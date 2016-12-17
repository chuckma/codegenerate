package com.shishu.codegenerate.conf;

/**
 * 
 * <p>内容摘要: 表信息</p>
 * <p>完成日期: 2013年9月7日 下午5:10:49</p>
 * <p>修改记录:</p>
 * <pre>
 *    修改日期:
 *    修 改 人:
 *    修改内容:
 * </pre>
 * @author   qiaoel@zjhcsoft.com
 */
public class Table {
	private String schema;
	private String tableName;
	private String className;
	private String fieldName;
	private String idFieldName;
	private String idCoulmnName;
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */

	public Table() {}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getIdFieldName() {
		return idFieldName;
	}

	public void setIdFieldName(String idFieldName) {
		this.idFieldName = idFieldName;
	}

	public String getIdCoulmnName() {
		return idCoulmnName;
	}

	public void setIdCoulmnName(String idCoulmnName) {
		this.idCoulmnName = idCoulmnName;
	}

}
