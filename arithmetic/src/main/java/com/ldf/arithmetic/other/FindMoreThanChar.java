package com.ldf.arithmetic.other;

/**
 * @author ldf
 * @date 2019/10/11 16:43
 **/
public class FindMoreThanChar {

    /**
     * 两个char数组，第一个比第二个多一个元素，其他值和顺序都相同
     */

    public static void main(String[] args) {
        char[] chars1 = {'1', 'a', '2', 'b', '3', 'c'};
        char[] chars2 = {'1', '2', 'b', '3', 'c'};
        System.out.println(findChar(chars1, chars2));;
    }

    private static char findChar(char[] chars1, char[] chars2){
        for(int i=0; i<chars1.length; i++){
            if(chars1[i] == chars2[i]){
            }else {
                return chars1[i];
            }
        }
        return chars1[chars1.length];
    }


}
