package com.epam.training.service;

import com.epam.training.entity.CacheEntry;
import com.epam.training.listener.ListenerImpl;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheServiceGuavaLRU implements CacheService {

    public static final int MAXIMUM_SIZE = 1000;
    public static final int DURATION = 5;
    private Cache<String, CacheEntry> cache;


    {
        cache = CacheBuilder.newBuilder()
                .maximumSize(MAXIMUM_SIZE)
                .expireAfterAccess(DURATION, TimeUnit.SECONDS)
                .removalListener(new ListenerImpl())
                .recordStats()
                .build();
    }


    @Override
    public synchronized void put(String key, CacheEntry value) {
        cache.put(key, value);
    }

    @Override
    public synchronized CacheEntry get(String key) {
        return cache.getIfPresent(key);
    }

}
