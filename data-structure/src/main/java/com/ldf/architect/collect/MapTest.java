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

//        hashMapTest();
//        linkedHashMap();
        treeMap();
    }

    private static void treeMap(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        treeMap.put(5, 5);
        treeMap.put(1, 10);
        treeMap.put(8, 8);
        System.out.println(treeMap);
    }

    private static void linkedHashMap(){
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(4);
        for(int i=0; i<16; i++){
            linkedHashMap.put(""+i, i);
        }
        linkedHashMap.get(1);
        linkedHashMap.forEach((k, v)-> System.out.println("key:" + k + "; value:" + v));
        System.out.println();
    }

    private static void hashMapTest(){
        HashMap<String, Integer> hashMap1 = new HashMap<>(5);
        hashMap1.put("5", -5);
        hashMap1.put("4", -4);
        hashMap1.put("3", -3);
        hashMap1.put(random(), 1);
        hashMap1.put(random(), 2);
        hashMap1.put(random(), 3);
        hashMap1.put(random(), 4);
        hashMap1.put(random(), 5);
        hashMap1.get(1);
        Set<Map.Entry<String, Integer>> entries = hashMap1.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry);
        }
        hashMap1.forEach((k,v)-> System.out.println("K:"+k+"; V:"+v));
        HashMap<TestKey, Integer> hashMap2 = new HashMap<>(2);
        TestKey key1 = new TestKey(1);
        TestKey key2 = new TestKey(2);
        hashMap2.put(key1, 1);
        hashMap2.put(key2, 2);
        System.out.println(hashMap1);
        System.out.println(hashMap2);
    }

    private static String random(){
        return UUID.randomUUID().toString();
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


    public static class TestKey{

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
