package poo.supermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static List<Cliente> listaDeClientes = new ArrayList<>();
    private static String dni;

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("1111", "Rodriguez", "Juan");
        Cliente cliente2 = new Cliente("2222", "Perez", "Gabriel");
        Cliente cliente3 = new Cliente("3333", "Martinez", "Jose");
        Cliente cliente4 = new Cliente("4444", "Barboza", "Milu");


        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeClientes.add(cliente3);
        listaDeClientes.add(cliente4);

        ItemFactura item1 = new ItemFactura(003345L, "arroz", 2, 200);
        ItemFactura item2 = new ItemFactura(000002L, "fideos", 3, 600);
        ItemFactura item3 = new ItemFactura(023456L, "harina", 1, 200);

        Factura factura1 = new Factura(cliente1);
        factura1.agregarItem(item1);
        factura1.agregarItem(item2);
        factura1.agregarItem(item3);

        Factura factura3 = new Factura(cliente3);
        factura3.agregarItem(item2);

        System.out.println("Lista de clientes: ");
        listaDeClientes.forEach(System.out::println);

        System.out.println("Ingrese dni para buscar cliente: ");
        dni = sc.nextLine();
        buscarClientePorDni();

        System.out.println("Ingrese dni para borrar cliente: ");
        dni = sc.nextLine();
        borrarClientePorDni();

        System.out.println("Lista de clientes: ");
        listaDeClientes.forEach(System.out::println);
    }

    private static void borrarClientePorDni() {
        Cliente clienteEncontrado = buscar();

        if (clienteEncontrado != null) {
            listaDeClientes.remove(clienteEncontrado);
            System.out.println("El cliente ha sido borrado");
        } else System.out.println("El cliente con dni " + dni + " no existe");
    }

    private static void buscarClientePorDni() {
        Cliente clienteEncontrado = buscar();

        if (clienteEncontrado != null)
            System.out.println("El cliente buscado es : " + clienteEncontrado);
        else
            System.out.println("El cliente con dni " + dni + " no existe");
    }

    private static Cliente buscar() {
        return listaDeClientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findAny()
                .orElse(null);
    }

}
