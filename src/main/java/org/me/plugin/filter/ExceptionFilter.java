package org.me.plugin.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.me.core.common.Resoult;
import org.me.core.exception.NoLoginExecption;
import org.me.core.exception.ViewExecption;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常拦截器
 * @author: chengbo
 * @date: 2015年10月12日 17:58:24
 */
public class ExceptionFilter implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView("/error.jsp");
		Resoult resoult=new Resoult();
		resoult.setCode(-1);
		if(ex instanceof UnauthorizedException || ex instanceof UnauthenticatedException){
			resoult.setInfo("暂无权限");
		}else if(ex instanceof ViewExecption){
			resoult.setInfo(ex.getMessage());
		}else if(ex instanceof NoLoginExecption){
			resoult.setInfo(ex.getMessage());
			mv.setViewName("/user/login.jsp");
		}else {
			resoult.setInfo("操作失败！");
		}
		mv.addObject("error",resoult);
        return mv;
	}
	
}