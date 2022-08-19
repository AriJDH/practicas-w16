package com.example.be_java_hisp_w16_g09_Nicoletta.utility.sort;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class AscendantSort extends Sort {

    @Override
    protected boolean canHandle(String anOrder, String aField) {
        return isMatching(anOrder, aField, "asc");
    }

    @Override
    public <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects) {
        List<T> result = objects;
        result.sort(Comparator.comparing(comparingCondition));
        return result;
    }
}
