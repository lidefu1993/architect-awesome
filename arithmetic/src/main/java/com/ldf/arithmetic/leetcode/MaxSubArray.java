package com.ldf.arithmetic.leetcode;

/**
 * 最大子序和
 */
public class MaxSubArray {

    /**
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     */

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 动态规划
     *  1、确定状态 & 转移方程
     *  到n处的最大连续子数组和记f(n)分两种情况，
     *     1）若f(n-1)+n_values <= n_values,则f(n)=n
     *     2) 若f(n-1)+n_values  n_values,则f(n)=f(n-1)+n_values
     *  2、初始值临界值，nums只有一个元素时,则nums[0]为最大值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //最大值
        int max = nums[0];
        //记录当前连续范围的和
        int temp = nums[0];
        for(int i=1; i<nums.length; i++){
            //若temp+当前值<当前值,即之前的和为负数, temp重置为当前值
            if(temp+nums[i]<nums[i]){
                temp = nums[i];
            }else {
                temp += nums[i];
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
