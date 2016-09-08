package org.seckill.study.pattern.observer.distinct;

/**
 * Created by teng on 2016/5/30.
 */
public class Client {

    public static void main(String[] args){

        //创建目标
       ConcreateWeatherSubject weatherSubject = new ConcreateWeatherSubject();

        //创建观察者
        ConcreateObserver observerGirl = new ConcreateObserver();
        observerGirl.setObserverName("女朋友");
        observerGirl.setRedminThing("出去约会");

        ConcreateObserver observerMum = new ConcreateObserver();
        observerMum.setObserverName("老妈");
        observerMum.setRedminThing("出去购物");

        //注册观察者
        weatherSubject.attach(observerGirl);
        weatherSubject.attach(observerMum);

        //目标发布天气
        weatherSubject.setWeatherContent("晴天");


    }
}
