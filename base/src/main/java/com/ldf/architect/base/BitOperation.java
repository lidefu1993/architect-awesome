package com.ldf.architect.base;

/**
 * @author lidefu
 * @date 2018/12/25 8:55
 */
public class BitOperation {


    public static void main(String[] args) {
        System.out.println(~-3);
    }

    private static void test1(){
        int i = -3;
        int j = i>>2;
        System.out.println("i: 10进制 " + i + " 2进制 "  + Integer.toBinaryString(i));
        System.out.println("j: 10进制 " + j + " 2进制 " + Integer.toBinaryString(j));
    }

}
