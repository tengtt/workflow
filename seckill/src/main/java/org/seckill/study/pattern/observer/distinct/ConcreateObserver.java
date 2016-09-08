package org.seckill.study.pattern.observer.distinct;

/**
 * Created by teng on 2016/5/30.
 */
public class ConcreateObserver implements Observer{

    private String observerName;

    private String weatherContent;

    private String redminThing;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRedminThing() {
        return redminThing;
    }

    public void setRedminThing(String redminThing) {
        this.redminThing = redminThing;
    }

    @Override
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public String getObserverName() {
        return observerName;
    }

    @Override
    public void update(WeatherSubject subject) {

        weatherContent = ((ConcreateWeatherSubject)subject).getWeatherContent();
        System.out.println(observerName +"收到了" +weatherContent +","+redminThing);

    }
}
