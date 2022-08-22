package com.bootcamp.proyectoprueba.repository;

import com.bootcamp.proyectoprueba.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepository implements IClienteRepository{

    List<Cliente> clientes = new ArrayList<>();

    @PostConstruct
    private void loadData() {
        clientes.add(new Cliente(1, "Andres"));
        clientes.add(new Cliente(2, "Felipe"));
        clientes.add(new Cliente(3, "Javier"));
        clientes.add(new Cliente(4, "Johan"));

    }

    @Override
    public Cliente findName() {
        return null;
    }
}
