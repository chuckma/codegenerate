package com.shishu.codegenerate.conf;

import java.util.List;

/**
 * 
 * <p>内容摘要: 代码生成配置信息</p>
 * <p>完成日期: 2013年9月7日 下午5:13:53</p>
 * <p>修改记录:</p>
 * <pre>
 *    修改日期:
 *    修 改 人:
 *    修改内容:
 * </pre>
 * @author   qiaoel@zjhcsoft.com
 */
public class Config {
	private JdbcConnection jdbcConnection;
	private List<Generator> generators;
	private List<Table> tables;


	public Config() {}


	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}


	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}


	public List<Generator> getGenerators() {
		return generators;
	}


	public void setGeneratorList(List<Generator> generators) {
		this.generators = generators;
	}


	public List<Table> getTables() {
		return tables;
	}


	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
}
