package org.seckill.study.reflect;

/**
 * Created by teng on 2016/6/1.
 */
public class Foo {

    public void print(int a, int b){
        System.out.println(a + b);
    }

    public void print(String a, String b){
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }
}
