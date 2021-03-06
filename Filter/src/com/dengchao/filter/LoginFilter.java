package com.dengchao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    private FilterConfig config;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();

        String noLoginPaths = config.getInitParameter("noLoginPaths");

        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);

        // 如果在登录界面或者失败界面，或者访问LoginServlet，则放行（否则会造成死循环）
        if (noLoginPaths != null) {
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {

                if (strArray[i] == null || "".equals(strArray[i])) {
                    continue;
                }
                System.out.println("URI:" + request.getRequestURI());
                if (request.getRequestURI().indexOf(strArray[i]) != -1) {
                    arg2.doFilter(arg0, arg1);
                    return;
                }
            }

        }

        if (session.getAttribute("username") != null) {
            arg2.doFilter(arg0, arg1);
        } else {
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        config = arg0;
    }

}
