package com.example.ejercicioodtyresponseentity.Ejercicio2.Repository;
import com.example.ejercicioodtyresponseentity.Ejercicio2.DTO.PersonaDeporteDTO;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class PersonaDeporteRepo {
    List personaDeporte = new ArrayList<>();

    public void agregarDto(PersonaDeporteDTO personaDeporteDTO) {
        personaDeporte.add(personaDeporteDTO);
    }
}
