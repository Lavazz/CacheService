package com.epam.training.service;

import com.epam.training.entity.Cache;
import com.epam.training.entity.CacheEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CacheServiceGuavaLRUTest {

    public static final int MAX_SIZE = 100000;
    CacheService serviceLFU = new CacheServiceLFU(MAX_SIZE);
    private Cache cache=Cache.getInstance();
    private Map<String, CacheEntry> cacheMAp=cache.getCache();

    @Before
    public void init(){
        cache.setCache("key", "value");
    }


    @Test
    public void put() {
        serviceLFU.put("key1", new CacheEntry("value1"));
        Assert.assertEquals(serviceLFU.get("key1").getValue(), new CacheEntry("value1").getValue());
    }

    @Test
    public void get() {
        Assert.assertEquals( serviceLFU.get("key").getValue(), "value");
    }
}