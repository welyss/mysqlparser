package org.welyss.mysqlparser.v84;

public enum EnumCommentState {
	/**
	 * Not parsing comments.
	 */
	NO_COMMENT,

	/**
	 * Parsing comments that need to be preserved. (Copy '/' '*' and '*' '/'
	 * sequences to the preprocessed buffer.) Typically, these are user comments '/'
	 * '*' ... '*' '/'.
	 */
	PRESERVE_COMMENT,

	/**
	 * Parsing comments that need to be discarded. (Don't copy '/' '*' '!' and '*'
	 * '/' sequences to the preprocessed buffer.) Typically, these are special
	 * comments '/' '*' '!' ... '*' '/', or '/' '*' '!' 'M' 'M' 'm' 'm' 'm' ... '*'
	 * '/', where the comment markers should not be expanded.
	 */
	DISCARD_COMMENT
}
