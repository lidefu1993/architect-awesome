package com.ldf.arithmetic.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 电话号码的字母组合
 * @author lidefu
 * @date 2019/8/21 9:44
 */
public class PhoneNumberLetterCombination {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    public static void main(String[] args) {
        PhoneNumberLetterCombination combination = new PhoneNumberLetterCombination();
        String digits = "";

        List<String> listOffice = combination.letterCombinationsOffice(digits);
        System.out.println("office:" + listOffice);
        List<String> list = combination.letterCombinations(digits);
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }
        Map<String, String[]> map = new HashMap<String, String[]>(){{
            put("2", new String[]{"a", "b", "c"});
            put("3", new String[]{"d", "e", "f"});
            put("4", new String[]{"g", "h", "i"});
            put("5", new String[]{"j", "k", "l"});
            put("6", new String[]{"m", "n", "o"});
            put("7", new String[]{"p", "q", "r", "s"});
            put("8", new String[]{"t", "u", "v"});
            put("9", new String[]{"w", "x", "y", "z"});
        }};
        List<String[]> strings = Arrays.stream(digits.split("")).map(map::get).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        index("", strings, 0, list);
        return list;
    }

    public List<String> letterCombinationsOffice(String digits){
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void index(String str, List<String[]> strings, int i, List<String> result){
        if(strings.size() == i){
            result.add(str);
        }else {
            for(int j=0; j<strings.get(i).length; j++){
                index(str+strings.get(i)[j], strings, i+1, result);
            }
        }

    }


    List<String> output = new ArrayList<String>();

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


}
