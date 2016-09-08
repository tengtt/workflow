package org.seckill.study.thread.base;

/**
 * Created by teng on 2016/6/2.
 */
public class Stage extends Thread{

    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年，。。。。。。。。。。。。。。");

        ArmyRunnable armyTaskOfDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread armyOfSuiDynasty = new Thread(armyTaskOfDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");

        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣，半路杀出了个程咬金");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想就是结束战争，使人们安居乐业");


        armyTaskOfDynasty.keepRunnig = false;
        armyTaskOfRevolt.keepRunnig = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();

        //所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束");
    }



    public static void main(String[] args){
        new Stage().start();
    }
}
