package org.seckill.study.pattern.responsibility.handler;

/**
 * Created by teng on 2016/5/27.
 *
 * 单一职责原则：在设计接口时，只将与该接口相关的业务放在该接口中
 *
 * 责任链模式：
 * 1）开闭原则
 *
 * 缺点：
 * 1）时间
 * 2）内存
 * 3）性能
 *
 * java中使用的责任链模式：Exception,Filter
 */
public abstract class PriceHandler {

    /*
    * 直接后继，用于传递请求
    * */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

   public abstract void processDiscount(float discount);

    /*
    * 创建priceHandler的工厂方法
    * 放在这个接口中不符合单一职责原则
    * */
    /*public static PriceHandler createPriceHandler(){
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

    }*/
}
