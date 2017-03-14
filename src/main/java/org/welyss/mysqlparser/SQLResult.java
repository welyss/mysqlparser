package org.welyss.mysqlparser;

import java.util.List;

public interface SQLResult {
	boolean ok();
	SQLCommand getSQLCommand();
	List<TableIdent> getTableList();
	String getErrorMsg();
}
