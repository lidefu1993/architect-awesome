package com.ldf.arithmetic.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 省份数量
 * @author lidefu
 * @date 2021年01月21日16:43
 **/
public class IdentitiesNumber {

    /**
     * 并查集；深度优先
     */

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

     省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

     给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

     返回矩阵中 省份 的数量。

     输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]] 输出：2

     输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]] 输出：3

     提示：

     1 <= n <= 200
     n == isConnected.length
     n == isConnected[i].length
     isConnected[i][j] 为 1 或 0
     isConnected[i][i] == 1
     isConnected[i][j] == isConnected[j][i]
     */

    public static void main(String[] args) {

//        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
//        int[][] isConnected  = {{1,0,0}, {0,1,0}, {0,0,1}};
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        IdentitiesNumber identitiesNumber = new IdentitiesNumber();
        int num = identitiesNumber.findCircleNum3(isConnected);
        System.out.println("省份数量：" + num);
    }

    /**

     思路： 并查集
        共N个城市，初始化各自父节点为自身
        遍历2维数组，判断城市是否相连，
        若相连，合并（合并规则保持一致）
        若不相连，忽略

        压缩-使得每个节点的父节点即为根节点

        取根节点的数量即为省份的数量

        思路优化： 不用压缩，而是判断根节点的特性，节点==parent[节点]
     * @param isConnected -
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        //节点数量
        int count = isConnected.length;
        //使用数组记录对应的父节点,开始初始化为各节点本身
        int[] pNodes = new int[count];
        for(int i=0; i<count; i++){
            pNodes[i] = i;
        }
        //遍历记录相连关系的二维数组
        for(int i=0; i<count; i++){
            for(int j=0; j<isConnected[i].length; j++){
                if(i == j){
                    continue;
                }
                if(isConnected[i][j] == 1){
                    //若相连 合并
                    union(i, j, pNodes);
                }
            }
        }
        //路径压缩-使得每个节点的父节点为根节点
        for(int i=0; i<count; i++){
            pNodes[i] = findRoot(pNodes[i], pNodes);
        }
        //根节点的数量即为省的数量
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<pNodes.length; i++){
            int val;
            if(!set.contains(val = pNodes[i])){
                set.add(val);
            }
        }
        return set.size();
    }

    /**
     并查集 优化
     基于上述解法的思路优化： 不用压缩，而是根据根节点的特性，节点==parent[节点]
     * @param isConnected -
     * @return
     */
    public int findCircleNum2(int[][] isConnected) {
        //节点数量
        int count = isConnected.length;
        //使用数组记录对应的父节点,开始初始化为各节点本身
        int[] pNodes = new int[count];
        for(int i=0; i<count; i++){
            pNodes[i] = i;
        }
        //遍历记录相连关系的二维数组
        for(int i=0; i<count; i++){
            for(int j=0; j<isConnected[i].length; j++){
                if(i == j){
                    continue;
                }
                if(isConnected[i][j] == 1){
                    //若相连 合并
                    union(i, j, pNodes);
                }
            }
        }
        int circles = 0;
        //根节点的数量即为省的数量
        for(int i=0; i<count; i++){
            if(i == pNodes[i]){
                //根节点：节点==parent[节点]
                circles++;
            }
        }
        return circles;
    }


    /**
     * 查找节点node的根节点(注意：node即为节点的值，也表示了在数组中的索引位置，pNodes[node]=node的父级节点)
     * @param node -
     * @return 根节点
     */
    private int findRoot(int node, int[] pNodes){
        if(node == pNodes[node]){
            //节点 == 父级节点 =》 node为根节点
            return node;
        }
        return findRoot(pNodes[node], pNodes);
    }

    private void union(int node1, int node2, int[] pNodes){
        if(node1 > node2){
            pNodes[findRoot(node1, pNodes)] = findRoot(node2, pNodes);
        }else {
            pNodes[findRoot(node2, pNodes)] = findRoot(node1, pNodes);
        }
    }

    /**
     * 深度优先
     *
     * @param isConnected -
     * @return -
     */
    public int findCircleNum3(int[][] isConnected) {
        int circles = 0;
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        for(int i=0; i<length; i++){
            if(!visited[i]){
                visited[i] = true;
                findGroup(i, length, visited, isConnected);
                circles++;
            }

        }
        return circles;
    }

    public void findGroup(int i, int length, boolean[] visited, int[][] isConnected){
        for(int j=0; j<length; j++){
            if(!visited[j] && isConnected[i][j] == 1){
                visited[j]=true;
                findGroup(j, length, visited, isConnected);
            }
        }
    }

    /**
     * 广度优先搜索
     * @param isConnected -
     * @return
     */
    public int findCircleNum4(int[][] isConnected) {
        int circles = 0;
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<length; i++){
            if(!visited[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    Integer j = queue.poll();
                    visited[j] = true;
                    for(int k=0; k<length; k++){
                        if(isConnected[j][k] == 1 && !visited[k]){
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }

}
