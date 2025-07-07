package org.welyss.mysqlparser;

public class SQLInfo {
	public String sql;
	public String alterCommand;
	public SQLCommand sqlCommand;

	public SQLInfo(String sql) {
		this.sql = sql;
	}

	public SQLInfo(String sql, SQLCommand sqlCommand) {
		this.sql = sql;
		this.sqlCommand = sqlCommand;
	}

	public SQLInfo(String sql, String alterCommand) {
		this.sql = sql;
		this.alterCommand = alterCommand;
	}

	public SQLInfo(String sql, String alterCommand, SQLCommand sqlCommand) {
		this.sql = sql;
		this.alterCommand = alterCommand;
		this.sqlCommand = sqlCommand;
	}
}
