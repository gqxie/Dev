package com.gqxie.util.email;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Xie Guoqiang
 * @date 2017-11-27 13:14:12
 */
public final class EmailUtil
{
    private static Logger logger = Logger.getLogger(EmailUtil.class);

    private static volatile EmailUtil emailUtil;

    private static Authenticator authenticator;

    private static Properties props;

    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    private static final String MAIL_SMTP_HOST = "mail.smtp.host";

    private static final String MAIL_SMTP_PORT = "mail.smtp.port";

    private static final String MAIL_USER = "mail.user";

    private static final String MAIL_PASSWORD = "mail.password";

    private static final String EMAIL_CONFIG = "mail.properties";

    private EmailUtil()
    {
    }

    public static EmailUtil getInstance()
    {
        if (null == emailUtil)
        {
            synchronized (EmailUtil.class)
            {
                if (null == emailUtil)
                {
                    emailUtil = new EmailUtil();
                    init();
                }
            }
        }
        return emailUtil;
    }

    private static void init()
    {
        try (FileInputStream fos = new FileInputStream(emailUtil.getClass().getResource("/").getPath() + EMAIL_CONFIG))
        {
            props = new Properties();
            props.load(fos);
            logger.info("load mail config success.");
        }
        catch (IOException e)
        {
            logger.error("load email config error.", e);
        }

        // 构建授权信息，用于进行SMTP进行身份验证
        authenticator = new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                String userName = props.getProperty(MAIL_USER);
                String password = props.getProperty(MAIL_PASSWORD);
                return new PasswordAuthentication(userName, password);
            }
        };
    }

    /**
     * 发送邮件
     *
     * @param subject 主题
     * @param mailTo  发送到
     * @param content 邮件内容
     */
    public void sendMail(String mailTo, String subject, String content)
    {
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try
        {
            InternetAddress form = new InternetAddress(props.getProperty(MAIL_USER));
            message.setFrom(form);
            InternetAddress to = new InternetAddress(mailTo);
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);
        }
        catch (MessagingException e)
        {
            logger.error("send mail failed.", e);
        }
    }

}
