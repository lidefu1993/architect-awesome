package com.ldf.arithmetic.sort;

/**
 * @author ldf
 * @date 2020/12/1 23:13
 **/
public abstract class AbstractSort {


    public void test(int n){
        //mock数据
        int[] nums = mockNums(n);
        long begin = System.currentTimeMillis();
        //排序
        sort(nums);
        long end = System.currentTimeMillis();
        System.out.println("排序耗时：" + (end-begin) + "毫秒");
        //校验顺序
        assertSort(nums);
    }

    public abstract void sort(int[] nums);

    protected int[] mockNums(int n){
        StringBuilder s = new StringBuilder("原数组：");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            int num = (int)(1+Math.random()*1000);
            nums[i] = num;
            s.append(num).append(";");
        }
        System.out.println(s.toString());
        return nums;
    }

    protected void assertSort(int[] nums){
        StringBuilder s = new StringBuilder("排序后：").append(nums[0]).append(";");
        //i always >= i-1
        for(int i=1; i<nums.length; i++){
            s.append(nums[i]).append(";");
            if(nums[i] < nums[i-1]){
                System.out.println("sort error: i:" + i);
                break;
            }
        }
        System.out.println(s.toString());
    }

}
