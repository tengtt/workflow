package org.seckill.listener;

import org.seckill.entity.Loginer;
import org.seckill.util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * Created by teng on 2016/5/24.
 */


public class MyHttpSessionListener implements HttpSessionListener{


    /*
    * Session失效： session超时，浏览器关闭，服务器关闭。
    *可在web.xml中配置session失效时间
    * */

    private static int userNumber=0;



     @Override
    public void sessionCreated(HttpSessionEvent se) {
         userNumber++;
         se.getSession().getServletContext().setAttribute("userNumber",userNumber);
         System.out.println("sessionCreated==================="+userNumber);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userNumber--;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);

        ArrayList<Loginer> loginList = null;
        loginList = (ArrayList<Loginer>)se.getSession().getServletContext().getAttribute("loginList");
        if(SessionUtil.getLoginBySessionId(loginList,se.getSession().getId()) != null){
            loginList.remove(SessionUtil.getLoginBySessionId(loginList,se.getSession().getId()));
        }
    }
}
