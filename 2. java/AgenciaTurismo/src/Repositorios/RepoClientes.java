package Repositorios;

import java.util.ArrayList;
import java.util.List;

public class RepoClientes {

    private List<Cliente> clientes = new ArrayList<>();

    public RepoClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
