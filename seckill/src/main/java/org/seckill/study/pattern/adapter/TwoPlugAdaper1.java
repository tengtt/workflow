package org.seckill.study.pattern.adapter;

/**
 * Created by teng on 2016/5/27.
 *
 * 采用继承的方式
 * 单继承，只能继承一个类。
 */
public class TwoPlugAdaper1 extends GBTwoPlug implements ThreePlugIf{


    @Override
    public void powerWithThree() {
        this.powerWithTwo();
        System.out.println("组合的方式-----------");
    }
}
