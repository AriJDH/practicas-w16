package com.bootcamp.proyectoprueba.service;

import com.bootcamp.proyectoprueba.dto.ClienteDto;
import com.bootcamp.proyectoprueba.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClienteService implements IClienteService{

    List<Cliente> clientes;

    @Override
    public List<ClienteDto> getAllCLientes() {

        return clientes.stream().filter(x -> x.getId() == 1).collect(Collectors.toList());
    }
}
