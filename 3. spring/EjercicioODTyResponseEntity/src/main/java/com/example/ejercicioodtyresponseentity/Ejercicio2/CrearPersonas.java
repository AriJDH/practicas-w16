/*
package com.example.ejercicioodtyresponseentity.Ejercicio2;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CrearPersonas {
    private int idPersona = 0;
    private int idDeporte = 0;
    ArrayList<Deporte> deportes = new ArrayList<>();
    ArrayList<Persona> personas = new ArrayList<>();


    //Se captura y crean objetos persona
    @GetMapping(path = "/Persona/{nombrePersona}/{apellidoPersona}/{edadPersona}")
    public ArrayList ingresarPersona(@PathVariable String nombrePersona, @PathVariable String apellidoPersona, @PathVariable String edadPersona) {
        idPersona += 1;
        Persona persona = new Persona(idPersona, nombrePersona, apellidoPersona, edadPersona);
        personas.add(persona);
        return personas;
    }

    //Se capturan y muestran objetos deportes
    @GetMapping(path = "/deporte/{nombre}/{nivel}")
    public ArrayList ingresarPersona(@PathVariable String nombre, @PathVariable String nivel) {
        idDeporte += 1;
        Deporte deporte = new Deporte(nombre, nivel, idDeporte);
        deportes.add(deporte);
        return deportes;

    }

    //Se muestran en pantalla las personas ingresadas
    @GetMapping(path = "/findPersons")
    public ArrayList mostrarPersonas() {
        return personas;
    }

    //Se muestran en pantalla los deportes ingresados
    @GetMapping(path = "/findSports")
    public ArrayList mostrarDeportes() {
        return deportes;
    }

    //Buscar si deporte se encuentra en lista
    @GetMapping(path = "/deporte/{nombre}")
    public ResponseEntity<String> buscarDeporte(@PathVariable String nombre) {

        try {
            for (Deporte p : deportes) {
                if (p.getNombreDeporte() == nombre) {
                    String msg = "Se ha encontrado el deporte: " + p.getNombreDeporte() + " de nivel " + p.getNivelDeporte();
                    return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>("No existe el deporte ingresado", HttpStatus.NOT_FOUND);
        }

    }


}

 */
