package com.dengchao.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleAndScheduleAtFixedRate {

    public static void main(String[] args) {
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println("current time is :" + sf.format(calendar.getTime()));
        calendar.add(Calendar.SECOND, -6);
        Timer timer = new Timer();
        // 第一次执行时间为6秒前，之后每隔2秒执行一次
        /*timer.schedule(new TimerTask() {

            @Override
            public void run() {
                //打印当前计划执行时间
                System.out.println("Scheduled exect time is : " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);*/
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                //打印当前计划执行时间
                System.out.println("Scheduled exect time is : " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);
    }
}
