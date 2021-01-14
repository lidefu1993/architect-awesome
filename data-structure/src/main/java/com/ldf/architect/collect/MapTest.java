package com.ldf.architect.collect;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lidefu
 * @date 2018/12/20 13:30
 */
public class MapTest {

    /**
     * 1、为什么HashMap的初始容量必须是2的n(2的n次方)
     *      在查找索引位置时使用 (length-1)&hash length是2的n次方 可以把hash值的高位清零，保证得到的索引位置在长度范围内
     * 2、tableSizeFor（查找大于等于给定值的最小2的幂）的实现逻辑
     *      无符号右移取或，使得从最高位到最低位全为1，+1后可以得到最近2的n次方
     * 3、HashMap的hash方法的用意 hashCode^(hashCode>>>16)
     *      获取索引位置是hash值与length取与操作，基本上看的都是hash值的低位，无符号右移取异或使得hash值的高位对低位产生
     *      影响，继而影响低位的索引值计算，减少碰撞次数
     */

    public static void main(String[] args) {
        int n = 5;
        System.out.println(tableSizeFor(n));
        System.out.println(tableSizeForSelf(n));
    }

    private static void hashMapTest(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println(hashMap);
    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    private static int tableSizeForSelf(int cap) {
        return cap/2 == 0 ? cap : cap+1;
    }


    public class TestKey{

        private int id;

        public TestKey(int id){
            this.id = id;
        }

        public int getId(){
            return this.id;
        }

        @Override
        public int hashCode(){
            return 1;
        }

        @Override
        public boolean equals(Object o){
            return id == ((TestKey)o).getId();
        }

        @Override
        public String toString(){
            return "{"+id+"="+id+"}";
        }

    }



}
