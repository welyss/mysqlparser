package org.welyss.mysqlparser.items;

public class Token {
	public int token;
	public LexString lexStr;

	public Token() {
		token = -1;
		lexStr = new LexString();
	}

	public Token(int token) {
		this.token = token;
	}

	public Token(int token, String lexStr) {
		this.lexStr = new LexString(lexStr);
		this.token = token;
	}

	public Token(int token, String lexStr, int pos) {
		this.lexStr = new LexString(lexStr, pos);
		this.token = token;
	}
}
