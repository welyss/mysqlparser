package org.welyss.mysqlparser.v56;

import java.util.ArrayList;

import org.welyss.mysqlparser.AlterColumn;
import org.welyss.mysqlparser.MySQLThread;
import org.welyss.mysqlparser.SQLInfo;
import org.welyss.mysqlparser.items.TableIdent;
import org.welyss.mysqlparser.items.Token;

public class SQLThread extends MySQLThread {
	public Boolean success;
	public MyLexStates nextState = MyLexStates.MY_LEX_START;
	protected StringBuilder sql;
	public Token yylval;
	public int foundSemicolon;

	/** Current state of the lexical analyser. */
	protected int mTokStartPrev;
	/** Starting position of the last token parsed, in the raw buffer. */
	protected int mTokStart;
	/** Ending position of the previous token parsed, in the raw buffer. */
	protected int mTokEnd;
	/** Pointer to the current position in the raw input stream. */
	public int mPtr;
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
	protected Token lookaheadYylval;

	/**
	 * Current statement digest instrumentation.
	 */
	protected SQLDigestState mDigest;
	protected int yyerrstatus_ = 0;

	public SQLThread(String sql) {
		this.sql = new StringBuilder(sql);
		this.inComment = EnumCommentState.NO_COMMENT;
		mTokEnd = this.sql.length();
		mDigest = new SQLDigestState();
	}

	protected void addSQL(int eof) {
		String alterCmd = null;
		if (lex.alterPos > 0 && lex.alterPos < eof) {
			alterCmd = sql.substring(lex.alterPos, eof).trim();
			lex.alterPos = 0;
		}
		parsedSqls.add(new MySQLInfo(sql.substring(foundSemicolon, eof), lex.sqlCommand, lex.tables, pc.alterInfo.flags, alterCmd, lex.selectLex.whereOn, lex.alterInfo.columns));
		// Clear transient variables
		lex.tables = new ArrayList<TableIdent>();
		pc.alterInfo.flags = 0;
		lex.alterInfo.columns = new ArrayList<AlterColumn>();
	}

	public SQLInfo getSQLResultAndReset(int lastPos) {
		SQLInfo ret;
		if (success) {
			ret = parsedSqls.get(parsedSqls.size() - 1);
			for(TableIdent ti : this.lex.tables) {
				if (ti.getDbStartPos() != null) ti.setDbStartPos(ti.getDbStartPos() - lastPos);
				if (ti.getTableStartPos() != null) ti.setTableStartPos(ti.getTableStartPos() - lastPos);
			}
		} else {
			ret = new MySQLInfo(sql.toString(), this.lex.sqlCommand, this.lex.tables, pc.alterInfo.flags, null, lex.selectLex.whereOn, lex.alterInfo.columns);
			this.lex.tables = new ArrayList<TableIdent>();
		}
//		ParseItem result = new ParseItem(success, parsedSQL, this.lex.sqlCommand, new ArrayList<TableIdent>(this.lex.tables), this.msg, lex.alterInfo.flags, this.inWhere, alterCommand, lex.alterInfo.columns);
//		success = null;
		this.lex.sqlCommand = null;
		this.lex.tables.clear();
		this.msg = null;
//		lex.alterInfo.flags = new TreeSet<AlterFlag>();
		lex.alterInfo.columns = new ArrayList<AlterColumn>();
		return ret;
	}
}
