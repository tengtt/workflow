package org.seckill.study.pattern.proxy.staticProxy;

/**
 * Created by teng on 2016/5/26.
 *
 * 使用聚合方式实现
 */
public class CarTimeProxy implements Moveable {

    private Moveable m;

    public CarTimeProxy(Moveable m){
        super();
        this.m = m;

    }

    @Override
    public void move() {

        long startTIme = System.currentTimeMillis();
        System.out.println("汽车开始行驶----------");
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束--------行驶时间" + (endTime - startTIme) + "毫秒");
    }
}
