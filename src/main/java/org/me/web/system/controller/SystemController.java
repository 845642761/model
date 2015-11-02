package org.me.web.system.controller;

import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.me.core.common.Resoult;
import org.me.core.common.base.BaseController;
import org.me.core.exception.NoLoginExecption;
import org.me.plugin.shiro.entity.Permission;
import org.me.plugin.shiro.service.ISecurityService;
import org.me.web.user.entity.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理Controller
 * @author cheng_bo
 * @date 2015年6月9日 14:18:48
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController {
	
	@Resource
	private ISecurityService securityService;
	
	@RequestMapping("/main")
	public ModelAndView main (HttpServletRequest request) {
		Resoult resoult=new Resoult();
		resoult.setName("SystemController.main");
		resoult.setCode(-1);
		ModelAndView mav=new ModelAndView("/system/main");
		LoginUser u=getLoginUserId();
		if(u == null){
			throw new NoLoginExecption("请登录！");
		}
		try {
			Permission p=new Permission();
			p.setnState(1);
			p.setnType(0);
			ArrayList<Permission> menuList=securityService.getPermissionsList(p, securityService.getRoles(u.getStrLoginId()));
			
			ArrayList<Permission> menuOneLevel = new ArrayList<>();
			ArrayList<Permission> menuTwoLevel = new ArrayList<>();
			
			for (Permission pm : menuList) {
				String id = pm.getStrPid();
				if("0".equals(id))
					menuOneLevel.add(pm);
				else
					menuTwoLevel.add(pm);
			}
			
			mav.addObject("menuOneLevel",menuOneLevel);
			mav.addObject("menuTwoLevel",menuTwoLevel);
			resoult.setCode(0);
		} catch (Exception e) {
			e.printStackTrace();
			resoult.setInfo("菜单加载失败！");
			mav.addObject(resoult);
		}
		return mav;
	}
	
}
