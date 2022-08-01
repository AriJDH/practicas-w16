package ejercicioIntegrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Market {

    private final CustomerCrud customerCrud;
    private final InvoiceCrud invoiceCrud;

    public Market() {
        customerCrud = new CustomerCrud();
        invoiceCrud = new InvoiceCrud();
    }

    public void addCustomers(List<Customer> customers) {
        customers.forEach(customer -> customerCrud.add(customer));
    }
    public void printCustomers() {
        System.out.println("Datos de clientes:");
        customerCrud.getAll().forEach(System.out::println);
    }

    public void removeCustomer(Integer aDNI) {
        customerCrud.removeCustomerByDni(aDNI);
    }

    public void printCustomerWith(Integer aDNI) {
        Optional<Customer> filteredOptionalCustomer = customerCrud.findCustomerWith(aDNI);
        if (filteredOptionalCustomer.isPresent()) {
            System.out.println("Cliente encontrado: " + filteredOptionalCustomer.get().toString());
        } else {
            System.out.println("No se encontro cliente con el dni ingresado.");
        }
    }

    public void registerInvoice(Invoice anInvoice){
        if (!customerCrud.findCustomerWith(anInvoice.getCustomer().getDni()).isEmpty()) {
            customerCrud.add(anInvoice.getCustomer());
        }
        invoiceCrud.add(anInvoice);
    }
}
