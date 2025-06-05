package org.welyss.mysqlparser.items;

public class LexStr {
	public String str;
	public int length;

	public LexStr(String str) {
		this.str = str;
		this.length = this.str == null ? 0 : this.str.length();
	}
}
