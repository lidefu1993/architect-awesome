package com.ldf.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 两数之和
 * @author lidefu
 * @date 2019/1/8 13:12
 */
public class SumOfTwoNumbers {

    /**
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 52};
        SumOfTwoNumbers numbers = new SumOfTwoNumbers();
        int[] ints = numbers.twoSum(nums, 54);
        System.out.println(JSON.toJSONString(ints));
    }

    /**
     * 两遍hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int j = target - nums[i];
            Integer integer = map.get(j);
            if(map.containsKey(j) && integer != i){
                return new int[]{i, integer};
            }
        }
        return null;
    }

    /**
     * 暴力方式 for循环嵌套
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMy(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }



}
