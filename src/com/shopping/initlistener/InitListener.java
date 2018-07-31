package com.shopping.initlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.shopping.util.ValTool;


@WebListener
public class InitListener implements ServletContextListener{

	//容器关闭的时候调用，可以用来做资源的释放
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	//容器启动的时候调用，可以用来做初始化操作
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		ServletContext application = evt.getServletContext();
		ValTool.CONTEXT_PATH = application.getContextPath();
		ValTool.REAL_PATH = application.getRealPath("/");
		application.setAttribute("rt", ValTool.CONTEXT_PATH);
		System.out.println("======contextPath=====" + ValTool.CONTEXT_PATH);
		System.out.println("======rootPath=====" + ValTool.REAL_PATH);
	}

}
