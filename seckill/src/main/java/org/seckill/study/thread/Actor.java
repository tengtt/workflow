package org.seckill.study.thread;

/**
 * Created by teng on 2016/6/1.
 * 进程: 程序或任务的执行过程。动态概念。(持有资源和内存)资源和线程的载体。QQ
 * 线程：QQ中的文件传输，聊天都是线程
 *
 * Runnable方式可以避免Thread方式由于Java单继承特性带来的缺陷。
 * Runnable的代码可以被多个线程共享，适合于多个线程处理统一资源的情况。
 *
 */
public class Actor extends Thread {

    public void run(){
        System.out.println(this.getName() + "是一个演员");
        int count = 0;

        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(this.getName() + "登台演出 " + (++count));
            if(count == 100){
                keepRunning = false;
            }

            if(count % 10 == 0 ){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.getName() + "的演出结束");
    }

    public static void main(String[] args){
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actress = new Thread(new Actress());
    }

}
