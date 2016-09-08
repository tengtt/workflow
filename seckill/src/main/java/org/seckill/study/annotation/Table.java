package org.seckill.study.annotation;

import java.lang.annotation.*;

/**
 * Created by teng on 2016/5/18.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();

}
