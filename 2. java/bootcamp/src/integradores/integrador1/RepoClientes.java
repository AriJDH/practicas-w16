package integradores.integrador1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepoClientes implements Repositorio<Cliente>{

    private Map<String, Cliente> clientes;

    public RepoClientes() {
        this.clientes = new HashMap<>();
    }

    @Override
    public void add(Cliente obj) {
        this.clientes.put(obj.getDni(), obj);
    }

    @Override
    public void delete(Cliente obj) {
        this.clientes.remove(obj.getDni());
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
    public Cliente get(String id) {
        return this.clientes.get(id);
    }

    @Override
    public boolean has(String id) {
        return this.clientes.containsKey(id);
    }

    public List<Cliente> getClientes() {
        return clientes.values().stream().collect(Collectors.toList());
    }
}
