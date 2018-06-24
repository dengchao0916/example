package com.dengchao.order;

import com.dengchao.order.ThreadCC;
import com.dengchao.order.MyService;
import com.dengchao.order.ThreadAA;
import com.dengchao.order.ThreadBB;

//方法一：通过共享对象锁加上可见变量来实现。
public class Run {

    public static void main(String[] args) {
        MyService myService = new MyService();
        for (int i = 0; i < 2; i++) {
            ThreadBB output = new ThreadBB(myService);
            output.start();
            ThreadAA input = new ThreadAA(myService);
            input.start();
            ThreadCC threadCC = new ThreadCC(myService);
            threadCC.start();
        }
    }

}