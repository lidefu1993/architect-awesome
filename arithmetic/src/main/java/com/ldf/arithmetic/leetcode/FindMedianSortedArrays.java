package com.ldf.arithmetic.leetcode;

/**
 *寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     *
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     */

    public static void main(String[] args) {
        FindMedianSortedArrays sortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double v = sortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(v);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        //判断奇偶，若为奇数中位数是索引位为length/2的值, 若为偶数中位数为（length/2）-1 和 （length/2）处的值的平均值
        //true为奇数
        boolean flag = (length&1) == 1;
        //定义双指针 i：nums1, j:nums2
        int i=0,j=0;
        //定义上一个值
        Integer pre=null;
        //定义当前值
        int current;
        //当前已遍历到的索引位置
        int n=0;
        while (true){
            if(i >= nums1.length){
                current = nums2[j];
                j++;
            }else if(j >= nums2.length){
                current = nums1[i];
                i++;
            }else {
                if(nums1[i]<nums2[j]){
                    current = nums1[i];
                    i++;
                }else {
                    current = nums2[j];
                    j++;
                }
            }
            //判断是否达到中位数的索引位
            if(length/2-1 == n){
                //已到中位值索引处
                pre = current;
            }
            if(length/2 == n){
                if(flag){
                    //奇数
                    return current;
                }else {
                    //偶数
                    return (current+pre)/2.0;
                }
            }
            n++;
        }
    }

}
