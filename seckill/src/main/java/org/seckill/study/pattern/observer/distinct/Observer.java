package org.seckill.study.pattern.observer.distinct;

/**
 * Created by teng on 2016/5/30.
 */
public interface Observer {

    public void update(WeatherSubject subject);

    public void setObserverName(String observerName);

    public String getObserverName();
}
