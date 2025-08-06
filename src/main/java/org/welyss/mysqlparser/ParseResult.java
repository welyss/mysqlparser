package org.welyss.mysqlparser;

import java.util.List;

public interface ParseResult {
	boolean success();
	List<SQLInfo> getParsedSQLInfo();
	String getErrorMsg();
}
