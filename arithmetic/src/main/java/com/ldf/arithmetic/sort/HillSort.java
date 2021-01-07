package com.ldf.arithmetic.sort;

/**
 * @author ldf
 * @date 2020/12/1 23:36
 **/
public class HillSort extends AbstractSort{

    /**
     * 希尔排序
     * 插入排序的优化版
     *  预处理数组，使其有更好的有序性
     */

    public static void main(String[] args) {
        AbstractSort sort = new QuickSort();
        sort.test(10);
    }

    @Override
    public void sort(int nums[]){
        int l = nums.length;
        while (l/2 > 0){
            for(int i=0; i<nums.length; i+=l){

            }
        }
    }

}
