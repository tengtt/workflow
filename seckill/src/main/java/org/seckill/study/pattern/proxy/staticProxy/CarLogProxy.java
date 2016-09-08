package org.seckill.study.pattern.proxy.staticProxy;

/**
 * Created by teng on 2016/5/26.
 *
 * 使用聚合方式实现
 */
public class CarLogProxy implements Moveable {

    private Moveable m;

    public CarLogProxy(Moveable m){
        super();
        this.m = m;

    }

    @Override
    public void move() {

        long startTIme = System.currentTimeMillis();
        System.out.println("日志开始----------");
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("日志结束--------行驶时间" + (endTime - startTIme) + "毫秒");
    }
}
