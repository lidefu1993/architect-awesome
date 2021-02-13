package com.ldf.architect.concurrent.demo.volatiletest;

/**
 * volatile 修饰引用类型
 */
public class VolatileObject {

    public static Item item = new Item();

    public static void main(String[] args) {
        test();
    }

    public static void test(){

        new Thread(()->{
            try {
                Thread.sleep(1000);
                item.tag = 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                while (true){
                    System.out.println("----");
                    if(item.tag != 0){
                        break;
                    }
                    Thread.sleep(200L);
                }
                System.out.println("结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static class Item{
        public int tag;
    }

}
