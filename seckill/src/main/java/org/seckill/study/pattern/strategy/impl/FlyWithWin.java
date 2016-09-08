package org.seckill.study.pattern.strategy.impl;

import org.seckill.study.pattern.strategy.FlyingStrategy;

/**
 * Created by teng on 2016/5/30.
 */
public class FlyWithWin implements FlyingStrategy {


    @Override
    public void performFly() {
        System.out.println("振翅高飞");
    }
}
