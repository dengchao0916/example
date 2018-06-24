package com.dengchao.order;

public class ThreadCC extends Thread {
    private MyService dbtools;

    public ThreadCC(MyService dbtools) {
        super();
        this.dbtools = dbtools;
    }

    @Override
    public void run() {
        dbtools.methodC();
    }
}
