package com.dengchao.java;

//java的util包中实现观察者模式
public class Client {

    public static void main(String[] args) {
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("girl");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("mum");

        // 注册观察者
        subject.addObserver(girl);
        subject.addObserver(mum);
        subject.setContent("天气晴朗");

    }

}
