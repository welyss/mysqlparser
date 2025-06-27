package org.welyss.mysqlparser.v84;

/**
 * Convert from struct lex_stateMaps_st in
 * strings/sql_chars.h,strings/sql_chars.cc
 */
public class LexStateMapsSt {
	public static MyLexStates[] mainMap;
	public static boolean[] identMap;
	public static HintLexCharClasses[] hintMap;

	static {

		// This character set has already been initialized.
//		if (mainMap != null && identMap != null)
//			return false;

		MyLexStates[] stateMap = mainMap = new MyLexStates[256];
		identMap = new boolean[256];

		hintLexInitMaps();

		/* Fill stateMap with states to get a faster parser */
		for (short i = 0; i < 256; i++) {
			if (Character.isAlphabetic(i))
				stateMap[i] = MyLexStates.MY_LEX_IDENT;
			else if (Character.isDigit(i))
				stateMap[i] = MyLexStates.MY_LEX_NUMBER_IDENT;
			else if (myIsmb1st((char)i))
				/* To get whether it's a possible leading byte for a charset. */
				stateMap[i] = MyLexStates.MY_LEX_IDENT;
			else if (Character.isWhitespace(i))
				stateMap[i] = MyLexStates.MY_LEX_SKIP;
			else
				stateMap[i] = MyLexStates.MY_LEX_CHAR;
		}
		stateMap['_'] = stateMap['$'] = MyLexStates.MY_LEX_IDENT;
		stateMap['\''] = MyLexStates.MY_LEX_STRING;
		stateMap['.'] = MyLexStates.MY_LEX_REAL_OR_POINT;
		stateMap['>'] = stateMap['='] = stateMap['!'] = MyLexStates.MY_LEX_CMP_OP;
		stateMap['<'] = MyLexStates.MY_LEX_LONG_CMP_OP;
		stateMap['&'] = stateMap['|'] = MyLexStates.MY_LEX_BOOL;
		stateMap['#'] = MyLexStates.MY_LEX_COMMENT;
		stateMap[';'] = MyLexStates.MY_LEX_SEMICOLON;
		stateMap[':'] = MyLexStates.MY_LEX_SET_VAR;
		stateMap[0] = MyLexStates.MY_LEX_EOL;
		stateMap['/'] = MyLexStates.MY_LEX_LONG_COMMENT;
		stateMap['*'] = MyLexStates.MY_LEX_END_LONG_COMMENT;
		stateMap['@'] = MyLexStates.MY_LEX_USER_END;
		stateMap['`'] = MyLexStates.MY_LEX_USER_VARIABLE_DELIMITER;
		stateMap['"'] = MyLexStates.MY_LEX_STRING_OR_DELIMITER;

		/*
		 * Create a second map to make it faster to find identifiers
		 */
		for (short i = 0; i < 256; i++) {
			identMap[i] = (stateMap[i] == MyLexStates.MY_LEX_IDENT || stateMap[i] == MyLexStates.MY_LEX_NUMBER_IDENT);
		}

		/* Special handling of hex and binary strings */
		stateMap['x'] = stateMap['X'] = MyLexStates.MY_LEX_IDENT_OR_HEX;
		stateMap['b'] = stateMap['B'] = MyLexStates.MY_LEX_IDENT_OR_BIN;
		stateMap['n'] = stateMap['N'] = MyLexStates.MY_LEX_IDENT_OR_NCHAR;

		/* Special handling of '$' for dollar quoted strings */
		stateMap['$'] = MyLexStates.MY_LEX_IDENT_OR_DOLLAR_QUOTED_TEXT;
	}

	enum HintLexCharClasses {
		HINT_CHR_ASTERISK, // [*]
		HINT_CHR_AT, // [@]
		HINT_CHR_BACKQUOTE, // [`]
		HINT_CHR_CHAR, // default state
		HINT_CHR_DIGIT, // [[:digit:]]
		HINT_CHR_DOT, // '.'
		HINT_CHR_DOUBLEQUOTE, // ["]
		HINT_CHR_EOF, // pseudo-class
		HINT_CHR_IDENT, // [_$[:alpha:]]
		HINT_CHR_MB, // multibyte character
		HINT_CHR_NL, // \n
		HINT_CHR_QUOTE, // [']
		HINT_CHR_SLASH, // [/]
		HINT_CHR_SPACE // [[:space:]] excluding \n
	}

	private static void hintLexInitMaps() {
		hintMap = new HintLexCharClasses[256];
		for (short i = 0; i < 256; i++) {
			if (myIsmb1st((char)i))
				hintMap[i] = HintLexCharClasses.HINT_CHR_MB;
			else if (Character.isAlphabetic(i))
				hintMap[i] = HintLexCharClasses.HINT_CHR_IDENT;
			else if (Character.isDigit(i))
				hintMap[i] = HintLexCharClasses.HINT_CHR_DIGIT;
			else if (Character.isWhitespace(i)) {
				hintMap[i] = HintLexCharClasses.HINT_CHR_SPACE;
			} else {
				hintMap[i] = HintLexCharClasses.HINT_CHR_CHAR;
			}
		}
		hintMap['*'] = HintLexCharClasses.HINT_CHR_ASTERISK;
		hintMap['@'] = HintLexCharClasses.HINT_CHR_AT;
		hintMap['`'] = HintLexCharClasses.HINT_CHR_BACKQUOTE;
		hintMap['.'] = HintLexCharClasses.HINT_CHR_DOT;
		hintMap['"'] = HintLexCharClasses.HINT_CHR_DOUBLEQUOTE;
		hintMap['$'] = HintLexCharClasses.HINT_CHR_IDENT;
		hintMap['_'] = HintLexCharClasses.HINT_CHR_IDENT;
		hintMap['\n'] = HintLexCharClasses.HINT_CHR_NL;
		hintMap['\''] = HintLexCharClasses.HINT_CHR_QUOTE;
		hintMap['/'] = HintLexCharClasses.HINT_CHR_SLASH;
	}

	/**
	 * Judge if the given byte is a possible leading byte for a charset. For gb18030
	 * whose mbmaxlenlen is 2, we can't determine the length of a multi-byte
	 * character by looking at the first byte only
	 *
	 * @param[in] cs charset_info
	 * @param[in] leading_byte possible leading byte
	 * @return true if it is, otherwise false
	 */
	private static boolean myIsmb1st(char leadingByte) {
//		return myMbcharlen(leadingByte) > 1 || (myMbmaxlenlen() == 2 && myMbcharlen(leadingByte) == 0);
		// myMbmaxlenlen always 1 in utf8mb4
		return myMbcharlen(leadingByte) > 1;
	}

	/**
	 * always utf8mb4
	 * @param c character
	 * @return
	 */
	private static int myMbcharlen(char c) {
		if (c < 0x80)
			return 1;
		if (c < 0xc2)
			return 0; /* Illegal mb head */
		if (c < 0xe0)
			return 2;
		if (c < 0xf0)
			return 3;
		if (c < 0xf8)
			return 4;
		return 0; /* Illegal mb head */
	}
}
