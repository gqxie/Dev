/**  
 * Project Name:Dev  
 * File Name:SystemInit.java  
 * Package Name:com.gqxie.common  
 * Date:2017年6月30日下午6:26:51  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gqxie.entity.User;
import com.gqxie.service.UserService;
import com.gqxie.util.ehcache.EhcacheUtil;
import com.gqxie.util.encrypt.AESUtil;

/**
 * ClassName:SystemInit <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月30日 下午6:26:51 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.8
 * @see
 */
@Component
public class SystemInit implements ServletContextListener
{
    private Logger              logger       = Logger.getLogger(SystemInit.class);

    private static final String AES_KEY_FILE = "AesKey";

    @Autowired
    private UserService         userService;

    public void contextDestroyed(ServletContextEvent arg0)
    {
    }

    public void init() throws IOException
    {
        // 加载aes密钥
        readAesKey();
        // 缓存数据
        addAllUserToCache();
    }

    public void contextInitialized(ServletContextEvent arg0)
    {

        try
        {
            EhcacheUtil.init();
        }
        catch (Exception e)
        {
            logger.error("init ehcache error!");
            e.printStackTrace();
        }

    }

    private void addAllUserToCache()
    {
        List<User> list = userService.findAll();
        for (User user : list)
        {
            EhcacheUtil.put(user.getId(), user);
        }
    }

    private void readAesKey()
    {
        logger.info("load aes key from " + this.getClass().getResource("/").getPath() + AES_KEY_FILE + " ...");
        String aesKeyFile = this.getClass().getResource("/").getPath() + AES_KEY_FILE;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try
        {
            fis = new FileInputStream(aesKeyFile);
            ois = new ObjectInputStream(fis);
            Key key = (Key) ois.readObject();
            AESUtil.setKey(key);
            logger.info("load aes key success...");
        }
        catch (FileNotFoundException e)
        {
            logger.error("aes key file not found.");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            logger.error("load aes key failed.");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            logger.error("load aes key failed.");
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(ois);
        }
    }
}
