package com.shishu.codegenerate.util;

import java.io.InputStream;







import com.shishu.codegenerate.conf.Config;
import com.shishu.codegenerate.conf.Generator;
import com.shishu.codegenerate.conf.JdbcConnection;
import com.shishu.codegenerate.conf.Table;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * <p>内容摘要:配置解析类</p>
 * <p>完成日期: 2013年9月7日 下午5:08:37</p>
 * <p>修改记录:</p>
 * <pre>
 *    修改日期:
 *    修 改 人:
 *    修改内容:
 * </pre>
 * @author   qiaoel@zjhcsoft.com
 */
public class ConfUtil {
	/**
	 * 
	 * @date：2013年9月7日
	 * @Description：方法功能描述
	 * @param xmlConfig
	 * @return
	 */
	public static Config parse(InputStream xmlConfig){
		
		XStream xstream = new XStream();
		
		xstream.alias("config", Config.class);
		xstream.alias("generator", Generator.class);
		xstream.useAttributeFor(Generator.class, "targetPackage");
		xstream.useAttributeFor(Generator.class, "targetProject");
		xstream.useAttributeFor(Generator.class, "template");
		xstream.useAttributeFor(Generator.class, "type");
		
		
		xstream.alias("jdbcconnection", JdbcConnection.class);
		xstream.useAttributeFor(JdbcConnection.class, "connectionURL");
		xstream.useAttributeFor(JdbcConnection.class, "driverClass");
		xstream.useAttributeFor(JdbcConnection.class, "userId");
		xstream.useAttributeFor(JdbcConnection.class, "password");
		xstream.useAttributeFor(JdbcConnection.class, "infSql");
		
		xstream.alias("table", Table.class);
		xstream.useAttributeFor(Table.class, "schema");
		xstream.useAttributeFor(Table.class, "tableName");
		xstream.useAttributeFor(Table.class, "className");
		xstream.useAttributeFor(Table.class, "fieldName");
		
		return (Config)xstream.fromXML(xmlConfig);
	}
	/**
	 * 
	 * @date：2013年9月7日
	 * @Description：数据库类型到java数据类型转换
	 * @param type
	 * @return
	 */
	public static String type2Suffix(String type){
		/*
		 * xml
		 * domain
		 * dao
		 * service
		 * action
		 * vm
		 */
		if("xml".equals(type)){
			return ".xml";
		}else if("dao".equals(type)){
			return "Dao.java";
		}else if("datamodule".equals(type)){
			return ".java";
		}else if("service".equals(type)){
			return "Service.java";
		}else if("action".equals(type)){
			return "Action.java";
		}else if("vm".equals(type)){
			return ".vm";
		}else{
			return "."+type;
		}
	}
}
