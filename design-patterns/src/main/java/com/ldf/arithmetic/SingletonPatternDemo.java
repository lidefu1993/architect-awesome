package com.ldf.arithmetic;

/**
 * @author lidefu
 * @date 2019/9/26 13:48
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {

    }

    //懒汉 线程安全
    static class Singleton1{
        private static Singleton1 instance = null;
        private Singleton1(){}
        public static synchronized  Singleton1 getInstance(){
            if(instance == null){
                return new Singleton1();
            }
            return instance;
        }
    }



}
