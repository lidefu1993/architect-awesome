package com.ldf.architect.collect;
import java.util.HashMap;
/**
 * @author lidefu
 * @date 2018/12/20 13:30
 */
public class MapTest {

    /**
     * Map
     */
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        System.out.println("i:" + i + " j:" + j);
        i ^= j;
        j ^= i;
        i ^= j;
        System.out.println("i:" + i + " j:" + j);
        hashMap();
    }

    /**
     * HashMap
     */
    private static void hashMap(){
        int n = 1;
        HashMap<String, String> map = new HashMap<>(n);
        map.put("name", "李德富");
        map.put("age", "25");
        System.out.println(1);
    }
    


}
