package com.example.ejercicioodtyresponseentity.Ejercicio2.Controller;

import com.example.ejercicioodtyresponseentity.Ejercicio2.DTO.PersonaDeporteDTO;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //Se captura y crean objetos persona
    @GetMapping("/Persona/{nombrePersona}/{apellidoPersona}/{edadPersona}")
    public ResponseEntity<Persona> addPersona(@PathVariable String nombrePersona, @PathVariable String apellidoPersona, @PathVariable Integer edadPersona) {
        return new ResponseEntity<>(this.personaService.addPersona(nombrePersona, apellidoPersona, edadPersona), HttpStatus.OK);
    }
    //Se muestran las personas ingresadas
    @GetMapping("/Personas")
    public ResponseEntity<List<Persona>> showPersons(){
        return  new ResponseEntity<>(this.personaService.showPersons(),HttpStatus.OK);
    }


}
