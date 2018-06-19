package com.dengchao.action;

import com.opensymphony.xwork2.ActionSupport;

public class TimerAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        for (int i = 0; i < 10000; i++) {
            System.out.println("just test!");
        }
        return SUCCESS;
    }

}
