package mysqlparser;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.welyss.mysqlparser.MySQLParser;
import org.welyss.mysqlparser.ParseResult;

public class MySQLParserUnitTest {
	@Test
	public void case1() throws IOException {
		String sql = "select _utf8 0xD0B0D0B1D0B2;";
		MySQLParser parser = new MySQLParser();
		List<ParseResult> result = parser.parse(sql);
		assertTrue(result.get(0).isSuccess());
	}
}
