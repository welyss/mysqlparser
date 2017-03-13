package org.welyss.mysqlparser;

import java.io.IOException;

public class SQLThread {
	public StringBuilder sql;
	public String msg;
	public Lex lex;
	public Item yylval;
	/** Current state of the lexical analyser. */
	public MyLexStates nextState = MyLexStates.MY_LEX_START;
	public int mTokStartPrev;
	/** Starting position of the last token parsed, in the raw buffer. */
	public int mTokStart;
	/** Ending position of the previous token parsed, in the raw buffer. */
	public int mTokEnd;
	/** Pointer to the current position in the raw input stream. */
	public int mPtr;
	/** Current line number. */
	public int lineno = 1;
	/**
	 * Starting position of the TEXT_STRING or IDENT in the pre-processed
	 * buffer.
	 * 
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
	public int mCppTextStart;
	/**
	 * Ending position of the TEXT_STRING or IDENT in the pre-processed buffer.
	 * 
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
	public int mCppTextEnd;

	/**
	 * Starting position of the last token parsed, in the pre-processed buffer.
	 */
	public int mCppTokStart;

	/** Pointer to the current position in the pre-processed input stream. */
	public int mCppPtr;
	public boolean textStringIs7bit;

	/** State of the lexical analyser for comments. */
	public EnumCommentState inComment;
	public EnumCommentState inCommentSaved;

	/**
	 * LALR(2) resolution, look ahead token. Value of the next token to return,
	 * if any, or -1, if no token was parsed in advance. Note: 0 is a legal
	 * token, and represents YYEOF.
	 */
	public int lookaheadToken = -1;

	/** LALR(2) resolution, value of the look ahead token. */
	public Item lookaheadYylval;

	/**
	 * Current statement digest instrumentation.
	 */
	public SQLDigestState mDigest;

	public SQLThread(String sql) {
		this.sql = new StringBuilder(sql);
		this.inComment = EnumCommentState.NO_COMMENT;
		mTokEnd = this.sql.length();
		lex = new Lex();
		mDigest = new SQLDigestState();
	}
}
