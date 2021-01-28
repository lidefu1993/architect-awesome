package com.ldf.arithmetic.leetcode;

/**
 * 判断子序列
 */
public class IsSubsequence {

    /**
     给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

     字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

     进阶：

     如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

     示例 1：

     输入：s = "abc", t = "ahbgdc"
     输出：true
     示例 2：

     输入：s = "axc", t = "ahbgdc"
     输出：false

     提示：

     0 <= s.length <= 100
     0 <= t.length <= 10^4

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/is-subsequence
     */

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence2("adc", "ahbgdc"));
    }

    /**
     * 双指针
     */
    public boolean isSubsequence(String s, String t) {
        //记录字符串s的索引位置
        int i=0;
        //记录字符串t的索引位置
        int j=0;
        while (i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * 动态规划
     * 定义二位数组，int[][]f 记录t索引位后26个小写英文字符的位置，若字符不再t索引位后出现则赋值为t.length
     * 即若t[i]=j (j为26个小写英文字符c对应的数字，j=c-'a', 即j为[0, 26])
     */
    public boolean isSubsequence2(String s, String t){
        //定义f[][] 长度定义为s.length+1处理字符在索引位后不存在的情况
        int[][] f = new int[t.length()+1][26];
        //先初始化f[s.length][j]的值
        for(int j=0; j<26; j++){
            f[t.length()][j] = t.length();
        }
        //赋值f[][] 得到t字符串各个 注意需要倒叙
        for(int i=t.length()-1; i>=0; i--){
            for(int j=0; j<26; j++){
                if(t.charAt(i) == 'a'+j){
                    //t的i处字符为j对应的英文字符
                    f[i][j]=i;
                }else {
                    //反之 指向i+1处，若i+1处的字符为j对应的英文字符，则赋值为i+1,
                    // 反之类推到i为t.length,即为我们开始初始化的赋值t.length
                    f[i][j]=f[i+1][j];
                }
            }
        }
        //遍历字串s,根据得到的t的字符位置，若f[i][j]=t.length,则不满足要求，返回false
        //i记录已在t中查找的位置
        int i=0;
        for(int j=0; j<s.length(); j++){
            int v = f[i][s.charAt(j) - 'a'];
            if(v == t.length()){
                return false;
            }
            i=v+1;
        }
        return true;
    }

}
