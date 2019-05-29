package com.ldf.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lidefu
 * @date 2019/3/22 8:40
 */
public class SumThreeNumbers {


    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     注意：答案中不可以包含重复的三元组。
     例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     满足要求的三元组集合为：
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     */


    public static void main(String[] args) {
        SumThreeNumbers numbers = new SumThreeNumbers();
        int[] nums = {1,-1,-1,0};
        System.out.println(numbers.threeSum(nums).toString());
    }

    /**
     * 确定左边界 移动中间和右边界
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int left = 0; left < nums.length; left++){
            if(nums[left] > 0){
                break;
            }
            int mid = left+1;
            int right = nums.length-1;
            while (mid < right){
                if(left > 0 && nums[left] == nums[left-1]){
                    break;
                }
                if(nums[left] + nums[mid] + nums[right] == 0){
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while(mid < right && nums[++mid] == nums[mid-1]){};
                    while(mid < right && nums[--right] == nums[right+1]){};
                }else if(nums[left] + nums[mid] + nums[right] < 0){
                    mid++;
                }else {
                    right--;
                }

            }
        }
        return res;
    }


}
