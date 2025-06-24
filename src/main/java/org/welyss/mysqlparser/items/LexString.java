package org.welyss.mysqlparser.items;

/**
 * /include/lex_string.h <br>
 * /include/mysql/mysql_lex_string.h
 */
public class LexString {
	public String str;
	public int length;
	public int mPtr;

	public LexString() {
		str = null;
		length = 0;
		mPtr = 0;
	}

	public LexString(String str) {
		mPtr = 0;
		this.str = str;
		length = this.str == null ? 0 : this.str.length();
	}

	public LexString(int mPtr, String str) {
		this.mPtr = mPtr;
		this.str = str;
		length = this.str == null ? 0 : this.str.length();
	}

	public boolean isEmpty() {
		return str == null || length == 0;
	}
}
