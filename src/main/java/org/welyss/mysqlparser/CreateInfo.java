package org.welyss.mysqlparser;

public class CreateInfo {
	public static final long HA_CREATE_USED_AUTO = (1L << 0);
	public static final long HA_CREATE_USED_RAID = (1L << 1); // RAID is no longer availble
	public static final long HA_CREATE_USED_UNION = (1L << 2);
	public static final long HA_CREATE_USED_INSERT_METHOD = (1L << 3);
	public static final long HA_CREATE_USED_MIN_ROWS = (1L << 4);
	public static final long HA_CREATE_USED_MAX_ROWS = (1L << 5);
	public static final long HA_CREATE_USED_AVG_ROW_LENGTH = (1L << 6);
	public static final long HA_CREATE_USED_PACK_KEYS = (1L << 7);
	public static final long HA_CREATE_USED_CHARSET = (1L << 8);
	public static final long HA_CREATE_USED_DEFAULT_CHARSET = (1L << 9);
	public static final long HA_CREATE_USED_DATADIR = (1L << 10);
	public static final long HA_CREATE_USED_INDEXDIR = (1L << 11);
	public static final long HA_CREATE_USED_ENGINE = (1L << 12);
	public static final long HA_CREATE_USED_CHECKSUM = (1L << 13);
	public static final long HA_CREATE_USED_DELAY_KEY_WRITE = (1L << 14);
	public static final long HA_CREATE_USED_ROW_FORMAT = (1L << 15);
	public static final long HA_CREATE_USED_COMMENT = (1L << 16);
	public static final long HA_CREATE_USED_PASSWORD = (1L << 17);
	public static final long HA_CREATE_USED_CONNECTION = (1L << 18);
	public static final long HA_CREATE_USED_KEY_BLOCK_SIZE = (1L << 19);
	/** Unused. Reserved for future versions. */
	public static final long HA_CREATE_USED_TRANSACTIONAL = (1L << 20);
	/** Unused. Reserved for future versions. */
	public static final long HA_CREATE_USED_PAGE_CHECKSUM = (1L << 21);
	/**
	 * This is set whenever STATS_PERSISTENT=0|1|default has been specified in
	 * CREATE/ALTER TABLE. See also HA_OPTION_STATS_PERSISTENT in include/my_base.h.
	 * It is possible to distinguish whether STATS_PERSISTENT=default has been
	 * specified or no STATS_PERSISTENT= is given at all.
	 */
	public static final long HA_CREATE_USED_STATS_PERSISTENT = (1L << 22);
	/**
	 * This is set whenever STATS_AUTO_RECALC=0|1|default has been specified in
	 * CREATE/ALTER TABLE. See enum_stats_auto_recalc. It is possible to distinguish
	 * whether STATS_AUTO_RECALC=default has been specified or no STATS_AUTO_RECALC=
	 * is given at all.
	 */
	public static final long HA_CREATE_USED_STATS_AUTO_RECALC = (1L << 23);
	/**
	 * This is set whenever STATS_SAMPLE_PAGES=N|default has been specified in
	 * CREATE/ALTER TABLE. It is possible to distinguish whether
	 * STATS_SAMPLE_PAGES=default has been specified or no STATS_SAMPLE_PAGES= is
	 * given at all.
	 */
	public static final long HA_CREATE_USED_STATS_SAMPLE_PAGES = (1L << 24);
	String comment;
	long usedFields = 0;
}
