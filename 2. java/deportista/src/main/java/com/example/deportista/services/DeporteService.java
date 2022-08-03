package com.example.deportista.services;



import com.example.deportista.dtos.DeporteDto;
import com.example.deportista.entities.Deporte;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
public class DeporteService {


    private List<DeporteDto> Ddeportes = List.of(new DeporteDto(new Deporte("Futbol", "Principiante")),
            new DeporteDto(new Deporte("Tenis", "Intermedio")),
            new DeporteDto(new Deporte("Voleyball", "Avanzado")));








}
