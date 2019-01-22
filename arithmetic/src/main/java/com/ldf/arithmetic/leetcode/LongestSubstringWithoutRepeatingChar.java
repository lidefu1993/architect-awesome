package com.ldf.arithmetic.leetcode;
import java.util.*;

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
        LongestSubstringWithoutRepeatingChar repeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println(repeatingChar.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 优化的滑动窗口
     * 使用hashMap做滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for(int i = 0, j = 0; j < s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)));
            }
            max = Math.max(max, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return max;
    }

    /**
     * 使用set作为一个滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        int i = 0, j = 0, max = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
        }
        return max;
    }


    /**
     * 官方解答1：暴力法
     * 逐个检查子字符串，看是不是有重复的字符。不重复的记录长度
     * 所有的子字符串：开始索引i 结束索引j i和j的全部组合即为全部子字符串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s){
        if(s == null || s.isEmpty()){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length(); j++){
                if(allUnique(s, i, j)){
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;
    }

    /**
     * 是否没有重复
     * @param s
     * @param begin
     * @param end
     * @return true:没有重复 false:存在重复
     */
    private boolean allUnique(String s, int begin, int end){
        String s1 = s.substring(begin, end);
        for (int i = 0; i < s1.length(); i++){
            int index = s1.indexOf(s1.charAt(i));
            if(index != i){
                return false;
            }
        }
        return true;
    }


    /**
     * 自己的解答
     * @param s
     * @return
     */
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
