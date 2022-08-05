package com.example.ejercicioodtyresponseentity.Ejercicio2.Service;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.DeporteRepository;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

public class DeporteService {
    private DeporteRepository deporteRepository;
    public List<Deporte> addDeporte(String nombreDeporte,String nivelDeporte) {
        return this.deporteRepository.agregarDeporte(nombreDeporte,nivelDeporte);
    }



}
