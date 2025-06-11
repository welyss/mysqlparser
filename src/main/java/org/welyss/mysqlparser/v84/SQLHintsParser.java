/* A Bison parser, made by GNU Bison 3.8.1.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

/* First part of user prologue.  */
/* "sql_hints.y":29  */

package org.welyss.mysqlparser.v84;

import java.util.List;

/**
 * A Bison parser, automatically generated from <tt>sql_hints.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class SQLHintsParser {
	/** Version number for the Bison executable that generated this parser. */
	public static final String bisonVersion = "3.8.1";

	/** Name of the skeleton that generated this parser. */
	public static final String bisonSkeleton = "lalr1.java";

	public enum SymbolKind {
		S_YYEOF(0), /* "end of file" */
		S_YYerror(1), /* error */
		S_YYUNDEF(2), /* "invalid token" */
		S_MAX_EXECUTION_TIME_HINT(3), /* MAX_EXECUTION_TIME_HINT */
		S_RESOURCE_GROUP_HINT(4), /* RESOURCE_GROUP_HINT */
		S_BKA_HINT(5), /* BKA_HINT */
		S_BNL_HINT(6), /* BNL_HINT */
		S_DUPSWEEDOUT_HINT(7), /* DUPSWEEDOUT_HINT */
		S_FIRSTMATCH_HINT(8), /* FIRSTMATCH_HINT */
		S_INTOEXISTS_HINT(9), /* INTOEXISTS_HINT */
		S_LOOSESCAN_HINT(10), /* LOOSESCAN_HINT */
		S_MATERIALIZATION_HINT(11), /* MATERIALIZATION_HINT */
		S_NO_BKA_HINT(12), /* NO_BKA_HINT */
		S_NO_BNL_HINT(13), /* NO_BNL_HINT */
		S_NO_ICP_HINT(14), /* NO_ICP_HINT */
		S_NO_MRR_HINT(15), /* NO_MRR_HINT */
		S_NO_RANGE_OPTIMIZATION_HINT(16), /* NO_RANGE_OPTIMIZATION_HINT */
		S_NO_SEMIJOIN_HINT(17), /* NO_SEMIJOIN_HINT */
		S_MRR_HINT(18), /* MRR_HINT */
		S_QB_NAME_HINT(19), /* QB_NAME_HINT */
		S_SEMIJOIN_HINT(20), /* SEMIJOIN_HINT */
		S_SUBQUERY_HINT(21), /* SUBQUERY_HINT */
		S_DERIVED_MERGE_HINT(22), /* DERIVED_MERGE_HINT */
		S_NO_DERIVED_MERGE_HINT(23), /* NO_DERIVED_MERGE_HINT */
		S_JOIN_PREFIX_HINT(24), /* JOIN_PREFIX_HINT */
		S_JOIN_SUFFIX_HINT(25), /* JOIN_SUFFIX_HINT */
		S_JOIN_ORDER_HINT(26), /* JOIN_ORDER_HINT */
		S_JOIN_FIXED_ORDER_HINT(27), /* JOIN_FIXED_ORDER_HINT */
		S_INDEX_MERGE_HINT(28), /* INDEX_MERGE_HINT */
		S_NO_INDEX_MERGE_HINT(29), /* NO_INDEX_MERGE_HINT */
		S_SET_VAR_HINT(30), /* SET_VAR_HINT */
		S_SKIP_SCAN_HINT(31), /* SKIP_SCAN_HINT */
		S_NO_SKIP_SCAN_HINT(32), /* NO_SKIP_SCAN_HINT */
		S_HASH_JOIN_HINT(33), /* HASH_JOIN_HINT */
		S_NO_HASH_JOIN_HINT(34), /* NO_HASH_JOIN_HINT */
		S_HINT_ARG_NUMBER(35), /* HINT_ARG_NUMBER */
		S_HINT_ARG_IDENT(36), /* HINT_ARG_IDENT */
		S_HINT_ARG_QB_NAME(37), /* HINT_ARG_QB_NAME */
		S_HINT_ARG_TEXT(38), /* HINT_ARG_TEXT */
		S_HINT_IDENT_OR_NUMBER_WITH_SCALE(39), /* HINT_IDENT_OR_NUMBER_WITH_SCALE */
		S_HINT_CLOSE(40), /* HINT_CLOSE */
		S_HINT_ERROR(41), /* HINT_ERROR */
		S_INDEX_HINT(42), /* INDEX_HINT */
		S_NO_INDEX_HINT(43), /* NO_INDEX_HINT */
		S_JOIN_INDEX_HINT(44), /* JOIN_INDEX_HINT */
		S_NO_JOIN_INDEX_HINT(45), /* NO_JOIN_INDEX_HINT */
		S_GROUP_INDEX_HINT(46), /* GROUP_INDEX_HINT */
		S_NO_GROUP_INDEX_HINT(47), /* NO_GROUP_INDEX_HINT */
		S_ORDER_INDEX_HINT(48), /* ORDER_INDEX_HINT */
		S_NO_ORDER_INDEX_HINT(49), /* NO_ORDER_INDEX_HINT */
		S_DERIVED_CONDITION_PUSHDOWN_HINT(50), /* DERIVED_CONDITION_PUSHDOWN_HINT */
		S_NO_DERIVED_CONDITION_PUSHDOWN_HINT(51), /* NO_DERIVED_CONDITION_PUSHDOWN_HINT */
		S_HINT_ARG_FLOATING_POINT_NUMBER(52), /* HINT_ARG_FLOATING_POINT_NUMBER */
		S_53_(53), /* '(' */
		S_54_(54), /* ')' */
		S_55_(55), /* ',' */
		S_56_(56), /* '=' */
		S_YYACCEPT(57), /* $accept */
		S_start(58), /* start */
		S_hint_list(59), /* hint_list */
		S_hint(60), /* hint */
		S_max_execution_time_hint(61), /* max_execution_time_hint */
		S_opt_hint_param_table_list(62), /* opt_hint_param_table_list */
		S_hint_param_table_list(63), /* hint_param_table_list */
		S_opt_hint_param_table_list_empty_qb(64), /* opt_hint_param_table_list_empty_qb */
		S_hint_param_table_list_empty_qb(65), /* hint_param_table_list_empty_qb */
		S_opt_hint_param_index_list(66), /* opt_hint_param_index_list */
		S_hint_param_index_list(67), /* hint_param_index_list */
		S_hint_param_index(68), /* hint_param_index */
		S_hint_param_table_empty_qb(69), /* hint_param_table_empty_qb */
		S_hint_param_table(70), /* hint_param_table */
		S_hint_param_table_ext(71), /* hint_param_table_ext */
		S_opt_qb_name(72), /* opt_qb_name */
		S_qb_level_hint(73), /* qb_level_hint */
		S_semijoin_strategies(74), /* semijoin_strategies */
		S_semijoin_strategy(75), /* semijoin_strategy */
		S_subquery_strategy(76), /* subquery_strategy */
		S_table_level_hint(77), /* table_level_hint */
		S_index_level_hint(78), /* index_level_hint */
		S_table_level_hint_type_on(79), /* table_level_hint_type_on */
		S_table_level_hint_type_off(80), /* table_level_hint_type_off */
		S_key_level_hint_type_on(81), /* key_level_hint_type_on */
		S_key_level_hint_type_off(82), /* key_level_hint_type_off */
		S_qb_name_hint(83), /* qb_name_hint */
		S_set_var_hint(84), /* set_var_hint */
		S_resource_group_hint(85), /* resource_group_hint */
		S_set_var_ident(86), /* set_var_ident */
		S_set_var_num_item(87), /* set_var_num_item */
		S_set_var_text_value(88), /* set_var_text_value */
		S_set_var_string_item(89), /* set_var_string_item */
		S_set_var_arg(90); /* set_var_arg */

		private final int yycode_;

		SymbolKind(int n) {
			this.yycode_ = n;
		}

		private static final SymbolKind[] values_ = { SymbolKind.S_YYEOF, SymbolKind.S_YYerror, SymbolKind.S_YYUNDEF, SymbolKind.S_MAX_EXECUTION_TIME_HINT, SymbolKind.S_RESOURCE_GROUP_HINT,
				SymbolKind.S_BKA_HINT, SymbolKind.S_BNL_HINT, SymbolKind.S_DUPSWEEDOUT_HINT, SymbolKind.S_FIRSTMATCH_HINT, SymbolKind.S_INTOEXISTS_HINT, SymbolKind.S_LOOSESCAN_HINT,
				SymbolKind.S_MATERIALIZATION_HINT, SymbolKind.S_NO_BKA_HINT, SymbolKind.S_NO_BNL_HINT, SymbolKind.S_NO_ICP_HINT, SymbolKind.S_NO_MRR_HINT, SymbolKind.S_NO_RANGE_OPTIMIZATION_HINT,
				SymbolKind.S_NO_SEMIJOIN_HINT, SymbolKind.S_MRR_HINT, SymbolKind.S_QB_NAME_HINT, SymbolKind.S_SEMIJOIN_HINT, SymbolKind.S_SUBQUERY_HINT, SymbolKind.S_DERIVED_MERGE_HINT,
				SymbolKind.S_NO_DERIVED_MERGE_HINT, SymbolKind.S_JOIN_PREFIX_HINT, SymbolKind.S_JOIN_SUFFIX_HINT, SymbolKind.S_JOIN_ORDER_HINT, SymbolKind.S_JOIN_FIXED_ORDER_HINT,
				SymbolKind.S_INDEX_MERGE_HINT, SymbolKind.S_NO_INDEX_MERGE_HINT, SymbolKind.S_SET_VAR_HINT, SymbolKind.S_SKIP_SCAN_HINT, SymbolKind.S_NO_SKIP_SCAN_HINT, SymbolKind.S_HASH_JOIN_HINT,
				SymbolKind.S_NO_HASH_JOIN_HINT, SymbolKind.S_HINT_ARG_NUMBER, SymbolKind.S_HINT_ARG_IDENT, SymbolKind.S_HINT_ARG_QB_NAME, SymbolKind.S_HINT_ARG_TEXT,
				SymbolKind.S_HINT_IDENT_OR_NUMBER_WITH_SCALE, SymbolKind.S_HINT_CLOSE, SymbolKind.S_HINT_ERROR, SymbolKind.S_INDEX_HINT, SymbolKind.S_NO_INDEX_HINT, SymbolKind.S_JOIN_INDEX_HINT,
				SymbolKind.S_NO_JOIN_INDEX_HINT, SymbolKind.S_GROUP_INDEX_HINT, SymbolKind.S_NO_GROUP_INDEX_HINT, SymbolKind.S_ORDER_INDEX_HINT, SymbolKind.S_NO_ORDER_INDEX_HINT,
				SymbolKind.S_DERIVED_CONDITION_PUSHDOWN_HINT, SymbolKind.S_NO_DERIVED_CONDITION_PUSHDOWN_HINT, SymbolKind.S_HINT_ARG_FLOATING_POINT_NUMBER, SymbolKind.S_53_, SymbolKind.S_54_,
				SymbolKind.S_55_, SymbolKind.S_56_, SymbolKind.S_YYACCEPT, SymbolKind.S_start, SymbolKind.S_hint_list, SymbolKind.S_hint, SymbolKind.S_max_execution_time_hint,
				SymbolKind.S_opt_hint_param_table_list, SymbolKind.S_hint_param_table_list, SymbolKind.S_opt_hint_param_table_list_empty_qb, SymbolKind.S_hint_param_table_list_empty_qb,
				SymbolKind.S_opt_hint_param_index_list, SymbolKind.S_hint_param_index_list, SymbolKind.S_hint_param_index, SymbolKind.S_hint_param_table_empty_qb, SymbolKind.S_hint_param_table,
				SymbolKind.S_hint_param_table_ext, SymbolKind.S_opt_qb_name, SymbolKind.S_qb_level_hint, SymbolKind.S_semijoin_strategies, SymbolKind.S_semijoin_strategy,
				SymbolKind.S_subquery_strategy, SymbolKind.S_table_level_hint, SymbolKind.S_index_level_hint, SymbolKind.S_table_level_hint_type_on, SymbolKind.S_table_level_hint_type_off,
				SymbolKind.S_key_level_hint_type_on, SymbolKind.S_key_level_hint_type_off, SymbolKind.S_qb_name_hint, SymbolKind.S_set_var_hint, SymbolKind.S_resource_group_hint,
				SymbolKind.S_set_var_ident, SymbolKind.S_set_var_num_item, SymbolKind.S_set_var_text_value, SymbolKind.S_set_var_string_item, SymbolKind.S_set_var_arg };

		static final SymbolKind get(int code) {
			return values_[code];
		}

		public final int getCode() {
			return this.yycode_;
		}

		/*
		 * Return YYSTR after stripping away unnecessary quotes and backslashes, so that it's suitable for yyerror. The heuristic is that double-quoting is unnecessary
		 * unless the string contains an apostrophe, a comma, or backslash (other than backslash-backslash). YYSTR is taken from yytname.
		 */
		private static String yytnamerr_(String yystr) {
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
			}
			return yystr;
		}

		/*
		 * YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM. First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.
		 */
		private static final String[] yytname_ = yytname_init();

		private static final String[] yytname_init() {
			return new String[] { "\"end of file\"", "error", "\"invalid token\"", "MAX_EXECUTION_TIME_HINT", "RESOURCE_GROUP_HINT", "BKA_HINT", "BNL_HINT", "DUPSWEEDOUT_HINT", "FIRSTMATCH_HINT",
					"INTOEXISTS_HINT", "LOOSESCAN_HINT", "MATERIALIZATION_HINT", "NO_BKA_HINT", "NO_BNL_HINT", "NO_ICP_HINT", "NO_MRR_HINT", "NO_RANGE_OPTIMIZATION_HINT", "NO_SEMIJOIN_HINT",
					"MRR_HINT", "QB_NAME_HINT", "SEMIJOIN_HINT", "SUBQUERY_HINT", "DERIVED_MERGE_HINT", "NO_DERIVED_MERGE_HINT", "JOIN_PREFIX_HINT", "JOIN_SUFFIX_HINT", "JOIN_ORDER_HINT",
					"JOIN_FIXED_ORDER_HINT", "INDEX_MERGE_HINT", "NO_INDEX_MERGE_HINT", "SET_VAR_HINT", "SKIP_SCAN_HINT", "NO_SKIP_SCAN_HINT", "HASH_JOIN_HINT", "NO_HASH_JOIN_HINT", "HINT_ARG_NUMBER",
					"HINT_ARG_IDENT", "HINT_ARG_QB_NAME", "HINT_ARG_TEXT", "HINT_IDENT_OR_NUMBER_WITH_SCALE", "HINT_CLOSE", "HINT_ERROR", "INDEX_HINT", "NO_INDEX_HINT", "JOIN_INDEX_HINT",
					"NO_JOIN_INDEX_HINT", "GROUP_INDEX_HINT", "NO_GROUP_INDEX_HINT", "ORDER_INDEX_HINT", "NO_ORDER_INDEX_HINT", "DERIVED_CONDITION_PUSHDOWN_HINT", "NO_DERIVED_CONDITION_PUSHDOWN_HINT",
					"HINT_ARG_FLOATING_POINT_NUMBER", "'('", "')'", "','", "'='", "$accept", "start", "hint_list", "hint", "max_execution_time_hint", "opt_hint_param_table_list",
					"hint_param_table_list", "opt_hint_param_table_list_empty_qb", "hint_param_table_list_empty_qb", "opt_hint_param_index_list", "hint_param_index_list", "hint_param_index",
					"hint_param_table_empty_qb", "hint_param_table", "hint_param_table_ext", "opt_qb_name", "qb_level_hint", "semijoin_strategies", "semijoin_strategy", "subquery_strategy",
					"table_level_hint", "index_level_hint", "table_level_hint_type_on", "table_level_hint_type_off", "key_level_hint_type_on", "key_level_hint_type_off", "qb_name_hint",
					"set_var_hint", "resource_group_hint", "set_var_ident", "set_var_num_item", "set_var_text_value", "set_var_string_item", "set_var_arg", null };
		}

		/* The user-facing name of this symbol. */
		public final String getName() {
			return yytnamerr_(yytname_[yycode_]);
		}

	};

	/**
	 * Communication interface between the scanner and the Bison-generated parser <tt>my_hint_parser_Parser</tt>.
	 */
	public interface Lexer {
		/* Token kinds. */
		/** Token "end of file", to be returned by the scanner. */
		static final int YYEOF = 0;
		/** Token error, to be returned by the scanner. */
		static final int YYerror = 256;
		/** Token "invalid token", to be returned by the scanner. */
		static final int YYUNDEF = 1050;
		/** Token MAX_EXECUTION_TIME_HINT, to be returned by the scanner. */
		static final int MAX_EXECUTION_TIME_HINT = 1000;
		/** Token RESOURCE_GROUP_HINT, to be returned by the scanner. */
		static final int RESOURCE_GROUP_HINT = 1001;
		/** Token BKA_HINT, to be returned by the scanner. */
		static final int BKA_HINT = 1002;
		/** Token BNL_HINT, to be returned by the scanner. */
		static final int BNL_HINT = 1003;
		/** Token DUPSWEEDOUT_HINT, to be returned by the scanner. */
		static final int DUPSWEEDOUT_HINT = 1004;
		/** Token FIRSTMATCH_HINT, to be returned by the scanner. */
		static final int FIRSTMATCH_HINT = 1005;
		/** Token INTOEXISTS_HINT, to be returned by the scanner. */
		static final int INTOEXISTS_HINT = 1006;
		/** Token LOOSESCAN_HINT, to be returned by the scanner. */
		static final int LOOSESCAN_HINT = 1007;
		/** Token MATERIALIZATION_HINT, to be returned by the scanner. */
		static final int MATERIALIZATION_HINT = 1008;
		/** Token NO_BKA_HINT, to be returned by the scanner. */
		static final int NO_BKA_HINT = 1009;
		/** Token NO_BNL_HINT, to be returned by the scanner. */
		static final int NO_BNL_HINT = 1010;
		/** Token NO_ICP_HINT, to be returned by the scanner. */
		static final int NO_ICP_HINT = 1011;
		/** Token NO_MRR_HINT, to be returned by the scanner. */
		static final int NO_MRR_HINT = 1012;
		/** Token NO_RANGE_OPTIMIZATION_HINT, to be returned by the scanner. */
		static final int NO_RANGE_OPTIMIZATION_HINT = 1013;
		/** Token NO_SEMIJOIN_HINT, to be returned by the scanner. */
		static final int NO_SEMIJOIN_HINT = 1014;
		/** Token MRR_HINT, to be returned by the scanner. */
		static final int MRR_HINT = 1015;
		/** Token QB_NAME_HINT, to be returned by the scanner. */
		static final int QB_NAME_HINT = 1016;
		/** Token SEMIJOIN_HINT, to be returned by the scanner. */
		static final int SEMIJOIN_HINT = 1017;
		/** Token SUBQUERY_HINT, to be returned by the scanner. */
		static final int SUBQUERY_HINT = 1018;
		/** Token DERIVED_MERGE_HINT, to be returned by the scanner. */
		static final int DERIVED_MERGE_HINT = 1019;
		/** Token NO_DERIVED_MERGE_HINT, to be returned by the scanner. */
		static final int NO_DERIVED_MERGE_HINT = 1020;
		/** Token JOIN_PREFIX_HINT, to be returned by the scanner. */
		static final int JOIN_PREFIX_HINT = 1021;
		/** Token JOIN_SUFFIX_HINT, to be returned by the scanner. */
		static final int JOIN_SUFFIX_HINT = 1022;
		/** Token JOIN_ORDER_HINT, to be returned by the scanner. */
		static final int JOIN_ORDER_HINT = 1023;
		/** Token JOIN_FIXED_ORDER_HINT, to be returned by the scanner. */
		static final int JOIN_FIXED_ORDER_HINT = 1024;
		/** Token INDEX_MERGE_HINT, to be returned by the scanner. */
		static final int INDEX_MERGE_HINT = 1025;
		/** Token NO_INDEX_MERGE_HINT, to be returned by the scanner. */
		static final int NO_INDEX_MERGE_HINT = 1026;
		/** Token SET_VAR_HINT, to be returned by the scanner. */
		static final int SET_VAR_HINT = 1027;
		/** Token SKIP_SCAN_HINT, to be returned by the scanner. */
		static final int SKIP_SCAN_HINT = 1028;
		/** Token NO_SKIP_SCAN_HINT, to be returned by the scanner. */
		static final int NO_SKIP_SCAN_HINT = 1029;
		/** Token HASH_JOIN_HINT, to be returned by the scanner. */
		static final int HASH_JOIN_HINT = 1030;
		/** Token NO_HASH_JOIN_HINT, to be returned by the scanner. */
		static final int NO_HASH_JOIN_HINT = 1031;
		/** Token HINT_ARG_NUMBER, to be returned by the scanner. */
		static final int HINT_ARG_NUMBER = 1032;
		/** Token HINT_ARG_IDENT, to be returned by the scanner. */
		static final int HINT_ARG_IDENT = 1033;
		/** Token HINT_ARG_QB_NAME, to be returned by the scanner. */
		static final int HINT_ARG_QB_NAME = 1034;
		/** Token HINT_ARG_TEXT, to be returned by the scanner. */
		static final int HINT_ARG_TEXT = 1035;
		/** Token HINT_IDENT_OR_NUMBER_WITH_SCALE, to be returned by the scanner. */
		static final int HINT_IDENT_OR_NUMBER_WITH_SCALE = 1036;
		/** Token HINT_CLOSE, to be returned by the scanner. */
		static final int HINT_CLOSE = 1037;
		/** Token HINT_ERROR, to be returned by the scanner. */
		static final int HINT_ERROR = 1038;
		/** Token INDEX_HINT, to be returned by the scanner. */
		static final int INDEX_HINT = 1039;
		/** Token NO_INDEX_HINT, to be returned by the scanner. */
		static final int NO_INDEX_HINT = 1040;
		/** Token JOIN_INDEX_HINT, to be returned by the scanner. */
		static final int JOIN_INDEX_HINT = 1041;
		/** Token NO_JOIN_INDEX_HINT, to be returned by the scanner. */
		static final int NO_JOIN_INDEX_HINT = 1042;
		/** Token GROUP_INDEX_HINT, to be returned by the scanner. */
		static final int GROUP_INDEX_HINT = 1043;
		/** Token NO_GROUP_INDEX_HINT, to be returned by the scanner. */
		static final int NO_GROUP_INDEX_HINT = 1044;
		/** Token ORDER_INDEX_HINT, to be returned by the scanner. */
		static final int ORDER_INDEX_HINT = 1045;
		/** Token NO_ORDER_INDEX_HINT, to be returned by the scanner. */
		static final int NO_ORDER_INDEX_HINT = 1046;
		/** Token DERIVED_CONDITION_PUSHDOWN_HINT, to be returned by the scanner. */
		static final int DERIVED_CONDITION_PUSHDOWN_HINT = 1047;
		/** Token NO_DERIVED_CONDITION_PUSHDOWN_HINT, to be returned by the scanner. */
		static final int NO_DERIVED_CONDITION_PUSHDOWN_HINT = 1048;
		/** Token HINT_ARG_FLOATING_POINT_NUMBER, to be returned by the scanner. */
		static final int HINT_ARG_FLOATING_POINT_NUMBER = 1049;

		/** Deprecated, use YYEOF instead. */
		public static final int EOF = YYEOF;

		/**
		 * Method to retrieve the semantic value of the last scanned token.
		 *
		 * @return the semantic value of the last scanned token.
		 */
		Object getLVal();

		/**
		 * Entry point for the scanner. Returns the token identifier corresponding to the next token and prepares to return the semantic value of the token.
		 *
		 * @return the token identifier corresponding to the next token.
		 */
		int yylex() throws java.io.IOException;

		/**
		 * Emit an errorin a user-defined way.
		 *
		 *
		 * @param msg The string for the error message.
		 */
		void yyerror(String msg);

	}

	/**
	 * The object doing lexical analysis for us.
	 */
	private Lexer yylexer;

	/* User arguments. */
	protected SQLThread thd;
	protected HintScanner scanner;
	protected List<Integer> ret;

	/**
	 * Instantiates the Bison-generated parser.
	 *
	 * @param yylexer The scanner that will supply tokens to the parser.
	 */
	public SQLHintsParser(Lexer yylexer, SQLThread thd, HintScanner scanner, List<Integer> ret) {
		this.yylexer = yylexer;
		this.thd = thd;
		this.scanner = scanner;
		this.ret = ret;
	}

	private int yynerrs = 0;

	/**
	 * The number of syntax errors so far.
	 */
	public final int getNumberOfErrors() {
		return yynerrs;
	}

	/**
	 * Print an error message via the lexer.
	 *
	 * @param msg The error message.
	 */
	public final void yyerror(String msg) {
		yylexer.yyerror(msg);
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
			if (0 < num) {
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
	 * Returned by a Bison action in order to stop the parsing process and return success (<tt>true</tt>).
	 */
	public static final int YYACCEPT = 0;

	/**
	 * Returned by a Bison action in order to stop the parsing process and return failure (<tt>false</tt>).
	 */
	public static final int YYABORT = 1;

	/**
	 * Returned by a Bison action in order to start error recovery without printing an error message.
	 */
	public static final int YYERROR = 2;

	/**
	 * Internal return codes that are not supported for user semantic actions.
	 */
	private static final int YYERRLAB = 3;
	private static final int YYNEWSTATE = 4;
	private static final int YYDEFAULT = 5;
	private static final int YYREDUCE = 6;
	private static final int YYERRLAB1 = 7;
	private static final int YYRETURN = 8;

	private int yyerrstatus_ = 0;

	/**
	 * Whether error recovery is being done. In this state, the parser reads token until it reaches a known state, and then restarts normal operation.
	 */
	public final boolean recovering() {
		return yyerrstatus_ == 0;
	}

	/**
	 * Compute post-reduction state.
	 *
	 * @param yystate the current state
	 * @param yysym   the nonterminal to push on the stack
	 */
	private int yyLRGotoState(int yystate, int yysym) {
		int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
		if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
			return yytable_[yyr];
		else
			return yydefgoto_[yysym - YYNTOKENS_];
	}

	private int yyaction(int yyn, YYStack yystack, int yylen) {
		/*
		 * If YYLEN is nonzero, implement the default value of the action: '$$ = $1'. Otherwise, use the top of the stack.
		 *
		 * Otherwise, the following line sets YYVAL to garbage. This behavior is undocumented and Bison users should not rely upon it.
		 */
		Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

		switch (yyn) {
		case 2: /* start: hint_list HINT_CLOSE */
			if (yyn == 2)
			/* "sql_hints.y":213 */
			{
//	  	ret= ((hint_list)(yystack.valueAt (1)));
			}
			;
			break;

		case 3: /* start: hint_list error HINT_CLOSE */
			if (yyn == 3)
			/* "sql_hints.y":215 */
			{
//	  	ret= ((hint_list)(yystack.valueAt (2)));
			}
			;
			break;

		case 4: /* start: error HINT_CLOSE */
			if (yyn == 4)
			/* "sql_hints.y":217 */
			{
//	  		ret= nullptr;
			}
			;
			break;

		case 5: /* hint_list: hint */
			if (yyn == 5)
				/* "sql_hints.y":222 */
//          {
//            yyval = NEW_PTN PT_hint_list(thd.memRoot);
//            if (yyval == nullptr || yyval.push_back(((hint)(yystack.valueAt (0)))))
//              YYABORT; // OOM
//          };
				break;

		case 6: /* hint_list: hint_list hint */
			if (yyn == 6)

			/* "sql_hints.y":228 */
			{
//		((hintList) (yystack.valueAt(1))).push_back(((hint) (yystack.valueAt(0))));
//		yyval = ((hintList) (yystack.valueAt(1)));
			}
			;
			break;

		case 14: /* max_execution_time_hint: MAX_EXECUTION_TIME_HINT '(' HINT_ARG_NUMBER ')' */
			if (yyn == 14)
			/* "sql_hints.y":247 */
			{
//            longlong n;
//            if (parse_int(&n, ((lexer.hint_string)(yystack.valueAt (1))).str, ((lexer.hint_string)(yystack.valueAt (1))).length) || n > UINT_MAX32)
//            {
//              scanner.syntax_warning(ER_THD(thd,
//                                             ER_WARN_BAD_MAX_EXECUTION_TIME));
//              yyval= nullptr;
//            }
//            else
//            {
//              yyval=NEW_PTN PT_hint_max_execution_time(n);
//              if (yyval == nullptr)
//                YYABORT; // OOM
//            }

			}
			;
			break;

		case 15: /* opt_hint_param_table_list: %empty */
			if (yyn == 15)
			/* "sql_hints.y":266 */
			{
//		yyval.init(thd.mem_root);
			}
			;
			break;

		case 17: /* hint_param_table_list: hint_param_table */
			if (yyn == 17)
			/* "sql_hints.y":272 */
			{
//		yyval.init(thd.mem_root);if(yyval.push_back(((hint_param_table)(yystack.valueAt(0)))))YYABORT; // OOM
			}
			;
			break;

		case 18: /* hint_param_table_list: hint_param_table_list ',' hint_param_table */
			if (yyn == 18)
			/* "sql_hints.y":278 */
			{
//		if(((hint_param_table_list)(yystack.valueAt(2))).push_back(((hint_param_table)(yystack.valueAt(0)))))YYABORT; // OOM
//		yyval=((hint_param_table_list)(yystack.valueAt(2)));
			}
			;
			break;

		case 19: /* opt_hint_param_table_list_empty_qb: %empty */
			if (yyn == 19)
			/* "sql_hints.y":286 */
			{
//		yyval.init(thd.mem_root);
			}
			;
			break;

		case 21: /* hint_param_table_list_empty_qb: hint_param_table_empty_qb */
			if (yyn == 21)
			/* "sql_hints.y":292 */
			{
//		yyval.init(thd.mem_root);if(yyval.push_back(((hint_param_table)(yystack.valueAt(0)))))YYABORT; // OOM
			}
			;
			break;

		case 22: /* hint_param_table_list_empty_qb: hint_param_table_list_empty_qb ',' hint_param_table_empty_qb */
			if (yyn == 22)
			/* "sql_hints.y":298 */
			{
//		if(((hint_param_table_list)(yystack.valueAt(2))).push_back(((hint_param_table)(yystack.valueAt(0)))))YYABORT; // OOM
//		yyval=((hint_param_table_list)(yystack.valueAt(2)));
			}
			;
			break;

		case 23: /* opt_hint_param_index_list: %empty */
			if (yyn == 23)
			/* "sql_hints.y":306 */
			{
//		yyval.init(thd.mem_root);
			}
			;
			break;

		case 25: /* hint_param_index_list: hint_param_index */
			if (yyn == 25)
			/* "sql_hints.y":312 */
			{
//		yyval.init(thd.mem_root);if(yyval.push_back(((lexer.hint_string)(yystack.valueAt(0)))))YYABORT; // OOM
			}
			;
			break;

		case 26: /* hint_param_index_list: hint_param_index_list ',' hint_param_index */
			if (yyn == 26)
			/* "sql_hints.y":318 */
			{
//		if(((hint_param_index_list)(yystack.valueAt(2))).push_back(((lexer.hint_string)(yystack.valueAt(0)))))YYABORT; // OOM
//		yyval=((hint_param_index_list)(yystack.valueAt(2)));
			}
			;
			break;

		case 28: /* hint_param_table_empty_qb: HINT_ARG_IDENT */
			if (yyn == 28)
			/* "sql_hints.y":331 */
			{
//		yyval.table=((lexer.hint_string)(yystack.valueAt(0)));yyval.opt_query_block=NULL_CSTR;
			}
			;
			break;

		case 29: /* hint_param_table: HINT_ARG_IDENT opt_qb_name */
			if (yyn == 29)
			/* "sql_hints.y":339 */
			{
//		yyval.table=((lexer.hint_string)(yystack.valueAt(1)));yyval.opt_query_block=((lexer.hint_string)(yystack.valueAt(0)));
			}
			;
			break;

		case 31: /* hint_param_table_ext: HINT_ARG_QB_NAME HINT_ARG_IDENT */
			if (yyn == 31)
			/* "sql_hints.y":348 */
			{
//		yyval.table=((lexer.hint_string)(yystack.valueAt(0)));yyval.opt_query_block=((lexer.hint_string)(yystack.valueAt(1)));
			}
			;
			break;

		case 32: /* opt_qb_name: %empty */
			if (yyn == 32)
			/* "sql_hints.y":355 */
			{
//		yyval=NULL_CSTR;
			}
			;
			break;

		case 34: /* qb_level_hint: SEMIJOIN_HINT '(' opt_qb_name semijoin_strategies ')' */
			if (yyn == 34)
			/* "sql_hints.y":361 */
			{
//		yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt (2))), true, SEMIJOIN_HINT_ENUM, ((ulong_num)(yystack.valueAt (1))));
//        if (yyval == nullptr)
//          YYABORT; // OOM
			}
			;
			break;

		case 35: /* qb_level_hint: NO_SEMIJOIN_HINT '(' opt_qb_name semijoin_strategies ')' */
			if (yyn == 35)
			/* "sql_hints.y":368 */
			{
//        yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt (2))), false, SEMIJOIN_HINT_ENUM, ((ulong_num)(yystack.valueAt (1))));
//        if (yyval == nullptr)
//          YYABORT; // OOM
			}
			;
			break;

		case 36: /* qb_level_hint: SUBQUERY_HINT '(' opt_qb_name subquery_strategy ')' */
			if (yyn == 36)
			/* "sql_hints.y":375 */
			{
//        yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt (2))), true, SUBQUERY_HINT_ENUM, ((ulong_num)(yystack.valueAt (1))));
//        if (yyval == nullptr)
//          YYABORT; // OOM
			}
			;
			break;

		case 37: /* qb_level_hint: JOIN_PREFIX_HINT '(' opt_hint_param_table_list ')' */
			if (yyn == 37)
			/* "sql_hints.y":382 */
			{
//        yyval=NEW_PTN PT_qb_level_hint(NULL_CSTR, true, JOIN_PREFIX_HINT_ENUM, ((hint_param_table_list)(yystack.valueAt (1))));
//        if (yyval == nullptr)
//          YYABORT; // OOM
			}
			;
			break;

		case 38: /* qb_level_hint: JOIN_PREFIX_HINT '(' HINT_ARG_QB_NAME opt_hint_param_table_list_empty_qb ')' */
			if (yyn == 38)

			/* "sql_hints.y":389 */
			{
//        yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt (2))), true, JOIN_PREFIX_HINT_ENUM, ((hint_param_table_list)(yystack.valueAt (1))));
//        if (yyval == nullptr)
//          YYABORT; // OOM
			}
			;
			break;

		case 39: /* qb_level_hint: JOIN_SUFFIX_HINT '(' opt_hint_param_table_list ')' */
			if (yyn == 39)
			/* "sql_hints.y":396 */
			{
//        yyval=NEW_PTN PT_qb_level_hint(NULL_CSTR, true, JOIN_SUFFIX_HINT_ENUM, ((hint_param_table_list)(yystack.valueAt (1))));
//        if (yyval == nullptr)
//          YYABORT; // OOM
			}
			;
			break;

		case 40: /* qb_level_hint: JOIN_SUFFIX_HINT '(' HINT_ARG_QB_NAME opt_hint_param_table_list_empty_qb ')' */
			if (yyn == 40)
			/* "sql_hints.y":403 */
			{
//		yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt(2))),true,JOIN_SUFFIX_HINT_ENUM,((hint_param_table_list)(yystack.valueAt(1))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 41: /* qb_level_hint: JOIN_ORDER_HINT '(' opt_hint_param_table_list ')' */
			if (yyn == 41)
			/* "sql_hints.y":410 */
			{
//		yyval=NEW_PTN PT_qb_level_hint(NULL_CSTR,true,JOIN_ORDER_HINT_ENUM,((hint_param_table_list)(yystack.valueAt(1))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 42: /* qb_level_hint: JOIN_ORDER_HINT '(' HINT_ARG_QB_NAME opt_hint_param_table_list_empty_qb ')' */
			if (yyn == 42)
			/* "sql_hints.y":417 */
			{
//		yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt(2))),true,JOIN_ORDER_HINT_ENUM,((hint_param_table_list)(yystack.valueAt(1))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 43: /* qb_level_hint: JOIN_FIXED_ORDER_HINT '(' opt_qb_name ')' */
			if (yyn == 43)
			/* "sql_hints.y":424 */
			{
//		yyval=NEW_PTN PT_qb_level_hint(((lexer.hint_string)(yystack.valueAt(1))),true,JOIN_FIXED_ORDER_HINT_ENUM,0);if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 44: /* semijoin_strategies: %empty */
			if (yyn == 44)
			/* "sql_hints.y":432 */
			{
//		yyval = 0;
			}
			;
			break;

		case 45: /* semijoin_strategies: semijoin_strategy */
			if (yyn == 45)
			/* "sql_hints.y":434 */
			{
//		yyval = ((ulong_num) (yystack.valueAt(0)));
			}
			;
			break;

		case 46: /* semijoin_strategies: semijoin_strategies ',' semijoin_strategy */
			if (yyn == 46)
			/* "sql_hints.y":438 */
			{
//		yyval = ((ulong_num) (yystack.valueAt(2))) | ((ulong_num) (yystack.valueAt(0)));
			}
			;
			break;

		case 47: /* semijoin_strategy: FIRSTMATCH_HINT */
			if (yyn == 47)
			/* "sql_hints.y":444 */
			{
//		yyval = OPTIMIZER_SWITCH_FIRSTMATCH;
			}
			;
			break;

		case 48: /* semijoin_strategy: LOOSESCAN_HINT */
			if (yyn == 48)
			/* "sql_hints.y":445 */
			{
//		yyval = OPTIMIZER_SWITCH_LOOSE_SCAN;
			}
			;
			break;

		case 49: /* semijoin_strategy: MATERIALIZATION_HINT */
			if (yyn == 49)
			/* "sql_hints.y":446 */
			{
//		yyval = OPTIMIZER_SWITCH_MATERIALIZATION;
			}
			;
			break;

		case 50: /* semijoin_strategy: DUPSWEEDOUT_HINT */
			if (yyn == 50)
			/* "sql_hints.y":447 */
			{
//		yyval = OPTIMIZER_SWITCH_DUPSWEEDOUT;
			}
			;
			break;

		case 51: /* subquery_strategy: MATERIALIZATION_HINT */
			if (yyn == 51)
			/* "sql_hints.y":451 */
			{
//		yyval=static_cast<long>(Subquery_strategy::SUBQ_MATERIALIZATION);
			}
			;
			break;

		case 52: /* subquery_strategy: INTOEXISTS_HINT */
			if (yyn == 52)
			/* "sql_hints.y":453 */
			{
//		yyval=static_cast<long>(Subquery_strategy::SUBQ_EXISTS);
			}
			;
			break;

		case 53: /* table_level_hint: table_level_hint_type_on '(' opt_hint_param_table_list ')' */
			if (yyn == 53)
			/* "sql_hints.y":459 */
			{
//		yyval=NEW_PTN PT_table_level_hint(NULL_CSTR,((hint_param_table_list)(yystack.valueAt(1))),true,((hint_type)(yystack.valueAt(3))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 54: /* table_level_hint: table_level_hint_type_on '(' HINT_ARG_QB_NAME opt_hint_param_table_list_empty_qb ')' */
			if (yyn == 54)
			/* "sql_hints.y":466 */
			{
//		yyval=NEW_PTN PT_table_level_hint(((lexer.hint_string)(yystack.valueAt(2))),((hint_param_table_list)(yystack.valueAt(1))),true,((hint_type)(yystack.valueAt(4))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 55: /* table_level_hint: table_level_hint_type_off '(' opt_hint_param_table_list ')' */
			if (yyn == 55)
			/* "sql_hints.y":472 */
			{
//		yyval=NEW_PTN PT_table_level_hint(NULL_CSTR,((hint_param_table_list)(yystack.valueAt(1))),false,((hint_type)(yystack.valueAt(3))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 56: /* table_level_hint: table_level_hint_type_off '(' HINT_ARG_QB_NAME opt_hint_param_table_list_empty_qb ')' */
			if (yyn == 56)
			/* "sql_hints.y":479 */
			{
//		yyval=NEW_PTN PT_table_level_hint(((lexer.hint_string)(yystack.valueAt(2))),((hint_param_table_list)(yystack.valueAt(1))),false,((hint_type)(yystack.valueAt(4))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 57: /* index_level_hint: key_level_hint_type_on '(' hint_param_table_ext opt_hint_param_index_list ')' */
			if (yyn == 57)
			/* "sql_hints.y":489 */
			{
//		yyval=NEW_PTN PT_key_level_hint(((hint_param_table)(yystack.valueAt(2))),((hint_param_index_list)(yystack.valueAt(1))),true,((hint_type)(yystack.valueAt(4))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 58: /* index_level_hint: key_level_hint_type_off '(' hint_param_table_ext opt_hint_param_index_list ')' */
			if (yyn == 58)
			/* "sql_hints.y":496 */
			{
//		yyval=NEW_PTN PT_key_level_hint(((hint_param_table)(yystack.valueAt(2))),((hint_param_index_list)(yystack.valueAt(1))),false,((hint_type)(yystack.valueAt(4))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 59: /* table_level_hint_type_on: BKA_HINT */
			if (yyn == 59)
			/* "sql_hints.y":505 */
			{
//		yyval = BKA_HINT_ENUM;
			}
			;
			break;

		case 60: /* table_level_hint_type_on: BNL_HINT */
			if (yyn == 60)
			/* "sql_hints.y":509 */
			{
//		yyval = BNL_HINT_ENUM;
			}
			;
			break;

		case 61: /* table_level_hint_type_on: HASH_JOIN_HINT */
			if (yyn == 61)
			/* "sql_hints.y":513 */
			{
//		yyval = HASH_JOIN_HINT_ENUM;
			}
			;
			break;

		case 62: /* table_level_hint_type_on: DERIVED_MERGE_HINT */
			if (yyn == 62)
			/* "sql_hints.y":517 */
			{
//		yyval = DERIVED_MERGE_HINT_ENUM;
			}
			;
			break;

		case 63: /* table_level_hint_type_on: DERIVED_CONDITION_PUSHDOWN_HINT */
			if (yyn == 63)
			/* "sql_hints.y":521 */
			{
//		yyval = DERIVED_CONDITION_PUSHDOWN_HINT_ENUM;
			}
			;
			break;

		case 64: /* table_level_hint_type_off: NO_BKA_HINT */
			if (yyn == 64)
			/* "sql_hints.y":528 */
			{
//		yyval = BKA_HINT_ENUM;
			}
			;
			break;

		case 65: /* table_level_hint_type_off: NO_BNL_HINT */
			if (yyn == 65)
			/* "sql_hints.y":532 */
			{
//		yyval = BNL_HINT_ENUM;
			}
			;
			break;

		case 66: /* table_level_hint_type_off: NO_HASH_JOIN_HINT */
			if (yyn == 66)
			/* "sql_hints.y":536 */
			{
//		yyval = HASH_JOIN_HINT_ENUM;
			}
			;
			break;

		case 67: /* table_level_hint_type_off: NO_DERIVED_MERGE_HINT */
			if (yyn == 67)
			/* "sql_hints.y":540 */
			{
//		yyval = DERIVED_MERGE_HINT_ENUM;
			}
			;
			break;

		case 68: /* table_level_hint_type_off: NO_DERIVED_CONDITION_PUSHDOWN_HINT */
			if (yyn == 68)
			/* "sql_hints.y":544 */
			{
//		yyval = DERIVED_CONDITION_PUSHDOWN_HINT_ENUM;
			}
			;
			break;

		case 69: /* key_level_hint_type_on: MRR_HINT */
			if (yyn == 69)
			/* "sql_hints.y":551 */
			{
//		yyval = MRR_HINT_ENUM;
			}
			;
			break;

		case 70: /* key_level_hint_type_on: NO_RANGE_OPTIMIZATION_HINT */
			if (yyn == 70)
			/* "sql_hints.y":555 */
			{
//		yyval = NO_RANGE_HINT_ENUM;
			}
			;
			break;

		case 71: /* key_level_hint_type_on: INDEX_MERGE_HINT */
			if (yyn == 71)
			/* "sql_hints.y":559 */
			{
//		yyval = INDEX_MERGE_HINT_ENUM;
			}
			;
			break;

		case 72: /* key_level_hint_type_on: SKIP_SCAN_HINT */
			if (yyn == 72)
			/* "sql_hints.y":563 */
			{
//		yyval = SKIP_SCAN_HINT_ENUM;
			}
			;
			break;

		case 73: /* key_level_hint_type_on: INDEX_HINT */
			if (yyn == 73)
			/* "sql_hints.y":567 */
			{
//		yyval = INDEX_HINT_ENUM;
			}
			;
			break;

		case 74: /* key_level_hint_type_on: JOIN_INDEX_HINT */
			if (yyn == 74)
			/* "sql_hints.y":571 */
			{
//		yyval = JOIN_INDEX_HINT_ENUM;
			}
			;
			break;

		case 75: /* key_level_hint_type_on: GROUP_INDEX_HINT */
			if (yyn == 75)
			/* "sql_hints.y":575 */
			{
//		yyval = GROUP_INDEX_HINT_ENUM;
			}
			;
			break;

		case 76: /* key_level_hint_type_on: ORDER_INDEX_HINT */
			if (yyn == 76)
			/* "sql_hints.y":579 */
			{
//		yyval = ORDER_INDEX_HINT_ENUM;
			}
			;
			break;

		case 77: /* key_level_hint_type_off: NO_ICP_HINT */
			if (yyn == 77)
			/* "sql_hints.y":586 */
			{
//		yyval = ICP_HINT_ENUM;
			}
			;
			break;

		case 78: /* key_level_hint_type_off: NO_MRR_HINT */
			if (yyn == 78)
			/* "sql_hints.y":590 */
			{
//		yyval = MRR_HINT_ENUM;
			}
			;
			break;

		case 79: /* key_level_hint_type_off: NO_INDEX_MERGE_HINT */
			if (yyn == 79)
			/* "sql_hints.y":594 */
			{
//		yyval = INDEX_MERGE_HINT_ENUM;
			}
			;
			break;

		case 80: /* key_level_hint_type_off: NO_SKIP_SCAN_HINT */
			if (yyn == 80)
			/* "sql_hints.y":598 */
			{
//		yyval = SKIP_SCAN_HINT_ENUM;
			}
			;
			break;

		case 81: /* key_level_hint_type_off: NO_INDEX_HINT */
			if (yyn == 81)
			/* "sql_hints.y":602 */
			{
//		yyval = INDEX_HINT_ENUM;
			}
			;
			break;

		case 82: /* key_level_hint_type_off: NO_JOIN_INDEX_HINT */
			if (yyn == 82)
			/* "sql_hints.y":606 */
			{
//		yyval = JOIN_INDEX_HINT_ENUM;
			}
			;
			break;

		case 83: /* key_level_hint_type_off: NO_GROUP_INDEX_HINT */
			if (yyn == 83)
			/* "sql_hints.y":610 */
			{
//		yyval = GROUP_INDEX_HINT_ENUM;
			}
			;
			break;

		case 84: /* key_level_hint_type_off: NO_ORDER_INDEX_HINT */
			if (yyn == 84)
			/* "sql_hints.y":614 */
			{
//		yyval = ORDER_INDEX_HINT_ENUM;
			}
			;
			break;

		case 85: /* qb_name_hint: QB_NAME_HINT '(' HINT_ARG_IDENT ')' */
			if (yyn == 85)
			/* "sql_hints.y":621 */
			{
//		yyval=NEW_PTN PT_hint_qb_name(((lexer.hint_string)(yystack.valueAt(1))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 86: /* set_var_hint: SET_VAR_HINT '(' set_var_ident '=' set_var_arg ')' */
			if (yyn == 86)
			/* "sql_hints.y":630 */
			{
//		yyval=NEW_PTN PT_hint_sys_var(((lexer.hint_string)(yystack.valueAt(3))),((item)(yystack.valueAt(1))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 87: /* resource_group_hint: RESOURCE_GROUP_HINT '(' HINT_ARG_IDENT ')' */
			if (yyn == 87)
			/* "sql_hints.y":639 */
			{
//		if(check_resource_group_name_len(((lexer.hint_string)(yystack.valueAt(1))),Sql_condition::SL_WARNING))YYERROR;
//		yyval=NEW_PTN PT_hint_resource_group(((lexer.hint_string)(yystack.valueAt(1))));if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		case 90: /* set_var_num_item: HINT_ARG_NUMBER */
			if (yyn == 90)
			/* "sql_hints.y":656 */
			{
//		longlong n;
//		if(parse_int(&n,((lexer.hint_string)(yystack.valueAt(0))).str,((lexer.hint_string)(yystack.valueAt(0))).length)){
//			scanner.syntax_warning(ER_THD(thd,ER_WRONG_SIZE_NUMBER));yyval=nullptr;
//		} else {
//			yyval=NEW_PTN Item_int((ulonglong)n);if(yyval==nullptr)YYABORT; // OOM
//		}
			}
			;
			break;

		case 91: /* set_var_num_item: HINT_ARG_FLOATING_POINT_NUMBER */
			if (yyn == 91)
			/* "sql_hints.y":671 */
			{
//		yyval=NEW_PTN Item_float(((lexer.hint_string)(yystack.valueAt(0))).str,((lexer.hint_string)(yystack.valueAt(0))).length);
			}
			;
			break;

		case 92: /* set_var_num_item: HINT_IDENT_OR_NUMBER_WITH_SCALE */
			if (yyn == 92)
			/* "sql_hints.y":675 */
			{
//		longlong n;
//		if(parse_int(&n,((lexer.hint_string)(yystack.valueAt(0))).str,((lexer.hint_string)(yystack.valueAt(0))).length-1)){
//			scanner.syntax_warning(ER_THD(thd,ER_WRONG_SIZE_NUMBER));yyval=nullptr;
//		}else{
//			int multiplier;
//			switch(((lexer.hint_string)(yystack.valueAt(0))).str[((lexer.hint_string)(yystack.valueAt(0))).length-1]){
//				case'K':
//					multiplier=1024;
//					break;
//				case'M':
//					multiplier=1024*1024;
//					break;
//				case'G':
//					multiplier=1024*1024*1024;
//					break;
//				default:
//					assert(false); // should
//					YYABORT; // for sure
//			}
//			if(1.0 L*n*multiplier>LLONG_MAX_DOUBLE){
//				scanner.syntax_warning(ER_THD(thd,ER_WRONG_SIZE_NUMBER));yyval=nullptr;
//			} else{
//				yyval=NEW_PTN Item_int((ulonglong)n*multiplier);if(yyval==nullptr)YYABORT; // OOM
//			}
//		}
			}
			;
			break;

		case 95: /* set_var_string_item: set_var_text_value */
			if (yyn == 95)

			/* "sql_hints.y":715 */
			{
//		yyval=NEW_PTN Item_string(((lexer.hint_string)(yystack.valueAt(0))).str,((lexer.hint_string)(yystack.valueAt(0))).length,thd.charset());if(yyval==nullptr)YYABORT; // OOM
			}
			;
			break;

		/* "sql_hints.java":1481 */

		default:
			break;
		}

		yystack.pop(yylen);
		yylen = 0;

		/* Shift the result of the reduction. */
		int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
		yystack.push(yystate, yyval);
		return YYNEWSTATE;
	}

	/**
	 * Parse input from the scanner that was specified at object construction time. Return whether the end of the input was reached successfully.
	 *
	 * @return <tt>true</tt> if the parsing succeeds. Note that this does not imply that there were no syntax errors.
	 */
	public boolean parse() throws java.io.IOException

	{

		/* Lookahead token kind. */
		int yychar = YYEMPTY_;
		/* Lookahead symbol kind. */
		SymbolKind yytoken = null;

		/* State. */
		int yyn = 0;
		int yylen = 0;
		int yystate = 0;
		YYStack yystack = new YYStack();
		int label = YYNEWSTATE;

		/* Semantic value of the lookahead. */
		Object yylval = null;

		yyerrstatus_ = 0;
		yynerrs = 0;

		/* Initialize the stack. */
		yystack.push(yystate, yylval);

		for (;;)
			switch (label) {
			/*
			 * New state. Unlike in the C/C++ skeletons, the state is already pushed when we come here.
			 */
			case YYNEWSTATE:

				/* Accept? */
				if (yystate == YYFINAL_)
					return true;

				/* Take a decision. First try without lookahead. */
				yyn = yypact_[yystate];
				if (yyPactValueIsDefault(yyn)) {
					label = YYDEFAULT;
					break;
				}

				/* Read a lookahead token. */
				if (yychar == YYEMPTY_) {

					yychar = yylexer.yylex();
					yylval = yylexer.getLVal();

				}

				/* Convert token to internal form. */
				yytoken = yytranslate_(yychar);

				if (yytoken == SymbolKind.S_YYerror) {
					// The scanner already issued an error message, process directly
					// to error recovery. But do not keep the error token as
					// lookahead, it is too special and may lead us to an endless
					// loop in error recovery. */
					yychar = Lexer.YYUNDEF;
					yytoken = SymbolKind.S_YYUNDEF;
					label = YYERRLAB1;
				} else {
					/*
					 * If the proper action on seeing token YYTOKEN is to reduce or to detect an error, take that action.
					 */
					yyn += yytoken.getCode();
					if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
						label = YYDEFAULT;
					}

					/* <= 0 means reduce or error. */
					else if ((yyn = yytable_[yyn]) <= 0) {
						if (yyTableValueIsError(yyn)) {
							label = YYERRLAB;
						} else {
							yyn = -yyn;
							label = YYREDUCE;
						}
					}

					else {
						/* Shift the lookahead token. */
						/* Discard the token being shifted. */
						yychar = YYEMPTY_;

						/*
						 * Count tokens shifted since error; after three, turn off error status.
						 */
						if (yyerrstatus_ > 0)
							--yyerrstatus_;

						yystate = yyn;
						yystack.push(yystate, yylval);
						label = YYNEWSTATE;
					}
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
				label = yyaction(yyn, yystack, yylen);
				yystate = yystack.stateAt(0);
				break;

			/*------------------------------------.
			| yyerrlab -- here on detecting error |
			`------------------------------------*/
			case YYERRLAB:
				/* If not already recovering from an error, report this error. */
				if (yyerrstatus_ == 0) {
					++yynerrs;
					if (yychar == YYEMPTY_)
						yytoken = null;
					yyreportSyntaxError(new Context(this, yystack, yytoken));
				}

				if (yyerrstatus_ == 3) {
					/*
					 * If just tried and failed to reuse lookahead token after an error, discard it.
					 */

					if (yychar <= Lexer.YYEOF) {
						/* Return failure if at end of input. */
						if (yychar == Lexer.YYEOF)
							return false;
					} else
						yychar = YYEMPTY_;
				}

				/*
				 * Else will try to reuse lookahead token after shifting the error token.
				 */
				label = YYERRLAB1;
				break;

			/*-------------------------------------------------.
			| errorlab -- error raised explicitly by YYERROR.  |
			`-------------------------------------------------*/
			case YYERROR:
				/*
				 * Do not reclaim the symbols of the rule which action triggered this YYERROR.
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
				yyerrstatus_ = 3; /* Each real token shifted decrements this. */

				// Pop stack until we find a state that shifts the error token.
				for (;;) {
					yyn = yypact_[yystate];
					if (!yyPactValueIsDefault(yyn)) {
						yyn += SymbolKind.S_YYerror.getCode();
						if (0 <= yyn && yyn <= YYLAST_ && yycheck_[yyn] == SymbolKind.S_YYerror.getCode()) {
							yyn = yytable_[yyn];
							if (0 < yyn)
								break;
						}
					}

					/*
					 * Pop the current state because it cannot handle the error token.
					 */
					if (yystack.height == 0)
						return false;

					yystack.pop();
					yystate = yystack.stateAt(0);
				}

				if (label == YYABORT)
					/* Leave the switch. */
					break;

				/* Shift the error token. */

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

	/**
	 * Information needed to get the list of expected tokens and to forge a syntax error diagnostic.
	 */
	public static final class Context {
		Context(SQLHintsParser parser, YYStack stack, SymbolKind token) {
			yyparser = parser;
			yystack = stack;
			yytoken = token;
		}

		private SQLHintsParser yyparser;
		private YYStack yystack;

		/**
		 * The symbol kind of the lookahead token.
		 */
		public final SymbolKind getToken() {
			return yytoken;
		}

		private SymbolKind yytoken;
		static final int NTOKENS = SQLHintsParser.YYNTOKENS_;

		/**
		 * Put in YYARG at most YYARGN of the expected tokens given the current YYCTX, and return the number of tokens stored in YYARG. If YYARG is null, return the
		 * number of expected tokens (guaranteed to be less than YYNTOKENS).
		 */
		int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
			return getExpectedTokens(yyarg, 0, yyargn);
		}

		int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
			int yycount = yyoffset;
			int yyn = yypact_[this.yystack.stateAt(0)];
			if (!yyPactValueIsDefault(yyn)) {
				/*
				 * Start YYX at -YYN if negative to avoid negative indexes in YYCHECK. In other words, skip the first -YYN actions for this state because they are default
				 * actions.
				 */
				int yyxbegin = yyn < 0 ? -yyn : 0;
				/* Stay within bounds of both yycheck and yytname. */
				int yychecklim = YYLAST_ - yyn + 1;
				int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
				for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
					if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode() && !yyTableValueIsError(yytable_[yyx + yyn])) {
						if (yyarg == null)
							yycount += 1;
						else if (yycount == yyargn)
							return 0; // FIXME: this is incorrect.
						else
							yyarg[yycount++] = SymbolKind.get(yyx);
					}
			}
			if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
				yyarg[yycount] = null;
			return yycount - yyoffset;
		}
	}

	/**
	 * Build and emit a "syntax error" message in a user-defined way.
	 *
	 * @param ctx The context of the error.
	 */
	private void yyreportSyntaxError(Context yyctx) {
		yyerror("syntax error");
	}

	/**
	 * Whether the given <code>yypact_</code> value indicates a defaulted state.
	 *
	 * @param yyvalue the value to check
	 */
	private static boolean yyPactValueIsDefault(int yyvalue) {
		return yyvalue == yypact_ninf_;
	}

	/**
	 * Whether the given <code>yytable_</code> value indicates a syntax error.
	 *
	 * @param yyvalue the value to check
	 */
	private static boolean yyTableValueIsError(int yyvalue) {
		return yyvalue == yytable_ninf_;
	}

	private static final byte yypact_ninf_ = -65;
	private static final short yytable_ninf_ = -1;

	/*
	 * YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing STATE-NUM.
	 */
	private static final byte[] yypact_ = yypact_init();

	private static final byte[] yypact_init() {
		return new byte[] { 50, -34, -17, -15, -65, -65, -65, -65, -65, -65, -65, -13, -65, 36, 38, 55, -65, -65, 57, 59, 64, 72, -65, -65, 81, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65,
				-65, -65, -65, 104, -1, -65, -65, -65, -65, -65, 82, 83, 84, 85, -65, -65, -65, -65, 17, 103, 105, 107, 105, 105, -27, 22, 51, 105, -2, -65, 100, -65, -65, 79, 92, 94, 94, 87, 90, -65,
				116, 91, 116, 26, 105, 110, 93, 95, -65, 110, 97, 110, 98, 99, -65, -65, 101, -65, 110, 102, 110, 106, 112, -65, 113, 113, -65, -65, -65, -65, -65, -65, 6, -65, -65, 78, -65, -65, 108,
				-65, -65, 109, 111, -65, -65, 118, 114, -65, 115, -65, -65, 67, 117, -65, 119, -65, -65, -65, 120, 121, -65, 123, -65, 116, -65, -65, -65, 110, -65, -65, -65, -65, -65, -65, -65, -65,
				-65, -65, -65, 124, -65, -65, -65, 113, -65, -65, -65, -65, -65 };
	}

	/*
	 * YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM. Performed when YYTABLE does not specify something else to do. Zero means the default is
	 * an error.
	 */
	private static final byte[] yydefact_ = yydefact_init();

	private static final byte[] yydefact_init() {
		return new byte[] { 0, 0, 0, 0, 59, 60, 64, 65, 77, 78, 70, 0, 69, 0, 0, 0, 62, 67, 0, 0, 0, 0, 71, 79, 0, 72, 80, 61, 66, 73, 81, 74, 82, 75, 83, 76, 84, 63, 68, 0, 0, 5, 11, 9, 8, 7, 0, 0,
				0, 0, 10, 12, 13, 4, 0, 0, 32, 0, 32, 32, 15, 15, 15, 32, 0, 1, 0, 2, 6, 15, 15, 0, 0, 0, 0, 33, 44, 0, 44, 0, 32, 19, 0, 16, 17, 19, 0, 19, 0, 0, 89, 88, 0, 3, 19, 0, 19, 0, 0, 30,
				23, 23, 14, 87, 50, 47, 48, 49, 0, 45, 85, 0, 52, 51, 0, 29, 28, 0, 20, 21, 37, 0, 0, 39, 0, 41, 43, 0, 0, 53, 0, 55, 31, 27, 0, 24, 25, 0, 35, 0, 34, 36, 38, 0, 18, 40, 42, 90, 93,
				94, 92, 91, 97, 95, 96, 0, 54, 56, 57, 0, 58, 46, 22, 86, 26 };
	}

	/* YYPGOTO[NTERM-NUM]. */
	private static final byte[] yypgoto_ = yypgoto_init();

	private static final byte[] yypgoto_init() {
		return new byte[] { -65, -65, -65, 125, -65, 52, -65, 24, -65, 54, -65, 0, 15, -64, 89, 27, -65, 86, 28, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65, -65 };
	}

	/* YYDEFGOTO[NTERM-NUM]. */
	private static final short[] yydefgoto_ = yydefgoto_init();

	private static final short[] yydefgoto_init() {
		return new short[] { 0, 39, 40, 41, 42, 82, 83, 117, 118, 134, 135, 136, 119, 84, 100, 76, 43, 108, 109, 114, 44, 45, 46, 47, 48, 49, 50, 51, 52, 92, 152, 153, 154, 155 };
	}

	/*
	 * YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM. If positive, shift that token. If negative, reduce the rule whose number is the opposite. If
	 * YYTABLE_NINF, syntax error.
	 */
	private static final short[] yytable_ = yytable_init();

	private static final short[] yytable_init() {
		return new short[] { 66, 90, 2, 3, 4, 5, 53, 99, 99, 80, 81, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 91, 112, 54, 113, 55, 67, 56, 29, 30, 31,
				32, 33, 34, 35, 36, 37, 38, 1, 73, 2, 3, 4, 5, 144, 80, 85, 138, 139, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 78, 79, 80, 87, 57, 89,
				58, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 147, 148, 65, 149, 150, 115, 59, 122, 60, 124, 61, 86, 88, 80, 94, 62, 128, 151, 130, 95, 97, 104, 105, 63, 106, 107, 80, 96, 80, 98, 140,
				139, 64, 69, 70, 71, 72, 74, 93, 102, 75, 77, 103, 110, 116, 120, 132, 133, 121, 123, 125, 126, 80, 137, 129, 127, 162, 164, 131, 101, 141, 142, 111, 68, 143, 161, 145, 146, 0, 156, 0,
				157, 158, 0, 159, 160, 163 };
	}

	private static final short[] yycheck_ = yycheck_init();

	private static final short[] yycheck_init() {
		return new short[] { 1, 3, 3, 4, 5, 6, 40, 71, 72, 36, 37, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 36, 9, 53, 11, 53, 40, 53, 42, 43, 44,
				45, 46, 47, 48, 49, 50, 51, 1, 35, 3, 4, 5, 6, 121, 36, 37, 54, 55, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 58, 59, 36, 37, 53, 63,
				53, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 35, 36, 0, 38, 39, 80, 53, 85, 53, 87, 53, 61, 62, 36, 37, 53, 94, 52, 96, 69, 70, 7, 8, 53, 10, 11, 36, 37, 36, 37, 54, 55, 53, 53, 53, 53,
				53, 36, 40, 54, 37, 36, 54, 54, 36, 54, 36, 36, 55, 54, 54, 54, 36, 101, 54, 56, 143, 159, 54, 72, 54, 54, 78, 40, 55, 139, 54, 54, -1, 54, -1, 54, 54, -1, 55, 54, 54 };
	}

	/*
	 * YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of state STATE-NUM.
	 */
	private static final byte[] yystos_ = yystos_init();

	private static final byte[] yystos_init() {
		return new byte[] { 0, 1, 3, 4, 5, 6, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 58, 59, 60, 61, 73,
				77, 78, 79, 80, 81, 82, 83, 84, 85, 40, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 0, 1, 40, 60, 53, 53, 53, 53, 35, 36, 37, 72, 36, 72, 72, 36, 37, 62, 63, 70, 37, 62, 37, 62, 72, 3,
				36, 86, 40, 37, 62, 37, 62, 37, 70, 71, 71, 54, 54, 7, 8, 10, 11, 74, 75, 54, 74, 9, 11, 76, 72, 36, 64, 65, 69, 54, 55, 64, 54, 64, 54, 54, 56, 64, 54, 64, 54, 36, 36, 66, 67, 68, 66,
				54, 55, 54, 54, 54, 55, 70, 54, 54, 35, 36, 38, 39, 52, 87, 88, 89, 90, 54, 54, 54, 55, 54, 75, 69, 54, 68 };
	}

	/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM. */
	private static final byte[] yyr1_ = yyr1_init();

	private static final byte[] yyr1_init() {
		return new byte[] { 0, 57, 58, 58, 58, 59, 59, 60, 60, 60, 60, 60, 60, 60, 61, 62, 62, 63, 63, 64, 64, 65, 65, 66, 66, 67, 67, 68, 69, 70, 71, 71, 72, 72, 73, 73, 73, 73, 73, 73, 73, 73, 73,
				73, 74, 74, 74, 75, 75, 75, 75, 76, 76, 77, 77, 77, 77, 78, 78, 79, 79, 79, 79, 79, 80, 80, 80, 80, 80, 81, 81, 81, 81, 81, 81, 81, 81, 82, 82, 82, 82, 82, 82, 82, 82, 83, 84, 85, 86,
				86, 87, 87, 87, 88, 88, 89, 90, 90 };
	}

	/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM. */
	private static final byte[] yyr2_ = yyr2_init();

	private static final byte[] yyr2_init() {
		return new byte[] { 0, 2, 2, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 4, 0, 1, 1, 3, 0, 1, 1, 3, 0, 1, 1, 3, 1, 1, 2, 1, 2, 0, 1, 5, 5, 5, 4, 5, 4, 5, 4, 5, 4, 0, 1, 3, 1, 1, 1, 1, 1, 1, 4, 5, 4, 5,
				5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 6, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	}

	/*
	 * YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM as returned by yylex, with out-of-bounds checking.
	 */
	private static final SymbolKind yytranslate_(int t) {
		// Last valid token kind.
		int code_max = 1050;
		if (t <= 0)
			return SymbolKind.S_YYEOF;
		else if (t <= code_max)
			return SymbolKind.get(yytranslate_table_[t]);
		else
			return SymbolKind.S_YYUNDEF;
	}

	private static final byte[] yytranslate_table_ = yytranslate_table_init();

	private static final byte[] yytranslate_table_init() {
		return new byte[] { 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 53, 54, 2, 2, 55, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 56, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
				29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 2 };
	}

	private static final int YYLAST_ = 178;
	private static final int YYEMPTY_ = -2;
	private static final int YYFINAL_ = 65;
	private static final int YYNTOKENS_ = 57;

//	public static boolean parseInt(long to, int from, int fromLength) {
//		int error;
//		int end = from + fromLength;
//		to = myStrtoll10(from, end, error);
//		return error != 0 || end != (from + fromLength);
//	}

}
