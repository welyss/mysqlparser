package org.welyss.mysqlparser.test;

import java.io.IOException;

import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.SQLResult;
import org.welyss.mysqlparser.items.TableIdent;

public class MySQLParserTest {
	public static void main(String[] args) {
		try {
			MySQLParser parser = new MySQLParser();
			SQLResult result = parser.parse("select * from acdb.anct_account inner join bkdb.bknt_account where id = 1");
			System.out.println(result.ok());
			if (result.ok()) {
				System.out.println(result.getSQLCommand());
				for (TableIdent ident : result.getTableList()) {
					System.out.println(ident.getDb() + "." + ident.getTable());
				}
			} else {
				System.out.println(result.getErrorMsg());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
