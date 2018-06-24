package com.dengchao.concurrent;

/*
 *使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。
 *cpu会从众多的可执行态里选择，也就是说，
 *当前也就是刚刚的那个线程还是有可能会被再次执行到的，
 *并不是说一定会执行其他线程而该线程在下一次中不会执行到了。
 *
 *yield不会释放资源锁,当暂停后,等待调度程序再次调用,走完同步区域代码后才释放锁 
 */
public class YieldExample extends Thread
{
    public YieldExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args)
    {
        YieldExample yt1 = new YieldExample("张三");
        YieldExample yt2 = new YieldExample("李四");
        yt1.start();
        yt2.start();
    }
}
