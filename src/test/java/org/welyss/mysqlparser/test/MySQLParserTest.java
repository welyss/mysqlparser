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
			List<ParseResult> resultList = parser.parse("alter table `acc` add column `tname` varchar(200) null default null after `bb`;alter table `eeeeeeedeee`.`acc` add column `tname` varchar(200) null default null after `bb`;alter table `fffff`.`acc` add column `tname` varchar(200) null default null after `bb`;CREATE TABLE `jjjj`.`uds_syncdata_detail` ( `id` int(10) unsigned NOT NULL AUTO_INCREMENT, `node_id` tinyint(4) unsigned NOT NULL, `sync_db` varchar(40) NOT NULL, `sync_table` varchar(100) NOT NULL, `target_table` varchar(100) DEFAULT NULL, `target_columns` varchar(2000) DEFAULT NULL, `sensitive_cols` varchar(512) DEFAULT NULL, `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (`id`), UNIQUE KEY `unq_detail` (`node_id`,`sync_db`,`sync_table`,`target_table`), KEY `fk_db_idx` (`node_id`,`sync_db`), CONSTRAINT `fk_db` FOREIGN KEY (`node_id`, `sync_db`) REFERENCES `uds_syncdata_savepoints` (`node_id`, `sync_db`) ON DELETE CASCADE ON UPDATE CASCADE ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8; ");
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
