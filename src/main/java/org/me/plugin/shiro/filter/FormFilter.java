package org.me.plugin.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 登录拦截器
 * @author: chengbo
 * @date: 2015年10月13日 09:30:50
 */
public class FormFilter extends FormAuthenticationFilter {
	
	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("+++++++++++++++++++++++++");
		return super.executeLogin(request, response);
	}
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		return super.onLoginSuccess(token, subject, request, response);
	}
}
