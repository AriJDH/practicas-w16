package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.view;

import java.util.List;
import java.util.Scanner;

import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteDos.RepositoryInvoice;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteDos.RepositoryProduct;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller.*;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Repository<Factura> repositoryFactura = new RepositoryInvoice();
        Repository<Item> repositoryItem = new RepositoryProduct();
        Repository<Cliente> repository = new RepositoryClient();

        repository.add(new Cliente("120310304", "Juan", "Perez"));
        repository.add(new Cliente("120310305", "Pedro", "Perez"));
        repository.add(new Cliente("120310306", "Jenny", "Sanchez"));

        List<Cliente> clients = (List<Cliente>) repository.getAll();
        
        clients.forEach(System.out::println);

        boolean deleted = repository.delete(new FilterType("dni", "120310305"));

        if (deleted) {
            System.out.println("\nCliente eliminado");
        } else {
            System.out.println("\nCliente no encontrado");
        }

        System.out.println("\n");
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

        Factura factura = new Factura();
        repositoryFactura.add(factura);

        Cliente cliente = new Cliente("113010425", "Maria", "Mojica");
        Cliente response = repository.get(cliente);

        if(response == null) { //Adding Cliente to Repository
            repository.add(cliente);
        }
        
        factura.setCliente(cliente);

        //Addiing Items to local repository
        repositoryItem.add(new Item("1", "Producto 1", 10, 2));
        repositoryItem.add(new Item("2", "Producto 2", 20, 3));
        repositoryItem.add(new Item("3", "Producto 3", 30, 4));

        //Adding Items to Factura
        factura.setItems((List<Item>) repositoryItem.getAll());

        //Printing Factura
        System.out.println("Total factura: " + factura.getTotal());
        
    }
}
