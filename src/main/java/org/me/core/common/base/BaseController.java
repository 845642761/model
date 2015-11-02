package org.me.core.common.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.me.core.common.WebConstant;
import org.me.web.user.entity.LoginUser;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {
	@InitBinder
	public void initBinder(WebDataBinder binder)  {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
	}
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public LoginUser getLoginUserId() {
		HttpSession session=getSession();
		if(session == null || session.getAttribute(WebConstant.LOGINUSER) == null)
			return null;
		return (LoginUser) session.getAttribute(WebConstant.LOGINUSER);
	}
}
