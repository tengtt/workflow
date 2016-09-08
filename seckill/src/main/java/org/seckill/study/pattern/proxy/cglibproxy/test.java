package org.seckill.study.pattern.proxy.cglibproxy;

/**
 * Created by teng on 2016/5/26.
 */
public class test {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train tarin = (Train)proxy.getProxy(Train.class);
        tarin.move();

    }
}
