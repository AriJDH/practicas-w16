package com.ejercicio.deportistas.service;

import com.ejercicio.deportistas.dto.DeporteDTO;
import com.ejercicio.deportistas.dto.DeportistaDTO;
import com.ejercicio.deportistas.entities.Deporte;
import com.ejercicio.deportistas.entities.Deportista;
import com.ejercicio.deportistas.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasAppService {
    private List<Deporte> deportes;
    private List<Persona> personas;
    private List<Deportista> deportistas;

    public DeportistasAppService() {
        createData();
    }

    public List<DeporteDTO> findAllSports() {
        List<DeporteDTO> deportesDTO = deportes.stream()
                .map(dep -> new DeporteDTO(dep.getNombre(), dep.getNivel())).collect(Collectors.toList());
        return deportesDTO;
    }

    public DeporteDTO findSportByName(String name) {
        return findAllSports().stream().filter(dep -> dep.getNombre()
                .equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<DeportistaDTO> findAllSportsPersons() {
        return deportistas.stream()
                .map(dep -> new DeportistaDTO(dep.getPersona().getNombre(), dep.getPersona().getApellido(),
                        dep.getDeporte().getNombre())).collect(Collectors.toList());
    }

    private void createData() {

        Persona p1 = new Persona("Milu", "Castro", 4);
        Persona p2 = new Persona("Juan", "Perez", 18);
        Persona p3 = new Persona("Maria", "Rodriguez", 20);
        Persona p4 = new Persona("Pedro", "Gonzalez", 24);
        Persona p5 = new Persona("Jose", "Jose", 24);
        personas = List.of(p1, p2, p3, p4, p5);


        Deporte footbal = new Deporte("Football", "Medio");
        Deporte jockey = new Deporte("Jockey", "Avanzado");
        Deporte tenis = new Deporte("Tenis", "Medio");
        Deporte voley = new Deporte("Voley", "Avanzado");
        Deporte atletismo = new Deporte("Atletismo", "Basico");
        deportes = List.of(footbal, voley, tenis, jockey, atletismo);

        deportistas = new ArrayList<>();
        deportistas.add(new Deportista(p1, footbal));
        deportistas.add(new Deportista(p2, footbal));
        deportistas.add(new Deportista(p2, jockey));
        deportistas.add(new Deportista(p3, tenis));
        deportistas.add(new Deportista(p4, voley));
    }
}
