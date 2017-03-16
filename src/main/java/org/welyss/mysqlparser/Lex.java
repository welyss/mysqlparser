package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.TableIdent;

public class Lex {
	SQLCommand sqlCommand;
	SelectLex selectLex;
	List<SelectLex> allSelectsList = new ArrayList<SelectLex>();
	public long grant;
	public int allPrivileges;

	public Lex() {
	}

	public void mysqlInitSelect() {
		selectLex = new SelectLex();
		allSelectsList.clear();
		allSelectsList.add(selectLex);
	}
}

class SelectLex {
	int options;
	List<TableIdent> tableList;

	public SelectLex() {
		options = 0;
		tableList = new ArrayList<TableIdent>();
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