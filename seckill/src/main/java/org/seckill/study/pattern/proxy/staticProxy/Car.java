package org.seckill.study.pattern.proxy.staticProxy;

import java.util.Random;

/**
 * Created by teng on 2016/5/26.
 */
public class Car implements Moveable {

    public void move(){


        try{
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中---------");
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
