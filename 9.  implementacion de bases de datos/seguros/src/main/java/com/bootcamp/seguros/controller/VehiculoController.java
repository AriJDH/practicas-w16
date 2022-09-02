package com.bootcamp.seguros.controller;

import com.bootcamp.seguros.dto.ResponseApiDTO;
import com.bootcamp.seguros.dto.ResponsePatenteDTO;
import com.bootcamp.seguros.dto.ResponsePatenteMarcaDTO;
import com.bootcamp.seguros.dto.VehiculoDTO;
import com.bootcamp.seguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/all_patentes")
    public ResponseEntity<List<ResponsePatenteDTO>> getAllPatentes(){
        return new ResponseEntity<>(vehiculoService.findAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/all_by_date")
    public ResponseEntity<List<ResponsePatenteMarcaDTO>> getAllOrderByDate(){
        return new ResponseEntity<>(vehiculoService.findAllOrderByDate(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApiDTO> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return new ResponseEntity<>(vehiculoService.createVehiculo(vehiculoDTO),HttpStatus.CREATED);
    }
}
