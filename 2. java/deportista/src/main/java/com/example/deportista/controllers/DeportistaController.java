package com.example.deportista.controllers;

import com.example.deportista.dtos.DeporteDto;
import com.example.deportista.dtos.PersonaDto;
import com.example.deportista.entities.Deporte;
import com.example.deportista.services.DeporteService;
import com.example.deportista.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class DeportistaController {

  DeporteService serviceDeporte= new DeporteService();
  PersonaService personaService= new PersonaService();

    @GetMapping("/lista_Deporte")
    public ResponseEntity<List<DeporteDto>> getListaDeportes(){

        return  ResponseEntity.ok(serviceDeporte.getDdeportes());

    }


    @GetMapping("getDeporte")
    public ResponseEntity<DeporteDto> getDeporte(@RequestParam String nombre)
    {
        DeporteDto deporteDto = serviceDeporte.getDdeportes().stream().filter(x-> x.getDeporte().getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        return  ResponseEntity.ok(deporteDto);
    }


    @GetMapping("/getDeportista")
    public  ResponseEntity<List<PersonaDto>> getDeportista(@RequestParam String nombre)
    {
        List<PersonaDto> personaDto = personaService.getListaPersonas().stream().filter(x-> x.getPersona().getDeporte().getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        return ResponseEntity.ok(personaDto);
    }


}
