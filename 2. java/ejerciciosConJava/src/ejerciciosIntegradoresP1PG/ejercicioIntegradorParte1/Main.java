package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente(1000,"Luis","Perez");
        clientes.add(cliente);
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


        //items
        List<Item> items = new ArrayList<>();
        items.add(new Item(123,"Chocolate",1,15));
        items.add(new Item(1256,"Barra de amaranto",2,10));

        CrudItem crudItem = new CrudItem(items);
        double total=crudItem.totalPrecio();

        Cliente cliente1 = new Cliente(1003,"Linn","Sanchez");
        //crear factura
        List<Factura> facturas = new ArrayList<>();
        Factura factura1 = new Factura(1,cliente1,items,total);


        CrudFactura crudFactura = new CrudFactura(facturas);
        if(crudCliente.encontrarPorDni(factura1.getCliente().getDni())){
            facturas.add(factura1);
            System.out.println("El cliente se encontro en la lista y se creo su factura");
        }else{
            crudCliente.crear(factura1.getCliente());
            facturas.add(factura1);
            System.out.println("El cliente se añadio a la lista y se creo su factura");
        }

        System.out.println("listar clientes");
        System.out.println(crudCliente.listar());

        System.out.println(crudFactura.listar());
        System.out.println("encontrando factura");
        crudFactura.encontrarPorDni(1);
    }

}
