package org.seckill.study.pattern.template;

/**
 * Created by teng on 2016/5/27.
 * 抽象基类，为所有子类提供一个算法框架
 *
 * 适用场景：
 * 1、算法或操作遵循相似的逻辑
 * 2、重构时（把相同的代码抽取到父类中）
 * 3、重要、复杂的算法，核心算法设计为模板算法
 *
 * 优点：
 * 1、封装性好
 * 2、复用性好
 * 3、屏蔽细节
 * 4、便于维护
 * 缺点：
 *
 * java是单继承。extends一个父类。
 * 引入新的继承比较困难
 */
public abstract class RefreshBeverage {

    /*
    * 封装所有子类共同遵循的算法框架
    * 不能被子类更改步骤，所以声明为final
    * */
    public final void prepareBeverageTemplate() {


        //1、将水煮沸
        boilWater();

        //2、泡制饮料
        brew();

        //3、将饮料倒入杯中
        pourInCup();

        //4、加入调味料

        if (isCustomerWants()) {
            addCondiments();
        }
    }

    /*钩子函数，Hook
    * 提供一个默认或空的实现
    * 具体的子类可以自行决定是否挂钩以及如果挂钩
    *
    * */
    protected boolean isCustomerWants(){
        return true;
    }



    /*
    * 基本方法，这两步对所有饮料操作都一样，所有方法私有。
    * */
    private void boilWater(){
        System.out.println("将水煮沸");
    }

    private void pourInCup(){
        System.out.println("将饮料倒入杯中");
    }

    /*
    * 各种饮料实现不同，所有由子类覆写
    * */
    protected abstract void brew();

    protected abstract void addCondiments();

}
