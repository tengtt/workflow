package org.seckill.study.annotation.test;

import org.seckill.study.annotation.Description;

/**
 * Created by teng on 2016/5/18.
 */
/*@Description("I am class annotation")*/
public class Child extends Person {

    @Override
    public String name() {
        return null;
    }

    @Description("I am method annotation")
    public void test(){

    }

}
