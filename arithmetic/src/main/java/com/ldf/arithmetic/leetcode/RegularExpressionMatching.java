package com.ldf.arithmetic.leetcode;

import sun.security.util.Length;

/**
 * 正则表达式匹配
 * @author lidefu
 * @date 2019/3/6 9:08
 */
public class RegularExpressionMatching {

    /**
     * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
     '.' 匹配任意单个字符。
     '*' 匹配零个或多个前面的元素。
     匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
     说明:
     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     示例 1:
     输入:
     s = "aa"
     p = "a"
     输出: false
     解释: "a" 无法匹配 "aa" 整个字符串。
     示例 2:
     输入:
     s = "aa"
     p = "a*"
     输出: true
     解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
     示例 3:
     输入:
     s = "ab"
     p = ".*"
     输出: true
     解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
     示例 4:
     输入:
     s = "aab"
     p = "c*a*b"
     输出: true
     解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
     示例 5:
     输入:
     s = "mississippi"
     p = "mis*is*p*."
     输出: false
     */

    public static void main(String[] args) {

        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(matching.isMatch("mississippi", "mis*is*ip*."));
    }

    public boolean isMatch2(String s, String p) {
        if(".*".equals(p)){
            return true;
        }
        if(s == null && p == null){
            return true;
        }
        if(s == null){
            return false;
        }else if( p == null){
            return false;
        }
        int i=s.length()-1,j=p.length()-1;
        while (i>=0 && j>=0){
            if(p.charAt(j) == '*'){
                if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.'){
                    i--;
                }else {
                    j-=2;
                }
            }else {
                if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)){
                    i--;
                    j--;
                }else {
                    return false;
                }
            }
        }
        if(j < 0){
            if(i < 0){
                return true;
            }else {
                return false;
            }
        }
        if(i < 0 ){
            if(j < 0){
                return true;
            }else {
                while (j >= 0){
                    if(p.charAt(j) == '*'){
                        j-=2;
                    }else {
                        return false;
                    }
                }
                if(j <= -1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(String text, String pattern){
        if (pattern.isEmpty()) return text.isEmpty();

        //第一个是否匹配上
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //看有没有可能,剩下的pattern匹配上全部的text
            //看有没有可能,剩下的text匹配整个pattern
            //isMatch(text, pattern.substring(2)) 指当p第二个为*时，前面的字符不影响匹配所以可以忽略，所以将*以及*之前的一个字符删除后匹配之后的字符，这就是为什么用pattern.substring(2)
            //如果第一个已经匹配成功，并且第二个字符为*时，这是我们就要判断之后的需要匹配的字符串是否是多个前面的元素（*的功能），这就是first_match && isMatch(text.substring(1), pattern))的意义
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }


}
