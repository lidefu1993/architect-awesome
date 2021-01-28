package com.ldf.arithmetic.leetcode;

/**
 * 区域检索
 */
public class NumArray {

    /**

     给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。

     实现 NumArray 类：

     NumArray(int[] nums) 使用数组 nums 初始化对象
     int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）

     示例：

     输入：
     ["NumArray", "sumRange", "sumRange", "sumRange"]
     [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     输出：
     [null, 1, -1, -3]

     解释：
     NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
     numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))

     提示：

     0 <= nums.length <= 104
     -105<= nums[i] <=105
     0 <= i <= j < nums.length
     最多调用 104 次 sumRange 方法

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/range-sum-query-immutable

     */

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if(nums.length == 0){
            return;
        }
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i==0 ? sum[j] : sum[j]-sum[i-1];
    }

}
