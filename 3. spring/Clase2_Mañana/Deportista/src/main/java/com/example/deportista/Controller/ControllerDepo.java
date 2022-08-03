package com.example.deportista.Controller;

import com.example.deportista.DTO.DeporteDTO;
import com.example.deportista.DTO.PersonaDeporteDTO;
import com.example.deportista.Service.ServiceDeportes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerDepo {
    ServiceDeportes s = new ServiceDeportes();

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> allDeportes(){
        return new ResponseEntity<>(s.allDeportes(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> getDeporte(@PathVariable String name){
        return new ResponseEntity<>(s.getDeportePorNombre(name),HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> allPersonsDeporte(){
        return new ResponseEntity<>(s.personaDeporteList(),HttpStatus.OK);
    }
}
