package integradores.integrador1;

import java.util.List;

public class Supermercado {

    private RepoClientes clientes;
    private RepoFacturas facturas;

    public Supermercado() {
        clientes = new RepoClientes();
        facturas = new RepoFacturas();
    }

    public void agregarCliente(String dni, String nombre, String apellido){
        clientes.add(new Cliente(dni, nombre, apellido));
    }

    public void mostrarClientes(){
        clientes.getClientes().stream().forEach(System.out::println);
    }

    public Cliente mostrarCliente(String dni){
        return clientes.get(dni);
    }

    public void eliminarCliente(String dni){
        clientes.delete(dni);
    }

    public boolean existeCliente(String dni){
       return clientes.has(dni);
    }


    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }

}
