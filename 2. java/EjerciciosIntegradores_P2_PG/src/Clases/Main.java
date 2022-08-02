package Clases;

import Interfaces.CRUD;
import Interfaces.ClienteImp;
import Interfaces.FacturaImp;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        ClienteImp clienteImp =  ClienteImp.getInstance();

        clienteImp.save(new Cliente("juan", "1234", "perez"));
        clienteImp.save(new Cliente("Martin", "4567", "gonzales"));
        clienteImp.save(new Cliente("Carla", "8910", "Rodriguez"));

        System.out.println("recorrido y printeo de la lista de clientes");

        clienteImp.mostrarPantalla();

        System.out.println("eliminacion de uno y printeo");
        System.out.println("Ingrese el DNI del cliente que desea eliminar");
        String dniEliminacion = sc.next();
        clienteImp.eliminar(dniEliminacion);
        System.out.println("lista de clientes luego de la compra");
        clienteImp.mostrarPantalla();

        /*
        System.out.println("ingrese el dni de el que desea buscar");
        Scanner sc = new Scanner(System.in);
        String dni = sc.next();

        if(listaClientes.containsKey(dni)){
            System.out.println("la informacion del clientes es:");
            System.out.println(listaClientes.get(dni));
        }else{
            System.out.println("ese cliente no esta ingresado");
        }*/

        System.out.println("testeos factura");
        List<Item> listaItemsFactura= new ArrayList<>();
        listaItemsFactura.add(new Item("1234","item1",2,13));
        listaItemsFactura.add(new Item("2234","item2",1,22));
        listaItemsFactura.add(new Item("12223","item3",3,45));

        Cliente clienteFactura = new Cliente("TestFactura", "8837", "perez");
        Factura testFactura = new Factura(clienteFactura,listaItemsFactura,"123456");
        FacturaImp facturaImp = FacturaImp.getInstance();

        facturaImp.save(testFactura);
        facturaImp.mostrarPantalla();
        clienteImp.mostrarPantalla();

    }
}
