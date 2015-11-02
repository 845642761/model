package org.me.plugin.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

public class LoginFilter extends PathMatchingFilter{
	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		return super.onPreHandle(request, response, mappedValue);
	}
}
