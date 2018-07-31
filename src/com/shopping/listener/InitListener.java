package com.shopping.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.shopping.util.HttpVal;

@WebListener
public class InitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//容器启动的时候调用，可以用来做初始化操作
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		String contextPath = evt.getServletContext().getContextPath();
		HttpVal.CONTEXT_PATH = contextPath;
		evt.getServletContext().setAttribute("root", contextPath);
	}
}
