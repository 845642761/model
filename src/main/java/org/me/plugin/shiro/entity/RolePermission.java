package org.me.plugin.shiro.entity;

import java.io.Serializable;

public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;
	private String strId;//主键Id
	private String strRoleId;//角色Id
	private String strPermissionId;//权限Id
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrRoleId() {
		return strRoleId;
	}
	public void setStrRoleId(String strRoleId) {
		this.strRoleId = strRoleId;
	}
	public String getStrPermissionId() {
		return strPermissionId;
	}
	public void setStrPermissionId(String strPermissionId) {
		this.strPermissionId = strPermissionId;
	}
}
