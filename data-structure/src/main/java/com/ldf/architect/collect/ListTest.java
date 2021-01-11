package com.ldf.architect.collect;

import com.alibaba.fastjson.JSON;

import javax.sound.midi.Soundbank;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lidefu
 * @date 2018/12/17 9:18
 */
public class ListTest {


    /**
     * List
     * ArrayList 和 LinkedList
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {

        linkedListTest();

    }

    private static void linkedListTest() throws InterruptedException {
        linkedListConcurrentAdd();
    }

    /**
     * LinkedList 并发插入 越界异常IndexOutOfRangeException
     */
    private static void linkedListConcurrentAdd() throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>(1);
        new Thread(() -> {
            for(int i=0; i<= 10; i++){
                arrayList.add(i);
            }
        }).start();
        new Thread(() -> {
            for(int i=0; i<= 10; i++){
                arrayList.add(i);
            }
        }).start();

        Thread.sleep(100L);
        System.out.println(arrayList.size());
    }


    private static void arrayListTest(){
        ArrayList<Integer> arrayList = new ArrayList<>();
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
