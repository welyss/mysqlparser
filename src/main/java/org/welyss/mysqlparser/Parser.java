package org.welyss.mysqlparser;

public interface Parser {
	MySQLLexer lexer();
	ParseResult parse(String sql);
}
