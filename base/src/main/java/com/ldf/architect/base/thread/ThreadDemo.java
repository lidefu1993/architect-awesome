package com.ldf.architect.base.thread;


/**
 * @author lidefu
 * @date 2019/9/25 9:39
 */
public class ThreadDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).run();

    }

}
