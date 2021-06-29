package com.epam.training.service;

import com.epam.training.entity.Cache;
import com.epam.training.entity.CacheEntry;
import com.epam.training.util.FrequencyUtil;

import java.util.Map;

public class CacheServiceLFU implements CacheService {


    private Map<String, CacheEntry> cache;
    private final int maxSize;


    public CacheServiceLFU(int maxSize) {
        this.cache = Cache.getInstance().getCache();
        this.maxSize = maxSize;
    }


    @Override
    public synchronized void put(String key, CacheEntry value) {
        if (key == null || value == null) {
            throw new NullPointerException("Value must not be null");
        }

        if (cache.size() == maxSize) {
            cache.remove(FrequencyUtil.getMinFreqKey());
        }
        cache.put(key, value);
        FrequencyUtil.increaseFrequency(key);
    }


    @Override
    public synchronized CacheEntry get(String key) {
        CacheEntry value = cache.get(key);
        if (value != null) {
            FrequencyUtil.increaseFrequency(key);
        }
        return value;

    }

}
