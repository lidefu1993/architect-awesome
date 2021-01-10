package com.ldf.arithmetic.other;

/**
 * @author ldf
 * @date 2021/1/7 22:19
 **/
public class LinkReset {

    /**
     *  链表倒置
     */

    public static void main(String[] args) {
        LinkNode linkNode = testLinkNode();
        System.out.println("原链表：" );
        print(linkNode);
        LinkNode resetLinkNode = reset(linkNode);
        System.out.println("倒转后：" );
        print(resetLinkNode);
    }

    private static LinkNode reset(LinkNode linkNode){
        if(linkNode.next == null){
            return linkNode;
        }
        LinkNode lastNode = reset(linkNode.next);
        linkNode.next.next = linkNode;
        linkNode.next = null;
        return lastNode;
    }

    static class LinkNode{
        private int val;
        private LinkNode next;
        public LinkNode(int val){
            this.val = val;
        }

        @Override
        public String toString(){
            return val+"";
        }
    }

    private static LinkNode testLinkNode(){
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    private static void print(LinkNode linkNode){
        if(linkNode == null){
            System.out.println("链表为空");
            return;
        }
        LinkNode next = linkNode;
        StringBuilder builder = new StringBuilder("");
        while (next != null){
            builder.append(next.toString()).append(";");
            next = next.next;
        }
        System.out.println(builder.toString());
    }

}
