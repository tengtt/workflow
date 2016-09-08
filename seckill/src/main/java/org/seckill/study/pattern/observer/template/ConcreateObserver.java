package org.seckill.study.pattern.observer.template;

/**
 * Created by teng on 2016/5/30.
 *
 * 具体的观察者对象，实现更新的方法，
 */
public class ConcreateObserver implements Observer{

    private String observerState;

    /*
    * 获取目标类的状态同步到观察者状态中
    * */
    @Override
    public void update(Subject subject) {
        observerState = ((ConcreateSubject)subject).getSubjectState();
    }
}
