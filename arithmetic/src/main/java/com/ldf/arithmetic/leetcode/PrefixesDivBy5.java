package com.ldf.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  可被 5 整除的二进制前缀
 * @author lidefu
 * @date 2021年01月14日19:22
 **/
public class PrefixesDivBy5 {

    /**
     *给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
     返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
     示例 1：
     输入：[0,1,1]
     输出：[true,false,false]
     解释：
     输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
     示例 2：
     输入：[1,1,1]
     输出：[false,false,false]
     示例 3：
     输入：[0,1,1,1,1,1]
     输出：[true,false,false,false,true,false]
     示例 4：
     输入：[1,1,1,0,1]
     输出：[false,false,false,false,false]
     提示：
     1 <= A.length <= 30000
     A[i] 为 0 或 1
     */

    public static void main(String[] args) {


        PrefixesDivBy5 divBy5 = new PrefixesDivBy5();
        List<Boolean> list = divBy5.prefixesDivBy5(new int[]{0,1,1,1,1,1});
        for(Boolean b : list){
            System.out.println(b);
        }
    }

    /**
     *
     * 考虑数组的长度过长，不能将0-n对于的完整二进制数值转为10进制
     * 保留前一位除以5的余数Mi-1，则当前位除以5的余数为Mi-1左移1位+当前位的值（0/1）在对5取余
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        if(A == null || A.length == 0){
            return new ArrayList<>();
        }
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;
        for(int i : A){
            prefix = ((prefix << 1) + i) % 5;
            result.add(prefix == 0);
        }
        return result;
    }

}
