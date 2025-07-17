package org.welyss.mysqlparser.items;

public class TableIdent extends Token {
	Token dbArg;
	Token tableArg;
	boolean sel;
	String tableFunction;

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
		return dbArg == null ? null : dbArg.lexStr.pos;
	}

	public void setDbStartPos(int pos) {
		if (dbArg != null)
			dbArg.lexStr.pos = pos;
	}

	public Integer getTableStartPos() {
		return tableArg == null ? null : tableArg.lexStr.pos;
	}

	public void setTableStartPos(int pos) {
		if (tableArg != null)
			tableArg.lexStr.pos = pos;
	}

	public boolean isDerivedTable() {
		return sel;
	}

	public boolean isTableFunction() {
		return (tableFunction != null);
	}
}
