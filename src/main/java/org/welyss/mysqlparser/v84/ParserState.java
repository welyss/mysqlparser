package org.welyss.mysqlparser.v84;

public class ParserState {
	public LexInputStream mLip;
	/**
	 * True if current query contains comments
	 */
	private boolean mComment;

	public ParserState(String sql, SQLThread thd) {
		mLip = new LexInputStream(sql, thd);
	}

	public void add_comment() {
		mComment = true;
	}

	public boolean has_comment() {
		return mComment;
	}
}
