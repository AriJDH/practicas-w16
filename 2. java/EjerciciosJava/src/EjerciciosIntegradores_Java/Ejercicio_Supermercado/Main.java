package EjerciciosIntegradores_Java.Ejercicio_Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Parte 1
        //Punto B
        Cliente cli1 = new Cliente("41715987", "Lucas", "Abbiatici");
        Cliente cli2 = new Cliente("20203080", "Mariel", "Martinez");
        Cliente cli3 = new Cliente("41715986", "Tomás", "Abbiatici");
        List<Cliente> listaClientes = new ArrayList<>(List.of(cli1, cli2, cli3));

        //Punto C
        listaClientes.stream().forEach(System.out::println);

        System.out.println("-------------------------------");

        //Punto D
        listaClientes.remove(2);
        listaClientes.stream().forEach(System.out::println);

        System.out.println("-------------------------------");

        //Punto E
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el dni de un cliente: ");
        String dni = scan.nextLine();
        scan.close();

        List<Cliente> listaDni = listaClientes.stream().filter(cliente -> cliente.getDni().equals(dni)).collect(Collectors.toList());

        if(listaDni.size() == 0)
            System.out.println("No se encuentra registrado un cliente con ese DNI");
        else
            System.out.println(listaDni);

        System.out.println("-------------------------------");

        //Parte 2
        Item item1 = new Item("123", "Bananas", 5, 50.0);
        Item item2 = new Item("456", "Manzanas", 10, 40.0);
        Item item3 = new Item("789", "Jugos", 2, 150.0);
        List<Item> listaItems = new ArrayList<>(List.of(item1, item2, item3));

        Factura factura1 = new Factura(cli1, listaItems);
        Factura factura2 = new Factura(cli3, listaItems);

        List<Factura> listaFacturas = new ArrayList<>();

        System.out.println("Intento agregar factura con cliente 1");
        if(listaClientes.contains(factura1.getCliente())){
            listaFacturas.add(factura1);
            System.out.println("Factura agregada correctamente");
        } else {
            System.out.println("El cliente no existe en la base de datos.");
        }

        System.out.println("-------------------------------");

        System.out.println("Intento agregar factura con cliente 3");
        if(listaClientes.contains(factura2.getCliente())){
            listaFacturas.add(factura2);
            System.out.println("Factura agregada correctamente");
        } else {
            System.out.println("El cliente no existe en la base de datos.");
        }

        System.out.println("-------------------------------");

        System.out.println(listaFacturas);

    }
}
