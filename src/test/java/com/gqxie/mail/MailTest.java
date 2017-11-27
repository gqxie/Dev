package com.gqxie.mail;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Xie Guoqiang
 * @date 2017-11-27 09:07:10
 */
public class MailTest
{
    @Test
    public void mainTest() throws MessagingException
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        // 端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "587");
        props.put("mail.user", "188353625@qq.com");
        props.put("mail.password", "ceymneiyafgqbifa");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(mailSession);
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);
        InternetAddress to = new InternetAddress("xieguoqiang@chezhibao.com");
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        // 设置邮件标题
        message.setSubject("测试邮件");
        // 设置邮件的内容体
        message.setContent("这是一封测试邮件", "text/html;charset=UTF-8");
        // 最后当然就是发送邮件啦
        Transport.send(message);
    }
}
