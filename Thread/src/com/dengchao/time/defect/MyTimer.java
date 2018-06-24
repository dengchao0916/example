package com.dengchao.time.defect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask myTimerTask1 = new MyTimerTask("No.1", 2000);
        MyTimerTask myTimerTask2 = new MyTimerTask("No.2", 2000);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is : " + sf.format(calendar.getTime()));
        /*
         * timer.schedule(myTimerTask1, calendar.getTime());
         * timer.schedule(myTimerTask2, calendar.getTime());
         */
        timer.scheduleAtFixedRate(myTimerTask1, calendar.getTime(), 2000);
        timer.scheduleAtFixedRate(myTimerTask2, calendar.getTime(), 2000);
    }

}
