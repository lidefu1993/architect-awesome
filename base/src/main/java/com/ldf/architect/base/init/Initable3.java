package com.ldf.architect.base.init;

/**
 * @author lidefu
 * @date 2019/8/23 10:12
 */
public class Initable3 {

    static int staticNonFinal = 74;
    static {
        System.out.println("init initable3");
    }

}
