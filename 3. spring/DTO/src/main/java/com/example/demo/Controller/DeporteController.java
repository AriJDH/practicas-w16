package com.example.demo.Controller;

import com.example.demo.DTOs.PersonaDTO;
import com.example.demo.Entities.Deporte;
import com.example.demo.DTOs.DeporteDTO;
import com.example.demo.Entities.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeporteController {

    //No respeta REST btw.
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> devolverDeportes() {
        List<Deporte> deportes = mockDeportes();
        List<DeporteDTO> deporteDTOS = new ArrayList<>();

        deportes.forEach((x) -> {
            deporteDTOS.add(new DeporteDTO(x.getNombre(), x.getNivel()));
        });

        return new ResponseEntity<>(deporteDTOS, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> devolverDeportePorNombre(@PathVariable String name){

        List<Deporte> deportes = mockDeportes();
        List<Deporte> posibleDeportes = deportes.stream().filter((x) -> x.getNombre().equals(name)).collect(Collectors.toList());

        if (posibleDeportes.size() == 0){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        DeporteDTO deporteDTO = new DeporteDTO(posibleDeportes.get(0).getNombre(), posibleDeportes.get(0).getNivel());

        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }

    @GetMapping("/findSportPeople")
    public ResponseEntity<List<PersonaDTO>> devolverDeportePersonas(){
        List<Persona> personas = mockPersonas();
        List<PersonaDTO> personaDTOS = new ArrayList<>();

        personas.forEach((x) -> {
            personaDTOS.add(new PersonaDTO(x.getNombre(), x.getApellido(), x.getDeporte().getNombre()));
        });

        return new ResponseEntity<>(personaDTOS, HttpStatus.OK);
    }

    private List<Deporte> mockDeportes(){
        ArrayList deportes = new ArrayList();
        Deporte d = new Deporte("Nombre1", "Nivel1");
        Deporte d2 = new Deporte("Nombre2", "Nivel1");
        Deporte d3 = new Deporte("Nombre3", "Nivel2");

        deportes.add(d);
        deportes.add(d2);
        deportes.add(d3);

        return deportes;
    }

    private List<Persona> mockPersonas(){
        ArrayList personas = new ArrayList();
        List<Deporte> deportes = mockDeportes();

        Persona p1 = new Persona("Nombre1", "Apellido1", 21, deportes.get(0));
        Persona p2 = new Persona("Nombre2", "Apellido2", 41, deportes.get(0));
        Persona p3 = new Persona("Nombre3", "Apellido3", 15, deportes.get(1));

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);

        return personas;
    }


}
