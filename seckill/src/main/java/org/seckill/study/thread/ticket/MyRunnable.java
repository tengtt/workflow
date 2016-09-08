package org.seckill.study.thread.ticket;

/**
 * Created by teng on 2016/6/2.
 */
public class MyRunnable implements Runnable{

    private int ticketsCount = 5;

    @Override
    public void run() {
        while(ticketsCount > 0){
            ticketsCount--;
            System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余票数为：" + ticketsCount);

        }
    }
}
