package com.ldf.arithmetic.leetcode;

/**
 * 回文数
 * @author lidefu
 * @date 2019/3/5 8:30
 */
public class TractsNumber {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
         示例 1:
         输入: 121
         输出: true
         示例 2:
         输入: -121
         输出: false
         解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
         示例 3:
         输入: 10
         输出: false
         解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */

    public static void main(String[] args) {
        System.out.println(String.valueOf(System.currentTimeMillis()).length());
        TractsNumber tractsNumber = new TractsNumber();
        System.out.println(tractsNumber.isPalindrome3(122221));
    }

    public boolean isPalindrome(int x) {
        String xs = String.valueOf(x);
        int length = xs.length();
        if(length == 1){
            return true;
        }
        int i = 0, j = length-1;
        while (i < j){
            if(xs.charAt(i) != xs.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(int x){
        int reverse = 0;
        int ori = x;
        if(x<10 && x>=0){
            return true;
        }
        if(x<0 || x%10==0){
            return false;
        }
        while (x >= 1){
            reverse = reverse*10 + x%10;
            x = x/10;
        }
        return reverse == ori;
    }

    public boolean isPalindrome3(int x){
        int reverse = 0;
        if(x<10 && x>=0){
            return true;
        }
        if(x<0 || x%10==0){
            return false;
        }
        while (x > reverse){
            reverse = reverse*10 + x%10;
            x = x/10;
        }
        return reverse == x || x == reverse/10;
    }
}
