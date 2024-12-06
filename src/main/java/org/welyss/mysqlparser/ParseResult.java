package org.welyss.mysqlparser;

import java.util.List;
import java.util.Set;

import org.welyss.mysqlparser.items.TableIdent;

public class ParseResult {
	private boolean success;
	private String parsedSQL;
	private SQLCommand sqlCommand;
	private List<TableIdent> tables;
	private String errorMsg;
	private Set<AlterFlag> alterFlags;
	private List<AlterColumnInfo> alterColumnInfos;
	private boolean inWhere;
	private String alterCommand;

	public ParseResult(boolean success, String parsedSQL, SQLCommand sqlCommand, List<TableIdent> tables, String errorMsg, Set<AlterFlag> alterFlags, boolean inWhere, String alterCommand, List<AlterColumnInfo> alterColumnInfos) {
		this.success = success;
		this.parsedSQL = parsedSQL;
		this.sqlCommand = sqlCommand;
		this.tables = tables;
		this.errorMsg = errorMsg;
		this.alterFlags = alterFlags;
		this.inWhere = inWhere;
		this.alterCommand = alterCommand;
		this.alterColumnInfos = alterColumnInfos;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public SQLCommand getSqlCommand() {
		return sqlCommand;
	}
	public void setSqlCommand(SQLCommand sqlCommand) {
		this.sqlCommand = sqlCommand;
	}
	public List<TableIdent> getTables() {
		return tables;
	}
	public void setTables(List<TableIdent> tables) {
		this.tables = tables;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Set<AlterFlag> getAlterFlags() {
		return alterFlags;
	}
	public void setAlterFlags(Set<AlterFlag> alterFlags) {
		this.alterFlags = alterFlags;
	}
	public String getParsedSQL() {
		return parsedSQL.trim();
	}
	public void setParsedSQL(String parsedSQL) {
		this.parsedSQL = parsedSQL;
	}
	public boolean inWhere() {
		return inWhere;
	}
	public void setInWhere(boolean inWhere) {
		this.inWhere = inWhere;
	}
	public String getAlterCommand() {
		return alterCommand;
	}
	public void setAlterCommand(String alterCommand) {
		this.alterCommand = alterCommand;
	}

	public List<AlterColumnInfo> getAlterColumnInfos() {
		return alterColumnInfos;
	}

	public void setAlterColumnInfos(List<AlterColumnInfo> alterColumnInfos) {
		this.alterColumnInfos = alterColumnInfos;
	}

	public String hack(String schema, String table) {
		StringBuilder result = new StringBuilder(parsedSQL);
		if (!sqlCommand.equals(SQLCommand.SQLCOM_EMPTY_QUERY)) {
			if (tables.size() > 0) {
				TableIdent ti = tables.get(0);
				if (ti.getDbStartPos() != null) {
					int offset = 0;
					if (schema != null && schema.trim().length() > 0) {
						result.delete(ti.getDbStartPos(), ti.getDbStartPos() + ti.getDb().length()).insert(ti.getDbStartPos(), schema);
						offset = ti.getDb().length() - schema.length();
					}
					if (table != null && table.trim().length() > 0) {
						offset = ti.getTableStartPos() - offset;
						result.delete(offset, offset + ti.getTable().length()).insert(offset, table);
					}
				} else if (ti.getTableStartPos() != null) {
					if (table != null && table.trim().length() > 0) {
						result.delete(ti.getTableStartPos(), ti.getTableStartPos() + ti.getTable().length()).insert(ti.getTableStartPos(), table);
					}
				}
			}
		}
		return result.toString().trim();
	}
	public String hack(String schema) {
		return hack(schema, null);
	}
}
