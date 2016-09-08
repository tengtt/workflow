package org.seckill.study.pattern.strategy.impl;

import org.seckill.study.pattern.strategy.QuackStrategy;

/**
 * Created by teng on 2016/5/30.
 */
public class QuackWithGaga implements QuackStrategy {
    @Override
    public void performQuack() {
        System.out.println("嘎~~嘎~~嘎~~嘎~~~");
    }
}
