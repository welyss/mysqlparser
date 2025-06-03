package org.welyss.mysqlparser.v84;

/**
 * Convert from struct lex_state_maps_st in
 * strings/sql_chars.h,strings/sql_chars.cc
 */
public class LexStateMapsSt {
	MyLexStates[] mainMap;
	HintLexCharClasses[] hintMap;

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

	private void hintLexInitMaps(CharsetInfo cs, HintLexCharClasses[] hintMap) {
		byte i;
		for (i = 0; i < 256; i++) {
			if (myIsmb1st(cs, i))
				hintMap[i] = HintLexCharClasses.HINT_CHR_MB;
			else if (Character.isAlphabetic(i))
				hintMap[i] = HintLexCharClasses.HINT_CHR_IDENT;
			else if (Character.isDigit(i))
				hintMap[i] = HintLexCharClasses.HINT_CHR_DIGIT;
			else if (Character.isWhitespace(i)) {
				assert (!myIsmb1st(cs, i));
				hintMap[i] = HintLexCharClasses.HINT_CHR_SPACE;
			} else
				hintMap[i] = HintLexCharClasses.HINT_CHR_CHAR;
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

private boolean initStateMaps(MY_CHARSET_LOADER loader, CharsetInfo cs) {
Integer identMap = null;
MyLexStates stateMap = null;

// This character set has already been initialized.
if (cs.stateMaps != null && cs.identMap != null) return false;

lexStateMapsSt *lexStateMaps = staticCast<lexStateMapsSt *>(
loader.onceAlloc(sizeof(lexStateMapsSt)));

if (lexStateMaps == null) return true;  // Oom

cs.stateMaps = lexStateMaps;
stateMap = lexStateMaps.mainMap;

if (!(cs.identMap = identMap =
staticCast<uint8T *>(loader.onceAlloc(256))))
return true;  // OOM

hintLexInitMaps(cs, lexStateMaps.hintmap);

/* Fill state_map with states to get a faster parser */
for (unsigned i = 0; i < 256; i++) {
if (my_isalpha(cs, i))
state_map[i] = MY_LEX_IDENT;
else if (my_isdigit(cs, i))
state_map[i] = MY_LEX_NUMBER_IDENT;
else if (my_ismb1st(cs, i))
/* To get whether it's a possible leading byte for a charset. */
state_map[i] = MY_LEX_IDENT;
else if (my_isspace(cs, i))
state_map[i] = MY_LEX_SKIP;
else
state_map[i] = MY_LEX_CHAR;
}
state_map[u'_'] = state_map[u'$'] = MY_LEX_IDENT;
state_map[u'\''] = MY_LEX_STRING;
state_map[u'.'] = MY_LEX_REAL_OR_POINT;
state_map[u'>'] = state_map[u'='] = state_map[u'!'] = MY_LEX_CMP_OP;
state_map[u'<'] = MY_LEX_LONG_CMP_OP;
state_map[u'&'] = state_map[u'|'] = MY_LEX_BOOL;
state_map[u'#'] = MY_LEX_COMMENT;
state_map[u';'] = MY_LEX_SEMICOLON;
state_map[u':'] = MY_LEX_SET_VAR;
state_map[0] = MY_LEX_EOL;
state_map[u'/'] = MY_LEX_LONG_COMMENT;
state_map[u'*'] = MY_LEX_END_LONG_COMMENT;
state_map[u'@'] = MY_LEX_USER_END;
state_map[u'`'] = MY_LEX_USER_VARIABLE_DELIMITER;
state_map[u'"'] = MY_LEX_STRING_OR_DELIMITER;

/*
Create a second map to make it faster to find identifiers
*/
for (unsigned i = 0; i < 256; i++) {
ident_map[i] = static_cast<uint8_t>(state_map[i] == MY_LEX_IDENT ||
                     state_map[i] == MY_LEX_NUMBER_IDENT);
}

/* Special handling of hex and binary strings */
state_map[u'x'] = state_map[u'X'] = MY_LEX_IDENT_OR_HEX;
state_map[u'b'] = state_map[u'B'] = MY_LEX_IDENT_OR_BIN;
state_map[u'n'] = state_map[u'N'] = MY_LEX_IDENT_OR_NCHAR;

/* Special handling of '$' for dollar quoted strings */
state_map[u'$'] = MY_LEX_IDENT_OR_DOLLAR_QUOTED_TEXT;

return false;
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
	private boolean myIsmb1st(CharsetInfo cs, byte leadingByte) {
		return myMbcharlen(cs, leadingByte) > 1 || (myMbmaxlenlen(cs) == 2 && myMbcharlen(cs, leadingByte) == 0);
	}

	private int myMbcharlen(CharsetInfo cs, byte firstByte) {
		// only utf8mb3 for now
		if (firstByte < 0x80)
			return 1;
		else if (firstByte < 0xc2)
			return 0; /* Illegal mb head */
		else if (firstByte < 0xe0)
			return 2;
		else if (firstByte < 0xf0)
			return 3;
		return 0; /* Illegal mb head */
	}

	/**
	 * Get the maximum length of leading bytes needed to determine the length of a
	 * multi-byte gb18030 code
	 *
	 * @param[in] cs charset_info
	 * @return number of leading bytes we need, would be 2 for gb18030 and 1 for all
	 *         other charsets
	 */
	private int myMbmaxlenlen(CharsetInfo cs) {
		return cs.mbmaxlenlen;
	}
}
