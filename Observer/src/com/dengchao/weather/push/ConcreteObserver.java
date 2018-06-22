package com.dengchao.weather.push;

/**
 * @Title:ConcreteObserver
 * @Description:具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author Administrator
 */
public class ConcreteObserver implements Observer {
    // 观察者名称
    private String observerName;
    // 天气情况
    private String weatherContent;
    // 提醒内容
    private String remmindThing;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getRemmindThing() {
        return remmindThing;
    }

    public void setRemmindThing(String remmindThing) {
        this.remmindThing = remmindThing;
    }

    /*
     * 获取目标类的状态同步到观察者的状态中
     */
    @Override
    public void update(String content) {
        weatherContent = content;
        System.out.println(observerName + "收到了" + weatherContent + "，" + remmindThing);
    }

}
