package com.ldf.arithmetic.leetcode;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  有效的括号
 * @author lidefu
 * @date 2019/8/26 16:50
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        if((s.length()&1)!= 0){
            return false;
        }
        Stack<String> stack = new Stack<>();
        for(String s1 : s.split("")){
            if(Arrays.asList("(", "{", "[").contains(s1)){
                stack.push(s1);
            }else {
                String peek ;
                try {
                    peek = stack.pop();
                }catch (Exception e){
                    return false;
                }
                if(")".equals(s1) && !"(".equals(peek)){
                    return false;
                }else if("}".equals(s1) && !"{".equals(peek)){
                    return false;
                }else if("]".equals(s1) && !"[".equals(peek)){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

}
