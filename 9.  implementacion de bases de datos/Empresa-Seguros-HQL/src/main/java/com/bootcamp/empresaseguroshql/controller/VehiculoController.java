package com.bootcamp.empresaseguroshql.controller;

import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteDto;
import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteMarcaDto;
import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteMarcaModeloDto;
import com.bootcamp.empresaseguroshql.repository.IVehiculoRepository;
import com.bootcamp.empresaseguroshql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    IVehiculoService iVehiculoService;

    @GetMapping("/vehiculosPatente")
    public ResponseEntity<List<VehiculoPatenteDto>> getVehiculosPatente(){
        return new ResponseEntity<>(iVehiculoService.encontrarPatenteVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/vehiculosPatenteMarca")
    public ResponseEntity<List<VehiculoPatenteMarcaDto>> getVehiculosPatenteMarca(){
        return new ResponseEntity<>(iVehiculoService.encontrarPatenteMarcaVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/vehiculosPatenteMas4ruedas")
    public ResponseEntity<List<VehiculoPatenteDto>> getVehiculoMas4RuedasAnioEnCurso(){
        return new ResponseEntity<>(iVehiculoService.encontrarVehiculoMas4RuedasAnioEnCurso(), HttpStatus.OK);
    }

    @GetMapping("/vehiculosPerdidaMayor10000")
    public ResponseEntity<List<VehiculoPatenteMarcaModeloDto>> getVehiculosPerdidaMayor10000(){
        return new ResponseEntity<>(iVehiculoService.encontrarVehiculosPerdidaMayor10000(), HttpStatus.OK);
    }



}
