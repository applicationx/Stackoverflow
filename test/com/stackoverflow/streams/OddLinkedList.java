package com.stackoverflow.streams;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ECO Design IT
 * Created by jonasd on 2016-07-24.
 */
public class OddLinkedList {

    @Test
    public void testOdds() {
        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(10);

        integerList.stream().filter((i) -> i % 2 == 1).collect(Collectors.toCollection(LinkedList::new));
    }
}
