package org.welyss.mysqlparser;

import org.welyss.mysqlparser.items.Token;

public abstract class MySQLThread {
	public Token yylval;
	public int foundSemicolon;
}
