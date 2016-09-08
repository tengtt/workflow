package org.seckill.study.pattern.observer.template;

/**
 * Created by teng on 2016/5/30.
 *
 * 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {


    /*
    * 更新的接口，subject传入目标对象
    * */
    public void update(Subject subject);
}
