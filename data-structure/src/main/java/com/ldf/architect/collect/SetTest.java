package com.ldf.architect.collect;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author lidefu
 * @date 2018/12/20 13:07
 */
public class SetTest {

    /**
     * Set底层的数据结构为Map
     * @param args
     */

    public static void main(String[] args) {
    }

    /**
     * HashSet 基于HashMap,新增一个值相当于HashMap put,新增的值为key
     *  其余的相关操作最后都是HashMap的操作
     */
    private static void hashSet(){
        HashSet set = new HashSet();
    }

    /**
     * TreeSet 基于TreeMap
     */
    private static void treeSet(){
        TreeSet set = new TreeSet();
    }

    /**
     * LinkedHashSet 基于 LinkedHashMap
     */
    private static void linkedHashSet(){
        LinkedHashSet set = new LinkedHashSet();
    }

}
