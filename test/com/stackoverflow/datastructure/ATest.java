package com.stackoverflow.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by jonasd on 2016-11-16.
 */
public class ATest {

    private A a;
    @Before
    public void setup() {
        a = new A();
        B b1 = new B();
        C c1 = new C1("first C1");
        C c2 = new C2("first C2");
        C c3 = new C3("first C3");
        b1.cs.add(c1);
        b1.cs.add(c2);
        b1.cs.add(c3);
        B b2 = new B();
        C c4 = new C1("second C1");
        C c5 = new C2("second C2");
        C c6 = new C3("second C3");
        b2.cs.add(c4);
        b2.cs.add(c5);
        b2.cs.add(c6);
        a.bs.add(b1);
        a.bs.add(b2);
    }

    public C2 findFirstC2(A a) {
        for (B b : a.bs) {
            for (C c : b.cs) {
                if (c instanceof C2) {
                    return (C2) c;
                }
            }
        }
        return null;
    }

    public Optional<C2> findStreamFirstC2(A a) {
        return a.bs.stream()
                .flatMap(b -> b.cs.stream())
                .filter(C2.class::isInstance)
                .map(C2.class::cast)
                .findFirst();
    }

    public <P extends Parent,T> Optional<T> findFirst(P parent, Class<T> clazz) {
        Optional<T> first = parent.getChildren().stream()
                .filter(Parent.class::isInstance)
//                .map(o -> findFirst((Parent) o, clazz))
                .flatMap(o -> flatMapOptional(findFirst((Parent) o, clazz)))
                .findFirst();
        if (!first.isPresent()) {
            first = parent.getChildren().stream()
                    .filter(clazz::isInstance)
                    .map(clazz::cast)
                    .findFirst();
        }
        return first;
    }

    private <T> Object flatMapOptional(Optional<T> o) {
        return o.isPresent() ? Stream.of(o.get()) : Stream.empty();
    }


    public <P extends Parent,T> Optional<T> findPredicate(P parent, Class<T> clazz, Predicate<T> predicate) {
        Optional<T> first = parent.getChildren().stream()
                .filter(Parent.class::isInstance)
                .flatMap(o -> flatMapOptional(findPredicate((Parent) o, clazz, predicate)))
                .findFirst();
        if (!first.isPresent()) {
            first = parent.getChildren().stream()
                    .filter(clazz::isInstance)
                    .map(clazz::cast)
                    .filter(predicate)
                    .findFirst();
        }
        return first;
    }

    private Predicate<C2> predicate = new Predicate<C2>() {
        @Override
        public boolean test(C2 obj) {
            return obj.name.contains("second");
        }
    };
    @Test
    public void findFirstC2() {
        assertEquals(true, findFirst(a, C2.class).get().name.equals("first C2"));
        assertEquals(true, Parent.findFirstPredicate(a, C2.class, predicate).get().name.equals("second C2"));
        assertEquals(true, findFirstC2(a).name.equals("first C2"));
        assertEquals(true, findStreamFirstC2(a).get().name.equals("first C2"));
        assertEquals(true, true);
    }

}