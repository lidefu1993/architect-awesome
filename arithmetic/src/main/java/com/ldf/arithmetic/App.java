package com.ldf.arithmetic;

import java.util.UUID;

/**
 * @author lidefu
 * @date 2019/1/8 13:09
 */
public class App {

    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(s.length());
    }

}
