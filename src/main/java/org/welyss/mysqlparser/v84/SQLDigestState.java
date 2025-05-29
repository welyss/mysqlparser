package org.welyss.mysqlparser.v84;

public class SQLDigestState {
	/**
	 * Index, in the digest token array, of the last identifier seen. Reduce rules
	 * used in the digest computation can not apply to tokens seen before an
	 * identifier.
	 * 
	 * @sa digest_add_token
	 */
	int mLastIdIndex;
	SQLDigestStorage mDigestStorage;

	void reset(char token_array, int length) {
		mLastIdIndex = 0;
		mDigestStorage.reset(token_array, length);
	}

	boolean isEmpty() {
		return mDigestStorage.isEmpty();
	}
}
