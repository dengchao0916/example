package com.dengchao.time.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class Executor {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is : " + sf.format(calendar.getTime()));
        DancingRoboot dr = new DancingRoboot();
        WaterRoboot wr = new WaterRoboot(timer);
        timer.schedule(dr, calendar.getTime(), 2000);
        timer.scheduleAtFixedRate(wr, calendar.getTime(), 1000);
    }
}
