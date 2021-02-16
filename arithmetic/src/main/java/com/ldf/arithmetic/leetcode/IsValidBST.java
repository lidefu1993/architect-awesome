package com.ldf.arithmetic.leetcode;

import java.util.Stack;

/**
 * 验证二叉搜索树
 */
public class IsValidBST {

    /**
     *
     * 二叉搜索树中序遍历的结果为有序的
     *
     */

    public static void main(String[] args) {

    }

    public boolean isValidBST1(TreeNode root){
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        if(node.val >= max || node.val <= min){
            return false;
        }
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }


    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        int index = 0;
        int pre = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                if(index !=0 && node.val <= pre){
                    return false;
                }
                pre = node.val;
                node = node.right;
                index++;
            }
        }
        return true;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
    }
}
