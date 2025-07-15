package org.welyss.mysqlparser.v84;

public class AuthAcls {
	/* Total Number of ACLs present in mysql.user */
	public static final long NUM_ACLS = 31;

	public static final long SELECT_ACL = (1 << 0);
	public static final long INSERT_ACL = (1 << 1);
	public static final long UPDATE_ACL = (1 << 2);
	public static final long DELETE_ACL = (1 << 3);
	public static final long CREATE_ACL = (1 << 4);
	public static final long DROP_ACL = (1 << 5);
	public static final long RELOAD_ACL = (1 << 6);
	public static final long SHUTDOWN_ACL = (1 << 7);
	public static final long PROCESS_ACL = (1 << 8);
	public static final long FILE_ACL = (1 << 9);
	/**
	 * Set to true by both GRANT GRANT OPTION ... TO ... and GRANT ... TO ... WITH GRANT OPTION
	 *
	 * Stored longo the relevant column in the priv tables for static privileges. And longo the the GRANT_OPTION column for dynamic privilege grants. Note that, once
	 * granted GRANT_OPTION applies to all static privs on the same level, i.e. the following: GRANT SELECT ON *.* TO foo; GRANT INSERT ON *.* TO foo WITH GRANT
	 * OPTION; is equivalent to: GRANT SELECT,INSERT ON *.* TO foo WITH GRANT OPTION; And is also equivalent to GRANT SELECT,INSERT, GRANT OPTION ON *.* TO foo;
	 *
	 * @sa @ref LEX::grant_privilege
	 */
	public static final long GRANT_ACL = (1 << 10);
	public static final long REFERENCES_ACL = (1 << 11);
	public static final long INDEX_ACL = (1 << 12);
	public static final long ALTER_ACL = (1 << 13);
	public static final long SHOW_DB_ACL = (1 << 14);
	public static final long SUPER_ACL = (1 << 15);
	public static final long CREATE_TMP_ACL = (1 << 16);
	public static final long LOCK_TABLES_ACL = (1 << 17);
	public static final long EXECUTE_ACL = (1 << 18);
	public static final long REPL_SLAVE_ACL = (1 << 19);
	public static final long REPL_CLIENT_ACL = (1 << 20);
	public static final long CREATE_VIEW_ACL = (1 << 21);
	public static final long SHOW_VIEW_ACL = (1 << 22);
	public static final long CREATE_PROC_ACL = (1 << 23);
	public static final long ALTER_PROC_ACL = (1 << 24);
	public static final long CREATE_USER_ACL = (1 << 25);
	public static final long EVENT_ACL = (1 << 26);
	public static final long TRIGGER_ACL = (1 << 27);
	public static final long CREATE_TABLESPACE_ACL = (1 << 28);
	public static final long CREATE_ROLE_ACL = (1 << 29);
	public static final long DROP_ROLE_ACL = (1 << 30);
	/*
	 * don't forget to update 1. static struct show_privileges_st sys_privileges[] 2. static const char *command_array[] and static ulong command_lengths[] 3.
	 * mysql_system_tables.sql and mysql_system_tables_fix.sql 4. acl_init() or whatever - to define behaviour for old privilege tables 5. sql_yacc.yy - for
	 * GRANT/REVOKE to work 6. global_privileges map and vector
	 */

	public static final long NO_ACCESS = (1 << NUM_ACLS);
	public static final long ALL_ACCESS = (NO_ACCESS - 1);

	/**
	 * Privileges to perform database related operations. Use this macro over DB_ACLS unless there is real need to use additional privileges present in the DB_ACLS
	 */
	public static final long DB_OP_ACLS = (UPDATE_ACL | SELECT_ACL | INSERT_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL | REFERENCES_ACL | INDEX_ACL | ALTER_ACL | CREATE_TMP_ACL | LOCK_TABLES_ACL
			| EXECUTE_ACL | CREATE_VIEW_ACL | SHOW_VIEW_ACL | CREATE_PROC_ACL | ALTER_PROC_ACL | EVENT_ACL | TRIGGER_ACL);

	/**
	 * Privileges to perform table related operations. Use this macro over TABLE_ACLS unless there is real need to use additional privileges present in the DB_ACLS
	 */
	public static final long TABLE_OP_ACLS = (SELECT_ACL | INSERT_ACL | UPDATE_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL | REFERENCES_ACL | INDEX_ACL | ALTER_ACL | CREATE_VIEW_ACL | SHOW_VIEW_ACL
			| TRIGGER_ACL);

	/**
	 * Privileges to modify or execute stored procedures. Use this macro over PROC_ACLS unless there is real need to use additional privileges present in the
	 * PROC_ACLS
	 */
	public static final long PROC_OP_ACLS = (ALTER_PROC_ACL | EXECUTE_ACL);

	/**
	 * Represents all privileges which could be granted to users at DB-level. It essentially represents all the privileges present in the mysql.db table.
	 */
	public static final long DB_ACLS = (DB_OP_ACLS | GRANT_ACL);

	/**
	 * Represents all privileges which could be granted to users at table-level. It essentially represents all the privileges present in the mysql.tables_priv
	 * table.
	 */
	public static final long TABLE_ACLS = (TABLE_OP_ACLS | GRANT_ACL);

	/**
	 * Represents all privileges which could be granted to users at column-level. It essentially represents all the privileges present in the columns_priv table.
	 */
	public static final long COL_ACLS = (SELECT_ACL | INSERT_ACL | UPDATE_ACL | REFERENCES_ACL);

	/**
	 * Represents all privileges which could be granted to users for stored procedures. It essentially represents all the privileges present in the mysql.procs_priv
	 * table.
	 */
	public static final long PROC_ACLS = (PROC_OP_ACLS | GRANT_ACL);

	/**
	 * Represents all privileges which are required to show the stored procedure.
	 */
	public static final long SHOW_PROC_ACLS = (PROC_OP_ACLS | CREATE_PROC_ACL);

	/**
	  Represents all privileges which could be granted to users globally.
	  It essentially represents all the privileges present in the mysql.user table
	*/
	public static final long GLOBAL_ACLS =
	  (SELECT_ACL | INSERT_ACL | UPDATE_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL |
	   RELOAD_ACL | SHUTDOWN_ACL | PROCESS_ACL | FILE_ACL | GRANT_ACL |
	   REFERENCES_ACL | INDEX_ACL | ALTER_ACL | SHOW_DB_ACL | SUPER_ACL |
	   CREATE_TMP_ACL | LOCK_TABLES_ACL | REPL_SLAVE_ACL | REPL_CLIENT_ACL |
	   EXECUTE_ACL | CREATE_VIEW_ACL | SHOW_VIEW_ACL | CREATE_PROC_ACL |
	   ALTER_PROC_ACL | CREATE_USER_ACL | EVENT_ACL | TRIGGER_ACL |
	   CREATE_TABLESPACE_ACL | CREATE_ROLE_ACL | DROP_ROLE_ACL);

	public static final long DEFAULT_CREATE_PROC_ACLS = (ALTER_PROC_ACL | EXECUTE_ACL);

	/**
	  Table-level privileges which are automatically "granted" to everyone on
	  existing temporary tables (CREATE_ACL is necessary for ALTER ... RENAME).
	*/
	public static final long TMP_TABLE_ACLS =
	  (SELECT_ACL | INSERT_ACL | UPDATE_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL |
	   INDEX_ACL | ALTER_ACL);

	/*
	  Defines to change the above bits to how things are stored in tables
	  This is needed as the 'host' and 'db' table is missing a few privileges
	*/

	/* Privileges that need to be reallocated (in continuous chunks) */
	public static final long DB_CHUNK0 =
	  (SELECT_ACL | INSERT_ACL | UPDATE_ACL | DELETE_ACL | CREATE_ACL | DROP_ACL);
	public static final long DB_CHUNK1 = (GRANT_ACL | REFERENCES_ACL | INDEX_ACL | ALTER_ACL);
	public static final long DB_CHUNK2 = (CREATE_TMP_ACL | LOCK_TABLES_ACL);
	public static final long DB_CHUNK3 =
	  (CREATE_VIEW_ACL | SHOW_VIEW_ACL | CREATE_PROC_ACL | ALTER_PROC_ACL);
	public static final long DB_CHUNK4 = (EXECUTE_ACL);
	public static final long DB_CHUNK5 = (EVENT_ACL | TRIGGER_ACL);

	public static final long fix_rights_for_db(long A) {
		return (((A)&DB_CHUNK0) | (((A) << 4) & DB_CHUNK1) | (((A) << 6) & DB_CHUNK2) |
				(((A) << 9) & DB_CHUNK3) | (((A) << 2) & DB_CHUNK4)) |
				(((A) << 9) & DB_CHUNK5);
	}

	public static final long get_rights_for_db(long A) {
		return (((A)&DB_CHUNK0) | (((A)&DB_CHUNK1) >> 4) | (((A)&DB_CHUNK2) >> 6) |
				(((A)&DB_CHUNK3) >> 9) | (((A)&DB_CHUNK4) >> 2)) |
				(((A)&DB_CHUNK5) >> 9);
	}

	public static final long TBL_CHUNK0 = DB_CHUNK0;
	public static final long TBL_CHUNK1 = DB_CHUNK1;
	public static final long TBL_CHUNK2 = (CREATE_VIEW_ACL | SHOW_VIEW_ACL);
	public static final long TBL_CHUNK3 = TRIGGER_ACL;

	public static final long fix_rights_for_table(long A) {
		return (((A)&TBL_CHUNK0) | (((A) << 4) & TBL_CHUNK1) | (((A) << 11) & TBL_CHUNK2) |
				(((A) << 15) & TBL_CHUNK3));
	}

	public static final long get_rights_for_table(long A) {
		return (((A)&TBL_CHUNK0) | (((A)&TBL_CHUNK1) >> 4) | (((A)&TBL_CHUNK2) >> 11) |
				(((A)&TBL_CHUNK3) >> 15));
	}

	public static final long fix_rights_for_column(long A) { return (((A)&7) | (((A) & ~7) << 8));}

	public static final long get_rights_for_column(long A) { return (((A)&7) | ((A) >> 8));}

	public static final long fix_rights_for_procedure(long A) {
		return ((((A) << 18) & EXECUTE_ACL) | (((A) << 23) & ALTER_PROC_ACL) |
				(((A) << 8) & GRANT_ACL));
	}

	public static final long get_rights_for_procedure(long A) {
		return ((((A)&EXECUTE_ACL) >> 18) | (((A)&ALTER_PROC_ACL) >> 23) |
				(((A)&GRANT_ACL) >> 8));
	}
}
