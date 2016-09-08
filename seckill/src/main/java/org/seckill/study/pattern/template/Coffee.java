package org.seckill.study.pattern.template;

/**
 * Created by teng on 2016/5/27.
 *
 * 具体子类，咖啡的子类
 */
public class Coffee extends RefreshBeverage{

    @Override
    protected void brew() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("添加糖和牛奶");
    }
}
