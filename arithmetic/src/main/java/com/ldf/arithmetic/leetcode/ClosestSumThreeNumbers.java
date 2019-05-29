package com.ldf.arithmetic.leetcode;

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
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeNumbers.threeSumClosest(nums, 1));
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
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int left = 0; left < nums.length-1; left++){
            int tempMin = Integer.MAX_VALUE;
            int mid = left + 1;
            int right = nums.length-1;
            while (mid < right){
                sum += nums[left] + nums[left] + nums[right];
                tempMin = Math.abs(tempMin-target) <= Math.abs(sum-target) ? tempMin : sum;
                if(sum == target){
                    return target;
                }else if(sum > target){
                    left--;
                }else {
                    mid++;
                }
            }
            min = Math.abs(tempMin-target) <= Math.abs(min-target) ? tempMin : min;

        }
        return min;
    }

}
