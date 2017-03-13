package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

public class Lex {
	public SQLCommand sqlCommand;
	public SelectLex selectLex = new SelectLex();
//	public SelectLex currentSelect;
//	public List<SelectLex> allSelectsList;
	public long grant;
	public int allPrivileges;

	public Lex() {
	}
}

class SelectLex {
	int options;
	List<TableIdent> tableList = new ArrayList<TableIdent>();

	public SelectLex() {
		options = 0;
	}

	public boolean addTableToList(SQLThread thd, TableIdent table, Item alias, Item partitionNames) {
		boolean success = false;
		if(table != null) {
			tableList.add(table);
			success = true;
		}
		return success;
	}
}