package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements crudRepository<Cliente>{
    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void save(Cliente obj) {
        listaClientes.add(obj);
    }

    @Override
    public void mostrarPantalla() {
        listaClientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        try
        {
            Cliente cli = listaClientes.stream().filter(c -> c.getDni().equals(id)).findFirst().get();
            return Optional.of(cli);

        } catch (Exception e) {
            System.out.println("No se encontro el cliente");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long dni) {
        Optional<Cliente> cliente = this.buscar(dni);

        if (cliente.isEmpty()) {
            System.out.println("No se encontro el cliente");
        } else {
            listaClientes.remove(cliente.get());
            System.out.println("Cliente borrado");
        }
    }

    @Override
    public List<Cliente> listar() {
        return listaClientes;
    }
}
