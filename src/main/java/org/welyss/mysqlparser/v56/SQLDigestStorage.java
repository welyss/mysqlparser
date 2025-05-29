package org.welyss.mysqlparser.v56;

import java.util.ArrayList;
import java.util.List;

public class SQLDigestStorage {
	public static final int MD5_HASH_SIZE = 16;
	public boolean mFull;
	int mByteCount;
	char[] mMd5;
	/** Character set number. */
	int mCharsetNumber;
	/**
	 * Token array. Token array is an array of bytes to store tokens received
	 * during parsing. Following is the way token array is formed. ...
	 * &lt;non-id-token&gt; &lt;non-id-token&gt; &lt;id-token&gt; &lt;id_len&gt;
	 * &lt;id_text&gt; ... For Example: SELECT * FROM T1; &lt;SELECT_TOKEN&gt;
	 * &lt;*&gt; &lt;FROM_TOKEN&gt; &lt;ID_TOKEN&gt; &lt;2&gt; &lt;T1&gt;
	 * 
	 * @note Only the first @c m_byte_count bytes are initialized, out of @c
	 *       m_token_array_length.
	 */
	List<SqlDigestInfo> mTokenArray;
	/*
	 * Length of the token array to be considered for DIGEST_TEXT calculation.
	 */
	int mTokenArrayLength;

	SQLDigestStorage() {
		reset(0);
	}

	void reset(int length) {
		mTokenArrayLength = length;
		reset();
	}

	public void reset() {
		mTokenArray = new ArrayList<SqlDigestInfo>();
		mTokenArrayLength = mTokenArray.size();
		mMd5 = new char[SQLDigestStorage.MD5_HASH_SIZE];
		mFull = false;
		mByteCount = 0;
		mCharsetNumber = 0;
	}

	boolean isEmpty() {
		return (mByteCount == 0);
	}

	void copy(SQLDigestStorage from) {
		/*
		 * Keep in mind this is a dirty copy of something that may change, as
		 * the thread producing the digest is executing concurrently, without
		 * any lock enforced.
		 */
		int byteCountCopy = mTokenArrayLength < from.mByteCount ? mTokenArrayLength : from.mByteCount;

		if (byteCountCopy > 0) {
			mFull = from.mFull;
			mByteCount = byteCountCopy;
			mCharsetNumber = from.mCharsetNumber;
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