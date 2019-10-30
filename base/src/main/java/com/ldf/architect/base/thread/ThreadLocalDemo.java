package com.ldf.architect.base.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lidefu
 * @date 2019/9/23 15:38
 */
public class ThreadLocalDemo {

    /**
     * ExecutorService / ThreadPoolExecutor
     *
     */

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {

        System.out.println("before:" + threadLocal.get());

        Thread thread1 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
            System.out.println("before:" + threadLocal.get());
            threadLocal.set(name);
            System.out.println("after:" + threadLocal.get());
        });
        thread1.setName("ldf-1");

        Thread thread2 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name);
            System.out.println("before:" + threadLocal.get());
            threadLocal.set(name);
            System.out.println("after:" + threadLocal.get());
        });
        thread2.setName("ldf-2");

        thread1.start();
        thread2.start();

        threadLocal.set("after");

        String s = threadLocal.get();

        System.out.println("after:" + threadLocal.get());
    }

}
