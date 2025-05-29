package org.welyss.mysqlparser.v84;

public class SQLDigestStorage {
	/**
	 * DIGEST hash size, in bytes. 256 bits, for SHA256.
	 */
	public static final int DIGEST_HASH_SIZE = 32;

	boolean mFull;
	int mByteCount;
	char mHash[] = new char[DIGEST_HASH_SIZE];
	/** Character set number. */
	int mCharsetNumber;
	/**
	 * Token array. Token array is an array of bytes to store tokens received during
	 * parsing. Following is the way token array is formed. ... &lt;non-id-token&gt;
	 * &lt;non-id-token&gt; &lt;id-token&gt; &lt;id_len&gt; &lt;id_text&gt; ... For
	 * Example: SELECT * FROM T1; &lt;SELECT_TOKEN&gt; &lt;*&gt; &lt;FROM_TOKEN&gt;
	 * &lt;ID_TOKEN&gt; &lt;2&gt; &lt;T1&gt;
	 * 
	 * @note Only the first @c mByteCount bytes are initialized, out of @c
	 *       mTokenArrayLength.
	 */
	char mTokenArray;
	/* Length of the token array to be considered for DIGEST_TEXT calculation. */
	int mTokenArrayLength;

	SQLDigestStorage() {
		reset(null, 0);
	}

	void reset(Character tokenArray, int length) {
		mTokenArray = tokenArray;
		mTokenArrayLength = length;
		reset();
	}

	void reset() {
		mFull = false;
		mByteCount = 0;
		mCharsetNumber = 0;
//		memset(mHash, 0, DIGEST_HASH_SIZE);
	}

	boolean isEmpty() {
		return (mByteCount == 0);
	}

	void copy(SQLDigestStorage from) {
		/*
		 * Keep in mind this is a dirty copy of something that may change, as the thread
		 * producing the digest is executing concurrently, without any lock enforced.
		 */
		int byteCountCopy = mTokenArrayLength < from.mByteCount ? mTokenArrayLength : from.mByteCount;

		if (byteCountCopy > 0) {
			mFull = from.mFull;
			mByteCount = byteCountCopy;
			mCharsetNumber = from.mCharsetNumber;
//			memcpy(mTokenArray, from.mTokenArray, mByteCount);
//			memcpy(mHash, from.mHash, DIGEST_HASH_SIZE);
		} else {
			mFull = false;
			mByteCount = 0;
			mCharsetNumber = 0;
		}
	}
}

class SqlDigestInfo {
	int token;
	String idName;

	public SqlDigestInfo(int token, String idName) {
		this.token = token;
		this.idName = idName;
	}

}