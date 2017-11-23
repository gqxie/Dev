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
public class QueueReceiver2 implements MessageListener
{
    private Logger logger = Logger.getLogger(QueueReceiver2.class);

    @Override
    public void onMessage(Message message)
    {
        try
        {
            logger.info("QueueReceiver2接收到消息:" + ((TextMessage) message).getText());
        }
        catch (JMSException e)
        {
            logger.error("queue receiver error.", e);
        }
    }

}
