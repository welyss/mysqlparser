package org.welyss.mysqlparser;

public class SelectLex {
	public int options;
	public boolean whereOn;

	public SelectLex() {
		options = 0;
		whereOn = false;
	}
}
