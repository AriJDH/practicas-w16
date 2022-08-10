package main;

import clases.Cliente;
import clases.Factura;
import clases.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static List<Cliente> listaClientes = new ArrayList<>();
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Facundo", "Díaz", "12345678");
        Cliente cliente2 = new Cliente("Guillermo", "Bariani", "78787878");
        Cliente cliente3 = new Cliente("Raul", "Tato", "45454545");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        listaClientes.forEach(System.out::println);
        listaClientes.remove(0);
        listaClientes.forEach(System.out::println);

        Scanner teclado = new Scanner(System.in);
        System.out.print("Buscar cliente por DNI: ");
        String dni = teclado.next();
        Cliente c = buscarCliente(dni);
        if(c == null){
            System.out.println("No existe el cliente");
        }
        else{
            System.out.println(c);
        }

        //Crear factura
        List<Item> listaItems = new ArrayList<>(Arrays.asList(
                new Item("COD123", "Item 1", 2, 10.5),
                new Item("COD222", "Item 2", 4, 23),
                new Item("COD333", "Item 3", 7, 42.1)
        ));
        Factura factura = new Factura(c, listaItems);

        System.out.println(factura);
    }

    public static Cliente buscarCliente(String dni){
        Cliente cliente = null;
        for (Cliente c : listaClientes){
            if (c.getDni().equals(dni)){
                cliente = c;
            }
        }
        return cliente;
    }
}
