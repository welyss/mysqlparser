package org.welyss.mysqlparser.v84;

import org.welyss.mysqlparser.items.LexString;
import org.welyss.mysqlparser.v84.LexStateMapsSt.HintLexCharClasses;

/**
 * Convert from /src/sql/sql_lex_hints.h, /src/sql/sql_lex_hints.cc
 */
public class HintScanner {
	public String yytext;
	public int yyleng;
	public int rawYytext;
	public int ptr;
	private SQLThread thd;
	private int lineno;
	private int inputBuf;
	private int inputBufEnd;
	private int prevToken;
	private boolean isAnsiQuotes;
	private SQLDigestState digestState;

	public HintScanner(SQLThread thd, int linenoArg, int buf, int len, SQLDigestState digestStateArg) {
		this.thd = thd;
		lineno = linenoArg;
		inputBuf = buf;
		inputBufEnd = len;
		ptr = inputBuf + 3;// skip "/*+"
		isAnsiQuotes = SystemVariables.isModeOn(SystemVariables.MODE_ANSI_QUOTES);
	}

	public int getNextToken() {
		int prevToken = scan();
		addHintTokenDigest();
		return prevToken;
	}

	private int scan() {
		int whitespaces = 0;
		for (;;) {
			startToken();
			HintLexCharClasses charClass = peekClass();
			switch (charClass) {
			case HINT_CHR_NL:
				skipNewline();
				whitespaces++;
				continue;
			case HINT_CHR_SPACE:
				skipByte();
				whitespaces++;
				continue;
			case HINT_CHR_DIGIT:
				return scanNumberOrMultiplierOrIdent();
			case HINT_CHR_IDENT:
				return scanIdentOrKeyword();
			case HINT_CHR_MB:
				return scanIdent();
			case HINT_CHR_QUOTE:
				return scanQuoted(HintLexCharClasses.HINT_CHR_QUOTE);
			case HINT_CHR_BACKQUOTE:
				return scanQuoted(HintLexCharClasses.HINT_CHR_BACKQUOTE);
			case HINT_CHR_DOUBLEQUOTE:
				return scanQuoted(HintLexCharClasses.HINT_CHR_DOUBLEQUOTE);
			case HINT_CHR_ASTERISK:
				HintLexCharClasses peekClass2 = peekClass2();
				if (peekClass2 == HintLexCharClasses.HINT_CHR_SLASH) {
					yytext = thd.mParserState.mLip.sqlBuf.substring(inputBuf+3, ptr).trim();
					yyleng = yytext.length();
					ptr += 2; // skip "*/"
					inputBufEnd = ptr;
					return SQLHintsLexer.HINT_CLOSE;
				} else
					return getByte();
			case HINT_CHR_AT:
				if (prevToken == '(' || (prevToken == SQLHintsLexer.HINT_ARG_IDENT && whitespaces == 0))
					return scanQueryBlockName();
				else
					return getByte();
			case HINT_CHR_DOT:
				return scanFractionDigits();
			case HINT_CHR_EOF:
				return 0;
			default:
				return getByte();
			}
		}
	}

	private void adjustToken() {
//		yytext = ptr;
		yytext = null;
		yyleng = 0;
	}

	private void startToken() {
		adjustToken();
		rawYytext = ptr;
	}

	/**
	 * Add hint tokens to main lexer's digest calculation buffer.
	 */
	void addHintTokenDigest() {
//	  if (digest_state == nullptr) return;  // can't add: digest buffer is full
//
//	  if (prevToken == 0 || prevToken == HINT_ERROR) return;  // nothing to add
//
//	  if (prevToken == HINT_CLOSE) {
//	    if (has_hints) add_digest(TOK_HINT_COMMENT_CLOSE);
//	    return;
//	  }
//	  if (!has_hints) {  // the 1st hint in the comment
//	    add_digest(TOK_HINT_COMMENT_OPEN);
//	    has_hints = true;
//	  }
//
//	  switch (prevToken) {
//	    case HINT_ARG_NUMBER:
//	    case HINT_ARG_FLOATING_POINT_NUMBER:
//	      add_digest(NUM);
//	      break;
//	    case HINT_ARG_IDENT:
//	      add_digest((peek_class() == HINT_CHR_AT) ? TOK_IDENT_AT : IDENT);
//	      break;
//	    case HINT_ARG_QB_NAME:
//	      add_digest('@');
//	      add_digest(IDENT);
//	      break;
//	    case HINT_ARG_TEXT:
//	      add_digest(TEXT_STRING);
//	      break;
//	    case HINT_IDENT_OR_NUMBER_WITH_SCALE:
//	      add_digest(NUM);
//	      break;
//	    default:
//	      if (prevToken <= UCHAR_MAX)  // Single-char token.
//	        add_digest(prevToken);
//	      else  // keyword
//	      {
//	        /* Make sure this is a known hint keyword: */
//	        switch (prevToken) {
//	          case BKA_HINT:
//	          case BNL_HINT:
//	          case DUPSWEEDOUT_HINT:
//	          case FIRSTMATCH_HINT:
//	          case INTOEXISTS_HINT:
//	          case LOOSESCAN_HINT:
//	          case MATERIALIZATION_HINT:
//	          case MAX_EXECUTION_TIME_HINT:
//	          case MRR_HINT:
//	          case NO_BKA_HINT:
//	          case NO_BNL_HINT:
//	          case NO_ICP_HINT:
//	          case NO_MRR_HINT:
//	          case NO_RANGE_OPTIMIZATION_HINT:
//	          case NO_SEMIJOIN_HINT:
//	          case QB_NAME_HINT:
//	          case SEMIJOIN_HINT:
//	          case SET_VAR_HINT:
//	          case SUBQUERY_HINT:
//	          case DERIVED_MERGE_HINT:
//	          case NO_DERIVED_MERGE_HINT:
//	          case JOIN_PREFIX_HINT:
//	          case JOIN_SUFFIX_HINT:
//	          case JOIN_ORDER_HINT:
//	          case JOIN_FIXED_ORDER_HINT:
//	          case INDEX_MERGE_HINT:
//	          case NO_INDEX_MERGE_HINT:
//	          case RESOURCE_GROUP_HINT:
//	          case SKIP_SCAN_HINT:
//	          case NO_SKIP_SCAN_HINT:
//	          case HASH_JOIN_HINT:
//	          case NO_HASH_JOIN_HINT:
//	          case INDEX_HINT:
//	          case NO_INDEX_HINT:
//	          case JOIN_INDEX_HINT:
//	          case NO_JOIN_INDEX_HINT:
//	          case GROUP_INDEX_HINT:
//	          case NO_GROUP_INDEX_HINT:
//	          case ORDER_INDEX_HINT:
//	          case NO_ORDER_INDEX_HINT:
//	          case DERIVED_CONDITION_PUSHDOWN_HINT:
//	          case NO_DERIVED_CONDITION_PUSHDOWN_HINT:
//	            break;
//	          default:
//	            assert(false);
//	        }
//	        add_digest(prevToken);
//	      }
//	  }
	}

	private int scanNumberOrMultiplierOrIdent() {
		skipByte();

		for (;;) {
			switch (peekClass()) {
			case HINT_CHR_DIGIT:
				skipByte();
				continue;
			case HINT_CHR_DOT:
				return scanFractionDigits();
			case HINT_CHR_IDENT:
				return scanMultiplierOrIdent();
			case HINT_CHR_MB:
				return scanIdent();
			case HINT_CHR_EOF:
			default:
				return SQLHintsLexer.HINT_ARG_NUMBER;
			}
		}
	}

	private int scanMultiplierOrIdent() {
//		assert (peekClass() == HINT_CHR_IDENT);
		switch (peekByte()) {
		case 'K':
		case 'M':
		case 'G':
			break;
		default:
			return scanIdent();
		}
		skipByte();

		switch (peekClass()) {
		case HINT_CHR_IDENT:
		case HINT_CHR_DIGIT:
			return scanIdent();
		default:
			return SQLHintsLexer.HINT_IDENT_OR_NUMBER_WITH_SCALE;
		}
	}

	private int scanIdent() {
		for (;;) {
			HintLexCharClasses chrClass = peekClass();
			switch (chrClass) {
			case HINT_CHR_IDENT:
			case HINT_CHR_DIGIT:
				skipByte();
				continue;
			case HINT_CHR_MB:
				if (skipMb())
					return SQLHintsLexer.HINT_ERROR;
				continue;
			case HINT_CHR_EOF:
			default:
				return SQLHintsLexer.HINT_ARG_IDENT;
			}
		}
	}

	/**
	 * function strmake from /src/mysys/my_alloc.cc, /src/sql/sql_class.h
	 */
	private int scanIdentOrKeyword() {
		int start = ptr;
		for (;;) {
			HintLexCharClasses charClass = peekClass();
			switch (charClass) {
			case HINT_CHR_IDENT:
			case HINT_CHR_DIGIT:
				skipByte();
				continue;
			case HINT_CHR_MB:
				return scanIdent();
			case HINT_CHR_EOF:
			default:
				yytext = thd.mParserState.mLip.sqlBuf.substring(start, ptr);
				Symbol symbol = LexHash.getHashSymbol(yytext, false, true);
				if (symbol != null) // keyword
				{
					/*
					 * Override the yytext pointer to the short-living buffer with a long-living pointer to the same text (don't need to allocate a keyword string since symbol
					 * array is a global constant).
					 */
					yytext = symbol.name;
//					assert (yyleng == symbol.length);

					return symbol.tok;
				}

//				yytext = thd.strmake(yytext, yyleng);
				return SQLHintsLexer.HINT_ARG_IDENT;
			}
		}
	}

	public void skipNewline() {
//		    assert(!eof() && peek_byte() == '\n');
		if (!eof() && peekByte() == '\n') {
			skipByte();
			lineno++;
		}
	}

	private boolean skipMb() {
//		int len = my_ismbchar(cs, ptr, inputBufEnd);
//		if (len == 0) {
//			ptr++;
//			yyleng++;
//			return true;
//		}
//		ptr += len;
//		yyleng += len;
//		return false;
		return true;
	}

	public int getByte() {
//		    assert(!eof());
		int ret = ptr;
		yyleng++;
		ptr++;
		return ret;
	}

	public void skipByte() {
//		    assert(!eof());
		if (!eof()) {
			yyleng++;
			ptr++;
		}
	}

	/**
	 * Skips the next byte. In the debug mode, abort if it's not found in @p byte.
	 *
	 * @param ch A byte to compare with the byte we skip. Unused in non-debug builds.
	 */
	private void skipByte(char ch) {
//    assert(peekByte() == ch);
		if (peekByte() == ch)
			skipByte();
	}

	/**
	 * Skips the next byte. In the debug mode, abort if it's not found in @p str.
	 *
	 * @param str A string of characters to compare with the next byte. Unused in non-debug builds.
	 */
	private void skipByte(String str) {
//		assert (strchr(str, peekByte()));
		if (str.indexOf(peekByte()) != -1)
			skipByte();
	}

	public boolean eof() {
//		    assert(ptr <= inputBufEnd);
		return ptr >= inputBufEnd;
	}

	public char peekByte() {
		return peekByte(0);
	}

	public char peekByte(int n) {
//	    assert(!eof());
		return thd.mParserState.mLip.sqlBuf.charAt(ptr + n);
	}

	private HintLexCharClasses peekClass() {
		return eof() ? HintLexCharClasses.HINT_CHR_EOF : LexStateMapsSt.hintMap[peekByte()];
	}

	private HintLexCharClasses peekClass2() {
		return ptr + 1 >= inputBufEnd ? HintLexCharClasses.HINT_CHR_EOF : LexStateMapsSt.hintMap[peekByte(1)];
	}

	private int scanFractionDigits() {
		skipByte('.');

		if (peekClass() == HintLexCharClasses.HINT_CHR_DIGIT)
			skipByte();
		else
			return SQLHintsLexer.HINT_ERROR;

		for (;;) {
			switch (peekClass()) {
			case HINT_CHR_DIGIT:
				skipByte();
				continue;
			case HINT_CHR_IDENT:
			case HINT_CHR_MB:
				return SQLHintsLexer.HINT_ERROR;
			default:
				return SQLHintsLexer.HINT_ARG_FLOATING_POINT_NUMBER;
			}
		}
	}

	/**
	 * from /src/sql/sql_lex_hints.h
	 *
	 * @return
	 */
	private int scanQuoted(HintLexCharClasses quote) {
//		    assert(Quote == HINT_CHR_BACKQUOTE || Quote == HINT_CHR_DOUBLEQUOTE ||
//		           Quote == HINT_CHR_QUOTE);
//		    assert(*ptr == '`' || *ptr == '"' || *ptr == '\'');
		if (quote == HintLexCharClasses.HINT_CHR_BACKQUOTE || quote == HintLexCharClasses.HINT_CHR_DOUBLEQUOTE || quote == HintLexCharClasses.HINT_CHR_QUOTE) {
			boolean isIdent = (quote == HintLexCharClasses.HINT_CHR_BACKQUOTE) || (isAnsiQuotes && quote == HintLexCharClasses.HINT_CHR_DOUBLEQUOTE);
			int ret = isIdent ? SQLHintsLexer.HINT_ARG_IDENT : SQLHintsLexer.HINT_ARG_TEXT;

			skipByte("\"'`"); // skip opening quote sign
			adjustToken(); // reset yytext & yyleng

			int doubleSeparators = 0;

			for (;;) {
				HintLexCharClasses chrClass = peekClass();
				if (chrClass.equals(HintLexCharClasses.HINT_CHR_NL)) {
					skipNewline();
					continue;
				} else if (chrClass.equals(HintLexCharClasses.HINT_CHR_MB)) {
					if (skipMb())
						return SQLHintsLexer.HINT_ERROR;
					continue;
				} else if (chrClass.equals(HintLexCharClasses.HINT_CHR_ASTERISK)) {
					if (peekClass2() == HintLexCharClasses.HINT_CHR_SLASH)
						return SQLHintsLexer.HINT_ERROR; // we don't support "*/" inside quoted
					// identifiers
					skipByte('*');
					continue;
				} else if (chrClass.equals(HintLexCharClasses.HINT_CHR_EOF)) {
					return SQLHintsLexer.HINT_ERROR;
				} else if (chrClass.equals(quote)) {
					if (peekClass2() == quote) {
						skipByte("\"'`");
						skipByte("\"'`");
						doubleSeparators++;
						continue;
					} else {
						if (yyleng == 0)
							return SQLHintsLexer.HINT_ERROR; // empty quoted identifier

						ptr++; // skip closing quote

						if (thd.charsetIsSystemCharset && doubleSeparators == 0) {
							yytext = new String(yytext); // null-terminate it.
							return ret;
						}

						LexString s = new LexString();
						if (!thd.charsetIsSystemCharset) {
//	    					if (thd.convert_string(&s, system_charset_info, yytext, yyleng,
//	    							thd.charset()))
//	    						return HINT_ERROR;  // OOM etc.
						} else {
//	    					assert(0 < doubleSeparators && doubleSeparators < yyleng);
							if (0 < doubleSeparators && doubleSeparators < yyleng) {
								s.length = yyleng - doubleSeparators;
								s.str = new String(new char[s.length]);
								if (s.str == null)
									return SQLHintsLexer.HINT_ERROR; // OOM
							}
						}
						if (doubleSeparators > 0)
							compact(quote, s, yytext, yyleng, doubleSeparators);

						yytext = s.str;
						yyleng = s.length;
						return ret;
					}
				} else {
					skipByte();
				}
			}
		} else {
			return -1;
		}
	}

	private int scanQueryBlockName() {
		skipByte('@');
		startToken();

		switch (peekClass()) {
		case HINT_CHR_IDENT:
		case HINT_CHR_DIGIT:
		case HINT_CHR_MB:
			if (scanIdent() == SQLHintsLexer.HINT_ARG_IDENT) {
//		          yytext = thd.strmake(yytext, yyleng);
				return SQLHintsLexer.HINT_ARG_QB_NAME;
			} else
				return SQLHintsLexer.HINT_ERROR;
		case HINT_CHR_BACKQUOTE:
			return scanQuoted(HintLexCharClasses.HINT_CHR_BACKQUOTE) == SQLHintsLexer.HINT_ARG_IDENT ? SQLHintsLexer.HINT_ARG_QB_NAME : SQLHintsLexer.HINT_ERROR;
		case HINT_CHR_DOUBLEQUOTE:
			return scanQuoted(HintLexCharClasses.HINT_CHR_DOUBLEQUOTE) == SQLHintsLexer.HINT_ARG_IDENT ? SQLHintsLexer.HINT_ARG_QB_NAME : SQLHintsLexer.HINT_ERROR;
		default:
			return SQLHintsLexer.HINT_ERROR;
		}
	}

	private void compact(HintLexCharClasses separator, LexString to, String from, int len, int doubles) {
		int d = doubles;
		for (int s = 0, end = len; s < end;) {
			HintLexCharClasses hlccs = LexStateMapsSt.hintMap[s];
			if (hlccs.equals(HintLexCharClasses.HINT_CHR_MB)) {
//			          int hintLen = my_ismbchar(cs, s, end);
				int hintLen = 1;
//			          assert(hintLen > 1);
//			          memcpy(t, s, hintLen);
				to.str += from.charAt(hintLen);
				s += hintLen;
				continue;
			} else if (hlccs.equals(separator)) {
//		          assert(char_classes[(uchar)*s] == Separator);
				if (hlccs == separator) {
					// t = ++s;
					s++; // skip the 2nd separator
					d--;
					if (d == 0) {
//			        			memcpy(t, s, end - s);
						to.length = len - doubles;
//						return;
					}
				}
				continue;
			} else if (hlccs.equals(HintLexCharClasses.HINT_CHR_EOF)) {
//		          assert(0);
				to.length = 0;
//				return;
			} else {
//		          *t++ = *s++;
				s++;
			}
		}
//	    assert(0);
		to.length = 0;
		return;
	}

	public int getPtr() {
		return ptr;
	}

	public SQLDigestState getDigest() {
		return digestState;
	}
}
