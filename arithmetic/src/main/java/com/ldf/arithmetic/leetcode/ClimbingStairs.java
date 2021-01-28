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
        System.out.println((1000000007+1000000006)%1000000007);
        ClimbingStairs stairs = new ClimbingStairs();
        int n = 61;
        System.out.println(stairs.climbStairs3_2(n));
    }

    /**
     *      * 动态规划：
     *      *  1、确定状态 爬到第n阶，可能是从n-1阶爬1阶上来或者从n-2阶爬两阶上来
     *      *  2、转移方程 f(n) = f(n-1)+f(n-2) f(n)表示爬到n阶的方法数量
     *      *  3、临界值（确定值/初始值）f(1)=1, f(2)=2
     */

    /**
     * 每次可以爬1阶或两阶
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        //使用临时变量 pre1表示f(n-1), pre2表示f(n-2)
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            //f(n)=f(n-1)+f(n-2)
            int cur = pre1 + pre2;
            //更新临时变量
            // n+1后的pre2为n时的pre1
            pre2 = pre1;
            // n+1后的pre1为n时的当前值
            pre1 = cur;
        }
        return pre1;
    }

    /**
     * 每次可以爬1，2，3阶
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

    public int climbStairs3_2(int n) {
        if(n<3){
            return n;
        }
        if(n==3){
            return 4;
        }
        int pre1=4, pre2=2, pre3=1;
        int cur = 0;
        for(int i=4; i<=n; i++){
            //取模保证不会溢出
            cur = (pre1 + (pre2 + pre3) % 1000000007) % 1000000007;
            pre3 = pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }




}
