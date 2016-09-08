package org.seckill.study.reflect;

import java.lang.reflect.Method;

/**
 * Created by teng on 2016/6/1.
 */
public class MethodDemo {

    public static void main(String[] args){

        /*获取print(int,int)方法，
        * 1、获取一个方法就是要获取类的信息，获取类的信息首先要获取类对象
        * */
        Foo a = new Foo();
        Class c = a.getClass();

        try {
            Method method =  c.getDeclaredMethod("print",new Class[]{int.class,int.class});
            //方法的反射操作
            Object o =  method.invoke(c.newInstance(),1,1);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
