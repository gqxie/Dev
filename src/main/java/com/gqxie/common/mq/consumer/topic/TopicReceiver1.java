package com.gqxie.common.mq.consumer.topic;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author xieguoqiang
 * @description Topic消息监听器
 */
@Component
public class TopicReceiver1 implements MessageListener
{
    private Logger logger = Logger.getLogger(TopicReceiver1.class);

    @Override
    public void onMessage(Message message)
    {
        try
        {
            logger.info("TopicReceiver1接收到消息:" + ((TextMessage) message).getText());
        }
        catch (JMSException e)
        {
            logger.error("topic receiver error.", e);
        }
    }

}
