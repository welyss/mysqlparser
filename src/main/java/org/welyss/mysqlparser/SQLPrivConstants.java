package org.welyss.mysqlparser;

public class SQLPrivConstants {
	public static final long SELECT_DISTINCT = (1L << 0); // SELECT, user
	public static final long SELECT_STRAIGHT_JOIN = (1L << 1); // SELECT, user
	public static final long SELECT_DESCRIBE = (1L << 2); // SELECT, user
	public static final long SELECT_SMALL_RESULT = (1L << 3); // SELECT, user
	public static final long SELECT_BIG_RESULT = (1L << 4); // SELECT, user
	public static final long OPTION_FOUND_ROWS = (1L << 5); // SELECT, user
	public static final long OPTION_TO_QUERY_CACHE = (1L << 6); // SELECT, user
	public static final long SELECT_NO_JOIN_CACHE = (1L << 7); // intern
	/**
	 * always the opposite of OPTION_NOT_AUTOCOMMIT except when in
	 * fix_autocommit= ();
	 */
	public static final long OPTION_AUTOCOMMIT = (1L << 8); // THD, user
	public static final long OPTION_BIG_SELECTS = (1L << 9); // THD, user
	public static final long OPTION_LOG_OFF = (1L << 10); // THD, user
	public static final long OPTION_QUOTE_SHOW_CREATE = (1L << 11); // THD,
																	// user,
																	// unused
	public static final long TMP_TABLE_ALL_COLUMNS = (1L << 12); // SELECT,
																	// intern
	public static final long OPTION_WARNINGS = (1L << 13); // THD, user
	public static final long OPTION_AUTO_IS_NULL = (1L << 14); // THD, user,
																// binlog
	public static final long OPTION_FOUND_COMMENT = (1L << 15); // SELECT,
																// intern,
																// parser
	public static final long OPTION_SAFE_UPDATES = (1L << 16); // THD, user
	public static final long OPTION_BUFFER_RESULT = (1L << 17); // SELECT, user
	public static final long OPTION_BIN_LOG = (1L << 18); // THD, user
	public static final long OPTION_NOT_AUTOCOMMIT = (1L << 19); // THD, user
	public static final long OPTION_BEGIN = (1L << 20); // THD, intern
	public static final long OPTION_TABLE_LOCK = (1L << 21); // THD, intern
	public static final long OPTION_QUICK = (1L << 22); // SELECT = (for
														// DELETE);
	/* 23rd bit is unused. It was occupied by OPTION_KEEP_LOG. */

	/* The following is used to detect a conflict with DISTINCT */
	public static final long SELECT_ALL = (1L << 24); // SELECT, user, parser
	/**
	 * The following can be set when importing tables in a 'wrong order' to
	 * suppress foreign key checks
	 */
	public static final long OPTION_NO_FOREIGN_KEY_CHECKS = (1L << 26); // THD,
																		// user,
																		// binlog
	/**
	 * The following speeds up inserts to InnoDB tables by suppressing unique
	 * key checks in some cases
	 */
	public static final long OPTION_RELAXED_UNIQUE_CHECKS = (1L << 27); // THD,
																		// user,
																		// binlog
	public static final long SELECT_NO_UNLOCK = (1L << 28); // SELECT, intern
	public static final long OPTION_SCHEMA_TABLE = (1L << 29); // SELECT, intern
	/** Flag set if setup_tables already done */
	public static final long OPTION_SETUP_TABLES_DONE = (1L << 30); // intern
	/** If not set then the thread will ignore all warnings with level notes. */
	public static final long OPTION_SQL_NOTES = (1L << 31); // THD, user
	/**
	 * Force the used temporary table to be a MyISAM table = (because we will
	 * use fulltext functions when reading from it.
	 */
	public static final long TMP_TABLE_FORCE_MYISAM = (1L << 32);
	public static final long OPTION_PROFILING = (1L << 33);
	/**
	 * Indicates that this is a HIGH_PRIORITY SELECT. Currently used only for
	 * printing of such selects. Type of locks to be acquired is specified
	 * directly.
	 */
	public static final long SELECT_HIGH_PRIORITY = (1L << 34); // SELECT, user
	/**
	 * Is set in slave SQL thread when there was an error on master, which, when
	 * is not reproducible on slave = (i.e. the query succeeds on slave);, is
	 * not terminal to the state of repliation, and should be ignored. The slave
	 * SQL thread, however, needs to rollback the effects of the succeeded
	 * statement to keep replication consistent.
	 */
	public static final long OPTION_MASTER_SQL_ERROR = (1L << 35);

	/**
	 * Dont report errors for individual rows, But just report error on commit =
	 * (or read ofcourse); Note! Reserved for use in MySQL Cluster
	 */
	public static final long OPTION_ALLOW_BATCH = (1 << 36); // THD, intern =
																// (slave);

	public static final long SELECT_ACL = (1L << 0);
	public static final long INSERT_ACL = (1L << 1);
	public static final long UPDATE_ACL = (1L << 2);
	public static final long DELETE_ACL = (1L << 3);
	public static final long CREATE_ACL = (1L << 4);
	public static final long DROP_ACL = (1L << 5);
	public static final long RELOAD_ACL = (1L << 6);
	public static final long SHUTDOWN_ACL = (1L << 7);
	public static final long PROCESS_ACL = (1L << 8);
	public static final long FILE_ACL = (1L << 9);
	public static final long GRANT_ACL = (1L << 10);
	public static final long REFERENCES_ACL = (1L << 11);
	public static final long INDEX_ACL = (1L << 12);
	public static final long ALTER_ACL = (1L << 13);
	public static final long SHOW_DB_ACL = (1L << 14);
	public static final long SUPER_ACL = (1L << 15);
	public static final long CREATE_TMP_ACL = (1L << 16);
	public static final long LOCK_TABLES_ACL = (1L << 17);
	public static final long EXECUTE_ACL = (1L << 18);
	public static final long REPL_SLAVE_ACL = (1L << 19);
	public static final long REPL_CLIENT_ACL = (1L << 20);
	public static final long CREATE_VIEW_ACL = (1L << 21);
	public static final long SHOW_VIEW_ACL = (1L << 22);
	public static final long CREATE_PROC_ACL = (1L << 23);
	public static final long ALTER_PROC_ACL = (1L << 24);
	public static final long CREATE_USER_ACL = (1L << 25);
	public static final long EVENT_ACL = (1L << 26);
	public static final long TRIGGER_ACL = (1L << 27);
	public static final long CREATE_TABLESPACE_ACL = (1L << 28);
	/*
	 * don't forget to update; 1. static struct show_privileges_st
	 * sys_privileges[]; 2. static const char *command_array[] and static uint
	 * command_lengths[]; 3. mysql_system_tables.sql and
	 * mysql_system_tables_fix.sql; 4. acl_init() or whatever - to define
	 * behaviour for old privilege tables; 5. sql_yacc.yy - for GRANT/REVOKE to
	 * work;
	 */
	public static final long NO_ACCESS = (1L << 30);
	public static final long DB_ACLS = (UPDATE_ACL | SELECT_ACL | INSERT_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL | GRANT_ACL
			| REFERENCES_ACL | INDEX_ACL | ALTER_ACL | CREATE_TMP_ACL | LOCK_TABLES_ACL | EXECUTE_ACL | CREATE_VIEW_ACL
			| SHOW_VIEW_ACL | CREATE_PROC_ACL | ALTER_PROC_ACL | EVENT_ACL | TRIGGER_ACL);
	public static final long TABLE_ACLS = (SELECT_ACL | INSERT_ACL | UPDATE_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL | GRANT_ACL
			| REFERENCES_ACL | INDEX_ACL | ALTER_ACL | CREATE_VIEW_ACL | SHOW_VIEW_ACL | TRIGGER_ACL);
	public static final long COL_ACLS = (SELECT_ACL | INSERT_ACL | UPDATE_ACL | REFERENCES_ACL);

	public static final long PROC_ACLS = (ALTER_PROC_ACL | EXECUTE_ACL | GRANT_ACL);

	public static final long SHOW_PROC_ACLS = (ALTER_PROC_ACL | EXECUTE_ACL | CREATE_PROC_ACL);

	public static final long GLOBAL_ACLS = (SELECT_ACL | INSERT_ACL | UPDATE_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL | RELOAD_ACL
			| SHUTDOWN_ACL | PROCESS_ACL | FILE_ACL | GRANT_ACL | REFERENCES_ACL | INDEX_ACL | ALTER_ACL | SHOW_DB_ACL | SUPER_ACL
			| CREATE_TMP_ACL | LOCK_TABLES_ACL | REPL_SLAVE_ACL | REPL_CLIENT_ACL | EXECUTE_ACL | CREATE_VIEW_ACL | SHOW_VIEW_ACL
			| CREATE_PROC_ACL | ALTER_PROC_ACL | CREATE_USER_ACL | EVENT_ACL | TRIGGER_ACL | CREATE_TABLESPACE_ACL);
}
