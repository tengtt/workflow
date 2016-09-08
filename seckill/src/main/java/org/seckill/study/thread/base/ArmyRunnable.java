package org.seckill.study.thread.base;

/**
 * Created by teng on 2016/6/2.
 */
public class ArmyRunnable implements Runnable{

    volatile boolean keepRunnig = true;

    @Override
    public void run() {
        while(keepRunnig){
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + "进攻对象[" + i + "]");

                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束战斗");
    }
}
