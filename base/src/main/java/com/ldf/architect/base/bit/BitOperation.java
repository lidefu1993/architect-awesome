package com.ldf.architect.base.bit;

/**
 * @author lidefu
 * @date 2019/9/3 10:44
 */
public class BitOperation {

    public static void main(String[] args) {
        and(4);
        or(5);
        xor(1214520);
        not(-253);
        leftMobile(-3, 1);
        rightMobile(-12, 2);
        unsignRightMobile(-12, 3);
        integerMaxValue();
    }

    /**
     * 按位与& 二进制下全为1结果为1
     *  应用：判断一个整数的奇偶性 n&1==1 ? 奇数 : 偶数
     *
     */
    private static void and(int n){
        System.out.println((n&1) == 1 ? "奇数" : "偶数");
    }

    /**
     * 按位或| 二进制下有一个为1结果为1
     *  应用：取一个整数的最接近的偶数 (n|1)-1 | (n|1)+1
     * @param n
     */
    private static void or(int n){
        System.out.println((n|1)+1);
    }

    /**
     * 按位异或^ 二进制某位不同为1 相同为0
     *  应用: 简单加密 n^秘钥 = r  r^秘钥=n
     */
    private static void xor(int n){
        int secret = 789456123;
        System.out.println(((n^secret)^secret) == n );
    }

    /**
     * 按位取反~ 二进制下0变成1 1变成0
     * @param n
     */
    private static void not(int n){
        System.out.println(~n + " sum:" + ((~n)+n));
    }

    /**
     * 左移 << 左移要保持符号位
     *  应用：n<<i == n*2^i
     * @param n
     */
    private static void leftMobile(int n, int i){
        System.out.println("左移：" + (n<<i));
    }

    /**
     * 右移 >> 负数高位补1 正数高位补0
     *    应用: n>>i == n/2^i(取整)
     * @param n
     */
    private static void rightMobile(int n, int i){
        System.out.println(n>>i);
    }

    /**
     * 无符号右移 >>> 不管正负 高位补0 所以负数无符号右移会变成特别大的正数
     * @param n
     */
    private static void unsignRightMobile(int n, int i){
        System.out.println(n>>>i);
    }

    private static void integerMaxValue(){
        int n = 1;
        System.out.println(Integer.MAX_VALUE >> 1);
        while (Integer.MAX_VALUE>>n++ != 1){

        }
        System.out.println("n: " + n);
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("2^n：" + (2^n));
        System.out.println((2^n) == Integer.MAX_VALUE);
    }

}
