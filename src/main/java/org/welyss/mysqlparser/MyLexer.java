package org.welyss.mysqlparser;

import java.util.HashMap;
import java.util.Map;

import org.welyss.mysqlparser.MyParser.Lexer;
import org.welyss.mysqlparser.items.KeywordToken;
import org.welyss.mysqlparser.items.Token;

class MyLexer implements Lexer {
	public Variables variables = new Variables();
	public static final int LONG_LEN = 10;
	public static final char[] LONG_STR = new char[] { '2', '1', '4', '7', '4', '8', '3', '6', '4', '7' };
	public static final char[] SIGNED_LONG_STR = new char[] { '-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8' };
	public static final char[] LONGLONG_STR = new char[] { '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '7' };
	public static final int LONGLONG_LEN = 19;
	public static final char[] SIGNED_LONGLONG_STR = new char[] { '-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8' };
	public static final int SIGNED_LONGLONG_LEN = 19;
	public static final char[] UNSIGNED_LONGLONG_STR = new char[] { '1', '8', '4', '4', '6', '7', '4', '4', '0', '7', '3', '7', '0', '9', '5', '5', '1', '6', '1', '5' };
	public static final int UNSIGNED_LONGLONG_LEN = 20;
	/** Lex_input_stream **/
	public LexInputStreamProcessor lip;
	private Map<Character, MyLexStates> stateMap;
	private Map<Character, Boolean> identMap;
	private boolean ignoreSpace = (variables.sqlMode & Variables.MODE_IGNORE_SPACE) == Variables.MODE_IGNORE_SPACE;

	public MyLexer() {
		lip = new LexInputStreamProcessor();
		initStateMaps();
	}

	@Override
	public Object getLVal(SQLThread thd) {
		return thd.yylval;
	}

	@Override
	public void mysqlError(String s, SQLThread thd) {
		thd.msg = String.format(
				"You have an error in your SQL syntax; check the manual that corresponds to your MySQL server"
						+ " version for the right syntax to use near '%s' at line %d",
				thd.sql.substring(thd.mTokEnd, thd.sql.length()), thd.lineno);
	}

	/**
	 * MYSQLlex remember the following states from the following MYSQLlex()
	 * 
	 * @param yylval
	 *            [out] semantic value of the token being parsed (yylval)
	 * @param thd
	 *            THD
	 * 
	 *            - MY_LEX_EOQ Found end of query - MY_LEX_OPERATOR_OR_IDENT
	 *            Last state was an ident, text or number (which can't be
	 *            followed by a signed number)
	 */
	@Override
	public int mysqlLex(SQLThread thd) {
		// Lex_input_stream *lip= & thd->m_parser_state->m_lip;
		thd.yylval = new Token();
		int token;

		if (thd.lookaheadToken >= 0) {
			/*
			 * The next token was already parsed in advance, return it.
			 */
			token = thd.lookaheadToken;
			thd.lookaheadToken = -1;
			thd.yylval = thd.lookaheadYylval;
			thd.lookaheadYylval = null;
//			lip.addDigestToken(token, thd);
			return token;
		}

		token = lexOneToken(thd);
//		if (thd.yylval != null && thd.yylval.getClass().isInstance(Token.class)) {
//			((Token)thd.yylval).token = token;
//		}

		switch (token) {
		case MyParser.WITH:
			/*
			 * Parsing 'WITH' 'ROLLUP' or 'WITH' 'CUBE' requires 2 look ups,
			 * which makes the grammar LALR(2). Replace by a single
			 * 'WITH_ROLLUP' or 'WITH_CUBE' token, to transform the grammar into
			 * a LALR(1) grammar, which sql_yacc.yy can process.
			 */
			token = lexOneToken(thd);
			switch (token) {
			case MyParser.CUBE_SYM:
//				lip.addDigestToken(MyParser.WITH_CUBE_SYM, thd);
				return MyParser.WITH_CUBE_SYM;
			case MyParser.ROLLUP_SYM:
//				lip.addDigestToken(MyParser.WITH_ROLLUP_SYM, thd);
				return MyParser.WITH_ROLLUP_SYM;
			default:
				/*
				 * Save the token following 'WITH'
				 */
				thd.lookaheadYylval = thd.yylval;
				thd.yylval = null;
				thd.lookaheadToken = token;
//				lip.addDigestToken(MyParser.WITH, thd);
				return MyParser.WITH;
			}
			// break;
		default:
			break;
		}

//		lip.addDigestToken(token, thd);
		return token;
	}

	public int lexOneToken(SQLThread thd) {
		char c = 0;
		boolean comment_closed;
		int tokval, result_state;
		int length;
		// enum my_lex_states state;
		// LexInputStreamProcessor lip = thd.lis;
		// LEX *lex= thd->lex;
		// uchar *stateMap= cs->stateMap;
		// uchar *identMap= cs->identMap;

		// lip.yylval=yylval; // The global state
		Token token = (Token)thd.yylval;

		lip.startToken(thd);
		MyLexStates state = thd.nextState;
		thd.nextState = MyLexStates.MY_LEX_OPERATOR_OR_IDENT;
		for (;;) {
			switch (state) {
			case MY_LEX_OPERATOR_OR_IDENT: // Next is operator or keyword
			case MY_LEX_START: // Start of token
				// Skip starting whitespace
				while (state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_SKIP) {
					if (c == '\n')
						thd.lineno++;
					lip.yySkip(thd);
				}

				/* Start of real token */
				lip.restartToken(thd);
				c = lip.yyGet(thd);
				state = state(c);
				break;
			case MY_LEX_ESCAPE:
				if (lip.yyGet(thd) == 'N') { // Allow \N as shortcut for NULL
					token.lexStr = "\\N";
					return MyParser.NULL_SYM;
				}
			case MY_LEX_CHAR: // Unknown or single char token
			case MY_LEX_SKIP: // This should not happen
				if (c == '-' && lip.yyPeek(thd) == '-' && (Character.isWhitespace(lip.yyPeekn(thd, 1))
						|| LexInputStreamProcessor.myIsCntrl(lip.yyPeekn(thd, 1)))) {
					state = MyLexStates.MY_LEX_COMMENT;
					break;
				}

				if (c != ')')
					thd.nextState = MyLexStates.MY_LEX_START; // Allow signed
																// numbers

				if (c == ',') {
					/*
					 * Warning: This is a work around, to make the
					 * "remember_name" rule in sql/sql_yacc.yy work properly.
					 * The problem is that, when parsing "select expr1, expr2",
					 * the code generated by bison executes the *pre* action
					 * remember_name (see select_item) *before* actually parsing
					 * the first token of expr2.
					 */
					lip.restartToken(thd);
				} else {
					/*
					 * Check for a placeholder: it should not precede a possible
					 * identifier because of binlogging: when a placeholder is
					 * replaced with its value in a query for the binlog, the
					 * query must stay grammatically correct.
					 */
					if (c == '?' && lip.stmtPrepareMode && !ident(lip.yyPeek(thd)))
						return (MyParser.PARAM_MARKER);
				}

				return ((int) c);

			case MY_LEX_IDENT_OR_NCHAR:
				if (lip.yyPeek(thd) != '\'') {
					state = MyLexStates.MY_LEX_IDENT;
					break;
				}
				/* Found N'string' */
				lip.yySkip(thd); // Skip '
				if (!"".equals((token.lexStr = getText(thd, 2, 1)))) {
					state = MyLexStates.MY_LEX_CHAR; // Read char by char
					break;
				}
				thd.textStringIs7bit = (lip.tokBitmap & 0x80) == 0x80 ? false : true;
				return (MyParser.NCHAR_STRING);

			case MY_LEX_IDENT_OR_HEX:
				if (lip.yyPeek(thd) == '\'') { // Found x'hex-number'
					state = MyLexStates.MY_LEX_HEX_NUMBER;
					break;
				}
			case MY_LEX_IDENT_OR_BIN:
				if (lip.yyPeek(thd) == '\'') { // Found b'bin-number'
					state = MyLexStates.MY_LEX_BIN_NUMBER;
					break;
				}
			case MY_LEX_IDENT:
				token.pos = thd.mTokStart;
				int start; {
					for (result_state = c; ident(c = lip.yyGet(thd)); result_state |= c)
						;
					/*
					 * If there were non-ASCII characters, mark that we must convert
					 */
					result_state = (result_state & 0x80) == 0x80 ? MyParser.IDENT_QUOTED : MyParser.IDENT;
				}
				length = lip.yyLength(thd);
				start = lip.getPtr(thd);
				if (ignoreSpace) {
					/*
					 * If we find a space then this can't be an identifier. We
					 * notice this below by checking start != lex->ptr.
					 */
					for (; state(c) == MyLexStates.MY_LEX_SKIP; c = lip.yyGet(thd))
						;
				}
				if (start == lip.getPtr(thd) && c == '.' && ident(lip.yyPeek(thd)))
					thd.nextState = MyLexStates.MY_LEX_IDENT_SEP;
				else { // '(' must follow directly if function
					lip.yyUnget(thd);
					if ((tokval = findKeyword(thd, length, c == '(')) > 0) {
						thd.nextState = MyLexStates.MY_LEX_START; // Allow
																	// signed
																	// numbers
						return (tokval); // Was keyword
					} else {
						((Token)thd.yylval).lexStr = thd.sql.substring(thd.mTokStart, thd.mTokStart + length);
					}
					lip.yySkip(thd); // next state does a unget
				}
				token.lexStr = getToken(thd, 0, length);

				/*
				 * Note: "SELECT _bla AS 'alias'" _bla should be considered as a
				 * IDENT if charset haven't been found. So we don't use
				 * MYF(MY_WME) with get_charset_by_csname to avoid producing an
				 * error.
				 */

				// if (token.lexStr.str.charAt(0) == '_')
				// {
				// CHARSET_INFO *cs= get_charset_by_csname(yylval->lex_str.str +
				// 1,
				// MY_CS_PRIMARY, MYF(0));
				// if (cs)
				// {
				// yylval->charset= cs;
				// lip.m_underscore_cs= cs;
				//
				// lip.body_utf8_append(lip.m_cpp_text_start,
				// lip.get_cpp_tok_start(thd) + length);
				// return(UNDERSCORE_CHARSET);
				// }
				// }

				// lip.body_utf8_append(lip.m_cpp_text_start);
				//
				// lip.body_utf8_append_literal(thd, &yylval->lex_str, cs,
				// lip.m_cpp_text_end);

				return (result_state); // IDENT or IDENT_QUOTED

			case MY_LEX_IDENT_SEP: // Found ident and now '.'
				token.lexStr = String.valueOf((char) lip.getPtr(thd));
				c = lip.yyGet(thd); // should be '.'
				thd.nextState = MyLexStates.MY_LEX_IDENT_START;// Next is an
																// ident (not a
																// keyword)
				if (!ident(lip.yyPeek(thd))) // Probably ` or "
					thd.nextState = MyLexStates.MY_LEX_START;
				return ((int) c);

			case MY_LEX_NUMBER_IDENT: // number or ident which num-start
				if (lip.yyGetLast(thd) == '0') {
					c = lip.yyGet(thd);
					if (c == 'x') {
						while (Character.isDigit(c = lip.yyGet(thd)))
							;
						if ((lip.yyLength(thd) >= 3) && !ident(c)) {
							/* skip '0x' */
							token.lexStr = getToken(thd, 2, lip.yyLength(thd) - 2);
							return (MyParser.HEX_NUM);
						}
						lip.yyUnget(thd);
						state = MyLexStates.MY_LEX_IDENT_START;
						break;
					} else if (c == 'b') {
						while ((c = lip.yyGet(thd)) == '0' || c == '1')
							;
						if ((lip.yyLength(thd) >= 3) && !ident(c)) {
							/* Skip '0b' */
							token.lexStr = getToken(thd, 2, lip.yyLength(thd) - 2);
							return (MyParser.BIN_NUM);
						}
						lip.yyUnget(thd);
						state = MyLexStates.MY_LEX_IDENT_START;
						break;
					}
					lip.yyUnget(thd);
				}

				while (Character.isDigit(c = lip.yyGet(thd)))
					;
				if (!ident(c)) { // Can't be identifier
					state = MyLexStates.MY_LEX_INT_OR_REAL;
					break;
				}
				if (c == 'e' || c == 'E') {
					// The following test is written this way to allow numbers
					// of type 1e1
					if (Character.isDigit(lip.yyPeek(thd)) || (c = (lip.yyGet(thd))) == '+' || c == '-') { // Allow
																											// 1E+10
						if (Character.isDigit(lip.yyPeek(thd))) // Number must
																// have digit
																// after sign
						{
							lip.yySkip(thd);
							while (Character.isDigit(lip.yyGet(thd)))
								;
							token.lexStr = getToken(thd, 0, lip.yyLength(thd));
							return (MyParser.FLOAT_NUM);
						}
					}
					lip.yyUnget(thd);
				}
				// fall through
			case MY_LEX_IDENT_START: // We come here after '.'
				result_state = MyParser.IDENT; {
					for (result_state = 0; ident(c = lip.yyGet(thd)); result_state |= c)
						;
					/*
					 * If there were non-ASCII characters, mark that we must convert
					 */
					result_state = (result_state & 0x80) == 0x80 ? MyParser.IDENT_QUOTED : MyParser.IDENT;
				}
				if (c == '.' && ident(lip.yyPeek(thd)))
					thd.nextState = MyLexStates.MY_LEX_IDENT_SEP;// Next is '.'

				token.lexStr = getToken(thd, 0, lip.yyLength(thd));
				token.pos = thd.mTokStart;

				// lip.body_utf8_append(lip.m_cpp_text_start);

				// lip.body_utf8_append_literal(thd, &yylval->lex_str, cs,
				// lip.m_cpp_text_end);

				return (result_state);

			case MY_LEX_USER_VARIABLE_DELIMITER: // Found quote char
			{
				int double_quotes = 0;
				char quote_char = c; // Used char
				for (;;) {
					c = lip.yyGet(thd);
					if (c == 0) {
						lip.yyUnget(thd);
						return MyParser.ABORT_SYM; // Unmatched quotes
					}

					// int var_length;
					if ((LexInputStreamProcessor.myMbcharlen(c)) == 1) {
						if (c == quote_char) {
							if (lip.yyPeek(thd) != quote_char)
								break;
							c = lip.yyGet(thd);
							double_quotes++;
							continue;
						}
					}
				}
				if (double_quotes > 0)
					token.lexStr = getQuotedToken(thd, 1, lip.yyLength(thd) - double_quotes - 1, quote_char);
				else
					token.lexStr = getToken(thd, 1, lip.yyLength(thd) - 1);
				if (c == quote_char)
					lip.yySkip(thd); // Skip end `
				token.pos = thd.mCppTextStart;
				thd.nextState = MyLexStates.MY_LEX_START;

				// lip.body_utf8_append(lip.m_cpp_text_start);
				//
				// lip.body_utf8_append_literal(thd, &yylval->lex_str, cs,
				// lip.m_cpp_text_end);

				return (MyParser.IDENT_QUOTED);
			}
			case MY_LEX_INT_OR_REAL: // Complete int or incomplete real
				if (c != '.') { // Found complete integer number.
					token.lexStr = getToken(thd, 0, lip.yyLength(thd));
					return intToken(token.lexStr, token.lexStr.length());
				}
				// fall through
			case MY_LEX_REAL: // Incomplete real number
				while (Character.isDigit(c = lip.yyGet(thd)))
					;

				if (c == 'e' || c == 'E') {
					c = lip.yyGet(thd);
					if (c == '-' || c == '+')
						c = lip.yyGet(thd); // Skip sign
					if (!Character.isDigit(c)) { // No digit after sign
						state = MyLexStates.MY_LEX_CHAR;
						break;
					}
					while (Character.isDigit(lip.yyGet(thd)))
						;
					token.lexStr = getToken(thd, 0, lip.yyLength(thd));
					return (MyParser.FLOAT_NUM);
				}
				token.lexStr = getToken(thd, 0, lip.yyLength(thd));
				return (MyParser.DECIMAL_NUM);

			case MY_LEX_HEX_NUMBER: // Found x'hexstring'
				lip.yySkip(thd); // Accept opening '
				while (Character.isDigit(c = lip.yyGet(thd)))
					;
				if (c != '\'')
					return (MyParser.ABORT_SYM); // Illegal hex constant
				lip.yySkip(thd); // Accept closing '
				length = lip.yyLength(thd); // Length of hexnum+3
				if ((length % 2) == 0)
					return (MyParser.ABORT_SYM); // odd number of hex digits
				token.lexStr = getToken(thd, 2, // skip x'
						length - 3); // don't count x' and last '
				return (MyParser.HEX_NUM);

			case MY_LEX_BIN_NUMBER: // Found b'bin-string'
				lip.yySkip(thd); // Accept opening '
				while ((c = lip.yyGet(thd)) == '0' || c == '1')
					;
				if (c != '\'')
					return (MyParser.ABORT_SYM); // Illegal hex constant
				lip.yySkip(thd); // Accept closing '
				length = lip.yyLength(thd); // Length of bin-num + 3
				token.lexStr = getToken(thd, 2, // skip b'
						length - 3); // don't count b' and last '
				return (MyParser.BIN_NUM);

			case MY_LEX_CMP_OP: // Incomplete comparison operator
				if (state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_CMP_OP
						|| state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_LONG_CMP_OP)
					lip.yySkip(thd);
				if ((tokval = findKeyword(thd, lip.yyLength(thd) + 1, false)) > 0) {
					thd.nextState = MyLexStates.MY_LEX_START; // Allow signed
																// numbers
					return (tokval);
				}
				state = MyLexStates.MY_LEX_CHAR; // Something fishy found
				break;

			case MY_LEX_LONG_CMP_OP: // Incomplete comparison operator
				if (state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_CMP_OP
						|| state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_LONG_CMP_OP) {
					lip.yySkip(thd);
					if (state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_CMP_OP)
						lip.yySkip(thd);
				}
				if ((tokval = findKeyword(thd, lip.yyLength(thd) + 1, false)) > 0) {
					thd.nextState = MyLexStates.MY_LEX_START; // Found long op
					return (tokval);
				}
				state = MyLexStates.MY_LEX_CHAR; // Something fishy found
				break;

			case MY_LEX_BOOL:
				if (c != lip.yyPeek(thd)) {
					state = MyLexStates.MY_LEX_CHAR;
					break;
				}
				lip.yySkip(thd);
				tokval = findKeyword(thd, 2, false); // Is a bool operator
				thd.nextState = MyLexStates.MY_LEX_START; // Allow signed
															// numbers
				return (tokval);

			case MY_LEX_STRING_OR_DELIMITER:
				if ((variables.sqlMode & Variables.MODE_ANSI_QUOTES) == Variables.MODE_ANSI_QUOTES) {
					state = MyLexStates.MY_LEX_USER_VARIABLE_DELIMITER;
					break;
				}
				/* " used for strings */
			case MY_LEX_STRING: // Incomplete text string
				if ((token.lexStr = getText(thd, 1, 1)) == null) {
					state = MyLexStates.MY_LEX_CHAR; // Read char by char
					break;
				}

				// lip.body_utf8_append(lip.m_cpp_text_start);
				// lip.body_utf8_append_literal(thd, &yylval->lex_str,
				// lip.m_underscore_cs ? lip.m_underscore_cs : cs,
				// lip.m_cpp_text_end);

				// lip.m_underscore_cs= NULL;

				thd.textStringIs7bit = (lip.tokBitmap & 0x80) == 0x80 ? false : true;
				return (MyParser.TEXT_STRING);

			case MY_LEX_COMMENT: // Comment
				thd.lex.selectLex.options |= SQLPrivConstants.OPTION_FOUND_COMMENT;
				while ((c = lip.yyGet(thd)) != '\n' && c > 0)
					;
				lip.yyUnget(thd); // Safety against eof
				state = MyLexStates.MY_LEX_START; // Try again
				break;
			case MY_LEX_LONG_COMMENT: /* Long C comment? */
				if (lip.yyPeek(thd) != '*') {
					state = MyLexStates.MY_LEX_CHAR; // Probable division
					break;
				}
				thd.lex.selectLex.options |= SQLPrivConstants.OPTION_FOUND_COMMENT;
				/* Reject '/' '*', since we might need to turn off the echo */
				lip.yyUnget(thd);

				lip.saveInCommentState(thd);

				if (lip.yyPeekn(thd, 2) == '!') {
					thd.inComment = EnumCommentState.DISCARD_COMMENT;
					/* Accept '/' '*' '!', but do not keep this marker. */
					// lip.set_echo(FALSE);
					lip.yySkip(thd);
					lip.yySkip(thd);
					lip.yySkip(thd);

					/*
					 * The special comment format is very strict: '/' '*' '!',
					 * followed by exactly 1 digit (major), 2 digits (minor),
					 * then 2 digits (dot). 32302 -> 3.23.02 50032 -> 5.0.32
					 * 50114 -> 5.1.14
					 */
					char version_str[] = new char[6];
					version_str[0] = lip.yyPeekn(thd, 0);
					version_str[1] = lip.yyPeekn(thd, 1);
					version_str[2] = lip.yyPeekn(thd, 2);
					version_str[3] = lip.yyPeekn(thd, 3);
					version_str[4] = lip.yyPeekn(thd, 4);
					version_str[5] = 0;
					if (Character.isDigit(version_str[0]) && Character.isDigit(version_str[1])
							&& Character.isDigit(version_str[2]) && Character.isDigit(version_str[3])
							&& Character.isDigit(version_str[4])) {
						// long version;
						// version=strtol(version_str, NULL, 10);

						// if (version <= MYSQL_VERSION_ID)
						// {
						// /* Accept 'M' 'm' 'm' 'd' 'd' */
						// lip.yySkipn(5);
						// /* Expand the content of the special comment as real
						// code */
						// lip.set_echo(TRUE);
						// state=MY_LEX_START;
						// break; /* Do not treat contents as a comment. */
						// }
						// else
						// {
						/*
						 * Patch and skip the conditional comment to avoid it
						 * being propagated infinitely (eg. to a slave).
						 */
						lip.yyUnput(thd, ' ');
						comment_closed = !consumeComment(thd, 1);
						if (!comment_closed) {
							thd.sql.setCharAt(lip.yyGet(thd), '!');
						}
						/*
						 * version allowed to have one level of comment inside.
						 */
						// }
					} else {
						/* Not a version comment. */
						state = MyLexStates.MY_LEX_START;
						// lip.set_echo(TRUE);
						break;
					}
				} else {
					thd.inComment = EnumCommentState.PRESERVE_COMMENT;
					lip.yySkip(thd); // Accept /
					lip.yySkip(thd); // Accept *
					comment_closed = !consumeComment(thd, 0);
					/* regular comments can have zero comments inside. */
				}
				/*
				 * Discard: - regular '/' '*' comments, - special comments '/'
				 * '*' '!' for a future version, by scanning until we find a
				 * closing '*' '/' marker.
				 * 
				 * Nesting regular comments isn't allowed. The first '*' '/'
				 * returns the parser to the previous state.
				 * 
				 * /#!VERSI oned containing /# regular #/ is allowed #/
				 * 
				 * Inside one versioned comment, another versioned comment is
				 * treated as a regular discardable comment. It gets no special
				 * parsing.
				 */

				/*
				 * Unbalanced comments with a missing '*' '/' are a syntax error
				 */
				if (!comment_closed)
					return (MyParser.ABORT_SYM);
				state = MyLexStates.MY_LEX_START; // Try again
				lip.restoreInCommentState(thd);
				break;
			case MY_LEX_END_LONG_COMMENT:
				if ((thd.inComment != EnumCommentState.NO_COMMENT) && lip.yyPeek(thd) == '/') {
					/* Reject '*' '/' */
					lip.yyUnget(thd);
					/* Accept '*' '/', with the proper echo */
					// lip.set_echo(lip.in_comment == PRESERVE_COMMENT);
					lip.yySkipn(thd, 2);
					/* And start recording the tokens again */
					// lip.set_echo(TRUE);

					/*
					 * C-style comments are replaced with a single space (as it
					 * is in C and C++). If there is already a whitespace
					 * character at this point in the stream, the space is not
					 * inserted.
					 * 
					 * See also ISO/IEC 9899:1999 §5.1.1.2
					 * ("Programming languages — C")
					 */
					if (!Character.isWhitespace(lip.yyPeek(thd)) &&
					// lip.getCppPtr(thd) != lip.getCppBuf(thd) &&
							!Character.isWhitespace(lip.yyPeekn(thd, -1)))
						// lip.cpp_inject(' ');

						thd.inComment = EnumCommentState.NO_COMMENT;
					state = MyLexStates.MY_LEX_START;
				} else
					state = MyLexStates.MY_LEX_CHAR; // Return '*'
				break;
			case MY_LEX_SET_VAR: // Check if ':='
				if (lip.yyPeek(thd) != '=') {
					state = MyLexStates.MY_LEX_CHAR; // Return ':'
					break;
				}
				lip.yySkip(thd);
				return (MyParser.SET_VAR);
			case MY_LEX_SEMICOLON: // optional line terminator
				state = MyLexStates.MY_LEX_CHAR; // Return ';'
				break;
			case MY_LEX_EOL:
				if (lip.eof(thd)) {
					lip.yyUnget(thd); // Reject the last '\0'
					// lip.set_echo(FALSE);
					lip.yySkip(thd);
					// lip.set_echo(TRUE);
					/*
					 * Unbalanced comments with a missing '*' '/' are a syntax
					 * error
					 */
					if (thd.inComment != EnumCommentState.NO_COMMENT)
						return (MyParser.ABORT_SYM);
					thd.nextState = MyLexStates.MY_LEX_END; // Mark for next
															// loop
					return (MyParser.END_OF_INPUT);
				}
				state = MyLexStates.MY_LEX_CHAR;
				break;
			case MY_LEX_END:
				thd.nextState = MyLexStates.MY_LEX_END;
				return (0); // We found end of input last time

			/* Actually real shouldn't start with . but allow them anyhow */
			case MY_LEX_REAL_OR_POINT:
				if (Character.isDigit(lip.yyPeek(thd)))
					state = MyLexStates.MY_LEX_REAL; // Real
				else {
					state = MyLexStates.MY_LEX_IDENT_SEP; // return '.'
					lip.yyUnget(thd); // Put back '.'
				}
				break;
			case MY_LEX_USER_END: // end '@' of user@hostname
				switch (state(lip.yyPeek(thd))) {
				case MY_LEX_STRING:
				case MY_LEX_USER_VARIABLE_DELIMITER:
				case MY_LEX_STRING_OR_DELIMITER:
					break;
				case MY_LEX_USER_END:
					thd.nextState = MyLexStates.MY_LEX_SYSTEM_VAR;
					break;
				default:
					thd.nextState = MyLexStates.MY_LEX_HOSTNAME;
					break;
				}
				token.lexStr = String.valueOf(lip.yyPeekn(thd, -1));
				return ((int) '@');
			case MY_LEX_HOSTNAME: // end '@' of user@hostname
				for (c = lip.yyGet(thd); LexInputStreamProcessor.myIsalnum(c) || c == '.' || c == '_'
						|| c == '$'; c = lip.yyGet(thd))
					;
				token.lexStr = getToken(thd, 0, lip.yyLength(thd));
				return (MyParser.LEX_HOSTNAME);
			case MY_LEX_SYSTEM_VAR:
				token.lexStr = String.valueOf(lip.yyGet(thd));
				lip.yySkip(thd); // Skip '@'
				thd.nextState = (state(lip.yyPeek(thd)) == MyLexStates.MY_LEX_USER_VARIABLE_DELIMITER
						? MyLexStates.MY_LEX_OPERATOR_OR_IDENT : MyLexStates.MY_LEX_IDENT_OR_KEYWORD);
				return ((int) '@');
			case MY_LEX_IDENT_OR_KEYWORD:
				/*
				 * We come here when we have found two '@' in a row. We should
				 * now be able to handle: [(global | local | session)
				 * .]variable_name
				 */
				for (result_state = 0; ident(c = lip.yyGet(thd)); result_state |= c)
					;
				/*
				 * If there were non-ASCII characters, mark that we must convert
				 */
				result_state = (result_state & 0x80) == 0x80 ? MyParser.IDENT_QUOTED : MyParser.IDENT;

				if (c == '.')
					thd.nextState = MyLexStates.MY_LEX_IDENT_SEP;
				length = lip.yyLength(thd);
				if (length == 0)
					return (MyParser.ABORT_SYM); // Names must be nonempty.
				if ((tokval = findKeyword(thd, length, false)) > 0) {
					lip.yyUnget(thd); // Put back 'c'
					return (tokval); // Was keyword
				}
				token.lexStr = getToken(thd, 0, length);

				// lip.body_utf8_append(lip.m_cpp_text_start);

				// lip.body_utf8_append_literal(thd, &yylval->lex_str, cs,
				// lip.m_cpp_text_end);

				return (result_state);
			}
		}
	}

	private String getText(SQLThread thd, int preSkip, int postSkip) {
		char c, sep;
		boolean foundEscape = false;
		// const CHARSET_INFO *cs= lip->m_thd->charset();

		lip.tokBitmap = 0;
		sep = lip.yyGetLast(thd); // String should end with this
		while (!lip.eof(thd)) {
			c = lip.yyGet(thd);
			lip.tokBitmap |= c;
			if (c == '\\'
					&& !((variables.sqlMode & Variables.MODE_NO_BACKSLASH_ESCAPES) == Variables.MODE_NO_BACKSLASH_ESCAPES)) { // Escaped
																																// character
				foundEscape = true;
				if (lip.eof(thd))
					return null;
				lip.yySkip(thd);
			} else if (c == sep) {
				if (c == lip.yyGet(thd)) // Check if two separators in a row
				{
					foundEscape = true; // duplicate. Remember for delete
					continue;
				} else
					lip.yyUnget(thd);

				/* Found end. Unescape and return string */
				int str, end;
				String start;

				str = lip.getTokStart(thd);
				end = lip.getPtr(thd);
				/* Extract the text from the token */
				str += preSkip;
				end -= postSkip;

				// if (!(start= (char*) lip->m_thd->alloc((uint) (end-str)+1)))
				// return (char*) ""; // Sql_alloc has set error flag

				thd.mCppTextStart = lip.getCppTokStart(thd) + preSkip;
				thd.mCppTextEnd = lip.getCppPtr(thd) - postSkip;

				if (!foundEscape) {
					start = thd.sql.substring(str, end);
				} else {
					char[] to;
					int i = 0;
					for (to = new char[end - str]; str != end; str++) {
						if (!((variables.sqlMode & Variables.MODE_NO_BACKSLASH_ESCAPES) == Variables.MODE_NO_BACKSLASH_ESCAPES)
								&& thd.sql.charAt(str) == '\\' && str + 1 != end) {
							switch (thd.sql.charAt(++str)) {
							case 'n':
								to[i++] = '\n';
								break;
							case 't':
								to[i++] = '\t';
								break;
							case 'r':
								to[i++] = '\r';
								break;
							case 'b':
								to[i++] = '\b';
								break;
							case '0':
								to[i++] = 0; // Ascii null
								break;
							case 'Z': // ^Z must be escaped on Win32
								to[i++] = '\032';
								break;
							case '_':
							case '%':
								to[i++] = '\\'; // remember prefix for wildcard
								/* Fall through */
							default:
								to[i++] = thd.sql.charAt(str);
								break;
							}
						} else if (thd.sql.charAt(str) == sep)
							to[i++] = thd.sql.charAt(str++); // Two ' or "
						else
							to[i++] = thd.sql.charAt(str);
					}
					to[i] = 0;
					start = to.toString();
				}
				return start;
			}
		}
		return null; // unexpected end of query
	}

	/**
	 * Given a stream that is advanced to the first contained character in an
	 * open comment, consume the comment. Optionally, if we are allowed, recurse
	 * so that we understand comments within this current comment.
	 * 
	 * At this level, we do not support version-condition comments. We might
	 * have been called with having just passed one in the stream, though. In
	 * that case, we probably want to tolerate mundane comments inside. Thus,
	 * the case for recursion.
	 * 
	 * @retval Whether EOF reached before comment is closed.
	 */
	public boolean consumeComment(SQLThread thd, int remaining_recursions_permitted) {
		char c;
		while (!lip.eof(thd)) {
			c = lip.yyGet(thd);

			if (remaining_recursions_permitted > 0) {
				if ((c == '/') && (lip.yyPeek(thd) == '*')) {
					lip.yySkip(thd); /* Eat asterisk */
					consumeComment(thd, remaining_recursions_permitted - 1);
					continue;
				}
			}

			if (c == '*') {
				if (lip.yyPeek(thd) == '/') {
					lip.yySkip(thd); /* Eat slash */
					return false;
				}
			}

			if (c == '\n')
				thd.lineno++;
		}

		return true;
	}

	public int intToken(String str, int length) {
		if (length < LONG_LEN) // quick normal case
			return MyParser.NUM;
		boolean neg = false;

		int index = 0;
		if (str.charAt(index) == '+') // Remove sign and pre-zeros
		{
			index++;
			length--;
		} else if (str.charAt(index) == '-') {
			index++;
			length--;
			neg = true;
		}
		while (str.charAt(index) == '0' && length > 0) {
			index++;
			length--;
		}
		if (length < LONG_LEN)
			return MyParser.NUM;

		int smaller, bigger;
		char[] cmp;
		if (neg) {
			if (length == LONG_LEN) {
				System.arraycopy(SIGNED_LONG_STR, 1, cmp = new char[SIGNED_LONG_STR.length - 1], 0, SIGNED_LONG_STR.length - 1);
				smaller = MyParser.NUM; // If <= signed_long_str
				bigger = MyParser.LONG_NUM; // If >= signed_long_str
			} else if (length < SIGNED_LONGLONG_LEN)
				return MyParser.LONG_NUM;
			else if (length > SIGNED_LONGLONG_LEN)
				return MyParser.DECIMAL_NUM;
			else {
				System.arraycopy(SIGNED_LONGLONG_STR, 1, cmp = new char[SIGNED_LONGLONG_STR.length - 1], 0,
						SIGNED_LONGLONG_STR.length - 1);
				smaller = MyParser.LONG_NUM; // If <= signed_longlong_str
				bigger = MyParser.DECIMAL_NUM;
			}
		} else {
			if (length == LONG_LEN) {
				cmp = LONG_STR;
				smaller = MyParser.NUM;
				bigger = MyParser.LONG_NUM;
			} else if (length < LONGLONG_LEN)
				return MyParser.LONG_NUM;
			else if (length > LONGLONG_LEN) {
				if (length > UNSIGNED_LONGLONG_LEN)
					return MyParser.DECIMAL_NUM;
				cmp = UNSIGNED_LONGLONG_STR;
				smaller = MyParser.ULONGLONG_NUM;
				bigger = MyParser.DECIMAL_NUM;
			} else {
				cmp = LONGLONG_STR;
				smaller = MyParser.LONG_NUM;
				bigger = MyParser.ULONGLONG_NUM;
			}
		}
		int cmpIndex = 0;
		while (cmpIndex < cmp.length && index < length && cmp[cmpIndex++] == str.charAt(index++))
			;
		return str.charAt(index) <= cmp[cmpIndex] ? smaller : bigger;
	}

	private int findKeyword(SQLThread thd, int len, boolean function) {
		KeywordToken keywordToken = getHashSymbol(thd, len, function);
		if (keywordToken != null) {
			thd.yylval = keywordToken;
			if ((keywordToken.token == MyParser.NOT_SYM)
					&& (variables.sqlMode & Variables.MODE_HIGH_NOT_PRECEDENCE) == Variables.MODE_HIGH_NOT_PRECEDENCE)
				return MyParser.NOT2_SYM;
			if ((keywordToken.token == MyParser.OR_OR_SYM)
					&& !((variables.sqlMode & Variables.MODE_PIPES_AS_CONCAT) == Variables.MODE_PIPES_AS_CONCAT))
				return MyParser.OR2_SYM;

			return ((Token)thd.yylval).token;
		}
		return 0;
	}

	private KeywordToken getHashSymbol(SQLThread thd, int len, boolean function) {
		KeywordToken keywordToken = null;
		if (len > 0) {
			String tokstring = thd.sql.substring(thd.mTokStart, thd.mTokStart + len);
			String tokstringUpp = tokstring.toUpperCase();
			Integer token = null;
			if (function) {
				token = LexConstants.sqlFunctions.get(tokstringUpp);
			}
			if (token == null) {
				token = LexConstants.symbols.get(tokstringUpp);
			}
			if (token != null) {
				keywordToken = new KeywordToken(token, tokstring, tokstringUpp);
				keywordToken.pos = thd.mTokStart;
			}
//			else {
//				if (function) {
//					token = LexConstants.symbols.get(tokstringUpp);
//				} else {
//					token = LexConstants.sqlFunctions.get(tokstringUpp);
//				}
//				if (token != null) {
//					keywordToken = new KeywordToken(token, tokstring, tokstringUpp);
//				}
//			}
		}
		return keywordToken;
	}

	/**
	 * todo: There are no dangerous charsets in mysql for function
	 * get_quoted_token yet. But it should be fixed in the future to operate
	 * multichar strings (like ucs2)
	 */
	public String getQuotedToken(SQLThread thd, int skip, int length, char quote) {
		int from;
		StringBuilder to = new StringBuilder();
		lip.yyUnget(thd); // ptr points now after last token char
		// tmp.str=(char*) lip->m_thd->alloc(tmp.length+1);
		from = lip.getTokStart(thd) + skip;

		thd.mCppTextStart = lip.getCppTokStart(thd) + skip;
		thd.mCppTextEnd = thd.mCppTextStart + length;

		for (int i = 0; i < length; i++) {
			char c = thd.sql.charAt(from + i);
			if (c == quote) {
				// Skip double quotes
				thd.mCppTextStart++;
			} else {
				to.append(c);
			}
		}
		return to.toString();
	}

	/** make a copy of token before ptr and set yytoklen */
	public String getToken(SQLThread thd, int skip, int length) {
		lip.yyUnget(thd); // ptr points now after last token char
		String tmp = thd.sql.substring(lip.getTokStart(thd) + skip, lip.getTokStart(thd) + skip + length);

		thd.mCppTextStart = lip.getTokStart(thd) + skip;
		thd.mCppTextEnd = thd.mCppTextStart + length;

		return tmp;
	}

	private boolean initStateMaps() {
		// uchar *stateMap;
		// uchar *identMap;
		stateMap = new HashMap<Character, MyLexStates>();
		identMap = new HashMap<Character, Boolean>();

		/* Fill stateMap with states to get a faster parser */
		for (int i = 0; i < 256; i++) {
			if (Character.isAlphabetic(i))
				stateMap.put((char) i, MyLexStates.MY_LEX_IDENT);
			else if (Character.isDigit(i))
				stateMap.put((char) i, MyLexStates.MY_LEX_NUMBER_IDENT);
			else if (Character.isWhitespace(i))
				stateMap.put((char) i, MyLexStates.MY_LEX_SKIP);
			else
				stateMap.put((char) i, MyLexStates.MY_LEX_CHAR);
		}
		stateMap.put('_', MyLexStates.MY_LEX_IDENT);
		stateMap.put('$', MyLexStates.MY_LEX_IDENT);
		stateMap.put('\'', MyLexStates.MY_LEX_STRING);
		stateMap.put('.', MyLexStates.MY_LEX_REAL_OR_POINT);
		stateMap.put('>', MyLexStates.MY_LEX_CMP_OP);
		stateMap.put('=', MyLexStates.MY_LEX_CMP_OP);
		stateMap.put('!', MyLexStates.MY_LEX_CMP_OP);
		stateMap.put('<', MyLexStates.MY_LEX_LONG_CMP_OP);
		stateMap.put('&', MyLexStates.MY_LEX_BOOL);
		stateMap.put('|', MyLexStates.MY_LEX_BOOL);
		stateMap.put('#', MyLexStates.MY_LEX_COMMENT);
		stateMap.put(';', MyLexStates.MY_LEX_SEMICOLON);
		stateMap.put(':', MyLexStates.MY_LEX_SET_VAR);
		stateMap.put((char) 0, MyLexStates.MY_LEX_EOL);
		stateMap.put('\\', MyLexStates.MY_LEX_ESCAPE);
		stateMap.put('/', MyLexStates.MY_LEX_LONG_COMMENT);
		stateMap.put('*', MyLexStates.MY_LEX_END_LONG_COMMENT);
		stateMap.put('@', MyLexStates.MY_LEX_USER_END);
		stateMap.put('`', MyLexStates.MY_LEX_USER_VARIABLE_DELIMITER);
		stateMap.put('"', MyLexStates.MY_LEX_STRING_OR_DELIMITER);

		/*
		 * Create a second map to make it faster to find identifiers
		 */
		for (int i = 0; i < 256; i++) {
			char c = (char) i;
			identMap.put(c, state(c) == MyLexStates.MY_LEX_IDENT || state(c) == MyLexStates.MY_LEX_NUMBER_IDENT);
		}

		/* Special handling of hex and binary strings */
		stateMap.put('x', MyLexStates.MY_LEX_IDENT_OR_HEX);
		stateMap.put('X', MyLexStates.MY_LEX_IDENT_OR_HEX);
		stateMap.put('b', MyLexStates.MY_LEX_IDENT_OR_BIN);
		stateMap.put('B', MyLexStates.MY_LEX_IDENT_OR_BIN);
		stateMap.put('n', MyLexStates.MY_LEX_IDENT_OR_NCHAR);
		stateMap.put('N', MyLexStates.MY_LEX_IDENT_OR_NCHAR);
		return true;
	}

	/**
	 * get state from stateMap, if c > 255, then default to MY_LEX_IDENT.
	 * @param c char
	 * @return LexState
	 */
	MyLexStates state(char c) {
		MyLexStates result = stateMap.get(c);
		if (result == null) {
			result = MyLexStates.MY_LEX_IDENT;
		}
		return result;
	}

	/**
	 * check whether the c is an ident.
	 * @param c char
	 * @return if c is an ident, then true, or false.
	 */
	Boolean ident(char c) {
		Boolean result = true;
		if (identMap.containsKey(c)) {
			result = identMap.get(c);
		}
		return result;
	}

	class Variables {
		/* Bits for different SQL modes modes (including ANSI mode) */
		public static final int MODE_REAL_AS_FLOAT = 1;
		public static final int MODE_PIPES_AS_CONCAT = 2;
		public static final int MODE_ANSI_QUOTES = 4;
		public static final int MODE_IGNORE_SPACE = 8;
		public static final int MODE_NOT_USED = 16;
		public static final int MODE_ONLY_FULL_GROUP_BY = 32;
		public static final int MODE_NO_UNSIGNED_SUBTRACTION = 64;
		public static final int MODE_NO_DIR_IN_CREATE = 128;
		public static final int MODE_POSTGRESQL = 256;
		public static final int MODE_ORACLE = 512;
		public static final int MODE_MSSQL = 1024;
		public static final int MODE_DB2 = 2048;
		public static final int MODE_MAXDB = 4096;
		public static final int MODE_NO_KEY_OPTIONS = 8192;
		public static final int MODE_NO_TABLE_OPTIONS = 16384;
		public static final int MODE_NO_FIELD_OPTIONS = 32768;
		public static final int MODE_MYSQL323 = 65536;
		public static final int MODE_MYSQL40 = (MODE_MYSQL323 * 2);
		public static final int MODE_ANSI = (MODE_MYSQL40 * 2);
		public static final int MODE_NO_AUTO_VALUE_ON_ZERO = (MODE_ANSI * 2);
		public static final int MODE_NO_BACKSLASH_ESCAPES = (MODE_NO_AUTO_VALUE_ON_ZERO * 2);
		public static final int MODE_STRICT_TRANS_TABLES = (MODE_NO_BACKSLASH_ESCAPES * 2);
		public static final int MODE_STRICT_ALL_TABLES = (MODE_STRICT_TRANS_TABLES * 2);
		public static final int MODE_NO_ZERO_IN_DATE = (MODE_STRICT_ALL_TABLES * 2);
		public static final int MODE_NO_ZERO_DATE = (MODE_NO_ZERO_IN_DATE * 2);
		public static final int MODE_INVALID_DATES = (MODE_NO_ZERO_DATE * 2);
		public static final int MODE_ERROR_FOR_DIVISION_BY_ZERO = (MODE_INVALID_DATES * 2);
		public static final int MODE_TRADITIONAL = (MODE_ERROR_FOR_DIVISION_BY_ZERO * 2);
		public static final int MODE_NO_AUTO_CREATE_USER = (MODE_TRADITIONAL * 2);
		public static final int MODE_HIGH_NOT_PRECEDENCE = (MODE_NO_AUTO_CREATE_USER * 2);
		public static final int MODE_NO_ENGINE_SUBSTITUTION = (MODE_HIGH_NOT_PRECEDENCE * 2);
		public static final int MODE_PAD_CHAR_TO_FULL_LENGTH = (1 << 31);

		public int sqlMode;

		public Variables() {
			sqlMode = 0;
		}
	}
}

enum MyLexStates {
	MY_LEX_START, MY_LEX_CHAR, MY_LEX_IDENT, MY_LEX_IDENT_SEP, MY_LEX_IDENT_START, MY_LEX_REAL, MY_LEX_HEX_NUMBER, MY_LEX_BIN_NUMBER, MY_LEX_CMP_OP, MY_LEX_LONG_CMP_OP, MY_LEX_STRING, MY_LEX_COMMENT, MY_LEX_END, MY_LEX_OPERATOR_OR_IDENT, MY_LEX_NUMBER_IDENT, MY_LEX_INT_OR_REAL, MY_LEX_REAL_OR_POINT, MY_LEX_BOOL, MY_LEX_EOL, MY_LEX_ESCAPE, MY_LEX_LONG_COMMENT, MY_LEX_END_LONG_COMMENT, MY_LEX_SEMICOLON, MY_LEX_SET_VAR, MY_LEX_USER_END, MY_LEX_HOSTNAME, MY_LEX_SKIP, MY_LEX_USER_VARIABLE_DELIMITER, MY_LEX_SYSTEM_VAR, MY_LEX_IDENT_OR_KEYWORD, MY_LEX_IDENT_OR_HEX, MY_LEX_IDENT_OR_BIN, MY_LEX_IDENT_OR_NCHAR, MY_LEX_STRING_OR_DELIMITER
};

/**
 * The state of the lexical parser, when parsing comments.
 */
enum EnumCommentState {
	/**
	 * Not parsing comments.
	 */
	NO_COMMENT,
	/**
	 * Parsing comments that need to be preserved. Typically, these are user
	 * comments '/' '*' ... '*' '/'.
	 */
	PRESERVE_COMMENT,
	/**
	 * Parsing comments that need to be discarded. Typically, these are special
	 * comments '/' '*' '!' ... '*' '/', or '/' '*' '!' 'M' 'M' 'm' 'm' 'm' ...
	 * '*' '/', where the comment markers should not be expanded.
	 */
	DISCARD_COMMENT
};