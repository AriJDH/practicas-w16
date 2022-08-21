package JavaGenericLambdaStream;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo5 {

    public static void main(String[] args) {
        // Ejemplo  5
        System.out.println("\nEjemplo   5");
        Employee employee1 = new Employee(1, "Gonzalo Albertini", "Contabilidad");
        Employee employee2 = new Employee(2, "Mariana Lisoski", "Sistemas");
        Employee employee3 = new Employee(3, "Esteban Gomez", "Sistemas");
        Employee employee4 = new Employee(4, "Amelia Jaciuk", "Administracion");
        Employee employee5 = new Employee(5, "Carlos Perez", "Administracion");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        employees.stream()
                .filter(x -> x.getDepartament().equals("Sistemas"))
                .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
                .forEach(System.out::println);
    }
}
