package org.welyss.mysqlparser.v84;

public enum DeleteOption {
	DELETE_QUICK(1 << 0), DELETE_LOW_PRIORITY(1 << 1), DELETE_IGNORE(1 << 2);

	private int value;

	private DeleteOption(int value) {
		this.value = value;
	}

	public int intValue() {
		return value;
	}
}
