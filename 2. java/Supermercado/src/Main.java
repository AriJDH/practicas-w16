import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static List<Client> clients = new ArrayList<>();
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
            }

        } while (opcionMenu != 4);
    }

    public static Integer imprimirMenu() {
        System.out.println("1. Ver clientes");
        System.out.println("2. Borrar cliente");
        System.out.println("3. Mostrar datos cliente por dni");
        System.out.println("4. salir");
        System.out.print("Ingrese la opcion deseada: ");
        return leer.nextInt();
    }

    public static void loadDataClients() {
        clients.add(new Client("1073525066", "Anggy", "Arguello"));
        clients.add(new Client("1073527896", "Arvey", "Murcia"));
        clients.add(new Client("23944832", "Luisa", "Patarroyo"));
    }
}
