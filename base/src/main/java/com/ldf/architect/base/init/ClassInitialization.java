package com.ldf.architect.base.init;

import java.util.Random;

/**
 * @author lidefu
 * @date 2019/8/23 10:13
 */
public class ClassInitialization {

    public static Random random = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref ");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticFinal);
        Class<?> initable3 = Class.forName("com.ldf.architect.base.init.Initable3");
        System.out.println("after init initable3 ");
        System.out.println(Initable3.staticNonFinal);
    }

}
