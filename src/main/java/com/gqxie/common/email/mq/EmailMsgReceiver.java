package com.gqxie.common.email.mq;

import com.alibaba.fastjson.JSON;
import com.gqxie.common.email.vo.EmailVO;
import com.gqxie.util.email.EmailUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 邮件消息消费者类
 *
 * @author Xie Guoqiang
 * @date 2017-11-27 14:02:40
 */
@Component
public class EmailMsgReceiver implements MessageListener
{
    private Logger logger = Logger.getLogger(EmailMsgReceiver.class);

    @Override
    public void onMessage(Message message)
    {
        try
        {
            logger.info("EmailMsgReceiver接收到消息:" + ((TextMessage) message).getText());
            EmailVO emailVO = JSON.parseObject(((TextMessage) message).getText(), EmailVO.class);
            EmailUtil.getInstance().sendMail(emailVO.getMailTo(), emailVO.getSubject(), emailVO.getContent());
            logger.info("send email success.");
        }
        catch (JMSException e)
        {
            logger.error("queue receiver error.", e);
        }
    }
}
