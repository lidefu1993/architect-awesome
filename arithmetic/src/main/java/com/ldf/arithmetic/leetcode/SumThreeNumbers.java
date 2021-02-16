package com.ldf.arithmetic.leetcode;

import java.util.*;

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
        int[] nums = {1,2,-2,-1};
        System.out.println(numbers.threeSumHash(nums).toString());
    }

    public List<List<Integer>> threeSumHash(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            //去重
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1; j<nums.length; j++){
                if(map.containsKey(nums[j])){
                    if(map.get(nums[j])==0){
                        res.add(Arrays.asList(nums[i], nums[j], -nums[j]-nums[i]));
                        //去重
                        map.put(nums[j], -1);
                    }
                }else {
                    map.put(-nums[i]-nums[j], 0);
                }
            }
        }
        return res;
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
            //要求三数之和==0，其中之一大于0，左指针为最小值，最小值大于0，则不满足要求
            if(nums[left] > 0){
                break;
            }
            int mid = left+1;
            int right = nums.length-1;
            while (mid < right){
                //题目要求找不重复的三元组，若当前的左指针等于上一个左指针 必然会得到重复的结果 故此处跳出循环
                if(left > 0 && nums[left] == nums[left-1]){
                    break;
                }
                if(nums[left] + nums[mid] + nums[right] == 0){
                    //添加满足条件的一组数据
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    //处理mid等值的情况
                    while(mid < right && nums[++mid] == nums[mid-1]){};
                    //处理right等值的情况
                    while(mid < right && nums[--right] == nums[right+1]){};
                }else if(nums[left] + nums[mid] + nums[right] < 0){
                    //和小于0 向右移动mid指针，增加sum值
                    mid++;
                }else {
                    //和大于0 向左移动right指针，减少sum值
                    right--;
                }

            }
        }
        return res;
    }


}
