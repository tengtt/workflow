package org.seckill.study.pattern.factory;

/**
 * Created by teng on 2016/5/27.
 */
public class HNFactory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new HNBoy();
    }

    @Override
    public Girl getGirl() {
        return new HNGirl();
    }
}
