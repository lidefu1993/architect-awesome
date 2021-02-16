package com.ldf.arithmetic.leetcode;

import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  数据流中的第 K 大元素
 */
public class KthLargest {

    /**
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     *
     * 请实现 KthLargest 类：
     *
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     *  
     *
     * 示例：
     *
     * 输入：
     * ["KthLargest", "add", "add", "add", "add", "add"]
     * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     * 输出：
     * [null, 4, 5, 5, 8, 8]
     *
     * 解释：
     * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
     * kthLargest.add(3);   // return 4
     * kthLargest.add(5);   // return 5
     * kthLargest.add(10);  // return 5
     * kthLargest.add(9);   // return 8
     * kthLargest.add(4);   // return 8
     *  
     *
     * 提示：
     * 1 <= k <= 104
     * 0 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * -104 <= val <= 104
     * 最多调用 add 方法 104 次
     * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
     */

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 6, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(1));
    }

    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        //变种为第k小 只需要修改优先队列的比较器 改为从大到小 维护一个长度为k的堆 始终保持堆的第一个元素为k个元素的最大值
        this.queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0; i<nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(queue.size()<k){
            queue.offer(val);
        }else if(queue.peek() > val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

}
