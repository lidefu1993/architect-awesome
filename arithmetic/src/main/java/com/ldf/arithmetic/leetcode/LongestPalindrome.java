package com.ldf.arithmetic.leetcode;

/**
 * 最长回文子串
 */
public class LongestPalindrome {

    /**
     给你一个字符串 s，找到 s 中最长的回文子串。

     示例 1：

     输入：s = "babad"
     输出："bab"
     解释："aba" 同样是符合题意的答案。
     示例 2：

     输入：s = "cbbd"
     输出："bb"
     示例 3：

     输入：s = "a"
     输出："a"
     示例 4：

     输入：s = "ac"
     输出："a"

     提示：

     1 <= s.length <= 1000
     s 仅由数字和英文字母（大写和/或小写）组成

     */

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "cbbd";
        String palindrome = longestPalindrome.longestPalindrome(s);
        System.out.println(palindrome);

    }

    /**
     * 动态规划
     * p(i,j)记为字符串索引从i到j的字串
     * 若p(i,j)为回文字符串，则去掉开头结尾后依然为回文字符串
     * @param s -
     * @return -
     */
    public String longestPalindrome(String s) {
        String ans = "";
        int length = s.length();
        //定义
        boolean[][] dp = new boolean[length][length];
        //转移方程需要由短字串判断长字串是否为回文，故l一定要从小到大遍历
        for(int l=0; l<length; l++){
            for(int i=0; i+l<length; i++){
                int j=i+l;
                if(l==0){
                    //单一字符构成的字符串为true
                    dp[i][j] = true;
                }else {
                    final boolean b = s.charAt(i) == s.charAt(j);
                    if(l==1){
                        //两个字符ab构成的字符串，a==b为true，否则为false
                        dp[i][j] = b;
                    }else {
                        //根据转移方程
                        dp[i][j] = dp[i+1][j-1] && b;
                    }
                }
                if(dp[i][j]){
                    ans = ans.length() < j-i+1 ? s.substring(i, j+1) : ans;
                }
            }
        }
        return ans;

    }

}
