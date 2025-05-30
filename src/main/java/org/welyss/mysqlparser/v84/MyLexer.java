package org.welyss.mysqlparser.v84;

import java.io.IOException;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.Position;
import org.welyss.mysqlparser.v84.MyParser.Lexer;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from sql_lex.cc, include my_sql_parser_lex,lex_one_token... function.
 */
public class MyLexer implements Lexer {
	public MyLexer() {
	}

	@Override
	public Position getEndPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLVal(SQLThread thd) {
		return thd.yylval;
	}

	@Override
	public Position getStartPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void yyerror(Location loc, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public int yylex(SQLThread thd) throws IOException {
		  Item yylval = thd.yylval;
		  // POS in mysql-8.4.5/src/sql/parse_location.h
		  Location yylloc = thd.yylloc;
		  LexInputStream lip = thd.lip;
		  int token;

//		  if (thd.is_error()) {
//		    if (thd.get_parser_da().has_sql_condition(ER_CAPACITY_EXCEEDED))
//		      return ABORT_SYM;
//		  }

		  if (lip.lookaheadToken >= 0) {
		    /*
		      The next token was already parsed in advance,
		      return it.
		    */
		    token = lip.lookaheadToken;
		    lip.lookaheadToken = -1;
		    yylval = lip.lookaheadYylval;
//		    yylloc.cpp.start = lip.getCppTokStart();
//		    yylloc.cpp.end = lip.getCppPtr();
//		    yylloc.raw.start = lip.getTokStart();
//		    yylloc.raw.end = lip.getPtr();
		    lip.lookaheadYylval = null;
		    lip.addDigestToken(token, yylval);
		    return token;
		  }

		  token = lexOneToken(yylval, thd);
//		  yylloc.cpp.start = lip.getCppTokStart();
//		  yylloc.raw.start = lip.getTokStart();

		  switch (token) {
		    case WITH:
		      /*
		        Parsing 'WITH' 'ROLLUP' requires 2 look ups,
		        which makes the grammar LALR(2).
		        Replace by a single 'WithRollup' token,
		        to transform the grammar into a LALR(1) grammar,
		        which sqlYacc.yy can process.
		      */
		      token = lexOneToken(yylval, thd);
		      switch (token) {
		        case RollupSym:
//		          yylloc.cpp.end = lip.getCppPtr();
//		          yylloc.raw.end = lip.getPtr();
		          lip.addDigestToken(WithRollupSym, yylval);
		          return WithRollupSym;
		        default:
		          /*
		            Save the token following 'WITH'
		          */
		          lip.lookaheadYylval = lip.yylval;
		          lip.yylval = nullptr;
		          lip.lookaheadToken = token;
//		          yylloc.cpp.end = lip.getCppPtr();
//		          yylloc.raw.end = lip.getPtr();
		          lip.addDigestToken(With, yylval);
		          return WITH;
		      }
		      break;
		  }

//		  yylloc.cpp.end = lip.getCppPtr();
//		  yylloc.raw.end = lip.getPtr();
		  if (!lip.skipDigest) lip.addDigestToken(token, yylval);
		  lip.skipDigest = false;
		  return token;
	}
}
