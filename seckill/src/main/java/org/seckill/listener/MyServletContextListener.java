package org.seckill.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by teng on 2016/5/24.
 */
public class MyServletContextListener implements ServletContextListener{


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String namespace = sce.getServletContext().getInitParameter("namespace");
        System.out.println("contextInitialized: namespace:"+namespace);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
}
