package org.seckill.study.pattern.template;

/**
 * Created by teng on 2016/5/27.
 */
public class test {


    public static void main(String[] args){

        System.out.println("制备咖啡---------");
        RefreshBeverage b1 = new Coffee();
        b1.prepareBeverageTemplate();
        System.out.println("咖啡好了---------");


        System.out.println("************************************************");

        System.out.println("制备茶---------");
        RefreshBeverage b2 = new Tea();
        b2.prepareBeverageTemplate();
        System.out.println("茶好了---------");

    }
}
