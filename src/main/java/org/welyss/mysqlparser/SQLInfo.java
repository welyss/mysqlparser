package org.welyss.mysqlparser;

public class SQLInfo {
	private String sql;
	private String alterCommand;
	private SQLCommand sqlCommand;

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

	public String getSQL() {
		return sql;
	}

	public void setSQL(String sql) {
		this.sql = sql;
	}

	public String getAlterCommand() {
		return alterCommand;
	}

	public void setAlterCommand(String alterCommand) {
		this.alterCommand = alterCommand;
	}

	public SQLCommand getSQLCommand() {
		return sqlCommand;
	}

	public void setSQLCommand(SQLCommand sqlCommand) {
		this.sqlCommand = sqlCommand;
	}
}
