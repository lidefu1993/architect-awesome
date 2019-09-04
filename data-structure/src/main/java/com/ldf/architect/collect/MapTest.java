package com.ldf.architect.collect;
import java.util.*;
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
//        hashMap2();
        treeMap2();
        System.out.println(1);
    }

    private static void treeMap(){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(5, 5);
        map.put(3, 3);
        map.put(4, 4);
        Integer integer = map.get(4);
        System.out.println(integer);
    }

    private static void treeMap2(){
        TreeMap<TestKey, Integer> map = new TreeMap<>((o1, o2)-> -o1.id+o2.id);
        MapTest mapTest = new MapTest();
        map.put(mapTest.new TestKey(1), 1);
        map.put(mapTest.new TestKey(2), 2);
        map.put(mapTest.new TestKey(5), 5);
        map.put(mapTest.new TestKey(6), 6);
        map.put(mapTest.new TestKey(7), 7);
        map.put(mapTest.new TestKey(8), 8);
        map.put(mapTest.new TestKey(3), 3);
        map.put(mapTest.new TestKey(4), 4);
        map.put(mapTest.new TestKey(9), 9);
        System.out.println(1);
    }

    /**
     * HashMap
     */
    private static void hashMap(){
        HashMap<String, String> map = new HashMap<>(3);
        map.put("name", "李德富");
        map.put("sex", "男");
        map.put("age", "25");
        map.get("age");
        System.out.println(1);
    }

    private static void hashMap2(){
        MapTest mapTest = new MapTest();
        HashMap<TestKey, Integer> map = new HashMap<>(3);
        map.put(mapTest.new TestKey(1), 1);
        map.put(mapTest.new TestKey(2), 2);
        map.put(mapTest.new TestKey(3), 3);
        map.put(mapTest.new TestKey(4), 4);
        map.put(mapTest.new TestKey(5), 5);
        map.put(mapTest.new TestKey(6), 6);
        map.put(mapTest.new TestKey(7), 7);
        map.put(mapTest.new TestKey(8), 8);
        map.put(mapTest.new TestKey(9), 9);
        map.put(mapTest.new TestKey(10), 10);
        map.put(mapTest.new TestKey(1), 10);
        Integer integer = map.get(mapTest.new TestKey(1));
        Integer integer1 = map.get(mapTest.new TestKey(4));
        System.out.println(integer);
    }

    private static int tableSizeFor(int cap){
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
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
