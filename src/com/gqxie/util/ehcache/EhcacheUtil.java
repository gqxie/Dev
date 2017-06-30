package com.gqxie.util.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class EhcacheUtil
{
    private static Cache<Long, String> myCache = null;
    
    private static CacheManager cacheManager = null;

    public static void init()
    {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build())
                .build(true);

        // Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);

        myCache = cacheManager.createCache("devcache", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build());
    }
    public static void put(Long key,String value)
    {
        myCache.put(key, value);
    }
    
    public static String get(Long key)
    {
        return myCache.get(key);
    }
    
    public static void close(){
        cacheManager.close();
    }

}
