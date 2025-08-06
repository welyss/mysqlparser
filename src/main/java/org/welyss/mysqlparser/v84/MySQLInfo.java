package org.welyss.mysqlparser.v84;

import java.util.List;

import org.welyss.mysqlparser.AlterColumn;
import org.welyss.mysqlparser.SQLCommand;
import org.welyss.mysqlparser.SQLInfo;
import org.welyss.mysqlparser.items.TableIdent;

public class MySQLInfo implements SQLInfo {
	private String sql;
	private String alterCommand;
	private SQLCommand sqlCommand;
	private List<TableIdent> tableIdents;
	private long alterFlags = 0;
	private boolean hasWhere;
	private List<AlterColumn> alterColumns;

	public MySQLInfo(String sql, SQLCommand sqlCommand, List<TableIdent> tableIdents, long alterFlags, String alterCommand, boolean hasWhere, List<AlterColumn> alterColumns) {
		this.sql = sql;
		this.sqlCommand = sqlCommand;
		this.tableIdents = tableIdents;
		this.alterFlags = alterFlags;
		this.alterCommand = alterCommand;
		this.hasWhere = hasWhere;
		this.alterColumns = alterColumns;
	}

	public String getSQL() {
		return sql;
	}

	public void setSQL(String sql) {
		this.sql = sql;
	}

	public String getAlterCommand() {
		String ret;
		if (alterCommand != null) {
			ret = alterCommand.trim();
		} else {
			ret = alterCommand;
		}
		return ret;
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

	public List<TableIdent> getTableIdents() {
		return tableIdents;
	}

	public void setTableIdents(List<TableIdent> tableIdents) {
		this.tableIdents = tableIdents;
	}

	@Override
	public long getAlterFlags() {
		return alterFlags;
	}

	@Override
	public boolean hasWhere() {
		return hasWhere;
	}

	@Override
	public List<AlterColumn> getAlterColumns() {
		return alterColumns;
	}
}
