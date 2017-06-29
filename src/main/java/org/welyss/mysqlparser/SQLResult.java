package org.welyss.mysqlparser;

import java.util.List;
import java.util.Set;

import org.welyss.mysqlparser.items.TableIdent;

public interface SQLResult {
	boolean ok();
	SQLCommand getSQLCommand();
	List<TableIdent> getTableList();
	String getErrorMsg();
	Set<AlterFlag> getAlterFlags();
}
