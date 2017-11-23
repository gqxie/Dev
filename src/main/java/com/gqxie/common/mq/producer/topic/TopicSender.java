package com.gqxie.common.mq.producer.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xieguoqiang
 * @description Topic生产者发送消息到Topic
 */

@Component("topicSender")
public class TopicSender
{

    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 发送一条消息到指定的队列（目标）
     *
     * @param topicName 队列名称
     * @param message   消息内容
     */
    public void send(String topicName, final String message)
    {
        jmsTemplate.send(topicName, session -> session.createTextMessage(message));
    }

}
