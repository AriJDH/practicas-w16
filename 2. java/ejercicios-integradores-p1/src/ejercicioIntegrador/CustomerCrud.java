package ejercicioIntegrador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerCrud extends AbsEntityCrud<Customer> implements EntityCrud<Customer> {


    public void removeCustomerByDni(Integer aDNI) {
        entities.removeIf(customer -> customer.getDni().equals(aDNI));
    }

    public Optional<Customer> findCustomerWith(Integer aDNI) {
        return entities.stream().filter(customer -> customer.getDni().equals(aDNI)).findFirst();
    }
}
