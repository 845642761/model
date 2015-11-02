package org.me.plugin.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 启动时初始化配置
 * @author cheng_bo
 * @date 2015年5月26日 11:26:45
 */
public class Init implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
	}
}
