package org.seckill.study.pattern.factory;

/**
 * Created by teng on 2016/5/27.
 */
public class MCFactory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new MCBoy();
    }

    @Override
    public Girl getGirl() {
        return new MCGirl();
    }
}
