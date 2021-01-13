package com.ldf.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidefu
 * @date 2021年01月13日18:49
 **/
public class RedundantConnection {

    /**
     * 冗余连接
     * 在本问题中, 树指的是一个连通且无环的无向图。
     输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
     返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
     示例 1：
     输入: [[1,2], [1,3], [2,3]]
     输出: [2,3]
     解释: 给定的无向图为:
     1
     / \
     2 - 3
     示例 2：
     输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
     输出: [1,4]
     解释: 给定的无向图为:
     5 - 1 - 2
     |   |
     4 - 3
     注意:
     输入的二维数组大小在 3 到 1000。
     二维数组中的整数在1到N之间，其中N是输入数组的大小。

     */

    public static void main(String[] args) {
        RedundantConnection rd = new RedundantConnection();
        int[][] edges = {{1,2},{1,4}, {2,3}, {3,4},  {1,5}};
        int[] ints = rd.findRedundantConnection(edges);
        for(int i : ints){
            System.out.println(i);
        }
    }

    /**
     *  题意理解：
     *     给定一个图，该图为树多了一条边从而出现回环形成，找出该边返回
     *  思路：并查集
     *
     *
     *
     */
    public int[] findRedundantConnection(int[][] edges) {
        int nodeNums = edges.length;
        //存储各个节点对应的父级节点，初始化赋值为自己
        int[] parents = new int[nodeNums+1];
        for(int i=1; i<= nodeNums; i++){
            parents[i] = i;
        }
        //遍历各边 若边的两个顶点存在相同的根节点 则该边会导致回环
        for(int i=0; i<edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if(findRoot(parents, n1) == findRoot(parents, n2)){
                return new int[]{n1, n2};
            }
            //合并
            parents[findRoot(parents, n1)] = findRoot(parents, n2);
        }
        return new int[0];
    }

    /**
     * 查找节点n的根节点
     * @param parents 父级节点数组
     * @param n 节点
     * @return n的根节点
     */
    private int findRoot(int[] parents, int n){
        if(parents[n] == n){
            return n;
        }
        return findRoot(parents, parents[n]);
    }


}
