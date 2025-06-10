package org.welyss.mysqlparser.v84;

public class SystemVariables {
	/* Bits for different SQL modes modes (including ANSI mode) */
	public static final int MODE_REAL_AS_FLOAT = 1;
	public static final int MODE_PIPES_AS_CONCAT = 2;
	public static final int MODE_ANSI_QUOTES = 4;
	public static final int MODE_IGNORE_SPACE = 8;
	public static final int MODE_NOT_USED = 16;
	public static final int MODE_ONLY_FULL_GROUP_BY = 32;
	public static final int MODE_NO_UNSIGNED_SUBTRACTION = 64;
	public static final int MODE_NO_DIR_IN_CREATE = 128;
	public static final int MODE_ANSI = 0x40000;
	public static final int MODE_NO_AUTO_VALUE_ON_ZERO = MODE_ANSI * 2;
	public static final int MODE_NO_BACKSLASH_ESCAPES = MODE_NO_AUTO_VALUE_ON_ZERO * 2;
	public static final int MODE_STRICT_TRANS_TABLES = MODE_NO_BACKSLASH_ESCAPES * 2;
	public static final int MODE_STRICT_ALL_TABLES = MODE_STRICT_TRANS_TABLES * 2;
	/*
	 * NO_ZERO_DATE, NO_ZERO_IN_DATE and ERROR_FOR_DIVISION_BY_ZERO modes are
	 * removed in 5.7 and their functionality is merged with STRICT MODE. However,
	 * For backward compatibility during upgrade, these modes are kept but they are
	 * not used. Setting these modes in 5.7 will give warning and have no effect.
	 */
	public static final int MODE_NO_ZERO_IN_DATE = MODE_STRICT_ALL_TABLES * 2;
	public static final int MODE_NO_ZERO_DATE = MODE_NO_ZERO_IN_DATE * 2;
	public static final int MODE_INVALID_DATES = MODE_NO_ZERO_DATE * 2;
	public static final int MODE_ERROR_FOR_DIVISION_BY_ZERO = MODE_INVALID_DATES * 2;
	public static final int MODE_TRADITIONAL = MODE_ERROR_FOR_DIVISION_BY_ZERO * 2;
	public static final int MODE_HIGH_NOT_PRECEDENCE = 1 << 29;
	public static final int MODE_NO_ENGINE_SUBSTITUTION = MODE_HIGH_NOT_PRECEDENCE * 2;
	public static final int MODE_PAD_CHAR_TO_FULL_LENGTH = 1 << 31;
	/*
	 * If this mode is set the fractional seconds which cannot fit in given fsp will
	 * be truncated.
	 */
	public static final int MODE_TIME_TRUNCATE_FRACTIONAL = 1 << 32;

	public static final int MODE_LAST = 1 << 33;

	public static final int MODE_ALLOWED_MASK = (MODE_REAL_AS_FLOAT | MODE_PIPES_AS_CONCAT | MODE_ANSI_QUOTES
			| MODE_IGNORE_SPACE | MODE_NOT_USED | MODE_ONLY_FULL_GROUP_BY | MODE_NO_UNSIGNED_SUBTRACTION
			| MODE_NO_DIR_IN_CREATE | MODE_ANSI | MODE_NO_AUTO_VALUE_ON_ZERO | MODE_NO_BACKSLASH_ESCAPES
			| MODE_STRICT_TRANS_TABLES | MODE_STRICT_ALL_TABLES | MODE_NO_ZERO_IN_DATE | MODE_NO_ZERO_DATE
			| MODE_INVALID_DATES | MODE_ERROR_FOR_DIVISION_BY_ZERO | MODE_TRADITIONAL | MODE_HIGH_NOT_PRECEDENCE
			| MODE_NO_ENGINE_SUBSTITUTION | MODE_PAD_CHAR_TO_FULL_LENGTH | MODE_TIME_TRUNCATE_FRACTIONAL);

	public int sqlMode;

	public SystemVariables() {
		sqlMode = MODE_ONLY_FULL_GROUP_BY | MODE_STRICT_TRANS_TABLES | MODE_NO_ZERO_IN_DATE | MODE_NO_ZERO_DATE | MODE_ERROR_FOR_DIVISION_BY_ZERO | MODE_NO_ENGINE_SUBSTITUTION;
	}
}
