package com.dengchao.java;

import java.util.Observable;

//天气目标具体实现类
public class ConcreteWeatherSubject extends Observable {
    // 天气情况
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        // 天气情况有变，就要通知所有的观察者
        // java中的Observer模式，下面的这句不可少
        this.setChanged();
        // 然后主动通知，推方法
        this.notifyObservers(content);
        // 拉方法
        // this.notifyObservers();
    }

}
