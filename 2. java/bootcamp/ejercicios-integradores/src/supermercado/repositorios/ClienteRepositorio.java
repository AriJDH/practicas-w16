package supermercado.repositorios;

import agencia_turismo.Cliente;
import agencia_turismo.Localizador;
import supermercado.Interfaces.Crud;

import java.util.*;
import java.util.stream.Collectors;

public class ClienteRepositorio implements Crud {

    private static List<supermercado.Cliente> clientes = new ArrayList<>();


    @Override
    public void crear(Object o) {
        clientes.add((supermercado.Cliente) o);
    }

    @Override
    public Object get(String id) {
        return clientes.stream().filter(cliente -> cliente.getDni().equals(id)).findFirst().get();
    }

    @Override
    public void eliminar(String id) {
        clientes.removeIf(cliente -> cliente.getDni().equals(id));
    }

    @Override
    public List<Object> getTodos() {
        return Arrays.asList(clientes.toArray());
    }


}
