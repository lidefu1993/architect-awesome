package com.ldf.arithmetic.other;

/**
 * @author ldf
 * @date 2019/10/15 9:59
 **/
public class MinimumSpacing {

    /**
     *
     * 两个数组的最小间距
     * 例如 arr1[1, 2, 3, 5]  arr2[7, 9, 89]
     * 最小间距为7-5=2
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 12, 45};
        int[] arr2 = {7, 10, 30};
        System.out.println(min(arr1, arr2));
    }

    private static int min(int[] arr1, int[] arr2){
        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return Integer.MAX_VALUE;
        }
        int i=0, j=0, min = Integer.MAX_VALUE;
        int a=arr1.length, b=arr2.length;
        while (i<a || j<b){
            //数组arr1 循环结束
            if(i>=a){
                if(min <= Math.abs(arr2[j]-arr1[a-1])){
                    j = b;
                }else {
                    min = Math.abs(arr2[j]-arr1[a-1]); j++;
                }
                continue;
            }
            //数组arr2 循环结束
            if(j>=b){
                if(min <= Math.abs(arr2[b-1]-arr1[i])){
                    i=a;
                }else {
                    min = Math.abs(arr2[b-1]-arr1[i]); i++;
                }
                continue;
            }
            min = min <= Math.abs(arr2[j]-arr1[i]) ? min : Math.abs(arr2[j]-arr1[i]);
            if(arr1[i] > arr2[j]){
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else {
                return 0;
            }
        }
        return min;
    }

}
