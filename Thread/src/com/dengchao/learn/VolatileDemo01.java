package com.dengchao.learn;


public class VolatileDemo01 {

    private int number = 0;

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        synchronized (this) {
            this.number++;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final VolatileDemo01 volDemo = new VolatileDemo01();
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    volDemo.increase();
                }
            }).start();
        }

        // 如果还有子线程在运行，主线程就让出CPU资源，
        // 直到所有的子线程都运行完了，主线程再继续往下执行
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("number : " + volDemo.getNumber());
    }

}
