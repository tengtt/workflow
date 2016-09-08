package org.seckill.study.pattern.observer.instance;

/**
 * Created by teng on 2016/5/30.
 *
 * 具体的观察者对象，实现更新的方法，
 *
 * 所需变量：
 * 1）观察者的名字
 * 2）天气情况的内容
 * 3）提醒的内容（女朋友提醒约会，老妈提醒逛街）
 */
public class ConcreateObserver implements Observer {

    //观察者名称：是谁收到这个讯息，妈还是女朋友
    private String observerName;

    //天气情况的内容，这个消息从目标处获取
    private String weatherContent;

    //提醒的内容
    private String remindThing;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }

   /* *//*
            * 获取目标类的状态同步到观察者状态中
            * *//*
    @Override
    public void update(WeatherSubject weatherSubject) {
        weatherContent = ((ConcreateWeatherSubject)weatherSubject).getWeatherContent();
        System.out.println(observerName + "收到了" + weatherContent+"," + remindThing);

    }*/

    @Override
    public void update(String content) {
        weatherContent = content;
        System.out.println(observerName + "收到了" + weatherContent+"," + remindThing);
    }
}
