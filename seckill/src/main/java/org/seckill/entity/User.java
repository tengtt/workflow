package org.seckill.entity;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * Created by teng on 2016/5/24.
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{


    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("valueBound name:"+event.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("valueUnbound name:"+event.getName());

    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("sessionWillPassivate -=============name:" + se.getSource());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("sessionDidActivate ===========name:" + se.getSource());

    }
}
