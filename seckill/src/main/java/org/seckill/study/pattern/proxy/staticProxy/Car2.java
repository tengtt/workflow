package org.seckill.study.pattern.proxy.staticProxy;

/**
 * Created by teng on 2016/5/26.
 *
 * 使用继承的方式实现代理
 *
 * 会使代理类无限增加，不使用
 */
public class Car2 extends Car {

    public void move(){

        long startTIme = System.currentTimeMillis();
        System.out.println("汽车开始行驶----------");
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束--------行驶时间" + (endTime - startTIme) + "毫秒");

    }
}
