package com.stackoverflow.datastructure;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Parent<T> {

    List<T> getChildren();

    static <T> Object streamUnwrapOptional(Optional<T> o) {
        return o.isPresent() ? Stream.of(o.get()) : Stream.empty();
    }

    static <P extends Parent, T> Optional<T> findFirstPredicate(P parent, Class<T> clazz, Predicate<T> predicate) {
        Optional<T> first = parent.getChildren().stream()
                .filter(Parent.class::isInstance)
                .flatMap(o -> streamUnwrapOptional(findFirstPredicate((Parent) o, clazz, predicate)))
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
}
