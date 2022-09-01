package com.bootcamp.proyectoprueba.repository;

import com.bootcamp.proyectoprueba.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface IClienteRepository {

    List<Cliente> getListCliente();
    Cliente findName();


}
