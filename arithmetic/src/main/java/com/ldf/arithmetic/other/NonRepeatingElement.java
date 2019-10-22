package com.ldf.arithmetic.other;

/**
 * @author ldf
 * @date 2019/10/9 19:57
 **/
public class NonRepeatingElement {

    /**
     * 一个有序有重复的数组，不产生新数组且遍历一次的情况下变为，前边为有序的不重复元素，后边任意，例如：
     * int a[] = {1,1,2,2,2,3,4,5,5} -> {1,2,3,4,5,x,x,x,x,x}
     */


    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 4};
        solution(a);
    }

    private static void solution(int[] a){
        int j=1; //i之前为不重复的记录
        for(int i=1; i<a.length; i++){
            if(a[i] > a[j-1]){
                a[i] = a[i]^a[j];
                a[j] = a[i]^a[j];
                a[i] = a[i]^a[j];
                j++;
            }
        }
        for (int k : a){
            System.out.println(k);
        }
    }

}
