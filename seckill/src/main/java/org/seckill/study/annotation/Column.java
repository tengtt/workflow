package org.seckill.study.annotation;

import java.lang.annotation.*;

/**
 * Created by teng on 2016/5/18.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value();

}
