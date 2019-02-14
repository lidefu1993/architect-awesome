package com.ldf.arithmetic.leetcode;

/**
 * 爬楼梯
 * @author lidefu
 * @date 2019/1/29 10:17
 */
public class ClimbingStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     注意：给定 n 是一个正整数。
     示例 1：
     输入： 2
     输出： 2
     解释： 有两种方法可以爬到楼顶。
     1.  1 阶 + 1 阶
     2.  2 阶
     示例 2：
     输入： 3
     输出： 3
     解释： 有三种方法可以爬到楼顶。
     1.  1 阶 + 1 阶 + 1 阶
     2.  1 阶 + 2 阶
     3.  2 阶 + 1 阶
     */

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        int n = 5;
        System.out.println(stairs.climbStairs3(n));
    }

    /**
     * 两种
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    /**
     * 三种
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if(n ==3)
            return 4;
        if(n <3)
            return n;
        return climbStairs3(n-1) + climbStairs3(n-2) + climbStairs3(n-3);
    }




}
