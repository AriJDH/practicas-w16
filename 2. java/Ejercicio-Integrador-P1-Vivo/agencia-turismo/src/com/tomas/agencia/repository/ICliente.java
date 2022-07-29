package com.tomas.agencia.repository;

import com.tomas.agencia.models.Cliente;
import com.tomas.agencia.models.Localizadores;

public interface ICliente {

    public Cliente crearCliente(Cliente cliente);

    public Cliente agregarLocalizador(Localizadores localizadores, Cliente cliente);

}