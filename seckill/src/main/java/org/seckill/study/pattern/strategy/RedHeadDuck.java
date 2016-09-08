package org.seckill.study.pattern.strategy;

import org.seckill.study.pattern.strategy.impl.QuackWithGaga;
import org.seckill.study.pattern.strategy.impl.FlyWithWin;

/**
 * Created by teng on 2016/5/30.
 */
public class RedHeadDuck extends Duck{

    public RedHeadDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
        super.setQuackStrategy(new QuackWithGaga());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的");
    }
}
