package com.ldf.arithmetic.leetcode;

/**
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */

    public static void main(String[] args) {
        TreeNode node = testCase();
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode treeNode = ancestor.lowestCommonAncestor2(node, new TreeNode(3), new TreeNode(6));
        System.out.println(1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.equals(p) || root.equals(q)){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static TreeNode testCase(){
        TreeNode node = new TreeNode(8);
        for(int val : new int[]{5, 3, 6, 2, 4, 7}){
            node = insert(node, val);
        }
        return node;
    }

    public static TreeNode insert(TreeNode tree, int val){
        if(tree == null){
            return new TreeNode(val, null, null);
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

        @Override
        public boolean equals(Object obj){
            return ((TreeNode)obj).val == this.val;
        }

        @Override
        public int hashCode(){
            return this.val;
        }

    }

}
