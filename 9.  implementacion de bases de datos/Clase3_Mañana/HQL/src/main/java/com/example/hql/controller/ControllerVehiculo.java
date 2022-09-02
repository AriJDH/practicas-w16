package com.example.hql.controller;

import com.example.hql.dto.*;
import com.example.hql.service.ServiceVehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Vehiculo")
public class ControllerVehiculo {
    final ServiceVehiculo serviceVehiculo;

    public ControllerVehiculo(ServiceVehiculo serviceVehiculo) {
        this.serviceVehiculo = serviceVehiculo;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addVehiculo(@RequestBody VehiculoDTO vehiculo){
        return new ResponseEntity<>(serviceVehiculo.add(vehiculo), HttpStatus.OK);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<VehiculoIdDTO> getVehiculo(@PathVariable int id){
        return new ResponseEntity<>(serviceVehiculo.getById(id),HttpStatus.OK);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<VehiculoIdDTO>> getVehiculos(){
        return new ResponseEntity<>(serviceVehiculo.getAll(),HttpStatus.OK);
    }

    @GetMapping("/consulta1")
    public ResponseEntity<List<PatenteDTO>> consulta1(){
        return new ResponseEntity<>(serviceVehiculo.findPatenteAll(),HttpStatus.OK);
    }

    @GetMapping("/consulta2")
    public ResponseEntity<List<StringX2>> consulta2(){
        return new ResponseEntity<>(serviceVehiculo.findPatenteMarcaAll(),HttpStatus.OK);
    }

    @GetMapping("/consulta4")
    public ResponseEntity<List<StringX3>> consulta4(){
        return new ResponseEntity<>(serviceVehiculo.findPatenteMarcaModeloBySiniestroPerdida(),HttpStatus.OK);
    }

    @GetMapping("/consulta5")
    public ResponseEntity<List<VehiculoBDDTO>> consulta5(){
        return new ResponseEntity<>(serviceVehiculo.findPatenteMarcaModeloBySiniestroPerdidaTotal(),HttpStatus.OK);
    }


}
