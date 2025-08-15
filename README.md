# mysqlparser
this is a mysql parser, lexer is modified from mysql5.6.35/mysql8.4.5 source to java by myself, parser is created by bison2.7. The parser can confirm if the query correct, query type, alter type, related tables and schemas.
一个mysql的sql解析，词法解析部分是人工将mysql5.6.35和8.4.5的源码翻译成java版，语法解析部分是通过bison2.7对sql_yacc.yy文件生成的, 解析器可以确认SQL语法是否正确，SQL的类型，修改表的类型，查询涉及到的表和库.

# Sample
		
		MySQLParser parser = new MySQLParser(MySQLVersion.v84);
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
	
