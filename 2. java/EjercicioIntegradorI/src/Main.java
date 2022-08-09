import clases.Cliente;
import clases.Factura;
import clases.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("123", "Juan", "Espitia"));
        clientes.add(new Cliente("124", "Ivan", "Montoya"));
        clientes.add(new Cliente("125", "Mabel", "Ramirez"));

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni del usuario");
        String dni = teclado.next();

        boolean rta = false;
        Cliente clienteFac = new Cliente();
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                System.out.println(c.toString());
                rta = true;
                clienteFac=c;
                break;

            }
        }

        if (rta == true) {

        }else{
            System.out.println("cliente no encontrado");
            System.out.println("ingrese dni");
            String dniNuevo= teclado.next();
            System.out.println("ingrese nombre");
            String nombre = teclado.next();
            System.out.println("ingrese apellido");
            String apellido = teclado.next();
            Cliente clienteNuevo =new Cliente(dniNuevo,nombre,apellido);
            clienteFac=clienteNuevo;
            clientes.add(clienteNuevo);
        }


        List<Item> listaItems = new ArrayList<>();
        listaItems.add(new Item("I01","LECHE",2,200));
        listaItems.add(new Item("I02","ARROZ",4,300));
        listaItems.add(new Item("I03","HUEVOS",30,40));
        listaItems.add(new Item("I04","SAL",3,150));
        double totalCompra=0;
        for (Item item: listaItems) {
            totalCompra = totalCompra+(item.getCostoUnitario()*item.getCantidadComprada());
        }

        Factura factura = new Factura(1,clienteFac,listaItems,totalCompra);

        System.out.println(factura.toString());

    }
}
