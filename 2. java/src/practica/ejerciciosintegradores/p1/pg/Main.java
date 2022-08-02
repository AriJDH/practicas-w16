package practica.ejerciciosintegradores.p1.pg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente clienteUno = new Cliente(12345, "Juan", "Perez");
        Cliente clienteDos = new Cliente(54321, "Jose", "Gonzalez");
        Cliente clienteTres = new Cliente(13579, "Mauricio", "Cabrera");

        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(clienteUno, clienteDos, clienteTres));

        mostrarClientes(clientes);
        clientes.remove(2);
        mostrarClientes(clientes);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un dni para buscar un cliente:");
        int dni = sc.nextInt();
        try {
            System.out.println("El cliente que ha solicitado es: " + clientes.get(dni));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void mostrarClientes(ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
