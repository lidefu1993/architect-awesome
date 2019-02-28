package com.ldf.architect.concurrent.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lidefu
 * @date 2019/2/19 9:14
 */
public class WarehouseTest {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String[] args) throws InterruptedException {

        if(lock.writeLock().tryLock()){
            lock.writeLock().tryLock();
        }
        System.out.println();
    }

    private static void test(){
        lock.writeLock().tryLock();
    }

    private static void lockTest(){
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(() -> System.out.println(Thread.currentThread()));
        WarehouseLocked locked = new WarehouseLocked();
        //普通可重入锁测试
        new Thread(() -> locked.test1(Thread.currentThread()), "Thread-1").start();
        new Thread(() -> locked.test1(Thread.currentThread()), "Thread-2").start();
        //读写可重入锁测试
        new Thread(() -> locked.test2(Thread.currentThread()), "Thread-3").start();
        new Thread(() -> locked.test2(Thread.currentThread()), "Thread-4").start();
    }


    private static void synchronizedTest(){
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(WarehouseTest::synchronizedTest1);
        service.execute(WarehouseTest::synchronizedTest2);
    }

    private static void synchronizedTest1(){
        ExecutorService service1 = Executors.newFixedThreadPool(3);
        while (true){
            service1.execute(WarehouseSynchronized::pull);
            service1.execute(WarehouseSynchronized::pull);
            service1.execute(WarehouseSynchronized::pull);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void synchronizedTest2(){
        ExecutorService service1 = Executors.newFixedThreadPool(3);
        while (true){
            service1.execute(WarehouseSynchronized::take);
            service1.execute(WarehouseSynchronized::take);
            service1.execute(WarehouseSynchronized::take);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
