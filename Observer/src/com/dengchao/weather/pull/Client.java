package com.dengchao.weather.pull;

/*拉模型：目标对象在通知观察者的时候，只传递少量信息，
如果观察者需要更具体的信息，有观察者主动到目标对象中获取，
相当于是观察者从目标对象中拉数据，一般这种模型的实现中，
会把目标对象自身通过update方法传递给观察者*/
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
