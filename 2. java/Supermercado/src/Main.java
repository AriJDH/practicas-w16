import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static List<Client> clients = new ArrayList<>();
    static List<Invoice> invoices = new ArrayList<>();
    static Double total = 0.0;
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        loadDataClients();
        Integer opcionMenu = 0;
        do {
            opcionMenu = imprimirMenu();
            if (opcionMenu == 1) {
                System.out.println("Los clientes existentes son: ");
                clients.stream().forEach(client -> System.out.println(client.getDni() + " - " + client.getName() + " " + client.getLastName()));
            } else if (opcionMenu == 2) {
                System.out.print("Ingrese el dni para borrar cliente: ");
                String dni = leer.next();

                Client client = clients.stream().filter(clientDelete -> clientDelete.getDni().equals(dni)).findFirst().orElse(null);
                if (client == null) {
                    System.out.println("El cliente no existe");
                } else {
                    clients.remove(client);

                    System.out.println("El cliente se borro exitosamente");
                }
            } else if (opcionMenu == 3) {
                System.out.print("Ingrese el dni para borrar cliente: ");
                String dni = leer.next();

                Client client = clients.stream().filter(clientDelete -> clientDelete.getDni().equals(dni)).findFirst().orElse(null);
                if (client == null) {
                    System.out.println("El cliente no existe");
                } else {
                    System.out.println("Los datos del cliente son: " + client.getDni() + " - " + client.getName() + " " + client.getLastName());
                }
            } else if (opcionMenu == 4) {
                System.out.print("Ingrese el dni del cliente para la factura: ");
                String dni = leer.next();

                Client client = clients.stream().filter(clientDelete -> clientDelete.getDni().equals(dni)).findFirst().orElse(null);
                if (client == null) {
                    System.out.println("El cliente no existe, ingrese los datos.");
                    client = createClient();
                    clients.add(client);

                    List<Item> items = new ArrayList<>();
                    items = createItems();
                    Invoice invoice = new Invoice(client, items, total);
                    invoices.add(invoice);
                    System.out.println("El total a pagar es: " + invoice.getTotal());
                } else {
                    System.out.println("Los datos del cliente son: " + client.getDni() + " - " + client.getName() + " " + client.getLastName());
                }
            }

        } while (opcionMenu != 5);
    }

    public static Integer imprimirMenu() {
        System.out.println("1. Ver clientes");
        System.out.println("2. Borrar cliente");
        System.out.println("3. Mostrar datos cliente por dni");
        System.out.println("4. Factura");
        System.out.println("5. salir");
        System.out.print("Ingrese la opcion deseada: ");
        return leer.nextInt();
    }

    public static void loadDataClients() {
        clients.add(new Client("1073525066", "Anggy", "Arguello"));
        clients.add(new Client("1073527896", "Arvey", "Murcia"));
        clients.add(new Client("23944832", "Luisa", "Patarroyo"));
    }

    public static Client createClient() {
        Client client = new Client();
        System.out.print("DNI: ");
        client.setDni(leer.next());

        System.out.print("Nombre: ");
        client.setName(leer.next());

        System.out.print("Apellido: ");
        client.setLastName(leer.next());

        return client;
    }

    public static List<Item> createItems() {
        List<Item> items = new ArrayList<>();
        Integer opcionItem = 0;
        do {
            System.out.println("1. Agregar item");
            System.out.println("2. Volver a la factura");
            System.out.print("Escoja una opcion: ");
            opcionItem = leer.nextInt();

            if (opcionItem == 1) {
                Item item = new Item();

                System.out.print("Codigo: ");
                item.setId(leer.nextInt());

                System.out.print("Nombre: ");
                item.setName(leer.next());

                System.out.print("Cantidad: ");
                item.setAmount(leer.nextInt());

                System.out.print("Valor unitario: ");
                item.setCost(leer.nextDouble());

                total = total + (item.getCost() * item.getAmount());

                items.add(item);
            }
        } while (opcionItem != 2);

        return items;
    }
}
