package org.welyss.mysqlparser.v84;

public enum AlterFlag {
	/// Set for ADD [COLUMN]
	ALTER_ADD_COLUMN(1l << 0),

	/// Set for DROP [COLUMN]
	ALTER_DROP_COLUMN(1l << 1),

	/// Set for CHANGE [COLUMN] | MODIFY [CHANGE]
	/// Set by mysql_recreate_table()
	ALTER_CHANGE_COLUMN(1l << 2),

	/// Set for ADD INDEX | ADD KEY | ADD PRIMARY KEY | ADD UNIQUE KEY |
	/// ADD UNIQUE INDEX | ALTER ADD [COLUMN]
	ALTER_ADD_INDEX(1l << 3),

	/// Set for DROP PRIMARY KEY | DROP FOREIGN KEY | DROP KEY | DROP INDEX
	ALTER_DROP_INDEX(1l << 4),

	/// Set for RENAME [TO]
	ALTER_RENAME(1l << 5),

	/// Set for ORDER BY
	ALTER_ORDER(1l << 6),

	/// Set for table_options
	ALTER_OPTIONS(1l << 7),

	/// Set for ALTER [COLUMN] ... SET DEFAULT ... | DROP DEFAULT
	ALTER_CHANGE_COLUMN_DEFAULT(1l << 8),

	/// Set for DISABLE KEYS | ENABLE KEYS
	ALTER_KEYS_ONOFF(1l << 9),

	/// Set for FORCE
	/// Set for ENGINE(same engine)
	/// Set by mysql_recreate_table()
	ALTER_RECREATE(1l << 10),

	/// Set for ADD PARTITION
	ALTER_ADD_PARTITION(1l << 11),

	/// Set for DROP PARTITION
	ALTER_DROP_PARTITION(1l << 12),

	/// Set for COALESCE PARTITION
	ALTER_COALESCE_PARTITION(1l << 13),

	/// Set for REORGANIZE PARTITION ... INTO
	ALTER_REORGANIZE_PARTITION(1l << 14),

	/// Set for partition_options
	ALTER_PARTITION(1l << 15),

	/// Set for LOAD INDEX INTO CACHE ... PARTITION
	/// Set for CACHE INDEX ... PARTITION
	ALTER_ADMIN_PARTITION(1l << 16),

	/// Set for REORGANIZE PARTITION
	ALTER_TABLE_REORG(1l << 17),

	/// Set for REBUILD PARTITION
	ALTER_REBUILD_PARTITION(1l << 18),

	/// Set for partitioning operations specifying ALL keyword
	ALTER_ALL_PARTITION(1l << 19),

	/// Set for REMOVE PARTITIONING
	ALTER_REMOVE_PARTITIONING(1l << 20),

	/// Set for ADD FOREIGN KEY
	ADD_FOREIGN_KEY(1l << 21),

	/// Set for DROP FOREIGN KEY
	DROP_FOREIGN_KEY(1l << 22),

	/// Set for EXCHANGE PARTITION
	ALTER_EXCHANGE_PARTITION(1l << 23),

	/// Set by Sql_cmd_alter_table_truncate_partition::execute()
	ALTER_TRUNCATE_PARTITION(1l << 24),

	/// Set for ADD [COLUMN] FIRST | AFTER
	ALTER_COLUMN_ORDER(1l << 25),

	/// Set for RENAME INDEX
	ALTER_RENAME_INDEX(1l << 26),

	/// Set for discarding the tablespace
	ALTER_DISCARD_TABLESPACE(1l << 27),

	/// Set for importing the tablespace
	ALTER_IMPORT_TABLESPACE(1l << 28),

	/// Means that the visibility of an index is changed.
	ALTER_INDEX_VISIBILITY(1l << 29),

	/// Set for SECONDARY LOAD
	ALTER_SECONDARY_LOAD(1l << 30),

	/// Set for SECONDARY UNLOAD
	ALTER_SECONDARY_UNLOAD(1l << 31),

	/// Set for add check constraint.
	ADD_CHECK_CONSTRAINT(1l << 32),

	/// Set for drop check constraint.
	DROP_CHECK_CONSTRAINT(1l << 33),

	/// Set for check constraint enforce.
	ENFORCE_CHECK_CONSTRAINT(1l << 34),

	/// Set for check constraint suspend.
	SUSPEND_CHECK_CONSTRAINT(1l << 35),

	/// Set for DROP CONSTRAINT.
	DROP_ANY_CONSTRAINT(1l << 36),

	/// Set for ALTER CONSTRAINT symbol ENFORCED.
	ENFORCE_ANY_CONSTRAINT(1l << 37),

	/// Set for ALTER CONSTRAINT symbol NOT ENFORCED.
	SUSPEND_ANY_CONSTRAINT(1l << 38),

	/// Set if ANY engine attribute is used (also in CREATE) Note that
	/// this is NOT to be set for SECONDARY_ENGINE_ATTRIBUTE as this flag
	/// controls if execution should check if SE supports engine
	/// attributes.
	ANY_ENGINE_ATTRIBUTE(1l << 39),

	/// Set for column visibility attribute alter.
	ALTER_COLUMN_VISIBILITY(1l << 40);

	private long value;

	private AlterFlag(long value) {
		this.value = value;
	}

	public long longVal() {
		return value;
	}
}
