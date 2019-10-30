package com.ldf.architect.middleware.activeMq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author lidefu
 * @date 2019/9/4 16:41
 */
@Service
public class Publisher {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void publish(String destName, Object message) {
        JmsTemplate jmsTemplate = jmsMessagingTemplate.getJmsTemplate();
        //开启订阅模式
        jmsTemplate.setPubSubDomain(true);
        Destination destination = new ActiveMQTopic(destName);
        System.out.println("发布消息：" + message);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
