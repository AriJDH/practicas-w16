package Repository;

import Entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente>clientes;


    public RepositorioCliente() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addClientes(Cliente c){
        clientes.add(c);
    }
}
