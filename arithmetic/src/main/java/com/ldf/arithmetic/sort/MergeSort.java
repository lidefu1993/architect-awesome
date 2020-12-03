package com.ldf.arithmetic.sort;

import java.util.Arrays;

/**
 * @author ldf
 * @date 2020/12/1 23:37
 **/
public class MergeSort extends AbstractSort {

    /**
     * 归并排序
     * 将数组拆分为两个有序的子数组，然后合并
     */

    public static void main(String[] args) {

        AbstractSort sort = new MaoPaoSort();
        sort.test(100000);
    }

    @Override
    public void sort(int nums[]){
        nums = sortNums(nums);
    }

    public int[] sortNums(int[] nums){
        if(nums.length < 2){
            return nums;
        }
        int middle = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);
        return merge(left, right);
    }

    /**
     * 对两个有序数组进行合并
     * @param left -
     * @param right -
     * @return -
     */
    public int[] merge(int[] left, int[] right){
        //定义合并后的数组
        int[] mergeNums = new int[left.length + right.length];
        int i=0, j=0, k=0;
        while (j<left.length && k<right.length){
            if(left[j] < right[k]){
                mergeNums[i] = left[j++];
            }else {
                mergeNums[i] = right[k++];
            }
            i++;
        }
        //若left有剩余
        if(j<left.length-1){
            for (;j<left.length; j++){
                mergeNums[i++] = left[j];
            }
        }
        //若right有剩余
        if(k<right.length-1){
            for (;k<left.length; k++){
                mergeNums[i++] = right[k];
            }
        }
        return mergeNums;
    }

}
