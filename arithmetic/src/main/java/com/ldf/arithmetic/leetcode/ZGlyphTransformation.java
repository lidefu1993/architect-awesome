package com.ldf.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 * @author lidefu
 * @date 2019/2/18 9:46
 */
public class ZGlyphTransformation {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     L   C   I   R
     E T O E S I I G
     E   D   H   N
     之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     请你实现这个将字符串进行指定行数变换的函数：
     string convert(string s, int numRows);
     示例 1:
     输入: s = "LEETCODEISHIRING", numRows = 3
     输出: "LCIRETOESIIGEDHN"
     示例 2:
     输入: s = "LEETCODEISHIRING", numRows = 4
     输出: "LDREOEIIECIHNTSG"
     解释:
     L     D     R
     E   O E   I I
     E C   I H   N
     T     S     G
     */

    /**
     * 竖过来是z型
     */

    public static void main(String[] args) {
        ZGlyphTransformation zGlyphTransformation = new ZGlyphTransformation();
        String s = zGlyphTransformation.convert("LEETCODEISHIRING", 4);
        System.out.println(s);
    }

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int rowNums = Math.min(s.length(), numRows);
        List<StringBuilder> rows = new ArrayList<>(rowNums);
        for(int i = 0; i < rowNums; i++){
            rows.add(new StringBuilder());
        }
        int i = 0;
        boolean b = false;
        for(char c : s.toCharArray()){
            if(i == 0 || i == rowNums-1){
                b = !b;
            }
            rows.get(i).append(c);
            i += b ? 1 : -1;
        }
        StringBuilder r = new StringBuilder();
        for (StringBuilder row : rows){
            r.append(row);
        }
        return r.toString();
    }

}
