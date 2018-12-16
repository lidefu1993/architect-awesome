package com.ldf.architect.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author lidefu
 * @date 2018/12/12 12:23
 */
public class QueueTest {

    public static void main(String[] args) throws InterruptedException {
        blockingPriorityQueue();
    }

    /**
     * PriorityQueue 队列测试
     * 存在队列中的元素不一定是按优先级存储的，取出的顺序一定是按顺序的。
     * 每次取出的数组的index=0的元素，需要保证index=0的元素永远是优先级最高的元素
     */
    private static void priorityQueueTest(){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //倒序
                return o1 - o2 > 0 ? -1 : 1;
            }
        });
        queue.add(1);
        queue.add(5);
        queue.add(6);
        queue.add(4);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.size());
        while (true){
            Object poll = queue.poll();
            System.out.println(poll);
            if(poll == null) {
                break;
            }
        }
    }

    /**
     * 阻塞队列
     * 从队列中取元素的时候，若队列为空，阻塞线程
     * 往队列中添加元素的时候，若队列已满，阻塞线程
     */
    private static void blockingPriorityQueue() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(2);
        Object o = queue.take();
        System.out.println("queue take:" + o);
    }

}
