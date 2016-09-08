package org.seckill.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by teng on 2016/5/24.
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequestAttribute_Added requestName: "+srae.getServletRequest().getAttribute("requestName"));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequestAttribute_Removed requestName: "+srae.getServletRequest().getAttribute("requestName"));
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequestAttribute_Replaced requestName: "+srae.getServletRequest().getAttribute("requestName"));
    }
}
