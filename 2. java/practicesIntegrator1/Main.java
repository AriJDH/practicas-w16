package practicesIntegrator1;


import java.util.Scanner;

public class Main {

    static Client client = new Client();
    static RepositoryClient clientRepository = new RepositoryClient(client);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Crear clientes
        System.out.println("-----------------Crear clientes-------------------");
        Client pepe = new Client("123","Pepe","Garcia");
        Client jacinta = new Client("456", "Jacinta", "Cano");
        Client pacha = new Client("789", "Pacha", "Ramirez");

        clientRepository.create(pepe);
        clientRepository.create(jacinta);
        clientRepository.create(pacha);

        System.out.println("---------------------------------------------------");

        // Listar clientes
        System.out.println("----------------Listar clientes--------------------");
        client.getDbClients().forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // Eliminar Clientes y listar los nuevos
        System.out.println("-------Eliminar uno y listar clientes nuevos--------");
        clientRepository.delete(pacha);
        client.getDbClients().forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        System.out.println("-----------------Consultar por dni------------------");
        System.out.println("Ingrese un dni a consultar: ");
        String dni = sc.next();

        clientRepository.consultByDni(dni);
    }

}
