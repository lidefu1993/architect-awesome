package com.ldf.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 两两交换链表中的节点
 */
public class LinkedSwapPairs {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     */

    public static void main(String[] args) {
        LinkedSwapPairs swapPairs = new LinkedSwapPairs();
        ListNode listNode = testCase();
        ListNode node = swapPairs.swapPairs(listNode);
        System.out.println(1);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return res.next;
    }

    public static ListNode testCase(){
        ListNode root = new ListNode(1);
        ListNode curr = root;
        for(int i=2; i<=4; i++){
            ListNode node = new ListNode(i);
            curr.next = node;
            curr=node;
        }
        return root;
    }

    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

}
