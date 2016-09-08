package org.seckill.study.pattern.observer.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式的定义：
 * 定义对象间的一种一对多的依赖关系，当一个对象的状态正在发生改变时，所有依赖于它的对象都得到通知并被自动更新
 *
 *订阅者：   观察者，女朋友和老妈
 * 订阅者订阅的对象： 目标   天气
 *
 *
 * Created by teng on 2016/5/30.
 * 目标对象，它知道观察它的观察者，并提供注册(增加)和删除观察者的接口
 */
public class WeatherSubject {


    //用来保存注册的观察者对象
    public static List<Observer> observers = new ArrayList<Observer>();

    /*
    * 把订阅天气的人添加到订阅者列表中
    * @param oberver
    * */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /*
   * 删除指定的订阅天气的人
   * @param oberver
   * */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /*
    * 通知所有已知订阅天气的人
    * */
   /* public void notifyObservers(){
        for(Observer observer: observers){
            observer.update(this);
        }
    }*/

     public void notifyObservers(String content){
        for(Observer observer: observers){
            observer.update(content);
        }
    }
}
