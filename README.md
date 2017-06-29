# Dev
##从零开始做网站

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
    

    public static Integer get(String key)
    {
        if (null == helloCache)
        {
            return null;
        }
        Integer value = helloCache.get(key);
        
        return value;
    }
    

    public static void set(String key, Integer value)
    {

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
