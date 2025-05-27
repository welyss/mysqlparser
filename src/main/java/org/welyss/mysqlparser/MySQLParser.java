package org.welyss.mysqlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.v56.MyLexStates56;
import org.welyss.mysqlparser.v56.MyLexer56;
import org.welyss.mysqlparser.v56.MyParser56;
import org.welyss.mysqlparser.v56.SQLThread56;

public class MySQLParser {
	private MyParser56 myParser;

	public MySQLParser() throws IOException {
		this(50644);
	}

	public MySQLParser(long version) throws IOException {
		try {
			MyLexer56 lexer = new MyLexer56();
			lexer.mysqlVersionId = version;
			myParser = new MyParser56(lexer);
		} catch (IOException e) {
			throw new IOException("Action table file read faild.", e);
		}
	}

	/**
	 * parse sql
	 * @param sql
	 * @return Parsed Info
	 */
	public List<ParseResult> parse(String sql) {
		List<ParseResult> result = new ArrayList<>();
		SQLThread56 sqlThread = new SQLThread56(sql);
		sqlThread.success = myParser.parse(sqlThread);
		result.add(sqlThread.getSQLResultAndReset(0));
		while(sqlThread.success && sqlThread.foundSemicolon > 0 && !myParser.myLexer.lip.eof(sqlThread)) {
			int lastPos = sqlThread.mPtr;
			sqlThread.nextState = MyLexStates56.MY_LEX_START;
			sqlThread.success = myParser.parse(sqlThread);
			result.add(sqlThread.getSQLResultAndReset(lastPos));
		}
		return result;
	}

	/**
	 * set stmtPrepareMode, default is true.
	 * @param value
	 */
	public void setStmtPrepareMode(boolean value) {
		((MyLexer56)myParser.myLexer).lip.stmtPrepareMode = value;
	}

	/**
	 * whether the placeholder '?' can be accepted.
	 * @return
	 */
	public boolean isStmtPrepareMode() {
		return ((MyLexer56)myParser.myLexer).lip.stmtPrepareMode;
	}

	/**
	 * set debug level.
	 * @param level
	 */
	public void setDebugLevel(int level) {
		myParser.setDebugLevel(level);
	}
}
