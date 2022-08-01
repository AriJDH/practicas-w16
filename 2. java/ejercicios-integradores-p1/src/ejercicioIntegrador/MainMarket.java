package ejercicioIntegrador;

import java.util.*;

public class MainMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer dniToSearch;

        List<Customer> customers =
                List.of(
                        new Customer(42312772, "Nicolas", "De Maio"),
                        new Customer(1111111, "Juan", "Perez"),
                        new Customer(3399231, "John", "Doe")
                );

        Market market = new Market();

        market.addCustomers(customers);

        market.printCustomers();

        System.out.println("Ingrese el numero de Dni de un cliente a borrar:");
        dniToSearch = scanner.nextInt();
        market.removeCustomer(dniToSearch);

        market.printCustomers();

        System.out.println("Ingrese el numero de dni de un cliente a buscar:");
        dniToSearch = scanner.nextInt();
        market.printCustomerWith(dniToSearch);

        scanner.close();
    }

}
