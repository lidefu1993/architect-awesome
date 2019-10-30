package com.ldf.architect.middleware.activeMq;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

/**
 * @author lidefu
 * @date 2019/9/4 16:44
 */
@Service
public class Subscriber {

    @JmsListener(destination = "topic.0904", containerFactory = "myJmsListenerContainerFactory")
    public void subscriber(Object obj) {
        try {
            //接受对象消息
            if (obj instanceof ActiveMQObjectMessage) {
                Object sourObj = ((ActiveMQObjectMessage) obj).getObject();
                System.out.println("收到订阅消息：" + sourObj);
            }else if(obj instanceof ActiveMQTextMessage){
                String text = ((ActiveMQTextMessage) obj).getText();
                System.out.println("收到订阅消息：" + text);
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
