package org.seckill.study.pattern.strategy.impl;

import org.seckill.study.pattern.strategy.FlyingStrategy;

/**
 * Created by teng on 2016/5/30.
 */
public class FlyWithRocket implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("我在太空中遨游");
    }
}
