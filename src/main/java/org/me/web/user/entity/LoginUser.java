package org.me.web.user.entity;

import java.io.Serializable;

/**
 * loginUser
 * @author cheng_bo
 * @date:2015年5月24日 21:27:01
 */
public class LoginUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String strLoginId;					// 登录id（字母小写）
	private String strPassword;					// 密码
	private Integer nState;							// 状态,0-待审核,1-正常,2-禁用

	public String getStrLoginId() {
		return strLoginId;
	}

	public void setStrLoginId(String strLoginId) {
		this.strLoginId = strLoginId;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public Integer getnState() {
		return nState;
	}

	public void setnState(Integer nState) {
		this.nState = nState;
	}
}
