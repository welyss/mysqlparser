package org.welyss.mysqlparser;

import java.util.ArrayList;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.TableIdent;

public class MyParserProcessor {

	public static void mysqlInitSelect(Lex lex) {
		lex.selectLex = new SelectLex();
		lex.allSelectsList.clear();
		lex.allSelectsList.add(lex.selectLex);
	}

	public static boolean addTableToList(SQLThread thd, TableIdent table, Item alias, Item partitionNames) {
		boolean success = false;
		if (table != null) {
			thd.lex.tables.add(table);
			success = true;
		}
		return success;
	}

	public static boolean addTableToList(Lex lex, TableIdent table, Item alias, Item partitionNames) {
		boolean success = false;
		if (table != null) {
			lex.tables.add(table);
			success = true;
		}
		return success;
	}

	public static boolean mysqlNewSelect(Lex lex, boolean moveDown) {
		boolean result = false;
		lex.selectLex = new SelectLex();
		lex.allSelectsList.add(lex.selectLex);
		return result;
	}

	public static boolean prepareSchemaTable(SQLThread thd, TableIdent table, SchemaTables schemaTableIdx) {
		boolean success = false;
		switch (schemaTableIdx) {
		case SCH_SCHEMATA:
			break;
		case SCH_TABLE_NAMES:
		case SCH_TABLES:
		case SCH_VIEWS:
		case SCH_TRIGGERS:
		case SCH_EVENTS:
			break;
		case SCH_COLUMNS:
		case SCH_STATISTICS:
			break;
		case SCH_PROFILES:
			/*
			 * Mark this current profiling record to be discarded. We don't wish
			 * to have SHOW commands show up in profiling.
			 */
			break;
		case SCH_OPTIMIZER_TRACE:
		case SCH_OPEN_TABLES:
		case SCH_VARIABLES:
		case SCH_STATUS:
		case SCH_PROCEDURES:
		case SCH_CHARSETS:
		case SCH_ENGINES:
		case SCH_COLLATIONS:
		case SCH_COLLATION_CHARACTER_SET_APPLICABILITY:
		case SCH_USER_PRIVILEGES:
		case SCH_SCHEMA_PRIVILEGES:
		case SCH_TABLE_PRIVILEGES:
		case SCH_COLUMN_PRIVILEGES:
		case SCH_TABLE_CONSTRAINTS:
		case SCH_KEY_COLUMN_USAGE:
		default:
			break;
		}
		if (table != null) {
			thd.lex.tables.add(table);
			success = true;
		}
		return success;
	}

	public static boolean addFieldToList(SQLThread thd, String column, String type) {
		boolean result = false;
		if (column != null) {
			ColumnInfo curCol = new ColumnInfo();
			curCol.name = column;
			if (type != null) {
				curCol.typeName = type;
			}
			thd.lex.alterInfo.columns.add(curCol);
			result = true;
		}
		return result;
	}
}
