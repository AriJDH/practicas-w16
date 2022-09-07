package com.example.Aseguradora.Autos.controller;

import com.example.Aseguradora.Autos.dto.VehiculoPatenteDto;
import com.example.Aseguradora.Autos.dto.VehiculoPatenteMarcaDto;
import com.example.Aseguradora.Autos.dto.VehiculoPatenteMarcaModeloDto;
import com.example.Aseguradora.Autos.dto.VehiculoSiniestroDto;
import com.example.Aseguradora.Autos.service.IVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculo vehiculo;

    @GetMapping("/patente")
    public ResponseEntity<List<VehiculoPatenteDto>> mostrarPatentes(){
        return new ResponseEntity<>(vehiculo.mostrarPatente(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/patente/ruedas/anio")
    public ResponseEntity<List<VehiculoPatenteDto>> mostrarPatentesPorRuedasYAnio(){
        return new ResponseEntity<>(vehiculo.mostrarPatentePorRuedas(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/patente/marca")
    public ResponseEntity<List<VehiculoPatenteMarcaDto>> mostrarPatenteMarca(){
        return new ResponseEntity<>(vehiculo.mostrarPatenteYMarca(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/patente/marca/modelo")
    public ResponseEntity<List<VehiculoPatenteMarcaModeloDto>> mostrarPatenteMarcaModelo(){
        return new ResponseEntity<>(vehiculo.mostrarPatenteMarcaYModelo(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/perdidaTotal")
    public ResponseEntity<List<VehiculoSiniestroDto>> mostrarPerdidaTotal(){
        return new ResponseEntity<>(vehiculo.mostrarPorPerdidaEconomica(),HttpStatus.ACCEPTED);
    }
}
