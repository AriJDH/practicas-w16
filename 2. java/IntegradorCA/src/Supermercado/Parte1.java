package Supermercado;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Parte1 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(93998432,"Julio", "Vargas");
        Cliente cliente2 = new Cliente(44483821,"Martina");
        Cliente cliente3 = new Cliente(33222526, "Cloé");

        /////
        Set<Cliente> clientes = new HashSet<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        /////
        System.out.println("Collection de clientes:");
        clientes.forEach(System.out::println);

        /////
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresar DNI que desea eliminar: ");
        Integer dniBuscado = input.nextInt();

        boolean borrado = false;
        System.out.println("Eliminando cliente...");
        for (Cliente cliente : clientes) {
            if(cliente.getDni().equals(dniBuscado)) {
                clientes.remove(cliente);
                borrado = true;
                break;
            }
        }
        if(borrado)
            System.out.println("Cliente Eliminado");
        else System.out.println("No se encontró el DNI buscado.");

        /////
        System.out.println("Collection de clientes:");
        clientes.forEach(System.out::println);

        /////
        System.out.println("Ingresar DNI que desea buscar: ");
        dniBuscado = input.nextInt();
        boolean encontrado = false;
        System.out.println("Buscando cliente...");
        for (Cliente cliente : clientes) {
            if(cliente.getDni().equals(dniBuscado)) {
                System.out.println("Cliente encontrado:");
                System.out.println(cliente);
                encontrado = true;
                break;
            }
        }
        if(!encontrado)
            System.out.println("No se encontró el DNI buscado.");
    }
}
