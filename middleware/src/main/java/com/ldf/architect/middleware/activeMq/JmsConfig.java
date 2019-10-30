package com.ldf.architect.middleware.activeMq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @author lidefu
 * @date 2019/9/4 16:43
 */
@Configuration
public class JmsConfig {

    @Bean
    JmsListenerContainerFactory<?> myJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory = new SimpleJmsListenerContainerFactory();
        simpleJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        //开启订阅模式
        simpleJmsListenerContainerFactory.setPubSubDomain(true);
        //开启持久化订阅,订阅端不在线能保持未消费的消息
        simpleJmsListenerContainerFactory.setClientId("ldf");
        simpleJmsListenerContainerFactory.setSubscriptionDurable(true);
        return simpleJmsListenerContainerFactory;
    }

}
