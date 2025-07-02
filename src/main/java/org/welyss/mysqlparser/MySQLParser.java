package org.welyss.mysqlparser;

import java.io.IOException;

public class MySQLParser {
	private Parser myParser;
	private MySQLVersion version;

	public MySQLParser() throws IOException {
		this(MySQLVersion.v56);
	}

	public MySQLParser(MySQLVersion version) throws IOException {
		this.version = version;
		try {
			MySQLLexer lexer;
			switch (this.version) {
			case v84:
				lexer = new org.welyss.mysqlparser.v84.MyLexer();
				myParser = new org.welyss.mysqlparser.v84.MyParser(lexer);
				break;
			default:
				lexer = new org.welyss.mysqlparser.v56.MyLexer();
				myParser = new org.welyss.mysqlparser.v56.MyParser(lexer);
				break;
			}
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
		return myParser.parse(sql);
	}

	public MySQLVersion version() {
		return version;
	}
}
