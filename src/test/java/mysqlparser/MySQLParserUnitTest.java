package mysqlparser;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.ParseResult;

public class MySQLParserUnitTest {
	MySQLParser parser;

	public MySQLParserUnitTest() throws IOException {
		parser = new MySQLParser();
	}

	@Test
	public void case1() throws IOException {
		String sql = "select _utf8 0xD0B0D0B1D0B2;";
		List<ParseResult> result = parser.parse(sql);
		assertTrue(result.get(0).isSuccess());
	}

	@Test
	public void case2() throws IOException {
		String sql = "WITH\r\n"
				+ "  cte1 AS (SELECT id,c1,c2 account_id FROM t2),\r\n"
				+ "  cte2 AS (SELECT id,nm, dt FROM t3)\r\n"
				+ "SELECT cte1.c1,cte2.nm FROM cte1 JOIN cte2\r\n"
				+ "WHERE cte1.id = cte2.id;";
		List<ParseResult> result = parser.parse(sql);
		assertTrue(result.get(0).isSuccess());
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
		List<ParseResult> result = parser.parse(sql);
		assertTrue(result.get(0).isSuccess());
	}
}
