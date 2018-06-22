package com.dengchao.weather.pull;

/**
 * @Title:ConcreteSubject
 * @Description:具体的目标对象，负责把有关状态存入到相应的观察者对象中
 * @author Administrator
 */
public class ConcreteWeatherSubject extends WeatherSubject {
    // 天气信息
    private String weahterContent;

    public String getWeahterContent() {
        return weahterContent;
    }

    public void setWeahterContent(String weahterContent) {
        this.weahterContent = weahterContent;
        this.notifyObservers();
    }

}
