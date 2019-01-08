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
        TestBean testBean = new TestBean();
        hashMap();
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
    


}
