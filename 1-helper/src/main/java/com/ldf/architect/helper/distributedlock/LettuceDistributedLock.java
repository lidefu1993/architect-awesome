package com.ldf.architect.helper.distributedlock;

import com.ldf.architect.helper.BeanFactoryUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @author lidefu
 * @date 2021年01月12日15:08
 **/
public class LettuceDistributedLock extends JedisDistributedLock{

    private ValueOperations<String, String> valueOperations;
    private StringRedisTemplate redisTemplate;
    public LettuceDistributedLock(DistributedLockProperties properties) {
        super(properties);
        redisTemplate = BeanFactoryUtil.getBean(StringRedisTemplate.class);
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    protected boolean tryLock(String key, String value, long expireTime) {
        Boolean absent = valueOperations.setIfAbsent(key, value, expireTime, TimeUnit.MILLISECONDS);
        return absent == null ? false : absent;
    }

    @Override
    protected boolean releaseLock(String key, String val) {
        Boolean b = redisTemplate.delete(key);
        return b == null ? false : b;
    }
}
