package com.ldf.architect.tree;

import java.util.Random;
import java.util.Stack;

/**
 * 遍历树
 */
public class TreeTraversal {

    /**
     * 二叉树的前序、中序、后序遍历
     *
     * 先序：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
     *
     * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
     *
     * 后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
     */

    public static void main(String[] args) {
        BinarySearchTree.BinaryNode node = testCase();
        //前序遍历
        System.out.println("前序递归遍历:");
        pre(node);
        System.out.println("\n前序非递归遍历");
        pre2(node);

        //中序遍历
        System.out.println("\n中序递归遍历");
        mid(node);
        System.out.println("\n中序非递归遍历");
        mid2(node);

        //后序遍历
        System.out.println("\n后序递归遍历");
        bac(node);
        System.out.println("\n后序非递归遍历");
        bac(node);
    }

    //前序递归
    public static void pre(BinarySearchTree.BinaryNode tree){
        if(tree != null){
            System.out.print(tree.val+", ");
            pre(tree.left);
            pre(tree.right);
        }
    }

    //前序非递归
    public static void pre2(BinarySearchTree.BinaryNode tree){
        Stack<BinarySearchTree.BinaryNode> stack = new Stack<>();
        BinarySearchTree.BinaryNode curr = tree;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                System.out.print(curr.val+", ");
                stack.push(curr);
                curr=curr.left;
            }
            if(!stack.isEmpty()){
                BinarySearchTree.BinaryNode pop = stack.pop();
                curr=pop.right;
            }

        }
    }

    //中序递归
    public static void mid(BinarySearchTree.BinaryNode tree){
        if(tree != null){
            mid(tree.left);
            System.out.print(tree.val+" ,");
            mid(tree.right);
        }
    }

    //中序非递归
    public static void mid2(BinarySearchTree.BinaryNode tree){
        Stack<BinarySearchTree.BinaryNode> stack = new Stack<>();
        BinarySearchTree.BinaryNode node = tree;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                BinarySearchTree.BinaryNode pop = stack.pop();
                System.out.print(pop.val+" ,");
                node = pop.right;
            }
        }
    }

    //后序递归
    public static void bac(BinarySearchTree.BinaryNode tree){
        if(tree != null){
            bac(tree.left);
            bac(tree.right);
            System.out.print(tree.val + " ,");
        }
    }

    //后序非递归
    public static void bac2(BinarySearchTree.BinaryNode tree){
        Stack<BinarySearchTree.BinaryNode> stack = new Stack<>();
        BinarySearchTree.BinaryNode node = tree;
        BinarySearchTree.BinaryNode lastVisitedNode = null;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(stack.pop());
                node=node.left;
            }
            node = stack.peek();
            if(node.right == null || node.right == lastVisitedNode){
                System.out.print(node.val+" ,");
                stack.pop();
                lastVisitedNode = node;
                node = null;
            }else {
                node = node.right;
            }
        }
    }

    private static BinarySearchTree.BinaryNode testCase(){
        BinarySearchTree.BinaryNode tree = new BinarySearchTree.BinaryNode();
        tree.val=5;
        for(int i=0; i<7; i++){
            tree = BinarySearchTree.insert(tree, (int) (Math.random()*10));
        }
        return tree;
    }


}
