package com.ldf.arithmetic.leetcode;
import java.util.*;
/**
 * 最长回文子串
 * @author ldf
 * @date 2019/2/7 15:09
 **/
public class LongestPalindromeSubstring {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     示例 1：
     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。
     示例 2：
     输入: "cbbd"
     输出: "bb"

     注意：回文得意思是正着跟反着是一样得
     */

    public static void main(String[] args) {
        LongestPalindromeSubstring substring = new LongestPalindromeSubstring();
        String str = "kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv";
//        String str = "abss";
        long begin = System.currentTimeMillis();
        System.out.println(substring.longestPalindrome(str));
        System.out.println((System.currentTimeMillis() - begin)/1000.0);
    }



    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        String result = "";
        String[] split = s.split("");
        String temp = "";
        int lowIndex = 0, highIndex = 0, length = 0;
        for(int i = 0; i < split.length; i++){
            for(int j = i; j < split.length; j++){
                if(palindrome(split, i, j)){
                    if(j-i+1 >= length){
                        lowIndex = i;
                        highIndex = j;
                        length = j-i+1;
                    }
                }
            }
        }
        if(length == 1){
            result = split[split.length-1];
        }else {
            for(int i=lowIndex; i<=highIndex; i++){
                result += split[i];
            }
        }
        return result;
    }

    public boolean palindrome(String[] ss, int lowIndex, int highIndex){
        if(lowIndex == highIndex){
            return true;
        }
        int length = highIndex+lowIndex;
        for(int i = lowIndex; i<= length/2; i++){
            if(!ss[i].equals(ss[length-i])){
                return false;
            }
        }
        return true;
    }

}
