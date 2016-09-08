package org.seckill.study.thread.base;

/**
 * Created by teng on 2016/6/2.
 */
public class KeyPersonThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始了战斗");
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "攻击隋军。。。");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗");
    }
}
