package Supermercado;

import java.util.*;

public class Parte2 {
    public static void main(String[] args) {
        // TODO Crear nueva factura
        // TODO Antes de agregar una factura,
        //  Validar si el cliente asociado a la factura existe en la collection. If not, crearlo
        //  Crear lista de items y asociarla a la factura creada
        //  Calcular el total (ya está hecho en el diseño de mi clase).

        // Crear clientes:
        Cliente cliente1 = new Cliente(93998432,"Julio", "Vargas");
        Cliente cliente2 = new Cliente(44483821,"Martina");
        Cliente cliente3 = new Cliente(33222526, "Gabriel");
        Cliente cliente4 = new Cliente(11133322, "Cloé");

        // Crear lista de clientes:
        Set<Cliente> clientes = new HashSet<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Imprimir lista de clientes:
        System.out.println("Collection de clientes:");
        clientes.forEach(System.out::println);


        // Crear factura del cliente 4 y agregarlo de ser necesario
        ArrayList<Item> items = new ArrayList<>(Arrays.asList(
                new Item(11,"Leche",2,249.99),
                new Item(12,"Papa (Bolsa 1Kg)",3,209.99),
                new Item(13, "Manteca", 1,435.49)
        ));
        Factura factura = new Factura(cliente4, items);

        for (Cliente cli : clientes) {
            if(!factura.getCliente().getDni().equals(cli.getDni())) {
                clientes.add(factura.getCliente());
                break;
            }
        }

        // Imprimir factura:
        System.out.println("Factura:\n" + factura);
        // Imprimir nuevamente la lista
        System.out.println("Collection de clientes:");
        clientes.forEach(System.out::println);

        // TODO BONUS:
        //  Crear interfaz CRUD que contenga, mediante genericos, todos los metodos necesarios para
        //  realizar altas, bajas, modificaciones, y consultas.
        //  Crear o utilizar las correspondientes clases que sean capaces de implementar los metodos
        //  de la interfaz CRUD.
        //  TODO despues: Modificar el main para que en lugar de realizar todo el código de manera secuencial
        //   se pueda modularizar mediante el llamado de métodos.
    }
}
