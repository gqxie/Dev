package com.gqxie.util.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import com.gqxie.entity.User;

/**
 * @author gqxie
 */
public class EhcacheUtil
{
    private static Cache<Long, User> myCache;

    private static CacheManager cacheManager;

    public static void init()
    {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build())
                .build(true);

        myCache = cacheManager.createCache("devcache", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, User.class, ResourcePoolsBuilder.heap(100)).build());
    }

    public static void put(Long key, User value)
    {
        myCache.put(key, value);
    }

    public static User get(Long key)
    {
        return myCache.get(key);
    }

    public static void close()
    {
        cacheManager.close();
    }

    private EhcacheUtil()
    {

    }

}
