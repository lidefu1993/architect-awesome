package com.ldf.architect.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author ldf
 * @date 2019/10/11 16:54
 **/
public class CountdownlatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            Service service = new CountdownlatchDemo().new Service(countDownLatch, 100000L);
            service.test();
        }).start();

        new Thread(() -> {
            Service service = new CountdownlatchDemo().new Service(countDownLatch, 60000L);
            service.test();
        }).start();

        countDownLatch.await();
        System.out.println("--------------------结束--------------------");
        System.exit(200);
    }

    public class Service{
        private CountDownLatch countDownLatch;
        private long time;
        public Service(CountDownLatch countDownLatch, long time){
            this.countDownLatch = countDownLatch;
            this.time = time;
        }
        public void test(){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完成----"+time);
            countDownLatch.countDown();
        }
    }

}
