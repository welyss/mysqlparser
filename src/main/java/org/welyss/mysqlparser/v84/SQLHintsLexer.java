package org.welyss.mysqlparser.v84;

import java.io.IOException;

import org.welyss.mysqlparser.items.LexerYystype;
import org.welyss.mysqlparser.v84.SQLHintsParser.Lexer;

public class SQLHintsLexer implements Lexer {
	public HintScanner scanner;
	public LexerYystype yylval;

	public SQLHintsLexer(HintScanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public Object getLVal() {
		return yylval;
	}

	@Override
	public void yyerror(String msg) {
//		SQLThread thd = (SQLThread)mThd;
//		LexInputStream lip = thd.mParserState.mLip;
//		thd.msg = String.format("You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '%s' at line %d",
//				lip.sqlBuf.substring(lip.mTokEnd, lip.mEndOfQuery), lip.yylineno);
//		LOGGER.error("{}, Location: {}, {}.", msg, loc.begin.offset, loc.end.offset);
	}

	@Override
	public int yylex() throws IOException {
		  yylval = new LexerYystype();
		  int ret = scanner.getNextToken();
		  yylval.hintString.str = scanner.yytext;
		  yylval.hintString.length = scanner.yyleng;
		  return ret;
	}
}
