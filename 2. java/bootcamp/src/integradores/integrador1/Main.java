package integradores.integrador1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Cliente> clientes = new HashMap<String, Cliente>();

        Cliente cliente1 = new Cliente("12345", "Sofia", "Petrides");
        clientes.put("12345", cliente1);
        Cliente cliente2 = new Cliente("67890", "Juan", "Perez");
        clientes.put("67890", cliente2);
        Cliente cliente3 = new Cliente("24680", "Martin", "Gomez");
        clientes.put("24680", cliente3);

        clientes.values().stream().forEach(System.out::println);

        System.out.println("Elimino Cliente: ");
        clientes.remove("24680");

        clientes.values().stream().forEach(System.out::println);


        System.out.println("Ingrese número de DNI: ");
        Scanner teclado = new Scanner(System.in);

        String dni = teclado.nextLine();
        teclado.close();

        if (clientes.containsKey(dni))
            System.out.println(clientes.get(dni));
        else
            System.out.println("El cliente no existe");



    }
}
