package com.ldf.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  无重复字符的最长子串
 * @author lidefu
 * @date 2019/1/21 8:47
 */
public class LongestSubstringWithoutRepeatingChar {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     示例 1:
     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:
     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:
     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public static void main(String[] args) {
//        List<String> ss = new ArrayList<>();
//        ss.add("a"); ss.add("b"); ss.add("c");
//        ss.subList(0, 1);
        LongestSubstringWithoutRepeatingChar repeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println(repeatingChar.lengthOfLongestSubstringMy("aabaab!bb"));
    }


    public int lengthOfLongestSubstringMy(String s){
        int max = 1;
        if(s == null || s.isEmpty()){
            return 0;
        }
        String[] chars = s.split("");
        List<String> sonList = new ArrayList<>();
        for (String c : chars){
            int i = sonList.indexOf(c);
            if(i == -1){
                sonList.add(c);
                continue;
            }
            max = max > sonList.size() ? max : sonList.size();
            if(i == sonList.size()-1){
                sonList = new ArrayList<>();
            }else {
                sonList = sonList.subList(i+1, sonList.size());
            }
            sonList.add(c);
        }
        return max > sonList.size() ? max : sonList.size();
    }

}
