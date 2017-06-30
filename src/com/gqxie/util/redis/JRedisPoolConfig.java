/**  
 * Project Name:Dev  
 * File Name:JRedisPoolConfig.java  
 * Package Name:com.gqxie.util.redis  
 * Date:2017年6月30日下午1:09:20  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.util.redis;

/**  
 * ClassName:JRedisPoolConfig <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月30日 下午1:09:20 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.kit.PathKit;

public class JRedisPoolConfig
{
    protected static Logger log = LoggerFactory.getLogger(JRedisPoolConfig.class);
    public static String REDIS_IP;
    public static int REDIS_PORT;
    public static String REDIS_PASSWORD;
    public static int MAX_ACTIVE;
    public static int MAX_IDLE;
    public static long MAX_WAIT;
    public static boolean TEST_ON_BORROW;
    public static boolean TEST_ON_RETURN;

/*    static
    {
        init();
    }
*/
    public static void init()
    {
        try
        {
            String fullFile = PathKit.getWebRootPath() + File.separator + "WEB-INF" + File.separator + "classes"
                    + File.separator + "redis.properties";
            File file = new File(fullFile);
            if (file.exists())
            {
                log.info("loading redis config from redis.properties.......");
                InputStream in = new FileInputStream(fullFile);
                Properties p = new Properties();
                p.load(in);
                REDIS_IP = p.getProperty("redis.ip");
                REDIS_PORT = Integer.parseInt(p.getProperty("redis.port"));
                REDIS_PASSWORD = p.getProperty("redis.password");
                MAX_ACTIVE = Integer.parseInt(p.getProperty("redis.pool.maxActive"));
                MAX_IDLE = Integer.parseInt(p.getProperty("redis.pool.maxIdle"));
                MAX_WAIT = Integer.parseInt(p.getProperty("redis.pool.maxWait"));
                TEST_ON_BORROW = Boolean.parseBoolean(p.getProperty("redis.pool.testOnBorrow"));
                TEST_ON_RETURN = Boolean.parseBoolean(p.getProperty("redis.pool.testOnReturn"));
                log.info("redis config load Completed。");
                in.close();
                in = null;
            } else
            {
                log.error("redis.properties is not found!");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
