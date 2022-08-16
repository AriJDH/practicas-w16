package bootcamp.supermecado.repository;

import bootcamp.supermecado.entity.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteRepository  implements ICrudRepository {

    private static List<Cliente> clientes = new ArrayList<>();
    @Override
    public void crear(Object o) {
        clientes.add((Cliente) o);

    }

    @Override
    public Object get(Integer id) {
        return clientes.stream()
                .filter(x -> x.getDni().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void eliminar(Integer id) {
        clientes.removeIf(x -> x.getDni().equals(id));
    }

    @Override
    public List<Object> getTodos() {
        return Arrays.asList(clientes.toArray());
    }
}
