package com.ldf.arithmetic.leetcode;

import java.util.*;

/**
 * 滑动窗口最大值
 */
public class MaxSlidingWindow {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 示例 3：
     *
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     * 示例 4：
     *
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     * 示例 5：
     *
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     *
     */

    public static void main(String[] args) {
        MaxSlidingWindow window = new MaxSlidingWindow();
        int[] ints = window.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i : ints){
            System.out.println(i);
        }
    }

    // 双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        //定义双端队列,保存nums中的索引位置 保证双端队列的第一个元素始终为最大值
        Deque<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<nums.length; i++){
            //移除窗口外的元素
            while (!queue.isEmpty() && (i-queue.getFirst()>=k)){
                queue.removeFirst();
            }
            //保证左端首位元素始终为最大值
            while (!queue.isEmpty() && nums[queue.getLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.offer(i);
            if(i>=k-1){
                res[i-k+1]=nums[queue.getFirst()];
            }
        }
        return res;
    }

    //堆
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        //维护长度为k的堆，堆顶为最大值 int[]{索引，数据}
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1] !=0 ? o2[1]-o1[1] : o2[0]-o1[0]);
        for(int i=0; i<nums.length; i++){
            if(i-k+1<0){
                queue.offer(new int[]{i, nums[i]});
            }else {
                queue.offer(new int[]{i, nums[i]});
                //剔除超出滑动窗口的元素
                while (i-queue.peek()[0]>=k){
                    queue.poll();
                }
                res[i-k+1]=queue.peek()[1];
            }
        }
        return res;
    }



}
