package org.seckill.study.pattern.responsibility;

import org.seckill.study.pattern.responsibility.handler.PriceHandlerFactory;
import org.seckill.study.pattern.responsibility.handler.PriceHandler;
import org.seckill.study.pattern.responsibility.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * Created by teng on 2016/5/27.
 */
public class Customer {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }



    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

        Random random = new Random();
        for(int i = 0; i <= 100; i++){
            System.out.println(i + ":");
            customer.requestDiscount(random.nextFloat());
        }

    }
}
