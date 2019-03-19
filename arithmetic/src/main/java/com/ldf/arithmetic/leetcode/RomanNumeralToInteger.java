package com.ldf.arithmetic.leetcode;


/**
 * 罗马数字转整数
 * @author lidefu
 * @date 2019/3/19 8:39
 */
public class RomanNumeralToInteger {

    public static void main(String[] args) {
        RomanNumeralToInteger integer = new RomanNumeralToInteger();
        System.out.println(integer.romanToInt("MCDLXXVI"));
    }

    public int romanToInt(String s) {
        int res = 0;
        int i=0;
        char[] chars = s.toCharArray();
        while (i<chars.length){
            if(i<chars.length-1){
                int i1 = base("" + chars[i] + chars[i + 1]);
                if(i1 != 0){
                    res += i1;
                    i+=2;
                    continue;
                }
            }
            res += base("" + chars[i]);
            i++;
        }
        return res;
    }

    public int base(String s){
        switch (s){
            case "IV": return 4;
            case "IX": return 9;
            case "XL": return 40;
            case "XC": return 90;
            case "CD": return 400;
            case "CM": return 900;
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            default: return 0;
        }
    }


}
