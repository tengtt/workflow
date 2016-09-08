package org.seckill.study.thread.ticket;

/**
 * Created by teng on 2016/6/2.
 *
 * 线程声明周期：
 * 创建--start() ---就绪状态（等待CPU，具有运行能力，但不一定运行）---运行状态(执行run方法里面的逻辑)----终止状态
 * 运行的线程，由于某些原因让出CPU资源，暂停自己程序，进入阻塞状态。
 *
 *
 * 线程类别：
 * 1、用户线程 运行在前台，执行具体的任务
 * 2、守护线程 运行在后台，为其他前台线程服务
 * 一旦所有用户线程都结束运行，守护线程会随JVM一起结束工作
 * 比如：垃圾回收线程
 *
 * 怎样设置守护线程：
 * 1、setDaemon(true) 必须在start()方法之前调用，否则会抛出异常IllegalThreadStateException
 * 2、守护线程中产生的新线程也是守护线程
 * 3、不是所有任务都可以分配给守护线程来执行，比如读写操作或者计算逻辑
 *
 */
public class test {

    public static void main(String[] args) {

        /*
        * new了三个线程，每个线程都有五张票
        * */
       /* MyThread t1 = new MyThread("窗口1");
        MyThread t2 = new MyThread("窗口2");
        MyThread t3 = new MyThread("窗口3");
        t1.start();
        t2.start();
        t3.start();*/

        MyRunnable r1 = new MyRunnable();
        Thread tr1 = new Thread(r1,"窗口1");
        Thread tr2 = new Thread(r1,"窗口2");
        Thread tr3 = new Thread(r1,"窗口3");
        tr1.start();
        tr2.start();
        tr3.start();
    }

}
