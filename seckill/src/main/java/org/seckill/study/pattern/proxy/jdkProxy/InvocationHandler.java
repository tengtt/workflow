package org.seckill.study.pattern.proxy.jdkProxy;

import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/26.
 */
public interface InvocationHandler {

    public void invoke(Object o, Method m);
}
