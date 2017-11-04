/**  
 * Project Name:Dev  
 * File Name:SystemInit.java  
 * Package Name:com.gqxie.common  
 * Date:2017年6月30日下午6:26:51  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gqxie.util.ehcache.EhcacheUtil;
import com.gqxie.util.redis.JRedisPoolConfig;

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
public class SystemInit implements ServletContextListener
{
    public void contextDestroyed(ServletContextEvent arg0)
    {

    }

    public void contextInitialized(ServletContextEvent arg0)
    {

        try
        {
            // 初始化jedis
            JRedisPoolConfig.init();
            // 初始化ehcache
            EhcacheUtil.init();
        } catch (Exception e)
        {
            System.out.println("system init error!");
        }

    }
}
