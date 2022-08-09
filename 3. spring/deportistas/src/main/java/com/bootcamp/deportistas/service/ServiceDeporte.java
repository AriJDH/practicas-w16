package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.response.DeporteDTO;
import com.bootcamp.deportistas.dto.response.PersonaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ServiceDeporte {

    public List<DeporteDTO> getAllDeportes() {
        List<Deporte> deportes = cargarDeportes();
        List<DeporteDTO> deportesDTO = new ArrayList<>();

        deportes.forEach(x -> {
            deportesDTO.add(new DeporteDTO(x.getNombre(), x.getNivel()));
        });
        return deportesDTO;
    }

    public DeporteDTO getDeporte(String nombre) {
        List<DeporteDTO> deportesDTO = getAllDeportes();
        DeporteDTO deporte = new DeporteDTO();
                deportesDTO.stream().forEach(x -> {
                    if(x.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                        deporte.setNombre(x.getNombre());
                        deporte.setNivel((x.getNivel()));
                    }
                });
        return deporte;
    }

    public List<PersonaDTO> getPersonas() {
        List<Persona> personas = cargarPersonas();
        List<PersonaDTO> personasDTO= new ArrayList<>();
        personas.forEach(x-> {
            personasDTO.add(new PersonaDTO(x.getNombre(), x.getApellido(), x.getDeporte()));
        });
        return personasDTO;
    }

    private static List<Deporte> cargarDeportes() {
        List<Deporte> deportes = new ArrayList<>();
        Deporte futbol = new Deporte("Futbol", "Nivel Medio");
        Deporte tenis = new Deporte("Tenis", "Nivel Alto");
        Deporte runnig = new Deporte("Running", "Nivel Basico");
        Deporte ciclismo = new Deporte("Ciclismo", "Nivel Basico");
        deportes.add(futbol);
        deportes.add(tenis);
        deportes.add(runnig);
        deportes.add(ciclismo);
        return deportes;
    }

    private static List<Persona>  cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona persona = new Persona("Camilo", "Palma", 30, "Running");
        Persona persona1 = new Persona("Juan", "Saldivar", 30, "Futbol");
        Persona persona2 = new Persona("Samuel", "Riquelme", 30, "Futbol");
        Persona persona3 = new Persona("Maria", "Zagal", 30, "Ciclismo");
        Persona persona4 = new Persona("Angelica", "Astra", 30, "Tenis");
        Persona persona5 = new Persona("Alice", "Mor", 30, "Ciclismo");
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);
        return personas;
    }


}
