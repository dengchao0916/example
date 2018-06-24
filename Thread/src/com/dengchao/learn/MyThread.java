package com.dengchao.learn;

public class MyThread extends Thread {

    private int count = 5;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    synchronized public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + name + "  计算，count=" + count);
        }

    }
}
