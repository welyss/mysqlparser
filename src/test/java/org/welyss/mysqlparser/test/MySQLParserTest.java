package org.welyss.mysqlparser.test;

import java.io.IOException;

import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.SQLResult;
import org.welyss.mysqlparser.items.TableIdent;

public class MySQLParserTest {
	public static void main(String[] args) {
		try {
			MySQLParser parser = new MySQLParser();
			SQLResult result = parser.parse("/*导入历史清算数据*/\nINSERT tg_mimicplaid_yield_history (mimicplaid,day_yield,last_date) \nSELECT mimicplaid,profit_rate,STR_TO_DATE(CALC_DATE,'%Y%m%d') from  tg_yield where serialno!=3534");
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
