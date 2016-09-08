package org.seckill.study.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by teng on 2016/6/1.
 */
public class MethodDemo1 {

    public static void main(String[] args){
        ArrayList list = new ArrayList();

        ArrayList<String> list1 = new ArrayList<String>();

        Class c1 = list.getClass();
        Class c2 = list1.getClass();

        System.out.println(c1 == c2);
        /*c1 == c2true,说明编译之后，集合的泛型是去泛型化的
        * java中集合的泛型是为了防止错误输入的，只在编译阶段有效，
        * 绕过编译就无效了。
        * */

        try {
            Method method = c2.getMethod("add", Object.class);
            //绕过编译操作就绕过了泛型
            method.invoke(c2.newInstance(),100);
            System.out.print(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
