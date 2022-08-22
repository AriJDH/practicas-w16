package com.bootcamp.proyectoprueba.controller;


import com.bootcamp.proyectoprueba.dto.ClienteDto;
import com.bootcamp.proyectoprueba.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    IClienteService clienteService;

    @GetMapping("/name")
    public ResponseEntity<List<ClienteDto>> verCliente(){

        return new ResponseEntity<>(clienteService.getAllCLientes(), HttpStatus.ACCEPTED);
    }

}
