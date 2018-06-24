package com.dengchao.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String name;
    private Integer count = 0;
    public MyTimerTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if(count < 100){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("current time is :" + sf.format(calendar.getTime()));
            System.out.println("current name is : " + name);
            count++;
        }else{
            //取消任务
            cancel();
            System.out.println("Task cancel!");
        }
        
    }

}
