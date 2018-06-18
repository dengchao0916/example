package com.dengchao.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		System.out.println("requestDestroyed ");
	}

	public void requestInitialized(ServletRequestEvent servletrequestevent) {
	    //获取请求参数，如：http://localhost:8080/Listener?name=dengchao
		String name = servletrequestevent.getServletRequest().getParameter("name");
		System.out.println("requestInitialized name:"+name);
	}

}
