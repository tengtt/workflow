package org.seckill.pattern.proxy.jdkProxy;
import org.seckill.study.pattern.proxy.jdkProxy.InvocationHandler;
import org.seckill.study.pattern.proxy.staticProxy.Moveable;

import java.lang.reflect.Method;
public class $Proxy0 implements Moveable {
private InvocationHandler h;
    public $Proxy0(InvocationHandler h){
       super();
       this.h = h;

    }

@Override
public void move() {
   try{
       Method m = Moveable.class.getMethod("move");
       h.invoke(this,m);
   }catch(Exception e){
   e.printStackTrace();
   }
 }
 }