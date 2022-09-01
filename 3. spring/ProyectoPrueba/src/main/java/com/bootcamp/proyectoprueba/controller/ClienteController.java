package com.bootcamp.proyectoprueba.controller;


import com.bootcamp.proyectoprueba.dto.ClienteDto;
import com.bootcamp.proyectoprueba.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @GetMapping("/name")
    public ResponseEntity<List<ClienteDto>> verCliente(){
        return new ResponseEntity<>(clienteService.kakaka(), HttpStatus.ACCEPTED);
    }

}
