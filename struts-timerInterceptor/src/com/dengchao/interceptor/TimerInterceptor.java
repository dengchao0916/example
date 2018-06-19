package com.dengchao.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 * 计算执行Action花费的时间
 */
public class TimerInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // 1.执行Action之前
        long start = System.currentTimeMillis();
        // 2.执行下一个拦截器，如果已经是最后一个拦截器，则执行目标Action，返回的是逻辑视图名
        String result = invocation.invoke();
        // 3.执行Action之后
        long end = System.currentTimeMillis();
        System.out.println("执行Action花费的时间：" + (end - start) + "ms");

        return result;
    }

}
