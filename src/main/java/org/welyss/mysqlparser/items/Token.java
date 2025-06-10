package org.welyss.mysqlparser.items;

public class Token extends Item {
	public int token;
	public int pos;

	public Token() {
	}

	public Token(int token) {
		this.token = token;
	}

	public Token(int token, String lexStr) {
		this.lexStr = new LexString(lexStr);
		this.token = token;
	}

	public Token(String lexStr, int token, int pos) {
		this.lexStr = new LexString(lexStr);
		this.token = token;
		this.pos = pos;
	}
}
