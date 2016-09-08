package org.seckill.study.thread;

/**
 * Created by teng on 2016/6/1.
 *
 * volatile如何实现内存可见性：
 * 通过加入内存屏障和禁止重排序来实现的
 * 1）对volatile变量执行写操作时，会在写操作后加入一条store屏障指令
 * 2）对volatile变量执行读操作时，会在读操作前加入一条load屏障指令
 *
 * 通俗来讲：volatile变量在每次被线程访问时，都强迫从主内存中重读该变量的值，而当该变量发生变化时，又会强迫将最新的值刷新到主内存，
 * 这样任何时刻，不同的线程总能看到该变量的最新值。
 *
 * 线程写volatile变量的过程：
 * 1）改变线程工作内存中volatile变量副本的值
 * 2）将改变后的副本的值从工作内存刷新到主内存
 * 线程读volatile变量的过程：
 * 1）从主内存中读取volatile变量的最新值到线程的工作内存中
 * 2）从工作内存中读取volatile变量的副本
 *
 *
 * volatile使用场景：
 * 1）对变量的写入操作不依赖其当前值,如：number++,count=count*5，不满足。 如 boolean变量，记录温度变化的变量等，满足。
 * 2）该变量没有包含在具有其他变量的不变式中。多个volatile变量，每个volatile变量要独立于其他volatile变量。
 * 如：不变式 （volatile）low < （volatile）up 不满足。
 *
 *
 */
public class VolatileDemo {

    private volatile int number = 0;

    public int getNumber(){
        return this.number;
    }
    public void increase(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.number++;
    }

    public static void main(String[] args){

        final VolatileDemo volatileDemo = new VolatileDemo();
        for(int i = 0; i < 20; i++){
            new  Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.increase();
                }
            }).start();

        }
        //如果还有子线程在运行，主线程就让出CPU资源
        //知道所有的子线程都运行完毕，主线程再继续往下执行
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.print("number:"+ volatileDemo.getNumber());
    }

}
