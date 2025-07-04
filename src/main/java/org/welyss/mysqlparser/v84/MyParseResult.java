package org.welyss.mysqlparser.v84;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.ParseItem;
import org.welyss.mysqlparser.ParseResult;

public class MyParseResult implements ParseResult {
	public Boolean success;
	public List<ParseItem> parseItems;

	public MyParseResult() {
		parseItems = new ArrayList<ParseItem>();
	}

	@Override
	public boolean success() {
		return success;
	}

	public boolean setSuccess(boolean success) {
		return this.success = success;
	}
}
