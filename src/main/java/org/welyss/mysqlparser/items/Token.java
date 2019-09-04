package org.welyss.mysqlparser.items;

public class Token extends Item {
	public String lexStr;
	public int token;
	public int pos;

	public Token() {
	}

	public Token(int token) {
		this.token = token;
	}

	public Token(int token, String lexStr) {
		this.lexStr = lexStr;
		this.token = token;
	}

	public Token(String lexStr, int token, int pos) {
		this.lexStr = lexStr;
		this.token = token;
		this.pos = pos;
	}
}
