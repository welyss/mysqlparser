package org.welyss.mysqlparser.v84;

/**
 * Convert from struct CHARSET_INFO in m_ctype.h
 */
public class CharsetInfo {
	int number;
	int primaryNumber;
	int binaryNumber;
	int state;
	public static char csname;
	public static char mCollName;
	public static char comment;
	public static char tailoring;
//	Coll_param collParam;
	public static int ctype;
	public static int toLower;
	public static int toUpper;
	public static int sortOrder;
//	MY_UCA_INFO uca; /* This can be changed in apply_one_rule() */
	public static long tabToUni;
//	public static final MY_UNI_IDX tabFromUni;
//	public static final MY_UNICASE_INFO caseinfo;
	public static final LexStateMapsSt stateMaps; /* parser internal data */
	public static int identMap; /* parser internal data */
	int strxfrmMultiply;
	int caseupMultiply;
	int casednMultiply;
	int mbminlen;
	int mbmaxlen;
	int mbmaxlenlen;
//	my_wc_t minSortChar;
//	my_wc_t maxSortChar; /* For LIKE optimization */
	int pad_char;
	boolean escape_with_backslash_is_dangerous;
	int levels_for_compare;

//	MY_CHARSET_HANDLER cset;
//	MY_COLLATION_HANDLER coll;

	/**
	 * If this collation is PAD_SPACE, it collates as if all inputs were padded with
	 * a given number of spaces at the end (see the "num_codepoints" flag to
	 * strnxfrm). NO_PAD simply compares unextended strings.
	 *
	 * Note that this is fundamentally about the behavior of coll->strnxfrm.
	 */
//	PadAttribute padAttribute;
}
