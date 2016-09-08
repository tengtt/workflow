package org.seckill.entity;

/**
 * Created by teng on 2016/5/24.
 */
public class Loginer {

    private String sessionIdString;

    private String ipString;

    private String firstTimesString;

    public String getSessionIdString() {
        return sessionIdString;
    }

    public void setSessionIdString(String sessionIdString) {
        this.sessionIdString = sessionIdString;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getFirstTimesString() {
        return firstTimesString;
    }

    public void setFirstTimesString(String firstTimesString) {
        this.firstTimesString = firstTimesString;
    }
}
