package com.ldf.architect.concurrent.demo.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.*;

/**
 * @author lidefu
 * @date 2019/9/25 11:07
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws Exception{
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory());
        Future<?> runnable = threadPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable 执行---------");
            }
        });

        Future<Object> callable = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000*400);
                System.out.println("callable 执行---------");
                return "ldf";
            }
        });

        Future<Object> callable2 = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000*300);
                System.out.println("callable 执行---------");
                return "ldf";
            }
        });

        Future<Object> callable3 = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000*300);
                System.out.println("callable 执行---------");
                return "ldf";
            }
        });

        Future<Object> callable4 = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000*300);
                System.out.println("callable 执行---------");
                return "ldf";
            }
        });

        System.out.println(runnable.isDone());
        System.out.println(callable.isDone());
        while (!runnable.isDone()) {
            System.out.println("runnable 未结束");
            Thread.sleep(500);
        }
        while (!callable.isDone()) {
            System.out.println("callable 未结束");
            Thread.sleep(500);
        }


        System.out.println("全部结束");
        threadPool.shutdown();
    }

}
