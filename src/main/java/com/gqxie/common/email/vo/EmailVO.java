package com.gqxie.common.email.vo;

import lombok.Data;

/**
 * 邮件value对象,用于生成mq消息
 *
 * @author Xie Guoqiang
 * @date 2017-11-27 15:54:10
 */
public class EmailVO
{
    public EmailVO()
    {

    }

    public EmailVO(String mailTo, String subject, String content)
    {
        this.mailTo = mailTo;
        this.subject = subject;
        this.content = content;
    }

    /**
     * 收件人
     */
    private String mailTo;
    /**
     * 主题
     */
    private String subject;
    /**
     * 内容
     */
    private String content;

    public String getMailTo()
    {
        return mailTo;
    }

    public void setMailTo(String mailTo)
    {
        this.mailTo = mailTo;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "EmailVO{" + "mailTo='" + mailTo + '\'' + ", subject='" + subject + '\'' + ", content='" + content + '\''
                + '}';
    }
}
