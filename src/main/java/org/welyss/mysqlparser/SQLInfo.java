package org.welyss.mysqlparser;

public class SQLInfo {
	public String sql;
	public String alterCommand;
	public SQLInfo(String sql, String alterCommand) {
		this.sql = sql;
		this.alterCommand = alterCommand;
	}
}
