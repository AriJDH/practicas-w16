package com.tomas.joyeria.controller;

import com.tomas.joyeria.dto.JoyaDTO;
import com.tomas.joyeria.dto.RespuestaActualizadoDTO;
import com.tomas.joyeria.service.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyeriaController {

    @Autowired
    IJoyeriaService service;

    @PostMapping("/jewerly/new")
    public ResponseEntity registrarNuevaJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity(service.crearJoya(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity traerJoya(){
        return new ResponseEntity(service.listarJoya(), HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public void eliminarJoya(@PathVariable Long id){
        service.eliminarJoya(id);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity actualizarJoya(@PathVariable Long id_modificar, @RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity(service.actualizarJoya(id_modificar, joyaDTO), HttpStatus.OK);
    }



}
