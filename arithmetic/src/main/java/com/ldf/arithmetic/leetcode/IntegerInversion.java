package com.ldf.arithmetic.leetcode;

import java.util.Stack;

/**
 * 整数反转
 * @author lidefu
 * @date 2019/2/28 8:45
 */
public class IntegerInversion {

    /**
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     示例 1:
     输入: 123
     输出: 321
     示例 2:
     输入: -123
     输出: -321
     示例 3:
     输入: 120
     输出: 21
     *
     */

    public static void main(String[] args) {
        IntegerInversion inversion = new IntegerInversion();
        System.out.println(inversion.reverseOfficial(-474836));
    }

    public int reverseOfficial(int x){
        int rex = 0;
        while (x != 0){
            int pop = x%10;
            x/=10;
            if((rex > Integer.MAX_VALUE/10) || (rex == Integer.MAX_VALUE/10 && pop > 7) ) {
                return 0;
            }
            if((rex < Integer.MIN_VALUE/10) || (rex == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            }
            rex = rex*10 + pop;
        }
        return rex;
    }

    /**
     * 使用栈
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String s = String.valueOf(x);
        Stack<String> stack = new Stack<>();
        int i = isNegative ? 1 : 0;
        String[] split = s.split("");
        for(; i<split.length; i++){
            stack.push(split[i]);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.empty()){
            res.append(stack.pop());
        }
        Long aLong = Long.valueOf(res.toString());
        if(aLong > Integer.MAX_VALUE){
            return 0;
        }
        int r = Math.toIntExact(aLong);
        if (isNegative){
            return -r;
        }
        return r;
    }


    public int reverse2(int x){
        boolean isNegative = x < 0;
        String s = String.valueOf(x);
        int i = isNegative ? 1 : 0;
        String[] split = s.split("");
        long reverse = 0;
        int val = 0;
        for(; i<split.length; i++){
            val = Integer.valueOf(split[i]);
            if(isNegative){
                reverse += val*Math.pow(10, i-1);
            }else {
                reverse += val*Math.pow(10, i);
            }
        }
        int r = reverse > Integer.MAX_VALUE ? 0 : Math.toIntExact(reverse);
        if(isNegative){
            return -r;
        }
        return r;
    }

}
