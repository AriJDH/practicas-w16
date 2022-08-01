package main;

import supermercado.Cliente;
import supermercado.Factura;
import supermercado.Item;
import supermercado.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supermercado sm = new Supermercado();
        Cliente cliente1 = new Cliente("1234567890", "John", "Doe");
        sm.agregarCliente(cliente1);
        sm.agregarCliente(new Cliente("2345678901", "Jhon", "Doo"));
        sm.agregarCliente(new Cliente("3456789012", "Jon", "Do"));
        sm.getClientes().forEach(System.out::println);

        System.out.print("digite dni:\n>>");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();
        Cliente c = sm.getClientes().stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        System.out.println(c);

        List<Item> items = new ArrayList<>(3);
        items.add(new Item("123456", "Jabón", 2, 10));
        items.add(new Item("987654", "jamón", 1, 50));
        Factura f = sm.crearFactura(cliente1, items);
        System.out.println(f);
    }
}
