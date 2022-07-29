package supermercadoElEconomico;

import supermercadoElEconomico.domain.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("232023", "Pedro", "Vazquez");
        Cliente cliente2 = new Cliente("455326", "Ricardito", "Mocked");
        Cliente cliente3 = new Cliente("234324", "Sofia", "Perez");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.forEach(cliente -> System.out.println(cliente));

        clientes.remove(cliente1);
        clientes.forEach(cliente -> System.out.println(cliente));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni de un cliente");
        String dniBuscado = scanner.nextLine();

        Optional<Cliente> posibleMatch = clientes
                .stream()
                .filter(elem -> elem.getDni().equalsIgnoreCase(dniBuscado))
                .findAny();

        if (posibleMatch.isPresent())
            System.out.println(posibleMatch.get());
        else
            System.out.println("Cliente no encontrado");


    }
}
