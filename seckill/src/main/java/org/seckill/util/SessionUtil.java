package org.seckill.util;

import org.seckill.entity.Loginer;

import java.util.ArrayList;

/**
 * Created by teng on 2016/5/24.
 */
public class SessionUtil {

    public static  Object getLoginBySessionId(ArrayList<Loginer> loginerList, String sessionIdString){
        for(int i = 0; i < loginerList.size(); i++){
            Loginer loginer = loginerList.get(i);
            if(loginer.getSessionIdString().equals(sessionIdString)){
                return loginer;
            }
        }
        return null;

    }
}
