package com.grodriguez.deportistas.controller;

import com.grodriguez.deportistas.dto.DeporteDTO;
import com.grodriguez.deportistas.dto.DeportistaDTO;
import com.grodriguez.deportistas.dto.NivelDTO;
import com.grodriguez.deportistas.entities.Deporte;
import com.grodriguez.deportistas.entities.Persona;
import com.grodriguez.deportistas.service.DeporteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeportistaController {

    @Autowired
    private DeporteService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){

        List<Deporte> listaDeportes = sportService.getAllSports();
        List<DeporteDTO> listaDeportesDTO = new ArrayList<>();

        for (Deporte d: listaDeportes) {
            listaDeportesDTO.add(new DeporteDTO(d.getNombre(), d.getNivel()));
        }

        return new ResponseEntity<List<DeporteDTO>>(listaDeportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<NivelDTO> findSport(@PathVariable String name){

        NivelDTO nivel = new NivelDTO(sportService.getLevel(name));

        return new ResponseEntity<NivelDTO>(nivel, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons(){

        List<Persona> listaPersonas = sportService.getAllPersonas();
        List<DeportistaDTO> listaDeportistas = new ArrayList<>();

        listaDeportistas = listaPersonas.stream().map(
                p -> new DeportistaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                .collect(Collectors.toList());

        return new ResponseEntity<List<DeportistaDTO>>(listaDeportistas, HttpStatus.OK);
    }
}
