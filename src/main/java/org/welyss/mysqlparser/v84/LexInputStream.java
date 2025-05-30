package org.welyss.mysqlparser.v84;

import org.welyss.mysqlparser.items.Item;

/**
 * Convert from sql_lex.h,sql_lex.cc
 */
public class LexInputStream {
	StringBuilder sqlBuilder;

	public LexInputStream(String sql) {
		sqlBuilder = new StringBuilder(sql);
		reset(0, 0);
	}

	/**
	 * Object initializer. Must be called before usage.
	 *
	 * @retval false OK
	 * @retval true Error
	 */
	boolean init(Integer buff, int length) {
//queryCharset = thd.charset();
//m_cpp_buf = (char)thd->alloc(length + 1);
		if (mCppBuf == null)
			return true;
//		mThd = thd;
		reset(buff, length);
		return false;
	}

	void reset(Integer buff, int length) {
		yylineno = 1;
		yytoklen = 0;
		yylval = null;
		lookaheadToken = grammarSelectorToken;
		Item dummyYylval = null;
		lookaheadYylval = dummyYylval;
		skipDigest = false;
		/*
		 * Lex_input_stream modifies the query string in one special case (sic!).
		 * yyUnput() modifises the string when patching version comments. This is done
		 * to prevent newer slaves from executing a different statement than older
		 * masters.
		 *
		 * For now, cast away const here. This means that e.g. SHOW PROCESSLIST can see
		 * partially patched query strings. It would be better if we could replicate the
		 * query string as is and have the slave take the master version into account.
		 */
		mPtr = null;
		mTokStart = null;
		mTokEnd = null;
		mEndOfQuery = buff + length;
		mBuf = buff;
		mBufLength = length;
		mEcho = true;
		mCppTokStart = null;
		mCppTokEnd = null;
		mBodyUtf8 = null;
		mCppUtf8ProcessedPtr = null;
		nextState = MyLexStates.MY_LEX_START;
		foundSemicolon = null;
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
	 * When echo is true, characters parsed from the raw input stream are preserved.
	 * When false, characters parsed are silently ignored.
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
		char c = sqlBuilder.charAt(mPtr++);
		if (mEcho)
			mCppPtr = mPtr;
		return c;
	}

	/**
	 * Get the last character accepted.
	 *
	 * @return the last character accepted.
	 */
	char yyGetLast() {
		return sqlBuilder.charAt(mPtr - 1);
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
		return offset < sqlBuilder.length() ? sqlBuilder.charAt(offset) : MyParser.SymbolKind.S_YYEOF.getChar();
	}

	/**
	 * Cancel the effect of the last yyGet() or yySkip(). Note that the echo mode
	 * should not change between calls to yyGet / yySkip and yyUnget. The caller is
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
		assert (mPtr <= mEndOfQuery);
//		if (mEcho)
//			mCppPtr++ = mPtr++;
//		else
//			mPtr++;
	}

	/**
	 * Accept multiple characters at once.
	 *
	 * @param n the number of characters to accept.
	 */
	void yySkipn(int n) {
		assert (mPtr + n <= mEndOfQuery);
//		if (mEcho) {
//			memcpy(mCppPtr, mPtr, n);
//			mCppPtr += n;
//		}
//		mPtr += n;
	}

	/**
	 * Puts a character back into the stream, canceling the effect of the last
	 * yyGet() or yySkip(). Note that the echo mode should not change between calls
	 * to unput, get, or skip from the stream.
	 */
	char yyUnput(char ch) {
		sqlBuilder.setCharAt(--mPtr, ch);
		if (mEcho)
			mCppPtr--;
		return sqlBuilder.charAt(mPtr);
	}

	/**
	 * Inject a character into the pre-processed stream.
	 *
	 * Note, this function is used to inject a space instead of multi-character
	 * C-comment. Thus there is no boundary checks here (basically, we replace
	 * N-chars by 1-char here).
	 */
	char cppInject(char ch) {
//		mCppPtr = ch;
		sqlBuilder.replace(mCppPtr, mCppPtr + 1, String.valueOf(ch));
		return sqlBuilder.charAt(++mCppPtr);
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
		return sqlBuilder.charAt(mBuf);
	}

	/** Get the pre-processed query buffer. */
	char getCppBuf() {
		return sqlBuilder.charAt(mCppBuf);
	}

	/** Get the end of the raw query buffer. */
	char getEndOfQuery() {
		return sqlBuilder.charAt(mEndOfQuery);
	}

	/** Mark the stream position as the start of a new token. */
	void startToken() {
		mTokStart = mPtr;
		mTokEnd = mPtr;

		mCppTokStart = mCppPtr;
		mCppTokEnd = mCppPtr;
	}

	/**
	 * Adjust the starting position of the current token. This is used to compensate
	 * for starting whitespace.
	 */
	void restartToken() {
		mTokStart = mPtr;
		mCppTokStart = mCppPtr;
	}

	/** Get the token start position, in the raw buffer. */
	char getTokStart() {
		return sqlBuilder.charAt(mTokStart);
	}

	/** Get the token start position, in the pre-processed buffer. */
	char getCppTokStart() {
		return sqlBuilder.charAt(mCppTokStart);
	}

	/** Get the token end position, in the raw buffer. */
	char getTokEnd() {
		return sqlBuilder.charAt(mTokEnd);
	}

	/** Get the token end position, in the pre-processed buffer. */
	char getCppTokEnd() {
		return sqlBuilder.charAt(mCppTokEnd);
	}

	/** Get the current stream pointer, in the raw buffer. */
	char getPtr() {
		return sqlBuilder.charAt(mPtr);
	}

	/** Get the current stream pointer, in the pre-processed buffer. */
	char getCppPtr() {
		return sqlBuilder.charAt(mCppPtr);
	}

	/** Get the length of the current token, in the raw buffer. */
	int yyLength() {
		/*
		 * The assumption is that the lexical analyser is always 1 character ahead,
		 * which the -1 account for.
		 */
//		assert (mPtr > mTokStart);
		return (mPtr - mTokStart) - 1;
	}

	/** Get the utf8-body string. */
	char getBodyUtf8Str() {
		return mBodyUtf8;
	}

	/** Get the utf8-body length. */
	int getBodyUtf8Length() {
		return mBodyUtf8Ptr - mBodyUtf8;
	}

	void bodyUtf8Start(SQLThread thd, char beginPtr) {

	}

	void bodyUtf8Append(char ptr) {

	}

	void bodyUtf8Append(char ptr, char end_ptr) {

	}

	void bodyUtf8AppendLiteral(SQLThread thd, String txt, CharsetInfo txt_cs, char end_ptr) {

	}

	Integer getLineno(char rawPtr) {
		return null;
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
	 * LALR(2) resolution, look ahead token. Value of the next token to return, if
	 * any, or -1, if no token was parsed in advance. Note: 0 is a legal token, and
	 * represents YYEOF.
	 */
	int lookaheadToken;

	/** LALR(2) resolution, value of the look ahead token. */
	Item lookaheadYylval;

	/**
	 * Skip adding of the current token's digest since it is already added Usually
	 * we calculate a digest token by token at the top-level function of the lexer:
	 * MYSQLlex(). However, some complex ("hintable") tokens break that data flow:
	 * for example, the `SELECT &frasl;*+ HINT(t) *&frasl;` is the single token from
	 * the main parser's point of view, and we add the "SELECT" keyword to the
	 * digest buffer right after the lex_one_token() call, but the "&frasl;*+
	 * HINT(t) *&frasl;" is a sequence of separate tokens from the hint parser's
	 * point of view, and we add those tokens to the digest buffer *inside* the
	 * lex_one_token() call. Thus, the usual data flow adds tokens from the
	 * "&frasl;*+ HINT(t) *&frasl;" string first, and only than it appends the
	 * "SELECT" keyword token to that stream: "&frasl;*+ HINT(t) *&frasl; SELECT".
	 * This is not acceptable, since we use the digest buffer to restore query
	 * strings in their normalized forms, so the order of added tokens is important.
	 * Thus, we add tokens of "hintable" keywords to a digest buffer right in the
	 * hint parser and skip adding of them at the caller with the help of
	 * skip_digest flag.
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
	 * True if this scanner tokenizes a partial query (partition expression,
	 * generated column expression etc.)
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
	void warnOnDeprecatedCharset(CharsetInfo cs, char alias) {
		if (!isPartialParser()) {
//    ::warn_on_deprecated_charset(m_thd, cs, alias);
		}
	}

	/**
	 * Outputs warnings on deprecated collations in complete SQL statements
	 *
	 * @param [in] collation The collation to check for a deprecation.
	 */
	void warnOnDeprecatedCollation(CharsetInfo collation) {
		if (!isPartialParser()) {
//    ::warn_on_deprecated_collation(m_thd, collation);
		}
	}

	static final CharsetInfo queryCharset = new CharsetInfo();

// private
	/** Pointer to the current position in the raw input stream. */
	Integer mPtr;

	/** Starting position of the last token parsed, in the raw buffer. */
	Integer mTokStart;

	/** Ending position of the previous token parsed, in the raw buffer. */
	Integer mTokEnd;

	/** End of the query text in the input stream, in the raw buffer. */
	Integer mEndOfQuery;

	/** Begining of the query text in the input stream, in the raw buffer. */
	Integer mBuf;

	/** Length of the raw buffer. */
	int mBufLength;

	/** Echo the parsed stream to the pre-processed buffer. */
	boolean mEcho;
	boolean mEchoSaved;

	/** Pre-processed buffer. */
	Integer mCppBuf;

	/** Pointer to the current position in the pre-processed input stream. */
	Integer mCppPtr;

	/**
	 * Starting position of the last token parsed, in the pre-processed buffer.
	 */
	Integer mCppTokStart;

	/**
	 * Ending position of the previous token parsed, in the pre-processed buffer.
	 */
	Integer mCppTokEnd;

	/** UTF8-body buffer created during parsing. */
	Character mBodyUtf8;

	/** Pointer to the current position in the UTF8-body buffer. */
	Integer mBodyUtf8Ptr;

	/**
	 * Position in the pre-processed buffer. The query from mCppBuf to
	 * m_cpp_utf_processed_ptr is converted to UTF8-body.
	 */
	Integer mCppUtf8ProcessedPtr;

	// public
	/** Current state of the lexical analyser. */
	public MyLexStates nextState;

	/**
	 * Position of ';' in the stream, to delimit multiple queries. This delimiter is
	 * in the raw buffer.
	 */
	Integer foundSemicolon;

	/** Token character bitmaps, to detect 7bit strings. */
	Character tokBitmap;

	/** SQL_MODE = IGNORE_SPACE. */
	boolean ignoreSpace;

	/**
	 * true if we're parsing a prepared statement: in this mode we should allow
	 * placeholders.
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
	public static final CharsetInfo mUnderscoreCs = new CharsetInfo();

	/**
	 * Current statement digest instrumentation.
	 */
	SQLDigestState mDigest;

	/**
	 * The synthetic 1st token to prepend token stream with.
	 *
	 * This token value tricks parser to simulate multiple %start-ing points.
	 * Currently the grammar is aware of 4 such synthetic tokens: 1.
	 * GRAMMAR_SELECTOR_PART for partitioning stuff from DD, 2.
	 * GRAMMAR_SELECTOR_GCOL for generated column stuff from DD, 3.
	 * GRAMMAR_SELECTOR_EXPR for generic single expressions from DD/.frm. 4.
	 * GRAMMAR_SELECTOR_CTE for generic subquery expressions from CTEs. 5. -1 when
	 * parsing with the main grammar (no grammar selector available).
	 *
	 * @note yylex() is expected to return the value of type int: 0 is for EOF and
	 *       everything else for real token numbers. Bison, in its turn, generates
	 *       positive token numbers. So, the negative grammar_selector_token means
	 *       "not a token". In other words, -1 is "empty value".
	 */
	static int grammarSelectorToken;

	boolean textStringIs7bit() {
		return !((tokBitmap & 0x80) > 0);
	}

}
