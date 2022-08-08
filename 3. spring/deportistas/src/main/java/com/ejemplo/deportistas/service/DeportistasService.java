package com.ejemplo.deportistas.service;

import com.ejemplo.deportistas.dto.DeporteDTO;
import com.ejemplo.deportistas.dto.PersonaDTO;
import com.ejemplo.deportistas.dto.DeportistaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportistasService {

    public static List<DeporteDTO> deportes = new ArrayList<>();
    public static List<DeportistaDTO> personaDeporte = new ArrayList<>();

    public List<DeporteDTO> cargarDeportes(){
        deportes.add(new DeporteDTO("Futbol",2));
        deportes.add(new DeporteDTO("Natacion",4));
        deportes.add(new DeporteDTO("Tenis",3));

        return deportes;
    }

    public List<DeportistaDTO> cargarPersonaDeporte(){

        List<DeporteDTO> deportes = cargarDeportes();
        PersonaDTO persona = new PersonaDTO("Juan","Hernandez",23);

        personaDeporte.add(new DeportistaDTO(deportes.get(0).getNombre(), persona));

        return personaDeporte;

    }

    public List<DeporteDTO> findSports(){

        List<DeporteDTO> deportes = cargarDeportes();

        return deportes;

    }

    public DeporteDTO findSportsWithName(String nombre){

        List<DeporteDTO> deportes = cargarDeportes();

        DeporteDTO deporte = new DeporteDTO();

        for (DeporteDTO deporteDTOS : deportes) {
            if (deporteDTOS.getNombre().equals(nombre)) {
                deporte = deporteDTOS;
            }
        }

        return deporte;

    }

    public List<DeportistaDTO> findSportsPersona(){

        List<DeportistaDTO> personaDeporte = cargarPersonaDeporte();

        return personaDeporte;

    }

}
