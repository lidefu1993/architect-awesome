package com.ldf.arithmetic.leetcode;

import java.util.List;

/**
 * K 个一组翻转链表
 */
public class LinkedReverseKGroup {

    /**
     *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     *  
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     *  
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */

    public static void main(String[] args) {
        LinkedReverseKGroup kGroup = new LinkedReverseKGroup();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        res.next=head;
        ListNode temp = res;
        while (head != null){
            //判断链表的长度是否小于k,并取到第k个节点
            ListNode kTail = temp;
            for(int i=0; i<k; i++){
                kTail = kTail.next;
                //链表长度小于k, 剩余结果不需要翻转，返回
                if(kTail == null){
                    return res.next;
                }
            }
            //事先取出下一阶段链表的首节点
            ListNode next = kTail.next;
            //旋转以head为首节点tail为尾节点的链表
            ListNode[] reverse = reverse(head, kTail);
            temp.next = reverse[0];
            reverse[1].next = next;
            temp=reverse[1];
            head=next;
        }
        return res.next;
    }

    /**
     * 翻转以head为头以tail为尾的链表
     * @param head 头
     * @param tail 尾
     * @return 【0】翻转后的头部节点 [1]翻转后的尾部节点
     */
    public static ListNode[] reverse(ListNode head, ListNode tail){
        ListNode curr = head;
        ListNode pre = tail.next;
        while (pre != tail){
            ListNode next = curr.next;
            curr.next = pre;
            pre=curr;
            curr=next;
        }
        return new ListNode[]{tail, head};
    }

    public static ListNode testCase(){
        ListNode root = new ListNode(1);
        ListNode curr = root;
        for(int i=2; i<=8; i++){
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
