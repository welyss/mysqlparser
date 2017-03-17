package org.welyss.mysqlparser.items;

public class Token extends Item {
	public String lexStr;
	public int token;

	public Token() {
	}

	public Token(int token) {
		this.token = token;
	}

	public Token(int token, String lexStr) {
		this.lexStr = lexStr;
		this.token = token;
	}
}
