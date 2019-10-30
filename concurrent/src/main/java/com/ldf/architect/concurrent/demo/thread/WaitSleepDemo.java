package com.ldf.architect.concurrent.demo.thread;

/**
 * @author lidefu
 * @date 2019/9/25 15:19
 */
public class WaitSleepDemo {


    public static void main(String[] args) throws InterruptedException {
        String l1 = "l1";
        new Thread(() -> {
            System.out.println("进入t1");
            synchronized (l1){
                System.out.println("t1 ---获取到了锁l1");
                try {
                    Thread.sleep(1000);
                    System.out.println("t1 --- 稍微等了一下");
                    l1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 ---- 执行结束");
        }).start();
        Thread.sleep(2000);
        new Thread(()->{
            System.out.println("进入t2");
            synchronized (l1){
                System.out.println("t2 ---获取到了锁l2");
                l1.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 --- 唤醒后稍微等一下 在此之前t1需要等待获取到锁");
            }
            System.out.println("t2--结束 t1可以继续执行了");
        }).start();
    }




}
