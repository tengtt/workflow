package org.seckill.study.thread.DaemonThread;

import java.util.Scanner;

/**
 * Created by teng on 2016/6/2.
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        System.out.println("进入主线程"+Thread.currentThread().getName());

        DaemonThread daemonThread = new DaemonThread();
        Thread t1 = new Thread(daemonThread);
        t1.setDaemon(true);
        t1.start();

        Scanner sc = new Scanner(System.in);
        sc.next();

        System.out.println("退出主线程"+Thread.currentThread().getName());
    }
}
