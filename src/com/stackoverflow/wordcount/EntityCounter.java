package com.stackoverflow.wordcount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityCounter<T> {


    public Map<T, Integer> getCount(List<T> entityList) {
        HashMap<T, Integer> counterMap = new HashMap();
        for (T entity : entityList) {
            Integer i = counterMap.getOrDefault(entity, 0);
            counterMap.put(entity, ++i);
        }
        return counterMap;
    }
}
