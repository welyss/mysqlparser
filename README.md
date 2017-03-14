# mysqlparser
this is a mysql parser, lexer is modified from mysql5.6.35 source code to java by myself, parser is created by bison2.7.
一个mysql的sql解析，词法解析部分是人工将mysql5.6.35源码翻译成java版，语法解析部分是通过bison2.7对mysql5.6.35中sql_yacc.yy文件生成的，语义解释部分由于sql_yacc.yy中都是c语言的，所以生成的语义解释都注释掉了，导致解析以外的所有功能需要用java重新改造，目前只实现了获取sql类型，库名，表名，有时间的话可能会再追加wherelist。。。。。

# Sample
		try {
			MySQLParser parser = new MySQLParser();
			SQLResult result = parser.parser("select * from acdb.anct_account inner join bkdb.bknt_account where id = 1");
			System.out.println(result.ok());
			if (result.ok()) {
				System.out.println(result.getSQLCommand());
				for(TableIdent ident : result.getTableList()) {
					System.out.println(ident.getDb() + "." + ident.getTable());
				}
			} else {
				System.out.println(result.getErrorMsg());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
