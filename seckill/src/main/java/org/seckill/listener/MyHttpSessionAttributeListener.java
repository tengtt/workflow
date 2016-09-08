package org.seckill.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by teng on 2016/5/24.
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionAttribute_Added SessionName: "+event.getSession().getAttribute("SessionName"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionAttribute_Removed SessionName: "+event.getSession().getAttribute("SessionName"));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionAttribute_Replaced SessionName: "+event.getSession().getAttribute("SessionName"));

    }
}
