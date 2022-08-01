package ejercicioIntegrador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerCrud extends AbsEntityCrud<Customer> implements EntityCrud<Customer> {


    public void removeCustomerByDni(Integer aDNI) {
        Optional<Customer> customerToDelete = findCustomerWith(aDNI);
        if (customerToDelete.isPresent()) {
            entities = entities.stream().filter(customer -> !customer.equals(customerToDelete.get())).collect(Collectors.toList());
        } else {
            System.out.println("No se encontro un cliente con el Dni dado, no se borro satisfactoriamente.");
        }
    }

    public Optional<Customer> findCustomerWith(Integer aDNI) {
        return entities.stream().filter(customer -> customer.getDni().equals(aDNI)).findFirst();
    }
}
