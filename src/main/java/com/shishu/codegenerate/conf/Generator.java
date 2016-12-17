package com.shishu.codegenerate.conf;

/**
 * 
 * <p>内容摘要: 代码生成单元，表示需要生成的组件代码，如dao、service等</p>
 * <p>完成日期: 2013年9月7日 下午5:13:03</p>
 * <p>修改记录:</p>
 * <pre>
 *    修改日期:
 *    修 改 人:
 *    修改内容:
 * </pre>
 * @author   qiaoel@zjhcsoft.com
 */
public class Generator {
	
	private String type;
	private String targetPackage;
	private String targetProject;
	private String template;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */

	public Generator() {
	}

	public String getTargetPackage() {
		return targetPackage;
	}

	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}

	public String getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(String targetProject) {
		this.targetProject = targetProject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
