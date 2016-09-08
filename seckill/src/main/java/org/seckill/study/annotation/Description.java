package org.seckill.study.annotation;

import java.lang.annotation.*;

/**
 * Created by teng on 2016/5/18.
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //注解的作用域
@Retention(RetentionPolicy.RUNTIME)
@Inherited //允许子类继承,只会继承到类上的注解，部署继承方法上的注解
@Documented//生成到java文档中

/*注解类型受限：原始类型，String,Class,Annotation,Enumeration
* 注解可以没有成员，为标示注解*/
public @interface Description {
    //若注解只有一个成员，则成员名必须取名为value(),使用时可以忽略成员名和赋值号
    String value();
}
