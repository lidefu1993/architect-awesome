package com.ldf.architect.collect;

import com.alibaba.fastjson.JSON;

import javax.sound.midi.Soundbank;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @author lidefu
 * @date 2018/12/17 9:18
 */
public class ListTest {


    /**
     * List
     *  https://juejin.cn/post/6916069478765690887/
     * ArrayList 和 LinkedList
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {

        linkedListConcurrentRemove();

    }

    private static void vectorTest(){
    }

    private static void linkedListTest() throws InterruptedException {
        linkedListConcurrentAdd();
    }

    /**
     * LinkedList 并发插入
     */
    private static void linkedListConcurrentAdd() throws InterruptedException {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int num = 1000;
        CountDownLatch latch = new CountDownLatch(num);
        for(int i=0; i<num; i++){
            new Thread(()->{
                linkedList.add(1);
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(linkedList.size());
    }

    /**
     * LinkedList 并发移除
     */
    private static void linkedListConcurrentRemove() throws InterruptedException {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0; i<1000; i++){
            linkedList.add(i);
        }
        int num = 500;
        CountDownLatch latch = new CountDownLatch(num);
        for(int i=0; i<num; i++){
            new Thread(()->{
                linkedList.remove(499);
                latch.countDown();
            }).start();

        }
        latch.await();
        System.out.println(linkedList.size());
        System.out.println(linkedList.getLast());
    }


    private static void arrayListTest(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        arrayList.forEach(integer -> System.out.println(integer));
        arrayList.iterator().next();
    }

    /**
     * ArrayList 并发插入 越界异常IndexOutOfRangeException
     */
    private static void arrayListConcurrentAdd() throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>(1);
        new Thread(() -> {
            for(int i=0; i<= 100; i++){
                arrayList.add(i);
            }
        }).start();
        new Thread(() -> {
            for(int i=0; i<= 10; i++){
                arrayList.add(i);
            }
        }).start();
        System.out.println(arrayList);
    }

    /**
     * 并发移除 并发操作异常
     */
    private static void arrayListConcurrentRemove() throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>(1);
        for(int i=0; i<= 10002; i++){
            arrayList.add(i);
        }
        new Thread(() -> {
            for(int i=5000; i>=0; i--){
                arrayList.remove(i);
            }
        }).start();
        new Thread(() -> {
            for(int i=5000; i>=0; i--){
                arrayList.remove(i);
            }
        }).start();
        Thread.sleep(10000L);
        System.out.println(arrayList);
    }


}
