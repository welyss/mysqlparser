package org.welyss.mysqlparser.items;

import java.util.List;

public abstract class Item {
	public LexString lexStr;
	public LexSymbol keyword;
	public List<Integer> optimizerHints;

	public Item() {
		lexStr = null;
		keyword = null;
		optimizerHints = null;
	}
}
