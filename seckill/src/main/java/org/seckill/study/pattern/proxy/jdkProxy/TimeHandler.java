package org.seckill.study.pattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/26.
 * jdk动态代理：
 * 运行时需要实现一组class,
 * 该Class需要实现一组Interface
 * 使用动态代理类时，必须实现InvocationHandler接口
 *
 *
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /*
        * proxy：被代理对象
        * mehtod:被代理对象的方法
        * args: 方法的参数
        * 返回值：Object对象
        * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTIme = System.currentTimeMillis();
        System.out.println("汽车开始行驶----------");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束--------行驶时间" + (endTime - startTIme) + "毫秒");
        return null;
    }
}
