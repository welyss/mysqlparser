package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AlterInfo {
	Set<AlterFlag> flags;
	List<ColumnInfo> columns;

	public AlterInfo() {
		this.flags = new TreeSet<AlterFlag>();
		this.columns = new ArrayList<ColumnInfo>();
	}
}
