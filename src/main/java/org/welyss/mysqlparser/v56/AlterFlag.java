package org.welyss.mysqlparser.v56;

public enum AlterFlag {
	/*
	 * These flags are set by the parser and describes the type of operation(s) specified by the ALTER TABLE statement.
	 *
	 * They do *not* describe the type operation(s) to be executed by the storage engine. For example, we don't yet know the type of index to be added/dropped.
	 */

	// Set for ADD [COLUMN]
	ALTER_ADD_COLUMN(1L << 0),

	// Set for DROP [COLUMN]
	ALTER_DROP_COLUMN(1L << 1),

	// Set for CHANGE [COLUMN] | MODIFY [CHANGE]
	// Set by mysql_recreate_table()
	ALTER_CHANGE_COLUMN(1L << 2),

	// Set for ADD INDEX | ADD KEY | ADD PRIMARY KEY | ADD UNIQUE KEY |
	// ADD UNIQUE INDEX | ALTER ADD [COLUMN]
	ALTER_ADD_INDEX(1L << 3),

	// Set for DROP PRIMARY KEY | DROP FOREIGN KEY | DROP KEY | DROP INDEX
	ALTER_DROP_INDEX(1L << 4),

	// Set for RENAME [TO]
	ALTER_RENAME(1L << 5),

	// Set for ORDER BY
	ALTER_ORDER(1L << 6),

	// Set for table_options
	ALTER_OPTIONS(1L << 7),

	// Set for ALTER [COLUMN] ... SET DEFAULT ... | DROP DEFAULT
	ALTER_CHANGE_COLUMN_DEFAULT(1L << 8),

	// Set for DISABLE KEYS | ENABLE KEYS
	ALTER_KEYS_ONOFF(1L << 9),

	// Set for FORCE
	// Set for ENGINE(same engine)
	// Set by mysql_recreate_table()
	ALTER_RECREATE(1L << 10),

	// Set for ADD PARTITION
	ALTER_ADD_PARTITION(1L << 11),

	// Set for DROP PARTITION
	ALTER_DROP_PARTITION(1L << 12),

	// Set for COALESCE PARTITION
	ALTER_COALESCE_PARTITION(1L << 13),

	// Set for REORGANIZE PARTITION ... INTO
	ALTER_REORGANIZE_PARTITION(1L << 14),

	// Set for partition_options
	ALTER_PARTITION(1L << 15),

	// Set for LOAD INDEX INTO CACHE ... PARTITION
	// Set for CACHE INDEX ... PARTITION
	ALTER_ADMIN_PARTITION(1L << 16),

	// Set for REORGANIZE PARTITION
	ALTER_TABLE_REORG(1L << 17),

	// Set for REBUILD PARTITION
	ALTER_REBUILD_PARTITION(1L << 18),

	// Set for partitioning operations specifying ALL keyword
	ALTER_ALL_PARTITION(1L << 19),

	// Set for REMOVE PARTITIONING
	ALTER_REMOVE_PARTITIONING(1L << 20),

	// Set for ADD FOREIGN KEY
	ADD_FOREIGN_KEY(1L << 21),

	// Set for DROP FOREIGN KEY
	DROP_FOREIGN_KEY(1L << 22),

	// Set for EXCHANGE PARITION
	ALTER_EXCHANGE_PARTITION(1L << 23),

	// Set by Sql_cmd_alter_table_truncate_partition::execute()
	ALTER_TRUNCATE_PARTITION(1L << 24),

	// Set for ADD [COLUMN] FIRST | AFTER
	ALTER_COLUMN_ORDER(1L << 25);

	private long value;

	private AlterFlag(long value) {
		this.value = value;
	}

	public long Value() {
		return value;
	}

	public boolean is(long flags) {
		return (flags & value) == value;
	}
}
