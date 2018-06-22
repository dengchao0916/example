package com.dengchao.weather.push;

//推模型：目标对象主动向观察者推送目标的详细信息，推送的信息通常是目标对象的全部或部分数据
//缺点，对象难以复用
public class Client {
    public static void main(String[] args) {
        // 1.创建目标
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
        // 2.创建观察者
        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("girl");
        girl.setRemmindThing("适合去逛街");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("mum");
        mum.setRemmindThing("适合散步");

        // 3.注册观察者
        weather.attach(girl);
        weather.attach(mum);
        // 4.目标发布天气
        weather.setWeahterContent("天气晴朗");
    }
}
