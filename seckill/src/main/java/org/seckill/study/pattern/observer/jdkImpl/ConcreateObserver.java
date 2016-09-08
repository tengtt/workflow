package org.seckill.study.pattern.observer.jdkImpl;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by teng on 2016/5/30.
 */
public class ConcreateObserver implements Observer{

    private String oberverName;

    public String getOberverName() {
        return oberverName;
    }

    public void setOberverName(String oberverName) {
        this.oberverName = oberverName;
    }

    @Override
    public void update(Observable o, Object arg) {
        //推模型
        System.out.println(oberverName + "收到了消息，目标推送过来的是：" + arg);

        //拉模型
        System.out.println(oberverName + "收到了消息，主动到目标对象中去拉，拉的内容是："
                + ((ConcreateWeatherSubject)o).getContent());
    }
}
