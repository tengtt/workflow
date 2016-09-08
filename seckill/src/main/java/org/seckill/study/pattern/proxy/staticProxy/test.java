package org.seckill.study.pattern.proxy.staticProxy;

/**
 * Created by teng on 2016/5/26.
 */
public class test {

    public static void main(String[] args){

        Car car = new Car();

        CarTimeProxy time = new CarTimeProxy(car);
        CarLogProxy log = new CarLogProxy(time);
        log.move();
    }
}
