package com.dengchao.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class TimerTest {

    public static void main(String[] args) {
        // 创建一个Timer实例（Util包下）
        Timer timer = new Timer();
        // Timer定时的调用TimerTask
        MyTimerTask mytimer = new MyTimerTask("No.1");
        // 第一次是在2秒后执行，之后每隔1秒执行一次
        // timer.schedule(mytimer, 2000L, 1000L);

        // 获取当前时间，并设置距当前时间3秒之后的时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(calendar.getTime()));
        // calendar.add(Calendar.SECOND, 3);
        // 在时间等于或超过time的时候执行且仅执行一次task
        // mytimer.setName("schedule1");
        // timer.schedule(mytimer, calendar.getTime());

        // 在时间等于或超过time的时候执行且仅执行一次task，之后每隔period毫秒重复执行一次task
        // mytimer.setName("schedule2");
        // timer.schedule(mytimer, calendar.getTime(), 2000);

        // 等待delay毫秒后执行仅且执行一次task
        // mytimer.setName("schedule3");
        // timer.schedule(mytimer, 2000);

        // 等待delay毫秒后首次执行task，之后每隔period毫秒重复执行一次task
        // mytimer.setName("schedule4");
        // timer.schedule(mytimer, 3000, 2000);

        // 在时间等于或超过time的时候执行且仅执行一次task，之后每隔period毫秒重复执行一次task
        // mytimer.setName("scheduleAtFixedRate1");
        // timer.scheduleAtFixedRate(mytimer, calendar.getTime(), 2000);

        // 等待delay毫秒后首次执行task，之后每隔period毫秒重复执行一次task
        // mytimer.setName("scheduleAtFixedRate2");
        // timer.scheduleAtFixedRate(mytimer, 3000, 2000);

        mytimer.setName("schedule");
        timer.schedule(mytimer, 3000,2000);
        System.out.println("最近会执行的Task的时间 : " + sf.format(mytimer.scheduledExecutionTime()));

    }
}
