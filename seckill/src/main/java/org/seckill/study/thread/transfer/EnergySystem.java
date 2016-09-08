package org.seckill.study.thread.transfer;

/**
 * Created by teng on 2016/6/2.
 */
public class EnergySystem {

    private final double[] energyBoxes;

    private final Object lockObj = new Object();

    //initialEnergy 初始值
    public EnergySystem(int n, double initialEnergy){
        energyBoxes = new double[n];
        for(int i = 0; i < energyBoxes.length; i++){
            energyBoxes[i] = initialEnergy;
        }

    }

    /**
     *能量转移，从一个盒子到另一个盒子
     * @param from 能量源
     * @param to 能量终点
     * @param amount 能量值
     */
    public void transfer(int from, int to, double amount){

        //加锁，对线程加互斥操作
        synchronized (lockObj){

            //使程序退出，程序退出后依然有机会去竞争cpu资源，再次执行线程，所以，将此方法改为while{}
          /*  if(energyBoxes[from] < amount){
                return;
            }*/
            //条件不符合时，将线程进入等待状态，而不是继续竞争CPU资源
            //wait set
            while(energyBoxes[from] < amount){

                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());

            energyBoxes[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            energyBoxes[to] += amount;
            System.out.printf("能量总和：%10.2fn",getTotalEnergies());
            //唤醒所有在lockObj对象上等待的线程
            lockObj.notifyAll();
        }
    }

    public double getTotalEnergies(){
        double sum = 0;
        for(double amount: energyBoxes){
            sum += amount;
        }
        return sum;

    }

    public int getBoxAmount(){
        return energyBoxes.length;
    }




}
