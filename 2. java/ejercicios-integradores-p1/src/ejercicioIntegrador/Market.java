package ejercicioIntegrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Market {

    private List<Customer> customers;

    public Market(List<Customer> customers) {
        this.customers = customers;
    }

    public void printCustomers() {
        System.out.println("Datos de clientes:");
        customers.forEach(System.out::println);
    }

    public void removeCustomer(Integer aDNI) {
        Optional<Customer> customerToDelete = findCustomerWith(aDNI);
        if (customerToDelete.isPresent()) {
            customers = customers.stream().filter(customer -> !customer.equals(customerToDelete.get())).collect(Collectors.toList());
        } else {
            System.out.println("No se encontro un cliente con el Dni dado, no se borro satisfactoriamente.");
        }
    }

    public void printCustomerWith(Integer aDNI) {
        Optional<Customer> filteredOptionalCustomer = findCustomerWith(aDNI);
        if (filteredOptionalCustomer.isPresent()) {
            System.out.println("Cliente encontrado: " + filteredOptionalCustomer.get().toString());
        } else {
            System.out.println("No se encontro cliente con el dni ingresado.");
        }
    }

    private Optional<Customer> findCustomerWith(Integer aDNI) {
        return customers.stream().filter(customer -> customer.getDni().equals(aDNI)).findFirst();
    }
}
