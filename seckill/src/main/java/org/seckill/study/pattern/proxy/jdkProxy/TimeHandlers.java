package org.seckill.study.pattern.proxy.jdkProxy;

import java.lang.reflect.*;

/**
 * Created by teng on 2016/5/26.
 */
public class TimeHandlers implements InvocationHandler {

    private Object target;

    public TimeHandlers(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        try {
            long startTIme = System.currentTimeMillis();
            System.out.println("汽车开始行驶----------");
            m.invoke(target);
            long endTime = System.currentTimeMillis();
            System.out.println("汽车行驶结束--------行驶时间" + (endTime - startTIme) + "毫秒");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
