package com.ldf.arithmetic.leetcode;

/**
 * 寻找两个有序数组的中位数
 * @author lidefu
 * @date 2019/1/28 9:30
 */
public class MedianOfTwoOrderedArrays {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     你可以假设 nums1 和 nums2 不会同时为空。
     示例 1:
     nums1 = [1, 3]
     nums2 = [2]
     则中位数是 2.0
     示例 2:
     nums1 = [1, 2]
     nums2 = [3, 4]
     则中位数是 (2 + 3)/2 = 2.5
     */

    public static void main(String[] args) {
        MedianOfTwoOrderedArrays median = new MedianOfTwoOrderedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println( 3/2 );
        System.out.println(median.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 思路：分别用i,j将两个数组A,B分为两部分；两个左半边与两个右半边组成两个新数组
     * 保证 i + j = m-i + n-j 且 A[i-1] < B[j], A[i] > B[j-1]
     * 1、赋值两个有序数组给A（size:m），B(size:n) n >= m
     * 2、从 [0, m]中获取i, j = m+n/2 - i(向上取整)
     * 3、保证 i=0 or j=n or A[i] > B[j-1] 且 i = m or j = 0 or A[i-1] < B[j]
     * 4、若A[i-1] > B[j] 说明i太大 则i从[0, i-1]中重新取值； 若A[i] < B[j-1] 说明i过小 则i从[i+1, m]中重新取值
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int m = A.length;
        int n = B.length;
        // to ensure m<=n
        if (m > n) {
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                // i is too small
                iMin = i + 1;
            }
            else if (i > iMin && A[i-1] > B[j]) {
                // i is too big
                iMax = i - 1;
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }
                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


}
