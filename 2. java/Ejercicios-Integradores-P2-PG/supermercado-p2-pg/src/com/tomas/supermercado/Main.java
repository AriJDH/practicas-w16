package com.tomas.supermercado;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 01 de Agosto 2022
 */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ClienteImplementacion objClienteImp = new ClienteImplementacion();

        Cliente objClienteUno = new Cliente(10873823, "José", "Trujillo");
        Cliente objClienteDos = new Cliente(890102, "Carlos", "Gonzalez");
        Cliente objClienteTres = new Cliente(19928392, "Sara", "Perez");

        objClienteImp.guardar(objClienteUno);
        objClienteImp.guardar(objClienteDos);
        objClienteImp.guardar(objClienteTres);

        System.out.println("-----Datos de los clientes-----");

        objClienteImp.mostrarDatos();

        System.out.println();
        System.out.println("-----Eliminando un cliente-----");

        objClienteImp.eliminar(890102);


        int dni;
        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("Digite el dni a buscar");
        dni = entrada.nextInt();
        objClienteImp.buscar(dni);




    }
}
