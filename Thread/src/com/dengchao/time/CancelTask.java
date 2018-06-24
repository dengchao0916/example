package com.dengchao.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class CancelTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");

        Date starttime = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start time is : " + sf.format(starttime));

        timer.schedule(task1, 3000, 2000);
        timer.schedule(task2, 1000, 2000);
        System.out.println("current canceled task number is : " + timer.purge());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date endtime = new Date();
        System.out.println("end time is : " + sf.format(endtime));
        //Timer下的cancel方法， 取消所有任务
        // timer.cancel();
        //TimerTask下的cancel方法
        task2.cancel();
        System.out.println("current canceled task number is : " + timer.purge());
    }
}
