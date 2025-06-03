package org.welyss.mysqlparser.v84;

public class ParserState {
	public LexInputStream lip;
	/**
	 * True if current query contains comments
	 */
	private boolean mComment;

	public ParserState(String sql) {
		lip = new LexInputStream(sql);
	}

	public void add_comment() {
		mComment = true;
	}

	public boolean has_comment() {
		return mComment;
	}
}
