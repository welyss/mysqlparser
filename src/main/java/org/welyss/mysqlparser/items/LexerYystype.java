package org.welyss.mysqlparser.items;

import java.util.List;

public class LexerYystype extends Token {
	public LexSymbol keyword;
	public LexString hintString;
	public List<Integer> optimizerHints;
	public String charset;

	public LexerYystype() {
		keyword = null;
		optimizerHints = null;
		charset = null;
		hintString = new LexString();
	}

	public LexerYystype(LexString lexStr, LexSymbol keyword) {
		this.keyword = keyword;
		this.lexStr = lexStr;
		optimizerHints = null;
		charset = null;
		hintString = new LexString();
	}

	public LexerYystype reset() {
		keyword = null;
		optimizerHints = null;
		charset = null;
		lexStr = null;
		hintString = new LexString();
		return this;
	}
}
