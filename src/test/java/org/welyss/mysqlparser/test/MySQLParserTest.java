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
			List<ParseResult> resultList = parser.parse("CREATE DEFINER=`zabbix`@`%` PROCEDURE `partition_create`(SCHEMANAME varchar(64), TABLENAME varchar(64), PARTITIONNAME varchar(64), CLOCK int)\nBEGIN\n\n\n\n        DECLARE RETROWS INT;\n        SELECT COUNT(1) INTO RETROWS\n        FROM information_schema.partitions\n        WHERE table_schema = SCHEMANAME AND table_name = TABLENAME AND partition_description >= CLOCK;\n\n        IF RETROWS = 0 THEN\n\n                SELECT CONCAT( \"partition_create(\", SCHEMANAME, \",\", TABLENAME, \",\", PARTITIONNAME, \",\", CLOCK, \")\" ) AS msg;\n                SET @sql = CONCAT( 'ALTER TABLE ', SCHEMANAME, '.', TABLENAME, ' ADD PARTITION (PARTITION ', PARTITIONNAME, ' VALUES LESS THAN (', CLOCK, '));' );\n                PREPARE STMT FROM @sql;\n                EXECUTE STMT;\n                DEALLOCATE PREPARE STMT;\n        END IF;\nEND;"
					+ "insert into test values(1);insert into test values(2);alter table test add index `idx_test`(`idnm`)");
			for(ParseResult result : resultList) {
				System.out.println("==================================");
				System.out.println(result.getParsedSQL());
				System.out.println(result.isSuccess());
				if (result.isSuccess()) {
					System.out.println(result.getSqlCommand());
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
