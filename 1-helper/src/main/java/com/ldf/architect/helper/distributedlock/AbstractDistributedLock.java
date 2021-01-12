package com.ldf.architect.helper.distributedlock;

import java.io.Closeable;

/**
 * @author lidefu
 * @date 2021年01月12日13:56
 **/
public abstract class AbstractDistributedLock implements Closeable{


    protected DistributedLockProperties properties;


    public AbstractDistributedLock(DistributedLockProperties properties){
        this.properties = properties;
    }

    /**
     * 获取锁
     * @return true 获取锁成功 false 获取锁失败
     */
    public boolean tryLock(){
        if(properties.getWaitTime() == 0){
            return tryLock(properties.getLockKey(), properties.getLockVal(), properties.getExpireTime());
        }
        return tryLock(properties.getLockKey(), properties.getLockVal(), properties.getExpireTime(), properties.getWaitTime());
    }

    /**
     * 尝试获取锁
     * @param key 锁key
     * @param value 锁值
     * @param expireTime 锁失效时间
     * @param waitTime 获取锁等待时间
     * @return true获取成功
     */
    protected abstract boolean tryLock(String key, String value, long expireTime, long waitTime);

    /**
     * 尝试获取锁
     * @param key 锁key
     * @param value 锁值
     * @param expireTime 锁失效时间
     * @return true获取成功
     */
    protected abstract boolean tryLock(String key, String value, long expireTime);

    public boolean releaseLock(){
        return releaseLock(properties.getLockKey(), properties.getLockVal());
    }

    /**
     * 释放锁
     * @param key -
     * @param val -
     */
    protected abstract boolean releaseLock(String key, String val);

    @Override
    public void close(){
        releaseLock();
    }
}
