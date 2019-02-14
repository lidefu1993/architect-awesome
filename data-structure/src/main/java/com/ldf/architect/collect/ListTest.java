package com.ldf.architect.collect;

import com.alibaba.fastjson.JSON;

import javax.sound.midi.Soundbank;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lidefu
 * @date 2018/12/17 9:18
 */
public class ListTest {


    /**
     * List
     * ArrayList 和 LinkedList
     *
     */

    public static void main(String[] args) {
        remainAll();
    }

    private static void remainAll(){
        String s = "abss";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        System.out.println(list);
        System.out.println(list.subList(2, 4));
        System.out.println();
    }

    /**
     * arrayList 基于数组
     * 获取指定索引的值效率高，删除、插入效率较低 涉及到整体数组的挪动
     */
    private static void arrayList(){
        List<String> list = new ArrayList<String>();
        list.add("1"); list.add("2"); list.add("3");
        //元素插入到指定索引位置 原先索引位置及后边的值向后挪一位 （前提是当前的list集合的对应索引位置已经有值了）
        list.add(2, " 测试2 ");
        list.add("测试");
        list.add("测试");
        System.out.println("old size :" + JSON.toJSONString(list));
        System.out.println("size:"+list.size());
        //返回对象在集合中第一次出现的位置索引
        int indexOf = list.indexOf("测试");
        System.out.println("indexOf:" + indexOf);
        //返回对象在集合中最后一次出现的位置
        int lastIndexOf = list.lastIndexOf("测试");
        System.out.println("lastIndexOf:" + lastIndexOf);
        String set = list.set(0, "测试0");
        System.out.println("index = 0 old : " + set);
        //返回从索引0到索引2之间所有元素组成的子集合 （左闭右开区间）
        List<String> list1 = list.subList(0, 2);
        System.out.println(" 0 - 2 list :" + JSON.toJSONString(list1));
        //根据指定规则重新设置集合中的所有元素
        list.replaceAll(String::trim);
        //排序
        list.sort((o1, o2) -> (o1.hashCode() > o2.hashCode()) ? 1 : -1);
        System.out.println("sort :" + JSON.toJSONString(list));
    }

    /**
     * LinkedList 基于双向链表
     * 查找效率较低，每次都要从起始/结束 节点开始查找
     */
    private static void linkedList(){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3, 4);
        list.set(0, 0);
        list.subList(0, 2);
        list.remove(0);
        list.remove(1);
    }

    /**
     * Vector基于数据的线程安全的集合
     */
    private static void vectorTest(){
        List<Integer> vector = new Vector<>();
        vector.add(1);
    }


}
