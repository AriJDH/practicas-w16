package repositorios;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private List<Cliente> listClientes = new ArrayList<>();

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public Clientes() {
    }

    public void agregarCliente(Cliente cliente){
        this.listClientes.add(cliente);
    }

    public Clientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "listClientes=" + listClientes +
                '}';
    }

    private List<Cliente> mostrarClientes(){
        return this.listClientes;
    }

    public boolean eliminarCliente(String dni){
        Cliente cliente = listClientes.stream()
                .filter(x ->x.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        if (cliente == null){
            return false;
        }else {
            listClientes.remove(cliente);
            return true;
        }
    }

    public Cliente mostrarCliente(String dni){
        Cliente cliente = listClientes.stream()
                .filter(x ->x.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        return cliente;
    }
}
