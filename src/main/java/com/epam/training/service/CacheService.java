package com.epam.training.service;

import com.epam.training.entity.CacheEntry;

public interface CacheService {

    void put(String key, CacheEntry value);

    CacheEntry get(String key);

}
