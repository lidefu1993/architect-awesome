package com.ldf.architect.concurrent;

import java.util.concurrent.*;

/**
 * @author lidefu
 * @date 2019/2/19 9:39
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        threadPool();
    }


    private static void threadPool() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6,
                1, TimeUnit.DAYS, new LinkedBlockingQueue<>());
        executor.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----");
            System.out.println(1);
            System.out.println("--------");
        });
        executor.shutdown();
        System.out.println("end");
    }

    private static void executors() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        System.out.println("-------begin-------");
        Future<Integer> future = service.submit(() -> {
            Thread.sleep(1000);
            return 23;
        });
        System.out.println("------end-----");
        while (true){
            if(future.isDone()){
                System.out.println("over: " + future.get());
                break;
            }
        }
        service.shutdown();
    }

}
