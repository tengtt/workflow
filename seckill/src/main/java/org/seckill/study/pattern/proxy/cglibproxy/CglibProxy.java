package org.seckill.study.pattern.proxy.cglibproxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/26.
 */
public class CglibProxy implements MethodInterceptor{

    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        //设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /*
    * 拦截所有目标类方法调用
    * o:目标类的实例
    * method: 目标方法的反射对象
    * objects:方法的参数
    * methodProxy:代理类的实例
    * */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("汽车开始行驶----------");
        //代理类调用的父类的方法
        methodProxy.invokeSuper(o,objects);
        System.out.println("汽车结束行驶----------");
        return null;
    }
}
