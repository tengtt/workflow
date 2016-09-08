package org.seckill.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by teng on 2016/5/24.
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener{
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContextAttribute_Added contextName:"+event.getServletContext().getAttribute("contextName"));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ServletContextAttribute_Removed contextName:"+event.getServletContext().getAttribute("contextName"));
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ServletContextAttribute_Replaced contextName:"+event.getServletContext().getAttribute("contextName"));
    }
}
