import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creo 3 clientes, los agrego a una lista y los muestro
        Cliente cli1 = new Cliente("Juan", "Perez", 12341238l);
        Cliente cli2 = new Cliente("Pedro", "Perez", 1234567l);
        Cliente cli3 = new Cliente("Juan", "Perez", 123456l);

        ClienteImp clienteImp = new ClienteImp();
        clienteImp.save(cli1);//guardar cliente
        clienteImp.save(cli2);
        clienteImp.save(cli3);

        clienteImp.mostrarPantalla();//mostrar clientes

        //buscar cliente
        System.out.println("Ingrese el DNI del cliente a buscar: ");
        Long dniBuscar = sc.nextLong();
        System.out.println("Cliente encontrado:" + clienteImp.buscar(dniBuscar));

        //borrar el cliente
        System.out.println("Ingrese el DNI del cliente a borrar: ");
        Long dniBorrar = sc.nextLong();
        clienteImp.eliminar(dniBorrar);

        //clientes actualizado despues de borrar
        clienteImp.mostrarPantalla();

        //creo 1 lista de items, la cargo con 2 items q tambien creo, y genero la factura pasandole la lista de items
        List<Item> listaItems = new ArrayList<>();
        Item item1 = new Item("Coca-Cola", 1l, 10.0,2);
        Item item2 = new Item("Pepsi", 2l, 20.0,1);
        listaItems.add(item1);
        listaItems.add(item2);

        Factura factura1 = new Factura(1l, cli1, listaItems);
        System.out.println("Factura 1: " + factura1);

    }
}
