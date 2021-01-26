package com.ldf.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 等式方程的可满足性
 * @author lidefu
 * @date 2021年01月22日16:26
 **/
public class EquationsPossible {

    /**

     给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

     只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。

     示例 1：

     输入：["a==b","b!=a"]
     输出：false
     解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     示例 2：

     输入：["b==a","a==b"]
     输出：true
     解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     示例 3：

     输入：["a==b","b==c","a==c"]
     输出：true
     示例 4：

     输入：["a==b","b!=c","c==a"]
     输出：false
     示例 5：

     输入：["c==c","b==d","x!=z"]
     输出：true
      

     提示：

     1 <= equations.length <= 500
     equations[i].length == 4
     equations[i][0] 和 equations[i][3] 是小写字母
     equations[i][1] 要么是 '='，要么是 '!'
     equations[i][2] 是 '='

     */

    public static void main(String[] args) {
        EquationsPossible possible = new EquationsPossible();
        String[] equations = {"a==b","b!=a"};

        boolean b = possible.equationsPossible(equations);
        System.out.println(b);
    }

    /**
     * 并查集：
     * 等式两边的字符作为节点，==代表节点相连
     * 合并后，若有且只有一个根节点，则满足要求
     * @param equations -
     * @return -
     */
    public boolean equationsPossible(String[] equations) {
        //得到全部节点
        List<Character> nodes = new ArrayList<>();
        //默认父级节点为自身
        List<Character> pNodes = new ArrayList<>();
        for(String c : equations){
            char c1 = c.charAt(0);
            if(!nodes.contains(c1)){
                nodes.add(c1);
                pNodes.add(c1);
            }
            char c2 = c.charAt(3);
            if(!nodes.contains(c2)){
                nodes.add(c2);
                pNodes.add(c2);
            }
        }
        //遍历、合并
        for(String c : equations){
            if(c.charAt(1) == '='){
                union(c.charAt(0), c.charAt(3), nodes, pNodes);
            }
        }
        int count = 0;
        //统计根节点数量
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).equals(pNodes.get(i))){
                count++;
            }
        }
        return count==1;
    }

    private Character find(int i, List<Character> nodes, List<Character> pNodes){
        Character pNode ;
        if(nodes.get(i).equals(pNode = pNodes.get(i))){
            return nodes.get(i);
        }
        return find(nodes.indexOf(pNode), nodes, pNodes);
    }

    private void union(Character c1, Character c2, List<Character> nodes, List<Character> pNodes){
        int i = nodes.indexOf(c1);
        int j = nodes.indexOf(c2);
        Character pN = find(j, nodes, pNodes);
        pNodes.set(nodes.indexOf(pN), find(i, nodes, pNodes));
    }


}
