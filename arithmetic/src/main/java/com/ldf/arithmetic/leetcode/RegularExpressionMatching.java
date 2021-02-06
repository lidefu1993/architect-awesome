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
        System.out.println(matching.isMatch2("mississippi", "p**"));
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public boolean isMatch(String s, String p){
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //第二位为* 两种情况
            //1、第一位相等 则将s后移一位s与p比较
            //2、第一位无所谓相等（*号为0）p后移两位与p比较
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            //第二位不是* 则第一位必须相等 然后s和p都后移一位相等
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }


}
