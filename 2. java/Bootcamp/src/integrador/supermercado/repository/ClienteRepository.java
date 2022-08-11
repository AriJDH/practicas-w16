package integrador.supermercado.repository;

import integrador.supermercado.interfaces.IRepository;
import integrador.supermercado.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ClienteRepository implements IRepository<Cliente, String> {
    private List<Cliente> clientes;
    public static ClienteRepository instance;

    private ClienteRepository(){
        this.clientes = new ArrayList<>();
    }

    public static ClienteRepository getInstance(){
        if(instance == null) instance = new ClienteRepository();
        return instance;
    }
    @Override
    public Optional<Cliente> findOne(String identificador) {
        return this.clientes.stream()
                        .filter(c->c.getDni().equalsIgnoreCase(identificador))
                        .findFirst();
    }

    @Override
    public List<Cliente> getAll() {
        return this.clientes;
    }

    @Override
    public Cliente save(Cliente object) {
        if(this.findOne(object.getDni()).isPresent()) throw new IllegalArgumentException(String.format("Ya existe un cliente registrado con el documento: %s.\n", object.getDni()));
        this.clientes.add(object);
        return object;
    }

    @Override
    public Boolean delete(String identificador) {
        Optional<Cliente> cliente = this.findOne(identificador);
        if(cliente.isEmpty()) return Boolean.FALSE;
        this.clientes.remove(cliente.get());
        return Boolean.TRUE;
    }
}
