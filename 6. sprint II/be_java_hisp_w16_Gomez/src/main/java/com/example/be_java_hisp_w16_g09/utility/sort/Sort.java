package com.example.be_java_hisp_w16_g09.utility.sort;
import com.example.be_java_hisp_w16_g09.dto.exception.OrderNotExist;

import java.util.List;
import java.util.function.Function;

public abstract class Sort {

    public static Sort orderSequenceBasedOn(String anOrder, String aField) {
        Sort sorter =
                subclasses()
                        .stream()
                        .filter(sortingClass -> sortingClass.canHandle(anOrder, aField))
                        .findFirst()
                        .orElseThrow(() -> new OrderNotExist());
        return sorter;
    }

    protected abstract boolean canHandle(String anOrder, String aField);

    private static List<Sort> subclasses() {
        return List.of(new NoOrderSequenceSort(), new AscendantSort(), new DescendentSort());
    }
    protected Boolean isMatching(String anOrder, String aField, String aDirection) {
        return anOrder != null
                && anOrder.split("_").length > 1
                && (anOrder.split("_")[0].equals(aField) && anOrder.split("_")[1].equals(aDirection));
    }

    public abstract <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects);

}

