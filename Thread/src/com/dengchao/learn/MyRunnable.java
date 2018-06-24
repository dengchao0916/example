package com.dengchao.learn;

public class MyRunnable implements Runnable {
    int count = 5;

    @Override
    synchronized public void run() {
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "  计算，count=" + count);
    }

}
