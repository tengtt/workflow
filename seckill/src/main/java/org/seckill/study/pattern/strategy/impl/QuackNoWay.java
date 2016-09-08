package org.seckill.study.pattern.strategy.impl;

import org.seckill.study.pattern.strategy.QuackStrategy;

/**
 * Created by teng on 2016/5/30.
 */
public class QuackNoWay implements QuackStrategy{
    @Override
    public void performQuack() {
        System.out.println("我不会叫");
    }
}
