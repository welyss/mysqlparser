package org.welyss.mysqlparser.v84;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from class THD in sql_class.h
 */
public class SQLThread {
	public LexInputStream lip;
	public Item yylval;
	public Location yylloc;
}
