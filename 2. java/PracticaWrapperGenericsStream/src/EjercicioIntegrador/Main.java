package EjercicioIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Crear 3 cliente y mostrar sus datos");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("49867865", "German", "Rodriguez"));
        clientes.add(new Cliente("48347501", "Romina", "Garcia"));
        clientes.add(new Cliente("49876543", "Oliver", "Rodriguez"));
        clientes.forEach(System.out::println);

        System.out.println("Eliminar uno y mostrar datos de los demas");
        clientes.remove(clientes.size() - 1);
        clientes.forEach(System.out::println);

        System.out.println("Ingresar un CI, si esta muestro sus datos:");
        Scanner teclado = new Scanner(System.in);
        String ci = teclado.nextLine();

        boolean found = false;
        int i = 0;
        do{
            if(clientes.get(i).getCi().equals(ci)){
                System.out.println(clientes.get(i).toString());
                found = true;
            }
            i++;
        } while (!found && i < clientes.size());

        if (!found)
            System.out.println("No se encontro el cliente");
    }
}
