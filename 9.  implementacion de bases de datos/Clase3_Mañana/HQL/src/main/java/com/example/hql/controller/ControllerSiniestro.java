package com.example.hql.controller;

import com.example.hql.dto.SiniestroDTO;
import com.example.hql.dto.SiniestroIdDTO;
import com.example.hql.dto.VehiculoDTO;
import com.example.hql.service.ServiceSiniestro;
import com.example.hql.service.ServiceVehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Siniestro")
public class ControllerSiniestro {
    final ServiceSiniestro serviceSiniestro;

    public ControllerSiniestro(ServiceSiniestro serviceSiniestro) {
        this.serviceSiniestro = serviceSiniestro;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSiniestro(@RequestBody SiniestroDTO siniestro){
        return new ResponseEntity<>(serviceSiniestro.add(siniestro), HttpStatus.OK);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<SiniestroIdDTO> getSiniestro(@PathVariable int id){
        return new ResponseEntity<>(serviceSiniestro.getById(id),HttpStatus.OK);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<SiniestroIdDTO>> getVehiculos(){
        return new ResponseEntity<>(serviceSiniestro.getAll(),HttpStatus.OK);
    }


}
