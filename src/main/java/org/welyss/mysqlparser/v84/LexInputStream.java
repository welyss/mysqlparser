package org.welyss.mysqlparser.v84;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.LexString;

/**
 * Convert from sql_lex.h,sql_lex.cc, the [yylval] is Lexer_yystype from sql_lex.h, lexer_yystype.h, lex_symbol.h .
 */
public class LexInputStream {
	public static short MY_CHAR_U = 01; /* Upper case */
	public static short MY_CHAR_L = 02; /* Lower case */
	public static short MY_CHAR_NMR = 04; /* Numeral (digit) */
	public static short MY_CHAR_SPC = 010; /* Spacing character */
	public static short MY_CHAR_PNT = 020; /* Punctuation */
	public static short MY_CHAR_CTR = 040; /* Control character */
	public static short MY_CHAR_B = 0100; /* Blank */
	public static short MY_CHAR_X = 0200; /* heXadecimal digit */
	public static short[] ctypeUtf8mb4 = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 40, 40, 40, 40, 40, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 72, 16, 16, 16, 16, 16,
			16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 132, 132, 132, 132, 132, 132, 132, 132, 132, 132, 16, 16, 16, 16, 16, 16, 16, 129, 129, 129, 129, 129, 129, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 16, 16, 16, 16, 16, 16, 130, 130, 130, 130, 130, 130, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 16, 16, 16, 16, 32, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
			3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
			3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0 };

	public StringBuilder sqlBuf;
	public SQLThread mThd;

	public LexInputStream(String sql, SQLThread thd) {
		sqlBuf = new StringBuilder(sql);
		mThd = thd;
		init(0, sqlBuf.length());
	}

	/**
	 * Object initializer. Must be called before usage.
	 *
	 * @retval false OK
	 * @retval true Error
	 */
	boolean init(Integer buff, int length) {
		reset(buff, length);
		return false;
	}

	void reset(Integer buff, int length) {
		yylineno = 1;
		yytoklen = 0;
		yylval = null;
		lookaheadToken = grammarSelectorToken = -1;
		Item dummyYylval = null;
		lookaheadYylval = dummyYylval;
		skipDigest = false;
		/*
		 * Lex_input_stream modifies the query string in one special case (sic!). yyUnput() modifises the string when patching version comments. This is done to prevent
		 * newer slaves from executing a different statement than older masters.
		 *
		 * For now, cast away const here. This means that e.g. SHOW PROCESSLIST can see partially patched query strings. It would be better if we could replicate the
		 * query string as is and have the slave take the master version into account.
		 */
		mPtr = 0;
		mTokStart = 0;
		mTokEnd = 0;
		mEndOfQuery = buff + length;
		mBuf = buff;
		mBufLength = length;
		mEcho = true;
		mCppTokStart = 0;
		mCppTokEnd = 0;
		mBodyUtf8 = null;
		mCppUtf8ProcessedPtr = 0;
		nextState = MyLexStates.MY_LEX_START;
		foundSemicolon = 0;
		ignoreSpace = false;
		stmtPrepareMode = false;
		multiStatements = true;
		inComment = EnumCommentState.NO_COMMENT;
//		mUnderscoreCs = null;
		mCppPtr = mCppBuf;
	}

	/**
	 * Set the echo mode.
	 *
	 * When echo is true, characters parsed from the raw input stream are preserved. When false, characters parsed are silently ignored.
	 *
	 * @param echo the echo mode.
	 */
	void setEcho(boolean echo) {
		mEcho = echo;
	}

	void saveInCommentState() {
		mEchoSaved = mEcho;
		inCommentSaved = inComment;
	}

	void restoreInCommentState() {
		mEcho = mEchoSaved;
		inComment = inCommentSaved;
	}

	/**
	 * Skip binary from the input stream.
	 *
	 * @param n number of bytes to accept.
	 */
	void skipBinary(int n) {
//		assert (mPtr + n <= mEndOfQuery);
//		if (mEcho) {
//			memcpy(mCppPtr, mPtr, n);
//			mCppPtr += n;
//		}
//		mPtr += n;
	}

	/**
	 * Get a character, and advance in the stream.
	 *
	 * @return the next character to parse.
	 */
	char yyGet() {
		if (eof()) {
			return MyParser.SymbolKind.S_YYEOF.getChar();
		} else {
			char c = sqlBuf.charAt(mPtr++);
			if (mEcho)
				mCppPtr = mPtr;
			return c;
		}
	}

	/**
	 * Get the last character accepted.
	 *
	 * @return the last character accepted.
	 */
	char yyGetLast() {
		return sqlBuf.charAt(mPtr - 1);
	}

	/**
	 * Look at the next character to parse, but do not accept it.
	 */
	char yyPeek() {
		return yyPeekn(0);
	}

	/**
	 * Look ahead at some character to parse.
	 *
	 * @param n offset of the character to look up
	 */
	char yyPeekn(int n) {
		int offset = mPtr + n;
		return offset < sqlBuf.length() ? sqlBuf.charAt(offset) : MyParser.SymbolKind.S_YYEOF.getChar();
	}

	/**
	 * Cancel the effect of the last yyGet() or yySkip(). Note that the echo mode should not change between calls to yyGet / yySkip and yyUnget. The caller is
	 * responsible for ensuring that.
	 */
	void yyUnget() {
		mPtr--;
		if (mEcho)
			mCppPtr--;
	}

	/**
	 * Accept a character, by advancing the input stream.
	 */
	void yySkip() {
		if (mEcho)
			mCppPtr = ++mPtr;
		else
			mPtr++;
	}

	/**
	 * Accept multiple characters at once.
	 *
	 * @param n the number of characters to accept.
	 */
	void yySkipn(int n) {
		if (mEcho) {
			mCppPtr += n;
		}
		mPtr += n;
	}

	/**
	 * Puts a character back into the stream, canceling the effect of the last yyGet() or yySkip(). Note that the echo mode should not change between calls to
	 * unput, get, or skip from the stream.
	 */
	char yyUnput(char ch) {
		sqlBuf.setCharAt(--mPtr, ch);
		if (mEcho)
			mCppPtr--;
		return sqlBuf.charAt(mPtr);
	}

	/**
	 * Inject a character into the pre-processed stream.
	 *
	 * Note, this function is used to inject a space instead of multi-character C-comment. Thus there is no boundary checks here (basically, we replace N-chars by
	 * 1-char here).
	 */
	char cppInject(char ch) {
//		mCppPtr = ch;
		sqlBuf.replace(mCppPtr, mCppPtr + 1, String.valueOf(ch));
		return sqlBuf.charAt(++mCppPtr);
	}

	/**
	 * End of file indicator for the query text to parse.
	 *
	 * @return true if there are no more characters to parse
	 */
	boolean eof() {
		return (mPtr >= mEndOfQuery);
	}

	/**
	 * End of file indicator for the query text to parse.
	 *
	 * @param n number of characters expected
	 * @return true if there are less than n characters to parse
	 */
	boolean eof(int n) {
		return ((mPtr + n) >= mEndOfQuery);
	}

	/** Get the raw query buffer. */
	char getBuf() {
		return sqlBuf.charAt(mBuf);
	}

	/** Get the pre-processed query buffer. */
	char getCppBuf() {
		return sqlBuf.charAt(mCppBuf);
	}

	/** Get the end of the raw query buffer. */
	char getEndOfQuery() {
		return sqlBuf.charAt(mEndOfQuery);
	}

	/** Mark the stream position as the start of a new token. */
	void startToken() {
		mTokStart = mPtr;
		mTokEnd = mPtr;
		mCppTokStart = mCppPtr;
		mCppTokEnd = mCppPtr;
	}

	/**
	 * Adjust the starting position of the current token. This is used to compensate for starting whitespace.
	 */
	void restartToken() {
		mTokStart = mPtr;
		mCppTokStart = mCppPtr;
	}

	/** Get the token start position, in the raw buffer. */
	int getTokStart() {
		return mTokStart;
	}

	/** Get the token start position, in the pre-processed buffer. */
	int getCppTokStart() {
		return mCppTokStart;
	}

	/** Get the token end position, in the raw buffer. */
	int getTokEnd() {
		return mTokEnd;
	}

	/** Get the token end position, in the pre-processed buffer. */
	int getCppTokEnd() {
		return mCppTokEnd;
	}

	/** Get the current stream pointer, in the raw buffer. */
	int getPtr() {
		return mPtr;
	}

	/** Get the current stream pointer, in the pre-processed buffer. */
	int getCppPtr() {
		return mCppPtr;
	}

	/** Get the length of the current token, in the raw buffer. */
	int yyLength() {
		/*
		 * The assumption is that the lexical analyser is always 1 character ahead, which the -1 account for.
		 */
//		assert (mPtr > mTokStart);
		return (mPtr - mTokStart) - 1;
	}

	/** Get the utf8-body string. */
	String getBodyUtf8Str() {
		return mBodyUtf8;
	}

	/** Get the utf8-body length. */
	int getBodyUtf8Length() {
		return mBodyUtf8 == null ? 0 : mBodyUtf8.length();
	}

	void bodyUtf8Start(SQLThread thd, char beginPtr) {

	}

	/**
	 * The operation appends unprocessed part of the pre-processed buffer till the given pointer (ptr) and sets m_cpp_utf8_processed_ptr to ptr.
	 *
	 * @param ptr Pointer in the pre-processed buffer, which specifies the end of the chunk, which should be appended to the utf8 body.
	 */
	public void bodyUtf8Append(int ptr) {
		bodyUtf8Append(ptr, ptr);
	}

	/**
	 * @brief The operation appends unprocessed part of pre-processed buffer till the given pointer (ptr) and sets m_cpp_utf8_processed_ptr to end_ptr.
	 *
	 *        The idea is that some tokens in the pre-processed buffer (like character set introducers) should be skipped.
	 *
	 *        Example: CPP buffer: SELECT 'str1', _latin1 'str2'; m_cpp_utf8_processed_ptr -- points at the "SELECT ..."; In order to skip "_latin1", the following
	 *        call should be made: body_utf8_append(<pointer to "_latin1 ...">, <pointer to " 'str2'...">)
	 *
	 * @param ptr     Pointer in the pre-processed buffer, which specifies the end of the chunk, which should be appended to the utf8 body.
	 * @param end_ptr Pointer in the pre-processed buffer, to which m_cpp_utf8_processed_ptr will be set in the end of the operation.
	 */
	public void bodyUtf8Append(int ptr, int endPtr) {
		if (mCppBuf <= ptr && ptr <= mCppBuf + mBufLength) {
			if (mCppBuf <= endPtr && endPtr <= mCppBuf + mBufLength) {
				if (mBodyUtf8 == null)
					return;
				if (mCppUtf8ProcessedPtr >= ptr)
					return;
				int bytesToCopy = ptr - mCppUtf8ProcessedPtr;
//				memcpy(mBodyUtf8Ptr, mCppUtf8ProcessedPtr, bytesToCopy);
				mBodyUtf8 = sqlBuf.substring(mCppUtf8ProcessedPtr, mCppUtf8ProcessedPtr + bytesToCopy);
				mBodyUtf8Ptr += bytesToCopy;
//				mBodyUtf8Ptr = 0;
				mCppUtf8ProcessedPtr = endPtr;
			}
		}
	}

	/**
	 * The operation converts the specified text literal to the utf8 and appends the result to the utf8-body.
	 *
	 * @param thd     Thread context.
	 * @param txt     Text literal.
	 * @param txt_cs  Character set of the text literal.
	 * @param end_ptr Pointer in the pre-processed buffer, to which m_cpp_utf8_processed_ptr will be set in the end of the operation.
	 */
	public void bodyUtf8AppendLiteral(SQLThread thd, LexString txt, Integer endPtr) {
		if (mCppUtf8ProcessedPtr == null)
			return;
		LexString utfTxt = new LexString(null);
//		  if (!myCharsetSame(txtCs, &myCharsetUtf8mb4GeneralCi)) {
//		    thd.convertString(&utfTxt, &myCharsetUtf8mb4GeneralCi, txt.str,
//		                        txt.length, txtCs);
//		  } else {
		utfTxt.str = txt.str;
		utfTxt.length = txt.length;
//		  }
//		  MY_COMPILER_DIAGNOSTIC_PUSH();
		// GCC 10.2.0 solaris
//		  MY_COMPILER_GCC_DIAGNOSTIC_IGNORE("-Wmaybe-uninitialized");

		/* NOTE: utf_txt.length is in bytes, not in symbols. */
//		  memcpy(m_body_utf8_ptr, utf_txt.str, utf_txt.length);
		mBodyUtf8 = utfTxt.str;
		mBodyUtf8Ptr += utfTxt.length;
//		  mBodyUtf8Ptr = 0;
//		  MY_COMPILER_DIAGNOSTIC_POP();
		mCppUtf8ProcessedPtr = endPtr;
	}

	Integer getLineno(char rawPtr) {
		return null;
	}

	public char p2c(int point) {
		return sqlBuf.charAt(point);
	}

	/** Current thread. */
//	SQLThread mThd;

	/** Current line number. */
	int yylineno;

	/** Length of the last token parsed. */
	int yytoklen;

	/** Interface with bison, value of the last token parsed. */
	Item yylval;

	/**
	 * LALR(2) resolution, look ahead token. Value of the next token to return, if any, or -1, if no token was parsed in advance. Note: 0 is a legal token, and
	 * represents YYEOF.
	 */
	int lookaheadToken;

	/** LALR(2) resolution, value of the look ahead token. */
	Item lookaheadYylval;

	/**
	 * Skip adding of the current token's digest since it is already added Usually we calculate a digest token by token at the top-level function of the lexer:
	 * MYSQLlex(). However, some complex ("hintable") tokens break that data flow: for example, the `SELECT &frasl;*+ HINT(t) *&frasl;` is the single token from the
	 * main parser's point of view, and we add the "SELECT" keyword to the digest buffer right after the lex_one_token() call, but the "&frasl;*+ HINT(t) *&frasl;"
	 * is a sequence of separate tokens from the hint parser's point of view, and we add those tokens to the digest buffer *inside* the lex_one_token() call. Thus,
	 * the usual data flow adds tokens from the "&frasl;*+ HINT(t) *&frasl;" string first, and only than it appends the "SELECT" keyword token to that stream:
	 * "&frasl;*+ HINT(t) *&frasl; SELECT". This is not acceptable, since we use the digest buffer to restore query strings in their normalized forms, so the order
	 * of added tokens is important. Thus, we add tokens of "hintable" keywords to a digest buffer right in the hint parser and skip adding of them at the caller
	 * with the help of skip_digest flag.
	 */
	boolean skipDigest;

	void addDigestToken(int token, Item yylval) {
		if (mDigest != null) {
			// TODO digest process
//			mDigest = digestAddToken(mDigest, token, yylval);
		}
	}

	void reduceDigestToken(int tokenLeft, int tokenRight) {
		if (mDigest != null) {
			// TODO digest process
//			mDigest = digestReduceToken(mDigest, tokenLeft, tokenRight);
		}
	}

	/**
	 * True if this scanner tokenizes a partial query (partition expression, generated column expression etc.)
	 *
	 * @return true if parsing a partial query, otherwise false.
	 */
	boolean isPartialParser() {
		return grammarSelectorToken >= 0;
	}

	/**
	 * Outputs warnings on deprecated charsets in complete SQL statements
	 *
	 * @param [in] cs The character set/collation to check for a deprecation.
	 * @param [in] alias The name/alias of @p cs.
	 */
//	void warnOnDeprecatedCharset(CharsetInfo cs, char alias) {
//		if (!isPartialParser()) {
////    ::warn_on_deprecated_charset(m_thd, cs, alias);
//		}
//	}

	/**
	 * Outputs warnings on deprecated collations in complete SQL statements
	 *
	 * @param [in] collation The collation to check for a deprecation.
	 */
//	void warnOnDeprecatedCollation(CharsetInfo collation) {
//		if (!isPartialParser()) {
////    ::warn_on_deprecated_collation(m_thd, collation);
//		}
//	}

//	static final CharsetInfo queryCharset = new CharsetInfo();

// private
	/** Pointer to the current position in the raw input stream. */
	int mPtr;

	/** Starting position of the last token parsed, in the raw buffer. */
	int mTokStart;

	/** Ending position of the previous token parsed, in the raw buffer. */
	int mTokEnd;

	/** End of the query text in the input stream, in the raw buffer. */
	int mEndOfQuery;

	/** Begining of the query text in the input stream, in the raw buffer. */
	int mBuf;

	/** Length of the raw buffer. */
	int mBufLength;

	/** Echo the parsed stream to the pre-processed buffer. */
	boolean mEcho;
	boolean mEchoSaved;

	/** Pre-processed buffer. */
	int mCppBuf;

	/** Pointer to the current position in the pre-processed input stream. */
	int mCppPtr;

	/**
	 * Starting position of the last token parsed, in the pre-processed buffer.
	 */
	int mCppTokStart;

	/**
	 * Ending position of the previous token parsed, in the pre-processed buffer.
	 */
	int mCppTokEnd;

	/** UTF8-body buffer created during parsing. */
	String mBodyUtf8;

	/** Pointer to the current position in the UTF8-body buffer. */
	int mBodyUtf8Ptr;

	/**
	 * Position in the pre-processed buffer. The query from mCppBuf to m_cpp_utf_processed_ptr is converted to UTF8-body.
	 */
	Integer mCppUtf8ProcessedPtr;

	// public
	/** Current state of the lexical analyser. */
	public MyLexStates nextState;

	/**
	 * Position of ';' in the stream, to delimit multiple queries. This delimiter is in the raw buffer.
	 */
	int foundSemicolon;

	/** Token character bitmaps, to detect 7bit strings. */
	char tokBitmap;

	/** SQL_MODE = IGNORE_SPACE. */
	boolean ignoreSpace;

	/**
	 * true if we're parsing a prepared statement: in this mode we should allow placeholders.
	 */
	boolean stmtPrepareMode;
	/**
	 * true if we should allow multi-statements.
	 */
	boolean multiStatements;

	/** State of the lexical analyser for comments. */
	EnumCommentState inComment;
	EnumCommentState inCommentSaved;

	/**
	 * Starting position of the TEXT_STRING or IDENT in the pre-processed buffer.
	 *
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
	Integer mCppTextStart;

	/**
	 * Ending position of the TEXT_STRING or IDENT in the pre-processed buffer.
	 *
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
	Integer mCppTextEnd;

	/**
	 * Character set specified by the character-set-introducer.
	 *
	 * NOTE: this member must be used within MYSQLlex() function only.
	 */
//	public static final CharsetInfo mUnderscoreCs = new CharsetInfo();

	/**
	 * Current statement digest instrumentation.
	 */
	SQLDigestState mDigest;

	/**
	 * The synthetic 1st token to prepend token stream with.
	 *
	 * This token value tricks parser to simulate multiple %start-ing points. Currently the grammar is aware of 4 such synthetic tokens: 1. GRAMMAR_SELECTOR_PART
	 * for partitioning stuff from DD, 2. GRAMMAR_SELECTOR_GCOL for generated column stuff from DD, 3. GRAMMAR_SELECTOR_EXPR for generic single expressions from
	 * DD/.frm. 4. GRAMMAR_SELECTOR_CTE for generic subquery expressions from CTEs. 5. -1 when parsing with the main grammar (no grammar selector available).
	 *
	 * @note yylex() is expected to return the value of type int: 0 is for EOF and everything else for real token numbers. Bison, in its turn, generates positive
	 *       token numbers. So, the negative grammar_selector_token means "not a token". In other words, -1 is "empty value".
	 */
	static int grammarSelectorToken;

	boolean textStringIs7bit() {
		return !((tokBitmap & 0x80) > 0);
	}

	public boolean myIscntrl(char ch) {
		int chInt = ch + 1;
		return chInt < ctypeUtf8mb4.length && (ctypeUtf8mb4[chInt] & MY_CHAR_CTR) == MY_CHAR_CTR;
	}

	public boolean myIsspace(char ch) {
		int chInt = ch + 1;
		return chInt < ctypeUtf8mb4.length && (ctypeUtf8mb4[chInt] & MY_CHAR_SPC) == MY_CHAR_SPC;
	}

	public boolean myIsalnum(char ch) {
		int chInt = ch + 1;
		int alnum = (MY_CHAR_U | MY_CHAR_L | MY_CHAR_NMR);
		return chInt < ctypeUtf8mb4.length && (ctypeUtf8mb4[chInt] & alnum) == alnum;
	}
}
