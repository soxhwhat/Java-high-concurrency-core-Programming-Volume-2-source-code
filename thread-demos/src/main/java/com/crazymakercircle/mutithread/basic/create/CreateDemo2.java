package com.crazymakercircle.mutithread.basic.create;

import com.crazymakercircle.util.Print;

import static com.crazymakercircle.util.ThreadUtil.getCurThreadName;

/**
 * Created by 尼恩@疯狂创客圈.
 */

public class CreateDemo2 {
    public static final int MAX_TURN = 5;


    static int threadNo = 1;

    static class RunTarget implements Runnable  //① 实现Runnable接口
    {
        public void run()  //② 在这些写业务逻辑
        {
            for (int j = 1; j < MAX_TURN; j++) {
                Print.cfo(getCurThreadName() + ", 轮次：" + j);
            }

            Print.cfo(getCurThreadName() + " 运行结束.");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread = null;

//        //方法2.1：使用实现Runnable的实现类创建和启动线程
//
//        for (int i = 0; i < 2; i++) {
//            Runnable target = new RunTarget();
        //（1）public Thread(Runnable target)（2）public Thread(Runnable target，String name)
//            thread = new Thread(target, "RunnableThread" + threadNo++);
//            thread.start();
//        }
//
//        //方法2.2：使用实现Runnable的匿名类创建和启动线程
//
//        for (int i = 0; i < 2; i++) {
//            thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 1; j < MAX_TURN; j++) {
//                        Print.cfo(getCurThreadName() + ", 轮次：" + j);
//                    }
//                    Print.cfo(getCurThreadName() + " 运行结束.");
//                }
//            }, "RunnableThread" + threadNo++);
//            thread.start();
//        }
        //方法2.3：使用实现lambda表达式创建和启动线程
        for (int i = 0; i < 2; i++) {
            thread = new Thread(() ->
            {
                for (int j = 1; j < MAX_TURN; j++) {
                    Print.cfo(getCurThreadName() + ", 轮次：" + j);
                }
                Print.cfo(getCurThreadName() + " 运行结束.");
            }, "RunnableThread" + threadNo++);
            thread.start();
        }
        Print.cfo(getCurThreadName() + " 运行结束.");
    }
}