package com.crazymakercircle.mutithread.basic.create;

import com.crazymakercircle.util.Print;

import static com.crazymakercircle.util.ThreadUtil.getCurThreadName;

/**
 * Created by 尼恩@疯狂创客圈.
 */

public class CreateDemo {
    //静态常量
    //如果关键字static被省略，需要通过CreateDemo类的对象进行访问，那么每个对象都有自己的一份拷贝。
    //每个类对象都可以对共有域，所以最好不要将域定义为共有的。但是，如果将域定义为static final就没问题了。
    public static final int MAX_TURN = 5;

    //静态域
    //如果将域定义为static，每个类中只有一个这样的域。而每一个对象对于所有的实例域都有自己的一份拷贝。
    static int threadNo = 1;

    //静态方法不能操作对象，但是可以访问自身类中的静态域。
    static class DemoThread extends Thread {

        public DemoThread() {
            super("Mall-" + threadNo++);
        }

        public void run() {
            for (int i = 1; i < MAX_TURN; i++) {
                Print.cfo(getName() + ", 轮次：" + i);
            }
            Print.cfo(getName() + " 运行结束.");
        }
    }


    public static void main(String args[]) throws InterruptedException {
        Thread thread = null;
        //方法一：使用Thread子类创建和启动线程
        for (int i = 0; i < 2; i++) {
            thread = new DemoThread();
            thread.start();
        }

        Print.cfo(getCurThreadName() + " 运行结束.");
    }
}