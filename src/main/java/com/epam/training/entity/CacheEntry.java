package com.epam.training.entity;

public class CacheEntry {

    private String value;


    public CacheEntry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
