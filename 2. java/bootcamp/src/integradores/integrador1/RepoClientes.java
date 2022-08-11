package integradores.integrador1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepoClientes implements Repositorio<Cliente>{

    private Map<Long, Cliente> clientes;

    public RepoClientes() {
        this.clientes = new HashMap<>();
    }

    @Override
    public void add(Cliente obj) {
        this.clientes.put(obj.getDni(), obj);
    }

    @Override
    public void delete(Long id) {
        this.clientes.remove(id);
    }


    public void delete(String dni) {
        this.clientes.remove(dni);
    }

    @Override
    public void update(Cliente obj, Cliente newObj) {
        this.clientes.remove(obj.getDni());
        this.clientes.put(newObj.getDni(), newObj);
    }

    @Override
    public Cliente get(Long id) {
        return this.clientes.get(id);
    }

    @Override
    public boolean has(Long id) {
        return this.clientes.containsKey(id);
    }

    @Override
    public List<Cliente> getAll() {
        return clientes.values().stream().collect(Collectors.toList());
    }

}
