package org.welyss.mysqlparser.v84;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from class THD in sql_class.h
 */
public class SQLThread<T> {
	public Item<T> yylval;
	public Location yylloc;
	public ParserState mParserState;
	public SystemVariables variables;

	public SQLThread(String sql) {
		mParserState = new ParserState(sql, this);
		variables = new SystemVariables();
	}

}
