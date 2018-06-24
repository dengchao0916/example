package com.dengchao.order;

import java.util.Random;

//方法三：通过线程执行时Join()
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        T3 t3 = new T3(t2);
        t2.start();
        t1.start();
        t3.start();
    }
}

class T1 extends Thread {
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in T1");
    }
}

class T2 extends Thread {
    private Thread thread;

    public T2(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in T2");
    }
}

class T3 extends Thread {
    private Thread thread;

    public T3(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in T3");
    }
}
