package com.ldf.arithmetic.leetcode;

/**
 * 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    /**
     数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。

     每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。

     请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。

     示例1：

     输入：cost = [10, 15, 20]
     输出：15
     解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
     示例 2：

     输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     输出：6
     解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。

     提示：




     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
     */

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(i);
    }

    /**
     * 动态规划
     * 1、确定状态
     *  共有n阶楼梯，爬完楼梯存在两种途径，1、从n-1处消耗体力爬一层，2、从n-2处消耗体力爬2层
     *  记f(n)=爬完n层楼梯的最小花费
     * 2、状态方程
     *  f(n) = min(f(n-1)+cos[n-1], f(n-2)+cos[n-2])
     * 3、初始值
     *  f(2)=min(cos[1], cos[0])
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        //使用临时变量 pre1,pre2分别代表，n-1,n-2层的最小花费
        int pre1 = 0;
        int pre2 = 0;
        //记录f(n)
        int cur=0;
        for(int i=2; i<=cost.length; i++){
            cur = Math.min(pre1+cost[i-1], pre2+cost[i-2]);
            //转移pre的值，为i++准备
            pre2=pre1;
            pre1=cur;
        }
        return cur;
    }



}
