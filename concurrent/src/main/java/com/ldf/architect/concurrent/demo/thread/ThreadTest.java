package com.ldf.architect.concurrent.demo.thread;

/**
 * @author lidefu
 * @date 2019/6/11 14:14
 */
public class ThreadTest {

    public static void main(String[] args) {
        threadTest();
//        runnableTest();
    }

    private static void threadTest(){
        System.out.println("----------ThreadTest begin----------");
        ThreadDemo demo = new ThreadDemo();
        demo.start();
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.interrupt();
        new ThreadDemo().start();
        new ThreadDemo().start();
        System.out.println("----------ThreadTest end----------");
    }

    private static void runnableTest(){
        System.out.println("----------RunnableTest begin----------");
        RunableDemo runableDemo = new RunableDemo();
        new Thread(runableDemo).start();
        new Thread(runableDemo).start();
        new Thread(runableDemo).start();
        new Thread(runableDemo).start();
        new Thread(runableDemo).start();
        new Thread(runableDemo).start();
        new Thread(runableDemo).start();
        System.out.println("----------RunnableTest end----------");
    }

}
