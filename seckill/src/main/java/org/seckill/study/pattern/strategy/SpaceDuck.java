package org.seckill.study.pattern.strategy;

import org.seckill.study.pattern.strategy.impl.FlyWithRocket;
import org.seckill.study.pattern.strategy.impl.QuackNoWay;

/**
 * Created by teng on 2016/5/30.
 */
public class SpaceDuck extends Duck{

    public SpaceDuck() {
        super();
        super.setFlyingStrategy(new FlyWithRocket());
        super.setQuackStrategy(new QuackNoWay());
    }

    @Override
    public void display() {
        System.out.println("我头戴宇航头盔");
    }

    public void quack(){
        System.out.println("我通过无线电与你通信");
    }
}
