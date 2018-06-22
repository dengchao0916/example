package com.dengchao.main;

/**
 * @Title:ConcreteObserver
 * @Description:具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author Administrator
 */
public class ConcreteObserver implements Observer {
    // 观察者状态
    private String observerStatus;

    public String getObserverStatus() {
        return observerStatus;
    }

    public void setObserverStatus(String observerStatus) {
        this.observerStatus = observerStatus;
    }

    /*
     * 获取目标类的状态同步到观察者的状态中
     */
    @Override
    public void update(Subject subject) {
        observerStatus = ((ConcreteSubject) subject).getSubjectStatus();
    }

}
