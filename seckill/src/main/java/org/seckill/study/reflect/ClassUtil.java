package org.seckill.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by teng on 2016/6/1.
 */
public class ClassUtil {

    /*
    *
    * 打印类的信息，包括类的成员函数，成员变量
    *
    * */

    public static void printClassMessage(Object obj){
        //获取类的类对象
        Class c = obj.getClass();
        //获取类名称
        String className = c.getName();
        System.out.println("类的名称是：" + className);
        /*Method类，方法对象
        * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
        * getDeclaredMethods()获取的是所有该类自己什么的方法，不问访问权限
        * */
        Method[] methods = c.getMethods();
        //c.getDeclaredMethods();

        for(int i = 0; i < methods.length; i++) {
            //得到方法的返回值类型的类类型
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(methods[i].getName() + "(");

            //获取参数类型
            Class[] paramTypes = methods[i].getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j != paramTypes.length - 1) {
                    System.out.print(paramTypes[j].getName() + ",");
                } else {
                    System.out.print(paramTypes[j].getName());
                }

            }
            System.out.println(")");


        }

    }

        public static void printFieldMessage(Object obj) {
        //获取类的类对象
        Class c = obj.getClass();
             /*
            * getFields()方法获取的是所有的public的成员变量的信息
            * getDeclaredFields()获取的是该类自己声明的成员变量的信息
            *
            * */
        Field[] fs = c.getFields();//c.getDeclaredFields();

        for (int k = 0; k < fs.length; k++) {
            //得到成员变量的类型的类类型
            Class fieldType = fs[k].getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = fs[k].getName();
            System.out.println(typeName + " " + fieldName);
        }
    }


    public static void printConMessage(Object obj) {

        Class c = obj.getClass();
        //构造函数
        Constructor[] cons = c.getDeclaredConstructors();//c.getDeclaredConstructors()

        for(Constructor con : cons){
            System.out.println("构造函数的名称：" + con.getName());
            Class[] paramTypes = con.getParameterTypes();
            System.out.print(con.getName() + "(");
            for(Class paramType : paramTypes){
                System.out.print(paramType.getName() + ",");
            }
            System.out.println(")");

        }


    }

}
