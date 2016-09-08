package org.seckill.study.pattern.factory;

/**
 * Created by teng on 2016/5/27.
 *
 * 发型工厂,将产品和实现分离
 */
public class InHair implements HairInterface{

    @Override
    public void draw() {
        System.out.println("---中分发型---");
    }
}
