package org.welyss.mysqlparser.v84;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.ParseResult;
import org.welyss.mysqlparser.SQLInfo;

public class MyParseResult implements ParseResult {
	public Boolean success;
	public List<SQLInfo> parsedSQLInfo;

	public MyParseResult() {
		parsedSQLInfo = new ArrayList<SQLInfo>();
	}

	public MyParseResult(List<SQLInfo> parsedSQLInfo) {
		this.parsedSQLInfo = parsedSQLInfo;
	}

	@Override
	public boolean success() {
		return success;
	}

	public boolean setSuccess(boolean success) {
		return this.success = success;
	}

	@Override
	public List<SQLInfo> getParsedSQLInfo() {
		return parsedSQLInfo;
	}
}
