package org.seckill.study.pattern.observer.instance;

/**
 * Created by teng on 2016/5/30.
 *
 * 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {


    /*
    * 更新的接口，weatherSubject--传入目标对象
    * 拉模型：目标对象不知道观察者具体需要什么数据，因此把自身传给观察者，由观察者来取值
    *
    * */
   // public void update(WeatherSubject weatherSubject);

    /*
    * 推模型，假定目标对象需要知道观察者需要的数据
    * 会使观察者对象难以复用
    *
    * */
    public void update(String content);
}
