package org.welyss.mysqlparser.v84;

import org.welyss.mysqlparser.MySQLThread;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from class THD in sql_class.h
 */
public class SQLThread extends MySQLThread {
	public Location yylloc;
	public ParserState mParserState;
//	public SystemVariables variables;
	public boolean charsetIsSystemCharset;

	public SQLThread(String sql) {
		mParserState = new ParserState(sql, this);
//		variables = new SystemVariables();
		charsetIsSystemCharset = true;
	}

}
