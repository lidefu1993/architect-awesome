package com.ldf.architect.helper.distributedlock;

/**
 * @author lidefu
 * @date 2021年01月12日15:22
 **/
public class RedissionClientDistributedLock extends AbstractDistributedLock{


    public RedissionClientDistributedLock(DistributedLockProperties properties) {
        super(properties);
    }

    @Override
    protected boolean tryLock(String key, String value, long expireTime, long waitTime) {
        return false;
    }

    @Override
    protected boolean tryLock(String key, String value, long expireTime) {
        return false;
    }

    @Override
    protected boolean releaseLock(String key, String val) {
        return false;
    }

}
