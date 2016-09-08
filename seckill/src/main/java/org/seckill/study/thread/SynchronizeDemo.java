package org.seckill.study.thread;

/**
 * Created by teng on 2016/6/1.
 *
 * 可见性：一个线程对共享变量值得修改，能够及时地被其他线程看到。
 * 共享变量：如果一个变量在多个线程的工作内存中都存在副本，那么这个变量就是这几个线程的共享变量。
 *
 * java内存模型（JMM）：原则
 * 1）线程对共享变量的所有操作都必须在自己的工作内存中进行，不能直接从主内存中读取。
 * 2）不同线程之间无法直接访问其他线程工作内存中的变量，线程间变量值的传递需要通过主内存来完成
 *
 * 实现共享变量可见性原理：
 * 1）把工作内存1中更新过的共享变量刷新到主内存中
 * 2）把主内存中最新的共享变量的值更新到工作内存2中
 *
 *
 * java语言层面支持的可见性：
 * synchronized: JMM关于synchronized的两条规定：
 * 1）线程解锁前：必须把共享变量的最新值刷新到主内存中
 * 2）线程加锁时，将清空工作内存中共享变量的值，从而使用共享变量时需要从主内存中重新读取最新的值
 *
 * 线程执行互斥代码的过程;
 * 1)获得互斥锁
 * 2）清空工作内存
 * 3）从主内存拷贝变量的最新副本到工作内存
 * 4）执行代码
 * 5）将更改后的共享变量的值刷新到主内存中
 * 6）释放互斥锁
 *
 *
 * 重排序：
 * 代码书写的顺序和实际执行的顺序不同，指令重排序是编译器或处理器为了提高性能而做的优化。
 * 1、编译器优化的重排序
 * 2、指令级并行重排序
 * 3、内存系统的重排序
 *
 * as-if-serial：无论如何重排序，程序执行的结果应该与代码顺序执行的结果一致。
 * java编译器、运行时和处理器都会保证java单线程下遵循as-if-serial语义
 *
 * volatile和synchronize：
 * 1）volatile不需要加锁，比synchronize更轻量级，不会阻塞线程；
 * 2）从内存可见性角度讲，volatile读相当于加锁，volatile写相当于解锁。
 *
 *
 * 执行顺序: 1.2-->2.1-->2.2-->1.1
 *
 * 导致共享变量在线程间不可见的原因：
 * 1）线程的交叉执行        -------synchronize的原子性，线程不能交叉执行
 * 2）重排序结合线程交叉执行 --------synchronize的原子性
 * 3）共享变量更新后的值没有在工作内存中与主内存间及时更新--------synchronize的可见性
 *
 * 多个线程执行，互相争取CPU资源
 *
 *
 *
 * java中对共享数据操作的并发控制采用传统的加锁机制。
 * 线程之间的交互，采用wait()和notify()。不提倡使用suspend()和resume()方法，他们容易造成死锁。
 * 共享数据的访问权限都必须完全定义为private
 * java中没有提供检测和避免死锁的专门机制，因此完全由程序进行控制。
 *
 */
public class SynchronizeDemo {

    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    public void write(){
        ready = true;            //1.1
        number = 2;              //1.2
    }
    public void read(){
        if(ready){               //2.1
            result = number * 3; //2.2
        }
        System.out.print("result的值为：" + result);
    }

    private class ReadWriteThread extends Thread{

        private boolean flag;
        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }

        public void run(){
            if(flag) write();
            else read();
        }
    }

    public static void main(String[] args){
        SynchronizeDemo syn = new SynchronizeDemo();
        syn.new ReadWriteThread(true).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        syn.new ReadWriteThread(false).start();

    }




}
