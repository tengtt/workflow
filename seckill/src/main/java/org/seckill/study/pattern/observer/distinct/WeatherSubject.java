package org.seckill.study.pattern.observer.distinct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 2016/5/30.
 *
 * 区别对待观察者
 */
public abstract class WeatherSubject {


    List<Observer> observerList = new ArrayList<Observer>();

    public void attach(Observer observer){
        observerList.add(observer);
    }

    public void detach(Observer observer){
        observerList.remove(observer);
    }

    //根据不同的天气情况去判断
    public abstract void notifyObservers();

}
