package org.seckill.study.pattern.observer.distinct;

/**
 * Created by teng on 2016/5/30.
 */
public class ConcreateWeatherSubject extends WeatherSubject{

    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observerList){
            //黄明女朋友，下雨通知，其他条件不通知
            if("下雨".equals(this.getWeatherContent())){
                if("女朋友".equals(observer.getObserverName())){
                    observer.update(this);
                }
                if("老妈".equals(observer.getObserverName())){
                    observer.update(this);
                }
            }
            if("下雪".equals(this.getWeatherContent())) {
                if ("老妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }


            //黄明老妈，下雨，下雪通知，其他条件不通知

        }
    }
}
