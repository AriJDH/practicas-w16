package supermercadoElEconomico.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Florencia", "Reyes", 486486486L);
        Cliente cliente2 = new Cliente("Ileana", "Sosa", 5846845664L);
        Cliente cliente3 = new Cliente("Sofia", "Briano", 35484684L);

        List<Cliente> lista = new ArrayList<>();

        lista.add(cliente1);
        lista.add(cliente2);
        lista.add(cliente3);

        lista.forEach(System.out::println);

        lista.remove(cliente1);

        lista.forEach(System.out::println);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el DNI de quien desea buscar");

        long dniBuscado = teclado.nextLong();
        boolean bandera = false;

        for (Cliente c: lista) {
            if (c.getDni().equals(dniBuscado)){
                System.out.println("Cliante " + c + " encontrado");
                bandera = true;
                break;
            }
        }

        if (!bandera)System.out.println("Cliente no encontrado");

    }
}
