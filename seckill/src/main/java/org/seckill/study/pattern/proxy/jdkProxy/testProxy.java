package org.seckill.study.pattern.proxy.jdkProxy;

import org.seckill.study.pattern.proxy.staticProxy.Moveable;
import org.seckill.study.pattern.proxy.staticProxy.Car;

/**
 * Created by teng on 2016/5/26.
 */
public class testProxy {

    public static void main(String[] args){
        Car car = new Car();
        InvocationHandler h = new TimeHandlers(car);
        try {
            Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
            m.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
