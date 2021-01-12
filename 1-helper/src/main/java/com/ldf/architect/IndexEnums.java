package com.ldf.architect;

import com.ldf.architect.config.RedisConfig;
import com.ldf.architect.helper.BeanFactoryUtil;
import com.ldf.architect.test.config.RedisConfigTest;

/**
 * @author lidefu
 * @date 2021年01月12日11:00
 **/
public enum IndexEnums {

    /**
     * 索引
     */
    REDIS_CONFIG("redis配置类", RedisConfig.class, RedisConfigTest.class),
    BEAN_FACTORY_UTIL("bean工厂工具类", BeanFactoryUtil.class, BeanFactoryUtil.class),

    ;
    private String msg;

    /**
     * class
     */
    private Class c;

    /**
     * 对应的测试Class
     */
    private Class tc;

    IndexEnums(String msg, Class c, Class tc){
        this.msg = msg;
        this.c = c;
        this.tc = tc;
    }

}
