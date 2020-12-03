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
			List<ParseResult> resultList = parser.parse("ALTER TABLE `biz_fund_nav`\r\n"
					+ "        CHANGE COLUMN `nav_adjfactor` `nav_adjfactor` DECIMAL(20,8) NULL DEFAULT NULL AFTER `security_code`,\r\n"
					+ "        CHANGE COLUMN `net_present_value` `net_present_value` DECIMAL(20,8) NULL DEFAULT NULL AFTER `nav_adjfactor`,\r\n"
					+ "        CHANGE COLUMN `net_present_value_change` `net_present_value_change` DECIMAL(20,8) NULL DEFAULT NULL AFTER `net_present_value`,\r\n"
					+ "        CHANGE COLUMN `cumulative_net_present_value` `cumulative_net_present_value` DECIMAL(20,8) NULL DEFAULT NULL AFTER `net_present_value_change`,\r\n"
					+ "        CHANGE COLUMN `cumulative_net_present_value_change` `cumulative_net_present_value_change` DECIMAL(20,8) NULL DEFAULT NULL AFTER `cumulative_net_present_value`,\r\n"
					+ "        CHANGE COLUMN `time_weighted_cumulative_net_present_value` `time_weighted_cumulative_net_present_value` DECIMAL(20,8) NULL DEFAULT NULL AFTER `cumulative_net_present_value_change`,\r\n"
					+ "        CHANGE COLUMN `time_weighted_cumulative_net_present_value_change` `time_weighted_cumulative_net_present_value_change` DECIMAL(20,8) NULL DEFAULT NULL AFTER `time_weighted_cumulative_net_present_value`,\r\n"
					+ "        CHANGE COLUMN `yield` `yield` DECIMAL(20,8) NULL DEFAULT NULL AFTER `time_weighted_cumulative_net_present_value_change`,\r\n"
					+ "        CHANGE COLUMN `cumulative_yield` `cumulative_yield` DECIMAL(20,8) NULL DEFAULT NULL AFTER `yield`,\r\n"
					+ "        CHANGE COLUMN `the10k_accrual` `the10k_accrual` DECIMAL(20,8) NULL DEFAULT NULL AFTER `cumulative_yield`,\r\n"
					+ "        CHANGE COLUMN `the7days_years_yield` `the7days_years_yield` DECIMAL(20,8) NULL DEFAULT NULL AFTER `the10k_accrual`,\r\n"
					+ "        CHANGE COLUMN `the14days_years_yield` `the14days_years_yield` DECIMAL(20,8) NULL DEFAULT NULL AFTER `the7days_years_yield`,\r\n"
					+ "        CHANGE COLUMN `the28days_years_yield` `the28days_years_yield` DECIMAL(20,8) NULL DEFAULT NULL AFTER `the14days_years_yield`,\r\n"
					+ "        CHANGE COLUMN `the35days_years_yield` `the35days_years_yield` DECIMAL(20,8) NULL DEFAULT NULL AFTER `the28days_years_yield`,\r\n"
					+ "        CHANGE COLUMN `rpt_netasset` `rpt_netasset` DECIMAL(20,8) NULL DEFAULT NULL COMMENT '资产净值' AFTER `id`\r\n"
					+ "/*!*/;");
			for(ParseResult result : resultList) {
				System.out.println("==================================");
				System.out.println(result.isSuccess());
				System.out.println(result.getParsedSQL());
				if (result.isSuccess()) {
					System.out.println(result.hack("yyyyyffffy", "wysjsjsjsjsj"));
					System.out.println(result.getSqlCommand());
					System.out.println("inWhere: " + result.inWhere());
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
