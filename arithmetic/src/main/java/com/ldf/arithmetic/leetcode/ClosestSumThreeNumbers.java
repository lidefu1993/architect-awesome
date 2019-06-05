package com.ldf.arithmetic.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最接近的三数之和
 * @author lidefu
 * @date 2019/4/1 8:36
 */
public class ClosestSumThreeNumbers {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        ClosestSumThreeNumbers threeNumbers = new ClosestSumThreeNumbers();
        int[] nums = {-3,-2,-5,3,-4};
//        int[] sortedNums = arraySort(nums);
//        for (int i=0; i<sortedNums.length; i++){
//            System.out.println(sortedNums[i]);
//        }
        int target = 1;
        System.out.println(threeNumbers.threeSumClosest(nums, -1));
    }

    /**
     * 排序
     * 确定左边界left
     * 初始化 mid=left+1 right=length-1
     * num[left] + num[right] + num[mid] compare target
     * if {
     *     =target : return
     *     >target : right--
     *     <target : left++
     * }
     * @param nums 数组
     * @param target 目标值
     * @return r
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return Integer.MAX_VALUE;
        }
        int min = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int left = 0; left < nums.length-1; left++){
            int mid = left + 1;
            int right = nums.length-1;
            while (mid < right){
                int sum = nums[left] + nums[mid] + nums[right];
                min = Math.abs(min-target) <= Math.abs(sum-target) ? min : sum;
                if(sum == target){
                    return target;
                }else if(sum > target){
                    right--;
                }else {
                    mid++;
                }
            }
            min = Math.abs(min-target) <= Math.abs(min-target) ? min : min;

        }
        return min;
    }

    public int threeSumClosest1(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }


}
