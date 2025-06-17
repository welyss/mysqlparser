package org.welyss.mysqlparser.items;

public class LexString {
	public String str;
	public int length;

	public LexString() {
		this.length = 0;
	}

	public LexString(String str) {
		this.str = str;
		this.length = this.str == null ? 0 : this.str.length();
	}
}
