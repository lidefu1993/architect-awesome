package com.ldf.arithmetic.test;

/**
 * @author ldf
 * @date 2020/11/15 19:04
 **/
public class ArithmeticTest {

    public static void main(String[] args) {
        int[] a = {1, -1, 0,1, 1,2};
        System.out.println(count3(a));
        System.out.println(count2(a));

    }

    /**
     * 统计和为0的元组的数量
     * @param a -
     * @return -
     */
    private static int count3(int[] a){
        int n = a.length;
        int cnt = 0;
        int total = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    total++;
                    if(a[i]+a[j]+a[k]==0){
                        System.out.println("i:" + i + ",j:" + j + ",k:"+k);
                        cnt++;
                    }
                }
            }
        }
        System.out.println("total=n*(n-1)*(n-2)/6:"+ total);
        return cnt;
    }

    private static int count2(int[] a){
        int n = a.length;
        int cnt = 0;
        int total = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                total++;
            }
        }
        System.out.println("total=n*(n-1)/2:"+ total);
        return cnt;
    }
}
