package com.gqxie.common.email.mq;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.gqxie.common.email.vo.EmailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 邮件消息生产者类
 *
 * @author Xie Guoqiang
 * @date 2017-11-27 14:00:44
 */
@Component("emailMsgSender")
public class EmailMsgSender
{

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 邮件发送队列名
     */
    private static final String EMAIL_QUEUE = "email.queue";

    /**
     * 发送一条消息到指定的队列（目标）
     *
     * @param queueName 队列名称
     * @param message   消息内容
     */
    private void send(String queueName, final String message)
    {
        jmsTemplate.send(queueName, session -> session.createTextMessage(message));
    }

    /**
     * 组装邮件消息体
     *
     * @param mailTo  接收人
     * @param subject 主题
     * @param content 内容
     */
    public void sendEmail(String mailTo, String subject, String content)
    {
        EmailVO emailVO = new EmailVO(mailTo, subject, content);
        String msg = JSON.toJSONString(emailVO);
        send(EMAIL_QUEUE, msg);
    }

    /**
     * 邮件消息体对象
     *
     * @param emailVO
     */
    public void sendEmail(EmailVO emailVO)
    {
        String msg = JSON.toJSONString(emailVO);
        send(EMAIL_QUEUE, msg);
    }
}
