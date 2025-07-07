package org.welyss.mysqlparser;

import java.util.List;

public interface ParseResult {
	public boolean success();
	public List<SQLInfo> getParsedSQLInfo();
}
