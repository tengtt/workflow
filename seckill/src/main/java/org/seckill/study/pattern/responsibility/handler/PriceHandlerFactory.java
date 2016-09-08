package org.seckill.study.pattern.responsibility.handler;

/**
 * Created by teng on 2016/5/27.
 *
 * 工厂方法
 */
public class PriceHandlerFactory {

    public static PriceHandler createPriceHandler(){
        PriceHandler sales = new Sales();
        PriceHandler lead = new Lead();
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler vicePresident = new VicePresident();
        PriceHandler ceo = new CEO();

        sales.setSuccessor(lead);
        lead.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(ceo);

        return sales;

    }
}
