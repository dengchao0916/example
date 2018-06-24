package com.dengchao.order;

public class ThreadBB extends Thread {
    private MyService dbtools;

    public ThreadBB(MyService dbtools) {
        super();
        this.dbtools = dbtools;
    }

    @Override
    public void run() {
        dbtools.methodB();
    }
}
