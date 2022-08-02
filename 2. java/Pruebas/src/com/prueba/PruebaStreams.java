package com.prueba;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaStreams {
    public static List<String> names = new ArrayList<String>();
    public static  List countries = new ArrayList<String>();

    public static Integer[] numberArray = {4,2,6,9,8,5};

    public void primerEjemploStream(){
        names.add("Andres");
        names.add("Felipe");
        names.add("Juan");
        names.add("Camilo");
        names.add("Sandra");

        names.stream().forEach(System.out::println);
    }

    public void segundoEjemploStream(){
        Stream.of("Argentina", "Colombia", "Urugay","Chile","Brasil").map(country -> country.toUpperCase()).forEach(System.out::println);

    }

    public void tercerEjemploStream(){
        countries = Stream.of("Argentina", "Colombia", "Urugay","Chile","Brasil").map(country -> country.toUpperCase()).collect(Collectors.toList());
        countries.forEach(System.out::println);
    }

    public void cuartoEjemploStream(){

        List<Integer> numbers = Arrays.asList(numberArray);

        numbers.stream().filter(number -> number >= 5 ).forEach(System.out::println);
    }

    public int quintoEjemploStream(){
        List<Integer> numbers = Arrays.asList(numberArray);
        Integer result = numbers.stream().mapToInt(number->number*number).sum();

        return result;
    }


}
