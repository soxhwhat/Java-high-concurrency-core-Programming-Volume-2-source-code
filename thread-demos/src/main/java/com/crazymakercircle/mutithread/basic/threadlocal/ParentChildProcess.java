package com.crazymakercircle.mutithread.basic.threadlocal;

/**
 * <p>在开始处详细描述该类的作用</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Soxhwhat
 * @date 2023/2/21 10:07
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class ParentChildProcess {
    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
//         子线程无法获取父线程的ThreadLocal值
//    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();


    public static void main(String[] args) {
        threadLocal.set("parent");
        System.out.println("parent threadLocal value: " + threadLocal.get());

        Thread thread = new Thread(() -> {
            System.out.println("child threadLocal value: " + threadLocal.get());
        });
        /******************子线程可以获取父线程的ThreadLocal值******************/
        /**
         * Thread维护了一个ThreadLocal.ThreadLocalMap inheritableThreadLocals变量
         * 如果想让子线程可以获取父线程的ThreadLocal值，需要设置ThreadLocal的inheritable属性为true
         *
         * private void init(ThreadGroup g, Runnable target, String name,
         *                       long stackSize, AccessControlContext acc,
         *                       boolean inheritThreadLocals) {
         *  // 省略部分代码
         *  Thread parent = currentThread();
         *
         *     if (inheritThreadLocals && parent.inheritableThreadLocals != null)
         *         // copy父线程的 map，创建一个新的 map 赋值给当前线程的inheritableThreadLocals
         *   this.inheritableThreadLocals =
         *             ThreadLocal.createInheritedMap(parent.inheritableThreadLocals); //浅拷贝
         *
         *  // 省略部分代码
         *    }
         *
         * 如果你设置了 inheritableThreadLocals 变量，那么 Thread 就会把父线程 ThreadLocal threadLocals 中的所有数据都 copy 到子线程的 InheritableThreadLocal inheritableThreadLocals 中
         */


        thread.start();
    }
}
