package com.dengchao.main;

/**
 * @Title:ConcreteSubject
 * @Description:具体的目标对象，负责把有关状态存入到相应的观察者对象中
 * @author Administrator
 */
public class ConcreteSubject extends Subject {
    // 目标对象状态
    private String subjectStatus;

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
        this.notifyObservers();
    }

}
