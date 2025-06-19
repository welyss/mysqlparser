package org.welyss.mysqlparser.items;

import java.util.List;

public abstract class Item {
	public LexString lexStr;
	public LexSymbol keyword;
	public LexString hintString;
	public List<Integer> optimizerHints;
//	public String charset;

	public Item() {
		lexStr = null;
		keyword = null;
		optimizerHints = null;
//		charset = null;
	}
}
