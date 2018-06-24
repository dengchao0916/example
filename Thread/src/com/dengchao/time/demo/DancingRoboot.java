package com.dengchao.time.demo;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

public class DancingRoboot extends TimerTask {

    @Override
    public void run() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("scheduled exec time is : " + sf.format(scheduledExecutionTime()));
        System.out.println("Dancing happily!");
    }

}
