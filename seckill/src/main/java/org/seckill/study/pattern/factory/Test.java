package org.seckill.study.pattern.factory;

/**
 * Created by teng on 2016/5/27.
 */
public class Test {

    public static void main(String[] args){


        //工厂模式，定义一个用于创建对象的接口，让子类决定实例化哪个类
        //针对一个产品等级结构
        HairFactory factory = new HairFactory();
        HairInterface left = factory.getHair("left");
        if(null != left){
            left.draw();
        }

        HairInterface f = factory.getHairByClass("left");
        f.draw();
        HairInterface in = factory.getHairByClass("in");
        in.draw();

        //抽象工厂模式，为创建一组相关或者相互依赖的对象提供一个接口，而无需指定他们的具体类
        //面向多个产品等级结构
        PersonFactory factoryMC = new MCFactory();
        Girl girl = factoryMC.getGirl();
        girl.drawWom();

        PersonFactory factoryHN = new HNFactory();
        Boy boy = factoryHN.getBoy();
        boy.drawMan();



    }
}
