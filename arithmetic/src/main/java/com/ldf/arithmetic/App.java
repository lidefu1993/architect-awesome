package com.ldf.arithmetic;


/**
 * @author lidefu
 * @date 2019/1/8 13:09
 */
public class App {

    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue+1);
        int n = -1;
        int abs = Math.abs(maxValue - n);
        System.out.println(abs);

        System.out.println(Math.abs(Integer.MAX_VALUE+1));
        if(abs<0){
            System.out.println(-abs);
        }else {
            System.out.println(abs);
        }
    }

}
