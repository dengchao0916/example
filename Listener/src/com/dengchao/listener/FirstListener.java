package com.dengchao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FirstListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletcontextevent) {
	    //可以定义全局变量 注入缓存数据
		String initParam = servletcontextevent.getServletContext().getInitParameter("initParam");
		System.out.println("contextInitialized : initParam = "+initParam);
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		//可以做一下释放资源的操作
		System.out.println("contextDestroyed");
	}

}
