package org.welyss.mysqlparser;

import java.io.IOException;

import org.welyss.mysqlparser.v56.MyLexer;
import org.welyss.mysqlparser.v56.MyParser;
import org.welyss.mysqlparser.v56.SQLThread;



public class MySQLParser {
	private MyParser myParser;

	public MySQLParser() throws IOException {
		this(50644);
	}

	public MySQLParser(long version) throws IOException {
		try {
			MyLexer lexer = new MyLexer();
			lexer.mysqlVersionId = version;
			myParser = new MyParser(lexer);
		} catch (IOException e) {
			throw new IOException("Action table file read faild.", e);
		}
	}

	/**
	 * parse sql
	 * @param sql
	 * @return Parsed Info
	 */
	public ParseResult parse(String sql) {
		MySQLThread sqlThread = new SQLThread(sql);
		ParseResult result = myParser.parse(sqlThread);
		return result;
	}

	/**
	 * set debug level.
	 * @param level
	 */
	public void setDebugLevel(int level) {
		myParser.setDebugLevel(level);
	}
}
