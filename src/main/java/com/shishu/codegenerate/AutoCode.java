
package com.shishu.codegenerate;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;

import com.shishu.codegenerate.conf.Config;
import com.shishu.codegenerate.conf.Generator;
import com.shishu.codegenerate.conf.JdbcConnection;
import com.shishu.codegenerate.conf.Table;
import com.shishu.codegenerate.dao.JdbcDao;
import com.shishu.codegenerate.domain.Column;
import com.shishu.codegenerate.util.ConfUtil;
import com.shishu.utility.file.FileUtil;
import com.shishu.utility.log.LogUtil;
import com.shishu.utility.string.StringUtil;

/**
 * 
 * @author lixiaoping
 * 
 * 代码生成启动类
 *
 */
public class AutoCode {
	
	private static Logger log = LogUtil.getLogger(AutoCode.class);
	
	/**
	 * 
	 * @param configPath
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static void compiler(String configPath) throws Exception{
		if(null == configPath || "".equals(configPath)){
			configPath="/config.xml";
		}
		Config config = ConfUtil.parse(AutoCode.class.getResourceAsStream(configPath));
		JdbcConnection jdbcConnection = config.getJdbcConnection();
		//jdbc info
		String url = jdbcConnection.getConnectionURL();
		String userId = jdbcConnection.getUserId();
		String password = jdbcConnection.getPassword();
		String driver = jdbcConnection.getDriverClass();
		String infSql = jdbcConnection.getInfSql();
		JdbcDao columnDao = new JdbcDao(url, userId,password,driver);

		Map<String,Object> generatorContext = new HashMap<String,Object>();
		
		for(Table table:config.getTables()){
			List<Column> columns =columnDao.getColumns(infSql,table.getSchema(), table.getTableName());
			if(null == table.getClassName()){
				table.setClassName(StringUtil.toCamel(table.getTableName()));
			}
			table.setFieldName(StringUtil.toCamel(table.getTableName(),false));
			addFields(columns);
			addTableId(table,columns);
			for(Generator generator :config.getGenerators()){
				
				String targetPackage = generator.getTargetPackage();
				String targetProject = generator.getTargetProject();
				String targetTemplate =  generator.getTemplate();
				String generatorType = generator.getType();
				
				String code = null;
				String classFullName = targetPackage+"."+table.getClassName();
				generatorContext.put(generatorType, classFullName);
				
				String path = targetProject+"/"+StringUtil.packge2path(targetPackage)+"/"+table.getClassName()+ConfUtil.type2Suffix(generatorType);
				try {
					code =mergeTemplate(targetTemplate,targetPackage, table, columns,generatorContext);
					FileUtil.writeFile(path, code);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
		}
			
	}

	private static String mergeTemplate(String targetTemplate, String targetPackage,Table table,List<Column> columns,Map<String,Object> generatorContext) throws Exception{
		Properties p = new Properties();  
		p.setProperty("resource.loader", "class");  
		p.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");  
		
		Velocity.init(p);  
        VelocityContext context = new VelocityContext();  
        context.put("columns", columns);  
        context.put("targetPackage", targetPackage);
        context.put("tableName", table.getTableName());
        context.put("className", table.getClassName());
        context.put("idFieldName",table.getIdFieldName());
        context.put("idColumnName", table.getIdCoulmnName());        
        context.put("generatorContext",generatorContext);
       
        StringWriter w = new StringWriter();
        Velocity.mergeTemplate(targetTemplate, "UTF-8", context, w);  
        
        
        return w.getBuffer().toString();
	}
	/**
	 * @date：2013年9月7日
	 * @Description：添加set get方法
	 * @param columns
	 */
	private static void addFields(List<Column> columns){
		for(Column column:columns){
			column.setFieldName(column.getColumnName());
			column.setSetName("set"+StringUtil.toUpperFirst(column.getColumnName()));
			column.setGetName("get"+StringUtil.toUpperFirst(column.getColumnName()));
			column.setFieldType(column.getJavaType());
		}
	}
	/**
	 * @date：2013年9月7日
	 * @Description：查找表的主键字段
	 * @param table
	 * @param columns
	 */
	public static void addTableId(Table table,List<Column> columns){
		for(Column column:columns){
			if(!StringUtil.isBlank(column.getColumnKey())){
				table.setIdFieldName(StringUtil.toCamel(column.getColumnName()));
				table.setIdCoulmnName(column.getColumnName());
			}
		}
	}
	/**
	 * 
	 * @date：2013年9月7日
	 * @Description：程序入口
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
			compiler(null);
	}

}
