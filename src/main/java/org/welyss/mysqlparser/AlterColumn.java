package org.welyss.mysqlparser;

public class AlterColumn {
	public String name;
	public String changedName;
	public String typeName;

	public AlterColumn(String name, String typeName) {
		this(name, null, typeName);
	}

	public AlterColumn(String name, String changedName, String typeName) {
		this.name = name;
		this.changedName = changedName;
		this.typeName = typeName;
	}

	public AlterColumn(String name) {
		this(name, null, null);
	}
}
