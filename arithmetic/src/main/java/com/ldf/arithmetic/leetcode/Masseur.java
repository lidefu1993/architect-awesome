package com.ldf.arithmetic.leetcode;

/**
 * 按摩师
 */
public class Masseur {

    /**
     一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

     注意：本题相对原题稍作改动

      

     示例 1：

     输入： [1,2,3,1]
     输出： 4
     解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     示例 2：

     输入： [2,7,9,3,1]
     输出： 12
     解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     示例 3：

     输入： [2,1,4,5,3,1,1,3]
     输出： 12
     解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。


     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     */
    public static void main(String[] args) {
        Masseur masseur = new Masseur();
//        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};
        int[] nums = {2,1,4,5,3,1,1,3};
        int massage = masseur.massage(nums);
        System.out.println(massage);
    }

    /**
     * 动态规划
     * 1、确定状态
     *  最大总预约时间最终状态存在两种情况，
     *  1）最后以最后一位预约结束 2）最后以倒数第二位预约结束
     * 2、转移方程
     *  f(n)表示在n处预约结束时的总预约时间
     *  则结果res = max(f(n), f(n-1))
     *  再来分析f(n)的值，同样存在两种情况，
     *  1）f(n)=f(n-2)+nums[n] 2) f(n)=f(n-3)+nums[n]
     *  1)2)包含来全部的可能，首先n-1排除掉，因为不能连续，而若n-4及其以后，则f(n-4)+f(n-2)+f(n)一定大于f(n-4)+f(n)
     *  故得到f(n)的转移方程f(n)=f(n-2)+f(n-3)
     * 3、临界值
     *  由转移方程可知，我们需要以n=3开始遍历，即需要得到n=0,1,2的值
     *  n=0,即只有一个元素，即nums[0]为最大总预约时间
     *  n=1,即包含两个元素，即两者中的大值为最大总预约时间
     *  n=2,即包含三个元素，存在两种情况，1）完成第二个预约2）完成第一个和第三个预约 即max(nums[2], nums[0]+nums[3])
     */
    public int massage(int[] nums) {
        int length = 0;
        //nums为空，总预约数为0
        if(nums == null || (length = nums.length) == 0){
            return 0;
        }
        //只有一个预约
        if(length == 1){
            return nums[0];
        }
        //两个预约 取较大值
        if(length == 2){
            return Math.max(nums[0], nums[1]);
        }
        //三个预约，取两种可能的较大值
        if(length == 3){
            return Math.max(nums[1], nums[0]+nums[2]);
        }
        //定义数组，记录遍历到n为止，包含n处预约值的最大总预约时间
        int[] curs = new int[nums.length];
        //赋值0，1，2初始值
        curs[0] = nums[0];
        curs[1] = Math.max(nums[0], nums[1]);
        curs[2] = Math.max(nums[1], nums[0]+nums[2]);
        //从i=3即第四位开始遍历
        for(int i=3; i<length; i++){
            //f(n)=max(f(n-2)+f(n-3))
            curs[i] = Math.max(curs[i-2], curs[i-3]) + nums[i];
        }
        //res=math(f(n), f(n-1))
        return Math.max(curs[length-1], curs[length-2]);
    }

}
