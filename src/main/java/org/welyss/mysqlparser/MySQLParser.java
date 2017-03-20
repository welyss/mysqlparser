package org.welyss.mysqlparser;

import java.io.IOException;

public class MySQLParser {
	private MyParser myParser;

	public MySQLParser() throws IOException {
		try {
			myParser = new MyParser(new MyLexer());
		} catch (IOException e) {
			throw new IOException("Action table file read faild.", e);
		}
	}

	/**
	 * parse sql
	 * @param sql
	 * @return Parsed Info
	 */
	public SQLResult parse(String sql) {
		SQLThread result = new SQLThread(sql);
		result.ok = myParser.parse(result);
		return result;
	}

	/**
	 * set stmtPrepareMode, default is true.
	 * @param value
	 */
	public void setStmtPrepareMode(boolean value) {
		((MyLexer)myParser.myLexer).lip.stmtPrepareMode = value;
	}

	/**
	 * whether the placeholder '?' can be accepted.
	 * @return
	 */
	public boolean isStmtPrepareMode() {
		return ((MyLexer)myParser.myLexer).lip.stmtPrepareMode;
	}
}
