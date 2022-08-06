package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1000,"Luis","Perez"));
        clientes.add(new Cliente(1001,"Susana","Mejia"));
        clientes.add(new Cliente(1002,"Carolina","Tapia"));

        CrudCliente crudCliente = new CrudCliente(clientes);

        System.out.println("listar clientes");
        System.out.println(crudCliente.listar());

        //Eliminar cliente
        crudCliente.eliminarPorDni(1002);

        System.out.println("nueva lista de clientes");
        System.out.println(crudCliente.listar());


        Scanner escaner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a buscar");
        int dni = escaner.nextInt();
        crudCliente.encontrarPorDni(dni);
        escaner.close();

    }

}
