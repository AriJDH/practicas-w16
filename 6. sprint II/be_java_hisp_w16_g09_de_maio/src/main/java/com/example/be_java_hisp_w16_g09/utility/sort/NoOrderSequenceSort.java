package com.example.be_java_hisp_w16_g09.utility.sort;

import java.util.List;
import java.util.function.Function;

class NoOrderSequenceSort extends Sort {
    @Override
    protected boolean canHandle(String anOrder, String aField) {
        return anOrder == null;
    }

    @Override
    public <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects) {
        return objects;
    }
}
