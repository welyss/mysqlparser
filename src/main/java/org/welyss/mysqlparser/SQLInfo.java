package org.welyss.mysqlparser;

import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public class SQLInfo {
	private String sql;
	private String alterCommand;
	private SQLCommand sqlCommand;
	public List<TableIdent> tableIdents;

	public SQLInfo(String sql) {
		this.sql = sql;
	}

	public SQLInfo(String sql, SQLCommand sqlCommand, List<TableIdent> tableIdents) {
		this.sql = sql;
		this.sqlCommand = sqlCommand;
		this.tableIdents = tableIdents;
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
