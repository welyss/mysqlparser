package org.welyss.mysqlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public List<SQLResult> parse(String sql) {
		List<SQLResult> result = new ArrayList<>();
		SQLThread sqlThread = new SQLThread(sql);
		sqlThread.success = myParser.parse(sqlThread);
		result.add(sqlThread.getSQLResultAndReset());
		while(sqlThread.success && sqlThread.foundSemicolon > 0 && !myParser.myLexer.lip.eof(sqlThread)) {
			sqlThread.nextState = MyLexStates.MY_LEX_START;
			sqlThread.success = myParser.parse(sqlThread);
			result.add(sqlThread.getSQLResultAndReset());
		}
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

	/**
	 * set debug level.
	 * @param level
	 */
	public void setDebugLevel(int level) {
		myParser.setDebugLevel(level);
	}
}
