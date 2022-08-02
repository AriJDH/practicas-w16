package Interfaces;

import Clases.Cliente;

import java.util.*;

public class ClienteImp implements CRUD<Cliente>{
    private List< Cliente> listaClientes = new ArrayList<>();
    private static ClienteImp instance = null;

    public static ClienteImp getInstance(){
        if(instance == null){instance = new ClienteImp();}
        return instance;
    }
    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        listaClientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(String id) {
        return listaClientes.stream().filter(x->x.getDni().equals(id)).findFirst();
    }

    @Override
    public void eliminar(String id) {
        if(buscar(id).isPresent()){
            listaClientes.removeIf(x->x.getDni().equals(id));
            System.out.println("se elimino "+id);
        }else
        {
            System.out.println("Ese dni no se encuentra en el sistema");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return this.listaClientes;
    }
}
