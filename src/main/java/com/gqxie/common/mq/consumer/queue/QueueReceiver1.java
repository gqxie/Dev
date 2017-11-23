package com.gqxie.common.mq.consumer.queue;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author xieguoqiang
 * @description 队列消息监听器
 */
@Component
public class QueueReceiver1 implements MessageListener
{
    private Logger logger = Logger.getLogger(QueueReceiver1.class);

    @Override
    public void onMessage(Message message)
    {
        try
        {
            logger.info("QueueReceiver1接收到消息:" + ((TextMessage) message).getText());
        }
        catch (JMSException e)
        {
            logger.error("queue receiver error.", e);
        }
    }
}
