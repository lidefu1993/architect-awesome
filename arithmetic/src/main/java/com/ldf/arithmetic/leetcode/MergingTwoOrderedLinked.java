package com.ldf.arithmetic.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并两个有序链表
 * @author lidefu
 * @date 2019/8/29 8:47
 */
public class MergingTwoOrderedLinked {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     示例：
     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     *
     */

    public static void main(String[] args) {
        MergingTwoOrderedLinked linked = new MergingTwoOrderedLinked();
        ListNode l1 = linked.listNode(1, 2, 4);
        ListNode l2 = linked.listNode(1, 3, 4);
        ListNode node = linked.mergeTwoLists2(l1, l2);
        ListNode node1 = linked.mergeTwoLists(l1, l2);
        System.out.println(1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        List<Integer> vals = new ArrayList<>();
        ListNode l1Next = l1;
        while (l1Next != null){
            vals.add(l1Next.val);
            l1Next = l1Next.next;
        }
        ListNode l2Next = l2;
        while (l2Next != null){
            vals.add(l2Next.val);
            l2Next = l2Next.next;
        }
        Integer[] integers = new Integer[vals.size()];
        vals.toArray(integers);
        Arrays.sort(integers);
        ListNode node = new ListNode(0);
        ListNode next = node;
        for(Integer integer : integers){
            next = next.next = new ListNode(integer);
        }
        return node.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode listNode(Integer... integers){
        ListNode node = new ListNode(0);
        ListNode next = node;
        for(Integer integer : integers){
            next = next.next = new ListNode(integer);
        }
        return node.next;
    }



}
