package org.welyss.mysqlparser.items;

public abstract class Item {
	public LexString lexStr;
	public LexSymbol keyword;

	public Item() {
		lexStr = null;
		keyword = null;
	}
}
