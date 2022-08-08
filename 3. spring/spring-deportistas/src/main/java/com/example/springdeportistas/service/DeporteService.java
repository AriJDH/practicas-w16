package com.example.springdeportistas.service;

import com.example.springdeportistas.dto.DeporteDto;
import com.example.springdeportistas.entity.Deporte;
import lombok.Data;

import java.util.List;

@Data
public class DeporteService {
    private List<DeporteDto> listaDeDeportes = List.of(
            new DeporteDto(new Deporte("futbol", "Principiante")),
            new DeporteDto(new Deporte("tenis", "Intermedio")),
            new DeporteDto(new Deporte("basketball", "Principiante")),
            new DeporteDto(new Deporte("handball", "Intermedio")),
            new DeporteDto(new Deporte("natacion", "Avanzado"))
    );

    public List<DeporteDto> getAll() {
        return this.listaDeDeportes;
    }
}
