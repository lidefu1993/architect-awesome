package com.ldf.arithmetic.leetcode;

/**
 * 删除排序数组中的重复项
 * @author ldf
 * @date 2019/12/8 19:14
 **/
public class DelRepeatedArray {

    /**
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     示例 1:

     给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    public static void main(String[] args) {
        DelRepeatedArray delRepeatedArray = new DelRepeatedArray();
        int[] a = {1, 2, 3, 3, 4, 4};
        int i = delRepeatedArray.removeDuplicates(a);
        System.out.println(i);

    }

    public int removeDuplicates(int[] nums) {
        //i记录要被替换的位置
        int i = 0;
        if(nums == null){
            return 0;
        }
        if(nums.length<2){
            return nums.length;
        }
        for(int k = 1; k < nums.length; k++){
            if(i == 0){
                if(nums[k] == nums[k-1]){
                    i=k;
                }
            }else {
                if(nums[k] > nums[i-1]){
                    nums[i] = nums[i]^nums[k];
                    nums[k] = nums[i]^nums[k];
                    nums[i] = nums[i]^nums[k];
                    i++;
                }
            }

        }
        return i==0 ? nums.length : i;
    }

}
