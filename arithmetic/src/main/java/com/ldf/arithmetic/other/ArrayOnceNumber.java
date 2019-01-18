package com.ldf.arithmetic.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidefu
 * @date 2019/1/18 8:38
 */
public class ArrayOnceNumber {

    /**
     题意:
     一个整型数组里除了两个数字num1,num2之外，其他的数字都出现了偶数次，
     请写程序找出这两个出现一次的数字。
     要求时间复杂度是O(n)，空间复杂度是O(1).
     解题思路：用异或操作
     偶数个的异或起来为0，所以最后异或的答案等于所求两数异或和
     这两个数不一样那么异或结果一定至少有一位为1（假设索引位为i）。
     且数组可以分为两部分，一部分的异或结果的二进制i索引位为0,另一部分为1 ; 这两部分的异或值则分别为num1和num2
     假设num1该位为1，num2该位为0。
     将该位为1的数全部异或起来，得到的结果是num1。
     这是因为除了num1之外，剩下的每个数（当然不包括num2）一定有偶数个。
     同理将该位为0的数全部异或起来，得到的结果是num2。
     */

    public static void main(String[] args) {
        findNumsAppearOnce(new int[]{2,1,1,2,3,4});
    }

    private static void findNumsAppearOnce(int[] nums) {
        int num1 = 0, num2 = 0;
        List<Integer> num1Index = new ArrayList<>();
        List<Integer> num2Index = new ArrayList<>();
        int resultExclusiveOR = 0;
        for (int i = 0; i < nums.length; ++i) {
            resultExclusiveOR ^= nums[i];
        }
        int indexOf1 = findFirstBitIs1(resultExclusiveOR);
        for (int j = 0; j < nums.length; ++j){
            ///该位为1的异或起来
            if (isBit1(nums[j], indexOf1)){
                num1 ^= nums[j];
                num1Index.add(j);
            }else{
                ///该位不为1的异或起来
                num2 ^= nums[j];
                num2Index.add(j);
            }
        }
        System.out.println(num1^num2);
        System.out.println("num：" + num1 + "; num2:" + num2);
    }


    /**
     * 获取数字二进制中第一位为1的索引位
     * @param num
     * @return
     */
    private static int findFirstBitIs1(int num){
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit < 32))
        {
            num = num >> 1;
            ++ indexBit;
        }
        return indexBit;
    }

    /**
     * num二进制指定索引位是否为1
     * @param num
     * @param indexBit
     * @return 为1 返回true 否则返回false
     */
    private static boolean isBit1(int num, int indexBit)
    {
        num = num >> indexBit;
        return (num & 1) == 1;
    }


}
