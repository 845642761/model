package org.me.web.user.dao;

import org.me.web.user.entity.LoginUser;

public interface ILoginUserDao {
	public int save(LoginUser loginUser);
	public int selectSize(LoginUser user);
	public LoginUser get(String id);
}
