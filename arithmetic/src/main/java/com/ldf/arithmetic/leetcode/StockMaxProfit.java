package com.ldf.arithmetic.leetcode;

/**
 * 买卖股票的最佳时机
 */
public class StockMaxProfit {

    /**
     给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

     你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

     返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

     示例 1：

     输入：[7,1,5,3,6,4]
     输出：5
     解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     示例 2：

     输入：prices = [7,6,4,3,1]
     输出：0
     解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

     提示：

     1 <= prices.length <= 105
     0 <= prices[i] <= 104


     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     */

    public static void main(String[] args) {
        StockMaxProfit stockMaxProfit = new StockMaxProfit();
        int[] prices = {7,6,4,3,1};
        int profit = stockMaxProfit.maxProfit(prices);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        //记录最大值
        int maxprofit = 0;
        //记录当前已遍历的最小值
        int min = Integer.MAX_VALUE;
        //长度
        int len = prices.length;
        //在i天买入，在j天卖出
        for(int i=0; i<len-1; i++){
            if(prices[i] >= min){
                //若高于已经遍历过的价格，在计算已经没有意义，利润一定低于前者
                continue;
            }
            min = Math.min(min, prices[i]);
            for (int j=i+1; j<len; j++){
                //获取利润，跟当前已计算出的最大利润比较，取较大值
                maxprofit = Math.max(maxprofit, prices[j]-prices[i]);
            }
        }
        return maxprofit;
    }

    /**
     * 官方题解
     * 考虑若在第n天卖出利润最大，则需要我们在0，n-1天买入了最小值
     * 即遍历时，记录最小值，若当前值低于最小值，更新最小值，若当前值大于最小值，获取当前利润
     * 转为动态规划的思想：
     *  1、确定状态， 若在n天卖出利润最大，则需要在0，n-1天的最低点买入
     *  2、转移方程， f(n)=n_price-min[0,n-1]
     *  3、临界值（初始值），不买入利润为0，记录已遍历的最小值，若在当天卖出，计算与最小值的差值
     * @param prices -
     * @return -
     */
    public int maxProfitOfficial(int[] prices){
        //当前已遍历最小值
        int min = Integer.MAX_VALUE;
        //最大利润
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else {
                maxProfit = Math.max(prices[i]-min, maxProfit);
            }
        }
        return maxProfit;
    }

}
