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
	LexStateMapsSt stateMaps;

	public MyLexer() {
		stateMaps = new LexStateMapsSt();
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
			 * Parsing 'WITH' 'ROLLUP' requires 2 look ups, which makes the grammar LALR(2).
			 * Replace by a single 'WithRollup' token, to transform the grammar into a
			 * LALR(1) grammar, which sqlYacc.yy can process.
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

	private int lexOneToken(Item yylval, SQLThread thd) {
		  char c = 0;
		  boolean commentClosed;
		  int tokval, resultState;
		  int length;
		  MyLexStates state;
		  LexInputStream lip = thd.mParserState.mLip;
		  MyLexStates[] stateMap = stateMaps.mainMap;
		  boolean[] identMap = stateMaps.identMap;

		  lip.yylval = yylval;  // The global state

		  lip.startToken();
		  state = lip.nextState;
		  lip.nextState = MyLexStates.MY_LEX_START;
		  for (;;) {
		    switch (state) {
		      case MY_LEX_START:  // Start of token
		        // Skip starting whitespace
		        while (stateMap[c = lip.yypeek()] == MyLexSkip) {
		          if (c == '\n') lip.yylineno++;

		          lip.yy_skip();
		        }

		        /* Start of real token */
		        lip.restartToken();
		        c = lip.yy_get();
		        state = stateMap[c];
		        break;
		      case MyLexChar:  // Unknown or single char token
		      case MyLexSkip:  // This should not happen
		        if (c == '-' && lip.yy_peek() == '-' &&
		            (myIsspace(cs, lip.yypeekn(1)) ||
		             myIscntrl(cs, lip.yypeekn(1)))) {
		          state = MY_LEX_COMMENT;
		          break;
		        }

		        if (c == '-' && lip.yy_peek() == '>')  // '.'
		        {
		          lip.yy_skip();
		          lip.nextState = MyLexStart;
		          if (lip.yy_peek() == '>') {
		            lip.yy_skip();
		            return JsonUnquotedSeparatorSym;
		          }
		          return JsonSeparatorSym;
		        }

		        if (c != ')') lip.nextState = MyLexStart;  // Allow signed numbers

		        /*
		          Check for a placeholder: it should not precede a possible identifier
		          because of binlogging: when a placeholder is replaced with its value
		          in a query for the binlog, the query must stay grammatically correct.
		        */
		        if (c == '?' && lip.stmtPrepareMode && !identMap[lip.yypeek()])
		          return (ParamMarker);

		        return ((int)c);

		      case MyLexIdentOrNchar:
		        if (lip.yy_peek() != '\'') {
		          state = MyLexIdent;
		          break;
		        }
		        /* Found N'string' */
		        lip.yy_skip();  // Skip '
		        if (!(yylval.lexStr.str = getText(lip, 2, 1))) {
		          state = MyLexChar;  // Read char by char
		          break;
		        }
		        yylval.lexStr.length = lip.yytoklen;
		        return (NcharString);

		      case MyLexIdentOrHex:
		        if (lip.yy_peek() == '\'') {  // Found x'hex-number'
		          state = MyLexHexNumber;
		          break;
		        }
		        [[fallthrough]];
		      case MyLexIdentOrBin:
		        if (lip.yy_peek() == '\'') {  // Found b'bin-number'
		          state = MyLexBinNumber;
		          break;
		        }
		        [[fallthrough]];
		      case MyLexIdent:
		        const char *start;
		        if (useMb(cs)) {
		          resultState = IdentQuoted;
		          switch (myMbcharlen(cs, lip.yygetlast())) {
		            case 1:
		              break;
		            case 0:
		              if (myMbmaxlenlen(cs) < 2) break;
		              [[fallthrough]];
		            default:
		              const int l =
		                  myIsmbchar(cs, lip.getPtr() - 1, lip.getEndOfQuery());
		              if (l == 0) {
		                state = MyLexChar;
		                continue;
		              }
		              lip.skipBinary(l - 1);
		          }
		          while (identMap[c = lip.yyget()]) {
		            switch (myMbcharlen(cs, c)) {
		              case 1:
		                break;
		              case 0:
		                if (myMbmaxlenlen(cs) < 2) break;
		                [[fallthrough]];
		              default:
		                int l;
		                if ((l = myIsmbchar(cs, lip.getPtr() - 1,
		                                     lip.getEndOfQuery())) == 0)
		                  break;
		                lip.skipBinary(l - 1);
		            }
		          }
		        } else {
		          for (resultState = c; identMap[c = lip.yyget()]; resultState |= c)
		            ;
		          /* If there were non-ASCII characters, mark that we must convert */
		          resultState = resultState & 0x80 ? IdentQuoted : Ident;
		        }
		        length = lip.yy_length();
		        start = lip.getPtr();
		        if (lip.ignoreSpace) {
		          /*
		            If we find a space then this can't be an identifier. We notice this
		            below by checking start != lex.ptr.
		          */
		          for (; stateMap[c] == MyLexSkip; c = lip.yyget()) {
		            if (c == '\n') lip.yylineno++;
		          }
		        }
		        if (start == lip.getPtr() && c == '.' && identMap[lip.yypeek()])
		          lip.nextState = MyLexIdentSep;
		        else {  // '(' must follow directly if function
		          lip.yy_unget();
		          if ((tokval = findKeyword(lip, length, c == '('))) {
		            lip.nextState = MyLexStart;  // Allow signed numbers
		            return (tokval);                 // Was keyword
		          }
		          lip.yy_skip();  // next state does a unget
		        }
		        yylval.lexStr = getToken(lip, 0, length);

		        /*
		           Note: "Select Bla As 'alias'"
		           Bla should be considered as a Ident if charset haven't been found.
		           So we don't want to produce any warning in findPrimary.
		        */

		        if (yylval.lexStr.str[0] == '_') {
		          auto charsetName = yylval.lexStr.str + 1;
		          const CharsetInfo *underscoreCs =
		              mysql::collation::findPrimary(charsetName);
		          if (underscoreCs) {
		            lip.warnOnDeprecatedCharset(underscoreCs, charsetName);
		            if (underscoreCs == &myCharsetUtf8mb40900AiCi) {
		              /*
		                If underscoreCs is utf8mb4, and the collation of underscoreCs
		                is the default collation of utf8mb4, then update underscoreCs
		                with a value of the defaultCollationForUtf8mb4 system
		                variable:
		              */
		              underscoreCs = thd.variables.defaultCollationForUtf8mb4;
		            }
		            yylval.charset = underscoreCs;
		            lip.mUnderscoreCs = underscoreCs;

		            lip.bodyUtf8Append(lip.mCppTextStart,
		                                  lip.getCppTokStart() + length);
		            return (UnderscoreCharset);
		          }
		        }

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (resultState);  // Ident or IdentQuoted

		      case MyLexIdentSep:  // Found ident and now '.'
		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
		        yylval.lexStr.length = 1;
		        c = lip.yy_get();  // should be '.'
		        if (const uchar nextC = lip.yypeek(); identMap[nextC]) {
		          lip.nextState =
		              MyLexIdentStart;  // Next is an ident (not a keyword)
		          if (nextC == '$')       // We got .$ident
		            pushDeprecatedWarnNoReplacement(
		                lip.mThd,
		                "$ as the first character of an unquoted identifier");
		        } else  // Probably ` or "
		          lip.nextState = MyLexStart;

		        return ((int)c);

		      case MyLexNumberIdent:  // number or ident which num-start
		        if (lip.yy_get_last() == '0') {
		          c = lip.yy_get();
		          if (c == 'x') {
		            while (myIsxdigit(cs, (c = lip.yyget())))
		              ;
		            if ((lip.yylength() >= 3) && !identMap[c]) {
		              /* skip '0x' */
		              yylval.lexStr = getToken(lip, 2, lip.yylength() - 2);
		              return (HexNum);
		            }
		            lip.yy_unget();
		            state = MyLexIdentStart;
		            break;
		          } else if (c == 'b') {
		            while ((c = lip.yy_get()) == '0' || c == '1')
		              ;
		            if ((lip.yylength() >= 3) && !identMap[c]) {
		              /* Skip '0b' */
		              yylval.lexStr = getToken(lip, 2, lip.yylength() - 2);
		              return (BinNum);
		            }
		            lip.yy_unget();
		            state = MyLexIdentStart;
		            break;
		          }
		          lip.yy_unget();
		        }

		        while (myIsdigit(cs, (c = lip.yyget())))
		          ;
		        if (!identMap[c]) {  // Can't be identifier
		          state = MyLexIntOrReal;
		          break;
		        }
		        if (c == 'e' || c == 'E') {
		          // The following test is written this way to allow numbers of type 1e1
		          if (myIsdigit(cs, lip.yypeek()) || (c = (lip.yyget())) == '+' ||
		              c == '-') {  // Allow 1E+10
		            if (myIsdigit(cs,
		                           lip.yy_peek()))  // Number must have digit after sign
		            {
		              lip.yy_skip();
		              while (myIsdigit(cs, lip.yyget()))
		                ;
		              yylval.lexStr = getToken(lip, 0, lip.yylength());
		              return (FloatNum);
		            }
		          }
		          lip.yy_unget();
		        }
		        [[fallthrough]];
		      case MyLexIdentStart:  // We come here after '.'
		        resultState = Ident;
		        if (useMb(cs)) {
		          resultState = IdentQuoted;
		          while (identMap[c = lip.yyget()]) {
		            switch (myMbcharlen(cs, c)) {
		              case 1:
		                break;
		              case 0:
		                if (myMbmaxlenlen(cs) < 2) break;
		                [[fallthrough]];
		              default:
		                int l;
		                if ((l = myIsmbchar(cs, lip.getPtr() - 1,
		                                     lip.getEndOfQuery())) == 0)
		                  break;
		                lip.skipBinary(l - 1);
		            }
		          }
		        } else {
		          for (resultState = 0; identMap[c = lip.yyget()]; resultState |= c)
		            ;
		          /* If there were non-ASCII characters, mark that we must convert */
		          resultState = resultState & 0x80 ? IdentQuoted : Ident;
		        }
		        if (c == '.' && identMap[lip.yypeek()])
		          lip.nextState = MyLexIdentSep;  // Next is '.'

		        yylval.lexStr = getToken(lip, 0, lip.yylength());

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (resultState);

		      case MyLexUserVariableDelimiter:  // Found quote char
		      {
		        uint doubleQuotes = 0;
		        const char quoteChar = c;  // Used char
		        for (;;) {
		          c = lip.yy_get();
		          if (c == 0) {
		            lip.yy_unget();
		            return AbortSym;  // Unmatched quotes
		          }

		          int varLength;
		          if ((varLength = myMbcharlen(cs, c)) == 1) {
		            if (c == quoteChar) {
		              if (lip.yypeek() != quoteChar) break;
		              c = lip.yy_get();
		              doubleQuotes++;
		              continue;
		            }
		          } else if (useMb(cs)) {
		            if ((varLength = myIsmbchar(cs, lip.getPtr() - 1,
		                                          lip.getEndOfQuery())))
		              lip.skipBinary(varLength - 1);
		          }
		        }
		        if (doubleQuotes)
		          yylval.lexStr = getQuotedToken(
		              lip, 1, lip.yylength() - doubleQuotes - 1, quoteChar);
		        else
		          yylval.lexStr = getToken(lip, 1, lip.yylength() - 1);
		        if (c == quoteChar) lip.yyskip();  // Skip end `
		        lip.nextState = MyLexStart;

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (IdentQuoted);
		      }
		      case MyLexIntOrReal:  // Complete int or incomplete real
		        if (c != '.') {         // Found complete integer number.
		          yylval.lexStr = getToken(lip, 0, lip.yylength());
		          return intToken(yylval.lexStr.str, (uint)yylval.lexStr.length);
		        }
		        [[fallthrough]];
		      case MyLexReal:  // Incomplete real number
		        while (myIsdigit(cs, c = lip.yyget()))
		          ;

		        if (c == 'e' || c == 'E') {
		          c = lip.yy_get();
		          if (c == '-' || c == '+') c = lip.yy_get();  // Skip sign
		          if (!myIsdigit(cs, c)) {                    // No digit after sign
		            state = MyLexChar;
		            break;
		          }
		          while (myIsdigit(cs, lip.yyget()))
		            ;
		          yylval.lexStr = getToken(lip, 0, lip.yylength());
		          return (FloatNum);
		        }
		        yylval.lexStr = getToken(lip, 0, lip.yylength());
		        return (DecimalNum);

		      case MyLexHexNumber:  // Found x'hexstring'
		        lip.yy_skip();         // Accept opening '
		        while (myIsxdigit(cs, (c = lip.yyget())))
		          ;
		        if (c != '\'') return (AbortSym);          // Illegal hex constant
		        lip.yy_skip();                              // Accept closing '
		        length = lip.yy_length();                   // Length of hexnum+3
		        if ((length % 2) == 0) return (AbortSym);  // odd number of hex digits
		        yylval.lexStr = getToken(lip,
		                                    2,            // skip x'
		                                    length - 3);  // don't count x' and last '
		        return (HexNum);

		      case MyLexBinNumber:  // Found b'bin-string'
		        lip.yy_skip();         // Accept opening '
		        while ((c = lip.yy_get()) == '0' || c == '1')
		          ;
		        if (c != '\'') return (AbortSym);  // Illegal hex constant
		        lip.yy_skip();                      // Accept closing '
		        length = lip.yy_length();           // Length of bin-num + 3
		        yylval.lexStr = getToken(lip,
		                                    2,            // skip b'
		                                    length - 3);  // don't count b' and last '
		        return (BinNum);

		      case MyLexCmpOp:  // Incomplete comparison operator
		        if (stateMap[lip.yypeek()] == MyLexCmpOp ||
		            stateMap[lip.yypeek()] == MyLexLongCmpOp)
		          lip.yy_skip();
		        if ((tokval = findKeyword(lip, lip.yylength() + 1, false))) {
		          lip.nextState = MyLexStart;  // Allow signed numbers
		          return (tokval);
		        }
		        state = MyLexChar;  // Something fishy found
		        break;

		      case MyLexLongCmpOp:  // Incomplete comparison operator
		        if (stateMap[lip.yypeek()] == MyLexCmpOp ||
		            stateMap[lip.yypeek()] == MyLexLongCmpOp) {
		          lip.yy_skip();
		          if (stateMap[lip.yypeek()] == MyLexCmpOp) lip.yyskip();
		        }
		        if ((tokval = findKeyword(lip, lip.yylength() + 1, false))) {
		          lip.nextState = MyLexStart;  // Found long op
		          return (tokval);
		        }
		        state = MyLexChar;  // Something fishy found
		        break;

		      case MyLexBool:
		        if (c != lip.yy_peek()) {
		          state = MyLexChar;
		          break;
		        }
		        lip.yy_skip();
		        tokval = findKeyword(lip, 2, false);  // Is a bool operator
		        lip.nextState = MyLexStart;        // Allow signed numbers
		        return (tokval);

		      case MyLexStringOrDelimiter:
		        if (thd.variables.sqlMode & ModeAnsiQuotes) {
		          state = MyLexUserVariableDelimiter;
		          break;
		        }
		        /* " used for strings */
		        [[fallthrough]];
		      case MyLexString:  // Incomplete text string
		        if (!(yylval.lexStr.str = getText(lip, 1, 1))) {
		          state = MyLexChar;  // Read char by char
		          break;
		        }
		        yylval.lexStr.length = lip.yytoklen;

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(
		            thd, &yylval.lexStr,
		            lip.mUnderscoreCs ? lip.mUnderscoreCs : cs,
		            lip.mCppTextEnd);

		        lip.mUnderscoreCs = null;

		        return (TextString);

		      case MY_LEX_COMMENT:  //  Comment
		        thd.mParserState.addComment();
		        while ((c = lip.yy_get()) != '\n' && c)
		          ;
		        lip.yy_unget();        // Safety against eof
		        state = MY_LEX_START;  // Try again
		        break;
		      case MY_LEX_LONG_COMMENT: /* Long C comment? */
		        if (lip.yy_peek() != '*') {
		          state = MyLexChar;  // Probable division
		          break;
		        }
		        thd.mParserState.addComment();
		        /* Reject '/' '*', since we might need to turn off the echo */
		        lip.yy_unget();

		        lip.saveInCommentState();

		        if (lip.yy_peekn(2) == '!') {
		          lip.inComment = DiscardComment;
		          /* Accept '/' '*' '!', but do not keep this marker. */
		          lip.setEcho(false);
		          lip.yy_skip();
		          lip.yy_skip();
		          lip.yy_skip();

		          /*
		            The special comment format is very strict:
		            '/' '*' '!', followed by either

		            6 digits: 2 digits (major), 2 digits (mionr), 2 digits (dot), then a
		            white-space character.
		            032302 . 3.23.2
		            050032 . 5.0.32
		            050114 . 5.1.14
		            100000 . 10.0.0

		            or, if that format is not matched:

		            5 digits: 1 digit (major), 2 digits (minor), then 2 digits (dot).
		            32302 . 3.23.2
		            50032 . 5.0.32
		            50114 . 5.1.14
		          */
		          char versionStr[7] = {0};
		          if (myIsdigit(cs, (versionStr[0] = lip.yypeekn(0))) &&
		              myIsdigit(cs, (versionStr[1] = lip.yypeekn(1))) &&
		              myIsdigit(cs, (versionStr[2] = lip.yypeekn(2))) &&
		              myIsdigit(cs, (versionStr[3] = lip.yypeekn(3))) &&
		              myIsdigit(cs, (versionStr[4] = lip.yypeekn(4)))) {
		            if (myIsdigit(cs, lip.yypeekn(5)) &&
		                myIsspace(cs, lip.yypeekn(6))) {
		              versionStr[5] = lip.yypeekn(5);
		            } else if (!myIsspace(cs, lip.yypeekn(5))) {
		              pushWarning(thd, SqlCondition::SlWarning,
		                           ErWarnNoSpaceVersionComment,
		                           ErThd(thd, ErWarnNoSpaceVersionComment));
		            }

		            ulong version = strtol(versionStr, null, 10);
		            if (version <= MysqlVersionId) {
		              /* Accept ('M') 'M' 'm' 'm' 'd' 'd' */
		              lip.yyskipn(strlen(versionStr));
		              /* Expand the content of the special comment as real code */
		              lip.setEcho(true);
		              state = MyLexStart;
		              break; /* Do not treat contents as a comment.  */
		            } else {
		              /*
		                Patch and skip the conditional comment to avoid it
		                being propagated infinitely (eg. to a slave).
		              */
		              char *pcom = lip.yy_unput(' ');
		              commentClosed = !consumeComment(lip, 1);
		              if (!commentClosed) {
		                *pcom = '!';
		              }
		              /* version allowed to have one level of comment inside. */
		            }
		          } else {
		            /* Not a version comment. */
		            state = MyLexStart;
		            lip.setEcho(true);
		            break;
		          }
		        } else {
		          if (lip.inComment != NoComment) {
		            pushWarning(
		                lip.mThd, SqlCondition::SlWarning,
		                ErWarnDeprecatedSyntaxNoReplacement,
		                ErThd(lip.mThd, ErWarnDeprecatedNestedCommentSyntax));
		          }
		          lip.inComment = PreserveComment;
		          lip.yy_skip();  // Accept /
		          lip.yy_skip();  // Accept *
		          commentClosed = !consumeComment(lip, 0);
		          /* regular comments can have zero comments inside. */
		        }
		        /*
		          Discard:
		          - regular '/' '*' comments,
		          - special comments '/' '*' '!' for a future version,
		          by scanning until we find a closing '*' '/' marker.

		          Nesting regular comments isn't allowed.  The first
		          '*' '/' returns the parser to the previous state.

		          /#!VERSI oned containing /# regular #/ is allowed #/

		                  Inside one versioned comment, another versioned comment
		                  is treated as a regular discardable comment.  It gets
		                  no special parsing.
		        */

		        /* Unbalanced comments with a missing '*' '/' are a syntax error */
		        if (!commentClosed) return (AbortSym);
		        state = MyLexStart;  // Try again
		        lip.restoreInCommentState();
		        break;
		      case MyLexEndLongComment:
		        if ((lip.inComment != NoComment) && lip.yypeek() == '/') {
		          /* Reject '*' '/' */
		          lip.yy_unget();
		          /* Accept '*' '/', with the proper echo */
		          lip.setEcho(lip.inComment == PreserveComment);
		          lip.yy_skipn(2);
		          /* And start recording the tokens again */
		          lip.setEcho(true);

		          /*
		            C-style comments are replaced with a single space (as it
		            is in C and C++).  If there is already a whitespace
		            character at this point in the stream, the space is
		            not inserted.

		            See also ISO/IEC 9899:1999 §5.1.1.2
		            ("Programming languages — C")
		          */
		          if (!myIsspace(cs, lip.yypeek()) &&
		              lip.getCppPtr() != lip.getCppBuf() &&
		              !myIsspace(cs, *(lip.getCppPtr() - 1)))
		            lip.cppInject(' ');

		          lip.inComment = NoComment;
		          state = MyLexStart;
		        } else
		          state = MyLexChar;  // Return '*'
		        break;
		      case MyLexSetVar:  // Check if ':='
		        if (lip.yy_peek() != '=') {
		          state = MyLexChar;  // Return ':'
		          break;
		        }
		        lip.yy_skip();
		        return (SetVar);
		      case MyLexSemicolon:  // optional line terminator
		        state = MyLexChar;  // Return ';'
		        break;
		      case MyLexEol:
		        if (lip.eof()) {
		          lip.yy_unget();  // Reject the last '\0'
		          lip.setEcho(false);
		          lip.yy_skip();
		          lip.setEcho(true);
		          /* Unbalanced comments with a missing '*' '/' are a syntax error */
		          if (lip.inComment != NoComment) return (AbortSym);
		          lip.nextState = MyLexEnd;  // Mark for next loop
		          return (EndOfInput);
		        }
		        state = MyLexChar;
		        break;
		      case MyLexEnd:
		        lip.nextState = MyLexEnd;
		        return (0);  // We found end of input last time

		        /* Actually real shouldn't start with . but allow them anyhow */
		      case MyLexRealOrPoint:
		        if (myIsdigit(cs, lip.yypeek()))
		          state = MyLexReal;  // Real
		        else {
		          state = MyLexIdentSep;  // return '.'
		          lip.yy_unget();            // Put back '.'
		        }
		        break;
		      case MyLexUserEnd:  // end '@' of user@hostname
		        switch (stateMap[lip.yypeek()]) {
		          case MyLexString:
		          case MyLexUserVariableDelimiter:
		          case MyLexStringOrDelimiter:
		            break;
		          case MyLexUserEnd:
		            lip.nextState = MyLexSystemVar;
		            break;
		          default:
		            lip.nextState = MyLexHostname;
		            break;
		        }
		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
		        yylval.lexStr.length = 1;
		        return ((int)'@');
		      case MyLexHostname:  // end '@' of user@hostname
		        for (c = lip.yy_get();
		             myIsalnum(cs, c) || c == '.' || c == '_' || c == '$';
		             c = lip.yy_get())
		          ;
		        yylval.lexStr = getToken(lip, 0, lip.yylength());
		        return (LexHostname);
		      case MyLexSystemVar:
		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
		        yylval.lexStr.length = 1;
		        lip.yy_skip();  // Skip '@'
		        lip.nextState =
		            (stateMap[lip.yypeek()] == MyLexUserVariableDelimiter
		                 ? MyLexStart
		                 : MyLexIdentOrKeyword);
		        return ((int)'@');
		      case MyLexIdentOrKeyword:
		        /*
		          We come here when we have found two '@' in a row.
		          We should now be able to handle:
		          [(global | local | session) .]variableName
		        */

		        for (resultState = 0; identMap[c = lip.yyget()]; resultState |= c)
		          ;
		        /* If there were non-ASCII characters, mark that we must convert */
		        resultState = resultState & 0x80 ? IdentQuoted : Ident;

		        if (c == '.') lip.nextState = MyLexIdentSep;
		        length = lip.yy_length();
		        if (length == 0) return (AbortSym);  // Names must be nonempty.
		        if ((tokval = findKeyword(lip, length, false))) {
		          lip.yy_unget();   // Put back 'c'
		          return (tokval);  // Was keyword
		        }
		        yylval.lexStr = getToken(lip, 0, length);

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (resultState);

		      case MyLexIdentOrDollarQuotedText: {
		        int len = 0;             /* Length of the tag of the dollar quote */
		        uchar p = lip.yy_peek(); /* Character succeeding first $ */
		        // Find $ character after the tag
		        while (p != '$' && identMap[p] &&
		               lip.getPtr() + len <= lip.getEndOfQuery()) {
		          if (useMb(cs)) {
		            int l =
		                myIsmbchar(cs, lip.getPtr() + len, lip.getEndOfQuery());
		            if (l > 1) len += l - 1;
		          }
		          p = lip.yy_peekn(++len);
		        }

		        if (p != '$') { /* Not a dollar quote, could be an identifier */
		          pushDeprecatedWarnNoReplacement(
		              lip.mThd, "$ as the first character of an unquoted identifier");
		          state = MyLexIdent;
		          break;
		        } else {
		          LexCstring text = getDollarQuotedText(lip, len);
		          if (text == NullCstr)
		            return AbortSym;  // error: unterminated text
		          else {
		            yylval.lexStr.str = constCast<char *>(text.str);
		            yylval.lexStr.length = text.length;

		            lip.bodyUtf8Append(text.str);
		            lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                          text.str + text.length);

		            return DollarQuotedStringSym;  // $$ ... $$
		          }
		        }
		      }
		    }
		  }
		}

}
