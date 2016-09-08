package org.seckill.study.pattern.responsibility.handler;

/**
 * Created by teng on 2016/5/27.
 * 销售小组长
 */
public class Lead extends PriceHandler {

    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.15){
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
