package org.seckill.study.pattern.template;

/**
 * Created by teng on 2016/5/27.
 */
public class Tea extends RefreshBeverage{
    @Override
    protected void brew() {
        System.out.println("用80度的热水浸泡茶叶5分钟");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入冰糖");
    }

    /*
    * 通过覆载的方式，选择钩子函数
    * */
    protected boolean isCustomerWants(){
        return false;
    }
}
