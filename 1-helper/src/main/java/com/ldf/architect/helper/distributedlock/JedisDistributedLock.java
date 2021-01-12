package com.ldf.architect.helper.distributedlock;

import com.ldf.architect.helper.BeanFactoryUtil;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * @author lidefu
 * @date 2021年01月12日14:51
 **/
@Slf4j
public class JedisDistributedLock extends AbstractDistributedLock{

    /**
     * 首先获取锁对应的value值，检查是否相等，如果相等则删除锁（解锁）
     */
    private static final String LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    private static final Long RELEASE_SUCCESS = 1L;
    private JedisPool jedisPool;

    public JedisDistributedLock(DistributedLockProperties properties) {
        super(properties);
        this.jedisPool = BeanFactoryUtil.getBean(JedisPool.class);
    }

    /**
     *  TODO 优化
     * @param key 锁key
     * @param value 锁值
     * @param expireTime 锁失效时间
     * @param waitTime 获取锁等待时间
     * @return
     */
    @Override
    protected boolean tryLock(String key, String value, long expireTime, long waitTime) {
        boolean tryLock = false;
        long current = System.currentTimeMillis();
        while (!tryLock && System.currentTimeMillis()-current<waitTime){
            tryLock = tryLock(key, value, expireTime);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return tryLock;
    }

    @Override
    protected boolean tryLock(String key, String value, long expireTime) {
        Jedis jedisConnection = null;
        String result = null;
        try {
            // 获取连接
            jedisConnection = jedisPool.getResource();
            result = jedisConnection.set(key, value, "NX", "PX", expireTime);
        } catch (Exception e) {
            throw new RuntimeException("JedisDistributedLock tryLock error ", e);
        } finally {
            closeJedisConnection(jedisConnection);
        }
        if ("OK".equals(result)) {
            log.debug("加锁失败，lockKey:{}, lockVal:{}", key, value);
            return true;
        }
        log.warn("加锁失败，lockKey:{}, lockVal:{}", key, value);
        return false;
    }

    @Override
    protected boolean releaseLock(String key, String val) {
        Jedis jedisConnection = null;
        Object result = null;
        try {
            jedisConnection = jedisPool.getResource();
            result = jedisConnection.eval(LUA_SCRIPT, Collections.singletonList(key), Collections.singletonList(val));
        } catch (Exception e) {
            throw new RuntimeException("JedisDistributedLock releaseLock error", e);
        } finally {
            closeJedisConnection(jedisConnection);
        }
        boolean releaseResult = RELEASE_SUCCESS.equals(result);
        log.info("解锁结果:{}，lockKey:{}, lockVal:{}", RELEASE_SUCCESS.equals(result), key, val);
        return releaseResult;
    }

    private void closeJedisConnection(Jedis jedisConnection){
        if(jedisConnection != null && jedisConnection.isConnected()){
            jedisConnection.close();
        }
    }

}
