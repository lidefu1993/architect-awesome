package com.ldf.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 */
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    public static void main(String[] args) {
        String a = "abee";
        String b = "bae";
        IsAnagram isAnagram = new IsAnagram();
        boolean anagram = isAnagram.isAnagram2(a, b);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for(Character c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }
        for(Character c : t.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0)-1);
            if(countMap.get(c)<0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }




}
