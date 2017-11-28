/**
 * Project Name:Dev
 * File Name:SystemInit.java
 * Package Name:com.gqxie.common
 * Date:2017年6月30日下午6:26:51
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.
 */

package com.gqxie.common;

import com.gqxie.entity.TUser;
import com.gqxie.entity.TUserExample;
import com.gqxie.mapper.TUserMapper;
import com.gqxie.util.ehcache.EhcacheUtil;
import com.gqxie.util.encrypt.AesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.List;

/**
 * ClassName:SystemInit <br/>
 * Date: 2017年6月30日 下午6:26:51 <br/>
 *
 * @author xie
 * @see
 * @since JDK 1.8
 */
@Component
public class SystemInit implements ServletContextListener
{
    private Logger logger = Logger.getLogger(SystemInit.class);

    private static final String AES_KEY_FILE = "AesKey";

    @Autowired
    private TUserMapper userMapper;

    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        //do nothing
    }

    public void init()
    {
        // 加载aes密钥
        readAesKey();
        // 缓存数据
        addAllUserToCache();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {

        try
        {
            EhcacheUtil.init();
        }
        catch (Exception e)
        {
            logger.error("init ehcache error!", e);
        }

    }

    private void addAllUserToCache()
    {
        TUserExample example = new TUserExample();
        List<TUser> list = userMapper.selectByExample(example);
        for (TUser user : list)
        {
            user.setPwd(AesUtil.decrypt(user.getPwd()));
            EhcacheUtil.put(user.getId(), user);
        }
    }

    private void readAesKey()
    {
        logger.info("load aes key from " + this.getClass().getResource("/").getPath() + AES_KEY_FILE + " ...");
        String aesKeyFile = this.getClass().getResource("/").getPath() + AES_KEY_FILE;
        try (FileInputStream fis = new FileInputStream(aesKeyFile); ObjectInputStream ois = new ObjectInputStream(fis))
        {
            Key key = (Key) ois.readObject();
            AesUtil.setKey(key);
            logger.info("load aes key success...");
        }
        catch (FileNotFoundException e)
        {
            logger.error("aes key file not found.", e);
        }
        catch (ClassNotFoundException | IOException e)
        {
            logger.error("load aes key failed.", e);
        }
    }
}
