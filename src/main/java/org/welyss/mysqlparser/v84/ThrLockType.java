package org.welyss.mysqlparser.v84;

public enum ThrLockType {
	TL_IGNORE(-1), TL_UNLOCK(1), /* UNLOCK ANY LOCK */
	/*
	 * Parser only! At open_tables() becomes TL_READ or TL_READ_NO_INSERT depending on the binary log format (SBR/RBR) and on the table category (log table). Used
	 * for tables that are read by statements which modify tables.
	 */
	TL_READ_DEFAULT(2), TL_READ(3), /* Read lock */
	TL_READ_WITH_SHARED_LOCKS(4),
	/* High prior. than TL_WRITE. Allow concurrent insert */
	TL_READ_HIGH_PRIORITY(5),
	/* READ, Don't allow concurrent insert */
	TL_READ_NO_INSERT(6),
	/*
	 * Write lock, but allow other threads to read / write. Used by BDB tables in MySQL to mark that someone is reading/writing to the table.
	 */
	TL_WRITE_ALLOW_WRITE(7),
	/*
	 * parser only! Late bound low_priority_flag. At open_tables() becomes thd->insert_lock_default.
	 */
	TL_WRITE_CONCURRENT_DEFAULT(8),
	/*
	 * WRITE lock used by concurrent insert. Will allow READ, if one could use concurrent insert on table.
	 */
	TL_WRITE_CONCURRENT_INSERT(9),
	/*
	 * parser only! Late bound low_priority flag. At open_tables() becomes thd->update_lock_default.
	 */
	TL_WRITE_DEFAULT(10),
	/* WRITE lock that has lower priority than TL_READ */
	TL_WRITE_LOW_PRIORITY(11),
	/* Normal WRITE lock */
	TL_WRITE(12),
	/* Abort new lock request with an error */
	TL_WRITE_ONLY(13);

	private Integer value;

	ThrLockType(int value) {
		this.value = value;
	}

	ThrLockType() {
		value = null;
	}

	public int intValue() {
		return value;
	}
}
