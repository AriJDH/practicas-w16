package com.example.deportitas.controller;


import com.example.deportitas.dto.DeporteDto;
import com.example.deportitas.entities.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonaController {



    public Map<String, String> deporte(){
        Map<String, String> deporte = new HashMap<String, String>();

        deporte.put("Futbol", "Principiante");
        deporte.put("Baloncesto", "Medio");
        deporte.put("Voleyball", "Medio");
        deporte.put("Natacion", "Avanzado");
        deporte.put("Golf", "Avanzado");

        return deporte;

    }


    @GetMapping("/findSport")
    public ResponseEntity<DeporteDto> listarDeporte(){

        DeporteDto objDeporteDTO = new DeporteDto(deporte());
        return new ResponseEntity<>(objDeporteDTO, HttpStatus.OK);
    }
}
