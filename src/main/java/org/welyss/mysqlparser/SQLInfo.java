package org.welyss.mysqlparser;

import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public interface SQLInfo {

	/**
	 * Get query sql.
	 * @return
	 */
	public String getSQL();

	/**
	 * Get query type.
	 * @return
	 */
	SQLCommand getSQLCommand();

	/**
	 * Get tables in the query.
	 * @return
	 */
	List<TableIdent> getTableIdents();

	/**
	 * Get type of alter statement.
	 * @return
	 */
	long getAlterFlags();

	/**
	 * Get command of alter statement.
	 * @return
	 */
	String getAlterCommand();

	/**
	 * Get the query exists where clause.
	 * @return
	 */
	boolean hasWhere();

	/**
	 * Get columns in alter modify/change query.
	 * @return
	 */
	List<AlterColumn> getAlterColumns();
}
