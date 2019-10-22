package com.ldf.arithmetic.other;

/**
 * @author ldf
 * @date 2019/10/10 19:47
 **/
public class BinarySearch {

    /**
     *
     * 二分查找法  判断一个值是否在一个有序数组中
     *
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 12, 222};
        System.out.println(search(arr, 222));
    }

    private static int search(int[] arr, int target){
        int start = 0, end = arr.length-1;
        while (start <= end){
            int middle = (start + end) >>> 1;
            if(target == arr[middle]){
                return middle;
            }else if(target < arr[middle]){
                end = middle-1;
            }else {
                start = middle + 1;
            }
        }
        return -1;
    }


}
