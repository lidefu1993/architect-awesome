package com.ldf.arithmetic.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldf
 * @date 2019/10/11 16:17
 **/
public class SortedArrayJoin {

    /**
     * 两个有序数组取交集
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {2, 4, 5, 8};
        int[] join = join(arr1, arr2);
        System.out.println(join);
    }

    private static int[] join(int[] arr1, int[] arr2){
        if(arr1 == null || arr1.length == 0
                || arr2 == null || arr2.length == 0){
            return null;
        }
        int[] joinArr = new  int[arr1.length > arr2.length ? arr2.length : arr1.length];
        int i=0, j=0, c=0;
        while (i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                joinArr[c++] = arr1[i];
                i++; j++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] result = new int[c];
        System.arraycopy(joinArr, 0, result, 0, 2);
        return result;
    }

}
