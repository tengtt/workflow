package org.seckill.study.pattern.strategy;

/**
 * Created by teng on 2016/5/30.
 */
public abstract class Duck {

    private FlyingStrategy flyingStrategy;

    private QuackStrategy quackStrategy;

    public void fly(){
        flyingStrategy.performFly();
    }

    public abstract void display();

    public void quack(){
        quackStrategy.performQuack();
    }


    public FlyingStrategy getFlyingStrategy() {
        return flyingStrategy;
    }

    public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }

    public QuackStrategy getQuackStrategy() {
        return quackStrategy;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }
}
