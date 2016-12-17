package com.shishu.codegenerate.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.shishu.codegenerate.dao.JdbcDao;
import com.shishu.codegenerate.domain.Column;


public class JdbcDaoTest {

	@Test
	public void testGetColumnsStringString() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	/*	String url = "jdbc:mysql://localhost:3307/test?useUnicode=true&amp;characterset=utf-8";
		String userName = "root";
		String password = "root";
		String driver = "com.mysql.jdbc.Driver";*/
		String url = "jdbc:microsoft:sqlserver://10.80.11.248:1433;DatabaseName=envapp;useUnicode=true&characterEncoding=UTF-8";
		String userName = "sa";
		String password = "Zjhc123";
		String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		
		JdbcDao dao = new JdbcDao(url, userName, password, driver);
		@SuppressWarnings("unused")
		List<Column> columns =dao.getColumns("SELECT (case when a.colorder=1 then d.name else '' end) 表名, a.colorder 字段序号, a.name COLUMN_NAME, (case when COLUMNPROPERTY( a.id,a.name,'IsIdentity')=1 then 'Y'else 'N' end) 标识, (case when (SELECT count(*) FROM sysobjects WHERE (name in (SELECT name FROM sysindexes WHERE (id = a.id) AND (indid in (SELECT indid FROM sysindexkeys WHERE (id = a.id) AND (colid in (SELECT colid FROM syscolumns WHERE (id = a.id) AND (name = a.name) ) ) ) ) ) ) AND (xtype = 'PK') ) > 0 then 'Y' else 'N' end) COLUMN_KEY, b.name COLUMN_TYPE, b.name DATA_TYPE, a.length 占用字节数, COLUMNPROPERTY(a.id,a.name,'PRECISION') as 长度, isnull(COLUMNPROPERTY(a.id,a.name,'Scale'),0) as 小数位数, (case when a.isnullable=1 then 'Y'else 'N' end) IS_NULLABLE, isnull(e.text,'') COLUMN_DEFAULT, isnull(g.[value],'') AS COLUMN_COMMENT FROM  syscolumns a left join systypes b on a.xtype=b.xusertype inner join sysobjects d on a.id=d.id  and  d.xtype='U' and d.name<>'dtproperties' left join syscomments e on a.cdefault=e.id left join sys.extended_properties g on a.id=g.major_id AND a.colid = g.minor_id where d.name in ('${TABLE_NAME}') order by a.id,a.colorder ",null,"sys_dictionary");
	}
	
	
	/*SELECT
(case when a.colorder=1 then d.name else '' end) 表名,
a.colorder 字段序号,
a.name COLUMN_NAME,
(case when COLUMNPROPERTY( a.id,a.name,'IsIdentity')=1 then '√'else '' end) 标识,
(case when (SELECT count(*)
FROM sysobjects
WHERE (name in (SELECT name
FROM sysindexes
WHERE (id = a.id) AND (indid in (SELECT indid
FROM sysindexkeys
WHERE (id = a.id) AND (colid in (SELECT colid
FROM syscolumns
WHERE (id = a.id) AND (name = a.name)
)
)
)
)
)
) AND (xtype = 'PK')
) > 0 then 'Y' else 'N' end) COLUMN_KEY,
b.name COLUMN_TYPE,
b.name DATA_TYPE,
a.length 占用字节数,
COLUMNPROPERTY(a.id,a.name,'PRECISION') as 长度,
isnull(COLUMNPROPERTY(a.id,a.name,'Scale'),0) as 小数位数,
(case when a.isnullable=1 then 'Y'else 'N' end) IS_NULLABLE,
isnull(e.text,'') COLUMN_DEFAULT,
isnull(g.[value],'') AS COLUMN_COMMENT

FROM  syscolumns a
left join systypes b on a.xtype=b.xusertype
inner join sysobjects d on a.id=d.id  and  d.xtype='U' and d.name<>'dtproperties'
left join syscomments e on a.cdefault=e.id
left join sys.extended_properties g on a.id=g.major_id AND a.colid = g.minor_id 
where d.name in ('${TABLE_NAME}')
order by a.id,a.colorder 
	 */
	
	public static void main(String args[]){
		JdbcDaoTest jd = new JdbcDaoTest();
		try {
			jd.testGetColumnsStringString();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
