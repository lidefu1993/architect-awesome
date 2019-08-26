package com.ldf.arithmetic.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lidefu
 * @date 2019/8/22 9:19
 */
public class SumFourNumbers {

    public static void main(String[] args) {

        SumFourNumbers sumFourNumbers = new SumFourNumbers();
        int[] nums = {-2, -1, 0, 0, 0, 0, 0, 1, 2};
        int target = 0;
        List<List<Integer>> lists = sumFourNumbers.fourSumOffice(nums, target);
        System.out.println("office:" + lists);
        List<List<Integer>> lists1 = sumFourNumbers.fourSumOffice(nums, target);
        System.out.println("self:" + lists1);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return new ArrayList<>();
        }else if(nums.length == 4){
            int sum = Arrays.stream(nums).reduce((x, y) -> x + y).getAsInt();
            return sum == target ? Collections.singletonList(Arrays.stream(nums).boxed().collect(Collectors.toList())) : new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-1; i++){
            for(int left = i+1; left < nums.length; left++){
                int mid = left+1;
                int right = nums.length-1;
                while (mid < right){
                    if(nums[i] + nums[left] + nums[mid] + nums[right] == target){
                        add(res, Arrays.asList(nums[i], nums[left], nums[mid], nums[right]));
                        mid++; right--;
                    }else if(nums[i] + nums[left] + nums[mid] + nums[right] < target){
                        mid++;
                    }else {
                        right--;
                    }

                }
            }
        }
        return res;
    }

    public void add(List<List<Integer>> res, List<Integer> nums){
        boolean anyMatch = res.stream().anyMatch(item -> Arrays.equals(item.toArray(), nums.toArray()));
        if(!anyMatch){
            res.add(nums);
        }
    }

    public List<List<Integer>> fourSumOffice(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i ++) {
            // 去除指针i可能的重复情况
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1;j < nums.length;j ++) {
                // 去除j可能重复的情况
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length -1;
                while (left < right) {
                    // 不满足条件或者重复的，继续遍历
                    if ((left != j + 1 && nums[left] == nums[left-1]) || nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left ++;
                    } else if ((right != nums.length -1 && nums[right] == nums[right + 1]) || nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right --;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        // 满足条件的，进入下一次遍历
                        left ++;
                        right --;
                    }
                }
            }
        }

        return result;
    }

}
