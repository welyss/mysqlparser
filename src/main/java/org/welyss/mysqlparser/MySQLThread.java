package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

public abstract class MySQLThread {
	public int foundSemicolon;
	public String msg;
	public SQLCommand lastSQLCommand;
	protected List<SQLInfo> parsedSqls = new ArrayList<SQLInfo>();
}
