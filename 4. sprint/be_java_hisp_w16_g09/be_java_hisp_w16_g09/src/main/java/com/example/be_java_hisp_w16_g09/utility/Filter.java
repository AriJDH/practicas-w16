package com.example.be_java_hisp_w16_g09.utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filter<T> {
    public List<T> apply(List<T> objects, Function<T, Boolean> aCondition) {
        return objects.stream().filter(aCondition::apply).collect(Collectors.toList());
    }
}
