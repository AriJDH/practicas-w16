package Turismo.Repositorio;

import Turismo.Entidad.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteRepositorio {

    private static int contadorCliente = 0;
    public static List<Cliente> listaClientes = new ArrayList<>();

    public ClienteRepositorio() {}

    public static Cliente registrarDato(Scanner teclado) {

        ++contadorCliente;
        String nombre, dni;

        System.out.println("Registrar un nuevo cliente");
        System.out.print("Digita el dni de cliente");
        dni = teclado.next();

        System.out.print("Digita el nombre de cliente");
        nombre = teclado.next();

        Cliente cliente =  new Cliente(contadorCliente,dni,nombre);
        listaClientes.add(cliente);
        return cliente;
    }

    public void addToRepositorio() {

    }


    public List<Cliente> listRepositorio() {
        return null;
    }


    public static boolean validarExistencia() {
        return listaClientes.size() > 0;
    }


    public static boolean validarExistencia(int id) {

         return listaClientes.stream()
                 .filter(cliente -> cliente.getId() == id)
                 .count() > 0;
    }

    public static Cliente getCliente(int id){
        return listaClientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .get();
    }


}
