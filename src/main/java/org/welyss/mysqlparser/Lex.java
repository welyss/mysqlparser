package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public class Lex {
	public SQLCommand sqlCommand;
	public SelectLex selectLex = new SelectLex();
	public AlterInfo alterInfo;
	public CreateInfo createInfo;
	public List<SelectLex> allSelectsList;
	public List<TableIdent> tables;
	public List<TableIdent> tableReferenceList;
	public long grant;
	public int allPrivileges;
	public int alterPos;
	public String comment;
	public boolean whereExists;

	public Lex() {
		createInfo = new CreateInfo();
		alterInfo = new AlterInfo();
		allSelectsList = new ArrayList<SelectLex>();
		tables = new ArrayList<TableIdent>();
		tableReferenceList = new ArrayList<TableIdent>();
		whereExists = false;
		alterPos = 0;
	}
}
