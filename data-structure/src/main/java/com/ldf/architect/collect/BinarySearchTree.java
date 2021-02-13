package com.ldf.architect.collect;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

public class BinarySearchTree {

    /**
     * 二叉查找树
     */

    public static void main(String[] args) {
        BinaryNode tree = new BinaryNode(50, null, null);
        for(int i=0; i<10; i++){
            insert(tree, (int)(Math.random()*100));
        }
        BinaryNode node = insert(tree, 10);
        System.out.println("构建二叉查找树完成");
        BinaryNode node10 = find(node, 10);
        BinaryNode remove = remove(tree, 10);
        System.out.println("结束--------------");
        level(tree);
        StringBuilder s = new StringBuilder();
        dept(tree, s);
        System.out.println(s);
    }

    /**
     * 层次遍历
     * @param tree -
     * @return -
     */
    public static String level(BinaryNode tree){
        StringBuilder s = new StringBuilder();
        LinkedList<BinaryNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            BinaryNode node = queue.poll();
            if(node != null){
                s.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return queue.toString();
    }

    /**
     * 深度遍历
     * @param tree -
     * @return -
     */
    public static void dept(BinaryNode tree, StringBuilder s){
        if(tree != null){
            s.append(tree.val);
            dept(tree.left, s);
            dept(tree.right, s);
        }
    }

    /**
     * 查找目标值节点
     * @param tree
     * @param target
     * @return
     */
    public static BinaryNode find(BinaryNode tree, int target){
        if(tree == null){
            return null;
        }
        if(tree.val>target){
            return find(tree.left, target);
        }
        else if(tree.val<target){
            return find(tree.right, target);
        }
        else {
            return tree;
        }
    }

    /**
     * 判断二叉查找树中是否包含目标值
     * @param tree 二叉树
     * @param target 目标值
     * @return -
     */
    public static boolean contains(BinaryNode tree, int target){
        if(tree == null){
            return false;
        }
        if(tree.val > target){
            return contains(tree.left, target);
        }else if(tree.val < target){
            return contains(tree.right, target);
        }else {
            return true;
        }
    }

    /**
     * 获取树的最小值（递归）
     * @param tree 二叉查找树
     * @return 最小值
     */
    public static BinaryNode findMin(BinaryNode tree){
        if(tree == null){
            return null;
        }
        if(tree.left == null){
            return tree;
        }
        return findMin(tree.left);
    }

    /**
     * 获取树的最小值(遍历)
     * @param tree 二叉查找树
     * @return 最小值
     */
    public static BinaryNode findMin2(BinaryNode tree){
        if(tree == null){
            return null;
        }
        while (tree.left != null){
            tree = tree.left;
        }
        return tree;
    }

    /**
     * 查找最大值（递归）
     * @param tree 二叉查找树
     * @return 最大值
     */
    public static BinaryNode findMax(BinaryNode tree){
        if(tree == null){
            return null;
        }
        if(tree.right == null){
            return tree;
        }
        return findMax(tree);
    }

    /**
     * 查找最大值（遍历）
     * @param tree 树
     * @return 最大值
     */
    public static BinaryNode findMax2(BinaryNode tree){
        if(tree == null){
            return null;
        }
        while (tree.left != null){
            tree = tree.right;
        }
        return tree;
    }

    /**
     * 树中插入值为val的新节点
     * @param tree 树
     * @param val
     * @return 插入新节点后的树的根节点
     */
    public static BinaryNode insert(BinaryNode tree, int val){
        if(tree == null){
            return new BinaryNode(val, null, null);
        }
        if(tree.val < val){
            //插入节点在右子树
            tree.right = insert(tree.right, val);
        }else if(tree.val > val){
            //插入的节点在左子树
            tree.left = insert(tree.left, val);
        }else {
            //该节点已存在

        }
        return tree;
    }


    /**
     * 从树中移除某个节点
     * 1）目标节点不存在树中，此时不需要做任何操作
     * 2）目标节点无子节点，将该节点置为null即可(null也可看作左右节点的其中之一)
     * 3）目标节点有一个子节点（左/右），此时只需要把目标节点的子节点替换目标节点即可
     * 4）目标节点有两个子节点，此时需要找到右子树的最小节点rightMinNode，用rightMinNode节点的值替换目标值（保证满足节点的左子树都小于该节点而右子树都大于该节点)，
     *    最后删除rightMinNode
     *
     * @param tree 树
     * @return 返回移除节点后的树的Root节点
     */
    public static BinaryNode remove(BinaryNode tree, int target){
        if(tree == null){
            //树中不存在目标节点
            return tree;
        }
        if(tree.val<target){
            //目标节点在右子树
            tree.right = remove(tree.right, target);
        }else if(tree.val>target){
            //目标节点在左子树
            tree.left = remove(tree.left, target);
        }else if(tree.left != null && tree.right != null){
            //找到了目标节点且目标节点左右子节点皆不为空
            tree.val = findMin(tree.right).val;
            tree.right = remove(tree.right, tree.val);
        }else {
            //找到了目标节点且目标节点左右子树至少有一个为空
            tree = tree.left == null ? tree.right : tree.left;
        }
        return tree;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class BinaryNode{
        public int val;
        public BinaryNode left;
        public BinaryNode right;
    }

}
