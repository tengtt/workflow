package org.seckill.study.thread.transfer;

import org.seckill.study.pattern.strategy.MallarDuck;

/**
 * Created by teng on 2016/6/2.
 */
public class EnergyTransferTask implements Runnable{

    private EnergySystem energySystem;

    //能量转移的源能量盒子下标
    private int fromBox;

    //单次能量转移最大单元
    private double maxAmount;

    //最大休眠时间
    private int DELAY = 0;


    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {

        while(true){
            int toBox = (int)(energySystem.getBoxAmount()* Math.random());
            double amount = maxAmount *Math.random();
            energySystem.transfer(fromBox, toBox, amount);
            try {
                Thread.sleep((int)(DELAY*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
