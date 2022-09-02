package com.vehiculos.seguro.controller;

import com.vehiculos.seguro.dto.PatenteModeloMarcaDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteMarcaDTO;
import com.vehiculos.seguro.dto.VehiculoTotalPerdidaDTO;
import com.vehiculos.seguro.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seguro")
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/vehiculos-patente")
    public ResponseEntity<List<VehiculoPatenteDTO>> listAllByPatente(){
        return new ResponseEntity<>(vehiculoService.listAllByPatente(), HttpStatus.OK);
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<List<VehiculoPatenteMarcaDTO>> listarPatenteMarca(){
        return new ResponseEntity<>(vehiculoService.listPatenteMarca(), HttpStatus.OK);
    }

    @GetMapping("/vehiculo-mas-cuatro-ruedas")
    public ResponseEntity<List<VehiculoPatenteDTO>> listarPatenteVehiculoCuatroRuedas(){
        return new ResponseEntity<>(vehiculoService.listVehiculoCuatroRuedas(), HttpStatus.OK);
    }

    @GetMapping("/siniestro-mayor-diezmil")
    public ResponseEntity<List<PatenteModeloMarcaDTO>> listarVehiculoSiniestroMayorDiezmil(){
        return new ResponseEntity<>(vehiculoService.listVehiculoSienietroMayorDiezmil(), HttpStatus.OK);
    }

    @GetMapping("/siniestro-mayor-diezmil-total")
    public ResponseEntity<List<VehiculoTotalPerdidaDTO>> listarVehiculoSiniestroMayorDiezmilTotalPerdida(){
        return new ResponseEntity<>(vehiculoService.listVehiculoSiniestroMayorDiezmilSumatoriaTotal(), HttpStatus.OK);
    }


}
