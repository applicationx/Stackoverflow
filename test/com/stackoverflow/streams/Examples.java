package com.stackoverflow.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

public class Examples {

    private List<String> stringList;
    private List<User> userList;

    public class User {
        private final String name;
        private final int age;

        public User(String name, int age) {

            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    @Before
    public void setUp() {
        stringList = Arrays.asList("Jonas", "Lars", "Veronica", "Marie", "Elliot", "Sven", "Dämfors");
        userList = Arrays.asList(new User("Jonas", 38), new User("Lars", 38), new User("Veronica", 39), new User("Marie", 39), new User("Elliot", 1), new User("Sven", 1));
    }

    @Test
    public void testFilter() throws Exception {
        assertEquals(3, stringList.stream().filter(s -> s.endsWith("s")).count());
    }

    @Test
    public void testMap() throws Exception {
        stringList.stream().map(e -> {
            StringBuilder sb = new StringBuilder(e.length());
            char[] chars = e.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            return sb.toString();

        }).collect(toList()).forEach(s -> System.out.println(s));
    }

    @Test
    public void testReduce() throws Exception {
        System.out.println(stringList.stream().reduce((joined, part) -> joined + " " + part).get());
    }

    @Test
    public void testPredicate() throws Exception {
        Predicate<String> firstPredicate = (s) -> s.length()>4;
        Predicate<String> secondPredicate = (s) -> s.endsWith("s");

        System.out.println(stringList.stream().filter(firstPredicate.and(secondPredicate)).collect(toList()));
    }

    @Test
    public void testSort() throws Exception {
        System.out.println(stringList.stream().sorted().collect(toList()));
    }

    @Test
    public void testGrouping() throws Exception {
        Map<Integer, List<User>> ageList = userList.stream().collect(groupingBy(u -> u.getAge()));
        for (Map.Entry<Integer, List<User>> entry : ageList.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("================");
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }

    }
}
