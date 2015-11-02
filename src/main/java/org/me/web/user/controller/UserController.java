package org.me.web.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.me.core.common.Resoult;
import org.me.core.common.base.BaseController;
import org.me.web.user.entity.LoginUser;
import org.me.web.user.service.ILoginUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户Controller
 * @author: cheng_bo
 * @date: 2015年7月28日 17:58:57
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private ILoginUserService loginUserService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/user/login");
	}
	
	@RequestMapping("/regist")
	public ModelAndView regist(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/user/regist");
	}
	
	/**
	 * 用户登录
	 * @author cheng_bo
	 * @date 2015年6月5日 17:00:42
	 */
	@RequestMapping("/ssoLogin")
	@ResponseBody
	public Resoult ssoLogin(LoginUser lUser,HttpServletRequest request){
		Resoult resoult=new Resoult();
		resoult.setName("UserController.ssoLogin");
		resoult.setCode(-1);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(lUser.getStrLoginId(), lUser.getStrPassword());
		try {
			subject.login(token);
        	resoult.setCode(0);
		}catch (UnknownAccountException e) {
			resoult.setInfo("帐号不存在！");
		}catch (IncorrectCredentialsException e) {
			resoult.setInfo("密码验证错误！");
		}catch (LockedAccountException e) {
			if("2".equals(e.getMessage())){
				resoult.setInfo("帐号已禁用！");
			}else if("0".equals(e.getMessage())) {
				resoult.setInfo("帐号审核中！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			resoult.setInfo("登录失败！");
		}
		return resoult;
	}
	
	/**
	 * 注册登录用户
	 * @author cheng_bo
	 * @date 2015年6月5日 21:38:30
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Resoult saveLoginUser(LoginUser user){
		String strLoginId = user.getStrLoginId();
		String strPassword = user.getStrPassword();
		Resoult resoult=new Resoult();
		resoult.setName("UserController.saveLoginUser");
		resoult.setCode(-1);
		if(StringUtils.isEmpty(strLoginId)){
			resoult.setInfo("请输入用户名！");
			return resoult;
		}
		if(StringUtils.isEmpty(strPassword)){
			resoult.setInfo("请输入密码！");
			return resoult;
		}
		
		boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
		if(loginIdIsExit){
			resoult.setInfo("用户帐号已存在！");
			return resoult;
		}

		user.setnState(0);
		resoult=loginUserService.save(user);
		return resoult;
	}
	
	/**
	 * 用户帐号是否已存在
	 * @author cheng_bo
	 * @throws IOException 
	 * @date:2015年5月26日 10:23:42
	 */
	@RequestMapping("/loginIdIsExit")
	@ResponseBody
	public Resoult loginIdIsExit(LoginUser user){
		String strLoginId=user.getStrLoginId();
		Resoult resoult=new Resoult();
		resoult.setName("UserController.loginIdIsExit");
		resoult.setCode(-1);
		
		if(!StringUtils.hasText(strLoginId))
		{
			resoult.setInfo("请输入用户帐号！");
			return resoult;
		}
		
		boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
		if(loginIdIsExit){
			resoult.setInfo("用户帐号已存在！");
			return resoult;
		}
		resoult.setCode(0);
		resoult.setInfo("帐号可以使用！");
		return resoult;
	}
}