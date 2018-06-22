package com.dengchao.java;

import java.util.Observable;
import java.util.Observer;

//具体的观察者对象
public class ConcreteObserver implements Observer {
    // 观察者名称
    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    // 第一个参数拉方式，第二个参数推方式
    @Override
    public void update(Observable o, Object arg) {
        // 推方式
        System.out.println(observerName + "收到消息，目标推送过来的是：" + arg);
        // 拉方式
        System.out.println(observerName + "收到消息，主动到目标对象中拉取的内容是："
                + ((ConcreteWeatherSubject) o).getContent());

    }

}
