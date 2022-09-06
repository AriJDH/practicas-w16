package com.bootcamp.seguros.controller;

import com.bootcamp.seguros.dto.MarcaYPatenteVehiculoDto;
import com.bootcamp.seguros.dto.PatenteDto;
import com.bootcamp.seguros.dto.VehiculoDtoResponse;
import com.bootcamp.seguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    IVehiculoService iVehiculoService;

    @GetMapping("/todos")
    public ResponseEntity<List<VehiculoDtoResponse>> getAllVehiculos(){
        return new ResponseEntity<>(iVehiculoService.getAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<List<MarcaYPatenteVehiculoDto>> getAllPatentesYMarcasVehiculos(){
        return  new ResponseEntity<>(iVehiculoService.getAllPatentesYMarcasVehiculos(),HttpStatus.OK);
    }

    @GetMapping("/fabAnioCorriente/{anioFabricacion}")
    public ResponseEntity<List<PatenteDto>> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(@PathVariable Integer anioFabricacion){
        return  new ResponseEntity<>(iVehiculoService.getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(anioFabricacion)
                ,HttpStatus.OK);
    }

}
