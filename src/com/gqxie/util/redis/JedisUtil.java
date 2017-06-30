/**  
 * Project Name:Dev  
 * File Name:RedisTest.java  
 * Package Name:com.gqxie.util.redis  
 * Date:2017年6月30日下午12:45:39  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil
{

    private static JedisPool jedisPool = null;

    /** 缓存生存时间 */
    private final static int expire = 60000;

    static
    {
        JedisPoolConfig config = new JedisPoolConfig();
        // config.setMaxActive(JRedisPoolConfig.MAX_ACTIVE);
        config.setMaxIdle(JRedisPoolConfig.MAX_IDLE);
        // config.setMaxWait(JRedisPoolConfig.MAX_WAIT);
        config.setTestOnBorrow(JRedisPoolConfig.TEST_ON_BORROW);
        config.setTestOnReturn(JRedisPoolConfig.TEST_ON_RETURN);
        // redis如果设置了密码：
        jedisPool = new JedisPool(config, JRedisPoolConfig.REDIS_IP, JRedisPoolConfig.REDIS_PORT, 10000,
                JRedisPoolConfig.REDIS_PASSWORD);
    }

    public static JedisPool getPool()
    {
        return jedisPool;
    }

    /**
     * 从jedis连接池中获取获取jedis对象
     */
    public static Jedis getJedis()
    {
        return jedisPool.getResource();
    }

    /**
     * 回收jedis
     */
    public static void returnJedis(Jedis jedis)
    {
        if (jedis != null)
            jedisPool.returnResource(jedis);
    }

    /**
     * 设置过期时间
     */
    public static void expire(String key, int seconds)
    {
        if (seconds <= 0)
        {
            return;
        }
        Jedis jedis = getJedis();
        jedis.expire(key, seconds);
        returnJedis(jedis);
    }

    /**
     * 设置默认过期时间
     */
    public static void expire(String key)
    {
        expire(key, expire);
    }

    public static void set(String key, String value)
    {
        if (isBlank(key))
            return;
        Jedis jedis = getJedis();
        jedis.set(key, value);
        returnJedis(jedis);
    }

    public static void set(String key, Object value)
    {
        if (isBlank(key))
            return;
        Jedis jedis = getJedis();
        jedis.set(key.getBytes(), SerializeUtil.serialize(value));
        returnJedis(jedis);
    }

    public static void set(String key, int value)
    {
        if (isBlank(key))
            return;
        set(key, String.valueOf(value));
    }

    public static void set(String key, long value)
    {
        if (isBlank(key))
            return;
        set(key, String.valueOf(value));
    }

    public static void set(String key, float value)
    {
        if (isBlank(key))
            return;
        set(key, String.valueOf(value));
    }

    public static void set(String key, double value)
    {
        if (isBlank(key))
            return;
        set(key, String.valueOf(value));
    }

    public static Float getFloat(String key)
    {
        if (isBlank(key))
            return null;
        return Float.valueOf(getStr(key));
    }

    public static Double getDouble(String key)
    {
        if (isBlank(key))
            return null;
        return Double.valueOf(getStr(key));
    }

    public static Long getLong(String key)
    {
        if (isBlank(key))
            return null;
        return Long.valueOf(getStr(key));
    }

    public static Integer getInt(String key)
    {
        if (isBlank(key))
            return null;
        return Integer.valueOf(getStr(key));
    }

    public static String getStr(String key)
    {
        if (isBlank(key))
            return null;
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        returnJedis(jedis);
        return value;
    }

    public static Object getObj(String key)
    {
        if (isBlank(key))
            return null;
        Jedis jedis = getJedis();
        byte[] bits = jedis.get(key.getBytes());
        Object obj = SerializeUtil.unserialize(bits);
        returnJedis(jedis);
        return obj;
    }

    public static boolean isBlank(String str)
    {
        return str == null || "".equals(str.trim());
    }
}
