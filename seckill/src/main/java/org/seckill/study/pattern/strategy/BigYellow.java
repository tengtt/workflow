package org.seckill.study.pattern.strategy;

import org.seckill.study.pattern.strategy.impl.FlyNoWay;
import org.seckill.study.pattern.strategy.impl.QuackNoWay;

/**
 * Created by teng on 2016/5/30.
 */
public class BigYellow extends Duck{
    public BigYellow() {
        super();
        super.setFlyingStrategy(new FlyNoWay());
        super.setQuackStrategy(new QuackNoWay());
    }

    @Override
    public void display() {
        System.out.println("我个头很大，全身是黄的");
    }
}
