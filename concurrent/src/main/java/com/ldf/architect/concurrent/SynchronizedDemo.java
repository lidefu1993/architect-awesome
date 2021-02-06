package com.ldf.architect.concurrent;

public class SynchronizedDemo {

    private final static String lock = "lock_test";
    private final static String lock2 = "lock_test2";

    public static void main(String[] args) {
        //对象实例加锁
//        lockTest1();

        //类锁
//        lockTest2();

        //代码块
        lockTest3();
    }

    /**
     * 对象实例加锁
     *
     * 加锁对象实例，执行需要获取该对象实例的锁
     *
     */
    public static void lockTest1(){
        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(()->{
            demo.m1("thread1");
        }).start();
        new Thread(()->{
            demo.m2("thread2");
        }).start();
        new Thread(()->{
            demo.m1("thread3");
        }).start();

        SynchronizedDemo demo2 = new SynchronizedDemo();
        new Thread(()->{
            demo2.m1("thread4,demo2");
        }).start();
    }

    /**
     * 类对象加锁 静态方法加锁-针对类对象加锁，类对象是全局唯一，故加锁后任一实例都不可
     */
    public static void lockTest2(){
        new Thread(()->{
            SynchronizedDemo.m3("lockTest2 thread1 类锁");
        }).start();
        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(()->{
            demo.m1("lockTest2 thread2 对象锁");
        }).start();
        new Thread(()->{
            demo.m3("lockTest2 thread3 对象锁");
        }).start();
    }

    /**
     * 代码块加锁 需要注意的给字符串加锁，字符串常量池会被缓冲的
     */
    public static void lockTest3(){
        new Thread(()->{
            SynchronizedDemo.m4("thread1 代码块");
        }).start();

        new Thread(()->{
            SynchronizedDemo.m5("thread2 代码块");
        }).start();

        new Thread(()->{
            SynchronizedDemo.m6("thread3  代码块");
        }).start();

    }

    public synchronized void m1(String t){
        try {
            System.out.println("m1:" + t);
            Thread.sleep(1000*30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2(String t){
        try {
            System.out.println("m2:" + t);
            Thread.sleep(1000*30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m3(String t){
        try {
            System.out.println("m3:" + t);
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m4(String t){
        synchronized (lock){
            try {
                System.out.println("m4:" + t);
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m5(String t){
        synchronized (lock){
            try {
                System.out.println("m5:" + t);
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m6(String t){
        synchronized (lock2){
            try {
                System.out.println("m6:" + t);
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
