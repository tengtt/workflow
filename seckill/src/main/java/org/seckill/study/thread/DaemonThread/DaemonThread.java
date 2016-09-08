package org.seckill.study.thread.DaemonThread;

import java.io.*;

/**
 * Created by teng on 2016/6/2.
 */
public class DaemonThread implements Runnable{

    @Override
    public void run() {
        System.out.println("进入守护线程" + Thread.currentThread().getName());

        try{
            writeToFile();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("退出守护线程" + Thread.currentThread().getName());
    }

    public void writeToFile() throws Exception{
        File fileName = new File("C:/Users/teng/Desktop/daemon.txt");
            OutputStream os = new FileOutputStream(fileName,true);
            int count = 0;
            while( count < 999){
                os.write(("\r\nword"+count).getBytes());
                System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入了word"+ count++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
