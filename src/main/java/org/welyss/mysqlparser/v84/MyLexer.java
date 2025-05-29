package org.welyss.mysqlparser.v84;

import java.io.IOException;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.Position;
import org.welyss.mysqlparser.v84.MyParser.Lexer;
import org.welyss.mysqlparser.v84.MyParser.Location;

public class MyLexer implements Lexer {
	public MyLexer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Position getEndPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLVal() {
		// TODO Auto-generated method stub
		return null;
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
		LexInputStream lip = thd.lip;
		int token;

		  if (thd->is_error()) {
		    if (thd->get_parser_da()->has_sql_condition(ER_CAPACITY_EXCEEDED))
		      return ABORT_SYM;
		  }

		  if (lip->lookahead_token >= 0) {
		    /*
		      The next token was already parsed in advance,
		      return it.
		    */
		    token = lip->lookahead_token;
		    lip->lookahead_token = -1;
		    *yylval = *(lip->lookahead_yylval);
		    yylloc->cpp.start = lip->get_cpp_tok_start();
		    yylloc->cpp.end = lip->get_cpp_ptr();
		    yylloc->raw.start = lip->get_tok_start();
		    yylloc->raw.end = lip->get_ptr();
		    lip->lookahead_yylval = nullptr;
		    lip->add_digest_token(token, yylval);
		    return token;
		  }

		  token = lex_one_token(yylval, thd);
		  yylloc->cpp.start = lip->get_cpp_tok_start();
		  yylloc->raw.start = lip->get_tok_start();

		  switch (token) {
		    case WITH:
		      /*
		        Parsing 'WITH' 'ROLLUP' requires 2 look ups,
		        which makes the grammar LALR(2).
		        Replace by a single 'WITH_ROLLUP' token,
		        to transform the grammar into a LALR(1) grammar,
		        which sql_yacc.yy can process.
		      */
		      token = lex_one_token(yylval, thd);
		      switch (token) {
		        case ROLLUP_SYM:
		          yylloc->cpp.end = lip->get_cpp_ptr();
		          yylloc->raw.end = lip->get_ptr();
		          lip->add_digest_token(WITH_ROLLUP_SYM, yylval);
		          return WITH_ROLLUP_SYM;
		        default:
		          /*
		            Save the token following 'WITH'
		          */
		          lip->lookahead_yylval = lip->yylval;
		          lip->yylval = nullptr;
		          lip->lookahead_token = token;
		          yylloc->cpp.end = lip->get_cpp_ptr();
		          yylloc->raw.end = lip->get_ptr();
		          lip->add_digest_token(WITH, yylval);
		          return WITH;
		      }
		      break;
		  }

		  yylloc->cpp.end = lip->get_cpp_ptr();
		  yylloc->raw.end = lip->get_ptr();
		  if (!lip->skip_digest) lip->add_digest_token(token, yylval);
		  lip->skip_digest = false;
		  return token;
		}
	}
}
