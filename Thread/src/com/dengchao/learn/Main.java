package com.dengchao.learn;

public class Main {

    public static void main(String[] args) {
        MyThread mythread1 = new MyThread("A");
        MyThread mythread2 = new MyThread("B");
        MyThread mythread3 = new MyThread("C");
        MyThread mythread4 = new MyThread("D");
        MyThread mythread5 = new MyThread("E");

        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread4.start();
        mythread5.start();
        
        
        /*MyThread mythread = new MyThread();
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/
        
        /*MyRunnable myrunnable = new MyRunnable();
        Thread a = new Thread(myrunnable, "A");
        Thread b = new Thread(myrunnable, "B");
        Thread c = new Thread(myrunnable, "C");
        Thread d = new Thread(myrunnable, "D");
        Thread e = new Thread(myrunnable, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/

    }
}
