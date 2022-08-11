package integradores.integrador1;

import java.util.List;

public class Supermercado {

    private RepoClientes clientes;
    private RepoFacturas facturas;

    public Supermercado() {
        clientes = new RepoClientes();
        facturas = new RepoFacturas();
    }

    public void agregarCliente(Long dni, String nombre, String apellido){
        clientes.add(new Cliente(dni, nombre, apellido));
    }

    public void mostrarClientes(){
        clientes.getAll().stream().forEach(System.out::println);
    }

    public Cliente mostrarCliente(Long dni){
        return clientes.get(dni);
    }

    public void eliminarCliente(Long dni){
        clientes.delete(dni);
    }

    public boolean existeCliente(Long dni){
       return clientes.has(dni);
    }


    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }

    public void mostrarFacturas(){
        facturas.getAll().stream().forEach(System.out::println);
    }

    public void eliminarFactura(Long id){
        facturas.delete(id);
    }
}
