package org.seckill.study.pattern.observer.jdkImpl;

import java.util.Observable;

/**
 * Created by teng on 2016/5/30.
 */
public class ConcreateWeatherSubject  extends Observable {

    //天气情况的内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //通知所有的观察者
        //通知之前需要用setChanged
        this.setChanged();
        //推模型
        this.notifyObservers(content);

        //拉模型
        //this.notifyObservers();
    }
}
