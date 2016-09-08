package org.seckill.study.pattern.Singleton;

/**
 * Created by teng on 2016/5/25.
 *
 * 懒汉模式：当用户使用时才去创建实例
 * 特点：加载类时比较快，但是运行时获取对象的速度比较慢
 *线程不安全
 * 线程A，线程B，同事调用getInstance方法，可能会导致并发问题，并发情况下，会创建出两个实例来
 */
public class Singleton2 {

    private Singleton2(){

    }

    private static Singleton2 instance;

    private static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
