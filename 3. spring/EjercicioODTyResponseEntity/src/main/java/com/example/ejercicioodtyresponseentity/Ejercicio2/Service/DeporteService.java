package com.example.ejercicioodtyresponseentity.Ejercicio2.Service;

import com.example.ejercicioodtyresponseentity.Ejercicio2.DTO.PersonaDeporteDTO;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Persona;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.DeporteRepository;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.PersonaDeporteRepo;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeporteService {
    @Autowired
    DeporteRepository deporteRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    PersonaDeporteRepo personaDeporteRepo;
    int idDeporte;
    String nivelEncontrado;


    public Deporte addDeporte(String nombreDeporte,String nombreNivel) {
        idDeporte = idDeporte+1;
        Deporte deporte = new Deporte(idDeporte,nombreDeporte,nombreNivel);
        deporteRepository.agregarDeporte(deporte);
        return deporte;
    }
    public List<Deporte> showDeportes() {
        return deporteRepository.showDeportes();
    }

    public String showDeportesNameService(String nombreDeporteBuscado) {
        for(Deporte d:deporteRepository.showDeportes()){
            if(Objects.equals(d.getNombreDeporte(), nombreDeporteBuscado)){
                nivelEncontrado=d.getNivelDeporte();
            }
        }
        return nivelEncontrado;
    }





}
