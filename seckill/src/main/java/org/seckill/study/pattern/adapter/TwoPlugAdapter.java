package org.seckill.study.pattern.adapter;

/**
 * Created by teng on 2016/5/27.
 * 二相转三相
 *
 * 组合适配器： 对象适配器
 *
 * 可以适配被适配者的所有子类
 *
 *
 * 适配器：
 * 1）重用现存的类，解决现存类和复用环境不一致的问题
 * 2）透明
 * 3）将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原因代码（遵循开闭原则）
 */
public class TwoPlugAdapter implements ThreePlugIf{

    private GBTwoPlug plug;

    public TwoPlugAdapter(GBTwoPlug plug) {
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        plug.powerWithTwo();
        System.out.println("通过转换器");
    }
}
