package org.me.web.user.service;

import org.me.core.common.Resoult;
import org.me.web.user.entity.LoginUser;

/**
 * LoginUserService
 * @author cheng_bo
 * @date:2015年5月24日 21:43:17
 */
public interface ILoginUserService {
	public Resoult save(LoginUser user);//添加
	public boolean loginIdIsExit(String strLoginId);//用户帐号是否已存在
	public LoginUser getByLoginId(String strLoginId);//根据strLoginId获取用户
}
