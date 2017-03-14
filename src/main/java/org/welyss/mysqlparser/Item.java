package org.welyss.mysqlparser;

public class Item {
	String lexStr;

	public Item() {
	}

	public Item(String lexStr) {
		this.lexStr = lexStr;
	}
}

class Token extends Item {
	public int token;

	public Token(int token) {
		this.token = token;
	}

	public Token(int token, String lexStr) {
		super(lexStr);
		this.token = token;
	}
}

class KeywordToken extends Token {
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
