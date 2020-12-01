package com.ldf.arithmetic.sort;

/**
 * @author ldf
 * @date 2020/11/30 23:43
 **/
public class MaoPaoSort {

    /**
     * 冒泡排序
     * 两两比较，依次将数据按顺序排放
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 0, 6, 9, 1};
        sort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void sort(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            //i之前的是已经排好序的了 不需要比较 j从i+1开始循环
            for(int j=i+1; j<nums.length; j++){
                //从小到大
                if(nums[i]>nums[j]){
                    //交换位置
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


}
