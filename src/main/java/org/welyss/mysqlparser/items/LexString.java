package org.welyss.mysqlparser.items;

/**
 * /include/lex_string.h <br>
 * /include/mysql/mysql_lex_string.h
 */
public class LexString {
	public String str;
	public int length;
	public int pos;

	public LexString() {
		str = null;
		length = 0;
		pos = 0;
	}

	public LexString(String str) {
		pos = 0;
		this.str = str;
		length = this.str == null ? 0 : this.str.length();
	}

	public LexString(String str, int mPtr) {
		this.pos = mPtr;
		this.str = str;
		length = this.str == null ? 0 : this.str.length();
	}

	public boolean isEmpty() {
		return str == null || length == 0;
	}
}
