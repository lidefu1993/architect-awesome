package com.ldf.arithmetic.leetcode;

/**
 * 最长公共前缀
 * @author lidefu
 * @date 2019/3/20 8:42
 */
public class LongestCommonPrefix {

    /**
     *编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     示例 1:
     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:
     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:
     所有输入只包含小写字母 a-z 。
     */

    public static void main(String[] args) {
        "abc".indexOf("a");
        String[] strs = {"dog", "racecar", "car"};
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        if(strs.length == 1){
           return strs[0];
        }
        StringBuilder res = new StringBuilder("");
        int i=0;
        char tmp;
        while (true){
            if(i >= strs[0].length()){
                break;
            }
            tmp = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != tmp){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
            i++;
        }
        return res.toString();
    }



}
