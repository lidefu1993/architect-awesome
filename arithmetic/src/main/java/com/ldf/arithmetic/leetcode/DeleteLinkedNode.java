package com.ldf.arithmetic.leetcode;

import java.util.*;
import java.util.stream.Stream;

/**
 * 删除链表的倒数第N个节点
 * @author lidefu
 * @date 2019/8/26 10:26
 */
public class DeleteLinkedNode {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
    */



    public static void main(String[] args) {
        DeleteLinkedNode node = new DeleteLinkedNode();
        ListNode node1 = node.removeNthFromEndOfficial(node.listNode(), 4);
        System.out.println(node1);

    }


    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null || n < 0) {
            return head;
        }
        //获取链表长度
        int length = 1;
        ListNode next = head;
        while ((next = next.next) != null){
            length++;
        }
        if(n > length){
            return head;
        }
        if(length == 1){
            return null;
        }
        //倒数第n个节点所在的索引
        int nIndex = 0;
        next = head;
        if(n == 1){
            //删除倒数第一个即最后一个 倒数第二个的next赋值为null
            while (nIndex < length-1){
                if(nIndex++ == length-2){
                    next.next = null;
                }
                next = next.next;
            }
        }else if(n == length){
            //删除头上的 返回head的next
            head = head.next;
        }else {
            //删除中间的 删除位置的上一个节点的next赋值为删除节点的next
            ListNode pre = head;
            next = head.next;
            while (nIndex <= length-n-1){
                if(nIndex++ == length-n-1){
                    pre.next = next.next;
                }
                pre = pre.next;
                next = next.next;
            }
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n){
        if(head == null || n < 0) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode next = head; listNodes.add(next);
        while ((next = next.next) != null){
            listNodes.add(next);
        }
        if(n > listNodes.size()){
            return head;
        }
        if(listNodes.size() == 1){
            return null;
        }
        if(n == 1){
            //删除倒数第一个即最后一个:倒数第二个的next赋值为null
           listNodes.get(listNodes.size()-2).next = null;
        }else if(n == listNodes.size()){
            //删除头上的 返回head的next
            head = head.next;
        }else {
            //删除中间的 删除位置的上一个节点的next赋值为删除节点的next
            listNodes.get(listNodes.size()-n-1).next = listNodes.get(listNodes.size()-n).next;
        }
        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n){
        if(head == null || n < 0) {
            return head;
        }
        Map<Integer, ListNode> nodeMap = new HashMap<>(20);
        int index = 0;
        ListNode next = head; nodeMap.put(index, next);
        while ((next = next.next) != null){
            nodeMap.put(++index, next);
        }
        if(n > index+1){
            return head;
        }
        if(index+1 == 1){
            return null;
        }
        if(n == 1){
            //删除倒数第一个即最后一个:倒数第二个的next赋值为null
            nodeMap.get(index-1).next = null;
        }else if(n == index+1){
            //删除头上的 返回head的next
            head = head.next;
        }else {
            //删除中间的 删除位置的上一个节点的next赋值为删除节点的next
            nodeMap.get(index-n).next = nodeMap.get(index+1-n).next;
        }
        return head;
    }

    public ListNode removeNthFromEndOfficial(ListNode head, int n){
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode a = node, b = node;
        for(int i=1; i<= n+1; i++){
            a = a.next;
        }
        while (a != null){
            a = a.next;
            b = b.next;
        }
        b.next = b.next.next;
        return node.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    private ListNode listNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

}
