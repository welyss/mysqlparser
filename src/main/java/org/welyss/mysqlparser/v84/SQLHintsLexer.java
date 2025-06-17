package org.welyss.mysqlparser.v84;

import java.io.IOException;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.Token;
import org.welyss.mysqlparser.v84.SQLHintsParser.Lexer;

public class SQLHintsLexer implements Lexer {
	public HintScanner scanner;
	public Item yylval;

	@Override
	public Object getLVal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void yyerror(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public int yylex() throws IOException {
		  yylval = new Token();
		  int ret = scanner.getNextToken();
		  yylval.hintString.str = scanner.yytext;
		  yylval.hintString.length = scanner.yyleng;
		  return ret;
	}
}
