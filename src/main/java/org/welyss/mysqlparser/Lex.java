package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public class Lex {
	SQLCommand sqlCommand;
	SelectLex selectLex = new SelectLex();
	AlterInfo alterInfo;
	CreateInfo createInfo;
	List<SelectLex> allSelectsList;
	List<TableIdent> tables;
	public long grant;
	public int allPrivileges;
	String comment;

	public Lex() {
		createInfo = new CreateInfo();
		alterInfo = new AlterInfo();
		allSelectsList = new ArrayList<SelectLex>();
		tables = new ArrayList<TableIdent>();
	}
}

class SelectLex {
	int options;
//	List<TableIdent> tableList;

	public SelectLex() {
		options = 0;
//		tableList = new ArrayList<TableIdent>();
	}
}