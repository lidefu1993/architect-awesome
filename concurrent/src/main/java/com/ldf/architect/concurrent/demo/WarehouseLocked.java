package com.ldf.architect.concurrent.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lidefu
 * @date 2019/2/21 9:24
 */
public class WarehouseLocked {

    /**
     * 可重入锁
     */
    private Lock lock1 = new ReentrantLock();

    /**
     * 读写锁
     * 可同时读 不可同时读写 不可同时写
     */
    private ReentrantReadWriteLock lock2 = new ReentrantReadWriteLock();

    public void test1(Thread thread){
        try {
            if(lock1.tryLock(500, TimeUnit.MILLISECONDS)){
                try {
                    Thread.sleep(1000);
                    System.out.println(thread.getName()+"获取到锁lock1");
                }finally {
                    lock1.unlock();
                }
            }else {
                System.out.println(thread.getName()+"未获取到锁lock1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2(Thread thread){
        ReentrantReadWriteLock.ReadLock readLock = lock2.readLock();
        try {
            if(readLock.tryLock(100, TimeUnit.MILLISECONDS)){
                try {
                    Thread.sleep(1000);
                    System.out.println(thread.getName()+"获取到锁lock2");
                }finally {
                    readLock.unlock();
                }
            }else {
                System.out.println(thread.getName()+"未获取到锁lock2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
