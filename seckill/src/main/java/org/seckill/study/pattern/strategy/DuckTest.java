package org.seckill.study.pattern.strategy;

/**
 * Created by teng on 2016/5/30.
 *
 * 策略模式缺点：
 * 1、客户代码需要了解每个策略实现的细节
 * 2、增加了对象的数目
 *
 * 适应场景：
 * 1、许多相关的类仅仅是行为差异
 * 2、运行时采取不同的算法变体
 * 3、通过条件语句在每个分支中选取一
 */
public class DuckTest {

    public static void main(String[] args){
        Duck duck1 = new MallarDuck();
        duck1.display();
        duck1.quack();
        duck1.fly();


        Duck duck2 = new RedHeadDuck();
        duck2.display();
        duck2.quack();
        duck2.fly();

        Duck duck3 = new RubberDuck();
        duck3.display();
        duck3.quack();
        duck3.fly();

        Duck duck4 = new BigYellow();
        duck4.display();
        duck4.quack();
        duck4.fly();

        Duck duck5 = new SpaceDuck();
        duck5.display();
        duck5.quack();
        duck5.fly();

    }
}
