package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.TableIdent;

public class SQLThread {
	protected Boolean success;
	protected StringBuilder sql;
	protected List<SQLInfo> parsedSqls = new ArrayList<SQLInfo>();
	protected int foundSemicolon;
	protected boolean inWhere;
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

	protected ParseResult getSQLResultAndReset(int lastPos) {
		SQLInfo sqlInfo = parsedSqls.get(parsedSqls.size() - 1);
		String parsedSQL = success ? sqlInfo.sql : sql.substring(mPtr, sql.length());
		for(TableIdent ti : this.lex.tables) {
			if (ti.getDbStartPos() != null) ti.setDbStartPos(ti.getDbStartPos() - lastPos);
			if (ti.getTableStartPos() != null) ti.setTableStartPos(ti.getTableStartPos() - lastPos);
		}
		ParseResult result = new ParseResult(success, parsedSQL, this.lex.sqlCommand, new ArrayList<TableIdent>(this.lex.tables), this.msg, new TreeSet<AlterFlag>(lex.alterInfo.flags), this.inWhere, sqlInfo.alterCommand);
//		success = null;
		this.lex.sqlCommand = null;
		this.lex.tables.clear();
		this.msg = null;
		this.inWhere = false;
		lex.alterInfo.flags.clear();
		return result;
	}

	protected void addSQL(int eof) {
		String alterCmd = null;
		if (lex.alterPos != null && lex.alterPos < eof) {
			alterCmd = sql.substring(lex.alterPos, eof);
			lex.alterPos = null;
		}
		parsedSqls.add(new SQLInfo(sql.substring(foundSemicolon, eof), alterCmd));
	}
}
