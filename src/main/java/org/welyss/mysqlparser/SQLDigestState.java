package org.welyss.mysqlparser;

/**
 * State data storage for @c digest_start, @c digest_add_token. This structure
 * extends the @c sql_digest_storage structure with temporary state used only
 * during parsing.
 */
public class SQLDigestState {
	/**
	 * Index, in the digest token array, of the last identifier seen. Reduce
	 * rules used in the digest computation can not apply to tokens seen before
	 * an identifier.
	 * 
	 * @sa digest_add_token
	 */
	int mLastIdIndex;
	SQLDigestStorage mDigestStorage;

	public SQLDigestState() {
		mDigestStorage = new SQLDigestStorage();
	}

	void reset(char[] token_array, int length) {
		mLastIdIndex = 0;
		mDigestStorage.reset(length);
	}

	boolean isEmpty() {
		return mDigestStorage.isEmpty();
	}
}
