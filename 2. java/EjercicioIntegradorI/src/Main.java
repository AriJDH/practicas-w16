import clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes =new ArrayList<>();

        clientes.add(new Cliente("123","Juan","Espitia"));
        clientes.add(new Cliente("124","Ivan","Montoya"));
        clientes.add(new Cliente("125","Mabel","Ramirez"));

        clientes.stream()
                .forEach(System.out::println);

        clientes.remove(1);

        System.out.println("Clientes despues de eliminar 1");

        clientes.stream()
                .forEach(System.out::println);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni del usuario");
        String dni = teclado.next();

        boolean rta=false;

        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                System.out.println(c.toString());
                rta = true;
                break;
            }
        }

        if (rta==false){
            System.out.println("cliente no encontrado");
        }



    }
}
