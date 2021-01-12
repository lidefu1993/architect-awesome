package com.ldf.architect.helper.distributedlock;

import lombok.Getter;

/**
 * @author lidefu
 * @date 2021年01月12日14:29
 **/
@Getter
public class DistributedLockProperties {

    /**
     * 分布式锁key
     */
    private String lockKey;

    /**
     * 分布式锁value
     */
    private String lockVal;

    /**
     * 锁失效时间
     */
    private Long expireTime;

    /**
     * 获取锁等待时间
     */
    private Long waitTime;

    private DistributedLockProperties(){}

    public DistributedLockProperties(String lockKey){
        this.lockKey = lockKey;
        this.lockVal = "1";
        this.expireTime = 1000L * 10;
        this.waitTime = 1000L * 5;
    }

    public DistributedLockProperties ofLockVal(String lockVal){
        if(lockVal != null){
            this.lockVal = lockVal;
        }
        return this;
    }

    public DistributedLockProperties ofExpireTime(Long expireTime){
        if(expireTime != null){
            this.expireTime = expireTime;
        }
        return this;
    }

    public DistributedLockProperties ofWaitTime(Long waitTime){
        if(waitTime != null){
            this.waitTime = waitTime;
        }
        return this;
    }

}
