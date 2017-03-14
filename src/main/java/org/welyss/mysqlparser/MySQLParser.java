package org.welyss.mysqlparser;

import java.io.IOException;

public class MySQLParser {
	private MyParser myParser;

	public MySQLParser() throws IOException {
		try {
			this.myParser = new MyParser(new MyLexer());
		} catch (IOException e) {
			throw new IOException("action table initial faild.", e);
		}
	}

	public SQLResult parser(String sql) {
		SQLThread result = new SQLThread(sql);
		result.ok = myParser.parse(result);
		return result;
	}
}
