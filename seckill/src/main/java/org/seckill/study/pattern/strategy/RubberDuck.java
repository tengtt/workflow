package org.seckill.study.pattern.strategy;

import org.seckill.study.pattern.strategy.impl.QuackWithGa;
import org.seckill.study.pattern.strategy.impl.FlyNoWay;

/**
 * Created by teng on 2016/5/30.
 */
public class RubberDuck extends Duck{

    public RubberDuck() {
        super();
        super.setFlyingStrategy(new FlyNoWay());
        super.setQuackStrategy(new QuackWithGa());
    }

    @Override
    public void display() {
        System.out.println("我全身黄，嘴巴很红");
    }


}
