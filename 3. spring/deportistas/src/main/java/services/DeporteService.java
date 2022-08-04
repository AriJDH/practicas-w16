package services;

import dto.DeporteDTO;
import entities.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {

    public List<DeporteDTO> obtenerDeportes(){
        List<Deporte> deportes = cargarDeportes();
        List<DeporteDTO> deportesDTO = new ArrayList<>();
        for(Deporte deporte : deportes){
            deportesDTO.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel()));
        }
        return deportesDTO;
    }

    public DeporteDTO obtenerDeporteXNombre(String nombre){
        List<Deporte> deportes = cargarDeportes();
        Deporte d = deportes.stream().filter(deporteDTO -> deporteDTO.getNombre().equals(nombre)).findFirst().orElse(null);
        return new DeporteDTO(d.getNombre(), d.getNivel());
    }



    public List<Deporte> cargarDeportes(){

        List<Deporte> deportes = new ArrayList<>();

        deportes.add(new Deporte("Baloncesto", "alto"));
        deportes.add(new Deporte("Futbol", "bajo"));

        return deportes;
    }

}
