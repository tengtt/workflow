package org.seckill.study.pattern.observer.instance;

/**
 * Created by teng on 2016/5/30.
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 *
 */
public class ConcreateWeatherSubject extends WeatherSubject {

    //目标对象的状态
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers(weatherContent);
    }

}
