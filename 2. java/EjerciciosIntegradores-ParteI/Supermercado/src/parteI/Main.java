/*
    Autor: Tannia Lucía Hernández Rojas
    Supermercado "El Económico"
    Ejercicio integrador - Parte I
*/

package parteI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Cliente cliente1 = new Cliente(123456, "Pablo", "Monje");
        Cliente cliente2 = new Cliente(789012, "Maria", "Contreras");
        Cliente cliente3 = new Cliente(356890, "Alejandro", "Cumaco");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        //Imprimir la información de cada uno de los clientes
        for(Cliente cliente: clientes){
            System.out.println("DNI: "+cliente.getDni() + " Nombre: "+cliente.getNombre() + " Apellido: "+cliente.getApellido());
        }

        //Eliminar uno de los clientes
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a eliminar");
        long dni = input.nextLong();

         List<Cliente> borrar = clientes.stream()
                .filter(Cliente -> Cliente.getDni()==dni).collect(Collectors.toList());

         if (borrar.size()>0) {
             clientes.remove(borrar.get(0));
         }
         else{
             System.out.println("El cliente con ese DNI no existe");
         }

        //Imprimir la información de los clientes restantes
        for(Cliente cliente: clientes){
            System.out.println("DNI: "+cliente.getDni() + " Nombre: "+cliente.getNombre() + " Apellido: "+cliente.getApellido());
        }

        //Buscar a un cliente
        System.out.println("Ingrese el dni del cliente a consultar");
        long documento = input.nextLong();

        List<Cliente> consultar = clientes.stream()
                .filter(Cliente -> Cliente.getDni()==documento)
                .collect(Collectors.toList());

        if (consultar.size()>0) {
            System.out.println("DNI: "+consultar.get(0).getDni() + " Nombre: "+consultar.get(0).getNombre() + " Apellido: "+consultar.get(0).getApellido());
        }
        else{
            System.out.println("El cliente con ese DNI no existe");
        }

    }
}
