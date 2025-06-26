package org.welyss.mysqlparser.v84;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.welyss.mysqlparser.MySQLLexer;
import org.welyss.mysqlparser.MySQLThread;
import org.welyss.mysqlparser.MySQLVersion;
import org.welyss.mysqlparser.items.LexerYystype;
import org.welyss.mysqlparser.items.KeywordToken;
import org.welyss.mysqlparser.items.LexString;
import org.welyss.mysqlparser.items.LexSymbol;
import org.welyss.mysqlparser.items.Position;
import org.welyss.mysqlparser.items.Token;
import org.welyss.mysqlparser.v84.MyParser.Lexer;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from sql_lex.cc, include my_sql_parser_lex,lex_one_token... function.<br>
 * <b>CHARSET_INFO</b> is from include/mysql/strings/m_ctype.h and utf8mb3/utf8mb4 instance in strings/ctype-utf8.cc.
 */
public class MyLexer implements Lexer, MySQLLexer {
	public MySQLVersion mysqlVersion;
	public static final String LONG_STR = "2147483647";
	public static final int LONG_LEN = 10;
	public static final String SIGNED_LONG_STR = "-2147483648";
	public static final String LONGLONG_STR = "9223372036854775807";
	public static final int LONGLONG_LEN = 19;
	public static final String SIGNED_LONGLONG_STR = "-9223372036854775808";
	public static final int SIGNED_LONGLONG_LEN = 19;
	public static final String UNSIGNED_LONGLONG_STR = "18446744073709551615";
	public static final int UNSIGNED_LONGLONG_LEN = 20;

	LexStateMapsSt stateMaps;
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * show character set;
	 */
	private static Set<String> characters;

	static {
		characters = new HashSet<String>();
		characters.add("armscii8");
		characters.add("ascii");
		characters.add("big5");
		characters.add("binary");
		characters.add("cp1250");
		characters.add("cp1251");
		characters.add("cp1256");
		characters.add("cp1257");
		characters.add("cp850");
		characters.add("cp852");
		characters.add("cp866");
		characters.add("cp932");
		characters.add("dec8");
		characters.add("eucjpms");
		characters.add("euckr");
		characters.add("gb18030");
		characters.add("gb2312");
		characters.add("gbk");
		characters.add("geostd8");
		characters.add("greek");
		characters.add("hebrew");
		characters.add("hp8");
		characters.add("keybcs2");
		characters.add("koi8r");
		characters.add("koi8u");
		characters.add("latin1");
		characters.add("latin2");
		characters.add("latin5");
		characters.add("latin7");
		characters.add("macce");
		characters.add("macroman");
		characters.add("sjis");
		characters.add("swe7");
		characters.add("tis620");
		characters.add("ucs2");
		characters.add("ujis");
		characters.add("utf16");
		characters.add("utf16le");
		characters.add("utf32");
		characters.add("utf8");
		characters.add("utf8mb3");
		characters.add("utf8mb4");
	}

	public MyLexer() {
		stateMaps = new LexStateMapsSt();
		mysqlVersion = MySQLVersion.v84;
	}

	@Override
	public Position getEndPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLVal(MySQLThread thd) {
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
	public int yylex(MySQLThread mthd) throws IOException {
		SQLThread thd = (SQLThread)mthd;
		LexerYystype yylval = thd.mParserState.mLip.yylval;
		// POS in mysql-8.4.5/src/sql/parse_location.h
		Location yylloc = thd.yylloc;
		LexInputStream lip = thd.mParserState.mLip;
		int token;

//		  if (thd.is_error()) {
//		    if (thd.get_parser_da().has_sql_condition(ER_CAPACITY_EXCEEDED))
//		      return ABORT_SYM;
//		  }

		if (lip.lookaheadToken >= 0) {
			/*
			 * The next token was already parsed in advance, return it.
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
			 * Parsing 'WITH' 'ROLLUP' requires 2 look ups, which makes the grammar LALR(2). Replace by a single 'WithRollup' token, to transform the grammar into a LALR(1)
			 * grammar, which sqlYacc.yy can process.
			 */
			token = lexOneToken(yylval, thd);
			switch (token) {
			case ROLLUP_SYM:
//		          yylloc.cpp.end = lip.getCppPtr();
//		          yylloc.raw.end = lip.getPtr();
				lip.addDigestToken(WITH_ROLLUP_SYM, yylval);
				return WITH_ROLLUP_SYM;
			default:
				/*
				 * Save the token following 'WITH'
				 */
				lip.lookaheadYylval = lip.yylval;
				lip.yylval = null;
				lip.lookaheadToken = token;
//		          yylloc.cpp.end = lip.getCppPtr();
//		          yylloc.raw.end = lip.getPtr();
				lip.addDigestToken(WITH, yylval);
				return WITH;
			}
//		      break;
		}

//		  yylloc.cpp.end = lip.getCppPtr();
//		  yylloc.raw.end = lip.getPtr();
		if (!lip.skipDigest)
			lip.addDigestToken(token, yylval);
		lip.skipDigest = false;
		return token;
	}

	private int lexOneToken(LexerYystype yylval, SQLThread thd) {
		char c = 0;
		boolean commentClosed;
		int tokval, resultState;
		int length;
		MyLexStates state;
		LexInputStream lip = thd.mParserState.mLip;
		MyLexStates[] stateMap = LexStateMapsSt.mainMap;
		boolean[] identMap = LexStateMapsSt.identMap;

		if (yylval == null) yylval = new LexerYystype();
		lip.yylval = yylval; // The global state

		lip.startToken();
		state = lip.nextState;
		lip.nextState = MyLexStates.MY_LEX_START;
		for (;;) {
			switch (state) {
			case MY_LEX_START: // Start of token
				// Skip starting whitespace
				while (stateMap[c = lip.yyPeek()] == MyLexStates.MY_LEX_SKIP) {
					if (c == '\n')
						lip.yylineno++;
					lip.yySkip();
				}

				/* Start of real token */
				lip.restartToken();
				c = lip.yyGet();
				state = stateMap[c];
				break;
			case MY_LEX_CHAR: // Unknown or single char token
			case MY_LEX_SKIP: // This should not happen
				if (c == '-' && lip.yyPeek() == '-' && (Character.isWhitespace(lip.yyPeekn(1)) || lip.myIscntrl(lip.yyPeekn(1)))) {
					state = MyLexStates.MY_LEX_COMMENT;
					break;
				}

				if (c == '-' && lip.yyPeek() == '>') // '.'
				{
					lip.yySkip();
					lip.nextState = MyLexStates.MY_LEX_START;
					if (lip.yyPeek() == '>') {
						lip.yySkip();
						return JSON_UNQUOTED_SEPARATOR_SYM;
					}
					return JSON_SEPARATOR_SYM;
				}

				if (c != ')')
					lip.nextState = MyLexStates.MY_LEX_START; // Allow signed numbers

				/*
				 * Check for a placeholder: it should not precede a possible identifier because of binlogging: when a placeholder is replaced with its value in a query for the
				 * binlog, the query must stay grammatically correct.
				 */
				if (c == '?' && lip.stmtPrepareMode && !identMap[lip.yyPeek()])
					return (PARAM_MARKER);

				return ((int) c);

			case MY_LEX_IDENT_OR_NCHAR:
				if (lip.yyPeek() != '\'') {
					state = MyLexStates.MY_LEX_IDENT;
					break;
				}
				/* Found N'string' */
				lip.yySkip(); // Skip '

				if (!"".equals((yylval.lexStr.str = getText(lip, 2, 1)))) {
					state = MyLexStates.MY_LEX_CHAR; // Read char by char
					break;
				}
				yylval.lexStr.length = lip.yytoklen;
				return (NCHAR_STRING);

			case MY_LEX_IDENT_OR_HEX:
				if (lip.yyPeek() == '\'') { // Found x'hex-number'
					state = MyLexStates.MY_LEX_HEX_NUMBER;
					break;
				}
//		        [[fallthrough]];
			case MY_LEX_IDENT_OR_BIN:
				if (lip.yyPeek() == '\'') { // Found b'bin-number'
					state = MyLexStates.MY_LEX_BIN_NUMBER;
					break;
				}
//		        [[fallthrough]];
			case MY_LEX_IDENT:
				int start;
				for (resultState = c; identMap[c = lip.yyGet()]; resultState |= c)
					;
				/* If there were non-ASCII characters, mark that we must convert */
				resultState = (resultState & 0x80) == 0x80 ? IDENT_QUOTED : IDENT;
				length = lip.yyLength();
				start = lip.getPtr();
				if (lip.ignoreSpace) {
					/*
					 * If we find a space then this can't be an identifier. We notice this below by checking start != lex.ptr.
					 */
					for (; stateMap[c] == MyLexStates.MY_LEX_SKIP; c = lip.yyGet()) {
						if (c == '\n')
							lip.yylineno++;
					}
				}
				if (start == lip.getPtr() && c == '.' && identMap[lip.yyPeek()])
					lip.nextState = MyLexStates.MY_LEX_IDENT_SEP;
				else { // '(' must follow directly if function
					lip.yyUnget();
					if ((tokval = findKeyword(lip, length, c == '(')) != 0) {
						lip.nextState = MyLexStates.MY_LEX_START; // Allow signed numbers
						return (tokval); // Was keyword
					}
					lip.yySkip(); // next state does a unget
				}
				yylval.reset().lexStr = getToken(lip, 0, length);

				/*
				 * Note: "Select Bla As 'alias'" Bla should be considered as a Ident if charset haven't been found. So we don't want to produce any warning in findPrimary.
				 */

				if (yylval.lexStr.str.charAt(0) == '_') {
					String charsetName = yylval.lexStr.str.substring(1);
					yylval.charset = charsetName;
//		          const CharsetInfo *underscoreCs =
//		              mysql::collation::findPrimary(charsetName);
//		          if (underscoreCs) {
//		            lip.warnOnDeprecatedCharset(underscoreCs, charsetName);
//		            if (underscoreCs == &myCharsetUtf8mb40900AiCi) {
//		              /*
//		                If underscoreCs is utf8mb4, and the collation of underscoreCs
//		                is the default collation of utf8mb4, then update underscoreCs
//		                with a value of the defaultCollationForUtf8mb4 system
//		                variable:
//		              */
//		              underscoreCs = thd.variables.defaultCollationForUtf8mb4;
//		            }
//		           if (characters.contains(charsetName)) {}
//		            yylval.charset = charsetName;
//		            lip.mUnderscoreCs = underscoreCs;
					lip.bodyUtf8Append(lip.mCppTextStart, lip.getCppTokStart() + length);
					return (yylval.token = UNDERSCORE_CHARSET);
//		          }
				}
				lip.bodyUtf8Append(lip.mCppTextStart);
				lip.bodyUtf8AppendLiteral(thd, yylval.lexStr, lip.mCppTextEnd);
				return (yylval.token = resultState); // Ident or IdentQuoted

			case MY_LEX_IDENT_SEP: // Found ident and now '.'
//		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
				yylval.lexStr.str = String.valueOf(lip.getPtr());
				yylval.lexStr.length = 1;
				c = lip.yyGet(); // should be '.'
				char nextC = lip.yyPeek();
				if (identMap[nextC]) {
					lip.nextState = MyLexStates.MY_LEX_IDENT_START; // Next is an ident (not a keyword)
					if (nextC == '$') // We got .$ident
//		            pushDeprecatedWarnNoReplacement(lip.mThd, "$ as the first character of an unquoted identifier");
						LOGGER.warn("$ as the first character of an unquoted identifier");
				} else // Probably ` or "
					lip.nextState = MyLexStates.MY_LEX_START;

				return ((int) c);

			case MY_LEX_NUMBER_IDENT: // number or ident which num-start
				if (lip.yyGetLast() == '0') {
					c = lip.yyGet();
					if (c == 'x') {
						while (Character.isDigit(c = lip.yyGet()))
							;
						if ((lip.yyLength() >= 3) && !identMap[c]) {
							/* skip '0x' */
							yylval.lexStr = getToken(lip, 2, lip.yyLength() - 2);
							return (HEX_NUM);
						}
						lip.yyUnget();
						state = MyLexStates.MY_LEX_IDENT_START;
						break;
					} else if (c == 'b') {
						while ((c = lip.yyGet()) == '0' || c == '1')
							;
						if ((lip.yyLength() >= 3) && !identMap[c]) {
							/* Skip '0b' */
							yylval.lexStr = getToken(lip, 2, lip.yyLength() - 2);
							return (BIN_NUM);
						}
						lip.yyUnget();
						state = MyLexStates.MY_LEX_IDENT_START;
						break;
					}
					lip.yyUnget();
				}

				while (Character.isDigit(c = lip.yyGet()))
					;
				if (!identMap[c]) { // Can't be identifier
					state = MyLexStates.MY_LEX_INT_OR_REAL;
					break;
				}
				if (c == 'e' || c == 'E') {
					// The following test is written this way to allow numbers of type 1e1
					if (Character.isDigit(lip.yyPeek()) || (c = (lip.yyGet())) == '+' || c == '-') { // Allow 1E+10
						if (Character.isDigit(lip.yyPeek())) // Number must have digit after sign
						{
							lip.yySkip();
							while (Character.isDigit(lip.yyGet()))
								;
							yylval.lexStr = getToken(lip, 0, lip.yyLength());
							return (FLOAT_NUM);
						}
					}
					lip.yyUnget();
				}
//		        [[fallthrough]];
			case MY_LEX_IDENT_START: // We come here after '.'
				resultState = IDENT;
//		        if (useMb(cs)) {
//		          resultState = IDENT_QUOTED;
//		          while (identMap[c = lip.yyGet()]) {
//		            switch (myMbcharlen(cs, c)) {
//		              case 1:
//		                break;
//		              case 0:
//		                if (myMbmaxlenlen(cs) < 2) break;
////		                [[fallthrough]];
//		              default:
//		                int l;
//		                if ((l = myIsmbchar(cs, lip.getPtr() - 1, lip.getEndOfQuery())) == 0)
//		                  break;
//		                lip.skipBinary(l - 1);
//		            }
//		          }
//		        } else {
				for (resultState = 0; identMap[c = lip.yyGet()]; resultState |= c)
					;
				/* If there were non-ASCII characters, mark that we must convert */
				resultState = (resultState & 0x80) == 0x80 ? IDENT_QUOTED : IDENT;
//		        }
				if (c == '.' && identMap[lip.yyPeek()])
					lip.nextState = MyLexStates.MY_LEX_IDENT_SEP; // Next is '.'

				yylval.lexStr = getToken(lip, 0, lip.yyLength());

				lip.bodyUtf8Append(lip.mCppTextStart);

				lip.bodyUtf8AppendLiteral(thd, yylval.lexStr, lip.mCppTextEnd);

				return (resultState);

			case MY_LEX_USER_VARIABLE_DELIMITER: // Found quote char
			{
				int doubleQuotes = 0;
				char quoteChar = c; // Used char
				for (;;) {
					c = lip.yyGet();
					if (c == 0) {
						lip.yyUnget();
						return ABORT_SYM; // Unmatched quotes
					}

//		          int varLength;
//		          if ((varLength = myMbcharlen(cs, c)) == 1) {
					if (c == quoteChar) {
						if (lip.yyPeek() != quoteChar)
							break;
						c = lip.yyGet();
						doubleQuotes++;
						continue;
					}
//		          } else if (useMb(cs)) {
//		            if ((varLength = myIsmbchar(cs, lip.getPtr() - 1,
//		                                          lip.getEndOfQuery())))
//		              lip.skipBinary(varLength - 1);
//		          }
				}
				if (doubleQuotes > 0)
					yylval.lexStr = getQuotedToken(lip, 1, lip.yyLength() - doubleQuotes - 1, quoteChar);
				else
					yylval.lexStr = getToken(lip, 1, lip.yyLength() - 1);
				if (c == quoteChar)
					lip.yySkip(); // Skip end `
				lip.nextState = MyLexStates.MY_LEX_START;

				lip.bodyUtf8Append(lip.mCppTextStart);

				lip.bodyUtf8AppendLiteral(thd, yylval.lexStr, lip.mCppTextEnd);

				return (IDENT_QUOTED);
			}
			case MY_LEX_INT_OR_REAL: // Complete int or incomplete real
				if (c != '.') { // Found complete integer number.
					yylval.lexStr = getToken(lip, 0, lip.yyLength());
					return intToken(yylval.lexStr.str, (int) yylval.lexStr.length);
				}
//		        [[fallthrough]];
			case MY_LEX_REAL: // Incomplete real number
				while (Character.isDigit(c = lip.yyGet()))
					;

				if (c == 'e' || c == 'E') {
					c = lip.yyGet();
					if (c == '-' || c == '+')
						c = lip.yyGet(); // Skip sign
					if (!Character.isDigit(c)) { // No digit after sign
						state = MyLexStates.MY_LEX_CHAR;
						break;
					}
					while (Character.isDigit(lip.yyGet()))
						;
					yylval.lexStr = getToken(lip, 0, lip.yyLength());
					return (FLOAT_NUM);
				}
				yylval.lexStr = getToken(lip, 0, lip.yyLength());
				return (DECIMAL_NUM);

			case MY_LEX_HEX_NUMBER: // Found x'hexstring'
				lip.yySkip(); // Accept opening '
				while (Character.isDigit(c = lip.yyGet()))
					;
				if (c != '\'')
					return (ABORT_SYM); // Illegal hex constant
				lip.yySkip(); // Accept closing '
				length = lip.yyLength(); // Length of hexnum+3
				if ((length % 2) == 0)
					return (ABORT_SYM); // odd number of hex digits
				yylval.lexStr = getToken(lip, 2, // skip x'
						length - 3); // don't count x' and last '
				return (HEX_NUM);

			case MY_LEX_BIN_NUMBER: // Found b'bin-string'
				lip.yySkip(); // Accept opening '
				while ((c = lip.yyGet()) == '0' || c == '1')
					;
				if (c != '\'')
					return (ABORT_SYM); // Illegal hex constant
				lip.yySkip(); // Accept closing '
				length = lip.yyLength(); // Length of bin-num + 3
				yylval.lexStr = getToken(lip, 2, // skip b'
						length - 3); // don't count b' and last '
				return (BIN_NUM);

			case MY_LEX_CMP_OP: // Incomplete comparison operator
				if (stateMap[lip.yyPeek()] == MyLexStates.MY_LEX_CMP_OP || stateMap[lip.yyPeek()] == MyLexStates.MY_LEX_LONG_CMP_OP)
					lip.yySkip();
				if ((tokval = findKeyword(lip, lip.yyLength() + 1, false)) != 0) {
					lip.nextState = MyLexStates.MY_LEX_START; // Allow signed numbers
					return (tokval);
				}
				state = MyLexStates.MY_LEX_CHAR; // Something fishy found
				break;

			case MY_LEX_LONG_CMP_OP: // Incomplete comparison operator
				if (stateMap[lip.yyPeek()] == MyLexStates.MY_LEX_CMP_OP || stateMap[lip.yyPeek()] == MyLexStates.MY_LEX_LONG_CMP_OP) {
					lip.yySkip();
					if (stateMap[lip.yyPeek()] == MyLexStates.MY_LEX_CMP_OP)
						lip.yySkip();
				}
				if ((tokval = findKeyword(lip, lip.yyLength() + 1, false)) != 0) {
					lip.nextState = MyLexStates.MY_LEX_START; // Found long op
					return (tokval);
				}
				state = MyLexStates.MY_LEX_CHAR; // Something fishy found
				break;

			case MY_LEX_BOOL:
				if (c != lip.yyPeek()) {
					state = MyLexStates.MY_LEX_CHAR;
					break;
				}
				lip.yySkip();
				tokval = findKeyword(lip, 2, false); // Is a bool operator
				lip.nextState = MyLexStates.MY_LEX_START; // Allow signed numbers
				return (tokval);

			case MY_LEX_STRING_OR_DELIMITER:
				if (SystemVariables.isModeOn(SystemVariables.MODE_ANSI_QUOTES)) {
					state = MyLexStates.MY_LEX_USER_VARIABLE_DELIMITER;
					break;
				}
				/* " used for strings */
//		        [[fallthrough]];
			case MY_LEX_STRING: // Incomplete text string
				if ((yylval.lexStr.str = getText(lip, 1, 1)) != null) {
					state = MyLexStates.MY_LEX_CHAR; // Read char by char
					break;
				}
				yylval.lexStr.length = lip.yytoklen;

				lip.bodyUtf8Append(lip.mCppTextStart);

				lip.bodyUtf8AppendLiteral(thd, yylval.lexStr, lip.mCppTextEnd);

//		        lip.mUnderscoreCs = null;

				return (TEXT_STRING);

			case MY_LEX_COMMENT: // Comment
				thd.mParserState.addComment();
				while ((c = lip.yyGet()) != '\n' && c != '\0')
					;
				lip.yyUnget(); // Safety against eof
				state = MyLexStates.MY_LEX_START; // Try again
				break;
			case MY_LEX_LONG_COMMENT: /* Long C comment? */
				if (lip.yyPeek() != '*') {
					state = MyLexStates.MY_LEX_CHAR; // Probable division
					break;
				}
				thd.mParserState.addComment();
				/* Reject '/' '*', since we might need to turn off the echo */
				lip.yyUnget();

				lip.saveInCommentState();

				if (lip.yyPeekn(2) == '!') {
					lip.inComment = EnumCommentState.DISCARD_COMMENT;
					/* Accept '/' '*' '!', but do not keep this marker. */
					lip.setEcho(false);
					lip.yySkip();
					lip.yySkip();
					lip.yySkip();

					/*
					 * The special comment format is very strict: '/' '*' '!', followed by either
					 *
					 * 6 digits: 2 digits (major), 2 digits (mionr), 2 digits (dot), then a white-space character. 032302 . 3.23.2 050032 . 5.0.32 050114 . 5.1.14 100000 . 10.0.0
					 *
					 * or, if that format is not matched:
					 *
					 * 5 digits: 1 digit (major), 2 digits (minor), then 2 digits (dot). 32302 . 3.23.2 50032 . 5.0.32 50114 . 5.1.14
					 */
//		          char versionStr[7] = {0};
					char[] versionStr = new char[8];
					versionStr[7] = 0;
					if (Character.isDigit(versionStr[0] = lip.yyPeekn(0)) && Character.isDigit(versionStr[1] = lip.yyPeekn(1)) && Character.isDigit(versionStr[2] = lip.yyPeekn(2))
							&& Character.isDigit(versionStr[3] = lip.yyPeekn(3)) && Character.isDigit(versionStr[4] = lip.yyPeekn(4))) {
						if (Character.isDigit(lip.yyPeekn(5)) && Character.isWhitespace(lip.yyPeekn(6))) {
							versionStr[5] = lip.yyPeekn(5);
						} else if (!Character.isWhitespace(lip.yyPeekn(5))) {
							LOGGER.warn("ER_WARN_NO_SPACE_VERSION_COMMENT");
//		              pushWarning(thd, SqlCondition::SL_WARNING,
//		                           ER_WARN_NO_SPACE_VERSION_COMMENT,
//		                           ErThd(thd, ER_WARN_NO_SPACE_VERSION_COMMENT));
						}

//		            long version = strtol(versionStr, null, 10);
						long version;
						try {
							version = Long.parseLong(versionStr.toString());
						} catch (NumberFormatException e) {
							version = Long.parseLong(versionStr.toString().replaceFirst("^(\\d+).*", "$1"));
						}
						if (version <= mysqlVersion.value()) {
							/* Accept ('M') 'M' 'm' 'm' 'd' 'd' */
							int skipLen = 0;
							for (int i = 6; i >= 0; i--) {
								if (Character.isDigit(versionStr[i])) {
									skipLen = i + 1;
								}
							}
							lip.yySkipn(skipLen);
							/* Expand the content of the special comment as real code */
							lip.setEcho(true);
							state = MyLexStates.MY_LEX_START;
							break; /* Do not treat contents as a comment. */
						} else {
							/*
							 * Patch and skip the conditional comment to avoid it being propagated infinitely (eg. to a slave).
							 */
							char pcom = lip.yyUnput(' ');
							commentClosed = !consumeComment(lip, 1);
							if (!commentClosed) {
								pcom = '!';
							}
							/* version allowed to have one level of comment inside. */
						}
					} else {
						/* Not a version comment. */
						state = MyLexStates.MY_LEX_START;
						lip.setEcho(true);
						break;
					}
				} else {
					if (lip.inComment != EnumCommentState.NO_COMMENT) {
//		            pushWarning(
//		                lip.mThd, SqlCondition::SlWarning,
//		                ER_WARN_DEPRECATED_SYNTAX_NO_REPLACEMENT,
//		                ErThd(lip.mThd, ER_WARN_DEPRECATED_NESTED_COMMENT_SYNTAX));
						LOGGER.warn("ER_WARN_DEPRECATED_SYNTAX_NO_REPLACEMENT,ER_WARN_DEPRECATED_NESTED_COMMENT_SYNTAX");
					}
					lip.inComment = EnumCommentState.PRESERVE_COMMENT;
					lip.yySkip(); // Accept /
					lip.yySkip(); // Accept *
					commentClosed = !consumeComment(lip, 0);
					/* regular comments can have zero comments inside. */
				}
				/*
				 * Discard: - regular '/' '*' comments, - special comments '/' '*' '!' for a future version, by scanning until we find a closing '*' '/' marker.
				 *
				 * Nesting regular comments isn't allowed. The first '*' '/' returns the parser to the previous state.
				 *
				 * /#!VERSI oned containing /# regular #/ is allowed #/
				 *
				 * Inside one versioned comment, another versioned comment is treated as a regular discardable comment. It gets no special parsing.
				 */

				/* Unbalanced comments with a missing '*' '/' are a syntax error */
				if (!commentClosed)
					return (ABORT_SYM);
				state = MyLexStates.MY_LEX_START; // Try again
				lip.restoreInCommentState();
				break;
			case MY_LEX_END_LONG_COMMENT:
				if ((lip.inComment != EnumCommentState.NO_COMMENT) && lip.yyPeek() == '/') {
					/* Reject '*' '/' */
					lip.yyUnget();
					/* Accept '*' '/', with the proper echo */
					lip.setEcho(lip.inComment == EnumCommentState.PRESERVE_COMMENT);
					lip.yySkipn(2);
					/* And start recording the tokens again */
					lip.setEcho(true);

					/*
					 * C-style comments are replaced with a single space (as it is in C and C++). If there is already a whitespace character at this point in the stream, the space
					 * is not inserted.
					 *
					 * See also ISO/IEC 9899:1999 §5.1.1.2 ("Programming languages — C")
					 */
//		          if (!myIsspace(cs, lip.yyPeek()) &&
//		              lip.getCppPtr() != lip.getCppBuf() &&
//		              !myIsspace(cs, *(lip.getCppPtr() - 1)))
//		            lip.cppInject(' ');

					lip.inComment = EnumCommentState.NO_COMMENT;
					state = MyLexStates.MY_LEX_START;
				} else
					state = MyLexStates.MY_LEX_CHAR; // Return '*'
				break;
			case MY_LEX_SET_VAR: // Check if ':='
				if (lip.yyPeek() != '=') {
					state = MyLexStates.MY_LEX_CHAR; // Return ':'
					break;
				}
				lip.yySkip();
				return (SET_VAR);
			case MY_LEX_SEMICOLON: // optional line terminator
				state = MyLexStates.MY_LEX_CHAR; // Return ';'
				break;
			case MY_LEX_EOL:
				if (lip.eof()) {
					lip.yyUnget(); // Reject the last '\0'
					lip.setEcho(false);
					lip.yySkip();
					lip.setEcho(true);
					/* Unbalanced comments with a missing '*' '/' are a syntax error */
					if (lip.inComment != EnumCommentState.NO_COMMENT)
						return (ABORT_SYM);
					lip.nextState = MyLexStates.MY_LEX_END; // Mark for next loop
					return (END_OF_INPUT);
				}
				state = MyLexStates.MY_LEX_CHAR;
				break;
			case MY_LEX_END:
				lip.nextState = MyLexStates.MY_LEX_END;
				return (0); // We found end of input last time

			/* Actually real shouldn't start with . but allow them anyhow */
			case MY_LEX_REAL_OR_POINT:
				if (Character.isDigit(lip.yyPeek()))
					state = MyLexStates.MY_LEX_REAL; // Real
				else {
					state = MyLexStates.MY_LEX_IDENT_SEP; // return '.'
					lip.yyUnget(); // Put back '.'
				}
				break;
			case MY_LEX_USER_END: // end '@' of user@hostname
				switch (stateMap[lip.yyPeek()]) {
				case MY_LEX_STRING:
				case MY_LEX_USER_VARIABLE_DELIMITER:
				case MY_LEX_STRING_OR_DELIMITER:
					break;
				case MY_LEX_USER_END:
					lip.nextState = MyLexStates.MY_LEX_SYSTEM_VAR;
					break;
				default:
					lip.nextState = MyLexStates.MY_LEX_HOSTNAME;
					break;
				}
				yylval.lexStr.str = String.valueOf(lip.p2c(lip.getPtr()));
				yylval.lexStr.length = 1;
				return ((int) '@');
			case MY_LEX_HOSTNAME: // end '@' of user@hostname
				for (c = lip.yyGet(); lip.myIsalnum(c) || c == '.' || c == '_' || c == '$'; c = lip.yyGet())
					;
				yylval.lexStr = getToken(lip, 0, lip.yyLength());
				return (LEX_HOSTNAME);
			case MY_LEX_SYSTEM_VAR:
				yylval.lexStr.str = String.valueOf(lip.p2c(lip.getPtr()));
				yylval.lexStr.length = 1;
				lip.yySkip(); // Skip '@'
				lip.nextState = (stateMap[lip.yyPeek()] == MyLexStates.MY_LEX_USER_VARIABLE_DELIMITER ? MyLexStates.MY_LEX_START : MyLexStates.MY_LEX_IDENT_OR_KEYWORD);
				return ((int) '@');
			case MY_LEX_IDENT_OR_KEYWORD:
				/*
				 * We come here when we have found two '@' in a row. We should now be able to handle: [(global | local | session) .]variableName
				 */

				for (resultState = 0; identMap[c = lip.yyGet()]; resultState |= c)
					;
				/* If there were non-ASCII characters, mark that we must convert */
				resultState = (resultState & 0x80) == 0x80 ? IDENT_QUOTED : IDENT;

				if (c == '.')
					lip.nextState = MyLexStates.MY_LEX_IDENT_SEP;
				length = lip.yyLength();
				if (length == 0)
					return (ABORT_SYM); // Names must be nonempty.
				if ((tokval = findKeyword(lip, length, false)) != 0) {
					lip.yyUnget(); // Put back 'c'
					return (tokval); // Was keyword
				}
				yylval.lexStr = getToken(lip, 0, length);

				lip.bodyUtf8Append(lip.mCppTextStart);

				lip.bodyUtf8AppendLiteral(thd, yylval.lexStr, lip.mCppTextEnd);

				return (resultState);

			case MY_LEX_IDENT_OR_DOLLAR_QUOTED_TEXT: {
				int len = 0; /* Length of the tag of the dollar quote */
				char p = lip.yyPeek(); /* Character succeeding first $ */
				// Find $ character after the tag
				while (p != '$' && identMap[p] && lip.getPtr() + len <= lip.getEndOfQuery()) {
//		          if (useMb(cs)) {
//		            int l =
//		                myIsmbchar(cs, lip.getPtr() + len, lip.getEndOfQuery());
//		            if (l > 1) len += l - 1;
//		          }
					p = lip.yyPeekn(++len);
				}

				if (p != '$') { /* Not a dollar quote, could be an identifier */
//		          pushDeprecatedWarnNoReplacement(lip.mThd, "$ as the first character of an unquoted identifier");
					LOGGER.warn("$ as the first character of an unquoted identifier");
					state = MyLexStates.MY_LEX_IDENT;
					break;
				} else {
					LexString text = getDollarQuotedText(lip, len);
					if (text == null || text.isEmpty())
						return ABORT_SYM; // error: unterminated text
					else {
//		            yylval.lexStr.str = constCast<char *>(text.str);
						yylval.lexStr.str = text.str;
						yylval.lexStr.length = text.length;

						lip.bodyUtf8Append(text.pos);
						lip.bodyUtf8AppendLiteral(thd, yylval.lexStr, text.pos + text.length);

						return DOLLAR_QUOTED_STRING_SYM; // $$ ... $$
					}
				}
			}
			}
		}
	}

	private String getText(LexInputStream lip, int preSkip, int postSkip) {
		char c, sep;
		boolean foundEscape = false;
//		  const CHARSET_INFO *cs = lip.m_thd.charset();

		lip.tokBitmap = 0;
		sep = lip.yyGetLast(); // String should end with this
		while (!lip.eof()) {
			c = lip.yyGet();
			lip.tokBitmap |= c;
			if (c == '\\' && !((SystemVariables.sqlMode & SystemVariables.MODE_NO_BACKSLASH_ESCAPES) == SystemVariables.MODE_NO_BACKSLASH_ESCAPES)) { // Escaped
																																						// character
				foundEscape = true;
				if (lip.eof())
					return null;
				lip.yySkip();
			} else if (c == sep) {
				if (c == lip.yyGet()) // Check if two separators in a row
				{
					foundEscape = true; // duplicate. Remember for delete
					continue;
				} else
					lip.yyUnget();

				/* Found end. Unescape and return string */
				int str, end;
				String start;

				str = lip.getTokStart();
				end = lip.getPtr();
				/* Extract the text from the token */
				str += preSkip;
				end -= postSkip;

				lip.mCppTextStart = lip.getCppTokStart() + preSkip;
				lip.mCppTextEnd = lip.getCppPtr() - postSkip;

				if (!foundEscape) {
					lip.yytoklen = end - str;
					start = lip.sqlBuf.substring(str, end);
				} else {
					char[] to = new char[end - str];
					int i;
					for (i = 0; str != end; str++) {
						if (!(SystemVariables.isModeOn(SystemVariables.MODE_NO_BACKSLASH_ESCAPES)) && str == '\\' && str + 1 != end) {
							switch (++str) {
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
							default:
								to[i++] = lip.sqlBuf.charAt(str);
								break;
							}
						} else if (lip.sqlBuf.charAt(str) == sep)
							to[i++] = lip.sqlBuf.charAt(str++); // Two ' or "
						else
							to[i++] = lip.sqlBuf.charAt(str);
					}
					to[i] = 0;
					lip.yytoklen = (start = new String(to)).length();
				}
				return start;
			}
		}
		return null; // unexpected end of query
	}

	/**
	 * Convert from /sql/sql_lex_hash.cc, /sql/lex_symbol.h, /sql/gen_lex_hash.cc..., Function add_digest_token from /sql/sql_digest.cc
	 *
	 * @param lip
	 * @param len
	 * @param function whether include function keywords
	 * @return
	 */
	private int findKeyword(LexInputStream lip, int len, boolean function) {
//		  int tok = lip.getTokStart();
		String tokStr = lip.sqlBuf.substring(lip.getTokStart(), lip.getTokStart() + len);
		Symbol symbol = LexHash.getHashSymbol(tokStr, function);
//		  Integer symbol = (symbolInstance == null ? null : symbolInstance.tok);

		if (symbol != null) {
			lip.yylval = new LexerYystype(new LexString(tokStr, lip.getTokStart()), new LexSymbol(symbol.tok, symbol.name, symbol.length));

			if ((symbol.tok == NOT_SYM) && (SystemVariables.isModeOn(SystemVariables.MODE_HIGH_NOT_PRECEDENCE)))
				return NOT2_SYM;
			if ((symbol.tok == OR_OR_SYM) && !(SystemVariables.isModeOn(SystemVariables.MODE_PIPES_AS_CONCAT))) {
//		      push_deprecated_warn(lip.mThd, "|| as a synonym for OR", "OR");
				return OR2_SYM;
			}

			lip.yylval.optimizerHints = null;
			if ((symbol.group & Symbol.SG_HINTABLE_KEYWORDS) == Symbol.SG_HINTABLE_KEYWORDS) {
				lip.addDigestToken(symbol.tok, lip.yylval);
				if (consumeOptimizerHints(lip))
					return ABORT_SYM;
				lip.skipDigest = true;
			}

			return symbol.tok;
		}
		return 0;
	}

	/**
	 * function my_hint_parser_parse = yyparse from /src/sql/sql_hints.yy.cc HintScanner from /sql/sql_lex_hints.h, /sql/sql_lex_hints.cc
	 *
	 * @param lip
	 * @return true is failed, false is successful.
	 */
	private boolean consumeOptimizerHints(LexInputStream lip) {
		MyLexStates[] stateMap = LexStateMapsSt.mainMap;
		int whitespace = 0;
		char c = lip.yyPeek();
		int newlines = 0;

		for (; stateMap[c] == MyLexStates.MY_LEX_SKIP; whitespace++, c = lip.yyPeekn(whitespace)) {
			if (c == '\n')
				newlines++;
		}

		if (lip.yyPeekn(whitespace) == '/' && lip.yyPeekn(whitespace + 1) == '*' && lip.yyPeekn(whitespace + 2) == '+') {
			lip.yylineno += newlines;
			lip.yySkipn(whitespace); // skip whitespace

			HintScanner hintScanner = new HintScanner(lip.mThd, lip.yylineno, lip.getPtr(), lip.getEndOfQuery() - lip.getPtr(), lip.mDigest);
			List<Integer> hintList = new ArrayList<Integer>();
			SQLHintsParser shParser = new SQLHintsParser(lip.mThd, hintScanner, hintList);
//			int rc = my_hint_parser_parse(this, lip.mThd, hintScanner, hintList);
			boolean rc;
			try {
				rc = shParser.parse();
				if (!rc) {
					/*
					 * This branch is for 2 cases: 1. YYABORT in the hint parser grammar (we use it to process OOM errors), 2. open commentary error.
					 */
					lip.startToken(); // adjust error message text pointer to "/*+"
					return true;
				}
//			lip.yylineno = hintScanner.getLineno();
				lip.yySkipn(hintScanner.getPtr() - lip.getPtr());
				lip.yylval.optimizerHints = hintList; // Null in case of syntax error
				lip.mDigest = hintScanner.getDigest(); // Null is digest buf. is full.
				return false;
			} catch (IOException e) {
				return true;
			}
		} else
			return false;
	}

	/**
	 * make a copy of token before ptr and set yytoklen
	 *
	 * @param lip
	 * @param skip
	 * @param length
	 * @return
	 */
	private LexString getToken(LexInputStream lip, int skip, int length) {
		LexString tmp = new LexString();
		lip.yyUnget(); // ptr points now after last token char
		tmp.length = lip.yytoklen = length;
//		tmp.str = lip.mThd.strmake(lip.getTokStart() + skip, tmp.length);
		tmp.str = lip.sqlBuf.substring(lip.getTokStart() + skip, lip.getTokStart() + skip + length);
		lip.mCppTextStart = lip.getCppTokStart() + skip;
		lip.mCppTextEnd = lip.mCppTextStart + tmp.length;
		tmp.pos = lip.mCppTextStart;
		return tmp;
	}

	private LexString getQuotedToken(LexInputStream lip, int skip, int length, char quote) {
		LexString tmp = new LexString();
		int from, end;
		StringBuilder to = new StringBuilder();
		lip.yyUnget(); // ptr points now after last token char
		tmp.length = lip.yytoklen = length;
//		tmp.str = (char *)lip.m_thd.alloc(tmp.length + 1);
		from = lip.getTokStart() + skip;
//		to = tmp.str;
		end = from + length;

		lip.mCppTextStart = lip.getCppTokStart() + skip;
		lip.mCppTextEnd = lip.mCppTextStart + length;

		for (int i = from; i < end; i++) {
			char c = lip.sqlBuf.charAt(i);
			if (c == quote) {
				lip.mCppTextStart++;
				continue;
			} else {
				to.append(c);
			}
		}
		tmp.str = to.toString();
//		*to = 0;  // End null for safety
		return tmp;
	}

	private int intToken(String str, int length) {
		if (length < LONG_LEN) // quick normal case
			return NUM;
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
			return NUM;

		int smaller, bigger;
		String cmp;
		if (neg) {
			if (length == LONG_LEN) {
				cmp = SIGNED_LONG_STR.substring(1);
				smaller = NUM; // If <= signed_long_str
				bigger = LONG_NUM; // If >= signed_long_str
			} else if (length < SIGNED_LONGLONG_LEN)
				return LONG_NUM;
			else if (length > SIGNED_LONGLONG_LEN)
				return DECIMAL_NUM;
			else {
				cmp = SIGNED_LONGLONG_STR.substring(1);
				smaller = LONG_NUM; // If <= signed_longlong_str
				bigger = DECIMAL_NUM;
			}
		} else {
			if (length == LONG_LEN) {
				cmp = LONG_STR;
				smaller = NUM;
				bigger = LONG_NUM;
			} else if (length < LONGLONG_LEN)
				return LONG_NUM;
			else if (length > LONGLONG_LEN) {
				if (length > UNSIGNED_LONGLONG_LEN)
					return DECIMAL_NUM;
				cmp = UNSIGNED_LONGLONG_STR;
				smaller = ULONGLONG_NUM;
				bigger = DECIMAL_NUM;
			} else {
				cmp = LONGLONG_STR;
				smaller = LONG_NUM;
				bigger = ULONGLONG_NUM;
			}
		}
		int offset = 0;
		while (cmp.charAt(offset) != '\0' && cmp.charAt(offset) == str.charAt(offset)) {
			offset++;
		}
		return str.charAt(offset) <= cmp.charAt(offset) ? smaller : bigger;
	}

	/**
	 * Given a stream that is advanced to the first contained character in an open comment, consume the comment. Optionally, if we are allowed, recurse so that we
	 * understand comments within this current comment.
	 *
	 * At this level, we do not support version-condition comments. We might have been called with having just passed one in the stream, though. In that case, we
	 * probably want to tolerate mundane comments inside. Thus, the case for recursion.
	 *
	 * @retval Whether EOF reached before comment is closed.
	 */
	private boolean consumeComment(LexInputStream lip, int remainingRecursionsPermitted) {
		// only one level of nested comments are allowed
//	  assert(remainingRecursionsPermitted == 0 ||
//	         remainingRecursionsPermitted == 1);
		if (remainingRecursionsPermitted == 0 || remainingRecursionsPermitted == 1) {
			char c;
			while (!lip.eof()) {
				c = lip.yyGet();

				if (remainingRecursionsPermitted == 1) {
					if ((c == '/') && (lip.yyPeek() == '*')) {
//					  push_warning(
//							  lip.m_thd, Sql_condition::SL_WARNING,
//							  ER_WARN_DEPRECATED_SYNTAX_NO_REPLACEMENT,
//							  ER_THD(lip.m_thd, ER_WARN_DEPRECATED_NESTED_COMMENT_SYNTAX));
						LOGGER.warn("ER_WARN_DEPRECATED_SYNTAX_NO_REPLACEMENT,ER_WARN_DEPRECATED_NESTED_COMMENT_SYNTAX");
						lip.yyUnput('('); // Replace nested "/*..." with "(*..."
						lip.yySkip(); // and skip "("
						lip.yySkip(); /* Eat asterisk */
						if (consumeComment(lip, 0))
							return true;
						lip.yyUnput(')'); // Replace "...*/" with "...*)"
						lip.yySkip(); // and skip ")"
						continue;
					}
				}

				if (c == '*') {
					if (lip.yyPeek() == '/') {
						lip.yySkip(); /* Eat slash */
						return false;
					}
				}

				if (c == '\n')
					lip.yylineno++;
			}

			return true;
		} else {
			return false;
		}
	}

	enum DollarQuotedState {
		TEXT_BODY, RIGHT_DELIMITER
	}

	/**
	 * Get the text literal between dollar quotes.
	 *
	 * A dollar quote is of the form $tag$, where tag is zero or more characters. The same characters that are permitted for unquoted identifiers, except dollar,
	 * may be used for the tag. That is, basic ASCII letters, digits 0-9, underscore, and any multibyte UTF8 characters.
	 *
	 * @param lip     The input stream. When called, the current position is right after the initial dollar character
	 * @param tag_len The length of the tag
	 *
	 * @returns The text literal without dollar quotes
	 */
	private LexString getDollarQuotedText(LexInputStream lip, int tagLen) {
		LexString ret = null;
//	  assert(lip.yyGetLast() == '$' && !lip.eof());
		if (lip.yyGetLast() == '$' && !lip.eof()) {
//		  const CHARSET_INFO *cs = lip.mThd.charset();
			int leftDelim = lip.getTokStart();
			lip.yySkipn(tagLen + 1); // skip beyond the 2nd '$'
			DollarQuotedState state = DollarQuotedState.TEXT_BODY;
			int bodyStart = lip.getCppPtr();
			int delimPos = 0; // Position during delimiter matching
			while (!lip.eof()) {
				char c = lip.yyGet();
				switch (state) {
				case TEXT_BODY:
//					if (use_mb(cs)) {
//						int mb_len = my_ismbchar(cs, lip.getPtr() - 1, lip.getEndOfQuery());
//						if (mb_len > 1) {
//							lip.skipBinary(mb_len - 1);
//							break;
//						}
//					}
					if (c == '$') {
						state = DollarQuotedState.RIGHT_DELIMITER;
					}
					break;

				case RIGHT_DELIMITER:
					if (c == lip.p2c(leftDelim + (++delimPos))) {
						if (delimPos == tagLen + 1) {
							int length = lip.getCppPtr() - bodyStart - tagLen - 2;
							return new LexString(lip.sqlBuf.substring(bodyStart, bodyStart + length), bodyStart);
						}
					} else { // Not a right delimiter after all
						state = DollarQuotedState.TEXT_BODY;
						delimPos = 0;
					}
					break;
				}
			}
//		  assert(lip.eof());
			if (lip.eof()) {
				ret = new LexString();
			}
		}
		return ret;
	}
}
