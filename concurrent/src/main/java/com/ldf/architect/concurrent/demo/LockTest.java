package com.ldf.architect.concurrent.demo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lidefu
 * @date 2019/2/22 14:42
 */
public class LockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
    }

}
