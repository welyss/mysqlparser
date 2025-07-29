package org.welyss.mysqlparser;

import java.util.List;

import org.welyss.mysqlparser.items.TableIdent;

public interface SQLInfo {

//	public String getSQL();
//
//	public void setSQL(String sql);
//
//	public String getAlterCommand();
//
//	public void setAlterCommand(String alterCommand);
//
	public SQLCommand getSQLCommand();
//
//	public void setSQLCommand(SQLCommand sqlCommand);
//
	public List<TableIdent> getTableIdents();
//
//	public void setTableIdents(List<TableIdent> tableIdents);

	public long getAlterFlags();
}
