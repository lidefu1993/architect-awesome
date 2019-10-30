package com.ldf.architect.concurrent.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lidefu
 * @date 2019/9/25 10:57
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("开始");
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000*2);
                System.out.println("callable");
                return "ldf";
            }
        });
        System.out.println("结束");
        task.run();
        System.out.println(task.isDone());
        while (!task.isDone()){
            System.out.println("尚未结束");
            Thread.sleep(1000);
        }
        System.out.println(1);

    }

}
