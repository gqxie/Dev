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
public class EhcacheUtil
{
    private static Cache<Integer, TUser> myCache;

    private static CacheManager cacheManager;

    public static void init()
    {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build())
                .build(true);

        myCache = cacheManager.createCache("devcache", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Integer.class, TUser.class, ResourcePoolsBuilder.heap(100)).build());
    }

    public static void put(Integer key, TUser value)
    {
        myCache.put(key, value);
    }

    public static TUser get(Integer key)
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
