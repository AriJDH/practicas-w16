package supermercadoElEconomico;

import java.util.*;

/*
 * Ejercicio > Modulo 5: Java > EjerciciosIntegradores-P1-PG
 * ESTADO: Finalizado (falta revisión) / Sigue...
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        // Crear el modelo de clases.

        // Crear 3 clientes y guardarlos en una coleccion (se hara en una lista)
        Cliente gonzalo = new Cliente("12.345.678", "Gonzalo Nahuel", "Di Pierro");
        Cliente juan = new Cliente("11.111.111", "Juan", "Perez");
        Cliente jose = new Cliente("22.222.222", "Jose", "Gomez");

        List<Cliente> listaDeClientes = new ArrayList();
        listaDeClientes.add(gonzalo);
        listaDeClientes.add(juan);
        listaDeClientes.add(jose);

        // Recorrer la coleccion de clientes y mostrar los datos de cada uno
        //listaDeClientes.stream().forEach(System.out::println);

        // Eliminar un cliente de la lista y volver a mostrar los datos de los clientes restantes
        //listaDeClientes.remove(listaDeClientes.size() - 1);
        //listaDeClientes.stream().forEach(System.out::println);

        // Solicitar por teclado un numero de DNI de un cliente para buscarlo
        Scanner scanner = new Scanner(System.in);
        System.out.println("- Ingrese el DNI del cliente a buscar:");
        String dniABuscar = scanner.next();
        Cliente clienteEncontrado;
        try{
            clienteEncontrado = listaDeClientes.stream().filter((cliente) -> cliente.getDni().equals(dniABuscar)).findFirst().get();
        }catch(NoSuchElementException ex){
            clienteEncontrado = null;
        }

        System.out.println("\nRESULTADO");
        System.out.println("> " + (clienteEncontrado != null ? clienteEncontrado : "No hay un cliente con el DNI insertado."));
    }
}
