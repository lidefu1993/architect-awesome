package com.ldf.architect.concurrent.demo.thread;

/**
 * @author lidefu
 * @date 2019/6/11 14:13
 */
public class RunableDemo implements Runnable {

    private int ticket = 5;

    @Override
    public void run() {
        synchronized (this){
            for (int i=0;i<10;i++)
            {
                if(ticket > 0){
                    try {
                        Thread.sleep((long) Math.abs(Math.random()*100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ticket = " + ticket--);
                }
            }
        }
    }

}
