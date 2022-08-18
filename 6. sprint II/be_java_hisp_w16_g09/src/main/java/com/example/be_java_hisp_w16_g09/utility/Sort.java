package com.example.be_java_hisp_w16_g09.utility;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Sort {
    private static final String ASCENDANT_SEQUENCE = "asc";
    private static final String DESCENDENT_SEQUENCE = "desc";

    private static Optional<String> directionConsidering(String anOrder, String aField){
        if (anOrder == null) return Optional.empty();

        String[] direction = anOrder.split("_");
        if (direction.length > 1 && direction[0].equals(aField)) {
            return Optional.of(direction[1]);
        }
        return Optional.empty();
    }
    public static Sort orderSequenceBasedOn(String anOrder, String aField) {
        var optionalDirection = directionConsidering(anOrder, aField);
        Sort sort = new NoOrderSequenceSort();

        if (optionalDirection.isPresent()){
            if (optionalDirection.get().equals(ASCENDANT_SEQUENCE)) return new AscendantSort();
            if (optionalDirection.get().equals(DESCENDENT_SEQUENCE)) return new DescendentSort();
        }
        return sort;
    }

    public abstract <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects);

}

class AscendantSort extends Sort {

    @Override
    public <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects) {
        List<T> result = objects;
        result.sort(Comparator.comparing(comparingCondition));
        return result;
    }
}

class DescendentSort extends Sort {
    @Override
    public <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects) {
        List<T> result = objects;
        result.sort(Comparator.comparing(comparingCondition).reversed());
        return result;
    }
}

class NoOrderSequenceSort extends Sort {
    @Override
    public <T, U extends Comparable<? super U>> List<T> sortingBy(Function<? super T, ? extends U> comparingCondition, List<T> objects) {
        return objects;
    }
}