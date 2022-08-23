import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaYStreams {
    public static void main(String[] args) {

//Ejemplo 1
        Stream.of("Argentina, Colombia, Uruguay, Chile, Brasil")
                .map(country -> country.toUpperCase())
                .forEach(System.out::println);

//Ejemplo 2

        List<String> countries = Stream.of("Argentina, Colombia, Uruguay, Chile, Brasil")
                .map(country -> country.toUpperCase())
                .collect(Collectors.toList());
        countries.forEach(System.out::println);

//Ejemplo3

        Integer[] numberArray = {4, 2, 6, 9, 8, 5};

        List<Integer> numberList = Arrays.asList(numberArray);
        numberList.stream().filter(n -> n > 3).forEach(System.out::println);

//Ejemplo 4
        Integer resultSum = numberList.stream().mapToInt(n -> n * n).sum();
        System.out.println(resultSum);

        Employee employee1 = new Employee(1, "Gonzalo Albertini", "Contabilidad" );
        Employee employee2 = new Employee(2, "Mariana Lisoski", "Sistemas" );
        Employee employee3 = new Employee(3, "Esteban Gomez", "Sistemas" );
        Employee employee4 = new Employee(4, "Amelia Jaciuk", "Administracion" );
        Employee employee5 = new Employee(5, "Carlos Perez", "Administracion" );

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        employees.stream().filter(x-> x.getDepartment().equals("Sistemas"))
                .sorted((x,y)-> x.getName().compareToIgnoreCase(y.getName()))
                .forEach(System.out::println);
    }



}
