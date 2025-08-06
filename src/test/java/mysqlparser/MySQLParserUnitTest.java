package mysqlparser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.MySQLVersion;
import org.welyss.mysqlparser.ParseResult;
import org.welyss.mysqlparser.SQLCommand;
import org.welyss.mysqlparser.SQLInfo;
import org.welyss.mysqlparser.items.TableIdent;

public class MySQLParserUnitTest {
	MySQLParser parser;

	public MySQLParserUnitTest() throws IOException {
		parser = new MySQLParser(MySQLVersion.v84);
//		parser.setDebugLevel(1);
	}

	@Test
	public void case1() throws IOException {
//		String sql = "select _utf8 0xD0B0D0B1D0B2;select 1;insert into `test` values(1,2,3,4);";
//		String sql = "SET RESOURCE GROUP rg2 FOR 14, 78, 4;";
//		String sql = "rename table db1.t1 to `db2`.`t2`;";
//		String sql = "lock tables changelog read;";
//		String sql = "INSERT INTO t1 (a,b,c) VALUES (1,2,3) ON DUPLICATE KEY UPDATE c=c+1;";
//		String sql = "replace INTO t1 (a,b,c) VALUES (1,2,3) ON DUPLICATE KEY UPDATE c=c+1;";
//		String sql = "UPDATE acdb.t SET id = id + 1 WHERE t.id=1 ORDER BY id DESC;";
//		String sql = "SELECT * FROM JSON_TABLE( '[{\"a\":\"3\"},{\"a\":2},{\"b\":1},{\"a\":0},{\"a\":[1,2]}]', \"$[*]\" COLUMNS( rowid FOR ORDINALITY, ac VARCHAR(100) PATH \"$.a\" DEFAULT '111' ON EMPTY DEFAULT '999' ON ERROR, aj JSON PATH \"$.a\" DEFAULT '{\"x\": 333}' ON EMPTY, bx INT EXISTS PATH \"$.b\" ) ) AS tt;";
//		String sql = "SELECT * FROM acdb";
//		String sql = "show index in t1;show full columns in t4;";
//		String sql = "ALTER TABLE pt EXCHANGE PARTITION p WITH TABLE nt;";
//		String sql = "drop index idx_1 on t4;";
//		String sql = "LOAD INDEX INTO CACHE t1, t2 IGNORE LEAVES;";
//		String sql = "ANALYZE TABLE t UPDATE HISTOGRAM ON c1;";
//		String sql = "CREATE TRIGGER tg1 AFTER INSERT ON t1 FOR EACH ROW PRECEDES tg2 BEGIN insert into t2 values(1,2,3); END";
//		String sql = "alter table acdb.t1 add column age int unsigned comment '年龄', drop column aa;";
//		String sql = "ALTER TABLE t1 rebuild PARTITION p1, p2;";
//		String sql = "ALTER TABLE t1 rebuild PARTITION ALL;ALTER TABLE t1 add column age int;";
		String sql = "alter table fof_asset_allocation_rate_bond alter column DISABLE set default  1;\r\n"
				+ "alter table fof_asset_allocation_credit_bond alter column DISABLE set default  1;\r\n"
				+ "alter table fof_asset_allocation_convert_bond alter column DISABLE set default  1;\r\n"
				+ "alter table fof_asset_allocation_domestic_interest alter column DISABLE set default  1;\r\n"
				+ "alter table fof_asset_allocation_us_stock alter column DISABLE set default  1;\r\n"
				+ "alter table fof_asset_allocation_h_stock alter column DISABLE set default  1;\r\n"
				+ "alter table fof_asset_allocation_product alter column DISABLE set default  1;";
//		String sql = "repair NO_WRITE_TO_BINLOG table t1, t2 quick EXTENDED USE_FRM ;";
//		String sql = "select 1;";
//		String sql = "LOAD DATA INFILE '/tmp/test.txt' INTO TABLE test IGNORE 1 LINES;";
//		String sql = "UPDATE /*+ NO_MERGE(discounted) */ items, (SELECT id FROM items2 WHERE retail / wholesale >= 1.3 AND quantity < 100) AS discounted SET items.retail = items.retail * 0.9 WHERE items.id = discounted.id;";
//		String sql = "UPDATE /*+ NO_MERGE(discounted) */ items, discounted SET items.retail = items.retail * 0.9 WHERE items.id = discounted.id;";
//		String sql = "UPDATE items, (SELECT id FROM items2 WHERE retail / wholesale >= 1.3 AND quantity < 100) AS discounted SET items.retail = items.retail * 0.9 WHERE items.id = discounted.id;";
//		String sql = "DELETE FROM t1, t2 USING t1 INNER JOIN t2 INNER JOIN t3 WHERE t1.id=t2.id AND t2.id=t3.id;";
//		String sql = "select _utf8 0xD0B0D0B1D0B2;";
//		String sql = "select id from acnt_account;";
		ParseResult result = parser.parse(sql);
//		long alterFlags = result.getParsedSQLInfo().get(0).getAlterFlags();
//		assertTrue(org.welyss.mysqlparser.v84.AlterFlag.ALTER_REBUILD_PARTITION.is(alterFlags));
//		assertTrue(org.welyss.mysqlparser.v84.AlterFlag.ALTER_ALL_PARTITION.is(alterFlags));
//		assertTrue("add column age int".equals(result.getParsedSQLInfo().get(0).getAlterCommand()));
		assertTrue(result.success());
//		assertTrue(result.getParsedSQLInfo().get(0).getSQLCommand().equals(SQLCommand.SQLCOM_SELECT));
	}

	@Test
	public void case2() throws IOException {
		String sql = "WITH\r\n"
				+ "  cte1 AS (SELECT id,c1,c2 account_id FROM t2),\r\n"
				+ "  cte2 AS (SELECT id,nm, dt FROM t3)\r\n"
				+ "SELECT cte1.c1,cte2.nm FROM cte1 JOIN cte2\r\n"
				+ "WHERE cte1.id = cte2.id;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
	}

	@Test
	public void case3() throws IOException {
		String sql = "WITH current_assets AS (\r\n"
				+ "        SELECT \r\n"
				+ "            INST_ID,\r\n"
				+ "            MPD_ID,\r\n"
				+ "            MPD_UNIT,\r\n"
				+ "            TOTL_AST as 总资产,\r\n"
				+ "             (COALESCE(MKT_VAL1, 0) + COALESCE(MKT_VAL2, 0) + COALESCE(MKT_VAL3, 0) + COALESCE(MKT_VAL4, 0) \r\n"
				+ "             + COALESCE(MKT_VAL5, 0) + COALESCE(MKT_VAL6, 0) + COALESCE(ON_WAY_AST, 0)) AS 场外理财资产,\r\n"
				+ "        (COALESCE(MKT_VAL1, 0) + COALESCE(MKT_VAL2, 0) + COALESCE(MKT_VAL3, 0) + COALESCE(MKT_VAL4, 0) + COALESCE(MKT_VAL5, 0) + COALESCE(MKT_VAL6, 0)) as 理财持仓市值,\r\n"
				+ "               (COALESCE(CPTL_BAL, 0) - COALESCE(FRZ_AMT, 0) - COALESCE(THIS_FRZ_AMT, 0)) as 可用资金,\r\n"
				+ "        flot_Ret as 浮动盈亏,\r\n"
				+ "        MKT_VAL1 as 公募基金市值,\r\n"
				+ "        MKT_VAL2 as 私募基金市值\r\n"
				+ "        FROM \r\n"
				+ "            TIFP_MPD_STAT_DT\r\n"
				+ "        WHERE \r\n"
				+ "            dt = 20250522\r\n"
				+ "),\r\n"
				+ "previous_assets_week AS (\r\n"
				+ "    SELECT \r\n"
				+ "        INST_ID,\r\n"
				+ "            MPD_ID,\r\n"
				+ "            MPD_UNIT,\r\n"
				+ "             (COALESCE(MKT_VAL1, 0) + COALESCE(MKT_VAL2, 0) + COALESCE(MKT_VAL3, 0) + COALESCE(MKT_VAL4, 0) \r\n"
				+ "             + COALESCE(MKT_VAL5, 0) + COALESCE(MKT_VAL6, 0) + COALESCE(ON_WAY_AST, 0)) AS 场外理财资产\r\n"
				+ "    FROM \r\n"
				+ "        TIFP_MPD_STAT_DT\r\n"
				+ "    WHERE \r\n"
				+ "        dt = 20250516\r\n"
				+ "),\r\n"
				+ "previous_assets_month AS (\r\n"
				+ "    SELECT \r\n"
				+ "        INST_ID,\r\n"
				+ "            MPD_ID,\r\n"
				+ "            MPD_UNIT,\r\n"
				+ "             (COALESCE(MKT_VAL1, 0) + COALESCE(MKT_VAL2, 0) + COALESCE(MKT_VAL3, 0) + COALESCE(MKT_VAL4, 0) \r\n"
				+ "             + COALESCE(MKT_VAL5, 0) + COALESCE(MKT_VAL6, 0) + COALESCE(ON_WAY_AST, 0)) AS 场外理财资产\r\n"
				+ "    FROM \r\n"
				+ "        TIFP_MPD_STAT_DT\r\n"
				+ "    WHERE \r\n"
				+ "        dt = 20250430\r\n"
				+ "),\r\n"
				+ "previous_assets_year AS (\r\n"
				+ "    SELECT \r\n"
				+ "        INST_ID,\r\n"
				+ "            MPD_ID,\r\n"
				+ "            MPD_UNIT,\r\n"
				+ "             (COALESCE(MKT_VAL1, 0) + COALESCE(MKT_VAL2, 0) + COALESCE(MKT_VAL3, 0) + COALESCE(MKT_VAL4, 0) \r\n"
				+ "             + COALESCE(MKT_VAL5, 0) + COALESCE(MKT_VAL6, 0) + COALESCE(ON_WAY_AST, 0)) AS 场外理财资产\r\n"
				+ "    FROM \r\n"
				+ "        TIFP_MPD_STAT_DT\r\n"
				+ "    WHERE \r\n"
				+ "        dt = 20241231\r\n"
				+ ")\r\n"
				+ " SELECT \r\n"
				+ "        STAT.INST_ID as 机构代码,\r\n"
				+ "        STAT.MPD_ID as 产品编码,\r\n"
				+ "        mpd.mpd_nm as 产品清单,\r\n"
				+ "        STAT.MPD_UNIT,\r\n"
				+ "        STAT.总资产,\r\n"
				+ "        stat.场外理财资产,\r\n"
				+ "        stat.场外理财资产- COALESCE(pre_w.场外理财资产, 0) AS 本周新增场外理财资产,\r\n"
				+ "        stat.场外理财资产- COALESCE(pre_m.场外理财资产, 0) AS 本月新增场外理财资产,\r\n"
				+ "        stat.场外理财资产- COALESCE(pre_y.场外理财资产, 0) AS 本年度新增场外理财资产,\r\n"
				+ "        stat.理财持仓市值,\r\n"
				+ "               stat.可用资金,\r\n"
				+ "        stat.浮动盈亏,\r\n"
				+ "        STAT.公募基金市值,\r\n"
				+ "        STAT.私募基金市值\r\n"
				+ "FROM current_assets STAT\r\n"
				+ "left join previous_assets_week pre_w on stat.inst_id=pre_w.inst_id and stat.mpd_id=pre_w.mpd_id\r\n"
				+ "left join previous_assets_month pre_m on stat.inst_id=pre_m.inst_id and stat.mpd_id=pre_m.mpd_id\r\n"
				+ "left join previous_assets_year pre_y on stat.inst_id=pre_y.inst_id and stat.mpd_id=pre_y.mpd_id \r\n"
				+ "left join TIFP_MPD_INF mpd on stat.inst_id=mpd.inst_id and stat.mpd_id=mpd.mpd_id";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
	}

	@Test
	public void case4() throws IOException {
		String sql = "CREATE TABLE acdb.`std_fund_companies` (\r\n"
				+ "  `id` varchar(40) NOT NULL COMMENT 'ID',\r\n"
				+ "  `name` varchar(255) NOT NULL COMMENT '基金公司名称',\r\n"
				+ "  `abbr_name` varchar(255) DEFAULT NULL COMMENT '公司简称',\r\n"
				+ "  `pinyin_abbr_name` varchar(255) DEFAULT NULL COMMENT '拼音简称',\r\n"
				+ "  `founding_date` varchar(10) DEFAULT NULL COMMENT '成立日期',\r\n"
				+ "  `legal_person` varchar(255) DEFAULT NULL COMMENT '法人代表',\r\n"
				+ "  `telephone_number` varchar(255) DEFAULT NULL COMMENT '电话号码',\r\n"
				+ "  `contact_address` varchar(255) DEFAULT NULL COMMENT '联系地址',\r\n"
				+ "  `briefing` varchar(3400) DEFAULT NULL,\r\n"
				+ "  `last_modified_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',\r\n"
				+ "  `gazx_compainies_id` varchar(20) DEFAULT NULL COMMENT '基金公司ID(GaoTime)',\r\n"
				+ "  PRIMARY KEY (`id`),\r\n"
				+ "  KEY `last_modified_dt` (`last_modified_dt`),\r\n"
				+ "  KEY `name` (`name`)\r\n"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金公司信息表';\r\n"
//				+ "insert into `std_fund_companies` values(1,2,3);";
				+ "insert into `bkdb`.`std_fund_companies` values(1,2,3);";
//		String sql = "CREATE TABLE `std_fund_companies` (\r\n"
//				+ "  `id` varchar(40) NOT NULL COMMENT 'ID',\r\n"
//				+ "  `name` varchar(255) NOT NULL COMMENT '基金公司名称',\r\n"
//				+ "  `abbr_name` varchar(255) DEFAULT NULL COMMENT '公司简称',\r\n"
//				+ "  `pinyin_abbr_name` varchar(255) DEFAULT NULL COMMENT '拼音简称',\r\n"
//				+ "  `founding_date` varchar(10) DEFAULT NULL COMMENT '成立日期',\r\n"
//				+ "  `legal_person` varchar(255) DEFAULT NULL COMMENT '法人代表',\r\n"
//				+ "  `telephone_number` varchar(255) DEFAULT NULL COMMENT '电话号码',\r\n"
//				+ "  `contact_address` varchar(255) DEFAULT NULL COMMENT '联系地址',\r\n"
//				+ "  `briefing` varchar(2000) DEFAULT NULL COMMENT '公司简介',\r\n"
//				+ "  `last_modified_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',\r\n"
//				+ "  `gazx_compainies_id` varchar(20) DEFAULT NULL COMMENT '基金公司ID(GaoTime)',\r\n"
//				+ "  PRIMARY KEY (`id`),\r\n"
//				+ "  KEY `last_modified_dt` (`last_modified_dt`),\r\n"
//				+ "  KEY `name` (`name`)\r\n"
//				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='基金公司信息表'";
		ParseResult result = parser.parse(sql);
		assertTrue(result.success());
	}

	@Test
	public void case5() throws IOException {
		String sql = "CREATE TABLE `t_json` (\r\n"
				+ "  `id` int NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `col1` varchar(200) DEFAULT NULL,\r\n"
				+ "  `col2` varchar(200) DEFAULT NULL,\r\n"
				+ "  `key1` int DEFAULT NULL,\r\n"
				+ "  `key2` int DEFAULT NULL,\r\n"
				+ "  `jsoncol` json,\r\n"
				+ "  `dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\r\n"
				+ "  PRIMARY KEY (`id`),\r\n"
				+ "  KEY `idx_k12` (`key1`,`key2`)\r\n"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=1310726 DEFAULT CHARSET=utf8mb4;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
	}

	@Test
	public void case6() throws IOException {
		String sql = "select _utf8 0xD0B0D0B1D0B2;insert into `test` values(1,2,3,4);update t1 set a=123 where id = 1;delete from t2 where id =22;";
//		String sql = "select _utf8 0xD0B0D0B1D0B2;";
//		String sql = "select id from acnt_account;";
		ParseResult result = parser.parse(sql);
		assertTrue(result.success());
		assertTrue(result.getParsedSQLInfo().size() == 4);
		assertTrue(result.getParsedSQLInfo().get(0).getSQLCommand().equals(SQLCommand.SQLCOM_SELECT));
		assertTrue(result.getParsedSQLInfo().get(1).getSQLCommand().equals(SQLCommand.SQLCOM_INSERT));
		assertTrue(result.getParsedSQLInfo().get(2).getSQLCommand().equals(SQLCommand.SQLCOM_UPDATE));
		assertTrue(result.getParsedSQLInfo().get(3).getSQLCommand().equals(SQLCommand.SQLCOM_DELETE));
	}

	@Test
	public void case7() throws IOException {
		String sql = "CREATE TABLE t_zhxx_d(\r\n"
				+ "  cust_id varchar(64) comment '客户号', \r\n"
				+ "  cust_name varchar(255) comment '客户姓名',  \r\n"
				+ "  mob varchar(20) comment '手机号', \r\n"
				+ "  cust_stat varchar(50) comment '客户状态', \r\n"
				+ "  chn_attr varchar(50) comment '渠道',\r\n"
				+ "  zzc decimal(16,2) comment '总资产', \r\n"
				+ "  zzc_jzjy decimal(22,2) comment '总资产(普通)', \r\n"
				+ "  zzc_rzrq decimal(22,2) comment '总资产(两融)', \r\n"
				+ "  zzc_ggqq decimal(16,2) comment '总资产(期权)', \r\n"
				+ "  gos_cms decimal(38,6) comment '毛佣金', \r\n"
				+ "  chag_sm decimal(38,8) comment '手续费_私募', \r\n"
				+ "  chag_zg decimal(38,8) comment '手续费_资管', \r\n"
				+ "  chag_xt decimal(38,8) comment '手续费_信托', \r\n"
				+ "  chag_cw decimal(38,8) comment '手续费_公募基金', \r\n"
				+ "  chag_zgzx decimal(38,8) comment '手续费_资管直销', \r\n"
				+ "  glf_xt decimal(38,6) comment '管理费_信托', \r\n"
				+ "  glf_sm decimal(38,6) comment '管理费_私募', \r\n"
				+ "  glf_zg decimal(38,6) comment '管理费_资管', \r\n"
				+ "  glf_jjtgzx decimal(38,6) comment '管理费_基金投顾直销', \r\n"
				+ "  proc_date datetime comment '执行时间',\r\n"
				+ "  day_id varchar(20) comment '数据所属日期',\r\n"
				+ "  PRIMARY KEY (cust_id, day_id),\r\n"
				+ "  KEY idx_chn_attr (chn_attr)\r\n"
				+ " ) \r\n"
				+ " COMMENT '客户账户信息日表'\r\n"
				+ " PARTITION BY RANGE (CAST(SUBSTRING(day_id, 1, 6) AS UNSIGNED)) (\r\n"
				+ "    -- 2025年8月至2026年7月的分区\r\n"
				+ "    PARTITION p_202508 VALUES LESS THAN (202509),\r\n"
				+ "    PARTITION p_202509 VALUES LESS THAN (202510),\r\n"
				+ "    PARTITION p_202510 VALUES LESS THAN (202511),\r\n"
				+ "    PARTITION p_202511 VALUES LESS THAN (202512),\r\n"
				+ "    PARTITION p_202512 VALUES LESS THAN (202601),\r\n"
				+ "    PARTITION p_202601 VALUES LESS THAN (202602),\r\n"
				+ "    PARTITION p_202602 VALUES LESS THAN (202603),\r\n"
				+ "    PARTITION p_202603 VALUES LESS THAN (202604),\r\n"
				+ "    PARTITION p_202604 VALUES LESS THAN (202605),\r\n"
				+ "    PARTITION p_202605 VALUES LESS THAN (202606),\r\n"
				+ "    PARTITION p_202606 VALUES LESS THAN (202607),\r\n"
				+ "    PARTITION p_202607 VALUES LESS THAN (202608),\r\n"
				+ "    -- 兜底分区（处理超出未来一年的意外数据）\r\n"
				+ "    PARTITION p_max VALUES LESS THAN MAXVALUE\r\n"
				+ ");";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
	}

	@Test
	public void case8() throws IOException {
		String sql = "alter table t_b_article\r\n"
				+ "    add audit_id           bigint               null comment '审核id',\r\n"
				+ "    add audit_status       varchar(32)          null comment '审核状态',\r\n"
				+ "    add cover_image        varchar(255)         null comment '封面图片URL',\r\n"
				+ "    add category           varchar(255)         null comment '文章分类',\r\n"
				+ "    add content_url        varchar(255)         null comment '文章内容URL',\r\n"
				+ "    add linked_products    varchar(255)         null,\r\n"
				+ "    add distribution_type  varchar(32)          null comment '分销类型',\r\n"
				+ "    add listing_status     varchar(32)          null comment '上架状态',\r\n"
				+ "    add trial_content_url  varchar(255)         null comment '试用内容URL',\r\n"
				+ "    add snippet_trial      tinyint(1)           null comment '是否支持试看',\r\n"
				+ "    add sale_type          varchar(50)          null comment '销售类型',\r\n"
				+ "    add price              double               null comment '价格',\r\n"
				+ "    add original_price     double               null comment '划线价格',\r\n"
				+ "    add validity_type      varchar(50)          null comment '有效期类型',\r\n"
				+ "    add expiration_time    varchar(255)         null comment '到期时间',\r\n"
				+ "    add duration_days      int                  null comment '有效天数',\r\n"
				+ "    add mode               varchar(32)          null comment '文章模式',\r\n"
				+ "    add operation_setting  json                 null comment '运营设置（JSON格式）',\r\n"
				+ "    add creator            bigint               null comment '创建者ID',\r\n"
				+ "    add deleted            tinyint(1) default 0 null comment '是否已删除',\r\n"
				+ "    add listing_start_time datetime             null,\r\n"
				+ "    add article_brief      varchar(255)         null,\r\n"
				+ "    add listing_type varchar(12)  null comment '上架类型',\r\n"
				+ "    add pay_picture  varchar(255) null comment '支付助手二维码';";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
	}

	@Test
	public void case9() throws IOException {
		String sql = "set names utf8mb4;set autocommit = off;set global innodb_lock_wait_timeout = 120;show global variables like '%wait_%';";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			assertTrue(SQLCommand.SQLCOM_SET_OPTION.equals(list.get(0).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SET_OPTION.equals(list.get(1).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SET_OPTION.equals(list.get(2).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SHOW_VARIABLES.equals(list.get(3).getSQLCommand()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			assertTrue(SQLCommand.SQLCOM_SET_OPTION.equals(list.get(0).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SET_OPTION.equals(list.get(1).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SET_OPTION.equals(list.get(2).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SHOW_VARIABLES.equals(list.get(3).getSQLCommand()));
		}
		sql = "show index in t1;show full columns in t4;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			assertTrue(SQLCommand.SQLCOM_SHOW_KEYS.equals(list.get(0).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SHOW_FIELDS.equals(list.get(1).getSQLCommand()));
			assertTrue(list.get(0).getTableIdents().get(0).getTable().equals("t1"));
			assertEquals(list.get(1).getTableIdents().get(0).getTable(), "t4");
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			assertTrue(SQLCommand.SQLCOM_SHOW_KEYS.equals(list.get(0).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SHOW_FIELDS.equals(list.get(1).getSQLCommand()));
			assertTrue(list.get(0).getTableIdents().get(0).getTable().equals("t1"));
			assertEquals(list.get(1).getTableIdents().get(0).getTable(), "t4");
		}
	}

	@Test
	public void case10() throws IOException {
		String sql = "start replica for channel 'a';START REPLICA UNTIL SQL_AFTER_MTS_GAPS;stop replica for channel 'a'";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
			assertNotNull(result.getErrorMsg());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			assertTrue(SQLCommand.SQLCOM_REPLICA_START.equals(list.get(0).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_REPLICA_START.equals(list.get(1).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_REPLICA_STOP.equals(list.get(2).getSQLCommand()));
		}
		sql = "start slave;stop slave";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			assertTrue(SQLCommand.SQLCOM_SLAVE_START.equals(list.get(0).getSQLCommand()));
			assertTrue(SQLCommand.SQLCOM_SLAVE_STOP.equals(list.get(1).getSQLCommand()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertFalse(result.success());
			assertNotNull(result.getErrorMsg());
		}
	}

	@Test
	public void case11() throws IOException {
		String sql = "rename table db1.t1 to `db2`.`t2`;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("db1".equals(ti1.getDb()));
			assertTrue("t1".equals(ti1.getTable()));
			TableIdent ti2 = list.get(0).getTableIdents().get(1);
			assertTrue("db2".equals(ti2.getDb()));
			assertTrue("t2".equals(ti2.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("db1".equals(ti1.getDb()));
			assertTrue("t1".equals(ti1.getTable()));
			TableIdent ti2 = list.get(0).getTableIdents().get(1);
			assertTrue("db2".equals(ti2.getDb()));
			assertTrue("t2".equals(ti2.getTable()));
		}
		sql = "lock tables changelog read;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("changelog".equals(ti1.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("changelog".equals(ti1.getTable()));
		}
		sql = "handler t1 open as tt;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("t1".equals(ti1.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("t1".equals(ti1.getTable()));
		}
		sql = "handler t1 read `primary` = (11) limit 20;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("t1".equals(ti1.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("t1".equals(ti1.getTable()));
		}
	}

	@Test
	public void case12() throws IOException {
		String sql = "DELETE t1, t2 FROM db1.ta t1 INNER JOIN db2.tb t2 INNER JOIN db3.tc t3 WHERE t1.id=t2.id AND t2.id=t3.id;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_DELETE_MULTI));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("db1".equals(ti1.getDb()));
			assertTrue("ta".equals(ti1.getTable()));
			TableIdent ti2 = row.getTableIdents().get(1);
			assertTrue("db2".equals(ti2.getDb()));
			assertTrue("tb".equals(ti2.getTable()));
			TableIdent ti3 = row.getTableIdents().get(2);
			assertTrue("db3".equals(ti3.getDb()));
			assertTrue("tc".equals(ti3.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_DELETE_MULTI));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("db1".equals(ti1.getDb()));
			assertTrue("ta".equals(ti1.getTable()));
			TableIdent ti2 = row.getTableIdents().get(1);
			assertTrue("db2".equals(ti2.getDb()));
			assertTrue("tb".equals(ti2.getTable()));
			TableIdent ti3 = row.getTableIdents().get(2);
			assertTrue("db3".equals(ti3.getDb()));
			assertTrue("tc".equals(ti3.getTable()));
		}
		sql = "DELETE FROM t1, t2 USING t1 INNER JOIN t2 INNER JOIN t3 WHERE t1.id=t2.id AND t2.id=t3.id;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_DELETE_MULTI));
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("t1".equals(ti1.getTable()));
			TableIdent ti2 = list.get(0).getTableIdents().get(1);
			assertTrue("t2".equals(ti2.getTable()));
			TableIdent ti3 = list.get(0).getTableIdents().get(2);
			assertTrue("t3".equals(ti3.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_DELETE_MULTI));
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("t1".equals(ti1.getTable()));
			TableIdent ti2 = list.get(0).getTableIdents().get(1);
			assertTrue("t2".equals(ti2.getTable()));
			TableIdent ti3 = list.get(0).getTableIdents().get(2);
			assertTrue("t3".equals(ti3.getTable()));
		}
		sql = "INSERT INTO acdb.t1 (a,b,c) VALUES (1,2,3) ON DUPLICATE KEY UPDATE c=c+1;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_INSERT));
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("acdb".equals(ti1.getDb()));
			assertTrue("t1".equals(ti1.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_INSERT));
			TableIdent ti1 = list.get(0).getTableIdents().get(0);
			assertTrue("acdb".equals(ti1.getDb()));
			assertTrue("t1".equals(ti1.getTable()));
		}
		sql = "INSERT INTO a.t1 (a,b,c) select * from b.t2 x join b.t3 y on x.id = y.id where name = '123';";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_INSERT_SELECT));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("a".equals(ti1.getDb()));
			assertTrue("t1".equals(ti1.getTable()));
			TableIdent ti2 = row.getTableIdents().get(1);
			assertTrue("b".equals(ti2.getDb()));
			assertTrue("t2".equals(ti2.getTable()));
			TableIdent ti3 = row.getTableIdents().get(2);
			assertTrue("b".equals(ti3.getDb()));
			assertTrue("t3".equals(ti3.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_INSERT_SELECT));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("a".equals(ti1.getDb()));
			assertTrue("t1".equals(ti1.getTable()));
			TableIdent ti2 = row.getTableIdents().get(1);
			assertTrue("b".equals(ti2.getDb()));
			assertTrue("t2".equals(ti2.getTable()));
			TableIdent ti3 = row.getTableIdents().get(2);
			assertTrue("b".equals(ti3.getDb()));
			assertTrue("t3".equals(ti3.getTable()));
		}
		sql = "UPDATE /*+ NO_MERGE(discounted) */ `acdb`.`items`, (SELECT id FROM `bkdb`.`items2` WHERE retail / wholesale >= 1.3 AND quantity < 100) AS discounted SET items.retail = items.retail * 0.9 WHERE items.id = discounted.id;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_UPDATE_MULTI));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("acdb".equals(ti1.getDb()));
			assertTrue("items".equals(ti1.getTable()));
			TableIdent ti2 = row.getTableIdents().get(1);
			assertTrue("bkdb".equals(ti2.getDb()));
			assertTrue("items2".equals(ti2.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_UPDATE_MULTI));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("acdb".equals(ti1.getDb()));
			assertTrue("items".equals(ti1.getTable()));
			TableIdent ti2 = row.getTableIdents().get(1);
			assertTrue("bkdb".equals(ti2.getDb()));
			assertTrue("items2".equals(ti2.getTable()));
		}
		sql = "UPDATE acdb.t SET id = id + 1 WHERE t.id=1 ORDER BY id DESC;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_UPDATE));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("acdb".equals(ti1.getDb()));
			assertTrue("t".equals(ti1.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_UPDATE));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertTrue("acdb".equals(ti1.getDb()));
			assertTrue("t".equals(ti1.getTable()));
		}
	}

	@Test
	public void case13() throws IOException {
		String sql = "SELECT * FROM JSON_TABLE( '[{\"a\":\"3\"},{\"a\":2},{\"b\":1},{\"a\":0},{\"a\":[1,2]}]', \"$[*]\" COLUMNS( rowid FOR ORDINALITY, ac VARCHAR(100) PATH \"$.a\" DEFAULT '111' ON EMPTY DEFAULT '999' ON ERROR, aj JSON PATH \"$.a\" DEFAULT '{\"x\": 333}' ON EMPTY, bx INT EXISTS PATH \"$.b\" ) ) AS tt;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
		sql = "SELECT\r\n"
				+ "  salesperson.name,\r\n"
				+ "  max_sale.amount,\r\n"
				+ "  max_sale_customer.customer_name\r\n"
				+ "FROM\r\n"
				+ "  salesperson,\r\n"
				+ "  -- calculate maximum size, cache it in transient derived table max_sale\r\n"
				+ "  LATERAL\r\n"
				+ "  (SELECT MAX(amount) AS amount\r\n"
				+ "    FROM all_sales\r\n"
				+ "    WHERE all_sales.salesperson_id = salesperson.id)\r\n"
				+ "  AS max_sale,\r\n"
				+ "  -- find customer, reusing cached maximum size\r\n"
				+ "  LATERAL\r\n"
				+ "  (SELECT customer_name\r\n"
				+ "    FROM all_sales\r\n"
				+ "    WHERE all_sales.salesperson_id = salesperson.id\r\n"
				+ "    AND all_sales.amount =\r\n"
				+ "        -- the cached maximum size\r\n"
				+ "        max_sale.amount)\r\n"
				+ "  AS max_sale_customer;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
		}
	}

	@Test
	public void case14() throws IOException {
		String sql = "CACHE INDEX t1, t2, t3 IN hot_cache;CACHE INDEX pt PARTITION (p1, p3) IN kc_slow;LOAD INDEX INTO CACHE t1, t2 IGNORE LEAVES;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_ASSIGN_TO_KEYCACHE));
			TableIdent ti1 = row.getTableIdents().get(0);
			TableIdent ti2 = row.getTableIdents().get(1);
			TableIdent ti3 = row.getTableIdents().get(2);
			assertTrue("t1".equals(ti1.getTable()));
			assertTrue("t2".equals(ti2.getTable()));
			assertTrue("t3".equals(ti3.getTable()));
			row = list.get(1);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_ASSIGN_TO_KEYCACHE));
			ti1 = row.getTableIdents().get(0);
			assertTrue("pt".equals(ti1.getTable()));
			row = list.get(2);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_PRELOAD_KEYS));
			ti1 = row.getTableIdents().get(0);
			ti2 = row.getTableIdents().get(1);
			assertTrue("t1".equals(ti1.getTable()));
			assertTrue("t2".equals(ti2.getTable()));
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_ASSIGN_TO_KEYCACHE));
			TableIdent ti1 = row.getTableIdents().get(0);
			TableIdent ti2 = row.getTableIdents().get(1);
			TableIdent ti3 = row.getTableIdents().get(2);
			assertTrue("t1".equals(ti1.getTable()));
			assertTrue("t2".equals(ti2.getTable()));
			assertTrue("t3".equals(ti3.getTable()));
			row = list.get(1);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_ASSIGN_TO_KEYCACHE));
			ti1 = row.getTableIdents().get(0);
			assertTrue("pt".equals(ti1.getTable()));
			row = list.get(2);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_PRELOAD_KEYS));
			ti1 = row.getTableIdents().get(0);
			ti2 = row.getTableIdents().get(1);
			assertTrue("t1".equals(ti1.getTable()));
			assertTrue("t2".equals(ti2.getTable()));
		}
		sql = "LOAD DATA INFILE '/tmp/test.txt' INTO TABLE test IGNORE 1 LINES;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_LOAD));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("test", ti1.getTable());
		} else if(parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_LOAD));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("test", ti1.getTable());
		}
	}

	@Test
	public void case15() throws IOException {
		String sql = "repair NO_WRITE_TO_BINLOG table t1, t2 quick EXTENDED USE_FRM ;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_REPAIR));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_REPAIR));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		}
		sql = "ANALYZE TABLE t UPDATE HISTOGRAM ON c1;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertFalse(result.success());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_ANALYZE));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t", ti1.getTable());
		}
		sql = "CHECK TABLE t1,t2 FOR UPGRADE quick fast;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_CHECK));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_CHECK));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		}
		sql = "OPTIMIZE NO_WRITE_TO_BINLOG TABLE t1, t2;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_OPTIMIZE));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_OPTIMIZE));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		}
		sql = "DROP TABLE t1;DROP VIEW v1;FLUSH TABLES t1,t2 WITH READ LOCK;";
		result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row1 = list.get(0);
			assertTrue(row1.getSQLCommand().equals(SQLCommand.SQLCOM_DROP_TABLE));
			TableIdent ti1 = row1.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			SQLInfo row2 = list.get(1);
			assertTrue(row2.getSQLCommand().equals(SQLCommand.SQLCOM_DROP_VIEW));
			ti1 = row2.getTableIdents().get(0);
			assertEquals("v1", ti1.getTable());
			SQLInfo row3 = list.get(2);
			assertTrue(row3.getSQLCommand().equals(SQLCommand.SQLCOM_FLUSH));
			ti1 = row3.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row3.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row1 = list.get(0);
			assertTrue(row1.getSQLCommand().equals(SQLCommand.SQLCOM_DROP_TABLE));
			TableIdent ti1 = row1.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			SQLInfo row2 = list.get(1);
			assertTrue(row2.getSQLCommand().equals(SQLCommand.SQLCOM_DROP_VIEW));
			ti1 = row2.getTableIdents().get(0);
			assertEquals("v1", ti1.getTable());
			SQLInfo row3 = list.get(2);
			assertTrue(row3.getSQLCommand().equals(SQLCommand.SQLCOM_FLUSH));
			ti1 = row3.getTableIdents().get(0);
			assertEquals("t1", ti1.getTable());
			TableIdent ti2 = row3.getTableIdents().get(1);
			assertEquals("t2", ti2.getTable());
		}
	}

	@Test
	public void case16() throws IOException {
		String sql = "CREATE DEFINER=`platform_app`@`%` TRIGGER `subject_category_assoc_after_update` AFTER UPDATE ON `acdb`.`subject_category_assoc` FOR EACH ROW BEGIN\r\n"
				+ "        insert into `bkdb`.double_key_log (table_name,action,key1,key2) values ('subject_category_assoc', 'update',new.subject_id,new.subject_category_id);\r\n"
				+ "END";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_CREATE_TRIGGER));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("acdb", ti1.getDb());
			assertEquals("subject_category_assoc", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("bkdb", ti2.getDb());
			assertEquals("double_key_log", ti2.getTable());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row = list.get(0);
			assertTrue(row.getSQLCommand().equals(SQLCommand.SQLCOM_CREATE_TRIGGER));
			TableIdent ti1 = row.getTableIdents().get(0);
			assertEquals("acdb", ti1.getDb());
			assertEquals("subject_category_assoc", ti1.getTable());
			TableIdent ti2 = row.getTableIdents().get(1);
			assertEquals("bkdb", ti2.getDb());
			assertEquals("double_key_log", ti2.getTable());
		}
	}

	@Test
	public void case17() throws IOException {
		String sql = "desc acdb.t1;show full columns from `bkdb`.`t2`;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row1 = list.get(0);
			assertTrue(row1.getSQLCommand().equals(SQLCommand.SQLCOM_SHOW_FIELDS));
			TableIdent ti1 = row1.getTableIdents().get(0);
			assertEquals("acdb", ti1.getDb());
			assertEquals("t1", ti1.getTable());
			SQLInfo row2 = list.get(1);
			assertTrue(row2.getSQLCommand().equals(SQLCommand.SQLCOM_SHOW_FIELDS));
			ti1 = row2.getTableIdents().get(0);
			assertEquals("bkdb", ti1.getDb());
			assertEquals("t2", ti1.getTable());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row1 = list.get(0);
			assertTrue(row1.getSQLCommand().equals(SQLCommand.SQLCOM_SHOW_FIELDS));
			TableIdent ti1 = row1.getTableIdents().get(0);
			assertEquals("acdb", ti1.getDb());
			assertEquals("t1", ti1.getTable());
			SQLInfo row2 = list.get(1);
			assertTrue(row2.getSQLCommand().equals(SQLCommand.SQLCOM_SHOW_FIELDS));
			ti1 = row2.getTableIdents().get(0);
			assertEquals("bkdb", ti1.getDb());
			assertEquals("t2", ti1.getTable());
		}
	}

	@Test
	public void case18() throws IOException {
		String sql = "ALTER TABLE acdb.t1 rebuild PARTITION ALL;ALTER TABLE bkdb.t2 add column age int;";
		ParseResult result = parser.parse(sql);
		if (parser.version().equals(MySQLVersion.v56)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row1 = list.get(0);
			assertTrue(row1.getSQLCommand().equals(SQLCommand.SQLCOM_ALTER_TABLE));
			TableIdent ti1 = row1.getTableIdents().get(0);
			assertEquals("acdb", ti1.getDb());
			assertEquals("t1", ti1.getTable());
			assertEquals("rebuild PARTITION ALL", row1.getAlterCommand());
			SQLInfo row2 = list.get(1);
			assertTrue(row2.getSQLCommand().equals(SQLCommand.SQLCOM_ALTER_TABLE));
			ti1 = row2.getTableIdents().get(0);
			assertEquals("bkdb", ti1.getDb());
			assertEquals("t2", ti1.getTable());
			assertEquals("add column age int", row2.getAlterCommand());
		} else if (parser.version().equals(MySQLVersion.v84)) {
			assertTrue(result.success());
			List<SQLInfo> list = result.getParsedSQLInfo();
			SQLInfo row1 = list.get(0);
			assertTrue(row1.getSQLCommand().equals(SQLCommand.SQLCOM_ALTER_TABLE));
			TableIdent ti1 = row1.getTableIdents().get(0);
			assertEquals("acdb", ti1.getDb());
			assertEquals("t1", ti1.getTable());
			assertEquals("rebuild PARTITION ALL", row1.getAlterCommand());
			SQLInfo row2 = list.get(1);
			assertTrue(row2.getSQLCommand().equals(SQLCommand.SQLCOM_ALTER_TABLE));
			ti1 = row2.getTableIdents().get(0);
			assertEquals("bkdb", ti1.getDb());
			assertEquals("t2", ti1.getTable());
			assertEquals("add column age int", row2.getAlterCommand());
		}
	}
}
