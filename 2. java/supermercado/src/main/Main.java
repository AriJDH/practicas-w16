package main;

import supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(3);
        clientes.add(new Cliente("1234567890", "John", "Doe"));
        clientes.add(new Cliente("2345678901", "Jhon", "Doo"));
        clientes.add(new Cliente("3456789012", "Jon", "Do"));
        clientes.forEach(System.out::println);
        System.out.println();

        clientes.remove(1);
        clientes.forEach(System.out::println);
        System.out.println();

        System.out.print("digite dni:\n>>");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();
        Cliente c = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        System.out.println(c);
    }
}
