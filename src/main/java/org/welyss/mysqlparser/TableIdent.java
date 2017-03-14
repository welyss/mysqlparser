package org.welyss.mysqlparser;

public class TableIdent extends Item {
	String dbArg;
	String tableArg;

	public TableIdent(String dbArg, String tableArg) {
		this.dbArg = dbArg;
		this.tableArg = tableArg;
	}

	public TableIdent(String tableArg) {
		this.tableArg = tableArg;
	}

	public String getDb() {
		return dbArg;
	}

	public String getTable() {
		return tableArg;
	}
}
