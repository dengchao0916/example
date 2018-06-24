package com.dengchao.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
schedule  
下一次的执行时间点=上一次程序执行完成的时间点+间隔时间  因此执行时间会不断延后
scheduleAtFixedRate 
下一次的执行时间点=上一次程序开始执行的时间点+间隔时间  因此执行时间不会延后，存在并发性 
两个任务间可能存在重叠，需要考虑线程同步 
如果指定开始执行的时间在当前系统运行时间之前，
scheduleAtFixedRate会把已经过去的时间也作为周期执行，而schedule不会把过去的时间算上。
 */
public class Delay {

    public static void main(String[] args) {
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println("current time is :" + sf.format(calendar.getTime()));
        Timer timer = new Timer();
        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印当前计划执行时间
                System.out.println("Scheduled exect time is : " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);*/
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印当前计划执行时间
                System.out.println("Scheduled exect time is : " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);
    }
}
