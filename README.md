# Dev
近期计划
*   引入ehcache
*   引入spring boot

`cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);`
`CacheConfiguration<String, Integer> cacheConfiguration = CacheConfigurationBuilder`
`.newCacheConfigurationBuilder(String.class, Integer.class, ResourcePoolsBuilder.heap(500000L))`
`.withExpiry(Expirations.timeToLiveExpiration(Duration.of(3600L, TimeUnit.SECONDS)))`
`.build();`
