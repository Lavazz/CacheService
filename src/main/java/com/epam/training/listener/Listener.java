package com.epam.training.listener;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public interface Listener<K, V> extends RemovalListener<K, V> {

    void onRemoval(RemovalNotification entry);

}
