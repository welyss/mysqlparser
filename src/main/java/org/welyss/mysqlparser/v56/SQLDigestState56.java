package org.welyss.mysqlparser.v56;

/**
 * State data storage for @c digest_start, @c digest_add_token. This structure
 * extends the @c sql_digest_storage structure with temporary state used only
 * during parsing.
 */
public class SQLDigestState56 {
	/**
	 * Index, in the digest token array, of the last identifier seen. Reduce
	 * rules used in the digest computation can not apply to tokens seen before
	 * an identifier.
	 * 
	 * @sa digest_add_token
	 */
	int mLastIdIndex;
	SQLDigestStorage56 mDigestStorage;

	public SQLDigestState56() {
		mDigestStorage = new SQLDigestStorage56();
	}

	void reset(char[] token_array, int length) {
		mLastIdIndex = 0;
		mDigestStorage.reset(length);
	}

	boolean isEmpty() {
		return mDigestStorage.isEmpty();
	}
}
