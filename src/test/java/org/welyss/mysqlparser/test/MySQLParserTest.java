package org.welyss.mysqlparser.test;

import java.io.IOException;
import java.util.List;

import org.welyss.mysqlparser.AlterFlag;
import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.ParseResult;
import org.welyss.mysqlparser.items.TableIdent;

public class MySQLParserTest {
	public static void main(String[] args) {
		try {
			MySQLParser parser = new MySQLParser();
//			parser.setDebugLevel(1);
//			List<ParseResult> resultList = parser.parse("insert into history (itemid,clock,ns,value) values (49927,1560824767,194173205,0.120000);\n");
//			List<ParseResult> resultList = parser.parse("select * from acdb.acc where id = 1;delete from acdb.acc;insert into acdb.acc select * from acdb.acc where id = 1;");
			List<ParseResult> resultList = parser.parse("alter table acdb.`t1` add column wystest boolean;");
			for(ParseResult result : resultList) {
				System.out.println("==================================");
				System.out.println(result.isSuccess());
				System.out.println(result.getParsedSQL());
				if (result.isSuccess()) {
					System.out.println(result.hack("yyyyyffffy", "wysjsjsjsjsj"));
					System.out.println(result.getSqlCommand());
					System.out.println("inWhere: " + result.inWhere());
					System.out.println("alterCommands: " + result.getAlterCommands());
					for (AlterFlag af : result.getAlterFlags()) {
						System.out.println(af);
					}
					for (TableIdent ident : result.getTables()) {
						System.out.println(ident.getDb() + "." + ident.getTable());
					}
				} else {
					System.out.println(result.getErrorMsg());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
