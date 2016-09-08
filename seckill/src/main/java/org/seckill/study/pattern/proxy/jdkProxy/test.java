package org.seckill.study.pattern.proxy.jdkProxy;

import org.seckill.study.pattern.proxy.staticProxy.Car;
import org.seckill.study.pattern.proxy.staticProxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by teng on 2016/5/26.
 *
 *
 * 动态代理实现思路：
 * 实现功能：通过Proxy的newProxyInstance返回代理对象
 * 1、声明一段源码(动态产生代理)
 * 2、编译源码，产生新的代理类
 * 3、将这个类load到内存中，产生一个新的对象(代理对象)
 * 4、return 代理对象
 * 详见Proxy类
 *
 */
public class test {

    public static void main(String[] args){

        Car car = new Car();
        Class<?> cls = car.getClass();

        InvocationHandler htime = new TimeHandler(car);
        InvocationHandler hlog = new LogHandler(car);

        Moveable mtime=  (Moveable)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), htime);
        Moveable mlog =  (Moveable)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), hlog);
        System.out.println(""+ mtime.getClass().getName());
        System.out.println(""+ mlog.getClass().getName());
        mtime.move();
        mlog.move();

    }
}
