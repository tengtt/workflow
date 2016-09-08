package org.seckill.study.pattern.strategy.impl;

import org.seckill.study.pattern.strategy.QuackStrategy;

/**
 * Created by teng on 2016/5/30.
 */
public class QuackWithGa implements QuackStrategy {
    @Override
    public void performQuack() {
        System.out.println("嘎嘎嘎嘎");
    }
}
