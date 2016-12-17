package com.shishu.codegenerate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shishu.codegenerate.domain.Column;
import com.shishu.utility.string.StringUtil;


/**
 * 
 * <p>内容摘要: 数据访问对象</p>
 * <p>完成日期: 2013年9月7日 下午5:09:45</p>
 * <p>修改记录:</p>
 * <pre>
 *    修改日期:
 *    修 改 人:
 *    修改内容:
 * </pre>
 * @author   qiaoel@zjhcsoft.com
 */
public class JdbcDao {
	String url;
	String userName;
	String password;
	String driver;
	Connection con;

	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: 构建dao</p> 
	 * @param url
	 * @param userName
	 * @param password
	 * @param driver
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public JdbcDao(String url, String userName, String password, String driver)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException {
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.driver = driver;
		Class.forName(driver);
		Class.forName(driver).newInstance();
		this.con = DriverManager.getConnection(url , userName, password);
	}


	public List<Column> getColumns(String sql, String schema, String tableName)
			throws SQLException {
		List<Column> columns = new ArrayList<Column>();

//		ResultSet tables = con.getMetaData().getTables(null, null, tableName, new String[]{"TABLE"});
		//TABLE_NAME 表名称
		//REMARKS  表的解释性注释

//		ResultSet cols = con.getMetaData().getColumns(null, null, tableName, null);
//		while(cols.next()){
//			Column column = new Column();
//			column.setColumnCommnet(cols.getString("REMARKS"));
//			column.setColumnName(cols.getString("COLUMN_NAME"));
//			column.setColumnType(cols.getString("TYPE_NAME"));
//			column.setDataType(cols.getString("DATA_TYPE"));
////			column.setColumnKey(cols.getString("COLUMN_KEY"));
//			columns.add(column);
//		}
		
		Statement stmt = con.createStatement();
		
		if (StringUtil.isBlank(tableName)) {
			throw new java.lang.IllegalArgumentException(
					"tableName is can not Empty!");
		}
		sql = sql.replaceAll("\\$\\{TABLE_NAME\\}", tableName);
		if (!StringUtil.isBlank(schema)) {
			sql = sql.replaceAll("\\$\\{TABLE_SCHEMA\\}", schema);
		}
		//
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if (null == rs) {
				return columns;
			}
			while (rs.next()) {
				Column column = new Column();
				column.setColumnCommnet(rs.getString("COLUMN_COMMENT"));
				column.setColumnName(rs.getString("COLUMN_NAME"));
				column.setColumnType(rs.getString("COLUMN_TYPE"));
				column.setDataType(rs.getString("DATA_TYPE"));
				column.setColumnKey(rs.getString("COLUMN_KEY"));
				columns.add(column);
			}
		} finally {
			stmt.close();
		}
		return columns;
	}
}
