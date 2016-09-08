package org.seckill.study.pattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/26.
 */
public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTIme = System.currentTimeMillis();
        System.out.println("日志开始----------");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("日志结束--------行驶时间" + (endTime - startTIme) + "毫秒");
        return null;
    }
}
