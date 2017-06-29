# Dev
##从零开始做网站
package com.gqxie.junit.ehcache;

import java.util.concurrent.TimeUnit;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.springframework.util.StringUtils;

/**
 * 
 * <功能详细描述>
 * 
 * @author  xWX353962
 * @version  [版本号, 2017年6月29日]
 * @since  [云服务/模块版本]
 */
public class EhcacheDemo
{
    /**
     * 缓存名
     */
    public static final String CACHE_AUTH_RESOURCE = "helloworld";
    
    private static CacheManager cacheManager = null;
    
    private static Cache<String, Integer> helloCache = null;
    
    public static void main(String[] args)
    {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);
        CacheConfiguration<String, Integer> cacheConfiguration = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(String.class, Integer.class, ResourcePoolsBuilder.heap(500000L))
            .withExpiry(Expirations.timeToLiveExpiration(Duration.of(3600L, TimeUnit.SECONDS)))
            .build();
        helloCache = cacheManager.createCache(CACHE_AUTH_RESOURCE, cacheConfiguration);
    }
    
    /**
     * 从缓存查询
     * 
     * @param cacheName
     * @param key
     * @return
     */
    public static Integer get(String key)
    {
        if (null == helloCache)
        {
            return null;
        }
        Integer value = helloCache.get(key);
        
        return value;
    }
    
    /**
     * 设置缓存
     * 
     * @param cacheName
     * @param key
     * @param value
     */
    public static void set(String key, Integer value)
    {
        // 如果都不为null的话，放入缓存中
        if (!StringUtils.isEmpty(key) && value != null)
        {
            helloCache.put(key, value);
            
        }
    }
    
    public static void close()
    {
        cacheManager.close();
    }
    
    public static CacheManager getCacheManager()
    {
        return cacheManager;
    }
    
}
