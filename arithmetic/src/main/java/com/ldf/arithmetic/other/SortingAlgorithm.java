package com.ldf.arithmetic.other;

/**
 * 排序算法
 * @author lidefu
 * @date 2019/10/8 18:39
 */
public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] arr = {23,122,22,3,1, 3, 2, 5};
        maopao(arr);
    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static void maopao(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
        for (int i : arr){
            System.out.println(i);
        }
    }




}
