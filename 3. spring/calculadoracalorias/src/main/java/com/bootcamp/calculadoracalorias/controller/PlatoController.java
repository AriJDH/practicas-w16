package com.bootcamp.calculadoracalorias.controller;

import com.bootcamp.calculadoracalorias.dto.PlatoDto;
import com.bootcamp.calculadoracalorias.dto.RequestPlatoDto;
import com.bootcamp.calculadoracalorias.model.Plato;
import com.bootcamp.calculadoracalorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @GetMapping("/{nombrePlato}/{peso}")
    public ResponseEntity<PlatoDto> getInformacionPlato(@PathVariable String nombrePlato, @PathVariable int peso){
        return new ResponseEntity<>(platoService.getInfoPlato(nombrePlato,peso), HttpStatus.OK);
    }

    @PostMapping("/platos")
    public ResponseEntity<List<PlatoDto>>  getInformacionListaPlatos(@RequestBody List<RequestPlatoDto> listaPlatos){
        return new ResponseEntity<>(platoService.getInfoListaPlatos(listaPlatos),HttpStatus.OK);
    }
}
