package com.ldf.arithmetic.other;


/**
 * @author lidefu
 * @date 2019/9/26 10:49
 */
public class MaxLengthStr {

    /**
     *
     * 一个含有多个空格的ASCII串，求非空格子串的最长长度，要求时间和空间最优。
     * 例如，输入："aa aa aaaa aaa a a a aa aa a"，输出：4；
     *
     */

    public static void main(String[] args) {
        String string = "aa aa aaaa aaa a a a aa aa a  bbbbbbb aaa";
        System.out.println(solution1(string));
        System.out.println(solution2(string));
    }

    /**
     * 最优解
     * @param str 字符串
     * @return 最大长度
     */
    private static int solution2(String str){
        if(str == null || str.trim().isEmpty()){
            return 0;
        }
        int max = 0, item = 0;
        for(char c : str.toCharArray()){
            if(c == ' '){
                max = item > max ? item : max;
                item = 0;
            }else {
                item++;
            }

        }
        return item > max ? item : max;
    }

    private static int solution1(String str){
        if(str == null || str.trim().isEmpty()){
            return 0;
        }
        int max = 0;
        for(String s : str.split(" ")){
            max = s.length() > max ? s.length() : max;
        }
        return max;
    }



}
