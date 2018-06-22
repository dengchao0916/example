package com.dengchao.weather.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:Subject
 * @Description:目标对象，它知道观察它的观察者，并提供添加和删除观察者的接口
 * @author Administrator
 */
public class WeatherSubject {
    // 用来保存注册的订阅天气的人
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);

    }

    public void detach(Observer observer) {
        observers.remove(observer);

    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);

        }

    }
}
