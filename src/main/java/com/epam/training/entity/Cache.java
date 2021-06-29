package com.epam.training.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {


    private volatile Map<String, CacheEntry> cache;
    private volatile static Cache instance;

    private Cache() {
        cache = new ConcurrentHashMap<>();
    }

    public Map<String, CacheEntry> getCache() {
        return cache;
    }

    public void setCache(String key, String value) {
        cache.put(key, new CacheEntry(value));
    }

    public static Cache getInstance() {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }

}
