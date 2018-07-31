package com.shopping.initlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.shopping.util.ValTool;


@WebListener
public class InitListener implements ServletContextListener{

	//�����رյ�ʱ����ã�������������Դ���ͷ�
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	//����������ʱ����ã�������������ʼ������
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
