package com.epam.training.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyUtil {

    public static final int FIRST_MENTION = 1;
    private static Map<String, Integer> frequencyMap = new HashMap<>();

    public static void increaseFrequency(String key) {
        if (frequencyMap.containsKey(key)) {
            int frequency = frequencyMap.get(key);
            frequencyMap.put(key, ++frequency);
        } else {
            frequencyMap.put(key, FIRST_MENTION);
        }


    }

//
//    public static int getFrequency(String key) {
//        return frequencyMap.get(key);
//    }

    public static String getMinFreqKey() {

        if (frequencyMap.isEmpty()) {
            throw new NullPointerException("cache is empty");
        }
        Map<String, Integer> sortedMap = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap.keySet().iterator().next();
    }


}
