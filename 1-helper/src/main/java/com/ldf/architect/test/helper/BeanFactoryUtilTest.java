package com.ldf.architect.test.helper;

import com.ldf.architect.HelperApp;
import com.ldf.architect.config.RedisConfig;
import com.ldf.architect.helper.BeanFactoryUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lidefu
 * @date 2021年01月12日14:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelperApp.class)
public class BeanFactoryUtilTest {

    @Test
    public void getClassTest(){
        RedisConfig redisConfig = BeanFactoryUtil.getBean(RedisConfig.class);
        StringRedisTemplate redisTemplate = BeanFactoryUtil.getBean(StringRedisTemplate.class);
        assert true;
    }

}
