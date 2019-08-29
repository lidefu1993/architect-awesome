package com.ldf.architect.collect;
import java.util.HashMap;
/**
 * @author lidefu
 * @date 2018/12/20 13:30
 */
public class MapTest {

    /**
     * 1、为什么HashMap的初始容量必须是2的n(2的n次方)
     * 2、tableSizeFor（查找大于等于给定值的最小2的幂）的实现逻辑
     */





    public static void main(String[] args) {
        System.out.println(tableSizeFor(2));
    }

    /**
     * HashMap
     */
    private static void hashMap(){
        int n = 1;
        HashMap<String, String> map = new HashMap<>(n);
        map.put("name", "李德富");
        map.put("sex", "男");
        map.put("age", "25");
        map.get("age");
        System.out.println(1);
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




}
