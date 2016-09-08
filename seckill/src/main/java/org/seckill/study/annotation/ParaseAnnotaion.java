package org.seckill.study.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/18.
 */
public class ParaseAnnotaion {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("Child");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist){
                //拿到类上注解实例
                Description d = (Description)c.getAnnotation(Description.class);
                System.out.println(d.value());
            }

            //下面两种方法获取方法上的注解实例
            Method[] ms = c.getMethods();
            for(Method m : ms){
                boolean isMExit = m.isAnnotationPresent(Description.class);
                if(isMExit){
                    Description d = (Description)m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            for(Method m:ms){
                Annotation[] as = m.getAnnotations();
                for(Annotation a : as){
                    if(a instanceof Description){
                        Description d = (Description)a;
                        System.out.println(d.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }


}
