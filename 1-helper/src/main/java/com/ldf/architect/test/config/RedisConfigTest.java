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
        log.debug("test_value:{}", value);
    }


}
