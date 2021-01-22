package com.ldf.arithmetic.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 并查集
 * @author lidefu
 * @date 2021年01月20日17:47
 **/
public class AndCollect {

    static List<String> nodes = Arrays.asList("X", "A", "A1", "A2", "Y", "B", "B1", "B2");
    static List<String> pNodes = Arrays.asList("X", "X", "A", "A1", "Y", "Y", "B", "B1");


    public static void main(String[] args) {
        System.out.println("合并前-----------------");
        for(int i=0; i<nodes.size(); i++){
            System.out.println(findRoot(i));
        }
        union(0, 4);
        System.out.println("合并后-----------------");
        for(int i=0; i<nodes.size(); i++){
            System.out.println(findRoot(i));
        }
    }

    public static String findRoot(int index){
        String pNode;
        //我们根据根节点的父节点为根节点本身的特性判断是否为根节点
        if(nodes.get(index).equals(pNode = pNodes.get(index))){
            return nodes.get(index);
        }
        //继续向上查找父级节点
        return findRoot(nodes.indexOf(pNode));
    }

    public static void union(int indexA, int indexB){
        pNodes.set(indexA, findRoot(indexB));
    }


}
