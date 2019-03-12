package com.ldf.arithmetic.leetcode;

/**
 * 盛最多水的容器
 * @author lidefu
 * @date 2019/3/12 8:41
 */
public class ContainerWithTheMostWater {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     说明：你不能倾斜容器，且 n 的值至少为 2。
     示例:
     输入: [1,8,6,2,5,4,8,3,7]
     输出: 49
     宽*高 = （i2-i1）* height = (8-1)*7 = 49
     */

    public static void main(String[] args) {
        ContainerWithTheMostWater water = new ContainerWithTheMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(water.maxArea(height));
    }

    /**
     * 笨方法 去所有可能的两组值 去最大值
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0; i<height.length-1; i++){
            for(int j = i+1; j<height.length; j++){
                int temp = (j - i) * Math.min(height[i], height[j]);
                res = res >= temp ? res : temp;
            }
        }
        return res;
    }

}
