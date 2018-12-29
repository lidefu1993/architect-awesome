package com.ldf.architect.base;

/**
 * @author lidefu
 * @date 2018/12/25 8:55
 */
public class BitOperation {


    public static void main(String[] args) {
        moldTest(3,5);
    }

    /**
     * 取模测试
     * x对y取模
     * @param x
     * @param y y必须为2的n次方
     */
    private static void moldTest(int x, int y){
        int m1 = x % y;
        int m2 = x & (y-1);
        System.out.println("m1=" + m1 + ", m2=" + m2 + ", m1==m2=" + (m1==m2) );
    }

    private static void test1(){
        int i = -3;
        int j = i>>2;
        System.out.println("i: 10进制 " + i + " 2进制 "  + Integer.toBinaryString(i));
        System.out.println("j: 10进制 " + j + " 2进制 " + Integer.toBinaryString(j));
    }

}
