package org.seckill.study.pattern.Singleton;

/**
 * Created by teng on 2016/5/25.
 *
 * 饿汉模式：在类加载时就初始化实例
 * 特点:加载比较慢，运行时获取对象的速度比较快
 * 线程安全
 *
 */
public class Singleton1 {

    //1、将构造方法私有化，不允许外部直接创建对象
    private Singleton1(){

    }
    //2、不允许外部创建，需要自己创建实例
    private static Singleton1 instance = new Singleton1();

    //3、提供一个用于外面获取实例的方法
    public static Singleton1 getInstance(){
        return instance;
    }

}
