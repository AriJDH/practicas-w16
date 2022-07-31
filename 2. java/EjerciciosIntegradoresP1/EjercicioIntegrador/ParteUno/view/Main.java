package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.view;

import java.util.List;
import java.util.Scanner;

import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller.*;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Repository<Cliente> repository = new RepositoryClient();
        repository.add(new Cliente("120310304", "Juan", "Perez"));
        repository.add(new Cliente("120310305", "Pedro", "Perez"));
        repository.add(new Cliente("120310306", "Jenny", "Sanchez"));

        List<Cliente> clients = (List<Cliente>) repository.getAll();
        
        clients.forEach(System.out::println);

        repository.delete(new FilterType("dni", "120310305"));

        System.out.println("\n\nAfter delete: \n");
        clients = (List<Cliente>) repository.getAll();
        clients.forEach(System.out::println);

        System.out.println("\n\nSearch cliente by dni: \n");
        String dni = scanner.next();
        Cliente client = repository.get(new FilterType("dni", dni));

        if (client != null) {
            System.out.println(client);
        } else {
            System.out.println("Cliente not found");
        }


    }
}
