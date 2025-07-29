package org.welyss.mysqlparser.v84;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.platform.commons.util.StringUtils;
import org.welyss.mysqlparser.MySQLThread;
import org.welyss.mysqlparser.items.TableIdent;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from class THD in sql_class.h,/sql/sql_lex.h
 */
public class SQLThread extends MySQLThread {
	public static final int NAME_CHAR_LEN = 64;
	/** < Field/table name length */
	public static final int SYSTEM_CHARSET_MBMAXLEN = 3;
	public static final int NAME_LEN = (NAME_CHAR_LEN * SYSTEM_CHARSET_MBMAXLEN);

	/* Options to add_table_to_list() */
	public static final int TL_OPTION_UPDATING = 0x01;
	public static final int TL_OPTION_IGNORE_LEAVES = 0x02;
	public static final int TL_OPTION_ALIAS = 0x04;

	public Location yylloc;
	public ParserState mParserState;
//	public SystemVariables variables;
	public boolean charsetIsSystemCharset;

	public SQLThread(String sql) {
		mParserState = new ParserState(sql, this);
//		variables = new SystemVariables();
		charsetIsSystemCharset = true;
	}

	public void addSQL(String sql) {
		parsedSqls.add(new MySQLInfo(sql, lex.sqlCommand, lex.tables, pc.alterInfo.flags));
		// Clear transient variables
		lex.tables = new ArrayList<TableIdent>();
		pc.alterInfo.flags = 0;
	}

	/**
	 * from /sql/sql_parse.cc
	 *
	 * @param tableIdent
	 * @param alias
	 * @param tableOptions
	 * @param lockType
	 * @param mdlType
	 * @return
	 * @throws SQLException
	 */
	public boolean addTableToList(TableIdent tableIdent, String alias, long tableOptions, ThrLockType lockType, MdlType mdlType) throws SQLException {
		boolean ret = false;
		String tableName = tableIdent.getTable();
		if (tableName != null) {
			// A derived table has no table name, only an alias.
			if (!((tableOptions & TL_OPTION_ALIAS) == TL_OPTION_ALIAS) && !tableIdent.isDerivedTable()) {
				IdentNameCheck identCheckStatus = checkTableName(tableName);
				if (identCheckStatus == IdentNameCheck.WRONG) {
					throw new SQLException("ER_WRONG_TABLE_NAME: [" + tableName + " ].");
//					  myError(ER_WRONG_TABLE_NAME, Myf(0), tableIdent.table.str);
//					  ret = false;
				} else if (identCheckStatus == IdentNameCheck.TOO_LONG) {
					throw new SQLException("ER_TOO_LONG_IDENT: [" + tableName + "].");
//					  myError(ER_TOO_LONG_IDENT, Myf(0), tableIdent.table.str);
//					  ret = false;
				}
			}
			String db = tableIdent.getDb();
			IdentNameCheck identCheckStatus;
			if (!tableIdent.isDerivedTable() && !tableIdent.isTableFunction() && db != null && (identCheckStatus = checkTableName(db)) != IdentNameCheck.OK) {
				throw new SQLException(identCheckStatus + ": [" + tableName + "].");
//				  ret = false;
			}
			lex.tables.add(tableIdent);
			ret = true;
		}
		return ret;
	}

	/**
	 * check if ident is correct, from /sql/table.cc
	 * @param name
	 * @return
	 */
	private IdentNameCheck checkTableName(String name) {
		// name length in symbols
		if (StringUtils.isBlank(name))
			return IdentNameCheck.WRONG;
		if (name.length() != name.trim().length()) {
			return IdentNameCheck.WRONG;
		} else if (name.length() > NAME_CHAR_LEN) {
			return IdentNameCheck.TOO_LONG;
		}
		return IdentNameCheck.OK;
	}
}
