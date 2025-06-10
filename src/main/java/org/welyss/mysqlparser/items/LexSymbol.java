package org.welyss.mysqlparser.items;

public class LexSymbol {
	public Integer symbol;
	public String str;
	public int length;

	public LexSymbol(Integer symbol, String str, int length) {
		this.symbol = symbol;
		this.str = str;
		this.length = length;
	}
}
