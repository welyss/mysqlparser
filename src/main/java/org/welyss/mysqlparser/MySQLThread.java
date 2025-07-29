package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

public abstract class MySQLThread {
	public String msg;
	public List<SQLInfo> parsedSqls;
	public Lex lex = new Lex();
	public ParseContext pc;

	public MySQLThread() {
		parsedSqls = new ArrayList<SQLInfo>();
		pc = new ParseContext();
	}
}
