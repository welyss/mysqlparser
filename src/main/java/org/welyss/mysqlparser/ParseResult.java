package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

public class ParseResult {
	public Boolean success;
	public List<ParseItem> parseItems;

	public ParseResult() {
		parseItems = new ArrayList<ParseItem>();
	}
}
