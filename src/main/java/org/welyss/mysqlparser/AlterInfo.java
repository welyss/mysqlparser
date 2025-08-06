package org.welyss.mysqlparser;

import java.util.ArrayList;
import java.util.List;

public class AlterInfo {
//	public Set<AlterFlag> flags;
	public long flags = 0;
	public List<AlterColumn> columns;

	public AlterInfo() {
//		this.flags = new TreeSet<AlterFlag>();
		this.columns = new ArrayList<AlterColumn>();
	}
}
