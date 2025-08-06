package org.welyss.mysqlparser.v84;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.ParseResult;
import org.welyss.mysqlparser.SQLInfo;

public class MyParseResult implements ParseResult {
	protected Boolean success;
	protected List<SQLInfo> parsedSQLInfo;
	protected String errorMsg;

	public MyParseResult() {
		parsedSQLInfo = new ArrayList<SQLInfo>();
	}

	public MyParseResult(List<SQLInfo> parsedSQLInfo) {
		this.parsedSQLInfo = parsedSQLInfo;
	}

	public boolean setSuccess(boolean success) {
		return this.success = success;
	}

	@Override
	public boolean success() {
		return success;
	}

	@Override
	public List<SQLInfo> getParsedSQLInfo() {
		return parsedSQLInfo;
	}

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
