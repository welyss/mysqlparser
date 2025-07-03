package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

public abstract class MySQLThread {
	public String msg;
	public List<SQLInfo> parsedSqls = new ArrayList<SQLInfo>();
	public Lex lex = new Lex();
}
