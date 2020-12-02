package com.ldf.arithmetic.sort;

/**
 * @author ldf
 * @date 2020/12/1 23:12
 **/
public class QuickSort extends AbstractSort{

    /**
     * 快速排序
     * 指定基准值a，其余元素与基准值比较大小，小的移至左侧，大的移至右侧，
     * 形成以基准值为界，左侧区间的元素皆小于a,而右侧区间皆大于a
     * 迭代移动左右侧的区间，至排序完成
     */

    public static void main(String[] args) {
        AbstractSort sort = new QuickSort();
        sort.test(100000);
    }

    @Override
    public void sort(int nums[]){
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int left, int right){
        if(left<right){
            //得到基准值所处位置
            int p = position(nums, left, right);
            //处理基准值左侧区间
            quickSort(nums, left, p-1);
            //处理基准值右侧区间
            quickSort(nums, p+1, right);
        }
    }

    /**
     * 指定left坐标处数据a为基准值，从left+1开始遍历，
     * 保证从（left+1）+ n (小于nums[left]的数量)的值皆小于nums[left]
     * 然后交换nums[left]与nums[left+n]的值，则基准值a的左侧皆小于a,右侧皆大于a,left+n则为a的坐标
     * @param nums 数组
     * @param left 左边界
     * @param right 有边界
     */
    private int position(int[] nums, int left, int right){
        //定义基准值为left所在的元素
        int p = left;
        //小于基准值的数量
        int n = 0;
        //定义当前可交换位置的坐标位
        int index = left+1;
        for(int i=left+1; i<=right; i++){
            if(nums[p] > nums[i]){
                //交换index与i坐标位处数据 index右移
                swap(nums, index, i);
                index++;
                //累积基准值的数量
                n++;
            }
        }
        //将基准值交换至中间位置
        swap(nums, p, left+n);
        return left+n;
    }

    /**
     * 交换数组nums i与j处的值
     * @param nums 数组
     * @param i -
     * @param j -
     */
    private void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
