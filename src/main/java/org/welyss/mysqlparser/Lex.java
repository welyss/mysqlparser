package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public class Lex {
	SQLCommand sqlCommand;
	SelectLex selectLex;
	List<SelectLex> allSelectsList = new ArrayList<SelectLex>();
	List<TableIdent> allTableList = new ArrayList<TableIdent>();
	public long grant;
	public int allPrivileges;

	public Lex() {
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