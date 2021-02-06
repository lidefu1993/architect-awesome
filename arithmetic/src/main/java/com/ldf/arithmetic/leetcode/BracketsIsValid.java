package com.ldf.arithmetic.leetcode;

import java.util.*;

/**
 * 校验括号是否有效
 */
public class BracketsIsValid {

    /**
     *
     *
     */

    public static void main(String[] args) {
        String str = "{[]}";
        BracketsIsValid isValid = new BracketsIsValid();
        boolean b = isValid.isValid(str);
        System.out.println(b);
    }

    public boolean isValid(String s) {
        Map<Character, Character> cMap = new HashMap<>();
        cMap.put(')', '('); cMap.put('}', '{'); cMap.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            Character rc = cMap.get(c);
            if(rc == null){
                stack.add(c);
            }else {
                Character poll = stack.pollLast();
                if(poll != rc){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
