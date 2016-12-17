package com.shishu.codegenerate.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>内容摘要: 数据库列相关信息</p>
 * <p>完成日期: 2013年9月7日 下午5:09:03</p>
 * <p>修改记录:</p>
 * <pre>
 *    修改日期:
 *    修 改 人:
 *    修改内容:
 * </pre>
 * @author   qiaoel@zjhcsoft.com
 */
public class Column {
	
	private String columnName;
	private String columnType;
	private String columnDateType;
	private String columnKey;
	private String dataType;
	private String columnCommnet;
	
	private String fieldName;
	private String fieldType;
	private String getName;
	private String setName;
	
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnDateType() {
		return columnDateType;
	}
	public void setColumnDateType(String columnDateType) {
		this.columnDateType = columnDateType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColumnCommnet() {
		return columnCommnet;
	}
	public void setColumnCommnet(String columnCommnet) {
		this.columnCommnet = columnCommnet;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getGetName() {
		return getName;
	}
	public void setGetName(String getName) {
		this.getName = getName;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	
	/**
	 * 
	 * @date：2013年9月7日
	 * @Description：命名惯例转换
	 * @param type
	 * @return
	 */
	public  String getJavaType(){
		String type = getDataType();
		if(isBlank(type)){
			return null;
		}
		String javaType = map.get(type.toUpperCase());
		return javaType;
	}
	
	public static boolean isBlank(String v){
		if(null == v || "".equals(v)){
			return true;
		}else{
			return false;
		}
		
	}
	
	static Map<String,String> map;
	static{
		map = new HashMap<String,String>();
		map.put("CHAR","String");
		map.put("VARCHAR","String");
		map.put("BLOB","String");
		map.put("TEXT","String");
		map.put("ENUM","String");

		map.put("FLOAT","Double");
		map.put("REAL","Double");
		map.put("DOUBLE","Double");
		map.put("PRECISION","Integer");
		map.put("NUMERIC","Integer");
		map.put("DECIMAL","Integer");
		map.put("TINYINT","Integer");
		map.put("SMALLINT","Integer");
		map.put("INT","Integer");
		map.put("MEDIUMINT","Integer");
		map.put("INTEGER","Integer");
		map.put("BIGINT","Long");

		map.put("DATE","java.util.Date");
		map.put("TIME","java.util.Date");
		map.put("DATETIME","java.util.Date");
		map.put("TIMESTAMP","java.util.Date");
	}

}
