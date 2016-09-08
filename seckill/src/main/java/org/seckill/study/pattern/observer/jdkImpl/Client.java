package org.seckill.study.pattern.observer.jdkImpl;



/**
 * Created by teng on 2016/5/30.
 *
 * 观察者模式缺点：
 * 可能引起无谓的操作。
 *
 * 适用场景：
 * 触发联动；（观察者模式的本质）
 * 1）当一个抽象模型有两个方面，一个方面的操作依赖于另一个方面的状态变化
 * 2）更改对象的时候，需要同时连带改变其他的对象，而且不知道究竟应该有多少对象需要被连带改变
 *3）当一个对象必须通知其他的对象，但是你又希望这个对象和其他被他通知的对象是松耦合的。
 */
public class Client {

    public static void main(String[] args){

        ConcreateWeatherSubject weatherSubject = new ConcreateWeatherSubject();

        ConcreateObserver girl = new ConcreateObserver();
        girl.setOberverName("黄明女朋友");

        ConcreateObserver mum = new ConcreateObserver();
        mum.setOberverName("黄明老妈");

        weatherSubject.addObserver(girl);
        weatherSubject.addObserver(mum);

        weatherSubject.setContent("天气晴，气温28度");

    }
}
