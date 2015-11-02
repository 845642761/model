package org.me.plugin.shiro.entity;

import java.io.Serializable;

/**
 * 用户-角色对应
 * @author: cheng_bo
 * @date: 2015年8月6日 10:45:32
 */
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String strId;//主键Id
	private String strLoginId;//用户Id
	private String strRoleId;//角色Id
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrLoginId() {
		return strLoginId;
	}
	public void setStrLoginId(String strLoginId) {
		this.strLoginId = strLoginId;
	}
	public String getStrRoleId() {
		return strRoleId;
	}
	public void setStrRoleId(String strRoleId) {
		this.strRoleId = strRoleId;
	}
	
}
