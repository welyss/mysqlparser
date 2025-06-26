package org.welyss.mysqlparser;

public enum MySQLVersion {
	v56(50644), v84(80405);

	private long value;

	private MySQLVersion(long version) {
		value = version;
	}

	public long value() {
		return value;
	}
}
