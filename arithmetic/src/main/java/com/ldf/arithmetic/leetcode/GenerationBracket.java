package com.ldf.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidefu
 * @date 2019/9/2 14:55
 */
public class GenerationBracket {

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
      例如，给出 n = 3，生成结果为：
      [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
      ]
     *
     */

    public static void main(String[] args) {
        GenerationBracket bracket = new GenerationBracket();
        bracket.generateParenthesis(2);
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


}
