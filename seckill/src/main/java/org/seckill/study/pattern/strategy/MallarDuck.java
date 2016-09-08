package org.seckill.study.pattern.strategy;

import org.seckill.study.pattern.strategy.impl.QuackWithGaga;
import org.seckill.study.pattern.strategy.impl.FlyWithWin;

/**
 * Created by teng on 2016/5/30.
 */
public class MallarDuck extends Duck{

    public MallarDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
        super.setQuackStrategy(new QuackWithGaga());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }


}
