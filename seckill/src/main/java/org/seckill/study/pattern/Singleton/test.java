package org.seckill.study.pattern.Singleton;

/**
 * Created by teng on 2016/5/25.
 */
public class test {

    public static void main(String[] args){

        //饿汉模式
        /*Singleton s1 = Singleton.instance;
        Singleton s2 = Singleton.instance;*/
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        if(s1 == s2){
            System.out.println("s1 和 s2 是一个实例");
        }else{
            System.out.println("s1 和 s2 不是一个实例");
        }

    }
}
