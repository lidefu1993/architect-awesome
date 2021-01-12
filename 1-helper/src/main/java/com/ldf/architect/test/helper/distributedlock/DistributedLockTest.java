package com.ldf.architect.test.helper.distributedlock;

import com.ldf.architect.HelperApp;
import com.ldf.architect.helper.distributedlock.AbstractDistributedLock;
import com.ldf.architect.helper.distributedlock.DistributedLockProperties;
import com.ldf.architect.helper.distributedlock.JedisDistributedLock;
import com.ldf.architect.helper.distributedlock.LettuceDistributedLock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @author lidefu
 * @date 2021年01月12日16:21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelperApp.class)
public class DistributedLockTest {

    private DistributedLockProperties properties;

    @Before
    public void init(){
        this.properties = new DistributedLockProperties("lock_01").ofWaitTime(3000L);

    }

    @Test
    public void jedisDistributedLockTest() throws InterruptedException {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        int i=0;
        for (; i<= num; i++){
            new Thread(()->{
                try(AbstractDistributedLock distributedLock = new JedisDistributedLock(properties)) {
                    boolean tryLock = distributedLock.tryLock();
                    latch.countDown();
                    System.out.println("------------tryLock:"+ tryLock);
                }
            }).start();
        }
        latch.await();
        Thread.sleep(1000L);
        System.out.println("jedisDistributedLockTest end i:" + i);
    }

    @Test
    public void lettuceDistributedLockTest() throws InterruptedException {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        int i=0;
        for (; i<= num; i++){
            new Thread(()->{
                try(AbstractDistributedLock distributedLock = new LettuceDistributedLock(properties)) {
                    boolean tryLock = distributedLock.tryLock();
                    latch.countDown();
                    System.out.println("------------tryLock:"+ tryLock);
                }
            }).start();
        }
        latch.await();
        Thread.sleep(1000L);
        System.out.println("jedisDistributedLockTest end i:" + i);
    }

}
