package com.tomas.supermercado;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 01 de Agosto 2022
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Cliente> listaCliente = new ArrayList<>();

        Cliente objClienteUno = new Cliente(10873823, "José", "Trujillo");
        Cliente objClienteDos = new Cliente(890102, "Carlos", "Gonzalez");
        Cliente objClienteTres = new Cliente(19928392, "Sara", "Perez");

        listaCliente.add(objClienteUno);
        listaCliente.add(objClienteDos);
        listaCliente.add(objClienteTres);

        System.out.println("-----Datos de los clientes-----");

        for(Cliente datoCliente: listaCliente) {

            System.out.println(datoCliente.toString());

        }

        System.out.println();
        System.out.println("-----Eliminando un cliente-----");

        boolean clienteExiste = false;
        for(Cliente datoCliente: listaCliente) {

            if(datoCliente.getDni() == 890102) {
                clienteExiste = true;
                listaCliente.remove(datoCliente);
            }

        }

        if(clienteExiste) {
            System.out.println("El cliente fue elimindado");
        } else {
            System.out.println("El cliente no existe y por lo tanto no se ha podido eliminar ningún registro");
        }


        System.out.println();
        System.out.println("-----Datos de los clientes-----");

        for(Cliente datoCliente: listaCliente) {

            System.out.println(datoCliente.toString());

        }

        int dni;
        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("Digite el dni a buscar");
        dni = entrada.nextInt();


        clienteExiste = false;
        for(Cliente datoCliente: listaCliente) {

            if(datoCliente.getDni() == dni) {
                System.out.println(datoCliente.toString());
                clienteExiste = true;
            }

        }

        if(!clienteExiste) {
            System.out.println("El cliente no existe");
        }

    }
}
