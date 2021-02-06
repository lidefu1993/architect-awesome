package com.ldf.architect.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CasTest {

    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(0);
        integer.incrementAndGet();


    }

}
