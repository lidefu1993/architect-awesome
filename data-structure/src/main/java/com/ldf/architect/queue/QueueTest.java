package com.ldf.architect.queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * @author lidefu
 * @date 2018/12/12 12:23
 */
public class QueueTest {

    public static void main(String[] args) throws InterruptedException {
        dequeTest();
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
     * 取元素时，若队列为空，阻塞线程等待通知
     * 添加元素时，通知因为队列为空阻塞的线程；若丢列满了，阻塞或者抛出异常
     */

    /**
     * 优先级阻塞队列
     */
    private static void blockingPriorityQueue() throws InterruptedException {
        BlockingQueue<String> queue = new PriorityBlockingQueue<String>(1);
        queue.add("3");
        queue.add("2");
        String take = queue.take();
        System.out.println("queue take:" + take);
    }

    /**
     * 基于数组的阻塞队列
     */
    private static void arrayBlockingQueue() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        queue.add(1);
        queue.offer(1);
        queue.take();
        queue.poll();
    }

    /**
     * 基于链表的阻塞队列
     */
    private static void linkedBlockingQueue() throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(1);
        queue.add(1);
        queue.take();
    }

    /**
     * 双向队列测试
     */
    private static void dequeTest(){
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(1);
        deque.addFirst(2);
        deque.addLast(3);
        Integer first = deque.getFirst();
        Integer last = deque.getLast();
        System.out.println("first:" + first + " last:" + last);
    }

    /**
     * 延迟队列
     */
    private static void delayQueue(){
        DelayQueue delayQueue = new DelayQueue();
        DelayedTask task1 = new DelayedTask();
        delayQueue.add(task1);
    }

    private static class DelayedTask implements Delayed{

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

}
