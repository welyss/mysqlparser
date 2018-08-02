package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.TableIdent;

public class SQLThread {
	protected Boolean success;
	protected StringBuilder sql;
	protected List<String> parsedSqls = new ArrayList<String>();
	protected int foundSemicolon;
	protected String msg;
	protected Lex lex;
	protected Item yylval;
	/** Current state of the lexical analyser. */
	protected MyLexStates nextState = MyLexStates.MY_LEX_START;
	protected int mTokStartPrev;
	/** Starting position of the last token parsed, in the raw buffer. */
	protected int mTokStart;
	/** Ending position of the previous token parsed, in the raw buffer. */
	protected int mTokEnd;
	/** Pointer to the current position in the raw input stream. */
	protected int mPtr;
	/** Current line number. */
	protected int lineno = 1;
	/**
	 * Starting position of the TEXT_STRING or IDENT in the pre-processed
	 * buffer.
	 * 
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
	protected int mCppTextStart;
	/**
	 * Ending position of the TEXT_STRING or IDENT in the pre-processed buffer.
	 * 
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
	protected int mCppTextEnd;

	/**
	 * Starting position of the last token parsed, in the pre-processed buffer.
	 */
	protected int mCppTokStart;

	/** Pointer to the current position in the pre-processed input stream. */
	protected int mCppPtr;
	protected boolean textStringIs7bit;

	/** State of the lexical analyser for comments. */
	protected EnumCommentState inComment;
	protected EnumCommentState inCommentSaved;

	/**
	 * LALR(2) resolution, look ahead token. Value of the next token to return,
	 * if any, or -1, if no token was parsed in advance. Note: 0 is a legal
	 * token, and represents YYEOF.
	 */
	protected int lookaheadToken = -1;

	/** LALR(2) resolution, value of the look ahead token. */
	protected Item lookaheadYylval;

	/**
	 * Current statement digest instrumentation.
	 */
	protected SQLDigestState mDigest;
	protected int yyerrstatus_ = 0;

	public SQLThread(String sql) {
		this.sql = new StringBuilder(sql);
		this.inComment = EnumCommentState.NO_COMMENT;
		mTokEnd = this.sql.length();
		lex = new Lex();
		mDigest = new SQLDigestState();
	}

	protected ParseResult getSQLResultAndReset() {
		String parsedSQL = parsedSqls.get(parsedSqls.size() - 1);
		ParseResult result = new ParseResult(success, parsedSQL, this.lex.sqlCommand, new ArrayList<TableIdent>(this.lex.tables), this.msg, new TreeSet<AlterFlag>(lex.alterInfo.flags));
//		success = null;
		this.lex.sqlCommand = null;
		this.lex.tables.clear();
		this.msg = null;
		lex.alterInfo.flags.clear();
		return result;
	}
}
