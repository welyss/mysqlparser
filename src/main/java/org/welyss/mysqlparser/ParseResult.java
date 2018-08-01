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

	public ParseResult(boolean success, String parsedSQL, SQLCommand sqlCommand,
			List<TableIdent> tables, String errorMsg,
			Set<AlterFlag> alterFlags) {
		this.success = success;
		this.parsedSQL = parsedSQL;
		this.sqlCommand = sqlCommand;
		this.tables = tables;
		this.errorMsg = errorMsg;
		this.alterFlags = alterFlags;
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
		return parsedSQL;
	}

	public void setParsedSQL(String parsedSQL) {
		this.parsedSQL = parsedSQL;
	}

}
