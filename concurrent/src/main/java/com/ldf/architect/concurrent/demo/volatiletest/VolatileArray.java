package com.ldf.architect.concurrent.demo.volatiletest;

import java.util.concurrent.TimeUnit;

public class VolatileArray {

    public static int[] ints = new int[5];
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            //线程A
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ints[0] = 2;
        }).start();
        new Thread(() -> {            //线程B
            try {
                while (true) {
//                    Thread.sleep(100);
                    if (ints[0] == 2) {
                        System.out.println("结束");
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }

}
