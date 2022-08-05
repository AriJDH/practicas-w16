package com.tomas.calorias.controller;

import com.tomas.calorias.dto.PlatoDTO;
import com.tomas.calorias.dto.PlatoResponseDTO;
import com.tomas.calorias.dto.IngredienteDTO;
import com.tomas.calorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping("/plato/calorias")
    public ResponseEntity<PlatoResponseDTO> getCalorias(@RequestBody PlatoDTO dish){
        return new ResponseEntity<>(platoService.getCalorias(dish), HttpStatus.OK);
    }
    @GetMapping("/todos-platos/calorias")
    public ResponseEntity<List<PlatoResponseDTO>> getTodasCalorias(@RequestBody List<PlatoDTO> dishes){
        return new ResponseEntity<>(platoService.getTodasCalorias(dishes), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/calorias")
    public ResponseEntity<IngredienteDTO> getIngredientesCalorias(){
        return new ResponseEntity<>(platoService.getIngredientesCalorias(), HttpStatus.OK);
    }

}