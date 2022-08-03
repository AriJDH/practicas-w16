package com.EjerciciosDeportistas.deportistas.services;

import com.EjerciciosDeportistas.deportistas.DTOs.DeporteDTO;
import com.EjerciciosDeportistas.deportistas.entities.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService {

    private List<DeporteDTO> deportes;

    public DeportistasService() {
        deportes = new ArrayList<>();
        deportes.add(new DeporteDTO("Futbol",3));
        deportes.add(new DeporteDTO("Baloncesto",2));
        deportes.add(new DeporteDTO("voleybol",4));
    }

    public List<DeporteDTO> listarDeportes(){
        return deportes;
    }

    public DeporteDTO consultarDeporte(String nombre){

        List<DeporteDTO> deporte = deportes.stream()
                .filter(deporteDTO -> deporteDTO.getNombre().equals(nombre))
                .collect(Collectors.toList());

        if (deporte.size() == 1){
            return deporte.get(0);
        }
        else{
            return null;
        }
    }


}
