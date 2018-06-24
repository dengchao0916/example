package com.dengchao.time.defect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String name;
    private long costTime;

    public MyTimerTask(String name, long costTime) {
        this.name = name;
        this.costTime = costTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(name + "'s current time is : " + sf.format(calendar.getTime()));
        try {
            Thread.sleep(costTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calendar = Calendar.getInstance();
        System.out.println(name + "'s finish time is : " + sf.format(calendar.getTime()));
        //如果TimerTask抛出RuntimeException异常时,Timer会停止所有任务的运行
        //throw new RuntimeException();
    }

}
