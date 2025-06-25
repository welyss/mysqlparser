package org.welyss.mysqlparser;

public interface Parser {
	MySQLLexer lexer();
	int getDebugLevel();
	void setDebugLevel(int level);
}
