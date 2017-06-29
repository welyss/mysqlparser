package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public class Lex {
	SQLCommand sqlCommand;
	SelectLex selectLex;
	AlterInfo alterInfo;
	List<SelectLex> allSelectsList;
	List<TableIdent> allTableList;
	public long grant;
	public int allPrivileges;

	public Lex() {
		alterInfo = new AlterInfo();
		allSelectsList = new ArrayList<SelectLex>();
		allTableList = new ArrayList<TableIdent>();
	}
}

class SelectLex {
	int options;
	List<TableIdent> tableList;

	public SelectLex() {
		options = 0;
		tableList = new ArrayList<TableIdent>();
	}
}