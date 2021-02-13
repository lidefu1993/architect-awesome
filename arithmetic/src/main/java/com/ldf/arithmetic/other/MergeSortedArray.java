package com.ldf.arithmetic.other;

import java.util.List;

/**
 * 合并有序数组
 * @author ldf
 * @date 2019/10/9 19:46
 **/
public class MergeSortedArray {

    /**
     * 给定两个有序数组，聚合为一个有序数组，
     * 例如 int a[] = {1,4,7} int b[]={1,2,3,6} 合并后为[1,1,2,3,4,6,7]
     */

    public static void main(String[] args) {
        int a[] = {1, 3, 7, 8};
        int b[] = {2, 4, 5, 6};
        int[] merge = merge(a, b);
        for (int i : merge){
            System.out.println(i);
        }
    }

    private static int[] merge(int[] a, int[] b){
        if(a == null || a.length == 0 ){
            return b;
        }
        if(b == null || b.length == 0){
            return a;
        }
        int i = 0; int j=0; int k = 0;
        int[] c= new int[a.length + b.length];
        while (k < a.length + b.length){
            if(i >= a.length){
                c[k++] = b[j++];
            }else if(j >= b.length){
                c[k++] = a[i++];
            }else {
                c[k++] = a[i] > b[j] ? b[j++] : a[i++];
            }
        }
        return c;
    }

}
