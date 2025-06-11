package org.welyss.mysqlparser.v84;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.Position;
import org.welyss.mysqlparser.v84.MyParser.Lexer;
import org.welyss.mysqlparser.v84.MyParser.Location;

/**
 * Convert from sql_lex.cc, include my_sql_parser_lex,lex_one_token... function.<br>
 * <b>CHARSET_INFO</b> is from include/mysql/strings/m_ctype.h and utf8mb3/utf8mb4 instance in strings/ctype-utf8.cc.
 */
public class MyLexer implements Lexer {
	LexStateMapsSt stateMaps;
	public static Map<String, Symbol> symbols;

	static {
		// Initialize symbols map
		symbols = new HashMap<String, Symbol>();
		/*
		 * Insert new SQL keywords after that commentary (by alphabetical order):
		 */
		symbols.put("&&", new Symbol("&&", Symbol.AND_AND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("<", new Symbol("<", Symbol.LT, Symbol.SG_KEYWORDS));
		symbols.put("<=", new Symbol("<=", Symbol.LE, Symbol.SG_KEYWORDS));
		symbols.put("<>", new Symbol("<>", Symbol.NE, Symbol.SG_KEYWORDS));
		symbols.put("!=", new Symbol("!=", Symbol.NE, Symbol.SG_KEYWORDS));
		symbols.put("=", new Symbol("=", Symbol.EQ, Symbol.SG_KEYWORDS));
		symbols.put(">", new Symbol(">", Symbol.GT_SYM, Symbol.SG_KEYWORDS));
		symbols.put(">=", new Symbol(">=", Symbol.GE, Symbol.SG_KEYWORDS));
		symbols.put("<<", new Symbol("<<", Symbol.SHIFT_LEFT, Symbol.SG_KEYWORDS));
		symbols.put(">>", new Symbol(">>", Symbol.SHIFT_RIGHT, Symbol.SG_KEYWORDS));
		symbols.put("<=>", new Symbol("<=>", Symbol.EQUAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ACCESSIBLE", new Symbol("ACCESSIBLE", Symbol.ACCESSIBLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ACCOUNT", new Symbol("ACCOUNT", Symbol.ACCOUNT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ACTION", new Symbol("ACTION", Symbol.ACTION, Symbol.SG_KEYWORDS));
		symbols.put("ACTIVE", new Symbol("ACTIVE", Symbol.ACTIVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ADD", new Symbol("ADD", Symbol.ADD, Symbol.SG_KEYWORDS));
		symbols.put("ADMIN", new Symbol("ADMIN", Symbol.ADMIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AFTER", new Symbol("AFTER", Symbol.AFTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AGAINST", new Symbol("AGAINST", Symbol.AGAINST, Symbol.SG_KEYWORDS));
		symbols.put("AGGREGATE", new Symbol("AGGREGATE", Symbol.AGGREGATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ALL", new Symbol("ALL", Symbol.ALL, Symbol.SG_KEYWORDS));
		symbols.put("ALGORITHM", new Symbol("ALGORITHM", Symbol.ALGORITHM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ALTER", new Symbol("ALTER", Symbol.ALTER, Symbol.SG_KEYWORDS));
		symbols.put("ALWAYS", new Symbol("ALWAYS", Symbol.ALWAYS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ANALYZE", new Symbol("ANALYZE", Symbol.ANALYZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AND", new Symbol("AND", Symbol.AND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ANY", new Symbol("ANY", Symbol.ANY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ARRAY", new Symbol("ARRAY", Symbol.ARRAY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AS", new Symbol("AS", Symbol.AS, Symbol.SG_KEYWORDS));
		symbols.put("ASC", new Symbol("ASC", Symbol.ASC, Symbol.SG_KEYWORDS));
		symbols.put("ASCII", new Symbol("ASCII", Symbol.ASCII_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ASENSITIVE", new Symbol("ASENSITIVE", Symbol.ASENSITIVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AT", new Symbol("AT", Symbol.AT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ATTRIBUTE", new Symbol("ATTRIBUTE", Symbol.ATTRIBUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AUTHENTICATION", new Symbol("AUTHENTICATION", Symbol.AUTHENTICATION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AUTO", new Symbol("AUTO", Symbol.AUTO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AUTO_INCREMENT", new Symbol("AUTO_INCREMENT", Symbol.AUTO_INC, Symbol.SG_KEYWORDS));
		symbols.put("AUTOEXTEND_SIZE", new Symbol("AUTOEXTEND_SIZE", Symbol.AUTOEXTEND_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AVG", new Symbol("AVG", Symbol.AVG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("AVG_ROW_LENGTH", new Symbol("AVG_ROW_LENGTH", Symbol.AVG_ROW_LENGTH, Symbol.SG_KEYWORDS));
		symbols.put("BACKUP", new Symbol("BACKUP", Symbol.BACKUP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BEFORE", new Symbol("BEFORE", Symbol.BEFORE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BEGIN", new Symbol("BEGIN", Symbol.BEGIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BERNOULLI", new Symbol("BERNOULLI", Symbol.BERNOULLI_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BETWEEN", new Symbol("BETWEEN", Symbol.BETWEEN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BIGINT", new Symbol("BIGINT", Symbol.BIGINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BINARY", new Symbol("BINARY", Symbol.BINARY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BINLOG", new Symbol("BINLOG", Symbol.BINLOG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BIT", new Symbol("BIT", Symbol.BIT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BLOB", new Symbol("BLOB", Symbol.BLOB_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BLOCK", new Symbol("BLOCK", Symbol.BLOCK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BOOL", new Symbol("BOOL", Symbol.BOOL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BOOLEAN", new Symbol("BOOLEAN", Symbol.BOOLEAN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BOTH", new Symbol("BOTH", Symbol.BOTH, Symbol.SG_KEYWORDS));
		symbols.put("BTREE", new Symbol("BTREE", Symbol.BTREE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BUCKETS", new Symbol("BUCKETS", Symbol.BUCKETS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BULK", new Symbol("BULK", Symbol.BULK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("BY", new Symbol("BY", Symbol.BY, Symbol.SG_KEYWORDS));
		symbols.put("BYTE", new Symbol("BYTE", Symbol.BYTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CACHE", new Symbol("CACHE", Symbol.CACHE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CALL", new Symbol("CALL", Symbol.CALL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CASCADE", new Symbol("CASCADE", Symbol.CASCADE, Symbol.SG_KEYWORDS));
		symbols.put("CASCADED", new Symbol("CASCADED", Symbol.CASCADED, Symbol.SG_KEYWORDS));
		symbols.put("CASE", new Symbol("CASE", Symbol.CASE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CATALOG_NAME", new Symbol("CATALOG_NAME", Symbol.CATALOG_NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHAIN", new Symbol("CHAIN", Symbol.CHAIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHALLENGE_RESPONSE", new Symbol("CHALLENGE_RESPONSE", Symbol.CHALLENGE_RESPONSE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHANGE", new Symbol("CHANGE", Symbol.CHANGE, Symbol.SG_KEYWORDS));
		symbols.put("CHANGED", new Symbol("CHANGED", Symbol.CHANGED, Symbol.SG_KEYWORDS));
		symbols.put("CHANNEL", new Symbol("CHANNEL", Symbol.CHANNEL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHAR", new Symbol("CHAR", Symbol.CHAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHARACTER", new Symbol("CHARACTER", Symbol.CHAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHARSET", new Symbol("CHARSET", Symbol.CHARSET, Symbol.SG_KEYWORDS));
		symbols.put("CHECK", new Symbol("CHECK", Symbol.CHECK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CHECKSUM", new Symbol("CHECKSUM", Symbol.CHECKSUM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CIPHER", new Symbol("CIPHER", Symbol.CIPHER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CLASS_ORIGIN", new Symbol("CLASS_ORIGIN", Symbol.CLASS_ORIGIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CLIENT", new Symbol("CLIENT", Symbol.CLIENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CLONE", new Symbol("CLONE", Symbol.CLONE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CLOSE", new Symbol("CLOSE", Symbol.CLOSE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COALESCE", new Symbol("COALESCE", Symbol.COALESCE, Symbol.SG_KEYWORDS));
		symbols.put("CODE", new Symbol("CODE", Symbol.CODE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COLLATE", new Symbol("COLLATE", Symbol.COLLATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COLLATION", new Symbol("COLLATION", Symbol.COLLATION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COLUMN", new Symbol("COLUMN", Symbol.COLUMN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COLUMN_FORMAT", new Symbol("COLUMN_FORMAT", Symbol.COLUMN_FORMAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COLUMN_NAME", new Symbol("COLUMN_NAME", Symbol.COLUMN_NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COLUMNS", new Symbol("COLUMNS", Symbol.COLUMNS, Symbol.SG_KEYWORDS));
		symbols.put("COMMENT", new Symbol("COMMENT", Symbol.COMMENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMMIT", new Symbol("COMMIT", Symbol.COMMIT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMMITTED", new Symbol("COMMITTED", Symbol.COMMITTED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMPACT", new Symbol("COMPACT", Symbol.COMPACT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMPLETION", new Symbol("COMPLETION", Symbol.COMPLETION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMPONENT", new Symbol("COMPONENT", Symbol.COMPONENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMPRESSION", new Symbol("COMPRESSION", Symbol.COMPRESSION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("COMPRESSED", new Symbol("COMPRESSED", Symbol.COMPRESSED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENCRYPTION", new Symbol("ENCRYPTION", Symbol.ENCRYPTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONCURRENT", new Symbol("CONCURRENT", Symbol.CONCURRENT, Symbol.SG_KEYWORDS));
		symbols.put("CONDITION", new Symbol("CONDITION", Symbol.CONDITION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONNECTION", new Symbol("CONNECTION", Symbol.CONNECTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONSISTENT", new Symbol("CONSISTENT", Symbol.CONSISTENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONSTRAINT", new Symbol("CONSTRAINT", Symbol.CONSTRAINT, Symbol.SG_KEYWORDS));
		symbols.put("CONSTRAINT_CATALOG", new Symbol("CONSTRAINT_CATALOG", Symbol.CONSTRAINT_CATALOG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONSTRAINT_NAME", new Symbol("CONSTRAINT_NAME", Symbol.CONSTRAINT_NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONSTRAINT_SCHEMA", new Symbol("CONSTRAINT_SCHEMA", Symbol.CONSTRAINT_SCHEMA_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONTAINS", new Symbol("CONTAINS", Symbol.CONTAINS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONTEXT", new Symbol("CONTEXT", Symbol.CONTEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONTINUE", new Symbol("CONTINUE", Symbol.CONTINUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CONVERT", new Symbol("CONVERT", Symbol.CONVERT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CPU", new Symbol("CPU", Symbol.CPU_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CREATE", new Symbol("CREATE", Symbol.CREATE, Symbol.SG_KEYWORDS));
		symbols.put("CROSS", new Symbol("CROSS", Symbol.CROSS, Symbol.SG_KEYWORDS));
		symbols.put("CUBE", new Symbol("CUBE", Symbol.CUBE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CUME_DIST", new Symbol("CUME_DIST", Symbol.CUME_DIST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CURRENT", new Symbol("CURRENT", Symbol.CURRENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CURRENT_DATE", new Symbol("CURRENT_DATE", Symbol.CURDATE, Symbol.SG_KEYWORDS));
		symbols.put("CURRENT_TIME", new Symbol("CURRENT_TIME", Symbol.CURTIME, Symbol.SG_KEYWORDS));
		symbols.put("CURRENT_TIMESTAMP", new Symbol("CURRENT_TIMESTAMP", Symbol.NOW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CURRENT_USER", new Symbol("CURRENT_USER", Symbol.CURRENT_USER, Symbol.SG_KEYWORDS));
		symbols.put("CURSOR", new Symbol("CURSOR", Symbol.CURSOR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("CURSOR_NAME", new Symbol("CURSOR_NAME", Symbol.CURSOR_NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DATA", new Symbol("DATA", Symbol.DATA_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DATABASE", new Symbol("DATABASE", Symbol.DATABASE, Symbol.SG_KEYWORDS));
		symbols.put("DATABASES", new Symbol("DATABASES", Symbol.DATABASES, Symbol.SG_KEYWORDS));
		symbols.put("DATAFILE", new Symbol("DATAFILE", Symbol.DATAFILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DATE", new Symbol("DATE", Symbol.DATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DATETIME", new Symbol("DATETIME", Symbol.DATETIME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DAY", new Symbol("DAY", Symbol.DAY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DAY_HOUR", new Symbol("DAY_HOUR", Symbol.DAY_HOUR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DAY_MICROSECOND", new Symbol("DAY_MICROSECOND", Symbol.DAY_MICROSECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DAY_MINUTE", new Symbol("DAY_MINUTE", Symbol.DAY_MINUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DAY_SECOND", new Symbol("DAY_SECOND", Symbol.DAY_SECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DEALLOCATE", new Symbol("DEALLOCATE", Symbol.DEALLOCATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DEC", new Symbol("DEC", Symbol.DECIMAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DECIMAL", new Symbol("DECIMAL", Symbol.DECIMAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DECLARE", new Symbol("DECLARE", Symbol.DECLARE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DEFAULT", new Symbol("DEFAULT", Symbol.DEFAULT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DEFAULT_AUTH", new Symbol("DEFAULT_AUTH", Symbol.DEFAULT_AUTH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DEFINER", new Symbol("DEFINER", Symbol.DEFINER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DEFINITION", new Symbol("DEFINITION", Symbol.DEFINITION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DELAYED", new Symbol("DELAYED", Symbol.DELAYED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DELAY_KEY_WRITE", new Symbol("DELAY_KEY_WRITE", Symbol.DELAY_KEY_WRITE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DENSE_RANK", new Symbol("DENSE_RANK", Symbol.DENSE_RANK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DESC", new Symbol("DESC", Symbol.DESC, Symbol.SG_KEYWORDS));
		symbols.put("DESCRIBE", new Symbol("DESCRIBE", Symbol.DESCRIBE, Symbol.SG_KEYWORDS));
		symbols.put("DESCRIPTION", new Symbol("DESCRIPTION", Symbol.DESCRIPTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DETERMINISTIC", new Symbol("DETERMINISTIC", Symbol.DETERMINISTIC_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DIAGNOSTICS", new Symbol("DIAGNOSTICS", Symbol.DIAGNOSTICS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DIRECTORY", new Symbol("DIRECTORY", Symbol.DIRECTORY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DISABLE", new Symbol("DISABLE", Symbol.DISABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DISCARD", new Symbol("DISCARD", Symbol.DISCARD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DISK", new Symbol("DISK", Symbol.DISK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DISTINCT", new Symbol("DISTINCT", Symbol.DISTINCT, Symbol.SG_KEYWORDS));
		symbols.put("DISTINCTROW", new Symbol("DISTINCTROW", Symbol.DISTINCT, Symbol.SG_KEYWORDS));
		symbols.put("DIV", new Symbol("DIV", Symbol.DIV_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DO", new Symbol("DO", Symbol.DO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DOUBLE", new Symbol("DOUBLE", Symbol.DOUBLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DROP", new Symbol("DROP", Symbol.DROP, Symbol.SG_KEYWORDS));
		symbols.put("DUAL", new Symbol("DUAL", Symbol.DUAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DUMPFILE", new Symbol("DUMPFILE", Symbol.DUMPFILE, Symbol.SG_KEYWORDS));
		symbols.put("DUPLICATE", new Symbol("DUPLICATE", Symbol.DUPLICATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("DYNAMIC", new Symbol("DYNAMIC", Symbol.DYNAMIC_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EACH", new Symbol("EACH", Symbol.EACH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ELSE", new Symbol("ELSE", Symbol.ELSE, Symbol.SG_KEYWORDS));
		symbols.put("ELSEIF", new Symbol("ELSEIF", Symbol.ELSEIF_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EMPTY", new Symbol("EMPTY", Symbol.EMPTY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENABLE", new Symbol("ENABLE", Symbol.ENABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENCLOSED", new Symbol("ENCLOSED", Symbol.ENCLOSED, Symbol.SG_KEYWORDS));
		symbols.put("END", new Symbol("END", Symbol.END, Symbol.SG_KEYWORDS));
		symbols.put("ENDS", new Symbol("ENDS", Symbol.ENDS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENFORCED", new Symbol("ENFORCED", Symbol.ENFORCED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENGINE", new Symbol("ENGINE", Symbol.ENGINE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENGINE_ATTRIBUTE", new Symbol("ENGINE_ATTRIBUTE", Symbol.ENGINE_ATTRIBUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENGINES", new Symbol("ENGINES", Symbol.ENGINES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ENUM", new Symbol("ENUM", Symbol.ENUM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ERROR", new Symbol("ERROR", Symbol.ERROR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ERRORS", new Symbol("ERRORS", Symbol.ERRORS, Symbol.SG_KEYWORDS));
		symbols.put("ESCAPE", new Symbol("ESCAPE", Symbol.ESCAPE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ESCAPED", new Symbol("ESCAPED", Symbol.ESCAPED, Symbol.SG_KEYWORDS));
		symbols.put("EVENT", new Symbol("EVENT", Symbol.EVENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EVENTS", new Symbol("EVENTS", Symbol.EVENTS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EVERY", new Symbol("EVERY", Symbol.EVERY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXCEPT", new Symbol("EXCEPT", Symbol.EXCEPT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXCHANGE", new Symbol("EXCHANGE", Symbol.EXCHANGE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXCLUDE", new Symbol("EXCLUDE", Symbol.EXCLUDE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXECUTE", new Symbol("EXECUTE", Symbol.EXECUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXISTS", new Symbol("EXISTS", Symbol.EXISTS, Symbol.SG_KEYWORDS));
		symbols.put("EXIT", new Symbol("EXIT", Symbol.EXIT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXPANSION", new Symbol("EXPANSION", Symbol.EXPANSION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXPORT", new Symbol("EXPORT", Symbol.EXPORT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXPIRE", new Symbol("EXPIRE", Symbol.EXPIRE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXPLAIN", new Symbol("EXPLAIN", Symbol.DESCRIBE, Symbol.SG_KEYWORDS));
		symbols.put("EXTENDED", new Symbol("EXTENDED", Symbol.EXTENDED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("EXTENT_SIZE", new Symbol("EXTENT_SIZE", Symbol.EXTENT_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FACTOR", new Symbol("FACTOR", Symbol.FACTOR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FAILED_LOGIN_ATTEMPTS", new Symbol("FAILED_LOGIN_ATTEMPTS", Symbol.FAILED_LOGIN_ATTEMPTS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FALSE", new Symbol("FALSE", Symbol.FALSE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FAST", new Symbol("FAST", Symbol.FAST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FAULTS", new Symbol("FAULTS", Symbol.FAULTS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FETCH", new Symbol("FETCH", Symbol.FETCH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FIELDS", new Symbol("FIELDS", Symbol.COLUMNS, Symbol.SG_KEYWORDS));
		symbols.put("FILE", new Symbol("FILE", Symbol.FILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FILE_BLOCK_SIZE", new Symbol("FILE_BLOCK_SIZE", Symbol.FILE_BLOCK_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FILTER", new Symbol("FILTER", Symbol.FILTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FINISH", new Symbol("FINISH", Symbol.FINISH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FIRST", new Symbol("FIRST", Symbol.FIRST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FIRST_VALUE", new Symbol("FIRST_VALUE", Symbol.FIRST_VALUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FIXED", new Symbol("FIXED", Symbol.FIXED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FLOAT", new Symbol("FLOAT", Symbol.FLOAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FLOAT4", new Symbol("FLOAT4", Symbol.FLOAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FLOAT8", new Symbol("FLOAT8", Symbol.DOUBLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FLUSH", new Symbol("FLUSH", Symbol.FLUSH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FOLLOWS", new Symbol("FOLLOWS", Symbol.FOLLOWS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FOLLOWING", new Symbol("FOLLOWING", Symbol.FOLLOWING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FOR", new Symbol("FOR", Symbol.FOR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FORCE", new Symbol("FORCE", Symbol.FORCE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FOREIGN", new Symbol("FOREIGN", Symbol.FOREIGN, Symbol.SG_KEYWORDS));
		symbols.put("FORMAT", new Symbol("FORMAT", Symbol.FORMAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FOUND", new Symbol("FOUND", Symbol.FOUND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FROM", new Symbol("FROM", Symbol.FROM, Symbol.SG_KEYWORDS));
		symbols.put("FULL", new Symbol("FULL", Symbol.FULL, Symbol.SG_KEYWORDS));
		symbols.put("FULLTEXT", new Symbol("FULLTEXT", Symbol.FULLTEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("FUNCTION", new Symbol("FUNCTION", Symbol.FUNCTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GENERAL", new Symbol("GENERAL", Symbol.GENERAL, Symbol.SG_KEYWORDS));
		symbols.put("GROUP_REPLICATION", new Symbol("GROUP_REPLICATION", Symbol.GROUP_REPLICATION, Symbol.SG_KEYWORDS));
		symbols.put("GEOMCOLLECTION", new Symbol("GEOMCOLLECTION", Symbol.GEOMETRYCOLLECTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GEOMETRY", new Symbol("GEOMETRY", Symbol.GEOMETRY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GEOMETRYCOLLECTION", new Symbol("GEOMETRYCOLLECTION", Symbol.GEOMETRYCOLLECTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GET_FORMAT", new Symbol("GET_FORMAT", Symbol.GET_FORMAT, Symbol.SG_KEYWORDS));
		symbols.put("GET_SOURCE_PUBLIC_KEY", new Symbol("GET_SOURCE_PUBLIC_KEY", Symbol.GET_SOURCE_PUBLIC_KEY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GET", new Symbol("GET", Symbol.GET_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GENERATE", new Symbol("GENERATE", Symbol.GENERATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GENERATED", new Symbol("GENERATED", Symbol.GENERATED, Symbol.SG_KEYWORDS));
		symbols.put("GLOBAL", new Symbol("GLOBAL", Symbol.GLOBAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GRANT", new Symbol("GRANT", Symbol.GRANT, Symbol.SG_KEYWORDS));
		symbols.put("GRANTS", new Symbol("GRANTS", Symbol.GRANTS, Symbol.SG_KEYWORDS));
		symbols.put("GROUP", new Symbol("GROUP", Symbol.GROUP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GROUPING", new Symbol("GROUPING", Symbol.GROUPING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GROUPS", new Symbol("GROUPS", Symbol.GROUPS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GTIDS", new Symbol("GTIDS", Symbol.GTIDS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("GTID_ONLY", new Symbol("GTID_ONLY", Symbol.GTID_ONLY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HANDLER", new Symbol("HANDLER", Symbol.HANDLER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HASH", new Symbol("HASH", Symbol.HASH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HAVING", new Symbol("HAVING", Symbol.HAVING, Symbol.SG_KEYWORDS));
		symbols.put("HELP", new Symbol("HELP", Symbol.HELP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HIGH_PRIORITY", new Symbol("HIGH_PRIORITY", Symbol.HIGH_PRIORITY, Symbol.SG_KEYWORDS));
		symbols.put("HISTOGRAM", new Symbol("HISTOGRAM", Symbol.HISTOGRAM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HISTORY", new Symbol("HISTORY", Symbol.HISTORY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HOST", new Symbol("HOST", Symbol.HOST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HOSTS", new Symbol("HOSTS", Symbol.HOSTS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HOUR", new Symbol("HOUR", Symbol.HOUR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HOUR_MICROSECOND", new Symbol("HOUR_MICROSECOND", Symbol.HOUR_MICROSECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HOUR_MINUTE", new Symbol("HOUR_MINUTE", Symbol.HOUR_MINUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("HOUR_SECOND", new Symbol("HOUR_SECOND", Symbol.HOUR_SECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("IDENTIFIED", new Symbol("IDENTIFIED", Symbol.IDENTIFIED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("IF", new Symbol("IF", Symbol.IF, Symbol.SG_KEYWORDS));
		symbols.put("IGNORE", new Symbol("IGNORE", Symbol.IGNORE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("IGNORE_SERVER_IDS", new Symbol("IGNORE_SERVER_IDS", Symbol.IGNORE_SERVER_IDS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("IMPORT", new Symbol("IMPORT", Symbol.IMPORT, Symbol.SG_KEYWORDS));
		symbols.put("IN", new Symbol("IN", Symbol.IN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INACTIVE", new Symbol("INACTIVE", Symbol.INACTIVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INDEX", new Symbol("INDEX", Symbol.INDEX_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INDEXES", new Symbol("INDEXES", Symbol.INDEXES, Symbol.SG_KEYWORDS));
		symbols.put("INFILE", new Symbol("INFILE", Symbol.INFILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INITIAL", new Symbol("INITIAL", Symbol.INITIAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INITIAL_SIZE", new Symbol("INITIAL_SIZE", Symbol.INITIAL_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INITIATE", new Symbol("INITIATE", Symbol.INITIATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INNER", new Symbol("INNER", Symbol.INNER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INOUT", new Symbol("INOUT", Symbol.INOUT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INSENSITIVE", new Symbol("INSENSITIVE", Symbol.INSENSITIVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INSERT_METHOD", new Symbol("INSERT_METHOD", Symbol.INSERT_METHOD, Symbol.SG_KEYWORDS));
		symbols.put("INSTALL", new Symbol("INSTALL", Symbol.INSTALL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INSTANCE", new Symbol("INSTANCE", Symbol.INSTANCE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INT", new Symbol("INT", Symbol.INT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INT1", new Symbol("INT1", Symbol.TINYINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INT2", new Symbol("INT2", Symbol.SMALLINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INT3", new Symbol("INT3", Symbol.MEDIUMINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INT4", new Symbol("INT4", Symbol.INT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INT8", new Symbol("INT8", Symbol.BIGINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INTEGER", new Symbol("INTEGER", Symbol.INT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INTERSECT", new Symbol("INTERSECT", Symbol.INTERSECT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INTERVAL", new Symbol("INTERVAL", Symbol.INTERVAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INTO", new Symbol("INTO", Symbol.INTO, Symbol.SG_KEYWORDS));
		symbols.put("IO", new Symbol("IO", Symbol.IO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("IO_AFTER_GTIDS", new Symbol("IO_AFTER_GTIDS", Symbol.IO_AFTER_GTIDS, Symbol.SG_KEYWORDS));
		symbols.put("IO_BEFORE_GTIDS", new Symbol("IO_BEFORE_GTIDS", Symbol.IO_BEFORE_GTIDS, Symbol.SG_KEYWORDS));
		symbols.put("IO_THREAD", new Symbol("IO_THREAD", Symbol.RELAY_THREAD, Symbol.SG_KEYWORDS));
		symbols.put("IPC", new Symbol("IPC", Symbol.IPC_SYM, Symbol.SG_KEYWORDS));
		symbols.put("IS", new Symbol("IS", Symbol.IS, Symbol.SG_KEYWORDS));
		symbols.put("ISOLATION", new Symbol("ISOLATION", Symbol.ISOLATION, Symbol.SG_KEYWORDS));
		symbols.put("ISSUER", new Symbol("ISSUER", Symbol.ISSUER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ITERATE", new Symbol("ITERATE", Symbol.ITERATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INVISIBLE", new Symbol("INVISIBLE", Symbol.INVISIBLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("INVOKER", new Symbol("INVOKER", Symbol.INVOKER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("JOIN", new Symbol("JOIN", Symbol.JOIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("JSON", new Symbol("JSON", Symbol.JSON_SYM, Symbol.SG_KEYWORDS));
		symbols.put("JSON_TABLE", new Symbol("JSON_TABLE", Symbol.JSON_TABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("JSON_VALUE", new Symbol("JSON_VALUE", Symbol.JSON_VALUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("KEY", new Symbol("KEY", Symbol.KEY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("KEYRING", new Symbol("KEYRING", Symbol.KEYRING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("KEYS", new Symbol("KEYS", Symbol.KEYS, Symbol.SG_KEYWORDS));
		symbols.put("KEY_BLOCK_SIZE", new Symbol("KEY_BLOCK_SIZE", Symbol.KEY_BLOCK_SIZE, Symbol.SG_KEYWORDS));
		symbols.put("KILL", new Symbol("KILL", Symbol.KILL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LAG", new Symbol("LAG", Symbol.LAG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LANGUAGE", new Symbol("LANGUAGE", Symbol.LANGUAGE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LAST", new Symbol("LAST", Symbol.LAST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LAST_VALUE", new Symbol("LAST_VALUE", Symbol.LAST_VALUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LATERAL", new Symbol("LATERAL", Symbol.LATERAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LEAD", new Symbol("LEAD", Symbol.LEAD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LEADING", new Symbol("LEADING", Symbol.LEADING, Symbol.SG_KEYWORDS));
		symbols.put("LEAVE", new Symbol("LEAVE", Symbol.LEAVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LEAVES", new Symbol("LEAVES", Symbol.LEAVES, Symbol.SG_KEYWORDS));
		symbols.put("LEFT", new Symbol("LEFT", Symbol.LEFT, Symbol.SG_KEYWORDS));
		symbols.put("LESS", new Symbol("LESS", Symbol.LESS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LEVEL", new Symbol("LEVEL", Symbol.LEVEL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LIKE", new Symbol("LIKE", Symbol.LIKE, Symbol.SG_KEYWORDS));
		symbols.put("LIMIT", new Symbol("LIMIT", Symbol.LIMIT, Symbol.SG_KEYWORDS));
		symbols.put("LINEAR", new Symbol("LINEAR", Symbol.LINEAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LINES", new Symbol("LINES", Symbol.LINES, Symbol.SG_KEYWORDS));
		symbols.put("LINESTRING", new Symbol("LINESTRING", Symbol.LINESTRING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LIST", new Symbol("LIST", Symbol.LIST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOAD", new Symbol("LOAD", Symbol.LOAD, Symbol.SG_KEYWORDS));
		symbols.put("LOCAL", new Symbol("LOCAL", Symbol.LOCAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOCALTIME", new Symbol("LOCALTIME", Symbol.NOW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOCALTIMESTAMP", new Symbol("LOCALTIMESTAMP", Symbol.NOW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOCK", new Symbol("LOCK", Symbol.LOCK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOCKED", new Symbol("LOCKED", Symbol.LOCKED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOCKS", new Symbol("LOCKS", Symbol.LOCKS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOGFILE", new Symbol("LOGFILE", Symbol.LOGFILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOGS", new Symbol("LOGS", Symbol.LOGS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOG", new Symbol("LOG", Symbol.LOG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LONG", new Symbol("LONG", Symbol.LONG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LONGBLOB", new Symbol("LONGBLOB", Symbol.LONGBLOB_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LONGTEXT", new Symbol("LONGTEXT", Symbol.LONGTEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOOP", new Symbol("LOOP", Symbol.LOOP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("LOW_PRIORITY", new Symbol("LOW_PRIORITY", Symbol.LOW_PRIORITY, Symbol.SG_KEYWORDS));
		symbols.put("MANUAL", new Symbol("MANUAL", Symbol.MANUAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MASTER", new Symbol("MASTER", Symbol.MASTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MATCH", new Symbol("MATCH", Symbol.MATCH, Symbol.SG_KEYWORDS));
		symbols.put("MAX_CONNECTIONS_PER_HOUR", new Symbol("MAX_CONNECTIONS_PER_HOUR", Symbol.MAX_CONNECTIONS_PER_HOUR, Symbol.SG_KEYWORDS));
		symbols.put("MAX_QUERIES_PER_HOUR", new Symbol("MAX_QUERIES_PER_HOUR", Symbol.MAX_QUERIES_PER_HOUR, Symbol.SG_KEYWORDS));
		symbols.put("MAX_ROWS", new Symbol("MAX_ROWS", Symbol.MAX_ROWS, Symbol.SG_KEYWORDS));
		symbols.put("MAX_SIZE", new Symbol("MAX_SIZE", Symbol.MAX_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MAX_UPDATES_PER_HOUR", new Symbol("MAX_UPDATES_PER_HOUR", Symbol.MAX_UPDATES_PER_HOUR, Symbol.SG_KEYWORDS));
		symbols.put("MAX_USER_CONNECTIONS", new Symbol("MAX_USER_CONNECTIONS", Symbol.MAX_USER_CONNECTIONS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MAXVALUE", new Symbol("MAXVALUE", Symbol.MAX_VALUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MEDIUM", new Symbol("MEDIUM", Symbol.MEDIUM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MEDIUMBLOB", new Symbol("MEDIUMBLOB", Symbol.MEDIUMBLOB_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MEDIUMINT", new Symbol("MEDIUMINT", Symbol.MEDIUMINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MEDIUMTEXT", new Symbol("MEDIUMTEXT", Symbol.MEDIUMTEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MEMBER", new Symbol("MEMBER", Symbol.MEMBER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MEMORY", new Symbol("MEMORY", Symbol.MEMORY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MERGE", new Symbol("MERGE", Symbol.MERGE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MESSAGE_TEXT", new Symbol("MESSAGE_TEXT", Symbol.MESSAGE_TEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MICROSECOND", new Symbol("MICROSECOND", Symbol.MICROSECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MIDDLEINT", new Symbol("MIDDLEINT", Symbol.MEDIUMINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MIGRATE", new Symbol("MIGRATE", Symbol.MIGRATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MINUTE", new Symbol("MINUTE", Symbol.MINUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MINUTE_MICROSECOND", new Symbol("MINUTE_MICROSECOND", Symbol.MINUTE_MICROSECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MINUTE_SECOND", new Symbol("MINUTE_SECOND", Symbol.MINUTE_SECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MIN_ROWS", new Symbol("MIN_ROWS", Symbol.MIN_ROWS, Symbol.SG_KEYWORDS));
		symbols.put("MOD", new Symbol("MOD", Symbol.MOD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MODE", new Symbol("MODE", Symbol.MODE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MODIFIES", new Symbol("MODIFIES", Symbol.MODIFIES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MODIFY", new Symbol("MODIFY", Symbol.MODIFY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MONTH", new Symbol("MONTH", Symbol.MONTH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MULTILINESTRING", new Symbol("MULTILINESTRING", Symbol.MULTILINESTRING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MULTIPOINT", new Symbol("MULTIPOINT", Symbol.MULTIPOINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MULTIPOLYGON", new Symbol("MULTIPOLYGON", Symbol.MULTIPOLYGON_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MUTEX", new Symbol("MUTEX", Symbol.MUTEX_SYM, Symbol.SG_KEYWORDS));
		symbols.put("MYSQL_ERRNO", new Symbol("MYSQL_ERRNO", Symbol.MYSQL_ERRNO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NAME", new Symbol("NAME", Symbol.NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NAMES", new Symbol("NAMES", Symbol.NAMES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NATIONAL", new Symbol("NATIONAL", Symbol.NATIONAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NATURAL", new Symbol("NATURAL", Symbol.NATURAL, Symbol.SG_KEYWORDS));
		symbols.put("NDB", new Symbol("NDB", Symbol.NDBCLUSTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NDBCLUSTER", new Symbol("NDBCLUSTER", Symbol.NDBCLUSTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NCHAR", new Symbol("NCHAR", Symbol.NCHAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NESTED", new Symbol("NESTED", Symbol.NESTED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NETWORK_NAMESPACE", new Symbol("NETWORK_NAMESPACE", Symbol.NETWORK_NAMESPACE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NEVER", new Symbol("NEVER", Symbol.NEVER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NEW", new Symbol("NEW", Symbol.NEW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NEXT", new Symbol("NEXT", Symbol.NEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NO", new Symbol("NO", Symbol.NO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NO_WAIT", new Symbol("NO_WAIT", Symbol.NO_WAIT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NOWAIT", new Symbol("NOWAIT", Symbol.NOWAIT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NODEGROUP", new Symbol("NODEGROUP", Symbol.NODEGROUP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NONE", new Symbol("NONE", Symbol.NONE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NOT", new Symbol("NOT", Symbol.NOT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NO_WRITE_TO_BINLOG", new Symbol("NO_WRITE_TO_BINLOG", Symbol.NO_WRITE_TO_BINLOG, Symbol.SG_KEYWORDS));
		symbols.put("NTH_VALUE", new Symbol("NTH_VALUE", Symbol.NTH_VALUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NTILE", new Symbol("NTILE", Symbol.NTILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NULL", new Symbol("NULL", Symbol.NULL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NULLS", new Symbol("NULLS", Symbol.NULLS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NUMBER", new Symbol("NUMBER", Symbol.NUMBER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NUMERIC", new Symbol("NUMERIC", Symbol.NUMERIC_SYM, Symbol.SG_KEYWORDS));
		symbols.put("NVARCHAR", new Symbol("NVARCHAR", Symbol.NVARCHAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OF", new Symbol("OF", Symbol.OF_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OFF", new Symbol("OFF", Symbol.OFF_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OFFSET", new Symbol("OFFSET", Symbol.OFFSET_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OJ", new Symbol("OJ", Symbol.OJ_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OLD", new Symbol("OLD", Symbol.OLD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ON", new Symbol("ON", Symbol.ON_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ONE", new Symbol("ONE", Symbol.ONE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ONLY", new Symbol("ONLY", Symbol.ONLY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OPEN", new Symbol("OPEN", Symbol.OPEN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OPTIMIZE", new Symbol("OPTIMIZE", Symbol.OPTIMIZE, Symbol.SG_KEYWORDS));
		symbols.put("OPTIMIZER_COSTS", new Symbol("OPTIMIZER_COSTS", Symbol.OPTIMIZER_COSTS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OPTIONS", new Symbol("OPTIONS", Symbol.OPTIONS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OPTION", new Symbol("OPTION", Symbol.OPTION, Symbol.SG_KEYWORDS));
		symbols.put("OPTIONAL", new Symbol("OPTIONAL", Symbol.OPTIONAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OPTIONALLY", new Symbol("OPTIONALLY", Symbol.OPTIONALLY, Symbol.SG_KEYWORDS));
		symbols.put("OR", new Symbol("OR", Symbol.OR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ORGANIZATION", new Symbol("ORGANIZATION", Symbol.ORGANIZATION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OTHERS", new Symbol("OTHERS", Symbol.OTHERS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ORDER", new Symbol("ORDER", Symbol.ORDER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ORDINALITY", new Symbol("ORDINALITY", Symbol.ORDINALITY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OUT", new Symbol("OUT", Symbol.OUT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OUTER", new Symbol("OUTER", Symbol.OUTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OUTFILE", new Symbol("OUTFILE", Symbol.OUTFILE, Symbol.SG_KEYWORDS));
		symbols.put("OVER", new Symbol("OVER", Symbol.OVER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("OWNER", new Symbol("OWNER", Symbol.OWNER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PACK_KEYS", new Symbol("PACK_KEYS", Symbol.PACK_KEYS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PATH", new Symbol("PATH", Symbol.PATH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PARSE_TREE", new Symbol("PARSE_TREE", Symbol.PARSE_TREE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PARSER", new Symbol("PARSER", Symbol.PARSER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PAGE", new Symbol("PAGE", Symbol.PAGE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PARALLEL", new Symbol("PARALLEL", Symbol.PARALLEL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PARTIAL", new Symbol("PARTIAL", Symbol.PARTIAL, Symbol.SG_KEYWORDS));
		symbols.put("PARTITION", new Symbol("PARTITION", Symbol.PARTITION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PARTITIONING", new Symbol("PARTITIONING", Symbol.PARTITIONING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PARTITIONS", new Symbol("PARTITIONS", Symbol.PARTITIONS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PASSWORD", new Symbol("PASSWORD", Symbol.PASSWORD, Symbol.SG_KEYWORDS));
		symbols.put("PASSWORD_LOCK_TIME", new Symbol("PASSWORD_LOCK_TIME", Symbol.PASSWORD_LOCK_TIME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PERCENT_RANK", new Symbol("PERCENT_RANK", Symbol.PERCENT_RANK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PERSIST", new Symbol("PERSIST", Symbol.PERSIST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PERSIST_ONLY", new Symbol("PERSIST_ONLY", Symbol.PERSIST_ONLY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PHASE", new Symbol("PHASE", Symbol.PHASE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PLUGIN", new Symbol("PLUGIN", Symbol.PLUGIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PLUGINS", new Symbol("PLUGINS", Symbol.PLUGINS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PLUGIN_DIR", new Symbol("PLUGIN_DIR", Symbol.PLUGIN_DIR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("POINT", new Symbol("POINT", Symbol.POINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("POLYGON", new Symbol("POLYGON", Symbol.POLYGON_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PORT", new Symbol("PORT", Symbol.PORT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PRECEDES", new Symbol("PRECEDES", Symbol.PRECEDES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PRECEDING", new Symbol("PRECEDING", Symbol.PRECEDING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PRECISION", new Symbol("PRECISION", Symbol.PRECISION, Symbol.SG_KEYWORDS));
		symbols.put("PREPARE", new Symbol("PREPARE", Symbol.PREPARE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PRESERVE", new Symbol("PRESERVE", Symbol.PRESERVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PREV", new Symbol("PREV", Symbol.PREV_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PRIMARY", new Symbol("PRIMARY", Symbol.PRIMARY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PRIVILEGES", new Symbol("PRIVILEGES", Symbol.PRIVILEGES, Symbol.SG_KEYWORDS));
		symbols.put("PRIVILEGE_CHECKS_USER", new Symbol("PRIVILEGE_CHECKS_USER", Symbol.PRIVILEGE_CHECKS_USER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PROCEDURE", new Symbol("PROCEDURE", Symbol.PROCEDURE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PROCESS", new Symbol("PROCESS", Symbol.PROCESS, Symbol.SG_KEYWORDS));
		symbols.put("PROCESSLIST", new Symbol("PROCESSLIST", Symbol.PROCESSLIST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PROFILE", new Symbol("PROFILE", Symbol.PROFILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PROFILES", new Symbol("PROFILES", Symbol.PROFILES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PROXY", new Symbol("PROXY", Symbol.PROXY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("PURGE", new Symbol("PURGE", Symbol.PURGE, Symbol.SG_KEYWORDS));
		symbols.put("QUALIFY", new Symbol("QUALIFY", Symbol.QUALIFY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("QUARTER", new Symbol("QUARTER", Symbol.QUARTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("QUERY", new Symbol("QUERY", Symbol.QUERY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("QUICK", new Symbol("QUICK", Symbol.QUICK, Symbol.SG_KEYWORDS));
		symbols.put("RANDOM", new Symbol("RANDOM", Symbol.RANDOM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RANK", new Symbol("RANK", Symbol.RANK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RANGE", new Symbol("RANGE", Symbol.RANGE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("READ", new Symbol("READ", Symbol.READ_SYM, Symbol.SG_KEYWORDS));
		symbols.put("READ_ONLY", new Symbol("READ_ONLY", Symbol.READ_ONLY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("READ_WRITE", new Symbol("READ_WRITE", Symbol.READ_WRITE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("READS", new Symbol("READS", Symbol.READS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REAL", new Symbol("REAL", Symbol.REAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REBUILD", new Symbol("REBUILD", Symbol.REBUILD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RECOVER", new Symbol("RECOVER", Symbol.RECOVER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RECURSIVE", new Symbol("RECURSIVE", Symbol.RECURSIVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REDO_BUFFER_SIZE", new Symbol("REDO_BUFFER_SIZE", Symbol.REDO_BUFFER_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REDUNDANT", new Symbol("REDUNDANT", Symbol.REDUNDANT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REFERENCE", new Symbol("REFERENCE", Symbol.REFERENCE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REFERENCES", new Symbol("REFERENCES", Symbol.REFERENCES, Symbol.SG_KEYWORDS));
		symbols.put("REGEXP", new Symbol("REGEXP", Symbol.REGEXP, Symbol.SG_KEYWORDS));
		symbols.put("REGISTRATION", new Symbol("REGISTRATION", Symbol.REGISTRATION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RELAY", new Symbol("RELAY", Symbol.RELAY, Symbol.SG_KEYWORDS));
		symbols.put("RELAYLOG", new Symbol("RELAYLOG", Symbol.RELAYLOG_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RELAY_LOG_FILE", new Symbol("RELAY_LOG_FILE", Symbol.RELAY_LOG_FILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RELAY_LOG_POS", new Symbol("RELAY_LOG_POS", Symbol.RELAY_LOG_POS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RELAY_THREAD", new Symbol("RELAY_THREAD", Symbol.RELAY_THREAD, Symbol.SG_KEYWORDS));
		symbols.put("RELEASE", new Symbol("RELEASE", Symbol.RELEASE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RELOAD", new Symbol("RELOAD", Symbol.RELOAD, Symbol.SG_KEYWORDS));
		symbols.put("REMOVE", new Symbol("REMOVE", Symbol.REMOVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RENAME", new Symbol("RENAME", Symbol.RENAME, Symbol.SG_KEYWORDS));
		symbols.put("ASSIGN_GTIDS_TO_ANONYMOUS_TRANSACTIONS", new Symbol("ASSIGN_GTIDS_TO_ANONYMOUS_TRANSACTIONS", Symbol.ASSIGN_GTIDS_TO_ANONYMOUS_TRANSACTIONS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REORGANIZE", new Symbol("REORGANIZE", Symbol.REORGANIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REPAIR", new Symbol("REPAIR", Symbol.REPAIR, Symbol.SG_KEYWORDS));
		symbols.put("REPEATABLE", new Symbol("REPEATABLE", Symbol.REPEATABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REPLICA", new Symbol("REPLICA", Symbol.REPLICA_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REPLICAS", new Symbol("REPLICAS", Symbol.REPLICAS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATION", new Symbol("REPLICATION", Symbol.REPLICATION, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_DO_DB", new Symbol("REPLICATE_DO_DB", Symbol.REPLICATE_DO_DB, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_IGNORE_DB", new Symbol("REPLICATE_IGNORE_DB", Symbol.REPLICATE_IGNORE_DB, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_DO_TABLE", new Symbol("REPLICATE_DO_TABLE", Symbol.REPLICATE_DO_TABLE, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_IGNORE_TABLE", new Symbol("REPLICATE_IGNORE_TABLE", Symbol.REPLICATE_IGNORE_TABLE, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_WILD_DO_TABLE", new Symbol("REPLICATE_WILD_DO_TABLE", Symbol.REPLICATE_WILD_DO_TABLE, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_WILD_IGNORE_TABLE", new Symbol("REPLICATE_WILD_IGNORE_TABLE", Symbol.REPLICATE_WILD_IGNORE_TABLE, Symbol.SG_KEYWORDS));
		symbols.put("REPLICATE_REWRITE_DB", new Symbol("REPLICATE_REWRITE_DB", Symbol.REPLICATE_REWRITE_DB, Symbol.SG_KEYWORDS));
		symbols.put("REPEAT", new Symbol("REPEAT", Symbol.REPEAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REQUIRE", new Symbol("REQUIRE", Symbol.REQUIRE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REQUIRE_ROW_FORMAT", new Symbol("REQUIRE_ROW_FORMAT", Symbol.REQUIRE_ROW_FORMAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REQUIRE_TABLE_PRIMARY_KEY_CHECK", new Symbol("REQUIRE_TABLE_PRIMARY_KEY_CHECK", Symbol.REQUIRE_TABLE_PRIMARY_KEY_CHECK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESET", new Symbol("RESET", Symbol.RESET_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESPECT", new Symbol("RESPECT", Symbol.RESPECT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESIGNAL", new Symbol("RESIGNAL", Symbol.RESIGNAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESOURCE", new Symbol("RESOURCE", Symbol.RESOURCE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESTART", new Symbol("RESTART", Symbol.RESTART_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESTORE", new Symbol("RESTORE", Symbol.RESTORE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RESTRICT", new Symbol("RESTRICT", Symbol.RESTRICT, Symbol.SG_KEYWORDS));
		symbols.put("RESUME", new Symbol("RESUME", Symbol.RESUME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RETAIN", new Symbol("RETAIN", Symbol.RETAIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RETURNED_SQLSTATE", new Symbol("RETURNED_SQLSTATE", Symbol.RETURNED_SQLSTATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RETURN", new Symbol("RETURN", Symbol.RETURN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RETURNING", new Symbol("RETURNING", Symbol.RETURNING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RETURNS", new Symbol("RETURNS", Symbol.RETURNS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REUSE", new Symbol("REUSE", Symbol.REUSE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REVERSE", new Symbol("REVERSE", Symbol.REVERSE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("REVOKE", new Symbol("REVOKE", Symbol.REVOKE, Symbol.SG_KEYWORDS));
		symbols.put("RIGHT", new Symbol("RIGHT", Symbol.RIGHT, Symbol.SG_KEYWORDS));
		symbols.put("RLIKE", new Symbol("RLIKE", Symbol.REGEXP, Symbol.SG_KEYWORDS));
		symbols.put("ROLE", new Symbol("ROLE", Symbol.ROLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROLLBACK", new Symbol("ROLLBACK", Symbol.ROLLBACK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROLLUP", new Symbol("ROLLUP", Symbol.ROLLUP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROUTINE", new Symbol("ROUTINE", Symbol.ROUTINE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROTATE", new Symbol("ROTATE", Symbol.ROTATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROW", new Symbol("ROW", Symbol.ROW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROW_COUNT", new Symbol("ROW_COUNT", Symbol.ROW_COUNT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROW_NUMBER", new Symbol("ROW_NUMBER", Symbol.ROW_NUMBER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROWS", new Symbol("ROWS", Symbol.ROWS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ROW_FORMAT", new Symbol("ROW_FORMAT", Symbol.ROW_FORMAT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("RTREE", new Symbol("RTREE", Symbol.RTREE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("S3", new Symbol("S3", Symbol.S3_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SAVEPOINT", new Symbol("SAVEPOINT", Symbol.SAVEPOINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SCHEDULE", new Symbol("SCHEDULE", Symbol.SCHEDULE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SCHEMA", new Symbol("SCHEMA", Symbol.DATABASE, Symbol.SG_KEYWORDS));
		symbols.put("SCHEMA_NAME", new Symbol("SCHEMA_NAME", Symbol.SCHEMA_NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SCHEMAS", new Symbol("SCHEMAS", Symbol.DATABASES, Symbol.SG_KEYWORDS));
		symbols.put("SECOND", new Symbol("SECOND", Symbol.SECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECOND_MICROSECOND", new Symbol("SECOND_MICROSECOND", Symbol.SECOND_MICROSECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECONDARY", new Symbol("SECONDARY", Symbol.SECONDARY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECONDARY_ENGINE", new Symbol("SECONDARY_ENGINE", Symbol.SECONDARY_ENGINE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECONDARY_ENGINE_ATTRIBUTE", new Symbol("SECONDARY_ENGINE_ATTRIBUTE", Symbol.SECONDARY_ENGINE_ATTRIBUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECONDARY_LOAD", new Symbol("SECONDARY_LOAD", Symbol.SECONDARY_LOAD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECONDARY_UNLOAD", new Symbol("SECONDARY_UNLOAD", Symbol.SECONDARY_UNLOAD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SECURITY", new Symbol("SECURITY", Symbol.SECURITY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SENSITIVE", new Symbol("SENSITIVE", Symbol.SENSITIVE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SEPARATOR", new Symbol("SEPARATOR", Symbol.SEPARATOR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SERIAL", new Symbol("SERIAL", Symbol.SERIAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SERIALIZABLE", new Symbol("SERIALIZABLE", Symbol.SERIALIZABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SESSION", new Symbol("SESSION", Symbol.SESSION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SERVER", new Symbol("SERVER", Symbol.SERVER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SET", new Symbol("SET", Symbol.SET_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SHARE", new Symbol("SHARE", Symbol.SHARE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SHOW", new Symbol("SHOW", Symbol.SHOW, Symbol.SG_KEYWORDS));
		symbols.put("SHUTDOWN", new Symbol("SHUTDOWN", Symbol.SHUTDOWN, Symbol.SG_KEYWORDS));
		symbols.put("SIGNAL", new Symbol("SIGNAL", Symbol.SIGNAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SIGNED", new Symbol("SIGNED", Symbol.SIGNED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SIMPLE", new Symbol("SIMPLE", Symbol.SIMPLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SKIP", new Symbol("SKIP", Symbol.SKIP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SLAVE", new Symbol("SLAVE", Symbol.SLAVE, Symbol.SG_KEYWORDS));
		symbols.put("SLOW", new Symbol("SLOW", Symbol.SLOW, Symbol.SG_KEYWORDS));
		symbols.put("SNAPSHOT", new Symbol("SNAPSHOT", Symbol.SNAPSHOT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SMALLINT", new Symbol("SMALLINT", Symbol.SMALLINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOCKET", new Symbol("SOCKET", Symbol.SOCKET_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOME", new Symbol("SOME", Symbol.ANY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SONAME", new Symbol("SONAME", Symbol.SONAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOUNDS", new Symbol("SOUNDS", Symbol.SOUNDS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE", new Symbol("SOURCE", Symbol.SOURCE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_AUTO_POSITION", new Symbol("SOURCE_AUTO_POSITION", Symbol.SOURCE_AUTO_POSITION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_BIND", new Symbol("SOURCE_BIND", Symbol.SOURCE_BIND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_COMPRESSION_ALGORITHMS", new Symbol("SOURCE_COMPRESSION_ALGORITHMS", Symbol.SOURCE_COMPRESSION_ALGORITHM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_CONNECT_RETRY", new Symbol("SOURCE_CONNECT_RETRY", Symbol.SOURCE_CONNECT_RETRY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_CONNECTION_AUTO_FAILOVER", new Symbol("SOURCE_CONNECTION_AUTO_FAILOVER", Symbol.SOURCE_CONNECTION_AUTO_FAILOVER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_DELAY", new Symbol("SOURCE_DELAY", Symbol.SOURCE_DELAY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_HEARTBEAT_PERIOD", new Symbol("SOURCE_HEARTBEAT_PERIOD", Symbol.SOURCE_HEARTBEAT_PERIOD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_HOST", new Symbol("SOURCE_HOST", Symbol.SOURCE_HOST_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_LOG_FILE", new Symbol("SOURCE_LOG_FILE", Symbol.SOURCE_LOG_FILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_LOG_POS", new Symbol("SOURCE_LOG_POS", Symbol.SOURCE_LOG_POS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_PASSWORD", new Symbol("SOURCE_PASSWORD", Symbol.SOURCE_PASSWORD_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_PORT", new Symbol("SOURCE_PORT", Symbol.SOURCE_PORT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_PUBLIC_KEY_PATH", new Symbol("SOURCE_PUBLIC_KEY_PATH", Symbol.SOURCE_PUBLIC_KEY_PATH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_RETRY_COUNT", new Symbol("SOURCE_RETRY_COUNT", Symbol.SOURCE_RETRY_COUNT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_CAPATH", new Symbol("SOURCE_SSL_CAPATH", Symbol.SOURCE_SSL_CAPATH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_CA", new Symbol("SOURCE_SSL_CA", Symbol.SOURCE_SSL_CA_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_CERT", new Symbol("SOURCE_SSL_CERT", Symbol.SOURCE_SSL_CERT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_CIPHER", new Symbol("SOURCE_SSL_CIPHER", Symbol.SOURCE_SSL_CIPHER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_CRL", new Symbol("SOURCE_SSL_CRL", Symbol.SOURCE_SSL_CRL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_CRLPATH", new Symbol("SOURCE_SSL_CRLPATH", Symbol.SOURCE_SSL_CRLPATH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_KEY", new Symbol("SOURCE_SSL_KEY", Symbol.SOURCE_SSL_KEY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL", new Symbol("SOURCE_SSL", Symbol.SOURCE_SSL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_SSL_VERIFY_SERVER_CERT", new Symbol("SOURCE_SSL_VERIFY_SERVER_CERT", Symbol.SOURCE_SSL_VERIFY_SERVER_CERT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_TLS_CIPHERSUITES", new Symbol("SOURCE_TLS_CIPHERSUITES", Symbol.SOURCE_TLS_CIPHERSUITES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_TLS_VERSION", new Symbol("SOURCE_TLS_VERSION", Symbol.SOURCE_TLS_VERSION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_USER", new Symbol("SOURCE_USER", Symbol.SOURCE_USER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SOURCE_ZSTD_COMPRESSION_LEVEL", new Symbol("SOURCE_ZSTD_COMPRESSION_LEVEL", Symbol.SOURCE_ZSTD_COMPRESSION_LEVEL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SPATIAL", new Symbol("SPATIAL", Symbol.SPATIAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SPECIFIC", new Symbol("SPECIFIC", Symbol.SPECIFIC_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL", new Symbol("SQL", Symbol.SQL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQLEXCEPTION", new Symbol("SQLEXCEPTION", Symbol.SQLEXCEPTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQLSTATE", new Symbol("SQLSTATE", Symbol.SQLSTATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQLWARNING", new Symbol("SQLWARNING", Symbol.SQLWARNING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_AFTER_GTIDS", new Symbol("SQL_AFTER_GTIDS", Symbol.SQL_AFTER_GTIDS, Symbol.SG_KEYWORDS));
		symbols.put("SQL_AFTER_MTS_GAPS", new Symbol("SQL_AFTER_MTS_GAPS", Symbol.SQL_AFTER_MTS_GAPS, Symbol.SG_KEYWORDS));
		symbols.put("SQL_BEFORE_GTIDS", new Symbol("SQL_BEFORE_GTIDS", Symbol.SQL_BEFORE_GTIDS, Symbol.SG_KEYWORDS));
		symbols.put("SQL_BIG_RESULT", new Symbol("SQL_BIG_RESULT", Symbol.SQL_BIG_RESULT, Symbol.SG_KEYWORDS));
		symbols.put("SQL_BUFFER_RESULT", new Symbol("SQL_BUFFER_RESULT", Symbol.SQL_BUFFER_RESULT, Symbol.SG_KEYWORDS));
		symbols.put("SQL_CALC_FOUND_ROWS", new Symbol("SQL_CALC_FOUND_ROWS", Symbol.SQL_CALC_FOUND_ROWS, Symbol.SG_KEYWORDS));
		symbols.put("SQL_NO_CACHE", new Symbol("SQL_NO_CACHE", Symbol.SQL_NO_CACHE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_SMALL_RESULT", new Symbol("SQL_SMALL_RESULT", Symbol.SQL_SMALL_RESULT, Symbol.SG_KEYWORDS));
		symbols.put("SQL_THREAD", new Symbol("SQL_THREAD", Symbol.SQL_THREAD, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_SECOND", new Symbol("SQL_TSI_SECOND", Symbol.SECOND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_MINUTE", new Symbol("SQL_TSI_MINUTE", Symbol.MINUTE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_HOUR", new Symbol("SQL_TSI_HOUR", Symbol.HOUR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_DAY", new Symbol("SQL_TSI_DAY", Symbol.DAY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_WEEK", new Symbol("SQL_TSI_WEEK", Symbol.WEEK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_MONTH", new Symbol("SQL_TSI_MONTH", Symbol.MONTH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_QUARTER", new Symbol("SQL_TSI_QUARTER", Symbol.QUARTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SQL_TSI_YEAR", new Symbol("SQL_TSI_YEAR", Symbol.YEAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SRID", new Symbol("SRID", Symbol.SRID_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SSL", new Symbol("SSL", Symbol.SSL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STACKED", new Symbol("STACKED", Symbol.STACKED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("START", new Symbol("START", Symbol.START_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STARTING", new Symbol("STARTING", Symbol.STARTING, Symbol.SG_KEYWORDS));
		symbols.put("STARTS", new Symbol("STARTS", Symbol.STARTS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STATS_AUTO_RECALC", new Symbol("STATS_AUTO_RECALC", Symbol.STATS_AUTO_RECALC_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STATS_PERSISTENT", new Symbol("STATS_PERSISTENT", Symbol.STATS_PERSISTENT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STATS_SAMPLE_PAGES", new Symbol("STATS_SAMPLE_PAGES", Symbol.STATS_SAMPLE_PAGES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STATUS", new Symbol("STATUS", Symbol.STATUS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STOP", new Symbol("STOP", Symbol.STOP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STORAGE", new Symbol("STORAGE", Symbol.STORAGE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STORED", new Symbol("STORED", Symbol.STORED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STRAIGHT_JOIN", new Symbol("STRAIGHT_JOIN", Symbol.STRAIGHT_JOIN, Symbol.SG_KEYWORDS));
		symbols.put("STREAM", new Symbol("STREAM", Symbol.STREAM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("STRING", new Symbol("STRING", Symbol.STRING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SUBCLASS_ORIGIN", new Symbol("SUBCLASS_ORIGIN", Symbol.SUBCLASS_ORIGIN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SUBJECT", new Symbol("SUBJECT", Symbol.SUBJECT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SUBPARTITION", new Symbol("SUBPARTITION", Symbol.SUBPARTITION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SUBPARTITIONS", new Symbol("SUBPARTITIONS", Symbol.SUBPARTITIONS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SUPER", new Symbol("SUPER", Symbol.SUPER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SUSPEND", new Symbol("SUSPEND", Symbol.SUSPEND_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SWAPS", new Symbol("SWAPS", Symbol.SWAPS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SWITCHES", new Symbol("SWITCHES", Symbol.SWITCHES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("SYSTEM", new Symbol("SYSTEM", Symbol.SYSTEM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TABLE", new Symbol("TABLE", Symbol.TABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TABLE_NAME", new Symbol("TABLE_NAME", Symbol.TABLE_NAME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TABLES", new Symbol("TABLES", Symbol.TABLES, Symbol.SG_KEYWORDS));
		symbols.put("TABLESAMPLE", new Symbol("TABLESAMPLE", Symbol.TABLESAMPLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TABLESPACE", new Symbol("TABLESPACE", Symbol.TABLESPACE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TABLE_CHECKSUM", new Symbol("TABLE_CHECKSUM", Symbol.TABLE_CHECKSUM_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TEMPORARY", new Symbol("TEMPORARY", Symbol.TEMPORARY, Symbol.SG_KEYWORDS));
		symbols.put("TEMPTABLE", new Symbol("TEMPTABLE", Symbol.TEMPTABLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TERMINATED", new Symbol("TERMINATED", Symbol.TERMINATED, Symbol.SG_KEYWORDS));
		symbols.put("TEXT", new Symbol("TEXT", Symbol.TEXT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("THAN", new Symbol("THAN", Symbol.THAN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("THEN", new Symbol("THEN", Symbol.THEN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("THREAD_PRIORITY", new Symbol("THREAD_PRIORITY", Symbol.THREAD_PRIORITY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TIES", new Symbol("TIES", Symbol.TIES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TIME", new Symbol("TIME", Symbol.TIME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TIMESTAMP", new Symbol("TIMESTAMP", Symbol.TIMESTAMP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TIMESTAMPADD", new Symbol("TIMESTAMPADD", Symbol.TIMESTAMP_ADD, Symbol.SG_KEYWORDS));
		symbols.put("TIMESTAMPDIFF", new Symbol("TIMESTAMPDIFF", Symbol.TIMESTAMP_DIFF, Symbol.SG_KEYWORDS));
		symbols.put("TINYBLOB", new Symbol("TINYBLOB", Symbol.TINYBLOB_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TINYINT", new Symbol("TINYINT", Symbol.TINYINT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TINYTEXT", new Symbol("TINYTEXT", Symbol.TINYTEXT_SYN, Symbol.SG_KEYWORDS));
		symbols.put("TLS", new Symbol("TLS", Symbol.TLS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TO", new Symbol("TO", Symbol.TO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TRAILING", new Symbol("TRAILING", Symbol.TRAILING, Symbol.SG_KEYWORDS));
		symbols.put("TRANSACTION", new Symbol("TRANSACTION", Symbol.TRANSACTION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TRIGGER", new Symbol("TRIGGER", Symbol.TRIGGER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TRIGGERS", new Symbol("TRIGGERS", Symbol.TRIGGERS_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TRUE", new Symbol("TRUE", Symbol.TRUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TRUNCATE", new Symbol("TRUNCATE", Symbol.TRUNCATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TYPE", new Symbol("TYPE", Symbol.TYPE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("TYPES", new Symbol("TYPES", Symbol.TYPES_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNBOUNDED", new Symbol("UNBOUNDED", Symbol.UNBOUNDED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNCOMMITTED", new Symbol("UNCOMMITTED", Symbol.UNCOMMITTED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNDEFINED", new Symbol("UNDEFINED", Symbol.UNDEFINED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNDO_BUFFER_SIZE", new Symbol("UNDO_BUFFER_SIZE", Symbol.UNDO_BUFFER_SIZE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNDOFILE", new Symbol("UNDOFILE", Symbol.UNDOFILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNDO", new Symbol("UNDO", Symbol.UNDO_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNICODE", new Symbol("UNICODE", Symbol.UNICODE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNION", new Symbol("UNION", Symbol.UNION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNIQUE", new Symbol("UNIQUE", Symbol.UNIQUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNKNOWN", new Symbol("UNKNOWN", Symbol.UNKNOWN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNLOCK", new Symbol("UNLOCK", Symbol.UNLOCK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNINSTALL", new Symbol("UNINSTALL", Symbol.UNINSTALL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNREGISTER", new Symbol("UNREGISTER", Symbol.UNREGISTER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNSIGNED", new Symbol("UNSIGNED", Symbol.UNSIGNED_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UNTIL", new Symbol("UNTIL", Symbol.UNTIL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UPGRADE", new Symbol("UPGRADE", Symbol.UPGRADE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("URL", new Symbol("URL", Symbol.URL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("USAGE", new Symbol("USAGE", Symbol.USAGE, Symbol.SG_KEYWORDS));
		symbols.put("USE", new Symbol("USE", Symbol.USE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("USER", new Symbol("USER", Symbol.USER, Symbol.SG_KEYWORDS));
		symbols.put("USER_RESOURCES", new Symbol("USER_RESOURCES", Symbol.RESOURCES, Symbol.SG_KEYWORDS));
		symbols.put("USE_FRM", new Symbol("USE_FRM", Symbol.USE_FRM, Symbol.SG_KEYWORDS));
		symbols.put("USING", new Symbol("USING", Symbol.USING, Symbol.SG_KEYWORDS));
		symbols.put("UTC_DATE", new Symbol("UTC_DATE", Symbol.UTC_DATE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UTC_TIME", new Symbol("UTC_TIME", Symbol.UTC_TIME_SYM, Symbol.SG_KEYWORDS));
		symbols.put("UTC_TIMESTAMP", new Symbol("UTC_TIMESTAMP", Symbol.UTC_TIMESTAMP_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VALIDATION", new Symbol("VALIDATION", Symbol.VALIDATION_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VALUE", new Symbol("VALUE", Symbol.VALUE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VALUES", new Symbol("VALUES", Symbol.VALUES, Symbol.SG_KEYWORDS));
		symbols.put("VARBINARY", new Symbol("VARBINARY", Symbol.VARBINARY_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VARCHAR", new Symbol("VARCHAR", Symbol.VARCHAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VARCHARACTER", new Symbol("VARCHARACTER", Symbol.VARCHAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VARIABLES", new Symbol("VARIABLES", Symbol.VARIABLES, Symbol.SG_KEYWORDS));
		symbols.put("VARYING", new Symbol("VARYING", Symbol.VARYING, Symbol.SG_KEYWORDS));
		symbols.put("WAIT", new Symbol("WAIT", Symbol.WAIT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WARNINGS", new Symbol("WARNINGS", Symbol.WARNINGS, Symbol.SG_KEYWORDS));
		symbols.put("WEEK", new Symbol("WEEK", Symbol.WEEK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WEIGHT_STRING", new Symbol("WEIGHT_STRING", Symbol.WEIGHT_STRING_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WHEN", new Symbol("WHEN", Symbol.WHEN_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WHERE", new Symbol("WHERE", Symbol.WHERE, Symbol.SG_KEYWORDS));
		symbols.put("WHILE", new Symbol("WHILE", Symbol.WHILE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WINDOW", new Symbol("WINDOW", Symbol.WINDOW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VCPU", new Symbol("VCPU", Symbol.VCPU_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VIEW", new Symbol("VIEW", Symbol.VIEW_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VIRTUAL", new Symbol("VIRTUAL", Symbol.VIRTUAL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("VISIBLE", new Symbol("VISIBLE", Symbol.VISIBLE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WITH", new Symbol("WITH", Symbol.WITH, Symbol.SG_KEYWORDS));
		symbols.put("WITHOUT", new Symbol("WITHOUT", Symbol.WITHOUT_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WORK", new Symbol("WORK", Symbol.WORK_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WRAPPER", new Symbol("WRAPPER", Symbol.WRAPPER_SYM, Symbol.SG_KEYWORDS));
		symbols.put("WRITE", new Symbol("WRITE", Symbol.WRITE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("X509", new Symbol("X509", Symbol.X509_SYM, Symbol.SG_KEYWORDS));
		symbols.put("XOR", new Symbol("XOR", Symbol.XOR, Symbol.SG_KEYWORDS));
		symbols.put("XA", new Symbol("XA", Symbol.XA_SYM, Symbol.SG_KEYWORDS));
		symbols.put("XID", new Symbol("XID", Symbol.XID_SYM, Symbol.SG_KEYWORDS));
		symbols.put("XML", new Symbol("XML", Symbol.XML_SYM, Symbol.SG_KEYWORDS));
		symbols.put("YEAR", new Symbol("YEAR", Symbol.YEAR_SYM, Symbol.SG_KEYWORDS));
		symbols.put("YEAR_MONTH", new Symbol("YEAR_MONTH", Symbol.YEAR_MONTH_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ZEROFILL", new Symbol("ZEROFILL", Symbol.ZEROFILL_SYM, Symbol.SG_KEYWORDS));
		symbols.put("ZONE", new Symbol("ZONE", Symbol.ZONE_SYM, Symbol.SG_KEYWORDS));
		symbols.put("||", new Symbol("||", Symbol.OR_OR_SYM, Symbol.SG_KEYWORDS));
		/*
		 * Place keywords that accept optimizer hints below this comment.
		 */
		symbols.put("DELETE", new Symbol("DELETE", Symbol.DELETE_SYM, Symbol.SG_HINTABLE_KEYWORDS));
		symbols.put("INSERT", new Symbol("INSERT", Symbol.INSERT_SYM, Symbol.SG_HINTABLE_KEYWORDS));
		symbols.put("REPLACE", new Symbol("REPLACE", Symbol.REPLACE_SYM, Symbol.SG_HINTABLE_KEYWORDS));
		symbols.put("SELECT", new Symbol("SELECT", Symbol.SELECT_SYM, Symbol.SG_HINTABLE_KEYWORDS));
		symbols.put("UPDATE", new Symbol("UPDATE", Symbol.UPDATE_SYM, Symbol.SG_HINTABLE_KEYWORDS));
		/*
		 * Insert new function definitions after that commentary (by alphabetical order)
		 */
		symbols.put("ADDDATE", new Symbol("ADDDATE", Symbol.ADDDATE_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("BIT_AND", new Symbol("BIT_AND", Symbol.BIT_AND_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("BIT_OR", new Symbol("BIT_OR", Symbol.BIT_OR_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("BIT_XOR", new Symbol("BIT_XOR", Symbol.BIT_XOR_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("CAST", new Symbol("CAST", Symbol.CAST_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("COUNT", new Symbol("COUNT", Symbol.COUNT_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("CURDATE", new Symbol("CURDATE", Symbol.CURDATE, Symbol.SG_FUNCTIONS));
		symbols.put("CURTIME", new Symbol("CURTIME", Symbol.CURTIME, Symbol.SG_FUNCTIONS));
		symbols.put("DATE_ADD", new Symbol("DATE_ADD", Symbol.DATE_ADD_INTERVAL, Symbol.SG_FUNCTIONS));
		symbols.put("DATE_SUB", new Symbol("DATE_SUB", Symbol.DATE_SUB_INTERVAL, Symbol.SG_FUNCTIONS));
		symbols.put("EXTRACT", new Symbol("EXTRACT", Symbol.EXTRACT_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("GROUP_CONCAT", new Symbol("GROUP_CONCAT", Symbol.GROUP_CONCAT_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("JSON_OBJECTAGG", new Symbol("JSON_OBJECTAGG", Symbol.JSON_OBJECTAGG, Symbol.SG_FUNCTIONS));
		symbols.put("JSON_ARRAYAGG", new Symbol("JSON_ARRAYAGG", Symbol.JSON_ARRAYAGG, Symbol.SG_FUNCTIONS));
		symbols.put("MAX", new Symbol("MAX", Symbol.MAX_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("MID", new Symbol("MID", Symbol.SUBSTRING, Symbol.SG_FUNCTIONS));
		symbols.put("MIN", new Symbol("MIN", Symbol.MIN_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("NOW", new Symbol("NOW", Symbol.NOW_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("POSITION", new Symbol("POSITION", Symbol.POSITION_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("SESSION_USER", new Symbol("SESSION_USER", Symbol.USER, Symbol.SG_FUNCTIONS));
		symbols.put("STD", new Symbol("STD", Symbol.STD_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("STDDEV", new Symbol("STDDEV", Symbol.STD_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("STDDEV_POP", new Symbol("STDDEV_POP", Symbol.STD_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("STDDEV_SAMP", new Symbol("STDDEV_SAMP", Symbol.STDDEV_SAMP_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("ST_COLLECT", new Symbol("ST_COLLECT", Symbol.ST_COLLECT_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("SUBDATE", new Symbol("SUBDATE", Symbol.SUBDATE_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("SUBSTR", new Symbol("SUBSTR", Symbol.SUBSTRING, Symbol.SG_FUNCTIONS));
		symbols.put("SUBSTRING", new Symbol("SUBSTRING", Symbol.SUBSTRING, Symbol.SG_FUNCTIONS));
		symbols.put("SUM", new Symbol("SUM", Symbol.SUM_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("SYSDATE", new Symbol("SYSDATE", Symbol.SYSDATE, Symbol.SG_FUNCTIONS));
		symbols.put("SYSTEM_USER", new Symbol("SYSTEM_USER", Symbol.USER, Symbol.SG_FUNCTIONS));
		symbols.put("TRIM", new Symbol("TRIM", Symbol.TRIM, Symbol.SG_FUNCTIONS));
		symbols.put("VARIANCE", new Symbol("VARIANCE", Symbol.VARIANCE_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("VAR_POP", new Symbol("VAR_POP", Symbol.VARIANCE_SYM, Symbol.SG_FUNCTIONS));
		symbols.put("VAR_SAMP", new Symbol("VAR_SAMP", Symbol.VAR_SAMP_SYM, Symbol.SG_FUNCTIONS));
		/*
		 * Insert new optimizer hint keywords after that commentary:
		 */
		symbols.put("BKA", new Symbol("BKA", Symbol.BKA_HINT, Symbol.SG_HINTS));
		symbols.put("BNL", new Symbol("BNL", Symbol.BNL_HINT, Symbol.SG_HINTS));
		symbols.put("DUPSWEEDOUT", new Symbol("DUPSWEEDOUT", Symbol.DUPSWEEDOUT_HINT, Symbol.SG_HINTS));
		symbols.put("FIRSTMATCH", new Symbol("FIRSTMATCH", Symbol.FIRSTMATCH_HINT, Symbol.SG_HINTS));
		symbols.put("INTOEXISTS", new Symbol("INTOEXISTS", Symbol.INTOEXISTS_HINT, Symbol.SG_HINTS));
		symbols.put("LOOSESCAN", new Symbol("LOOSESCAN", Symbol.LOOSESCAN_HINT, Symbol.SG_HINTS));
		symbols.put("MATERIALIZATION", new Symbol("MATERIALIZATION", Symbol.MATERIALIZATION_HINT, Symbol.SG_HINTS));
		symbols.put("MAX_EXECUTION_TIME", new Symbol("MAX_EXECUTION_TIME", Symbol.MAX_EXECUTION_TIME_HINT, Symbol.SG_HINTS));
		symbols.put("NO_BKA", new Symbol("NO_BKA", Symbol.NO_BKA_HINT, Symbol.SG_HINTS));
		symbols.put("NO_BNL", new Symbol("NO_BNL", Symbol.NO_BNL_HINT, Symbol.SG_HINTS));
		symbols.put("NO_ICP", new Symbol("NO_ICP", Symbol.NO_ICP_HINT, Symbol.SG_HINTS));
		symbols.put("NO_MRR", new Symbol("NO_MRR", Symbol.NO_MRR_HINT, Symbol.SG_HINTS));
		symbols.put("NO_RANGE_OPTIMIZATION", new Symbol("NO_RANGE_OPTIMIZATION", Symbol.NO_RANGE_OPTIMIZATION_HINT, Symbol.SG_HINTS));
		symbols.put("NO_SEMIJOIN", new Symbol("NO_SEMIJOIN", Symbol.NO_SEMIJOIN_HINT, Symbol.SG_HINTS));
		symbols.put("MRR", new Symbol("MRR", Symbol.MRR_HINT, Symbol.SG_HINTS));
		symbols.put("QB_NAME", new Symbol("QB_NAME", Symbol.QB_NAME_HINT, Symbol.SG_HINTS));
		symbols.put("SEMIJOIN", new Symbol("SEMIJOIN", Symbol.SEMIJOIN_HINT, Symbol.SG_HINTS));
		symbols.put("SET_VAR", new Symbol("SET_VAR", Symbol.SET_VAR_HINT, Symbol.SG_HINTS));
		symbols.put("SUBQUERY", new Symbol("SUBQUERY", Symbol.SUBQUERY_HINT, Symbol.SG_HINTS));
		symbols.put("MERGE", new Symbol("MERGE", Symbol.DERIVED_MERGE_HINT, Symbol.SG_HINTS));
		symbols.put("NO_MERGE", new Symbol("NO_MERGE", Symbol.NO_DERIVED_MERGE_HINT, Symbol.SG_HINTS));
		symbols.put("JOIN_PREFIX", new Symbol("JOIN_PREFIX", Symbol.JOIN_PREFIX_HINT, Symbol.SG_HINTS));
		symbols.put("JOIN_SUFFIX", new Symbol("JOIN_SUFFIX", Symbol.JOIN_SUFFIX_HINT, Symbol.SG_HINTS));
		symbols.put("JOIN_ORDER", new Symbol("JOIN_ORDER", Symbol.JOIN_ORDER_HINT, Symbol.SG_HINTS));
		symbols.put("JOIN_FIXED_ORDER", new Symbol("JOIN_FIXED_ORDER", Symbol.JOIN_FIXED_ORDER_HINT, Symbol.SG_HINTS));
		symbols.put("INDEX_MERGE", new Symbol("INDEX_MERGE", Symbol.INDEX_MERGE_HINT, Symbol.SG_HINTS));
		symbols.put("NO_INDEX_MERGE", new Symbol("NO_INDEX_MERGE", Symbol.NO_INDEX_MERGE_HINT, Symbol.SG_HINTS));
		symbols.put("RESOURCE_GROUP", new Symbol("RESOURCE_GROUP", Symbol.RESOURCE_GROUP_HINT, Symbol.SG_HINTS));
		symbols.put("SKIP_SCAN", new Symbol("SKIP_SCAN", Symbol.SKIP_SCAN_HINT, Symbol.SG_HINTS));
		symbols.put("NO_SKIP_SCAN", new Symbol("NO_SKIP_SCAN", Symbol.NO_SKIP_SCAN_HINT, Symbol.SG_HINTS));
		symbols.put("HASH_JOIN", new Symbol("HASH_JOIN", Symbol.HASH_JOIN_HINT, Symbol.SG_HINTS));
		symbols.put("NO_HASH_JOIN", new Symbol("NO_HASH_JOIN", Symbol.NO_HASH_JOIN_HINT, Symbol.SG_HINTS));
		symbols.put("INDEX", new Symbol("INDEX", Symbol.INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("NO_INDEX", new Symbol("NO_INDEX", Symbol.NO_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("JOIN_INDEX", new Symbol("JOIN_INDEX", Symbol.JOIN_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("NO_JOIN_INDEX", new Symbol("NO_JOIN_INDEX", Symbol.NO_JOIN_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("GROUP_INDEX", new Symbol("GROUP_INDEX", Symbol.GROUP_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("NO_GROUP_INDEX", new Symbol("NO_GROUP_INDEX", Symbol.NO_GROUP_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("ORDER_INDEX", new Symbol("ORDER_INDEX", Symbol.ORDER_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("NO_ORDER_INDEX", new Symbol("NO_ORDER_INDEX", Symbol.NO_ORDER_INDEX_HINT, Symbol.SG_HINTS));
		symbols.put("DERIVED_CONDITION_PUSHDOWN", new Symbol("DERIVED_CONDITION_PUSHDOWN", Symbol.DERIVED_CONDITION_PUSHDOWN_HINT, Symbol.SG_HINTS));
		symbols.put("NO_DERIVED_CONDITION_PUSHDOWN", new Symbol("NO_DERIVED_CONDITION_PUSHDOWN", Symbol.NO_DERIVED_CONDITION_PUSHDOWN_HINT, Symbol.SG_HINTS));
	}

	public MyLexer() {
		stateMaps = new LexStateMapsSt();
	}

	@Override
	public Position getEndPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLVal(SQLThread thd) {
		return thd.yylval;
	}

	@Override
	public Position getStartPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void yyerror(Location loc, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public int yylex(SQLThread thd) throws IOException {
		Item yylval = thd.yylval;
		// POS in mysql-8.4.5/src/sql/parse_location.h
		Location yylloc = thd.yylloc;
		LexInputStream lip = thd.mParserState.mLip;
		int token;

//		  if (thd.is_error()) {
//		    if (thd.get_parser_da().has_sql_condition(ER_CAPACITY_EXCEEDED))
//		      return ABORT_SYM;
//		  }

		if (lip.lookaheadToken >= 0) {
			/*
			 * The next token was already parsed in advance, return it.
			 */
			token = lip.lookaheadToken;
			lip.lookaheadToken = -1;
			yylval = lip.lookaheadYylval;
//		    yylloc.cpp.start = lip.getCppTokStart();
//		    yylloc.cpp.end = lip.getCppPtr();
//		    yylloc.raw.start = lip.getTokStart();
//		    yylloc.raw.end = lip.getPtr();
			lip.lookaheadYylval = null;
			lip.addDigestToken(token, yylval);
			return token;
		}

		token = lexOneToken(yylval, thd);
//		  yylloc.cpp.start = lip.getCppTokStart();
//		  yylloc.raw.start = lip.getTokStart();

		switch (token) {
		case WITH:
			/*
			 * Parsing 'WITH' 'ROLLUP' requires 2 look ups, which makes the grammar LALR(2). Replace by a single 'WithRollup' token, to transform the grammar into a LALR(1)
			 * grammar, which sqlYacc.yy can process.
			 */
			token = lexOneToken(yylval, thd);
			switch (token) {
			case ROLLUP_SYM:
//		          yylloc.cpp.end = lip.getCppPtr();
//		          yylloc.raw.end = lip.getPtr();
				lip.addDigestToken(WITH_ROLLUP_SYM, yylval);
				return WITH_ROLLUP_SYM;
			default:
				/*
				 * Save the token following 'WITH'
				 */
				lip.lookaheadYylval = lip.yylval;
				lip.yylval = null;
				lip.lookaheadToken = token;
//		          yylloc.cpp.end = lip.getCppPtr();
//		          yylloc.raw.end = lip.getPtr();
				lip.addDigestToken(WITH, yylval);
				return WITH;
			}
//		      break;
		}

//		  yylloc.cpp.end = lip.getCppPtr();
//		  yylloc.raw.end = lip.getPtr();
		if (!lip.skipDigest)
			lip.addDigestToken(token, yylval);
		lip.skipDigest = false;
		return token;
	}

	private int lexOneToken(Item yylval, SQLThread thd) {
		  char c = 0;
		  boolean commentClosed;
		  int tokval, resultState;
		  int length;
		  MyLexStates state;
		  LexInputStream lip = thd.mParserState.mLip;
		  MyLexStates[] stateMap = stateMaps.mainMap;
		  boolean[] identMap = stateMaps.identMap;

		  lip.yylval = yylval;  // The global state

		  lip.startToken();
		  state = lip.nextState;
		  lip.nextState = MyLexStates.MY_LEX_START;
		  for (;;) {
		    switch (state) {
		      case MY_LEX_START:  // Start of token
		        // Skip starting whitespace
		        while (stateMap[c = lip.yyPeek()] == MyLexStates.MY_LEX_SKIP) {
		          if (c == '\n') lip.yylineno++;

		          lip.yySkip();
		        }

		        /* Start of real token */
		        lip.restartToken();
		        c = lip.yyGet();
		        state = stateMap[c];
		        break;
		      case MY_LEX_CHAR:  // Unknown or single char token
		      case MY_LEX_SKIP:  // This should not happen
		        if (c == '-' && lip.yyPeek() == '-' &&
		            (Character.isWhitespace(lip.yyPeekn(1)) ||
		             lip.myIscntrl(lip.yyPeekn(1)))) {
		          state = MyLexStates.MY_LEX_COMMENT;
		          break;
		        }

		        if (c == '-' && lip.yyPeek() == '>')  // '.'
		        {
		          lip.yySkip();
		          lip.nextState = MyLexStates.MY_LEX_START;
		          if (lip.yyPeek() == '>') {
		            lip.yySkip();
		            return JSON_UNQUOTED_SEPARATOR_SYM;
		          }
		          return JSON_SEPARATOR_SYM;
		        }

		        if (c != ')') lip.nextState = MyLexStates.MY_LEX_START;  // Allow signed numbers

		        /*
		          Check for a placeholder: it should not precede a possible identifier
		          because of binlogging: when a placeholder is replaced with its value
		          in a query for the binlog, the query must stay grammatically correct.
		        */
		        if (c == '?' && lip.stmtPrepareMode && !identMap[lip.yyPeek()])
		          return (PARAM_MARKER);

		        return ((int)c);

		      case MY_LEX_IDENT_OR_NCHAR:
		        if (lip.yyPeek() != '\'') {
		          state = MyLexStates.MY_LEX_IDENT;
		          break;
		        }
		        /* Found N'string' */
		        lip.yySkip();  // Skip '
		        if (!"".equals((yylval.lexStr.str = getText(lip, 2, 1)))) {
		          state = MyLexStates.MY_LEX_CHAR;  // Read char by char
		          break;
		        }
		        yylval.lexStr.length = lip.yytoklen;
		        return (NCHAR_STRING);

		      case MY_LEX_IDENT_OR_HEX:
		        if (lip.yyPeek() == '\'') {  // Found x'hex-number'
		          state = MyLexStates.MY_LEX_HEX_NUMBER;
		          break;
		        }
//		        [[fallthrough]];
		      case MY_LEX_IDENT_OR_BIN:
		        if (lip.yyPeek() == '\'') {  // Found b'bin-number'
		          state = MyLexStates.MY_LEX_BIN_NUMBER;
		          break;
		        }
//		        [[fallthrough]];
		      case MY_LEX_IDENT:
		        int start;
		          for (resultState = c; identMap[c = lip.yyGet()]; resultState |= c)
		            ;
		          /* If there were non-ASCII characters, mark that we must convert */
		          resultState = (resultState & 0x80) == 0x80 ? IDENT_QUOTED : IDENT;
		        length = lip.yyLength();
		        start = lip.getPtr();
		        if (lip.ignoreSpace) {
		          /*
		            If we find a space then this can't be an identifier. We notice this
		            below by checking start != lex.ptr.
		          */
		          for (; stateMap[c] == MyLexStates.MY_LEX_SKIP; c = lip.yyGet()) {
		            if (c == '\n') lip.yylineno++;
		          }
		        }
		        if (start == lip.getPtr() && c == '.' && identMap[lip.yyPeek()])
		          lip.nextState = MyLexStates.MY_LEX_IDENT_SEP;
		        else {  // '(' must follow directly if function
		          lip.yyUnget();
		          if ((tokval = findKeyword(lip, length, c == '('))) {
		            lip.nextState = MyLexStates.MY_LEX_START;  // Allow signed numbers
		            return (tokval);                 // Was keyword
		          }
		          lip.yySkip();  // next state does a unget
		        }
		        yylval.lexStr = getToken(lip, 0, length);

		        /*
		           Note: "Select Bla As 'alias'"
		           Bla should be considered as a Ident if charset haven't been found.
		           So we don't want to produce any warning in findPrimary.
		        */

		        if (yylval.lexStr.str[0] == '_') {
		          auto charsetName = yylval.lexStr.str + 1;
		          const CharsetInfo *underscoreCs =
		              mysql::collation::findPrimary(charsetName);
		          if (underscoreCs) {
		            lip.warnOnDeprecatedCharset(underscoreCs, charsetName);
		            if (underscoreCs == &myCharsetUtf8mb40900AiCi) {
		              /*
		                If underscoreCs is utf8mb4, and the collation of underscoreCs
		                is the default collation of utf8mb4, then update underscoreCs
		                with a value of the defaultCollationForUtf8mb4 system
		                variable:
		              */
		              underscoreCs = thd.variables.defaultCollationForUtf8mb4;
		            }
		            yylval.charset = underscoreCs;
		            lip.mUnderscoreCs = underscoreCs;

		            lip.bodyUtf8Append(lip.mCppTextStart,
		                                  lip.getCppTokStart() + length);
		            return (UnderscoreCharset);
		          }
		        }

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (resultState);  // Ident or IdentQuoted

		      case MyLexIdentSep:  // Found ident and now '.'
		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
		        yylval.lexStr.length = 1;
		        c = lip.yy_get();  // should be '.'
		        if (const uchar nextC = lip.yypeek(); identMap[nextC]) {
		          lip.nextState =
		              MyLexIdentStart;  // Next is an ident (not a keyword)
		          if (nextC == '$')       // We got .$ident
		            pushDeprecatedWarnNoReplacement(
		                lip.mThd,
		                "$ as the first character of an unquoted identifier");
		        } else  // Probably ` or "
		          lip.nextState = MyLexStart;

		        return ((int)c);

		      case MyLexNumberIdent:  // number or ident which num-start
		        if (lip.yy_get_last() == '0') {
		          c = lip.yy_get();
		          if (c == 'x') {
		            while (myIsxdigit(cs, (c = lip.yyget())))
		              ;
		            if ((lip.yylength() >= 3) && !identMap[c]) {
		              /* skip '0x' */
		              yylval.lexStr = getToken(lip, 2, lip.yylength() - 2);
		              return (HexNum);
		            }
		            lip.yy_unget();
		            state = MyLexIdentStart;
		            break;
		          } else if (c == 'b') {
		            while ((c = lip.yy_get()) == '0' || c == '1')
		              ;
		            if ((lip.yylength() >= 3) && !identMap[c]) {
		              /* Skip '0b' */
		              yylval.lexStr = getToken(lip, 2, lip.yylength() - 2);
		              return (BinNum);
		            }
		            lip.yy_unget();
		            state = MyLexIdentStart;
		            break;
		          }
		          lip.yy_unget();
		        }

		        while (myIsdigit(cs, (c = lip.yyget())))
		          ;
		        if (!identMap[c]) {  // Can't be identifier
		          state = MyLexIntOrReal;
		          break;
		        }
		        if (c == 'e' || c == 'E') {
		          // The following test is written this way to allow numbers of type 1e1
		          if (myIsdigit(cs, lip.yypeek()) || (c = (lip.yyget())) == '+' ||
		              c == '-') {  // Allow 1E+10
		            if (myIsdigit(cs,
		                           lip.yyPeek()))  // Number must have digit after sign
		            {
		              lip.yy_skip();
		              while (myIsdigit(cs, lip.yyget()))
		                ;
		              yylval.lexStr = getToken(lip, 0, lip.yylength());
		              return (FloatNum);
		            }
		          }
		          lip.yy_unget();
		        }
		        [[fallthrough]];
		      case MyLexIdentStart:  // We come here after '.'
		        resultState = Ident;
		        if (useMb(cs)) {
		          resultState = IdentQuoted;
		          while (identMap[c = lip.yyget()]) {
		            switch (myMbcharlen(cs, c)) {
		              case 1:
		                break;
		              case 0:
		                if (myMbmaxlenlen(cs) < 2) break;
		                [[fallthrough]];
		              default:
		                int l;
		                if ((l = myIsmbchar(cs, lip.getPtr() - 1,
		                                     lip.getEndOfQuery())) == 0)
		                  break;
		                lip.skipBinary(l - 1);
		            }
		          }
		        } else {
		          for (resultState = 0; identMap[c = lip.yyget()]; resultState |= c)
		            ;
		          /* If there were non-ASCII characters, mark that we must convert */
		          resultState = resultState & 0x80 ? IdentQuoted : Ident;
		        }
		        if (c == '.' && identMap[lip.yypeek()])
		          lip.nextState = MyLexIdentSep;  // Next is '.'

		        yylval.lexStr = getToken(lip, 0, lip.yylength());

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (resultState);

		      case MyLexUserVariableDelimiter:  // Found quote char
		      {
		        uint doubleQuotes = 0;
		        const char quoteChar = c;  // Used char
		        for (;;) {
		          c = lip.yy_get();
		          if (c == 0) {
		            lip.yy_unget();
		            return AbortSym;  // Unmatched quotes
		          }

		          int varLength;
		          if ((varLength = myMbcharlen(cs, c)) == 1) {
		            if (c == quoteChar) {
		              if (lip.yypeek() != quoteChar) break;
		              c = lip.yy_get();
		              doubleQuotes++;
		              continue;
		            }
		          } else if (useMb(cs)) {
		            if ((varLength = myIsmbchar(cs, lip.getPtr() - 1,
		                                          lip.getEndOfQuery())))
		              lip.skipBinary(varLength - 1);
		          }
		        }
		        if (doubleQuotes)
		          yylval.lexStr = getQuotedToken(
		              lip, 1, lip.yylength() - doubleQuotes - 1, quoteChar);
		        else
		          yylval.lexStr = getToken(lip, 1, lip.yylength() - 1);
		        if (c == quoteChar) lip.yyskip();  // Skip end `
		        lip.nextState = MyLexStart;

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (IdentQuoted);
		      }
		      case MyLexIntOrReal:  // Complete int or incomplete real
		        if (c != '.') {         // Found complete integer number.
		          yylval.lexStr = getToken(lip, 0, lip.yylength());
		          return intToken(yylval.lexStr.str, (uint)yylval.lexStr.length);
		        }
		        [[fallthrough]];
		      case MyLexReal:  // Incomplete real number
		        while (myIsdigit(cs, c = lip.yyget()))
		          ;

		        if (c == 'e' || c == 'E') {
		          c = lip.yy_get();
		          if (c == '-' || c == '+') c = lip.yy_get();  // Skip sign
		          if (!myIsdigit(cs, c)) {                    // No digit after sign
		            state = MyLexChar;
		            break;
		          }
		          while (myIsdigit(cs, lip.yyget()))
		            ;
		          yylval.lexStr = getToken(lip, 0, lip.yylength());
		          return (FloatNum);
		        }
		        yylval.lexStr = getToken(lip, 0, lip.yylength());
		        return (DecimalNum);

		      case MyLexHexNumber:  // Found x'hexstring'
		        lip.yy_skip();         // Accept opening '
		        while (myIsxdigit(cs, (c = lip.yyget())))
		          ;
		        if (c != '\'') return (AbortSym);          // Illegal hex constant
		        lip.yy_skip();                              // Accept closing '
		        length = lip.yy_length();                   // Length of hexnum+3
		        if ((length % 2) == 0) return (AbortSym);  // odd number of hex digits
		        yylval.lexStr = getToken(lip,
		                                    2,            // skip x'
		                                    length - 3);  // don't count x' and last '
		        return (HexNum);

		      case MyLexBinNumber:  // Found b'bin-string'
		        lip.yy_skip();         // Accept opening '
		        while ((c = lip.yy_get()) == '0' || c == '1')
		          ;
		        if (c != '\'') return (AbortSym);  // Illegal hex constant
		        lip.yy_skip();                      // Accept closing '
		        length = lip.yy_length();           // Length of bin-num + 3
		        yylval.lexStr = getToken(lip,
		                                    2,            // skip b'
		                                    length - 3);  // don't count b' and last '
		        return (BinNum);

		      case MyLexCmpOp:  // Incomplete comparison operator
		        if (stateMap[lip.yypeek()] == MyLexCmpOp ||
		            stateMap[lip.yypeek()] == MyLexLongCmpOp)
		          lip.yy_skip();
		        if ((tokval = findKeyword(lip, lip.yylength() + 1, false))) {
		          lip.nextState = MyLexStart;  // Allow signed numbers
		          return (tokval);
		        }
		        state = MyLexChar;  // Something fishy found
		        break;

		      case MyLexLongCmpOp:  // Incomplete comparison operator
		        if (stateMap[lip.yypeek()] == MyLexCmpOp ||
		            stateMap[lip.yypeek()] == MyLexLongCmpOp) {
		          lip.yy_skip();
		          if (stateMap[lip.yypeek()] == MyLexCmpOp) lip.yyskip();
		        }
		        if ((tokval = findKeyword(lip, lip.yylength() + 1, false))) {
		          lip.nextState = MyLexStart;  // Found long op
		          return (tokval);
		        }
		        state = MyLexChar;  // Something fishy found
		        break;

		      case MyLexBool:
		        if (c != lip.yyPeek()) {
		          state = MyLexChar;
		          break;
		        }
		        lip.yy_skip();
		        tokval = findKeyword(lip, 2, false);  // Is a bool operator
		        lip.nextState = MyLexStart;        // Allow signed numbers
		        return (tokval);

		      case MyLexStringOrDelimiter:
		        if (thd.variables.sqlMode & ModeAnsiQuotes) {
		          state = MyLexUserVariableDelimiter;
		          break;
		        }
		        /* " used for strings */
		        [[fallthrough]];
		      case MyLexString:  // Incomplete text string
		        if (!(yylval.lexStr.str = getText(lip, 1, 1))) {
		          state = MyLexChar;  // Read char by char
		          break;
		        }
		        yylval.lexStr.length = lip.yytoklen;

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(
		            thd, &yylval.lexStr,
		            lip.mUnderscoreCs ? lip.mUnderscoreCs : cs,
		            lip.mCppTextEnd);

		        lip.mUnderscoreCs = null;

		        return (TextString);

		      case MY_LEX_COMMENT:  //  Comment
		        thd.mParserState.addComment();
		        while ((c = lip.yy_get()) != '\n' && c)
		          ;
		        lip.yy_unget();        // Safety against eof
		        state = MY_LEX_START;  // Try again
		        break;
		      case MY_LEX_LONG_COMMENT: /* Long C comment? */
		        if (lip.yyPeek() != '*') {
		          state = MyLexChar;  // Probable division
		          break;
		        }
		        thd.mParserState.addComment();
		        /* Reject '/' '*', since we might need to turn off the echo */
		        lip.yy_unget();

		        lip.saveInCommentState();

		        if (lip.yyPeekn(2) == '!') {
		          lip.inComment = DiscardComment;
		          /* Accept '/' '*' '!', but do not keep this marker. */
		          lip.setEcho(false);
		          lip.yy_skip();
		          lip.yy_skip();
		          lip.yy_skip();

		          /*
		            The special comment format is very strict:
		            '/' '*' '!', followed by either

		            6 digits: 2 digits (major), 2 digits (mionr), 2 digits (dot), then a
		            white-space character.
		            032302 . 3.23.2
		            050032 . 5.0.32
		            050114 . 5.1.14
		            100000 . 10.0.0

		            or, if that format is not matched:

		            5 digits: 1 digit (major), 2 digits (minor), then 2 digits (dot).
		            32302 . 3.23.2
		            50032 . 5.0.32
		            50114 . 5.1.14
		          */
		          char versionStr[7] = {0};
		          if (myIsdigit(cs, (versionStr[0] = lip.yypeekn(0))) &&
		              myIsdigit(cs, (versionStr[1] = lip.yypeekn(1))) &&
		              myIsdigit(cs, (versionStr[2] = lip.yypeekn(2))) &&
		              myIsdigit(cs, (versionStr[3] = lip.yypeekn(3))) &&
		              myIsdigit(cs, (versionStr[4] = lip.yypeekn(4)))) {
		            if (myIsdigit(cs, lip.yypeekn(5)) &&
		                myIsspace(cs, lip.yypeekn(6))) {
		              versionStr[5] = lip.yypeekn(5);
		            } else if (!myIsspace(cs, lip.yypeekn(5))) {
		              pushWarning(thd, SqlCondition::SlWarning,
		                           ErWarnNoSpaceVersionComment,
		                           ErThd(thd, ErWarnNoSpaceVersionComment));
		            }

		            ulong version = strtol(versionStr, null, 10);
		            if (version <= MysqlVersionId) {
		              /* Accept ('M') 'M' 'm' 'm' 'd' 'd' */
		              lip.yyskipn(strlen(versionStr));
		              /* Expand the content of the special comment as real code */
		              lip.setEcho(true);
		              state = MyLexStart;
		              break; /* Do not treat contents as a comment.  */
		            } else {
		              /*
		                Patch and skip the conditional comment to avoid it
		                being propagated infinitely (eg. to a slave).
		              */
		              char *pcom = lip.yy_unput(' ');
		              commentClosed = !consumeComment(lip, 1);
		              if (!commentClosed) {
		                *pcom = '!';
		              }
		              /* version allowed to have one level of comment inside. */
		            }
		          } else {
		            /* Not a version comment. */
		            state = MyLexStart;
		            lip.setEcho(true);
		            break;
		          }
		        } else {
		          if (lip.inComment != NoComment) {
		            pushWarning(
		                lip.mThd, SqlCondition::SlWarning,
		                ErWarnDeprecatedSyntaxNoReplacement,
		                ErThd(lip.mThd, ErWarnDeprecatedNestedCommentSyntax));
		          }
		          lip.inComment = PreserveComment;
		          lip.yy_skip();  // Accept /
		          lip.yy_skip();  // Accept *
		          commentClosed = !consumeComment(lip, 0);
		          /* regular comments can have zero comments inside. */
		        }
		        /*
		          Discard:
		          - regular '/' '*' comments,
		          - special comments '/' '*' '!' for a future version,
		          by scanning until we find a closing '*' '/' marker.

		          Nesting regular comments isn't allowed.  The first
		          '*' '/' returns the parser to the previous state.

		          /#!VERSI oned containing /# regular #/ is allowed #/

		                  Inside one versioned comment, another versioned comment
		                  is treated as a regular discardable comment.  It gets
		                  no special parsing.
		        */

		        /* Unbalanced comments with a missing '*' '/' are a syntax error */
		        if (!commentClosed) return (AbortSym);
		        state = MyLexStart;  // Try again
		        lip.restoreInCommentState();
		        break;
		      case MyLexEndLongComment:
		        if ((lip.inComment != NoComment) && lip.yypeek() == '/') {
		          /* Reject '*' '/' */
		          lip.yy_unget();
		          /* Accept '*' '/', with the proper echo */
		          lip.setEcho(lip.inComment == PreserveComment);
		          lip.yy_skipn(2);
		          /* And start recording the tokens again */
		          lip.setEcho(true);

		          /*
		            C-style comments are replaced with a single space (as it
		            is in C and C++).  If there is already a whitespace
		            character at this point in the stream, the space is
		            not inserted.

		            See also ISO/IEC 9899:1999 §5.1.1.2
		            ("Programming languages — C")
		          */
		          if (!myIsspace(cs, lip.yypeek()) &&
		              lip.getCppPtr() != lip.getCppBuf() &&
		              !myIsspace(cs, *(lip.getCppPtr() - 1)))
		            lip.cppInject(' ');

		          lip.inComment = NoComment;
		          state = MyLexStart;
		        } else
		          state = MyLexChar;  // Return '*'
		        break;
		      case MyLexSetVar:  // Check if ':='
		        if (lip.yyPeek() != '=') {
		          state = MyLexChar;  // Return ':'
		          break;
		        }
		        lip.yy_skip();
		        return (SetVar);
		      case MyLexSemicolon:  // optional line terminator
		        state = MyLexChar;  // Return ';'
		        break;
		      case MyLexEol:
		        if (lip.eof()) {
		          lip.yy_unget();  // Reject the last '\0'
		          lip.setEcho(false);
		          lip.yy_skip();
		          lip.setEcho(true);
		          /* Unbalanced comments with a missing '*' '/' are a syntax error */
		          if (lip.inComment != NoComment) return (AbortSym);
		          lip.nextState = MyLexEnd;  // Mark for next loop
		          return (EndOfInput);
		        }
		        state = MyLexChar;
		        break;
		      case MyLexEnd:
		        lip.nextState = MyLexEnd;
		        return (0);  // We found end of input last time

		        /* Actually real shouldn't start with . but allow them anyhow */
		      case MyLexRealOrPoint:
		        if (myIsdigit(cs, lip.yypeek()))
		          state = MyLexReal;  // Real
		        else {
		          state = MyLexIdentSep;  // return '.'
		          lip.yy_unget();            // Put back '.'
		        }
		        break;
		      case MyLexUserEnd:  // end '@' of user@hostname
		        switch (stateMap[lip.yypeek()]) {
		          case MyLexString:
		          case MyLexUserVariableDelimiter:
		          case MyLexStringOrDelimiter:
		            break;
		          case MyLexUserEnd:
		            lip.nextState = MyLexSystemVar;
		            break;
		          default:
		            lip.nextState = MyLexHostname;
		            break;
		        }
		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
		        yylval.lexStr.length = 1;
		        return ((int)'@');
		      case MyLexHostname:  // end '@' of user@hostname
		        for (c = lip.yy_get();
		             myIsalnum(cs, c) || c == '.' || c == '_' || c == '$';
		             c = lip.yy_get())
		          ;
		        yylval.lexStr = getToken(lip, 0, lip.yylength());
		        return (LexHostname);
		      case MyLexSystemVar:
		        yylval.lexStr.str = constCast<char *>(lip.getPtr());
		        yylval.lexStr.length = 1;
		        lip.yy_skip();  // Skip '@'
		        lip.nextState =
		            (stateMap[lip.yypeek()] == MyLexUserVariableDelimiter
		                 ? MyLexStart
		                 : MyLexIdentOrKeyword);
		        return ((int)'@');
		      case MyLexIdentOrKeyword:
		        /*
		          We come here when we have found two '@' in a row.
		          We should now be able to handle:
		          [(global | local | session) .]variableName
		        */

		        for (resultState = 0; identMap[c = lip.yyget()]; resultState |= c)
		          ;
		        /* If there were non-ASCII characters, mark that we must convert */
		        resultState = resultState & 0x80 ? IdentQuoted : Ident;

		        if (c == '.') lip.nextState = MyLexIdentSep;
		        length = lip.yy_length();
		        if (length == 0) return (AbortSym);  // Names must be nonempty.
		        if ((tokval = findKeyword(lip, length, false))) {
		          lip.yy_unget();   // Put back 'c'
		          return (tokval);  // Was keyword
		        }
		        yylval.lexStr = getToken(lip, 0, length);

		        lip.bodyUtf8Append(lip.mCppTextStart);

		        lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                      lip.mCppTextEnd);

		        return (resultState);

		      case MyLexIdentOrDollarQuotedText: {
		        int len = 0;             /* Length of the tag of the dollar quote */
		        uchar p = lip.yyPeek(); /* Character succeeding first $ */
		        // Find $ character after the tag
		        while (p != '$' && identMap[p] &&
		               lip.getPtr() + len <= lip.getEndOfQuery()) {
		          if (useMb(cs)) {
		            int l =
		                myIsmbchar(cs, lip.getPtr() + len, lip.getEndOfQuery());
		            if (l > 1) len += l - 1;
		          }
		          p = lip.yyPeekn(++len);
		        }

		        if (p != '$') { /* Not a dollar quote, could be an identifier */
		          pushDeprecatedWarnNoReplacement(
		              lip.mThd, "$ as the first character of an unquoted identifier");
		          state = MyLexIdent;
		          break;
		        } else {
		          LexCstring text = getDollarQuotedText(lip, len);
		          if (text == NullCstr)
		            return AbortSym;  // error: unterminated text
		          else {
		            yylval.lexStr.str = constCast<char *>(text.str);
		            yylval.lexStr.length = text.length;

		            lip.bodyUtf8Append(text.str);
		            lip.bodyUtf8AppendLiteral(thd, &yylval.lexStr, cs,
		                                          text.str + text.length);

		            return DollarQuotedStringSym;  // $$ ... $$
		          }
		        }
		      }
		    }
		  }
		}

	private String getText(LexInputStream lip, int preSkip, int postSkip) {
		char c, sep;
		boolean foundEscape = false;
//		  const CHARSET_INFO *cs = lip.m_thd.charset();

		lip.tokBitmap = 0;
		sep = lip.yyGetLast(); // String should end with this
		while (!lip.eof()) {
			c = lip.yyGet();
			lip.tokBitmap |= c;
			if (c == '\\' && !((lip.mThd.variables.sqlMode & SystemVariables.MODE_NO_BACKSLASH_ESCAPES) == SystemVariables.MODE_NO_BACKSLASH_ESCAPES)) { // Escaped
																																							// character
				foundEscape = true;
				if (lip.eof())
					return null;
				lip.yySkip();
			} else if (c == sep) {
				if (c == lip.yyGet()) // Check if two separators in a row
				{
					foundEscape = true; // duplicate. Remember for delete
					continue;
				} else
					lip.yyUnget();

				/* Found end. Unescape and return string */
				int str, end;
				String start;

				str = lip.getTokStart();
				end = lip.getPtr();
				/* Extract the text from the token */
				str += preSkip;
				end -= postSkip;

				lip.mCppTextStart = lip.getCppTokStart() + preSkip;
				lip.mCppTextEnd = lip.getCppPtr() - postSkip;

				if (!foundEscape) {
					lip.yytoklen = end - str;
					start = lip.sqlBuf.substring(str, end);
				} else {
					char[] to = new char[end - str];
					int i;
					for (i = 0; str != end; str++) {
						if (!((lip.mThd.variables.sqlMode & SystemVariables.MODE_NO_BACKSLASH_ESCAPES) == SystemVariables.MODE_NO_BACKSLASH_ESCAPES) && str == '\\' && str + 1 != end) {
							switch (++str) {
							case 'n':
								to[i++] = '\n';
								break;
							case 't':
								to[i++] = '\t';
								break;
							case 'r':
								to[i++] = '\r';
								break;
							case 'b':
								to[i++] = '\b';
								break;
							case '0':
								to[i++] = 0; // Ascii null
								break;
							case 'Z': // ^Z must be escaped on Win32
								to[i++] = '\032';
								break;
							case '_':
							case '%':
								to[i++] = '\\'; // remember prefix for wildcard
							default:
								to[i++] = lip.sqlBuf.charAt(str);
								break;
							}
						} else if (lip.sqlBuf.charAt(str) == sep)
							to[i++] = lip.sqlBuf.charAt(str++); // Two ' or "
						else
							to[i++] = lip.sqlBuf.charAt(str);
					}
					to[i] = 0;
					lip.yytoklen = (start = new String(to)).length();
				}
				return start;
			}
		}
		return null; // unexpected end of query
	}

	/**
	 * Convert from /sql/sql_lex_hash.cc, /sql/lex_symbol.h, /sql/gen_lex_hash.cc..., Function add_digest_token from /sql/sql_digest.cc
	 *
	 * @param lip
	 * @param len
	 * @param function whether include function keywords
	 * @return
	 */
	private int findKeyword(LexInputStream lip, int len, boolean function) {
//		  int tok = lip.getTokStart();
		String tok = lip.sqlBuf.substring(lip.getTokStart(), lip.getTokStart() + len);
		Symbol symbol = getHashSymbol(tok, function);
//		  Integer symbol = (symbolInstance == null ? null : symbolInstance.tok);

		if (symbol != null) {
			lip.yylval.keyword.symbol = symbol.tok;
			lip.yylval.keyword.str = tok;
			lip.yylval.keyword.length = len;

			if ((symbol.tok == NOT_SYM) && (lip.mThd.variables.sqlMode & SystemVariables.MODE_HIGH_NOT_PRECEDENCE) == SystemVariables.MODE_HIGH_NOT_PRECEDENCE)
				return NOT2_SYM;
			if ((symbol.tok == OR_OR_SYM) && !((lip.mThd.variables.sqlMode & SystemVariables.MODE_PIPES_AS_CONCAT) == SystemVariables.MODE_PIPES_AS_CONCAT)) {
//		      push_deprecated_warn(lip.mThd, "|| as a synonym for OR", "OR");
				return OR2_SYM;
			}

			lip.yylval.optimizerHints = null;
			if ((symbol.group & Symbol.SG_HINTABLE_KEYWORDS) == Symbol.SG_HINTABLE_KEYWORDS) {
				lip.addDigestToken(symbol.tok, lip.yylval);
				if (consumeOptimizerHints(lip))
					return ABORT_SYM;
				lip.skipDigest = true;
			}

			return symbol.tok;
		}
		return 0;
	}

	/**
	 * function my_hint_parser_parse = yyparse from /src/sql/sql_hints.yy.cc
	 * @param lip
	 * @return
	 */
	private boolean consumeOptimizerHints(LexInputStream lip) {
		  MyLexStates[] stateMap = stateMaps.mainMap;
		  int whitespace = 0;
		  char c = lip.yyPeek();
		  int newlines = 0;

		  for (; stateMap[c] == MyLexStates.MY_LEX_SKIP;
		       whitespace++, c = lip.yyPeekn(whitespace)) {
		    if (c == '\n') newlines++;
		  }

		  if (lip.yyPeekn(whitespace) == '/' && lip.yyPeekn(whitespace + 1) == '*' &&
		      lip.yyPeekn(whitespace + 2) == '+') {
		    lip.yylineno += newlines;
		    lip.yySkipn(whitespace);  // skip whitespace

		    HintScanner hintScanner = new HintScanner(lip.mThd, lip.yylineno, lip.getPtr(),
		                              lip.getEndOfQuery() - lip.getPtr(),
		                              lip.mDigest);
		    List<Integer> hintList = null;
		    int rc = my_hint_parser_parse(lip.mThd, hintScanner, hintList);
		    if (rc == 2) return true;  // Bison's internal OOM error
		    if (rc == 1) {
		      /*
		        This branch is for 2 cases:
		        1. YYABORT in the hint parser grammar (we use it to process OOM errors),
		        2. open commentary error.
		      */
		      lip.start_token();  // adjust error message text pointer to "/*+"
		      return true;
		    }
		    lip.yylineno = hint_scanner.get_lineno();
		    lip.yySkipn(hint_scanner.get_ptr() - lip.get_ptr());
		    lip.yylval.optimizer_hints = hint_list;   // NULL in case of syntax error
		    lip.m_digest = hint_scanner.get_digest();  // NULL is digest buf. is full.
		    return false;
		  } else
		    return false;
		}

	private Symbol getHashSymbol(String token, boolean function) {
		Symbol result = null;
		Symbol symbol = symbols.get(token);
		if (symbol != null) {
			//
			if (function) {
				// "sql_keywords_and_funcs": SG_MAIN_PARSER
				if ((Symbol.SG_MAIN_PARSER & symbol.group) == symbol.group) {
					result = symbol;
				}
			} else {
				// "sql_keywords": SG_KEYWORDS | SG_HINTABLE_KEYWORDS
				if (((Symbol.SG_KEYWORDS & symbol.group) == symbol.group) || ((Symbol.SG_HINTABLE_KEYWORDS & symbol.group) == symbol.group)) {
					result = symbol;
				}
			}
		}
		return result;
	}
}
