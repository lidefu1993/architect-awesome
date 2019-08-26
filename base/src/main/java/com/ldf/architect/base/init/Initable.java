package com.ldf.architect.base.init;

/**
 * @author lidefu
 * @date 2019/8/23 10:08
 */
public class Initable {

    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println(" init Initable");
    }

}
