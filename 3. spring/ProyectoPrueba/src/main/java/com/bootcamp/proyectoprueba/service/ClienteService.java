package com.bootcamp.proyectoprueba.service;

import com.bootcamp.proyectoprueba.dto.ClienteDto;
import com.bootcamp.proyectoprueba.entity.Cliente;
import com.bootcamp.proyectoprueba.repository.IClienteRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClienteService implements IClienteService{

    ModelMapper mapper = new ModelMapper();

    @Autowired
    IClienteRepository iClienteRepository;


    @Override
    public List<ClienteDto> getAllCLientes() {
        List<Cliente> clientes = iClienteRepository.getListCliente();

        return  clientes.stream()
                .map(x -> mapper.map(x, ClienteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteDto> kakaka(){
        return getAllCLientes().stream().filter(x -> x.getId() > 1).collect(Collectors.toList());
    }
}
