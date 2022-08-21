package JavaGenericLambdaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //  Ejemplo 1
        System.out.println("Ejemplo     1");
        Stream.of("Argentina", "Colombia", "Uruguay", "Chile", "Brazil")
                .map(country -> country.toUpperCase())
                .forEach(System.out::println);
        // Ejemplo  2
        System.out.println("\nEjemplo   2");
        List<String> countries = Stream.of("Argentina", "Colombia", "Uruguay", "Chile", "Brazil")
                .map(country -> country.toUpperCase())
                .collect(Collectors.toList());

        countries.forEach(System.out::println);

        // Ejemplo  3
        System.out.println("\nEjemplo   3");
        Integer[] numberArray = {4, 2, 6, 9, 8, 5};

        List<Integer> numbers = Arrays.asList(numberArray);
        numbers.stream()
                //.filter(number -> number >= 5)
                .sorted((x, y) -> x.compareTo(y.intValue()))
                .forEach(System.out::println);

        // Ejemplo  4
        System.out.println("\nEjemplo   4");
        Integer result = numbers.stream()
                .mapToInt(number -> number * number)
                .sum();
        System.out.println(result);
    }
}
