package org.welyss.mysqlparser;

import java.util.Set;
import java.util.TreeSet;

public class AlterInfo {
	Set<AlterFlag> flags;

	public AlterInfo() {
		this.flags = new TreeSet<AlterFlag>();
	}
}
