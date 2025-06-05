package org.welyss.mysqlparser.items;

public class TableIdent extends Item {
	Token dbArg;
	Token tableArg;

	public TableIdent(Token dbArg, Token tableArg) {
		this.dbArg = dbArg;
		this.tableArg = tableArg;
	}

	public TableIdent(Token tableArg) {
		this.tableArg = tableArg;
	}

	public String getDb() {
		return dbArg == null ? null : dbArg.lexStr.str;
	}

	public String getTable() {
		return tableArg.lexStr.str;
	}

	public Integer getDbStartPos() {
		return dbArg == null ? null : dbArg.pos;
	}

	public void setDbStartPos(int pos) {
		if (dbArg != null) dbArg.pos = pos;
	}

	public Integer getTableStartPos() {
		return tableArg == null ? null : tableArg.pos;
	}

	public void setTableStartPos(int pos) {
		if (tableArg != null) tableArg.pos = pos;
	}
}
