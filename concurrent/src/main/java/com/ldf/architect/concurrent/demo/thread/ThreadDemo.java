package com.ldf.architect.concurrent.demo.thread;

/**
 * @author lidefu
 * @date 2019/6/11 14:11
 */
public class ThreadDemo extends Thread {

    private int ticket = 5;

    @Override
    public void run(){
        System.out.println("-----------------------ThreadDemo------------------------");
        for (int i=0;i<10;i++)
        {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("--------------------被打断-----------------");
                return;
            }
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "  ticket = " + ticket--);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
