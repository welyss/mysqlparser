package org.welyss.mysqlparser;

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
		if(table != null) {
			thd.lex.allTableList.add(table);
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
}
