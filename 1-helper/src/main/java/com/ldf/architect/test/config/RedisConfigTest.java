package com.ldf.architect.test.config;

import com.ldf.architect.HelperApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lidefu
 * @date 2021年01月12日11:20
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelperApp.class)
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void redisTemplateTest(){
        String key = "test_key";
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, "test_value");
        String value = valueOperations.get(key);
        Boolean absent = valueOperations.setIfAbsent(key, "2", 1000L * 20, TimeUnit.MILLISECONDS);
        log.debug("-------setIfAbsent:{}", absent);
        log.debug("test_value:{}", value);
        assert true;
    }

    @Test
    public void jedisPoolTest(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedis_pool_key", "jedis_pool_value");
        jedis.close();
        assert true;
    }

    @Test
    public void redisTemplateConcurrentTest() throws InterruptedException {
        int num = 1000;
        CountDownLatch latch = new CountDownLatch(num);
        int i = 0;
        for (; i<num; i++){
            new Thread(()->{
                redisTemplateTest();
                latch.countDown();
            }).start();
        }
        latch.await();
        log.debug("--------redisTemplateConcurrentTest, i:{}", i);
    }

    @Test
    public void jedisPoolConcurrentTest() throws InterruptedException {
        int num = 10000;
        CountDownLatch latch = new CountDownLatch(num);
        int i = 0;
        for (; i<num; i++){
            new Thread(()->{
                jedisPoolTest();
                latch.countDown();
            }).start();
        }
        latch.await();
        log.debug("--------jedisPoolConcurrentTest, i:{}", i);
    }

}
