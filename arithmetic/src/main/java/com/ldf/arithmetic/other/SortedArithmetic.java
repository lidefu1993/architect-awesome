package com.ldf.arithmetic.other;

/**
 * 排序算法
 * @author ldf
 * @date 2019/10/10 20:24
 **/
public class SortedArithmetic {

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 6, 5};
        maopao(arr);
    }

    /**
     * 冒泡排序
     */
    private static void maopao(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
        for (int a : arr){
            System.out.println(a);
        }
    }

    private static void kuaisu(int[] arr){
        if(arr.length > 0)   //查看数组是否为空
        {
            quickSort(arr, 0, arr.length-1);
        }
    }

    private static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }

    }

    private static int getMiddle(int[] numbers, int low,int high)
    {
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high)
        {
            while(low < high && numbers[high] >= temp)
            {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while(low < high && numbers[low] < temp)
            {
                low++;
            }
            numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }

}
