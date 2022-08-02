package practicesIntegrator1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Client client = new Client();
    static Invoce invoce = new Invoce();
    static RepositoryClient clientRepository = new RepositoryClient(client);
    static RepositoryInvoce invoceRepository = new RepositoryInvoce(invoce);

    public static void main(String[] args) {

        // Crear clientes
        Main.createClients();

        // Listar clientes
        Main.listClients();

        // Eliminar Clientes y listar los nuevos
        Main.delelteClients();

        // Consultar por dni un cliente
        Main.consultBydniClient();

        // Crear una factura
        Main.createInvoce();

        // Actualizar factura
        Main.updateInvoce();

        // Eliminar factura
        Main.delelteInvoce();
    }

    public static void createClients() {
        System.out.println("-----------------Crear clientes-------------------");
        Client pepe = new Client("123","Pepe","Garcia");
        Client jacinta = new Client("456", "Jacinta", "Cano");
        Client pacha = new Client("789", "Pacha", "Ramirez");

        clientRepository.create(pepe);
        clientRepository.create(jacinta);
        clientRepository.create(pacha);
        System.out.println("---------------------------------------------------");
    }

    public static void listClients() {
        System.out.println("----------------Listar clientes--------------------");
        client.getDbClients().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
    }

    public static void delelteClients() {
        System.out.println("-------Eliminar uno y listar clientes nuevos--------");
        Client pacha = new Client("789", "Pacha", "Ramirez");
        clientRepository.delete(pacha);
        client.getDbClients().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
    }

    public static void consultBydniClient() {
        System.out.println("----------------------------------------------------");
        System.out.println("-----------------Consultar por dni------------------");
        System.out.println("Ingrese un dni a consultar: ");
        String dni = sc.next();
        clientRepository.consultByDni(dni);
        System.out.println("----------------------------------------------------");
    }

    public static void createInvoce() {
        System.out.println("----------------------------------------------------");
        System.out.println("-----------------Crear una factura------------------");
        Item item1 = new Item("DAQ12", "Arroz", 2, 10000);
        Item item2 = new Item("DAQ13", "Frijol", 1, 3000);
        Item item3 = new Item("DAQ14", "Pollo", 2, 20000);
        Item item4 = new Item("DAQ15", "Leche", 2, 25000);
        List<Item> lisItems = new ArrayList<>(Arrays.asList(item1, item2, item3, item4));
        Client juan = new Client("68393", "Juan", "Gomez");
        Invoce invoce1 = new Invoce(juan, lisItems);
        invoceRepository.create(invoce1);

        System.out.println("----------------------------------------------------");
        System.out.println("-----------------Consultar la factura------------------");

        Invoce invoceFound = consultInvoce(invoce1);
        System.out.println(invoceFound);

        System.out.println("----------------------------------------------------");
    }

    public static Invoce consultInvoce(Invoce invoce) {
        return invoceRepository.consult(invoce);
    }

    public static void updateInvoce() {
        System.out.println("---------------Actualizar una factura-------------");
        Item item1 = new Item("DAQ12", "Arroz", 2, 10000);
        Item item2 = new Item("DAQ13", "Frijol", 1, 3000);
        Item item3 = new Item("DAQ14", "Pollo", 2, 20000);
        Item item4 = new Item("DAQ15", "Leche", 2, 25000);
        List<Item> lisItems = new ArrayList<>(Arrays.asList(item1, item2, item3, item4));
        Client juan = new Client("68393", "Juan", "Gomez");
        Invoce invoce1 = new Invoce(juan, lisItems);

        invoceRepository.update(invoce1);
        System.out.println("----------------------------------------------------");
    }

    public static void delelteInvoce() {
        System.out.println("---Eliminar factura y mostrar las facturas-----------");
        Item item1 = new Item("DAQ12", "Arroz", 2, 10000);
        Item item2 = new Item("DAQ13", "Frijol", 1, 3000);
        Item item3 = new Item("DAQ14", "Pollo", 2, 20000);
        Item item4 = new Item("DAQ15", "Leche", 2, 25000);
        List<Item> lisItems = new ArrayList<>(Arrays.asList(item1, item2, item3, item4));
        Client juan = new Client("68393", "Juan", "Gomez");
        Invoce invoce1 = new Invoce(juan, lisItems);

        invoceRepository.delete(invoce1);
        System.out.println("----------------------------------------------------");
    }
}
