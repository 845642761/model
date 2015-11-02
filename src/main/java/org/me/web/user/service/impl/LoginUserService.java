package org.me.web.user.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.core.exception.ServiceExecption;
import org.me.plugin.security.MD5;
import org.me.web.user.dao.ILoginUserDao;
import org.me.web.user.entity.LoginUser;
import org.me.web.user.service.ILoginUserService;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements ILoginUserService{

	private Logger logger = Logger.getLogger(LoginUserService.class);
	@Resource
	private ILoginUserDao loginUserDao;
	
	@Override
	public Resoult save(LoginUser loginUser) {
		Resoult resoult=new Resoult();
		resoult.setName("LoginUserService.save");
		try {
			MD5 md5=new MD5();
			loginUser.setStrPassword(md5.toMd5(loginUser.getStrPassword()));
			loginUserDao.save(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new ServiceExecption("保存失败！");
		}
		resoult.setInfo("保存成功！");
		logger.debug("LoginUserService.save successful!");
		return resoult;
	}

	/**
	 * 用户帐号是否已存在
	 * @author cheng_bo
	 * @date 2015年5月26日 11:03:05
	 * @param 用户帐号
	 * @return 存在：true	不存在：false
	 */
	@Override
	public boolean loginIdIsExit(String strLoginId) {
		LoginUser user = new LoginUser();
		user.setStrLoginId(strLoginId);
		int size=0;
		try {
			size=loginUserDao.selectSize(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new ServiceExecption("查询失败！");
		}
		if(size <= 0)
			return false;
		else
			return true;
	}
	
	/**
	 * 根据strLoginId获取用户
	 * @author: chengbo
	 * @date: 2015年8月11日 14:01:52
	 */
	@Override
	public LoginUser getByLoginId(String strLoginId) {
		LoginUser u = null;
		try {
			u = loginUserDao.get(strLoginId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new ServiceExecption("查询失败！");
		}
		return u;
	}

}