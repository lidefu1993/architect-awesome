package com.ldf.arithmetic.sort;

/**
 * @author ldf
 * @date 2020/12/1 23:35
 **/
public class InsertSort extends AbstractSort {

    /**
     * 插入排序
     * 保持已遍历部分有序，遍历至新元素时，与前边有序数据
     */

    public static void main(String[] args) {
        AbstractSort sort = new QuickSort();
        sort.test(10);
    }

    @Override
    public void sort(int nums[]){
        for(int i=1; i<nums.length; i++){
            int temp = nums[i];
            int j=i;
            while (j>0 && temp<nums[j-1]){
                //右移
                nums[j] = nums[j-1];
                j--;
            }
            //插入指定位置
            if(j!=i){
                nums[j] = temp;
            }
        }
    }

}
