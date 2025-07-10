package mysqlparser;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

import org.junit.Test;
import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.MySQLVersion;
import org.welyss.mysqlparser.ParseResult;
import org.welyss.mysqlparser.SQLCommand;

public class MySQLParserUnitTest {
	MySQLParser parser;

	public MySQLParserUnitTest() throws IOException {
		parser = new MySQLParser(MySQLVersion.v84);
//		parser.setDebugLevel(1);
	}

	@Test
	public void case1() throws IOException {
		String sql = "select _utf8 0xD0B0D0B1D0B2;select 1;insert into `test` values(1,2,3,4);";
//		String sql = "select _utf8 0xD0B0D0B1D0B2;";
//		String sql = "select id from acnt_account;";
		ParseResult result = parser.parse(sql);
		assertTrue(result.success());
		assertTrue(result.getParsedSQLInfo().get(0).getSQLCommand().equals(SQLCommand.SQLCOM_SELECT));
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
}
