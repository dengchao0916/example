package com.dengchao.time.demo;

import java.util.Timer;
import java.util.TimerTask;

public class WaterRoboot extends TimerTask {

    private Timer timer;
    // 桶容量最大为5L
    private Integer bucketCapacity = 0;

    public WaterRoboot(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        if (bucketCapacity < 5) {
            bucketCapacity++;
            System.out.println("Add 1L water into the bucket!");
        } else {
            // 取消单个实例
            cancel();
            System.out.println("The waterRobot has aborted");
            // 移除已取消TimerTask实例的内存
            System.out.println("The number of canceled task in timer is : " + timer.purge());
            System.out.println("Curent water is " + bucketCapacity + "L");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 取消timer下所有实例
            timer.cancel();
        }
    }
}
