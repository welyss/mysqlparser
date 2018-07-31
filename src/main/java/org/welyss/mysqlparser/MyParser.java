package org.welyss.mysqlparser;

import java.io.IOException;

import org.welyss.mysqlparser.items.Item;
import org.welyss.mysqlparser.items.TableIdent;
import org.welyss.mysqlparser.items.Token;
import org.welyss.mysqlparser.utils.MySQLParserUtils;

/* A Bison parser, made by GNU Bison 2.7.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java
   
      Copyright (C) 2007-2012 Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/**
 * A Bison parser, automatically generated from <tt>sql_yacc.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
class MyParser {
	/** Version number for the Bison executable that generated this parser. */
	public static final String bisonVersion = "2.7";

	/** Name of the skeleton that generated this parser. */
	public static final String bisonSkeleton = "lalr1.java";

	/** True if verbose error messages are enabled. */
	public boolean errorVerbose = false;

	/** Token returned by the scanner to signal the end of its input. */
	public static final int EOF = 0;

	/* Tokens. */
	/** Token number, to be returned by the scanner. */
	public static final int ABORT_SYM = 258;
	/** Token number, to be returned by the scanner. */
	public static final int ACCESSIBLE_SYM = 259;
	/** Token number, to be returned by the scanner. */
	public static final int ACTION = 260;
	/** Token number, to be returned by the scanner. */
	public static final int ADD = 261;
	/** Token number, to be returned by the scanner. */
	public static final int ADDDATE_SYM = 262;
	/** Token number, to be returned by the scanner. */
	public static final int AFTER_SYM = 263;
	/** Token number, to be returned by the scanner. */
	public static final int AGAINST = 264;
	/** Token number, to be returned by the scanner. */
	public static final int AGGREGATE_SYM = 265;
	/** Token number, to be returned by the scanner. */
	public static final int ALGORITHM_SYM = 266;
	/** Token number, to be returned by the scanner. */
	public static final int ALL = 267;
	/** Token number, to be returned by the scanner. */
	public static final int ALTER = 268;
	/** Token number, to be returned by the scanner. */
	public static final int ANALYSE_SYM = 269;
	/** Token number, to be returned by the scanner. */
	public static final int ANALYZE_SYM = 270;
	/** Token number, to be returned by the scanner. */
	public static final int AND_AND_SYM = 271;
	/** Token number, to be returned by the scanner. */
	public static final int AND_SYM = 272;
	/** Token number, to be returned by the scanner. */
	public static final int ANY_SYM = 273;
	/** Token number, to be returned by the scanner. */
	public static final int AS = 274;
	/** Token number, to be returned by the scanner. */
	public static final int ASC = 275;
	/** Token number, to be returned by the scanner. */
	public static final int ASCII_SYM = 276;
	/** Token number, to be returned by the scanner. */
	public static final int ASENSITIVE_SYM = 277;
	/** Token number, to be returned by the scanner. */
	public static final int AT_SYM = 278;
	/** Token number, to be returned by the scanner. */
	public static final int AUTOEXTEND_SIZE_SYM = 279;
	/** Token number, to be returned by the scanner. */
	public static final int AUTO_INC = 280;
	/** Token number, to be returned by the scanner. */
	public static final int AVG_ROW_LENGTH = 281;
	/** Token number, to be returned by the scanner. */
	public static final int AVG_SYM = 282;
	/** Token number, to be returned by the scanner. */
	public static final int BACKUP_SYM = 283;
	/** Token number, to be returned by the scanner. */
	public static final int BEFORE_SYM = 284;
	/** Token number, to be returned by the scanner. */
	public static final int BEGIN_SYM = 285;
	/** Token number, to be returned by the scanner. */
	public static final int BETWEEN_SYM = 286;
	/** Token number, to be returned by the scanner. */
	public static final int BIGINT = 287;
	/** Token number, to be returned by the scanner. */
	public static final int BINARY = 288;
	/** Token number, to be returned by the scanner. */
	public static final int BINLOG_SYM = 289;
	/** Token number, to be returned by the scanner. */
	public static final int BIN_NUM = 290;
	/** Token number, to be returned by the scanner. */
	public static final int BIT_AND = 291;
	/** Token number, to be returned by the scanner. */
	public static final int BIT_OR = 292;
	/** Token number, to be returned by the scanner. */
	public static final int BIT_SYM = 293;
	/** Token number, to be returned by the scanner. */
	public static final int BIT_XOR = 294;
	/** Token number, to be returned by the scanner. */
	public static final int BLOB_SYM = 295;
	/** Token number, to be returned by the scanner. */
	public static final int BLOCK_SYM = 296;
	/** Token number, to be returned by the scanner. */
	public static final int BOOLEAN_SYM = 297;
	/** Token number, to be returned by the scanner. */
	public static final int BOOL_SYM = 298;
	/** Token number, to be returned by the scanner. */
	public static final int BOTH = 299;
	/** Token number, to be returned by the scanner. */
	public static final int BTREE_SYM = 300;
	/** Token number, to be returned by the scanner. */
	public static final int BY = 301;
	/** Token number, to be returned by the scanner. */
	public static final int BYTE_SYM = 302;
	/** Token number, to be returned by the scanner. */
	public static final int CACHE_SYM = 303;
	/** Token number, to be returned by the scanner. */
	public static final int CALL_SYM = 304;
	/** Token number, to be returned by the scanner. */
	public static final int CASCADE = 305;
	/** Token number, to be returned by the scanner. */
	public static final int CASCADED = 306;
	/** Token number, to be returned by the scanner. */
	public static final int CASE_SYM = 307;
	/** Token number, to be returned by the scanner. */
	public static final int CAST_SYM = 308;
	/** Token number, to be returned by the scanner. */
	public static final int CATALOG_NAME_SYM = 309;
	/** Token number, to be returned by the scanner. */
	public static final int CHAIN_SYM = 310;
	/** Token number, to be returned by the scanner. */
	public static final int CHANGE = 311;
	/** Token number, to be returned by the scanner. */
	public static final int CHANGED = 312;
	/** Token number, to be returned by the scanner. */
	public static final int CHARSET = 313;
	/** Token number, to be returned by the scanner. */
	public static final int CHAR_SYM = 314;
	/** Token number, to be returned by the scanner. */
	public static final int CHECKSUM_SYM = 315;
	/** Token number, to be returned by the scanner. */
	public static final int CHECK_SYM = 316;
	/** Token number, to be returned by the scanner. */
	public static final int CIPHER_SYM = 317;
	/** Token number, to be returned by the scanner. */
	public static final int CLASS_ORIGIN_SYM = 318;
	/** Token number, to be returned by the scanner. */
	public static final int CLIENT_SYM = 319;
	/** Token number, to be returned by the scanner. */
	public static final int CLOSE_SYM = 320;
	/** Token number, to be returned by the scanner. */
	public static final int COALESCE = 321;
	/** Token number, to be returned by the scanner. */
	public static final int CODE_SYM = 322;
	/** Token number, to be returned by the scanner. */
	public static final int COLLATE_SYM = 323;
	/** Token number, to be returned by the scanner. */
	public static final int COLLATION_SYM = 324;
	/** Token number, to be returned by the scanner. */
	public static final int COLUMNS = 325;
	/** Token number, to be returned by the scanner. */
	public static final int COLUMN_SYM = 326;
	/** Token number, to be returned by the scanner. */
	public static final int COLUMN_FORMAT_SYM = 327;
	/** Token number, to be returned by the scanner. */
	public static final int COLUMN_NAME_SYM = 328;
	/** Token number, to be returned by the scanner. */
	public static final int COMMENT_SYM = 329;
	/** Token number, to be returned by the scanner. */
	public static final int COMMITTED_SYM = 330;
	/** Token number, to be returned by the scanner. */
	public static final int COMMIT_SYM = 331;
	/** Token number, to be returned by the scanner. */
	public static final int COMPACT_SYM = 332;
	/** Token number, to be returned by the scanner. */
	public static final int COMPLETION_SYM = 333;
	/** Token number, to be returned by the scanner. */
	public static final int COMPRESSED_SYM = 334;
	/** Token number, to be returned by the scanner. */
	public static final int CONCURRENT = 335;
	/** Token number, to be returned by the scanner. */
	public static final int CONDITION_SYM = 336;
	/** Token number, to be returned by the scanner. */
	public static final int CONNECTION_SYM = 337;
	/** Token number, to be returned by the scanner. */
	public static final int CONSISTENT_SYM = 338;
	/** Token number, to be returned by the scanner. */
	public static final int CONSTRAINT = 339;
	/** Token number, to be returned by the scanner. */
	public static final int CONSTRAINT_CATALOG_SYM = 340;
	/** Token number, to be returned by the scanner. */
	public static final int CONSTRAINT_NAME_SYM = 341;
	/** Token number, to be returned by the scanner. */
	public static final int CONSTRAINT_SCHEMA_SYM = 342;
	/** Token number, to be returned by the scanner. */
	public static final int CONTAINS_SYM = 343;
	/** Token number, to be returned by the scanner. */
	public static final int CONTEXT_SYM = 344;
	/** Token number, to be returned by the scanner. */
	public static final int CONTINUE_SYM = 345;
	/** Token number, to be returned by the scanner. */
	public static final int CONVERT_SYM = 346;
	/** Token number, to be returned by the scanner. */
	public static final int COUNT_SYM = 347;
	/** Token number, to be returned by the scanner. */
	public static final int CPU_SYM = 348;
	/** Token number, to be returned by the scanner. */
	public static final int CREATE = 349;
	/** Token number, to be returned by the scanner. */
	public static final int CROSS = 350;
	/** Token number, to be returned by the scanner. */
	public static final int CUBE_SYM = 351;
	/** Token number, to be returned by the scanner. */
	public static final int CURDATE = 352;
	/** Token number, to be returned by the scanner. */
	public static final int CURRENT_SYM = 353;
	/** Token number, to be returned by the scanner. */
	public static final int CURRENT_USER = 354;
	/** Token number, to be returned by the scanner. */
	public static final int CURSOR_SYM = 355;
	/** Token number, to be returned by the scanner. */
	public static final int CURSOR_NAME_SYM = 356;
	/** Token number, to be returned by the scanner. */
	public static final int CURTIME = 357;
	/** Token number, to be returned by the scanner. */
	public static final int DATABASE = 358;
	/** Token number, to be returned by the scanner. */
	public static final int DATABASES = 359;
	/** Token number, to be returned by the scanner. */
	public static final int DATAFILE_SYM = 360;
	/** Token number, to be returned by the scanner. */
	public static final int DATA_SYM = 361;
	/** Token number, to be returned by the scanner. */
	public static final int DATETIME = 362;
	/** Token number, to be returned by the scanner. */
	public static final int DATE_ADD_INTERVAL = 363;
	/** Token number, to be returned by the scanner. */
	public static final int DATE_SUB_INTERVAL = 364;
	/** Token number, to be returned by the scanner. */
	public static final int DATE_SYM = 365;
	/** Token number, to be returned by the scanner. */
	public static final int DAY_HOUR_SYM = 366;
	/** Token number, to be returned by the scanner. */
	public static final int DAY_MICROSECOND_SYM = 367;
	/** Token number, to be returned by the scanner. */
	public static final int DAY_MINUTE_SYM = 368;
	/** Token number, to be returned by the scanner. */
	public static final int DAY_SECOND_SYM = 369;
	/** Token number, to be returned by the scanner. */
	public static final int DAY_SYM = 370;
	/** Token number, to be returned by the scanner. */
	public static final int DEALLOCATE_SYM = 371;
	/** Token number, to be returned by the scanner. */
	public static final int DECIMAL_NUM = 372;
	/** Token number, to be returned by the scanner. */
	public static final int DECIMAL_SYM = 373;
	/** Token number, to be returned by the scanner. */
	public static final int DECLARE_SYM = 374;
	/** Token number, to be returned by the scanner. */
	public static final int DEFAULT = 375;
	/** Token number, to be returned by the scanner. */
	public static final int DEFAULT_AUTH_SYM = 376;
	/** Token number, to be returned by the scanner. */
	public static final int DEFINER_SYM = 377;
	/** Token number, to be returned by the scanner. */
	public static final int DELAYED_SYM = 378;
	/** Token number, to be returned by the scanner. */
	public static final int DELAY_KEY_WRITE_SYM = 379;
	/** Token number, to be returned by the scanner. */
	public static final int DELETE_SYM = 380;
	/** Token number, to be returned by the scanner. */
	public static final int DESC = 381;
	/** Token number, to be returned by the scanner. */
	public static final int DESCRIBE = 382;
	/** Token number, to be returned by the scanner. */
	public static final int DES_KEY_FILE = 383;
	/** Token number, to be returned by the scanner. */
	public static final int DETERMINISTIC_SYM = 384;
	/** Token number, to be returned by the scanner. */
	public static final int DIAGNOSTICS_SYM = 385;
	/** Token number, to be returned by the scanner. */
	public static final int DIRECTORY_SYM = 386;
	/** Token number, to be returned by the scanner. */
	public static final int DISABLE_SYM = 387;
	/** Token number, to be returned by the scanner. */
	public static final int DISCARD = 388;
	/** Token number, to be returned by the scanner. */
	public static final int DISK_SYM = 389;
	/** Token number, to be returned by the scanner. */
	public static final int DISTINCT = 390;
	/** Token number, to be returned by the scanner. */
	public static final int DIV_SYM = 391;
	/** Token number, to be returned by the scanner. */
	public static final int DOUBLE_SYM = 392;
	/** Token number, to be returned by the scanner. */
	public static final int DO_SYM = 393;
	/** Token number, to be returned by the scanner. */
	public static final int DROP = 394;
	/** Token number, to be returned by the scanner. */
	public static final int DUAL_SYM = 395;
	/** Token number, to be returned by the scanner. */
	public static final int DUMPFILE = 396;
	/** Token number, to be returned by the scanner. */
	public static final int DUPLICATE_SYM = 397;
	/** Token number, to be returned by the scanner. */
	public static final int DYNAMIC_SYM = 398;
	/** Token number, to be returned by the scanner. */
	public static final int EACH_SYM = 399;
	/** Token number, to be returned by the scanner. */
	public static final int ELSE = 400;
	/** Token number, to be returned by the scanner. */
	public static final int ELSEIF_SYM = 401;
	/** Token number, to be returned by the scanner. */
	public static final int ENABLE_SYM = 402;
	/** Token number, to be returned by the scanner. */
	public static final int ENCLOSED = 403;
	/** Token number, to be returned by the scanner. */
	public static final int END = 404;
	/** Token number, to be returned by the scanner. */
	public static final int ENDS_SYM = 405;
	/** Token number, to be returned by the scanner. */
	public static final int END_OF_INPUT = 406;
	/** Token number, to be returned by the scanner. */
	public static final int ENGINES_SYM = 407;
	/** Token number, to be returned by the scanner. */
	public static final int ENGINE_SYM = 408;
	/** Token number, to be returned by the scanner. */
	public static final int ENUM = 409;
	/** Token number, to be returned by the scanner. */
	public static final int EQ = 410;
	/** Token number, to be returned by the scanner. */
	public static final int EQUAL_SYM = 411;
	/** Token number, to be returned by the scanner. */
	public static final int ERROR_SYM = 412;
	/** Token number, to be returned by the scanner. */
	public static final int ERRORS = 413;
	/** Token number, to be returned by the scanner. */
	public static final int ESCAPED = 414;
	/** Token number, to be returned by the scanner. */
	public static final int ESCAPE_SYM = 415;
	/** Token number, to be returned by the scanner. */
	public static final int EVENTS_SYM = 416;
	/** Token number, to be returned by the scanner. */
	public static final int EVENT_SYM = 417;
	/** Token number, to be returned by the scanner. */
	public static final int EVERY_SYM = 418;
	/** Token number, to be returned by the scanner. */
	public static final int EXCHANGE_SYM = 419;
	/** Token number, to be returned by the scanner. */
	public static final int EXECUTE_SYM = 420;
	/** Token number, to be returned by the scanner. */
	public static final int EXISTS = 421;
	/** Token number, to be returned by the scanner. */
	public static final int EXIT_SYM = 422;
	/** Token number, to be returned by the scanner. */
	public static final int EXPANSION_SYM = 423;
	/** Token number, to be returned by the scanner. */
	public static final int EXPIRE_SYM = 424;
	/** Token number, to be returned by the scanner. */
	public static final int EXPORT_SYM = 425;
	/** Token number, to be returned by the scanner. */
	public static final int EXTENDED_SYM = 426;
	/** Token number, to be returned by the scanner. */
	public static final int EXTENT_SIZE_SYM = 427;
	/** Token number, to be returned by the scanner. */
	public static final int EXTRACT_SYM = 428;
	/** Token number, to be returned by the scanner. */
	public static final int FALSE_SYM = 429;
	/** Token number, to be returned by the scanner. */
	public static final int FAST_SYM = 430;
	/** Token number, to be returned by the scanner. */
	public static final int FAULTS_SYM = 431;
	/** Token number, to be returned by the scanner. */
	public static final int FETCH_SYM = 432;
	/** Token number, to be returned by the scanner. */
	public static final int FILE_SYM = 433;
	/** Token number, to be returned by the scanner. */
	public static final int FIRST_SYM = 434;
	/** Token number, to be returned by the scanner. */
	public static final int FIXED_SYM = 435;
	/** Token number, to be returned by the scanner. */
	public static final int FLOAT_NUM = 436;
	/** Token number, to be returned by the scanner. */
	public static final int FLOAT_SYM = 437;
	/** Token number, to be returned by the scanner. */
	public static final int FLUSH_SYM = 438;
	/** Token number, to be returned by the scanner. */
	public static final int FORCE_SYM = 439;
	/** Token number, to be returned by the scanner. */
	public static final int FOREIGN = 440;
	/** Token number, to be returned by the scanner. */
	public static final int FOR_SYM = 441;
	/** Token number, to be returned by the scanner. */
	public static final int FORMAT_SYM = 442;
	/** Token number, to be returned by the scanner. */
	public static final int FOUND_SYM = 443;
	/** Token number, to be returned by the scanner. */
	public static final int FROM = 444;
	/** Token number, to be returned by the scanner. */
	public static final int FULL = 445;
	/** Token number, to be returned by the scanner. */
	public static final int FULLTEXT_SYM = 446;
	/** Token number, to be returned by the scanner. */
	public static final int FUNCTION_SYM = 447;
	/** Token number, to be returned by the scanner. */
	public static final int GE = 448;
	/** Token number, to be returned by the scanner. */
	public static final int GENERAL = 449;
	/** Token number, to be returned by the scanner. */
	public static final int GEOMETRYCOLLECTION = 450;
	/** Token number, to be returned by the scanner. */
	public static final int GEOMETRY_SYM = 451;
	/** Token number, to be returned by the scanner. */
	public static final int GET_FORMAT = 452;
	/** Token number, to be returned by the scanner. */
	public static final int GET_SYM = 453;
	/** Token number, to be returned by the scanner. */
	public static final int GLOBAL_SYM = 454;
	/** Token number, to be returned by the scanner. */
	public static final int GRANT = 455;
	/** Token number, to be returned by the scanner. */
	public static final int GRANTS = 456;
	/** Token number, to be returned by the scanner. */
	public static final int GROUP_SYM = 457;
	/** Token number, to be returned by the scanner. */
	public static final int GROUP_CONCAT_SYM = 458;
	/** Token number, to be returned by the scanner. */
	public static final int GT_SYM = 459;
	/** Token number, to be returned by the scanner. */
	public static final int HANDLER_SYM = 460;
	/** Token number, to be returned by the scanner. */
	public static final int HASH_SYM = 461;
	/** Token number, to be returned by the scanner. */
	public static final int HAVING = 462;
	/** Token number, to be returned by the scanner. */
	public static final int HELP_SYM = 463;
	/** Token number, to be returned by the scanner. */
	public static final int HEX_NUM = 464;
	/** Token number, to be returned by the scanner. */
	public static final int HIGH_PRIORITY = 465;
	/** Token number, to be returned by the scanner. */
	public static final int HOST_SYM = 466;
	/** Token number, to be returned by the scanner. */
	public static final int HOSTS_SYM = 467;
	/** Token number, to be returned by the scanner. */
	public static final int HOUR_MICROSECOND_SYM = 468;
	/** Token number, to be returned by the scanner. */
	public static final int HOUR_MINUTE_SYM = 469;
	/** Token number, to be returned by the scanner. */
	public static final int HOUR_SECOND_SYM = 470;
	/** Token number, to be returned by the scanner. */
	public static final int HOUR_SYM = 471;
	/** Token number, to be returned by the scanner. */
	public static final int IDENT = 472;
	/** Token number, to be returned by the scanner. */
	public static final int IDENTIFIED_SYM = 473;
	/** Token number, to be returned by the scanner. */
	public static final int IDENT_QUOTED = 474;
	/** Token number, to be returned by the scanner. */
	public static final int IF = 475;
	/** Token number, to be returned by the scanner. */
	public static final int IGNORE_SYM = 476;
	/** Token number, to be returned by the scanner. */
	public static final int IGNORE_SERVER_IDS_SYM = 477;
	/** Token number, to be returned by the scanner. */
	public static final int IMPORT = 478;
	/** Token number, to be returned by the scanner. */
	public static final int INDEXES = 479;
	/** Token number, to be returned by the scanner. */
	public static final int INDEX_SYM = 480;
	/** Token number, to be returned by the scanner. */
	public static final int INFILE = 481;
	/** Token number, to be returned by the scanner. */
	public static final int INITIAL_SIZE_SYM = 482;
	/** Token number, to be returned by the scanner. */
	public static final int INNER_SYM = 483;
	/** Token number, to be returned by the scanner. */
	public static final int INOUT_SYM = 484;
	/** Token number, to be returned by the scanner. */
	public static final int INSENSITIVE_SYM = 485;
	/** Token number, to be returned by the scanner. */
	public static final int INSERT = 486;
	/** Token number, to be returned by the scanner. */
	public static final int INSERT_METHOD = 487;
	/** Token number, to be returned by the scanner. */
	public static final int INSTALL_SYM = 488;
	/** Token number, to be returned by the scanner. */
	public static final int INTERVAL_SYM = 489;
	/** Token number, to be returned by the scanner. */
	public static final int INTO = 490;
	/** Token number, to be returned by the scanner. */
	public static final int INT_SYM = 491;
	/** Token number, to be returned by the scanner. */
	public static final int INVOKER_SYM = 492;
	/** Token number, to be returned by the scanner. */
	public static final int IN_SYM = 493;
	/** Token number, to be returned by the scanner. */
	public static final int IO_AFTER_GTIDS = 494;
	/** Token number, to be returned by the scanner. */
	public static final int IO_BEFORE_GTIDS = 495;
	/** Token number, to be returned by the scanner. */
	public static final int IO_SYM = 496;
	/** Token number, to be returned by the scanner. */
	public static final int IPC_SYM = 497;
	/** Token number, to be returned by the scanner. */
	public static final int IS = 498;
	/** Token number, to be returned by the scanner. */
	public static final int ISOLATION = 499;
	/** Token number, to be returned by the scanner. */
	public static final int ISSUER_SYM = 500;
	/** Token number, to be returned by the scanner. */
	public static final int ITERATE_SYM = 501;
	/** Token number, to be returned by the scanner. */
	public static final int JOIN_SYM = 502;
	/** Token number, to be returned by the scanner. */
	public static final int KEYS = 503;
	/** Token number, to be returned by the scanner. */
	public static final int KEY_BLOCK_SIZE = 504;
	/** Token number, to be returned by the scanner. */
	public static final int KEY_SYM = 505;
	/** Token number, to be returned by the scanner. */
	public static final int KILL_SYM = 506;
	/** Token number, to be returned by the scanner. */
	public static final int LANGUAGE_SYM = 507;
	/** Token number, to be returned by the scanner. */
	public static final int LAST_SYM = 508;
	/** Token number, to be returned by the scanner. */
	public static final int LE = 509;
	/** Token number, to be returned by the scanner. */
	public static final int LEADING = 510;
	/** Token number, to be returned by the scanner. */
	public static final int LEAVES = 511;
	/** Token number, to be returned by the scanner. */
	public static final int LEAVE_SYM = 512;
	/** Token number, to be returned by the scanner. */
	public static final int LEFT = 513;
	/** Token number, to be returned by the scanner. */
	public static final int LESS_SYM = 514;
	/** Token number, to be returned by the scanner. */
	public static final int LEVEL_SYM = 515;
	/** Token number, to be returned by the scanner. */
	public static final int LEX_HOSTNAME = 516;
	/** Token number, to be returned by the scanner. */
	public static final int LIKE = 517;
	/** Token number, to be returned by the scanner. */
	public static final int LIMIT = 518;
	/** Token number, to be returned by the scanner. */
	public static final int LINEAR_SYM = 519;
	/** Token number, to be returned by the scanner. */
	public static final int LINES = 520;
	/** Token number, to be returned by the scanner. */
	public static final int LINESTRING = 521;
	/** Token number, to be returned by the scanner. */
	public static final int LIST_SYM = 522;
	/** Token number, to be returned by the scanner. */
	public static final int LOAD = 523;
	/** Token number, to be returned by the scanner. */
	public static final int LOCAL_SYM = 524;
	/** Token number, to be returned by the scanner. */
	public static final int LOCATOR_SYM = 525;
	/** Token number, to be returned by the scanner. */
	public static final int LOCKS_SYM = 526;
	/** Token number, to be returned by the scanner. */
	public static final int LOCK_SYM = 527;
	/** Token number, to be returned by the scanner. */
	public static final int LOGFILE_SYM = 528;
	/** Token number, to be returned by the scanner. */
	public static final int LOGS_SYM = 529;
	/** Token number, to be returned by the scanner. */
	public static final int LONGBLOB = 530;
	/** Token number, to be returned by the scanner. */
	public static final int LONGTEXT = 531;
	/** Token number, to be returned by the scanner. */
	public static final int LONG_NUM = 532;
	/** Token number, to be returned by the scanner. */
	public static final int LONG_SYM = 533;
	/** Token number, to be returned by the scanner. */
	public static final int LOOP_SYM = 534;
	/** Token number, to be returned by the scanner. */
	public static final int LOW_PRIORITY = 535;
	/** Token number, to be returned by the scanner. */
	public static final int LT = 536;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_AUTO_POSITION_SYM = 537;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_BIND_SYM = 538;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_CONNECT_RETRY_SYM = 539;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_DELAY_SYM = 540;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_HOST_SYM = 541;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_LOG_FILE_SYM = 542;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_LOG_POS_SYM = 543;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_PASSWORD_SYM = 544;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_PORT_SYM = 545;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_RETRY_COUNT_SYM = 546;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SERVER_ID_SYM = 547;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_CAPATH_SYM = 548;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_CA_SYM = 549;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_CERT_SYM = 550;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_CIPHER_SYM = 551;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_CRL_SYM = 552;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_CRLPATH_SYM = 553;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_KEY_SYM = 554;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_SYM = 555;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SSL_VERIFY_SERVER_CERT_SYM = 556;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_SYM = 557;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_USER_SYM = 558;
	/** Token number, to be returned by the scanner. */
	public static final int MASTER_HEARTBEAT_PERIOD_SYM = 559;
	/** Token number, to be returned by the scanner. */
	public static final int MATCH = 560;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_CONNECTIONS_PER_HOUR = 561;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_QUERIES_PER_HOUR = 562;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_ROWS = 563;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_SIZE_SYM = 564;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_SYM = 565;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_UPDATES_PER_HOUR = 566;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_USER_CONNECTIONS_SYM = 567;
	/** Token number, to be returned by the scanner. */
	public static final int MAX_VALUE_SYM = 568;
	/** Token number, to be returned by the scanner. */
	public static final int MEDIUMBLOB = 569;
	/** Token number, to be returned by the scanner. */
	public static final int MEDIUMINT = 570;
	/** Token number, to be returned by the scanner. */
	public static final int MEDIUMTEXT = 571;
	/** Token number, to be returned by the scanner. */
	public static final int MEDIUM_SYM = 572;
	/** Token number, to be returned by the scanner. */
	public static final int MEMORY_SYM = 573;
	/** Token number, to be returned by the scanner. */
	public static final int MERGE_SYM = 574;
	/** Token number, to be returned by the scanner. */
	public static final int MESSAGE_TEXT_SYM = 575;
	/** Token number, to be returned by the scanner. */
	public static final int MICROSECOND_SYM = 576;
	/** Token number, to be returned by the scanner. */
	public static final int MIGRATE_SYM = 577;
	/** Token number, to be returned by the scanner. */
	public static final int MINUTE_MICROSECOND_SYM = 578;
	/** Token number, to be returned by the scanner. */
	public static final int MINUTE_SECOND_SYM = 579;
	/** Token number, to be returned by the scanner. */
	public static final int MINUTE_SYM = 580;
	/** Token number, to be returned by the scanner. */
	public static final int MIN_ROWS = 581;
	/** Token number, to be returned by the scanner. */
	public static final int MIN_SYM = 582;
	/** Token number, to be returned by the scanner. */
	public static final int MODE_SYM = 583;
	/** Token number, to be returned by the scanner. */
	public static final int MODIFIES_SYM = 584;
	/** Token number, to be returned by the scanner. */
	public static final int MODIFY_SYM = 585;
	/** Token number, to be returned by the scanner. */
	public static final int MOD_SYM = 586;
	/** Token number, to be returned by the scanner. */
	public static final int MONTH_SYM = 587;
	/** Token number, to be returned by the scanner. */
	public static final int MULTILINESTRING = 588;
	/** Token number, to be returned by the scanner. */
	public static final int MULTIPOINT = 589;
	/** Token number, to be returned by the scanner. */
	public static final int MULTIPOLYGON = 590;
	/** Token number, to be returned by the scanner. */
	public static final int MUTEX_SYM = 591;
	/** Token number, to be returned by the scanner. */
	public static final int MYSQL_ERRNO_SYM = 592;
	/** Token number, to be returned by the scanner. */
	public static final int NAMES_SYM = 593;
	/** Token number, to be returned by the scanner. */
	public static final int NAME_SYM = 594;
	/** Token number, to be returned by the scanner. */
	public static final int NATIONAL_SYM = 595;
	/** Token number, to be returned by the scanner. */
	public static final int NATURAL = 596;
	/** Token number, to be returned by the scanner. */
	public static final int NCHAR_STRING = 597;
	/** Token number, to be returned by the scanner. */
	public static final int NCHAR_SYM = 598;
	/** Token number, to be returned by the scanner. */
	public static final int NDBCLUSTER_SYM = 599;
	/** Token number, to be returned by the scanner. */
	public static final int NE = 600;
	/** Token number, to be returned by the scanner. */
	public static final int NEG = 601;
	/** Token number, to be returned by the scanner. */
	public static final int NEW_SYM = 602;
	/** Token number, to be returned by the scanner. */
	public static final int NEXT_SYM = 603;
	/** Token number, to be returned by the scanner. */
	public static final int NODEGROUP_SYM = 604;
	/** Token number, to be returned by the scanner. */
	public static final int NONE_SYM = 605;
	/** Token number, to be returned by the scanner. */
	public static final int NOT2_SYM = 606;
	/** Token number, to be returned by the scanner. */
	public static final int NOT_SYM = 607;
	/** Token number, to be returned by the scanner. */
	public static final int NOW_SYM = 608;
	/** Token number, to be returned by the scanner. */
	public static final int NO_SYM = 609;
	/** Token number, to be returned by the scanner. */
	public static final int NO_WAIT_SYM = 610;
	/** Token number, to be returned by the scanner. */
	public static final int NO_WRITE_TO_BINLOG = 611;
	/** Token number, to be returned by the scanner. */
	public static final int NULL_SYM = 612;
	/** Token number, to be returned by the scanner. */
	public static final int NUM = 613;
	/** Token number, to be returned by the scanner. */
	public static final int NUMBER_SYM = 614;
	/** Token number, to be returned by the scanner. */
	public static final int NUMERIC_SYM = 615;
	/** Token number, to be returned by the scanner. */
	public static final int NVARCHAR_SYM = 616;
	/** Token number, to be returned by the scanner. */
	public static final int OFFSET_SYM = 617;
	/** Token number, to be returned by the scanner. */
	public static final int OLD_PASSWORD = 618;
	/** Token number, to be returned by the scanner. */
	public static final int ON = 619;
	/** Token number, to be returned by the scanner. */
	public static final int ONE_SYM = 620;
	/** Token number, to be returned by the scanner. */
	public static final int ONLY_SYM = 621;
	/** Token number, to be returned by the scanner. */
	public static final int OPEN_SYM = 622;
	/** Token number, to be returned by the scanner. */
	public static final int OPTIMIZE = 623;
	/** Token number, to be returned by the scanner. */
	public static final int OPTIONS_SYM = 624;
	/** Token number, to be returned by the scanner. */
	public static final int OPTION = 625;
	/** Token number, to be returned by the scanner. */
	public static final int OPTIONALLY = 626;
	/** Token number, to be returned by the scanner. */
	public static final int OR2_SYM = 627;
	/** Token number, to be returned by the scanner. */
	public static final int ORDER_SYM = 628;
	/** Token number, to be returned by the scanner. */
	public static final int OR_OR_SYM = 629;
	/** Token number, to be returned by the scanner. */
	public static final int OR_SYM = 630;
	/** Token number, to be returned by the scanner. */
	public static final int OUTER = 631;
	/** Token number, to be returned by the scanner. */
	public static final int OUTFILE = 632;
	/** Token number, to be returned by the scanner. */
	public static final int OUT_SYM = 633;
	/** Token number, to be returned by the scanner. */
	public static final int OWNER_SYM = 634;
	/** Token number, to be returned by the scanner. */
	public static final int PACK_KEYS_SYM = 635;
	/** Token number, to be returned by the scanner. */
	public static final int PAGE_SYM = 636;
	/** Token number, to be returned by the scanner. */
	public static final int PARAM_MARKER = 637;
	/** Token number, to be returned by the scanner. */
	public static final int PARSER_SYM = 638;
	/** Token number, to be returned by the scanner. */
	public static final int PARTIAL = 639;
	/** Token number, to be returned by the scanner. */
	public static final int PARTITION_SYM = 640;
	/** Token number, to be returned by the scanner. */
	public static final int PARTITIONS_SYM = 641;
	/** Token number, to be returned by the scanner. */
	public static final int PARTITIONING_SYM = 642;
	/** Token number, to be returned by the scanner. */
	public static final int PASSWORD = 643;
	/** Token number, to be returned by the scanner. */
	public static final int PHASE_SYM = 644;
	/** Token number, to be returned by the scanner. */
	public static final int PLUGIN_DIR_SYM = 645;
	/** Token number, to be returned by the scanner. */
	public static final int PLUGIN_SYM = 646;
	/** Token number, to be returned by the scanner. */
	public static final int PLUGINS_SYM = 647;
	/** Token number, to be returned by the scanner. */
	public static final int POINT_SYM = 648;
	/** Token number, to be returned by the scanner. */
	public static final int POLYGON = 649;
	/** Token number, to be returned by the scanner. */
	public static final int PORT_SYM = 650;
	/** Token number, to be returned by the scanner. */
	public static final int POSITION_SYM = 651;
	/** Token number, to be returned by the scanner. */
	public static final int PRECISION = 652;
	/** Token number, to be returned by the scanner. */
	public static final int PREPARE_SYM = 653;
	/** Token number, to be returned by the scanner. */
	public static final int PRESERVE_SYM = 654;
	/** Token number, to be returned by the scanner. */
	public static final int PREV_SYM = 655;
	/** Token number, to be returned by the scanner. */
	public static final int PRIMARY_SYM = 656;
	/** Token number, to be returned by the scanner. */
	public static final int PRIVILEGES = 657;
	/** Token number, to be returned by the scanner. */
	public static final int PROCEDURE_SYM = 658;
	/** Token number, to be returned by the scanner. */
	public static final int PROCESS = 659;
	/** Token number, to be returned by the scanner. */
	public static final int PROCESSLIST_SYM = 660;
	/** Token number, to be returned by the scanner. */
	public static final int PROFILE_SYM = 661;
	/** Token number, to be returned by the scanner. */
	public static final int PROFILES_SYM = 662;
	/** Token number, to be returned by the scanner. */
	public static final int PROXY_SYM = 663;
	/** Token number, to be returned by the scanner. */
	public static final int PURGE = 664;
	/** Token number, to be returned by the scanner. */
	public static final int QUARTER_SYM = 665;
	/** Token number, to be returned by the scanner. */
	public static final int QUERY_SYM = 666;
	/** Token number, to be returned by the scanner. */
	public static final int QUICK = 667;
	/** Token number, to be returned by the scanner. */
	public static final int RANGE_SYM = 668;
	/** Token number, to be returned by the scanner. */
	public static final int READS_SYM = 669;
	/** Token number, to be returned by the scanner. */
	public static final int READ_ONLY_SYM = 670;
	/** Token number, to be returned by the scanner. */
	public static final int READ_SYM = 671;
	/** Token number, to be returned by the scanner. */
	public static final int READ_WRITE_SYM = 672;
	/** Token number, to be returned by the scanner. */
	public static final int REAL = 673;
	/** Token number, to be returned by the scanner. */
	public static final int REBUILD_SYM = 674;
	/** Token number, to be returned by the scanner. */
	public static final int RECOVER_SYM = 675;
	/** Token number, to be returned by the scanner. */
	public static final int REDOFILE_SYM = 676;
	/** Token number, to be returned by the scanner. */
	public static final int REDO_BUFFER_SIZE_SYM = 677;
	/** Token number, to be returned by the scanner. */
	public static final int REDUNDANT_SYM = 678;
	/** Token number, to be returned by the scanner. */
	public static final int REFERENCES = 679;
	/** Token number, to be returned by the scanner. */
	public static final int REGEXP = 680;
	/** Token number, to be returned by the scanner. */
	public static final int RELAY = 681;
	/** Token number, to be returned by the scanner. */
	public static final int RELAYLOG_SYM = 682;
	/** Token number, to be returned by the scanner. */
	public static final int RELAY_LOG_FILE_SYM = 683;
	/** Token number, to be returned by the scanner. */
	public static final int RELAY_LOG_POS_SYM = 684;
	/** Token number, to be returned by the scanner. */
	public static final int RELAY_THREAD = 685;
	/** Token number, to be returned by the scanner. */
	public static final int RELEASE_SYM = 686;
	/** Token number, to be returned by the scanner. */
	public static final int RELOAD = 687;
	/** Token number, to be returned by the scanner. */
	public static final int REMOVE_SYM = 688;
	/** Token number, to be returned by the scanner. */
	public static final int RENAME = 689;
	/** Token number, to be returned by the scanner. */
	public static final int REORGANIZE_SYM = 690;
	/** Token number, to be returned by the scanner. */
	public static final int REPAIR = 691;
	/** Token number, to be returned by the scanner. */
	public static final int REPEATABLE_SYM = 692;
	/** Token number, to be returned by the scanner. */
	public static final int REPEAT_SYM = 693;
	/** Token number, to be returned by the scanner. */
	public static final int REPLACE = 694;
	/** Token number, to be returned by the scanner. */
	public static final int REPLICATION = 695;
	/** Token number, to be returned by the scanner. */
	public static final int REQUIRE_SYM = 696;
	/** Token number, to be returned by the scanner. */
	public static final int RESET_SYM = 697;
	/** Token number, to be returned by the scanner. */
	public static final int RESIGNAL_SYM = 698;
	/** Token number, to be returned by the scanner. */
	public static final int RESOURCES = 699;
	/** Token number, to be returned by the scanner. */
	public static final int RESTORE_SYM = 700;
	/** Token number, to be returned by the scanner. */
	public static final int RESTRICT = 701;
	/** Token number, to be returned by the scanner. */
	public static final int RESUME_SYM = 702;
	/** Token number, to be returned by the scanner. */
	public static final int RETURNED_SQLSTATE_SYM = 703;
	/** Token number, to be returned by the scanner. */
	public static final int RETURNS_SYM = 704;
	/** Token number, to be returned by the scanner. */
	public static final int RETURN_SYM = 705;
	/** Token number, to be returned by the scanner. */
	public static final int REVERSE_SYM = 706;
	/** Token number, to be returned by the scanner. */
	public static final int REVOKE = 707;
	/** Token number, to be returned by the scanner. */
	public static final int RIGHT = 708;
	/** Token number, to be returned by the scanner. */
	public static final int ROLLBACK_SYM = 709;
	/** Token number, to be returned by the scanner. */
	public static final int ROLLUP_SYM = 710;
	/** Token number, to be returned by the scanner. */
	public static final int ROUTINE_SYM = 711;
	/** Token number, to be returned by the scanner. */
	public static final int ROWS_SYM = 712;
	/** Token number, to be returned by the scanner. */
	public static final int ROW_FORMAT_SYM = 713;
	/** Token number, to be returned by the scanner. */
	public static final int ROW_SYM = 714;
	/** Token number, to be returned by the scanner. */
	public static final int ROW_COUNT_SYM = 715;
	/** Token number, to be returned by the scanner. */
	public static final int RTREE_SYM = 716;
	/** Token number, to be returned by the scanner. */
	public static final int SAVEPOINT_SYM = 717;
	/** Token number, to be returned by the scanner. */
	public static final int SCHEDULE_SYM = 718;
	/** Token number, to be returned by the scanner. */
	public static final int SCHEMA_NAME_SYM = 719;
	/** Token number, to be returned by the scanner. */
	public static final int SECOND_MICROSECOND_SYM = 720;
	/** Token number, to be returned by the scanner. */
	public static final int SECOND_SYM = 721;
	/** Token number, to be returned by the scanner. */
	public static final int SECURITY_SYM = 722;
	/** Token number, to be returned by the scanner. */
	public static final int SELECT_SYM = 723;
	/** Token number, to be returned by the scanner. */
	public static final int SENSITIVE_SYM = 724;
	/** Token number, to be returned by the scanner. */
	public static final int SEPARATOR_SYM = 725;
	/** Token number, to be returned by the scanner. */
	public static final int SERIALIZABLE_SYM = 726;
	/** Token number, to be returned by the scanner. */
	public static final int SERIAL_SYM = 727;
	/** Token number, to be returned by the scanner. */
	public static final int SESSION_SYM = 728;
	/** Token number, to be returned by the scanner. */
	public static final int SERVER_SYM = 729;
	/** Token number, to be returned by the scanner. */
	public static final int SERVER_OPTIONS = 730;
	/** Token number, to be returned by the scanner. */
	public static final int SET = 731;
	/** Token number, to be returned by the scanner. */
	public static final int SET_VAR = 732;
	/** Token number, to be returned by the scanner. */
	public static final int SHARE_SYM = 733;
	/** Token number, to be returned by the scanner. */
	public static final int SHIFT_LEFT = 734;
	/** Token number, to be returned by the scanner. */
	public static final int SHIFT_RIGHT = 735;
	/** Token number, to be returned by the scanner. */
	public static final int SHOW = 736;
	/** Token number, to be returned by the scanner. */
	public static final int SHUTDOWN = 737;
	/** Token number, to be returned by the scanner. */
	public static final int SIGNAL_SYM = 738;
	/** Token number, to be returned by the scanner. */
	public static final int SIGNED_SYM = 739;
	/** Token number, to be returned by the scanner. */
	public static final int SIMPLE_SYM = 740;
	/** Token number, to be returned by the scanner. */
	public static final int SLAVE = 741;
	/** Token number, to be returned by the scanner. */
	public static final int SLOW = 742;
	/** Token number, to be returned by the scanner. */
	public static final int SMALLINT = 743;
	/** Token number, to be returned by the scanner. */
	public static final int SNAPSHOT_SYM = 744;
	/** Token number, to be returned by the scanner. */
	public static final int SOCKET_SYM = 745;
	/** Token number, to be returned by the scanner. */
	public static final int SONAME_SYM = 746;
	/** Token number, to be returned by the scanner. */
	public static final int SOUNDS_SYM = 747;
	/** Token number, to be returned by the scanner. */
	public static final int SOURCE_SYM = 748;
	/** Token number, to be returned by the scanner. */
	public static final int SPATIAL_SYM = 749;
	/** Token number, to be returned by the scanner. */
	public static final int SPECIFIC_SYM = 750;
	/** Token number, to be returned by the scanner. */
	public static final int SQLEXCEPTION_SYM = 751;
	/** Token number, to be returned by the scanner. */
	public static final int SQLSTATE_SYM = 752;
	/** Token number, to be returned by the scanner. */
	public static final int SQLWARNING_SYM = 753;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_AFTER_GTIDS = 754;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_AFTER_MTS_GAPS = 755;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_BEFORE_GTIDS = 756;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_BIG_RESULT = 757;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_BUFFER_RESULT = 758;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_CACHE_SYM = 759;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_CALC_FOUND_ROWS = 760;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_NO_CACHE_SYM = 761;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_SMALL_RESULT = 762;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_SYM = 763;
	/** Token number, to be returned by the scanner. */
	public static final int SQL_THREAD = 764;
	/** Token number, to be returned by the scanner. */
	public static final int SSL_SYM = 765;
	/** Token number, to be returned by the scanner. */
	public static final int STARTING = 766;
	/** Token number, to be returned by the scanner. */
	public static final int STARTS_SYM = 767;
	/** Token number, to be returned by the scanner. */
	public static final int START_SYM = 768;
	/** Token number, to be returned by the scanner. */
	public static final int STATS_AUTO_RECALC_SYM = 769;
	/** Token number, to be returned by the scanner. */
	public static final int STATS_PERSISTENT_SYM = 770;
	/** Token number, to be returned by the scanner. */
	public static final int STATS_SAMPLE_PAGES_SYM = 771;
	/** Token number, to be returned by the scanner. */
	public static final int STATUS_SYM = 772;
	/** Token number, to be returned by the scanner. */
	public static final int STDDEV_SAMP_SYM = 773;
	/** Token number, to be returned by the scanner. */
	public static final int STD_SYM = 774;
	/** Token number, to be returned by the scanner. */
	public static final int STOP_SYM = 775;
	/** Token number, to be returned by the scanner. */
	public static final int STORAGE_SYM = 776;
	/** Token number, to be returned by the scanner. */
	public static final int STRAIGHT_JOIN = 777;
	/** Token number, to be returned by the scanner. */
	public static final int STRING_SYM = 778;
	/** Token number, to be returned by the scanner. */
	public static final int SUBCLASS_ORIGIN_SYM = 779;
	/** Token number, to be returned by the scanner. */
	public static final int SUBDATE_SYM = 780;
	/** Token number, to be returned by the scanner. */
	public static final int SUBJECT_SYM = 781;
	/** Token number, to be returned by the scanner. */
	public static final int SUBPARTITIONS_SYM = 782;
	/** Token number, to be returned by the scanner. */
	public static final int SUBPARTITION_SYM = 783;
	/** Token number, to be returned by the scanner. */
	public static final int SUBSTRING = 784;
	/** Token number, to be returned by the scanner. */
	public static final int SUM_SYM = 785;
	/** Token number, to be returned by the scanner. */
	public static final int SUPER_SYM = 786;
	/** Token number, to be returned by the scanner. */
	public static final int SUSPEND_SYM = 787;
	/** Token number, to be returned by the scanner. */
	public static final int SWAPS_SYM = 788;
	/** Token number, to be returned by the scanner. */
	public static final int SWITCHES_SYM = 789;
	/** Token number, to be returned by the scanner. */
	public static final int SYSDATE = 790;
	/** Token number, to be returned by the scanner. */
	public static final int TABLES = 791;
	/** Token number, to be returned by the scanner. */
	public static final int TABLESPACE = 792;
	/** Token number, to be returned by the scanner. */
	public static final int TABLE_REF_PRIORITY = 793;
	/** Token number, to be returned by the scanner. */
	public static final int TABLE_SYM = 794;
	/** Token number, to be returned by the scanner. */
	public static final int TABLE_CHECKSUM_SYM = 795;
	/** Token number, to be returned by the scanner. */
	public static final int TABLE_NAME_SYM = 796;
	/** Token number, to be returned by the scanner. */
	public static final int TEMPORARY = 797;
	/** Token number, to be returned by the scanner. */
	public static final int TEMPTABLE_SYM = 798;
	/** Token number, to be returned by the scanner. */
	public static final int TERMINATED = 799;
	/** Token number, to be returned by the scanner. */
	public static final int TEXT_STRING = 800;
	/** Token number, to be returned by the scanner. */
	public static final int TEXT_SYM = 801;
	/** Token number, to be returned by the scanner. */
	public static final int THAN_SYM = 802;
	/** Token number, to be returned by the scanner. */
	public static final int THEN_SYM = 803;
	/** Token number, to be returned by the scanner. */
	public static final int TIMESTAMP = 804;
	/** Token number, to be returned by the scanner. */
	public static final int TIMESTAMP_ADD = 805;
	/** Token number, to be returned by the scanner. */
	public static final int TIMESTAMP_DIFF = 806;
	/** Token number, to be returned by the scanner. */
	public static final int TIME_SYM = 807;
	/** Token number, to be returned by the scanner. */
	public static final int TINYBLOB = 808;
	/** Token number, to be returned by the scanner. */
	public static final int TINYINT = 809;
	/** Token number, to be returned by the scanner. */
	public static final int TINYTEXT = 810;
	/** Token number, to be returned by the scanner. */
	public static final int TO_SYM = 811;
	/** Token number, to be returned by the scanner. */
	public static final int TRAILING = 812;
	/** Token number, to be returned by the scanner. */
	public static final int TRANSACTION_SYM = 813;
	/** Token number, to be returned by the scanner. */
	public static final int TRIGGERS_SYM = 814;
	/** Token number, to be returned by the scanner. */
	public static final int TRIGGER_SYM = 815;
	/** Token number, to be returned by the scanner. */
	public static final int TRIM = 816;
	/** Token number, to be returned by the scanner. */
	public static final int TRUE_SYM = 817;
	/** Token number, to be returned by the scanner. */
	public static final int TRUNCATE_SYM = 818;
	/** Token number, to be returned by the scanner. */
	public static final int TYPES_SYM = 819;
	/** Token number, to be returned by the scanner. */
	public static final int TYPE_SYM = 820;
	/** Token number, to be returned by the scanner. */
	public static final int UDF_RETURNS_SYM = 821;
	/** Token number, to be returned by the scanner. */
	public static final int ULONGLONG_NUM = 822;
	/** Token number, to be returned by the scanner. */
	public static final int UNCOMMITTED_SYM = 823;
	/** Token number, to be returned by the scanner. */
	public static final int UNDEFINED_SYM = 824;
	/** Token number, to be returned by the scanner. */
	public static final int UNDERSCORE_CHARSET = 825;
	/** Token number, to be returned by the scanner. */
	public static final int UNDOFILE_SYM = 826;
	/** Token number, to be returned by the scanner. */
	public static final int UNDO_BUFFER_SIZE_SYM = 827;
	/** Token number, to be returned by the scanner. */
	public static final int UNDO_SYM = 828;
	/** Token number, to be returned by the scanner. */
	public static final int UNICODE_SYM = 829;
	/** Token number, to be returned by the scanner. */
	public static final int UNINSTALL_SYM = 830;
	/** Token number, to be returned by the scanner. */
	public static final int UNION_SYM = 831;
	/** Token number, to be returned by the scanner. */
	public static final int UNIQUE_SYM = 832;
	/** Token number, to be returned by the scanner. */
	public static final int UNKNOWN_SYM = 833;
	/** Token number, to be returned by the scanner. */
	public static final int UNLOCK_SYM = 834;
	/** Token number, to be returned by the scanner. */
	public static final int UNSIGNED = 835;
	/** Token number, to be returned by the scanner. */
	public static final int UNTIL_SYM = 836;
	/** Token number, to be returned by the scanner. */
	public static final int UPDATE_SYM = 837;
	/** Token number, to be returned by the scanner. */
	public static final int UPGRADE_SYM = 838;
	/** Token number, to be returned by the scanner. */
	public static final int USAGE = 839;
	/** Token number, to be returned by the scanner. */
	public static final int USER = 840;
	/** Token number, to be returned by the scanner. */
	public static final int USE_FRM = 841;
	/** Token number, to be returned by the scanner. */
	public static final int USE_SYM = 842;
	/** Token number, to be returned by the scanner. */
	public static final int USING = 843;
	/** Token number, to be returned by the scanner. */
	public static final int UTC_DATE_SYM = 844;
	/** Token number, to be returned by the scanner. */
	public static final int UTC_TIMESTAMP_SYM = 845;
	/** Token number, to be returned by the scanner. */
	public static final int UTC_TIME_SYM = 846;
	/** Token number, to be returned by the scanner. */
	public static final int VALUES = 847;
	/** Token number, to be returned by the scanner. */
	public static final int VALUE_SYM = 848;
	/** Token number, to be returned by the scanner. */
	public static final int VARBINARY = 849;
	/** Token number, to be returned by the scanner. */
	public static final int VARCHAR = 850;
	/** Token number, to be returned by the scanner. */
	public static final int VARIABLES = 851;
	/** Token number, to be returned by the scanner. */
	public static final int VARIANCE_SYM = 852;
	/** Token number, to be returned by the scanner. */
	public static final int VARYING = 853;
	/** Token number, to be returned by the scanner. */
	public static final int VAR_SAMP_SYM = 854;
	/** Token number, to be returned by the scanner. */
	public static final int VIEW_SYM = 855;
	/** Token number, to be returned by the scanner. */
	public static final int WAIT_SYM = 856;
	/** Token number, to be returned by the scanner. */
	public static final int WARNINGS = 857;
	/** Token number, to be returned by the scanner. */
	public static final int WEEK_SYM = 858;
	/** Token number, to be returned by the scanner. */
	public static final int WEIGHT_STRING_SYM = 859;
	/** Token number, to be returned by the scanner. */
	public static final int WHEN_SYM = 860;
	/** Token number, to be returned by the scanner. */
	public static final int WHERE = 861;
	/** Token number, to be returned by the scanner. */
	public static final int WHILE_SYM = 862;
	/** Token number, to be returned by the scanner. */
	public static final int WITH = 863;
	/** Token number, to be returned by the scanner. */
	public static final int WITH_CUBE_SYM = 864;
	/** Token number, to be returned by the scanner. */
	public static final int WITH_ROLLUP_SYM = 865;
	/** Token number, to be returned by the scanner. */
	public static final int WORK_SYM = 866;
	/** Token number, to be returned by the scanner. */
	public static final int WRAPPER_SYM = 867;
	/** Token number, to be returned by the scanner. */
	public static final int WRITE_SYM = 868;
	/** Token number, to be returned by the scanner. */
	public static final int X509_SYM = 869;
	/** Token number, to be returned by the scanner. */
	public static final int XA_SYM = 870;
	/** Token number, to be returned by the scanner. */
	public static final int XML_SYM = 871;
	/** Token number, to be returned by the scanner. */
	public static final int XOR = 872;
	/** Token number, to be returned by the scanner. */
	public static final int YEAR_MONTH_SYM = 873;
	/** Token number, to be returned by the scanner. */
	public static final int YEAR_SYM = 874;
	/** Token number, to be returned by the scanner. */
	public static final int ZEROFILL = 875;

	/**
	 * Communication interface between the scanner and the Bison-generated
	 * parser <tt>YYParser</tt>.
	 */
	public interface Lexer {

		/**
		 * Method to retrieve the semantic value of the last scanned token.
		 * 
		 * @return the semantic value of the last scanned token.
		 */
		Object getLVal(SQLThread thd);

		/**
		 * Entry point for the scanner. Returns the token identifier
		 * corresponding to the next token and prepares to return the semantic
		 * value of the token.
		 * 
		 * @return the token identifier corresponding to the next token.
		 */
		int mysqlLex(SQLThread thd);

		/**
		 * Entry point for error reporting. Emits an error in a user-defined
		 * way.
		 *
		 * 
		 * @param s
		 *            The string for the error message.
		 */
		void mysqlError(String s, SQLThread thd);
	}

	/** The object doing lexical analysis for us. */
	protected MyLexer myLexer;

	/**
	 * Instantiates the Bison-generated parser.
	 * 
	 * @param myLexer
	 *            The scanner that will supply tokens to the parser.
	 * @throws IOException
	 */
	public MyParser(MyLexer myLexer) throws IOException {
		this.myLexer = myLexer;
		// Initial
		yypact_ = MySQLParserUtils.initArrayForInt("yypact");
		yydefact_ = MySQLParserUtils.initArrayForShort("yydefact");
		yypgoto_ = MySQLParserUtils.initArrayForShort("yypgoto");
		yydefgoto_ = MySQLParserUtils.initArrayForShort("yydefgoto");
		yytable_ = MySQLParserUtils.initArrayForShort("yytable");
		yycheck_ = MySQLParserUtils.initArrayForShort("yycheck");
		yystos_ = MySQLParserUtils.initArrayForShort("yystos");
		yytoken_number_ = MySQLParserUtils.initArrayForShort("yytoken_number");
		yyr1_ = MySQLParserUtils.initArrayForShort("yyr1");
		yyr2_ = MySQLParserUtils.initArrayForByte("yyr2");
		yytname_ = MySQLParserUtils.initArrayForString("yytname");
		yyrhs_ = MySQLParserUtils.initArrayForShort("yyrhs");
		yyprhs_ = MySQLParserUtils.initArrayForShort("yyprhs");
		yyrline_ = MySQLParserUtils.initArrayForShort("yyrline");
		yytranslate_table_ = MySQLParserUtils.initArrayForShort("yytranslate_table");
	}

	private java.io.PrintStream yyDebugStream = System.err;

	/**
	 * Return the <tt>PrintStream</tt> on which the debugging output is printed.
	 */
	public final java.io.PrintStream getDebugStream() {
		return yyDebugStream;
	}

	/**
	 * Set the <tt>PrintStream</tt> on which the debug output is printed.
	 * 
	 * @param s
	 *            The stream that is used for debugging output.
	 */
	public final void setDebugStream(java.io.PrintStream s) {
		yyDebugStream = s;
	}

	private int yydebug = 0;

	/**
	 * Answer the verbosity of the debugging output; 0 means that all kinds of
	 * output from the parser are suppressed.
	 */
	public final int getDebugLevel() {
		return yydebug;
	}

	/**
	 * Set the verbosity of the debugging output; 0 means that all kinds of
	 * output from the parser are suppressed.
	 * 
	 * @param level
	 *            The verbosity level for debugging output.
	 */
	public final void setDebugLevel(int level) {
		yydebug = level;
	}

	private final int yylex(SQLThread thd) {
		return myLexer.mysqlLex(thd);
	}

	protected final void yyerror(String s, SQLThread thd) {
		myLexer.mysqlError(s, thd);
	}

	protected final void yycdebug(String s) {
		if (yydebug > 0)
			yyDebugStream.println(s);
	}

	private final class YYStack {
		private int[] stateStack = new int[16];

		private Object[] valueStack = new Object[16];

		public int size = 16;
		public int height = -1;

		public final void push(int state, Object value) {
			height++;
			if (size == height) {
				int[] newStateStack = new int[size * 2];
				System.arraycopy(stateStack, 0, newStateStack, 0, height);
				stateStack = newStateStack;

				Object[] newValueStack = new Object[size * 2];
				System.arraycopy(valueStack, 0, newValueStack, 0, height);
				valueStack = newValueStack;

				size *= 2;
			}

			stateStack[height] = state;

			valueStack[height] = value;
		}

		public final void pop() {
			pop(1);
		}

		public final void pop(int num) {
			// Avoid memory leaks... garbage collection is a white lie!
			if (num > 0) {
				java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);

			}
			height -= num;
		}

		public final int stateAt(int i) {
			return stateStack[height - i];
		}

		public final Object valueAt(int i) {
			return valueStack[height - i];
		}

		// Print the state stack on the debug stream.
		public void print(java.io.PrintStream out) {
			out.print("Stack now");

			for (int i = 0; i <= height; i++) {
				out.print(' ');
				out.print(stateStack[i]);
			}
			out.println();
		}
	}

	/**
	 * Returned by a Bison action in order to stop the parsing process and
	 * return success (<tt>true</tt>).
	 */
	public static final int YYACCEPT = 0;

	/**
	 * Returned by a Bison action in order to stop the parsing process and
	 * return failure (<tt>false</tt>).
	 */
	public static final int YYABORT = 1;

	/**
	 * Returned by a Bison action in order to start error recovery without
	 * printing an error message.
	 */
	public static final int YYERROR = 2;

	// Internal return codes that are not supported for user semantic
	// actions.
	private static final int YYERRLAB = 3;
	private static final int YYNEWSTATE = 4;
	private static final int YYDEFAULT = 5;
	private static final int YYREDUCE = 6;
	private static final int YYERRLAB1 = 7;
	private static final int YYRETURN = 8;

	/**
	 * Return whether error recovery is being done. In this state, the parser
	 * reads token until it reaches a known state, and then restarts normal
	 * operation.
	 */
	public final boolean recovering(SQLThread thd) {
		return thd.yyerrstatus_ == 0;
	}

	/**
	 * Based on Ver. MySQL-5.6.35
	 * 
	 * @param yyn
	 * @param yystack
	 * @param yylen
	 * @param thd
	 * @return
	 */
	private int yyaction(int yyn, YYStack yystack, int yylen, SQLThread thd) {
		Object yyval;

		/*
		 * If YYLEN is nonzero, implement the default value of the action: `$$ =
		 * $1'. Otherwise, use the top of the stack.
		 * 
		 * Otherwise, the following line sets YYVAL to garbage. This behavior is
		 * undocumented and Bison users should not rely upon it.
		 */
		if (yylen > 0)
			yyval = yystack.valueAt(yylen - 1);
		else
			yyval = yystack.valueAt(0);

		yy_reduce_print(yyn, yystack);

		switch (yyn) {
		case 2:
			if (yyn == 2)
			/* Line 350 of lalr1.java */
			/* Line 1970 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// if (!thd->bootstrap &&
				// (!(thd->lex->select_lex.options & OPTION_FOUND_COMMENT)))
				// {
				// my_message(ER_EMPTY_QUERY, ER(ER_EMPTY_QUERY), MYF(0));
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_EMPTY_QUERY;
				// YYLIP->found_semicolon= NULL;
			}
			;
			break;
		
		
		case 3:
		if (yyn == 3)
		/* Line 350 of lalr1.java */
		/* Line 1982 of "sql_yacc.y" */
		{
			if (myLexer.lip.eof(thd)) {
				thd.parsedSqls.add(thd.sql.substring(thd.foundSemicolon, myLexer.lip.getPtr(thd)));
			} else {
				thd.nextState = MyLexStates.MY_LEX_END;
				thd.parsedSqls.add(thd.sql.substring(thd.foundSemicolon, myLexer.lip.getPtr(thd)));
			}
			thd.foundSemicolon = myLexer.lip.getPtr(thd);
		// Lex_input_stream *lip = YYLIP;
		//
		// if ((YYTHD->client_capabilities & CLIENT_MULTI_QUERIES) &&
		// lip->multi_statements &&
		// ! lip->eof())
		// {
		// /*
		// We found a well formed query, and multi queries are allowed:
		// - force the parser to stop after the ';'
		// - mark the start of the next query for the next invocation
		// of the parser.
		// */
		// lip->next_state= MY_LEX_END;
		// lip->found_semicolon= lip->get_ptr();
		// }
		// else
		// {
		// /* Single query, terminated. */
		// lip->found_semicolon= NULL;
		// }
		};
		break;
		//
		//
		// case 5:
		// if (yyn == 5)
		// /* Line 350 of lalr1.java */
		// /* Line 2007 of "sql_yacc.y" */
		// {
		// /* Single query, not terminated. */
		// YYLIP->found_semicolon= NULL;
		// };
		// break;

		case 62:
			if (yyn == 62)
			/* Line 350 of lalr1.java */
			/* Line 2081 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DEALLOCATE_PREPARE;
				// lex->prepared_stmt_name= ((lex_str)(yystack.valueAt
				// (3-(3))));
			}
			;
			break;

		case 65:
			if (yyn == 65)
			/* Line 350 of lalr1.java */
			/* Line 2096 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_PREPARE;
				// lex->prepared_stmt_name= ((lex_str)(yystack.valueAt
				// (4-(2))));
				// /*
				// We don't know know at this time whether there's a password
				// in prepare_src, so we err on the side of caution. Setting
				// the flag will force a rewrite which will obscure all of
				// prepare_src in the "Query" log line. We'll see the actual
				// query (with just the passwords obscured, if any) immediately
				// afterwards in the "Prepare" log lines anyway, and then again
				// in the "Execute" log line if and when prepare_src is
				// executed.
				// */
				// lex->contains_plaintext_password= true;
			}
			;
			break;
		//
		//
		// case 66:
		// if (yyn == 66)
		// /* Line 350 of lalr1.java */
		// /* Line 2116 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->prepared_stmt_code= ((lex_str)(yystack.valueAt (1-(1))));
		// lex->prepared_stmt_code_is_varref= FALSE;
		// };
		// break;
		//
		//
		// case 67:
		// if (yyn == 67)
		// /* Line 350 of lalr1.java */
		// /* Line 2123 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->prepared_stmt_code= ((lex_str)(yystack.valueAt (2-(2))));
		// lex->prepared_stmt_code_is_varref= TRUE;
		// };
		// break;

		case 68:
			if (yyn == 68)
			/* Line 350 of lalr1.java */
			/* Line 2133 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_EXECUTE;
				// lex->prepared_stmt_name= ((lex_str)(yystack.valueAt
				// (2-(2))));
			}
			;
			break;
		//
		//
		// case 69:
		// if (yyn == 69)
		// /* Line 350 of lalr1.java */
		// /* Line 2140 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 74:
		// if (yyn == 74)
		// /* Line 350 of lalr1.java */
		// /* Line 2155 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// LEX_STRING *lexstr=
		// (LEX_STRING*)sql_memdup(&((lex_str)(yystack.valueAt (2-(2)))),
		// sizeof(LEX_STRING));
		// if (!lexstr || lex->prepared_stmt_params.push_back(lexstr))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 75:
		// if (yyn == 75)
		// /* Line 350 of lalr1.java */
		// /* Line 2167 of "sql_yacc.y" */
		// {
		// if (Lex->sphead)
		// {
		// my_error(ER_SP_BADSTATEMENT, MYF(0), "HELP");
		// return YYABORT;
		// }
		// };
		// break;

		case 76:
			if (yyn == 76)
			/* Line 350 of lalr1.java */
			/* Line 2175 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_HELP;
				// lex->help_arg= ((lex_str)(yystack.valueAt (3-(3)))).str;
			}
			;
			break;

		case 77:
			if (yyn == 77)
			/* Line 350 of lalr1.java */
			/* Line 2186 of "sql_yacc.y" */
			{
				// LEX *lex = Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CHANGE_MASTER;
				// /*
				// Clear LEX_MASTER_INFO struct. repl_ignore_server_ids is freed
				// in THD::cleanup_after_query. So it is guaranteed to be
				// uninitialized before here.
				// Its allocation is deferred till the option is parsed below.
				// */
				// lex->mi.set_unspecified();
				// DBUG_ASSERT(Lex->mi.repl_ignore_server_ids.elements == 0);
			}
			;
			break;
		//
		//
		// case 78:
		// if (yyn == 78)
		// /* Line 350 of lalr1.java */
		// /* Line 2199 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 81:
		// if (yyn == 81)
		// /* Line 350 of lalr1.java */
		// /* Line 2209 of "sql_yacc.y" */
		// {
		// Lex->mi.host = ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 82:
		// if (yyn == 82)
		// /* Line 350 of lalr1.java */
		// /* Line 2213 of "sql_yacc.y" */
		// {
		// Lex->mi.bind_addr = ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 83:
		// if (yyn == 83)
		// /* Line 350 of lalr1.java */
		// /* Line 2217 of "sql_yacc.y" */
		// {
		// Lex->mi.user = ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 84:
		// if (yyn == 84)
		// /* Line 350 of lalr1.java */
		// /* Line 2221 of "sql_yacc.y" */
		// {
		// Lex->mi.password = ((lex_str)(yystack.valueAt (3-(3)))).str;
		// Lex->contains_plaintext_password= true;
		// };
		// break;
		//
		//
		// case 85:
		// if (yyn == 85)
		// /* Line 350 of lalr1.java */
		// /* Line 2226 of "sql_yacc.y" */
		// {
		// Lex->mi.port = ((ulong_num)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 86:
		// if (yyn == 86)
		// /* Line 350 of lalr1.java */
		// /* Line 2230 of "sql_yacc.y" */
		// {
		// Lex->mi.connect_retry = ((ulong_num)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 87:
		// if (yyn == 87)
		// /* Line 350 of lalr1.java */
		// /* Line 2234 of "sql_yacc.y" */
		// {
		// Lex->mi.retry_count= ((ulong_num)(yystack.valueAt (3-(3))));
		// Lex->mi.retry_count_opt= LEX_MASTER_INFO::LEX_MI_ENABLE;
		// };
		// break;
		//
		//
		// case 88:
		// if (yyn == 88)
		// /* Line 350 of lalr1.java */
		// /* Line 2239 of "sql_yacc.y" */
		// {
		// if (((ulong_num)(yystack.valueAt (3-(3)))) > MASTER_DELAY_MAX)
		// {
		// Lex_input_stream *lip= YYLIP;
		// const char *start= lip->get_tok_start();
		// const char *msg= YYTHD->strmake(start, lip->get_ptr() - start);
		// my_error(ER_MASTER_DELAY_VALUE_OUT_OF_RANGE, MYF(0),
		// msg, MASTER_DELAY_MAX);
		// }
		// else
		// Lex->mi.sql_delay = ((ulong_num)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 89:
		// if (yyn == 89)
		// /* Line 350 of lalr1.java */
		// /* Line 2252 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl= ((ulong_num)(yystack.valueAt (3-(3)))) ?
		// LEX_MASTER_INFO::LEX_MI_ENABLE : LEX_MASTER_INFO::LEX_MI_DISABLE;
		// };
		// break;
		//
		//
		// case 90:
		// if (yyn == 90)
		// /* Line 350 of lalr1.java */
		// /* Line 2257 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_ca= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 91:
		// if (yyn == 91)
		// /* Line 350 of lalr1.java */
		// /* Line 2261 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_capath= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 92:
		// if (yyn == 92)
		// /* Line 350 of lalr1.java */
		// /* Line 2265 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_cert= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 93:
		// if (yyn == 93)
		// /* Line 350 of lalr1.java */
		// /* Line 2269 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_cipher= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 94:
		// if (yyn == 94)
		// /* Line 350 of lalr1.java */
		// /* Line 2273 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_key= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 95:
		// if (yyn == 95)
		// /* Line 350 of lalr1.java */
		// /* Line 2277 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_verify_server_cert= ((ulong_num)(yystack.valueAt
		// (3-(3)))) ?
		// LEX_MASTER_INFO::LEX_MI_ENABLE : LEX_MASTER_INFO::LEX_MI_DISABLE;
		// };
		// break;
		//
		//
		// case 96:
		// if (yyn == 96)
		// /* Line 350 of lalr1.java */
		// /* Line 2282 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_crl= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 97:
		// if (yyn == 97)
		// /* Line 350 of lalr1.java */
		// /* Line 2286 of "sql_yacc.y" */
		// {
		// Lex->mi.ssl_crlpath= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 98:
		// if (yyn == 98)
		// /* Line 350 of lalr1.java */
		// /* Line 2291 of "sql_yacc.y" */
		// {
		// Lex->mi.heartbeat_period= (float) ((item_num)(yystack.valueAt
		// (3-(3))))->val_real();
		// if (Lex->mi.heartbeat_period > SLAVE_MAX_HEARTBEAT_PERIOD ||
		// Lex->mi.heartbeat_period < 0.0)
		// {
		// const char format[]= "%d";
		// char buf[4*sizeof(SLAVE_MAX_HEARTBEAT_PERIOD) + sizeof(format)];
		// sprintf(buf, format, SLAVE_MAX_HEARTBEAT_PERIOD);
		// my_error(ER_SLAVE_HEARTBEAT_VALUE_OUT_OF_RANGE, MYF(0), buf);
		// return YYABORT;
		// }
		// if (Lex->mi.heartbeat_period > slave_net_timeout)
		// {
		// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
		// ER_SLAVE_HEARTBEAT_VALUE_OUT_OF_RANGE_MAX,
		// ER(ER_SLAVE_HEARTBEAT_VALUE_OUT_OF_RANGE_MAX));
		// }
		// if (Lex->mi.heartbeat_period < 0.001)
		// {
		// if (Lex->mi.heartbeat_period != 0.0)
		// {
		// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
		// ER_SLAVE_HEARTBEAT_VALUE_OUT_OF_RANGE_MIN,
		// ER(ER_SLAVE_HEARTBEAT_VALUE_OUT_OF_RANGE_MIN));
		// Lex->mi.heartbeat_period= 0.0;
		// }
		// Lex->mi.heartbeat_opt= LEX_MASTER_INFO::LEX_MI_DISABLE;
		// }
		// Lex->mi.heartbeat_opt= LEX_MASTER_INFO::LEX_MI_ENABLE;
		// };
		// break;
		//
		//
		// case 99:
		// if (yyn == 99)
		// /* Line 350 of lalr1.java */
		// /* Line 2322 of "sql_yacc.y" */
		// {
		// Lex->mi.repl_ignore_server_ids_opt= LEX_MASTER_INFO::LEX_MI_ENABLE;
		// };
		// break;
		//
		//
		// case 100:
		// if (yyn == 100)
		// /* Line 350 of lalr1.java */
		// /* Line 2327 of "sql_yacc.y" */
		// {
		// Lex->mi.auto_position= ((ulong_num)(yystack.valueAt (3-(3)))) ?
		// LEX_MASTER_INFO::LEX_MI_ENABLE :
		// LEX_MASTER_INFO::LEX_MI_DISABLE;
		// };
		// break;
		//
		//
		// case 105:
		// if (yyn == 105)
		// /* Line 350 of lalr1.java */
		// /* Line 2344 of "sql_yacc.y" */
		// {
		// if (Lex->mi.repl_ignore_server_ids.elements == 0)
		// {
		// my_init_dynamic_array2(&Lex->mi.repl_ignore_server_ids,
		// sizeof(::server_id),
		// Lex->mi.server_ids_buffer,
		// array_elements(Lex->mi.server_ids_buffer),
		// 16);
		// }
		// insert_dynamic(&Lex->mi.repl_ignore_server_ids, (uchar*)
		// &(((ulong_num)(yystack.valueAt (1-(1))))));
		// };
		// break;
		//
		//
		// case 106:
		// if (yyn == 106)
		// /* Line 350 of lalr1.java */
		// /* Line 2358 of "sql_yacc.y" */
		// {
		// Lex->mi.log_file_name = ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 107:
		// if (yyn == 107)
		// /* Line 350 of lalr1.java */
		// /* Line 2362 of "sql_yacc.y" */
		// {
		// Lex->mi.pos = ((ulonglong_number)(yystack.valueAt (3-(3))));
		// /*
		// If the user specified a value < BIN_LOG_HEADER_SIZE, adjust it
		// instead of causing subsequent errors.
		// We need to do it in this file, because only there we know that
		// MASTER_LOG_POS has been explicitely specified. On the contrary
		// in change_master() (sql_repl.cc) we cannot distinguish between 0
		// (MASTER_LOG_POS explicitely specified as 0) and 0 (unspecified),
		// whereas we want to distinguish (specified 0 means "read the binlog
		// from 0" (4 in fact), unspecified means "don't change the position
		// (keep the preceding value)").
		// */
		// Lex->mi.pos = max<ulonglong>(BIN_LOG_HEADER_SIZE, Lex->mi.pos);
		// };
		// break;
		//
		//
		// case 108:
		// if (yyn == 108)
		// /* Line 350 of lalr1.java */
		// /* Line 2378 of "sql_yacc.y" */
		// {
		// Lex->mi.relay_log_name = ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 109:
		// if (yyn == 109)
		// /* Line 350 of lalr1.java */
		// /* Line 2382 of "sql_yacc.y" */
		// {
		// Lex->mi.relay_log_pos = ((ulong_num)(yystack.valueAt (3-(3))));
		// /* Adjust if < BIN_LOG_HEADER_SIZE (same comment as Lex->mi.pos) */
		// Lex->mi.relay_log_pos = max<ulong>(BIN_LOG_HEADER_SIZE,
		// Lex->mi.relay_log_pos);
		// };
		// break;

		case 110:
			if (yyn == 110)
			/* Line 350 of lalr1.java */
			/* Line 2394 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_TABLE;
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(5 - (5)), null, null))
					return YYABORT;
				// /*
				// Instruct open_table() to acquire SHARED lock to check the
				// existance of table. If the table does not exist then
				// it will be upgraded EXCLUSIVE MDL lock. If table exist
				// then open_table() will return with an error or warning.
				// */
				// lex->query_tables->open_strategy=
				// TABLE_LIST::OPEN_FOR_CREATE;
				// lex->alter_info.reset();
				// lex->col_list.empty();
				// lex->change=NullS;
				// memset(&lex->create_info, 0, sizeof(lex->create_info));
				// lex->create_info.options=((num)(yystack.valueAt (5-(2)))) |
				// ((num)(yystack.valueAt (5-(4))));
				// lex->create_info.default_table_charset= NULL;
				// lex->name.str= 0;
				// lex->name.length= 0;
				// lex->create_last_non_select_table= lex->last_table();
			}
			;
			break;
		//
		//
		// case 111:
		// if (yyn == 111)
		// /* Line 350 of lalr1.java */
		// /* Line 2420 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->current_select= &lex->select_lex;
		// if ((lex->create_info.used_fields & HA_CREATE_USED_ENGINE) &&
		// !lex->create_info.db_type)
		// {
		// lex->create_info.db_type=
		// lex->create_info.options & HA_LEX_CREATE_TMP_TABLE ?
		// ha_default_temp_handlerton(thd) : ha_default_handlerton(thd);
		// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
		// ER_WARN_USING_OTHER_HANDLER,
		// ER(ER_WARN_USING_OTHER_HANDLER),
		// ha_resolve_storage_engine_name(lex->create_info.db_type),
		// ((table)(yystack.valueAt (7-(5))))->table.str);
		// }
		// create_table_set_open_action_and_adjust_tables(lex);
		// };
		// break;
		//
		//
		case 112:
		if (yyn == 112)
		/* Line 350 of lalr1.java */
		/* Line 2439 of "sql_yacc.y" */
		{
//		 if (add_create_index_prepare(Lex, ((table)(yystack.valueAt
//		 (7-(7))))))
			if (!addCreateIndexPrepare(thd.lex, (TableIdent)yystack.valueAt(7 - (7))))
				return YYABORT;
		};
		break;
		//
		//
		// case 113:
		// if (yyn == 113)
		// /* Line 350 of lalr1.java */
		// /* Line 2444 of "sql_yacc.y" */
		// {
		// if (add_create_index(Lex, ((key_type)(yystack.valueAt (12-(2)))),
		// ((lex_str)(yystack.valueAt (12-(4))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 114:
		// if (yyn == 114)
		// /* Line 350 of lalr1.java */
		// /* Line 2448 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		case 115:
		if (yyn == 115)
		/* Line 350 of lalr1.java */
		/* Line 2451 of "sql_yacc.y" */
		{
//		 if (add_create_index_prepare(Lex, ((table)(yystack.valueAt
//		 (7-(7))))))
			if (!addCreateIndexPrepare(thd.lex, (TableIdent)yystack.valueAt(7 - (7))))
				return YYABORT;
		};
		break;
		//
		//
		// case 116:
		// if (yyn == 116)
		// /* Line 350 of lalr1.java */
		// /* Line 2456 of "sql_yacc.y" */
		// {
		// if (add_create_index(Lex, ((key_type)(yystack.valueAt (12-(2)))),
		// ((lex_str)(yystack.valueAt (12-(4))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 117:
		// if (yyn == 117)
		// /* Line 350 of lalr1.java */
		// /* Line 2460 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		case 118:
		if (yyn == 118)
		/* Line 350 of lalr1.java */
		/* Line 2463 of "sql_yacc.y" */
		{
		// if (add_create_index_prepare(Lex, ((table)(yystack.valueAt
		// (7-(7))))))
			if (!addCreateIndexPrepare(thd.lex, (TableIdent)yystack.valueAt(7 - (7))))
				return YYABORT;
		};
		break;
		//
		//
		// case 119:
		// if (yyn == 119)
		// /* Line 350 of lalr1.java */
		// /* Line 2468 of "sql_yacc.y" */
		// {
		// if (add_create_index(Lex, ((key_type)(yystack.valueAt (12-(2)))),
		// ((lex_str)(yystack.valueAt (12-(4))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 120:
		// if (yyn == 120)
		// /* Line 350 of lalr1.java */
		// /* Line 2472 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 121:
		// if (yyn == 121)
		// /* Line 350 of lalr1.java */
		// /* Line 2474 of "sql_yacc.y" */
		// {
		// Lex->create_info.default_table_charset= NULL;
		// Lex->create_info.used_fields= 0;
		// };
		// break;

		case 122:
			if (yyn == 122)
			/* Line 350 of lalr1.java */
			/* Line 2479 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_DB;
				// lex->name= ((lex_str)(yystack.valueAt (6-(4))));
				// lex->create_info.options=((num)(yystack.valueAt (6-(3))));
			}
			;
			break;
		//
		//
		// case 123:
		// if (yyn == 123)
		// /* Line 350 of lalr1.java */
		// /* Line 2486 of "sql_yacc.y" */
		// {
		// Lex->create_view_mode= VIEW_CREATE_NEW;
		// Lex->create_view_algorithm= VIEW_ALGORITHM_UNDEFINED;
		// Lex->create_view_suid= TRUE;
		// };
		// break;
		//
		//
		// case 124:
		// if (yyn == 124)
		// /* Line 350 of lalr1.java */
		// /* Line 2492 of "sql_yacc.y" */
		// {};
		// break;

		case 125:
			if (yyn == 125)
			/* Line 350 of lalr1.java */
			/* Line 2494 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_USER;
			}
			;
			break;

		// case 126:
		// if (yyn == 126)
		// /* Line 350 of lalr1.java */
		// /* Line 2498 of "sql_yacc.y" */
		// {
		// Lex->alter_tablespace_info->ts_cmd_type= CREATE_LOGFILE_GROUP;
		// };
		// break;
		//
		//
		// case 127:
		// if (yyn == 127)
		// /* Line 350 of lalr1.java */
		// /* Line 2502 of "sql_yacc.y" */
		// {
		// Lex->alter_tablespace_info->ts_cmd_type= CREATE_TABLESPACE;
		// };
		// break;

		case 128:
			if (yyn == 128)
			/* Line 350 of lalr1.java */
			/* Line 2506 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_SERVER;
			}
			;
			break;
		//
		//
		// case 129:
		// if (yyn == 129)
		// /* Line 350 of lalr1.java */
		// /* Line 2517 of "sql_yacc.y" */
		// {
		// if (((lex_str)(yystack.valueAt (10-(2)))).length == 0)
		// {
		// my_error(ER_WRONG_VALUE, MYF(0), "server name", "");
		// return YYABORT;
		// }
		// Lex->server_options.server_name= ((lex_str)(yystack.valueAt
		// (10-(2)))).str;
		// Lex->server_options.server_name_length= ((lex_str)(yystack.valueAt
		// (10-(2)))).length;
		// Lex->server_options.scheme= ((lex_str)(yystack.valueAt
		// (10-(6)))).str;
		// };
		// break;
		//
		//
		// case 132:
		// if (yyn == 132)
		// /* Line 350 of lalr1.java */
		// /* Line 2536 of "sql_yacc.y" */
		// {
		// Lex->server_options.username= ((lex_str)(yystack.valueAt
		// (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 133:
		// if (yyn == 133)
		// /* Line 350 of lalr1.java */
		// /* Line 2540 of "sql_yacc.y" */
		// {
		// Lex->server_options.host= ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 134:
		// if (yyn == 134)
		// /* Line 350 of lalr1.java */
		// /* Line 2544 of "sql_yacc.y" */
		// {
		// Lex->server_options.db= ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 135:
		// if (yyn == 135)
		// /* Line 350 of lalr1.java */
		// /* Line 2548 of "sql_yacc.y" */
		// {
		// Lex->server_options.owner= ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 136:
		// if (yyn == 136)
		// /* Line 350 of lalr1.java */
		// /* Line 2552 of "sql_yacc.y" */
		// {
		// Lex->server_options.password= ((lex_str)(yystack.valueAt
		// (2-(2)))).str;
		// Lex->contains_plaintext_password= true;
		// };
		// break;
		//
		//
		// case 137:
		// if (yyn == 137)
		// /* Line 350 of lalr1.java */
		// /* Line 2557 of "sql_yacc.y" */
		// {
		// Lex->server_options.socket= ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 138:
		// if (yyn == 138)
		// /* Line 350 of lalr1.java */
		// /* Line 2561 of "sql_yacc.y" */
		// {
		// Lex->server_options.port= ((ulong_num)(yystack.valueAt (2-(2))));
		// };
		// break;
		//
		//
		case 139:
			if (yyn == 139)
			/* Line 350 of lalr1.java */
			/* Line 2568 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex=Lex;
				//
				// lex->stmt_definition_begin= ((simple_string)(yystack.valueAt
				// (4-(1))));
				// lex->create_info.options= ((num)(yystack.valueAt (4-(3))));
				// if (!(lex->event_parse_data=
				// Event_parse_data::new_instance(thd)))
				// return YYABORT;
				// lex->event_parse_data->identifier= ((spname)(yystack.valueAt
				// (4-(4))));
				// lex->event_parse_data->on_completion=
				// Event_parse_data::ON_COMPLETION_DROP;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_EVENT;
				// /* We need that for disallowing subqueries */
			}
			;
			break;

		case 140:
			if (yyn == 140)
			/* Line 350 of lalr1.java */
			/* Line 2588 of "sql_yacc.y" */
			{
				/*
				 * sqlCommand is set here because some rules in ev_sql_stmt can
				 * overwrite it
				 */
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_EVENT;
			}
			;
			break;
		//
		//
		// case 141:
		// if (yyn == 141)
		// /* Line 350 of lalr1.java */
		// /* Line 2599 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->item_expression= ((item)(yystack.valueAt
		// (3-(2))));
		// Lex->event_parse_data->interval= ((interval)(yystack.valueAt
		// (3-(3))));
		// };
		// break;
		//
		//
		// case 143:
		// if (yyn == 143)
		// /* Line 350 of lalr1.java */
		// /* Line 2606 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->item_execute_at= ((item)(yystack.valueAt
		// (2-(2))));
		// };
		// break;
		//
		//
		// case 144:
		// if (yyn == 144)
		// /* Line 350 of lalr1.java */
		// /* Line 2612 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 145:
		// if (yyn == 145)
		// /* Line 350 of lalr1.java */
		// /* Line 2614 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->status= Event_parse_data::ENABLED;
		// Lex->event_parse_data->status_changed= true;
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 146:
		// if (yyn == 146)
		// /* Line 350 of lalr1.java */
		// /* Line 2620 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->status= Event_parse_data::SLAVESIDE_DISABLED;
		// Lex->event_parse_data->status_changed= true;
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 147:
		// if (yyn == 147)
		// /* Line 350 of lalr1.java */
		// /* Line 2626 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->status= Event_parse_data::DISABLED;
		// Lex->event_parse_data->status_changed= true;
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 148:
		// if (yyn == 148)
		// /* Line 350 of lalr1.java */
		// /* Line 2635 of "sql_yacc.y" */
		// {
		// Item *item= new (YYTHD->mem_root) Item_func_now_local(0);
		// if (item == NULL)
		// return YYABORT;
		// Lex->event_parse_data->item_starts= item;
		// };
		// break;
		//
		//
		// case 149:
		// if (yyn == 149)
		// /* Line 350 of lalr1.java */
		// /* Line 2642 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->item_starts= ((item)(yystack.valueAt
		// (2-(2))));
		// };
		// break;
		//
		//
		// case 151:
		// if (yyn == 151)
		// /* Line 350 of lalr1.java */
		// /* Line 2650 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->item_ends= ((item)(yystack.valueAt (2-(2))));
		// };
		// break;
		//
		//
		// case 152:
		// if (yyn == 152)
		// /* Line 350 of lalr1.java */
		// /* Line 2656 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 154:
		// if (yyn == 154)
		// /* Line 350 of lalr1.java */
		// /* Line 2662 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->on_completion=
		// Event_parse_data::ON_COMPLETION_PRESERVE;
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 155:
		// if (yyn == 155)
		// /* Line 350 of lalr1.java */
		// /* Line 2668 of "sql_yacc.y" */
		// {
		// Lex->event_parse_data->on_completion=
		// Event_parse_data::ON_COMPLETION_DROP;
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 156:
		// if (yyn == 156)
		// /* Line 350 of lalr1.java */
		// /* Line 2676 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 157:
		// if (yyn == 157)
		// /* Line 350 of lalr1.java */
		// /* Line 2678 of "sql_yacc.y" */
		// {
		// Lex->comment= Lex->event_parse_data->comment=
		// ((lex_str)(yystack.valueAt (2-(2))));
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 158:
		// if (yyn == 158)
		// /* Line 350 of lalr1.java */
		// /* Line 2685 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// Lex_input_stream *lip= YYLIP;
		//
		// /*
		// This stops the following :
		// - CREATE EVENT ... DO CREATE EVENT ...;
		// - ALTER EVENT ... DO CREATE EVENT ...;
		// - CREATE EVENT ... DO ALTER EVENT DO ....;
		// - CREATE PROCEDURE ... BEGIN CREATE EVENT ... END|
		// This allows:
		// - CREATE EVENT ... DO DROP EVENT yyy;
		// - CREATE EVENT ... DO ALTER EVENT yyy;
		// (the nested ALTER EVENT can have anything but DO clause)
		// - ALTER EVENT ... DO ALTER EVENT yyy;
		// (the nested ALTER EVENT can have anything but DO clause)
		// - ALTER EVENT ... DO DROP EVENT yyy;
		// - CREATE PROCEDURE ... BEGIN ALTER EVENT ... END|
		// (the nested ALTER EVENT can have anything but DO clause)
		// - CREATE PROCEDURE ... BEGIN DROP EVENT ... END|
		// */
		// if (lex->sphead)
		// {
		// my_error(ER_EVENT_RECURSION_FORBIDDEN, MYF(0));
		// return YYABORT;
		// }
		//
		// sp_head *sp= sp_start_parsing(thd,
		// SP_TYPE_PROCEDURE,
		// lex->event_parse_data->identifier);
		//
		// if (!sp)
		// return YYABORT;
		//
		// lex->sphead= sp;
		//
		// memset(&lex->sp_chistics, 0, sizeof(st_sp_chistics));
		// sp->m_chistics= &lex->sp_chistics;
		//
		// sp->set_body_start(thd, lip->get_cpp_ptr());
		// };
		// break;
		//
		//
		// case 159:
		// if (yyn == 159)
		// /* Line 350 of lalr1.java */
		// /* Line 2728 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		//
		// sp_finish_parsing(thd);
		//
		// lex->sp_chistics.suid= SP_IS_SUID; //always the definer!
		// lex->event_parse_data->body_changed= TRUE;
		// };
		// break;
		//
		//
		// case 173:
		// if (yyn == 173)
		// /* Line 350 of lalr1.java */
		// /* Line 2757 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->users_list.empty();
		// lex->columns.empty();
		// lex->grant= lex->grant_tot_col= 0;
		// lex->all_privileges= 0;
		// lex->select_lex.db= 0;
		// lex->ssl_type= SSL_TYPE_NOT_SPECIFIED;
		// lex->ssl_cipher= lex->x509_subject= lex->x509_issuer= 0;
		// memset(&(lex->mqh), 0, sizeof(lex->mqh));
		// };
		// break;
		//
		//
		// case 174:
		// if (yyn == 174)
		// /* Line 350 of lalr1.java */
		// /* Line 2772 of "sql_yacc.y" */
		// {
		// if (!((lex_str)(yystack.valueAt (3-(1)))).str ||
		// (check_and_convert_db_name(&((lex_str)(yystack.valueAt (3-(1)))),
		// FALSE) != IDENT_NAME_OK))
		// return YYABORT;
		// if (sp_check_name(&((lex_str)(yystack.valueAt (3-(3))))))
		// {
		// return YYABORT;
		// }
		// yyval= new sp_name(((lex_str)(yystack.valueAt (3-(1)))),
		// ((lex_str)(yystack.valueAt (3-(3)))), true);
		// if (yyval == NULL)
		// return YYABORT;
		// yyval->init_qname(YYTHD);
		// };
		// break;
		//
		//
		// case 175:
		// if (yyn == 175)
		// /* Line 350 of lalr1.java */
		// /* Line 2786 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// LEX_STRING db;
		// if (sp_check_name(&((lex_str)(yystack.valueAt (1-(1))))))
		// {
		// return YYABORT;
		// }
		// if (lex->copy_db_to(&db.str, &db.length))
		// return YYABORT;
		// yyval= new sp_name(db, ((lex_str)(yystack.valueAt (1-(1)))), false);
		// if (yyval == NULL)
		// return YYABORT;
		// yyval->init_qname(thd);
		// };
		// break;
		//
		//
		// case 176:
		// if (yyn == 176)
		// /* Line 350 of lalr1.java */
		// /* Line 2804 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 177:
		// if (yyn == 177)
		// /* Line 350 of lalr1.java */
		// /* Line 2805 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 178:
		// if (yyn == 178)
		// /* Line 350 of lalr1.java */
		// /* Line 2809 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 179:
		// if (yyn == 179)
		// /* Line 350 of lalr1.java */
		// /* Line 2810 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 180:
		// if (yyn == 180)
		// /* Line 350 of lalr1.java */
		// /* Line 2816 of "sql_yacc.y" */
		// { Lex->sp_chistics.comment= ((lex_str)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 181:
		// if (yyn == 181)
		// /* Line 350 of lalr1.java */
		// /* Line 2818 of "sql_yacc.y" */
		// { /* Just parse it, we only have one language for now. */ };
		// break;
		//
		//
		// case 182:
		// if (yyn == 182)
		// /* Line 350 of lalr1.java */
		// /* Line 2820 of "sql_yacc.y" */
		// { Lex->sp_chistics.daccess= SP_NO_SQL; };
		// break;
		//
		//
		// case 183:
		// if (yyn == 183)
		// /* Line 350 of lalr1.java */
		// /* Line 2822 of "sql_yacc.y" */
		// { Lex->sp_chistics.daccess= SP_CONTAINS_SQL; };
		// break;
		//
		//
		// case 184:
		// if (yyn == 184)
		// /* Line 350 of lalr1.java */
		// /* Line 2824 of "sql_yacc.y" */
		// { Lex->sp_chistics.daccess= SP_READS_SQL_DATA; };
		// break;
		//
		//
		// case 185:
		// if (yyn == 185)
		// /* Line 350 of lalr1.java */
		// /* Line 2826 of "sql_yacc.y" */
		// { Lex->sp_chistics.daccess= SP_MODIFIES_SQL_DATA; };
		// break;
		//
		//
		// case 186:
		// if (yyn == 186)
		// /* Line 350 of lalr1.java */
		// /* Line 2828 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 187:
		// if (yyn == 187)
		// /* Line 350 of lalr1.java */
		// /* Line 2833 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 188:
		// if (yyn == 188)
		// /* Line 350 of lalr1.java */
		// /* Line 2834 of "sql_yacc.y" */
		// { Lex->sp_chistics.detistic= TRUE; };
		// break;
		//
		//
		// case 189:
		// if (yyn == 189)
		// /* Line 350 of lalr1.java */
		// /* Line 2835 of "sql_yacc.y" */
		// { Lex->sp_chistics.detistic= FALSE; };
		// break;
		//
		//
		// case 190:
		// if (yyn == 190)
		// /* Line 350 of lalr1.java */
		// /* Line 2840 of "sql_yacc.y" */
		// {
		// Lex->sp_chistics.suid= SP_IS_SUID;
		// };
		// break;
		//
		//
		// case 191:
		// if (yyn == 191)
		// /* Line 350 of lalr1.java */
		// /* Line 2844 of "sql_yacc.y" */
		// {
		// Lex->sp_chistics.suid= SP_IS_NOT_SUID;
		// };
		// break;

		case 192:
			if (yyn == 192)
			/* Line 350 of lalr1.java */
			/* Line 2851 of "sql_yacc.y" */
			{
				// LEX *lex = Lex;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CALL;
				// lex->spname= ((spname)(yystack.valueAt (2-(2))));
				// lex->value_list.empty();
				// sp_add_used_routine(lex, YYTHD, ((spname)(yystack.valueAt
				// (2-(2)))),
				// SP_TYPE_PROCEDURE);
			}
			;
			break;
		//
		//
		// case 193:
		// if (yyn == 193)
		// /* Line 350 of lalr1.java */
		// /* Line 2859 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 198:
		// if (yyn == 198)
		// /* Line 350 of lalr1.java */
		// /* Line 2875 of "sql_yacc.y" */
		// {
		// Lex->value_list.push_back(((item)(yystack.valueAt (3-(3)))));
		// };
		// break;
		//
		//
		// case 199:
		// if (yyn == 199)
		// /* Line 350 of lalr1.java */
		// /* Line 2879 of "sql_yacc.y" */
		// {
		// Lex->value_list.push_back(((item)(yystack.valueAt (1-(1)))));
		// };
		// break;
		//
		//
		// case 204:
		// if (yyn == 204)
		// /* Line 350 of lalr1.java */
		// /* Line 2897 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		//
		// lex->length= 0;
		// lex->dec= 0;
		// lex->type= 0;
		//
		// lex->default_value= 0;
		// lex->on_update_value= 0;
		//
		// lex->comment= null_lex_str;
		// lex->charset= NULL;
		//
		// lex->interval_list.empty();
		// lex->uint_geom_type= 0;
		// };
		// break;
		//
		//
		// case 205:
		// if (yyn == 205)
		// /* Line 350 of lalr1.java */
		// /* Line 2917 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// if (pctx->find_variable(((lex_str)(yystack.valueAt (3-(1)))), TRUE))
		// {
		// my_error(ER_SP_DUP_PARAM, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(1)))).str);
		// return YYABORT;
		// }
		//
		// sp_variable *spvar= pctx->add_variable(thd,
		// ((lex_str)(yystack.valueAt (3-(1)))),
		// (enum enum_field_types) ((num)(yystack.valueAt (3-(3)))),
		// sp_variable::MODE_IN);
		//
		// if (fill_field_definition(thd, sp,
		// (enum enum_field_types) ((num)(yystack.valueAt (3-(3)))),
		// &spvar->field_def))
		// {
		// return YYABORT;
		// }
		// spvar->field_def.field_name= spvar->name.str;
		// spvar->field_def.pack_flag |= FIELDFLAG_MAYBE_NULL;
		// };
		// break;
		//
		//
		// case 210:
		// if (yyn == 210)
		// /* Line 350 of lalr1.java */
		// /* Line 2958 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// if (pctx->find_variable(((lex_str)(yystack.valueAt (4-(3)))), TRUE))
		// {
		// my_error(ER_SP_DUP_PARAM, MYF(0), ((lex_str)(yystack.valueAt
		// (4-(3)))).str);
		// return YYABORT;
		// }
		// sp_variable *spvar= pctx->add_variable(thd,
		// ((lex_str)(yystack.valueAt (4-(3)))),
		// (enum enum_field_types) ((num)(yystack.valueAt (4-(4)))),
		// (sp_variable::enum_mode) ((num)(yystack.valueAt (4-(1)))));
		//
		// if (fill_field_definition(thd, sp,
		// (enum enum_field_types) ((num)(yystack.valueAt (4-(4)))),
		// &spvar->field_def))
		// {
		// return YYABORT;
		// }
		// spvar->field_def.field_name= spvar->name.str;
		// spvar->field_def.pack_flag |= FIELDFLAG_MAYBE_NULL;
		// };
		// break;
		//
		//
		// case 211:
		// if (yyn == 211)
		// /* Line 350 of lalr1.java */
		// /* Line 2986 of "sql_yacc.y" */
		// { yyval= sp_variable::MODE_IN; };
		// break;
		//
		//
		// case 212:
		// if (yyn == 212)
		// /* Line 350 of lalr1.java */
		// /* Line 2987 of "sql_yacc.y" */
		// { yyval= sp_variable::MODE_IN; };
		// break;
		//
		//
		// case 213:
		// if (yyn == 213)
		// /* Line 350 of lalr1.java */
		// /* Line 2988 of "sql_yacc.y" */
		// { yyval= sp_variable::MODE_OUT; };
		// break;
		//
		//
		// case 214:
		// if (yyn == 214)
		// /* Line 350 of lalr1.java */
		// /* Line 2989 of "sql_yacc.y" */
		// { yyval= sp_variable::MODE_INOUT; };
		// break;
		//
		//
		// case 215:
		// if (yyn == 215)
		// /* Line 350 of lalr1.java */
		// /* Line 2993 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 217:
		// if (yyn == 217)
		// /* Line 350 of lalr1.java */
		// /* Line 2998 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 219:
		// if (yyn == 219)
		// /* Line 350 of lalr1.java */
		// /* Line 3004 of "sql_yacc.y" */
		// {
		// yyval.vars= yyval.conds= yyval.hndlrs= yyval.curs= 0;
		// };
		// break;
		//
		//
		// case 220:
		// if (yyn == 220)
		// /* Line 350 of lalr1.java */
		// /* Line 3008 of "sql_yacc.y" */
		// {
		// /* We check for declarations out of (standard) order this way
		// because letting the grammar rules reflect it caused tricky
		// shift/reduce conflicts with the wrong result. (And we get
		// better error handling this way.) */
		// if ((((spblock)(yystack.valueAt (3-(2)))).vars ||
		// ((spblock)(yystack.valueAt (3-(2)))).conds) &&
		// (((spblock)(yystack.valueAt (3-(1)))).curs ||
		// ((spblock)(yystack.valueAt (3-(1)))).hndlrs))
		// { /* Variable or condition following cursor or handler */
		// my_message(ER_SP_VARCOND_AFTER_CURSHNDLR,
		// ER(ER_SP_VARCOND_AFTER_CURSHNDLR), MYF(0));
		// return YYABORT;
		// }
		// if (((spblock)(yystack.valueAt (3-(2)))).curs &&
		// ((spblock)(yystack.valueAt (3-(1)))).hndlrs)
		// { /* Cursor following handler */
		// my_message(ER_SP_CURSOR_AFTER_HANDLER,
		// ER(ER_SP_CURSOR_AFTER_HANDLER), MYF(0));
		// return YYABORT;
		// }
		// yyval.vars= ((spblock)(yystack.valueAt (3-(1)))).vars +
		// ((spblock)(yystack.valueAt (3-(2)))).vars;
		// yyval.conds= ((spblock)(yystack.valueAt (3-(1)))).conds +
		// ((spblock)(yystack.valueAt (3-(2)))).conds;
		// yyval.hndlrs= ((spblock)(yystack.valueAt (3-(1)))).hndlrs +
		// ((spblock)(yystack.valueAt (3-(2)))).hndlrs;
		// yyval.curs= ((spblock)(yystack.valueAt (3-(1)))).curs +
		// ((spblock)(yystack.valueAt (3-(2)))).curs;
		// };
		// break;
		//
		//
		// case 221:
		// if (yyn == 221)
		// /* Line 350 of lalr1.java */
		// /* Line 3034 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp->reset_lex(thd);
		// pctx->declare_var_boundary(((num)(yystack.valueAt (2-(2)))));
		// };
		// break;
		//
		//
		// case 222:
		// if (yyn == 222)
		// /* Line 350 of lalr1.java */
		// /* Line 3045 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// uint num_vars= pctx->context_var_count();
		// enum enum_field_types var_type= (enum enum_field_types)
		// ((num)(yystack.valueAt (5-(4))));
		// Item *dflt_value_item= ((item)(yystack.valueAt (5-(5))));
		// LEX_STRING dflt_value_query= EMPTY_STR;
		//
		// if (dflt_value_item)
		// {
		// // sp_opt_default only pushes start ptr for DEFAULT clause.
		// const char *expr_start_ptr=
		// sp->m_parser_data.pop_expr_start_ptr();
		// if (lex->is_metadata_used())
		// {
		// dflt_value_query= make_string(thd, expr_start_ptr,
		// YY_TOKEN_END);
		// if (!dflt_value_query.str)
		// return YYABORT;
		// }
		// }
		// else
		// {
		// dflt_value_item= new (thd->mem_root) Item_null();
		//
		// if (dflt_value_item == NULL)
		// return YYABORT;
		// }
		//
		// // We can have several variables in DECLARE statement.
		// // We need to create an sp_instr_set instruction for each variable.
		//
		// for (uint i = num_vars-((num)(yystack.valueAt (5-(2)))) ; i <
		// num_vars ; i++)
		// {
		// uint var_idx= pctx->var_context2runtime(i);
		// sp_variable *spvar= pctx->find_variable(var_idx);
		//
		// if (!spvar)
		// return YYABORT;
		//
		// spvar->type= var_type;
		// spvar->default_value= dflt_value_item;
		//
		// if (fill_field_definition(thd, sp, var_type, &spvar->field_def))
		// return YYABORT;
		//
		// spvar->field_def.field_name= spvar->name.str;
		// spvar->field_def.pack_flag |= FIELDFLAG_MAYBE_NULL;
		//
		// /* The last instruction is responsible for freeing LEX. */
		//
		// sp_instr_set *is=
		// new (thd->mem_root)
		// sp_instr_set(sp->instructions(),
		// lex,
		// var_idx,
		// dflt_value_item,
		// dflt_value_query,
		// (i == num_vars - 1));
		//
		// if (!is || sp->add_instr(thd, is))
		// return YYABORT;
		// }
		//
		// pctx->declare_var_boundary(0);
		// if (sp->restore_lex(thd))
		// return YYABORT;
		// yyval.vars= ((num)(yystack.valueAt (5-(2))));
		// yyval.conds= yyval.hndlrs= yyval.curs= 0;
		// };
		// break;
		//
		//
		// case 223:
		// if (yyn == 223)
		// /* Line 350 of lalr1.java */
		// /* Line 3118 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// if (pctx->find_condition(((lex_str)(yystack.valueAt (5-(2)))), TRUE))
		// {
		// my_error(ER_SP_DUP_COND, MYF(0), ((lex_str)(yystack.valueAt
		// (5-(2)))).str);
		// return YYABORT;
		// }
		// if(pctx->add_condition(thd, ((lex_str)(yystack.valueAt (5-(2)))),
		// ((spcondvalue)(yystack.valueAt (5-(5))))))
		// return YYABORT;
		// yyval.vars= yyval.hndlrs= yyval.curs= 0;
		// yyval.conds= 1;
		// };
		// break;
		//
		//
		// case 224:
		// if (yyn == 224)
		// /* Line 350 of lalr1.java */
		// /* Line 3134 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp_pcontext *parent_pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_pcontext *handler_pctx=
		// parent_pctx->push_context(thd, sp_pcontext::HANDLER_SCOPE);
		//
		// sp_handler *h=
		// parent_pctx->add_handler(thd, (sp_handler::enum_type)
		// ((num)(yystack.valueAt (4-(2)))));
		//
		// lex->set_sp_current_parsing_ctx(handler_pctx);
		//
		// sp_instr_hpush_jump *i=
		// new (thd->mem_root)
		// sp_instr_hpush_jump(sp->instructions(), handler_pctx, h);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		//
		// if (((num)(yystack.valueAt (4-(2)))) == sp_handler::CONTINUE)
		// {
		// // Mark the end of CONTINUE handler scope.
		//
		// if (sp->m_parser_data.add_backpatch_entry(
		// i, handler_pctx->last_label()))
		// {
		// return YYABORT;
		// }
		// }
		//
		// if (sp->m_parser_data.add_backpatch_entry(
		// i, handler_pctx->push_label(thd, EMPTY_STR, 0)))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 225:
		// if (yyn == 225)
		// /* Line 350 of lalr1.java */
		// /* Line 3174 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *hlab= pctx->pop_label(); /* After this hdlr */
		//
		// if (((num)(yystack.valueAt (7-(2)))) == sp_handler::CONTINUE)
		// {
		// sp_instr_hreturn *i=
		// new (thd->mem_root) sp_instr_hreturn(sp->instructions(), pctx);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// }
		// else
		// { /* EXIT or UNDO handler, just jump to the end of the block */
		// sp_instr_hreturn *i=
		// new (thd->mem_root) sp_instr_hreturn(sp->instructions(), pctx);
		//
		// if (i == NULL ||
		// sp->add_instr(thd, i) ||
		// sp->m_parser_data.add_backpatch_entry(i, pctx->last_label()))
		// return YYABORT;
		// }
		//
		// sp->m_parser_data.do_backpatch(hlab, sp->instructions());
		//
		// lex->set_sp_current_parsing_ctx(pctx->pop_context());
		//
		// yyval.vars= yyval.conds= yyval.curs= 0;
		// yyval.hndlrs= 1;
		// };
		// break;
		//
		//
		// case 226:
		// if (yyn == 226)
		// /* Line 350 of lalr1.java */
		// /* Line 3208 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.set_current_stmt_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 227:
		// if (yyn == 227)
		// /* Line 350 of lalr1.java */
		// /* Line 3217 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *cursor_lex= Lex;
		// sp_head *sp= cursor_lex->sphead;
		//
		// DBUG_ASSERT(cursor_thd.lex.sqlCommand == SQLCOM_SELECT);
		//
		// if (cursor_lex->result)
		// {
		// my_message(ER_SP_BAD_CURSOR_SELECT, ER(ER_SP_BAD_CURSOR_SELECT),
		// MYF(0));
		// return YYABORT;
		// }
		//
		// cursor_lex->sp_lex_in_use= true;
		//
		// if (sp->restore_lex(thd))
		// return YYABORT;
		//
		// LEX *lex= Lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// uint offp;
		//
		// if (pctx->find_cursor(((lex_str)(yystack.valueAt (6-(2)))), &offp,
		// TRUE))
		// {
		// my_error(ER_SP_DUP_CURS, MYF(0), ((lex_str)(yystack.valueAt
		// (6-(2)))).str);
		// delete cursor_lex;
		// return YYABORT;
		// }
		//
		// LEX_STRING cursor_query= EMPTY_STR;
		//
		// if (cursor_lex->is_metadata_used())
		// {
		// cursor_query=
		// make_string(thd,
		// sp->m_parser_data.get_current_stmt_start_ptr(),
		// YY_TOKEN_END);
		//
		// if (!cursor_query.str)
		// return YYABORT;
		// }
		//
		// sp_instr_cpush *i=
		// new (thd->mem_root)
		// sp_instr_cpush(sp->instructions(), pctx,
		// cursor_lex, cursor_query,
		// pctx->current_cursor_count());
		//
		// if (i == NULL ||
		// sp->add_instr(thd, i) ||
		// pctx->add_cursor(((lex_str)(yystack.valueAt (6-(2))))))
		// {
		// return YYABORT;
		// }
		//
		// yyval.vars= yyval.conds= yyval.hndlrs= 0;
		// yyval.curs= 1;
		// };
		// break;
		//
		//
		// case 228:
		// if (yyn == 228)
		// /* Line 350 of lalr1.java */
		// /* Line 3280 of "sql_yacc.y" */
		// { yyval= sp_handler::EXIT; };
		// break;
		//
		//
		// case 229:
		// if (yyn == 229)
		// /* Line 350 of lalr1.java */
		// /* Line 3281 of "sql_yacc.y" */
		// { yyval= sp_handler::CONTINUE; };
		// break;
		//
		//
		// case 230:
		// if (yyn == 230)
		// /* Line 350 of lalr1.java */
		// /* Line 3287 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 231:
		// if (yyn == 231)
		// /* Line 350 of lalr1.java */
		// /* Line 3289 of "sql_yacc.y" */
		// { yyval+= 1; };
		// break;
		//
		//
		// case 232:
		// if (yyn == 232)
		// /* Line 350 of lalr1.java */
		// /* Line 3294 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_pcontext *parent_pctx= pctx->parent_context();
		//
		// if
		// (parent_pctx->check_duplicate_handler(((spcondvalue)(yystack.valueAt
		// (1-(1))))))
		// {
		// my_message(ER_SP_DUP_HANDLER, ER(ER_SP_DUP_HANDLER), MYF(0));
		// return YYABORT;
		// }
		// else
		// {
		// sp_instr_hpush_jump *i=
		// (sp_instr_hpush_jump *)sp->last_instruction();
		//
		// i->add_condition(((spcondvalue)(yystack.valueAt (1-(1)))));
		// }
		// };
		// break;
		//
		//
		// case 233:
		// if (yyn == 233)
		// /* Line 350 of lalr1.java */
		// /* Line 3317 of "sql_yacc.y" */
		// { /* mysql errno */
		// if (((ulong_num)(yystack.valueAt (1-(1)))) == 0)
		// {
		// my_error(ER_WRONG_VALUE, MYF(0), "CONDITION", "0");
		// return YYABORT;
		// }
		// yyval= new (YYTHD->mem_root)
		// sp_condition_value(((ulong_num)(yystack.valueAt (1-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 235:
		// if (yyn == 235)
		// /* Line 350 of lalr1.java */
		// /* Line 3332 of "sql_yacc.y" */
		// { /* SQLSTATE */
		//
		// /*
		// An error is triggered:
		// - if the specified string is not a valid SQLSTATE,
		// - or if it represents the completion condition -- it is not
		// allowed to SIGNAL, or declare a handler for the completion
		// condition.
		// */
		// if (!is_sqlstate_valid(&((lex_str)(yystack.valueAt (3-(3))))) ||
		// is_sqlstate_completion(((lex_str)(yystack.valueAt (3-(3)))).str))
		// {
		// my_error(ER_SP_BAD_SQLSTATE, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(3)))).str);
		// return YYABORT;
		// }
		// yyval= new (YYTHD->mem_root)
		// sp_condition_value(((lex_str)(yystack.valueAt (3-(3)))).str);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 236:
		// if (yyn == 236)
		// /* Line 350 of lalr1.java */
		// /* Line 3353 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 237:
		// if (yyn == 237)
		// /* Line 350 of lalr1.java */
		// /* Line 3354 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 238:
		// if (yyn == 238)
		// /* Line 350 of lalr1.java */
		// /* Line 3359 of "sql_yacc.y" */
		// {
		// yyval= ((spcondvalue)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 239:
		// if (yyn == 239)
		// /* Line 350 of lalr1.java */
		// /* Line 3363 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// yyval= pctx->find_condition(((lex_str)(yystack.valueAt (1-(1)))),
		// false);
		//
		// if (yyval == NULL)
		// {
		// my_error(ER_SP_COND_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 240:
		// if (yyn == 240)
		// /* Line 350 of lalr1.java */
		// /* Line 3376 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// sp_condition_value(sp_condition_value::WARNING);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 241:
		// if (yyn == 241)
		// /* Line 350 of lalr1.java */
		// /* Line 3382 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// sp_condition_value(sp_condition_value::NOT_FOUND);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 242:
		// if (yyn == 242)
		// /* Line 350 of lalr1.java */
		// /* Line 3388 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// sp_condition_value(sp_condition_value::EXCEPTION);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;

		case 243:
			if (yyn == 243)
			/* Line 350 of lalr1.java */
			/* Line 3397 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// Yacc_state *state= & thd->m_parser_state->m_yacc;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SIGNAL;
				// lex->m_sql_cmd=
				// new (thd->mem_root)
				// Sql_cmd_signal(((spcondvalue)(yystack.valueAt
				// (3-(2)))), state->m_set_signal_info);
				// if (lex->m_sql_cmd == NULL)
				// return YYABORT;
			}
			;
			break;
		//
		//
		// case 244:
		// if (yyn == 244)
		// /* Line 350 of lalr1.java */
		// /* Line 3412 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// if (!pctx)
		// {
		// /* SIGNAL foo cannot be used outside of stored programs */
		// my_error(ER_SP_COND_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		//
		// sp_condition_value *cond=
		// pctx->find_condition(((lex_str)(yystack.valueAt (1-(1)))), false);
		//
		// if (!cond)
		// {
		// my_error(ER_SP_COND_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// if (cond->type != sp_condition_value::SQLSTATE)
		// {
		// my_error(ER_SIGNAL_BAD_CONDITION_TYPE, MYF(0));
		// return YYABORT;
		// }
		// yyval= cond;
		// };
		// break;
		//
		//
		// case 245:
		// if (yyn == 245)
		// /* Line 350 of lalr1.java */
		// /* Line 3438 of "sql_yacc.y" */
		// { yyval= ((spcondvalue)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 246:
		// if (yyn == 246)
		// /* Line 350 of lalr1.java */
		// /* Line 3443 of "sql_yacc.y" */
		// { yyval= NULL; };
		// break;
		//
		//
		// case 247:
		// if (yyn == 247)
		// /* Line 350 of lalr1.java */
		// /* Line 3445 of "sql_yacc.y" */
		// { yyval= ((spcondvalue)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 248:
		// if (yyn == 248)
		// /* Line 350 of lalr1.java */
		// /* Line 3450 of "sql_yacc.y" */
		// {
		// YYTHD->m_parser_state->m_yacc.m_set_signal_info.clear();
		// };
		// break;
		//
		//
		// case 250:
		// if (yyn == 250)
		// /* Line 350 of lalr1.java */
		// /* Line 3458 of "sql_yacc.y" */
		// {
		// Set_signal_information *info;
		// info= & YYTHD->m_parser_state->m_yacc.m_set_signal_info;
		// int index= (int) ((diag_condition_item_name)(yystack.valueAt
		// (3-(1))));
		// info->clear();
		// info->m_item[index]= ((item)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 251:
		// if (yyn == 251)
		// /* Line 350 of lalr1.java */
		// /* Line 3467 of "sql_yacc.y" */
		// {
		// Set_signal_information *info;
		// info= & YYTHD->m_parser_state->m_yacc.m_set_signal_info;
		// int index= (int) ((diag_condition_item_name)(yystack.valueAt
		// (5-(3))));
		// if (info->m_item[index] != NULL)
		// {
		// my_error(ER_DUP_SIGNAL_SET, MYF(0),
		// Diag_condition_item_names[index].str);
		// return YYABORT;
		// }
		// info->m_item[index]= ((item)(yystack.valueAt (5-(5))));
		// };
		// break;
		//
		//
		// case 252:
		// if (yyn == 252)
		// /* Line 350 of lalr1.java */
		// /* Line 3486 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		case 253:
			if (yyn == 253)
			/* Line 350 of lalr1.java */
			/* Line 3488 of "sql_yacc.y" */
			{
				// if (((item)(yystack.valueAt (1-(1))))->type() ==
				// Item::FUNC_ITEM)
				// {
				// Item_func *item= (Item_func*) ((item)(yystack.valueAt
				// (1-(1))));
				// if (item->functype() == Item_func::SUSERVAR_FUNC)
				// {
				// /*
				// Don't allow the following syntax:
				// SIGNAL/RESIGNAL ...
				// SET <signal condition item name> = @foo := expr
				// */
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// }
				// yyval= ((item)(yystack.valueAt (1-(1))));
			}
			;
			break;
		//
		//
		// case 254:
		// if (yyn == 254)
		// /* Line 350 of lalr1.java */
		// /* Line 3506 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 255:
		// if (yyn == 255)
		// /* Line 350 of lalr1.java */
		// /* Line 3512 of "sql_yacc.y" */
		// { yyval= DIAG_CLASS_ORIGIN; };
		// break;
		//
		//
		// case 256:
		// if (yyn == 256)
		// /* Line 350 of lalr1.java */
		// /* Line 3514 of "sql_yacc.y" */
		// { yyval= DIAG_SUBCLASS_ORIGIN; };
		// break;
		//
		//
		// case 257:
		// if (yyn == 257)
		// /* Line 350 of lalr1.java */
		// /* Line 3516 of "sql_yacc.y" */
		// { yyval= DIAG_CONSTRAINT_CATALOG; };
		// break;
		//
		//
		// case 258:
		// if (yyn == 258)
		// /* Line 350 of lalr1.java */
		// /* Line 3518 of "sql_yacc.y" */
		// { yyval= DIAG_CONSTRAINT_SCHEMA; };
		// break;
		//
		//
		// case 259:
		// if (yyn == 259)
		// /* Line 350 of lalr1.java */
		// /* Line 3520 of "sql_yacc.y" */
		// { yyval= DIAG_CONSTRAINT_NAME; };
		// break;
		//
		//
		// case 260:
		// if (yyn == 260)
		// /* Line 350 of lalr1.java */
		// /* Line 3522 of "sql_yacc.y" */
		// { yyval= DIAG_CATALOG_NAME; };
		// break;
		//
		//
		// case 261:
		// if (yyn == 261)
		// /* Line 350 of lalr1.java */
		// /* Line 3524 of "sql_yacc.y" */
		// { yyval= DIAG_SCHEMA_NAME; };
		// break;
		//
		//
		// case 262:
		// if (yyn == 262)
		// /* Line 350 of lalr1.java */
		// /* Line 3526 of "sql_yacc.y" */
		// { yyval= DIAG_TABLE_NAME; };
		// break;
		//
		//
		// case 263:
		// if (yyn == 263)
		// /* Line 350 of lalr1.java */
		// /* Line 3528 of "sql_yacc.y" */
		// { yyval= DIAG_COLUMN_NAME; };
		// break;
		//
		//
		// case 264:
		// if (yyn == 264)
		// /* Line 350 of lalr1.java */
		// /* Line 3530 of "sql_yacc.y" */
		// { yyval= DIAG_CURSOR_NAME; };
		// break;
		//
		//
		// case 265:
		// if (yyn == 265)
		// /* Line 350 of lalr1.java */
		// /* Line 3532 of "sql_yacc.y" */
		// { yyval= DIAG_MESSAGE_TEXT; };
		// break;
		//
		//
		// case 266:
		// if (yyn == 266)
		// /* Line 350 of lalr1.java */
		// /* Line 3534 of "sql_yacc.y" */
		// { yyval= DIAG_MYSQL_ERRNO; };
		// break;

		case 267:
			if (yyn == 267)
			/* Line 350 of lalr1.java */
			/* Line 3539 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// Yacc_state *state= & thd->m_parser_state->m_yacc;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_RESIGNAL;
				// lex->m_sql_cmd=
				// new (thd->mem_root)
				// Sql_cmd_resignal(((spcondvalue)(yystack.valueAt
				// (3-(2)))),
				// state->m_set_signal_info);
				// if (lex->m_sql_cmd == NULL)
				// return YYABORT;
			}
			;
			break;

		case 268:
			if (yyn == 268)
			/* Line 350 of lalr1.java */
			/* Line 3555 of "sql_yacc.y" */
			{
				// Diagnostics_information *info= ((diag_info)(yystack.valueAt
				// (4-(4))));
				//
				// info->set_which_da(((diag_area)(yystack.valueAt (4-(2)))));
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_GET_DIAGNOSTICS;
				// Lex->m_sql_cmd= new (YYTHD->mem_root)
				// Sql_cmd_get_diagnostics(info);
				//
				// if (Lex->m_sql_cmd == NULL)
				// return YYABORT;
			}
			;
			break;
		//
		//
		// case 269:
		// if (yyn == 269)
		// /* Line 350 of lalr1.java */
		// /* Line 3570 of "sql_yacc.y" */
		// { yyval= Diagnostics_information::CURRENT_AREA; };
		// break;
		//
		//
		// case 270:
		// if (yyn == 270)
		// /* Line 350 of lalr1.java */
		// /* Line 3572 of "sql_yacc.y" */
		// { yyval= Diagnostics_information::CURRENT_AREA; };
		// break;
		//
		//
		// case 271:
		// if (yyn == 271)
		// /* Line 350 of lalr1.java */
		// /* Line 3577 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Statement_information(((stmt_info_list)(yystack.valueAt (1-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 272:
		// if (yyn == 272)
		// /* Line 350 of lalr1.java */
		// /* Line 3583 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Condition_information(((item)(yystack.valueAt (3-(2)))),
		// ((cond_info_list)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 273:
		// if (yyn == 273)
		// /* Line 350 of lalr1.java */
		// /* Line 3592 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) List<Statement_information_item>;
		// if (yyval == NULL ||
		// yyval->push_back(((stmt_info_item)(yystack.valueAt (1-(1))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 274:
		// if (yyn == 274)
		// /* Line 350 of lalr1.java */
		// /* Line 3598 of "sql_yacc.y" */
		// {
		// if (((stmt_info_list)(yystack.valueAt
		// (3-(1))))->push_back(((stmt_info_item)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// yyval= ((stmt_info_list)(yystack.valueAt (3-(1))));
		// };
		// break;
		//
		//
		// case 275:
		// if (yyn == 275)
		// /* Line 350 of lalr1.java */
		// /* Line 3607 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Statement_information_item(((stmt_info_item_name)(yystack.valueAt
		// (3-(3)))), ((item)(yystack.valueAt (3-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 276:
		// if (yyn == 276)
		// /* Line 350 of lalr1.java */
		// /* Line 3615 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// Lex_input_stream *lip= YYLIP;
		// sp_head *sp= lex->sphead;
		//
		// /*
		// NOTE: lex->sphead is NULL if we're parsing something like
		// 'GET DIAGNOSTICS v' outside a stored program. We should throw
		// ER_SP_UNDECLARED_VAR in such cases.
		// */
		//
		// if (!sp)
		// {
		// my_error(ER_SP_UNDECLARED_VAR, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		//
		// yyval=
		// create_item_for_sp_var(
		// thd, ((lex_str)(yystack.valueAt (1-(1)))), NULL,
		// sp->m_parser_data.get_current_stmt_start_ptr(),
		// lip->get_tok_start(),
		// lip->get_ptr());
		//
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 277:
		// if (yyn == 277)
		// /* Line 350 of lalr1.java */
		// /* Line 3644 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_get_user_var(((lex_str)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 278:
		// if (yyn == 278)
		// /* Line 350 of lalr1.java */
		// /* Line 3653 of "sql_yacc.y" */
		// { yyval= Statement_information_item::NUMBER; };
		// break;
		//
		//
		// case 279:
		// if (yyn == 279)
		// /* Line 350 of lalr1.java */
		// /* Line 3655 of "sql_yacc.y" */
		// { yyval= Statement_information_item::ROW_COUNT; };
		// break;
		//
		//
		// case 280:
		// if (yyn == 280)
		// /* Line 350 of lalr1.java */
		// /* Line 3664 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 281:
		// if (yyn == 281)
		// /* Line 350 of lalr1.java */
		// /* Line 3669 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) List<Condition_information_item>;
		// if (yyval == NULL ||
		// yyval->push_back(((cond_info_item)(yystack.valueAt (1-(1))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 282:
		// if (yyn == 282)
		// /* Line 350 of lalr1.java */
		// /* Line 3675 of "sql_yacc.y" */
		// {
		// if (((cond_info_list)(yystack.valueAt
		// (3-(1))))->push_back(((cond_info_item)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// yyval= ((cond_info_list)(yystack.valueAt (3-(1))));
		// };
		// break;
		//
		//
		// case 283:
		// if (yyn == 283)
		// /* Line 350 of lalr1.java */
		// /* Line 3684 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Condition_information_item(((cond_info_item_name)(yystack.valueAt
		// (3-(3)))), ((item)(yystack.valueAt (3-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 284:
		// if (yyn == 284)
		// /* Line 350 of lalr1.java */
		// /* Line 3692 of "sql_yacc.y" */
		// { yyval= Condition_information_item::CLASS_ORIGIN; };
		// break;
		//
		//
		// case 285:
		// if (yyn == 285)
		// /* Line 350 of lalr1.java */
		// /* Line 3694 of "sql_yacc.y" */
		// { yyval= Condition_information_item::SUBCLASS_ORIGIN; };
		// break;
		//
		//
		// case 286:
		// if (yyn == 286)
		// /* Line 350 of lalr1.java */
		// /* Line 3696 of "sql_yacc.y" */
		// { yyval= Condition_information_item::CONSTRAINT_CATALOG; };
		// break;
		//
		//
		// case 287:
		// if (yyn == 287)
		// /* Line 350 of lalr1.java */
		// /* Line 3698 of "sql_yacc.y" */
		// { yyval= Condition_information_item::CONSTRAINT_SCHEMA; };
		// break;
		//
		//
		// case 288:
		// if (yyn == 288)
		// /* Line 350 of lalr1.java */
		// /* Line 3700 of "sql_yacc.y" */
		// { yyval= Condition_information_item::CONSTRAINT_NAME; };
		// break;
		//
		//
		// case 289:
		// if (yyn == 289)
		// /* Line 350 of lalr1.java */
		// /* Line 3702 of "sql_yacc.y" */
		// { yyval= Condition_information_item::CATALOG_NAME; };
		// break;
		//
		//
		// case 290:
		// if (yyn == 290)
		// /* Line 350 of lalr1.java */
		// /* Line 3704 of "sql_yacc.y" */
		// { yyval= Condition_information_item::SCHEMA_NAME; };
		// break;
		//
		//
		// case 291:
		// if (yyn == 291)
		// /* Line 350 of lalr1.java */
		// /* Line 3706 of "sql_yacc.y" */
		// { yyval= Condition_information_item::TABLE_NAME; };
		// break;
		//
		//
		// case 292:
		// if (yyn == 292)
		// /* Line 350 of lalr1.java */
		// /* Line 3708 of "sql_yacc.y" */
		// { yyval= Condition_information_item::COLUMN_NAME; };
		// break;
		//
		//
		// case 293:
		// if (yyn == 293)
		// /* Line 350 of lalr1.java */
		// /* Line 3710 of "sql_yacc.y" */
		// { yyval= Condition_information_item::CURSOR_NAME; };
		// break;
		//
		//
		// case 294:
		// if (yyn == 294)
		// /* Line 350 of lalr1.java */
		// /* Line 3712 of "sql_yacc.y" */
		// { yyval= Condition_information_item::MESSAGE_TEXT; };
		// break;
		//
		//
		// case 295:
		// if (yyn == 295)
		// /* Line 350 of lalr1.java */
		// /* Line 3714 of "sql_yacc.y" */
		// { yyval= Condition_information_item::MYSQL_ERRNO; };
		// break;
		//
		//
		// case 296:
		// if (yyn == 296)
		// /* Line 350 of lalr1.java */
		// /* Line 3716 of "sql_yacc.y" */
		// { yyval= Condition_information_item::RETURNED_SQLSTATE; };
		// break;
		//
		//
		// case 297:
		// if (yyn == 297)
		// /* Line 350 of lalr1.java */
		// /* Line 3721 of "sql_yacc.y" */
		// {
		// /* NOTE: field definition is filled in sp_decl section. */
		//
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// if (pctx->find_variable(((lex_str)(yystack.valueAt (1-(1)))), TRUE))
		// {
		// my_error(ER_SP_DUP_VAR, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		//
		// pctx->add_variable(thd,
		// ((lex_str)(yystack.valueAt (1-(1)))),
		// MYSQL_TYPE_DECIMAL,
		// sp_variable::MODE_IN);
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 298:
		// if (yyn == 298)
		// /* Line 350 of lalr1.java */
		// /* Line 3741 of "sql_yacc.y" */
		// {
		// /* NOTE: field definition is filled in sp_decl section. */
		//
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// if (pctx->find_variable(((lex_str)(yystack.valueAt (3-(3)))), TRUE))
		// {
		// my_error(ER_SP_DUP_VAR, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(3)))).str);
		// return YYABORT;
		// }
		//
		// pctx->add_variable(thd,
		// ((lex_str)(yystack.valueAt (3-(3)))),
		// MYSQL_TYPE_DECIMAL,
		// sp_variable::MODE_IN);
		// yyval= ((num)(yystack.valueAt (3-(1)))) + 1;
		// };
		// break;
		//
		//
		// case 299:
		// if (yyn == 299)
		// /* Line 350 of lalr1.java */
		// /* Line 3764 of "sql_yacc.y" */
		// { yyval = NULL; };
		// break;
		//
		//
		// case 300:
		// if (yyn == 300)
		// /* Line 350 of lalr1.java */
		// /* Line 3766 of "sql_yacc.y" */
		// { Lex->sphead->m_parser_data.push_expr_start_ptr(YY_TOKEN_END); };
		// break;
		//
		//
		// case 301:
		// if (yyn == 301)
		// /* Line 350 of lalr1.java */
		// /* Line 3768 of "sql_yacc.y" */
		// { yyval = ((item)(yystack.valueAt (3-(3)))); };
		// break;
		//
		//
		// case 315:
		// if (yyn == 315)
		// /* Line 350 of lalr1.java */
		// /* Line 3789 of "sql_yacc.y" */
		// { Lex->sphead->m_parser_data.new_cont_backpatch(); };
		// break;
		//
		//
		// case 316:
		// if (yyn == 316)
		// /* Line 350 of lalr1.java */
		// /* Line 3791 of "sql_yacc.y" */
		// {
		// sp_head *sp= Lex->sphead;
		//
		// sp->m_parser_data.do_cont_backpatch(sp->instructions());
		// };
		// break;
		//
		//
		// case 317:
		// if (yyn == 317)
		// /* Line 350 of lalr1.java */
		// /* Line 3799 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// Lex_input_stream *lip= YYLIP;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.set_current_stmt_start_ptr(lip->get_tok_start());
		// };
		// break;
		//
		//
		// case 318:
		// if (yyn == 318)
		// /* Line 350 of lalr1.java */
		// /* Line 3809 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->m_flags|= sp_get_flags_for_command(lex);
		// if (thd.lex.sqlCommand == SQLCOM_CHANGE_DB)
		// { /* "USE db" doesn't work in a procedure */
		// my_error(ER_SP_BADSTATEMENT, MYF(0), "USE");
		// return YYABORT;
		// }
		// /*
		// Don't add an instruction for SET statements, since all
		// instructions for them were already added during processing
		// of "set" rule.
		// */
		// DBUG_ASSERT(thd.lex.sqlCommand != SQLCOM_SET_OPTION ||
		// lex->var_list.is_empty());
		// if (thd.lex.sqlCommand != SQLCOM_SET_OPTION)
		// {
		// /* Extract the query statement from the tokenizer. */
		//
		// LEX_STRING query=
		// make_string(thd,
		// sp->m_parser_data.get_current_stmt_start_ptr(),
		// YY_TOKEN_END);
		//
		// if (!query.str)
		// return YYABORT;
		//
		// /* Add instruction. */
		//
		// sp_instr_stmt *i=
		// new (thd->mem_root)
		// sp_instr_stmt(sp->instructions(), lex, query);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// }
		//
		// if (sp->restore_lex(thd))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 319:
		// if (yyn == 319)
		// /* Line 350 of lalr1.java */
		// /* Line 3856 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		//
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 320:
		// if (yyn == 320)
		// /* Line 350 of lalr1.java */
		// /* Line 3866 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// /* Extract expression string. */
		//
		// LEX_STRING expr_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!expr_query.str)
		// return YYABORT;
		// }
		//
		// /* Check that this is a stored function. */
		//
		// if (sp->m_type != SP_TYPE_FUNCTION)
		// {
		// my_message(ER_SP_BADRETURN, ER(ER_SP_BADRETURN), MYF(0));
		// return YYABORT;
		// }
		//
		// /* Indicate that we've reached RETURN statement. */
		//
		// sp->m_flags|= sp_head::HAS_RETURN;
		//
		// /* Add instruction. */
		//
		// sp_instr_freturn *i=
		// new (thd->mem_root)
		// sp_instr_freturn(sp->instructions(), lex, ((item)(yystack.valueAt
		// (3-(3)))), expr_query,
		// sp->m_return_field_def.sql_type);
		//
		// if (i == NULL ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 321:
		// if (yyn == 321)
		// /* Line 350 of lalr1.java */
		// /* Line 3912 of "sql_yacc.y" */
		// { /* Unlabeled controls get a secret label. */
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// pctx->push_label(thd,
		// EMPTY_STR,
		// sp->instructions());
		// };
		// break;
		//
		//
		// case 322:
		// if (yyn == 322)
		// /* Line 350 of lalr1.java */
		// /* Line 3923 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp->m_parser_data.do_backpatch(pctx->pop_label(),
		// sp->instructions());
		// };
		// break;
		//
		//
		// case 323:
		// if (yyn == 323)
		// /* Line 350 of lalr1.java */
		// /* Line 3935 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp = lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *lab= pctx->find_label(((lex_str)(yystack.valueAt
		// (2-(2)))));
		//
		// if (! lab)
		// {
		// my_error(ER_SP_LILABEL_MISMATCH, MYF(0), "LEAVE",
		// ((lex_str)(yystack.valueAt (2-(2)))).str);
		// return YYABORT;
		// }
		//
		// uint ip= sp->instructions();
		//
		// /*
		// When jumping to a BEGIN-END block end, the target jump
		// points to the block hpop/cpop cleanup instructions,
		// so we should exclude the block context here.
		// When jumping to something else (i.e., sp_label::ITERATION),
		// there are no hpop/cpop at the jump destination,
		// so we should include the block context here for cleanup.
		// */
		// bool exclusive= (lab->type == sp_label::BEGIN);
		//
		// uint n= pctx->diff_handlers(lab->ctx, exclusive);
		//
		// if (n)
		// {
		// sp_instr_hpop *hpop=
		// new (thd->mem_root) sp_instr_hpop(ip++, pctx);
		//
		// if (!hpop || sp->add_instr(thd, hpop))
		// return YYABORT;
		// }
		//
		// n= pctx->diff_cursors(lab->ctx, exclusive);
		//
		// if (n)
		// {
		// sp_instr_cpop *cpop=
		// new (thd->mem_root) sp_instr_cpop(ip++, pctx, n);
		//
		// if (!cpop || sp->add_instr(thd, cpop))
		// return YYABORT;
		// }
		//
		// sp_instr_jump *i= new (thd->mem_root) sp_instr_jump(ip, pctx);
		//
		// if (!i ||
		// /* Jumping forward */
		// sp->m_parser_data.add_backpatch_entry(i, lab) ||
		// sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 324:
		// if (yyn == 324)
		// /* Line 350 of lalr1.java */
		// /* Line 3994 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *lab= pctx->find_label(((lex_str)(yystack.valueAt
		// (2-(2)))));
		//
		// if (! lab || lab->type != sp_label::ITERATION)
		// {
		// my_error(ER_SP_LILABEL_MISMATCH, MYF(0), "ITERATE",
		// ((lex_str)(yystack.valueAt (2-(2)))).str);
		// return YYABORT;
		// }
		//
		// uint ip= sp->instructions();
		//
		// /* Inclusive the dest. */
		// uint n= pctx->diff_handlers(lab->ctx, FALSE);
		//
		// if (n)
		// {
		// sp_instr_hpop *hpop=
		// new (thd->mem_root) sp_instr_hpop(ip++, pctx);
		//
		// if (!hpop || sp->add_instr(thd, hpop))
		// return YYABORT;
		// }
		//
		// /* Inclusive the dest. */
		// n= pctx->diff_cursors(lab->ctx, FALSE);
		//
		// if (n)
		// {
		// sp_instr_cpop *cpop=
		// new (thd->mem_root) sp_instr_cpop(ip++, pctx, n);
		//
		// if (!cpop || sp->add_instr(thd, cpop))
		// return YYABORT;
		// }
		//
		// /* Jump back */
		// sp_instr_jump *i=
		// new (thd->mem_root) sp_instr_jump(ip, pctx, lab->ip);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 325:
		// if (yyn == 325)
		// /* Line 350 of lalr1.java */
		// /* Line 4044 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// uint offset;
		//
		// if (! pctx->find_cursor(((lex_str)(yystack.valueAt (2-(2)))),
		// &offset, false))
		// {
		// my_error(ER_SP_CURSOR_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (2-(2)))).str);
		// return YYABORT;
		// }
		//
		// sp_instr_copen *i=
		// new (thd->mem_root)
		// sp_instr_copen(sp->instructions(), pctx, offset);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 326:
		// if (yyn == 326)
		// /* Line 350 of lalr1.java */
		// /* Line 4068 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// uint offset;
		//
		// if (! pctx->find_cursor(((lex_str)(yystack.valueAt (4-(3)))),
		// &offset, false))
		// {
		// my_error(ER_SP_CURSOR_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (4-(3)))).str);
		// return YYABORT;
		// }
		//
		// sp_instr_cfetch *i=
		// new (thd->mem_root)
		// sp_instr_cfetch(sp->instructions(), pctx, offset);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 327:
		// if (yyn == 327)
		// /* Line 350 of lalr1.java */
		// /* Line 4089 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 328:
		// if (yyn == 328)
		// /* Line 350 of lalr1.java */
		// /* Line 4094 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// uint offset;
		//
		// if (! pctx->find_cursor(((lex_str)(yystack.valueAt (2-(2)))),
		// &offset, false))
		// {
		// my_error(ER_SP_CURSOR_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (2-(2)))).str);
		// return YYABORT;
		// }
		//
		// sp_instr_cclose *i=
		// new (thd->mem_root)
		// sp_instr_cclose(sp->instructions(), pctx, offset);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 332:
		// if (yyn == 332)
		// /* Line 350 of lalr1.java */
		// /* Line 4124 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_variable *spv;
		//
		// if (!pctx || !(spv= pctx->find_variable(((lex_str)(yystack.valueAt
		// (1-(1)))), false)))
		// {
		// my_error(ER_SP_UNDECLARED_VAR, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		//
		// /* An SP local variable */
		// sp_instr_cfetch *i= (sp_instr_cfetch *)sp->last_instruction();
		//
		// i->add_to_varlist(spv);
		// };
		// break;
		//
		//
		// case 333:
		// if (yyn == 333)
		// /* Line 350 of lalr1.java */
		// /* Line 4142 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_variable *spv;
		//
		// if (!pctx || !(spv= pctx->find_variable(((lex_str)(yystack.valueAt
		// (3-(3)))), false)))
		// {
		// my_error(ER_SP_UNDECLARED_VAR, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(3)))).str);
		// return YYABORT;
		// }
		//
		// /* An SP local variable */
		// sp_instr_cfetch *i= (sp_instr_cfetch *)sp->last_instruction();
		//
		// i->add_to_varlist(spv);
		// };
		// break;
		//
		//
		// case 334:
		// if (yyn == 334)
		// /* Line 350 of lalr1.java */
		// /* Line 4162 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 335:
		// if (yyn == 335)
		// /* Line 350 of lalr1.java */
		// /* Line 4171 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// /* Extract expression string. */
		//
		// LEX_STRING expr_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!expr_query.str)
		// return YYABORT;
		// }
		//
		// sp_instr_jump_if_not *i =
		// new (thd->mem_root)
		// sp_instr_jump_if_not(sp->instructions(), lex,
		// ((item)(yystack.valueAt (2-(2)))), expr_query);
		//
		// /* Add jump instruction. */
		//
		// if (i == NULL ||
		// sp->m_parser_data.add_backpatch_entry(
		// i, pctx->push_label(thd, EMPTY_STR, 0)) ||
		// sp->m_parser_data.add_cont_backpatch_entry(i) ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 336:
		// if (yyn == 336)
		// /* Line 350 of lalr1.java */
		// /* Line 4207 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_instr_jump *i =
		// new (thd->mem_root) sp_instr_jump(sp->instructions(), pctx);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		//
		// sp->m_parser_data.do_backpatch(pctx->pop_label(),
		// sp->instructions());
		//
		// sp->m_parser_data.add_backpatch_entry(
		// i, pctx->push_label(thd, EMPTY_STR, 0));
		// };
		// break;
		//
		//
		// case 337:
		// if (yyn == 337)
		// /* Line 350 of lalr1.java */
		// /* Line 4226 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp->m_parser_data.do_backpatch(pctx->pop_label(),
		// sp->instructions());
		// };
		// break;
		//
		//
		// case 343:
		// if (yyn == 343)
		// /* Line 350 of lalr1.java */
		// /* Line 4249 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// case_stmt_action_case(thd);
		//
		// sp->reset_lex(thd); /* For CASE-expr $3 */
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 344:
		// if (yyn == 344)
		// /* Line 350 of lalr1.java */
		// /* Line 4260 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		//
		// /* Extract CASE-expression string. */
		//
		// LEX_STRING case_expr_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// case_expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!case_expr_query.str)
		// return YYABORT;
		// }
		//
		// /* Register new CASE-expression and get its id. */
		//
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// int case_expr_id= pctx->push_case_expr_id();
		//
		// if (case_expr_id < 0)
		// return YYABORT;
		//
		// /* Add CASE-set instruction. */
		//
		// sp_instr_set_case_expr *i=
		// new (thd->mem_root)
		// sp_instr_set_case_expr(sp->instructions(), lex,
		// case_expr_id, ((item)(yystack.valueAt (3-(3)))), case_expr_query);
		//
		// if (i == NULL ||
		// sp->m_parser_data.add_cont_backpatch_entry(i) ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 345:
		// if (yyn == 345)
		// /* Line 350 of lalr1.java */
		// /* Line 4304 of "sql_yacc.y" */
		// {
		// case_stmt_action_end_case(Lex, true);
		// };
		// break;
		//
		//
		// case 346:
		// if (yyn == 346)
		// /* Line 350 of lalr1.java */
		// /* Line 4311 of "sql_yacc.y" */
		// {
		// case_stmt_action_case(YYTHD);
		// };
		// break;
		//
		//
		// case 347:
		// if (yyn == 347)
		// /* Line 350 of lalr1.java */
		// /* Line 4318 of "sql_yacc.y" */
		// {
		// case_stmt_action_end_case(Lex, false);
		// };
		// break;
		//
		//
		// case 352:
		// if (yyn == 352)
		// /* Line 350 of lalr1.java */
		// /* Line 4335 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 353:
		// if (yyn == 353)
		// /* Line 350 of lalr1.java */
		// /* Line 4344 of "sql_yacc.y" */
		// {
		// /* Simple case: <caseval> = <whenval> */
		//
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// /* Extract expression string. */
		//
		// LEX_STRING when_expr_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// when_expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!when_expr_query.str)
		// return YYABORT;
		// }
		//
		// /* Add CASE-when-jump instruction. */
		//
		// sp_instr_jump_case_when *i =
		// new (thd->mem_root)
		// sp_instr_jump_case_when(sp->instructions(), lex,
		// pctx->get_current_case_expr_id(),
		// ((item)(yystack.valueAt (3-(3)))), when_expr_query);
		//
		// if (i == NULL ||
		// i->on_after_expr_parsing(thd) ||
		// sp->m_parser_data.add_backpatch_entry(
		// i, pctx->push_label(thd, EMPTY_STR, 0)) ||
		// sp->m_parser_data.add_cont_backpatch_entry(i) ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 354:
		// if (yyn == 354)
		// /* Line 350 of lalr1.java */
		// /* Line 4385 of "sql_yacc.y" */
		// {
		// if (case_stmt_action_then(YYTHD, Lex))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 355:
		// if (yyn == 355)
		// /* Line 350 of lalr1.java */
		// /* Line 4393 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 356:
		// if (yyn == 356)
		// /* Line 350 of lalr1.java */
		// /* Line 4402 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// /* Extract expression string. */
		//
		// LEX_STRING when_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// when_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!when_query.str)
		// return YYABORT;
		// }
		//
		// /* Add jump instruction. */
		//
		// sp_instr_jump_if_not *i=
		// new (thd->mem_root)
		// sp_instr_jump_if_not(sp->instructions(), lex, ((item)(yystack.valueAt
		// (3-(3)))), when_query);
		//
		// if (i == NULL ||
		// sp->m_parser_data.add_backpatch_entry(
		// i, pctx->push_label(thd, EMPTY_STR, 0)) ||
		// sp->m_parser_data.add_cont_backpatch_entry(i) ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 357:
		// if (yyn == 357)
		// /* Line 350 of lalr1.java */
		// /* Line 4438 of "sql_yacc.y" */
		// {
		// if (case_stmt_action_then(YYTHD, Lex))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 358:
		// if (yyn == 358)
		// /* Line 350 of lalr1.java */
		// /* Line 4446 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_instr_error *i=
		// new (thd->mem_root)
		// sp_instr_error(sp->instructions(), pctx, ER_SP_CASE_NOT_FOUND);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 360:
		// if (yyn == 360)
		// /* Line 350 of lalr1.java */
		// /* Line 4464 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *lab= pctx->find_label(((lex_str)(yystack.valueAt
		// (2-(1)))));
		//
		// if (lab)
		// {
		// my_error(ER_SP_LABEL_REDEFINE, MYF(0), ((lex_str)(yystack.valueAt
		// (2-(1)))).str);
		// return YYABORT;
		// }
		// else
		// {
		// lab= pctx->push_label(YYTHD, ((lex_str)(yystack.valueAt (2-(1)))),
		// sp->instructions());
		// lab->type= sp_label::ITERATION;
		// }
		// };
		// break;
		//
		//
		// case 361:
		// if (yyn == 361)
		// /* Line 350 of lalr1.java */
		// /* Line 4482 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *lab= pctx->pop_label();
		//
		// if (((lex_str)(yystack.valueAt (5-(5)))).str)
		// {
		// if (my_strcasecmp(system_charset_info, ((lex_str)(yystack.valueAt
		// (5-(5)))).str, lab->name.str) != 0)
		// {
		// my_error(ER_SP_LABEL_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (5-(5)))).str);
		// return YYABORT;
		// }
		// }
		// sp->m_parser_data.do_backpatch(lab, sp->instructions());
		// };
		// break;
		//
		//
		// case 362:
		// if (yyn == 362)
		// /* Line 350 of lalr1.java */
		// /* Line 4501 of "sql_yacc.y" */
		// { yyval= null_lex_str; };
		// break;
		//
		//
		// case 363:
		// if (yyn == 363)
		// /* Line 350 of lalr1.java */
		// /* Line 4502 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 364:
		// if (yyn == 364)
		// /* Line 350 of lalr1.java */
		// /* Line 4507 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *lab= pctx->find_label(((lex_str)(yystack.valueAt
		// (2-(1)))));
		//
		// if (lab)
		// {
		// my_error(ER_SP_LABEL_REDEFINE, MYF(0), ((lex_str)(yystack.valueAt
		// (2-(1)))).str);
		// return YYABORT;
		// }
		//
		// lab= pctx->push_label(YYTHD, ((lex_str)(yystack.valueAt (2-(1)))),
		// sp->instructions());
		// lab->type= sp_label::BEGIN;
		// };
		// break;
		//
		//
		// case 365:
		// if (yyn == 365)
		// /* Line 350 of lalr1.java */
		// /* Line 4523 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_label *lab= pctx->pop_label();
		//
		// if (((lex_str)(yystack.valueAt (5-(5)))).str)
		// {
		// if (my_strcasecmp(system_charset_info, ((lex_str)(yystack.valueAt
		// (5-(5)))).str, lab->name.str) != 0)
		// {
		// my_error(ER_SP_LABEL_MISMATCH, MYF(0), ((lex_str)(yystack.valueAt
		// (5-(5)))).str);
		// return YYABORT;
		// }
		// }
		// };
		// break;
		//
		//
		// case 366:
		// if (yyn == 366)
		// /* Line 350 of lalr1.java */
		// /* Line 4540 of "sql_yacc.y" */
		// { /* Unlabeled blocks get a secret label. */
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_label *lab=
		// pctx->push_label(YYTHD, EMPTY_STR, sp->instructions());
		//
		// lab->type= sp_label::BEGIN;
		// };
		// break;
		//
		//
		// case 367:
		// if (yyn == 367)
		// /* Line 350 of lalr1.java */
		// /* Line 4551 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->get_sp_current_parsing_ctx()->pop_label();
		// };
		// break;
		//
		//
		// case 368:
		// if (yyn == 368)
		// /* Line 350 of lalr1.java */
		// /* Line 4559 of "sql_yacc.y" */
		// { /* QQ This is just a dummy for grouping declarations and statements
		// together. No [[NOT] ATOMIC] yet, and we need to figure out how
		// make it coexist with the existing BEGIN COMMIT/ROLLBACK. */
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_pcontext *parent_pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_pcontext *child_pctx=
		// parent_pctx->push_context(thd, sp_pcontext::REGULAR_SCOPE);
		//
		// lex->set_sp_current_parsing_ctx(child_pctx);
		// };
		// break;
		//
		//
		// case 369:
		// if (yyn == 369)
		// /* Line 350 of lalr1.java */
		// /* Line 4574 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// // We always have a label.
		// sp->m_parser_data.do_backpatch(pctx->last_label(),
		// sp->instructions());
		//
		// if (((spblock)(yystack.valueAt (5-(3)))).hndlrs)
		// {
		// sp_instr *i=
		// new (thd->mem_root) sp_instr_hpop(sp->instructions(), pctx);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// }
		//
		// if (((spblock)(yystack.valueAt (5-(3)))).curs)
		// {
		// sp_instr *i=
		// new (thd->mem_root)
		// sp_instr_cpop(sp->instructions(), pctx, ((spblock)(yystack.valueAt
		// (5-(3)))).curs);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// }
		//
		// lex->set_sp_current_parsing_ctx(pctx->pop_context());
		// };
		// break;
		//
		//
		// case 370:
		// if (yyn == 370)
		// /* Line 350 of lalr1.java */
		// /* Line 4610 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_instr_jump *i=
		// new (thd->mem_root)
		// sp_instr_jump(sp->instructions(), pctx,
		// pctx->last_label()->ip);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 371:
		// if (yyn == 371)
		// /* Line 350 of lalr1.java */
		// /* Line 4625 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 372:
		// if (yyn == 372)
		// /* Line 350 of lalr1.java */
		// /* Line 4634 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// /* Extract expression string. */
		//
		// LEX_STRING expr_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!expr_query.str)
		// return YYABORT;
		// }
		//
		// /* Add jump instruction. */
		//
		// sp_instr_jump_if_not *i=
		// new (thd->mem_root)
		// sp_instr_jump_if_not(sp->instructions(), lex, ((item)(yystack.valueAt
		// (3-(3)))), expr_query);
		//
		// if (i == NULL ||
		// /* Jumping forward */
		// sp->m_parser_data.add_backpatch_entry(i, pctx->last_label()) ||
		// sp->m_parser_data.new_cont_backpatch() ||
		// sp->m_parser_data.add_cont_backpatch_entry(i) ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 373:
		// if (yyn == 373)
		// /* Line 350 of lalr1.java */
		// /* Line 4672 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		//
		// sp_instr_jump *i=
		// new (thd->mem_root)
		// sp_instr_jump(sp->instructions(), pctx, pctx->last_label()->ip);
		//
		// if (!i || sp->add_instr(thd, i))
		// return YYABORT;
		//
		// sp->m_parser_data.do_cont_backpatch(sp->instructions());
		// };
		// break;
		//
		//
		// case 374:
		// if (yyn == 374)
		// /* Line 350 of lalr1.java */
		// /* Line 4688 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// sp->reset_lex(thd);
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_END);
		// };
		// break;
		//
		//
		// case 375:
		// if (yyn == 375)
		// /* Line 350 of lalr1.java */
		// /* Line 4697 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// uint ip= sp->instructions();
		//
		// /* Extract expression string. */
		//
		// LEX_STRING expr_query= EMPTY_STR;
		// const char *expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
		//
		// if (lex->is_metadata_used())
		// {
		// expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
		// if (!expr_query.str)
		// return YYABORT;
		// }
		//
		// /* Add jump instruction. */
		//
		// sp_instr_jump_if_not *i=
		// new (thd->mem_root)
		// sp_instr_jump_if_not(ip, lex, ((item)(yystack.valueAt (5-(5)))),
		// expr_query,
		// pctx->last_label()->ip);
		//
		// if (i == NULL ||
		// sp->add_instr(thd, i) ||
		// sp->restore_lex(thd))
		// {
		// return YYABORT;
		// }
		//
		// /* We can shortcut the cont_backpatch here */
		// i->set_cont_dest(ip + 1);
		// };
		// break;
		//
		//
		// case 377:
		// if (yyn == 377)
		// /* Line 350 of lalr1.java */
		// /* Line 4738 of "sql_yacc.y" */
		// { yyval= TRG_ACTION_BEFORE; };
		// break;
		//
		//
		// case 378:
		// if (yyn == 378)
		// /* Line 350 of lalr1.java */
		// /* Line 4740 of "sql_yacc.y" */
		// { yyval= TRG_ACTION_AFTER; };
		// break;
		//
		//
		// case 379:
		// if (yyn == 379)
		// /* Line 350 of lalr1.java */
		// /* Line 4745 of "sql_yacc.y" */
		// { yyval= TRG_EVENT_INSERT; };
		// break;
		//
		//
		// case 380:
		// if (yyn == 380)
		// /* Line 350 of lalr1.java */
		// /* Line 4747 of "sql_yacc.y" */
		// { yyval= TRG_EVENT_UPDATE; };
		// break;
		//
		//
		// case 381:
		// if (yyn == 381)
		// /* Line 350 of lalr1.java */
		// /* Line 4749 of "sql_yacc.y" */
		// { yyval= TRG_EVENT_DELETE; };
		// break;
		//
		//
		// case 385:
		// if (yyn == 385)
		// /* Line 350 of lalr1.java */
		// /* Line 4783 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 386:
		// if (yyn == 386)
		// /* Line 350 of lalr1.java */
		// /* Line 4785 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->logfile_group_name=
		// ((lex_str)(yystack.valueAt (4-(4)))).str;
		// };
		// break;
		//
		//
		// case 387:
		// if (yyn == 387)
		// /* Line 350 of lalr1.java */
		// /* Line 4795 of "sql_yacc.y" */
		// {
		// Lex->alter_tablespace_info->ts_alter_tablespace_type=
		// ALTER_TABLESPACE_ADD_FILE;
		// };
		// break;
		//
		//
		// case 388:
		// if (yyn == 388)
		// /* Line 350 of lalr1.java */
		// /* Line 4801 of "sql_yacc.y" */
		// {
		// Lex->alter_tablespace_info->ts_alter_tablespace_type=
		// ALTER_TABLESPACE_DROP_FILE;
		// };
		// break;
		//
		//
		// case 393:
		// if (yyn == 393)
		// /* Line 350 of lalr1.java */
		// /* Line 4824 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 444:
		// if (yyn == 444)
		// /* Line 350 of lalr1.java */
		// /* Line 4922 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->data_file_name=
		// ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 445:
		// if (yyn == 445)
		// /* Line 350 of lalr1.java */
		// /* Line 4930 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->undo_file_name=
		// ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 446:
		// if (yyn == 446)
		// /* Line 350 of lalr1.java */
		// /* Line 4938 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->redo_file_name=
		// ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;

		case 447:
			if (yyn == 447)
			/* Line 350 of lalr1.java */
			/* Line 4946 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// lex->alter_tablespace_info= new st_alter_tablespace();
				// if (lex->alter_tablespace_info == NULL)
				// return YYABORT;
				// lex->alter_tablespace_info->tablespace_name=
				// ((lex_str)(yystack.valueAt (1-(1)))).str;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_TABLESPACE;
			}
			;
			break;

		case 448:
			if (yyn == 448)
			/* Line 350 of lalr1.java */
			/* Line 4958 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// lex->alter_tablespace_info= new st_alter_tablespace();
				// if (lex->alter_tablespace_info == NULL)
				// return YYABORT;
				// lex->alter_tablespace_info->logfile_group_name=
				// ((lex_str)(yystack.valueAt (1-(1)))).str;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_TABLESPACE;
			}
			;
			break;
		//
		//
		// case 449:
		// if (yyn == 449)
		// /* Line 350 of lalr1.java */
		// /* Line 4970 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_access_mode= TS_READ_ONLY;
		// };
		// break;
		//
		//
		// case 450:
		// if (yyn == 450)
		// /* Line 350 of lalr1.java */
		// /* Line 4975 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_access_mode= TS_READ_WRITE;
		// };
		// break;
		//
		//
		// case 451:
		// if (yyn == 451)
		// /* Line 350 of lalr1.java */
		// /* Line 4980 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_access_mode= TS_NOT_ACCESSIBLE;
		// };
		// break;
		//
		//
		// case 452:
		// if (yyn == 452)
		// /* Line 350 of lalr1.java */
		// /* Line 4988 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->initial_size=
		// ((ulonglong_number)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 453:
		// if (yyn == 453)
		// /* Line 350 of lalr1.java */
		// /* Line 4996 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->autoextend_size=
		// ((ulonglong_number)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 454:
		// if (yyn == 454)
		// /* Line 350 of lalr1.java */
		// /* Line 5004 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->max_size=
		// ((ulonglong_number)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 455:
		// if (yyn == 455)
		// /* Line 350 of lalr1.java */
		// /* Line 5012 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->extent_size=
		// ((ulonglong_number)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 456:
		// if (yyn == 456)
		// /* Line 350 of lalr1.java */
		// /* Line 5020 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->undo_buffer_size=
		// ((ulonglong_number)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 457:
		// if (yyn == 457)
		// /* Line 350 of lalr1.java */
		// /* Line 5028 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->redo_buffer_size=
		// ((ulonglong_number)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 458:
		// if (yyn == 458)
		// /* Line 350 of lalr1.java */
		// /* Line 5036 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (lex->alter_tablespace_info->nodegroup_id != UNDEF_NODEGROUP)
		// {
		// my_error(ER_FILEGROUP_OPTION_ONLY_ONCE,MYF(0),"NODEGROUP");
		// return YYABORT;
		// }
		// lex->alter_tablespace_info->nodegroup_id=
		// ((ulong_num)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 459:
		// if (yyn == 459)
		// /* Line 350 of lalr1.java */
		// /* Line 5049 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (lex->alter_tablespace_info->ts_comment != NULL)
		// {
		// my_error(ER_FILEGROUP_OPTION_ONLY_ONCE,MYF(0),"COMMENT");
		// return YYABORT;
		// }
		// lex->alter_tablespace_info->ts_comment= ((lex_str)(yystack.valueAt
		// (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 460:
		// if (yyn == 460)
		// /* Line 350 of lalr1.java */
		// /* Line 5062 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (lex->alter_tablespace_info->storage_engine != NULL)
		// {
		// my_error(ER_FILEGROUP_OPTION_ONLY_ONCE,MYF(0),
		// "STORAGE ENGINE");
		// return YYABORT;
		// }
		// lex->alter_tablespace_info->storage_engine=
		// ((db_type)(yystack.valueAt (4-(4))));
		// };
		// break;
		//
		//
		// case 461:
		// if (yyn == 461)
		// /* Line 350 of lalr1.java */
		// /* Line 5076 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->wait_until_completed= TRUE;
		// };
		// break;
		//
		//
		// case 462:
		// if (yyn == 462)
		// /* Line 350 of lalr1.java */
		// /* Line 5081 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (!(lex->alter_tablespace_info->wait_until_completed))
		// {
		// my_error(ER_FILEGROUP_OPTION_ONLY_ONCE,MYF(0),"NO_WAIT");
		// return YYABORT;
		// }
		// lex->alter_tablespace_info->wait_until_completed= FALSE;
		// };
		// break;
		//
		//
		// case 463:
		// if (yyn == 463)
		// /* Line 350 of lalr1.java */
		// /* Line 5093 of "sql_yacc.y" */
		// { yyval= ((ulonglong_number)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 464:
		// if (yyn == 464)
		// /* Line 350 of lalr1.java */
		// /* Line 5095 of "sql_yacc.y" */
		// {
		// ulonglong number;
		// uint text_shift_number= 0;
		// longlong prefix_number;
		// char *start_ptr= ((lex_str)(yystack.valueAt (1-(1)))).str;
		// uint str_len= ((lex_str)(yystack.valueAt (1-(1)))).length;
		// char *end_ptr= start_ptr + str_len;
		// int error;
		// prefix_number= my_strtoll10(start_ptr, &end_ptr, &error);
		// if ((start_ptr + str_len - 1) == end_ptr)
		// {
		// switch (end_ptr[0])
		// {
		// case 'g':
		// case 'G':
		// text_shift_number+=10;
		// case 'm':
		// case 'M':
		// text_shift_number+=10;
		// case 'k':
		// case 'K':
		// text_shift_number+=10;
		// break;
		// default:
		// {
		// my_error(ER_WRONG_SIZE_NUMBER, MYF(0));
		// return YYABORT;
		// }
		// }
		// if (prefix_number >> 31)
		// {
		// my_error(ER_SIZE_OVERFLOW_ERROR, MYF(0));
		// return YYABORT;
		// }
		// number= prefix_number << text_shift_number;
		// }
		// else
		// {
		// my_error(ER_WRONG_SIZE_NUMBER, MYF(0));
		// return YYABORT;
		// }
		// yyval= number;
		// };
		// break;
		//
		//
		// case 465:
		// if (yyn == 465)
		// /* Line 350 of lalr1.java */
		// /* Line 5145 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 466:
		// if (yyn == 466)
		// /* Line 350 of lalr1.java */
		// /* Line 5148 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		case 467:
			if (yyn == 467)
			/* Line 350 of lalr1.java */
			/* Line 5150 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				boolean result;
				// LEX *lex= thd->lex;
				//
				// lex->create_info.options|= HA_LEX_CREATE_TABLE_LIKE;
				result = MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(2 - (2)), null, null);
				if (!result)
					return YYABORT;
				// /* CREATE TABLE ... LIKE is not allowed for views. */
				// src_table->required_type= FRMTYPE_TABLE;
			}
			;
			break;

		case 468:
			if (yyn == 468)
			/* Line 350 of lalr1.java */
			/* Line 5165 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// TABLE_LIST *src_table;
				// LEX *lex= thd->lex;
				//
				// lex->create_info.options|= HA_LEX_CREATE_TABLE_LIKE;
				boolean result = MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(4 - (3)), null, null);
				if (!result)
					return YYABORT;
				// /* CREATE TABLE ... LIKE is not allowed for views. */
				// src_table->required_type= FRMTYPE_TABLE;
			}
			;
			break;
		//
		//
		// case 469:
		// if (yyn == 469)
		// /* Line 350 of lalr1.java */
		// /* Line 5184 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 470:
		// if (yyn == 470)
		// /* Line 350 of lalr1.java */
		// /* Line 5187 of "sql_yacc.y" */
		// { Select->set_braces(1);};
		// break;
		//
		//
		// case 471:
		// if (yyn == 471)
		// /* Line 350 of lalr1.java */
		// /* Line 5188 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 472:
		// if (yyn == 472)
		// /* Line 350 of lalr1.java */
		// /* Line 5192 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 473:
		// if (yyn == 473)
		// /* Line 350 of lalr1.java */
		// /* Line 5194 of "sql_yacc.y" */
		// { Select->set_braces(0);};
		// break;
		//
		//
		// case 474:
		// if (yyn == 474)
		// /* Line 350 of lalr1.java */
		// /* Line 5195 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 475:
		// if (yyn == 475)
		// /* Line 350 of lalr1.java */
		// /* Line 5197 of "sql_yacc.y" */
		// { Select->set_braces(1);};
		// break;
		//
		//
		// case 476:
		// if (yyn == 476)
		// /* Line 350 of lalr1.java */
		// /* Line 5198 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 477:
		// if (yyn == 477)
		// /* Line 350 of lalr1.java */
		// /* Line 5203 of "sql_yacc.y" */
		// {
		// /*
		// Remove all tables used in PARTITION clause from the global table
		// list. Partitioning with subqueries is not allowed anyway.
		// */
		// TABLE_LIST *last_non_sel_table= Lex->create_last_non_select_table;
		// last_non_sel_table->next_global= 0;
		// Lex->query_tables_last= &last_non_sel_table->next_global;
		// };
		// break;
		//
		//
		// case 478:
		// if (yyn == 478)
		// /* Line 350 of lalr1.java */
		// /* Line 5239 of "sql_yacc.y" */
		// {};
		// break;

		case 480:
		if (yyn == 480)
		/* Line 350 of lalr1.java */
		/* Line 5245 of "sql_yacc.y" */
		{
		// LEX *lex= Lex;
		// lex->part_info= new partition_info();
		// if (!lex->part_info)
		// {
		// mem_alloc_error(sizeof(partition_info));
		// return YYABORT;
		// }
			if (thd.lex.sqlCommand == SQLCommand.SQLCOM_ALTER_TABLE)
			{
				thd.lex.alterInfo.flags.add(AlterFlag.ALTER_PARTITION);
			}
		};
		break;
		//
		//
		// case 482:
		// if (yyn == 482)
		// /* Line 350 of lalr1.java */
		// /* Line 5263 of "sql_yacc.y" */
		// {
		// #ifdef WITH_PARTITION_STORAGE_ENGINE
		// LEX_STRING partition_name={C_STRING_WITH_LEN("partition")};
		// if (!plugin_is_ready(&partition_name, MYSQL_STORAGE_ENGINE_PLUGIN))
		// {
		// my_error(ER_OPTION_PREVENTS_STATEMENT, MYF(0),
		// "--skip-partition");
		// return YYABORT;
		// }
		// #else
		// my_error(ER_FEATURE_DISABLED, MYF(0), "partitioning",
		// "--with-plugin-partition");
		// return YYABORT;
		// #endif
		// };
		// break;
		//
		//
		// case 483:
		// if (yyn == 483)
		// /* Line 350 of lalr1.java */
		// /* Line 5282 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (!lex->part_info)
		// {
		// my_parse_error(ER(ER_PARTITION_ENTRY_ERROR));
		// return YYABORT;
		// }
		// /*
		// We enter here when opening the frm file to translate
		// partition info string into part_info data structure.
		// */
		// };
		// break;
		//
		//
		// case 484:
		// if (yyn == 484)
		// /* Line 350 of lalr1.java */
		// /* Line 5294 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 486:
		// if (yyn == 486)
		// /* Line 350 of lalr1.java */
		// /* Line 5303 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->list_of_part_fields= TRUE;
		// part_info->column_list= FALSE;
		// part_info->part_type= HASH_PARTITION;
		// };
		// break;
		//
		//
		// case 487:
		// if (yyn == 487)
		// /* Line 350 of lalr1.java */
		// /* Line 5310 of "sql_yacc.y" */
		// { Lex->part_info->part_type= HASH_PARTITION; };
		// break;
		//
		//
		// case 488:
		// if (yyn == 488)
		// /* Line 350 of lalr1.java */
		// /* Line 5311 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 489:
		// if (yyn == 489)
		// /* Line 350 of lalr1.java */
		// /* Line 5313 of "sql_yacc.y" */
		// { Lex->part_info->part_type= RANGE_PARTITION; };
		// break;
		//
		//
		// case 490:
		// if (yyn == 490)
		// /* Line 350 of lalr1.java */
		// /* Line 5315 of "sql_yacc.y" */
		// { Lex->part_info->part_type= RANGE_PARTITION; };
		// break;
		//
		//
		// case 491:
		// if (yyn == 491)
		// /* Line 350 of lalr1.java */
		// /* Line 5317 of "sql_yacc.y" */
		// { Lex->part_info->part_type= LIST_PARTITION; };
		// break;
		//
		//
		// case 492:
		// if (yyn == 492)
		// /* Line 350 of lalr1.java */
		// /* Line 5319 of "sql_yacc.y" */
		// { Lex->part_info->part_type= LIST_PARTITION; };
		// break;
		//
		//
		// case 493:
		// if (yyn == 493)
		// /* Line 350 of lalr1.java */
		// /* Line 5323 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 494:
		// if (yyn == 494)
		// /* Line 350 of lalr1.java */
		// /* Line 5325 of "sql_yacc.y" */
		// { Lex->part_info->linear_hash_ind= TRUE;};
		// break;
		//
		//
		// case 495:
		// if (yyn == 495)
		// /* Line 350 of lalr1.java */
		// /* Line 5330 of "sql_yacc.y" */
		// { Lex->part_info->key_algorithm=
		// partition_info::KEY_ALGORITHM_NONE;};
		// break;
		//
		//
		case 496:
			if (yyn == 496)
			/* Line 350 of lalr1.java */
			/* Line 5332 of "sql_yacc.y" */
			{
				// switch (((ulong_num)(yystack.valueAt (3-(3))))) {
				// case 1:
				// Lex->part_info->key_algorithm=
				// partition_info::KEY_ALGORITHM_51;
				// break;
				// case 2:
				// Lex->part_info->key_algorithm=
				// partition_info::KEY_ALGORITHM_55;
				// break;
				// default:
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		// case 497:
		// if (yyn == 497)
		// /* Line 350 of lalr1.java */
		// /* Line 5348 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 498:
		// if (yyn == 498)
		// /* Line 350 of lalr1.java */
		// /* Line 5349 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 499:
		// if (yyn == 499)
		// /* Line 350 of lalr1.java */
		// /* Line 5353 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 500:
		// if (yyn == 500)
		// /* Line 350 of lalr1.java */
		// /* Line 5354 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 501:
		// if (yyn == 501)
		// /* Line 350 of lalr1.java */
		// /* Line 5359 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->num_columns++;
		// if (part_info->part_field_list.push_back(((lex_str)(yystack.valueAt
		// (1-(1)))).str))
		// {
		// mem_alloc_error(1);
		// return YYABORT;
		// }
		// if (part_info->num_columns > MAX_REF_PARTS)
		// {
		// my_error(ER_TOO_MANY_PARTITION_FUNC_FIELDS_ERROR, MYF(0),
		// "list of partition fields");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 502:
		// if (yyn == 502)
		// /* Line 350 of lalr1.java */
		// /* Line 5378 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->column_list= TRUE;
		// part_info->list_of_part_fields= TRUE;
		// };
		// break;
		//
		//
		// case 503:
		// if (yyn == 503)
		// /* Line 350 of lalr1.java */
		// /* Line 5388 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if (part_info->set_part_expr(((simple_string)(yystack.valueAt
		// (5-(2))))+1, ((item)(yystack.valueAt (5-(3)))),
		// ((simple_string)(yystack.valueAt (5-(4)))), FALSE))
		// { return YYABORT; }
		// part_info->num_columns= 1;
		// part_info->column_list= FALSE;
		// };
		// break;
		//
		//
		// case 504:
		// if (yyn == 504)
		// /* Line 350 of lalr1.java */
		// /* Line 5399 of "sql_yacc.y" */
		// {
		// if (Lex->part_info->set_part_expr(((simple_string)(yystack.valueAt
		// (5-(2))))+1, ((item)(yystack.valueAt (5-(3)))),
		// ((simple_string)(yystack.valueAt (5-(4)))), TRUE))
		// { return YYABORT; }
		// };
		// break;
		//
		//
		// case 505:
		// if (yyn == 505)
		// /* Line 350 of lalr1.java */
		// /* Line 5407 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 506:
		// if (yyn == 506)
		// /* Line 350 of lalr1.java */
		// /* Line 5409 of "sql_yacc.y" */
		// {
		// uint num_parts= ((ulong_num)(yystack.valueAt (2-(2))));
		// partition_info *part_info= Lex->part_info;
		// if (num_parts == 0)
		// {
		// my_error(ER_NO_PARTS_ERROR, MYF(0), "partitions");
		// return YYABORT;
		// }
		//
		// part_info->num_parts= num_parts;
		// part_info->use_default_num_partitions= FALSE;
		// };
		// break;
		//
		//
		// case 507:
		// if (yyn == 507)
		// /* Line 350 of lalr1.java */
		// /* Line 5424 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 508:
		// if (yyn == 508)
		// /* Line 350 of lalr1.java */
		// /* Line 5426 of "sql_yacc.y" */
		// { Lex->part_info->subpart_type= HASH_PARTITION; };
		// break;
		//
		//
		// case 509:
		// if (yyn == 509)
		// /* Line 350 of lalr1.java */
		// /* Line 5427 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 510:
		// if (yyn == 510)
		// /* Line 350 of lalr1.java */
		// /* Line 5430 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->subpart_type= HASH_PARTITION;
		// part_info->list_of_subpart_fields= TRUE;
		// };
		// break;
		//
		//
		// case 511:
		// if (yyn == 511)
		// /* Line 350 of lalr1.java */
		// /* Line 5435 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 512:
		// if (yyn == 512)
		// /* Line 350 of lalr1.java */
		// /* Line 5439 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 513:
		// if (yyn == 513)
		// /* Line 350 of lalr1.java */
		// /* Line 5440 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 514:
		// if (yyn == 514)
		// /* Line 350 of lalr1.java */
		// /* Line 5445 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if
		// (part_info->subpart_field_list.push_back(((lex_str)(yystack.valueAt
		// (1-(1)))).str))
		// {
		// mem_alloc_error(1);
		// return YYABORT;
		// }
		// if (part_info->subpart_field_list.elements > MAX_REF_PARTS)
		// {
		// my_error(ER_TOO_MANY_PARTITION_FUNC_FIELDS_ERROR, MYF(0),
		// "list of subpartition fields");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 515:
		// if (yyn == 515)
		// /* Line 350 of lalr1.java */
		// /* Line 5463 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// bool not_corr_func;
		// not_corr_func= !lex->safe_to_cache_query;
		// lex->safe_to_cache_query= 1;
		// if (not_corr_func)
		// {
		// my_parse_error(ER(ER_WRONG_EXPR_IN_PARTITION_FUNC_ERROR));
		// return YYABORT;
		// }
		// yyval=((item)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 516:
		// if (yyn == 516)
		// /* Line 350 of lalr1.java */
		// /* Line 5478 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 517:
		// if (yyn == 517)
		// /* Line 350 of lalr1.java */
		// /* Line 5480 of "sql_yacc.y" */
		// {
		// uint num_parts= ((ulong_num)(yystack.valueAt (2-(2))));
		// LEX *lex= Lex;
		// if (num_parts == 0)
		// {
		// my_error(ER_NO_PARTS_ERROR, MYF(0), "subpartitions");
		// return YYABORT;
		// }
		// lex->part_info->num_subparts= num_parts;
		// lex->part_info->use_default_num_subpartitions= FALSE;
		// };
		// break;
		//
		//
		// case 518:
		// if (yyn == 518)
		// /* Line 350 of lalr1.java */
		// /* Line 5495 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if (part_info->part_type == RANGE_PARTITION)
		// {
		// my_error(ER_PARTITIONS_MUST_BE_DEFINED_ERROR, MYF(0),
		// "RANGE");
		// return YYABORT;
		// }
		// else if (part_info->part_type == LIST_PARTITION)
		// {
		// my_error(ER_PARTITIONS_MUST_BE_DEFINED_ERROR, MYF(0),
		// "LIST");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 519:
		// if (yyn == 519)
		// /* Line 350 of lalr1.java */
		// /* Line 5511 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// uint count_curr_parts= part_info->partitions.elements;
		// if (part_info->num_parts != 0)
		// {
		// if (part_info->num_parts !=
		// count_curr_parts)
		// {
		// my_parse_error(ER(ER_PARTITION_WRONG_NO_PART_ERROR));
		// return YYABORT;
		// }
		// }
		// else if (count_curr_parts > 0)
		// {
		// part_info->num_parts= count_curr_parts;
		// }
		// part_info->count_curr_subparts= 0;
		// };
		// break;
		//
		//
		// case 520:
		// if (yyn == 520)
		// /* Line 350 of lalr1.java */
		// /* Line 5532 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 521:
		// if (yyn == 521)
		// /* Line 350 of lalr1.java */
		// /* Line 5533 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 522:
		// if (yyn == 522)
		// /* Line 350 of lalr1.java */
		// /* Line 5538 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// partition_element *p_elem= new partition_element();
		//
		// if (!p_elem || part_info->partitions.push_back(p_elem))
		// {
		// mem_alloc_error(sizeof(partition_element));
		// return YYABORT;
		// }
		// p_elem->part_state= PART_NORMAL;
		// part_info->curr_part_elem= p_elem;
		// part_info->current_partition= p_elem;
		// part_info->use_default_partitions= FALSE;
		// part_info->use_default_num_partitions= FALSE;
		// };
		// break;
		//
		//
		// case 523:
		// if (yyn == 523)
		// /* Line 350 of lalr1.java */
		// /* Line 5557 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 524:
		// if (yyn == 524)
		// /* Line 350 of lalr1.java */
		// /* Line 5562 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// partition_element *p_elem= part_info->curr_part_elem;
		// if (check_string_char_length(&((lex_str)(yystack.valueAt (1-(1)))),
		// "", NAME_CHAR_LEN,
		// system_charset_info, true))
		// {
		// my_error(ER_TOO_LONG_IDENT, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// p_elem->partition_name= ((lex_str)(yystack.valueAt (1-(1)))).str;
		// };
		// break;
		//
		//
		// case 525:
		// if (yyn == 525)
		// /* Line 350 of lalr1.java */
		// /* Line 5577 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// partition_info *part_info= lex->part_info;
		// if (! lex->is_partition_management())
		// {
		// if (part_info->part_type == RANGE_PARTITION)
		// {
		// my_error(ER_PARTITION_REQUIRES_VALUES_ERROR, MYF(0),
		// "RANGE", "LESS THAN");
		// return YYABORT;
		// }
		// if (part_info->part_type == LIST_PARTITION)
		// {
		// my_error(ER_PARTITION_REQUIRES_VALUES_ERROR, MYF(0),
		// "LIST", "IN");
		// return YYABORT;
		// }
		// }
		// else
		// part_info->part_type= HASH_PARTITION;
		// };
		// break;
		//
		//
		// case 526:
		// if (yyn == 526)
		// /* Line 350 of lalr1.java */
		// /* Line 5599 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// partition_info *part_info= lex->part_info;
		// if (! lex->is_partition_management())
		// {
		// if (part_info->part_type != RANGE_PARTITION)
		// {
		// my_error(ER_PARTITION_WRONG_VALUES_ERROR, MYF(0),
		// "RANGE", "LESS THAN");
		// return YYABORT;
		// }
		// }
		// else
		// part_info->part_type= RANGE_PARTITION;
		// };
		// break;
		//
		//
		// case 527:
		// if (yyn == 527)
		// /* Line 350 of lalr1.java */
		// /* Line 5614 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 528:
		// if (yyn == 528)
		// /* Line 350 of lalr1.java */
		// /* Line 5616 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// partition_info *part_info= lex->part_info;
		// if (! lex->is_partition_management())
		// {
		// if (part_info->part_type != LIST_PARTITION)
		// {
		// my_error(ER_PARTITION_WRONG_VALUES_ERROR, MYF(0),
		// "LIST", "IN");
		// return YYABORT;
		// }
		// }
		// else
		// part_info->part_type= LIST_PARTITION;
		// };
		// break;
		//
		//
		// case 529:
		// if (yyn == 529)
		// /* Line 350 of lalr1.java */
		// /* Line 5631 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 530:
		// if (yyn == 530)
		// /* Line 350 of lalr1.java */
		// /* Line 5636 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		//
		// if (part_info->num_columns &&
		// part_info->num_columns != 1U)
		// {
		// part_info->print_debug("Kilroy II", NULL);
		// my_parse_error(ER(ER_PARTITION_COLUMN_LIST_ERROR));
		// return YYABORT;
		// }
		// else
		// part_info->num_columns= 1U;
		// if (part_info->init_column_part())
		// {
		// return YYABORT;
		// }
		// if (part_info->add_max_value())
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 531:
		// if (yyn == 531)
		// /* Line 350 of lalr1.java */
		// /* Line 5657 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 532:
		// if (yyn == 532)
		// /* Line 350 of lalr1.java */
		// /* Line 5662 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// partition_info *part_info= lex->part_info;
		// part_info->print_debug("part_values_in: part_value_item", NULL);
		//
		// if (part_info->num_columns != 1U)
		// {
		// if (!lex->is_partition_management() ||
		// part_info->num_columns == 0 ||
		// part_info->num_columns > MAX_REF_PARTS)
		// {
		// part_info->print_debug("Kilroy III", NULL);
		// my_parse_error(ER(ER_PARTITION_COLUMN_LIST_ERROR));
		// return YYABORT;
		// }
		// /*
		// Reorganize the current large array into a list of small
		// arrays with one entry in each array. This can happen
		// in the first partition of an ALTER TABLE statement where
		// we ADD or REORGANIZE partitions. Also can only happen
		// for LIST [COLUMNS] partitions.
		// */
		// if (part_info->reorganize_into_single_field_col_val())
		// {
		// return YYABORT;
		// }
		// }
		// };
		// break;
		//
		//
		// case 533:
		// if (yyn == 533)
		// /* Line 350 of lalr1.java */
		// /* Line 5691 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if (part_info->num_columns < 2U)
		// {
		// my_parse_error(ER(ER_ROW_SINGLE_PARTITION_FIELD_ERROR));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 534:
		// if (yyn == 534)
		// /* Line 350 of lalr1.java */
		// /* Line 5702 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 535:
		// if (yyn == 535)
		// /* Line 350 of lalr1.java */
		// /* Line 5703 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 536:
		// if (yyn == 536)
		// /* Line 350 of lalr1.java */
		// /* Line 5708 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->print_debug("( part_value_item", NULL);
		// /* Initialisation code needed for each list of value expressions */
		// if (!(part_info->part_type == LIST_PARTITION &&
		// part_info->num_columns == 1U) &&
		// part_info->init_column_part())
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 537:
		// if (yyn == 537)
		// /* Line 350 of lalr1.java */
		// /* Line 5719 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 538:
		// if (yyn == 538)
		// /* Line 350 of lalr1.java */
		// /* Line 5721 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->print_debug(") part_value_item", NULL);
		// if (part_info->num_columns == 0)
		// part_info->num_columns= part_info->curr_list_object;
		// if (part_info->num_columns != part_info->curr_list_object)
		// {
		// /*
		// All value items lists must be of equal length, in some cases
		// which is covered by the above if-statement we don't know yet
		// how many columns is in the partition so the assignment above
		// ensures that we only report errors when we know we have an
		// error.
		// */
		// part_info->print_debug("Kilroy I", NULL);
		// my_parse_error(ER(ER_PARTITION_COLUMN_LIST_ERROR));
		// return YYABORT;
		// }
		// part_info->curr_list_object= 0;
		// };
		// break;
		//
		//
		// case 539:
		// if (yyn == 539)
		// /* Line 350 of lalr1.java */
		// /* Line 5744 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 540:
		// if (yyn == 540)
		// /* Line 350 of lalr1.java */
		// /* Line 5745 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 541:
		// if (yyn == 541)
		// /* Line 350 of lalr1.java */
		// /* Line 5750 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if (part_info->part_type == LIST_PARTITION)
		// {
		// my_parse_error(ER(ER_MAXVALUE_IN_VALUES_IN));
		// return YYABORT;
		// }
		// if (part_info->add_max_value())
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 542:
		// if (yyn == 542)
		// /* Line 350 of lalr1.java */
		// /* Line 5763 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// partition_info *part_info= lex->part_info;
		// Item *part_expr= ((item)(yystack.valueAt (1-(1))));
		//
		// if (!lex->safe_to_cache_query)
		// {
		// my_parse_error(ER(ER_WRONG_EXPR_IN_PARTITION_FUNC_ERROR));
		// return YYABORT;
		// }
		// if (part_info->add_column_list_value(YYTHD, part_expr))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 543:
		// if (yyn == 543)
		// /* Line 350 of lalr1.java */
		// /* Line 5783 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if (part_info->num_subparts != 0 &&
		// !part_info->use_default_subpartitions)
		// {
		// /*
		// We come here when we have defined subpartitions on the first
		// partition but not on all the subsequent partitions.
		// */
		// my_parse_error(ER(ER_PARTITION_WRONG_NO_SUBPART_ERROR));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 544:
		// if (yyn == 544)
		// /* Line 350 of lalr1.java */
		// /* Line 5797 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// if (part_info->num_subparts != 0)
		// {
		// if (part_info->num_subparts !=
		// part_info->count_curr_subparts)
		// {
		// my_parse_error(ER(ER_PARTITION_WRONG_NO_SUBPART_ERROR));
		// return YYABORT;
		// }
		// }
		// else if (part_info->count_curr_subparts > 0)
		// {
		// if (part_info->partitions.elements > 1)
		// {
		// my_parse_error(ER(ER_PARTITION_WRONG_NO_SUBPART_ERROR));
		// return YYABORT;
		// }
		// part_info->num_subparts= part_info->count_curr_subparts;
		// }
		// part_info->count_curr_subparts= 0;
		// };
		// break;
		//
		//
		// case 545:
		// if (yyn == 545)
		// /* Line 350 of lalr1.java */
		// /* Line 5822 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 546:
		// if (yyn == 546)
		// /* Line 350 of lalr1.java */
		// /* Line 5823 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 547:
		// if (yyn == 547)
		// /* Line 350 of lalr1.java */
		// /* Line 5828 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// partition_element *curr_part= part_info->current_partition;
		// partition_element *sub_p_elem= new partition_element(curr_part);
		// if (part_info->use_default_subpartitions &&
		// part_info->partitions.elements >= 2)
		// {
		// /*
		// create table t1 (a int)
		// partition by list (a) subpartition by hash (a)
		// (partition p0 values in (1),
		// partition p1 values in (2) subpartition sp11);
		// causes use to arrive since we are on the second
		// partition, but still use_default_subpartitions
		// is set. When we come here we're processing at least
		// the second partition (the current partition processed
		// have already been put into the partitions list.
		// */
		// my_parse_error(ER(ER_PARTITION_WRONG_NO_SUBPART_ERROR));
		// return YYABORT;
		// }
		// if (!sub_p_elem ||
		// curr_part->subpartitions.push_back(sub_p_elem))
		// {
		// mem_alloc_error(sizeof(partition_element));
		// return YYABORT;
		// }
		// part_info->curr_part_elem= sub_p_elem;
		// part_info->use_default_subpartitions= FALSE;
		// part_info->use_default_num_subpartitions= FALSE;
		// part_info->count_curr_subparts++;
		// };
		// break;
		//
		//
		// case 548:
		// if (yyn == 548)
		// /* Line 350 of lalr1.java */
		// /* Line 5860 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 549:
		// if (yyn == 549)
		// /* Line 350 of lalr1.java */
		// /* Line 5865 of "sql_yacc.y" */
		// {
		// if (check_string_char_length(&((lex_str)(yystack.valueAt (1-(1)))),
		// "", NAME_CHAR_LEN,
		// system_charset_info, true))
		// {
		// my_error(ER_TOO_LONG_IDENT, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// Lex->part_info->curr_part_elem->partition_name=
		// ((lex_str)(yystack.valueAt (1-(1)))).str;
		// };
		// break;
		//
		//
		// case 550:
		// if (yyn == 550)
		// /* Line 350 of lalr1.java */
		// /* Line 5877 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 551:
		// if (yyn == 551)
		// /* Line 350 of lalr1.java */
		// /* Line 5878 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 552:
		// if (yyn == 552)
		// /* Line 350 of lalr1.java */
		// /* Line 5882 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 553:
		// if (yyn == 553)
		// /* Line 350 of lalr1.java */
		// /* Line 5883 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 554:
		// if (yyn == 554)
		// /* Line 350 of lalr1.java */
		// /* Line 5888 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->tablespace_name=
		// ((lex_str)(yystack.valueAt (3-(3)))).str; };
		// break;
		//
		//
		// case 555:
		// if (yyn == 555)
		// /* Line 350 of lalr1.java */
		// /* Line 5890 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->curr_part_elem->engine_type= ((db_type)(yystack.valueAt
		// (4-(4))));
		// part_info->default_engine_type= ((db_type)(yystack.valueAt (4-(4))));
		// };
		// break;
		//
		//
		// case 556:
		// if (yyn == 556)
		// /* Line 350 of lalr1.java */
		// /* Line 5896 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->nodegroup_id= (uint16)
		// ((ulong_num)(yystack.valueAt (3-(3)))); };
		// break;
		//
		//
		// case 557:
		// if (yyn == 557)
		// /* Line 350 of lalr1.java */
		// /* Line 5898 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->part_max_rows= (ha_rows)
		// ((ulonglong_number)(yystack.valueAt (3-(3)))); };
		// break;
		//
		//
		// case 558:
		// if (yyn == 558)
		// /* Line 350 of lalr1.java */
		// /* Line 5900 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->part_min_rows= (ha_rows)
		// ((ulonglong_number)(yystack.valueAt (3-(3)))); };
		// break;
		//
		//
		// case 559:
		// if (yyn == 559)
		// /* Line 350 of lalr1.java */
		// /* Line 5902 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->data_file_name=
		// ((lex_str)(yystack.valueAt (4-(4)))).str; };
		// break;
		//
		//
		// case 560:
		// if (yyn == 560)
		// /* Line 350 of lalr1.java */
		// /* Line 5904 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->index_file_name=
		// ((lex_str)(yystack.valueAt (4-(4)))).str; };
		// break;
		//
		//
		// case 561:
		// if (yyn == 561)
		// /* Line 350 of lalr1.java */
		// /* Line 5906 of "sql_yacc.y" */
		// { Lex->part_info->curr_part_elem->part_comment=
		// ((lex_str)(yystack.valueAt (3-(3)))).str; };
		// break;

		case 562:
			if (yyn == 562)
			/* Line 350 of lalr1.java */
			/* Line 5915 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				if (thd.lex.sqlCommand == SQLCommand.SQLCOM_INSERT)
					thd.lex.sqlCommand = SQLCommand.SQLCOM_INSERT_SELECT;
				else if (thd.lex.sqlCommand == SQLCommand.SQLCOM_REPLACE)
					thd.lex.sqlCommand = SQLCommand.SQLCOM_REPLACE_SELECT;
				// /*
				// The following work only with the local list, the global list
				// is created correctly in this case
				// */
				// lex->current_select->table_list.save_and_clear(&lex->save_list);
				MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->current_select->parsing_place= SELECT_LIST;
			}
			;
			break;
		//
		//
		// case 563:
		// if (yyn == 563)
		// /* Line 350 of lalr1.java */
		// /* Line 5930 of "sql_yacc.y" */
		// {
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 564:
		// if (yyn == 564)
		// /* Line 350 of lalr1.java */
		// /* Line 5934 of "sql_yacc.y" */
		// {
		// /*
		// The following work only with the local list, the global list
		// is created correctly in this case
		// */
		// Lex->current_select->table_list.push_front(&Lex->save_list);
		// };
		// break;
		//
		//
		// case 565:
		// if (yyn == 565)
		// /* Line 350 of lalr1.java */
		// /* Line 5944 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 566:
		// if (yyn == 566)
		// /* Line 350 of lalr1.java */
		// /* Line 5945 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 567:
		// if (yyn == 567)
		// /* Line 350 of lalr1.java */
		// /* Line 5949 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 568:
		// if (yyn == 568)
		// /* Line 350 of lalr1.java */
		// /* Line 5950 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 569:
		// if (yyn == 569)
		// /* Line 350 of lalr1.java */
		// /* Line 5954 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 570:
		// if (yyn == 570)
		// /* Line 350 of lalr1.java */
		// /* Line 5955 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 571:
		// if (yyn == 571)
		// /* Line 350 of lalr1.java */
		// /* Line 5959 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 572:
		// if (yyn == 572)
		// /* Line 350 of lalr1.java */
		// /* Line 5960 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 573:
		// if (yyn == 573)
		// /* Line 350 of lalr1.java */
		// /* Line 5964 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 574:
		// if (yyn == 574)
		// /* Line 350 of lalr1.java */
		// /* Line 5965 of "sql_yacc.y" */
		// { yyval= ((num)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 575:
		// if (yyn == 575)
		// /* Line 350 of lalr1.java */
		// /* Line 5969 of "sql_yacc.y" */
		// { yyval=((num)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 576:
		// if (yyn == 576)
		// /* Line 350 of lalr1.java */
		// /* Line 5970 of "sql_yacc.y" */
		// { yyval= ((num)(yystack.valueAt (2-(1)))) | ((num)(yystack.valueAt
		// (2-(2)))); };
		// break;
		//
		//
		// case 577:
		// if (yyn == 577)
		// /* Line 350 of lalr1.java */
		// /* Line 5974 of "sql_yacc.y" */
		// { yyval=HA_LEX_CREATE_TMP_TABLE; };
		// break;
		//
		//
		// case 578:
		// if (yyn == 578)
		// /* Line 350 of lalr1.java */
		// /* Line 5978 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 579:
		// if (yyn == 579)
		// /* Line 350 of lalr1.java */
		// /* Line 5979 of "sql_yacc.y" */
		// { yyval=HA_LEX_CREATE_IF_NOT_EXISTS; };
		// break;
		//
		//
		// case 587:
		// if (yyn == 587)
		// /* Line 350 of lalr1.java */
		// /* Line 6000 of "sql_yacc.y" */
		// {
		// Lex->create_info.db_type= ((db_type)(yystack.valueAt (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_ENGINE;
		// };
		// break;
		//
		//
		// case 588:
		// if (yyn == 588)
		// /* Line 350 of lalr1.java */
		// /* Line 6005 of "sql_yacc.y" */
		// {
		// Lex->create_info.max_rows= ((ulonglong_number)(yystack.valueAt
		// (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_MAX_ROWS;
		// };
		// break;
		//
		//
		// case 589:
		// if (yyn == 589)
		// /* Line 350 of lalr1.java */
		// /* Line 6010 of "sql_yacc.y" */
		// {
		// Lex->create_info.min_rows= ((ulonglong_number)(yystack.valueAt
		// (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_MIN_ROWS;
		// };
		// break;
		//
		//
		// case 590:
		// if (yyn == 590)
		// /* Line 350 of lalr1.java */
		// /* Line 6015 of "sql_yacc.y" */
		// {
		// Lex->create_info.avg_row_length=((ulong_num)(yystack.valueAt
		// (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_AVG_ROW_LENGTH;
		// };
		// break;
		//
		//
		// case 591:
		// if (yyn == 591)
		// /* Line 350 of lalr1.java */
		// /* Line 6020 of "sql_yacc.y" */
		// {
		// Lex->create_info.password=((lex_str)(yystack.valueAt (3-(3)))).str;
		// Lex->create_info.used_fields|= HA_CREATE_USED_PASSWORD;
		// };
		// break;
		//
		//
		// case 592:
		// if (yyn == 592)
		// /* Line 350 of lalr1.java */
		// /* Line 6025 of "sql_yacc.y" */
		// {
		// Lex->create_info.comment=((lex_str)(yystack.valueAt (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_COMMENT;
		// };
		// break;
		//
		//
		// case 593:
		// if (yyn == 593)
		// /* Line 350 of lalr1.java */
		// /* Line 6030 of "sql_yacc.y" */
		// {
		// Lex->create_info.auto_increment_value=((ulonglong_number)(yystack.valueAt
		// (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_AUTO;
		// };
		// break;
		//
		//
		case 594:
			if (yyn == 594)
			/* Line 350 of lalr1.java */
			/* Line 6035 of "sql_yacc.y" */
			{
				// switch(((ulong_num)(yystack.valueAt (3-(3))))) {
				// case 0:
				// Lex->create_info.table_options|= HA_OPTION_NO_PACK_KEYS;
				// break;
				// case 1:
				// Lex->create_info.table_options|= HA_OPTION_PACK_KEYS;
				// break;
				// default:
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// Lex->create_info.used_fields|= HA_CREATE_USED_PACK_KEYS;
			}
			;
			break;
		//
		//
		// case 595:
		// if (yyn == 595)
		// /* Line 350 of lalr1.java */
		// /* Line 6050 of "sql_yacc.y" */
		// {
		// Lex->create_info.table_options&=
		// ~(HA_OPTION_PACK_KEYS | HA_OPTION_NO_PACK_KEYS);
		// Lex->create_info.used_fields|= HA_CREATE_USED_PACK_KEYS;
		// };
		// break;
		//
		//
		case 596:
			if (yyn == 596)
			/* Line 350 of lalr1.java */
			/* Line 6056 of "sql_yacc.y" */
			{
				// switch(((ulong_num)(yystack.valueAt (3-(3))))) {
				// case 0:
				// Lex->create_info.stats_auto_recalc= HA_STATS_AUTO_RECALC_OFF;
				// break;
				// case 1:
				// Lex->create_info.stats_auto_recalc= HA_STATS_AUTO_RECALC_ON;
				// break;
				// default:
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// Lex->create_info.used_fields|=
				// HA_CREATE_USED_STATS_AUTO_RECALC;
			}
			;
			break;
		//
		//
		// case 597:
		// if (yyn == 597)
		// /* Line 350 of lalr1.java */
		// /* Line 6071 of "sql_yacc.y" */
		// {
		// Lex->create_info.stats_auto_recalc= HA_STATS_AUTO_RECALC_DEFAULT;
		// Lex->create_info.used_fields|= HA_CREATE_USED_STATS_AUTO_RECALC;
		// };
		// break;
		//
		//
		case 598:
			if (yyn == 598)
			/* Line 350 of lalr1.java */
			/* Line 6076 of "sql_yacc.y" */
			{
				// switch(((ulong_num)(yystack.valueAt (3-(3))))) {
				// case 0:
				// Lex->create_info.table_options|=
				// HA_OPTION_NO_STATS_PERSISTENT;
				// break;
				// case 1:
				// Lex->create_info.table_options|= HA_OPTION_STATS_PERSISTENT;
				// break;
				// default:
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// Lex->create_info.used_fields|=
				// HA_CREATE_USED_STATS_PERSISTENT;
			}
			;
			break;
		//
		//
		// case 599:
		// if (yyn == 599)
		// /* Line 350 of lalr1.java */
		// /* Line 6091 of "sql_yacc.y" */
		// {
		// Lex->create_info.table_options&=
		// ~(HA_OPTION_STATS_PERSISTENT | HA_OPTION_NO_STATS_PERSISTENT);
		// Lex->create_info.used_fields|= HA_CREATE_USED_STATS_PERSISTENT;
		// };
		// break;
		//
		//
		case 600:
			if (yyn == 600)
			/* Line 350 of lalr1.java */
			/* Line 6097 of "sql_yacc.y" */
			{
				// /* From user point of view STATS_SAMPLE_PAGES can be
				// specified as
				// STATS_SAMPLE_PAGES=N (where 0<N<=65535, it does not make
				// sense to
				// scan 0 pages) or STATS_SAMPLE_PAGES=default. Internally we
				// record
				// =default as 0. See create_frm() in sql/table.cc, we use only
				// two
				// bytes for stats_sample_pages and this is why we do not allow
				// larger values. 65535 pages, 16kb each means to sample 1GB,
				// which
				// is impractical. If at some point this needs to be extended,
				// then
				// we can store the higher bits from stats_sample_pages in .frm
				// too. */
				// if (((ulong_num)(yystack.valueAt (3-(3)))) == 0 ||
				// ((ulong_num)(yystack.valueAt (3-(3)))) > 0xffff)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// Lex->create_info.stats_sample_pages=((ulong_num)(yystack.valueAt
				// (3-(3))));
				// Lex->create_info.used_fields|=
				// HA_CREATE_USED_STATS_SAMPLE_PAGES;
			}
			;
			break;
		//
		//
		// case 601:
		// if (yyn == 601)
		// /* Line 350 of lalr1.java */
		// /* Line 6115 of "sql_yacc.y" */
		// {
		// Lex->create_info.stats_sample_pages=0;
		// Lex->create_info.used_fields|= HA_CREATE_USED_STATS_SAMPLE_PAGES;
		// };
		// break;
		//
		//
		// case 602:
		// if (yyn == 602)
		// /* Line 350 of lalr1.java */
		// /* Line 6120 of "sql_yacc.y" */
		// {
		// Lex->create_info.table_options|= ((ulong_num)(yystack.valueAt
		// (3-(3)))) ? HA_OPTION_CHECKSUM : HA_OPTION_NO_CHECKSUM;
		// Lex->create_info.used_fields|= HA_CREATE_USED_CHECKSUM;
		// };
		// break;
		//
		//
		// case 603:
		// if (yyn == 603)
		// /* Line 350 of lalr1.java */
		// /* Line 6125 of "sql_yacc.y" */
		// {
		// Lex->create_info.table_options|= ((ulong_num)(yystack.valueAt
		// (3-(3)))) ? HA_OPTION_CHECKSUM : HA_OPTION_NO_CHECKSUM;
		// Lex->create_info.used_fields|= HA_CREATE_USED_CHECKSUM;
		// };
		// break;
		//
		//
		// case 604:
		// if (yyn == 604)
		// /* Line 350 of lalr1.java */
		// /* Line 6130 of "sql_yacc.y" */
		// {
		// Lex->create_info.table_options|= ((ulong_num)(yystack.valueAt
		// (3-(3)))) ? HA_OPTION_DELAY_KEY_WRITE : HA_OPTION_NO_DELAY_KEY_WRITE;
		// Lex->create_info.used_fields|= HA_CREATE_USED_DELAY_KEY_WRITE;
		// };
		// break;
		//
		//
		// case 605:
		// if (yyn == 605)
		// /* Line 350 of lalr1.java */
		// /* Line 6135 of "sql_yacc.y" */
		// {
		// Lex->create_info.row_type= ((row_type)(yystack.valueAt (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_ROW_FORMAT;
		// };
		// break;
		//
		//
		// case 606:
		// if (yyn == 606)
		// /* Line 350 of lalr1.java */
		// /* Line 6140 of "sql_yacc.y" */
		// {
		// Lex->select_lex.table_list.save_and_clear(&Lex->save_list);
		// };
		// break;
		//
		//
		// case 607:
		// if (yyn == 607)
		// /* Line 350 of lalr1.java */
		// /* Line 6144 of "sql_yacc.y" */
		// {
		// /*
		// Move the union list to the merge_list and exclude its tables
		// from the global list.
		// */
		// LEX *lex=Lex;
		// lex->create_info.merge_list= lex->select_lex.table_list;
		// lex->select_lex.table_list= lex->save_list;
		// /*
		// When excluding union list from the global list we assume that
		// elements of the former immediately follow elements which represent
		// table being created/altered and parent tables.
		// */
		// TABLE_LIST *last_non_sel_table= lex->create_last_non_select_table;
		// DBUG_ASSERT(last_non_sel_table->next_global ==
		// lex->create_info.merge_list.first);
		// last_non_sel_table->next_global= 0;
		// Lex->query_tables_last= &last_non_sel_table->next_global;
		//
		// lex->create_info.used_fields|= HA_CREATE_USED_UNION;
		// };
		// break;
		//
		//
		// case 610:
		// if (yyn == 610)
		// /* Line 350 of lalr1.java */
		// /* Line 6168 of "sql_yacc.y" */
		// {
		// Lex->create_info.merge_insert_method= ((ulong_num)(yystack.valueAt
		// (3-(3))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_INSERT_METHOD;
		// };
		// break;
		//
		//
		// case 611:
		// if (yyn == 611)
		// /* Line 350 of lalr1.java */
		// /* Line 6173 of "sql_yacc.y" */
		// {
		// Lex->create_info.data_file_name= ((lex_str)(yystack.valueAt
		// (4-(4)))).str;
		// Lex->create_info.used_fields|= HA_CREATE_USED_DATADIR;
		// };
		// break;
		//
		//
		// case 612:
		// if (yyn == 612)
		// /* Line 350 of lalr1.java */
		// /* Line 6178 of "sql_yacc.y" */
		// {
		// Lex->create_info.index_file_name= ((lex_str)(yystack.valueAt
		// (4-(4)))).str;
		// Lex->create_info.used_fields|= HA_CREATE_USED_INDEXDIR;
		// };
		// break;
		//
		//
		// case 613:
		// if (yyn == 613)
		// /* Line 350 of lalr1.java */
		// /* Line 6183 of "sql_yacc.y" */
		// {Lex->create_info.tablespace= ((lex_str)(yystack.valueAt
		// (2-(2)))).str;};
		// break;
		//
		//
		// case 614:
		// if (yyn == 614)
		// /* Line 350 of lalr1.java */
		// /* Line 6185 of "sql_yacc.y" */
		// {Lex->create_info.storage_media= HA_SM_DISK;};
		// break;
		//
		//
		// case 615:
		// if (yyn == 615)
		// /* Line 350 of lalr1.java */
		// /* Line 6187 of "sql_yacc.y" */
		// {Lex->create_info.storage_media= HA_SM_MEMORY;};
		// break;
		//
		//
		// case 616:
		// if (yyn == 616)
		// /* Line 350 of lalr1.java */
		// /* Line 6189 of "sql_yacc.y" */
		// {
		// Lex->create_info.connect_string.str= ((lex_str)(yystack.valueAt
		// (3-(3)))).str;
		// Lex->create_info.connect_string.length= ((lex_str)(yystack.valueAt
		// (3-(3)))).length;
		// Lex->create_info.used_fields|= HA_CREATE_USED_CONNECTION;
		// };
		// break;
		//
		//
		// case 617:
		// if (yyn == 617)
		// /* Line 350 of lalr1.java */
		// /* Line 6195 of "sql_yacc.y" */
		// {
		// Lex->create_info.used_fields|= HA_CREATE_USED_KEY_BLOCK_SIZE;
		// Lex->create_info.key_block_size= ((ulong_num)(yystack.valueAt
		// (3-(3))));
		// };
		// break;
		//
		//
		// case 618:
		// if (yyn == 618)
		// /* Line 350 of lalr1.java */
		// /* Line 6203 of "sql_yacc.y" */
		// {
		// HA_CREATE_INFO *cinfo= &Lex->create_info;
		// if ((cinfo->used_fields & HA_CREATE_USED_DEFAULT_CHARSET) &&
		// cinfo->default_table_charset && ((charset)(yystack.valueAt (4-(4))))
		// &&
		// !my_charset_same(cinfo->default_table_charset,((charset)(yystack.valueAt
		// (4-(4))))))
		// {
		// my_error(ER_CONFLICTING_DECLARATIONS, MYF(0),
		// "CHARACTER SET ", cinfo->default_table_charset->csname,
		// "CHARACTER SET ", ((charset)(yystack.valueAt (4-(4))))->csname);
		// return YYABORT;
		// }
		// Lex->create_info.default_table_charset= ((charset)(yystack.valueAt
		// (4-(4))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_DEFAULT_CHARSET;
		// };
		// break;
		//
		//
		// case 619:
		// if (yyn == 619)
		// /* Line 350 of lalr1.java */
		// /* Line 6221 of "sql_yacc.y" */
		// {
		// HA_CREATE_INFO *cinfo= &Lex->create_info;
		// if ((cinfo->used_fields & HA_CREATE_USED_DEFAULT_CHARSET) &&
		// cinfo->default_table_charset && ((charset)(yystack.valueAt (4-(4))))
		// &&
		// !(((charset)(yystack.valueAt (4-(4))))=
		// merge_charset_and_collation(cinfo->default_table_charset,
		// ((charset)(yystack.valueAt (4-(4)))))))
		// {
		// return YYABORT;
		// }
		//
		// Lex->create_info.default_table_charset= ((charset)(yystack.valueAt
		// (4-(4))));
		// Lex->create_info.used_fields|= HA_CREATE_USED_DEFAULT_CHARSET;
		// };
		// break;
		//
		//
		// case 620:
		// if (yyn == 620)
		// /* Line 350 of lalr1.java */
		// /* Line 6238 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// plugin_ref plugin=
		// ha_resolve_by_name(thd, &((lex_str)(yystack.valueAt (1-(1)))),
		// thd->lex->create_info.options & HA_LEX_CREATE_TMP_TABLE);
		//
		// if (plugin)
		// yyval= plugin_data(plugin, handlerton*);
		// else
		// {
		// if (thd->variables.sql_mode & MODE_NO_ENGINE_SUBSTITUTION)
		// {
		// my_error(ER_UNKNOWN_STORAGE_ENGINE, MYF(0),
		// ((lex_str)(yystack.valueAt (1-(1)))).str);
		// return YYABORT;
		// }
		// yyval= 0;
		// push_warning_printf(thd, Sql_condition::WARN_LEVEL_WARN,
		// ER_UNKNOWN_STORAGE_ENGINE,
		// ER(ER_UNKNOWN_STORAGE_ENGINE),
		// ((lex_str)(yystack.valueAt (1-(1)))).str);
		// }
		// };
		// break;
		//
		//
		// case 621:
		// if (yyn == 621)
		// /* Line 350 of lalr1.java */
		// /* Line 6264 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// plugin_ref plugin=
		// ha_resolve_by_name(thd, &((lex_str)(yystack.valueAt (1-(1)))),
		// lex->create_info.options & HA_LEX_CREATE_TMP_TABLE);
		// if (plugin)
		// yyval= plugin_data(plugin, handlerton*);
		// else
		// {
		// my_error(ER_UNKNOWN_STORAGE_ENGINE, MYF(0),
		// ((lex_str)(yystack.valueAt (1-(1)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 622:
		// if (yyn == 622)
		// /* Line 350 of lalr1.java */
		// /* Line 6281 of "sql_yacc.y" */
		// { yyval= ROW_TYPE_DEFAULT; };
		// break;
		//
		//
		// case 623:
		// if (yyn == 623)
		// /* Line 350 of lalr1.java */
		// /* Line 6282 of "sql_yacc.y" */
		// { yyval= ROW_TYPE_FIXED; };
		// break;
		//
		//
		// case 624:
		// if (yyn == 624)
		// /* Line 350 of lalr1.java */
		// /* Line 6283 of "sql_yacc.y" */
		// { yyval= ROW_TYPE_DYNAMIC; };
		// break;
		//
		//
		// case 625:
		// if (yyn == 625)
		// /* Line 350 of lalr1.java */
		// /* Line 6284 of "sql_yacc.y" */
		// { yyval= ROW_TYPE_COMPRESSED; };
		// break;
		//
		//
		// case 626:
		// if (yyn == 626)
		// /* Line 350 of lalr1.java */
		// /* Line 6285 of "sql_yacc.y" */
		// { yyval= ROW_TYPE_REDUNDANT; };
		// break;
		//
		//
		// case 627:
		// if (yyn == 627)
		// /* Line 350 of lalr1.java */
		// /* Line 6286 of "sql_yacc.y" */
		// { yyval= ROW_TYPE_COMPACT; };
		// break;
		//
		//
		// case 628:
		// if (yyn == 628)
		// /* Line 350 of lalr1.java */
		// /* Line 6290 of "sql_yacc.y" */
		// { yyval= MERGE_INSERT_DISABLED; };
		// break;
		//
		//
		// case 629:
		// if (yyn == 629)
		// /* Line 350 of lalr1.java */
		// /* Line 6291 of "sql_yacc.y" */
		// { yyval= MERGE_INSERT_TO_FIRST; };
		// break;
		//
		//
		// case 630:
		// if (yyn == 630)
		// /* Line 350 of lalr1.java */
		// /* Line 6292 of "sql_yacc.y" */
		// { yyval= MERGE_INSERT_TO_LAST; };
		// break;
		//
		//
		// case 631:
		// if (yyn == 631)
		// /* Line 350 of lalr1.java */
		// /* Line 6296 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 633:
		// if (yyn == 633)
		// /* Line 350 of lalr1.java */
		// /* Line 6301 of "sql_yacc.y" */
		// {yyval = (int) STRING_RESULT; };
		// break;
		//
		//
		// case 634:
		// if (yyn == 634)
		// /* Line 350 of lalr1.java */
		// /* Line 6302 of "sql_yacc.y" */
		// {yyval = (int) REAL_RESULT; };
		// break;
		//
		//
		// case 635:
		// if (yyn == 635)
		// /* Line 350 of lalr1.java */
		// /* Line 6303 of "sql_yacc.y" */
		// {yyval = (int) DECIMAL_RESULT; };
		// break;
		//
		//
		// case 636:
		// if (yyn == 636)
		// /* Line 350 of lalr1.java */
		// /* Line 6304 of "sql_yacc.y" */
		// {yyval = (int) INT_RESULT; };
		// break;
		//
		//
		// case 637:
		// if (yyn == 637)
		// /* Line 350 of lalr1.java */
		// /* Line 6310 of "sql_yacc.y" */
		// {
		// Lex->create_last_non_select_table= Lex->last_table();
		// };
		// break;
		//
		//
		// case 643:
		// if (yyn == 643)
		// /* Line 350 of lalr1.java */
		// /* Line 6328 of "sql_yacc.y" */
		// {
		// Lex->col_list.empty(); /* Alloced by sql_alloc */
		// };
		// break;
		//
		//
		// case 644:
		// if (yyn == 644)
		// /* Line 350 of lalr1.java */
		// /* Line 6335 of "sql_yacc.y" */
		// {
		// if (add_create_index (Lex, ((key_type)(yystack.valueAt (7-(1)))),
		// ((lex_str)(yystack.valueAt (7-(2))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 645:
		// if (yyn == 645)
		// /* Line 350 of lalr1.java */
		// /* Line 6341 of "sql_yacc.y" */
		// {
		// if (add_create_index (Lex, ((key_type)(yystack.valueAt (8-(1)))),
		// ((lex_str)(yystack.valueAt (8-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 646:
		// if (yyn == 646)
		// /* Line 350 of lalr1.java */
		// /* Line 6347 of "sql_yacc.y" */
		// {
		// if (add_create_index (Lex, ((key_type)(yystack.valueAt (8-(1)))),
		// ((lex_str)(yystack.valueAt (8-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 647:
		// if (yyn == 647)
		// /* Line 350 of lalr1.java */
		// /* Line 6353 of "sql_yacc.y" */
		// {
		// if (add_create_index (Lex, ((key_type)(yystack.valueAt (8-(2)))),
		// ((lex_str)(yystack.valueAt (8-(3)))).str ? ((lex_str)(yystack.valueAt
		// (8-(3)))) : ((lex_str)(yystack.valueAt (8-(1))))))
		// return YYABORT;
		// };
		// break;

		case 648:
		if (yyn == 648)
		/* Line 350 of lalr1.java */
		/* Line 6358 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Key *key= new Foreign_key(((lex_str)(yystack.valueAt (8-(4)))).str ?
		// ((lex_str)(yystack.valueAt (8-(4)))) : ((lex_str)(yystack.valueAt
		// (8-(1)))), lex->col_list,
		// ((table)(yystack.valueAt (8-(8))))->db,
		// ((table)(yystack.valueAt (8-(8))))->table,
		// lex->ref_list,
		// lex->fk_delete_opt,
		// lex->fk_update_opt,
		// lex->fk_match_option);
		// if (key == NULL)
		// return YYABORT;
		// lex->alter_info.key_list.push_back(key);
		// if (add_create_index (lex, Key::MULTIPLE, ((lex_str)(yystack.valueAt
		// (8-(1)))).str ? ((lex_str)(yystack.valueAt (8-(1)))) :
		// ((lex_str)(yystack.valueAt (8-(4)))),
		// &default_key_create_info, 1))
		// return YYABORT;
		// /* Only used for ALTER TABLE. Ignored otherwise. */
			thd.lex.alterInfo.flags.add(AlterFlag.ADD_FOREIGN_KEY);
		};
		break;
		//
		//
		// case 649:
		// if (yyn == 649)
		// /* Line 350 of lalr1.java */
		// /* Line 6377 of "sql_yacc.y" */
		// {
		// Lex->col_list.empty(); /* Alloced by sql_alloc */
		// };
		// break;
		//
		//
		// case 653:
		// if (yyn == 653)
		// /* Line 350 of lalr1.java */
		// /* Line 6392 of "sql_yacc.y" */
		// { yyval= null_lex_str; };
		// break;
		//
		//
		// case 654:
		// if (yyn == 654)
		// /* Line 350 of lalr1.java */
		// /* Line 6393 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 655:
		// if (yyn == 655)
		// /* Line 350 of lalr1.java */
		// /* Line 6397 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 656:
		// if (yyn == 656)
		// /* Line 350 of lalr1.java */
		// /* Line 6402 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->length=lex->dec=0;
		// lex->type=0;
		// lex->default_value= lex->on_update_value= 0;
		// lex->comment=null_lex_str;
		// lex->charset=NULL;
		// };
		// break;
		//
		//
		// case 657:
		// if (yyn == 657)
		// /* Line 350 of lalr1.java */
		// /* Line 6411 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (add_field_to_list(lex->thd, &((lex_str)(yystack.valueAt
		// (4-(1)))), (enum enum_field_types) ((num)(yystack.valueAt (4-(3)))),
		// lex->length,lex->dec,lex->type,
		// lex->default_value, lex->on_update_value,
		// &lex->comment,
		// lex->change,&lex->interval_list,lex->charset,
		// lex->uint_geom_type))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 658:
		// if (yyn == 658)
		// /* Line 350 of lalr1.java */
		// /* Line 6424 of "sql_yacc.y" */
		// { yyval=((num)(yystack.valueAt (3-(1)))); };
		// break;
		//
		//
		// case 659:
		// if (yyn == 659)
		// /* Line 350 of lalr1.java */
		// /* Line 6425 of "sql_yacc.y" */
		// { yyval=((num)(yystack.valueAt (3-(1)))); };
		// break;
		//
		//
		// case 660:
		// if (yyn == 660)
		// /* Line 350 of lalr1.java */
		// /* Line 6426 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_FLOAT; };
		// break;
		//
		//
		// case 661:
		// if (yyn == 661)
		// /* Line 350 of lalr1.java */
		// /* Line 6428 of "sql_yacc.y" */
		// {
		// Lex->length= (char*) "1";
		// yyval=MYSQL_TYPE_BIT;
		// };
		// break;
		//
		//
		// case 662:
		// if (yyn == 662)
		// /* Line 350 of lalr1.java */
		// /* Line 6433 of "sql_yacc.y" */
		// {
		// yyval=MYSQL_TYPE_BIT;
		// };
		// break;
		//
		//
		// case 663:
		// if (yyn == 663)
		// /* Line 350 of lalr1.java */
		// /* Line 6437 of "sql_yacc.y" */
		// {
		// Lex->length= (char*) "1";
		// yyval=MYSQL_TYPE_TINY;
		// };
		// break;
		//
		//
		// case 664:
		// if (yyn == 664)
		// /* Line 350 of lalr1.java */
		// /* Line 6442 of "sql_yacc.y" */
		// {
		// Lex->length= (char*) "1";
		// yyval=MYSQL_TYPE_TINY;
		// };
		// break;
		//
		//
		// case 665:
		// if (yyn == 665)
		// /* Line 350 of lalr1.java */
		// /* Line 6447 of "sql_yacc.y" */
		// {
		// yyval=MYSQL_TYPE_STRING;
		// };
		// break;
		//
		//
		// case 666:
		// if (yyn == 666)
		// /* Line 350 of lalr1.java */
		// /* Line 6451 of "sql_yacc.y" */
		// {
		// Lex->length= (char*) "1";
		// yyval=MYSQL_TYPE_STRING;
		// };
		// break;
		//
		//
		// case 667:
		// if (yyn == 667)
		// /* Line 350 of lalr1.java */
		// /* Line 6456 of "sql_yacc.y" */
		// {
		// yyval=MYSQL_TYPE_STRING;
		// Lex->charset=national_charset_info;
		// };
		// break;
		//
		//
		// case 668:
		// if (yyn == 668)
		// /* Line 350 of lalr1.java */
		// /* Line 6461 of "sql_yacc.y" */
		// {
		// Lex->length= (char*) "1";
		// yyval=MYSQL_TYPE_STRING;
		// Lex->charset=national_charset_info;
		// };
		// break;
		//
		//
		// case 669:
		// if (yyn == 669)
		// /* Line 350 of lalr1.java */
		// /* Line 6467 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_STRING;
		// };
		// break;
		//
		//
		// case 670:
		// if (yyn == 670)
		// /* Line 350 of lalr1.java */
		// /* Line 6472 of "sql_yacc.y" */
		// {
		// Lex->length= (char*) "1";
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_STRING;
		// };
		// break;
		//
		//
		// case 671:
		// if (yyn == 671)
		// /* Line 350 of lalr1.java */
		// /* Line 6478 of "sql_yacc.y" */
		// {
		// yyval= MYSQL_TYPE_VARCHAR;
		// };
		// break;
		//
		//
		// case 672:
		// if (yyn == 672)
		// /* Line 350 of lalr1.java */
		// /* Line 6482 of "sql_yacc.y" */
		// {
		// yyval= MYSQL_TYPE_VARCHAR;
		// Lex->charset=national_charset_info;
		// };
		// break;
		//
		//
		// case 673:
		// if (yyn == 673)
		// /* Line 350 of lalr1.java */
		// /* Line 6487 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval= MYSQL_TYPE_VARCHAR;
		// };
		// break;
		//
		//
		// case 674:
		// if (yyn == 674)
		// /* Line 350 of lalr1.java */
		// /* Line 6492 of "sql_yacc.y" */
		// {
		// if (Lex->length)
		// {
		// errno= 0;
		// ulong length= strtoul(Lex->length, NULL, 10);
		// if (errno == 0 && length <= MAX_FIELD_BLOBLENGTH && length != 4)
		// {
		// /* Reset unsupported positive column width to default value */
		// Lex->length= NULL;
		// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
		// ER_INVALID_YEAR_COLUMN_LENGTH,
		// ER(ER_INVALID_YEAR_COLUMN_LENGTH),
		// length);
		// }
		// }
		// yyval=MYSQL_TYPE_YEAR;
		// };
		// break;
		//
		//
		// case 675:
		// if (yyn == 675)
		// /* Line 350 of lalr1.java */
		// /* Line 6510 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_DATE; };
		// break;
		//
		//
		// case 676:
		// if (yyn == 676)
		// /* Line 350 of lalr1.java */
		// /* Line 6512 of "sql_yacc.y" */
		// { yyval= MYSQL_TYPE_TIME2; };
		// break;
		//
		//
		// case 677:
		// if (yyn == 677)
		// /* Line 350 of lalr1.java */
		// /* Line 6514 of "sql_yacc.y" */
		// {
		// if (YYTHD->variables.sql_mode & MODE_MAXDB)
		// yyval=MYSQL_TYPE_DATETIME2;
		// else
		// {
		// /*
		// Unlike other types TIMESTAMP fields are NOT NULL by default.
		// This behavior is deprecated now.
		// */
		// if (!YYTHD->variables.explicit_defaults_for_timestamp)
		// Lex->type|= NOT_NULL_FLAG;
		//
		// yyval=MYSQL_TYPE_TIMESTAMP2;
		// }
		// };
		// break;
		//
		//
		// case 678:
		// if (yyn == 678)
		// /* Line 350 of lalr1.java */
		// /* Line 6530 of "sql_yacc.y" */
		// { yyval= MYSQL_TYPE_DATETIME2; };
		// break;
		//
		//
		// case 679:
		// if (yyn == 679)
		// /* Line 350 of lalr1.java */
		// /* Line 6532 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_TINY_BLOB;
		// };
		// break;
		//
		//
		// case 680:
		// if (yyn == 680)
		// /* Line 350 of lalr1.java */
		// /* Line 6537 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_BLOB;
		// };
		// break;
		//
		//
		// case 681:
		// if (yyn == 681)
		// /* Line 350 of lalr1.java */
		// /* Line 6542 of "sql_yacc.y" */
		// {
		// #ifdef HAVE_SPATIAL
		// Lex->charset=&my_charset_bin;
		// Lex->uint_geom_type= (uint)((num)(yystack.valueAt (1-(1))));
		// yyval=MYSQL_TYPE_GEOMETRY;
		// #else
		// my_error(ER_FEATURE_DISABLED, MYF(0),
		// sym_group_geom.name, sym_group_geom.needed_define);
		// return YYABORT;
		// #endif
		// };
		// break;
		//
		//
		// case 682:
		// if (yyn == 682)
		// /* Line 350 of lalr1.java */
		// /* Line 6554 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_MEDIUM_BLOB;
		// };
		// break;
		//
		//
		// case 683:
		// if (yyn == 683)
		// /* Line 350 of lalr1.java */
		// /* Line 6559 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_LONG_BLOB;
		// };
		// break;
		//
		//
		// case 684:
		// if (yyn == 684)
		// /* Line 350 of lalr1.java */
		// /* Line 6564 of "sql_yacc.y" */
		// {
		// Lex->charset=&my_charset_bin;
		// yyval=MYSQL_TYPE_MEDIUM_BLOB;
		// };
		// break;
		//
		//
		// case 685:
		// if (yyn == 685)
		// /* Line 350 of lalr1.java */
		// /* Line 6569 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_MEDIUM_BLOB; };
		// break;
		//
		//
		// case 686:
		// if (yyn == 686)
		// /* Line 350 of lalr1.java */
		// /* Line 6571 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_TINY_BLOB; };
		// break;
		//
		//
		// case 687:
		// if (yyn == 687)
		// /* Line 350 of lalr1.java */
		// /* Line 6573 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_BLOB; };
		// break;
		//
		//
		// case 688:
		// if (yyn == 688)
		// /* Line 350 of lalr1.java */
		// /* Line 6575 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_MEDIUM_BLOB; };
		// break;
		//
		//
		// case 689:
		// if (yyn == 689)
		// /* Line 350 of lalr1.java */
		// /* Line 6577 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_LONG_BLOB; };
		// break;
		//
		//
		// case 690:
		// if (yyn == 690)
		// /* Line 350 of lalr1.java */
		// /* Line 6579 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_NEWDECIMAL;};
		// break;
		//
		//
		// case 691:
		// if (yyn == 691)
		// /* Line 350 of lalr1.java */
		// /* Line 6581 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_NEWDECIMAL;};
		// break;
		//
		//
		// case 692:
		// if (yyn == 692)
		// /* Line 350 of lalr1.java */
		// /* Line 6583 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_NEWDECIMAL;};
		// break;
		//
		//
		// case 693:
		// if (yyn == 693)
		// /* Line 350 of lalr1.java */
		// /* Line 6585 of "sql_yacc.y" */
		// {Lex->interval_list.empty();};
		// break;
		//
		//
		// case 694:
		// if (yyn == 694)
		// /* Line 350 of lalr1.java */
		// /* Line 6587 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_ENUM; };
		// break;
		//
		//
		// case 695:
		// if (yyn == 695)
		// /* Line 350 of lalr1.java */
		// /* Line 6589 of "sql_yacc.y" */
		// { Lex->interval_list.empty();};
		// break;
		//
		//
		// case 696:
		// if (yyn == 696)
		// /* Line 350 of lalr1.java */
		// /* Line 6591 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_SET; };
		// break;
		//
		//
		// case 697:
		// if (yyn == 697)
		// /* Line 350 of lalr1.java */
		// /* Line 6593 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_MEDIUM_BLOB; };
		// break;
		//
		//
		// case 698:
		// if (yyn == 698)
		// /* Line 350 of lalr1.java */
		// /* Line 6595 of "sql_yacc.y" */
		// {
		// yyval=MYSQL_TYPE_LONGLONG;
		// Lex->type|= (AUTO_INCREMENT_FLAG | NOT_NULL_FLAG | UNSIGNED_FLAG |
		// UNIQUE_FLAG);
		// };
		// break;
		//
		//
		// case 699:
		// if (yyn == 699)
		// /* Line 350 of lalr1.java */
		// /* Line 6603 of "sql_yacc.y" */
		// { yyval= Field::GEOM_GEOMETRY; };
		// break;
		//
		//
		// case 700:
		// if (yyn == 700)
		// /* Line 350 of lalr1.java */
		// /* Line 6604 of "sql_yacc.y" */
		// { yyval= Field::GEOM_GEOMETRYCOLLECTION; };
		// break;
		//
		//
		// case 701:
		// if (yyn == 701)
		// /* Line 350 of lalr1.java */
		// /* Line 6606 of "sql_yacc.y" */
		// {
		// Lex->length= const_cast<char*>(STRINGIFY_ARG
		// (MAX_LEN_GEOM_POINT_FIELD));
		// yyval= Field::GEOM_POINT;
		// };
		// break;
		//
		//
		// case 702:
		// if (yyn == 702)
		// /* Line 350 of lalr1.java */
		// /* Line 6611 of "sql_yacc.y" */
		// { yyval= Field::GEOM_MULTIPOINT; };
		// break;
		//
		//
		// case 703:
		// if (yyn == 703)
		// /* Line 350 of lalr1.java */
		// /* Line 6612 of "sql_yacc.y" */
		// { yyval= Field::GEOM_LINESTRING; };
		// break;
		//
		//
		// case 704:
		// if (yyn == 704)
		// /* Line 350 of lalr1.java */
		// /* Line 6613 of "sql_yacc.y" */
		// { yyval= Field::GEOM_MULTILINESTRING; };
		// break;
		//
		//
		// case 705:
		// if (yyn == 705)
		// /* Line 350 of lalr1.java */
		// /* Line 6614 of "sql_yacc.y" */
		// { yyval= Field::GEOM_POLYGON; };
		// break;
		//
		//
		// case 706:
		// if (yyn == 706)
		// /* Line 350 of lalr1.java */
		// /* Line 6615 of "sql_yacc.y" */
		// { yyval= Field::GEOM_MULTIPOLYGON; };
		// break;
		//
		//
		// case 707:
		// if (yyn == 707)
		// /* Line 350 of lalr1.java */
		// /* Line 6619 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 708:
		// if (yyn == 708)
		// /* Line 350 of lalr1.java */
		// /* Line 6623 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 709:
		// if (yyn == 709)
		// /* Line 350 of lalr1.java */
		// /* Line 6624 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 710:
		// if (yyn == 710)
		// /* Line 350 of lalr1.java */
		// /* Line 6628 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 711:
		// if (yyn == 711)
		// /* Line 350 of lalr1.java */
		// /* Line 6629 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 712:
		// if (yyn == 712)
		// /* Line 350 of lalr1.java */
		// /* Line 6633 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 713:
		// if (yyn == 713)
		// /* Line 350 of lalr1.java */
		// /* Line 6634 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 714:
		// if (yyn == 714)
		// /* Line 350 of lalr1.java */
		// /* Line 6635 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 715:
		// if (yyn == 715)
		// /* Line 350 of lalr1.java */
		// /* Line 6636 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 716:
		// if (yyn == 716)
		// /* Line 350 of lalr1.java */
		// /* Line 6637 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 717:
		// if (yyn == 717)
		// /* Line 350 of lalr1.java */
		// /* Line 6641 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_LONG; };
		// break;
		//
		//
		// case 718:
		// if (yyn == 718)
		// /* Line 350 of lalr1.java */
		// /* Line 6642 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_TINY; };
		// break;
		//
		//
		// case 719:
		// if (yyn == 719)
		// /* Line 350 of lalr1.java */
		// /* Line 6643 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_SHORT; };
		// break;
		//
		//
		// case 720:
		// if (yyn == 720)
		// /* Line 350 of lalr1.java */
		// /* Line 6644 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_INT24; };
		// break;
		//
		//
		// case 721:
		// if (yyn == 721)
		// /* Line 350 of lalr1.java */
		// /* Line 6645 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_LONGLONG; };
		// break;
		//
		//
		// case 722:
		// if (yyn == 722)
		// /* Line 350 of lalr1.java */
		// /* Line 6650 of "sql_yacc.y" */
		// {
		// yyval= YYTHD->variables.sql_mode & MODE_REAL_AS_FLOAT ?
		// MYSQL_TYPE_FLOAT : MYSQL_TYPE_DOUBLE;
		// };
		// break;
		//
		//
		// case 723:
		// if (yyn == 723)
		// /* Line 350 of lalr1.java */
		// /* Line 6655 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_DOUBLE; };
		// break;
		//
		//
		// case 724:
		// if (yyn == 724)
		// /* Line 350 of lalr1.java */
		// /* Line 6657 of "sql_yacc.y" */
		// { yyval=MYSQL_TYPE_DOUBLE; };
		// break;
		//
		//
		// case 725:
		// if (yyn == 725)
		// /* Line 350 of lalr1.java */
		// /* Line 6662 of "sql_yacc.y" */
		// { Lex->dec=Lex->length= (char*)0; };
		// break;
		//
		//
		// case 726:
		// if (yyn == 726)
		// /* Line 350 of lalr1.java */
		// /* Line 6664 of "sql_yacc.y" */
		// { Lex->dec= (char*)0; };
		// break;
		//
		//
		// case 727:
		// if (yyn == 727)
		// /* Line 350 of lalr1.java */
		// /* Line 6666 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 728:
		// if (yyn == 728)
		// /* Line 350 of lalr1.java */
		// /* Line 6671 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->length=((lex_str)(yystack.valueAt (5-(2)))).str;
		// lex->dec=((lex_str)(yystack.valueAt (5-(4)))).str;
		// };
		// break;
		//
		//
		// case 729:
		// if (yyn == 729)
		// /* Line 350 of lalr1.java */
		// /* Line 6680 of "sql_yacc.y" */
		// { Lex->dec= (char *) 0; };
		// break;
		//
		//
		// case 730:
		// if (yyn == 730)
		// /* Line 350 of lalr1.java */
		// /* Line 6681 of "sql_yacc.y" */
		// { Lex->dec= ((lex_str)(yystack.valueAt (3-(2)))).str; };
		// break;
		//
		//
		// case 731:
		// if (yyn == 731)
		// /* Line 350 of lalr1.java */
		// /* Line 6685 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 732:
		// if (yyn == 732)
		// /* Line 350 of lalr1.java */
		// /* Line 6686 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 733:
		// if (yyn == 733)
		// /* Line 350 of lalr1.java */
		// /* Line 6688 of "sql_yacc.y" */
		// {
		// int error;
		// yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt (3-(2)))).str,
		// NULL, &error);
		// };
		// break;
		//
		//
		// case 734:
		// if (yyn == 734)
		// /* Line 350 of lalr1.java */
		// /* Line 6695 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 735:
		// if (yyn == 735)
		// /* Line 350 of lalr1.java */
		// /* Line 6696 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 736:
		// if (yyn == 736)
		// /* Line 350 of lalr1.java */
		// /* Line 6700 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 737:
		// if (yyn == 737)
		// /* Line 350 of lalr1.java */
		// /* Line 6701 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 738:
		// if (yyn == 738)
		// /* Line 350 of lalr1.java */
		// /* Line 6705 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 739:
		// if (yyn == 739)
		// /* Line 350 of lalr1.java */
		// /* Line 6706 of "sql_yacc.y" */
		// { Lex->type|= UNSIGNED_FLAG;};
		// break;
		//
		//
		// case 740:
		// if (yyn == 740)
		// /* Line 350 of lalr1.java */
		// /* Line 6707 of "sql_yacc.y" */
		// { Lex->type|= UNSIGNED_FLAG | ZEROFILL_FLAG; };
		// break;
		//
		//
		// case 741:
		// if (yyn == 741)
		// /* Line 350 of lalr1.java */
		// /* Line 6711 of "sql_yacc.y" */
		// { Lex->length= ((lex_str)(yystack.valueAt (3-(2)))).str; };
		// break;
		//
		//
		// case 742:
		// if (yyn == 742)
		// /* Line 350 of lalr1.java */
		// /* Line 6712 of "sql_yacc.y" */
		// { Lex->length= ((lex_str)(yystack.valueAt (3-(2)))).str; };
		// break;
		//
		//
		// case 743:
		// if (yyn == 743)
		// /* Line 350 of lalr1.java */
		// /* Line 6713 of "sql_yacc.y" */
		// { Lex->length= ((lex_str)(yystack.valueAt (3-(2)))).str; };
		// break;
		//
		//
		// case 744:
		// if (yyn == 744)
		// /* Line 350 of lalr1.java */
		// /* Line 6714 of "sql_yacc.y" */
		// { Lex->length= ((lex_str)(yystack.valueAt (3-(2)))).str; };
		// break;
		//
		//
		// case 745:
		// if (yyn == 745)
		// /* Line 350 of lalr1.java */
		// /* Line 6717 of "sql_yacc.y" */
		// { Lex->length=(char*) 0; /* use default length */ };
		// break;
		//
		//
		// case 746:
		// if (yyn == 746)
		// /* Line 350 of lalr1.java */
		// /* Line 6718 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 747:
		// if (yyn == 747)
		// /* Line 350 of lalr1.java */
		// /* Line 6722 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 748:
		// if (yyn == 748)
		// /* Line 350 of lalr1.java */
		// /* Line 6723 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 749:
		// if (yyn == 749)
		// /* Line 350 of lalr1.java */
		// /* Line 6727 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 750:
		// if (yyn == 750)
		// /* Line 350 of lalr1.java */
		// /* Line 6728 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 751:
		// if (yyn == 751)
		// /* Line 350 of lalr1.java */
		// /* Line 6732 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 753:
		// if (yyn == 753)
		// /* Line 350 of lalr1.java */
		// /* Line 6737 of "sql_yacc.y" */
		// { Lex->type&= ~ NOT_NULL_FLAG; };
		// break;
		//
		//
		// case 754:
		// if (yyn == 754)
		// /* Line 350 of lalr1.java */
		// /* Line 6738 of "sql_yacc.y" */
		// { Lex->type|= NOT_NULL_FLAG; };
		// break;
		//
		//
		// case 755:
		// if (yyn == 755)
		// /* Line 350 of lalr1.java */
		// /* Line 6739 of "sql_yacc.y" */
		// { Lex->default_value=((item)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 756:
		// if (yyn == 756)
		// /* Line 350 of lalr1.java */
		// /* Line 6740 of "sql_yacc.y" */
		// { Lex->on_update_value= ((item)(yystack.valueAt (3-(3)))); };
		// break;
		//
		//
		// case 757:
		// if (yyn == 757)
		// /* Line 350 of lalr1.java */
		// /* Line 6741 of "sql_yacc.y" */
		// { Lex->type|= AUTO_INCREMENT_FLAG | NOT_NULL_FLAG; };
		// break;

		case 758:
		if (yyn == 758)
		/* Line 350 of lalr1.java */
		/* Line 6743 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->type|= AUTO_INCREMENT_FLAG | NOT_NULL_FLAG | UNIQUE_FLAG;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_INDEX);
		};
		break;

		case 759:
		if (yyn == 759)
		/* Line 350 of lalr1.java */
		/* Line 6749 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->type|= PRI_KEY_FLAG | NOT_NULL_FLAG;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_INDEX);
		};
		break;

		case 760:
		if (yyn == 760)
		/* Line 350 of lalr1.java */
		/* Line 6755 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->type|= UNIQUE_FLAG;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_INDEX);
		};
		break;

		case 761:
		if (yyn == 761)
		/* Line 350 of lalr1.java */
		/* Line 6761 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->type|= UNIQUE_KEY_FLAG;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_INDEX);
		};
		break;
		//
		//
		// case 762:
		// if (yyn == 762)
		// /* Line 350 of lalr1.java */
		// /* Line 6766 of "sql_yacc.y" */
		// { Lex->comment= ((lex_str)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 763:
		// if (yyn == 763)
		// /* Line 350 of lalr1.java */
		// /* Line 6768 of "sql_yacc.y" */
		// {
		// if (Lex->charset &&
		// !my_charset_same(Lex->charset,((charset)(yystack.valueAt (2-(2))))))
		// {
		// my_error(ER_COLLATION_CHARSET_MISMATCH, MYF(0),
		// ((charset)(yystack.valueAt (2-(2))))->name,Lex->charset->csname);
		// return YYABORT;
		// }
		// else
		// {
		// Lex->charset=((charset)(yystack.valueAt (2-(2))));
		// }
		// };
		// break;
		//
		//
		// case 764:
		// if (yyn == 764)
		// /* Line 350 of lalr1.java */
		// /* Line 6781 of "sql_yacc.y" */
		// {
		// Lex->type&= ~(FIELD_FLAGS_COLUMN_FORMAT_MASK);
		// Lex->type|=
		// (COLUMN_FORMAT_TYPE_DEFAULT << FIELD_FLAGS_COLUMN_FORMAT);
		// };
		// break;
		//
		//
		// case 765:
		// if (yyn == 765)
		// /* Line 350 of lalr1.java */
		// /* Line 6787 of "sql_yacc.y" */
		// {
		// Lex->type&= ~(FIELD_FLAGS_COLUMN_FORMAT_MASK);
		// Lex->type|=
		// (COLUMN_FORMAT_TYPE_FIXED << FIELD_FLAGS_COLUMN_FORMAT);
		// };
		// break;
		//
		//
		// case 766:
		// if (yyn == 766)
		// /* Line 350 of lalr1.java */
		// /* Line 6793 of "sql_yacc.y" */
		// {
		// Lex->type&= ~(FIELD_FLAGS_COLUMN_FORMAT_MASK);
		// Lex->type|=
		// (COLUMN_FORMAT_TYPE_DYNAMIC << FIELD_FLAGS_COLUMN_FORMAT);
		// };
		// break;
		//
		//
		// case 767:
		// if (yyn == 767)
		// /* Line 350 of lalr1.java */
		// /* Line 6799 of "sql_yacc.y" */
		// {
		// Lex->type&= ~(FIELD_FLAGS_STORAGE_MEDIA_MASK);
		// Lex->type|= (HA_SM_DEFAULT << FIELD_FLAGS_STORAGE_MEDIA);
		// };
		// break;
		//
		//
		// case 768:
		// if (yyn == 768)
		// /* Line 350 of lalr1.java */
		// /* Line 6804 of "sql_yacc.y" */
		// {
		// Lex->type&= ~(FIELD_FLAGS_STORAGE_MEDIA_MASK);
		// Lex->type|= (HA_SM_DISK << FIELD_FLAGS_STORAGE_MEDIA);
		// };
		// break;
		//
		//
		// case 769:
		// if (yyn == 769)
		// /* Line 350 of lalr1.java */
		// /* Line 6809 of "sql_yacc.y" */
		// {
		// Lex->type&= ~(FIELD_FLAGS_STORAGE_MEDIA_MASK);
		// Lex->type|= (HA_SM_MEMORY << FIELD_FLAGS_STORAGE_MEDIA);
		// };
		// break;
		//
		//
		// case 770:
		// if (yyn == 770)
		// /* Line 350 of lalr1.java */
		// /* Line 6818 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (2-(1))));
		//
		// if (Lex->charset) /* Lex->charset is scanned in "type" */
		// {
		// if (!(Lex->charset= merge_charset_and_collation(Lex->charset,
		// ((charset)(yystack.valueAt (2-(2)))))))
		// return YYABORT;
		// }
		// else if (((charset)(yystack.valueAt (2-(2)))))
		// {
		// my_error(ER_NOT_SUPPORTED_YET, MYF(0),
		// "COLLATE with no CHARACTER SET "
		// "in SP parameters, RETURNS, DECLARE");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 771:
		// if (yyn == 771)
		// /* Line 350 of lalr1.java */
		// /* Line 6839 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_now_local(((ulong_num)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 773:
		// if (yyn == 773)
		// /* Line 350 of lalr1.java */
		// /* Line 6848 of "sql_yacc.y" */
		// { yyval=((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 774:
		// if (yyn == 774)
		// /* Line 350 of lalr1.java */
		// /* Line 6852 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 775:
		// if (yyn == 775)
		// /* Line 350 of lalr1.java */
		// /* Line 6853 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 776:
		// if (yyn == 776)
		// /* Line 350 of lalr1.java */
		// /* Line 6858 of "sql_yacc.y" */
		// {
		// if (!(yyval=get_charset_by_csname(((lex_str)(yystack.valueAt
		// (1-(1)))).str,MY_CS_PRIMARY,MYF(0))))
		// {
		// my_error(ER_UNKNOWN_CHARACTER_SET, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 777:
		// if (yyn == 777)
		// /* Line 350 of lalr1.java */
		// /* Line 6865 of "sql_yacc.y" */
		// { yyval= &my_charset_bin; };
		// break;
		//
		//
		// case 778:
		// if (yyn == 778)
		// /* Line 350 of lalr1.java */
		// /* Line 6869 of "sql_yacc.y" */
		// { yyval=((charset)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 779:
		// if (yyn == 779)
		// /* Line 350 of lalr1.java */
		// /* Line 6870 of "sql_yacc.y" */
		// { yyval=NULL; };
		// break;
		//
		//
		// case 780:
		// if (yyn == 780)
		// /* Line 350 of lalr1.java */
		// /* Line 6874 of "sql_yacc.y" */
		// { yyval= NULL; };
		// break;
		//
		//
		// case 781:
		// if (yyn == 781)
		// /* Line 350 of lalr1.java */
		// /* Line 6875 of "sql_yacc.y" */
		// { yyval= ((charset)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 782:
		// if (yyn == 782)
		// /* Line 350 of lalr1.java */
		// /* Line 6880 of "sql_yacc.y" */
		// {
		// if (!(yyval=get_charset_by_csname(((lex_str)(yystack.valueAt
		// (1-(1)))).str,MY_CS_PRIMARY,MYF(0))) &&
		// !(yyval=get_old_charset_by_name(((lex_str)(yystack.valueAt
		// (1-(1)))).str)))
		// {
		// my_error(ER_UNKNOWN_CHARACTER_SET, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 783:
		// if (yyn == 783)
		// /* Line 350 of lalr1.java */
		// /* Line 6888 of "sql_yacc.y" */
		// { yyval= &my_charset_bin; };
		// break;
		//
		//
		// case 784:
		// if (yyn == 784)
		// /* Line 350 of lalr1.java */
		// /* Line 6892 of "sql_yacc.y" */
		// { yyval=((charset)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 785:
		// if (yyn == 785)
		// /* Line 350 of lalr1.java */
		// /* Line 6893 of "sql_yacc.y" */
		// { yyval=NULL; };
		// break;
		//
		//
		// case 786:
		// if (yyn == 786)
		// /* Line 350 of lalr1.java */
		// /* Line 6898 of "sql_yacc.y" */
		// {
		// if (!(yyval= mysqld_collation_get_by_name(((lex_str)(yystack.valueAt
		// (1-(1)))).str)))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 787:
		// if (yyn == 787)
		// /* Line 350 of lalr1.java */
		// /* Line 6905 of "sql_yacc.y" */
		// { yyval=NULL; };
		// break;
		//
		//
		// case 788:
		// if (yyn == 788)
		// /* Line 350 of lalr1.java */
		// /* Line 6906 of "sql_yacc.y" */
		// { yyval=((charset)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 789:
		// if (yyn == 789)
		// /* Line 350 of lalr1.java */
		// /* Line 6910 of "sql_yacc.y" */
		// { yyval=((charset)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 790:
		// if (yyn == 790)
		// /* Line 350 of lalr1.java */
		// /* Line 6911 of "sql_yacc.y" */
		// { yyval=NULL; };
		// break;
		//
		//
		// case 791:
		// if (yyn == 791)
		// /* Line 350 of lalr1.java */
		// /* Line 6915 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 792:
		// if (yyn == 792)
		// /* Line 350 of lalr1.java */
		// /* Line 6916 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 793:
		// if (yyn == 793)
		// /* Line 350 of lalr1.java */
		// /* Line 6921 of "sql_yacc.y" */
		// { Lex->charset= &my_charset_latin1; };
		// break;
		//
		//
		// case 794:
		// if (yyn == 794)
		// /* Line 350 of lalr1.java */
		// /* Line 6923 of "sql_yacc.y" */
		// {
		// Lex->charset= &my_charset_latin1_bin;
		// };
		// break;
		//
		//
		// case 795:
		// if (yyn == 795)
		// /* Line 350 of lalr1.java */
		// /* Line 6927 of "sql_yacc.y" */
		// {
		// Lex->charset= &my_charset_latin1_bin;
		// };
		// break;
		//
		//
		// case 796:
		// if (yyn == 796)
		// /* Line 350 of lalr1.java */
		// /* Line 6934 of "sql_yacc.y" */
		// {
		// if (!(Lex->charset=get_charset_by_csname("ucs2",
		// MY_CS_PRIMARY,MYF(0))))
		// {
		// my_error(ER_UNKNOWN_CHARACTER_SET, MYF(0), "ucs2");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 797:
		// if (yyn == 797)
		// /* Line 350 of lalr1.java */
		// /* Line 6943 of "sql_yacc.y" */
		// {
		// if (!(Lex->charset= mysqld_collation_get_by_name("ucs2_bin")))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 798:
		// if (yyn == 798)
		// /* Line 350 of lalr1.java */
		// /* Line 6948 of "sql_yacc.y" */
		// {
		// if (!(Lex->charset= mysqld_collation_get_by_name("ucs2_bin")))
		// my_error(ER_UNKNOWN_COLLATION, MYF(0), "ucs2_bin");
		// };
		// break;
		//
		//
		// case 799:
		// if (yyn == 799)
		// /* Line 350 of lalr1.java */
		// /* Line 6955 of "sql_yacc.y" */
		// { Lex->charset=NULL; };
		// break;
		//
		//
		// case 802:
		// if (yyn == 802)
		// /* Line 350 of lalr1.java */
		// /* Line 6958 of "sql_yacc.y" */
		// { Lex->charset=&my_charset_bin; };
		// break;
		//
		//
		// case 803:
		// if (yyn == 803)
		// /* Line 350 of lalr1.java */
		// /* Line 6959 of "sql_yacc.y" */
		// { Lex->charset=((charset)(yystack.valueAt (3-(2)))); };
		// break;
		//
		//
		// case 804:
		// if (yyn == 804)
		// /* Line 350 of lalr1.java */
		// /* Line 6961 of "sql_yacc.y" */
		// {
		// Lex->charset= NULL;
		// Lex->type|= BINCMP_FLAG;
		// };
		// break;
		//
		//
		// case 805:
		// if (yyn == 805)
		// /* Line 350 of lalr1.java */
		// /* Line 6966 of "sql_yacc.y" */
		// {
		// Lex->charset= ((charset)(yystack.valueAt (3-(3))));
		// Lex->type|= BINCMP_FLAG;
		// };
		// break;
		//
		//
		// case 806:
		// if (yyn == 806)
		// /* Line 350 of lalr1.java */
		// /* Line 6973 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 807:
		// if (yyn == 807)
		// /* Line 350 of lalr1.java */
		// /* Line 6974 of "sql_yacc.y" */
		// { Lex->type|= BINCMP_FLAG; };
		// break;
		//
		//
		case 808:
			if (yyn == 808)
			/* Line 350 of lalr1.java */
			/* Line 6979 of "sql_yacc.y" */
			{
				// if (((ulong_num)(yystack.valueAt (2-(2)))) == 0)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		// case 809:
		// if (yyn == 809)
		// /* Line 350 of lalr1.java */
		// /* Line 6987 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (4-(2)))); };
		// break;
		//
		//
		// case 810:
		// if (yyn == 810)
		// /* Line 350 of lalr1.java */
		// /* Line 6991 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 811:
		// if (yyn == 811)
		// /* Line 350 of lalr1.java */
		// /* Line 6992 of "sql_yacc.y" */
		// { yyval= 1 << MY_STRXFRM_DESC_SHIFT; };
		// break;
		//
		//
		// case 812:
		// if (yyn == 812)
		// /* Line 350 of lalr1.java */
		// /* Line 6996 of "sql_yacc.y" */
		// { yyval= 1 << MY_STRXFRM_REVERSE_SHIFT; };
		// break;
		//
		//
		// case 813:
		// if (yyn == 813)
		// /* Line 350 of lalr1.java */
		// /* Line 6999 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 814:
		// if (yyn == 814)
		// /* Line 350 of lalr1.java */
		// /* Line 7000 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 815:
		// if (yyn == 815)
		// /* Line 350 of lalr1.java */
		// /* Line 7001 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (2-(1)))) |
		// ((ulong_num)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 816:
		// if (yyn == 816)
		// /* Line 350 of lalr1.java */
		// /* Line 7002 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (1-(1)))) ; };
		// break;
		//
		//
		// case 817:
		// if (yyn == 817)
		// /* Line 350 of lalr1.java */
		// /* Line 7007 of "sql_yacc.y" */
		// {
		// yyval= ((ulong_num)(yystack.valueAt (1-(1)))) < 1 ? 1 :
		// (((ulong_num)(yystack.valueAt (1-(1)))) > MY_STRXFRM_NLEVELS ?
		// MY_STRXFRM_NLEVELS : ((ulong_num)(yystack.valueAt (1-(1)))));
		// yyval--;
		// };
		// break;
		//
		//
		// case 818:
		// if (yyn == 818)
		// /* Line 350 of lalr1.java */
		// /* Line 7015 of "sql_yacc.y" */
		// {
		// yyval= (1 | ((ulong_num)(yystack.valueAt (2-(2))))) <<
		// ((ulong_num)(yystack.valueAt (2-(1))));
		// };
		// break;
		//
		//
		// case 819:
		// if (yyn == 819)
		// /* Line 350 of lalr1.java */
		// /* Line 7021 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 820:
		// if (yyn == 820)
		// /* Line 350 of lalr1.java */
		// /* Line 7022 of "sql_yacc.y" */
		// { yyval|= ((ulong_num)(yystack.valueAt (3-(3)))); };
		// break;
		//
		//
		// case 821:
		// if (yyn == 821)
		// /* Line 350 of lalr1.java */
		// /* Line 7027 of "sql_yacc.y" */
		// {
		// uint start= ((ulong_num)(yystack.valueAt (3-(1))));
		// uint end= ((ulong_num)(yystack.valueAt (3-(3))));
		// for (yyval= 0; start <= end; start++)
		// yyval|= (1 << start);
		// };
		// break;
		//
		//
		// case 822:
		// if (yyn == 822)
		// /* Line 350 of lalr1.java */
		// /* Line 7036 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 823:
		// if (yyn == 823)
		// /* Line 350 of lalr1.java */
		// /* Line 7037 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 824:
		// if (yyn == 824)
		// /* Line 350 of lalr1.java */
		// /* Line 7041 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 825:
		// if (yyn == 825)
		// /* Line 350 of lalr1.java */
		// /* Line 7042 of "sql_yacc.y" */
		// { yyval= ((ulong_num)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 828:
		// if (yyn == 828)
		// /* Line 350 of lalr1.java */
		// /* Line 7056 of "sql_yacc.y" */
		// {
		// yyval=((table)(yystack.valueAt (5-(2))));
		// };
		// break;
		//
		//
		// case 829:
		// if (yyn == 829)
		// /* Line 350 of lalr1.java */
		// /* Line 7063 of "sql_yacc.y" */
		// { Lex->ref_list.empty(); };
		// break;
		//
		//
		// case 831:
		// if (yyn == 831)
		// /* Line 350 of lalr1.java */
		// /* Line 7069 of "sql_yacc.y" */
		// {
		// Key_part_spec *key= new Key_part_spec(((lex_str)(yystack.valueAt
		// (3-(3)))), 0);
		// if (key == NULL)
		// return YYABORT;
		// Lex->ref_list.push_back(key);
		// };
		// break;
		//
		//
		// case 832:
		// if (yyn == 832)
		// /* Line 350 of lalr1.java */
		// /* Line 7076 of "sql_yacc.y" */
		// {
		// Key_part_spec *key= new Key_part_spec(((lex_str)(yystack.valueAt
		// (1-(1)))), 0);
		// if (key == NULL)
		// return YYABORT;
		// LEX *lex= Lex;
		// lex->ref_list.empty();
		// lex->ref_list.push_back(key);
		// };
		// break;
		//
		//
		// case 833:
		// if (yyn == 833)
		// /* Line 350 of lalr1.java */
		// /* Line 7088 of "sql_yacc.y" */
		// { Lex->fk_match_option= Foreign_key::FK_MATCH_UNDEF; };
		// break;
		//
		//
		// case 834:
		// if (yyn == 834)
		// /* Line 350 of lalr1.java */
		// /* Line 7090 of "sql_yacc.y" */
		// { Lex->fk_match_option= Foreign_key::FK_MATCH_FULL; };
		// break;
		//
		//
		// case 835:
		// if (yyn == 835)
		// /* Line 350 of lalr1.java */
		// /* Line 7092 of "sql_yacc.y" */
		// { Lex->fk_match_option= Foreign_key::FK_MATCH_PARTIAL; };
		// break;
		//
		//
		// case 836:
		// if (yyn == 836)
		// /* Line 350 of lalr1.java */
		// /* Line 7094 of "sql_yacc.y" */
		// { Lex->fk_match_option= Foreign_key::FK_MATCH_SIMPLE; };
		// break;
		//
		//
		// case 837:
		// if (yyn == 837)
		// /* Line 350 of lalr1.java */
		// /* Line 7099 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->fk_update_opt= Foreign_key::FK_OPTION_UNDEF;
		// lex->fk_delete_opt= Foreign_key::FK_OPTION_UNDEF;
		// };
		// break;
		//
		//
		// case 838:
		// if (yyn == 838)
		// /* Line 350 of lalr1.java */
		// /* Line 7105 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->fk_update_opt= ((m_fk_option)(yystack.valueAt (3-(3))));
		// lex->fk_delete_opt= Foreign_key::FK_OPTION_UNDEF;
		// };
		// break;
		//
		//
		// case 839:
		// if (yyn == 839)
		// /* Line 350 of lalr1.java */
		// /* Line 7111 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->fk_update_opt= Foreign_key::FK_OPTION_UNDEF;
		// lex->fk_delete_opt= ((m_fk_option)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 840:
		// if (yyn == 840)
		// /* Line 350 of lalr1.java */
		// /* Line 7118 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->fk_update_opt= ((m_fk_option)(yystack.valueAt (6-(3))));
		// lex->fk_delete_opt= ((m_fk_option)(yystack.valueAt (6-(6))));
		// };
		// break;
		//
		//
		// case 841:
		// if (yyn == 841)
		// /* Line 350 of lalr1.java */
		// /* Line 7125 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->fk_update_opt= ((m_fk_option)(yystack.valueAt (6-(6))));
		// lex->fk_delete_opt= ((m_fk_option)(yystack.valueAt (6-(3))));
		// };
		// break;
		//
		//
		// case 842:
		// if (yyn == 842)
		// /* Line 350 of lalr1.java */
		// /* Line 7133 of "sql_yacc.y" */
		// { yyval= Foreign_key::FK_OPTION_RESTRICT; };
		// break;
		//
		//
		// case 843:
		// if (yyn == 843)
		// /* Line 350 of lalr1.java */
		// /* Line 7134 of "sql_yacc.y" */
		// { yyval= Foreign_key::FK_OPTION_CASCADE; };
		// break;
		//
		//
		// case 844:
		// if (yyn == 844)
		// /* Line 350 of lalr1.java */
		// /* Line 7135 of "sql_yacc.y" */
		// { yyval= Foreign_key::FK_OPTION_SET_NULL; };
		// break;
		//
		//
		// case 845:
		// if (yyn == 845)
		// /* Line 350 of lalr1.java */
		// /* Line 7136 of "sql_yacc.y" */
		// { yyval= Foreign_key::FK_OPTION_NO_ACTION; };
		// break;
		//
		//
		// case 846:
		// if (yyn == 846)
		// /* Line 350 of lalr1.java */
		// /* Line 7137 of "sql_yacc.y" */
		// { yyval= Foreign_key::FK_OPTION_DEFAULT; };
		// break;
		//
		//
		// case 847:
		// if (yyn == 847)
		// /* Line 350 of lalr1.java */
		// /* Line 7141 of "sql_yacc.y" */
		// { yyval= Key::MULTIPLE; };
		// break;
		//
		//
		// case 848:
		// if (yyn == 848)
		// /* Line 350 of lalr1.java */
		// /* Line 7145 of "sql_yacc.y" */
		// { yyval= Key::PRIMARY; };
		// break;
		//
		//
		// case 849:
		// if (yyn == 849)
		// /* Line 350 of lalr1.java */
		// /* Line 7146 of "sql_yacc.y" */
		// { yyval= Key::UNIQUE; };
		// break;
		//
		//
		// case 850:
		// if (yyn == 850)
		// /* Line 350 of lalr1.java */
		// /* Line 7150 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 851:
		// if (yyn == 851)
		// /* Line 350 of lalr1.java */
		// /* Line 7151 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 852:
		// if (yyn == 852)
		// /* Line 350 of lalr1.java */
		// /* Line 7155 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 854:
		// if (yyn == 854)
		// /* Line 350 of lalr1.java */
		// /* Line 7160 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 855:
		// if (yyn == 855)
		// /* Line 350 of lalr1.java */
		// /* Line 7161 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 856:
		// if (yyn == 856)
		// /* Line 350 of lalr1.java */
		// /* Line 7162 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 857:
		// if (yyn == 857)
		// /* Line 350 of lalr1.java */
		// /* Line 7166 of "sql_yacc.y" */
		// { yyval= Key::MULTIPLE; };
		// break;
		//
		//
		// case 858:
		// if (yyn == 858)
		// /* Line 350 of lalr1.java */
		// /* Line 7167 of "sql_yacc.y" */
		// { yyval= Key::UNIQUE; };
		// break;
		//
		//
		// case 859:
		// if (yyn == 859)
		// /* Line 350 of lalr1.java */
		// /* Line 7171 of "sql_yacc.y" */
		// { yyval= Key::FULLTEXT;};
		// break;
		//
		//
		// case 860:
		// if (yyn == 860)
		// /* Line 350 of lalr1.java */
		// /* Line 7176 of "sql_yacc.y" */
		// {
		// #ifdef HAVE_SPATIAL
		// yyval= Key::SPATIAL;
		// #else
		// my_error(ER_FEATURE_DISABLED, MYF(0),
		// sym_group_geom.name, sym_group_geom.needed_define);
		// return YYABORT;
		// #endif
		// };
		// break;
		//
		//
		// case 861:
		// if (yyn == 861)
		// /* Line 350 of lalr1.java */
		// /* Line 7188 of "sql_yacc.y" */
		// {
		// Lex->key_create_info= default_key_create_info;
		// };
		// break;
		//
		//
		// case 864:
		// if (yyn == 864)
		// /* Line 350 of lalr1.java */
		// /* Line 7205 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 866:
		// if (yyn == 866)
		// /* Line 350 of lalr1.java */
		// /* Line 7210 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 868:
		// if (yyn == 868)
		// /* Line 350 of lalr1.java */
		// /* Line 7215 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 876:
		// if (yyn == 876)
		// /* Line 350 of lalr1.java */
		// /* Line 7235 of "sql_yacc.y" */
		// { Lex->key_create_info.algorithm= ((key_alg)(yystack.valueAt
		// (2-(2)))); };
		// break;
		//
		//
		// case 877:
		// if (yyn == 877)
		// /* Line 350 of lalr1.java */
		// /* Line 7236 of "sql_yacc.y" */
		// { Lex->key_create_info.algorithm= ((key_alg)(yystack.valueAt
		// (2-(2)))); };
		// break;
		//
		//
		// case 878:
		// if (yyn == 878)
		// /* Line 350 of lalr1.java */
		// /* Line 7241 of "sql_yacc.y" */
		// { Lex->key_create_info.block_size= ((ulong_num)(yystack.valueAt
		// (3-(3)))); };
		// break;
		//
		//
		// case 879:
		// if (yyn == 879)
		// /* Line 350 of lalr1.java */
		// /* Line 7242 of "sql_yacc.y" */
		// { Lex->key_create_info.comment= ((lex_str)(yystack.valueAt (2-(2))));
		// };
		// break;
		//
		//
		// case 884:
		// if (yyn == 884)
		// /* Line 350 of lalr1.java */
		// /* Line 7257 of "sql_yacc.y" */
		// {
		// if (plugin_is_ready(&((lex_str)(yystack.valueAt (3-(3)))),
		// MYSQL_FTPARSER_PLUGIN))
		// Lex->key_create_info.parser_name= ((lex_str)(yystack.valueAt
		// (3-(3))));
		// else
		// {
		// my_error(ER_FUNCTION_NOT_DEFINED, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(3)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 885:
		// if (yyn == 885)
		// /* Line 350 of lalr1.java */
		// /* Line 7269 of "sql_yacc.y" */
		// { yyval= HA_KEY_ALG_BTREE; };
		// break;
		//
		//
		// case 886:
		// if (yyn == 886)
		// /* Line 350 of lalr1.java */
		// /* Line 7270 of "sql_yacc.y" */
		// { yyval= HA_KEY_ALG_RTREE; };
		// break;
		//
		//
		// case 887:
		// if (yyn == 887)
		// /* Line 350 of lalr1.java */
		// /* Line 7271 of "sql_yacc.y" */
		// { yyval= HA_KEY_ALG_HASH; };
		// break;
		//
		//
		// case 888:
		// if (yyn == 888)
		// /* Line 350 of lalr1.java */
		// /* Line 7275 of "sql_yacc.y" */
		// { Lex->col_list.push_back(((key_part)(yystack.valueAt (4-(3))))); };
		// break;
		//
		//
		// case 889:
		// if (yyn == 889)
		// /* Line 350 of lalr1.java */
		// /* Line 7276 of "sql_yacc.y" */
		// { Lex->col_list.push_back(((key_part)(yystack.valueAt (2-(1))))); };
		// break;
		//
		//
		// case 890:
		// if (yyn == 890)
		// /* Line 350 of lalr1.java */
		// /* Line 7281 of "sql_yacc.y" */
		// {
		// yyval= new Key_part_spec(((lex_str)(yystack.valueAt (1-(1)))), 0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 891:
		// if (yyn == 891)
		// /* Line 350 of lalr1.java */
		// /* Line 7287 of "sql_yacc.y" */
		// {
		// int key_part_len= atoi(((lex_str)(yystack.valueAt (4-(3)))).str);
		// if (!key_part_len)
		// {
		// my_error(ER_KEY_PART_0, MYF(0), ((lex_str)(yystack.valueAt
		// (4-(1)))).str);
		// }
		// yyval= new Key_part_spec(((lex_str)(yystack.valueAt (4-(1)))), (uint)
		// key_part_len);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 892:
		// if (yyn == 892)
		// /* Line 350 of lalr1.java */
		// /* Line 7300 of "sql_yacc.y" */
		// { yyval= null_lex_str; };
		// break;
		//
		//
		// case 893:
		// if (yyn == 893)
		// /* Line 350 of lalr1.java */
		// /* Line 7301 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 894:
		// if (yyn == 894)
		// /* Line 350 of lalr1.java */
		// /* Line 7305 of "sql_yacc.y" */
		// { yyval= null_lex_str; };
		// break;
		//
		//
		// case 895:
		// if (yyn == 895)
		// /* Line 350 of lalr1.java */
		// /* Line 7306 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 896:
		// if (yyn == 896)
		// /* Line 350 of lalr1.java */
		// /* Line 7310 of "sql_yacc.y" */
		// { Lex->interval_list.push_back(((string)(yystack.valueAt (1-(1)))));
		// };
		// break;
		//
		//
		// case 897:
		// if (yyn == 897)
		// /* Line 350 of lalr1.java */
		// /* Line 7311 of "sql_yacc.y" */
		// { Lex->interval_list.push_back(((string)(yystack.valueAt (3-(3)))));
		// };
		// break;

		case 898:
			if (yyn == 898)
			/* Line 350 of lalr1.java */
			/* Line 7319 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// lex->name.str= 0;
				// lex->name.length= 0;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_TABLE;
				// lex->duplicates= DUP_ERROR;
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(4 - (4)), null, null))
					return YYABORT;
				// lex->col_list.empty();
				// lex->select_lex.init_order();
				// lex->select_lex.db= (lex->select_lex.table_list.first)->db;
				// memset(&lex->create_info, 0, sizeof(lex->create_info));
				// lex->create_info.db_type= 0;
				// lex->create_info.default_table_charset= NULL;
				// lex->create_info.row_type= ROW_TYPE_NOT_USED;
				// lex->alter_info.reset();
				// lex->no_write_to_binlog= 0;
				// lex->create_info.storage_media= HA_SM_DEFAULT;
				// lex->create_last_non_select_table= lex->last_table();
				// DBUG_ASSERT(!lex->m_sql_cmd);
				// if (lex->ignore)
				// {
				// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
				// ER_WARN_DEPRECATED_SYNTAX_NO_REPLACEMENT,
				// ER(ER_WARN_DEPRECATED_SYNTAX_NO_REPLACEMENT),
				// "IGNORE");
				// }
			}
			;
			break;
		//
		//
		// case 899:
		// if (yyn == 899)
		// /* Line 350 of lalr1.java */
		// /* Line 7352 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// if (!lex->m_sql_cmd)
		// {
		// /* Create a generic ALTER TABLE statment. */
		// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_alter_table();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 900:
		// if (yyn == 900)
		// /* Line 350 of lalr1.java */
		// /* Line 7364 of "sql_yacc.y" */
		// {
		// Lex->create_info.default_table_charset= NULL;
		// Lex->create_info.used_fields= 0;
		// };
		// break;

		case 901:
			if (yyn == 901)
			/* Line 350 of lalr1.java */
			/* Line 7369 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_DB;
				// lex->name= ((lex_str)(yystack.valueAt (5-(3))));
				// if (lex->name.str == NULL &&
				// lex->copy_db_to(&lex->name.str, &lex->name.length))
				// return YYABORT;
			}
			;
			break;

		case 902:
			if (yyn == 902)
			/* Line 350 of lalr1.java */
			/* Line 7378 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_NO_DROP_SP, MYF(0), "DATABASE");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_DB_UPGRADE;
				// lex->name= ((lex_str)(yystack.valueAt (7-(3))));
			}
			;
			break;
		//
		//
		// case 903:
		// if (yyn == 903)
		// /* Line 350 of lalr1.java */
		// /* Line 7389 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_NO_DROP_SP, MYF(0), "PROCEDURE");
		// return YYABORT;
		// }
		// memset(&lex->sp_chistics, 0, sizeof(st_sp_chistics));
		// };
		// break;

		case 904:
			if (yyn == 904)
			/* Line 350 of lalr1.java */
			/* Line 7400 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_PROCEDURE;
				// lex->spname= ((spname)(yystack.valueAt (5-(3))));
			}
			;
			break;
		//
		//
		// case 905:
		// if (yyn == 905)
		// /* Line 350 of lalr1.java */
		// /* Line 7407 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_NO_DROP_SP, MYF(0), "FUNCTION");
		// return YYABORT;
		// }
		// memset(&lex->sp_chistics, 0, sizeof(st_sp_chistics));
		// };
		// break;

		case 906:
			if (yyn == 906)
			/* Line 350 of lalr1.java */
			/* Line 7418 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_FUNCTION;
				// lex->spname= ((spname)(yystack.valueAt (5-(3))));
			}
			;
			break;
		//
		//
		// case 907:
		// if (yyn == 907)
		// /* Line 350 of lalr1.java */
		// /* Line 7425 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_BADSTATEMENT, MYF(0), "ALTER VIEW");
		// return YYABORT;
		// }
		// lex->create_view_mode= VIEW_ALTER;
		// };
		// break;
		//
		//
		// case 908:
		// if (yyn == 908)
		// /* Line 350 of lalr1.java */
		// /* Line 7436 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 909:
		// if (yyn == 909)
		// /* Line 350 of lalr1.java */
		// /* Line 7443 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_BADSTATEMENT, MYF(0), "ALTER VIEW");
		// return YYABORT;
		// }
		// lex->create_view_algorithm= VIEW_ALGORITHM_UNDEFINED;
		// lex->create_view_mode= VIEW_ALTER;
		// };
		// break;
		//
		//
		// case 910:
		// if (yyn == 910)
		// /* Line 350 of lalr1.java */
		// /* Line 7455 of "sql_yacc.y" */
		// {};
		// break;

		case 911:
			if (yyn == 911)
			/* Line 350 of lalr1.java */
			/* Line 7457 of "sql_yacc.y" */
			{
				// /*
				// It is safe to use Lex->spname because
				// ALTER EVENT xxx RENATE TO yyy DO ALTER EVENT RENAME TO
				// is not allowed. Lex->spname is used in the case of RENAME TO
				// If it had to be supported spname had to be added to
				// Event_parse_data.
				// */
				//
				// if (!(Lex->event_parse_data=
				// Event_parse_data::new_instance(YYTHD)))
				// return YYABORT;
				// Lex->event_parse_data->identifier= ((spname)(yystack.valueAt
				// (4-(4))));
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_EVENT;
			}
			;
			break;
		//
		//
		case 912:
			if (yyn == 912)
			/* Line 350 of lalr1.java */
			/* Line 7477 of "sql_yacc.y" */
			{
				// if (!(((num)(yystack.valueAt (10-(6)))) ||
				// ((num)(yystack.valueAt
				// (10-(7)))) || ((num)(yystack.valueAt (10-(8)))) ||
				// ((num)(yystack.valueAt (10-(9)))) || ((num)(yystack.valueAt
				// (10-(10))))))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// /*
				// sqlCommand is set here because some rules in ev_sql_stmt
				// can overwrite it
				// */
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_EVENT;
			}
			;
			break;
		//
		//
		// case 913:
		// if (yyn == 913)
		// /* Line 350 of lalr1.java */
		// /* Line 7490 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_cmd_type= ALTER_TABLESPACE;
		// };
		// break;
		//
		//
		// case 914:
		// if (yyn == 914)
		// /* Line 350 of lalr1.java */
		// /* Line 7495 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_cmd_type= ALTER_LOGFILE_GROUP;
		// };
		// break;
		//
		//
		// case 915:
		// if (yyn == 915)
		// /* Line 350 of lalr1.java */
		// /* Line 7500 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_cmd_type= CHANGE_FILE_TABLESPACE;
		// };
		// break;
		//
		//
		// case 916:
		// if (yyn == 916)
		// /* Line 350 of lalr1.java */
		// /* Line 7505 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_cmd_type=
		// ALTER_ACCESS_MODE_TABLESPACE;
		// };
		// break;

		case 917:
			if (yyn == 917)
			/* Line 350 of lalr1.java */
			/* Line 7510 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_SERVER;
				// lex->server_options.server_name= ((lex_str)(yystack.valueAt
				// (7-(3)))).str;
				// lex->server_options.server_name_length=
				// ((lex_str)(yystack.valueAt
				// (7-(3)))).length;
			}
			;
			break;

		case 918:
			if (yyn == 918)
			/* Line 350 of lalr1.java */
			/* Line 7517 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ALTER_USER;
			}
			;
			break;
		//
		//
		// case 919:
		// if (yyn == 919)
		// /* Line 350 of lalr1.java */
		// /* Line 7524 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (3-(1))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 920:
		// if (yyn == 920)
		// /* Line 350 of lalr1.java */
		// /* Line 7529 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (5-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 921:
		// if (yyn == 921)
		// /* Line 350 of lalr1.java */
		// /* Line 7536 of "sql_yacc.y" */
		// { yyval= 0;};
		// break;
		//
		//
		// case 922:
		// if (yyn == 922)
		// /* Line 350 of lalr1.java */
		// /* Line 7537 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 923:
		// if (yyn == 923)
		// /* Line 350 of lalr1.java */
		// /* Line 7538 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 924:
		// if (yyn == 924)
		// /* Line 350 of lalr1.java */
		// /* Line 7539 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 925:
		// if (yyn == 925)
		// /* Line 350 of lalr1.java */
		// /* Line 7543 of "sql_yacc.y" */
		// { yyval= 0;};
		// break;
		//
		//
		// case 926:
		// if (yyn == 926)
		// /* Line 350 of lalr1.java */
		// /* Line 7545 of "sql_yacc.y" */
		// {
		// /*
		// Use lex's spname to hold the new name.
		// The original name is in the Event_parse_data object
		// */
		// Lex->spname= ((spname)(yystack.valueAt (3-(3))));
		// yyval= 1;
		// };
		// break;
		//
		//
		// case 927:
		// if (yyn == 927)
		// /* Line 350 of lalr1.java */
		// /* Line 7556 of "sql_yacc.y" */
		// { yyval= 0;};
		// break;
		//
		//
		// case 928:
		// if (yyn == 928)
		// /* Line 350 of lalr1.java */
		// /* Line 7557 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 929:
		// if (yyn == 929)
		// /* Line 350 of lalr1.java */
		// /* Line 7561 of "sql_yacc.y" */
		// { yyval.str= 0; yyval.length= 0; };
		// break;
		//
		//
		// case 930:
		// if (yyn == 930)
		// /* Line 350 of lalr1.java */
		// /* Line 7562 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 932:
		// if (yyn == 932)
		// /* Line 350 of lalr1.java */
		// /* Line 7568 of "sql_yacc.y" */
		// {
		// Lex->m_sql_cmd= new (YYTHD->mem_root)
		// Sql_cmd_discard_import_tablespace(
		// Sql_cmd_discard_import_tablespace::DISCARD_TABLESPACE);
		// if (Lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 933:
		// if (yyn == 933)
		// /* Line 350 of lalr1.java */
		// /* Line 7576 of "sql_yacc.y" */
		// {
		// Lex->m_sql_cmd= new (YYTHD->mem_root)
		// Sql_cmd_discard_import_tablespace(
		// Sql_cmd_discard_import_tablespace::IMPORT_TABLESPACE);
		// if (Lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;

		case 939:
		if (yyn == 939)
		/* Line 350 of lalr1.java */
		/* Line 7598 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_DROP_PARTITION);
		};
		break;

		case 940:
		if (yyn == 940)
		/* Line 350 of lalr1.java */
		/* Line 7603 of "sql_yacc.y" */
		{
		// LEX *lex= Lex;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_REBUILD_PARTITION);
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (4-(3))));
		};
		break;
		//
		//
		// case 941:
		// if (yyn == 941)
		// /* Line 350 of lalr1.java */
		// /* Line 7610 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (4-(3))));
		// lex->check_opt.init();
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root)
		// Sql_cmd_alter_table_optimize_partition();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 943:
		// if (yyn == 943)
		// /* Line 350 of lalr1.java */
		// /* Line 7624 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (4-(3))));
		// lex->check_opt.init();
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root)
		// Sql_cmd_alter_table_analyze_partition();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 944:
		// if (yyn == 944)
		// /* Line 350 of lalr1.java */
		// /* Line 7636 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->check_opt.init();
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root)
		// Sql_cmd_alter_table_check_partition();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 946:
		// if (yyn == 946)
		// /* Line 350 of lalr1.java */
		// /* Line 7649 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (4-(3))));
		// lex->check_opt.init();
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root)
		// Sql_cmd_alter_table_repair_partition();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;

		case 948:
		if (yyn == 948)
		/* Line 350 of lalr1.java */
		/* Line 7662 of "sql_yacc.y" */
		{
		// LEX *lex= Lex;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_COALESCE_PARTITION);
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (4-(3))));
		// lex->alter_info.num_parts= ((ulong_num)(yystack.valueAt (4-(4))));
		};
		break;
		//
		//
		// case 949:
		// if (yyn == 949)
		// /* Line 350 of lalr1.java */
		// /* Line 7669 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// lex->check_opt.init();
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root)
		// Sql_cmd_alter_table_truncate_partition();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;

		case 951:
			if (yyn == 951)
			/* Line 350 of lalr1.java */
			/* Line 7682 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// size_t dummy;
				// lex->select_lex.db=((table)(yystack.valueAt
				// (7-(6))))->db.str;
				// if (lex->select_lex.db == NULL &&
				// lex->copy_db_to(&lex->select_lex.db, &dummy))
				// {
				// return YYABORT;
				// }
				// lex->name= ((table)(yystack.valueAt (7-(6))))->table;
					thd.lex.alterInfo.flags.add(AlterFlag.ALTER_EXCHANGE_PARTITION);
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(7 - (6)), null, null))
					return YYABORT;
				// DBUG_ASSERT(!lex->m_sql_cmd);
				// lex->m_sql_cmd= new (thd->mem_root)
				// Sql_cmd_alter_table_exchange_partition();
				// if (lex->m_sql_cmd == NULL)
				// return YYABORT;
			}
			;
			break;

		case 952:
		if (yyn == 952)
		/* Line 350 of lalr1.java */
		/* Line 7709 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_REMOVE_PARTITIONING);
		};
		break;

		case 953:
		if (yyn == 953)
		/* Line 350 of lalr1.java */
		/* Line 7716 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ALL_PARTITION);
		};
		break;

		case 955:
		if (yyn == 955)
		/* Line 350 of lalr1.java */
		/* Line 7724 of "sql_yacc.y" */
		{
		// LEX *lex= Lex;
		// lex->part_info= new partition_info();
		// if (!lex->part_info)
		// {
		// mem_alloc_error(sizeof(partition_info));
		// return YYABORT;
		// }
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_PARTITION);
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (3-(3))));
		};
		break;
		//
		//
		// case 956:
		// if (yyn == 956)
		// /* Line 350 of lalr1.java */
		// /* Line 7736 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 958:
		// if (yyn == 958)
		// /* Line 350 of lalr1.java */
		// /* Line 7742 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->part_info->num_parts= lex->part_info->partitions.elements;
		// };
		// break;
		//
		//
		// case 959:
		// if (yyn == 959)
		// /* Line 350 of lalr1.java */
		// /* Line 7747 of "sql_yacc.y" */
		// {
		// Lex->part_info->num_parts= ((ulong_num)(yystack.valueAt (2-(2))));
		// };
		// break;
		//
		//
		// case 960:
		// if (yyn == 960)
		// /* Line 350 of lalr1.java */
		// /* Line 7754 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->part_info= new partition_info();
		// if (!lex->part_info)
		// {
		// mem_alloc_error(sizeof(partition_info));
		// return YYABORT;
		// }
		// lex->no_write_to_binlog= ((num)(yystack.valueAt (3-(3))));
		// };
		// break;

		case 962:
		if (yyn == 962)
		/* Line 350 of lalr1.java */
		/* Line 7769 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_TABLE_REORG);
		};
		break;

		case 963:
		if (yyn == 963)
		/* Line 350 of lalr1.java */
		/* Line 7773 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_REORGANIZE_PARTITION);
		};
		break;
		//
		//
		// case 964:
		// if (yyn == 964)
		// /* Line 350 of lalr1.java */
		// /* Line 7777 of "sql_yacc.y" */
		// {
		// partition_info *part_info= Lex->part_info;
		// part_info->num_parts= part_info->partitions.elements;
		// };
		// break;
		//
		//
		// case 965:
		// if (yyn == 965)
		// /* Line 350 of lalr1.java */
		// /* Line 7784 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 966:
		// if (yyn == 966)
		// /* Line 350 of lalr1.java */
		// /* Line 7785 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 967:
		// if (yyn == 967)
		// /* Line 350 of lalr1.java */
		// /* Line 7790 of "sql_yacc.y" */
		// {
		// if
		// (Lex->alter_info.partition_names.push_back(((lex_str)(yystack.valueAt
		// (1-(1)))).str))
		// {
		// mem_alloc_error(1);
		// return YYABORT;
		// }
		// };
		// break;

		case 970:
		if (yyn == 970)
		/* Line 350 of lalr1.java */
		/* Line 7810 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->change=0;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_COLUMN);
		};
		break;
		//
		//
		// case 971:
		// if (yyn == 971)
		// /* Line 350 of lalr1.java */
		// /* Line 7819 of "sql_yacc.y" */
		// {
		// Lex->create_last_non_select_table= Lex->last_table();
		// };
		// break;

		case 972:
		if (yyn == 972)
		/* Line 350 of lalr1.java */
		/* Line 7823 of "sql_yacc.y" */
		{
		// Lex->create_last_non_select_table= Lex->last_table();
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_INDEX);
		};
		break;

		case 973:
		if (yyn == 973)
		/* Line 350 of lalr1.java */
		/* Line 7828 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_COLUMN);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADD_INDEX);
		};
		break;

		case 974:
		if (yyn == 974)
		/* Line 350 of lalr1.java */
		/* Line 7833 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->change= ((lex_str)(yystack.valueAt (3-(3)))).str;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_CHANGE_COLUMN);
		};
		break;
		//
		//
		// case 975:
		// if (yyn == 975)
		// /* Line 350 of lalr1.java */
		// /* Line 7839 of "sql_yacc.y" */
		// {
		// Lex->create_last_non_select_table= Lex->last_table();
		// };
		// break;

		case 976:
		if (yyn == 976)
		/* Line 350 of lalr1.java */
		/* Line 7843 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->length=lex->dec=0; lex->type=0;
		// lex->default_value= lex->on_update_value= 0;
		// lex->comment=null_lex_str;
		// lex->charset= NULL;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_CHANGE_COLUMN);
		};
		break;
		//
		//
		// case 977:
		// if (yyn == 977)
		// /* Line 350 of lalr1.java */
		// /* Line 7852 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (add_field_to_list(lex->thd,&((lex_str)(yystack.valueAt (6-(3)))),
		// (enum enum_field_types) ((num)(yystack.valueAt (6-(5)))),
		// lex->length,lex->dec,lex->type,
		// lex->default_value, lex->on_update_value,
		// &lex->comment,
		// ((lex_str)(yystack.valueAt (6-(3)))).str, &lex->interval_list,
		// lex->charset,
		// lex->uint_geom_type))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 978:
		// if (yyn == 978)
		// /* Line 350 of lalr1.java */
		// /* Line 7864 of "sql_yacc.y" */
		// {
		// Lex->create_last_non_select_table= Lex->last_table();
		// };
		// break;

		case 979:
		if (yyn == 979)
		/* Line 350 of lalr1.java */
		/* Line 7868 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Alter_drop *ad= new Alter_drop(Alter_drop::COLUMN,
		// ((lex_str)(yystack.valueAt (4-(3)))).str);
		// if (ad == NULL)
		// return YYABORT;
		// lex->alter_info.drop_list.push_back(ad);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_DROP_COLUMN);
		};
		break;

		case 980:
		if (yyn == 980)
		/* Line 350 of lalr1.java */
		/* Line 7877 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Alter_drop *ad= new Alter_drop(Alter_drop::FOREIGN_KEY,
		// ((lex_str)(yystack.valueAt (4-(4)))).str);
		// if (ad == NULL)
		// return YYABORT;
		// lex->alter_info.drop_list.push_back(ad);
			thd.lex.alterInfo.flags.add(AlterFlag.DROP_FOREIGN_KEY);
		};
		break;

		case 981:
		if (yyn == 981)
		/* Line 350 of lalr1.java */
		/* Line 7886 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Alter_drop *ad= new Alter_drop(Alter_drop::KEY, primary_key_name);
		// if (ad == NULL)
		// return YYABORT;
		// lex->alter_info.drop_list.push_back(ad);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_DROP_INDEX);
		};
		break;

		case 982:
		if (yyn == 982)
		/* Line 350 of lalr1.java */
		/* Line 7895 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Alter_drop *ad= new Alter_drop(Alter_drop::KEY,
		// ((lex_str)(yystack.valueAt (3-(3)))).str);
		// if (ad == NULL)
		// return YYABORT;
		// lex->alter_info.drop_list.push_back(ad);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_DROP_INDEX);
		};
		break;

		case 983:
		if (yyn == 983)
		/* Line 350 of lalr1.java */
		/* Line 7904 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->alter_info.keys_onoff= Alter_info::DISABLE;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_KEYS_ONOFF);
		};
		break;

		case 984:
		if (yyn == 984)
		/* Line 350 of lalr1.java */
		/* Line 7910 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// lex->alter_info.keys_onoff= Alter_info::ENABLE;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_KEYS_ONOFF);
		};
		break;

		case 985:
		if (yyn == 985)
		/* Line 350 of lalr1.java */
		/* Line 7916 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Alter_column *ac= new Alter_column(((lex_str)(yystack.valueAt
		// (6-(3)))).str,((item)(yystack.valueAt (6-(6)))));
		// if (ac == NULL)
		// return YYABORT;
		// lex->alter_info.alter_list.push_back(ac);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_CHANGE_COLUMN_DEFAULT);
		};
		break;

		case 986:
		if (yyn == 986)
		/* Line 350 of lalr1.java */
		/* Line 7925 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// Alter_column *ac= new Alter_column(((lex_str)(yystack.valueAt
		// (5-(3)))).str, (Item*) 0);
		// if (ac == NULL)
		// return YYABORT;
		// lex->alter_info.alter_list.push_back(ac);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_CHANGE_COLUMN_DEFAULT);
		};
		break;

		case 987:
		if (yyn == 987)
		/* Line 350 of lalr1.java */
		/* Line 7934 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
		// size_t dummy;
		// lex->select_lex.db=((table)(yystack.valueAt (3-(3))))->db.str;
		// if (lex->select_lex.db == NULL &&
		// lex->copy_db_to(&lex->select_lex.db, &dummy))
		// {
		// return YYABORT;
		// }
		// enum_ident_name_check ident_check_status=
		// check_table_name(((table)(yystack.valueAt
		// (3-(3))))->table.str,((table)(yystack.valueAt
		// (3-(3))))->table.length, FALSE);
		// if (ident_check_status == IDENT_NAME_WRONG)
		// {
		// my_error(ER_WRONG_TABLE_NAME, MYF(0), ((table)(yystack.valueAt
		// (3-(3))))->table.str);
		// return YYABORT;
		// }
		// else if (ident_check_status == IDENT_NAME_TOO_LONG)
		// {
		// my_error(ER_TOO_LONG_IDENT, MYF(0), ((table)(yystack.valueAt
		// (3-(3))))->table.str);
		// return YYABORT;
		// }
		// if (((table)(yystack.valueAt (3-(3))))->db.str &&
		// (check_and_convert_db_name(&((table)(yystack.valueAt (3-(3))))->db,
		// FALSE) != IDENT_NAME_OK))
		// return YYABORT;
		// lex->name= ((table)(yystack.valueAt (3-(3))))->table;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_RENAME);
		};
		break;

		case 988:
		if (yyn == 988)
		/* Line 350 of lalr1.java */
		/* Line 7962 of "sql_yacc.y" */
		{
		// if (!((charset)(yystack.valueAt (5-(4)))))
		// {
		// THD *thd= YYTHD;
		// ((charset)(yystack.valueAt (5-(4))))=
		// thd->variables.collation_database;
		// }
		// ((charset)(yystack.valueAt (5-(5))))= ((charset)(yystack.valueAt
		// (5-(5)))) ? ((charset)(yystack.valueAt (5-(5)))) :
		// ((charset)(yystack.valueAt (5-(4))));
		// if (!my_charset_same(((charset)(yystack.valueAt
		// (5-(4)))),((charset)(yystack.valueAt (5-(5))))))
		// {
		// my_error(ER_COLLATION_CHARSET_MISMATCH, MYF(0),
		// ((charset)(yystack.valueAt (5-(5))))->name,
		// ((charset)(yystack.valueAt (5-(4))))->csname);
		// return YYABORT;
		// }
		// LEX *lex= Lex;
		// lex->create_info.table_charset=
		// lex->create_info.default_table_charset= ((charset)(yystack.valueAt
		// (5-(5))));
		// lex->create_info.used_fields|= (HA_CREATE_USED_CHARSET |
		// HA_CREATE_USED_DEFAULT_CHARSET);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_OPTIONS);
		};
		break;

		case 989:
		if (yyn == 989)
		/* Line 350 of lalr1.java */
		/* Line 7983 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_OPTIONS);
		// if ((lex->create_info.used_fields & HA_CREATE_USED_ENGINE) &&
		// !lex->create_info.db_type)
		// {
		// lex->create_info.used_fields&= ~HA_CREATE_USED_ENGINE;
		// }
		};
		break;

		case 990:
		if (yyn == 990)
		/* Line 350 of lalr1.java */
		/* Line 7993 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_RECREATE);
		};
		break;

		case 991:
		if (yyn == 991)
		/* Line 350 of lalr1.java */
		/* Line 7997 of "sql_yacc.y" */
		{
		// LEX *lex=Lex;
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ORDER);
		};
		break;
		//
		//
		// case 999:
		// if (yyn == 999)
		// /* Line 350 of lalr1.java */
		// /* Line 8014 of "sql_yacc.y" */
		// {
		// Lex->alter_info.requested_algorithm=
		// Alter_info::ALTER_TABLE_ALGORITHM_DEFAULT;
		// };
		// break;
		//
		//
		// case 1000:
		// if (yyn == 1000)
		// /* Line 350 of lalr1.java */
		// /* Line 8019 of "sql_yacc.y" */
		// {
		// if
		// (Lex->alter_info.set_requested_algorithm(&((lex_str)(yystack.valueAt
		// (3-(3))))))
		// {
		// my_error(ER_UNKNOWN_ALTER_ALGORITHM, MYF(0),
		// ((lex_str)(yystack.valueAt (3-(3)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1001:
		// if (yyn == 1001)
		// /* Line 350 of lalr1.java */
		// /* Line 8030 of "sql_yacc.y" */
		// {
		// Lex->alter_info.requested_lock=
		// Alter_info::ALTER_TABLE_LOCK_DEFAULT;
		// };
		// break;
		//
		//
		// case 1002:
		// if (yyn == 1002)
		// /* Line 350 of lalr1.java */
		// /* Line 8035 of "sql_yacc.y" */
		// {
		// if (Lex->alter_info.set_requested_lock(&((lex_str)(yystack.valueAt
		// (3-(3))))))
		// {
		// my_error(ER_UNKNOWN_ALTER_LOCK, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(3)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1003:
		// if (yyn == 1003)
		// /* Line 350 of lalr1.java */
		// /* Line 8045 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1004:
		// if (yyn == 1004)
		// /* Line 350 of lalr1.java */
		// /* Line 8046 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1005:
		// if (yyn == 1005)
		// /* Line 350 of lalr1.java */
		// /* Line 8050 of "sql_yacc.y" */
		// { Lex->ignore= 0;};
		// break;
		//
		//
		// case 1006:
		// if (yyn == 1006)
		// /* Line 350 of lalr1.java */
		// /* Line 8051 of "sql_yacc.y" */
		// { Lex->ignore= 1;};
		// break;
		//
		//
		// case 1007:
		// if (yyn == 1007)
		// /* Line 350 of lalr1.java */
		// /* Line 8055 of "sql_yacc.y" */
		// { Lex->drop_mode= DROP_DEFAULT; };
		// break;
		//
		//
		// case 1008:
		// if (yyn == 1008)
		// /* Line 350 of lalr1.java */
		// /* Line 8056 of "sql_yacc.y" */
		// { Lex->drop_mode= DROP_RESTRICT; };
		// break;
		//
		//
		// case 1009:
		// if (yyn == 1009)
		// /* Line 350 of lalr1.java */
		// /* Line 8057 of "sql_yacc.y" */
		// { Lex->drop_mode= DROP_CASCADE; };
		// break;
		//
		//
		// case 1010:
		// if (yyn == 1010)
		// /* Line 350 of lalr1.java */
		// /* Line 8061 of "sql_yacc.y" */
		// {};
		// break;

		case 1011:
		if (yyn == 1011)
		/* Line 350 of lalr1.java */
		/* Line 8063 of "sql_yacc.y" */
		{
		// store_position_for_column(((lex_str)(yystack.valueAt (2-(2)))).str);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_COLUMN_ORDER);
		};
		break;

		case 1012:
		if (yyn == 1012)
		/* Line 350 of lalr1.java */
		/* Line 8068 of "sql_yacc.y" */
		{
		// store_position_for_column(first_keyword);
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_COLUMN_ORDER);
		};
		break;
		//
		//
		// case 1013:
		// if (yyn == 1013)
		// /* Line 350 of lalr1.java */
		// /* Line 8075 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1014:
		// if (yyn == 1014)
		// /* Line 350 of lalr1.java */
		// /* Line 8076 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1015:
		// if (yyn == 1015)
		// /* Line 350 of lalr1.java */
		// /* Line 8077 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1016:
		// if (yyn == 1016)
		// /* Line 350 of lalr1.java */
		// /* Line 8078 of "sql_yacc.y" */
		// {};
		// break;

		case 1017:
			if (yyn == 1017)
			/* Line 350 of lalr1.java */
			/* Line 8083 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// /* Clean previous slave connection values */
				// lex->slave_connection.reset();
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SLAVE_START;
				// lex->type = 0;
				// /* We'll use mi structure for UNTIL options */
				// lex->mi.set_unspecified();
				// lex->slave_thd_opt= ((num)(yystack.valueAt (3-(3))));
			}
			;
			break;
		//
		//
		// case 1018:
		// if (yyn == 1018)
		// /* Line 350 of lalr1.java */
		// /* Line 8095 of "sql_yacc.y" */
		// {
		// /*
		// It is not possible to set user's information when
		// one is trying to start the SQL Thread.
		// */
		// if ((Lex->slave_thd_opt & SLAVE_SQL) == SLAVE_SQL &&
		// (Lex->slave_thd_opt & SLAVE_IO) != SLAVE_IO &&
		// (Lex->slave_connection.user ||
		// Lex->slave_connection.password ||
		// Lex->slave_connection.plugin_auth ||
		// Lex->slave_connection.plugin_dir))
		// {
		// my_error(ER_SQLTHREAD_WITH_SECURE_SLAVE, MYF(0));
		// return YYABORT;
		// }
		// };
		// break;

		case 1019:
			if (yyn == 1019)
			/* Line 350 of lalr1.java */
			/* Line 8112 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SLAVE_STOP;
				// lex->type = 0;
				// lex->slave_thd_opt= ((num)(yystack.valueAt (3-(3))));
			}
			;
			break;
		//
		//
		case 1020:
			if (yyn == 1020)
			/* Line 350 of lalr1.java */
			/* Line 8122 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_BEGIN;
				// /* READ ONLY and READ WRITE are mutually exclusive. */
				// if ((((num)(yystack.valueAt (3-(3)))) &
				// MYSQL_START_TRANS_OPT_READ_WRITE) &&
				// (((num)(yystack.valueAt (3-(3)))) &
				// MYSQL_START_TRANS_OPT_READ_ONLY))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// lex->start_transaction_opt= ((num)(yystack.valueAt (3-(3))));
			}
			;
			break;
		//
		//
		// case 1021:
		// if (yyn == 1021)
		// /* Line 350 of lalr1.java */
		// /* Line 8138 of "sql_yacc.y" */
		// {
		// yyval= 0;
		// };
		// break;
		//
		//
		// case 1022:
		// if (yyn == 1022)
		// /* Line 350 of lalr1.java */
		// /* Line 8142 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 1023:
		// if (yyn == 1023)
		// /* Line 350 of lalr1.java */
		// /* Line 8149 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 1024:
		// if (yyn == 1024)
		// /* Line 350 of lalr1.java */
		// /* Line 8153 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (3-(1)))) | ((num)(yystack.valueAt
		// (3-(3))));
		// };
		// break;
		//
		//
		// case 1025:
		// if (yyn == 1025)
		// /* Line 350 of lalr1.java */
		// /* Line 8160 of "sql_yacc.y" */
		// {
		// yyval= MYSQL_START_TRANS_OPT_WITH_CONS_SNAPSHOT;
		// };
		// break;
		//
		//
		// case 1026:
		// if (yyn == 1026)
		// /* Line 350 of lalr1.java */
		// /* Line 8164 of "sql_yacc.y" */
		// {
		// yyval= MYSQL_START_TRANS_OPT_READ_ONLY;
		// };
		// break;
		//
		//
		// case 1027:
		// if (yyn == 1027)
		// /* Line 350 of lalr1.java */
		// /* Line 8168 of "sql_yacc.y" */
		// {
		// yyval= MYSQL_START_TRANS_OPT_READ_WRITE;
		// };
		// break;
		//
		//
		// case 1029:
		// if (yyn == 1029)
		// /* Line 350 of lalr1.java */
		// /* Line 8179 of "sql_yacc.y" */
		// {
		// /* empty */
		// };
		// break;
		//
		//
		// case 1030:
		// if (yyn == 1030)
		// /* Line 350 of lalr1.java */
		// /* Line 8183 of "sql_yacc.y" */
		// {
		// Lex->slave_connection.user= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 1031:
		// if (yyn == 1031)
		// /* Line 350 of lalr1.java */
		// /* Line 8189 of "sql_yacc.y" */
		// {
		// /* empty */
		// };
		// break;
		//
		//
		// case 1032:
		// if (yyn == 1032)
		// /* Line 350 of lalr1.java */
		// /* Line 8193 of "sql_yacc.y" */
		// {
		// Lex->slave_connection.password= ((lex_str)(yystack.valueAt
		// (3-(3)))).str;
		// Lex->contains_plaintext_password= true;
		// };
		// break;
		//
		//
		// case 1033:
		// if (yyn == 1033)
		// /* Line 350 of lalr1.java */
		// /* Line 8199 of "sql_yacc.y" */
		// {
		// /* empty */
		// };
		// break;
		//
		//
		// case 1034:
		// if (yyn == 1034)
		// /* Line 350 of lalr1.java */
		// /* Line 8203 of "sql_yacc.y" */
		// {
		// Lex->slave_connection.plugin_auth= ((lex_str)(yystack.valueAt
		// (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 1035:
		// if (yyn == 1035)
		// /* Line 350 of lalr1.java */
		// /* Line 8209 of "sql_yacc.y" */
		// {
		// /* empty */
		// };
		// break;
		//
		//
		// case 1036:
		// if (yyn == 1036)
		// /* Line 350 of lalr1.java */
		// /* Line 8213 of "sql_yacc.y" */
		// {
		// Lex->slave_connection.plugin_dir= ((lex_str)(yystack.valueAt
		// (3-(3)))).str;
		// };
		// break;
		//
		//
		// case 1037:
		// if (yyn == 1037)
		// /* Line 350 of lalr1.java */
		// /* Line 8220 of "sql_yacc.y" */
		// {
		// yyval= 0;
		// };
		// break;
		//
		//
		// case 1038:
		// if (yyn == 1038)
		// /* Line 350 of lalr1.java */
		// /* Line 8224 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 1039:
		// if (yyn == 1039)
		// /* Line 350 of lalr1.java */
		// /* Line 8231 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 1040:
		// if (yyn == 1040)
		// /* Line 350 of lalr1.java */
		// /* Line 8235 of "sql_yacc.y" */
		// {
		// yyval= ((num)(yystack.valueAt (3-(1)))) | ((num)(yystack.valueAt
		// (3-(3))));
		// };
		// break;
		//
		//
		// case 1041:
		// if (yyn == 1041)
		// /* Line 350 of lalr1.java */
		// /* Line 8242 of "sql_yacc.y" */
		// {
		// yyval= SLAVE_SQL;
		// };
		// break;
		//
		//
		// case 1042:
		// if (yyn == 1042)
		// /* Line 350 of lalr1.java */
		// /* Line 8246 of "sql_yacc.y" */
		// {
		// yyval= SLAVE_IO;
		// };
		// break;
		//
		//
		// case 1043:
		// if (yyn == 1043)
		// /* Line 350 of lalr1.java */
		// /* Line 8252 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1044:
		// if (yyn == 1044)
		// /* Line 350 of lalr1.java */
		// /* Line 8254 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (((lex->mi.log_file_name || lex->mi.pos) &&
		// lex->mi.gtid) ||
		// ((lex->mi.relay_log_name || lex->mi.relay_log_pos) &&
		// lex->mi.gtid) ||
		// !((lex->mi.log_file_name && lex->mi.pos) ||
		// (lex->mi.relay_log_name && lex->mi.relay_log_pos) ||
		// lex->mi.gtid ||
		// lex->mi.until_after_gaps) ||
		// /* SQL_AFTER_MTS_GAPS is meaningless in combination */
		// /* with any other coordinates related options */
		// ((lex->mi.log_file_name || lex->mi.pos || lex->mi.relay_log_name
		// || lex->mi.relay_log_pos || lex->mi.gtid)
		// && lex->mi.until_after_gaps))
		// {
		// my_message(ER_BAD_SLAVE_UNTIL_COND,
		// ER(ER_BAD_SLAVE_UNTIL_COND), MYF(0));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1047:
		// if (yyn == 1047)
		// /* Line 350 of lalr1.java */
		// /* Line 8281 of "sql_yacc.y" */
		// {
		// Lex->mi.gtid= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// Lex->mi.gtid_until_condition=
		// LEX_MASTER_INFO::UNTIL_SQL_BEFORE_GTIDS;
		// };
		// break;
		//
		//
		// case 1048:
		// if (yyn == 1048)
		// /* Line 350 of lalr1.java */
		// /* Line 8286 of "sql_yacc.y" */
		// {
		// Lex->mi.gtid= ((lex_str)(yystack.valueAt (3-(3)))).str;
		// Lex->mi.gtid_until_condition= LEX_MASTER_INFO::UNTIL_SQL_AFTER_GTIDS;
		// };
		// break;
		//
		//
		// case 1049:
		// if (yyn == 1049)
		// /* Line 350 of lalr1.java */
		// /* Line 8291 of "sql_yacc.y" */
		// {
		// Lex->mi.until_after_gaps= true;
		// };
		// break;

		case 1050:
			if (yyn == 1050)
			/* Line 350 of lalr1.java */
			/* Line 8298 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CHECKSUM;
				// /* Will be overriden during execution. */
				// YYPS->m_lock_type= TL_UNLOCK;
			}
			;
			break;
		//
		//
		// case 1051:
		// if (yyn == 1051)
		// /* Line 350 of lalr1.java */
		// /* Line 8305 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1052:
		// if (yyn == 1052)
		// /* Line 350 of lalr1.java */
		// /* Line 8309 of "sql_yacc.y" */
		// { Lex->check_opt.flags= 0; };
		// break;
		//
		//
		// case 1053:
		// if (yyn == 1053)
		// /* Line 350 of lalr1.java */
		// /* Line 8310 of "sql_yacc.y" */
		// { Lex->check_opt.flags= T_QUICK; };
		// break;
		//
		//
		// case 1054:
		// if (yyn == 1054)
		// /* Line 350 of lalr1.java */
		// /* Line 8311 of "sql_yacc.y" */
		// { Lex->check_opt.flags= T_EXTEND; };
		// break;

		case 1055:
			if (yyn == 1055)
			/* Line 350 of lalr1.java */
			/* Line 8316 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_REPAIR;
				// lex->no_write_to_binlog= ((num)(yystack.valueAt (3-(2))));
				// lex->check_opt.init();
				// lex->alter_info.reset();
				// /* Will be overriden during execution. */
				// YYPS->m_lock_type= TL_UNLOCK;
			}
			;
			break;
		//
		//
		// case 1056:
		// if (yyn == 1056)
		// /* Line 350 of lalr1.java */
		// /* Line 8326 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX* lex= thd->lex;
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_repair_table();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1057:
		// if (yyn == 1057)
		// /* Line 350 of lalr1.java */
		// /* Line 8337 of "sql_yacc.y" */
		// { Lex->check_opt.flags = T_MEDIUM; };
		// break;
		//
		//
		// case 1058:
		// if (yyn == 1058)
		// /* Line 350 of lalr1.java */
		// /* Line 8338 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1059:
		// if (yyn == 1059)
		// /* Line 350 of lalr1.java */
		// /* Line 8342 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1060:
		// if (yyn == 1060)
		// /* Line 350 of lalr1.java */
		// /* Line 8343 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1061:
		// if (yyn == 1061)
		// /* Line 350 of lalr1.java */
		// /* Line 8347 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_QUICK; };
		// break;
		//
		//
		// case 1062:
		// if (yyn == 1062)
		// /* Line 350 of lalr1.java */
		// /* Line 8348 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_EXTEND; };
		// break;
		//
		//
		// case 1063:
		// if (yyn == 1063)
		// /* Line 350 of lalr1.java */
		// /* Line 8349 of "sql_yacc.y" */
		// { Lex->check_opt.sql_flags|= TT_USEFRM; };
		// break;

		case 1064:
			if (yyn == 1064)
			/* Line 350 of lalr1.java */
			/* Line 8354 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ANALYZE;
				// lex->no_write_to_binlog= ((num)(yystack.valueAt (3-(2))));
				// lex->check_opt.init();
				// lex->alter_info.reset();
				// /* Will be overriden during execution. */
				// YYPS->m_lock_type= TL_UNLOCK;
			}
			;
			break;
		//
		//
		// case 1065:
		// if (yyn == 1065)
		// /* Line 350 of lalr1.java */
		// /* Line 8364 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX* lex= thd->lex;
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_analyze_table();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;

		case 1066:
			if (yyn == 1066)
			/* Line 350 of lalr1.java */
			/* Line 8376 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_BINLOG_BASE64_EVENT;
				// Lex->comment= ((lex_str)(yystack.valueAt (2-(2))));
			}
			;
			break;

		case 1067:
			if (yyn == 1067)
			/* Line 350 of lalr1.java */
			/* Line 8384 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				//
				// if (lex->sphead)
				// {
				// my_error(ER_SP_BADSTATEMENT, MYF(0), "CHECK");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CHECK;
				// lex->check_opt.init();
				// lex->alter_info.reset();
				// /* Will be overriden during execution. */
				// YYPS->m_lock_type= TL_UNLOCK;
			}
			;
			break;
		//
		//
		// case 1068:
		// if (yyn == 1068)
		// /* Line 350 of lalr1.java */
		// /* Line 8399 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX* lex= thd->lex;
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_check_table();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1069:
		// if (yyn == 1069)
		// /* Line 350 of lalr1.java */
		// /* Line 8410 of "sql_yacc.y" */
		// { Lex->check_opt.flags = T_MEDIUM; };
		// break;
		//
		//
		// case 1070:
		// if (yyn == 1070)
		// /* Line 350 of lalr1.java */
		// /* Line 8411 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1071:
		// if (yyn == 1071)
		// /* Line 350 of lalr1.java */
		// /* Line 8415 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1072:
		// if (yyn == 1072)
		// /* Line 350 of lalr1.java */
		// /* Line 8416 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1073:
		// if (yyn == 1073)
		// /* Line 350 of lalr1.java */
		// /* Line 8420 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_QUICK; };
		// break;
		//
		//
		// case 1074:
		// if (yyn == 1074)
		// /* Line 350 of lalr1.java */
		// /* Line 8421 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_FAST; };
		// break;
		//
		//
		// case 1075:
		// if (yyn == 1075)
		// /* Line 350 of lalr1.java */
		// /* Line 8422 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_MEDIUM; };
		// break;
		//
		//
		// case 1076:
		// if (yyn == 1076)
		// /* Line 350 of lalr1.java */
		// /* Line 8423 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_EXTEND; };
		// break;
		//
		//
		// case 1077:
		// if (yyn == 1077)
		// /* Line 350 of lalr1.java */
		// /* Line 8424 of "sql_yacc.y" */
		// { Lex->check_opt.flags|= T_CHECK_ONLY_CHANGED; };
		// break;
		//
		//
		// case 1078:
		// if (yyn == 1078)
		// /* Line 350 of lalr1.java */
		// /* Line 8425 of "sql_yacc.y" */
		// { Lex->check_opt.sql_flags|= TT_FOR_UPGRADE; };
		// break;

		case 1079:
			if (yyn == 1079)
			/* Line 350 of lalr1.java */
			/* Line 8430 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_OPTIMIZE;
				// lex->no_write_to_binlog= ((num)(yystack.valueAt (3-(2))));
				// lex->check_opt.init();
				// lex->alter_info.reset();
				// /* Will be overriden during execution. */
				// YYPS->m_lock_type= TL_UNLOCK;
			}
			;
			break;
		//
		//
		// case 1080:
		// if (yyn == 1080)
		// /* Line 350 of lalr1.java */
		// /* Line 8440 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX* lex= thd->lex;
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_optimize_table();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1081:
		// if (yyn == 1081)
		// /* Line 350 of lalr1.java */
		// /* Line 8451 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 1082:
		// if (yyn == 1082)
		// /* Line 350 of lalr1.java */
		// /* Line 8452 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 1083:
		// if (yyn == 1083)
		// /* Line 350 of lalr1.java */
		// /* Line 8453 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;

		case 1084:
			if (yyn == 1084)
			/* Line 350 of lalr1.java */
			/* Line 8458 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_RENAME_TABLE;
			}
			;
			break;
		//
		//
		// case 1085:
		// if (yyn == 1085)
		// /* Line 350 of lalr1.java */
		// /* Line 8462 of "sql_yacc.y" */
		// {};
		// break;

		case 1086:
			if (yyn == 1086)
			/* Line 350 of lalr1.java */
			/* Line 8464 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_RENAME_USER;
			}
			;
			break;
		//
		//
		// case 1087:
		// if (yyn == 1087)
		// /* Line 350 of lalr1.java */
		// /* Line 8471 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (3-(1)))))
		// || Lex->users_list.push_back(((lex_user)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1088:
		// if (yyn == 1088)
		// /* Line 350 of lalr1.java */
		// /* Line 8476 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (5-(3)))))
		// || Lex->users_list.push_back(((lex_user)(yystack.valueAt (5-(5))))))
		// return YYABORT;
		// };
		// break;

		case 1091:
			if (yyn == 1091)
			/* Line 350 of lalr1.java */
			/* Line 8489 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// SELECT_LEX *sl= lex->current_select;
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (1)), null, null)
						|| !MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (3)), null, null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1092:
		// if (yyn == 1092)
		// /* Line 350 of lalr1.java */
		// /* Line 8502 of "sql_yacc.y" */
		// {
		// Lex->alter_info.reset();
		// };
		// break;
		//
		//
		case 1093:
			if (yyn == 1093)
			/* Line 350 of lalr1.java */
			/* Line 8506 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ASSIGN_TO_KEYCACHE;
				// lex->ident= ((lex_str)(yystack.valueAt (6-(6))));
			}
			;
			break;

		case 1098:
			if (yyn == 1098)
			/* Line 350 of lalr1.java */
			/* Line 8525 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(2 - (1)), null, null))
					return YYABORT;
			}
			;
			break;

		case 1099:
			if (yyn == 1099)
			/* Line 350 of lalr1.java */
			/* Line 8535 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (1)), null, null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1100:
		// if (yyn == 1100)
		// /* Line 350 of lalr1.java */
		// /* Line 8544 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1101:
		// if (yyn == 1101)
		// /* Line 350 of lalr1.java */
		// /* Line 8545 of "sql_yacc.y" */
		// { yyval = default_key_cache_base; };
		// break;
		//
		//
		case 1102:
			if (yyn == 1102)
			/* Line 350 of lalr1.java */
			/* Line 8550 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_PRELOAD_KEYS;
				// lex->alter_info.reset();
			}
			;
			break;
		//
		//
		// case 1103:
		// if (yyn == 1103)
		// /* Line 350 of lalr1.java */
		// /* Line 8556 of "sql_yacc.y" */
		// {};
		// break;

		case 1108:
			if (yyn == 1108)
			/* Line 350 of lalr1.java */
			/* Line 8571 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (1)), null, null))
					return YYABORT;
			}
			;
			break;

		case 1109:
			if (yyn == 1109)
			/* Line 350 of lalr1.java */
			/* Line 8581 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(4 - (1)), null, null))
					return YYABORT;
			}
			;
			break;

		case 1110:
		if (yyn == 1110)
		/* Line 350 of lalr1.java */
		/* Line 8591 of "sql_yacc.y" */
		{
			thd.lex.alterInfo.flags.add(AlterFlag.ALTER_ADMIN_PARTITION);
		};
		break;
		//
		//
		// case 1112:
		// if (yyn == 1112)
		// /* Line 350 of lalr1.java */
		// /* Line 8598 of "sql_yacc.y" */
		// {
		// Lex->select_lex.alloc_index_hints(YYTHD);
		// Select->set_index_hint_type(INDEX_HINT_USE,
		// old_mode ?
		// INDEX_HINT_MASK_JOIN :
		// INDEX_HINT_MASK_ALL);
		// };
		// break;
		//
		//
		// case 1114:
		// if (yyn == 1114)
		// /* Line 350 of lalr1.java */
		// /* Line 8609 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 1116:
		// if (yyn == 1116)
		// /* Line 350 of lalr1.java */
		// /* Line 8615 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 1117:
		// if (yyn == 1117)
		// /* Line 350 of lalr1.java */
		// /* Line 8616 of "sql_yacc.y" */
		// { yyval= TL_OPTION_IGNORE_LEAVES; };
		// break;

		case 1118:
			if (yyn == 1118)
			/* Line 350 of lalr1.java */
			/* Line 8626 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SELECT;
			}
			;
			break;
		//
		//
		// case 1121:
		// if (yyn == 1121)
		// /* Line 350 of lalr1.java */
		// /* Line 8640 of "sql_yacc.y" */
		// {
		// if (setup_select_in_parentheses(Lex))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1123:
		// if (yyn == 1123)
		// /* Line 350 of lalr1.java */
		// /* Line 8650 of "sql_yacc.y" */
		// {
		// if (setup_select_in_parentheses(Lex))
		// return YYABORT;
		// };
		// break;
		//
		//
		case 1125:
			if (yyn == 1125)
			/* Line 350 of lalr1.java */
			/* Line 8659 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// SELECT_LEX * sel= lex->current_select;
				// if (lex->current_select->set_braces(0))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// if (sel->linkage == UNION_TYPE &&
				// sel->master_unit()->first_select()->braces)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;

		case 1127:
			if (yyn == 1127)
			/* Line 350 of lalr1.java */
			/* Line 8678 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// SELECT_LEX *sel= lex->current_select;
				// if (sel->linkage != UNION_TYPE)
				if (thd.lex.selectLex == null) MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->current_select->parsing_place= SELECT_LIST;
			}
			;
			break;
		//
		//
		// case 1128:
		// if (yyn == 1128)
		// /* Line 350 of lalr1.java */
		// /* Line 8686 of "sql_yacc.y" */
		// {
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1130:
		// if (yyn == 1130)
		// /* Line 350 of lalr1.java */
		// /* Line 8693 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1135:
		// if (yyn == 1135)
		// /* Line 350 of lalr1.java */
		// /* Line 8703 of "sql_yacc.y" */
		// {
		// Select->context.table_list=
		// Select->context.first_name_resolution_table=
		// Select->table_list.first;
		// };
		// break;
		//
		//
		// case 1138:
		// if (yyn == 1138)
		// /* Line 350 of lalr1.java */
		// /* Line 8718 of "sql_yacc.y" */
		// {
		// if (Select->options & SELECT_DISTINCT && Select->options &
		// SELECT_ALL)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "ALL", "DISTINCT");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1142:
		// if (yyn == 1142)
		// /* Line 350 of lalr1.java */
		// /* Line 8735 of "sql_yacc.y" */
		// {
		// /*
		// Allow this flag only on the first top-level SELECT statement, if
		// SQL_CACHE wasn't specified, and only once per query.
		// */
		// if (Lex->current_select != &Lex->select_lex)
		// {
		// my_error(ER_CANT_USE_OPTION_HERE, MYF(0), "SQL_NO_CACHE");
		// return YYABORT;
		// }
		// else if (Lex->select_lex.sql_cache == SELECT_LEX::SQL_CACHE)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "SQL_CACHE", "SQL_NO_CACHE");
		// return YYABORT;
		// }
		// else if (Lex->select_lex.sql_cache == SELECT_LEX::SQL_NO_CACHE)
		// {
		// my_error(ER_DUP_ARGUMENT, MYF(0), "SQL_NO_CACHE");
		// return YYABORT;
		// }
		// else
		// {
		// Lex->safe_to_cache_query=0;
		// Lex->select_lex.options&= ~OPTION_TO_QUERY_CACHE;
		// Lex->select_lex.sql_cache= SELECT_LEX::SQL_NO_CACHE;
		// }
		// };
		// break;
		//
		//
		// case 1143:
		// if (yyn == 1143)
		// /* Line 350 of lalr1.java */
		// /* Line 8763 of "sql_yacc.y" */
		// {
		// /*
		// Allow this flag only on the first top-level SELECT statement, if
		// SQL_NO_CACHE wasn't specified, and only once per query.
		// */
		// if (Lex->current_select != &Lex->select_lex)
		// {
		// my_error(ER_CANT_USE_OPTION_HERE, MYF(0), "SQL_CACHE");
		// return YYABORT;
		// }
		// else if (Lex->select_lex.sql_cache == SELECT_LEX::SQL_NO_CACHE)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "SQL_NO_CACHE", "SQL_CACHE");
		// return YYABORT;
		// }
		// else if (Lex->select_lex.sql_cache == SELECT_LEX::SQL_CACHE)
		// {
		// my_error(ER_DUP_ARGUMENT, MYF(0), "SQL_CACHE");
		// return YYABORT;
		// }
		// else
		// {
		// Lex->safe_to_cache_query=1;
		// Lex->select_lex.options|= OPTION_TO_QUERY_CACHE;
		// Lex->select_lex.sql_cache= SELECT_LEX::SQL_CACHE;
		// }
		// };
		// break;
		//
		//
		// case 1145:
		// if (yyn == 1145)
		// /* Line 350 of lalr1.java */
		// /* Line 8795 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (!lex->describe)
		// {
		// lex->current_select->set_lock_for_tables(TL_WRITE);
		// lex->safe_to_cache_query=0;
		// }
		// };
		// break;
		//
		//
		// case 1146:
		// if (yyn == 1146)
		// /* Line 350 of lalr1.java */
		// /* Line 8804 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (!lex->describe)
		// {
		// lex->current_select->
		// set_lock_for_tables(TL_READ_WITH_SHARED_LOCKS);
		// lex->safe_to_cache_query=0;
		// }
		// };
		// break;
		//
		//
		// case 1149:
		// if (yyn == 1149)
		// /* Line 350 of lalr1.java */
		// /* Line 8819 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Item *item= new (thd->mem_root)
		// Item_field(&thd->lex->current_select->context,
		// NULL, NULL, "*");
		// if (item == NULL)
		// return YYABORT;
		// if (add_item_to_list(thd, item))
		// return YYABORT;
		// (thd->lex->current_select->with_wild)++;
		// };
		// break;
		//
		//
		// case 1150:
		// if (yyn == 1150)
		// /* Line 350 of lalr1.java */
		// /* Line 8834 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		//
		// if (add_item_to_list(thd, ((item)(yystack.valueAt (3-(2))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1151:
		// if (yyn == 1151)
		// /* Line 350 of lalr1.java */
		// /* Line 8841 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// DBUG_ASSERT(((simple_string)(yystack.valueAt (4-(1)))) <
		// ((simple_string)(yystack.valueAt (4-(3)))));
		//
		// if (add_item_to_list(thd, ((item)(yystack.valueAt (4-(2))))))
		// return YYABORT;
		// if (((lex_str)(yystack.valueAt (4-(4)))).str)
		// {
		// if (thd.lex.sqlCommand == SQLCOM_CREATE_VIEW &&
		// check_column_name(((lex_str)(yystack.valueAt (4-(4)))).str))
		// {
		// my_error(ER_WRONG_COLUMN_NAME, MYF(0), ((lex_str)(yystack.valueAt
		// (4-(4)))).str);
		// return YYABORT;
		// }
		// ((item)(yystack.valueAt
		// (4-(2))))->item_name.copy(((lex_str)(yystack.valueAt (4-(4)))).str,
		// ((lex_str)(yystack.valueAt (4-(4)))).length, system_charset_info,
		// false);
		// }
		// else if (!((item)(yystack.valueAt (4-(2))))->item_name.is_set())
		// {
		// ((item)(yystack.valueAt
		// (4-(2))))->item_name.copy(((simple_string)(yystack.valueAt (4-(1)))),
		// (uint) (((simple_string)(yystack.valueAt (4-(3)))) -
		// ((simple_string)(yystack.valueAt (4-(1))))), thd->charset());
		// }
		// };
		// break;
		//
		//
		// case 1152:
		// if (yyn == 1152)
		// /* Line 350 of lalr1.java */
		// /* Line 8865 of "sql_yacc.y" */
		// {
		// yyval= (char*) YYLIP->get_cpp_tok_start();
		// };
		// break;
		//
		//
		// case 1153:
		// if (yyn == 1153)
		// /* Line 350 of lalr1.java */
		// /* Line 8871 of "sql_yacc.y" */
		// {
		// yyval= (char*) YYLIP->get_cpp_tok_end();
		// };
		// break;
		//
		//
		// case 1154:
		// if (yyn == 1154)
		// /* Line 350 of lalr1.java */
		// /* Line 8877 of "sql_yacc.y" */
		// { yyval=null_lex_str;};
		// break;
		//
		//
		// case 1155:
		// if (yyn == 1155)
		// /* Line 350 of lalr1.java */
		// /* Line 8878 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 1156:
		// if (yyn == 1156)
		// /* Line 350 of lalr1.java */
		// /* Line 8879 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 1157:
		// if (yyn == 1157)
		// /* Line 350 of lalr1.java */
		// /* Line 8880 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1158:
		// if (yyn == 1158)
		// /* Line 350 of lalr1.java */
		// /* Line 8881 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1159:
		// if (yyn == 1159)
		// /* Line 350 of lalr1.java */
		// /* Line 8885 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1160:
		// if (yyn == 1160)
		// /* Line 350 of lalr1.java */
		// /* Line 8886 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1161:
		// if (yyn == 1161)
		// /* Line 350 of lalr1.java */
		// /* Line 8892 of "sql_yacc.y" */
		// {
		// /*
		// Design notes:
		// Do not use a manually maintained stack like thd->lex->xxx_list,
		// but use the internal bison stack ($$, $1 and $3) instead.
		// Using the bison stack is:
		// - more robust to changes in the grammar,
		// - guaranteed to be in sync with the parser state,
		// - better for performances (no memory allocation).
		// */
		// Item_cond_or *item1;
		// Item_cond_or *item3;
		// if (is_cond_or(((item)(yystack.valueAt (3-(1))))))
		// {
		// item1= (Item_cond_or*) ((item)(yystack.valueAt (3-(1))));
		// if (is_cond_or(((item)(yystack.valueAt (3-(3))))))
		// {
		// item3= (Item_cond_or*) ((item)(yystack.valueAt (3-(3))));
		// /*
		// (X1 OR X2) OR (Y1 OR Y2) ==> OR (X1, X2, Y1, Y2)
		// */
		// item3->add_at_head(item1->argument_list());
		// yyval = ((item)(yystack.valueAt (3-(3))));
		// }
		// else
		// {
		// /*
		// (X1 OR X2) OR Y ==> OR (X1, X2, Y)
		// */
		// item1->add(((item)(yystack.valueAt (3-(3)))));
		// yyval = ((item)(yystack.valueAt (3-(1))));
		// }
		// }
		// else if (is_cond_or(((item)(yystack.valueAt (3-(3))))))
		// {
		// item3= (Item_cond_or*) ((item)(yystack.valueAt (3-(3))));
		// /*
		// X OR (Y1 OR Y2) ==> OR (X, Y1, Y2)
		// */
		// item3->add_at_head(((item)(yystack.valueAt (3-(1)))));
		// yyval = ((item)(yystack.valueAt (3-(3))));
		// }
		// else
		// {
		// /* X OR Y */
		// yyval = new (YYTHD->mem_root) Item_cond_or(((item)(yystack.valueAt
		// (3-(1)))), ((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1162:
		// if (yyn == 1162)
		// /* Line 350 of lalr1.java */
		// /* Line 8943 of "sql_yacc.y" */
		// {
		// /* XOR is a proprietary extension */
		// yyval = new (YYTHD->mem_root) Item_func_xor(((item)(yystack.valueAt
		// (3-(1)))), ((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1163:
		// if (yyn == 1163)
		// /* Line 350 of lalr1.java */
		// /* Line 8950 of "sql_yacc.y" */
		// {
		// /* See comments in rule expr: expr or expr */
		// Item_cond_and *item1;
		// Item_cond_and *item3;
		// if (is_cond_and(((item)(yystack.valueAt (3-(1))))))
		// {
		// item1= (Item_cond_and*) ((item)(yystack.valueAt (3-(1))));
		// if (is_cond_and(((item)(yystack.valueAt (3-(3))))))
		// {
		// item3= (Item_cond_and*) ((item)(yystack.valueAt (3-(3))));
		// /*
		// (X1 AND X2) AND (Y1 AND Y2) ==> AND (X1, X2, Y1, Y2)
		// */
		// item3->add_at_head(item1->argument_list());
		// yyval = ((item)(yystack.valueAt (3-(3))));
		// }
		// else
		// {
		// /*
		// (X1 AND X2) AND Y ==> AND (X1, X2, Y)
		// */
		// item1->add(((item)(yystack.valueAt (3-(3)))));
		// yyval = ((item)(yystack.valueAt (3-(1))));
		// }
		// }
		// else if (is_cond_and(((item)(yystack.valueAt (3-(3))))))
		// {
		// item3= (Item_cond_and*) ((item)(yystack.valueAt (3-(3))));
		// /*
		// X AND (Y1 AND Y2) ==> AND (X, Y1, Y2)
		// */
		// item3->add_at_head(((item)(yystack.valueAt (3-(1)))));
		// yyval = ((item)(yystack.valueAt (3-(3))));
		// }
		// else
		// {
		// /* X AND Y */
		// yyval = new (YYTHD->mem_root) Item_cond_and(((item)(yystack.valueAt
		// (3-(1)))), ((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1164:
		// if (yyn == 1164)
		// /* Line 350 of lalr1.java */
		// /* Line 8993 of "sql_yacc.y" */
		// {
		// yyval= negate_expression(YYTHD, ((item)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1165:
		// if (yyn == 1165)
		// /* Line 350 of lalr1.java */
		// /* Line 8999 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_istrue(((item)(yystack.valueAt
		// (3-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1166:
		// if (yyn == 1166)
		// /* Line 350 of lalr1.java */
		// /* Line 9005 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_isnottrue(((item)(yystack.valueAt (4-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1167:
		// if (yyn == 1167)
		// /* Line 350 of lalr1.java */
		// /* Line 9011 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_isfalse(((item)(yystack.valueAt (3-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1168:
		// if (yyn == 1168)
		// /* Line 350 of lalr1.java */
		// /* Line 9017 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_isnotfalse(((item)(yystack.valueAt (4-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1169:
		// if (yyn == 1169)
		// /* Line 350 of lalr1.java */
		// /* Line 9023 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_isnull(((item)(yystack.valueAt
		// (3-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1170:
		// if (yyn == 1170)
		// /* Line 350 of lalr1.java */
		// /* Line 9029 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_isnotnull(((item)(yystack.valueAt (4-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1172:
		// if (yyn == 1172)
		// /* Line 350 of lalr1.java */
		// /* Line 9039 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_isnull(((item)(yystack.valueAt
		// (3-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1173:
		// if (yyn == 1173)
		// /* Line 350 of lalr1.java */
		// /* Line 9045 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_isnotnull(((item)(yystack.valueAt (4-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1174:
		// if (yyn == 1174)
		// /* Line 350 of lalr1.java */
		// /* Line 9051 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_equal(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1175:
		// if (yyn == 1175)
		// /* Line 350 of lalr1.java */
		// /* Line 9057 of "sql_yacc.y" */
		// {
		// yyval= (*((boolfunc2creator)(yystack.valueAt
		// (3-(2)))))(0)->create(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1176:
		// if (yyn == 1176)
		// /* Line 350 of lalr1.java */
		// /* Line 9063 of "sql_yacc.y" */
		// {
		// yyval= all_any_subquery_creator(((item)(yystack.valueAt (6-(1)))),
		// ((boolfunc2creator)(yystack.valueAt (6-(2)))), ((num)(yystack.valueAt
		// (6-(3)))), ((select_lex)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1178:
		// if (yyn == 1178)
		// /* Line 350 of lalr1.java */
		// /* Line 9073 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_in_subselect(((item)(yystack.valueAt (5-(1)))),
		// ((select_lex)(yystack.valueAt (5-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1179:
		// if (yyn == 1179)
		// /* Line 350 of lalr1.java */
		// /* Line 9079 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Item *item= new (thd->mem_root)
		// Item_in_subselect(((item)(yystack.valueAt (6-(1)))),
		// ((select_lex)(yystack.valueAt (6-(5)))));
		// if (item == NULL)
		// return YYABORT;
		// yyval= negate_expression(thd, item);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1180:
		// if (yyn == 1180)
		// /* Line 350 of lalr1.java */
		// /* Line 9089 of "sql_yacc.y" */
		// {
		// yyval= handle_sql2003_note184_exception(YYTHD,
		// ((item)(yystack.valueAt (5-(1)))), true, ((item)(yystack.valueAt
		// (5-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1181:
		// if (yyn == 1181)
		// /* Line 350 of lalr1.java */
		// /* Line 9095 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (7-(6))))->push_front(((item)(yystack.valueAt (7-(4)))));
		// ((item_list)(yystack.valueAt
		// (7-(6))))->push_front(((item)(yystack.valueAt (7-(1)))));
		// yyval= new (YYTHD->mem_root)
		// Item_func_in(*((item_list)(yystack.valueAt (7-(6)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1182:
		// if (yyn == 1182)
		// /* Line 350 of lalr1.java */
		// /* Line 9103 of "sql_yacc.y" */
		// {
		// yyval= handle_sql2003_note184_exception(YYTHD,
		// ((item)(yystack.valueAt (6-(1)))), false, ((item)(yystack.valueAt
		// (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1183:
		// if (yyn == 1183)
		// /* Line 350 of lalr1.java */
		// /* Line 9109 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (8-(7))))->push_front(((item)(yystack.valueAt (8-(5)))));
		// ((item_list)(yystack.valueAt
		// (8-(7))))->push_front(((item)(yystack.valueAt (8-(1)))));
		// Item_func_in *item = new (YYTHD->mem_root)
		// Item_func_in(*((item_list)(yystack.valueAt (8-(7)))));
		// if (item == NULL)
		// return YYABORT;
		// item->negate();
		// yyval= item;
		// };
		// break;
		//
		//
		// case 1184:
		// if (yyn == 1184)
		// /* Line 350 of lalr1.java */
		// /* Line 9119 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_between(((item)(yystack.valueAt
		// (5-(1)))),((item)(yystack.valueAt (5-(3)))),((item)(yystack.valueAt
		// (5-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1185:
		// if (yyn == 1185)
		// /* Line 350 of lalr1.java */
		// /* Line 9125 of "sql_yacc.y" */
		// {
		// Item_func_between *item;
		// item= new (YYTHD->mem_root) Item_func_between(((item)(yystack.valueAt
		// (6-(1)))),((item)(yystack.valueAt (6-(4)))),((item)(yystack.valueAt
		// (6-(6)))));
		// if (item == NULL)
		// return YYABORT;
		// item->negate();
		// yyval= item;
		// };
		// break;
		//
		//
		// case 1186:
		// if (yyn == 1186)
		// /* Line 350 of lalr1.java */
		// /* Line 9134 of "sql_yacc.y" */
		// {
		// Item *item1= new (YYTHD->mem_root)
		// Item_func_soundex(((item)(yystack.valueAt (4-(1)))));
		// Item *item4= new (YYTHD->mem_root)
		// Item_func_soundex(((item)(yystack.valueAt (4-(4)))));
		// if ((item1 == NULL) || (item4 == NULL))
		// return YYABORT;
		// yyval= new (YYTHD->mem_root) Item_func_eq(item1, item4);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1187:
		// if (yyn == 1187)
		// /* Line 350 of lalr1.java */
		// /* Line 9144 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_like(((item)(yystack.valueAt
		// (4-(1)))),((item)(yystack.valueAt (4-(3)))),((item)(yystack.valueAt
		// (4-(4)))),Lex->escape_used);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1188:
		// if (yyn == 1188)
		// /* Line 350 of lalr1.java */
		// /* Line 9150 of "sql_yacc.y" */
		// {
		// Item *item= new (YYTHD->mem_root)
		// Item_func_like(((item)(yystack.valueAt
		// (5-(1)))),((item)(yystack.valueAt (5-(4)))),((item)(yystack.valueAt
		// (5-(5)))),
		// Lex->escape_used);
		// if (item == NULL)
		// return YYABORT;
		// yyval= new (YYTHD->mem_root) Item_func_not(item);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1189:
		// if (yyn == 1189)
		// /* Line 350 of lalr1.java */
		// /* Line 9160 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_regex(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1190:
		// if (yyn == 1190)
		// /* Line 350 of lalr1.java */
		// /* Line 9166 of "sql_yacc.y" */
		// {
		// Item *item= new (YYTHD->mem_root)
		// Item_func_regex(((item)(yystack.valueAt
		// (4-(1)))),((item)(yystack.valueAt (4-(4)))));
		// if (item == NULL)
		// return YYABORT;
		// yyval= negate_expression(YYTHD, item);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1192:
		// if (yyn == 1192)
		// /* Line 350 of lalr1.java */
		// /* Line 9179 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_bit_or(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1193:
		// if (yyn == 1193)
		// /* Line 350 of lalr1.java */
		// /* Line 9185 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_bit_and(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1194:
		// if (yyn == 1194)
		// /* Line 350 of lalr1.java */
		// /* Line 9191 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_shift_left(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1195:
		// if (yyn == 1195)
		// /* Line 350 of lalr1.java */
		// /* Line 9197 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_shift_right(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1196:
		// if (yyn == 1196)
		// /* Line 350 of lalr1.java */
		// /* Line 9203 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_plus(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1197:
		// if (yyn == 1197)
		// /* Line 350 of lalr1.java */
		// /* Line 9209 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_minus(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1198:
		// if (yyn == 1198)
		// /* Line 350 of lalr1.java */
		// /* Line 9215 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt
		// (5-(1)))),((item)(yystack.valueAt
		// (5-(4)))),((interval)(yystack.valueAt (5-(5)))),0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1199:
		// if (yyn == 1199)
		// /* Line 350 of lalr1.java */
		// /* Line 9221 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt
		// (5-(1)))),((item)(yystack.valueAt
		// (5-(4)))),((interval)(yystack.valueAt (5-(5)))),1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1200:
		// if (yyn == 1200)
		// /* Line 350 of lalr1.java */
		// /* Line 9227 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_mul(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1201:
		// if (yyn == 1201)
		// /* Line 350 of lalr1.java */
		// /* Line 9233 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_div(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1202:
		// if (yyn == 1202)
		// /* Line 350 of lalr1.java */
		// /* Line 9239 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_mod(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1203:
		// if (yyn == 1203)
		// /* Line 350 of lalr1.java */
		// /* Line 9245 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_int_div(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1204:
		// if (yyn == 1204)
		// /* Line 350 of lalr1.java */
		// /* Line 9251 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_mod(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1205:
		// if (yyn == 1205)
		// /* Line 350 of lalr1.java */
		// /* Line 9257 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_bit_xor(((item)(yystack.valueAt
		// (3-(1)))),((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1215:
		// if (yyn == 1215)
		// /* Line 350 of lalr1.java */
		// /* Line 9286 of "sql_yacc.y" */
		// { yyval = &comp_eq_creator; };
		// break;
		//
		//
		// case 1216:
		// if (yyn == 1216)
		// /* Line 350 of lalr1.java */
		// /* Line 9287 of "sql_yacc.y" */
		// { yyval = &comp_ge_creator; };
		// break;
		//
		//
		// case 1217:
		// if (yyn == 1217)
		// /* Line 350 of lalr1.java */
		// /* Line 9288 of "sql_yacc.y" */
		// { yyval = &comp_gt_creator; };
		// break;
		//
		//
		// case 1218:
		// if (yyn == 1218)
		// /* Line 350 of lalr1.java */
		// /* Line 9289 of "sql_yacc.y" */
		// { yyval = &comp_le_creator; };
		// break;
		//
		//
		// case 1219:
		// if (yyn == 1219)
		// /* Line 350 of lalr1.java */
		// /* Line 9290 of "sql_yacc.y" */
		// { yyval = &comp_lt_creator; };
		// break;
		//
		//
		// case 1220:
		// if (yyn == 1220)
		// /* Line 350 of lalr1.java */
		// /* Line 9291 of "sql_yacc.y" */
		// { yyval = &comp_ne_creator; };
		// break;
		//
		//
		// case 1221:
		// if (yyn == 1221)
		// /* Line 350 of lalr1.java */
		// /* Line 9295 of "sql_yacc.y" */
		// { yyval = 1; };
		// break;
		//
		//
		// case 1222:
		// if (yyn == 1222)
		// /* Line 350 of lalr1.java */
		// /* Line 9296 of "sql_yacc.y" */
		// { yyval = 0; };
		// break;
		//
		//
		// case 1228:
		// if (yyn == 1228)
		// /* Line 350 of lalr1.java */
		// /* Line 9306 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Item *i1= new (thd->mem_root) Item_string(((lex_str)(yystack.valueAt
		// (3-(3)))).str,
		// ((lex_str)(yystack.valueAt (3-(3)))).length,
		// thd->charset());
		// if (i1 == NULL)
		// return YYABORT;
		// yyval= new (thd->mem_root)
		// Item_func_set_collation(((item)(yystack.valueAt (3-(1)))), i1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1233:
		// if (yyn == 1233)
		// /* Line 350 of lalr1.java */
		// /* Line 9322 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_concat(((item)(yystack.valueAt
		// (3-(1)))), ((item)(yystack.valueAt (3-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1234:
		// if (yyn == 1234)
		// /* Line 350 of lalr1.java */
		// /* Line 9328 of "sql_yacc.y" */
		// {
		// yyval= ((item)(yystack.valueAt (2-(2))));
		// };
		// break;
		//
		//
		// case 1235:
		// if (yyn == 1235)
		// /* Line 350 of lalr1.java */
		// /* Line 9332 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_neg(((item)(yystack.valueAt
		// (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1236:
		// if (yyn == 1236)
		// /* Line 350 of lalr1.java */
		// /* Line 9338 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_bit_neg(((item)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1237:
		// if (yyn == 1237)
		// /* Line 350 of lalr1.java */
		// /* Line 9344 of "sql_yacc.y" */
		// {
		// yyval= negate_expression(YYTHD, ((item)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1238:
		// if (yyn == 1238)
		// /* Line 350 of lalr1.java */
		// /* Line 9350 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_singlerow_subselect(((select_lex)(yystack.valueAt (3-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1239:
		// if (yyn == 1239)
		// /* Line 350 of lalr1.java */
		// /* Line 9356 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (3-(2)))); };
		// break;
		//
		//
		// case 1240:
		// if (yyn == 1240)
		// /* Line 350 of lalr1.java */
		// /* Line 9358 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (5-(4))))->push_front(((item)(yystack.valueAt (5-(2)))));
		// yyval= new (YYTHD->mem_root) Item_row(*((item_list)(yystack.valueAt
		// (5-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1241:
		// if (yyn == 1241)
		// /* Line 350 of lalr1.java */
		// /* Line 9365 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (6-(5))))->push_front(((item)(yystack.valueAt (6-(3)))));
		// yyval= new (YYTHD->mem_root) Item_row(*((item_list)(yystack.valueAt
		// (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1242:
		// if (yyn == 1242)
		// /* Line 350 of lalr1.java */
		// /* Line 9372 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_exists_subselect(((select_lex)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1243:
		// if (yyn == 1243)
		// /* Line 350 of lalr1.java */
		// /* Line 9378 of "sql_yacc.y" */
		// {
		// Item_string *item;
		// yyval= NULL;
		// /*
		// If "expr" is reasonably short pure ASCII string literal,
		// try to parse known ODBC style date, time or timestamp literals,
		// e.g:
		// SELECT {d'2001-01-01'};
		// SELECT {t'10:20:30'};
		// SELECT {ts'2001-01-01 10:20:30'};
		// */
		// if (((item)(yystack.valueAt (4-(3))))->type() == Item::STRING_ITEM &&
		// (item= (Item_string *) ((item)(yystack.valueAt (4-(3))))) &&
		// item->collation.repertoire == MY_REPERTOIRE_ASCII &&
		// item->str_value.length() < MAX_DATE_STRING_REP_LENGTH * 4)
		// {
		// enum_field_types type= MYSQL_TYPE_STRING;
		// ErrConvString str(&item->str_value);
		// LEX_STRING *ls= &((lex_str)(yystack.valueAt (4-(2))));
		// if (ls->length == 1)
		// {
		// if (ls->str[0] == 'd') /* {d'2001-01-01'} */
		// type= MYSQL_TYPE_DATE;
		// else if (ls->str[0] == 't') /* {t'10:20:30'} */
		// type= MYSQL_TYPE_TIME;
		// }
		// else if (ls->length == 2) /* {ts'2001-01-01 10:20:30'} */
		// {
		// if (ls->str[0] == 't' && ls->str[1] == 's')
		// type= MYSQL_TYPE_DATETIME;
		// }
		// if (type != MYSQL_TYPE_STRING)
		// yyval= create_temporal_literal(YYTHD,
		// str.ptr(), str.length(),
		// system_charset_info,
		// type, false);
		// }
		// if (yyval == NULL)
		// yyval= ((item)(yystack.valueAt (4-(3))));
		// };
		// break;
		//
		//
		// case 1244:
		// if (yyn == 1244)
		// /* Line 350 of lalr1.java */
		// /* Line 9419 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (7-(2))))->push_front(((item)(yystack.valueAt (7-(5)))));
		// Item_func_match *i1= new (YYTHD->mem_root)
		// Item_func_match(*((item_list)(yystack.valueAt (7-(2)))),
		// ((num)(yystack.valueAt (7-(6)))));
		// if (i1 == NULL)
		// return YYABORT;
		// Select->add_ftfunc_to_list(i1);
		// yyval= i1;
		// };
		// break;
		//
		//
		// case 1245:
		// if (yyn == 1245)
		// /* Line 350 of lalr1.java */
		// /* Line 9428 of "sql_yacc.y" */
		// {
		// yyval= create_func_cast(YYTHD, ((item)(yystack.valueAt (2-(2)))),
		// ITEM_CAST_CHAR, NULL, NULL,
		// &my_charset_bin);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1246:
		// if (yyn == 1246)
		// /* Line 350 of lalr1.java */
		// /* Line 9435 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// yyval= create_func_cast(YYTHD, ((item)(yystack.valueAt (6-(3)))),
		// ((cast_type)(yystack.valueAt (6-(5)))), lex->length, lex->dec,
		// lex->charset);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1247:
		// if (yyn == 1247)
		// /* Line 350 of lalr1.java */
		// /* Line 9443 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_case(*
		// ((item_list)(yystack.valueAt (5-(3)))), ((item)(yystack.valueAt
		// (5-(2)))), ((item)(yystack.valueAt (5-(4)))) );
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1248:
		// if (yyn == 1248)
		// /* Line 350 of lalr1.java */
		// /* Line 9449 of "sql_yacc.y" */
		// {
		// yyval= create_func_cast(YYTHD, ((item)(yystack.valueAt (6-(3)))),
		// ((cast_type)(yystack.valueAt (6-(5)))), Lex->length, Lex->dec,
		// Lex->charset);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1249:
		// if (yyn == 1249)
		// /* Line 350 of lalr1.java */
		// /* Line 9456 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_conv_charset(((item)(yystack.valueAt
		// (6-(3)))),((charset)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1250:
		// if (yyn == 1250)
		// /* Line 350 of lalr1.java */
		// /* Line 9462 of "sql_yacc.y" */
		// {
		// if (((item)(yystack.valueAt (4-(3))))->is_splocal())
		// {
		// Item_splocal *il= static_cast<Item_splocal *>(((item)(yystack.valueAt
		// (4-(3)))));
		//
		// my_error(ER_WRONG_COLUMN_NAME, MYF(0), il->m_name.ptr());
		// return YYABORT;
		// }
		// yyval= new (YYTHD->mem_root)
		// Item_default_value(Lex->current_context(),
		// ((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1251:
		// if (yyn == 1251)
		// /* Line 350 of lalr1.java */
		// /* Line 9476 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_insert_value(Lex->current_context(),
		// ((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1252:
		// if (yyn == 1252)
		// /* Line 350 of lalr1.java */
		// /* Line 9484 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt
		// (5-(5)))),((item)(yystack.valueAt
		// (5-(2)))),((interval)(yystack.valueAt (5-(3)))),0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1253:
		// if (yyn == 1253)
		// /* Line 350 of lalr1.java */
		// /* Line 9499 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_char(*((item_list)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1254:
		// if (yyn == 1254)
		// /* Line 350 of lalr1.java */
		// /* Line 9505 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_char(*((item_list)(yystack.valueAt (6-(3)))),
		// ((charset)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1255:
		// if (yyn == 1255)
		// /* Line 350 of lalr1.java */
		// /* Line 9511 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_current_user(Lex->current_context());
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_SYSTEM_FUNCTION);
		// Lex->safe_to_cache_query= 0;
		// };
		// break;
		//
		//
		// case 1256:
		// if (yyn == 1256)
		// /* Line 350 of lalr1.java */
		// /* Line 9519 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_typecast(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1257:
		// if (yyn == 1257)
		// /* Line 350 of lalr1.java */
		// /* Line 9525 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_dayofmonth(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1258:
		// if (yyn == 1258)
		// /* Line 350 of lalr1.java */
		// /* Line 9531 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_hour(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1259:
		// if (yyn == 1259)
		// /* Line 350 of lalr1.java */
		// /* Line 9537 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_insert(((item)(yystack.valueAt
		// (10-(3)))),((item)(yystack.valueAt (10-(5)))),((item)(yystack.valueAt
		// (10-(7)))),((item)(yystack.valueAt (10-(9)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1260:
		// if (yyn == 1260)
		// /* Line 350 of lalr1.java */
		// /* Line 9543 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// List<Item> *list= new (thd->mem_root) List<Item>;
		// if (list == NULL)
		// return YYABORT;
		// list->push_front(((item)(yystack.valueAt (6-(5)))));
		// list->push_front(((item)(yystack.valueAt (6-(3)))));
		// Item_row *item= new (thd->mem_root) Item_row(*list);
		// if (item == NULL)
		// return YYABORT;
		// yyval= new (thd->mem_root) Item_func_interval(item);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1261:
		// if (yyn == 1261)
		// /* Line 350 of lalr1.java */
		// /* Line 9558 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// ((item_list)(yystack.valueAt
		// (8-(7))))->push_front(((item)(yystack.valueAt (8-(5)))));
		// ((item_list)(yystack.valueAt
		// (8-(7))))->push_front(((item)(yystack.valueAt (8-(3)))));
		// Item_row *item= new (thd->mem_root)
		// Item_row(*((item_list)(yystack.valueAt (8-(7)))));
		// if (item == NULL)
		// return YYABORT;
		// yyval= new (thd->mem_root) Item_func_interval(item);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1262:
		// if (yyn == 1262)
		// /* Line 350 of lalr1.java */
		// /* Line 9570 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_left(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1263:
		// if (yyn == 1263)
		// /* Line 350 of lalr1.java */
		// /* Line 9576 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_minute(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1264:
		// if (yyn == 1264)
		// /* Line 350 of lalr1.java */
		// /* Line 9582 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_month(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1265:
		// if (yyn == 1265)
		// /* Line 350 of lalr1.java */
		// /* Line 9588 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_right(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1266:
		// if (yyn == 1266)
		// /* Line 350 of lalr1.java */
		// /* Line 9594 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_second(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1267:
		// if (yyn == 1267)
		// /* Line 350 of lalr1.java */
		// /* Line 9600 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_time_typecast(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1268:
		// if (yyn == 1268)
		// /* Line 350 of lalr1.java */
		// /* Line 9606 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_datetime_typecast(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1269:
		// if (yyn == 1269)
		// /* Line 350 of lalr1.java */
		// /* Line 9612 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_add_time(((item)(yystack.valueAt (6-(3)))),
		// ((item)(yystack.valueAt (6-(5)))), 1, 0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1270:
		// if (yyn == 1270)
		// /* Line 350 of lalr1.java */
		// /* Line 9618 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_trim(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1271:
		// if (yyn == 1271)
		// /* Line 350 of lalr1.java */
		// /* Line 9624 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_ltrim(((item)(yystack.valueAt
		// (7-(6)))),((item)(yystack.valueAt (7-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1272:
		// if (yyn == 1272)
		// /* Line 350 of lalr1.java */
		// /* Line 9630 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_rtrim(((item)(yystack.valueAt
		// (7-(6)))),((item)(yystack.valueAt (7-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1273:
		// if (yyn == 1273)
		// /* Line 350 of lalr1.java */
		// /* Line 9636 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_trim(((item)(yystack.valueAt
		// (7-(6)))),((item)(yystack.valueAt (7-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1274:
		// if (yyn == 1274)
		// /* Line 350 of lalr1.java */
		// /* Line 9642 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_ltrim(((item)(yystack.valueAt
		// (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1275:
		// if (yyn == 1275)
		// /* Line 350 of lalr1.java */
		// /* Line 9648 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_rtrim(((item)(yystack.valueAt
		// (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1276:
		// if (yyn == 1276)
		// /* Line 350 of lalr1.java */
		// /* Line 9654 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_trim(((item)(yystack.valueAt
		// (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1277:
		// if (yyn == 1277)
		// /* Line 350 of lalr1.java */
		// /* Line 9660 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_trim(((item)(yystack.valueAt
		// (6-(5)))),((item)(yystack.valueAt (6-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1278:
		// if (yyn == 1278)
		// /* Line 350 of lalr1.java */
		// /* Line 9666 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_user();
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_SYSTEM_FUNCTION);
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1279:
		// if (yyn == 1279)
		// /* Line 350 of lalr1.java */
		// /* Line 9674 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_year(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1280:
		// if (yyn == 1280)
		// /* Line 350 of lalr1.java */
		// /* Line 9695 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt (6-(3)))),
		// ((item)(yystack.valueAt (6-(5)))),
		// INTERVAL_DAY, 0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1281:
		// if (yyn == 1281)
		// /* Line 350 of lalr1.java */
		// /* Line 9702 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt (8-(3)))),
		// ((item)(yystack.valueAt (8-(6)))), ((interval)(yystack.valueAt
		// (8-(7)))), 0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1282:
		// if (yyn == 1282)
		// /* Line 350 of lalr1.java */
		// /* Line 9708 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_curdate_local();
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1283:
		// if (yyn == 1283)
		// /* Line 350 of lalr1.java */
		// /* Line 9715 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_curtime_local(((ulong_num)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1284:
		// if (yyn == 1284)
		// /* Line 350 of lalr1.java */
		// /* Line 9723 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt
		// (8-(3)))),((item)(yystack.valueAt
		// (8-(6)))),((interval)(yystack.valueAt (8-(7)))),0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1285:
		// if (yyn == 1285)
		// /* Line 350 of lalr1.java */
		// /* Line 9730 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt
		// (8-(3)))),((item)(yystack.valueAt
		// (8-(6)))),((interval)(yystack.valueAt (8-(7)))),1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1286:
		// if (yyn == 1286)
		// /* Line 350 of lalr1.java */
		// /* Line 9736 of "sql_yacc.y" */
		// {
		// yyval=new (YYTHD->mem_root) Item_extract( ((interval)(yystack.valueAt
		// (6-(3)))), ((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1287:
		// if (yyn == 1287)
		// /* Line 350 of lalr1.java */
		// /* Line 9742 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_get_format(((date_time_type)(yystack.valueAt (6-(3)))),
		// ((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1288:
		// if (yyn == 1288)
		// /* Line 350 of lalr1.java */
		// /* Line 9748 of "sql_yacc.y" */
		// {
		// yyval= ((item)(yystack.valueAt (1-(1))));
		// Lex->safe_to_cache_query= 0;
		// };
		// break;
		//
		//
		// case 1289:
		// if (yyn == 1289)
		// /* Line 350 of lalr1.java */
		// /* Line 9753 of "sql_yacc.y" */
		// {
		// yyval = new (YYTHD->mem_root)
		// Item_func_locate(((item)(yystack.valueAt
		// (6-(5)))),((item)(yystack.valueAt (6-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1290:
		// if (yyn == 1290)
		// /* Line 350 of lalr1.java */
		// /* Line 9759 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt (6-(3)))),
		// ((item)(yystack.valueAt (6-(5)))),
		// INTERVAL_DAY, 1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1291:
		// if (yyn == 1291)
		// /* Line 350 of lalr1.java */
		// /* Line 9766 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt (8-(3)))),
		// ((item)(yystack.valueAt (8-(6)))), ((interval)(yystack.valueAt
		// (8-(7)))), 1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1292:
		// if (yyn == 1292)
		// /* Line 350 of lalr1.java */
		// /* Line 9772 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_substr(((item)(yystack.valueAt
		// (8-(3)))),((item)(yystack.valueAt (8-(5)))),((item)(yystack.valueAt
		// (8-(7)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1293:
		// if (yyn == 1293)
		// /* Line 350 of lalr1.java */
		// /* Line 9778 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_substr(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1294:
		// if (yyn == 1294)
		// /* Line 350 of lalr1.java */
		// /* Line 9784 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_substr(((item)(yystack.valueAt
		// (8-(3)))),((item)(yystack.valueAt (8-(5)))),((item)(yystack.valueAt
		// (8-(7)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1295:
		// if (yyn == 1295)
		// /* Line 350 of lalr1.java */
		// /* Line 9790 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_substr(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1296:
		// if (yyn == 1296)
		// /* Line 350 of lalr1.java */
		// /* Line 9796 of "sql_yacc.y" */
		// {
		// /*
		// Unlike other time-related functions, SYSDATE() is
		// replication-unsafe because it is not affected by the
		// TIMESTAMP variable. It is unsafe even if
		// sysdate_is_now=1, because the slave may have
		// sysdate_is_now=0.
		// */
		// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_SYSTEM_FUNCTION);
		// if (global_system_variables.sysdate_is_now == 0)
		// yyval= new (YYTHD->mem_root)
		// Item_func_sysdate_local(((ulong_num)(yystack.valueAt (2-(2)))));
		// else
		// yyval= new (YYTHD->mem_root)
		// Item_func_now_local(((ulong_num)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1297:
		// if (yyn == 1297)
		// /* Line 350 of lalr1.java */
		// /* Line 9814 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_date_add_interval(((item)(yystack.valueAt
		// (8-(7)))),((item)(yystack.valueAt
		// (8-(5)))),((interval_time_st)(yystack.valueAt (8-(3)))),0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1298:
		// if (yyn == 1298)
		// /* Line 350 of lalr1.java */
		// /* Line 9820 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_timestamp_diff(((item)(yystack.valueAt
		// (8-(5)))),((item)(yystack.valueAt
		// (8-(7)))),((interval_time_st)(yystack.valueAt (8-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1299:
		// if (yyn == 1299)
		// /* Line 350 of lalr1.java */
		// /* Line 9826 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_curdate_utc();
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1300:
		// if (yyn == 1300)
		// /* Line 350 of lalr1.java */
		// /* Line 9833 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_curtime_utc(((ulong_num)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1301:
		// if (yyn == 1301)
		// /* Line 350 of lalr1.java */
		// /* Line 9840 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_now_utc(((ulong_num)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1302:
		// if (yyn == 1302)
		// /* Line 350 of lalr1.java */
		// /* Line 9855 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_ascii(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1303:
		// if (yyn == 1303)
		// /* Line 350 of lalr1.java */
		// /* Line 9861 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_charset(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1304:
		// if (yyn == 1304)
		// /* Line 350 of lalr1.java */
		// /* Line 9867 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_coalesce(*
		// ((item_list)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1305:
		// if (yyn == 1305)
		// /* Line 350 of lalr1.java */
		// /* Line 9873 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_collation(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1306:
		// if (yyn == 1306)
		// /* Line 350 of lalr1.java */
		// /* Line 9879 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_database();
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->safe_to_cache_query=0;
		// };
		// break;
		//
		//
		// case 1307:
		// if (yyn == 1307)
		// /* Line 350 of lalr1.java */
		// /* Line 9886 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_if(((item)(yystack.valueAt
		// (8-(3)))),((item)(yystack.valueAt (8-(5)))),((item)(yystack.valueAt
		// (8-(7)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1308:
		// if (yyn == 1308)
		// /* Line 350 of lalr1.java */
		// /* Line 9892 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_format(((item)(yystack.valueAt
		// (6-(3)))), ((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1309:
		// if (yyn == 1309)
		// /* Line 350 of lalr1.java */
		// /* Line 9898 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_format(((item)(yystack.valueAt
		// (8-(3)))), ((item)(yystack.valueAt (8-(5)))), ((item)(yystack.valueAt
		// (8-(7)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1310:
		// if (yyn == 1310)
		// /* Line 350 of lalr1.java */
		// /* Line 9904 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_microsecond(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1311:
		// if (yyn == 1311)
		// /* Line 350 of lalr1.java */
		// /* Line 9910 of "sql_yacc.y" */
		// {
		// yyval = new (YYTHD->mem_root) Item_func_mod(((item)(yystack.valueAt
		// (6-(3)))), ((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1312:
		// if (yyn == 1312)
		// /* Line 350 of lalr1.java */
		// /* Line 9916 of "sql_yacc.y" */
		// {
		// WARN_DEPRECATED(YYTHD, "OLD_PASSWORD", "PASSWORD");
		// yyval= new (YYTHD->mem_root)
		// Item_func_old_password(((item)(yystack.valueAt (4-(3)))));
		// Lex->contains_plaintext_password= true;
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1313:
		// if (yyn == 1313)
		// /* Line 350 of lalr1.java */
		// /* Line 9924 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Item* i1;
		// Lex->contains_plaintext_password= true;
		// if (thd->variables.old_passwords == 1)
		// i1= new (thd->mem_root)
		// Item_func_old_password(((item)(yystack.valueAt (4-(3)))));
		// else
		// i1= new (thd->mem_root) Item_func_password(((item)(yystack.valueAt
		// (4-(3)))));
		// if (i1 == NULL)
		// return YYABORT;
		// yyval= i1;
		// };
		// break;
		//
		//
		// case 1314:
		// if (yyn == 1314)
		// /* Line 350 of lalr1.java */
		// /* Line 9937 of "sql_yacc.y" */
		// {
		// yyval = new (YYTHD->mem_root)
		// Item_func_quarter(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1315:
		// if (yyn == 1315)
		// /* Line 350 of lalr1.java */
		// /* Line 9943 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_repeat(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1316:
		// if (yyn == 1316)
		// /* Line 350 of lalr1.java */
		// /* Line 9949 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_replace(((item)(yystack.valueAt
		// (8-(3)))),((item)(yystack.valueAt (8-(5)))),((item)(yystack.valueAt
		// (8-(7)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1317:
		// if (yyn == 1317)
		// /* Line 350 of lalr1.java */
		// /* Line 9955 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_reverse(((item)(yystack.valueAt (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1318:
		// if (yyn == 1318)
		// /* Line 350 of lalr1.java */
		// /* Line 9961 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_row_count();
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_SYSTEM_FUNCTION);
		// Lex->safe_to_cache_query= 0;
		// };
		// break;
		//
		//
		// case 1319:
		// if (yyn == 1319)
		// /* Line 350 of lalr1.java */
		// /* Line 9969 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_round(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))),1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1320:
		// if (yyn == 1320)
		// /* Line 350 of lalr1.java */
		// /* Line 9975 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Item *i1= new (thd->mem_root) Item_int(NAME_STRING("0"),
		// thd->variables.default_week_format,
		// 1);
		// if (i1 == NULL)
		// return YYABORT;
		// yyval= new (thd->mem_root) Item_func_week(((item)(yystack.valueAt
		// (4-(3)))), i1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1321:
		// if (yyn == 1321)
		// /* Line 350 of lalr1.java */
		// /* Line 9987 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_func_week(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1322:
		// if (yyn == 1322)
		// /* Line 350 of lalr1.java */
		// /* Line 9993 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_weight_string(((item)(yystack.valueAt (5-(3)))), 0, 0,
		// ((ulong_num)(yystack.valueAt (5-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1323:
		// if (yyn == 1323)
		// /* Line 350 of lalr1.java */
		// /* Line 9999 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_weight_string(((item)(yystack.valueAt (8-(3)))), 0,
		// ((ulong_num)(yystack.valueAt (8-(6)))),
		// ((ulong_num)(yystack.valueAt (8-(7)))) | MY_STRXFRM_PAD_WITH_SPACE);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1324:
		// if (yyn == 1324)
		// /* Line 350 of lalr1.java */
		// /* Line 10007 of "sql_yacc.y" */
		// {
		// Item *item= new (YYTHD->mem_root)
		// Item_char_typecast(((item)(yystack.valueAt (7-(3)))),
		// ((ulong_num)(yystack.valueAt (7-(6)))), &my_charset_bin);
		// if (item == NULL)
		// return YYABORT;
		// yyval= new (YYTHD->mem_root)
		// Item_func_weight_string(item, 0, ((ulong_num)(yystack.valueAt
		// (7-(6)))), MY_STRXFRM_PAD_WITH_SPACE);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1325:
		// if (yyn == 1325)
		// /* Line 350 of lalr1.java */
		// /* Line 10017 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_weight_string(((item)(yystack.valueAt (10-(3)))),
		// ((ulong_num)(yystack.valueAt (10-(5)))), ((ulong_num)(yystack.valueAt
		// (10-(7)))), ((ulong_num)(yystack.valueAt (10-(9)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1326:
		// if (yyn == 1326)
		// /* Line 350 of lalr1.java */
		// /* Line 10023 of "sql_yacc.y" */
		// {
		// #ifdef HAVE_SPATIAL
		// yyval= ((item)(yystack.valueAt (1-(1))));
		// /* $1 may be NULL, GEOM_NEW not tested for out of memory */
		// if (yyval == NULL)
		// return YYABORT;
		// #else
		// my_error(ER_FEATURE_DISABLED, MYF(0),
		// sym_group_geom.name, sym_group_geom.needed_define);
		// return YYABORT;
		// #endif
		// };
		// break;
		//
		//
		// case 1327:
		// if (yyn == 1327)
		// /* Line 350 of lalr1.java */
		// /* Line 10039 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_mbr_rel(((item)(yystack.valueAt (6-(3)))),
		// ((item)(yystack.valueAt (6-(5)))),
		// Item_func::SP_CONTAINS_FUNC));
		// };
		// break;
		//
		//
		// case 1328:
		// if (yyn == 1328)
		// /* Line 350 of lalr1.java */
		// /* Line 10045 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_collection(* ((item_list)(yystack.valueAt
		// (4-(3)))),
		// Geometry::wkb_geometrycollection,
		// Geometry::wkb_point));
		// };
		// break;
		//
		//
		// case 1329:
		// if (yyn == 1329)
		// /* Line 350 of lalr1.java */
		// /* Line 10052 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_collection(* ((item_list)(yystack.valueAt
		// (4-(3)))),
		// Geometry::wkb_linestring,
		// Geometry::wkb_point));
		// };
		// break;
		//
		//
		// case 1330:
		// if (yyn == 1330)
		// /* Line 350 of lalr1.java */
		// /* Line 10059 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_collection(* ((item_list)(yystack.valueAt
		// (4-(3)))),
		// Geometry::wkb_multilinestring,
		// Geometry::wkb_linestring));
		// };
		// break;
		//
		//
		// case 1331:
		// if (yyn == 1331)
		// /* Line 350 of lalr1.java */
		// /* Line 10066 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_collection(* ((item_list)(yystack.valueAt
		// (4-(3)))),
		// Geometry::wkb_multipoint,
		// Geometry::wkb_point));
		// };
		// break;
		//
		//
		// case 1332:
		// if (yyn == 1332)
		// /* Line 350 of lalr1.java */
		// /* Line 10073 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_collection(* ((item_list)(yystack.valueAt
		// (4-(3)))),
		// Geometry::wkb_multipolygon,
		// Geometry::wkb_polygon));
		// };
		// break;
		//
		//
		// case 1333:
		// if (yyn == 1333)
		// /* Line 350 of lalr1.java */
		// /* Line 10080 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD, Item_func_point(((item)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(5))))));
		// };
		// break;
		//
		//
		// case 1334:
		// if (yyn == 1334)
		// /* Line 350 of lalr1.java */
		// /* Line 10084 of "sql_yacc.y" */
		// {
		// yyval= GEOM_NEW(YYTHD,
		// Item_func_spatial_collection(* ((item_list)(yystack.valueAt
		// (4-(3)))),
		// Geometry::wkb_polygon,
		// Geometry::wkb_linestring));
		// };
		// break;
		//
		//
		case 1335:
			if (yyn == 1335)
			/* Line 350 of lalr1.java */
			/* Line 10103 of "sql_yacc.y" */
			{
				// #ifdef HAVE_DLOPEN
				// udf_func *udf= 0;
				// LEX *lex= Lex;
				// if (using_udf_functions &&
				// (udf= find_udf(((lex_str)(yystack.valueAt (2-(1)))).str,
				// ((lex_str)(yystack.valueAt (2-(1)))).length)) &&
				// udf->type == UDFTYPE_AGGREGATE)
				// {
				// if (lex->current_select->inc_in_sum_expr())
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// }
				// /* Temporary placing the result of find_udf in $3 */
				// yyval= udf;
				// #endif
			}
			;
			break;
		//
		//
		// case 1336:
		// if (yyn == 1336)
		// /* Line 350 of lalr1.java */
		// /* Line 10122 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Create_func *builder;
		// Item *item= NULL;
		//
		// if (sp_check_name(&((lex_str)(yystack.valueAt (5-(1))))))
		// {
		// return YYABORT;
		// }
		//
		// /*
		// Implementation note:
		// names are resolved with the following order:
		// - MySQL native functions,
		// - User Defined Functions,
		// - Stored Functions (assuming the current <use> database)
		//
		// This will be revised with WL#2128 (SQL PATH)
		// */
		// builder= find_native_function_builder(thd, ((lex_str)(yystack.valueAt
		// (5-(1)))));
		// if (builder)
		// {
		// item= builder->create_func(thd, ((lex_str)(yystack.valueAt (5-(1)))),
		// ((item_list)(yystack.valueAt (5-(4)))));
		// }
		// else
		// {
		// #ifdef HAVE_DLOPEN
		// /* Retrieving the result of find_udf */
		// udf_func *udf= ((udf)(yystack.valueAt (5-(3))));
		//
		// if (udf)
		// {
		// if (udf->type == UDFTYPE_AGGREGATE)
		// {
		// Select->in_sum_expr--;
		// }
		//
		// item= Create_udf_func::s_singleton.create(thd, udf,
		// ((item_list)(yystack.valueAt (5-(4)))));
		// }
		// else
		// #endif
		// {
		// builder= find_qualified_function_builder(thd);
		// DBUG_ASSERT(builder);
		// item= builder->create_func(thd, ((lex_str)(yystack.valueAt (5-(1)))),
		// ((item_list)(yystack.valueAt (5-(4)))));
		// }
		// }
		//
		// if (! (yyval= item))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1337:
		// if (yyn == 1337)
		// /* Line 350 of lalr1.java */
		// /* Line 10176 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Create_qfunc *builder;
		// Item *item= NULL;
		//
		// /*
		// The following in practice calls:
		// <code>Create_sp_func::create()</code>
		// and builds a stored function.
		//
		// However, it's important to maintain the interface between the
		// parser and the implementation in item_create.cc clean,
		// since this will change with WL#2128 (SQL PATH):
		// - INFORMATION_SCHEMA.version() is the SQL 99 syntax for the native
		// function version(),
		// - MySQL.version() is the SQL 2003 syntax for the native function
		// version() (a vendor can specify any schema).
		// */
		//
		// if (!((lex_str)(yystack.valueAt (6-(1)))).str ||
		// (check_and_convert_db_name(&((lex_str)(yystack.valueAt (6-(1)))),
		// FALSE) != IDENT_NAME_OK))
		// return YYABORT;
		// if (sp_check_name(&((lex_str)(yystack.valueAt (6-(3))))))
		// {
		// return YYABORT;
		// }
		//
		// builder= find_qualified_function_builder(thd);
		// DBUG_ASSERT(builder);
		// item= builder->create(thd, ((lex_str)(yystack.valueAt (6-(1)))),
		// ((lex_str)(yystack.valueAt (6-(3)))), true,
		// ((item_list)(yystack.valueAt (6-(5)))));
		//
		// if (! (yyval= item))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1338:
		// if (yyn == 1338)
		// /* Line 350 of lalr1.java */
		// /* Line 10216 of "sql_yacc.y" */
		// { yyval= ((num)(yystack.valueAt (2-(1)))) | ((num)(yystack.valueAt
		// (2-(2)))); };
		// break;
		//
		//
		// case 1339:
		// if (yyn == 1339)
		// /* Line 350 of lalr1.java */
		// /* Line 10218 of "sql_yacc.y" */
		// { yyval= FT_BOOL; };
		// break;
		//
		//
		// case 1340:
		// if (yyn == 1340)
		// /* Line 350 of lalr1.java */
		// /* Line 10222 of "sql_yacc.y" */
		// { yyval= FT_NL; };
		// break;
		//
		//
		// case 1341:
		// if (yyn == 1341)
		// /* Line 350 of lalr1.java */
		// /* Line 10223 of "sql_yacc.y" */
		// { yyval= FT_NL; };
		// break;
		//
		//
		// case 1342:
		// if (yyn == 1342)
		// /* Line 350 of lalr1.java */
		// /* Line 10227 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 1343:
		// if (yyn == 1343)
		// /* Line 350 of lalr1.java */
		// /* Line 10228 of "sql_yacc.y" */
		// { yyval= FT_EXPAND; };
		// break;
		//
		//
		// case 1344:
		// if (yyn == 1344)
		// /* Line 350 of lalr1.java */
		// /* Line 10232 of "sql_yacc.y" */
		// { yyval= NULL; };
		// break;
		//
		//
		// case 1345:
		// if (yyn == 1345)
		// /* Line 350 of lalr1.java */
		// /* Line 10233 of "sql_yacc.y" */
		// { yyval= ((item_list)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1346:
		// if (yyn == 1346)
		// /* Line 350 of lalr1.java */
		// /* Line 10238 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) List<Item>;
		// if (yyval == NULL)
		// return YYABORT;
		// yyval->push_back(((item)(yystack.valueAt (1-(1)))));
		// };
		// break;
		//
		//
		// case 1347:
		// if (yyn == 1347)
		// /* Line 350 of lalr1.java */
		// /* Line 10245 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (3-(1))))->push_back(((item)(yystack.valueAt (3-(3)))));
		// yyval= ((item_list)(yystack.valueAt (3-(1))));
		// };
		// break;
		//
		//
		// case 1348:
		// if (yyn == 1348)
		// /* Line 350 of lalr1.java */
		// /* Line 10253 of "sql_yacc.y" */
		// {
		// /*
		// Use Item::name as a storage for the attribute value of user
		// defined function argument. It is safe to use Item::name
		// because the syntax will not allow having an explicit name here.
		// See WL#1017 re. udf attributes.
		// */
		// if (((lex_str)(yystack.valueAt (4-(4)))).str)
		// {
		// ((item)(yystack.valueAt
		// (4-(2))))->item_name.copy(((lex_str)(yystack.valueAt (4-(4)))).str,
		// ((lex_str)(yystack.valueAt (4-(4)))).length, system_charset_info,
		// false);
		// }
		// /*
		// A field has to have its proper name in order for name
		// resolution to work, something we are only guaranteed if we
		// parse it out. If we hijack the input stream with
		// remember_name we may get quoted or escaped names.
		// */
		// else if (((item)(yystack.valueAt (4-(2))))->type() !=
		// Item::FIELD_ITEM &&
		// ((item)(yystack.valueAt (4-(2))))->type() != Item::REF_ITEM /* For
		// HAVING */ )
		// ((item)(yystack.valueAt
		// (4-(2))))->item_name.copy(((simple_string)(yystack.valueAt (4-(1)))),
		// (uint) (((simple_string)(yystack.valueAt (4-(3)))) -
		// ((simple_string)(yystack.valueAt (4-(1))))), YYTHD->charset());
		// yyval= ((item)(yystack.valueAt (4-(2))));
		// };
		// break;
		//
		//
		// case 1349:
		// if (yyn == 1349)
		// /* Line 350 of lalr1.java */
		// /* Line 10279 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_avg(((item)(yystack.valueAt
		// (4-(3)))), FALSE);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1350:
		// if (yyn == 1350)
		// /* Line 350 of lalr1.java */
		// /* Line 10285 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_avg(((item)(yystack.valueAt
		// (5-(4)))), TRUE);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1351:
		// if (yyn == 1351)
		// /* Line 350 of lalr1.java */
		// /* Line 10291 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_and(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1352:
		// if (yyn == 1352)
		// /* Line 350 of lalr1.java */
		// /* Line 10297 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_or(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1353:
		// if (yyn == 1353)
		// /* Line 350 of lalr1.java */
		// /* Line 10303 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_xor(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1354:
		// if (yyn == 1354)
		// /* Line 350 of lalr1.java */
		// /* Line 10309 of "sql_yacc.y" */
		// {
		// Item *item= new (YYTHD->mem_root) Item_int((int32) 0L,1);
		// if (item == NULL)
		// return YYABORT;
		// yyval= new (YYTHD->mem_root) Item_sum_count(item);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1355:
		// if (yyn == 1355)
		// /* Line 350 of lalr1.java */
		// /* Line 10318 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_count(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1356:
		// if (yyn == 1356)
		// /* Line 350 of lalr1.java */
		// /* Line 10324 of "sql_yacc.y" */
		// { Select->in_sum_expr++; };
		// break;
		//
		//
		// case 1357:
		// if (yyn == 1357)
		// /* Line 350 of lalr1.java */
		// /* Line 10326 of "sql_yacc.y" */
		// { Select->in_sum_expr--; };
		// break;
		//
		//
		// case 1358:
		// if (yyn == 1358)
		// /* Line 350 of lalr1.java */
		// /* Line 10328 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_count(*
		// ((item_list)(yystack.valueAt (7-(5)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1359:
		// if (yyn == 1359)
		// /* Line 350 of lalr1.java */
		// /* Line 10334 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_min(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1360:
		// if (yyn == 1360)
		// /* Line 350 of lalr1.java */
		// /* Line 10345 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_min(((item)(yystack.valueAt
		// (5-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1361:
		// if (yyn == 1361)
		// /* Line 350 of lalr1.java */
		// /* Line 10351 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_max(((item)(yystack.valueAt
		// (4-(3)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1362:
		// if (yyn == 1362)
		// /* Line 350 of lalr1.java */
		// /* Line 10357 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_max(((item)(yystack.valueAt
		// (5-(4)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1363:
		// if (yyn == 1363)
		// /* Line 350 of lalr1.java */
		// /* Line 10363 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_std(((item)(yystack.valueAt
		// (4-(3)))), 0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1364:
		// if (yyn == 1364)
		// /* Line 350 of lalr1.java */
		// /* Line 10369 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_sum_variance(((item)(yystack.valueAt (4-(3)))), 0);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1365:
		// if (yyn == 1365)
		// /* Line 350 of lalr1.java */
		// /* Line 10375 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_std(((item)(yystack.valueAt
		// (4-(3)))), 1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1366:
		// if (yyn == 1366)
		// /* Line 350 of lalr1.java */
		// /* Line 10381 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_sum_variance(((item)(yystack.valueAt (4-(3)))), 1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1367:
		// if (yyn == 1367)
		// /* Line 350 of lalr1.java */
		// /* Line 10387 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_sum(((item)(yystack.valueAt
		// (4-(3)))), FALSE);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1368:
		// if (yyn == 1368)
		// /* Line 350 of lalr1.java */
		// /* Line 10393 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_sum_sum(((item)(yystack.valueAt
		// (5-(4)))), TRUE);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1369:
		// if (yyn == 1369)
		// /* Line 350 of lalr1.java */
		// /* Line 10399 of "sql_yacc.y" */
		// { Select->in_sum_expr++; };
		// break;
		//
		//
		// case 1370:
		// if (yyn == 1370)
		// /* Line 350 of lalr1.java */
		// /* Line 10403 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->in_sum_expr--;
		// yyval= new (YYTHD->mem_root)
		// Item_func_group_concat(Lex->current_context(), ((num)(yystack.valueAt
		// (8-(3)))), ((item_list)(yystack.valueAt (8-(5)))),
		// sel->gorder_list, ((string)(yystack.valueAt (8-(7)))));
		// if (yyval == NULL)
		// return YYABORT;
		// ((item_list)(yystack.valueAt (8-(5))))->empty();
		// sel->gorder_list.empty();
		// };
		// break;
		//
		//
		// case 1371:
		// if (yyn == 1371)
		// /* Line 350 of lalr1.java */
		// /* Line 10418 of "sql_yacc.y" */
		// {
		// if (! Lex->parsing_options.allows_variable)
		// {
		// my_error(ER_VIEW_SELECT_VARIABLE, MYF(0));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1372:
		// if (yyn == 1372)
		// /* Line 350 of lalr1.java */
		// /* Line 10426 of "sql_yacc.y" */
		// {
		// yyval= ((item)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1373:
		// if (yyn == 1373)
		// /* Line 350 of lalr1.java */
		// /* Line 10433 of "sql_yacc.y" */
		// {
		// Item_func_set_user_var *item;
		// yyval= item=
		// new (YYTHD->mem_root)
		// Item_func_set_user_var(((lex_str)(yystack.valueAt (3-(1)))),
		// ((item)(yystack.valueAt (3-(3)))), false);
		// if (yyval == NULL)
		// return YYABORT;
		// LEX *lex= Lex;
		// lex->uncacheable(UNCACHEABLE_RAND);
		// lex->set_var_list.push_back(item);
		// };
		// break;
		//
		//
		// case 1374:
		// if (yyn == 1374)
		// /* Line 350 of lalr1.java */
		// /* Line 10444 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_func_get_user_var(((lex_str)(yystack.valueAt (1-(1)))));
		// if (yyval == NULL)
		// return YYABORT;
		// LEX *lex= Lex;
		// lex->uncacheable(UNCACHEABLE_RAND);
		// };
		// break;
		//
		//
		case 1375:
			if (yyn == 1375)
			/* Line 350 of lalr1.java */
			/* Line 10452 of "sql_yacc.y" */
			{
				// /* disallow "SELECT @@global.global.variable" */
				// if (((lex_str)(yystack.valueAt (4-(3)))).str &&
				// ((lex_str)(yystack.valueAt (4-(4)))).str &&
				// check_reserved_words(&((lex_str)(yystack.valueAt (4-(3))))))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// if (!(yyval= get_system_var(YYTHD,
				// ((var_type)(yystack.valueAt
				// (4-(2)))), ((lex_str)(yystack.valueAt (4-(3)))),
				// ((lex_str)(yystack.valueAt (4-(4)))))))
				// return YYABORT;
				// if (!((Item_func_get_system_var*)
				// yyval)->is_written_to_binlog())
				// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_SYSTEM_VARIABLE);
			}
			;
			break;
		//
		//
		// case 1376:
		// if (yyn == 1376)
		// /* Line 350 of lalr1.java */
		// /* Line 10467 of "sql_yacc.y" */
		// { yyval = 0; };
		// break;
		//
		//
		// case 1377:
		// if (yyn == 1377)
		// /* Line 350 of lalr1.java */
		// /* Line 10468 of "sql_yacc.y" */
		// { yyval = 1; };
		// break;
		//
		//
		// case 1378:
		// if (yyn == 1378)
		// /* Line 350 of lalr1.java */
		// /* Line 10473 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) String(",", 1, &my_charset_latin1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1379:
		// if (yyn == 1379)
		// /* Line 350 of lalr1.java */
		// /* Line 10478 of "sql_yacc.y" */
		// { yyval = ((string)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 1381:
		// if (yyn == 1381)
		// /* Line 350 of lalr1.java */
		// /* Line 10484 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// SELECT_LEX *sel= lex->current_select;
		// if (sel->linkage != GLOBAL_OPTIONS_TYPE &&
		// sel->olap != UNSPECIFIED_OLAP_TYPE &&
		// (sel->linkage != UNION_TYPE || sel->braces))
		// {
		// my_error(ER_WRONG_USAGE, MYF(0),
		// "CUBE/ROLLUP", "ORDER BY");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1383:
		// if (yyn == 1383)
		// /* Line 350 of lalr1.java */
		// /* Line 10501 of "sql_yacc.y" */
		// { if (add_gorder_to_list(YYTHD, ((item)(yystack.valueAt
		// (4-(3)))),(bool) ((num)(yystack.valueAt (4-(4)))))) return YYABORT;
		// };
		// break;
		//
		//
		// case 1384:
		// if (yyn == 1384)
		// /* Line 350 of lalr1.java */
		// /* Line 10503 of "sql_yacc.y" */
		// { if (add_gorder_to_list(YYTHD, ((item)(yystack.valueAt
		// (2-(1)))),(bool) ((num)(yystack.valueAt (2-(2)))))) return YYABORT;
		// };
		// break;
		//
		//
		case 1385:
			if (yyn == 1385)
			/* Line 350 of lalr1.java */
			/* Line 10508 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// if (lex->current_select->inc_in_sum_expr())
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		// case 1386:
		// if (yyn == 1386)
		// /* Line 350 of lalr1.java */
		// /* Line 10517 of "sql_yacc.y" */
		// {
		// Select->in_sum_expr--;
		// yyval= ((item)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1387:
		// if (yyn == 1387)
		// /* Line 350 of lalr1.java */
		// /* Line 10525 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_CHAR; Lex->charset= &my_charset_bin; Lex->dec= 0;
		// };
		// break;
		//
		//
		// case 1388:
		// if (yyn == 1388)
		// /* Line 350 of lalr1.java */
		// /* Line 10527 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_CHAR; Lex->dec= 0; };
		// break;
		//
		//
		// case 1389:
		// if (yyn == 1389)
		// /* Line 350 of lalr1.java */
		// /* Line 10529 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_CHAR; Lex->charset= national_charset_info;
		// Lex->dec=0; };
		// break;
		//
		//
		// case 1390:
		// if (yyn == 1390)
		// /* Line 350 of lalr1.java */
		// /* Line 10531 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_SIGNED_INT; Lex->charset= NULL;
		// Lex->dec=Lex->length= (char*)0; };
		// break;
		//
		//
		// case 1391:
		// if (yyn == 1391)
		// /* Line 350 of lalr1.java */
		// /* Line 10533 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_SIGNED_INT; Lex->charset= NULL;
		// Lex->dec=Lex->length= (char*)0; };
		// break;
		//
		//
		// case 1392:
		// if (yyn == 1392)
		// /* Line 350 of lalr1.java */
		// /* Line 10535 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_UNSIGNED_INT; Lex->charset= NULL;
		// Lex->dec=Lex->length= (char*)0; };
		// break;
		//
		//
		// case 1393:
		// if (yyn == 1393)
		// /* Line 350 of lalr1.java */
		// /* Line 10537 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_UNSIGNED_INT; Lex->charset= NULL;
		// Lex->dec=Lex->length= (char*)0; };
		// break;
		//
		//
		// case 1394:
		// if (yyn == 1394)
		// /* Line 350 of lalr1.java */
		// /* Line 10539 of "sql_yacc.y" */
		// { yyval= ITEM_CAST_DATE; Lex->charset= NULL; Lex->dec= Lex->length=
		// (char *) 0; };
		// break;
		//
		//
		// case 1395:
		// if (yyn == 1395)
		// /* Line 350 of lalr1.java */
		// /* Line 10541 of "sql_yacc.y" */
		// { yyval= ITEM_CAST_TIME; Lex->charset= NULL; Lex->length= (char *) 0;
		// };
		// break;
		//
		//
		// case 1396:
		// if (yyn == 1396)
		// /* Line 350 of lalr1.java */
		// /* Line 10543 of "sql_yacc.y" */
		// { yyval= ITEM_CAST_DATETIME; Lex->charset= NULL; Lex->length= (char
		// *) 0; };
		// break;
		//
		//
		// case 1397:
		// if (yyn == 1397)
		// /* Line 350 of lalr1.java */
		// /* Line 10545 of "sql_yacc.y" */
		// { yyval=ITEM_CAST_DECIMAL; Lex->charset= NULL; };
		// break;
		//
		//
		// case 1398:
		// if (yyn == 1398)
		// /* Line 350 of lalr1.java */
		// /* Line 10549 of "sql_yacc.y" */
		// { yyval= NULL; };
		// break;
		//
		//
		// case 1399:
		// if (yyn == 1399)
		// /* Line 350 of lalr1.java */
		// /* Line 10550 of "sql_yacc.y" */
		// { yyval= ((item_list)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1400:
		// if (yyn == 1400)
		// /* Line 350 of lalr1.java */
		// /* Line 10555 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) List<Item>;
		// if (yyval == NULL)
		// return YYABORT;
		// yyval->push_back(((item)(yystack.valueAt (1-(1)))));
		// };
		// break;
		//
		//
		// case 1401:
		// if (yyn == 1401)
		// /* Line 350 of lalr1.java */
		// /* Line 10562 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (3-(1))))->push_back(((item)(yystack.valueAt (3-(3)))));
		// yyval= ((item_list)(yystack.valueAt (3-(1))));
		// };
		// break;
		//
		//
		// case 1402:
		// if (yyn == 1402)
		// /* Line 350 of lalr1.java */
		// /* Line 10569 of "sql_yacc.y" */
		// { yyval= ((item_list)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1403:
		// if (yyn == 1403)
		// /* Line 350 of lalr1.java */
		// /* Line 10570 of "sql_yacc.y" */
		// { yyval= ((item_list)(yystack.valueAt (3-(2)))); };
		// break;
		//
		//
		// case 1404:
		// if (yyn == 1404)
		// /* Line 350 of lalr1.java */
		// /* Line 10575 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) List<Item>;
		// if (yyval == NULL)
		// return YYABORT;
		// yyval->push_back(((item)(yystack.valueAt (1-(1)))));
		// };
		// break;
		//
		//
		// case 1405:
		// if (yyn == 1405)
		// /* Line 350 of lalr1.java */
		// /* Line 10582 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (3-(1))))->push_back(((item)(yystack.valueAt (3-(3)))));
		// yyval= ((item_list)(yystack.valueAt (3-(1))));
		// };
		// break;
		//
		//
		// case 1406:
		// if (yyn == 1406)
		// /* Line 350 of lalr1.java */
		// /* Line 10589 of "sql_yacc.y" */
		// { yyval= NULL; };
		// break;
		//
		//
		// case 1407:
		// if (yyn == 1407)
		// /* Line 350 of lalr1.java */
		// /* Line 10590 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1408:
		// if (yyn == 1408)
		// /* Line 350 of lalr1.java */
		// /* Line 10594 of "sql_yacc.y" */
		// { yyval= NULL; };
		// break;
		//
		//
		// case 1409:
		// if (yyn == 1409)
		// /* Line 350 of lalr1.java */
		// /* Line 10595 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 1410:
		// if (yyn == 1410)
		// /* Line 350 of lalr1.java */
		// /* Line 10600 of "sql_yacc.y" */
		// {
		// yyval= new List<Item>;
		// if (yyval == NULL)
		// return YYABORT;
		// yyval->push_back(((item)(yystack.valueAt (4-(2)))));
		// yyval->push_back(((item)(yystack.valueAt (4-(4)))));
		// };
		// break;
		//
		//
		// case 1411:
		// if (yyn == 1411)
		// /* Line 350 of lalr1.java */
		// /* Line 10608 of "sql_yacc.y" */
		// {
		// ((item_list)(yystack.valueAt
		// (5-(1))))->push_back(((item)(yystack.valueAt (5-(3)))));
		// ((item_list)(yystack.valueAt
		// (5-(1))))->push_back(((item)(yystack.valueAt (5-(5)))));
		// yyval= ((item_list)(yystack.valueAt (5-(1))));
		// };
		// break;
		//
		//
		// case 1412:
		// if (yyn == 1412)
		// /* Line 350 of lalr1.java */
		// /* Line 10618 of "sql_yacc.y" */
		// { yyval=((table_list)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1413:
		// if (yyn == 1413)
		// /* Line 350 of lalr1.java */
		// /* Line 10620 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (!(yyval= lex->current_select->nest_last_join(lex->thd)))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1414:
		// if (yyn == 1414)
		// /* Line 350 of lalr1.java */
		// /* Line 10628 of "sql_yacc.y" */
		// { return YYABORT;_UNLESS(yyval=((table_list)(yystack.valueAt
		// (1-(1))))); };
		// break;
		//
		//
		// case 1415:
		// if (yyn == 1415)
		// /* Line 350 of lalr1.java */
		// /* Line 10639 of "sql_yacc.y" */
		// { yyval=((table_list)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1416:
		// if (yyn == 1416)
		// /* Line 350 of lalr1.java */
		// /* Line 10640 of "sql_yacc.y" */
		// { yyval=((table_list)(yystack.valueAt (4-(3)))); };
		// break;
		//
		//
		// case 1417:
		// if (yyn == 1417)
		// /* Line 350 of lalr1.java */
		// /* Line 10646 of "sql_yacc.y" */
		// { yyval=((table_list)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1418:
		// if (yyn == 1418)
		// /* Line 350 of lalr1.java */
		// /* Line 10648 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (3-(1)))) &&
		// (yyval=((table_list)(yystack.valueAt (3-(3))))));
		// };
		// break;
		//
		//
		// case 1419:
		// if (yyn == 1419)
		// /* Line 350 of lalr1.java */
		// /* Line 10668 of "sql_yacc.y" */
		// { return YYABORT;_UNLESS(((table_list)(yystack.valueAt (3-(1)))) &&
		// (yyval=((table_list)(yystack.valueAt (3-(3)))))); };
		// break;
		//
		//
		// case 1420:
		// if (yyn == 1420)
		// /* Line 350 of lalr1.java */
		// /* Line 10670 of "sql_yacc.y" */
		// { return YYABORT;_UNLESS(((table_list)(yystack.valueAt (3-(1)))) &&
		// (yyval=((table_list)(yystack.valueAt (3-(3))))));
		// ((table_list)(yystack.valueAt (3-(3))))->straight=1; };
		// break;
		//
		//
		// case 1421:
		// if (yyn == 1421)
		// /* Line 350 of lalr1.java */
		// /* Line 10673 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (4-(1)))) &&
		// ((table_list)(yystack.valueAt (4-(3)))));
		// /* Change the current name resolution context to a local context. */
		// if (push_new_name_resolution_context(YYTHD,
		// ((table_list)(yystack.valueAt (4-(1)))),
		// ((table_list)(yystack.valueAt (4-(3))))))
		// return YYABORT;
		// Select->parsing_place= IN_ON;
		// };
		// break;
		//
		//
		// case 1422:
		// if (yyn == 1422)
		// /* Line 350 of lalr1.java */
		// /* Line 10681 of "sql_yacc.y" */
		// {
		// add_join_on(((table_list)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(6)))));
		// Lex->pop_context();
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1423:
		// if (yyn == 1423)
		// /* Line 350 of lalr1.java */
		// /* Line 10688 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (4-(1)))) &&
		// ((table_list)(yystack.valueAt (4-(3)))));
		// /* Change the current name resolution context to a local context. */
		// if (push_new_name_resolution_context(YYTHD,
		// ((table_list)(yystack.valueAt (4-(1)))),
		// ((table_list)(yystack.valueAt (4-(3))))))
		// return YYABORT;
		// Select->parsing_place= IN_ON;
		// };
		// break;
		//
		//
		// case 1424:
		// if (yyn == 1424)
		// /* Line 350 of lalr1.java */
		// /* Line 10696 of "sql_yacc.y" */
		// {
		// ((table_list)(yystack.valueAt (6-(3))))->straight=1;
		// add_join_on(((table_list)(yystack.valueAt
		// (6-(3)))),((item)(yystack.valueAt (6-(6)))));
		// Lex->pop_context();
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1425:
		// if (yyn == 1425)
		// /* Line 350 of lalr1.java */
		// /* Line 10704 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (4-(1)))) &&
		// ((table_list)(yystack.valueAt (4-(3)))));
		// };
		// break;
		//
		//
		// case 1426:
		// if (yyn == 1426)
		// /* Line 350 of lalr1.java */
		// /* Line 10708 of "sql_yacc.y" */
		// { add_join_natural(((table_list)(yystack.valueAt
		// (8-(1)))),((table_list)(yystack.valueAt
		// (8-(3)))),((string_list)(yystack.valueAt (8-(7)))),Select);
		// yyval=((table_list)(yystack.valueAt (8-(3)))); };
		// break;
		//
		//
		// case 1427:
		// if (yyn == 1427)
		// /* Line 350 of lalr1.java */
		// /* Line 10710 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (4-(1)))) &&
		// (yyval=((table_list)(yystack.valueAt (4-(4))))));
		// add_join_natural(((table_list)(yystack.valueAt
		// (4-(1)))),((table_list)(yystack.valueAt (4-(4)))),NULL,Select);
		// };
		// break;
		//
		//
		// case 1428:
		// if (yyn == 1428)
		// /* Line 350 of lalr1.java */
		// /* Line 10718 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (6-(1)))) &&
		// ((table_list)(yystack.valueAt (6-(5)))));
		// /* Change the current name resolution context to a local context. */
		// if (push_new_name_resolution_context(YYTHD,
		// ((table_list)(yystack.valueAt (6-(1)))),
		// ((table_list)(yystack.valueAt (6-(5))))))
		// return YYABORT;
		// Select->parsing_place= IN_ON;
		// };
		// break;
		//
		//
		// case 1429:
		// if (yyn == 1429)
		// /* Line 350 of lalr1.java */
		// /* Line 10726 of "sql_yacc.y" */
		// {
		// add_join_on(((table_list)(yystack.valueAt
		// (8-(5)))),((item)(yystack.valueAt (8-(8)))));
		// Lex->pop_context();
		// ((table_list)(yystack.valueAt (8-(5))))->outer_join|=JOIN_TYPE_LEFT;
		// yyval=((table_list)(yystack.valueAt (8-(5))));
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1430:
		// if (yyn == 1430)
		// /* Line 350 of lalr1.java */
		// /* Line 10734 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (5-(1)))) &&
		// ((table_list)(yystack.valueAt (5-(5)))));
		// };
		// break;
		//
		//
		// case 1431:
		// if (yyn == 1431)
		// /* Line 350 of lalr1.java */
		// /* Line 10738 of "sql_yacc.y" */
		// {
		// add_join_natural(((table_list)(yystack.valueAt
		// (10-(1)))),((table_list)(yystack.valueAt
		// (10-(5)))),((string_list)(yystack.valueAt (10-(9)))),Select);
		// ((table_list)(yystack.valueAt (10-(5))))->outer_join|=JOIN_TYPE_LEFT;
		// yyval=((table_list)(yystack.valueAt (10-(5))));
		// };
		// break;
		//
		//
		// case 1432:
		// if (yyn == 1432)
		// /* Line 350 of lalr1.java */
		// /* Line 10744 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (6-(1)))) &&
		// ((table_list)(yystack.valueAt (6-(6)))));
		// add_join_natural(((table_list)(yystack.valueAt
		// (6-(1)))),((table_list)(yystack.valueAt (6-(6)))),NULL,Select);
		// ((table_list)(yystack.valueAt (6-(6))))->outer_join|=JOIN_TYPE_LEFT;
		// yyval=((table_list)(yystack.valueAt (6-(6))));
		// };
		// break;
		//
		//
		// case 1433:
		// if (yyn == 1433)
		// /* Line 350 of lalr1.java */
		// /* Line 10754 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (6-(1)))) &&
		// ((table_list)(yystack.valueAt (6-(5)))));
		// /* Change the current name resolution context to a local context. */
		// if (push_new_name_resolution_context(YYTHD,
		// ((table_list)(yystack.valueAt (6-(1)))),
		// ((table_list)(yystack.valueAt (6-(5))))))
		// return YYABORT;
		// Select->parsing_place= IN_ON;
		// };
		// break;
		//
		//
		// case 1434:
		// if (yyn == 1434)
		// /* Line 350 of lalr1.java */
		// /* Line 10762 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (!(yyval= lex->current_select->convert_right_join()))
		// return YYABORT;
		// add_join_on(yyval, ((item)(yystack.valueAt (8-(8)))));
		// Lex->pop_context();
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1435:
		// if (yyn == 1435)
		// /* Line 350 of lalr1.java */
		// /* Line 10771 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (5-(1)))) &&
		// ((table_list)(yystack.valueAt (5-(5)))));
		// };
		// break;
		//
		//
		// case 1436:
		// if (yyn == 1436)
		// /* Line 350 of lalr1.java */
		// /* Line 10775 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (!(yyval= lex->current_select->convert_right_join()))
		// return YYABORT;
		// add_join_natural(yyval,((table_list)(yystack.valueAt
		// (10-(5)))),((string_list)(yystack.valueAt (10-(9)))),Select);
		// };
		// break;
		//
		//
		// case 1437:
		// if (yyn == 1437)
		// /* Line 350 of lalr1.java */
		// /* Line 10782 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((table_list)(yystack.valueAt (6-(1)))) &&
		// ((table_list)(yystack.valueAt (6-(6)))));
		// add_join_natural(((table_list)(yystack.valueAt
		// (6-(6)))),((table_list)(yystack.valueAt (6-(1)))),NULL,Select);
		// LEX *lex= Lex;
		// if (!(yyval= lex->current_select->convert_right_join()))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1438:
		// if (yyn == 1438)
		// /* Line 350 of lalr1.java */
		// /* Line 10792 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1439:
		// if (yyn == 1439)
		// /* Line 350 of lalr1.java */
		// /* Line 10793 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1440:
		// if (yyn == 1440)
		// /* Line 350 of lalr1.java */
		// /* Line 10794 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1441:
		// if (yyn == 1441)
		// /* Line 350 of lalr1.java */
		// /* Line 10802 of "sql_yacc.y" */
		// { yyval= 0;};
		// break;
		//
		//
		// case 1443:
		// if (yyn == 1443)
		// /* Line 350 of lalr1.java */
		// /* Line 10808 of "sql_yacc.y" */
		// {
		// yyval= ((string_list)(yystack.valueAt (5-(3))));
		// };
		// break;
		//
		//
		// case 1444:
		// if (yyn == 1444)
		// /* Line 350 of lalr1.java */
		// /* Line 10822 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->table_join_options= 0;
		// };
		// break;

		case 1445:
			if (yyn == 1445)
			/* Line 350 of lalr1.java */
			/* Line 10827 of "sql_yacc.y" */
			{
				if (!(MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(5 - (2)),
						(Item) (yystack.valueAt(5 - (4))), (Item) (yystack.valueAt(5 - (3))))))
					return YYABORT;
				// Select->add_joined_table(yyval);
			}
			;
			break;
		//
		//
		case 1446:
			if (yyn == 1446)
			/* Line 350 of lalr1.java */
			/* Line 10838 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// SELECT_LEX *sel= lex->current_select;
				// if (((num)(yystack.valueAt (3-(1)))))
				// {
				// if (sel->set_braces(1))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// /* select in braces, can't contain global parameters */
				// if (sel->master_unit()->fake_select_lex)
				// sel->master_unit()->global_parameters=
				// sel->master_unit()->fake_select_lex;
				// }
				// if (((select_lex)(yystack.valueAt
				// (3-(2))))->init_nested_join(lex->thd))
				// return YYABORT;
				// yyval= 0;
				// /* incomplete derived tables return NULL, we must be
				// nested in select_derived rule to be here. */
			}
			;
			break;
		//
		//
		case 1447:
			if (yyn == 1447)
			/* Line 350 of lalr1.java */
			/* Line 10878 of "sql_yacc.y" */
			{
				// /* Use $2 instead of Lex->current_select as derived table
				// will
				// alter value of Lex->current_select. */
				// if (!(((table_list)(yystack.valueAt (5-(3)))) ||
				// ((lex_str_ptr)(yystack.valueAt (5-(5))))) &&
				// ((select_lex)(yystack.valueAt (5-(2))))->embedding &&
				// !((select_lex)(yystack.valueAt
				// (5-(2))))->embedding->nested_join->join_list.elements)
				// {
				// /* we have a derived table ($3 == NULL) but no alias,
				// Since we are nested in further parentheses so we
				// can pass NULL to the outer level parentheses
				// Permits parsing of "((((select ...))) as xyz)" */
				// yyval= 0;
				// }
				// else if (!((table_list)(yystack.valueAt (5-(3)))))
				// {
				// /* Handle case of derived table, alias may be NULL if there
				// are no outer parentheses, addTableToList() will throw
				// error in this case */
				// LEX *lex=Lex;
				// SELECT_LEX *sel= lex->current_select;
				// SELECT_LEX_UNIT *unit= sel->master_unit();
				// lex->current_select= sel= unit->outer_select();
				// Table_ident *ti= new Table_ident(unit);
				// if (ti == NULL)
				// return YYABORT;
				// if (!(yyval= sel->addTableToList(lex->thd,
				// ti, ((lex_str_ptr)(yystack.valueAt (5-(5)))), 0,
				// TL_READ, MDL_SHARED_READ)))
				//
				// return YYABORT;
				// sel->add_joined_table(yyval);
				// lex->pop_context();
				// lex->nest_level--;
				// }
				// else if (((lex_str_ptr)(yystack.valueAt (5-(5)))) != NULL)
				// {
				// /*
				// Tables with or without joins within parentheses cannot
				// have aliases, and we ruled out derived tables above.
				// */
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// else
				// {
				// /* nested join: FROM (t1 JOIN t2 ...),
				// nest_level is the same as in the outer query */
				// yyval= ((table_list)(yystack.valueAt (5-(3))));
				// }
			}
			;
			break;
		//
		//
		case 1448:
			if (yyn == 1448)
			/* Line 350 of lalr1.java */
			/* Line 10951 of "sql_yacc.y" */
			{
				// if (((table_list)(yystack.valueAt (2-(1)))) &&
				// ((is_not_empty)(yystack.valueAt (2-(2)))))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		// case 1449:
		// if (yyn == 1449)
		// /* Line 350 of lalr1.java */
		// /* Line 10961 of "sql_yacc.y" */
		// {
		// if (add_select_to_union_list(Lex, (bool)((num)(yystack.valueAt
		// (3-(3)))), FALSE))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1450:
		// if (yyn == 1450)
		// /* Line 350 of lalr1.java */
		// /* Line 10966 of "sql_yacc.y" */
		// {
		// /*
		// Remove from the name resolution context stack the context of the
		// last select in the union.
		// */
		// Lex->pop_context();
		// };
		// break;
		//
		//
		case 1451:
			if (yyn == 1451)
			/* Line 350 of lalr1.java */
			/* Line 10974 of "sql_yacc.y" */
			{
				// if (((table_list)(yystack.valueAt (7-(1)))) != NULL)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		case 1452:
			if (yyn == 1452)
			/* Line 350 of lalr1.java */
			/* Line 10986 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// SELECT_LEX * sel= lex->current_select;
				// if (lex->current_select->set_braces(0))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// if (sel->linkage == UNION_TYPE &&
				// sel->master_unit()->first_select()->braces)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;

		case 1453:
			if (yyn == 1453)
			/* Line 350 of lalr1.java */
			/* Line 11005 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// SELECT_LEX *sel= lex->current_select;
				// if (sel->linkage != UNION_TYPE)
				if (thd.lex.selectLex == null) MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->current_select->parsing_place= SELECT_LIST;
			}
			;
			break;
		//
		//
		// case 1454:
		// if (yyn == 1454)
		// /* Line 350 of lalr1.java */
		// /* Line 11013 of "sql_yacc.y" */
		// {
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1456:
		// if (yyn == 1456)
		// /* Line 350 of lalr1.java */
		// /* Line 11022 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (((select_lex)(yystack.valueAt
		// (1-(1))))->init_nested_join(lex->thd))
		// return YYABORT;
		// };
		// break;
		//
		//
		case 1457:
			if (yyn == 1457)
			/* Line 350 of lalr1.java */
			/* Line 11028 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// /* for normal joins, $3 != NULL and end_nested_join() !=
				// NULL,
				// for derived tables, both must equal NULL */
				//
				// if (!(yyval= ((select_lex)(yystack.valueAt
				// (3-(1))))->end_nested_join(lex->thd)) &&
				// ((table_list)(yystack.valueAt (3-(3)))))
				// return YYABORT;
				// if (!((table_list)(yystack.valueAt (3-(3)))) && yyval)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		case 1458:
			if (yyn == 1458)
			/* Line 350 of lalr1.java */
			/* Line 11044 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// lex->derived_tables|= DERIVED_SUBQUERY;
				// if (!lex->expr_allows_subselect ||
				// thd.lex.sqlCommand == (int)SQLCOM_PURGE)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// if (lex->current_select->linkage == GLOBAL_OPTIONS_TYPE ||
				// mysql_new_select(lex, 1))
				// return YYABORT;
				MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->current_select->linkage= DERIVED_TABLE_TYPE;
				// lex->current_select->parsing_place= SELECT_LIST;
			}
			;
			break;
		//
		//
		// case 1459:
		// if (yyn == 1459)
		// /* Line 350 of lalr1.java */
		// /* Line 11061 of "sql_yacc.y" */
		// {
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1461:
		// if (yyn == 1461)
		// /* Line 350 of lalr1.java */
		// /* Line 11068 of "sql_yacc.y" */
		// { yyval= Select; };
		// break;
		//
		//
		case 1462:
			if (yyn == 1462)
			/* Line 350 of lalr1.java */
			/* Line 11073 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				//
				// if (! lex->parsing_options.allows_derived)
				// {
				// my_error(ER_VIEW_SELECT_DERIVED, MYF(0));
				// return YYABORT;
				// }
				//
				// SELECT_LEX *sel= lex->current_select;
				// TABLE_LIST *embedding;
				// if (!sel->embedding || sel->end_nested_join(lex->thd))
				// {
				// /* we are not in parentheses */
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// embedding= Select->embedding;
				// yyval= embedding &&
				// !embedding->nested_join->join_list.elements;
				// /* return true if we are deeply nested */
			}
			;
			break;
		//
		//
		// case 1463:
		// if (yyn == 1463)
		// /* Line 350 of lalr1.java */
		// /* Line 11098 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1464:
		// if (yyn == 1464)
		// /* Line 350 of lalr1.java */
		// /* Line 11099 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1465:
		// if (yyn == 1465)
		// /* Line 350 of lalr1.java */
		// /* Line 11104 of "sql_yacc.y" */
		// {
		// yyval= old_mode ? INDEX_HINT_MASK_JOIN : INDEX_HINT_MASK_ALL;
		// };
		// break;
		//
		//
		// case 1466:
		// if (yyn == 1466)
		// /* Line 350 of lalr1.java */
		// /* Line 11107 of "sql_yacc.y" */
		// { yyval= INDEX_HINT_MASK_JOIN; };
		// break;
		//
		//
		// case 1467:
		// if (yyn == 1467)
		// /* Line 350 of lalr1.java */
		// /* Line 11108 of "sql_yacc.y" */
		// { yyval= INDEX_HINT_MASK_ORDER; };
		// break;
		//
		//
		// case 1468:
		// if (yyn == 1468)
		// /* Line 350 of lalr1.java */
		// /* Line 11109 of "sql_yacc.y" */
		// { yyval= INDEX_HINT_MASK_GROUP; };
		// break;
		//
		//
		// case 1469:
		// if (yyn == 1469)
		// /* Line 350 of lalr1.java */
		// /* Line 11113 of "sql_yacc.y" */
		// { yyval= INDEX_HINT_FORCE; };
		// break;
		//
		//
		// case 1470:
		// if (yyn == 1470)
		// /* Line 350 of lalr1.java */
		// /* Line 11114 of "sql_yacc.y" */
		// { yyval= INDEX_HINT_IGNORE; };
		// break;
		//
		//
		// case 1471:
		// if (yyn == 1471)
		// /* Line 350 of lalr1.java */
		// /* Line 11119 of "sql_yacc.y" */
		// {
		// Select->set_index_hint_type(((index_hint)(yystack.valueAt (3-(1)))),
		// ((num)(yystack.valueAt (3-(3)))));
		// };
		// break;
		//
		//
		// case 1473:
		// if (yyn == 1473)
		// /* Line 350 of lalr1.java */
		// /* Line 11124 of "sql_yacc.y" */
		// {
		// Select->set_index_hint_type(INDEX_HINT_USE, ((num)(yystack.valueAt
		// (3-(3)))));
		// };
		// break;
		//
		//
		// case 1478:
		// if (yyn == 1478)
		// /* Line 350 of lalr1.java */
		// /* Line 11137 of "sql_yacc.y" */
		// { Select->alloc_index_hints(YYTHD); };
		// break;
		//
		//
		// case 1480:
		// if (yyn == 1480)
		// /* Line 350 of lalr1.java */
		// /* Line 11141 of "sql_yacc.y" */
		// { Select->clear_index_hints(); };
		// break;
		//
		//
		// case 1482:
		// if (yyn == 1482)
		// /* Line 350 of lalr1.java */
		// /* Line 11146 of "sql_yacc.y" */
		// { Select->add_index_hint(YYTHD, NULL, 0); };
		// break;
		//
		//
		// case 1483:
		// if (yyn == 1483)
		// /* Line 350 of lalr1.java */
		// /* Line 11147 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1484:
		// if (yyn == 1484)
		// /* Line 350 of lalr1.java */
		// /* Line 11152 of "sql_yacc.y" */
		// { Select->add_index_hint(YYTHD, ((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length); };
		// break;
		//
		//
		// case 1485:
		// if (yyn == 1485)
		// /* Line 350 of lalr1.java */
		// /* Line 11154 of "sql_yacc.y" */
		// { Select->add_index_hint(YYTHD, (char *)"PRIMARY", 7); };
		// break;
		//
		//
		// case 1488:
		// if (yyn == 1488)
		// /* Line 350 of lalr1.java */
		// /* Line 11164 of "sql_yacc.y" */
		// {
		// if (!(yyval= new List<String>))
		// return YYABORT;
		// String *s= new (YYTHD->mem_root) String((const char *)
		// ((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length,
		// system_charset_info);
		// if (s == NULL)
		// return YYABORT;
		// yyval->push_back(s);
		// };
		// break;
		//
		//
		// case 1489:
		// if (yyn == 1489)
		// /* Line 350 of lalr1.java */
		// /* Line 11175 of "sql_yacc.y" */
		// {
		// String *s= new (YYTHD->mem_root) String((const char *)
		// ((lex_str)(yystack.valueAt (3-(3)))).str,
		// ((lex_str)(yystack.valueAt (3-(3)))).length,
		// system_charset_info);
		// if (s == NULL)
		// return YYABORT;
		// ((string_list)(yystack.valueAt (3-(1))))->push_back(s);
		// yyval= ((string_list)(yystack.valueAt (3-(1))));
		// };
		// break;
		//
		//
		// case 1490:
		// if (yyn == 1490)
		// /* Line 350 of lalr1.java */
		// /* Line 11187 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1491:
		// if (yyn == 1491)
		// /* Line 350 of lalr1.java */
		// /* Line 11188 of "sql_yacc.y" */
		// { yyval=INTERVAL_DAY_HOUR; };
		// break;
		//
		//
		// case 1492:
		// if (yyn == 1492)
		// /* Line 350 of lalr1.java */
		// /* Line 11189 of "sql_yacc.y" */
		// { yyval=INTERVAL_DAY_MICROSECOND; };
		// break;
		//
		//
		// case 1493:
		// if (yyn == 1493)
		// /* Line 350 of lalr1.java */
		// /* Line 11190 of "sql_yacc.y" */
		// { yyval=INTERVAL_DAY_MINUTE; };
		// break;
		//
		//
		// case 1494:
		// if (yyn == 1494)
		// /* Line 350 of lalr1.java */
		// /* Line 11191 of "sql_yacc.y" */
		// { yyval=INTERVAL_DAY_SECOND; };
		// break;
		//
		//
		// case 1495:
		// if (yyn == 1495)
		// /* Line 350 of lalr1.java */
		// /* Line 11192 of "sql_yacc.y" */
		// { yyval=INTERVAL_HOUR_MICROSECOND; };
		// break;
		//
		//
		// case 1496:
		// if (yyn == 1496)
		// /* Line 350 of lalr1.java */
		// /* Line 11193 of "sql_yacc.y" */
		// { yyval=INTERVAL_HOUR_MINUTE; };
		// break;
		//
		//
		// case 1497:
		// if (yyn == 1497)
		// /* Line 350 of lalr1.java */
		// /* Line 11194 of "sql_yacc.y" */
		// { yyval=INTERVAL_HOUR_SECOND; };
		// break;
		//
		//
		// case 1498:
		// if (yyn == 1498)
		// /* Line 350 of lalr1.java */
		// /* Line 11195 of "sql_yacc.y" */
		// { yyval=INTERVAL_MINUTE_MICROSECOND; };
		// break;
		//
		//
		// case 1499:
		// if (yyn == 1499)
		// /* Line 350 of lalr1.java */
		// /* Line 11196 of "sql_yacc.y" */
		// { yyval=INTERVAL_MINUTE_SECOND; };
		// break;
		//
		//
		// case 1500:
		// if (yyn == 1500)
		// /* Line 350 of lalr1.java */
		// /* Line 11197 of "sql_yacc.y" */
		// { yyval=INTERVAL_SECOND_MICROSECOND; };
		// break;
		//
		//
		// case 1501:
		// if (yyn == 1501)
		// /* Line 350 of lalr1.java */
		// /* Line 11198 of "sql_yacc.y" */
		// { yyval=INTERVAL_YEAR_MONTH; };
		// break;
		//
		//
		// case 1502:
		// if (yyn == 1502)
		// /* Line 350 of lalr1.java */
		// /* Line 11202 of "sql_yacc.y" */
		// { yyval=INTERVAL_DAY; };
		// break;
		//
		//
		// case 1503:
		// if (yyn == 1503)
		// /* Line 350 of lalr1.java */
		// /* Line 11203 of "sql_yacc.y" */
		// { yyval=INTERVAL_WEEK; };
		// break;
		//
		//
		// case 1504:
		// if (yyn == 1504)
		// /* Line 350 of lalr1.java */
		// /* Line 11204 of "sql_yacc.y" */
		// { yyval=INTERVAL_HOUR; };
		// break;
		//
		//
		// case 1505:
		// if (yyn == 1505)
		// /* Line 350 of lalr1.java */
		// /* Line 11205 of "sql_yacc.y" */
		// { yyval=INTERVAL_MINUTE; };
		// break;
		//
		//
		// case 1506:
		// if (yyn == 1506)
		// /* Line 350 of lalr1.java */
		// /* Line 11206 of "sql_yacc.y" */
		// { yyval=INTERVAL_MONTH; };
		// break;
		//
		//
		// case 1507:
		// if (yyn == 1507)
		// /* Line 350 of lalr1.java */
		// /* Line 11207 of "sql_yacc.y" */
		// { yyval=INTERVAL_QUARTER; };
		// break;
		//
		//
		// case 1508:
		// if (yyn == 1508)
		// /* Line 350 of lalr1.java */
		// /* Line 11208 of "sql_yacc.y" */
		// { yyval=INTERVAL_SECOND; };
		// break;
		//
		//
		// case 1509:
		// if (yyn == 1509)
		// /* Line 350 of lalr1.java */
		// /* Line 11209 of "sql_yacc.y" */
		// { yyval=INTERVAL_MICROSECOND; };
		// break;
		//
		//
		// case 1510:
		// if (yyn == 1510)
		// /* Line 350 of lalr1.java */
		// /* Line 11210 of "sql_yacc.y" */
		// { yyval=INTERVAL_YEAR; };
		// break;
		//
		//
		// case 1511:
		// if (yyn == 1511)
		// /* Line 350 of lalr1.java */
		// /* Line 11214 of "sql_yacc.y" */
		// {yyval= MYSQL_TIMESTAMP_DATE; };
		// break;
		//
		//
		// case 1512:
		// if (yyn == 1512)
		// /* Line 350 of lalr1.java */
		// /* Line 11215 of "sql_yacc.y" */
		// {yyval= MYSQL_TIMESTAMP_TIME; };
		// break;
		//
		//
		// case 1513:
		// if (yyn == 1513)
		// /* Line 350 of lalr1.java */
		// /* Line 11216 of "sql_yacc.y" */
		// {yyval= MYSQL_TIMESTAMP_DATETIME; };
		// break;
		//
		//
		// case 1514:
		// if (yyn == 1514)
		// /* Line 350 of lalr1.java */
		// /* Line 11217 of "sql_yacc.y" */
		// {yyval= MYSQL_TIMESTAMP_DATETIME; };
		// break;
		//
		//
		// case 1518:
		// if (yyn == 1518)
		// /* Line 350 of lalr1.java */
		// /* Line 11227 of "sql_yacc.y" */
		// { yyval=0; };
		// break;
		//
		//
		// case 1519:
		// if (yyn == 1519)
		// /* Line 350 of lalr1.java */
		// /* Line 11229 of "sql_yacc.y" */
		// {
		// yyval= (LEX_STRING*) sql_memdup(&((lex_str)(yystack.valueAt
		// (2-(2)))),sizeof(LEX_STRING));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1522:
		// if (yyn == 1522)
		// /* Line 350 of lalr1.java */
		// /* Line 11242 of "sql_yacc.y" */
		// { Select->where= 0; };
		// break;
		//
		//
		// case 1523:
		// if (yyn == 1523)
		// /* Line 350 of lalr1.java */
		// /* Line 11244 of "sql_yacc.y" */
		// {
		// Select->parsing_place= IN_WHERE;
		// };
		// break;
		//
		//
		// case 1524:
		// if (yyn == 1524)
		// /* Line 350 of lalr1.java */
		// /* Line 11248 of "sql_yacc.y" */
		// {
		// SELECT_LEX *select= Select;
		// select->where= ((item)(yystack.valueAt (3-(3))));
		// select->parsing_place= NO_MATTER;
		// if (((item)(yystack.valueAt (3-(3)))))
		// ((item)(yystack.valueAt (3-(3))))->top_level_item();
		// };
		// break;
		//
		//
		// case 1526:
		// if (yyn == 1526)
		// /* Line 350 of lalr1.java */
		// /* Line 11260 of "sql_yacc.y" */
		// {
		// Select->parsing_place= IN_HAVING;
		// };
		// break;
		//
		//
		// case 1527:
		// if (yyn == 1527)
		// /* Line 350 of lalr1.java */
		// /* Line 11264 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->having= ((item)(yystack.valueAt (3-(3))));
		// sel->parsing_place= NO_MATTER;
		// if (((item)(yystack.valueAt (3-(3)))))
		// ((item)(yystack.valueAt (3-(3))))->top_level_item();
		// };
		// break;
		//
		//
		// case 1528:
		// if (yyn == 1528)
		// /* Line 350 of lalr1.java */
		// /* Line 11275 of "sql_yacc.y" */
		// {
		// Lex->escape_used= TRUE;
		// yyval= ((item)(yystack.valueAt (2-(2))));
		// };
		// break;
		//
		//
		// case 1529:
		// if (yyn == 1529)
		// /* Line 350 of lalr1.java */
		// /* Line 11280 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// Lex->escape_used= FALSE;
		// yyval= ((thd->variables.sql_mode & MODE_NO_BACKSLASH_ESCAPES) ?
		// new (thd->mem_root) Item_string("", 0, &my_charset_latin1) :
		// new (thd->mem_root) Item_string("\\", 1, &my_charset_latin1));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1532:
		// if (yyn == 1532)
		// /* Line 350 of lalr1.java */
		// /* Line 11302 of "sql_yacc.y" */
		// { if (add_group_to_list(YYTHD, ((item)(yystack.valueAt
		// (4-(3)))),(bool) ((num)(yystack.valueAt (4-(4)))))) return YYABORT;
		// };
		// break;
		//
		//
		// case 1533:
		// if (yyn == 1533)
		// /* Line 350 of lalr1.java */
		// /* Line 11304 of "sql_yacc.y" */
		// { if (add_group_to_list(YYTHD, ((item)(yystack.valueAt
		// (2-(1)))),(bool) ((num)(yystack.valueAt (2-(2)))))) return YYABORT;
		// };
		// break;
		//
		//
		// case 1534:
		// if (yyn == 1534)
		// /* Line 350 of lalr1.java */
		// /* Line 11308 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1535:
		// if (yyn == 1535)
		// /* Line 350 of lalr1.java */
		// /* Line 11310 of "sql_yacc.y" */
		// {
		// /*
		// 'WITH CUBE' is reserved in the MySQL syntax, but not implemented,
		// and cause LALR(2) conflicts.
		// This syntax is not standard.
		// MySQL syntax: GROUP BY col1, col2, col3 WITH CUBE
		// SQL-2003: GROUP BY ... CUBE(col1, col2, col3)
		// */
		// LEX *lex=Lex;
		// if (lex->current_select->linkage == GLOBAL_OPTIONS_TYPE)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "WITH CUBE",
		// "global union parameters");
		// return YYABORT;
		// }
		// lex->current_select->olap= CUBE_TYPE;
		// my_error(ER_NOT_SUPPORTED_YET, MYF(0), "CUBE");
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1536:
		// if (yyn == 1536)
		// /* Line 350 of lalr1.java */
		// /* Line 11330 of "sql_yacc.y" */
		// {
		// /*
		// 'WITH ROLLUP' is needed for backward compatibility,
		// and cause LALR(2) conflicts.
		// This syntax is not standard.
		// MySQL syntax: GROUP BY col1, col2, col3 WITH ROLLUP
		// SQL-2003: GROUP BY ... ROLLUP(col1, col2, col3)
		// */
		// LEX *lex= Lex;
		// if (lex->current_select->linkage == GLOBAL_OPTIONS_TYPE)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "WITH ROLLUP",
		// "global union parameters");
		// return YYABORT;
		// }
		// if (lex->current_select->options & SELECT_DISTINCT)
		// {
		// // DISTINCT+ROLLUP does not work
		// my_error(ER_WRONG_USAGE, MYF(0), "WITH ROLLUP", "DISTINCT");
		// return YYABORT;
		// }
		// lex->current_select->olap= ROLLUP_TYPE;
		// };
		// break;
		//
		//
		// case 1540:
		// if (yyn == 1540)
		// /* Line 350 of lalr1.java */
		// /* Line 11370 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// bool ascending= (((num)(yystack.valueAt (2-(2)))) == 1) ? true :
		// false;
		// if (add_order_to_list(thd, ((item)(yystack.valueAt (2-(1)))),
		// ascending))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1543:
		// if (yyn == 1543)
		// /* Line 350 of lalr1.java */
		// /* Line 11389 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// SELECT_LEX *sel= lex->current_select;
		// SELECT_LEX_UNIT *unit= sel-> master_unit();
		// if (sel->linkage != GLOBAL_OPTIONS_TYPE &&
		// sel->olap != UNSPECIFIED_OLAP_TYPE &&
		// (sel->linkage != UNION_TYPE || sel->braces))
		// {
		// my_error(ER_WRONG_USAGE, MYF(0),
		// "CUBE/ROLLUP", "ORDER BY");
		// return YYABORT;
		// }
		// if (thd.lex.sqlCommand != SQLCOM_ALTER_TABLE &&
		// !unit->fake_select_lex)
		// {
		// /*
		// A query of the of the form (SELECT ...) ORDER BY order_list is
		// executed in the same way as the query
		// SELECT ... ORDER BY order_list
		// unless the SELECT construct contains ORDER BY or LIMIT clauses.
		// Otherwise we create a fake SELECT_LEX if it has not been created
		// yet.
		// */
		// SELECT_LEX *first_sl= unit->first_select();
		// if (!unit->is_union() &&
		// (first_sl->order_list.elements ||
		// first_sl->select_limit) &&
		// unit->add_fake_select_lex(lex->thd))
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1545:
		// if (yyn == 1545)
		// /* Line 350 of lalr1.java */
		// /* Line 11424 of "sql_yacc.y" */
		// { if (add_order_to_list(YYTHD, ((item)(yystack.valueAt
		// (4-(3)))),(bool) ((num)(yystack.valueAt (4-(4)))))) return YYABORT;
		// };
		// break;
		//
		//
		// case 1546:
		// if (yyn == 1546)
		// /* Line 350 of lalr1.java */
		// /* Line 11426 of "sql_yacc.y" */
		// { if (add_order_to_list(YYTHD, ((item)(yystack.valueAt
		// (2-(1)))),(bool) ((num)(yystack.valueAt (2-(2)))))) return YYABORT;
		// };
		// break;
		//
		//
		// case 1547:
		// if (yyn == 1547)
		// /* Line 350 of lalr1.java */
		// /* Line 11430 of "sql_yacc.y" */
		// { yyval = 1; };
		// break;
		//
		//
		// case 1548:
		// if (yyn == 1548)
		// /* Line 350 of lalr1.java */
		// /* Line 11431 of "sql_yacc.y" */
		// { yyval =1; };
		// break;
		//
		//
		// case 1549:
		// if (yyn == 1549)
		// /* Line 350 of lalr1.java */
		// /* Line 11432 of "sql_yacc.y" */
		// { yyval =0; };
		// break;
		//
		//
		// case 1550:
		// if (yyn == 1550)
		// /* Line 350 of lalr1.java */
		// /* Line 11437 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// SELECT_LEX *sel= lex->current_select;
		// sel->offset_limit= 0;
		// sel->select_limit= 0;
		// };
		// break;
		//
		//
		// case 1551:
		// if (yyn == 1551)
		// /* Line 350 of lalr1.java */
		// /* Line 11443 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1552:
		// if (yyn == 1552)
		// /* Line 350 of lalr1.java */
		// /* Line 11447 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1553:
		// if (yyn == 1553)
		// /* Line 350 of lalr1.java */
		// /* Line 11448 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1554:
		// if (yyn == 1554)
		// /* Line 350 of lalr1.java */
		// /* Line 11453 of "sql_yacc.y" */
		// {
		// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_LIMIT);
		// };
		// break;
		//
		//
		// case 1555:
		// if (yyn == 1555)
		// /* Line 350 of lalr1.java */
		// /* Line 11460 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->select_limit= ((item)(yystack.valueAt (1-(1))));
		// sel->offset_limit= 0;
		// sel->explicit_limit= 1;
		// };
		// break;
		//
		//
		// case 1556:
		// if (yyn == 1556)
		// /* Line 350 of lalr1.java */
		// /* Line 11467 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->select_limit= ((item)(yystack.valueAt (3-(3))));
		// sel->offset_limit= ((item)(yystack.valueAt (3-(1))));
		// sel->explicit_limit= 1;
		// };
		// break;
		//
		//
		// case 1557:
		// if (yyn == 1557)
		// /* Line 350 of lalr1.java */
		// /* Line 11474 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->select_limit= ((item)(yystack.valueAt (3-(1))));
		// sel->offset_limit= ((item)(yystack.valueAt (3-(3))));
		// sel->explicit_limit= 1;
		// };
		// break;
		//
		//
		// case 1558:
		// if (yyn == 1558)
		// /* Line 350 of lalr1.java */
		// /* Line 11484 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// Lex_input_stream *lip= YYLIP;
		// sp_head *sp= lex->sphead;
		// const char *query_start_ptr=
		// sp ? sp->m_parser_data.get_current_stmt_start_ptr() : NULL;
		//
		// Item_splocal *v= create_item_for_sp_var(thd,
		// ((lex_str)(yystack.valueAt (1-(1)))), NULL,
		// query_start_ptr,
		// lip->get_tok_start(),
		// lip->get_ptr());
		// if (!v)
		// return YYABORT;
		//
		// lex->safe_to_cache_query= false;
		//
		// if (v->type() != Item::INT_ITEM)
		// {
		// my_error(ER_WRONG_SPVAR_TYPE_IN_LIMIT, MYF(0));
		// return YYABORT;
		// }
		//
		// v->limit_clause_param= true;
		// yyval= v;
		// };
		// break;
		//
		//
		// case 1559:
		// if (yyn == 1559)
		// /* Line 350 of lalr1.java */
		// /* Line 11511 of "sql_yacc.y" */
		// {
		// ((Item_param *) ((item)(yystack.valueAt
		// (1-(1)))))->limit_clause_param= TRUE;
		// };
		// break;
		//
		//
		// case 1560:
		// if (yyn == 1560)
		// /* Line 350 of lalr1.java */
		// /* Line 11515 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_uint(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1561:
		// if (yyn == 1561)
		// /* Line 350 of lalr1.java */
		// /* Line 11521 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_uint(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1562:
		// if (yyn == 1562)
		// /* Line 350 of lalr1.java */
		// /* Line 11527 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_uint(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1563:
		// if (yyn == 1563)
		// /* Line 350 of lalr1.java */
		// /* Line 11536 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->current_select->select_limit= 0;
		// };
		// break;
		//
		//
		// case 1564:
		// if (yyn == 1564)
		// /* Line 350 of lalr1.java */
		// /* Line 11541 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// sel->select_limit= ((item)(yystack.valueAt (2-(2))));
		// Lex->set_stmt_unsafe(LEX::BINLOG_STMT_UNSAFE_LIMIT);
		// sel->explicit_limit= 1;
		// };
		// break;
		//
		//
		// case 1565:
		// if (yyn == 1565)
		// /* Line 350 of lalr1.java */
		// /* Line 11550 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1566:
		// if (yyn == 1566)
		// /* Line 350 of lalr1.java */
		// /* Line 11551 of "sql_yacc.y" */
		// { yyval= (ulong) strtol(((lex_str)(yystack.valueAt (1-(1)))).str,
		// (char**) 0, 16); };
		// break;
		//
		//
		// case 1567:
		// if (yyn == 1567)
		// /* Line 350 of lalr1.java */
		// /* Line 11552 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1568:
		// if (yyn == 1568)
		// /* Line 350 of lalr1.java */
		// /* Line 11553 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1569:
		// if (yyn == 1569)
		// /* Line 350 of lalr1.java */
		// /* Line 11554 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1570:
		// if (yyn == 1570)
		// /* Line 350 of lalr1.java */
		// /* Line 11555 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1571:
		// if (yyn == 1571)
		// /* Line 350 of lalr1.java */
		// /* Line 11559 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1572:
		// if (yyn == 1572)
		// /* Line 350 of lalr1.java */
		// /* Line 11560 of "sql_yacc.y" */
		// { yyval= (ulong) strtol(((lex_str)(yystack.valueAt (1-(1)))).str,
		// (char**) 0, 16); };
		// break;
		//
		//
		// case 1573:
		// if (yyn == 1573)
		// /* Line 350 of lalr1.java */
		// /* Line 11561 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1574:
		// if (yyn == 1574)
		// /* Line 350 of lalr1.java */
		// /* Line 11562 of "sql_yacc.y" */
		// { int error; yyval= (ulong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error); };
		// break;
		//
		//
		// case 1575:
		// if (yyn == 1575)
		// /* Line 350 of lalr1.java */
		// /* Line 11563 of "sql_yacc.y" */
		// { return YYABORT; };
		// break;
		//
		//
		// case 1576:
		// if (yyn == 1576)
		// /* Line 350 of lalr1.java */
		// /* Line 11567 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1577:
		// if (yyn == 1577)
		// /* Line 350 of lalr1.java */
		// /* Line 11568 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1578:
		// if (yyn == 1578)
		// /* Line 350 of lalr1.java */
		// /* Line 11569 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1579:
		// if (yyn == 1579)
		// /* Line 350 of lalr1.java */
		// /* Line 11570 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1580:
		// if (yyn == 1580)
		// /* Line 350 of lalr1.java */
		// /* Line 11571 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1581:
		// if (yyn == 1581)
		// /* Line 350 of lalr1.java */
		// /* Line 11575 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1582:
		// if (yyn == 1582)
		// /* Line 350 of lalr1.java */
		// /* Line 11576 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1583:
		// if (yyn == 1583)
		// /* Line 350 of lalr1.java */
		// /* Line 11577 of "sql_yacc.y" */
		// { int error; yyval= (ulonglong)
		// my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str, (char**) 0,
		// &error); };
		// break;
		//
		//
		// case 1584:
		// if (yyn == 1584)
		// /* Line 350 of lalr1.java */
		// /* Line 11578 of "sql_yacc.y" */
		// { return YYABORT; };
		// break;
		//
		//
		// case 1585:
		// if (yyn == 1585)
		// /* Line 350 of lalr1.java */
		// /* Line 11583 of "sql_yacc.y" */
		// { my_parse_error(ER(ER_ONLY_INTEGERS_ALLOWED)); };
		// break;
		//
		//
		// case 1589:
		// if (yyn == 1589)
		// /* Line 350 of lalr1.java */
		// /* Line 11594 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		//
		// if (!lex->parsing_options.allows_select_procedure)
		// {
		// my_error(ER_VIEW_SELECT_CLAUSE, MYF(0), "PROCEDURE");
		// return YYABORT;
		// }
		//
		// if (&lex->select_lex != lex->current_select)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "PROCEDURE", "subquery");
		// return YYABORT;
		// }
		//
		// if (lex->result != NULL)
		// {
		// my_error(ER_WRONG_USAGE, MYF(0), "PROCEDURE", "INTO");
		// return YYABORT;
		// }
		//
		// if ((lex->proc_analyse= new Proc_analyse_params) == NULL)
		// {
		// my_error(ER_OUTOFMEMORY, MYF(ME_FATALERROR));
		// return YYABORT;
		// }
		//
		// lex->uncacheable(UNCACHEABLE_SIDEEFFECT);
		// };
		// break;
		//
		//
		// case 1591:
		// if (yyn == 1591)
		// /* Line 350 of lalr1.java */
		// /* Line 11627 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1592:
		// if (yyn == 1592)
		// /* Line 350 of lalr1.java */
		// /* Line 11629 of "sql_yacc.y" */
		// {
		// Lex->proc_analyse->max_tree_elements=
		// ((ulonglong_number)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 1593:
		// if (yyn == 1593)
		// /* Line 350 of lalr1.java */
		// /* Line 11633 of "sql_yacc.y" */
		// {
		// Lex->proc_analyse->max_tree_elements=
		// ((ulonglong_number)(yystack.valueAt (3-(1))));
		// Lex->proc_analyse->max_treemem= ((ulonglong_number)(yystack.valueAt
		// (3-(3))));
		// };
		// break;
		//
		//
		// case 1594:
		// if (yyn == 1594)
		// /* Line 350 of lalr1.java */
		// /* Line 11641 of "sql_yacc.y" */
		// {
		// int error;
		// yyval= (ulonglong) my_strtoll10(((lex_str)(yystack.valueAt
		// (1-(1)))).str, (char**) 0, &error);
		// if (error != 0)
		// {
		// my_error(ER_WRONG_PARAMETERS_TO_PROCEDURE, MYF(0), "ANALYSE");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1595:
		// if (yyn == 1595)
		// /* Line 350 of lalr1.java */
		// /* Line 11653 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (!lex->describe && (!(lex->result= new select_dumpvar())))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1596:
		// if (yyn == 1596)
		// /* Line 350 of lalr1.java */
		// /* Line 11659 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1598:
		// if (yyn == 1598)
		// /* Line 350 of lalr1.java */
		// /* Line 11664 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1599:
		// if (yyn == 1599)
		// /* Line 350 of lalr1.java */
		// /* Line 11669 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (lex->result)
		// {
		// my_var *var= new my_var(((lex_str)(yystack.valueAt
		// (2-(2)))),0,0,(enum_field_types)0);
		// if (var == NULL)
		// return YYABORT;
		// ((select_dumpvar *)lex->result)->var_list.push_back(var);
		// }
		// else
		// {
		// /*
		// The parser won't create select_result instance only
		// if it's an EXPLAIN.
		// */
		// DBUG_ASSERT(lex->describe);
		// }
		// };
		// break;
		//
		//
		// case 1600:
		// if (yyn == 1600)
		// /* Line 350 of lalr1.java */
		// /* Line 11688 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// #ifndef DBUG_OFF
		// sp_head *sp= lex->sphead;
		// #endif
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_variable *spv;
		//
		// if (!pctx || !(spv= pctx->find_variable(((lex_str)(yystack.valueAt
		// (1-(1)))), false)))
		// {
		// my_error(ER_SP_UNDECLARED_VAR, MYF(0), ((lex_str)(yystack.valueAt
		// (1-(1)))).str);
		// return YYABORT;
		// }
		// if (lex->result)
		// {
		// my_var *var= new my_var(((lex_str)(yystack.valueAt (1-(1)))), 1,
		// spv->offset, spv->type);
		//
		// if (var == NULL)
		// return YYABORT;
		//
		// ((select_dumpvar *) lex->result)->var_list.push_back(var);
		//
		// #ifndef DBUG_OFF
		// var->sp= sp;
		// #endif
		// }
		// else
		// {
		// /*
		// The parser won't create select_result instance only
		// if it's an EXPLAIN.
		// */
		// DBUG_ASSERT(lex->describe);
		// }
		// };
		// break;
		//
		//
		// case 1601:
		// if (yyn == 1601)
		// /* Line 350 of lalr1.java */
		// /* Line 11727 of "sql_yacc.y" */
		// {
		// if (! Lex->parsing_options.allows_select_into)
		// {
		// my_error(ER_VIEW_SELECT_CLAUSE, MYF(0), "INTO");
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1603:
		// if (yyn == 1603)
		// /* Line 350 of lalr1.java */
		// /* Line 11739 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->uncacheable(UNCACHEABLE_SIDEEFFECT);
		// if (!(lex->exchange= new sql_exchange(((lex_str)(yystack.valueAt
		// (2-(2)))).str, 0)) ||
		// !(lex->result= new select_export(lex->exchange)))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1604:
		// if (yyn == 1604)
		// /* Line 350 of lalr1.java */
		// /* Line 11747 of "sql_yacc.y" */
		// { Lex->exchange->cs= ((charset)(yystack.valueAt (4-(4)))); };
		// break;
		//
		//
		// case 1606:
		// if (yyn == 1606)
		// /* Line 350 of lalr1.java */
		// /* Line 11750 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (!lex->describe)
		// {
		// lex->uncacheable(UNCACHEABLE_SIDEEFFECT);
		// if (!(lex->exchange= new sql_exchange(((lex_str)(yystack.valueAt
		// (2-(2)))).str,1)))
		// return YYABORT;
		// if (!(lex->result= new select_dump(lex->exchange)))
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1607:
		// if (yyn == 1607)
		// /* Line 350 of lalr1.java */
		// /* Line 11762 of "sql_yacc.y" */
		// {
		// Lex->uncacheable(UNCACHEABLE_SIDEEFFECT);
		// };
		// break;

		case 1608:
			if (yyn == 1608)
			/* Line 350 of lalr1.java */
			/* Line 11773 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DO;
				MyParserProcessor.mysqlInitSelect(thd.lex);
			}
			;
			break;
		//
		//
		// case 1609:
		// if (yyn == 1609)
		// /* Line 350 of lalr1.java */
		// /* Line 11779 of "sql_yacc.y" */
		// {
		// Lex->insert_list= ((item_list)(yystack.valueAt (3-(3))));
		// };
		// break;

		case 1610:
			if (yyn == 1610)
			/* Line 350 of lalr1.java */
			/* Line 11790 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_TABLE;
				// lex->drop_temporary= ((num)(yystack.valueAt (4-(2))));
				// lex->drop_if_exists= ((num)(yystack.valueAt (4-(4))));
				// YYPS->m_lock_type= TL_UNLOCK;
				// YYPS->m_mdl_type= MDL_EXCLUSIVE;
			}
			;
			break;
		//
		//
		// case 1611:
		// if (yyn == 1611)
		// /* Line 350 of lalr1.java */
		// /* Line 11799 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1612:
		// if (yyn == 1612)
		// /* Line 350 of lalr1.java */
		// /* Line 11800 of "sql_yacc.y" */
		// {};
		// break;

		case 1613:
			if (yyn == 1613)
			/* Line 350 of lalr1.java */
			/* Line 11801 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// Alter_drop *ad= new Alter_drop(Alter_drop::KEY,
				// ((lex_str)(yystack.valueAt (6-(3)))).str);
				// if (ad == NULL)
				// return YYABORT;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_INDEX;
				// lex->alter_info.reset();
				thd.lex.alterInfo.flags.add(AlterFlag.ALTER_DROP_INDEX);
				// lex->alter_info.drop_list.push_back(ad);
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(6 - (5)), null, null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1614:
		// if (yyn == 1614)
		// /* Line 350 of lalr1.java */
		// /* Line 11816 of "sql_yacc.y" */
		// {};
		// break;

		case 1615:
			if (yyn == 1615)
			/* Line 350 of lalr1.java */
			/* Line 11818 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_DB;
				// lex->drop_if_exists=((num)(yystack.valueAt (4-(3))));
				// lex->name= ((lex_str)(yystack.valueAt (4-(4))));
			}
			;
			break;

		case 1616:
			if (yyn == 1616)
			/* Line 350 of lalr1.java */
			/* Line 11825 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// sp_name *spname;
				// if (((lex_str)(yystack.valueAt (6-(4)))).str &&
				// (check_and_convert_db_name(&((lex_str)(yystack.valueAt
				// (6-(4)))),
				// FALSE) != IDENT_NAME_OK))
				// return YYABORT;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_NO_DROP_SP, MYF(0), "FUNCTION");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_FUNCTION;
				// lex->drop_if_exists= ((num)(yystack.valueAt (6-(3))));
				// spname= new sp_name(((lex_str)(yystack.valueAt (6-(4)))),
				// ((lex_str)(yystack.valueAt (6-(6)))), true);
				// if (spname == NULL)
				// return YYABORT;
				// spname->init_qname(thd);
				// lex->spname= spname;
			}
			;
			break;
		//
		//
		case 1617:
			if (yyn == 1617)
			/* Line 350 of lalr1.java */
			/* Line 11846 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// LEX_STRING db= {0, 0};
				// sp_name *spname;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_NO_DROP_SP, MYF(0), "FUNCTION");
				// return YYABORT;
				// }
				// if (thd->db && lex->copy_db_to(&db.str, &db.length))
				// return YYABORT;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_FUNCTION;
				// lex->drop_if_exists= ((num)(yystack.valueAt (4-(3))));
				// spname= new sp_name(db, ((lex_str)(yystack.valueAt (4-(4)))),
				// false);
				// if (spname == NULL)
				// return YYABORT;
				// spname->init_qname(thd);
				// lex->spname= spname;
			}
			;
			break;

		case 1618:
			if (yyn == 1618)
			/* Line 350 of lalr1.java */
			/* Line 11867 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_NO_DROP_SP, MYF(0), "PROCEDURE");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_PROCEDURE;
				// lex->drop_if_exists= ((num)(yystack.valueAt (4-(3))));
				// lex->spname= ((spname)(yystack.valueAt (4-(4))));
			}
			;
			break;

		case 1619:
			if (yyn == 1619)
			/* Line 350 of lalr1.java */
			/* Line 11879 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_USER;
			}
			;
			break;

		case 1620:
			if (yyn == 1620)
			/* Line 350 of lalr1.java */
			/* Line 11883 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_VIEW;
				// lex->drop_if_exists= ((num)(yystack.valueAt (3-(3))));
				// YYPS->m_lock_type= TL_UNLOCK;
				// YYPS->m_mdl_type= MDL_EXCLUSIVE;
			}
			;
			break;
		//
		//
		// case 1621:
		// if (yyn == 1621)
		// /* Line 350 of lalr1.java */
		// /* Line 11891 of "sql_yacc.y" */
		// {};
		// break;

		case 1622:
			if (yyn == 1622)
			/* Line 350 of lalr1.java */
			/* Line 11893 of "sql_yacc.y" */
			{
				// Lex->drop_if_exists= ((num)(yystack.valueAt (4-(3))));
				// Lex->spname= ((spname)(yystack.valueAt (4-(4))));
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_EVENT;
			}
			;
			break;

		case 1623:
			if (yyn == 1623)
			/* Line 350 of lalr1.java */
			/* Line 11899 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_TRIGGER;
				// lex->drop_if_exists= ((num)(yystack.valueAt (4-(3))));
				// lex->spname= ((spname)(yystack.valueAt (4-(4))));
			}
			;
			break;
		//
		//
		// case 1624:
		// if (yyn == 1624)
		// /* Line 350 of lalr1.java */
		// /* Line 11906 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_cmd_type= DROP_TABLESPACE;
		// };
		// break;
		//
		//
		// case 1625:
		// if (yyn == 1625)
		// /* Line 350 of lalr1.java */
		// /* Line 11911 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->alter_tablespace_info->ts_cmd_type= DROP_LOGFILE_GROUP;
		// };
		// break;

		case 1626:
			if (yyn == 1626)
			/* Line 350 of lalr1.java */
			/* Line 11916 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DROP_SERVER;
				// Lex->drop_if_exists= ((num)(yystack.valueAt (4-(3))));
				// Lex->server_options.server_name= ((lex_str)(yystack.valueAt
				// (4-(4)))).str;
				// Lex->server_options.server_name_length=
				// ((lex_str)(yystack.valueAt
				// (4-(4)))).length;
			}
			;
			break;

		case 1629:
			if (yyn == 1629)
			/* Line 350 of lalr1.java */
			/* Line 11931 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(1 - (1)), null, null))
					return YYABORT;
			}
			;
			break;

		case 1630:
			if (yyn == 1630)
			/* Line 350 of lalr1.java */
			/* Line 11942 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(2 - (1)), null,
						((Item) (yystack.valueAt(2 - (2))))))
					return YYABORT;
			}
			;
			break;

		case 1633:
			if (yyn == 1633)
			/* Line 350 of lalr1.java */
			/* Line 11960 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(1 - (1)), null, null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1634:
		// if (yyn == 1634)
		// /* Line 350 of lalr1.java */
		// /* Line 11970 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 1635:
		// if (yyn == 1635)
		// /* Line 350 of lalr1.java */
		// /* Line 11971 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 1636:
		// if (yyn == 1636)
		// /* Line 350 of lalr1.java */
		// /* Line 11975 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 1637:
		// if (yyn == 1637)
		// /* Line 350 of lalr1.java */
		// /* Line 11976 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;

		case 1645:
			if (yyn == 1645)
			/* Line 350 of lalr1.java */
			/* Line 11999 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_INSERT;
				// lex->duplicates= DUP_ERROR;
				MyParserProcessor.mysqlInitSelect(thd.lex);
			}
			;
			break;
		//
		//
		// case 1646:
		// if (yyn == 1646)
		// /* Line 350 of lalr1.java */
		// /* Line 12007 of "sql_yacc.y" */
		// {
		// Select->set_lock_for_tables(((lock_type)(yystack.valueAt (5-(3)))));
		// Lex->current_select= &Lex->select_lex;
		// };
		// break;
		//
		//
		// case 1647:
		// if (yyn == 1647)
		// /* Line 350 of lalr1.java */
		// /* Line 12012 of "sql_yacc.y" */
		// {};
		// break;

		case 1648:
			if (yyn == 1648)
			/* Line 350 of lalr1.java */
			/* Line 12017 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_REPLACE;
				// lex->duplicates= DUP_REPLACE;
				MyParserProcessor.mysqlInitSelect(thd.lex);
			}
			;
			break;
		//
		//
		// case 1649:
		// if (yyn == 1649)
		// /* Line 350 of lalr1.java */
		// /* Line 12024 of "sql_yacc.y" */
		// {
		// Select->set_lock_for_tables(((lock_type)(yystack.valueAt (4-(3)))));
		// Lex->current_select= &Lex->select_lex;
		// };
		// break;
		//
		//
		// case 1650:
		// if (yyn == 1650)
		// /* Line 350 of lalr1.java */
		// /* Line 12029 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1651:
		// if (yyn == 1651)
		// /* Line 350 of lalr1.java */
		// /* Line 12034 of "sql_yacc.y" */
		// {
		// #ifdef HAVE_QUERY_CACHE
		// /*
		// If it is SP we do not allow insert optimisation whan result of
		// insert visible only after the table unlocking but everyone can
		// read table.
		// */
		// yyval= (Lex->sphead ? TL_WRITE_DEFAULT : TL_WRITE_CONCURRENT_INSERT);
		// #else
		// yyval= TL_WRITE_CONCURRENT_INSERT;
		// #endif
		// };
		// break;
		//
		//
		// case 1652:
		// if (yyn == 1652)
		// /* Line 350 of lalr1.java */
		// /* Line 12046 of "sql_yacc.y" */
		// { yyval= TL_WRITE_LOW_PRIORITY; };
		// break;
		//
		//
		// case 1653:
		// if (yyn == 1653)
		// /* Line 350 of lalr1.java */
		// /* Line 12048 of "sql_yacc.y" */
		// {
		// Lex->keyword_delayed_begin_offset= (uint)(YYLIP->get_tok_start() -
		// YYTHD->query());
		// Lex->keyword_delayed_end_offset= Lex->keyword_delayed_begin_offset +
		// YYLIP->yyLength() + 1;
		// yyval= TL_WRITE_DELAYED;
		//
		// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
		// ER_WARN_DEPRECATED_SYNTAX,
		// ER(ER_WARN_DEPRECATED_SYNTAX),
		// "INSERT DELAYED", "INSERT");
		// };
		// break;
		//
		//
		// case 1654:
		// if (yyn == 1654)
		// /* Line 350 of lalr1.java */
		// /* Line 12060 of "sql_yacc.y" */
		// { yyval= TL_WRITE; };
		// break;
		//
		//
		// case 1655:
		// if (yyn == 1655)
		// /* Line 350 of lalr1.java */
		// /* Line 12064 of "sql_yacc.y" */
		// { yyval= ((lock_type)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1656:
		// if (yyn == 1656)
		// /* Line 350 of lalr1.java */
		// /* Line 12066 of "sql_yacc.y" */
		// {
		// Lex->keyword_delayed_begin_offset= (uint)(YYLIP->get_tok_start() -
		// YYTHD->query());
		// Lex->keyword_delayed_end_offset= Lex->keyword_delayed_begin_offset +
		// YYLIP->yyLength() + 1;
		// yyval= TL_WRITE_DELAYED;
		//
		// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
		// ER_WARN_DEPRECATED_SYNTAX,
		// ER(ER_WARN_DEPRECATED_SYNTAX),
		// "REPLACE DELAYED", "REPLACE");
		// };
		// break;
		//
		//
		// case 1657:
		// if (yyn == 1657)
		// /* Line 350 of lalr1.java */
		// /* Line 12081 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1658:
		// if (yyn == 1658)
		// /* Line 350 of lalr1.java */
		// /* Line 12082 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1659:
		// if (yyn == 1659)
		// /* Line 350 of lalr1.java */
		// /* Line 12087 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->field_list.empty();
		// lex->many_values.empty();
		// lex->insert_list=0;
		// };
		// break;
		//
		//
		// case 1660:
		// if (yyn == 1660)
		// /* Line 350 of lalr1.java */
		// /* Line 12095 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1661:
		// if (yyn == 1661)
		// /* Line 350 of lalr1.java */
		// /* Line 12096 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1662:
		// if (yyn == 1662)
		// /* Line 350 of lalr1.java */
		// /* Line 12097 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1663:
		// if (yyn == 1663)
		// /* Line 350 of lalr1.java */
		// /* Line 12099 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (!(lex->insert_list = new List_item) ||
		// lex->many_values.push_back(lex->insert_list))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1665:
		// if (yyn == 1665)
		// /* Line 350 of lalr1.java */
		// /* Line 12109 of "sql_yacc.y" */
		// { Lex->field_list.push_back(((item)(yystack.valueAt (3-(3))))); };
		// break;
		//
		//
		// case 1666:
		// if (yyn == 1666)
		// /* Line 350 of lalr1.java */
		// /* Line 12110 of "sql_yacc.y" */
		// { Lex->field_list.push_back(((item)(yystack.valueAt (1-(1))))); };
		// break;
		//
		//
		// case 1667:
		// if (yyn == 1667)
		// /* Line 350 of lalr1.java */
		// /* Line 12114 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1668:
		// if (yyn == 1668)
		// /* Line 350 of lalr1.java */
		// /* Line 12115 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1669:
		// if (yyn == 1669)
		// /* Line 350 of lalr1.java */
		// /* Line 12117 of "sql_yacc.y" */
		// { Select->set_braces(0);};
		// break;
		//
		//
		// case 1670:
		// if (yyn == 1670)
		// /* Line 350 of lalr1.java */
		// /* Line 12118 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1671:
		// if (yyn == 1671)
		// /* Line 350 of lalr1.java */
		// /* Line 12120 of "sql_yacc.y" */
		// { Select->set_braces(1);};
		// break;
		//
		//
		// case 1672:
		// if (yyn == 1672)
		// /* Line 350 of lalr1.java */
		// /* Line 12121 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1677:
		// if (yyn == 1677)
		// /* Line 350 of lalr1.java */
		// /* Line 12136 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (lex->field_list.push_back(((item)(yystack.valueAt (3-(1))))) ||
		// lex->insert_list->push_back(((item)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1678:
		// if (yyn == 1678)
		// /* Line 350 of lalr1.java */
		// /* Line 12145 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1679:
		// if (yyn == 1679)
		// /* Line 350 of lalr1.java */
		// /* Line 12146 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1680:
		// if (yyn == 1680)
		// /* Line 350 of lalr1.java */
		// /* Line 12150 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1681:
		// if (yyn == 1681)
		// /* Line 350 of lalr1.java */
		// /* Line 12151 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1682:
		// if (yyn == 1682)
		// /* Line 350 of lalr1.java */
		// /* Line 12156 of "sql_yacc.y" */
		// {
		// if (!(Lex->insert_list = new List_item))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1683:
		// if (yyn == 1683)
		// /* Line 350 of lalr1.java */
		// /* Line 12161 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (lex->many_values.push_back(lex->insert_list))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1684:
		// if (yyn == 1684)
		// /* Line 350 of lalr1.java */
		// /* Line 12169 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1686:
		// if (yyn == 1686)
		// /* Line 350 of lalr1.java */
		// /* Line 12175 of "sql_yacc.y" */
		// {
		// if (Lex->insert_list->push_back(((item)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1687:
		// if (yyn == 1687)
		// /* Line 350 of lalr1.java */
		// /* Line 12180 of "sql_yacc.y" */
		// {
		// if (Lex->insert_list->push_back(((item)(yystack.valueAt (1-(1))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1688:
		// if (yyn == 1688)
		// /* Line 350 of lalr1.java */
		// /* Line 12187 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1689:
		// if (yyn == 1689)
		// /* Line 350 of lalr1.java */
		// /* Line 12189 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_default_value(Lex->current_context());
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1691:
		// if (yyn == 1691)
		// /* Line 350 of lalr1.java */
		// /* Line 12198 of "sql_yacc.y" */
		// { Lex->duplicates= DUP_UPDATE; };
		// break;

		case 1693:
			if (yyn == 1693)
			/* Line 350 of lalr1.java */
			/* Line 12206 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_UPDATE;
				MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->duplicates= DUP_ERROR;
			}
			;
			break;

		case 1694:
			if (yyn == 1694)
			/* Line 350 of lalr1.java */
			/* Line 12214 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				if (thd.lex.tables.size() > 1)
					thd.lex.sqlCommand = SQLCommand.SQLCOM_UPDATE_MULTI;
				// else if (lex->select_lex.get_table_list()->derived)
				// {
				// /* it is single table update and it is update of derived
				// table */
				// my_error(ER_NON_UPDATABLE_TABLE, MYF(0),
				// lex->select_lex.get_table_list()->alias, "UPDATE");
				// return YYABORT;
				// }
				// /*
				// In case of multi-update setting write lock for all tables may
				// be too pessimistic. We will decrease lock level if possible
				// in
				// mysql_multi_update().
				// */
				// Select->set_lock_for_tables(((lock_type)(yystack.valueAt
				// (7-(3)))));
			}
			;
			break;
		//
		//
		// case 1695:
		// if (yyn == 1695)
		// /* Line 350 of lalr1.java */
		// /* Line 12232 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1698:
		// if (yyn == 1698)
		// /* Line 350 of lalr1.java */
		// /* Line 12242 of "sql_yacc.y" */
		// {
		// if (add_item_to_list(YYTHD, ((item)(yystack.valueAt (3-(1))))) ||
		// add_value_to_list(YYTHD, ((item)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1701:
		// if (yyn == 1701)
		// /* Line 350 of lalr1.java */
		// /* Line 12255 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// if (lex->update_list.push_back(((item)(yystack.valueAt (3-(1))))) ||
		// lex->value_list.push_back(((item)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1702:
		// if (yyn == 1702)
		// /* Line 350 of lalr1.java */
		// /* Line 12264 of "sql_yacc.y" */
		// { yyval= TL_WRITE_DEFAULT; };
		// break;
		//
		//
		// case 1703:
		// if (yyn == 1703)
		// /* Line 350 of lalr1.java */
		// /* Line 12265 of "sql_yacc.y" */
		// { yyval= TL_WRITE_LOW_PRIORITY; };
		// break;

		case 1704:
			if (yyn == 1704)
			/* Line 350 of lalr1.java */
			/* Line 12272 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_DELETE;
				MyParserProcessor.mysqlInitSelect(thd.lex);
				// YYPS->m_lock_type= TL_WRITE_DEFAULT;
				// YYPS->m_mdl_type= MDL_SHARED_WRITE;
				//
				// lex->ignore= 0;
				// lex->select_lex.init_order();
			}
			;
			break;

		case 1706:
			if (yyn == 1706)
			/* Line 350 of lalr1.java */
			/* Line 12287 of "sql_yacc.y" */
			{
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (2)), null,
						((Item) (yystack.valueAt(3 - (3))))))
					return YYABORT;
				// YYPS->m_lock_type= TL_READ_DEFAULT;
				// YYPS->m_mdl_type= MDL_SHARED_READ;
			}
			;
			break;
		//
		//
		// case 1707:
		// if (yyn == 1707)
		// /* Line 350 of lalr1.java */
		// /* Line 12298 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1708:
		// if (yyn == 1708)
		// /* Line 350 of lalr1.java */
		// /* Line 12300 of "sql_yacc.y" */
		// {
		// mysql_init_multi_delete(Lex);
		// YYPS->m_lock_type= TL_READ_DEFAULT;
		// YYPS->m_mdl_type= MDL_SHARED_READ;
		// };
		// break;
		//
		//
		// case 1709:
		// if (yyn == 1709)
		// /* Line 350 of lalr1.java */
		// /* Line 12306 of "sql_yacc.y" */
		// {
		// if (multi_delete_set_locks_and_link_aux_tables(Lex))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1710:
		// if (yyn == 1710)
		// /* Line 350 of lalr1.java */
		// /* Line 12311 of "sql_yacc.y" */
		// {
		// mysql_init_multi_delete(Lex);
		// YYPS->m_lock_type= TL_READ_DEFAULT;
		// YYPS->m_mdl_type= MDL_SHARED_READ;
		// };
		// break;
		//
		//
		// case 1711:
		// if (yyn == 1711)
		// /* Line 350 of lalr1.java */
		// /* Line 12317 of "sql_yacc.y" */
		// {
		// if (multi_delete_set_locks_and_link_aux_tables(Lex))
		// return YYABORT;
		// };
		// break;

		case 1714:
			if (yyn == 1714)
			/* Line 350 of lalr1.java */
			/* Line 12330 of "sql_yacc.y" */
			{
				TableIdent ti = new TableIdent(((Token) yystack.valueAt(2 - (1))).lexStr);
				if (!MyParserProcessor.addTableToList(thd, ti, null, null))
					return YYABORT;
			}
			;
			break;

		case 1715:
			if (yyn == 1715)
			/* Line 350 of lalr1.java */
			/* Line 12343 of "sql_yacc.y" */
			{
				TableIdent ti = new TableIdent(((Token) yystack.valueAt(4 - (1))).lexStr,
						((Token) (yystack.valueAt(4 - (3)))).lexStr);
				if (!MyParserProcessor.addTableToList(thd, ti, null, null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1716:
		// if (yyn == 1716)
		// /* Line 350 of lalr1.java */
		// /* Line 12358 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1717:
		// if (yyn == 1717)
		// /* Line 350 of lalr1.java */
		// /* Line 12359 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1718:
		// if (yyn == 1718)
		// /* Line 350 of lalr1.java */
		// /* Line 12363 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1719:
		// if (yyn == 1719)
		// /* Line 350 of lalr1.java */
		// /* Line 12364 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1720:
		// if (yyn == 1720)
		// /* Line 350 of lalr1.java */
		// /* Line 12368 of "sql_yacc.y" */
		// { Select->options|= OPTION_QUICK; };
		// break;
		//
		//
		// case 1721:
		// if (yyn == 1721)
		// /* Line 350 of lalr1.java */
		// /* Line 12369 of "sql_yacc.y" */
		// { YYPS->m_lock_type= TL_WRITE_LOW_PRIORITY; };
		// break;
		//
		//
		// case 1722:
		// if (yyn == 1722)
		// /* Line 350 of lalr1.java */
		// /* Line 12370 of "sql_yacc.y" */
		// { Lex->ignore= 1; };
		// break;

		case 1723:
			if (yyn == 1723)
			/* Line 350 of lalr1.java */
			/* Line 12375 of "sql_yacc.y" */
			{
				// LEX* lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_TRUNCATE;
				// lex->alter_info.reset();
				// lex->select_lex.options= 0;
				// lex->select_lex.sql_cache= SELECT_LEX::SQL_CACHE_UNSPECIFIED;
				// lex->select_lex.init_order();
				// YYPS->m_lock_type= TL_WRITE;
				// YYPS->m_mdl_type= MDL_EXCLUSIVE;
			}
			;
			break;
		//
		//
		// case 1724:
		// if (yyn == 1724)
		// /* Line 350 of lalr1.java */
		// /* Line 12386 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX* lex= thd->lex;
		// DBUG_ASSERT(!lex->m_sql_cmd);
		// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_truncate_table();
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1731:
		// if (yyn == 1731)
		// /* Line 350 of lalr1.java */
		// /* Line 12411 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_CPU;
		// };
		// break;
		//
		//
		// case 1732:
		// if (yyn == 1732)
		// /* Line 350 of lalr1.java */
		// /* Line 12415 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_MEMORY;
		// };
		// break;
		//
		//
		// case 1733:
		// if (yyn == 1733)
		// /* Line 350 of lalr1.java */
		// /* Line 12419 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_BLOCK_IO;
		// };
		// break;
		//
		//
		// case 1734:
		// if (yyn == 1734)
		// /* Line 350 of lalr1.java */
		// /* Line 12423 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_CONTEXT;
		// };
		// break;
		//
		//
		// case 1735:
		// if (yyn == 1735)
		// /* Line 350 of lalr1.java */
		// /* Line 12427 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_PAGE_FAULTS;
		// };
		// break;
		//
		//
		// case 1736:
		// if (yyn == 1736)
		// /* Line 350 of lalr1.java */
		// /* Line 12431 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_IPC;
		// };
		// break;
		//
		//
		// case 1737:
		// if (yyn == 1737)
		// /* Line 350 of lalr1.java */
		// /* Line 12435 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_SWAPS;
		// };
		// break;
		//
		//
		// case 1738:
		// if (yyn == 1738)
		// /* Line 350 of lalr1.java */
		// /* Line 12439 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_SOURCE;
		// };
		// break;
		//
		//
		// case 1739:
		// if (yyn == 1739)
		// /* Line 350 of lalr1.java */
		// /* Line 12443 of "sql_yacc.y" */
		// {
		// Lex->profile_options|= PROFILE_ALL;
		// };
		// break;
		//
		//
		// case 1740:
		// if (yyn == 1740)
		// /* Line 350 of lalr1.java */
		// /* Line 12450 of "sql_yacc.y" */
		// {
		// Lex->profile_query_id= 0;
		// };
		// break;
		//
		//
		// case 1741:
		// if (yyn == 1741)
		// /* Line 350 of lalr1.java */
		// /* Line 12454 of "sql_yacc.y" */
		// {
		// Lex->profile_query_id= atoi(((lex_str)(yystack.valueAt
		// (3-(3)))).str);
		// };
		// break;

		case 1742:
			if (yyn == 1742)
			/* Line 350 of lalr1.java */
			/* Line 12463 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// lex->wild=0;
				MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->current_select->parsing_place= SELECT_LIST;
				// memset(&lex->create_info, 0, sizeof(lex->create_info));
				// };
				// break;
				//
				//
				// case 1743:
				// if (yyn == 1743)
				// /* Line 350 of lalr1.java */
				// /* Line 12471 of "sql_yacc.y" */
				// {
				// Select->parsing_place= NO_MATTER;
			}
			;
			break;

		case 1744:
			if (yyn == 1744)
			/* Line 350 of lalr1.java */
			/* Line 12478 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_DATABASES;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_SCHEMATA))
					return YYABORT;
			}
			;
			break;

		case 1745:
			if (yyn == 1745)
			/* Line 350 of lalr1.java */
			/* Line 12485 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_TABLES;
				// lex->select_lex.db= ((simple_string)(yystack.valueAt
				// (4-(3))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_TABLE_NAMES))
					return YYABORT;
			}
			;
			break;

		case 1746:
			if (yyn == 1746)
			/* Line 350 of lalr1.java */
			/* Line 12493 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_TRIGGERS;
				// lex->select_lex.db= ((simple_string)(yystack.valueAt
				// (4-(3))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_TRIGGERS))
					return YYABORT;
			}
			;
			break;

		case 1747:
			if (yyn == 1747)
			/* Line 350 of lalr1.java */
			/* Line 12501 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_EVENTS;
				// lex->select_lex.db= ((simple_string)(yystack.valueAt
				// (3-(2))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_EVENTS))
					return YYABORT;
			}
			;
			break;

		case 1748:
			if (yyn == 1748)
			/* Line 350 of lalr1.java */
			/* Line 12509 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_TABLE_STATUS;
				// lex->select_lex.db= ((simple_string)(yystack.valueAt
				// (4-(3))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_TABLES))
					return YYABORT;
			}
			;
			break;

		case 1749:
			if (yyn == 1749)
			/* Line 350 of lalr1.java */
			/* Line 12517 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_OPEN_TABLES;
				// lex->select_lex.db= ((simple_string)(yystack.valueAt
				// (4-(3))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_OPEN_TABLES))
					return YYABORT;
			}
			;
			break;

		case 1750:
			if (yyn == 1750)
			/* Line 350 of lalr1.java */
			/* Line 12525 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_PLUGINS;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_PLUGINS))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1751:
		// if (yyn == 1751)
		// /* Line 350 of lalr1.java */
		// /* Line 12532 of "sql_yacc.y" */
		// { Lex->create_info.db_type= ((db_type)(yystack.valueAt (3-(2)))); };
		// break;
		//
		//
		// case 1752:
		// if (yyn == 1752)
		// /* Line 350 of lalr1.java */
		// /* Line 12534 of "sql_yacc.y" */
		// { Lex->create_info.db_type= NULL; };
		// break;

		case 1753:
			if (yyn == 1753)
			/* Line 350 of lalr1.java */
			/* Line 12536 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_FIELDS;
				// if (((simple_string)(yystack.valueAt (6-(5)))))
				// ((table)(yystack.valueAt
				// (6-(4))))->change_db(((simple_string)(yystack.valueAt
				// (6-(5)))));
				if (!MyParserProcessor.prepareSchemaTable(thd, ((TableIdent) (yystack.valueAt(6 - (4)))),
						SchemaTables.SCH_COLUMNS))
					return YYABORT;
			}
			;
			break;

		case 1754:
			if (yyn == 1754)
			/* Line 350 of lalr1.java */
			/* Line 12545 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_BINLOGS;
			}
			;
			break;

		case 1755:
			if (yyn == 1755)
			/* Line 350 of lalr1.java */
			/* Line 12549 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_SLAVE_HOSTS;
			}
			;
			break;

		case 1756:
			if (yyn == 1756)
			/* Line 350 of lalr1.java */
			/* Line 12553 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_BINLOG_EVENTS;
			}
			;
			break;

		case 1758:
			if (yyn == 1758)
			/* Line 350 of lalr1.java */
			/* Line 12558 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_RELAYLOG_EVENTS;
			}
			;
			break;

		case 1760:
			if (yyn == 1760)
			/* Line 350 of lalr1.java */
			/* Line 12563 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_KEYS;
				// if (((simple_string)(yystack.valueAt (5-(4)))))
				// ((table)(yystack.valueAt
				// (5-(3))))->change_db(((simple_string)(yystack.valueAt
				// (5-(4)))));
				if (!MyParserProcessor.prepareSchemaTable(thd, ((TableIdent) (yystack.valueAt(5 - (3)))),
						SchemaTables.SCH_STATISTICS))
					return YYABORT;
			}
			;
			break;

		case 1761:
			if (yyn == 1761)
			/* Line 350 of lalr1.java */
			/* Line 12572 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_STORAGE_ENGINES;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_ENGINES))
					return YYABORT;
			}
			;
			break;

		case 1762:
			if (yyn == 1762)
			/* Line 350 of lalr1.java */
			/* Line 12579 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_PRIVILEGES;
			}
			;
			break;
		//
		//
		// case 1763:
		// if (yyn == 1763)
		// /* Line 350 of lalr1.java */
		// /* Line 12584 of "sql_yacc.y" */
		// { (void) create_select_for_variable("warning_count"); };
		// break;
		//
		//
		// case 1764:
		// if (yyn == 1764)
		// /* Line 350 of lalr1.java */
		// /* Line 12586 of "sql_yacc.y" */
		// { (void) create_select_for_variable("error_count"); };
		// break;

		case 1765:
			if (yyn == 1765)
			/* Line 350 of lalr1.java */
			/* Line 12588 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_WARNS;
			}
			;
			break;

		case 1766:
			if (yyn == 1766)
			/* Line 350 of lalr1.java */
			/* Line 12590 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_ERRORS;
			}
			;
			break;

		case 1767:
			if (yyn == 1767)
			/* Line 350 of lalr1.java */
			/* Line 12592 of "sql_yacc.y" */
			{
				// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
				// ER_WARN_DEPRECATED_SYNTAX,
				// ER(ER_WARN_DEPRECATED_SYNTAX),
				// "SHOW PROFILES", "Performance Schema");
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_PROFILES;
			}
			;
			break;

		case 1768:
			if (yyn == 1768)
			/* Line 350 of lalr1.java */
			/* Line 12600 of "sql_yacc.y" */
			{
				// push_warning_printf(YYTHD, Sql_condition::WARN_LEVEL_WARN,
				// ER_WARN_DEPRECATED_SYNTAX,
				// ER(ER_WARN_DEPRECATED_SYNTAX),
				// "SHOW PROFILE", "Performance Schema");
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_PROFILE;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_PROFILES))
					return YYABORT;
			}
			;
			break;

		case 1769:
			if (yyn == 1769)
			/* Line 350 of lalr1.java */
			/* Line 12611 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_STATUS;
				// lex->option_type= ((var_type)(yystack.valueAt (3-(1))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_STATUS))
					return YYABORT;
			}
			;
			break;

		case 1770:
			if (yyn == 1770)
			/* Line 350 of lalr1.java */
			/* Line 12619 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_PROCESSLIST;
			}
			;
			break;

		case 1771:
			if (yyn == 1771)
			/* Line 350 of lalr1.java */
			/* Line 12621 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_VARIABLES;
				// lex->option_type= ((var_type)(yystack.valueAt (3-(1))));
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_VARIABLES))
					return YYABORT;
			}
			;
			break;

		case 1772:
			if (yyn == 1772)
			/* Line 350 of lalr1.java */
			/* Line 12629 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CHARSETS;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_CHARSETS))
					return YYABORT;
			}
			;
			break;

		case 1773:
			if (yyn == 1773)
			/* Line 350 of lalr1.java */
			/* Line 12636 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_COLLATIONS;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_COLLATIONS))
					return YYABORT;
			}
			;
			break;

		case 1774:
			if (yyn == 1774)
			/* Line 350 of lalr1.java */
			/* Line 12643 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_GRANTS;
				// LEX_USER *curr_user;
				// if (!(curr_user= (LEX_USER*)
				// lex->thd->alloc(sizeof(st_lex_user))))
				// return YYABORT;
				// memset(curr_user, 0, sizeof(st_lex_user));
				// lex->grant_user= curr_user;
			}
			;
			break;

		case 1775:
			if (yyn == 1775)
			/* Line 350 of lalr1.java */
			/* Line 12653 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_GRANTS;
				// lex->grant_user=((lex_user)(yystack.valueAt (3-(3))));
				// lex->grant_user->password=null_lex_str;
			}
			;
			break;

		case 1776:
			if (yyn == 1776)
			/* Line 350 of lalr1.java */
			/* Line 12660 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE_DB;
				// Lex->create_info.options=((num)(yystack.valueAt (4-(3))));
				// Lex->name= ((lex_str)(yystack.valueAt (4-(4))));
			}
			;
			break;

		case 1777:
			if (yyn == 1777)
			/* Line 350 of lalr1.java */
			/* Line 12666 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE;
				if (!MyParserProcessor.addTableToList(thd, new TableIdent(((Token) yystack.valueAt(3 - (3))).lexStr), null, null))
					return YYABORT;
				// lex->only_view= 0;
				// lex->create_info.storage_media= HA_SM_DEFAULT;
			}
			;
			break;

		case 1778:
			if (yyn == 1778)
			/* Line 350 of lalr1.java */
			/* Line 12675 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE;
				if (!MyParserProcessor.addTableToList(thd, new TableIdent(((Token) yystack.valueAt(3 - (3))).lexStr), null, null))
					return YYABORT;
				// lex->only_view= 1;
			}
			;
			break;

		case 1779:
			if (yyn == 1779)
			/* Line 350 of lalr1.java */
			/* Line 12683 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_MASTER_STAT;
			}
			;
			break;

		case 1780:
			if (yyn == 1780)
			/* Line 350 of lalr1.java */
			/* Line 12687 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_SLAVE_STAT;
			}
			;
			break;

		case 1781:
			if (yyn == 1781)
			/* Line 350 of lalr1.java */
			/* Line 12691 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE_PROC;
				// lex->spname= ((spname)(yystack.valueAt (3-(3))));
			}
			;
			break;

		case 1782:
			if (yyn == 1782)
			/* Line 350 of lalr1.java */
			/* Line 12698 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE_FUNC;
				// lex->spname= ((spname)(yystack.valueAt (3-(3))));
			}
			;
			break;

		case 1783:
			if (yyn == 1783)
			/* Line 350 of lalr1.java */
			/* Line 12705 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE_TRIGGER;
				// lex->spname= ((spname)(yystack.valueAt (3-(3))));
			}
			;
			break;

		case 1784:
			if (yyn == 1784)
			/* Line 350 of lalr1.java */
			/* Line 12711 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_STATUS_PROC;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_PROCEDURES))
					return YYABORT;
			}
			;
			break;

		case 1785:
			if (yyn == 1785)
			/* Line 350 of lalr1.java */
			/* Line 12718 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_STATUS_FUNC;
				if (MyParserProcessor.prepareSchemaTable(thd, null, SchemaTables.SCH_PROCEDURES))
					return YYABORT;
			}
			;
			break;

		case 1786:
			if (yyn == 1786)
			/* Line 350 of lalr1.java */
			/* Line 12725 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_PROC_CODE;
				// Lex->spname= ((spname)(yystack.valueAt (3-(3))));
			}
			;
			break;

		case 1787:
			if (yyn == 1787)
			/* Line 350 of lalr1.java */
			/* Line 12730 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_FUNC_CODE;
				// Lex->spname= ((spname)(yystack.valueAt (3-(3))));
			}
			;
			break;

		case 1788:
			if (yyn == 1788)
			/* Line 350 of lalr1.java */
			/* Line 12735 of "sql_yacc.y" */
			{
				// Lex->spname= ((spname)(yystack.valueAt (3-(3))));
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_CREATE_EVENT;
			}
			;
			break;

		case 1789:
			if (yyn == 1789)
			/* Line 350 of lalr1.java */
			/* Line 12743 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_ENGINE_STATUS;
			}
			;
			break;

		case 1790:
			if (yyn == 1790)
			/* Line 350 of lalr1.java */
			/* Line 12745 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_ENGINE_MUTEX;
			}
			;
			break;

		case 1791:
			if (yyn == 1791)
			/* Line 350 of lalr1.java */
			/* Line 12747 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_ENGINE_LOGS;
			}
			;
			break;
		//
		//
		// case 1796:
		// if (yyn == 1796)
		// /* Line 350 of lalr1.java */
		// /* Line 12761 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 1797:
		// if (yyn == 1797)
		// /* Line 350 of lalr1.java */
		// /* Line 12762 of "sql_yacc.y" */
		// { yyval= ((lex_str)(yystack.valueAt (2-(2)))).str; };
		// break;
		//
		//
		// case 1798:
		// if (yyn == 1798)
		// /* Line 350 of lalr1.java */
		// /* Line 12766 of "sql_yacc.y" */
		// { Lex->verbose=0; };
		// break;
		//
		//
		// case 1799:
		// if (yyn == 1799)
		// /* Line 350 of lalr1.java */
		// /* Line 12767 of "sql_yacc.y" */
		// { Lex->verbose=1; };
		// break;
		//
		//
		// case 1802:
		// if (yyn == 1802)
		// /* Line 350 of lalr1.java */
		// /* Line 12776 of "sql_yacc.y" */
		// { Lex->mi.log_file_name = 0; };
		// break;
		//
		//
		// case 1803:
		// if (yyn == 1803)
		// /* Line 350 of lalr1.java */
		// /* Line 12777 of "sql_yacc.y" */
		// { Lex->mi.log_file_name = ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 1804:
		// if (yyn == 1804)
		// /* Line 350 of lalr1.java */
		// /* Line 12781 of "sql_yacc.y" */
		// { Lex->mi.pos = 4; /* skip magic number */ };
		// break;
		//
		//
		// case 1805:
		// if (yyn == 1805)
		// /* Line 350 of lalr1.java */
		// /* Line 12782 of "sql_yacc.y" */
		// { Lex->mi.pos = ((ulonglong_number)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 1807:
		// if (yyn == 1807)
		// /* Line 350 of lalr1.java */
		// /* Line 12788 of "sql_yacc.y" */
		// {
		// Lex->wild= new (YYTHD->mem_root) String(((lex_str)(yystack.valueAt
		// (2-(2)))).str, ((lex_str)(yystack.valueAt (2-(2)))).length,
		// system_charset_info);
		// if (Lex->wild == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1808:
		// if (yyn == 1808)
		// /* Line 350 of lalr1.java */
		// /* Line 12795 of "sql_yacc.y" */
		// {
		// Select->where= ((item)(yystack.valueAt (2-(2))));
		// if (((item)(yystack.valueAt (2-(2)))))
		// ((item)(yystack.valueAt (2-(2))))->top_level_item();
		// };
		// break;

		case 1809:
			if (yyn == 1809)
			/* Line 350 of lalr1.java */
			/* Line 12805 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				MyParserProcessor.mysqlInitSelect(thd.lex);
				// lex->current_select->parsing_place= SELECT_LIST;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SHOW_FIELDS;
				// lex->select_lex.db= 0;
				// lex->verbose= 0;
				if (!MyParserProcessor.prepareSchemaTable(thd, ((TableIdent) (yystack.valueAt(2 - (2)))),
						SchemaTables.SCH_COLUMNS))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 1810:
		// if (yyn == 1810)
		// /* Line 350 of lalr1.java */
		// /* Line 12816 of "sql_yacc.y" */
		// {
		// Select->parsing_place= NO_MATTER;
		// };
		// break;
		//
		//
		// case 1811:
		// if (yyn == 1811)
		// /* Line 350 of lalr1.java */
		// /* Line 12820 of "sql_yacc.y" */
		// { Lex->describe|= DESCRIBE_NORMAL; };
		// break;
		//
		//
		// case 1812:
		// if (yyn == 1812)
		// /* Line 350 of lalr1.java */
		// /* Line 12822 of "sql_yacc.y" */
		// { Lex->select_lex.options|= SELECT_DESCRIBE; };
		// break;
		//
		//
		// case 1820:
		// if (yyn == 1820)
		// /* Line 350 of lalr1.java */
		// /* Line 12840 of "sql_yacc.y" */
		// {
		// if ((Lex->explain_format= new Explain_format_traditional) == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1821:
		// if (yyn == 1821)
		// /* Line 350 of lalr1.java */
		// /* Line 12845 of "sql_yacc.y" */
		// {
		// if ((Lex->explain_format= new Explain_format_traditional) == NULL)
		// return YYABORT;
		// Lex->describe|= DESCRIBE_EXTENDED;
		// };
		// break;
		//
		//
		// case 1822:
		// if (yyn == 1822)
		// /* Line 350 of lalr1.java */
		// /* Line 12851 of "sql_yacc.y" */
		// {
		// if ((Lex->explain_format= new Explain_format_traditional) == NULL)
		// return YYABORT;
		// Lex->describe|= DESCRIBE_PARTITIONS;
		// };
		// break;
		//
		//
		// case 1823:
		// if (yyn == 1823)
		// /* Line 350 of lalr1.java */
		// /* Line 12857 of "sql_yacc.y" */
		// {
		// if (!my_strcasecmp(system_charset_info, ((lex_str)(yystack.valueAt
		// (3-(3)))).str, "JSON"))
		// {
		// if ((Lex->explain_format= new Explain_format_JSON) == NULL)
		// return YYABORT;
		// Lex->describe|= DESCRIBE_EXTENDED | DESCRIBE_PARTITIONS;
		// }
		// else if (!my_strcasecmp(system_charset_info,
		// ((lex_str)(yystack.valueAt (3-(3)))).str, "TRADITIONAL"))
		// {
		// if ((Lex->explain_format= new Explain_format_traditional) == NULL)
		// return YYABORT;
		// }
		// else
		// {
		// my_error(ER_UNKNOWN_EXPLAIN_FORMAT, MYF(0),
		// ((lex_str)(yystack.valueAt (3-(3)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1824:
		// if (yyn == 1824)
		// /* Line 350 of lalr1.java */
		// /* Line 12878 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1825:
		// if (yyn == 1825)
		// /* Line 350 of lalr1.java */
		// /* Line 12879 of "sql_yacc.y" */
		// { Lex->wild= ((string)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1826:
		// if (yyn == 1826)
		// /* Line 350 of lalr1.java */
		// /* Line 12881 of "sql_yacc.y" */
		// {
		// Lex->wild= new (YYTHD->mem_root) String((const char*)
		// ((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length,
		// system_charset_info);
		// if (Lex->wild == NULL)
		// return YYABORT;
		// };
		// break;

		case 1827:
			if (yyn == 1827)
			/* Line 350 of lalr1.java */
			/* Line 12895 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_FLUSH;
				// lex->type= 0;
				// lex->no_write_to_binlog= ((num)(yystack.valueAt (2-(2))));
			}
			;
			break;
		//
		//
		// case 1828:
		// if (yyn == 1828)
		// /* Line 350 of lalr1.java */
		// /* Line 12902 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1829:
		// if (yyn == 1829)
		// /* Line 350 of lalr1.java */
		// /* Line 12907 of "sql_yacc.y" */
		// {
		// Lex->type|= REFRESH_TABLES;
		// /*
		// Set type of metadata and table locks for
		// FLUSH TABLES table_list [WITH READ LOCK].
		// */
		// YYPS->m_lock_type= TL_READ_NO_INSERT;
		// YYPS->m_mdl_type= MDL_SHARED_HIGH_PRIO;
		// };
		// break;
		//
		//
		// case 1830:
		// if (yyn == 1830)
		// /* Line 350 of lalr1.java */
		// /* Line 12916 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1831:
		// if (yyn == 1831)
		// /* Line 350 of lalr1.java */
		// /* Line 12917 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1833:
		// if (yyn == 1833)
		// /* Line 350 of lalr1.java */
		// /* Line 12922 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1834:
		// if (yyn == 1834)
		// /* Line 350 of lalr1.java */
		// /* Line 12924 of "sql_yacc.y" */
		// {
		// TABLE_LIST *tables= Lex->query_tables;
		// Lex->type|= REFRESH_READ_LOCK;
		// for (; tables; tables= tables->next_global)
		// {
		// tables->mdl_request.set_type(MDL_SHARED_NO_WRITE);
		// tables->required_type= FRMTYPE_TABLE; /* Don't try to flush views. */
		// tables->open_type= OT_BASE_ONLY; /* Ignore temporary tables. */
		// }
		// };
		// break;
		//
		//
		// case 1835:
		// if (yyn == 1835)
		// /* Line 350 of lalr1.java */
		// /* Line 12935 of "sql_yacc.y" */
		// {
		// if (Lex->query_tables == NULL) // Table list can't be empty
		// {
		// my_parse_error(ER(ER_NO_TABLES_USED));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1836:
		// if (yyn == 1836)
		// /* Line 350 of lalr1.java */
		// /* Line 12943 of "sql_yacc.y" */
		// {
		// TABLE_LIST *tables= Lex->query_tables;
		// Lex->type|= REFRESH_FOR_EXPORT;
		// for (; tables; tables= tables->next_global)
		// {
		// tables->mdl_request.set_type(MDL_SHARED_NO_WRITE);
		// tables->required_type= FRMTYPE_TABLE; /* Don't try to flush views. */
		// tables->open_type= OT_BASE_ONLY; /* Ignore temporary tables. */
		// }
		// };
		// break;
		//
		//
		// case 1838:
		// if (yyn == 1838)
		// /* Line 350 of lalr1.java */
		// /* Line 12958 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1839:
		// if (yyn == 1839)
		// /* Line 350 of lalr1.java */
		// /* Line 12963 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_ERROR_LOG; };
		// break;
		//
		//
		// case 1840:
		// if (yyn == 1840)
		// /* Line 350 of lalr1.java */
		// /* Line 12965 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_ENGINE_LOG; };
		// break;
		//
		//
		// case 1841:
		// if (yyn == 1841)
		// /* Line 350 of lalr1.java */
		// /* Line 12967 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_GENERAL_LOG; };
		// break;
		//
		//
		// case 1842:
		// if (yyn == 1842)
		// /* Line 350 of lalr1.java */
		// /* Line 12969 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_SLOW_LOG; };
		// break;
		//
		//
		// case 1843:
		// if (yyn == 1843)
		// /* Line 350 of lalr1.java */
		// /* Line 12971 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_BINARY_LOG; };
		// break;
		//
		//
		// case 1844:
		// if (yyn == 1844)
		// /* Line 350 of lalr1.java */
		// /* Line 12973 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_RELAY_LOG; };
		// break;
		//
		//
		// case 1845:
		// if (yyn == 1845)
		// /* Line 350 of lalr1.java */
		// /* Line 12975 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_QUERY_CACHE_FREE; };
		// break;
		//
		//
		// case 1846:
		// if (yyn == 1846)
		// /* Line 350 of lalr1.java */
		// /* Line 12977 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_HOSTS; };
		// break;
		//
		//
		// case 1847:
		// if (yyn == 1847)
		// /* Line 350 of lalr1.java */
		// /* Line 12979 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_GRANT; };
		// break;
		//
		//
		// case 1848:
		// if (yyn == 1848)
		// /* Line 350 of lalr1.java */
		// /* Line 12981 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_LOG; };
		// break;
		//
		//
		// case 1849:
		// if (yyn == 1849)
		// /* Line 350 of lalr1.java */
		// /* Line 12983 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_STATUS; };
		// break;
		//
		//
		// case 1850:
		// if (yyn == 1850)
		// /* Line 350 of lalr1.java */
		// /* Line 12985 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_DES_KEY_FILE; };
		// break;
		//
		//
		// case 1851:
		// if (yyn == 1851)
		// /* Line 350 of lalr1.java */
		// /* Line 12987 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_USER_RESOURCES; };
		// break;
		//
		//
		// case 1852:
		// if (yyn == 1852)
		// /* Line 350 of lalr1.java */
		// /* Line 12991 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1853:
		// if (yyn == 1853)
		// /* Line 350 of lalr1.java */
		// /* Line 12992 of "sql_yacc.y" */
		// {};
		// break;

		case 1854:
			if (yyn == 1854)
			/* Line 350 of lalr1.java */
			/* Line 12997 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_RESET;
				// lex->type=0;
			}
			;
			break;
		//
		//
		// case 1855:
		// if (yyn == 1855)
		// /* Line 350 of lalr1.java */
		// /* Line 13002 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1858:
		// if (yyn == 1858)
		// /* Line 350 of lalr1.java */
		// /* Line 13011 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_SLAVE; };
		// break;
		//
		//
		// case 1859:
		// if (yyn == 1859)
		// /* Line 350 of lalr1.java */
		// /* Line 13012 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 1860:
		// if (yyn == 1860)
		// /* Line 350 of lalr1.java */
		// /* Line 13013 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_MASTER; };
		// break;
		//
		//
		// case 1861:
		// if (yyn == 1861)
		// /* Line 350 of lalr1.java */
		// /* Line 13014 of "sql_yacc.y" */
		// { Lex->type|= REFRESH_QUERY_CACHE;};
		// break;
		//
		//
		// case 1862:
		// if (yyn == 1862)
		// /* Line 350 of lalr1.java */
		// /* Line 13018 of "sql_yacc.y" */
		// { Lex->reset_slave_info.all= false; };
		// break;
		//
		//
		// case 1863:
		// if (yyn == 1863)
		// /* Line 350 of lalr1.java */
		// /* Line 13019 of "sql_yacc.y" */
		// { Lex->reset_slave_info.all= true; };
		// break;

		case 1864:
			if (yyn == 1864)
			/* Line 350 of lalr1.java */
			/* Line 13024 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// lex->type=0;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_PURGE;
			}
			;
			break;
		//
		//
		// case 1865:
		// if (yyn == 1865)
		// /* Line 350 of lalr1.java */
		// /* Line 13030 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1867:
		// if (yyn == 1867)
		// /* Line 350 of lalr1.java */
		// /* Line 13039 of "sql_yacc.y" */
		// {
		// Lex->to_log = ((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;

		case 1868:
			if (yyn == 1868)
			/* Line 350 of lalr1.java */
			/* Line 13043 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// lex->value_list.empty();
				// lex->value_list.push_front(((item)(yystack.valueAt
				// (2-(2)))));
				thd.lex.sqlCommand = SQLCommand.SQLCOM_PURGE_BEFORE;
			}
			;
			break;

		case 1869:
			if (yyn == 1869)
			/* Line 350 of lalr1.java */
			/* Line 13055 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// lex->value_list.empty();
				// lex->value_list.push_front(((item)(yystack.valueAt
				// (3-(3)))));
				thd.lex.sqlCommand = SQLCommand.SQLCOM_KILL;
			}
			;
			break;
		//
		//
		// case 1870:
		// if (yyn == 1870)
		// /* Line 350 of lalr1.java */
		// /* Line 13064 of "sql_yacc.y" */
		// { Lex->type= 0; };
		// break;
		//
		//
		// case 1871:
		// if (yyn == 1871)
		// /* Line 350 of lalr1.java */
		// /* Line 13065 of "sql_yacc.y" */
		// { Lex->type= 0; };
		// break;
		//
		//
		// case 1872:
		// if (yyn == 1872)
		// /* Line 350 of lalr1.java */
		// /* Line 13066 of "sql_yacc.y" */
		// { Lex->type= ONLY_KILL_QUERY; };
		// break;

		case 1873:
			if (yyn == 1873)
			/* Line 350 of lalr1.java */
			/* Line 13073 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CHANGE_DB;
				// lex->select_lex.db= ((lex_str)(yystack.valueAt (2-(2)))).str;
			}
			;
			break;
		//
		//
		// case 1874:
		// if (yyn == 1874)
		// /* Line 350 of lalr1.java */
		// /* Line 13084 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_BADSTATEMENT, MYF(0),
		// ((filetype)(yystack.valueAt (2-(2)))) == FILETYPE_CSV ? "LOAD DATA" :
		// "LOAD XML");
		// return YYABORT;
		// }
		// };
		// break;

		case 1875:
			if (yyn == 1875)
			/* Line 350 of lalr1.java */
			/* Line 13096 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_LOAD;
				// lex->local_file= ((num)(yystack.valueAt (7-(5))));
				// lex->duplicates= DUP_ERROR;
				// lex->ignore= 0;
				// if (!(lex->exchange= new
				// sql_exchange(((lex_str)(yystack.valueAt
				// (7-(7)))).str, 0, ((filetype)(yystack.valueAt (7-(2)))))))
				// return YYABORT;
			}
			;
			break;

		case 1876:
			if (yyn == 1876)
			/* Line 350 of lalr1.java */
			/* Line 13106 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				if (!MyParserProcessor.addTableToList(thd, new TableIdent(((Token) yystack.valueAt(13 - (12))).lexStr), null,
						((Item) (yystack.valueAt(13 - (13))))))
					return YYABORT;
				// lex->field_list.empty();
				// lex->update_list.empty();
				// lex->value_list.empty();
			}
			;
			break;
		//
		//
		// case 1877:
		// if (yyn == 1877)
		// /* Line 350 of lalr1.java */
		// /* Line 13116 of "sql_yacc.y" */
		// { Lex->exchange->cs= ((charset)(yystack.valueAt (15-(15)))); };
		// break;
		//
		//
		// case 1878:
		// if (yyn == 1878)
		// /* Line 350 of lalr1.java */
		// /* Line 13120 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1879:
		// if (yyn == 1879)
		// /* Line 350 of lalr1.java */
		// /* Line 13124 of "sql_yacc.y" */
		// { yyval= FILETYPE_CSV; };
		// break;
		//
		//
		// case 1880:
		// if (yyn == 1880)
		// /* Line 350 of lalr1.java */
		// /* Line 13125 of "sql_yacc.y" */
		// { yyval= FILETYPE_XML; };
		// break;
		//
		//
		// case 1881:
		// if (yyn == 1881)
		// /* Line 350 of lalr1.java */
		// /* Line 13129 of "sql_yacc.y" */
		// { yyval=0;};
		// break;
		//
		//
		// case 1882:
		// if (yyn == 1882)
		// /* Line 350 of lalr1.java */
		// /* Line 13130 of "sql_yacc.y" */
		// { yyval=1;};
		// break;
		//
		//
		// case 1883:
		// if (yyn == 1883)
		// /* Line 350 of lalr1.java */
		// /* Line 13134 of "sql_yacc.y" */
		// { yyval= TL_WRITE_DEFAULT; };
		// break;
		//
		//
		// case 1884:
		// if (yyn == 1884)
		// /* Line 350 of lalr1.java */
		// /* Line 13136 of "sql_yacc.y" */
		// {
		// #ifdef HAVE_QUERY_CACHE
		// /*
		// Ignore this option in SP to avoid problem with query cache
		// */
		// if (Lex->sphead != 0)
		// yyval= TL_WRITE_DEFAULT;
		// else
		// #endif
		// yyval= TL_WRITE_CONCURRENT_INSERT;
		// };
		// break;
		//
		//
		// case 1885:
		// if (yyn == 1885)
		// /* Line 350 of lalr1.java */
		// /* Line 13147 of "sql_yacc.y" */
		// { yyval= TL_WRITE_LOW_PRIORITY; };
		// break;
		//
		//
		// case 1886:
		// if (yyn == 1886)
		// /* Line 350 of lalr1.java */
		// /* Line 13151 of "sql_yacc.y" */
		// { Lex->duplicates=DUP_ERROR; };
		// break;
		//
		//
		// case 1887:
		// if (yyn == 1887)
		// /* Line 350 of lalr1.java */
		// /* Line 13152 of "sql_yacc.y" */
		// { Lex->duplicates=DUP_REPLACE; };
		// break;
		//
		//
		// case 1888:
		// if (yyn == 1888)
		// /* Line 350 of lalr1.java */
		// /* Line 13153 of "sql_yacc.y" */
		// { Lex->ignore= 1; };
		// break;
		//
		//
		// case 1893:
		// if (yyn == 1893)
		// /* Line 350 of lalr1.java */
		// /* Line 13168 of "sql_yacc.y" */
		// {
		// DBUG_ASSERT(Lex->exchange != 0);
		// Lex->exchange->field_term= ((string)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1894:
		// if (yyn == 1894)
		// /* Line 350 of lalr1.java */
		// /* Line 13173 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// DBUG_ASSERT(lex->exchange != 0);
		// lex->exchange->enclosed= ((string)(yystack.valueAt (4-(4))));
		// lex->exchange->opt_enclosed= 1;
		// };
		// break;
		//
		//
		// case 1895:
		// if (yyn == 1895)
		// /* Line 350 of lalr1.java */
		// /* Line 13180 of "sql_yacc.y" */
		// {
		// DBUG_ASSERT(Lex->exchange != 0);
		// Lex->exchange->enclosed= ((string)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1896:
		// if (yyn == 1896)
		// /* Line 350 of lalr1.java */
		// /* Line 13185 of "sql_yacc.y" */
		// {
		// DBUG_ASSERT(Lex->exchange != 0);
		// Lex->exchange->escaped= ((string)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1901:
		// if (yyn == 1901)
		// /* Line 350 of lalr1.java */
		// /* Line 13203 of "sql_yacc.y" */
		// {
		// DBUG_ASSERT(Lex->exchange != 0);
		// Lex->exchange->line_term= ((string)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1902:
		// if (yyn == 1902)
		// /* Line 350 of lalr1.java */
		// /* Line 13208 of "sql_yacc.y" */
		// {
		// DBUG_ASSERT(Lex->exchange != 0);
		// Lex->exchange->line_start= ((string)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1903:
		// if (yyn == 1903)
		// /* Line 350 of lalr1.java */
		// /* Line 13215 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 1904:
		// if (yyn == 1904)
		// /* Line 350 of lalr1.java */
		// /* Line 13217 of "sql_yacc.y" */
		// { Lex->exchange->line_term = ((string)(yystack.valueAt (4-(4)))); };
		// break;
		//
		//
		// case 1906:
		// if (yyn == 1906)
		// /* Line 350 of lalr1.java */
		// /* Line 13222 of "sql_yacc.y" */
		// {
		// DBUG_ASSERT(Lex->exchange != 0);
		// Lex->exchange->skip_lines= atol(((lex_str)(yystack.valueAt
		// (3-(2)))).str);
		// };
		// break;
		//
		//
		// case 1907:
		// if (yyn == 1907)
		// /* Line 350 of lalr1.java */
		// /* Line 13229 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 1908:
		// if (yyn == 1908)
		// /* Line 350 of lalr1.java */
		// /* Line 13231 of "sql_yacc.y" */
		// { };
		// break;
		//
		//
		// case 1909:
		// if (yyn == 1909)
		// /* Line 350 of lalr1.java */
		// /* Line 13235 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1910:
		// if (yyn == 1910)
		// /* Line 350 of lalr1.java */
		// /* Line 13236 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1911:
		// if (yyn == 1911)
		// /* Line 350 of lalr1.java */
		// /* Line 13237 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1912:
		// if (yyn == 1912)
		// /* Line 350 of lalr1.java */
		// /* Line 13242 of "sql_yacc.y" */
		// { Lex->field_list.push_back(((item)(yystack.valueAt (3-(3))))); };
		// break;
		//
		//
		// case 1913:
		// if (yyn == 1913)
		// /* Line 350 of lalr1.java */
		// /* Line 13244 of "sql_yacc.y" */
		// { Lex->field_list.push_back(((item)(yystack.valueAt (1-(1))))); };
		// break;
		//
		//
		// case 1914:
		// if (yyn == 1914)
		// /* Line 350 of lalr1.java */
		// /* Line 13248 of "sql_yacc.y" */
		// {yyval= ((item)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1915:
		// if (yyn == 1915)
		// /* Line 350 of lalr1.java */
		// /* Line 13250 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_user_var_as_out_param(((lex_str)(yystack.valueAt (2-(2)))));
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1916:
		// if (yyn == 1916)
		// /* Line 350 of lalr1.java */
		// /* Line 13258 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1917:
		// if (yyn == 1917)
		// /* Line 350 of lalr1.java */
		// /* Line 13259 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1920:
		// if (yyn == 1920)
		// /* Line 350 of lalr1.java */
		// /* Line 13269 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// uint length= (uint) (((simple_string)(yystack.valueAt (5-(5)))) -
		// ((simple_string)(yystack.valueAt (5-(3)))));
		// String *val= new (YYTHD->mem_root)
		// String(((simple_string)(yystack.valueAt (5-(3)))),
		// length,
		// YYTHD->charset());
		// if (val == NULL)
		// return YYABORT;
		// if (lex->update_list.push_back(((item)(yystack.valueAt (5-(1))))) ||
		// lex->value_list.push_back(((item)(yystack.valueAt (5-(4))))) ||
		// lex->load_set_str_list.push_back(val))
		// return YYABORT;
		// ((item)(yystack.valueAt
		// (5-(4))))->item_name.copy(((simple_string)(yystack.valueAt (5-(3)))),
		// length, YYTHD->charset());
		// };
		// break;
		//
		//
		// case 1921:
		// if (yyn == 1921)
		// /* Line 350 of lalr1.java */
		// /* Line 13289 of "sql_yacc.y" */
		// {
		// LEX_STRING tmp;
		// THD *thd= YYTHD;
		// const CHARSET_INFO *cs_con= thd->variables.collation_connection;
		// const CHARSET_INFO *cs_cli= thd->variables.character_set_client;
		// uint repertoire= thd->lex->text_string_is_7bit &&
		// my_charset_is_ascii_based(cs_cli) ?
		// MY_REPERTOIRE_ASCII : MY_REPERTOIRE_UNICODE30;
		// if (thd->charset_is_collation_connection ||
		// (repertoire == MY_REPERTOIRE_ASCII &&
		// my_charset_is_ascii_based(cs_con)))
		// tmp= ((lex_str)(yystack.valueAt (1-(1))));
		// else
		// {
		// if (thd->convert_string(&tmp, cs_con, ((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length, cs_cli))
		// return YYABORT;
		// }
		// yyval= new (thd->mem_root) Item_string(tmp.str, tmp.length, cs_con,
		// DERIVATION_COERCIBLE,
		// repertoire);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1922:
		// if (yyn == 1922)
		// /* Line 350 of lalr1.java */
		// /* Line 13313 of "sql_yacc.y" */
		// {
		// uint repertoire= Lex->text_string_is_7bit ?
		// MY_REPERTOIRE_ASCII : MY_REPERTOIRE_UNICODE30;
		// DBUG_ASSERT(my_charset_is_ascii_based(national_charset_info));
		// yyval= new (YYTHD->mem_root) Item_string(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length,
		// national_charset_info,
		// DERIVATION_COERCIBLE,
		// repertoire);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1923:
		// if (yyn == 1923)
		// /* Line 350 of lalr1.java */
		// /* Line 13325 of "sql_yacc.y" */
		// {
		// Item_string *str= new (YYTHD->mem_root)
		// Item_string(((lex_str)(yystack.valueAt (2-(2)))).str,
		// ((lex_str)(yystack.valueAt (2-(2)))).length,
		// ((charset)(yystack.valueAt (2-(1)))));
		// if (str == NULL)
		// return YYABORT;
		// str->set_repertoire_from_value();
		// str->set_cs_specified(TRUE);
		//
		// yyval= str;
		// };
		// break;
		//
		//
		// case 1924:
		// if (yyn == 1924)
		// /* Line 350 of lalr1.java */
		// /* Line 13336 of "sql_yacc.y" */
		// {
		// Item_string* item= (Item_string*) ((item)(yystack.valueAt (2-(1))));
		// item->append(((lex_str)(yystack.valueAt (2-(2)))).str,
		// ((lex_str)(yystack.valueAt (2-(2)))).length);
		// if (!(item->collation.repertoire & MY_REPERTOIRE_EXTENDED))
		// {
		// /*
		// If the string has been pure ASCII so far,
		// check the new part.
		// */
		// const CHARSET_INFO *cs= YYTHD->variables.collation_connection;
		// item->collation.repertoire|= my_string_repertoire(cs,
		// ((lex_str)(yystack.valueAt (2-(2)))).str,
		// ((lex_str)(yystack.valueAt (2-(2)))).length);
		// }
		// };
		// break;
		//
		//
		// case 1925:
		// if (yyn == 1925)
		// /* Line 350 of lalr1.java */
		// /* Line 13355 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) String(((lex_str)(yystack.valueAt
		// (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length,
		// YYTHD->variables.collation_connection);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1926:
		// if (yyn == 1926)
		// /* Line 350 of lalr1.java */
		// /* Line 13363 of "sql_yacc.y" */
		// {
		// Item *tmp= new (YYTHD->mem_root)
		// Item_hex_string(((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (tmp == NULL)
		// return YYABORT;
		// /*
		// it is OK only emulate fix_fields, because we need only
		// value of constant
		// */
		// tmp->quick_fix_field();
		// yyval= tmp->val_str((String*) 0);
		// };
		// break;
		//
		//
		// case 1927:
		// if (yyn == 1927)
		// /* Line 350 of lalr1.java */
		// /* Line 13375 of "sql_yacc.y" */
		// {
		// Item *tmp= new (YYTHD->mem_root)
		// Item_bin_string(((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (tmp == NULL)
		// return YYABORT;
		// /*
		// it is OK only emulate fix_fields, because we need only
		// value of constant
		// */
		// tmp->quick_fix_field();
		// yyval= tmp->val_str((String*) 0);
		// };
		// break;
		//
		//
		// case 1928:
		// if (yyn == 1928)
		// /* Line 350 of lalr1.java */
		// /* Line 13390 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// Lex_input_stream *lip= YYLIP;
		// Item_param *item;
		// if (! lex->parsing_options.allows_variable)
		// {
		// my_error(ER_VIEW_SELECT_VARIABLE, MYF(0));
		// return YYABORT;
		// }
		// item= new (thd->mem_root) Item_param((uint) (lip->get_tok_start() -
		// thd->query()));
		// if (!(yyval= item) || lex->param_list.push_back(item))
		// {
		// my_message(ER_OUT_OF_RESOURCES, ER(ER_OUT_OF_RESOURCES), MYF(0));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1929:
		// if (yyn == 1929)
		// /* Line 350 of lalr1.java */
		// /* Line 13410 of "sql_yacc.y" */
		// { yyval = ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1930:
		// if (yyn == 1930)
		// /* Line 350 of lalr1.java */
		// /* Line 13411 of "sql_yacc.y" */
		// { yyval = ((item_num)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 1931:
		// if (yyn == 1931)
		// /* Line 350 of lalr1.java */
		// /* Line 13413 of "sql_yacc.y" */
		// {
		// ((item_num)(yystack.valueAt (2-(2))))->max_length++;
		// yyval= ((item_num)(yystack.valueAt (2-(2))))->neg();
		// };
		// break;
		//
		//
		// case 1932:
		// if (yyn == 1932)
		// /* Line 350 of lalr1.java */
		// /* Line 13421 of "sql_yacc.y" */
		// { yyval = ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1933:
		// if (yyn == 1933)
		// /* Line 350 of lalr1.java */
		// /* Line 13422 of "sql_yacc.y" */
		// { yyval = ((item_num)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1934:
		// if (yyn == 1934)
		// /* Line 350 of lalr1.java */
		// /* Line 13423 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1935:
		// if (yyn == 1935)
		// /* Line 350 of lalr1.java */
		// /* Line 13425 of "sql_yacc.y" */
		// {
		// Lex_input_stream *lip= YYLIP;
		// /*
		// For the digest computation, in this context only,
		// NULL is considered a literal, hence reduced to '?'
		// REDUCE:
		// TOK_GENERIC_VALUE := NULL_SYM
		// */
		// lip->reduce_digest_token(TOK_GENERIC_VALUE, NULL_SYM);
		// yyval = new (YYTHD->mem_root) Item_null();
		// if (yyval == NULL)
		// return YYABORT;
		// YYLIP->next_state= MY_LEX_OPERATOR_OR_IDENT;
		// };
		// break;
		//
		//
		// case 1936:
		// if (yyn == 1936)
		// /* Line 350 of lalr1.java */
		// /* Line 13440 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_int(NAME_STRING("FALSE"), 0, 1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1937:
		// if (yyn == 1937)
		// /* Line 350 of lalr1.java */
		// /* Line 13446 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_int(NAME_STRING("TRUE"), 1, 1);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1938:
		// if (yyn == 1938)
		// /* Line 350 of lalr1.java */
		// /* Line 13452 of "sql_yacc.y" */
		// {
		// yyval = new (YYTHD->mem_root)
		// Item_hex_string(((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1939:
		// if (yyn == 1939)
		// /* Line 350 of lalr1.java */
		// /* Line 13458 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root)
		// Item_bin_string(((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1940:
		// if (yyn == 1940)
		// /* Line 350 of lalr1.java */
		// /* Line 13464 of "sql_yacc.y" */
		// {
		// Item *tmp= new (YYTHD->mem_root)
		// Item_hex_string(((lex_str)(yystack.valueAt (2-(2)))).str,
		// ((lex_str)(yystack.valueAt (2-(2)))).length);
		// if (tmp == NULL)
		// return YYABORT;
		// /*
		// it is OK only emulate fix_fieds, because we need only
		// value of constant
		// */
		// tmp->quick_fix_field();
		// String *str= tmp->val_str((String*) 0);
		//
		// Item_string *item_str;
		// item_str= new (YYTHD->mem_root)
		// Item_string(null_name_string, /* name will be set in select_item */
		// str ? str->ptr() : "",
		// str ? str->length() : 0,
		// ((charset)(yystack.valueAt (2-(1)))));
		// if (!item_str ||
		// !item_str->check_well_formed_result(&item_str->str_value,
		// true, //send error
		// true)) //truncate
		// {
		// return YYABORT;
		// }
		//
		// item_str->set_repertoire_from_value();
		// item_str->set_cs_specified(TRUE);
		//
		// yyval= item_str;
		// };
		// break;
		//
		//
		// case 1941:
		// if (yyn == 1941)
		// /* Line 350 of lalr1.java */
		// /* Line 13495 of "sql_yacc.y" */
		// {
		// Item *tmp= new (YYTHD->mem_root)
		// Item_bin_string(((lex_str)(yystack.valueAt (2-(2)))).str,
		// ((lex_str)(yystack.valueAt (2-(2)))).length);
		// if (tmp == NULL)
		// return YYABORT;
		// /*
		// it is OK only emulate fix_fieds, because we need only
		// value of constant
		// */
		// tmp->quick_fix_field();
		// String *str= tmp->val_str((String*) 0);
		//
		// Item_string *item_str;
		// item_str= new (YYTHD->mem_root)
		// Item_string(null_name_string, /* name will be set in select_item */
		// str ? str->ptr() : "",
		// str ? str->length() : 0,
		// ((charset)(yystack.valueAt (2-(1)))));
		// if (!item_str ||
		// !item_str->check_well_formed_result(&item_str->str_value,
		// true, //send error
		// true)) //truncate
		// {
		// return YYABORT;
		// }
		//
		// item_str->set_cs_specified(TRUE);
		//
		// yyval= item_str;
		// };
		// break;
		//
		//
		// case 1942:
		// if (yyn == 1942)
		// /* Line 350 of lalr1.java */
		// /* Line 13528 of "sql_yacc.y" */
		// {
		// int error;
		// yyval= new (YYTHD->mem_root)
		// Item_int(((lex_str)(yystack.valueAt (1-(1)))),
		// (longlong) my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str,
		// NULL, &error),
		// ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1943:
		// if (yyn == 1943)
		// /* Line 350 of lalr1.java */
		// /* Line 13538 of "sql_yacc.y" */
		// {
		// int error;
		// yyval= new (YYTHD->mem_root)
		// Item_int(((lex_str)(yystack.valueAt (1-(1)))),
		// (longlong) my_strtoll10(((lex_str)(yystack.valueAt (1-(1)))).str,
		// NULL, &error),
		// ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1944:
		// if (yyn == 1944)
		// /* Line 350 of lalr1.java */
		// /* Line 13548 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_uint(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1945:
		// if (yyn == 1945)
		// /* Line 350 of lalr1.java */
		// /* Line 13554 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_decimal(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length,
		// YYTHD->charset());
		// if ((yyval == NULL) || (YYTHD->is_error()))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1946:
		// if (yyn == 1946)
		// /* Line 350 of lalr1.java */
		// /* Line 13563 of "sql_yacc.y" */
		// {
		// yyval= new (YYTHD->mem_root) Item_float(((lex_str)(yystack.valueAt
		// (1-(1)))).str, ((lex_str)(yystack.valueAt (1-(1)))).length);
		// if ((yyval == NULL) || (YYTHD->is_error()))
		// {
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1947:
		// if (yyn == 1947)
		// /* Line 350 of lalr1.java */
		// /* Line 13575 of "sql_yacc.y" */
		// {
		// if (!(yyval= create_temporal_literal(YYTHD,
		// ((lex_str)(yystack.valueAt (2-(2)))).str, ((lex_str)(yystack.valueAt
		// (2-(2)))).length, YYCSCL,
		// MYSQL_TYPE_DATE, true)))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1948:
		// if (yyn == 1948)
		// /* Line 350 of lalr1.java */
		// /* Line 13581 of "sql_yacc.y" */
		// {
		// if (!(yyval= create_temporal_literal(YYTHD,
		// ((lex_str)(yystack.valueAt (2-(2)))).str, ((lex_str)(yystack.valueAt
		// (2-(2)))).length, YYCSCL,
		// MYSQL_TYPE_TIME, true)))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1949:
		// if (yyn == 1949)
		// /* Line 350 of lalr1.java */
		// /* Line 13587 of "sql_yacc.y" */
		// {
		// if (!(yyval= create_temporal_literal(YYTHD,
		// ((lex_str)(yystack.valueAt (2-(2)))).str, ((lex_str)(yystack.valueAt
		// (2-(2)))).length, YYCSCL,
		// MYSQL_TYPE_DATETIME, true)))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1950:
		// if (yyn == 1950)
		// /* Line 350 of lalr1.java */
		// /* Line 13602 of "sql_yacc.y" */
		// { yyval=((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1951:
		// if (yyn == 1951)
		// /* Line 350 of lalr1.java */
		// /* Line 13603 of "sql_yacc.y" */
		// { yyval=((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1952:
		// if (yyn == 1952)
		// /* Line 350 of lalr1.java */
		// /* Line 13608 of "sql_yacc.y" */
		// {
		// SELECT_LEX *sel= Select;
		// yyval= new (YYTHD->mem_root) Item_field(Lex->current_context(),
		// NullS, ((lex_str)(yystack.valueAt (3-(1)))).str, "*");
		// if (yyval == NULL)
		// return YYABORT;
		// sel->with_wild++;
		// };
		// break;
		//
		//
		// case 1953:
		// if (yyn == 1953)
		// /* Line 350 of lalr1.java */
		// /* Line 13617 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// SELECT_LEX *sel= Select;
		// const char* schema= thd->client_capabilities & CLIENT_NO_SCHEMA ?
		// NullS : ((lex_str)(yystack.valueAt (5-(1)))).str;
		// yyval= new (thd->mem_root) Item_field(Lex->current_context(),
		// schema,
		// ((lex_str)(yystack.valueAt (5-(3)))).str,"*");
		// if (yyval == NULL)
		// return YYABORT;
		// sel->with_wild++;
		// };
		// break;
		//
		//
		// case 1954:
		// if (yyn == 1954)
		// /* Line 350 of lalr1.java */
		// /* Line 13632 of "sql_yacc.y" */
		// { yyval=((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1955:
		// if (yyn == 1955)
		// /* Line 350 of lalr1.java */
		// /* Line 13637 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_pcontext *pctx = lex->get_sp_current_parsing_ctx();
		// sp_variable *spv;
		//
		// if (pctx && (spv= pctx->find_variable(((lex_str)(yystack.valueAt
		// (1-(1)))), false)))
		// {
		// Lex_input_stream *lip= &thd->m_parser_state->m_lip;
		// sp_head *sp= lex->sphead;
		//
		// DBUG_ASSERT(sp);
		//
		// /* We're compiling a stored procedure and found a variable */
		// if (! lex->parsing_options.allows_variable)
		// {
		// my_error(ER_VIEW_SELECT_VARIABLE, MYF(0));
		// return YYABORT;
		// }
		//
		// yyval=
		// create_item_for_sp_var(
		// thd, ((lex_str)(yystack.valueAt (1-(1)))), spv,
		// sp->m_parser_data.get_current_stmt_start_ptr(),
		// lip->get_tok_start_prev(),
		// lip->get_tok_end());
		//
		// if (yyval == NULL)
		// return YYABORT;
		//
		// lex->safe_to_cache_query= false;
		// }
		// else
		// {
		// SELECT_LEX *sel=Select;
		// if ((sel->parsing_place != IN_HAVING) ||
		// (sel->get_in_sum_expr() > 0))
		// {
		// yyval= new (thd->mem_root) Item_field(Lex->current_context(),
		// NullS, NullS, ((lex_str)(yystack.valueAt (1-(1)))).str);
		// }
		// else
		// {
		// yyval= new (thd->mem_root) Item_ref(Lex->current_context(),
		// NullS, NullS, ((lex_str)(yystack.valueAt (1-(1)))).str);
		// }
		// if (yyval == NULL)
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1956:
		// if (yyn == 1956)
		// /* Line 350 of lalr1.java */
		// /* Line 13687 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1957:
		// if (yyn == 1957)
		// /* Line 350 of lalr1.java */
		// /* Line 13692 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// SELECT_LEX *sel=Select;
		// if ((sel->parsing_place != IN_HAVING) ||
		// (sel->get_in_sum_expr() > 0))
		// {
		// yyval= new (thd->mem_root) Item_field(Lex->current_context(),
		// NullS, NullS, ((lex_str)(yystack.valueAt (1-(1)))).str);
		// }
		// else
		// {
		// yyval= new (thd->mem_root) Item_ref(Lex->current_context(),
		// NullS, NullS, ((lex_str)(yystack.valueAt (1-(1)))).str);
		// }
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1958:
		// if (yyn == 1958)
		// /* Line 350 of lalr1.java */
		// /* Line 13709 of "sql_yacc.y" */
		// { yyval= ((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1959:
		// if (yyn == 1959)
		// /* Line 350 of lalr1.java */
		// /* Line 13714 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		//
		// /*
		// FIXME This will work ok in simple_ident_nospvar case because
		// we can't meet simple_ident_nospvar in trigger now. But it
		// should be changed in future.
		// */
		// if (sp && sp->m_type == SP_TYPE_TRIGGER &&
		// (!my_strcasecmp(system_charset_info, ((lex_str)(yystack.valueAt
		// (3-(1)))).str, "NEW") ||
		// !my_strcasecmp(system_charset_info, ((lex_str)(yystack.valueAt
		// (3-(1)))).str, "OLD")))
		// {
		// Item_trigger_field *trg_fld;
		// bool new_row= (((lex_str)(yystack.valueAt (3-(1)))).str[0]=='N' ||
		// ((lex_str)(yystack.valueAt (3-(1)))).str[0]=='n');
		//
		// if (sp->m_trg_chistics.event == TRG_EVENT_INSERT &&
		// !new_row)
		// {
		// my_error(ER_TRG_NO_SUCH_ROW_IN_TRG, MYF(0), "OLD", "on INSERT");
		// return YYABORT;
		// }
		//
		// if (sp->m_trg_chistics.event == TRG_EVENT_DELETE &&
		// new_row)
		// {
		// my_error(ER_TRG_NO_SUCH_ROW_IN_TRG, MYF(0), "NEW", "on DELETE");
		// return YYABORT;
		// }
		//
		// DBUG_ASSERT(!new_row ||
		// (sp->m_trg_chistics.event == TRG_EVENT_INSERT ||
		// sp->m_trg_chistics.event == TRG_EVENT_UPDATE));
		// const bool read_only=
		// !(new_row && sp->m_trg_chistics.action_time == TRG_ACTION_BEFORE);
		// trg_fld= new (thd->mem_root)
		// Item_trigger_field(Lex->current_context(),
		// new_row ?
		// Item_trigger_field::NEW_ROW:
		// Item_trigger_field::OLD_ROW,
		// ((lex_str)(yystack.valueAt (3-(3)))).str,
		// SELECT_ACL,
		// read_only);
		// if (trg_fld == NULL)
		// return YYABORT;
		//
		// /*
		// Let us add this item to list of all Item_trigger_field objects
		// in trigger.
		// */
		// lex->sphead->m_cur_instr_trig_field_items.link_in_list(
		// trg_fld, &trg_fld->next_trg_field);
		//
		// yyval= trg_fld;
		// }
		// else
		// {
		// SELECT_LEX *sel= lex->current_select;
		// if (sel->no_table_names_allowed)
		// {
		// my_error(ER_TABLENAME_NOT_ALLOWED_HERE,
		// MYF(0), ((lex_str)(yystack.valueAt (3-(1)))).str, thd->where);
		// }
		// if ((sel->parsing_place != IN_HAVING) ||
		// (sel->get_in_sum_expr() > 0))
		// {
		// yyval= new (thd->mem_root) Item_field(Lex->current_context(),
		// NullS, ((lex_str)(yystack.valueAt (3-(1)))).str,
		// ((lex_str)(yystack.valueAt (3-(3)))).str);
		// }
		// else
		// {
		// yyval= new (thd->mem_root) Item_ref(Lex->current_context(),
		// NullS, ((lex_str)(yystack.valueAt (3-(1)))).str,
		// ((lex_str)(yystack.valueAt (3-(3)))).str);
		// }
		// if (yyval == NULL)
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1960:
		// if (yyn == 1960)
		// /* Line 350 of lalr1.java */
		// /* Line 13794 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// SELECT_LEX *sel= lex->current_select;
		// if (sel->no_table_names_allowed)
		// {
		// my_error(ER_TABLENAME_NOT_ALLOWED_HERE,
		// MYF(0), ((lex_str)(yystack.valueAt (4-(2)))).str, thd->where);
		// }
		// if ((sel->parsing_place != IN_HAVING) ||
		// (sel->get_in_sum_expr() > 0))
		// {
		// yyval= new (thd->mem_root) Item_field(Lex->current_context(),
		// NullS, ((lex_str)(yystack.valueAt (4-(2)))).str,
		// ((lex_str)(yystack.valueAt (4-(4)))).str);
		//
		// }
		// else
		// {
		// yyval= new (thd->mem_root) Item_ref(Lex->current_context(),
		// NullS, ((lex_str)(yystack.valueAt (4-(2)))).str,
		// ((lex_str)(yystack.valueAt (4-(4)))).str);
		// }
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1961:
		// if (yyn == 1961)
		// /* Line 350 of lalr1.java */
		// /* Line 13819 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// SELECT_LEX *sel= lex->current_select;
		// const char* schema= (thd->client_capabilities & CLIENT_NO_SCHEMA ?
		// NullS : ((lex_str)(yystack.valueAt (5-(1)))).str);
		// if (sel->no_table_names_allowed)
		// {
		// my_error(ER_TABLENAME_NOT_ALLOWED_HERE,
		// MYF(0), ((lex_str)(yystack.valueAt (5-(3)))).str, thd->where);
		// }
		// if ((sel->parsing_place != IN_HAVING) ||
		// (sel->get_in_sum_expr() > 0))
		// {
		// yyval= new (thd->mem_root) Item_field(Lex->current_context(),
		// schema,
		// ((lex_str)(yystack.valueAt (5-(3)))).str, ((lex_str)(yystack.valueAt
		// (5-(5)))).str);
		// }
		// else
		// {
		// yyval= new (thd->mem_root) Item_ref(Lex->current_context(),
		// schema,
		// ((lex_str)(yystack.valueAt (5-(3)))).str, ((lex_str)(yystack.valueAt
		// (5-(5)))).str);
		// }
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1962:
		// if (yyn == 1962)
		// /* Line 350 of lalr1.java */
		// /* Line 13849 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1963:
		// if (yyn == 1963)
		// /* Line 350 of lalr1.java */
		// /* Line 13851 of "sql_yacc.y" */
		// {
		// TABLE_LIST *table= Select->table_list.first;
		// if (my_strcasecmp(table_alias_charset, ((lex_str)(yystack.valueAt
		// (5-(1)))).str, table->db))
		// {
		// my_error(ER_WRONG_DB_NAME, MYF(0), ((lex_str)(yystack.valueAt
		// (5-(1)))).str);
		// return YYABORT;
		// }
		// if (my_strcasecmp(table_alias_charset, ((lex_str)(yystack.valueAt
		// (5-(3)))).str,
		// table->table_name))
		// {
		// my_error(ER_WRONG_TABLE_NAME, MYF(0), ((lex_str)(yystack.valueAt
		// (5-(3)))).str);
		// return YYABORT;
		// }
		// yyval=((lex_str)(yystack.valueAt (5-(5))));
		// };
		// break;
		//
		//
		// case 1964:
		// if (yyn == 1964)
		// /* Line 350 of lalr1.java */
		// /* Line 13867 of "sql_yacc.y" */
		// {
		// TABLE_LIST *table= Select->table_list.first;
		// if (my_strcasecmp(table_alias_charset, ((lex_str)(yystack.valueAt
		// (3-(1)))).str, table->alias))
		// {
		// my_error(ER_WRONG_TABLE_NAME, MYF(0), ((lex_str)(yystack.valueAt
		// (3-(1)))).str);
		// return YYABORT;
		// }
		// yyval=((lex_str)(yystack.valueAt (3-(3))));
		// };
		// break;
		//
		//
		// case 1965:
		// if (yyn == 1965)
		// /* Line 350 of lalr1.java */
		// /* Line 13876 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (2-(2))));};
		// break;

		case 1966:
			if (yyn == 1966)
			/* Line 350 of lalr1.java */
			/* Line 13881 of "sql_yacc.y" */
			{
				yyval = new TableIdent(((Token) (yystack.valueAt(1 - (1)))).lexStr);
			}
			;
			break;

		case 1967:
			if (yyn == 1967)
			/* Line 350 of lalr1.java */
			/* Line 13887 of "sql_yacc.y" */
			{
				yyval = new TableIdent(((Token) (yystack.valueAt(3 - (1)))).lexStr, ((Token) (yystack.valueAt(3 - (3)))).lexStr);
			}
			;
			break;

		case 1968:
			if (yyn == 1968)
			/* Line 350 of lalr1.java */
			/* Line 13893 of "sql_yacc.y" */
			{
				/* For Delphi */
				yyval = new TableIdent(((Token) (yystack.valueAt(2 - (2)))).lexStr);
			}
			;
			break;

		case 1969:
			if (yyn == 1969)
			/* Line 350 of lalr1.java */
			/* Line 13903 of "sql_yacc.y" */
			{
				yyval = new TableIdent(((Token) (yystack.valueAt(2 - (1)))).lexStr);
			}
			;
			break;

		case 1970:
			if (yyn == 1970)
			/* Line 350 of lalr1.java */
			/* Line 13909 of "sql_yacc.y" */
			{
				yyval = new TableIdent(((Token) (yystack.valueAt(4 - (1)))).lexStr, ((Token) (yystack.valueAt(4 - (3)))).lexStr);
			}
			;
			break;

		case 1971:
			if (yyn == 1971)
			/* Line 350 of lalr1.java */
			/* Line 13918 of "sql_yacc.y" */
			{
				yyval = new TableIdent(LexConstants.ANY_DB, ((Token) yystack.valueAt(1 - (1))).lexStr);
			}
			;
			break;

		case 1972:
			if (yyn == 1972)
			/* Line 350 of lalr1.java */
			/* Line 13927 of "sql_yacc.y" */
			{
				yyval = ((Item) (yystack.valueAt(1 - (1))));
			}
			;
			break;
		//
		//
		// case 1973:
		// if (yyn == 1973)
		// /* Line 350 of lalr1.java */
		// /* Line 13929 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		//
		// if (thd->charset_is_system_charset)
		// {
		// const CHARSET_INFO *cs= system_charset_info;
		// int dummy_error;
		// uint wlen= cs->cset->well_formed_len(cs, ((lex_str)(yystack.valueAt
		// (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).str+((lex_str)(yystack.valueAt
		// (1-(1)))).length,
		// ((lex_str)(yystack.valueAt (1-(1)))).length, &dummy_error);
		// if (wlen < ((lex_str)(yystack.valueAt (1-(1)))).length)
		// {
		// ErrConvString err(((lex_str)(yystack.valueAt (1-(1)))).str,
		// ((lex_str)(yystack.valueAt (1-(1)))).length, &my_charset_bin);
		// my_error(ER_INVALID_CHARACTER_STRING, MYF(0),
		// cs->csname, err.ptr());
		// return YYABORT;
		// }
		// yyval= ((lex_str)(yystack.valueAt (1-(1))));
		// }
		// else
		// {
		// if (thd->convert_string(&yyval, system_charset_info,
		// ((lex_str)(yystack.valueAt (1-(1)))).str, ((lex_str)(yystack.valueAt
		// (1-(1)))).length, thd->charset()))
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1974:
		// if (yyn == 1974)
		// /* Line 350 of lalr1.java */
		// /* Line 13959 of "sql_yacc.y" */
		// {
		// if (!strcont(((lex_str)(yystack.valueAt (1-(1)))).str, "\n"))
		// yyval= ((lex_str)(yystack.valueAt (1-(1))));
		// else
		// {
		// my_error(ER_WRONG_VALUE, MYF(0), "argument contains not-allowed LF",
		// ((lex_str)(yystack.valueAt (1-(1)))).str);
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1975:
		// if (yyn == 1975)
		// /* Line 350 of lalr1.java */
		// /* Line 13972 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		//
		// if (thd->charset_is_system_charset)
		// yyval= ((lex_str)(yystack.valueAt (1-(1))));
		// else
		// {
		// if (thd->convert_string(&yyval, system_charset_info,
		// ((lex_str)(yystack.valueAt (1-(1)))).str, ((lex_str)(yystack.valueAt
		// (1-(1)))).length, thd->charset()))
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1976:
		// if (yyn == 1976)
		// /* Line 350 of lalr1.java */
		// /* Line 13988 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		//
		// if (thd->charset_is_collation_connection)
		// yyval= ((lex_str)(yystack.valueAt (1-(1))));
		// else
		// {
		// if (thd->convert_string(&yyval, thd->variables.collation_connection,
		// ((lex_str)(yystack.valueAt (1-(1)))).str, ((lex_str)(yystack.valueAt
		// (1-(1)))).length, thd->charset()))
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1977:
		// if (yyn == 1977)
		// /* Line 350 of lalr1.java */
		// /* Line 14004 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		//
		// if (thd->charset_is_character_set_filesystem)
		// yyval= ((lex_str)(yystack.valueAt (1-(1))));
		// else
		// {
		// if (thd->convert_string(&yyval,
		// thd->variables.character_set_filesystem,
		// ((lex_str)(yystack.valueAt (1-(1)))).str, ((lex_str)(yystack.valueAt
		// (1-(1)))).length, thd->charset()))
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 1978:
		// if (yyn == 1978)
		// /* Line 350 of lalr1.java */
		// /* Line 14020 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1979:
		// if (yyn == 1979)
		// /* Line 350 of lalr1.java */
		// /* Line 14022 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// yyval.str= thd->strmake(((symbol)(yystack.valueAt (1-(1)))).str,
		// ((symbol)(yystack.valueAt (1-(1)))).length);
		// if (yyval.str == NULL)
		// return YYABORT;
		// yyval.length= ((symbol)(yystack.valueAt (1-(1)))).length;
		// };
		// break;
		//
		//
		// case 1980:
		// if (yyn == 1980)
		// /* Line 350 of lalr1.java */
		// /* Line 14032 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 1981:
		// if (yyn == 1981)
		// /* Line 350 of lalr1.java */
		// /* Line 14034 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// yyval.str= thd->strmake(((symbol)(yystack.valueAt (1-(1)))).str,
		// ((symbol)(yystack.valueAt (1-(1)))).length);
		// if (yyval.str == NULL)
		// return YYABORT;
		// yyval.length= ((symbol)(yystack.valueAt (1-(1)))).length;
		// };
		// break;
		//
		//
		// case 1982:
		// if (yyn == 1982)
		// /* Line 350 of lalr1.java */
		// /* Line 14044 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1983:
		// if (yyn == 1983)
		// /* Line 350 of lalr1.java */
		// /* Line 14045 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1984:
		// if (yyn == 1984)
		// /* Line 350 of lalr1.java */
		// /* Line 14046 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1))));};
		// break;
		//
		//
		// case 1985:
		// if (yyn == 1985)
		// /* Line 350 of lalr1.java */
		// /* Line 14051 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// if (!(yyval=(LEX_USER*) thd->alloc(sizeof(st_lex_user))))
		// return YYABORT;
		// yyval->user= ((lex_str)(yystack.valueAt (1-(1))));
		// yyval->host.str= (char *) "%";
		// yyval->host.length= 1;
		// yyval->password= null_lex_str;
		// yyval->plugin= empty_lex_str;
		// yyval->auth= empty_lex_str;
		// yyval->uses_identified_by_clause= false;
		// yyval->uses_identified_with_clause= false;
		// yyval->uses_identified_by_password_clause= false;
		// yyval->uses_authentication_string_clause= false;
		//
		// /*
		// Trim whitespace as the values will go to a CHAR field
		// when stored.
		// */
		// trim_whitespace(system_charset_info, &yyval->user);
		//
		// if (check_string_char_length(&yyval->user, ER(ER_USERNAME),
		// USERNAME_CHAR_LENGTH,
		// system_charset_info, 0))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 1986:
		// if (yyn == 1986)
		// /* Line 350 of lalr1.java */
		// /* Line 14078 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// if (!(yyval=(LEX_USER*) thd->alloc(sizeof(st_lex_user))))
		// return YYABORT;
		// yyval->user= ((lex_str)(yystack.valueAt (3-(1))));
		// yyval->host= ((lex_str)(yystack.valueAt (3-(3))));
		// yyval->password= null_lex_str;
		// yyval->plugin= empty_lex_str;
		// yyval->auth= empty_lex_str;
		// yyval->uses_identified_by_clause= false;
		// yyval->uses_identified_with_clause= false;
		// yyval->uses_identified_by_password_clause= false;
		// yyval->uses_authentication_string_clause= false;
		//
		// if (check_string_char_length(&yyval->user, ER(ER_USERNAME),
		// USERNAME_CHAR_LENGTH,
		// system_charset_info, 0) ||
		// check_host_name(&yyval->host))
		// return YYABORT;
		// /*
		// Convert hostname part of username to lowercase.
		// It's OK to use in-place lowercase as long as
		// the character set is utf8.
		// */
		// my_casedn_str(system_charset_info, yyval->host.str);
		// /*
		// Trim whitespace as the values will go to a CHAR field
		// when stored.
		// */
		// trim_whitespace(system_charset_info, &yyval->user);
		// trim_whitespace(system_charset_info, &yyval->host);
		// };
		// break;
		//
		//
		// case 1987:
		// if (yyn == 1987)
		// /* Line 350 of lalr1.java */
		// /* Line 14111 of "sql_yacc.y" */
		// {
		// if (!(yyval=(LEX_USER*) YYTHD->alloc(sizeof(st_lex_user))))
		// return YYABORT;
		// /*
		// empty LEX_USER means current_user and
		// will be handled in the get_current_user() function
		// later
		// */
		// memset(yyval, 0, sizeof(LEX_USER));
		// };
		// break;
		//
		//
		// case 1988:
		// if (yyn == 1988)
		// /* Line 350 of lalr1.java */
		// /* Line 14125 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1989:
		// if (yyn == 1989)
		// /* Line 350 of lalr1.java */
		// /* Line 14126 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1990:
		// if (yyn == 1990)
		// /* Line 350 of lalr1.java */
		// /* Line 14127 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1991:
		// if (yyn == 1991)
		// /* Line 350 of lalr1.java */
		// /* Line 14128 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1992:
		// if (yyn == 1992)
		// /* Line 350 of lalr1.java */
		// /* Line 14129 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1993:
		// if (yyn == 1993)
		// /* Line 350 of lalr1.java */
		// /* Line 14130 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1994:
		// if (yyn == 1994)
		// /* Line 350 of lalr1.java */
		// /* Line 14131 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1995:
		// if (yyn == 1995)
		// /* Line 350 of lalr1.java */
		// /* Line 14132 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1996:
		// if (yyn == 1996)
		// /* Line 350 of lalr1.java */
		// /* Line 14133 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1997:
		// if (yyn == 1997)
		// /* Line 350 of lalr1.java */
		// /* Line 14134 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1998:
		// if (yyn == 1998)
		// /* Line 350 of lalr1.java */
		// /* Line 14135 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 1999:
		// if (yyn == 1999)
		// /* Line 350 of lalr1.java */
		// /* Line 14136 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2000:
		// if (yyn == 2000)
		// /* Line 350 of lalr1.java */
		// /* Line 14137 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2001:
		// if (yyn == 2001)
		// /* Line 350 of lalr1.java */
		// /* Line 14138 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2002:
		// if (yyn == 2002)
		// /* Line 350 of lalr1.java */
		// /* Line 14139 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2003:
		// if (yyn == 2003)
		// /* Line 350 of lalr1.java */
		// /* Line 14140 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2004:
		// if (yyn == 2004)
		// /* Line 350 of lalr1.java */
		// /* Line 14141 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2005:
		// if (yyn == 2005)
		// /* Line 350 of lalr1.java */
		// /* Line 14142 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2006:
		// if (yyn == 2006)
		// /* Line 350 of lalr1.java */
		// /* Line 14143 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2007:
		// if (yyn == 2007)
		// /* Line 350 of lalr1.java */
		// /* Line 14144 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2008:
		// if (yyn == 2008)
		// /* Line 350 of lalr1.java */
		// /* Line 14145 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2009:
		// if (yyn == 2009)
		// /* Line 350 of lalr1.java */
		// /* Line 14146 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2010:
		// if (yyn == 2010)
		// /* Line 350 of lalr1.java */
		// /* Line 14147 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2011:
		// if (yyn == 2011)
		// /* Line 350 of lalr1.java */
		// /* Line 14148 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2012:
		// if (yyn == 2012)
		// /* Line 350 of lalr1.java */
		// /* Line 14149 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2013:
		// if (yyn == 2013)
		// /* Line 350 of lalr1.java */
		// /* Line 14150 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2014:
		// if (yyn == 2014)
		// /* Line 350 of lalr1.java */
		// /* Line 14151 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2015:
		// if (yyn == 2015)
		// /* Line 350 of lalr1.java */
		// /* Line 14152 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2016:
		// if (yyn == 2016)
		// /* Line 350 of lalr1.java */
		// /* Line 14153 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2017:
		// if (yyn == 2017)
		// /* Line 350 of lalr1.java */
		// /* Line 14154 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2018:
		// if (yyn == 2018)
		// /* Line 350 of lalr1.java */
		// /* Line 14155 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2019:
		// if (yyn == 2019)
		// /* Line 350 of lalr1.java */
		// /* Line 14156 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2020:
		// if (yyn == 2020)
		// /* Line 350 of lalr1.java */
		// /* Line 14157 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2021:
		// if (yyn == 2021)
		// /* Line 350 of lalr1.java */
		// /* Line 14158 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2022:
		// if (yyn == 2022)
		// /* Line 350 of lalr1.java */
		// /* Line 14159 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2023:
		// if (yyn == 2023)
		// /* Line 350 of lalr1.java */
		// /* Line 14160 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2024:
		// if (yyn == 2024)
		// /* Line 350 of lalr1.java */
		// /* Line 14161 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2025:
		// if (yyn == 2025)
		// /* Line 350 of lalr1.java */
		// /* Line 14162 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2026:
		// if (yyn == 2026)
		// /* Line 350 of lalr1.java */
		// /* Line 14163 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2027:
		// if (yyn == 2027)
		// /* Line 350 of lalr1.java */
		// /* Line 14164 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2028:
		// if (yyn == 2028)
		// /* Line 350 of lalr1.java */
		// /* Line 14165 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2029:
		// if (yyn == 2029)
		// /* Line 350 of lalr1.java */
		// /* Line 14166 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2030:
		// if (yyn == 2030)
		// /* Line 350 of lalr1.java */
		// /* Line 14167 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2031:
		// if (yyn == 2031)
		// /* Line 350 of lalr1.java */
		// /* Line 14168 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2032:
		// if (yyn == 2032)
		// /* Line 350 of lalr1.java */
		// /* Line 14169 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2033:
		// if (yyn == 2033)
		// /* Line 350 of lalr1.java */
		// /* Line 14170 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2034:
		// if (yyn == 2034)
		// /* Line 350 of lalr1.java */
		// /* Line 14171 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2035:
		// if (yyn == 2035)
		// /* Line 350 of lalr1.java */
		// /* Line 14172 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2036:
		// if (yyn == 2036)
		// /* Line 350 of lalr1.java */
		// /* Line 14173 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2037:
		// if (yyn == 2037)
		// /* Line 350 of lalr1.java */
		// /* Line 14174 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2038:
		// if (yyn == 2038)
		// /* Line 350 of lalr1.java */
		// /* Line 14184 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2039:
		// if (yyn == 2039)
		// /* Line 350 of lalr1.java */
		// /* Line 14185 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2040:
		// if (yyn == 2040)
		// /* Line 350 of lalr1.java */
		// /* Line 14186 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2041:
		// if (yyn == 2041)
		// /* Line 350 of lalr1.java */
		// /* Line 14187 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2042:
		// if (yyn == 2042)
		// /* Line 350 of lalr1.java */
		// /* Line 14188 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2043:
		// if (yyn == 2043)
		// /* Line 350 of lalr1.java */
		// /* Line 14189 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2044:
		// if (yyn == 2044)
		// /* Line 350 of lalr1.java */
		// /* Line 14190 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2045:
		// if (yyn == 2045)
		// /* Line 350 of lalr1.java */
		// /* Line 14191 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2046:
		// if (yyn == 2046)
		// /* Line 350 of lalr1.java */
		// /* Line 14192 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2047:
		// if (yyn == 2047)
		// /* Line 350 of lalr1.java */
		// /* Line 14193 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2048:
		// if (yyn == 2048)
		// /* Line 350 of lalr1.java */
		// /* Line 14194 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2049:
		// if (yyn == 2049)
		// /* Line 350 of lalr1.java */
		// /* Line 14195 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2050:
		// if (yyn == 2050)
		// /* Line 350 of lalr1.java */
		// /* Line 14196 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2051:
		// if (yyn == 2051)
		// /* Line 350 of lalr1.java */
		// /* Line 14197 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2052:
		// if (yyn == 2052)
		// /* Line 350 of lalr1.java */
		// /* Line 14198 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2053:
		// if (yyn == 2053)
		// /* Line 350 of lalr1.java */
		// /* Line 14199 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2054:
		// if (yyn == 2054)
		// /* Line 350 of lalr1.java */
		// /* Line 14200 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2055:
		// if (yyn == 2055)
		// /* Line 350 of lalr1.java */
		// /* Line 14201 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2056:
		// if (yyn == 2056)
		// /* Line 350 of lalr1.java */
		// /* Line 14202 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2057:
		// if (yyn == 2057)
		// /* Line 350 of lalr1.java */
		// /* Line 14203 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2058:
		// if (yyn == 2058)
		// /* Line 350 of lalr1.java */
		// /* Line 14204 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2059:
		// if (yyn == 2059)
		// /* Line 350 of lalr1.java */
		// /* Line 14205 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2060:
		// if (yyn == 2060)
		// /* Line 350 of lalr1.java */
		// /* Line 14206 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2061:
		// if (yyn == 2061)
		// /* Line 350 of lalr1.java */
		// /* Line 14207 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2062:
		// if (yyn == 2062)
		// /* Line 350 of lalr1.java */
		// /* Line 14208 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2063:
		// if (yyn == 2063)
		// /* Line 350 of lalr1.java */
		// /* Line 14209 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2064:
		// if (yyn == 2064)
		// /* Line 350 of lalr1.java */
		// /* Line 14210 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2065:
		// if (yyn == 2065)
		// /* Line 350 of lalr1.java */
		// /* Line 14211 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2066:
		// if (yyn == 2066)
		// /* Line 350 of lalr1.java */
		// /* Line 14212 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2067:
		// if (yyn == 2067)
		// /* Line 350 of lalr1.java */
		// /* Line 14213 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2068:
		// if (yyn == 2068)
		// /* Line 350 of lalr1.java */
		// /* Line 14214 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2069:
		// if (yyn == 2069)
		// /* Line 350 of lalr1.java */
		// /* Line 14215 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2070:
		// if (yyn == 2070)
		// /* Line 350 of lalr1.java */
		// /* Line 14216 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2071:
		// if (yyn == 2071)
		// /* Line 350 of lalr1.java */
		// /* Line 14217 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2072:
		// if (yyn == 2072)
		// /* Line 350 of lalr1.java */
		// /* Line 14218 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2073:
		// if (yyn == 2073)
		// /* Line 350 of lalr1.java */
		// /* Line 14219 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2074:
		// if (yyn == 2074)
		// /* Line 350 of lalr1.java */
		// /* Line 14220 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2075:
		// if (yyn == 2075)
		// /* Line 350 of lalr1.java */
		// /* Line 14221 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2076:
		// if (yyn == 2076)
		// /* Line 350 of lalr1.java */
		// /* Line 14222 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2077:
		// if (yyn == 2077)
		// /* Line 350 of lalr1.java */
		// /* Line 14223 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2078:
		// if (yyn == 2078)
		// /* Line 350 of lalr1.java */
		// /* Line 14224 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2079:
		// if (yyn == 2079)
		// /* Line 350 of lalr1.java */
		// /* Line 14225 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2080:
		// if (yyn == 2080)
		// /* Line 350 of lalr1.java */
		// /* Line 14226 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2081:
		// if (yyn == 2081)
		// /* Line 350 of lalr1.java */
		// /* Line 14227 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2082:
		// if (yyn == 2082)
		// /* Line 350 of lalr1.java */
		// /* Line 14228 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2083:
		// if (yyn == 2083)
		// /* Line 350 of lalr1.java */
		// /* Line 14233 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2084:
		// if (yyn == 2084)
		// /* Line 350 of lalr1.java */
		// /* Line 14234 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2085:
		// if (yyn == 2085)
		// /* Line 350 of lalr1.java */
		// /* Line 14235 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2086:
		// if (yyn == 2086)
		// /* Line 350 of lalr1.java */
		// /* Line 14236 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2087:
		// if (yyn == 2087)
		// /* Line 350 of lalr1.java */
		// /* Line 14237 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2088:
		// if (yyn == 2088)
		// /* Line 350 of lalr1.java */
		// /* Line 14238 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2089:
		// if (yyn == 2089)
		// /* Line 350 of lalr1.java */
		// /* Line 14239 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2090:
		// if (yyn == 2090)
		// /* Line 350 of lalr1.java */
		// /* Line 14240 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2091:
		// if (yyn == 2091)
		// /* Line 350 of lalr1.java */
		// /* Line 14241 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2092:
		// if (yyn == 2092)
		// /* Line 350 of lalr1.java */
		// /* Line 14242 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2093:
		// if (yyn == 2093)
		// /* Line 350 of lalr1.java */
		// /* Line 14243 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2094:
		// if (yyn == 2094)
		// /* Line 350 of lalr1.java */
		// /* Line 14244 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2095:
		// if (yyn == 2095)
		// /* Line 350 of lalr1.java */
		// /* Line 14245 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2096:
		// if (yyn == 2096)
		// /* Line 350 of lalr1.java */
		// /* Line 14246 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2097:
		// if (yyn == 2097)
		// /* Line 350 of lalr1.java */
		// /* Line 14247 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2098:
		// if (yyn == 2098)
		// /* Line 350 of lalr1.java */
		// /* Line 14248 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2099:
		// if (yyn == 2099)
		// /* Line 350 of lalr1.java */
		// /* Line 14249 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2100:
		// if (yyn == 2100)
		// /* Line 350 of lalr1.java */
		// /* Line 14250 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2101:
		// if (yyn == 2101)
		// /* Line 350 of lalr1.java */
		// /* Line 14251 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2102:
		// if (yyn == 2102)
		// /* Line 350 of lalr1.java */
		// /* Line 14252 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2103:
		// if (yyn == 2103)
		// /* Line 350 of lalr1.java */
		// /* Line 14253 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2104:
		// if (yyn == 2104)
		// /* Line 350 of lalr1.java */
		// /* Line 14254 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2105:
		// if (yyn == 2105)
		// /* Line 350 of lalr1.java */
		// /* Line 14255 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2106:
		// if (yyn == 2106)
		// /* Line 350 of lalr1.java */
		// /* Line 14256 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2107:
		// if (yyn == 2107)
		// /* Line 350 of lalr1.java */
		// /* Line 14257 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2108:
		// if (yyn == 2108)
		// /* Line 350 of lalr1.java */
		// /* Line 14258 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2109:
		// if (yyn == 2109)
		// /* Line 350 of lalr1.java */
		// /* Line 14259 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2110:
		// if (yyn == 2110)
		// /* Line 350 of lalr1.java */
		// /* Line 14260 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2111:
		// if (yyn == 2111)
		// /* Line 350 of lalr1.java */
		// /* Line 14261 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2112:
		// if (yyn == 2112)
		// /* Line 350 of lalr1.java */
		// /* Line 14262 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2113:
		// if (yyn == 2113)
		// /* Line 350 of lalr1.java */
		// /* Line 14263 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2114:
		// if (yyn == 2114)
		// /* Line 350 of lalr1.java */
		// /* Line 14264 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2115:
		// if (yyn == 2115)
		// /* Line 350 of lalr1.java */
		// /* Line 14265 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2116:
		// if (yyn == 2116)
		// /* Line 350 of lalr1.java */
		// /* Line 14266 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2117:
		// if (yyn == 2117)
		// /* Line 350 of lalr1.java */
		// /* Line 14267 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2118:
		// if (yyn == 2118)
		// /* Line 350 of lalr1.java */
		// /* Line 14268 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2119:
		// if (yyn == 2119)
		// /* Line 350 of lalr1.java */
		// /* Line 14269 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2120:
		// if (yyn == 2120)
		// /* Line 350 of lalr1.java */
		// /* Line 14270 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2121:
		// if (yyn == 2121)
		// /* Line 350 of lalr1.java */
		// /* Line 14271 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2122:
		// if (yyn == 2122)
		// /* Line 350 of lalr1.java */
		// /* Line 14272 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2123:
		// if (yyn == 2123)
		// /* Line 350 of lalr1.java */
		// /* Line 14273 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2124:
		// if (yyn == 2124)
		// /* Line 350 of lalr1.java */
		// /* Line 14274 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2125:
		// if (yyn == 2125)
		// /* Line 350 of lalr1.java */
		// /* Line 14275 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2126:
		// if (yyn == 2126)
		// /* Line 350 of lalr1.java */
		// /* Line 14276 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2127:
		// if (yyn == 2127)
		// /* Line 350 of lalr1.java */
		// /* Line 14277 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2128:
		// if (yyn == 2128)
		// /* Line 350 of lalr1.java */
		// /* Line 14278 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2129:
		// if (yyn == 2129)
		// /* Line 350 of lalr1.java */
		// /* Line 14279 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2130:
		// if (yyn == 2130)
		// /* Line 350 of lalr1.java */
		// /* Line 14280 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2131:
		// if (yyn == 2131)
		// /* Line 350 of lalr1.java */
		// /* Line 14281 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2132:
		// if (yyn == 2132)
		// /* Line 350 of lalr1.java */
		// /* Line 14282 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2133:
		// if (yyn == 2133)
		// /* Line 350 of lalr1.java */
		// /* Line 14283 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2134:
		// if (yyn == 2134)
		// /* Line 350 of lalr1.java */
		// /* Line 14284 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2135:
		// if (yyn == 2135)
		// /* Line 350 of lalr1.java */
		// /* Line 14285 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2136:
		// if (yyn == 2136)
		// /* Line 350 of lalr1.java */
		// /* Line 14286 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2137:
		// if (yyn == 2137)
		// /* Line 350 of lalr1.java */
		// /* Line 14287 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2138:
		// if (yyn == 2138)
		// /* Line 350 of lalr1.java */
		// /* Line 14288 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2139:
		// if (yyn == 2139)
		// /* Line 350 of lalr1.java */
		// /* Line 14289 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2140:
		// if (yyn == 2140)
		// /* Line 350 of lalr1.java */
		// /* Line 14290 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2141:
		// if (yyn == 2141)
		// /* Line 350 of lalr1.java */
		// /* Line 14291 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2142:
		// if (yyn == 2142)
		// /* Line 350 of lalr1.java */
		// /* Line 14292 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2143:
		// if (yyn == 2143)
		// /* Line 350 of lalr1.java */
		// /* Line 14293 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2144:
		// if (yyn == 2144)
		// /* Line 350 of lalr1.java */
		// /* Line 14294 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2145:
		// if (yyn == 2145)
		// /* Line 350 of lalr1.java */
		// /* Line 14295 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2146:
		// if (yyn == 2146)
		// /* Line 350 of lalr1.java */
		// /* Line 14296 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2147:
		// if (yyn == 2147)
		// /* Line 350 of lalr1.java */
		// /* Line 14297 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2148:
		// if (yyn == 2148)
		// /* Line 350 of lalr1.java */
		// /* Line 14298 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2149:
		// if (yyn == 2149)
		// /* Line 350 of lalr1.java */
		// /* Line 14299 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2150:
		// if (yyn == 2150)
		// /* Line 350 of lalr1.java */
		// /* Line 14300 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2151:
		// if (yyn == 2151)
		// /* Line 350 of lalr1.java */
		// /* Line 14301 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2152:
		// if (yyn == 2152)
		// /* Line 350 of lalr1.java */
		// /* Line 14302 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2153:
		// if (yyn == 2153)
		// /* Line 350 of lalr1.java */
		// /* Line 14303 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2154:
		// if (yyn == 2154)
		// /* Line 350 of lalr1.java */
		// /* Line 14304 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2155:
		// if (yyn == 2155)
		// /* Line 350 of lalr1.java */
		// /* Line 14305 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2156:
		// if (yyn == 2156)
		// /* Line 350 of lalr1.java */
		// /* Line 14306 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2157:
		// if (yyn == 2157)
		// /* Line 350 of lalr1.java */
		// /* Line 14307 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2158:
		// if (yyn == 2158)
		// /* Line 350 of lalr1.java */
		// /* Line 14308 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2159:
		// if (yyn == 2159)
		// /* Line 350 of lalr1.java */
		// /* Line 14309 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2160:
		// if (yyn == 2160)
		// /* Line 350 of lalr1.java */
		// /* Line 14310 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2161:
		// if (yyn == 2161)
		// /* Line 350 of lalr1.java */
		// /* Line 14311 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2162:
		// if (yyn == 2162)
		// /* Line 350 of lalr1.java */
		// /* Line 14312 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2163:
		// if (yyn == 2163)
		// /* Line 350 of lalr1.java */
		// /* Line 14313 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2164:
		// if (yyn == 2164)
		// /* Line 350 of lalr1.java */
		// /* Line 14314 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2165:
		// if (yyn == 2165)
		// /* Line 350 of lalr1.java */
		// /* Line 14315 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2166:
		// if (yyn == 2166)
		// /* Line 350 of lalr1.java */
		// /* Line 14316 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2167:
		// if (yyn == 2167)
		// /* Line 350 of lalr1.java */
		// /* Line 14317 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2168:
		// if (yyn == 2168)
		// /* Line 350 of lalr1.java */
		// /* Line 14318 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2169:
		// if (yyn == 2169)
		// /* Line 350 of lalr1.java */
		// /* Line 14319 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2170:
		// if (yyn == 2170)
		// /* Line 350 of lalr1.java */
		// /* Line 14320 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2171:
		// if (yyn == 2171)
		// /* Line 350 of lalr1.java */
		// /* Line 14321 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2172:
		// if (yyn == 2172)
		// /* Line 350 of lalr1.java */
		// /* Line 14322 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2173:
		// if (yyn == 2173)
		// /* Line 350 of lalr1.java */
		// /* Line 14323 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2174:
		// if (yyn == 2174)
		// /* Line 350 of lalr1.java */
		// /* Line 14324 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2175:
		// if (yyn == 2175)
		// /* Line 350 of lalr1.java */
		// /* Line 14325 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2176:
		// if (yyn == 2176)
		// /* Line 350 of lalr1.java */
		// /* Line 14326 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2177:
		// if (yyn == 2177)
		// /* Line 350 of lalr1.java */
		// /* Line 14327 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2178:
		// if (yyn == 2178)
		// /* Line 350 of lalr1.java */
		// /* Line 14328 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2179:
		// if (yyn == 2179)
		// /* Line 350 of lalr1.java */
		// /* Line 14329 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2180:
		// if (yyn == 2180)
		// /* Line 350 of lalr1.java */
		// /* Line 14330 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2181:
		// if (yyn == 2181)
		// /* Line 350 of lalr1.java */
		// /* Line 14331 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2182:
		// if (yyn == 2182)
		// /* Line 350 of lalr1.java */
		// /* Line 14332 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2183:
		// if (yyn == 2183)
		// /* Line 350 of lalr1.java */
		// /* Line 14333 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2184:
		// if (yyn == 2184)
		// /* Line 350 of lalr1.java */
		// /* Line 14334 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2185:
		// if (yyn == 2185)
		// /* Line 350 of lalr1.java */
		// /* Line 14335 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2186:
		// if (yyn == 2186)
		// /* Line 350 of lalr1.java */
		// /* Line 14336 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2187:
		// if (yyn == 2187)
		// /* Line 350 of lalr1.java */
		// /* Line 14337 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2188:
		// if (yyn == 2188)
		// /* Line 350 of lalr1.java */
		// /* Line 14338 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2189:
		// if (yyn == 2189)
		// /* Line 350 of lalr1.java */
		// /* Line 14339 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2190:
		// if (yyn == 2190)
		// /* Line 350 of lalr1.java */
		// /* Line 14340 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2191:
		// if (yyn == 2191)
		// /* Line 350 of lalr1.java */
		// /* Line 14341 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2192:
		// if (yyn == 2192)
		// /* Line 350 of lalr1.java */
		// /* Line 14342 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2193:
		// if (yyn == 2193)
		// /* Line 350 of lalr1.java */
		// /* Line 14343 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2194:
		// if (yyn == 2194)
		// /* Line 350 of lalr1.java */
		// /* Line 14344 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2195:
		// if (yyn == 2195)
		// /* Line 350 of lalr1.java */
		// /* Line 14345 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2196:
		// if (yyn == 2196)
		// /* Line 350 of lalr1.java */
		// /* Line 14346 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2197:
		// if (yyn == 2197)
		// /* Line 350 of lalr1.java */
		// /* Line 14347 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2198:
		// if (yyn == 2198)
		// /* Line 350 of lalr1.java */
		// /* Line 14348 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2199:
		// if (yyn == 2199)
		// /* Line 350 of lalr1.java */
		// /* Line 14349 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2200:
		// if (yyn == 2200)
		// /* Line 350 of lalr1.java */
		// /* Line 14350 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2201:
		// if (yyn == 2201)
		// /* Line 350 of lalr1.java */
		// /* Line 14351 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2202:
		// if (yyn == 2202)
		// /* Line 350 of lalr1.java */
		// /* Line 14352 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2203:
		// if (yyn == 2203)
		// /* Line 350 of lalr1.java */
		// /* Line 14353 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2204:
		// if (yyn == 2204)
		// /* Line 350 of lalr1.java */
		// /* Line 14354 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2205:
		// if (yyn == 2205)
		// /* Line 350 of lalr1.java */
		// /* Line 14355 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2206:
		// if (yyn == 2206)
		// /* Line 350 of lalr1.java */
		// /* Line 14356 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2207:
		// if (yyn == 2207)
		// /* Line 350 of lalr1.java */
		// /* Line 14357 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2208:
		// if (yyn == 2208)
		// /* Line 350 of lalr1.java */
		// /* Line 14358 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2209:
		// if (yyn == 2209)
		// /* Line 350 of lalr1.java */
		// /* Line 14359 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2210:
		// if (yyn == 2210)
		// /* Line 350 of lalr1.java */
		// /* Line 14360 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2211:
		// if (yyn == 2211)
		// /* Line 350 of lalr1.java */
		// /* Line 14361 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2212:
		// if (yyn == 2212)
		// /* Line 350 of lalr1.java */
		// /* Line 14362 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2213:
		// if (yyn == 2213)
		// /* Line 350 of lalr1.java */
		// /* Line 14363 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2214:
		// if (yyn == 2214)
		// /* Line 350 of lalr1.java */
		// /* Line 14364 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2215:
		// if (yyn == 2215)
		// /* Line 350 of lalr1.java */
		// /* Line 14365 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2216:
		// if (yyn == 2216)
		// /* Line 350 of lalr1.java */
		// /* Line 14366 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2217:
		// if (yyn == 2217)
		// /* Line 350 of lalr1.java */
		// /* Line 14367 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2218:
		// if (yyn == 2218)
		// /* Line 350 of lalr1.java */
		// /* Line 14368 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2219:
		// if (yyn == 2219)
		// /* Line 350 of lalr1.java */
		// /* Line 14369 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2220:
		// if (yyn == 2220)
		// /* Line 350 of lalr1.java */
		// /* Line 14370 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2221:
		// if (yyn == 2221)
		// /* Line 350 of lalr1.java */
		// /* Line 14371 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2222:
		// if (yyn == 2222)
		// /* Line 350 of lalr1.java */
		// /* Line 14372 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2223:
		// if (yyn == 2223)
		// /* Line 350 of lalr1.java */
		// /* Line 14373 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2224:
		// if (yyn == 2224)
		// /* Line 350 of lalr1.java */
		// /* Line 14374 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2225:
		// if (yyn == 2225)
		// /* Line 350 of lalr1.java */
		// /* Line 14375 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2226:
		// if (yyn == 2226)
		// /* Line 350 of lalr1.java */
		// /* Line 14376 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2227:
		// if (yyn == 2227)
		// /* Line 350 of lalr1.java */
		// /* Line 14377 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2228:
		// if (yyn == 2228)
		// /* Line 350 of lalr1.java */
		// /* Line 14378 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2229:
		// if (yyn == 2229)
		// /* Line 350 of lalr1.java */
		// /* Line 14379 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2230:
		// if (yyn == 2230)
		// /* Line 350 of lalr1.java */
		// /* Line 14380 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2231:
		// if (yyn == 2231)
		// /* Line 350 of lalr1.java */
		// /* Line 14381 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2232:
		// if (yyn == 2232)
		// /* Line 350 of lalr1.java */
		// /* Line 14382 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2233:
		// if (yyn == 2233)
		// /* Line 350 of lalr1.java */
		// /* Line 14383 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2234:
		// if (yyn == 2234)
		// /* Line 350 of lalr1.java */
		// /* Line 14384 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2235:
		// if (yyn == 2235)
		// /* Line 350 of lalr1.java */
		// /* Line 14385 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2236:
		// if (yyn == 2236)
		// /* Line 350 of lalr1.java */
		// /* Line 14386 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2237:
		// if (yyn == 2237)
		// /* Line 350 of lalr1.java */
		// /* Line 14387 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2238:
		// if (yyn == 2238)
		// /* Line 350 of lalr1.java */
		// /* Line 14388 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2239:
		// if (yyn == 2239)
		// /* Line 350 of lalr1.java */
		// /* Line 14389 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2240:
		// if (yyn == 2240)
		// /* Line 350 of lalr1.java */
		// /* Line 14390 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2241:
		// if (yyn == 2241)
		// /* Line 350 of lalr1.java */
		// /* Line 14391 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2242:
		// if (yyn == 2242)
		// /* Line 350 of lalr1.java */
		// /* Line 14392 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2243:
		// if (yyn == 2243)
		// /* Line 350 of lalr1.java */
		// /* Line 14393 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2244:
		// if (yyn == 2244)
		// /* Line 350 of lalr1.java */
		// /* Line 14394 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2245:
		// if (yyn == 2245)
		// /* Line 350 of lalr1.java */
		// /* Line 14395 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2246:
		// if (yyn == 2246)
		// /* Line 350 of lalr1.java */
		// /* Line 14396 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2247:
		// if (yyn == 2247)
		// /* Line 350 of lalr1.java */
		// /* Line 14397 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2248:
		// if (yyn == 2248)
		// /* Line 350 of lalr1.java */
		// /* Line 14398 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2249:
		// if (yyn == 2249)
		// /* Line 350 of lalr1.java */
		// /* Line 14399 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2250:
		// if (yyn == 2250)
		// /* Line 350 of lalr1.java */
		// /* Line 14400 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2251:
		// if (yyn == 2251)
		// /* Line 350 of lalr1.java */
		// /* Line 14401 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2252:
		// if (yyn == 2252)
		// /* Line 350 of lalr1.java */
		// /* Line 14402 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2253:
		// if (yyn == 2253)
		// /* Line 350 of lalr1.java */
		// /* Line 14403 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2254:
		// if (yyn == 2254)
		// /* Line 350 of lalr1.java */
		// /* Line 14404 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2255:
		// if (yyn == 2255)
		// /* Line 350 of lalr1.java */
		// /* Line 14405 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2256:
		// if (yyn == 2256)
		// /* Line 350 of lalr1.java */
		// /* Line 14406 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2257:
		// if (yyn == 2257)
		// /* Line 350 of lalr1.java */
		// /* Line 14407 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2258:
		// if (yyn == 2258)
		// /* Line 350 of lalr1.java */
		// /* Line 14408 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2259:
		// if (yyn == 2259)
		// /* Line 350 of lalr1.java */
		// /* Line 14409 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2260:
		// if (yyn == 2260)
		// /* Line 350 of lalr1.java */
		// /* Line 14410 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2261:
		// if (yyn == 2261)
		// /* Line 350 of lalr1.java */
		// /* Line 14411 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2262:
		// if (yyn == 2262)
		// /* Line 350 of lalr1.java */
		// /* Line 14412 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2263:
		// if (yyn == 2263)
		// /* Line 350 of lalr1.java */
		// /* Line 14413 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2264:
		// if (yyn == 2264)
		// /* Line 350 of lalr1.java */
		// /* Line 14414 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2265:
		// if (yyn == 2265)
		// /* Line 350 of lalr1.java */
		// /* Line 14415 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2266:
		// if (yyn == 2266)
		// /* Line 350 of lalr1.java */
		// /* Line 14416 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2267:
		// if (yyn == 2267)
		// /* Line 350 of lalr1.java */
		// /* Line 14417 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2268:
		// if (yyn == 2268)
		// /* Line 350 of lalr1.java */
		// /* Line 14418 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2269:
		// if (yyn == 2269)
		// /* Line 350 of lalr1.java */
		// /* Line 14419 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2270:
		// if (yyn == 2270)
		// /* Line 350 of lalr1.java */
		// /* Line 14420 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2271:
		// if (yyn == 2271)
		// /* Line 350 of lalr1.java */
		// /* Line 14421 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2272:
		// if (yyn == 2272)
		// /* Line 350 of lalr1.java */
		// /* Line 14422 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2273:
		// if (yyn == 2273)
		// /* Line 350 of lalr1.java */
		// /* Line 14423 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2274:
		// if (yyn == 2274)
		// /* Line 350 of lalr1.java */
		// /* Line 14424 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2275:
		// if (yyn == 2275)
		// /* Line 350 of lalr1.java */
		// /* Line 14425 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2276:
		// if (yyn == 2276)
		// /* Line 350 of lalr1.java */
		// /* Line 14426 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2277:
		// if (yyn == 2277)
		// /* Line 350 of lalr1.java */
		// /* Line 14427 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2278:
		// if (yyn == 2278)
		// /* Line 350 of lalr1.java */
		// /* Line 14428 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2279:
		// if (yyn == 2279)
		// /* Line 350 of lalr1.java */
		// /* Line 14429 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2280:
		// if (yyn == 2280)
		// /* Line 350 of lalr1.java */
		// /* Line 14430 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2281:
		// if (yyn == 2281)
		// /* Line 350 of lalr1.java */
		// /* Line 14431 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2282:
		// if (yyn == 2282)
		// /* Line 350 of lalr1.java */
		// /* Line 14432 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2283:
		// if (yyn == 2283)
		// /* Line 350 of lalr1.java */
		// /* Line 14433 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2284:
		// if (yyn == 2284)
		// /* Line 350 of lalr1.java */
		// /* Line 14434 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2285:
		// if (yyn == 2285)
		// /* Line 350 of lalr1.java */
		// /* Line 14435 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2286:
		// if (yyn == 2286)
		// /* Line 350 of lalr1.java */
		// /* Line 14436 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2287:
		// if (yyn == 2287)
		// /* Line 350 of lalr1.java */
		// /* Line 14437 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2288:
		// if (yyn == 2288)
		// /* Line 350 of lalr1.java */
		// /* Line 14438 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2289:
		// if (yyn == 2289)
		// /* Line 350 of lalr1.java */
		// /* Line 14439 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2290:
		// if (yyn == 2290)
		// /* Line 350 of lalr1.java */
		// /* Line 14440 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2291:
		// if (yyn == 2291)
		// /* Line 350 of lalr1.java */
		// /* Line 14441 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2292:
		// if (yyn == 2292)
		// /* Line 350 of lalr1.java */
		// /* Line 14442 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2293:
		// if (yyn == 2293)
		// /* Line 350 of lalr1.java */
		// /* Line 14443 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2294:
		// if (yyn == 2294)
		// /* Line 350 of lalr1.java */
		// /* Line 14444 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2295:
		// if (yyn == 2295)
		// /* Line 350 of lalr1.java */
		// /* Line 14445 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2296:
		// if (yyn == 2296)
		// /* Line 350 of lalr1.java */
		// /* Line 14446 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2297:
		// if (yyn == 2297)
		// /* Line 350 of lalr1.java */
		// /* Line 14447 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2298:
		// if (yyn == 2298)
		// /* Line 350 of lalr1.java */
		// /* Line 14448 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2299:
		// if (yyn == 2299)
		// /* Line 350 of lalr1.java */
		// /* Line 14449 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2300:
		// if (yyn == 2300)
		// /* Line 350 of lalr1.java */
		// /* Line 14450 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2301:
		// if (yyn == 2301)
		// /* Line 350 of lalr1.java */
		// /* Line 14451 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2302:
		// if (yyn == 2302)
		// /* Line 350 of lalr1.java */
		// /* Line 14452 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2303:
		// if (yyn == 2303)
		// /* Line 350 of lalr1.java */
		// /* Line 14453 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2304:
		// if (yyn == 2304)
		// /* Line 350 of lalr1.java */
		// /* Line 14454 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2305:
		// if (yyn == 2305)
		// /* Line 350 of lalr1.java */
		// /* Line 14455 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2306:
		// if (yyn == 2306)
		// /* Line 350 of lalr1.java */
		// /* Line 14456 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2307:
		// if (yyn == 2307)
		// /* Line 350 of lalr1.java */
		// /* Line 14457 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2308:
		// if (yyn == 2308)
		// /* Line 350 of lalr1.java */
		// /* Line 14458 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2309:
		// if (yyn == 2309)
		// /* Line 350 of lalr1.java */
		// /* Line 14459 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2310:
		// if (yyn == 2310)
		// /* Line 350 of lalr1.java */
		// /* Line 14460 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2311:
		// if (yyn == 2311)
		// /* Line 350 of lalr1.java */
		// /* Line 14461 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2312:
		// if (yyn == 2312)
		// /* Line 350 of lalr1.java */
		// /* Line 14462 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2313:
		// if (yyn == 2313)
		// /* Line 350 of lalr1.java */
		// /* Line 14463 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2314:
		// if (yyn == 2314)
		// /* Line 350 of lalr1.java */
		// /* Line 14464 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2315:
		// if (yyn == 2315)
		// /* Line 350 of lalr1.java */
		// /* Line 14465 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2316:
		// if (yyn == 2316)
		// /* Line 350 of lalr1.java */
		// /* Line 14466 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2317:
		// if (yyn == 2317)
		// /* Line 350 of lalr1.java */
		// /* Line 14467 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2318:
		// if (yyn == 2318)
		// /* Line 350 of lalr1.java */
		// /* Line 14468 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2319:
		// if (yyn == 2319)
		// /* Line 350 of lalr1.java */
		// /* Line 14469 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2320:
		// if (yyn == 2320)
		// /* Line 350 of lalr1.java */
		// /* Line 14470 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2321:
		// if (yyn == 2321)
		// /* Line 350 of lalr1.java */
		// /* Line 14471 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2322:
		// if (yyn == 2322)
		// /* Line 350 of lalr1.java */
		// /* Line 14472 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2323:
		// if (yyn == 2323)
		// /* Line 350 of lalr1.java */
		// /* Line 14473 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2324:
		// if (yyn == 2324)
		// /* Line 350 of lalr1.java */
		// /* Line 14474 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2325:
		// if (yyn == 2325)
		// /* Line 350 of lalr1.java */
		// /* Line 14475 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2326:
		// if (yyn == 2326)
		// /* Line 350 of lalr1.java */
		// /* Line 14476 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2327:
		// if (yyn == 2327)
		// /* Line 350 of lalr1.java */
		// /* Line 14477 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2328:
		// if (yyn == 2328)
		// /* Line 350 of lalr1.java */
		// /* Line 14478 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2329:
		// if (yyn == 2329)
		// /* Line 350 of lalr1.java */
		// /* Line 14479 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2330:
		// if (yyn == 2330)
		// /* Line 350 of lalr1.java */
		// /* Line 14480 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2331:
		// if (yyn == 2331)
		// /* Line 350 of lalr1.java */
		// /* Line 14481 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2332:
		// if (yyn == 2332)
		// /* Line 350 of lalr1.java */
		// /* Line 14482 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2333:
		// if (yyn == 2333)
		// /* Line 350 of lalr1.java */
		// /* Line 14483 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2334:
		// if (yyn == 2334)
		// /* Line 350 of lalr1.java */
		// /* Line 14484 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2335:
		// if (yyn == 2335)
		// /* Line 350 of lalr1.java */
		// /* Line 14485 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2336:
		// if (yyn == 2336)
		// /* Line 350 of lalr1.java */
		// /* Line 14486 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2337:
		// if (yyn == 2337)
		// /* Line 350 of lalr1.java */
		// /* Line 14487 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2338:
		// if (yyn == 2338)
		// /* Line 350 of lalr1.java */
		// /* Line 14488 of "sql_yacc.y" */
		// {};
		// break;

		case 2339:
			if (yyn == 2339)
			/* Line 350 of lalr1.java */
			/* Line 14500 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				MyParserProcessor.mysqlInitSelect(thd.lex);
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SET_OPTION;
				// lex->option_type= OPT_SESSION;
				// lex->var_list.empty();
				// lex->one_shot_set= 0;
				// lex->autocommit= 0;
				//
				// sp_create_assignment_lex(YYTHD, YY_TOKEN_END);
			}
			;
			break;
		//
		//
		// case 2340:
		// if (yyn == 2340)
		// /* Line 350 of lalr1.java */
		// /* Line 14512 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2341:
		// if (yyn == 2341)
		// /* Line 350 of lalr1.java */
		// /* Line 14519 of "sql_yacc.y" */
		// {
		// if (sp_create_assignment_instr(YYTHD, YY_TOKEN_END))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2343:
		// if (yyn == 2343)
		// /* Line 350 of lalr1.java */
		// /* Line 14525 of "sql_yacc.y" */
		// {
		// Lex->option_type= OPT_DEFAULT;
		// };
		// break;
		//
		//
		// case 2344:
		// if (yyn == 2344)
		// /* Line 350 of lalr1.java */
		// /* Line 14529 of "sql_yacc.y" */
		// {
		// if (sp_create_assignment_instr(YYTHD, YY_TOKEN_END))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2345:
		// if (yyn == 2345)
		// /* Line 350 of lalr1.java */
		// /* Line 14534 of "sql_yacc.y" */
		// {
		// Lex->option_type= ((var_type)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 2347:
		// if (yyn == 2347)
		// /* Line 350 of lalr1.java */
		// /* Line 14544 of "sql_yacc.y" */
		// {
		// if (sp_create_assignment_instr(YYTHD, YY_TOKEN_END))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2349:
		// if (yyn == 2349)
		// /* Line 350 of lalr1.java */
		// /* Line 14550 of "sql_yacc.y" */
		// {
		// if (sp_create_assignment_instr(YYTHD, YY_TOKEN_END))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2352:
		// if (yyn == 2352)
		// /* Line 350 of lalr1.java */
		// /* Line 14564 of "sql_yacc.y" */
		// {
		// sp_create_assignment_lex(YYTHD, YY_TOKEN_START);
		// };
		// break;
		//
		//
		// case 2353:
		// if (yyn == 2353)
		// /* Line 350 of lalr1.java */
		// /* Line 14568 of "sql_yacc.y" */
		// {
		// if (sp_create_assignment_instr(YYTHD, YY_TOKEN_END))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2354:
		// if (yyn == 2354)
		// /* Line 350 of lalr1.java */
		// /* Line 14573 of "sql_yacc.y" */
		// {
		// sp_create_assignment_lex(YYTHD, YY_TOKEN_START);
		// };
		// break;
		//
		//
		// case 2355:
		// if (yyn == 2355)
		// /* Line 350 of lalr1.java */
		// /* Line 14577 of "sql_yacc.y" */
		// {
		// if (sp_create_assignment_instr(YYTHD, YY_TOKEN_END))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2356:
		// if (yyn == 2356)
		// /* Line 350 of lalr1.java */
		// /* Line 14586 of "sql_yacc.y" */
		// {
		// Lex->option_type= ((var_type)(yystack.valueAt (1-(1))));
		// };
		// break;
		//
		//
		// case 2359:
		// if (yyn == 2359)
		// /* Line 350 of lalr1.java */
		// /* Line 14594 of "sql_yacc.y" */
		// { yyval=OPT_GLOBAL; };
		// break;
		//
		//
		// case 2360:
		// if (yyn == 2360)
		// /* Line 350 of lalr1.java */
		// /* Line 14595 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		// case 2361:
		// if (yyn == 2361)
		// /* Line 350 of lalr1.java */
		// /* Line 14596 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		// case 2362:
		// if (yyn == 2362)
		// /* Line 350 of lalr1.java */
		// /* Line 14600 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		// case 2363:
		// if (yyn == 2363)
		// /* Line 350 of lalr1.java */
		// /* Line 14601 of "sql_yacc.y" */
		// { yyval=OPT_GLOBAL; };
		// break;
		//
		//
		// case 2364:
		// if (yyn == 2364)
		// /* Line 350 of lalr1.java */
		// /* Line 14602 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		// case 2365:
		// if (yyn == 2365)
		// /* Line 350 of lalr1.java */
		// /* Line 14603 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		// case 2366:
		// if (yyn == 2366)
		// /* Line 350 of lalr1.java */
		// /* Line 14607 of "sql_yacc.y" */
		// { yyval=OPT_DEFAULT; };
		// break;
		//
		//
		// case 2367:
		// if (yyn == 2367)
		// /* Line 350 of lalr1.java */
		// /* Line 14608 of "sql_yacc.y" */
		// { yyval=OPT_GLOBAL; };
		// break;
		//
		//
		// case 2368:
		// if (yyn == 2368)
		// /* Line 350 of lalr1.java */
		// /* Line 14609 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		// case 2369:
		// if (yyn == 2369)
		// /* Line 350 of lalr1.java */
		// /* Line 14610 of "sql_yacc.y" */
		// { yyval=OPT_SESSION; };
		// break;
		//
		//
		case 2370:
			if (yyn == 2370)
			/* Line 350 of lalr1.java */
			/* Line 14616 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= Lex;
				//
				// if (((variable)(yystack.valueAt (3-(1)))).var &&
				// ((variable)(yystack.valueAt (3-(1)))).var !=
				// trg_new_row_fake_var)
				// {
				// /* It is a system variable. */
				// if (set_system_variable(thd, &((variable)(yystack.valueAt
				// (3-(1)))),
				// lex->option_type, ((item)(yystack.valueAt (3-(3))))))
				// return YYABORT;
				// }
				// else
				// {
				// /*
				// Not in trigger assigning value to new row,
				// and option_type preceeding local variable is illegal.
				// */
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		// case 2371:
		// if (yyn == 2371)
		// /* Line 350 of lalr1.java */
		// /* Line 14641 of "sql_yacc.y" */
		// {
		// sp_head *sp= Lex->sphead;
		//
		// if (sp)
		// sp->m_parser_data.push_expr_start_ptr(YY_TOKEN_START);
		// };
		// break;
		//
		//
		case 2372:
			if (yyn == 2372)
			/* Line 350 of lalr1.java */
			/* Line 14648 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= Lex;
				// sp_head *sp= lex->sphead;
				// const char *expr_start_ptr= NULL;
				//
				// if (sp)
				// expr_start_ptr= sp->m_parser_data.pop_expr_start_ptr();
				//
				// if (((variable)(yystack.valueAt (4-(1)))).var ==
				// trg_new_row_fake_var)
				// {
				// DBUG_ASSERT(sp);
				// DBUG_ASSERT(expr_start_ptr);
				//
				// /* We are parsing trigger and this is a trigger NEW-field. */
				//
				// LEX_STRING expr_query= EMPTY_STR;
				//
				// if (!((item)(yystack.valueAt (4-(4)))))
				// {
				// // This is: SET NEW.x = DEFAULT
				// // DEFAULT clause is not supported in triggers.
				//
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// else if (lex->is_metadata_used())
				// {
				// expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
				//
				// if (!expr_query.str)
				// return YYABORT;
				// }
				//
				// if (set_trigger_new_row(thd, ((variable)(yystack.valueAt
				// (4-(1)))).base_name, ((item)(yystack.valueAt (4-(4)))),
				// expr_query))
				// return YYABORT;
				// }
				// else if (((variable)(yystack.valueAt (4-(1)))).var)
				// {
				// /* We're not parsing SP and this is a system variable. */
				//
				// if (set_system_variable(thd, &((variable)(yystack.valueAt
				// (4-(1)))),
				// lex->option_type, ((item)(yystack.valueAt (4-(4))))))
				// return YYABORT;
				// }
				// else
				// {
				// DBUG_ASSERT(sp);
				// DBUG_ASSERT(expr_start_ptr);
				//
				// /* We're parsing SP and this is an SP-variable. */
				//
				// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
				// sp_variable *spv=
				// pctx->find_variable(((variable)(yystack.valueAt
				// (4-(1)))).base_name, false);
				//
				// LEX_STRING expr_query= EMPTY_STR;
				//
				// if (!((item)(yystack.valueAt (4-(4)))))
				// {
				// // This is: SET x = DEFAULT, where x is a SP-variable.
				// // This is not supported.
				//
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// else if (lex->is_metadata_used())
				// {
				// expr_query= make_string(thd, expr_start_ptr, YY_TOKEN_END);
				//
				// if (!expr_query.str)
				// return YYABORT;
				// }
				//
				// /*
				// NOTE: every SET-expression has its own LEX-object, even if it
				// is
				// a multiple SET-statement, like:
				//
				// SET spv1 = expr1, spv2 = expr2, ...
				//
				// Every SET-expression has its own sp_instr_set. Thus, the
				// instruction owns the LEX-object, i.e. the instruction is
				// responsible for destruction of the LEX-object.
				// */
				//
				// sp_instr_set *i=
				// new sp_instr_set(sp->instructions(), lex,
				// spv->offset, ((item)(yystack.valueAt (4-(4)))), expr_query,
				// true); // The instruction owns its lex.
				//
				// if (!i || sp->add_instr(thd, i))
				// return YYABORT;
				// }
			}
			;
			break;
		//
		//
		// case 2373:
		// if (yyn == 2373)
		// /* Line 350 of lalr1.java */
		// /* Line 14741 of "sql_yacc.y" */
		// {
		// Item_func_set_user_var *item;
		// item= new (YYTHD->mem_root)
		// Item_func_set_user_var(((lex_str)(yystack.valueAt (4-(2)))),
		// ((item)(yystack.valueAt (4-(4)))), false);
		// if (item == NULL)
		// return YYABORT;
		// set_var_user *var= new set_var_user(item);
		// if (var == NULL)
		// return YYABORT;
		// Lex->var_list.push_back(var);
		// };
		// break;
		//
		//
		// case 2374:
		// if (yyn == 2374)
		// /* Line 350 of lalr1.java */
		// /* Line 14752 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// struct sys_var_with_base tmp= ((variable)(yystack.valueAt (6-(4))));
		// /* Lookup if necessary: must be a system variable. */
		// if (tmp.var == NULL)
		// {
		// if (find_sys_var_null_base(thd, &tmp))
		// return YYABORT;
		// }
		// if (set_system_variable(thd, &tmp, ((var_type)(yystack.valueAt
		// (6-(3)))), ((item)(yystack.valueAt (6-(6))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2375:
		// if (yyn == 2375)
		// /* Line 350 of lalr1.java */
		// /* Line 14765 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// int flags= ((charset)(yystack.valueAt (2-(2)))) ? 0 :
		// set_var_collation_client::SET_CS_DEFAULT;
		// const CHARSET_INFO *cs2;
		// cs2= ((charset)(yystack.valueAt (2-(2)))) ?
		// ((charset)(yystack.valueAt (2-(2)))):
		// global_system_variables.character_set_client;
		// set_var_collation_client *var;
		// var= new set_var_collation_client(flags,
		// cs2,
		// thd->variables.collation_database,
		// cs2);
		// if (var == NULL)
		// return YYABORT;
		// lex->var_list.push_back(var);
		// };
		// break;
		//
		//
		case 2376:
			if (yyn == 2376)
			/* Line 350 of lalr1.java */
			/* Line 14781 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
				// LEX_STRING names= { C_STRING_WITH_LEN("names") };
				//
				// if (pctx && pctx->find_variable(names, false))
				// my_error(ER_SP_BAD_VAR_SHADOW, MYF(0), names.str);
				// else
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				//
				// return YYABORT;
			}
			;
			break;
		//
		//
		// case 2377:
		// if (yyn == 2377)
		// /* Line 350 of lalr1.java */
		// /* Line 14794 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// const CHARSET_INFO *cs2;
		// const CHARSET_INFO *cs3;
		// int flags= set_var_collation_client::SET_CS_NAMES
		// | (((charset)(yystack.valueAt (3-(2)))) ? 0 :
		// set_var_collation_client::SET_CS_DEFAULT)
		// | (((charset)(yystack.valueAt (3-(3)))) ?
		// set_var_collation_client::SET_CS_COLLATE : 0);
		// cs2= ((charset)(yystack.valueAt (3-(2)))) ?
		// ((charset)(yystack.valueAt (3-(2)))) :
		// global_system_variables.character_set_client;
		// cs3= ((charset)(yystack.valueAt (3-(3)))) ?
		// ((charset)(yystack.valueAt (3-(3)))) : cs2;
		// if (!my_charset_same(cs2, cs3))
		// {
		// my_error(ER_COLLATION_CHARSET_MISMATCH, MYF(0),
		// cs3->name, cs2->csname);
		// return YYABORT;
		// }
		// set_var_collation_client *var;
		// var= new set_var_collation_client(flags, cs3, cs3, cs3);
		// if (var == NULL)
		// return YYABORT;
		// lex->var_list.push_back(var);
		// };
		// break;
		//
		//
		// case 2378:
		// if (yyn == 2378)
		// /* Line 350 of lalr1.java */
		// /* Line 14816 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_head *sp= lex->sphead;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// LEX_STRING pw= { C_STRING_WITH_LEN("password") };
		//
		// if (pctx && pctx->find_variable(pw, false))
		// {
		// my_error(ER_SP_BAD_VAR_SHADOW, MYF(0), pw.str);
		// return YYABORT;
		// }
		//
		// LEX_USER *user= (LEX_USER*) thd->alloc(sizeof(LEX_USER));
		//
		// if (!user)
		// return YYABORT;
		//
		// user->host=null_lex_str;
		// user->user.str=thd->security_ctx->user;
		// user->user.length= strlen(thd->security_ctx->user);
		//
		// set_var_password *var= new set_var_password(user,
		// ((simple_string)(yystack.valueAt (3-(3)))));
		// if (var == NULL)
		// return YYABORT;
		//
		// lex->var_list.push_back(var);
		// lex->autocommit= TRUE;
		// lex->is_set_password_sql= true;
		// lex->is_change_password= TRUE;
		//
		// if (sp)
		// sp->m_flags|= sp_head::HAS_SET_AUTOCOMMIT_STMT;
		// };
		// break;
		//
		//
		// case 2379:
		// if (yyn == 2379)
		// /* Line 350 of lalr1.java */
		// /* Line 14851 of "sql_yacc.y" */
		// {
		// LEX_USER *user= ((lex_user)(yystack.valueAt (5-(3))));
		// LEX *lex= Lex;
		// set_var_password *var;
		//
		// var= new set_var_password(user,((simple_string)(yystack.valueAt
		// (5-(5)))));
		// if (var == NULL)
		// return YYABORT;
		// lex->var_list.push_back(var);
		// lex->autocommit= TRUE;
		// lex->is_set_password_sql= true;
		// if (lex->sphead)
		// lex->sphead->m_flags|= sp_head::HAS_SET_AUTOCOMMIT_STMT;
		// /*
		// 'is_change_password' should be set if the user is setting his
		// own password. This is later used to determine if the password
		// expiration flag should be reset.
		// Either the user exactly matches the currently authroized user or
		// the CURRENT_USER keyword was used.
		//
		// If CURRENT_USER was used for the <user> rule then
		// user->user.str=0. See rule below:
		//
		// user:
		// [..]
		// | CURRENT_USER optional_braces
		// {
		// [..]
		// memset($$, 0, sizeof(LEX_USER));
		// }
		// */
		// if (user->user.str ||
		// match_authorized_user(&current_thd->main_security_ctx,
		// user))
		// lex->is_change_password= TRUE;
		// else
		// lex->is_change_password= FALSE;
		// };
		// break;
		//
		//
		// case 2380:
		// if (yyn == 2380)
		// /* Line 350 of lalr1.java */
		// /* Line 14893 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// sp_pcontext *pctx= lex->get_sp_current_parsing_ctx();
		// sp_variable *spv;
		//
		// /* Best effort lookup for system variable. */
		// if (!pctx || !(spv= pctx->find_variable(((lex_str)(yystack.valueAt
		// (1-(1)))), false)))
		// {
		// struct sys_var_with_base tmp= {NULL, ((lex_str)(yystack.valueAt
		// (1-(1))))};
		//
		// /* Not an SP local variable */
		// if (find_sys_var_null_base(thd, &tmp))
		// return YYABORT;
		//
		// yyval= tmp;
		// }
		// else
		// {
		// /*
		// Possibly an SP local variable (or a shadowed sysvar).
		// Will depend on the context of the SET statement.
		// */
		// yyval.var= NULL;
		// yyval.base_name= ((lex_str)(yystack.valueAt (1-(1))));
		// }
		// };
		// break;
		//
		//
		case 2381:
			if (yyn == 2381)
			/* Line 350 of lalr1.java */
			/* Line 14921 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// sp_head *sp= lex->sphead;
				//
				// if (check_reserved_words(&((lex_str)(yystack.valueAt
				// (3-(1))))))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				//
				// if (sp && sp->m_type == SP_TYPE_TRIGGER &&
				// (!my_strcasecmp(system_charset_info,
				// ((lex_str)(yystack.valueAt
				// (3-(1)))).str, "NEW") ||
				// !my_strcasecmp(system_charset_info,
				// ((lex_str)(yystack.valueAt
				// (3-(1)))).str, "OLD")))
				// {
				// if (((lex_str)(yystack.valueAt (3-(1)))).str[0]=='O' ||
				// ((lex_str)(yystack.valueAt (3-(1)))).str[0]=='o')
				// {
				// my_error(ER_TRG_CANT_CHANGE_ROW, MYF(0), "OLD", "");
				// return YYABORT;
				// }
				// if (sp->m_trg_chistics.event == TRG_EVENT_DELETE)
				// {
				// my_error(ER_TRG_NO_SUCH_ROW_IN_TRG, MYF(0),
				// "NEW", "on DELETE");
				// return YYABORT;
				// }
				// if (sp->m_trg_chistics.action_time == TRG_ACTION_AFTER)
				// {
				// my_error(ER_TRG_CANT_CHANGE_ROW, MYF(0), "NEW", "after ");
				// return YYABORT;
				// }
				// /* This special combination will denote field of NEW row */
				// yyval.var= trg_new_row_fake_var;
				// yyval.base_name= ((lex_str)(yystack.valueAt (3-(3))));
				// }
				// else
				// {
				// sys_var *tmp=find_sys_var(YYTHD, ((lex_str)(yystack.valueAt
				// (3-(3)))).str, ((lex_str)(yystack.valueAt (3-(3)))).length);
				// if (!tmp)
				// return YYABORT;
				// if (!tmp->is_struct())
				// my_error(ER_VARIABLE_IS_NOT_STRUCT, MYF(0),
				// ((lex_str)(yystack.valueAt (3-(3)))).str);
				// yyval.var= tmp;
				// yyval.base_name= ((lex_str)(yystack.valueAt (3-(1))));
				// }
			}
			;
			break;
		//
		//
		// case 2382:
		// if (yyn == 2382)
		// /* Line 350 of lalr1.java */
		// /* Line 14967 of "sql_yacc.y" */
		// {
		// sys_var *tmp=find_sys_var(YYTHD, ((lex_str)(yystack.valueAt
		// (3-(3)))).str, ((lex_str)(yystack.valueAt (3-(3)))).length);
		// if (!tmp)
		// return YYABORT;
		// if (!tmp->is_struct())
		// my_error(ER_VARIABLE_IS_NOT_STRUCT, MYF(0),
		// ((lex_str)(yystack.valueAt (3-(3)))).str);
		// yyval.var= tmp;
		// yyval.base_name.str= (char*) "default";
		// yyval.base_name.length= 7;
		// };
		// break;
		//
		//
		// case 2387:
		// if (yyn == 2387)
		// /* Line 350 of lalr1.java */
		// /* Line 14988 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex=Lex;
		// Item *item= new (thd->mem_root) Item_int((int32)
		// ((num)(yystack.valueAt (1-(1)))));
		// if (item == NULL)
		// return YYABORT;
		// set_var *var= new set_var(lex->option_type,
		// find_sys_var(thd, "tx_read_only"),
		// &null_lex_str,
		// item);
		// if (var == NULL)
		// return YYABORT;
		// lex->var_list.push_back(var);
		// };
		// break;
		//
		//
		// case 2388:
		// if (yyn == 2388)
		// /* Line 350 of lalr1.java */
		// /* Line 15006 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex=Lex;
		// Item *item= new (thd->mem_root) Item_int((int32)
		// ((tx_isolation)(yystack.valueAt (3-(3)))));
		// if (item == NULL)
		// return YYABORT;
		// set_var *var= new set_var(lex->option_type,
		// find_sys_var(thd, "tx_isolation"),
		// &null_lex_str,
		// item);
		// if (var == NULL)
		// return YYABORT;
		// lex->var_list.push_back(var);
		// };
		// break;
		//
		//
		// case 2389:
		// if (yyn == 2389)
		// /* Line 350 of lalr1.java */
		// /* Line 15023 of "sql_yacc.y" */
		// { yyval= true; };
		// break;
		//
		//
		// case 2390:
		// if (yyn == 2390)
		// /* Line 350 of lalr1.java */
		// /* Line 15024 of "sql_yacc.y" */
		// { yyval= false; };
		// break;
		//
		//
		// case 2391:
		// if (yyn == 2391)
		// /* Line 350 of lalr1.java */
		// /* Line 15028 of "sql_yacc.y" */
		// { yyval= ISO_READ_UNCOMMITTED; };
		// break;
		//
		//
		// case 2392:
		// if (yyn == 2392)
		// /* Line 350 of lalr1.java */
		// /* Line 15029 of "sql_yacc.y" */
		// { yyval= ISO_READ_COMMITTED; };
		// break;
		//
		//
		// case 2393:
		// if (yyn == 2393)
		// /* Line 350 of lalr1.java */
		// /* Line 15030 of "sql_yacc.y" */
		// { yyval= ISO_REPEATABLE_READ; };
		// break;
		//
		//
		// case 2394:
		// if (yyn == 2394)
		// /* Line 350 of lalr1.java */
		// /* Line 15031 of "sql_yacc.y" */
		// { yyval= ISO_SERIALIZABLE; };
		// break;
		//
		//
		// case 2395:
		// if (yyn == 2395)
		// /* Line 350 of lalr1.java */
		// /* Line 15035 of "sql_yacc.y" */
		// { yyval=((lex_str)(yystack.valueAt (1-(1)))).str;};
		// break;
		//
		//
		// case 2396:
		// if (yyn == 2396)
		// /* Line 350 of lalr1.java */
		// /* Line 15037 of "sql_yacc.y" */
		// {
		// if (((lex_str)(yystack.valueAt (4-(3)))).length == 0)
		// yyval= ((lex_str)(yystack.valueAt (4-(3)))).str;
		// else
		// switch (YYTHD->variables.old_passwords) {
		// case 1: yyval= Item_func_old_password::
		// alloc(YYTHD, ((lex_str)(yystack.valueAt (4-(3)))).str,
		// ((lex_str)(yystack.valueAt (4-(3)))).length);
		// break;
		// case 0:
		// case 2: yyval= Item_func_password::
		// create_password_hash_buffer(YYTHD, ((lex_str)(yystack.valueAt
		// (4-(3)))).str, ((lex_str)(yystack.valueAt (4-(3)))).length);
		// break;
		// }
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->contains_plaintext_password= true;
		// };
		// break;
		//
		//
		// case 2397:
		// if (yyn == 2397)
		// /* Line 350 of lalr1.java */
		// /* Line 15055 of "sql_yacc.y" */
		// {
		// WARN_DEPRECATED(YYTHD, "OLD_PASSWORD", "PASSWORD");
		// yyval= ((lex_str)(yystack.valueAt (4-(3)))).length ?
		// Item_func_old_password::
		// alloc(YYTHD, ((lex_str)(yystack.valueAt (4-(3)))).str,
		// ((lex_str)(yystack.valueAt (4-(3)))).length) :
		// ((lex_str)(yystack.valueAt (4-(3)))).str;
		// if (yyval == NULL)
		// return YYABORT;
		// Lex->contains_plaintext_password= true;
		// };
		// break;
		//
		//
		// case 2398:
		// if (yyn == 2398)
		// /* Line 350 of lalr1.java */
		// /* Line 15068 of "sql_yacc.y" */
		// { yyval=((item)(yystack.valueAt (1-(1)))); };
		// break;
		//
		//
		// case 2399:
		// if (yyn == 2399)
		// /* Line 350 of lalr1.java */
		// /* Line 15069 of "sql_yacc.y" */
		// { yyval=0; };
		// break;
		//
		//
		// case 2400:
		// if (yyn == 2400)
		// /* Line 350 of lalr1.java */
		// /* Line 15071 of "sql_yacc.y" */
		// {
		// yyval=new (YYTHD->mem_root) Item_string("ON", 2,
		// system_charset_info);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2401:
		// if (yyn == 2401)
		// /* Line 350 of lalr1.java */
		// /* Line 15077 of "sql_yacc.y" */
		// {
		// yyval=new (YYTHD->mem_root) Item_string("ALL", 3,
		// system_charset_info);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2402:
		// if (yyn == 2402)
		// /* Line 350 of lalr1.java */
		// /* Line 15083 of "sql_yacc.y" */
		// {
		// yyval=new (YYTHD->mem_root) Item_string("binary", 6,
		// system_charset_info);
		// if (yyval == NULL)
		// return YYABORT;
		// };
		// break;

		case 2403:
			if (yyn == 2403)
			/* Line 350 of lalr1.java */
			/* Line 15094 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				//
				// if (lex->sphead)
				// {
				// my_error(ER_SP_BADSTATEMENT, MYF(0), "LOCK");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_LOCK_TABLES;
			}
			;
			break;
		//
		//
		// case 2404:
		// if (yyn == 2404)
		// /* Line 350 of lalr1.java */
		// /* Line 15105 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		case 2409:
			if (yyn == 2409)
			/* Line 350 of lalr1.java */
			/* Line 15120 of "sql_yacc.y" */
			{
				// thr_lock_type lock_type= (thr_lock_type)
				// ((num)(yystack.valueAt
				// (3-(3))));
				// bool lock_for_write= (lock_type >= TL_WRITE_ALLOW_WRITE);
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (1)),
						((Item) (yystack.valueAt(3 - (2)))), null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 2410:
		// if (yyn == 2410)
		// /* Line 350 of lalr1.java */
		// /* Line 15132 of "sql_yacc.y" */
		// { yyval= TL_READ_NO_INSERT; };
		// break;
		//
		//
		// case 2411:
		// if (yyn == 2411)
		// /* Line 350 of lalr1.java */
		// /* Line 15133 of "sql_yacc.y" */
		// { yyval= TL_WRITE_DEFAULT; };
		// break;
		//
		//
		// case 2412:
		// if (yyn == 2412)
		// /* Line 350 of lalr1.java */
		// /* Line 15135 of "sql_yacc.y" */
		// {
		// yyval= TL_WRITE_LOW_PRIORITY;
		// WARN_DEPRECATED(YYTHD, "LOW_PRIORITY WRITE", "WRITE");
		// };
		// break;
		//
		//
		// case 2413:
		// if (yyn == 2413)
		// /* Line 350 of lalr1.java */
		// /* Line 15139 of "sql_yacc.y" */
		// { yyval= TL_READ; };
		// break;

		case 2414:
			if (yyn == 2414)
			/* Line 350 of lalr1.java */
			/* Line 15144 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				//
				// if (lex->sphead)
				// {
				// my_error(ER_SP_BADSTATEMENT, MYF(0), "UNLOCK");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_UNLOCK_TABLES;
			}
			;
			break;
		//
		//
		// case 2415:
		// if (yyn == 2415)
		// /* Line 350 of lalr1.java */
		// /* Line 15155 of "sql_yacc.y" */
		// {};
		// break;

		case 2416:
			if (yyn == 2416)
			/* Line 350 of lalr1.java */
			/* Line 15164 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= Lex;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_BADSTATEMENT, MYF(0), "HANDLER");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_HA_OPEN;
				if (!MyParserProcessor.addTableToList(thd, new TableIdent(((Token) yystack.valueAt(4 - (2))).lexStr),
						((Item) (yystack.valueAt(4 - (4)))), null))
					return YYABORT;
				// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_handler_open();
				// if (lex->m_sql_cmd == NULL)
				// return YYABORT;
			}
			;
			break;

		case 2417:
			if (yyn == 2417)
			/* Line 350 of lalr1.java */
			/* Line 15180 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= Lex;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_BADSTATEMENT, MYF(0), "HANDLER");
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_HA_CLOSE;
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (2)), null, null))
					return YYABORT;
				// lex->m_sql_cmd= new (thd->mem_root) Sql_cmd_handler_close();
				// if (lex->m_sql_cmd == NULL)
				// return YYABORT;
			}
			;
			break;

		case 2418:
			if (yyn == 2418)
			/* Line 350 of lalr1.java */
			/* Line 15196 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// if (lex->sphead)
				// {
				// my_error(ER_SP_BADSTATEMENT, MYF(0), "HANDLER");
				// return YYABORT;
				// }
				// lex->expr_allows_subselect= FALSE;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_HA_READ;
				// Item *one= new (YYTHD->mem_root) Item_int((int32) 1);
				// if (one == NULL)
				// return YYABORT;
				// lex->current_select->select_limit= one;
				// lex->current_select->offset_limit= 0;
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (2)), null, null))
					return YYABORT;
			}
			;
			break;
		//
		//
		// case 2419:
		// if (yyn == 2419)
		// /* Line 350 of lalr1.java */
		// /* Line 15214 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// Lex->expr_allows_subselect= TRUE;
		// /* Stored functions are not supported for HANDLER READ. */
		// if (lex->uses_stored_routines())
		// {
		// my_error(ER_NOT_SUPPORTED_YET, MYF(0),
		// "stored functions in HANDLER ... READ");
		// return YYABORT;
		// }
		// lex->m_sql_cmd= new (thd->mem_root)
		// Sql_cmd_handler_read(((ha_read_mode)(yystack.valueAt (7-(5)))),
		// lex->ident.str, lex->insert_list,
		// thd->m_parser_state->m_yacc.m_ha_rkey_mode);
		// if (lex->m_sql_cmd == NULL)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2420:
		// if (yyn == 2420)
		// /* Line 350 of lalr1.java */
		// /* Line 15234 of "sql_yacc.y" */
		// { Lex->ident= null_lex_str; yyval=((ha_read_mode)(yystack.valueAt
		// (1-(1)))); };
		// break;
		//
		//
		// case 2421:
		// if (yyn == 2421)
		// /* Line 350 of lalr1.java */
		// /* Line 15235 of "sql_yacc.y" */
		// { Lex->ident= ((lex_str)(yystack.valueAt (2-(1))));
		// yyval=((ha_read_mode)(yystack.valueAt (2-(2)))); };
		// break;
		//
		//
		// case 2422:
		// if (yyn == 2422)
		// /* Line 350 of lalr1.java */
		// /* Line 15239 of "sql_yacc.y" */
		// { yyval= RFIRST; };
		// break;
		//
		//
		// case 2423:
		// if (yyn == 2423)
		// /* Line 350 of lalr1.java */
		// /* Line 15240 of "sql_yacc.y" */
		// { yyval= RNEXT; };
		// break;
		//
		//
		// case 2424:
		// if (yyn == 2424)
		// /* Line 350 of lalr1.java */
		// /* Line 15244 of "sql_yacc.y" */
		// { yyval= RFIRST; };
		// break;
		//
		//
		// case 2425:
		// if (yyn == 2425)
		// /* Line 350 of lalr1.java */
		// /* Line 15245 of "sql_yacc.y" */
		// { yyval= RNEXT; };
		// break;
		//
		//
		// case 2426:
		// if (yyn == 2426)
		// /* Line 350 of lalr1.java */
		// /* Line 15246 of "sql_yacc.y" */
		// { yyval= RPREV; };
		// break;
		//
		//
		// case 2427:
		// if (yyn == 2427)
		// /* Line 350 of lalr1.java */
		// /* Line 15247 of "sql_yacc.y" */
		// { yyval= RLAST; };
		// break;
		//
		//
		// case 2428:
		// if (yyn == 2428)
		// /* Line 350 of lalr1.java */
		// /* Line 15249 of "sql_yacc.y" */
		// {
		// YYTHD->m_parser_state->m_yacc.m_ha_rkey_mode=
		// ((ha_rkey_mode)(yystack.valueAt (1-(1))));
		// Lex->insert_list= new List_item;
		// if (! Lex->insert_list)
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2429:
		// if (yyn == 2429)
		// /* Line 350 of lalr1.java */
		// /* Line 15256 of "sql_yacc.y" */
		// {
		// yyval= RKEY;
		// };
		// break;
		//
		//
		// case 2430:
		// if (yyn == 2430)
		// /* Line 350 of lalr1.java */
		// /* Line 15262 of "sql_yacc.y" */
		// { yyval=HA_READ_KEY_EXACT; };
		// break;
		//
		//
		// case 2431:
		// if (yyn == 2431)
		// /* Line 350 of lalr1.java */
		// /* Line 15263 of "sql_yacc.y" */
		// { yyval=HA_READ_KEY_OR_NEXT; };
		// break;
		//
		//
		// case 2432:
		// if (yyn == 2432)
		// /* Line 350 of lalr1.java */
		// /* Line 15264 of "sql_yacc.y" */
		// { yyval=HA_READ_KEY_OR_PREV; };
		// break;
		//
		//
		// case 2433:
		// if (yyn == 2433)
		// /* Line 350 of lalr1.java */
		// /* Line 15265 of "sql_yacc.y" */
		// { yyval=HA_READ_AFTER_KEY; };
		// break;
		//
		//
		// case 2434:
		// if (yyn == 2434)
		// /* Line 350 of lalr1.java */
		// /* Line 15266 of "sql_yacc.y" */
		// { yyval=HA_READ_BEFORE_KEY; };
		// break;

		case 2435:
			if (yyn == 2435)
			/* Line 350 of lalr1.java */
			/* Line 15272 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_REVOKE;
			}
			;
			break;
		//
		//
		// case 2436:
		// if (yyn == 2436)
		// /* Line 350 of lalr1.java */
		// /* Line 15273 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2437:
		// if (yyn == 2437)
		// /* Line 350 of lalr1.java */
		// /* Line 15278 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->type= 0;
		// };
		// break;
		//
		//
		case 2438:
			if (yyn == 2438)
			/* Line 350 of lalr1.java */
			/* Line 15283 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// if (lex->columns.elements)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// lex->type= TYPE_ENUM_FUNCTION;
			}
			;
			break;
		//
		//
		case 2439:
			if (yyn == 2439)
			/* Line 350 of lalr1.java */
			/* Line 15293 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// if (lex->columns.elements)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// lex->type= TYPE_ENUM_PROCEDURE;
			}
			;
			break;

		case 2440:
			if (yyn == 2440)
			/* Line 350 of lalr1.java */
			/* Line 15303 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_REVOKE_ALL;
			}
			;
			break;
		//
		//
		// case 2441:
		// if (yyn == 2441)
		// /* Line 350 of lalr1.java */
		// /* Line 15307 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->users_list.push_front (((lex_user)(yystack.valueAt (5-(3)))));
		// lex->type= TYPE_ENUM_PROXY;
		// };
		// break;

		case 2442:
			if (yyn == 2442)
			/* Line 350 of lalr1.java */
			/* Line 15315 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_GRANT;
			}
			;
			break;
		//
		//
		// case 2443:
		// if (yyn == 2443)
		// /* Line 350 of lalr1.java */
		// /* Line 15316 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2444:
		// if (yyn == 2444)
		// /* Line 350 of lalr1.java */
		// /* Line 15322 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->type= 0;
		// };
		// break;
		//
		//
		case 2445:
			if (yyn == 2445)
			/* Line 350 of lalr1.java */
			/* Line 15328 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// if (lex->columns.elements)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// lex->type= TYPE_ENUM_FUNCTION;
			}
			;
			break;
		//
		//
		case 2446:
			if (yyn == 2446)
			/* Line 350 of lalr1.java */
			/* Line 15339 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				// if (lex->columns.elements)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// lex->type= TYPE_ENUM_PROCEDURE;
			}
			;
			break;
		//
		//
		// case 2447:
		// if (yyn == 2447)
		// /* Line 350 of lalr1.java */
		// /* Line 15349 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->users_list.push_front (((lex_user)(yystack.valueAt (6-(3)))));
		// lex->type= TYPE_ENUM_PROXY;
		// };
		// break;

		case 2450:
			if (yyn == 2450)
			/* Line 350 of lalr1.java */
			/* Line 15363 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				if (thd.lex.grant == SQLPrivConstants.GLOBAL_ACLS && thd.lex.sqlCommand == SQLCommand.SQLCOM_REVOKE)
					thd.lex.sqlCommand = SQLCommand.SQLCOM_REVOKE_ALL;
			}
			;
			break;

		case 2451:
			if (yyn == 2451)
			/* Line 350 of lalr1.java */
			/* Line 15370 of "sql_yacc.y" */
			{
				thd.lex.allPrivileges = 1;
				thd.lex.grant = SQLPrivConstants.GLOBAL_ACLS;
			}
			;
			break;
		//
		//
		// case 2456:
		// if (yyn == 2456)
		// /* Line 350 of lalr1.java */
		// /* Line 15388 of "sql_yacc.y" */
		// { Lex->which_columns = SELECT_ACL;};
		// break;
		//
		//
		// case 2457:
		// if (yyn == 2457)
		// /* Line 350 of lalr1.java */
		// /* Line 15389 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2458:
		// if (yyn == 2458)
		// /* Line 350 of lalr1.java */
		// /* Line 15391 of "sql_yacc.y" */
		// { Lex->which_columns = INSERT_ACL;};
		// break;
		//
		//
		// case 2459:
		// if (yyn == 2459)
		// /* Line 350 of lalr1.java */
		// /* Line 15392 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2460:
		// if (yyn == 2460)
		// /* Line 350 of lalr1.java */
		// /* Line 15394 of "sql_yacc.y" */
		// { Lex->which_columns = UPDATE_ACL; };
		// break;
		//
		//
		// case 2461:
		// if (yyn == 2461)
		// /* Line 350 of lalr1.java */
		// /* Line 15395 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2462:
		// if (yyn == 2462)
		// /* Line 350 of lalr1.java */
		// /* Line 15397 of "sql_yacc.y" */
		// { Lex->which_columns = REFERENCES_ACL;};
		// break;
		//
		//
		// case 2463:
		// if (yyn == 2463)
		// /* Line 350 of lalr1.java */
		// /* Line 15398 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2464:
		// if (yyn == 2464)
		// /* Line 350 of lalr1.java */
		// /* Line 15399 of "sql_yacc.y" */
		// { Lex->grant |= DELETE_ACL;};
		// break;
		//
		//
		// case 2465:
		// if (yyn == 2465)
		// /* Line 350 of lalr1.java */
		// /* Line 15400 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2466:
		// if (yyn == 2466)
		// /* Line 350 of lalr1.java */
		// /* Line 15401 of "sql_yacc.y" */
		// { Lex->grant |= INDEX_ACL;};
		// break;
		//
		//
		// case 2467:
		// if (yyn == 2467)
		// /* Line 350 of lalr1.java */
		// /* Line 15402 of "sql_yacc.y" */
		// { Lex->grant |= ALTER_ACL;};
		// break;
		//
		//
		// case 2468:
		// if (yyn == 2468)
		// /* Line 350 of lalr1.java */
		// /* Line 15403 of "sql_yacc.y" */
		// { Lex->grant |= CREATE_ACL;};
		// break;
		//
		//
		// case 2469:
		// if (yyn == 2469)
		// /* Line 350 of lalr1.java */
		// /* Line 15404 of "sql_yacc.y" */
		// { Lex->grant |= DROP_ACL;};
		// break;
		//
		//
		// case 2470:
		// if (yyn == 2470)
		// /* Line 350 of lalr1.java */
		// /* Line 15405 of "sql_yacc.y" */
		// { Lex->grant |= EXECUTE_ACL;};
		// break;
		//
		//
		// case 2471:
		// if (yyn == 2471)
		// /* Line 350 of lalr1.java */
		// /* Line 15406 of "sql_yacc.y" */
		// { Lex->grant |= RELOAD_ACL;};
		// break;
		//
		//
		// case 2472:
		// if (yyn == 2472)
		// /* Line 350 of lalr1.java */
		// /* Line 15407 of "sql_yacc.y" */
		// { Lex->grant |= SHUTDOWN_ACL;};
		// break;
		//
		//
		// case 2473:
		// if (yyn == 2473)
		// /* Line 350 of lalr1.java */
		// /* Line 15408 of "sql_yacc.y" */
		// { Lex->grant |= PROCESS_ACL;};
		// break;
		//
		//
		// case 2474:
		// if (yyn == 2474)
		// /* Line 350 of lalr1.java */
		// /* Line 15409 of "sql_yacc.y" */
		// { Lex->grant |= FILE_ACL;};
		// break;
		//
		//
		// case 2475:
		// if (yyn == 2475)
		// /* Line 350 of lalr1.java */
		// /* Line 15410 of "sql_yacc.y" */
		// { Lex->grant |= GRANT_ACL;};
		// break;
		//
		//
		// case 2476:
		// if (yyn == 2476)
		// /* Line 350 of lalr1.java */
		// /* Line 15411 of "sql_yacc.y" */
		// { Lex->grant |= SHOW_DB_ACL;};
		// break;
		//
		//
		// case 2477:
		// if (yyn == 2477)
		// /* Line 350 of lalr1.java */
		// /* Line 15412 of "sql_yacc.y" */
		// { Lex->grant |= SUPER_ACL;};
		// break;
		//
		//
		// case 2478:
		// if (yyn == 2478)
		// /* Line 350 of lalr1.java */
		// /* Line 15413 of "sql_yacc.y" */
		// { Lex->grant |= CREATE_TMP_ACL;};
		// break;
		//
		//
		// case 2479:
		// if (yyn == 2479)
		// /* Line 350 of lalr1.java */
		// /* Line 15414 of "sql_yacc.y" */
		// { Lex->grant |= LOCK_TABLES_ACL; };
		// break;
		//
		//
		// case 2480:
		// if (yyn == 2480)
		// /* Line 350 of lalr1.java */
		// /* Line 15415 of "sql_yacc.y" */
		// { Lex->grant |= REPL_SLAVE_ACL; };
		// break;
		//
		//
		// case 2481:
		// if (yyn == 2481)
		// /* Line 350 of lalr1.java */
		// /* Line 15416 of "sql_yacc.y" */
		// { Lex->grant |= REPL_CLIENT_ACL; };
		// break;
		//
		//
		// case 2482:
		// if (yyn == 2482)
		// /* Line 350 of lalr1.java */
		// /* Line 15417 of "sql_yacc.y" */
		// { Lex->grant |= CREATE_VIEW_ACL; };
		// break;
		//
		//
		// case 2483:
		// if (yyn == 2483)
		// /* Line 350 of lalr1.java */
		// /* Line 15418 of "sql_yacc.y" */
		// { Lex->grant |= SHOW_VIEW_ACL; };
		// break;
		//
		//
		// case 2484:
		// if (yyn == 2484)
		// /* Line 350 of lalr1.java */
		// /* Line 15419 of "sql_yacc.y" */
		// { Lex->grant |= CREATE_PROC_ACL; };
		// break;
		//
		//
		// case 2485:
		// if (yyn == 2485)
		// /* Line 350 of lalr1.java */
		// /* Line 15420 of "sql_yacc.y" */
		// { Lex->grant |= ALTER_PROC_ACL; };
		// break;
		//
		//
		// case 2486:
		// if (yyn == 2486)
		// /* Line 350 of lalr1.java */
		// /* Line 15421 of "sql_yacc.y" */
		// { Lex->grant |= CREATE_USER_ACL; };
		// break;
		//
		//
		// case 2487:
		// if (yyn == 2487)
		// /* Line 350 of lalr1.java */
		// /* Line 15422 of "sql_yacc.y" */
		// { Lex->grant |= EVENT_ACL;};
		// break;
		//
		//
		// case 2488:
		// if (yyn == 2488)
		// /* Line 350 of lalr1.java */
		// /* Line 15423 of "sql_yacc.y" */
		// { Lex->grant |= TRIGGER_ACL; };
		// break;
		//
		//
		// case 2489:
		// if (yyn == 2489)
		// /* Line 350 of lalr1.java */
		// /* Line 15424 of "sql_yacc.y" */
		// { Lex->grant |= CREATE_TABLESPACE_ACL; };
		// break;
		//
		//
		// case 2490:
		// if (yyn == 2490)
		// /* Line 350 of lalr1.java */
		// /* Line 15428 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2491:
		// if (yyn == 2491)
		// /* Line 350 of lalr1.java */
		// /* Line 15429 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2494:
		// if (yyn == 2494)
		// /* Line 350 of lalr1.java */
		// /* Line 15439 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (lex->x509_subject)
		// {
		// my_error(ER_DUP_ARGUMENT, MYF(0), "SUBJECT");
		// return YYABORT;
		// }
		// lex->x509_subject=((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 2495:
		// if (yyn == 2495)
		// /* Line 350 of lalr1.java */
		// /* Line 15449 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (lex->x509_issuer)
		// {
		// my_error(ER_DUP_ARGUMENT, MYF(0), "ISSUER");
		// return YYABORT;
		// }
		// lex->x509_issuer=((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 2496:
		// if (yyn == 2496)
		// /* Line 350 of lalr1.java */
		// /* Line 15459 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// if (lex->ssl_cipher)
		// {
		// my_error(ER_DUP_ARGUMENT, MYF(0), "CIPHER");
		// return YYABORT;
		// }
		// lex->ssl_cipher=((lex_str)(yystack.valueAt (2-(2)))).str;
		// };
		// break;
		//
		//
		// case 2497:
		// if (yyn == 2497)
		// /* Line 350 of lalr1.java */
		// /* Line 15472 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// size_t dummy;
		// if (lex->copy_db_to(&lex->current_select->db, &dummy))
		// return YYABORT;
		// if (lex->grant == GLOBAL_ACLS)
		// lex->grant = DB_ACLS & ~GRANT_ACL;
		// else if (lex->columns.elements)
		// {
		// my_message(ER_ILLEGAL_GRANT_FOR_TABLE,
		// ER(ER_ILLEGAL_GRANT_FOR_TABLE), MYF(0));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 2498:
		// if (yyn == 2498)
		// /* Line 350 of lalr1.java */
		// /* Line 15487 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->current_select->db = ((lex_str)(yystack.valueAt (3-(1)))).str;
		// if (lex->grant == GLOBAL_ACLS)
		// lex->grant = DB_ACLS & ~GRANT_ACL;
		// else if (lex->columns.elements)
		// {
		// my_message(ER_ILLEGAL_GRANT_FOR_TABLE,
		// ER(ER_ILLEGAL_GRANT_FOR_TABLE), MYF(0));
		// return YYABORT;
		// }
		// };
		// break;
		//
		//
		// case 2499:
		// if (yyn == 2499)
		// /* Line 350 of lalr1.java */
		// /* Line 15500 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->current_select->db = NULL;
		// if (lex->grant == GLOBAL_ACLS)
		// lex->grant= GLOBAL_ACLS & ~GRANT_ACL;
		// else if (lex->columns.elements)
		// {
		// my_message(ER_ILLEGAL_GRANT_FOR_TABLE,
		// ER(ER_ILLEGAL_GRANT_FOR_TABLE), MYF(0));
		// return YYABORT;
		// }
		// };
		// break;

		case 2500:
			if (yyn == 2500)
			/* Line 350 of lalr1.java */
			/* Line 15513 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(1 - (1)), null, null))
					return YYABORT;
				// if (lex->grant == GLOBAL_ACLS)
				// lex->grant = TABLE_ACLS & ~GRANT_ACL;
			}
			;
			break;
		//
		//
		// case 2501:
		// if (yyn == 2501)
		// /* Line 350 of lalr1.java */
		// /* Line 15525 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (1-(1))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2502:
		// if (yyn == 2502)
		// /* Line 350 of lalr1.java */
		// /* Line 15530 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2503:
		// if (yyn == 2503)
		// /* Line 350 of lalr1.java */
		// /* Line 15538 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (1-(1))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2504:
		// if (yyn == 2504)
		// /* Line 350 of lalr1.java */
		// /* Line 15543 of "sql_yacc.y" */
		// {
		// if (Lex->users_list.push_back(((lex_user)(yystack.valueAt (3-(3))))))
		// return YYABORT;
		// };
		// break;
		//
		//
		case 2505:
			if (yyn == 2505)
			/* Line 350 of lalr1.java */
			/* Line 15551 of "sql_yacc.y" */
			{
				// yyval=((lex_user)(yystack.valueAt (4-(1))));
				// ((lex_user)(yystack.valueAt
				// (4-(1))))->password=((lex_str)(yystack.valueAt (4-(4))));
				// if (thd.lex.sqlCommand == SQLCOM_REVOKE)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// String *password = new (YYTHD->mem_root) String((const
				// char*)((lex_str)(yystack.valueAt (4-(4)))).str,
				// YYTHD->variables.character_set_client);
				// check_password_policy(password);
				// /*
				// 1. Plugin must be resolved
				// 2. Password must be digested
				// */
				// ((lex_user)(yystack.valueAt
				// (4-(1))))->uses_identified_by_clause=
				// true;
				// Lex->contains_plaintext_password= true;
			}
			;
			break;

		case 2506:
			if (yyn == 2506)
			/* Line 350 of lalr1.java */
			/* Line 15569 of "sql_yacc.y" */
			{
				// if (thd.lex.sqlCommand == SQLCOM_REVOKE)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// yyval= ((lex_user)(yystack.valueAt (5-(1))));
				// ((lex_user)(yystack.valueAt (5-(1))))->password=
				// ((lex_str)(yystack.valueAt (5-(5))));
				// if (!strcmp(((lex_str)(yystack.valueAt (5-(5)))).str, ""))
				// {
				// String *password= new (YYTHD->mem_root) String ((const char
				// *)"",
				// YYTHD->variables.character_set_client);
				// check_password_policy(password);
				// }
				// /*
				// 1. Plugin must be resolved
				// */
				// ((lex_user)(yystack.valueAt
				// (5-(1))))->uses_identified_by_password_clause= true;
			}
			;
			break;
		//
		//
		case 2507:
			if (yyn == 2507)
			/* Line 350 of lalr1.java */
			/* Line 15589 of "sql_yacc.y" */
			{
				// if (thd.lex.sqlCommand == SQLCOM_REVOKE)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// yyval= ((lex_user)(yystack.valueAt (4-(1))));
				// ((lex_user)(yystack.valueAt (4-(1))))->plugin=
				// ((lex_str)(yystack.valueAt (4-(4))));
				// ((lex_user)(yystack.valueAt (4-(1))))->auth= empty_lex_str;
				// ((lex_user)(yystack.valueAt
				// (4-(1))))->uses_identified_with_clause=
				// true;
			}
			;
			break;
		//
		//
		case 2508:
			if (yyn == 2508)
			/* Line 350 of lalr1.java */
			/* Line 15601 of "sql_yacc.y" */
			{
				// if (thd.lex.sqlCommand == SQLCOM_REVOKE)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// yyval= ((lex_user)(yystack.valueAt (6-(1))));
				// ((lex_user)(yystack.valueAt (6-(1))))->plugin=
				// ((lex_str)(yystack.valueAt (6-(4))));
				// ((lex_user)(yystack.valueAt (6-(1))))->auth=
				// ((lex_str)(yystack.valueAt (6-(6))));
				// ((lex_user)(yystack.valueAt
				// (6-(1))))->uses_identified_with_clause=
				// true;
				// ((lex_user)(yystack.valueAt
				// (6-(1))))->uses_authentication_string_clause= true;
			}
			;
			break;
		//
		//
		// case 2509:
		// if (yyn == 2509)
		// /* Line 350 of lalr1.java */
		// /* Line 15614 of "sql_yacc.y" */
		// {
		// yyval= ((lex_user)(yystack.valueAt (1-(1))));
		// ((lex_user)(yystack.valueAt (1-(1))))->password= null_lex_str;
		// };
		// break;
		//
		//
		// case 2510:
		// if (yyn == 2510)
		// /* Line 350 of lalr1.java */
		// /* Line 15622 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->grant |= lex->which_columns;
		// };
		// break;
		//
		//
		// case 2514:
		// if (yyn == 2514)
		// /* Line 350 of lalr1.java */
		// /* Line 15636 of "sql_yacc.y" */
		// {
		// String *new_str = new (YYTHD->mem_root) String((const char*)
		// ((lex_str)(yystack.valueAt (1-(1)))).str,((lex_str)(yystack.valueAt
		// (1-(1)))).length,system_charset_info);
		// if (new_str == NULL)
		// return YYABORT;
		// List_iterator <LEX_COLUMN> iter(Lex->columns);
		// class LEX_COLUMN *point;
		// LEX *lex=Lex;
		// while ((point=iter++))
		// {
		// if (!my_strcasecmp(system_charset_info,
		// point->column.ptr(), new_str->ptr()))
		// break;
		// }
		// lex->grant_tot_col|= lex->which_columns;
		// if (point)
		// point->rights |= lex->which_columns;
		// else
		// {
		// LEX_COLUMN *col= new LEX_COLUMN (*new_str,lex->which_columns);
		// if (col == NULL)
		// return YYABORT;
		// lex->columns.push_back(col);
		// }
		// };
		// break;
		//
		//
		// case 2516:
		// if (yyn == 2516)
		// /* Line 350 of lalr1.java */
		// /* Line 15665 of "sql_yacc.y" */
		// {
		// Lex->ssl_type=SSL_TYPE_SPECIFIED;
		// };
		// break;
		//
		//
		// case 2517:
		// if (yyn == 2517)
		// /* Line 350 of lalr1.java */
		// /* Line 15669 of "sql_yacc.y" */
		// {
		// Lex->ssl_type=SSL_TYPE_ANY;
		// };
		// break;
		//
		//
		// case 2518:
		// if (yyn == 2518)
		// /* Line 350 of lalr1.java */
		// /* Line 15673 of "sql_yacc.y" */
		// {
		// Lex->ssl_type=SSL_TYPE_X509;
		// };
		// break;
		//
		//
		// case 2519:
		// if (yyn == 2519)
		// /* Line 350 of lalr1.java */
		// /* Line 15677 of "sql_yacc.y" */
		// {
		// Lex->ssl_type=SSL_TYPE_NONE;
		// };
		// break;
		//
		//
		// case 2520:
		// if (yyn == 2520)
		// /* Line 350 of lalr1.java */
		// /* Line 15683 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2522:
		// if (yyn == 2522)
		// /* Line 350 of lalr1.java */
		// /* Line 15688 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2523:
		// if (yyn == 2523)
		// /* Line 350 of lalr1.java */
		// /* Line 15689 of "sql_yacc.y" */
		// { Lex->grant |= GRANT_ACL;};
		// break;
		//
		//
		// case 2524:
		// if (yyn == 2524)
		// /* Line 350 of lalr1.java */
		// /* Line 15693 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2525:
		// if (yyn == 2525)
		// /* Line 350 of lalr1.java */
		// /* Line 15694 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2526:
		// if (yyn == 2526)
		// /* Line 350 of lalr1.java */
		// /* Line 15698 of "sql_yacc.y" */
		// { Lex->grant |= GRANT_ACL;};
		// break;
		//
		//
		// case 2527:
		// if (yyn == 2527)
		// /* Line 350 of lalr1.java */
		// /* Line 15700 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->mqh.questions=((ulong_num)(yystack.valueAt (2-(2))));
		// lex->mqh.specified_limits|= USER_RESOURCES::QUERIES_PER_HOUR;
		// };
		// break;
		//
		//
		// case 2528:
		// if (yyn == 2528)
		// /* Line 350 of lalr1.java */
		// /* Line 15706 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->mqh.updates=((ulong_num)(yystack.valueAt (2-(2))));
		// lex->mqh.specified_limits|= USER_RESOURCES::UPDATES_PER_HOUR;
		// };
		// break;
		//
		//
		// case 2529:
		// if (yyn == 2529)
		// /* Line 350 of lalr1.java */
		// /* Line 15712 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->mqh.conn_per_hour= ((ulong_num)(yystack.valueAt (2-(2))));
		// lex->mqh.specified_limits|= USER_RESOURCES::CONNECTIONS_PER_HOUR;
		// };
		// break;
		//
		//
		// case 2530:
		// if (yyn == 2530)
		// /* Line 350 of lalr1.java */
		// /* Line 15718 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		// lex->mqh.user_conn= ((ulong_num)(yystack.valueAt (2-(2))));
		// lex->mqh.specified_limits|= USER_RESOURCES::USER_CONNECTIONS;
		// };
		// break;

		case 2531:
			if (yyn == 2531)
			/* Line 350 of lalr1.java */
			/* Line 15727 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_BEGIN;
				// lex->start_transaction_opt= 0;
			}
			;
			break;
		//
		//
		// case 2532:
		// if (yyn == 2532)
		// /* Line 350 of lalr1.java */
		// /* Line 15732 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2533:
		// if (yyn == 2533)
		// /* Line 350 of lalr1.java */
		// /* Line 15736 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2534:
		// if (yyn == 2534)
		// /* Line 350 of lalr1.java */
		// /* Line 15737 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2535:
		// if (yyn == 2535)
		// /* Line 350 of lalr1.java */
		// /* Line 15742 of "sql_yacc.y" */
		// { yyval= TVL_UNKNOWN; };
		// break;
		//
		//
		// case 2536:
		// if (yyn == 2536)
		// /* Line 350 of lalr1.java */
		// /* Line 15743 of "sql_yacc.y" */
		// { yyval= TVL_NO; };
		// break;
		//
		//
		// case 2537:
		// if (yyn == 2537)
		// /* Line 350 of lalr1.java */
		// /* Line 15744 of "sql_yacc.y" */
		// { yyval= TVL_YES; };
		// break;
		//
		//
		// case 2538:
		// if (yyn == 2538)
		// /* Line 350 of lalr1.java */
		// /* Line 15749 of "sql_yacc.y" */
		// { yyval= TVL_UNKNOWN; };
		// break;
		//
		//
		// case 2539:
		// if (yyn == 2539)
		// /* Line 350 of lalr1.java */
		// /* Line 15750 of "sql_yacc.y" */
		// { yyval= TVL_YES; };
		// break;
		//
		//
		// case 2540:
		// if (yyn == 2540)
		// /* Line 350 of lalr1.java */
		// /* Line 15751 of "sql_yacc.y" */
		// { yyval= TVL_NO; };
		// break;
		//
		//
		// case 2541:
		// if (yyn == 2541)
		// /* Line 350 of lalr1.java */
		// /* Line 15755 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2542:
		// if (yyn == 2542)
		// /* Line 350 of lalr1.java */
		// /* Line 15756 of "sql_yacc.y" */
		// {};
		// break;

		case 2543:
			if (yyn == 2543)
			/* Line 350 of lalr1.java */
			/* Line 15761 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_COMMIT;
				// /* Don't allow AND CHAIN RELEASE. */
				// return YYABORT;_UNLESS(((m_yes_no_unk)(yystack.valueAt
				// (4-(3)))) !=
				// TVL_YES || ((m_yes_no_unk)(yystack.valueAt (4-(4)))) !=
				// TVL_YES);
				// lex->tx_chain= ((m_yes_no_unk)(yystack.valueAt (4-(3))));
				// lex->tx_release= ((m_yes_no_unk)(yystack.valueAt (4-(4))));
			}
			;
			break;

		case 2544:
			if (yyn == 2544)
			/* Line 350 of lalr1.java */
			/* Line 15773 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ROLLBACK;
				// /* Don't allow AND CHAIN RELEASE. */
				// return YYABORT;_UNLESS(((m_yes_no_unk)(yystack.valueAt
				// (4-(3)))) !=
				// TVL_YES || ((m_yes_no_unk)(yystack.valueAt (4-(4)))) !=
				// TVL_YES);
				// lex->tx_chain= ((m_yes_no_unk)(yystack.valueAt (4-(3))));
				// lex->tx_release= ((m_yes_no_unk)(yystack.valueAt (4-(4))));
			}
			;
			break;

		case 2545:
			if (yyn == 2545)
			/* Line 350 of lalr1.java */
			/* Line 15783 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_ROLLBACK_TO_SAVEPOINT;
				// lex->ident= ((lex_str)(yystack.valueAt (5-(5))));
			}
			;
			break;

		case 2546:
			if (yyn == 2546)
			/* Line 350 of lalr1.java */
			/* Line 15792 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_SAVEPOINT;
				// lex->ident= ((lex_str)(yystack.valueAt (2-(2))));
			}
			;
			break;

		case 2547:
			if (yyn == 2547)
			/* Line 350 of lalr1.java */
			/* Line 15801 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_RELEASE_SAVEPOINT;
				// lex->ident= ((lex_str)(yystack.valueAt (3-(3))));
			}
			;
			break;
		//
		//
		// case 2548:
		// if (yyn == 2548)
		// /* Line 350 of lalr1.java */
		// /* Line 15814 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2550:
		// if (yyn == 2550)
		// /* Line 350 of lalr1.java */
		// /* Line 15820 of "sql_yacc.y" */
		// {
		// if (add_select_to_union_list(Lex, (bool)((num)(yystack.valueAt
		// (2-(2)))), TRUE))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2551:
		// if (yyn == 2551)
		// /* Line 350 of lalr1.java */
		// /* Line 15825 of "sql_yacc.y" */
		// {
		// /*
		// Remove from the name resolution context stack the context of the
		// last select in the union.
		// */
		// Lex->pop_context();
		// };
		// break;
		//
		//
		// case 2552:
		// if (yyn == 2552)
		// /* Line 350 of lalr1.java */
		// /* Line 15835 of "sql_yacc.y" */
		// { yyval= 0; };
		// break;
		//
		//
		// case 2553:
		// if (yyn == 2553)
		// /* Line 350 of lalr1.java */
		// /* Line 15836 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 2554:
		// if (yyn == 2554)
		// /* Line 350 of lalr1.java */
		// /* Line 15837 of "sql_yacc.y" */
		// { yyval= 1; };
		// break;
		//
		//
		// case 2555:
		// if (yyn == 2555)
		// /* Line 350 of lalr1.java */
		// /* Line 15841 of "sql_yacc.y" */
		// { yyval= false; };
		// break;
		//
		//
		// case 2556:
		// if (yyn == 2556)
		// /* Line 350 of lalr1.java */
		// /* Line 15842 of "sql_yacc.y" */
		// { yyval= true; };
		// break;
		//
		//
		// case 2557:
		// if (yyn == 2557)
		// /* Line 350 of lalr1.java */
		// /* Line 15846 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// DBUG_ASSERT(lex->current_select->linkage != GLOBAL_OPTIONS_TYPE);
		// SELECT_LEX *sel= lex->current_select;
		// SELECT_LEX_UNIT *unit= sel->master_unit();
		// SELECT_LEX *fake= unit->fake_select_lex;
		// if (fake)
		// {
		// unit->global_parameters= fake;
		// fake->no_table_names_allowed= 1;
		// lex->current_select= fake;
		// }
		// thd->where= "global ORDER clause";
		// };
		// break;
		//
		//
		// case 2558:
		// if (yyn == 2558)
		// /* Line 350 of lalr1.java */
		// /* Line 15862 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// thd->lex->current_select->no_table_names_allowed= 0;
		// thd->where= "";
		// };
		// break;
		//
		//
		// case 2561:
		// if (yyn == 2561)
		// /* Line 350 of lalr1.java */
		// /* Line 15875 of "sql_yacc.y" */
		// { yyval=1; };
		// break;
		//
		//
		// case 2562:
		// if (yyn == 2562)
		// /* Line 350 of lalr1.java */
		// /* Line 15876 of "sql_yacc.y" */
		// { yyval=1; };
		// break;
		//
		//
		// case 2563:
		// if (yyn == 2563)
		// /* Line 350 of lalr1.java */
		// /* Line 15877 of "sql_yacc.y" */
		// { yyval=0; };
		// break;
		//
		//
		// case 2564:
		// if (yyn == 2564)
		// /* Line 350 of lalr1.java */
		// /* Line 15882 of "sql_yacc.y" */
		// {
		// yyval= Lex->current_select->master_unit()->first_select();
		// };
		// break;
		//
		//
		// case 2565:
		// if (yyn == 2565)
		// /* Line 350 of lalr1.java */
		// /* Line 15886 of "sql_yacc.y" */
		// {
		// yyval= Lex->current_select->master_unit()->first_select();
		// };
		// break;
		//
		//
		// case 2567:
		// if (yyn == 2567)
		// /* Line 350 of lalr1.java */
		// /* Line 15895 of "sql_yacc.y" */
		// {
		// if (add_select_to_union_list(Lex, (bool)((num)(yystack.valueAt
		// (3-(3)))), FALSE))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2568:
		// if (yyn == 2568)
		// /* Line 350 of lalr1.java */
		// /* Line 15901 of "sql_yacc.y" */
		// {
		// Lex->pop_context();
		// yyval= ((select_lex)(yystack.valueAt (6-(1))));
		// };
		// break;
		//
		//
		// case 2569:
		// if (yyn == 2569)
		// /* Line 350 of lalr1.java */
		// /* Line 15910 of "sql_yacc.y" */
		// {
		// yyval= ((select_lex)(yystack.valueAt (3-(2))));
		// };
		// break;
		//
		//
		case 2570:
			if (yyn == 2570)
			/* Line 350 of lalr1.java */
			/* Line 15916 of "sql_yacc.y" */
			{
				// LEX *lex=Lex;
				// if (!lex->expr_allows_subselect ||
				// thd.lex.sqlCommand == (int)SQLCOM_PURGE)
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// /*
				// we are making a "derived table" for the parenthesis
				// as we need to have a lex level to fit the union
				// after the parenthesis, e.g.
				// (SELECT .. ) UNION ... becomes
				// SELECT * FROM ((SELECT ...) UNION ...)
				// */
				// if (mysql_new_select(Lex, 1))
				// return YYABORT;
			}
			;
			break;
		//
		//
		// case 2571:
		// if (yyn == 2571)
		// /* Line 350 of lalr1.java */
		// /* Line 15937 of "sql_yacc.y" */
		// {
		// LEX *lex=Lex;
		//
		// lex->pop_context();
		// SELECT_LEX *child= lex->current_select;
		// lex->current_select = lex->current_select->outer_select();
		// lex->nest_level--;
		// lex->current_select->n_child_sum_items += child->n_sum_items;
		// /*
		// A subselect can add fields to an outer select. Reserve space for
		// them.
		// */
		// lex->current_select->select_n_where_fields+=
		// child->select_n_where_fields;
		//
		// /*
		// Aggregate functions in having clause may add fields to an outer
		// select. Count them also.
		// */
		// lex->current_select->select_n_having_items+=
		// child->select_n_having_items;
		// };
		// break;
		//
		//
		// case 2576:
		// if (yyn == 2576)
		// /* Line 350 of lalr1.java */
		// /* Line 15972 of "sql_yacc.y" */
		// { Select->options|= SELECT_STRAIGHT_JOIN; };
		// break;
		//
		//
		// case 2577:
		// if (yyn == 2577)
		// /* Line 350 of lalr1.java */
		// /* Line 15974 of "sql_yacc.y" */
		// {
		// if (check_simple_select())
		// return YYABORT;
		// YYPS->m_lock_type= TL_READ_HIGH_PRIORITY;
		// YYPS->m_mdl_type= MDL_SHARED_READ;
		// Select->options|= SELECT_HIGH_PRIORITY;
		// };
		// break;
		//
		//
		// case 2578:
		// if (yyn == 2578)
		// /* Line 350 of lalr1.java */
		// /* Line 15981 of "sql_yacc.y" */
		// { Select->options|= SELECT_DISTINCT; };
		// break;
		//
		//
		// case 2579:
		// if (yyn == 2579)
		// /* Line 350 of lalr1.java */
		// /* Line 15982 of "sql_yacc.y" */
		// { Select->options|= SELECT_SMALL_RESULT; };
		// break;
		//
		//
		// case 2580:
		// if (yyn == 2580)
		// /* Line 350 of lalr1.java */
		// /* Line 15983 of "sql_yacc.y" */
		// { Select->options|= SELECT_BIG_RESULT; };
		// break;
		//
		//
		// case 2581:
		// if (yyn == 2581)
		// /* Line 350 of lalr1.java */
		// /* Line 15985 of "sql_yacc.y" */
		// {
		// if (check_simple_select())
		// return YYABORT;
		// Select->options|= OPTION_BUFFER_RESULT;
		// };
		// break;
		//
		//
		// case 2582:
		// if (yyn == 2582)
		// /* Line 350 of lalr1.java */
		// /* Line 15991 of "sql_yacc.y" */
		// {
		// if (check_simple_select())
		// return YYABORT;
		// Select->options|= OPTION_FOUND_ROWS;
		// };
		// break;
		//
		//
		// case 2583:
		// if (yyn == 2583)
		// /* Line 350 of lalr1.java */
		// /* Line 15996 of "sql_yacc.y" */
		// { Select->options|= SELECT_ALL; };
		// break;
		//
		//
		// case 2584:
		// if (yyn == 2584)
		// /* Line 350 of lalr1.java */
		// /* Line 16007 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2585:
		// if (yyn == 2585)
		// /* Line 350 of lalr1.java */
		// /* Line 16009 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2586:
		// if (yyn == 2586)
		// /* Line 350 of lalr1.java */
		// /* Line 16011 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2600:
		// if (yyn == 2600)
		// /* Line 350 of lalr1.java */
		// /* Line 16044 of "sql_yacc.y" */
		// {
		// /*
		// We have to distinguish missing DEFINER-clause from case when
		// CURRENT_USER specified as definer explicitly in order to properly
		// handle CREATE TRIGGER statements which come to replication thread
		// from older master servers (i.e. to create non-suid trigger in this
		// case).
		// */
		// YYTHD->lex->definer= 0;
		// };
		// break;
		//
		//
		// case 2601:
		// if (yyn == 2601)
		// /* Line 350 of lalr1.java */
		// /* Line 16058 of "sql_yacc.y" */
		// {
		// YYTHD->lex->definer= get_current_user(YYTHD,
		// ((lex_user)(yystack.valueAt (3-(3)))));
		// };
		// break;
		//
		//
		// case 2602:
		// if (yyn == 2602)
		// /* Line 350 of lalr1.java */
		// /* Line 16071 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2603:
		// if (yyn == 2603)
		// /* Line 350 of lalr1.java */
		// /* Line 16073 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2604:
		// if (yyn == 2604)
		// /* Line 350 of lalr1.java */
		// /* Line 16075 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2605:
		// if (yyn == 2605)
		// /* Line 350 of lalr1.java */
		// /* Line 16080 of "sql_yacc.y" */
		// { Lex->create_view_mode= VIEW_CREATE_OR_REPLACE; };
		// break;
		//
		//
		// case 2606:
		// if (yyn == 2606)
		// /* Line 350 of lalr1.java */
		// /* Line 16085 of "sql_yacc.y" */
		// { Lex->create_view_algorithm= VIEW_ALGORITHM_UNDEFINED; };
		// break;
		//
		//
		// case 2607:
		// if (yyn == 2607)
		// /* Line 350 of lalr1.java */
		// /* Line 16087 of "sql_yacc.y" */
		// { Lex->create_view_algorithm= VIEW_ALGORITHM_MERGE; };
		// break;
		//
		//
		// case 2608:
		// if (yyn == 2608)
		// /* Line 350 of lalr1.java */
		// /* Line 16089 of "sql_yacc.y" */
		// { Lex->create_view_algorithm= VIEW_ALGORITHM_TMPTABLE; };
		// break;
		//
		//
		// case 2609:
		// if (yyn == 2609)
		// /* Line 350 of lalr1.java */
		// /* Line 16094 of "sql_yacc.y" */
		// { Lex->create_view_suid= VIEW_SUID_DEFAULT; };
		// break;
		//
		//
		// case 2610:
		// if (yyn == 2610)
		// /* Line 350 of lalr1.java */
		// /* Line 16096 of "sql_yacc.y" */
		// { Lex->create_view_suid= VIEW_SUID_DEFINER; };
		// break;
		//
		//
		// case 2611:
		// if (yyn == 2611)
		// /* Line 350 of lalr1.java */
		// /* Line 16098 of "sql_yacc.y" */
		// { Lex->create_view_suid= VIEW_SUID_INVOKER; };
		// break;

		case 2612:
			if (yyn == 2612)
			/* Line 350 of lalr1.java */
			/* Line 16103 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_VIEW;
				// /* first table in list is target VIEW name */
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(3 - (3)), null, null))
					return YYABORT;
				// lex->query_tables->open_strategy= TABLE_LIST::OPEN_STUB;
			}
			;
			break;
		//
		//
		// case 2614:
		// if (yyn == 2614)
		// /* Line 350 of lalr1.java */
		// /* Line 16120 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2616:
		// if (yyn == 2616)
		// /* Line 350 of lalr1.java */
		// /* Line 16126 of "sql_yacc.y" */
		// {
		// Lex->view_list.push_back((LEX_STRING*)
		// sql_memdup(&((lex_str)(yystack.valueAt (1-(1)))),
		// sizeof(LEX_STRING)));
		// };
		// break;
		//
		//
		// case 2617:
		// if (yyn == 2617)
		// /* Line 350 of lalr1.java */
		// /* Line 16131 of "sql_yacc.y" */
		// {
		// Lex->view_list.push_back((LEX_STRING*)
		// sql_memdup(&((lex_str)(yystack.valueAt (3-(3)))),
		// sizeof(LEX_STRING)));
		// };
		// break;
		//
		//
		// case 2618:
		// if (yyn == 2618)
		// /* Line 350 of lalr1.java */
		// /* Line 16138 of "sql_yacc.y" */
		// {
		// LEX *lex= Lex;
		// lex->parsing_options.allows_variable= FALSE;
		// lex->parsing_options.allows_select_into= FALSE;
		// lex->parsing_options.allows_select_procedure= FALSE;
		// lex->parsing_options.allows_derived= FALSE;
		// lex->create_view_select.str= (char *) YYLIP->get_cpp_ptr();
		// };
		// break;
		//
		//
		// case 2619:
		// if (yyn == 2619)
		// /* Line 350 of lalr1.java */
		// /* Line 16147 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		// uint len= YYLIP->get_cpp_ptr() - lex->create_view_select.str;
		// void *create_view_select= thd->memdup(lex->create_view_select.str,
		// len);
		// lex->create_view_select.length= len;
		// lex->create_view_select.str= (char *) create_view_select;
		// trim_whitespace(thd->charset(), &lex->create_view_select);
		// lex->parsing_options.allows_variable= TRUE;
		// lex->parsing_options.allows_select_into= TRUE;
		// lex->parsing_options.allows_select_procedure= TRUE;
		// lex->parsing_options.allows_derived= TRUE;
		// };
		// break;
		//
		//
		case 2620:
			if (yyn == 2620)
			/* Line 350 of lalr1.java */
			/* Line 16164 of "sql_yacc.y" */
			{
				// if (Lex->current_select->set_braces(0))
				// {
				// my_parse_error(ER(ER_SYNTAX_ERROR));
				// return YYABORT;
				// }
				// /*
				// For statment as "CREATE VIEW v1 AS SELECT1 UNION SELECT2",
				// parsing of Select query (SELECT1) is completed and
				// UNION_CLAUSE
				// is not yet parsed. So check for
				// Lex->current_select->master_unit()->first_select()->braces
				// (as its done in "select_init2" for "select_part2" rule) is
				// not
				// done here.
				// */
			}
			;
			break;
		//
		//
		// case 2623:
		// if (yyn == 2623)
		// /* Line 350 of lalr1.java */
		// /* Line 16185 of "sql_yacc.y" */
		// {
		// if (setup_select_in_parentheses(Lex))
		// return YYABORT;
		// };
		// break;
		//
		//
		// case 2625:
		// if (yyn == 2625)
		// /* Line 350 of lalr1.java */
		// /* Line 16194 of "sql_yacc.y" */
		// {
		// Lex->current_select->table_list.save_and_clear(&Lex->save_list);
		// };
		// break;
		//
		//
		// case 2626:
		// if (yyn == 2626)
		// /* Line 350 of lalr1.java */
		// /* Line 16198 of "sql_yacc.y" */
		// {
		// Lex->current_select->table_list.push_front(&Lex->save_list);
		// };
		// break;
		//
		//
		// case 2627:
		// if (yyn == 2627)
		// /* Line 350 of lalr1.java */
		// /* Line 16205 of "sql_yacc.y" */
		// { Lex->create_view_check= VIEW_CHECK_NONE; };
		// break;
		//
		//
		// case 2628:
		// if (yyn == 2628)
		// /* Line 350 of lalr1.java */
		// /* Line 16207 of "sql_yacc.y" */
		// { Lex->create_view_check= VIEW_CHECK_CASCADED; };
		// break;
		//
		//
		// case 2629:
		// if (yyn == 2629)
		// /* Line 350 of lalr1.java */
		// /* Line 16209 of "sql_yacc.y" */
		// { Lex->create_view_check= VIEW_CHECK_CASCADED; };
		// break;
		//
		//
		// case 2630:
		// if (yyn == 2630)
		// /* Line 350 of lalr1.java */
		// /* Line 16211 of "sql_yacc.y" */
		// { Lex->create_view_check= VIEW_CHECK_LOCAL; };
		// break;
		//
		//
		// case 2631:
		// if (yyn == 2631)
		// /* Line 350 of lalr1.java */
		// /* Line 16228 of "sql_yacc.y" */
		// { /* $8 */
		// Lex->raw_trg_on_table_name_begin= YYLIP->get_tok_start();
		// };
		// break;
		//
		//
		// case 2632:
		// if (yyn == 2632)
		// /* Line 350 of lalr1.java */
		// /* Line 16234 of "sql_yacc.y" */
		// { /* $12 */
		// Lex->raw_trg_on_table_name_end= YYLIP->get_tok_start();
		// };
		// break;
		//
		//
		// case 2633:
		// if (yyn == 2633)
		// /* Line 350 of lalr1.java */
		// /* Line 16239 of "sql_yacc.y" */
		// { /* $15 */
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		// Lex_input_stream *lip= YYLIP;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_NO_RECURSIVE_CREATE, MYF(0), "TRIGGER");
		// return YYABORT;
		// }
		//
		// sp_head *sp= sp_start_parsing(thd, SP_TYPE_TRIGGER,
		// ((spname)(yystack.valueAt (14-(3)))));
		//
		// if (!sp)
		// return YYABORT;
		//
		// sp->m_trg_chistics.action_time= (enum trg_action_time_type)
		// ((num)(yystack.valueAt (14-(4))));
		// sp->m_trg_chistics.event= (enum trg_event_type)
		// ((num)(yystack.valueAt (14-(5))));
		// lex->stmt_definition_begin= ((simple_string)(yystack.valueAt
		// (14-(2))));
		// lex->ident.str= ((simple_string)(yystack.valueAt (14-(7))));
		// lex->ident.length= ((simple_string)(yystack.valueAt (14-(11)))) -
		// ((simple_string)(yystack.valueAt (14-(7))));
		//
		// lex->sphead= sp;
		// lex->spname= ((spname)(yystack.valueAt (14-(3))));
		//
		// memset(&lex->sp_chistics, 0, sizeof(st_sp_chistics));
		// sp->m_chistics= &lex->sp_chistics;
		// sp->set_body_start(thd, lip->get_cpp_ptr());
		// };
		// break;
		//
		//
		case 2634:
			if (yyn == 2634)
			/* Line 350 of lalr1.java */
			/* Line 16269 of "sql_yacc.y" */
			{ /* $17 */
				// THD *thd= YYTHD;
				// LEX *lex= Lex;
				// sp_head *sp= lex->sphead;
				//
				// sp_finish_parsing(thd);
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_TRIGGER;
				//
				// if (sp->is_not_allowed_in_function("trigger"))
				// return YYABORT;
				//
				// /*
				// We have to do it after parsing trigger body, because some of
				// sp_proc_stmt alternatives are not saving/restoring LEX, so
				// lex->query_tables can be wiped out.
				// */
				if (!MyParserProcessor.addTableToList(thd, (TableIdent) yystack.valueAt(16 - (9)), null, null))
					return YYABORT;
			}
			;
			break;

		case 2635:
			if (yyn == 2635)
			/* Line 350 of lalr1.java */
			/* Line 16304 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// if (is_native_function(thd, & ((lex_str)(yystack.valueAt
				// (8-(4))))))
				// {
				// my_error(ER_NATIVE_FCT_NAME_COLLISION, MYF(0),
				// ((lex_str)(yystack.valueAt (8-(4)))).str);
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_FUNCTION;
				// lex->udf.type= UDFTYPE_AGGREGATE;
				// lex->stmt_definition_begin= ((simple_string)(yystack.valueAt
				// (8-(2))));
				// lex->udf.name = ((lex_str)(yystack.valueAt (8-(4))));
				// lex->udf.returns=(Item_result) ((num)(yystack.valueAt
				// (8-(6))));
				// lex->udf.dl=((lex_str)(yystack.valueAt (8-(8)))).str;
			}
			;
			break;

		case 2636:
			if (yyn == 2636)
			/* Line 350 of lalr1.java */
			/* Line 16322 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// if (is_native_function(thd, & ((lex_str)(yystack.valueAt
				// (7-(3))))))
				// {
				// my_error(ER_NATIVE_FCT_NAME_COLLISION, MYF(0),
				// ((lex_str)(yystack.valueAt (7-(3)))).str);
				// return YYABORT;
				// }
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_FUNCTION;
				// lex->udf.type= UDFTYPE_FUNCTION;
				// lex->stmt_definition_begin= ((simple_string)(yystack.valueAt
				// (7-(1))));
				// lex->udf.name = ((lex_str)(yystack.valueAt (7-(3))));
				// lex->udf.returns=(Item_result) ((num)(yystack.valueAt
				// (7-(5))));
				// lex->udf.dl=((lex_str)(yystack.valueAt (7-(7)))).str;
			}
			;
			break;
		//
		//
		// case 2637:
		// if (yyn == 2637)
		// /* Line 350 of lalr1.java */
		// /* Line 16345 of "sql_yacc.y" */
		// { /* $5 */
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		//
		// lex->stmt_definition_begin= ((simple_string)(yystack.valueAt
		// (4-(1))));
		// lex->spname= ((spname)(yystack.valueAt (4-(3))));
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_NO_RECURSIVE_CREATE, MYF(0), "FUNCTION");
		// return YYABORT;
		// }
		//
		// sp_head *sp= sp_start_parsing(thd, SP_TYPE_FUNCTION, lex->spname);
		//
		// if (!sp)
		// return YYABORT;
		//
		// lex->sphead= sp;
		//
		// /*
		// NOTE: the start of the parameters in the query string is
		// YYLIP->get_cpp_tok_start() + 1. 1 is the length of '(', which the
		// tokenizer has just passed (just YYLIP->get_cpp_tok_start() points
		// to the '(').
		// */
		//
		// sp->m_parser_data.set_parameter_start_ptr(
		// YYLIP->get_cpp_tok_start() + 1);
		// };
		// break;
		//
		//
		// case 2638:
		// if (yyn == 2638)
		// /* Line 350 of lalr1.java */
		// /* Line 16377 of "sql_yacc.y" */
		// { /* $8 */
		// Lex->sphead->m_parser_data.set_parameter_end_ptr(
		// YYLIP->get_cpp_tok_start());
		// };
		// break;
		//
		//
		// case 2639:
		// if (yyn == 2639)
		// /* Line 350 of lalr1.java */
		// /* Line 16382 of "sql_yacc.y" */
		// { /* $10 */
		// LEX *lex= Lex;
		// lex->charset= NULL;
		// lex->length= lex->dec= NULL;
		// lex->interval_list.empty();
		// lex->type= 0;
		// };
		// break;
		//
		//
		// case 2640:
		// if (yyn == 2640)
		// /* Line 350 of lalr1.java */
		// /* Line 16390 of "sql_yacc.y" */
		// { /* $12 */
		// LEX *lex= Lex;
		// sp_head *sp= lex->sphead;
		// /*
		// This was disabled in 5.1.12. See bug #20701
		// When collation support in SP is implemented, then this test
		// should be removed.
		// */
		// if ((((num)(yystack.valueAt (11-(11)))) == MYSQL_TYPE_STRING ||
		// ((num)(yystack.valueAt (11-(11)))) == MYSQL_TYPE_VARCHAR)
		// && (lex->type & BINCMP_FLAG))
		// {
		// my_error(ER_NOT_SUPPORTED_YET, MYF(0), "return value collation");
		// return YYABORT;
		// }
		//
		// if (fill_field_definition(YYTHD, sp,
		// (enum enum_field_types) ((num)(yystack.valueAt (11-(11)))),
		// &sp->m_return_field_def))
		// return YYABORT;
		//
		// memset(&lex->sp_chistics, 0, sizeof(st_sp_chistics));
		// };
		// break;
		//
		//
		// case 2641:
		// if (yyn == 2641)
		// /* Line 350 of lalr1.java */
		// /* Line 16413 of "sql_yacc.y" */
		// { /* $14 */
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		//
		// lex->sphead->m_chistics= &lex->sp_chistics;
		// lex->sphead->set_body_start(thd, YYLIP->get_cpp_tok_start());
		// };
		// break;

		case 2642:
			if (yyn == 2642)
			/* Line 350 of lalr1.java */
			/* Line 16421 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= thd->lex;
				// sp_head *sp= lex->sphead;
				//
				// if (sp->is_not_allowed_in_function("function"))
				// return YYABORT;
				//
				// sp_finish_parsing(thd);
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_SPFUNCTION;
				//
				// if (!(sp->m_flags & sp_head::HAS_RETURN))
				// {
				// my_error(ER_SP_NORETURN, MYF(0), sp->m_qname.str);
				// return YYABORT;
				// }
				//
				// if (is_native_function(thd, & sp->m_name))
				// {
				// /*
				// This warning will be printed when
				// [1] A client query is parsed,
				// [2] A stored function is loaded by db_load_routine.
				// Printing the warning for [2] is intentional, to cover the
				// following scenario:
				// - A user define a SF 'foo' using MySQL 5.N
				// - An application uses select foo(), and works.
				// - MySQL 5.{N+1} defines a new native function 'foo', as
				// part of a new feature.
				// - MySQL 5.{N+1} documentation is updated, and should mention
				// that there is a potential incompatible change in case of
				// existing stored function named 'foo'.
				// - The user deploys 5.{N+1}. At this point, 'select foo()'
				// means something different, and the user code is most likely
				// broken (it's only safe if the code is 'select db.foo()').
				// With a warning printed when the SF is loaded (which has to
				// occur
				// before the call), the warning will provide a hint explaining
				// the root cause of a later failure of 'select foo()'.
				// With no warning printed, the user code will fail with no
				// apparent reason.
				// Printing a warning each time db_load_routine is executed for
				// an ambiguous function is annoying, since that can happen a
				// lot,
				// but in practice should not happen unless there *are* name
				// collisions.
				// If a collision exists, it should not be silenced but fixed.
				// */
				// push_warning_printf(thd,
				// Sql_condition::WARN_LEVEL_NOTE,
				// ER_NATIVE_FCT_NAME_COLLISION,
				// ER(ER_NATIVE_FCT_NAME_COLLISION),
				// sp->m_name.str);
				// }
			}
			;
			break;
		//
		//
		// case 2643:
		// if (yyn == 2643)
		// /* Line 350 of lalr1.java */
		// /* Line 16479 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= Lex;
		//
		// if (lex->sphead)
		// {
		// my_error(ER_SP_NO_RECURSIVE_CREATE, MYF(0), "PROCEDURE");
		// return YYABORT;
		// }
		//
		// lex->stmt_definition_begin= ((simple_string)(yystack.valueAt
		// (3-(2))));
		//
		// sp_head *sp= sp_start_parsing(thd, SP_TYPE_PROCEDURE,
		// ((spname)(yystack.valueAt (3-(3)))));
		//
		// if (!sp)
		// return YYABORT;
		//
		// lex->sphead= sp;
		// };
		// break;
		//
		//
		// case 2644:
		// if (yyn == 2644)
		// /* Line 350 of lalr1.java */
		// /* Line 16499 of "sql_yacc.y" */
		// {
		// /*
		// NOTE: the start of the parameters in the query string is
		// YYLIP->get_cpp_tok_start() + 1. 1 is the length of '(', which the
		// tokenizer has just passed (just YYLIP->get_cpp_tok_start() points
		// to the '(').
		// */
		//
		// Lex->sphead->m_parser_data.set_parameter_start_ptr(
		// YYLIP->get_cpp_tok_start() + 1);
		// };
		// break;
		//
		//
		// case 2645:
		// if (yyn == 2645)
		// /* Line 350 of lalr1.java */
		// /* Line 16512 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		//
		// Lex->sphead->m_parser_data.set_parameter_end_ptr(
		// YYLIP->get_cpp_tok_start());
		//
		// memset(&lex->sp_chistics, 0, sizeof(st_sp_chistics));
		// };
		// break;
		//
		//
		// case 2646:
		// if (yyn == 2646)
		// /* Line 350 of lalr1.java */
		// /* Line 16522 of "sql_yacc.y" */
		// {
		// THD *thd= YYTHD;
		// LEX *lex= thd->lex;
		//
		// lex->sphead->m_chistics= &lex->sp_chistics;
		// lex->sphead->set_body_start(thd, YYLIP->get_cpp_tok_start());
		// };
		// break;

		case 2647:
			if (yyn == 2647)
			/* Line 350 of lalr1.java */
			/* Line 16530 of "sql_yacc.y" */
			{
				// THD *thd= YYTHD;
				// LEX *lex= Lex;
				//
				// sp_finish_parsing(thd);
				//
				thd.lex.sqlCommand = SQLCommand.SQLCOM_CREATE_PROCEDURE;
			}
			;
			break;

		case 2648:
			if (yyn == 2648)
			/* Line 350 of lalr1.java */
			/* Line 16544 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_XA_START;
			}
			;
			break;

		case 2649:
			if (yyn == 2649)
			/* Line 350 of lalr1.java */
			/* Line 16548 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_XA_END;
			}
			;
			break;

		case 2650:
			if (yyn == 2650)
			/* Line 350 of lalr1.java */
			/* Line 16552 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_XA_PREPARE;
			}
			;
			break;

		case 2651:
			if (yyn == 2651)
			/* Line 350 of lalr1.java */
			/* Line 16556 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_XA_COMMIT;
			}
			;
			break;

		case 2652:
			if (yyn == 2652)
			/* Line 350 of lalr1.java */
			/* Line 16560 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_XA_ROLLBACK;
			}
			;
			break;

		case 2653:
			if (yyn == 2653)
			/* Line 350 of lalr1.java */
			/* Line 16564 of "sql_yacc.y" */
			{
				thd.lex.sqlCommand = SQLCommand.SQLCOM_XA_RECOVER;
			}
			;
			break;
		//
		//
		// case 2654:
		// if (yyn == 2654)
		// /* Line 350 of lalr1.java */
		// /* Line 16571 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((string)(yystack.valueAt (1-(1))))->length()
		// <=
		// MAXGTRIDSIZE);
		// if (!(Lex->xid=(XID *)YYTHD->alloc(sizeof(XID))))
		// return YYABORT;
		// Lex->xid->set(1L, ((string)(yystack.valueAt (1-(1))))->ptr(),
		// ((string)(yystack.valueAt (1-(1))))->length(), 0, 0);
		// };
		// break;
		//
		//
		// case 2655:
		// if (yyn == 2655)
		// /* Line 350 of lalr1.java */
		// /* Line 16578 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((string)(yystack.valueAt (3-(1))))->length()
		// <=
		// MAXGTRIDSIZE && ((string)(yystack.valueAt (3-(3))))->length() <=
		// MAXBQUALSIZE);
		// if (!(Lex->xid=(XID *)YYTHD->alloc(sizeof(XID))))
		// return YYABORT;
		// Lex->xid->set(1L, ((string)(yystack.valueAt (3-(1))))->ptr(),
		// ((string)(yystack.valueAt (3-(1))))->length(),
		// ((string)(yystack.valueAt (3-(3))))->ptr(), ((string)(yystack.valueAt
		// (3-(3))))->length());
		// };
		// break;
		//
		//
		// case 2656:
		// if (yyn == 2656)
		// /* Line 350 of lalr1.java */
		// /* Line 16585 of "sql_yacc.y" */
		// {
		// return YYABORT;_UNLESS(((string)(yystack.valueAt (5-(1))))->length()
		// <=
		// MAXGTRIDSIZE && ((string)(yystack.valueAt (5-(3))))->length() <=
		// MAXBQUALSIZE);
		// if (!(Lex->xid=(XID *)YYTHD->alloc(sizeof(XID))))
		// return YYABORT;
		// Lex->xid->set(((ulong_num)(yystack.valueAt (5-(5)))),
		// ((string)(yystack.valueAt (5-(1))))->ptr(), ((string)(yystack.valueAt
		// (5-(1))))->length(), ((string)(yystack.valueAt (5-(3))))->ptr(),
		// ((string)(yystack.valueAt (5-(3))))->length());
		// };
		// break;
		//
		//
		// case 2657:
		// if (yyn == 2657)
		// /* Line 350 of lalr1.java */
		// /* Line 16594 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2658:
		// if (yyn == 2658)
		// /* Line 350 of lalr1.java */
		// /* Line 16595 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2659:
		// if (yyn == 2659)
		// /* Line 350 of lalr1.java */
		// /* Line 16599 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_NONE; };
		// break;
		//
		//
		// case 2660:
		// if (yyn == 2660)
		// /* Line 350 of lalr1.java */
		// /* Line 16600 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_JOIN; };
		// break;
		//
		//
		// case 2661:
		// if (yyn == 2661)
		// /* Line 350 of lalr1.java */
		// /* Line 16601 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_RESUME; };
		// break;
		//
		//
		// case 2662:
		// if (yyn == 2662)
		// /* Line 350 of lalr1.java */
		// /* Line 16605 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_NONE; };
		// break;
		//
		//
		// case 2663:
		// if (yyn == 2663)
		// /* Line 350 of lalr1.java */
		// /* Line 16606 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_ONE_PHASE; };
		// break;
		//
		//
		// case 2664:
		// if (yyn == 2664)
		// /* Line 350 of lalr1.java */
		// /* Line 16611 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_NONE; };
		// break;
		//
		//
		// case 2665:
		// if (yyn == 2665)
		// /* Line 350 of lalr1.java */
		// /* Line 16613 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_SUSPEND; };
		// break;
		//
		//
		// case 2667:
		// if (yyn == 2667)
		// /* Line 350 of lalr1.java */
		// /* Line 16618 of "sql_yacc.y" */
		// {};
		// break;
		//
		//
		// case 2668:
		// if (yyn == 2668)
		// /* Line 350 of lalr1.java */
		// /* Line 16619 of "sql_yacc.y" */
		// { Lex->xa_opt=XA_FOR_MIGRATE; };
		// break;

		case 2669:
			if (yyn == 2669)
			/* Line 350 of lalr1.java */
			/* Line 16624 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_INSTALL_PLUGIN;
				// lex->comment= ((lex_str)(yystack.valueAt (5-(3))));
				// lex->ident= ((lex_str)(yystack.valueAt (5-(5))));
			}
			;
			break;

		case 2670:
			if (yyn == 2670)
			/* Line 350 of lalr1.java */
			/* Line 16634 of "sql_yacc.y" */
			{
				// LEX *lex= Lex;
				thd.lex.sqlCommand = SQLCommand.SQLCOM_UNINSTALL_PLUGIN;
				// lex->comment= ((lex_str)(yystack.valueAt (3-(3))));
			}
			;
			break;
		//
		//
		//
		// /* Line 350 of lalr1.java */
		// /* Line 28191 of "sql_yacc.java" */
		default:
			break;
		}

		yy_symbol_print("-> $$ =", yyr1_[yyn], yyval);

		yystack.pop(yylen);
		yylen = 0;

		/* Shift the result of the reduction. */
		yyn = yyr1_[yyn];
		int yystate = yypgoto_[yyn - yyntokens_] + yystack.stateAt(0);
		if (0 <= yystate && yystate <= yylast_ && yycheck_[yystate] == yystack.stateAt(0))
			yystate = yytable_[yystate];
		else
			yystate = yydefgoto_[yyn - yyntokens_];

		yystack.push(yystate, yyval);
		return YYNEWSTATE;
	}

	/*
	 * Return YYSTR after stripping away unnecessary quotes and backslashes, so
	 * that it's suitable for yyerror. The heuristic is that double-quoting is
	 * unnecessary unless the string contains an apostrophe, a comma, or
	 * backslash (other than backslash-backslash). YYSTR is taken from yytname.
	 */
	private final String yytnamerr_(String yystr) {
		if (yystr.charAt(0) == '"') {
			StringBuffer yyr = new StringBuffer();
			strip_quotes: for (int i = 1; i < yystr.length(); i++)
				switch (yystr.charAt(i)) {
				case '\'':
				case ',':
					break strip_quotes;

				case '\\':
					if (yystr.charAt(++i) != '\\')
						break strip_quotes;
					/* Fall through. */
				default:
					yyr.append(yystr.charAt(i));
					break;

				case '"':
					return yyr.toString();
				}
		} else if (yystr.equals("$end"))
			return "end of input";

		return yystr;
	}

	/*--------------------------------.
	| Print this symbol on YYOUTPUT.  |
	`--------------------------------*/

	private void yy_symbol_print(String s, int yytype, Object yyvaluep) {
		if (yydebug > 0)
			yycdebug(s + (yytype < yyntokens_ ? " token " : " nterm ") + yytname_[yytype] + " ("
					+ (yyvaluep == null ? "(null)" : yyvaluep.toString()) + ")");
	}

	/**
	 * Parse input from the scanner that was specified at object construction
	 * time. Return whether the end of the input was reached successfully.
	 *
	 * @return <tt>true</tt> if the parsing succeeds. Note that this does not
	 *         imply that there were no syntax errors.
	 */
	public boolean parse(SQLThread thd) {
		/// Lookahead and lookahead in internal form.
		int yychar = yyempty_;
		int yytoken = 0;

		/* State. */
		int yyn = 0;
		int yylen = 0;
		int yystate = 0;

		YYStack yystack = new YYStack();

		/* Error handling. */
		int yynerrs_ = 0;

		/// Semantic value of the lookahead.
		Object yylval = null;

		yycdebug("Starting parse\n");
		thd.yyerrstatus_ = 0;

		/* Initialize the stack. */
		yystack.push(yystate, yylval);

		int label = YYNEWSTATE;
		for (;;)
			switch (label) {
			/*
			 * New state. Unlike in the C/C++ skeletons, the state is already
			 * pushed when we come here.
			 */
			case YYNEWSTATE:
				yycdebug("Entering state " + yystate + "\n");
				if (yydebug > 0)
					yystack.print(yyDebugStream);

				/* Accept? */
				if (yystate == yyfinal_)
					return true;

				/* Take a decision. First try without lookahead. */
				yyn = yypact_[yystate];
				if (yy_pact_value_is_default_(yyn)) {
					label = YYDEFAULT;
					break;
				}

				/* Read a lookahead token. */
				if (yychar == yyempty_) {
					yycdebug("Reading a token: ");
					yychar = yylex(thd);
					// System.out.println(LexInputStreamProcessor.getTokenString(yychar));
					// System.out.println(yychar);

					yylval = myLexer.getLVal(thd);
				}

				/* Convert token to internal form. */
				if (yychar <= EOF) {
					yychar = yytoken = EOF;
					yycdebug("Now at end of input.\n");
				} else {
					yytoken = yytranslate_(yychar);
					yy_symbol_print("Next token is", yytoken, yylval);
				}

				/*
				 * If the proper action on seeing token YYTOKEN is to reduce or
				 * to detect an error, take that action.
				 */
				yyn += yytoken;
				if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
					label = YYDEFAULT;

				/* <= 0 means reduce or error. */
				else if ((yyn = yytable_[yyn]) <= 0) {
					if (yy_table_value_is_error_(yyn))
						label = YYERRLAB;
					else {
						yyn = -yyn;
						label = YYREDUCE;
					}
				}

				else {
					/* Shift the lookahead token. */
					yy_symbol_print("Shifting", yytoken, yylval);

					/* Discard the token being shifted. */
					yychar = yyempty_;

					/*
					 * Count tokens shifted since error; after three, turn off
					 * error status.
					 */
					if (thd.yyerrstatus_ > 0)
						--thd.yyerrstatus_;

					yystate = yyn;
					yystack.push(yystate, yylval);
					label = YYNEWSTATE;
				}
				break;

			/*-----------------------------------------------------------.
			| yydefault -- do the default action for the current state.  |
			`-----------------------------------------------------------*/
			case YYDEFAULT:
				yyn = yydefact_[yystate];
				if (yyn == 0)
					label = YYERRLAB;
				else
					label = YYREDUCE;
				break;

			/*-----------------------------.
			| yyreduce -- Do a reduction.  |
			`-----------------------------*/
			case YYREDUCE:
				yylen = yyr2_[yyn];
				label = yyaction(yyn, yystack, yylen, thd);
				yystate = yystack.stateAt(0);
				break;

			/*------------------------------------.
			| yyerrlab -- here on detecting error |
			`------------------------------------*/
			case YYERRLAB:
				/*
				 * If not already recovering from an error, report this error.
				 */
				if (thd.yyerrstatus_ == 0) {
					++yynerrs_;
					if (yychar == yyempty_)
						yytoken = yyempty_;
					yyerror(yysyntax_error(yystate, yytoken), thd);
				}

				if (thd.yyerrstatus_ == 3) {
					/*
					 * If just tried and failed to reuse lookahead token after
					 * an error, discard it.
					 */

					if (yychar <= EOF) {
						/* Return failure if at end of input. */
						if (yychar == EOF)
							return false;
					} else
						yychar = yyempty_;
				}

				/*
				 * Else will try to reuse lookahead token after shifting the
				 * error token.
				 */
				label = YYERRLAB1;
				break;

			/*---------------------------------------------------.
			| errorlab -- error raised explicitly by YYERROR.  |
			`---------------------------------------------------*/
			case YYERROR:

				/*
				 * Do not reclaim the symbols of the rule which action triggered
				 * this YYERROR.
				 */
				yystack.pop(yylen);
				yylen = 0;
				yystate = yystack.stateAt(0);
				label = YYERRLAB1;
				break;

			/*-------------------------------------------------------------.
			| yyerrlab1 -- common code for both syntax error and YYERROR.  |
			`-------------------------------------------------------------*/
			case YYERRLAB1:
				thd.yyerrstatus_ = 3; /* Each real token shifted decrements this. */

				for (;;) {
					yyn = yypact_[yystate];
					if (!yy_pact_value_is_default_(yyn)) {
						yyn += yyterror_;
						if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_) {
							yyn = yytable_[yyn];
							if (0 < yyn)
								break;
						}
					}

					/*
					 * Pop the current state because it cannot handle the error
					 * token.
					 */
					if (yystack.height == 0)
						return false;

					yystack.pop();
					yystate = yystack.stateAt(0);
					if (yydebug > 0)
						yystack.print(yyDebugStream);
				}

				/* Shift the error token. */
				yy_symbol_print("Shifting", yystos_[yyn], yylval);

				yystate = yyn;
				yystack.push(yyn, yylval);
				label = YYNEWSTATE;
				break;

			/* Accept. */
			case YYACCEPT:
				return true;

			/* Abort. */
			case YYABORT:
				return false;
			}
	}

	// Generate an error message.
	private String yysyntax_error(int yystate, int tok) {
		if (errorVerbose) {
			/*
			 * There are many possibilities here to consider: - Assume YYFAIL is
			 * not used. It's too flawed to consider. See
			 * <http://lists.gnu.org/archive/html/bison-patches/2009-12/msg00024
			 * .html> for details. YYERROR is fine as it does not invoke this
			 * function. - If this state is a consistent state with a default
			 * action, then the only way this function was invoked is if the
			 * default action is an error action. In that case, don't check for
			 * expected tokens because there are none. - The only way there can
			 * be no lookahead present (in tok) is if this state is a consistent
			 * state with a default action. Thus, detecting the absence of a
			 * lookahead is sufficient to determine that there is no unexpected
			 * or expected token to report. In that case, just report a simple
			 * "syntax error". - Don't assume there isn't a lookahead just
			 * because this state is a consistent state with a default action.
			 * There might have been a previous inconsistent state, consistent
			 * state with a non-default action, or user semantic action that
			 * manipulated yychar. (However, yychar is currently out of scope
			 * during semantic actions.) - Of course, the expected token list
			 * depends on states to have correct lookahead information, and it
			 * depends on the parser not to perform extra reductions after
			 * fetching a lookahead from the scanner and before detecting a
			 * syntax error. Thus, state merging (from LALR or IELR) and default
			 * reductions corrupt the expected token list. However, the list is
			 * correct for canonical LR with one exception: it will still
			 * contain any token that will not be accepted due to an error
			 * action in a later state.
			 */
			if (tok != yyempty_) {
				// FIXME: This method of building the message is not compatible
				// with internationalization.
				StringBuffer res = new StringBuffer("syntax error, unexpected ");
				res.append(yytnamerr_(yytname_[tok]));
				int yyn = yypact_[yystate];
				if (!yy_pact_value_is_default_(yyn)) {
					/*
					 * Start YYX at -YYN if negative to avoid negative indexes
					 * in YYCHECK. In other words, skip the first -YYN actions
					 * for this state because they are default actions.
					 */
					int yyxbegin = yyn < 0 ? -yyn : 0;
					/* Stay within bounds of both yycheck and yytname. */
					int yychecklim = yylast_ - yyn + 1;
					int yyxend = yychecklim < yyntokens_ ? yychecklim : yyntokens_;
					int count = 0;
					for (int x = yyxbegin; x < yyxend; ++x)
						if (yycheck_[x + yyn] == x && x != yyterror_ && !yy_table_value_is_error_(yytable_[x + yyn]))
							++count;
					if (count < 5) {
						count = 0;
						for (int x = yyxbegin; x < yyxend; ++x) {
							if (yycheck_[x + yyn] == x && x != yyterror_ && !yy_table_value_is_error_(yytable_[x + yyn])) {
								res.append(count++ == 0 ? ", expecting " : " or ");
								res.append(yytnamerr_(yytname_[x]));
							}
						}
					}
				}
				return res.toString();
			}
		}

		return "syntax error";
	}

	/**
	 * Whether the given <code>yypact_</code> value indicates a defaulted state.
	 * 
	 * @param yyvalue
	 *            the value to check
	 */
	private static boolean yy_pact_value_is_default_(int yyvalue) {
		return yyvalue == yypact_ninf_;
	}

	/**
	 * Whether the given <code>yytable_</code> value indicates a syntax error.
	 * 
	 * @param yyvalue
	 *            the value to check
	 */
	private static boolean yy_table_value_is_error_(int yyvalue) {
		return yyvalue == yytable_ninf_;
	}

	/*
	 * YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
	 * STATE-NUM.
	 */
	private static final int yypact_ninf_ = -3874;
	private static Integer yypact_[];

	/*
	 * YYDEFACT[S] -- default reduction number in state S. Performed when
	 * YYTABLE doesn't specify something else to do. Zero means the default is
	 * an error.
	 */
	private static Short yydefact_[];

	/* YYPGOTO[NTERM-NUM]. */
	private static Short yypgoto_[];

	/* YYDEFGOTO[NTERM-NUM]. */
	private static Short yydefgoto_[];

	/*
	 * YYTABLE[YYPACT[STATE-NUM]]. What to do in state STATE-NUM. If positive,
	 * shift that token. If negative, reduce the rule which number is the
	 * opposite. If YYTABLE_NINF_, syntax error.
	 */
	private static final short yytable_ninf_ = -2610;
	private static Short yytable_[];

	/* YYCHECK. */
	private static Short yycheck_[];

	/*
	 * STOS_[STATE-NUM] -- The (internal number of the) accessing symbol of
	 * state STATE-NUM.
	 */
	private static Short yystos_[];

	/*
	 * TOKEN_NUMBER_[YYLEX-NUM] -- Internal symbol number corresponding to
	 * YYLEX-NUM.
	 */
	private static Short yytoken_number_[];

	/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives. */
	private static Short yyr1_[];

	/* YYR2[YYN] -- Number of symbols composing right hand side of rule YYN. */
	private static Byte yyr2_[];

	/*
	 * YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM. First, the
	 * terminals, then, starting at \a yyntokens_, nonterminals.
	 */
	private static String yytname_[];

	/* YYRHS -- A `-1'-separated list of the rules' RHS. */
	private static Short yyrhs_[];

	/*
	 * YYPRHS[YYN] -- Index of the first RHS symbol of rule number YYN in YYRHS.
	 */
	private static Short yyprhs_[];

	/* YYRLINE[YYN] -- Source line where rule number YYN was defined. */
	private static Short yyrline_[];

	// Report on the debug stream that the rule yyrule is going to be reduced.
	private void yy_reduce_print(int yyrule, YYStack yystack) {
		if (yydebug == 0)
			return;

		int yylno = yyrline_[yyrule];
		int yynrhs = yyr2_[yyrule];
		/* Print the symbols being reduced, and their result. */
		yycdebug("Reducing stack by rule " + (yyrule - 1) + " (line " + yylno + "), ");

		/* The symbols being reduced. */
		for (int yyi = 0; yyi < yynrhs; yyi++)
			yy_symbol_print("   $" + (yyi + 1) + " =", yyrhs_[yyprhs_[yyrule] + yyi], ((yystack.valueAt(yynrhs - (yyi + 1)))));
	}

	/* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX. */
	private static Short yytranslate_table_[];

	private static final Short yytranslate_(int t) {
		if (t >= 0 && t <= yyuser_token_number_max_)
			return yytranslate_table_[t];
		else
			return yyundef_token_;
	}

	private static final int yylast_ = 55552;
	private static final int yynnts_ = 952;
	private static final int yyempty_ = -2;
	private static final int yyfinal_ = 597;
	private static final int yyterror_ = 1;
	private static final int yyerrcode_ = 256;
	private static final int yyntokens_ = 640;

	private static final int yyuser_token_number_max_ = 875;
	private static final int yyundef_token_ = 2;

	/* User implementation code. */
	private boolean addCreateIndexPrepare(Lex lex, TableIdent table) {
		lex.sqlCommand = SQLCommand.SQLCOM_CREATE_INDEX;
		if (MyParserProcessor.addTableToList(lex, table, null, null)) {
			return true;
		} else {
			return false;
		}
//	  lex->sql_command= SQLCOM_CREATE_INDEX;
//	  if (!lex->current_select->add_table_to_list(lex->thd, table, NULL,
//	                                              TL_OPTION_UPDATING,
//	                                              TL_READ_NO_INSERT,
//	                                              MDL_SHARED_UPGRADABLE))
//	    return TRUE;
//	  lex->alter_info.reset();
//	  lex->alter_info.flags= Alter_info::ALTER_ADD_INDEX;
//	  lex->col_list.empty();
//	  lex->change= NullS;
//	  return FALSE;
	}
}
