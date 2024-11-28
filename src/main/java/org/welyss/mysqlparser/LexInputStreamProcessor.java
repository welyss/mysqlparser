package org.welyss.mysqlparser;

import java.util.Iterator;
import java.util.Map.Entry;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.Token;

public class LexInputStreamProcessor {
	public static int TOK_GENERIC_VALUE;
	public static int TOK_GENERIC_VALUE_LIST;
	public static int TOK_UNUSED;
	public static int TOK_ROW_SINGLE_VALUE;
	public static int TOK_ROW_SINGLE_VALUE_LIST;
	public static int TOK_ROW_MULTIPLE_VALUE;
	public static int TOK_ROW_MULTIPLE_VALUE_LIST;
	public static int TOK_IDENT;
	public static final int MY_MAX_TOKEN = 1000;
	public static final int SIZE_OF_A_TOKEN = 2;
	/** Upper case */
	public static final int _MY_U = 01;
	/** Lower case */
	public static final int _MY_L = 02;
	/** Numeral (digit) */
	public static final int _MY_NMR = 04;
	/** Spacing character */
	public static final int _MY_SPC = 010;
	/** Punctuation */
	public static final int _MY_PNT = 020;
	/** Control character */
	public static final int _MY_CTR = 040;
	/** Blank */
	public static final int _MY_B = 0100;
	/** heXadecimal digit */
	public static final int _MY_X = 0200;

	public static final int ctypeLatin1[] = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 40, 40, 40, 40, 40, 32, 32, 32, 32, 32, 32, 32,
			32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 72, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 132, 132,
			132, 132, 132, 132, 132, 132, 132, 132, 16, 16, 16, 16, 16, 16, 16, 129, 129, 129, 129, 129, 129, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 16, 16, 16, 16, 16, 130, 130, 130, 130, 130, 130, 2, 2, 2, 2, 2, 2, 2, 2,
			2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 16, 16, 16, 16, 32, 16, 0, 16, 2, 16, 16, 16, 16, 16, 16, 1, 16, 1, 0, 1, 0, 0,
			16, 16, 16, 16, 16, 16, 16, 16, 16, 2, 16, 2, 0, 2, 1, 72, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
			16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 16, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 16, 2,
			2, 2, 2, 2, 2, 2, 2 };
	public static LexTokenString[] lexTokenArray;

	public static int maxTokenSeen;

	/** Token character bitmaps, to detect 7bit strings. */
	public char tokBitmap;

	/**
	 * TRUE if we're parsing a prepared statement: in this mode we should allow
	 * placeholders.
	 */
	public boolean stmtPrepareMode = true;

	static {
		computeTokens();
	}

	public LexInputStreamProcessor() {
	}

	public static boolean myIsCntrl(char c) {
		return c < ctypeLatin1.length && (ctypeLatin1[c] & _MY_CTR) == _MY_CTR;
	}

	public static int myMbcharlen(char c) {
		return 1;
	}

	public static boolean myIsDigit(char c) {
		return c < ctypeLatin1.length && ((ctypeLatin1[c] & _MY_NMR) == _MY_NMR);
	}

	public static boolean myIsalnum(char c) {
		return c < ctypeLatin1.length && ((ctypeLatin1[c] & _MY_U) == _MY_U || (ctypeLatin1[c] & _MY_L) == _MY_L || (ctypeLatin1[c] & _MY_NMR) == _MY_NMR);
	}

	/** Mark the stream position as the start of a new token. */
	public void startToken(SQLThread thd) {
		thd.mTokStartPrev = thd.mTokStart;
		thd.mTokStart = thd.mPtr;
		thd.mTokEnd = thd.mPtr;
	}

	/**
	 * Look at the next character to parse, but do not accept it.
	 */
	public char yyPeek(SQLThread thd) {
		return yyPeekn(thd, 0);
	}

	/**
	 * Look ahead at some character to parse.
	 * 
	 * @param n
	 *            offset of the character to look up
	 */
	public char yyPeekn(SQLThread thd, int n) {
		return thd.mPtr + n < thd.sql.length() ? thd.sql.charAt(thd.mPtr + n) : MyParser.EOF;
	}

	/**
	 * Accept a character, by advancing the input stream.
	 */
	public void yySkip(SQLThread thd) {
		thd.mPtr++;
	}

	/**
	 * Accept multiple characters at once.
	 * 
	 * @param n
	 *            the number of characters to accept.
	 */
	public void yySkipn(SQLThread thd, int n) {
		thd.mPtr += n;
	}

	/**
	 * Adjust the starting position of the current token. This is used to
	 * compensate for starting whitespace.
	 */
	public void restartToken(SQLThread thd) {
		thd.mTokStart = thd.mPtr;
	}

	/**
	 * Get a character, and advance in the stream.
	 * 
	 * @return the next character to parse.
	 */
	public char yyGet(SQLThread thd) {
		char c;
		if (thd.mPtr < thd.sql.length())
			c = thd.sql.charAt(thd.mPtr);
		else
			c = MyParser.EOF;
		thd.mPtr++;
		return c;
	}

	/**
	 * Get the last character accepted.
	 * 
	 * @return the last character accepted.
	 */
	public char yyGetLast(SQLThread thd) {
		return thd.sql.charAt(thd.mPtr - 1);
	}

	/**
	 * Cancel the effect of the last yyGet() or yySkip(). Note that the echo
	 * mode should not change between calls to yyGet / yySkip and yyUnget. The
	 * caller is responsible for ensuring that.
	 */
	public void yyUnget(SQLThread thd) {
		thd.mPtr--;
	}

	/** Get the token start position, in the raw buffer. */
	public int getTokStart(SQLThread thd) {
		return thd.mTokStart;
	}

	/** Get the current stream pointer, in the raw buffer. */
	public int getPtr(SQLThread thd) {
		return thd.mPtr;
	}

	/** Get the token start position, in the pre-processed buffer. */
	public int getCppTokStart(SQLThread thd) {
		return thd.mCppTokStart;
	}

	/** Get the token end position, in the raw buffer. */
	public int getTokEnd(SQLThread thd) {
		return thd.mTokEnd;
	}

	/** Get the current stream pointer, in the pre-processed buffer. */
	public int getCppPtr(SQLThread thd) {
		return thd.mCppPtr;
	}

	/** Get the length of the current token, in the raw buffer. */
	public int yyLength(SQLThread thd) {
		return ((thd.mPtr - thd.mTokStart) - 1);
	}

	public void saveInCommentState(SQLThread thd) {
		thd.inCommentSaved = thd.inComment;
	}

	/**
	 * Puts a character back into the stream, canceling the effect of the last
	 * yyGet() or yySkip(). Note that the echo mode should not change between
	 * calls to unput, get, or skip from the stream.
	 */
	public char yyUnput(SQLThread thd, char ch) {
		thd.sql.setCharAt(--thd.mPtr, ch);
		return thd.sql.charAt(thd.mPtr);
	}

	public void restoreInCommentState(SQLThread thd) {
		thd.inComment = thd.inCommentSaved;
	}

	/**
	 * End of file indicator for the query text to parse.
	 * 
	 * @return true if there are no more characters to parse
	 */
	public boolean eof(SQLThread thd) {
		return (thd.mPtr >= thd.sql.length());
	}

//	public void addDigestToken(int token, SQLThread thd) {
//		if (thd.mDigest != null) {
//			thd.mDigest = digestAddToken(thd.mDigest, token, thd.yylval);
//		}
//	}

	public SQLDigestState digestAddToken(SQLDigestState state, int token, Item yylval) {
		SQLDigestStorage digestStorage = null;
		digestStorage = state.mDigestStorage;

		/*
		 * Stop collecting further tokens if digest storage is full or if END
		 * token is received.
		 */
		if (digestStorage.mFull || token == MyParser.END_OF_INPUT)
			return null;

		/*
		 * Take last_token 2 tokens collected till now. These tokens will be
		 * used in reduce for normalisation. Make sure not to consider ID tokens
		 * in reduce.
		 */
		int[] lastToken = new int[2];

		switch (token) {
		case MyParser.NUM:
		case MyParser.LONG_NUM:
		case MyParser.ULONGLONG_NUM:
		case MyParser.DECIMAL_NUM:
		case MyParser.FLOAT_NUM:
		case MyParser.BIN_NUM:
		case MyParser.HEX_NUM: {
			boolean found_unary;
			do {
				found_unary = false;
				peekLastTwoTokens(digestStorage, state.mLastIdIndex, lastToken);

				if ((lastToken[0] == '-') || (lastToken[0] == '+')) {
					/*
					 * We need to differentiate: - a <unary minus> operator - a
					 * <unary plus> operator from - a <binary minus> operator -
					 * a <binary plus> operator to only reduce "a = -1" to
					 * "a = ?", and not change "b - 1" to "b ?"
					 * 
					 * Binary operators are found inside an expression, while
					 * unary operators are found at the beginning of an
					 * expression, or after operators.
					 * 
					 * To achieve this, every token that is followed by an
					 * <expr> expression in the SQL grammar is flagged. See
					 * sql/sql_yacc.yy See sql/gen_lex_token.cc
					 * 
					 * For example, "(-1)" is parsed as "(", "-", NUM, ")", and
					 * lexTokenArray["("].mStartExpr is true, so reduction of
					 * the "-" NUM is done, the result is "(?)". "(a-1)" is
					 * parsed as "(", ID, "-", NUM, ")", and
					 * lexTokenArray[ID].mStartExpr is false, so the operator is
					 * binary, no reduction is done, and the result is "(a-?)".
					 */
					if (lexTokenArray[lastToken[1]].mStartExpr) {
						/*
						 * REDUCE: TOK_GENERIC_VALUE := (UNARY_PLUS |
						 * UNARY_MINUS) (NUM | LOG_NUM | ... | FLOAT_NUM)
						 * 
						 * REDUCE: TOK_GENERIC_VALUE := (UNARY_PLUS |
						 * UNARY_MINUS) TOK_GENERIC_VALUE
						 */
						token = TOK_GENERIC_VALUE;
						digestStorage.mByteCount -= SIZE_OF_A_TOKEN;
						found_unary = true;
					}
				}
			} while (found_unary);
		}
		/* fall through, for case NULL_SYM below */
		case MyParser.LEX_HOSTNAME:
		case MyParser.TEXT_STRING:
		case MyParser.NCHAR_STRING:
		case MyParser.PARAM_MARKER: {
			/*
			 * REDUCE: TOK_GENERIC_VALUE := BIN_NUM | DECIMAL_NUM | ... |
			 * ULONGLONG_NUM
			 */
			token = TOK_GENERIC_VALUE;

			peekLastTwoTokens(digestStorage, state.mLastIdIndex, lastToken);

			if ((lastToken[1] == TOK_GENERIC_VALUE || lastToken[1] == TOK_GENERIC_VALUE_LIST) && (lastToken[0] == ',')) {
				/*
				 * REDUCE: TOK_GENERIC_VALUE_LIST := TOK_GENERIC_VALUE ','
				 * TOK_GENERIC_VALUE
				 * 
				 * REDUCE: TOK_GENERIC_VALUE_LIST := TOK_GENERIC_VALUE_LIST ','
				 * TOK_GENERIC_VALUE
				 */
				digestStorage.mByteCount -= 2 * SIZE_OF_A_TOKEN;
				token = TOK_GENERIC_VALUE_LIST;
			}
			/*
			 * Add this token or the resulting reduce to digest storage.
			 */
			storeToken(digestStorage, token);
			break;
		}
		case ')': {
			peekLastTwoTokens(digestStorage, state.mLastIdIndex, lastToken);

			if (lastToken[0] == TOK_GENERIC_VALUE && lastToken[1] == '(') {
				/*
				 * REDUCE: TOK_ROW_SINGLE_VALUE := '(' TOK_GENERIC_VALUE ')'
				 */
				digestStorage.mByteCount -= 2 * SIZE_OF_A_TOKEN;
				token = TOK_ROW_SINGLE_VALUE;

				/* Read last two tokens again */
				peekLastTwoTokens(digestStorage, state.mLastIdIndex, lastToken);

				if ((lastToken[1] == TOK_ROW_SINGLE_VALUE || lastToken[1] == TOK_ROW_SINGLE_VALUE_LIST)
						&& (lastToken[0] == ',')) {
					/*
					 * REDUCE: TOK_ROW_SINGLE_VALUE_LIST := TOK_ROW_SINGLE_VALUE
					 * ',' TOK_ROW_SINGLE_VALUE
					 * 
					 * REDUCE: TOK_ROW_SINGLE_VALUE_LIST :=
					 * TOK_ROW_SINGLE_VALUE_LIST ',' TOK_ROW_SINGLE_VALUE
					 */
					digestStorage.mByteCount -= 2 * SIZE_OF_A_TOKEN;
					token = TOK_ROW_SINGLE_VALUE_LIST;
				}
			} else if (lastToken[0] == TOK_GENERIC_VALUE_LIST && lastToken[1] == '(') {
				/*
				 * REDUCE: TOK_ROW_MULTIPLE_VALUE := '(' TOK_GENERIC_VALUE_LIST
				 * ')'
				 */
				digestStorage.mByteCount -= 2 * SIZE_OF_A_TOKEN;
				token = TOK_ROW_MULTIPLE_VALUE;

				/* Read last two tokens again */
				peekLastTwoTokens(digestStorage, state.mLastIdIndex, lastToken);

				if ((lastToken[1] == TOK_ROW_MULTIPLE_VALUE || lastToken[1] == TOK_ROW_MULTIPLE_VALUE_LIST)
						&& (lastToken[0] == ',')) {
					/*
					 * REDUCE: TOK_ROW_MULTIPLE_VALUE_LIST :=
					 * TOK_ROW_MULTIPLE_VALUE ',' TOK_ROW_MULTIPLE_VALUE
					 * 
					 * REDUCE: TOK_ROW_MULTIPLE_VALUE_LIST :=
					 * TOK_ROW_MULTIPLE_VALUE_LIST ',' TOK_ROW_MULTIPLE_VALUE
					 */
					digestStorage.mByteCount -= 2 * SIZE_OF_A_TOKEN;
					token = TOK_ROW_MULTIPLE_VALUE_LIST;
				}
			}
			/*
			 * Add this token or the resulting reduce to digest storage.
			 */
			storeToken(digestStorage, token);
			break;
		}
		case MyParser.IDENT:
		case MyParser.IDENT_QUOTED: {
			Token lexToken = (Token)yylval;
			String yytext = lexToken.lexStr;
			// int yylen = lexToken.lexStr.length;

			/*
			 * REDUCE: TOK_IDENT := IDENT | IDENT_QUOTED The parser gives IDENT
			 * or IDENT_TOKEN for the same text, depending on the character set
			 * used. We unify both to always print the same digest text, and
			 * always have the same digest hash.
			 */
			token = TOK_IDENT;
			/* Add this token and identifier string to digest storage. */
			storeTokenIdentifier(digestStorage, token, yytext);

			/* Update the index of last identifier found. */
			state.mLastIdIndex = (int) digestStorage.mByteCount;
			break;
		}
		default: {
			/* Add this token to digest storage. */
			storeToken(digestStorage, token);
			break;
		}
		}

		return state;
	}

	/**
	 * Store an identifier in token array.
	 */
	public void storeTokenIdentifier(SQLDigestStorage digestStorage, int token, String idName) {
		digestStorage.mTokenArray.add(new SqlDigestInfo(token, idName));
	}

	/**
	 * Store a single token in token array.
	 */
	public void storeToken(SQLDigestStorage digestStorage, int token) {
		storeTokenIdentifier(digestStorage, token, null);
	}

	/**
	 * Function to read last two tokens from token array. If an identifier is
	 * found, do not look for token before that.
	 */
	public void peekLastTwoTokens(SQLDigestStorage digestStorage, int last_id_index, int[] tokenLastTwo) {
		if (digestStorage.mTokenArray.size() > 0) {
			/* Take last token. */
			int lastTokenIndex = digestStorage.mTokenArray.size() - 1;
			tokenLastTwo[0] = peekToken(digestStorage, lastTokenIndex);

			if (digestStorage.mTokenArray.size() > 1) {
				/* Take 2nd token from last. */
				tokenLastTwo[1] = peekToken(digestStorage, lastTokenIndex - 1);
			} else {
				tokenLastTwo[1] = TOK_UNUSED;
			}
		} else {
			tokenLastTwo[0] = TOK_UNUSED;
			tokenLastTwo[1] = TOK_UNUSED;
		}
	}

	public int peekToken(SQLDigestStorage digest, int index) {
		int token = digest.mTokenArray.get(index).token;
		return token;
	}

	public static void computeTokens() {
		int tok;
//		int i;
		lexTokenArray = new LexTokenString[MY_MAX_TOKEN];
		/*
		 * Default value.
		 */
		for (tok = 0; tok < MY_MAX_TOKEN; tok++) {
			lexTokenArray[tok] = new LexTokenString();
		}

		/*
		 * Tokens made of just one terminal character
		 */
		for (tok = 0; tok < 256; tok++) {
			lexTokenArray[tok].mTokenString = String.valueOf((char) tok);
			lexTokenArray[tok].mTokenLength = 1;
			lexTokenArray[tok].mAppendSpace = true;
		}

		maxTokenSeen = 255;

		/*
		 * String terminal tokens, used in sql_yacc.yy
		 */
		setToken(MyParser.NEG, "~");
		setToken(MyParser.TABLE_REF_PRIORITY, "TABLE_REF_PRIORITY");

		/*
		 * Tokens hard coded in sql_lex.cc
		 */

		setToken(MyParser.WITH_CUBE_SYM, "WITH CUBE");
		setToken(MyParser.WITH_ROLLUP_SYM, "WITH ROLLUP");
		setToken(MyParser.NOT2_SYM, "!");
		setToken(MyParser.OR2_SYM, "|");
		setToken(MyParser.PARAM_MARKER, "?");
		setToken(MyParser.SET_VAR, ":=");
		setToken(MyParser.UNDERSCORE_CHARSET, "(_charset)");
		setToken(MyParser.END_OF_INPUT, "");

		/*
		 * Values. These tokens are all normalized later, so this strings will
		 * never be displayed.
		 */
		setToken(MyParser.BIN_NUM, "(bin)");
		setToken(MyParser.DECIMAL_NUM, "(decimal)");
		setToken(MyParser.FLOAT_NUM, "(float)");
		setToken(MyParser.HEX_NUM, "(hex)");
		setToken(MyParser.LEX_HOSTNAME, "(hostname)");
		setToken(MyParser.LONG_NUM, "(long)");
		setToken(MyParser.NUM, "(num)");
		setToken(MyParser.TEXT_STRING, "(text)");
		setToken(MyParser.NCHAR_STRING, "(nchar)");
		setToken(MyParser.ULONGLONG_NUM, "(ulonglong)");

		/*
		 * Identifiers.
		 */
		setToken(MyParser.IDENT, "(id)");
		setToken(MyParser.IDENT_QUOTED, "(id_quoted)");

		/*
		 * Unused tokens
		 */
		setToken(MyParser.LOCATOR_SYM, "LOCATOR");
		setToken(MyParser.SERVER_OPTIONS, "SERVER_OPTIONS");
		setToken(MyParser.UDF_RETURNS_SYM, "UDF_RETURNS");

		/*
		 * See symbols[] in sql/lex.h
		 */
		Iterator<Entry<String, Integer>> itSymbols = LexConstants.symbols.entrySet().iterator();
		while(itSymbols.hasNext()) {
			Entry<String, Integer> entry = itSymbols.next();
			setToken(entry.getValue(), entry.getKey());
		}

		/*
		 * See sql_functions[] in sql/lex.h
		 */
		Iterator<Entry<String, Integer>> itSqlFunctions = LexConstants.sqlFunctions.entrySet().iterator();
		while(itSqlFunctions.hasNext()) {
			Entry<String, Integer> entry = itSqlFunctions.next();
			setToken(entry.getValue(), entry.getKey());
		}

		/*
		 * Additional FAKE tokens, used internally to normalize a digest text.
		 */

		maxTokenSeen++;
		int tok_generic_value = maxTokenSeen;
		setToken(TOK_GENERIC_VALUE = tok_generic_value, "?");

		maxTokenSeen++;
		int tok_generic_value_list = maxTokenSeen;
		setToken(TOK_GENERIC_VALUE_LIST = tok_generic_value_list, "?, ...");

		maxTokenSeen++;
		int tok_row_single_value = maxTokenSeen;
		setToken(TOK_ROW_SINGLE_VALUE = tok_row_single_value, "(?)");

		maxTokenSeen++;
		int tok_row_single_value_list = maxTokenSeen;
		setToken(TOK_ROW_SINGLE_VALUE_LIST = tok_row_single_value_list, "(?) /* , ... */");

		maxTokenSeen++;
		int tok_row_multiple_value = maxTokenSeen;
		setToken(TOK_ROW_MULTIPLE_VALUE = tok_row_multiple_value, "(...)");

		maxTokenSeen++;
		int tok_row_multiple_value_list = maxTokenSeen;
		setToken(TOK_ROW_MULTIPLE_VALUE_LIST = tok_row_multiple_value_list, "(...) /* , ... */");

		maxTokenSeen++;
		int tok_ident = maxTokenSeen;
		setToken(TOK_IDENT = tok_ident, "(tok_id)");

		maxTokenSeen++;
		int tok_unused = maxTokenSeen;
		setToken(TOK_UNUSED = tok_unused, "UNUSED");

		/*
		 * Fix whitespace for some special tokens.
		 */

		/*
		 * The lexer parses "@@variable" as '@', '@', 'variable', returning a
		 * token for '@' alone.
		 * 
		 * This is incorrect, '@' is not really a token, because the syntax
		 * "@ @ variable" (with spaces) is not accepted: The lexer keeps some
		 * internal state after the '@' fake token.
		 * 
		 * To work around this, digest text are printed as "@@variable".
		 */
		lexTokenArray[(int) '@'].mAppendSpace = false;

		/*
		 * Define additional properties for tokens.
		 * 
		 * List all the token that are followed by an expression. This is needed
		 * to differentiate unary from binary '+' and '-' operators, because we
		 * want to: - reduce <unary +> <NUM> to <?>, - preserve <...> <binary +>
		 * <NUM> as is.
		 */
		setStartExprToken('(');
		setStartExprToken(',');
		setStartExprToken(MyParser.EVERY_SYM);
		setStartExprToken(MyParser.AT_SYM);
		setStartExprToken(MyParser.STARTS_SYM);
		setStartExprToken(MyParser.ENDS_SYM);
		setStartExprToken(MyParser.DEFAULT);
		setStartExprToken(MyParser.RETURN_SYM);
		setStartExprToken(MyParser.IF);
		setStartExprToken(MyParser.ELSEIF_SYM);
		setStartExprToken(MyParser.CASE_SYM);
		setStartExprToken(MyParser.WHEN_SYM);
		setStartExprToken(MyParser.WHILE_SYM);
		setStartExprToken(MyParser.UNTIL_SYM);
		setStartExprToken(MyParser.SELECT_SYM);

		setStartExprToken(MyParser.OR_SYM);
		setStartExprToken(MyParser.OR2_SYM);
		setStartExprToken(MyParser.XOR);
		setStartExprToken(MyParser.AND_SYM);
		setStartExprToken(MyParser.AND_AND_SYM);
		setStartExprToken(MyParser.NOT_SYM);
		setStartExprToken(MyParser.BETWEEN_SYM);
		setStartExprToken(MyParser.LIKE);
		setStartExprToken(MyParser.REGEXP);

		setStartExprToken('|');
		setStartExprToken('&');
		setStartExprToken(MyParser.SHIFT_LEFT);
		setStartExprToken(MyParser.SHIFT_RIGHT);
		setStartExprToken('+');
		setStartExprToken('-');
		setStartExprToken(MyParser.INTERVAL_SYM);
		setStartExprToken('*');
		setStartExprToken('/');
		setStartExprToken('%');
		setStartExprToken(MyParser.DIV_SYM);
		setStartExprToken(MyParser.MOD_SYM);
		setStartExprToken('^');
	}

	private static void setStartExprToken(int tok) {
		lexTokenArray[tok].mStartExpr = true;
	}

	private static void setToken(int tok, String str) {
		if (tok <= 0) {
			throw new RuntimeException("Bad token found\n");
		}

		if (tok > maxTokenSeen) {
			maxTokenSeen = tok;
		}

		if (maxTokenSeen >= MY_MAX_TOKEN) {
			throw new RuntimeException("Added that many new keywords ? Increase MY_MAX_TOKEN\n");
		}

		if (tok >= lexTokenArray.length) {
			LexTokenString[] tmp = lexTokenArray;
			lexTokenArray = new LexTokenString[tok + 1];
			System.arraycopy(tmp, 0, lexTokenArray, 0, tmp.length);
		}

		if (lexTokenArray[tok] == null) lexTokenArray[tok] = new LexTokenString();
		lexTokenArray[tok].mTokenString = str;
		lexTokenArray[tok].mTokenLength = str.length();
		lexTokenArray[tok].mAppendSpace = true;
		lexTokenArray[tok].mStartExpr = false;
	}

	public static String getTokenString(int token) {
		String str;
		if (lexTokenArray != null && token < lexTokenArray.length) {
			str = lexTokenArray[token].mTokenString;
		} else {
			str = lexTokenArray[0].mTokenString;
		}
		return str;
	}
}

class LexTokenString {
	public String mTokenString;
	public int mTokenLength;
	public boolean mAppendSpace;
	public boolean mStartExpr;

	public LexTokenString() {
		mTokenString = "(unknown)";
		mTokenLength = 9;
		mAppendSpace = true;
		mStartExpr = false;
	}

	public LexTokenString(String mTokenString, int mTokenLength, boolean mAppendSpace, boolean mStartExpr) {
		this.mTokenString = mTokenString;
		this.mTokenLength = mTokenLength;
		this.mAppendSpace = mAppendSpace;
		this.mStartExpr = mStartExpr;
	}
}
