package com.bootcamp.deportes.services;

import com.bootcamp.deportes.dtos.DeporteDTO;
import com.bootcamp.deportes.entities.Deporte;
import com.bootcamp.deportes.entities.Persona;
import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeporteServices {

    static List<Deporte> listaDeportes = new ArrayList<>(Arrays.asList(
            new Deporte("Futbol", 1),
            new Deporte("Basquetbol", 2),
            new Deporte("Golf", 3)
    ));


    public List<DeporteDTO> devolverDeportes(){
        List<DeporteDTO> listaDeportesDTO = new ArrayList<>();
        for (Deporte deporte: listaDeportes){
            DeporteDTO deporteDTO = new DeporteDTO(deporte.getNombre(), deporte.getNivel());
            listaDeportesDTO.add(deporteDTO);
        }
        return listaDeportesDTO;
    }

    public int devolverNivelDeporte(String nombre){
        Deporte deporte = listaDeportes.stream().filter(deporte1 -> deporte1.getNombre().equals(nombre)).findFirst().orElse(null);
        if (deporte != null){
            return deporte.getNivel();
        }else{
            return -1;
        }
    }
}
