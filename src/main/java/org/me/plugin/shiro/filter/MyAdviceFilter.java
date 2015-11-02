package org.me.plugin.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;

public class MyAdviceFilter extends AdviceFilter {
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		return super.preHandle(request, response);
	}
}
