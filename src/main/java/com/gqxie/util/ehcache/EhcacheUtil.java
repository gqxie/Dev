package com.gqxie.util.ehcache;

import com.gqxie.entity.TUser;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import javax.xml.registry.infomodel.User;

/**
 * 缓存
 *
 * @author gqxie
 */
public final class EhcacheUtil
{
    private static Cache<String, Object> myCache;

    private static CacheManager cacheManager;

    private static volatile EhcacheUtil ehcacheUtil;

    public static EhcacheUtil getInstance()
    {
        if (null == ehcacheUtil)
        {
            synchronized (EhcacheUtil.class)
            {
                if (null == ehcacheUtil)
                {
                    ehcacheUtil = new EhcacheUtil();
                    init();
                }
            }
        }
        return ehcacheUtil;
    }

    private static void init()
    {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build())
                .build(true);

        myCache = cacheManager.createCache("devcache", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(100)).build());
    }

    public void put(String key, Object value)
    {
        myCache.put(key, value);
    }

    public Object get(String key)
    {
        return myCache.get(key);
    }

    public void close()
    {
        cacheManager.close();
    }

    private EhcacheUtil()
    {

    }

}
