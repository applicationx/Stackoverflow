package com.stackoverflow.wordcount;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class EntityCounterTest {

    @Test
    public void testGetCount() throws Exception {
        List<String> listOfWords = Arrays.asList("Jonas", "Lars", "Jonas");
        EntityCounter<String> entityCounter = new EntityCounter<>();
        Map<String, Integer> stringMap = entityCounter.getCount(listOfWords);
        assertEquals(2, stringMap.size());
        assertEquals(2,stringMap.get("Jonas").intValue());
        assertEquals(1,stringMap.get("Lars").intValue());
        assertEquals(null ,stringMap.get("Kungen"));

    }
}