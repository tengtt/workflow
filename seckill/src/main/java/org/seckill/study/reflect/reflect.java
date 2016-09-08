package org.seckill.study.reflect;

/**
 * Created by teng on 2016/5/31.
 *
 * 普通数据类型，静态成员不是对象
 *
 * java中，万事万物都是对象
 *
 * 类是谁的对象？是java.lang.Class类的实例对象
 *
 *
 * 编译时刻加载类：静态加载
 * 运行时刻加载类：动态加载
 *
 */
public class reflect {


    public static void main(String[] args){

        //foo是Foo实例的类型
        Foo foo = new Foo();
        //任何一个类都是Class对象，这个实例对象有种表示方式
        //c1表示了Foo类的类类型，是Class类的类对象
        Class c1 = foo.getClass();
        Class c2 = null;
        try {
            c2 = Class.forName("Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Foo foo1 = null;
        try {
            foo1 = (Foo)c2.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Class n1 = int.class;
        Class n2 = String.class;
        Class n3 = Double.class;
        Class n4 = double.class;
        Class n5 = void.class;

        System.out.println(n5);
    }
}
