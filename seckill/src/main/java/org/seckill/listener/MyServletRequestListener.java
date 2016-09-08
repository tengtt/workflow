package org.seckill.listener;

import org.seckill.entity.Loginer;
import org.seckill.entity.User;
import org.seckill.util.SessionUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by teng on 2016/5/24.
 */
public class MyServletRequestListener implements ServletRequestListener{

    private ArrayList<Loginer> loginList;


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        loginList = (ArrayList<Loginer>)sre.getServletContext().getAttribute("loginList");
        if(loginList == null){
            loginList = new ArrayList<Loginer>();
        }

        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String sessionIdString = request.getSession().getId();
        if(SessionUtil.getLoginBySessionId(loginList,sessionIdString) == null){
            Loginer loginer = new Loginer();
            loginer.setSessionIdString(sessionIdString);
            loginer.setFirstTimesString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            loginer.setIpString(request.getRemoteAddr());
            loginList.add(loginer);
        }
        sre.getServletContext().setAttribute("loginList",loginList);

    }
}
