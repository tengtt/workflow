package org.seckill.study.pattern.observer.template;

/**
 * Created by teng on 2016/5/30.
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 *
 */
public class ConcreateSubject extends Subject{

    //目标对象的状态
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }
}
