package com.ldf.arithmetic.leetcode;

/**
 * 两数相加
 * @author lidefu
 * @date 2019/1/17 8:42
 */
public class AddingTwoNumbers{

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */

    public static void main(String[] args) {
        ListNode l1 = createListNode("364");
        ListNode l2 = createListNode("757");
        AddingTwoNumbers numbers = new AddingTwoNumbers();
        ListNode node = numbers.addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p1 = l1,p2 = l2;
        //当前所处节点
        ListNode current = result;
        //进位
        int extra = 0;
        while (p1 != null || p2 != null){
            int p1Val = (p1 == null) ? 0 : p1.val;
            int p2Val = (p2 == null) ? 0 : p2.val;
            int currentVal = p1Val + p2Val + extra;
            current.next = new ListNode(currentVal%10);
            //切换当前节点(关键)
            current = current.next;
            extra = currentVal/10;
            if(p1 != null) {
                p1 = p1.next;
            }
            if(p2 != null) {
                p2 = p2.next;
            }
        }
        if(extra == 1) {
            current.next = new ListNode(1);
        }
        return result.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode createListNode(String num){
        String[] split = num.split("");
        ListNode listNode = new ListNode(Integer.valueOf(split[0]));
        ListNode currentNode = listNode;
        if(split.length > 1){
            for (int i = 1; i<split.length; i++){
                ListNode next = new ListNode(Integer.valueOf(split[i]));
                currentNode.next = next;
                currentNode = next;
            }
        }
        return listNode;
    }

}
