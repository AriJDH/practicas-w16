package com.example.ejdeportistas.services;

import com.example.ejdeportistas.dtos.DeporteDto;
import com.example.ejdeportistas.entities.Deporte;
import lombok.Data;

import java.util.List;

@Data
public class DeporteService {

    private List<DeporteDto> deportes = List.of(
            new DeporteDto(new Deporte("Futbol", "Principiante")),
            new DeporteDto(new Deporte("Futbol", "Intermedio")),
            new DeporteDto(new Deporte("Futbol", "Avanzado"))
    );

    public List<DeporteDto> getAll() {
        return this.deportes;
    }
}
