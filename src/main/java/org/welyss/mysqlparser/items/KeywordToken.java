package org.welyss.mysqlparser.items;

public class KeywordToken extends Token {
	public Symbol symbol;

	public KeywordToken(int token, String lexStr, String symbolStr) {
		super(token, lexStr);
		this.symbol = new Symbol(symbolStr);
	}

	class Symbol {
		public String symbolStr;

		public Symbol(String symbolStr) {
			this.symbolStr = symbolStr;
		}
	}
}