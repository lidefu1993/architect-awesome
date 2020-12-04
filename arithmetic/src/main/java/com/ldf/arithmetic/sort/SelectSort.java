package com.ldf.arithmetic.sort;

/**
 * @author ldf
 * @date 2020/12/1 23:33
 **/
public class SelectSort extends AbstractSort{

    /**
     * 选择排序
     * 找到最大值放在首位，然后再依次在剩余元素中找到最大值，放在第二位，依次。。
     */

    public static void main(String[] args) {
        AbstractSort sort = new QuickSort();
        sort.test(10000);
    }

    @Override
    public void sort(int nums[]){
        for(int i=0; i<= nums.length-1; i++){
            int min = i;
            //获取当前最小值的坐标
            for(int j=i+1; j<nums.length; j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            //交换最小值至i处
            if(i != min){
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

}
