package com.epam.training.listener;

import com.google.common.cache.RemovalNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerImpl implements Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);


    @Override
    public void onRemoval(RemovalNotification entry) {
        if (entry.wasEvicted()) {
            LOGGER.info("Value vas removed because: {} ", entry.getCause());
        }
    }

}